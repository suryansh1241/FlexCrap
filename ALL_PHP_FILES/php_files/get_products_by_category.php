<?php
$conn = mysqli_connect("localhost", "root", "");
mysqli_select_db($conn, "e_com");

$catid = $_GET['catid']; 

$qry = "SELECT catid, pname, pdesc, price FROM tbl_product WHERE catid = '$catid'";
$raw = mysqli_query($conn, $qry);

$products = array();

while ($row = mysqli_fetch_assoc($raw)) {
    $products[] = $row;
}

echo json_encode($products);
?>