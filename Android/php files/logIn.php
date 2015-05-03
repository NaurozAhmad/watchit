<?php
	$conn = mysql_connect("localhost", "root", "");
	$db = mysql_select_db("multimediadb", $conn);
	
	$username = $_GET['username'];
	$password = $_GET['password'];
	$result = mysql_query("SELECT * FROM r_user where 
	User_Name='$username' and Password='$password'");
	$row = mysql_fetch_array($result);
	
	if(mysql_num_rows($result) == 1)
	{
		echo $row["First_Name"]. " " .$row["Last_Name"];
	}
	else
	{
		echo "Log in Failed";
	}
?>