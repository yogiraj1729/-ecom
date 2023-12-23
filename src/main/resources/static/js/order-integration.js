var OrderIntegration = {

	addItemToCart: function(itemId) {
		var obj = {
			"itemId": itemId,
			"quantity": 1
		}


		$.ajax({
			url: "/order/addItemToCart",
			type: "POST",
			contentType: "application/json",
			data: JSON.stringify(obj),
			success: function(data) {
				console.log(data);
				alert("Item added Successfully !!")
			},
			error(e) {
				console.log(e);
			}
		});
	},

	getCartCount: function() {
		$.ajax({
			url: "/order/getItemsCount",
			type: "GET",
			success: function(data) {
				console.log(data);
				$('#lblCartCount').html(data.cartCount);
			},
			error(e) {
				console.log(e);
			}
		});
	}
}