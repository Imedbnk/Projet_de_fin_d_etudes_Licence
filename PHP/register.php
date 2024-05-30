<?php
if(isset($_POST['Username']) && isset($_POST['Email']) && isset($_POST['PhoneNumber']) && isset($_POST['UserPassword'])){
    
    require_once "conn.php";
    require_once "validate.php";
    
    $Username = validate($_POST['Username']);
    $Email = validate($_POST['Email']);
    $PhoneNumber= validate($_POST['PhoneNumber']);
    $UserPassword = validate($_POST['UserPassword']);
    
    $sql = "insert into inscription values('','$Username','$Email','$PhoneNumber', '$UserPassword')";
    
    if(!$conn->query($sql)){
        echo "failure";
    }else{
        echo "success";   
    }
}
?>