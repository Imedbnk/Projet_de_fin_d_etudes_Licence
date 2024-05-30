<?php

header('Content-Type: application/json');

$username = "root";
$password = "";
$options = [
    PDO::ATTR_ERRMODE => PDO::ERRMODE_EXCEPTION,
    PDO::ATTR_DEFAULT_FETCH_MODE => PDO::FETCH_ASSOC
];

$conn = new PDO("mysql:host=localhost;dbname=db_hor", $username, $password, $options);

$sql = $conn->prepare("SELECT * FROM chambres_hotel WHERE disponibilite = 1");
$sql->execute();
$results = $sql->fetchAll();

echo json_encode($results);
?>
