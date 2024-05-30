 <!DOCTYPE html>
<?php
	require_once 'validate.php';
	require 'name.php';
?>
<html lang = "en">
	<head>
		<title>Hotel Online Reservation</title>
		<meta charset = "utf-8" />
		<meta name = "viewport" content = "width=device-width, initial-scale=1.0" />
		<link rel = "stylesheet" type = "text/css" href = "bootstrap.css " />
		<link rel = "stylesheet" type = "text/css" href = "style.css" />
	</head>
<body>
	<nav style = "background-color:rgba(0, 0, 0, 0.1);" class = "navbar navbar-default">
		<div  class = "container-fluid">
			<div class = "navbar-header">
				<a class = "navbar-brand" >Hotel Online Reservation</a>
			</div>
			<ul class = "nav navbar-nav pull-right ">
				<li class = "dropdown">
					<a class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false"><i class = "glyphicon glyphicon-user"></i> <?php echo $name;?></a>
					<ul class="dropdown-menu">
						<li><a href="logout.php"><i class = "glyphicon glyphicon-off"></i> Logout</a></li>
					</ul>
				</li>
			</ul>
		</div>
	</nav>
	<div class = "container-fluid">	
		<ul class = "nav nav-pills">
			<li><a href = "home.php">Home</a></li>
			<li class = "active"><a href = "account.php">Accounts</a></li>
			<li><a href = "reserve.php">Reservation</a></li>
			<li><a href = "hotels.php">Hotels</a></li>			
		</ul>	
	</div>
	<br />
	<div class = "container-fluid">
		<div class = "panel panel-default">
			<div class = "panel-body">
				<div class = "alert alert-info">Hotels / Change Hotel</div>
				<?php
					$query = $conn->query("SELECT * FROM `hotels` WHERE `hotels_id` = '$_REQUEST[hotels_id]'") or die(mysqli_error());
					$fetch = $query->fetch_array();
				?>
				<br />
				<div class = "col-md-4">	
					<form method = "POST" action = "edit_query_hotels.php?hotels_id=<?php echo $fetch['hotels_id']?>">
					    <div class = "form-group">
							<label>Id </label>
							<input type = "text" class = "form-control" value = "<?php echo $fetch['hotels_id']?>" name = "hotels_id" />
						</div>
						<div class = "form-group">
							<label>Nom </label>
							<input type = "text" class = "form-control" value = "<?php echo $fetch['Nom']?>" name = "nom" />
						</div>
						<div class = "form-group">
							<label>Stars </label>
							<input type = "text" class = "form-control" value = "<?php echo $fetch['stars']?>" name = "stars" />
						</div>
						<div class = "form-group">
							<label>Price </label>
							<input type = "password" class = "form-control" value = "<?php echo $fetch['price']?>" name = "price" />
						</div>
						<div class = "form-group">
							<label>Adress </label>
							<input type = "text" class = "form-control" value = "<?php echo $fetch['adress']?>" name = "adress" />
						</div>
						<div class = "form-group">
							<label>Déscription </label>
							<input type = "text" class = "form-control" value = "<?php echo $fetch['déscription']?>" name = "déscription" />
						</div>
						<div class = "form-group">
							<label>Check In </label>
							<input type = "text" class = "form-control" value = "<?php echo $fetch['checkIn']?>" name = "check In" />
						</div>
						<div class = "form-group">
							<label>Lien </label>
							<input type = "text" class = "form-control" value = "<?php echo $fetch['lien']?>" name = "lien" />
						</div>
						<br />
						<div class = "form-group">
							<button name = "edit_account" class = "btn btn-warning form-control"><i class = "glyphicon glyphicon-edit"></i> Save Changes</button>
						</div>
					</form>
				</div>
			</div>
		</div>
	</div>
	<br />
	<br />
	<div style = "text-align:right; margin-right:10px;" class = "navbar navbar-default navbar-fixed-bottom">
		<label>&copy; imed bnk 2024 </label>
	</div>
</body>
<script src = "../js/jquery.js"></script>
<script src = "../js/bootstrap.js"></script>
</html>