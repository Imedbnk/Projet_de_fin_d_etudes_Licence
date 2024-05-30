<?php
	 require_once 'connect.php';
	 $conn->query("DELETE FROM `hotels` WHERE `hotels_id` = '$_REQUEST[hotels_id]'") or die(mysqli_error());
	 header("location: hotels.php");