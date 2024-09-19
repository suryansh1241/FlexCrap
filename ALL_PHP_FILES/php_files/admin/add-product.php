<?php
session_start();
include("header.php");
include("conn.php");
?>
<main>
    <div class="section-1">
        <div class="container text-center">
            <h1 class="heading-1">Add your Product here</h1>

            <!-- Add Category Page Data -->
            <div>
                <form name="frm" action="process-product.php" method="post" enctype="multipart/form-data">
                    <div class="col-md-8 mx-auto">
                        <div class="form-group">
                            <label for="exampleInputEmail1">Select Brand</label>
                            <select name="category" class="form-control">
                                <?php
                                $qry = "select * from tbl_category";
                                $raw = mysqli_query($conn, $qry);
                                while ($res = mysqli_fetch_array($raw)) {
                                ?>
                                    <option value="<?php echo $res['id']; ?>"><?php echo $res['catname']; ?></option>
                                <?php } ?>
                            </select>
                        </div>
                        <div class="form-group">
                            <label for="exampleInputEmail1">Product Name</label>
                            <input type="text" name="pname" class="form-control" id="exampleInputEmail1" placeholder="Enter Product Name">
                        </div>
                        <div class="form-group">
                            <label for="exampleInputPassword1">Product Thumbnail</label>
                            <input type="file" name="upload" class="form-control" id="exampleInputPassword1">
                        </div>
                        <div class="form-group">
                            <label for="exampleInputEmail1">Product Price</label>
                            <input type="text" name="price" class="form-control" id="exampleInputEmail1" placeholder="Enter Product Price">
                        </div>
                        <div class="form-check">
                            <label for="exampleInputPassword1">Short Description</label>
                            <textarea name="sdesc" rows="3" cols="30" class="form-control"></textarea>
                        </div>
                        <br />
                        <button type="submit" class="btn btn-primary">Submit</button>
                    </div>
                </form>

                <!-- Success message -->
                <?php if (isset($_SESSION['msg1'])) { ?>
                    <div class="alert alert-success" role="alert">
                        <?php
                        echo $_SESSION['msg1'];
                        unset($_SESSION['msg1']);
                        ?>
                    </div>
                <?php } ?>

                <!-- Error message -->
                <?php if (isset($_SESSION['msg2'])) { ?>
                    <div class="alert alert-danger" role="alert">
                        <?php
                        echo $_SESSION['msg2'];
                        unset($_SESSION['msg2']);
                        ?>
                    </div>
                <?php } ?>
            </div>
        </div>
    </div>
</main>
<?php
include("footer.php");
?>
