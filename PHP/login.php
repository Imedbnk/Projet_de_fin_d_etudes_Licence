<?php

if(isset($_POST['Username']) && isset($_POST['UserPassword'])){
    
    require_once "conn.php";
    require_once "validate.php";
    
    $Username = validate($_POST['Username']);
    $UserPassword = validate($_POST['UserPassword']);
    
    $sql = "select * from inscription where Username='$Username' and UserPassword='$UserPassword'";
    
    $result = $conn->query($sql);

    if($result->num_rows > 0){
        echo "success";
    } else{
        echo "failure";
    }
}
?>