<?php
	$conn = mysql_connect("localhost", "root", "");
	$db = mysql_select_db("multimediadb", $conn);
	
	$email = $_GET['email'];
	$qry = "select * from r_user where Email_Id = '$email'";
	$result = mysql_query($qry);
	$row = mysql_fetch_array($result);
	$num = mysql_num_rows($result);
	echo $num;
	/*if( $num > 0)
	{
		$r = rand(10000, 99999);
		$b = mail( $email, "MM Streaming Application Password Recovery", "Here goes your activation code".$r , "From: Wajidali3042@yahoo.com");
		if($b)
		{
			mysql_query("update r_user set Activation_Code = '$r'");
			echo "success!";
		}
	}*/
	
?>