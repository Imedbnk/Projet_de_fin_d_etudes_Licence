<?php
	require_once 'connect.php';
	if(ISSET($_POST['edit_hotels'])){
		$id = $_POST['hotels_id'];
		$name = $_POST['nom'];
		$username = $_POST['stars'];
		$password = $_POST['price'];
		$name1 = $_POST['adress'];
		$username1 = $_POST['déscription'];
		$password1 = $_POST['checkIn'];
		$password2 = $_POST['lien'];
		$conn->mysql_query("UPDATE `hotels` SET `hotels_id` = '$id',`nom` = '$name', `stars` = '$username', `price` = '$password', 
		`adress` ='$name1', `déscription` = '$username1', `checkIn` = '$password1', `lien` = '$password2'
		WHERE `hotels_id` = '$_REQUEST[hotels_id]'") or die(mysqli_error());
		header("location:account.php");
	}	