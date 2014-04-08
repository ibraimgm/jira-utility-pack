// code taken (with minimal adaptations) from http://www.masswerk.at/elizabot/
var eliza = null;
var elizaLines = null;

var displayCols = 60;
var displayRows = 20;

function elizaReset() 
{
  eliza.reset();
  elizaLines.length = 0;
  elizaStep();
}

function elizaStep() 
{
  var userinput = jQuery("#e_input").val();
  if (eliza.quit) 
  {
    jQuery("#e_input").val('');
    if (confirm("This session is over.\nStart over?")) elizaReset();
    jQuery("#e_input").focus();
    return;
  }
  else if (userinput != '') 
  {
    var usr = 'YOU:   ' + userinput;
    var rpl ='ELIZA: ' + eliza.transform(userinput);
    elizaLines.push(usr);
    elizaLines.push(rpl);

    // display nicely
    // (fit to textarea with last line free - reserved for extra line caused by word wrap)
    var temp  = new Array();
    var l = 0;
    for (var i=elizaLines.length-1; i>=0; i--) 
    {
      l += 1 + Math.floor(elizaLines[i].length/displayCols);
      if (l >= displayRows) break
      else temp.push(elizaLines[i]);
    }
		
    elizaLines = temp.reverse();
    jQuery("#e_display").val(elizaLines.join('\n'));
  }
  else if (elizaLines.length == 0) 
  {
    // no input and no saved lines -> output initial
    var initial = 'ELIZA: ' + eliza.getInitial();
    elizaLines.push(initial);
    jQuery("#e_display").val(initial + '\n');
  }

  jQuery("#e_input").val('');
  jQuery("#e_input").focus();
}

function elizaInit()
{
  eliza = new ElizaBot();
  elizaLines = new Array();

  jQuery("#send").off();
  jQuery("#send").click(function () {
    elizaStep();
  });
  
  jQuery("#e_input").off();
  jQuery("#e_input").keyup(function(event)
  {
    if(event.keyCode == 13)
    {
      jQuery("#send").click();
    }
  });
  
  jQuery("#e_display").off();
  jQuery("#e_display").focus(function ()
  {
    jQuery("#e_input").focus();
  });  
  jQuery("#e_display").keyup(function(event)
  {
    jQuery("#e_input").focus();
  });
  
  elizaStep();
}
