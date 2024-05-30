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
				<a class = "navbar-brand" ></a>
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
			<li><a href = "account.php">Accounts</a></li>
			<li class = "active"><a href = "reserve.php">Reservation</a></li>
			<li><a href = "hotels.php">Hotels</a></li>			
		</ul>	
	</div>
	<br />
	<div class = "container-fluid">
		<div class = "panel panel-default">
			<div class = "panel-body">
				<div class = "alert alert-info">Table Reservation</div>
				<br />
				<br />
				<table id = "table" class = "table table-bordered">
					<thead>
						<tr>
							<th>Id</th>
							<th>Nom</th>
							<th>Email</th>
							<th>Numéro de Tél</th>
							<th>Date Arriver</th>
							<th>Date Depart</th>
							<th>Prix</th>
							<th>Nom Hotel</th>
							<th>Persons</th>
							<th>Type</th>
							<th>Action</th>
						</tr>
					</thead>
					<tbody>
						<?php  
							$query = $conn->query("SELECT * FROM `reservations`") or die(mysqli_error());
							while($fetch = $query->fetch_array()){
						?>
						<tr>
						    <td><?php echo $fetch['reserv_id']?></td>
							<td><?php echo $fetch['Nom']?></td>
							<td><?php echo $fetch['email']?></td>
							<td><?php echo $fetch['NumTel']?></td>
							<td><?php echo $fetch['DateArriver']?></td>
							<td><?php echo $fetch['DateDepart']?></td>
							<td><?php echo $fetch['Prix']?></td>
							<td><?php echo $fetch['NomHotel']?></td>
							<td><?php echo $fetch['Persons']?></td>
							<td><?php echo $fetch['Type']?></td>
							<td><center><a class = "btn btn-danger" onclick = "confirmationDelete(this); return false;" href = "delete_reserve.php?reserv_id=<?php echo $fetch['reserv_id']?>"><i class = "glyphicon glyphicon-remove"></i> Delete</a></center></td>
						</tr>
						<?php
							}
						?>
					</tbody>
				</table>
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
<script src = "../js/jquery.dataTables.js"></script>
<script src = "../js/dataTables.bootstrap.js"></script>	
<script type = "text/javascript">
	function confirmationDelete(anchor){
		var conf = confirm("Are you sure you want to delete this record?");
		if(conf){
			window.location = anchor.attr("href");
		}
	} 
</script>

<script type = "text/javascript">
	$(document).ready(function(){
		$("#table").DataTable();
	});
</script>
</html>