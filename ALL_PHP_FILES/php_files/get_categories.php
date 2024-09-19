<?php
header("Content-Type: application/json");

// Database connection
$conn = mysqli_connect("localhost", "root", "", "e_com");

if (!$conn) {
    die("Connection failed: " . mysqli_connect_error());
}

// SQL query to fetch categories
$query = "SELECT id, catname, sdesc FROM tbl_category";
$result = mysqli_query($conn, $query);

$categories = array();

// Fetching data and adding to array
while ($row = mysqli_fetch_assoc($result)) {
    $categories[] = $row;
}

// Closing the connection
mysqli_close($conn);

// Outputting JSON
echo json_encode($categories);
?>
