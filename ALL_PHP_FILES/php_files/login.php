<?php

$conn=mysqli_connect("localhost","root","");
mysqli_select_db($conn,"e_com");

$email=trim($_POST['email']);
$password=trim($_POST['password']);

$qry="select * from tbl_user where email='$email' and password='$password'";
$raw=mysqli_query($conn,$qry);

$count=mysqli_num_rows($raw);

if($count>0) {
    $response['message']='exist';
}
else {
    $response['message']="not_exist";
}
echo json_encode($response);

?>