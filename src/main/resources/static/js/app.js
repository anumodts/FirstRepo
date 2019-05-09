function validate() {
	var name = document.getElementById("name").value;
	var password = document.getElementById("password").value;
	console.log(name);
	if (name == '') {
		alert('Please enter the name.');
		return false;
	} else if (password == '') {
		alert('Password cannot be empty.');
		return false;

	} else {
		return true;
	}
}