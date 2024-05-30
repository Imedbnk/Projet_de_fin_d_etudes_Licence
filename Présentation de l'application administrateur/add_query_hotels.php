<?php
	if(ISSET($_POST['add_hotels'])){
		$id = $_POST['hotels_id'];
		$name = $_POST['Nom'];
		$username = $_POST['stars'];
		$password = $_POST['price'];
		$name1 = $_POST['adress'];
		$username1 = $_POST['déscription'];
		$password1 = $_POST['checkIn'];
		$password2 = $_POST['lien'];

		$query = $conn->query("SELECT * FROM `hotels`") or die(mysqli_error());
		$valid = $conn->num_rows;
		if($valid > 0){
			echo "<center><label style = 'color:red;'>Nom already taken</center></label>";
		}else{
			$conn->query("INSERT INTO `hotels` (hotels_id, Nom, stars, price,adress,déscription,checkIn,lien) VALUES('$id', '$name', '$username', '$password', '$name1', '$username1', '$password1', '$password2' )") or die(mysqli_error());
			header("location:hotels.php");
		}
	}
?>