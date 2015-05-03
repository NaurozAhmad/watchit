<?php
	$conn = mysql_connect("localhost", "root", "");
	$db = mysql_select_db("multimediadb", $conn);
	
	$id = $_GET['content_id'];
	$q = mysql_query("SELECT c.Comment as comment, u.User_Name as Uname FROM `comment` c inner join `r_user` u on ( c.User_Id = u.User_Id) Where c.Content_Id = $id");
	$something["data"] = array();
	while($arr = mysql_fetch_array($q))
	{
		$temp = array();
		
		$temp["comment"] = $arr['comment'];
		$temp["Uname"] = $arr["Uname"];
		array_push($something["data"], $temp);
		
	}
	
	echo json_encode($something);
?>