<?php

session_start();
include("conn.php");

    $cname=$_POST['cname'];
    $sdesc=$_POST['sdesc'];

    if($_FILES['upload']) {
        $sn=$_FILES['upload']['tmp_name'];  // mydocument/mypicture/hello.jpg
        $on=$_FILES['upload']['name'];  // hello.jpg
        $dn="images/".$on;
        move_uploaded_file($sn,$dn);

        $qry="INSERT INTO `tbl_category` (`id`, `catname`, `image`, `sdesc`, `status`) VALUES (NULL, '$cname', '$on', '$sdesc', '1')";

        $res=mysqli_query($conn,$qry);

        if($res==true)
            $_SESSION['msg1']="Inserted Successfully";
        else 
            $_SESSION['msg2']="Something Went Wrong";

        header("location:add-category.php");
    }

?>