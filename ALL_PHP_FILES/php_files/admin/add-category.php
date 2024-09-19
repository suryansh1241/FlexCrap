<?php
session_start();
include("header.php");
?>
<main>
    <div class="section-1">
    <div class="container text-center">
    <h1 class="heading-1">Add your Brand here</h1>

   <!-- Add Category Page Data -->
<div>

<form name="frm" action="process-category.php" method="post" enctype="multipart/form-data">
    <div class="col-md-8 mx-auto">
    <form>
  <div class="form-group">
    <label for="exampleInputEmail1">Brand Name</label>
    <input type="text" name="cname" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" placeholder="Enter Brand">
  </div>
  <div class="form-group">
    <label for="exampleInputPassword1">Brand Thumbnail</label>
    <input type="file" name="upload" class="form-control" id="exampleInputPassword1" placeholder="Password">
  </div>
  <div class="form-check">
    <label for="exampleInputPassword1">Short Description</label>
    <textarea name="sdesc" rows="3" cols="30" class="form-control"></textarea>
  </div>
  <br/>
  <button type="submit" class="btn btn-primary">Submit</button>
</form>


<?php
  if(isset($_SESSION['msg1'])) {
?>

<div class="alert alert-success" role="alert">
  <?php 
  echo $_SESSION['msg1'];
  unset($_SESSION['msg1']) ;  
  ?>
</div>
<?php }  ?>

<?php
  if(isset($_SESSION['msg2'])) {
?>
<div class="alert alert-danger" role="alert">
  <?php 
  echo $_SESSION['msg2'];
  unset($_SESSION['msg2']) ; 
  ?>
</div> 
<?php  } ?>

    </div>
</div>
   <!-- End of main section -->

</div>
</div>
</main>
<?php
include("footer.php");
?>
