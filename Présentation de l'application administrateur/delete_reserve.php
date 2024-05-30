<?php
	 require_once 'connect.php';
	 $conn->query("DELETE FROM `reservations` WHERE `reserv_id` = '$_REQUEST[reserv_id]'") or die(mysqli_error());
	 header("location: reserve.php");