<?php
	$conn = mysql_connect("localhost", "root", "");
	$db = mysql_select_db("multimediadb", $conn);
	
	$username = $_POST['username'];
	$Fname = $_POST['Fname'];
	$Lname = $_POST['Lname'];
	$password = $_POST['password'];
	$email = $_POST['email'];
	
	$qry = "INSERT INTO `r_user` ( `User_Id` , `User_Name` , `First_Name` , `Last_Name` , `Password` , `Activation_Code` , `Email_Id` )
			VALUES ( NULL ,  '$username',  '$Fname',  '$Lname',  '$password',  '',  '$email' )";
			
		if(mysql_query($qry))
		{
			echo "Successfully Registered!";
		}
?>