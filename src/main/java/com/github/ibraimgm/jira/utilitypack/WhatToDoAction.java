/*
 *  Copyright 2012 3L TECNOLOGIA
 *
 *  Licensed to the Apache Software Foundation (ASF) under one or more
 *  contributor license agreements.  See the NOTICE file distributed with
 *  this work for additional information regarding copyright ownership.
 *  The ASF licenses this file to You under the Apache License, Version 2.0
 *  (the "License"); you may not use this file except in compliance with
 *  the License.  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 *
 */
/*
 *  Copyright 2013 3L TECNOLOGIA
 *
 *  Licensed to the Apache Software Foundation (ASF) under one or more
 *  contributor license agreements.  See the NOTICE file distributed with
 *  this work for additional information regarding copyright ownership.
 *  The ASF licenses this file to You under the Apache License, Version 2.0
 *  (the "License"); you may not use this file except in compliance with
 *  the License.  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 *
 */
package com.github.ibraimgm.jira.utilitypack;

import com.atlassian.jira.issue.CustomFieldManager;
import com.atlassian.jira.issue.IssueManager;
import com.atlassian.jira.issue.MutableIssue;
import com.atlassian.jira.issue.fields.CustomField;
import com.atlassian.jira.web.action.JiraWebActionSupport;

/**
 * @author rafael.garcia
 * @since 07/04/2014 12:08:25
 *
 */
public class WhatToDoAction extends JiraWebActionSupport
{
  private final IssueManager issueManager;
  private final CustomFieldManager customFieldManager;
  private String whatToDoMessage; // for velocity
  private long issueId; // for velocity

  public WhatToDoAction(IssueManager issueManager,
                        CustomFieldManager customFieldManager)
  {
    this.issueManager = issueManager;
    this.customFieldManager = customFieldManager;
  }

  /*
   * (non-Javadoc)
   *
   * @see webwork.action.ActionSupport#doDefault()
   */
  @Override
  public String doDefault() throws Exception
  {
    // get the issue sent as parameter
    MutableIssue issue = issueManager.getIssueObject(issueId);

    if (issue == null)
    {
      whatToDoMessage = "Dude... you don't even have a valid issue, do you? Get back to work!";
      return INPUT;
    }

    // retrieve our 'Alignment' custom field.
    // This is not guaranted to be unique, but we don't care for this example
    CustomField customField = customFieldManager.getCustomFieldObjectByName("Alignment");
    String alignmentValue = (customField == null) ? null
                                                 : issue.getCustomFieldValue(customField)
                                                        .toString();

    if ((alignmentValue == null) || (alignmentValue.isEmpty()))
    {
      whatToDoMessage = "Since the issue doesn't have an alignment.."
                        + "I guess you will have to take your chance on this one.";
      return INPUT;
    }

    // messages depending on the issue alignment
    if (alignmentValue.equals("LG"))
      whatToDoMessage = "It's a strict issue, but nice nonetheless.";
    else if (alignmentValue.equals("LN"))
      whatToDoMessage = "This issue must follow the procedure.";
    else if (alignmentValue.equals("LE"))
      whatToDoMessage = "This is a hateful issue, but at least it follows a well-defined protocol.";
    else if (alignmentValue.equals("NG"))
      whatToDoMessage = "Looks like a nice, but colorless, issue.";
    else if (alignmentValue.equals("NN"))
      whatToDoMessage = "This is a very bland issue. Nothing special here.";
    else if (alignmentValue.equals("NE"))
      whatToDoMessage = "This issue may look shady, but it's not really memorable.";
    else if (alignmentValue.equals("CG"))
      whatToDoMessage = "This is a good issue, but extremely disorganized.";
    else if (alignmentValue.equals("CN"))
      whatToDoMessage = "A very chaotic and disjointed issue. Not that horrible, but still a pain.";
    else if (alignmentValue.equals("CE"))
      whatToDoMessage = "This issue is both mean and disorganized. Try to assign it to your enemies.";

    return INPUT;
  }

  public String getWhatToDoMessage()
  {
    return whatToDoMessage;
  }

  /**
   * @return the issueId
   */
  public long getIssueId()
  {
    return issueId;
  }

  /**
   * @param issueId
   *          the issueId to set
   */
  public void setIssueId(long issueId)
  {
    this.issueId = issueId;
  }

}
