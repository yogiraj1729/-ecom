var productDetails = {
	getProductCard: function(imagePath, itemPrice, itemName, itemId) {
		var test = " <div class='card-block'>"
			+ "            <div class='product-card'>"
			+ "                <img src='" + imagePath + "' class='img-size' alt='Cinque Terre'>"
			+ "            </div>"
			+ "            <div class='info-sec'>"
			+ "                <h3>" + itemName + "</h3>"
			+ "                <div class='buy'>"
			+ "                    <p class='price-sec'>Price : " + itemPrice + "$</p>"
			+ "                    <a  class='buy-url' id ='" + itemId + "'>Add to cart</a>"
			+ "                </div>"
			+ "            </div>"
			+ "        </div>"

		return test;
	},

	renderGallery: function(arr) {
		var html = "";
		for (var i = 0; i < arr.length; i++) {
			html = html + productDetails.getProductCard('/images/download.jpeg', arr[i].itemPrice, arr[i].itemName, arr[i].itemId);
		}
		$("#product-listing").append(html);
	}
}

$(document).ready(function() {
	$.ajax({
		url: "/product/getAllProduct",
		type: "GET",
		success: function(data) {
			console.log(data);
			productDetails.renderGallery(data.data);
		},
		error(e) {
			console.log(e);
		}
	});
});

$("div .card-block").hover(function() {
	$(this).css("background-color", "yellow");
}, function() {
	$(this).css("background-color", "white");
});


$(document).on("click", ".buy-url", function(e) {
	console.log(e.target.id);
	var itemId = e.target.id;
	OrderIntegration.addItemToCart(itemId);
});

$(document).on("click", "#lblCartCount", function(e) {
	OrderIntegration.getCartCount();
});


