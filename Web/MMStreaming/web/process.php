<?
include("include/connection.php");
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