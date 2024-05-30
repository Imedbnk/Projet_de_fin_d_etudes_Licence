<?php

$username = "root";
$password = "";
$database = $conn = new PDO("mysql:host=localhost; dbname=db_hor; ", $username, $password);

$sql = $database->prepare("SELECT * FROM chambres_hotel");
$sql ->execute();

foreach($sql AS $result){

    if($result['disponibilite']== 1){
        echo $result['type_de_lit'] . "</br>";
        echo $result['nbr_personne'] . "</br>";
        echo $result['chambre_lit'] . "</br>";
        echo $result['Prix'] . "</br>";
    }
}

?>
