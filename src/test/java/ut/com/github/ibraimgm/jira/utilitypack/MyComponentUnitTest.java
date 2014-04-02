package ut.com.github.ibraimgm.jira.utilitypack;

import org.junit.Test;
import com.github.ibraimgm.jira.utilitypack.MyPluginComponent;
import com.github.ibraimgm.jira.utilitypack.MyPluginComponentImpl;

import static org.junit.Assert.assertEquals;

public class MyComponentUnitTest
{
    @Test
    public void testMyName()
    {
        MyPluginComponent component = new MyPluginComponentImpl(null);
        assertEquals("names do not match!", "myComponent",component.getName());
    }
}