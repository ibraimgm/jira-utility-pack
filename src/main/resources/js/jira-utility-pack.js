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