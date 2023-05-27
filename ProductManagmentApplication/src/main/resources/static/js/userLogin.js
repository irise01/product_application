
function userSignIn() {
	var userName = $('#userNameId').val();
	var password = $('#userPassId').val();

	var settings = {
		"url": "/user/signIn?userName="+userName+"&password="+password,
		"method": "GET",
		"timeout": 0,
	};

	$.ajax(settings).done(function(response) {
		
		if(response.status==true){
			alert(response.message)
			window.location="/productDashboard.html"
		}else{
			alert(response.message)
			window.location="/userregister.html"
		}
	});
}