<?php

session_start();
include("conn.php");

    $catid=$_POST['category'];
    $pname=$_POST['pname'];
    $price=$_POST['price'];
    $sdesc=$_POST['sdesc'];

    if($_FILES['upload']) {
        $sn=$_FILES['upload']['tmp_name'];  // mydocument/mypicture/hello.jpg
        $on=$_FILES['upload']['name'];  // hello.jpg
        $dn="images/".$on;
        move_uploaded_file($sn,$dn);

        $qry="INSERT INTO `tbl_product` (`id`, `catid`, `pname`, `pimage`, `pdesc`, `price`, `status`) VALUES (NULL, '$catid', '$pname', '$on', '$sdesc', '$price', '1') ";

        $res=mysqli_query($conn,$qry);

        if($res==true)
            $_SESSION['msg1']="Inserted Successfully";
        else 
            $_SESSION['msg2']="Something Went Wrong";

        header("location:add-product.php");
    }

?>