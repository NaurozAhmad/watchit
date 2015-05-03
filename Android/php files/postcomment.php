<?php
	$conn = mysql_connect("localhost", "root", "");
	$db = mysql_select_db("multimediadb", $conn);
	
	$username = $_GET['username'];
	$content_id = $_GET['content_id'];
	$comment = $_GET['comment'];
        
	
	$qry = "INSERT INTO `multimediadb`.`comment` (`Comm_Id`, `Comment`, `Content_Id`, `User_Id`) VALUES (NULL, '$comment', '$content_id', '$username');";
			
		if(mysql_query($qry))
		{
			echo "Successfully posted your comment!";
		}
?>