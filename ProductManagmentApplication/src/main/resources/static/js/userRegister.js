function saveUser() {

	var fullName = $('#fnameId').val();
	var userAddress = $('#uaddressId').val();
	var userphoneNo = $('#uphoneId').val();
	var email = $('#uemailId').val();
	var userName = $('#unameId').val();
	var password = $('#passId').val();

	var settings = {
		"url": "/user/signUp",
		"method": "POST",
		"timeout": 0,
		"headers": {
			"Content-Type": "application/json"
		},
		"data": JSON.stringify({
			"fullName": fullName,
			"address": userAddress,
			"phoneNo":userphoneNo,
			"email": email,
			"userName": userName,
			"password": password
		}),
	};

	$.ajax(settings).done(function(response) {
		console.log(response);
		
		if(response.status==true){
			
			window.location="/userLogin.html"
		}else{
			window.location="/userregister.html"
		}
	});



}