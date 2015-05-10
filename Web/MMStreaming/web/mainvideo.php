<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>

 <script type="text/javascript" src="jquery-1.8.0.min.js"></script>
<script type="text/javascript" src="script.js"></script>

<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />
<title>video page</title>
 <link href="web.css" rel=stylesheet type="text/css"/>
<?php
include("include/connection.php");
include("include/script.php");
$strSQL_Result  = mysqli_query($conn,"select `like`,`un-like` from `like_tb` where video_id=3");
$row            = mysqli_fetch_array($strSQL_Result);

$like       = $row['like'];
$unlike     = $row['un-like'];
if($_POST)
{
   if(isset($_COOKIE["counter_jad"]))
    {
        echo "-1";
        exit;
    }
    setcookie("counter_jad", "liked", time()+3600*24,"/");
    
	if(mysqli_real_escape_string($conn,$_POST['op']) == 'like')
    {
        $update = "`like`=`like`+1";
    }
    if(mysqli_real_escape_string($conn,$_POST['op']) == 'un-like')
    {
        $update = "`un-like`=`un-like`+1";
    }
    mysqli_query($conn,"update `like_tb` set $update where `video_id`=3");
    echo 1;
    exit;   
}
//comment query//
$comment=$_POST['comment'];
$commetquery="INSERT INTO `Comment`('Comment_Id','Comment','Content_Id','User_Name') VALUES ('','$comment','33','jan')";
$sucess=mysqli_query($conn,$commetquery);
if(mysql_affected_rows()>0){
	echo "1";
	}
else{
	echo "2";
	}
?>

</head>

<body>
<div id="container">

    <div id="header">
	     <?php
         include("include/header.php");
		 ?>
		 </div>
	</div>
	    <div id="left-cor">
			  <?php
              include("include/leftBanner.php");
			  ?>
		</div>
	     <div id="main">
	           <video controls id="video">
               <source src="video.mp4" type="video/mp4">
               </video>	
		  <div class="grid">
            <span id="status"></span><br>
            <input type="button" value="<?php echo $like; ?>" class="button_like" id="linkeBtn" />
            <input type="button" value="<?php echo $unlike; ?>" class="button_unlike" id="unlinkeBtn" />
            </div>	   
			   <div id="desc">
			<h3>Description</h3>
			</div>
			<div id="comments">
			   <h3>Comments</h3>
			   <form id="comm-form">
			   <div id="dp"><img src="images/no-profile.png" height="25px" width="25px;" /></div>
			   <textarea id="in-comm" type="text" placeholder="Write Your Comment Here" rows="4" cols="50"/>
			            </textarea>
			   <input type="button" id="commit-btn" value="Comment" />
			   </form>
               <span id="response"></span>
               
			</div>    
	     </div>
		 <div id="rel-video">&nbsp;Related Videos
		     <div >
			     <ul>
		          <li><video class="rel-vid">
				      <source src="video.mp4" type="video/mp4">
				  </video></li>
				  <li><video class="rel-vid" >
      				  <source src="video.mp4" type="video/mp4">
				  </video></li>
				  <li><video class="rel-vid" >
				      <source src="video.mp4" type="video/mp4"> 
				  </video></li>
				  <li><video class="rel-vid">
				      <source src="video.mp4" type="video/mp4">
				  </video></li>
				  </ul>
		     </div>
		 </div>
    <div id="footer">
	      <div id="links"> Stay Connected &nbsp;
		    <a href="https://www.facebook.com/?_rdr"> <img id="fb" src="images/facebook.png"  /> </a>
		   <a href="https://accounts.google.com/ServiceLogin?service=oz&passive=1209600&continue=https://plus.google.com/?gpsrc%3Dgplp0"> 
		            <img id="g-plus" src="images/GooglePlus.png" /> </a>
		   <a href="https://twitter.com/?lang=en">  <img id="twitr" src="images/twitter.png" /> </a>
		  	</div>
          </div>
</div>


</body>
</html>
