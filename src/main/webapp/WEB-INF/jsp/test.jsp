<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>product-listing</title>
<link rel="stylesheet" href="/css/product-listing.css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">

<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
<script src="/js/product-listing.js"></script>
<script src="/js/order-integration.js"></script>
</head>
<body>
	<div class="container">
		<div class="cart-icon">
            <i class="fa" style="font-size:24px">&#xf07a;</i>
            <span class='badge badge-warning' id='lblCartCount'> 5 </span>
        </div>

		<div class="mens-heading">
			<h2>Mens Trainer's & Shoes</h2>
		</div>

		<div id='product-listing'>
			<div class="card-block">
				<div class="product-card">
					<img src="/images/download.jpeg" class="img-size"
						alt="Cinque Terre">
				</div>
				<div class="info-sec">
					<h3>Table Dog</h3>
					<div class="buy">
						<p class="price-sec">Price : 1200$</p>
						<a href="https://www.w3schools.com" class="buy-url">Add to
							cart</a>
					</div>
				</div>
			</div>
		</div>
	</div>

</body>
</html>