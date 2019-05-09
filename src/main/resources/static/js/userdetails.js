function checkUser() {
  var xhttp = new XMLHttpRequest();
  
  xhttp.onreadystatechange = function() {
    if (this.readyState == 4 && this.status == 200) {
    	var username=document.getElementById("username");

    	return false;
     
    }
  };
  xhttp.open("POST", "checkuser", true);
  xhttp.send();
}