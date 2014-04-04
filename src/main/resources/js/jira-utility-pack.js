function updateDnDAlignmentField(field_id)
{
  jQuery(function ($) {    
    $('#' + field_id).val($('#lvc_' + field_id).val() + $('#gve_' + field_id).val());
  });
};

function enableDnDAlignmentField(field_id, lvc, gve)
{  
  jQuery(function ($) {
    // shutdown previously defined events
    $('#lvc_' + field_id).off();
    $('#gve_' + field_id).off();
  
    // set the values
    if ((lvc == null) || (lvc == "") || (gve == null) || (gve == ""))
    {
      updateDnDAlignmentField(field_id);
    }
    else
    {  
      // fix start values
      $('select[id=lvc_' + field_id + ']').val(lvc);
      $('select[id=gve_' + field_id + ']').val(gve);
    };
    
    // add code for change event
    $('#lvc_' + field_id).change(function ()
    {
      updateDnDAlignmentField(field_id);
    });
    
    $('#gve_' + field_id).change(function ()
    {
      updateDnDAlignmentField(field_id);
    });
  });
};

function fetchQuoteOfTheIssue()
{
  jQuery(function ($) {        
    $.ajax({
      // using yql to bypass cross-domain issues
      url: "http://query.yahooapis.com/v1/public/yql",

      // the name of the callback parameter, as specified by the YQL service
      jsonp: "callback",

      // tell jQuery we're expecting JSONP
      dataType: "jsonp",

      // tell YQL what we want and that we want JSON
      data: {
          q: "select * from json where url=\"http://www.iheartquotes.com/api/v1/random?format=json&source=humorix_misc+prog_style+riddles\"",
          format: "json"
      },

      // work with the response
      success: function( response ) {
          obj = response.query.results.json;
          console.log( obj ); // server response
          $("#quote-loader").addClass("invisible");
          $("#quote").text(obj.quote);
          $("#quote-link").text("(view quote source)");
          $("#quote-link").attr("href",obj.link);                    
      }
    });    
  });
}