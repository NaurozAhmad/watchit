<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
       <meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />
       <title>MMStreaming</title>
  
<?php
session_start();
include_once("include/script.php");
include("include/connection.php");
if(isset ($_POST['signup'])){
	$username= $_POST['username'];
	$fname= $_POST['fname'];
	$lname= $_POST['lname'];
	$email= $_POST['email'];
	$pass= $_POST['pass'];
	$repass= $_POST['repass'];
	

	if(empty($fname)||empty($fname)||empty($lname)||empty($email)||empty($pass)||empty($repass)){
		
		echo "blank field";

	}
	elseif($pass!=$repass){
		echo "password didn,t match try again";
		
		}
		else
		{
			$query = "insert into `r_user` values('$username','$fname','$lname','$email','$pass','') ";
			mysql_query("$query");
			echo "data sucssesfully inserted";
			
			}
	
	}
?>
	   
	  <!--<script type="text/javascript">

/* function popup(){
  cuteLittleWindow = window.open("signup form.html", "littleWindow", "location=no,width=320,height=200"); 
}*/

</script> -->

</head>

<body>

<div id="container">
<?php
include_once("include/header.php");
if(isset($_POST['Login']))
	{
            $email=$_POST['email'];
			$pass=$_POST['password'];
			$q1="SELECT * FROM `r_user` WHERE `Email_id`='$email' AND `Password`='$pass'";
			$ex=mysqli_query($conn,$q1);
			$count=mysqli_num_rows($ex);
		if($count==1)
		{
				$row=mysqli_fetch_assoc($ex);
				$_SESSION['email']=$row['email_id'];
				
				header("location:mainvideo.php?welcome");
				
		}
			else
			 {
				header("location:index.php?invalid");
				$msg="invalid id or password";
				
				}
				
				
	}
?>

</div>
	<div id="left-cor">
	        <?php
            include_once("include/leftBanner.php");
			?>
	</div>
	
	<div id="rated">
	          <div id="rated-h">Most Rated Videos</div>
	              <div class="v1">
				  <video class="rel-vid">
				      <source src="video.mp4" type="video/mp4">
				  </video>
				  <video class="rel-vid">
				      <source src="video.mp4" type="video/mp4">
				  </video>
				  <video class="rel-vid">
				      <source src="video.mp4" type="video/mp4">
				  </video>
				  <video class="rel-vid">
				      <source src="video.mp4" type="video/mp4">
				  </video>
				     </div>
	 </div>
		 
	<div id="latest">
	          <div id="latest-h">Latest Videos</div>
			      <div class="v1">
	              <video class="rel-vid">
				      <source src="video.mp4" type="video/mp4">
				  </video>
				   <video class="rel-vid">
				      <source src="video.mp4" type="video/mp4">
				  </video>
				   <video class="rel-vid">
				      <source src="video.mp4" type="video/mp4">
				  </video>
				   <video class="rel-vid">
				      <source src="video.mp4" type="video/mp4">
				  </video>
			            </div>
			      <div class="v1">
	              <video class="rel-vid">
				      <source src="video.mp4" type="video/mp4">
				  </video>
				   <video class="rel-vid">
				      <source src="video.mp4" type="video/mp4">
				  </video>
				   <video class="rel-vid">
				      <source src="video.mp4" type="video/mp4">
				  </video>
				   <video class="rel-vid">
				      <source src="video.mp4" type="video/mp4">
				  </video>
			            </div>
						<div class="v1">
	              <video class="rel-vid">
				      <source src="video.mp4" type="video/mp4">
				  </video>
				   <video class="rel-vid">
				      <source src="video.mp4" type="video/mp4">
				  </video>
				   <video class="rel-vid">
				      <source src="video.mp4" type="video/mp4">
				  </video>
				   <video class="rel-vid">
				      <source src="video.mp4" type="video/mp4">
				  </video>
			            </div>			
		  </div>
		  
    <div id="footer"></div>

</div>

<div id="signup" style="display:none;">
<form>
<ul>
<li><input type="text" placeholder="FirstName" name="firstname" required="required"/></li>
</ul>
</form>
</div>


</body>
</html>
