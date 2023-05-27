
$(document).ready(function() {
	findAllProduct();
	findProductByid();

});

function addNewProduct() {

	var pname = $('#pnameId').val();
	var pqty = $('#pqtyId').val();
	var price = $('#ppriceId').val();

	var settings = {
		"url": "/product/addProduct",
		"method": "POST",
		"timeout": 0,
		"headers": {
			"Content-Type": "application/json"
		},
		"data": JSON.stringify({
			"pname": pname,
			"pqty": pqty,
			"price": price
		}),
	};

	$.ajax(settings).done(function(response) {
		if (response.status == true) {
			alert(response.message);
			window.location = "productdashboard.html"
		} else {
			alert(response.message);
			window.location = "addproduct.html";
		}
	});

}

function findAllProduct() {

	var settings = {
		"url": "/product/getALLProduct",
		"method": "GET",
		"timeout": 0,
	};

	$.ajax(settings).done(function(response) {

		response.forEach(function(obj, index) {
			$('#producttbodyId').append('<tr><td>' + obj.pid + '</td><td>' + obj.pname + '</td><td>' + obj.pqty + '</td><td>' + obj.price + '</td>'

				+ '<td><button onclick="edit(' + obj.pid + ')">Edit</button> <button onclick="deleteProduct(' + obj.pid + ')">Delete</button></td></tr>')


		});
	});
}


function deleteProduct(pid) {

	var settings = {
		"url": "/product/deleteById?pid=" + pid,
		"method": "DELETE",
		"timeout": 0,
	};

	$.ajax(settings).done(function(response) {
		if (response.status == true) {
			alert(response.message)
			window.location = "productDashboard.html"
		} else {
			alert(response.message)
			window.location = "productDashboard.html"
		}
	});

}

function edit(pid) {
	window.location = "/updateProduct.html?pid=" + pid;
}

function findProductByid() {

	var urls = window.location.href;
	var splittedurl = urls.split('=');
	var pid = splittedurl[1];

	var settings = {
		"url": "/product/findById/" + pid,
		"method": "GET",
		"timeout": 0,
	};

	$.ajax(settings).done(function(response) {

		if (response != null) {

			$('#pId').val(response.pid);
			$('#pnameId').val(response.pname);
			$('#pqtyId').val(response.pqty);
			$('#ppriceId').val(response.price);

		} else {
			window.location = "/productDashboard.html"
		}
	});

}

function updateProductById() {

		// updated values
		
		//var pid = 	$('#pId').val();
		var pid = 401;
		var pname = $('#pnameId').val();
		var pqty = 	$('#pqtyId').val();
		var price =	$('#ppriceId').val();

	var settings = {
		"url": "/product/updateProductByid?pid="+pid,
		"method": "POST",
		"timeout": 0,
		"headers": {
			"Content-Type": "application/json"
		},
		"data": JSON.stringify({
			"pname": pname,
			"pqty":pqty,
			"price": price
		}),
	};

	$.ajax(settings).done(function(response) {
		if(response != null){
			alert(response.message);
			window.location = "/productDashboard.html"
		}else{
			alert(response.message);
			window.location = "/productDashboard.html"
		}
	});
	

}
