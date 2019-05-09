$(document).ready(function () {

    $("#username").focusout(function (event) {

        //stop submit the form, we will post it manually.
        event.preventDefault();

        fire_ajax_submit();

    });

});

function fire_ajax_submit() {

    var search = {}
    search["username"] = $("#username").val();

    $("registerbtn").prop("disabled", true);

    $.ajax({
        type: "POST",
        contentType: "application/json",
        url: "/checkuser",
        data: JSON.stringify(search),
        dataType: 'json',
        cache: false,
        timeout: 600000,
        success: function (data) {

            var json = "<h4>Ajax Response</h4><pre>"
                + JSON.stringify(data, null, 4) + "</pre>";
            $('#feedback').html("User name already exits. Please choose a different user name.");

            console.log("SUCCESS : ", data);
            var response= JSON.stringify(data);
            console.log(response);
            if(response=="true"){
            	$("#registerbtn").prop("disabled", true);
            	$("#password").prop("disabled", true);
            	$("#firstname").prop("disabled", true);
            	$("#lastname").prop("disabled", true);
            	$("#phone").prop("disabled", true);
            	$("#emailid").prop("disabled", true);
            	return false;
            }else{
            	$('#feedback').html("");
            	$("#registerbtn").prop("disabled", false);
            	$("#password").prop("disabled", false);
            	$("#firstname").prop("disabled", false);
            	$("#lastname").prop("disabled", false);
            	$("#phone").prop("disabled", false);
            	$("#emailid").prop("disabled", false);
            	return true
            }
            

        },
        error: function (e) {

            var json = "<h4>Ajax Response</h4><pre>"
                + e.responseText + "</pre>";
            $('#feedback').html(json);

            console.log("ERROR : ", e);
            $("#btn-search").prop("disabled", false);

        }
    });

}