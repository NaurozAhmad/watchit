<?php 
	
	$conn = mysql_connect("localhost", "root", "");
	$db = mysql_select_db("multimediadb", $conn);
	
	$q = mysql_query("select * from mm_content");
	$something["data"] = array();
	while($arr = mysql_fetch_array($q))
	{
		$temp = array();
		
		$temp["id"] = $arr['Content_Id'];
		$temp["path"] = $arr["Path"];
		$temp["title"] = $arr["Title"];
		$temp["desc"] = $arr["Description"];
		array_push($something["data"], $temp);
		
	}
	
	echo json_encode($something);


?>