<link href="web.css" rel=stylesheet type="text/css" />
<link href="facefiles/facebox.css" media="screen" rel="stylesheet" type="text/css" />
<script src="facefiles/jquery-1.2.2.pack.js" type="text/javascript"></script>
<script src="facefiles/facebox.js" type="text/javascript"></script>

<script type="text/javascript">
    jQuery(document).ready(function($) {
      $('a[rel*=facebox]').facebox() 
    })
</script>
<script>
function sh(value)
       {
	if(value!="")
	{
		//alert(mid);
	if(window.XMLHttpRequest)
		{
			xmlhttp= new XMLHttpRequest();
		}
	else
		{
			xmlhttp=new ActiveXObject("Microsoft.XMLHTTP");
					
		}
		xmlhttp.onreadystatechange=function()
		{
			if(xmlhttp.readyState==4 && xmlhttp.status==200)
			{
			document.getElementById("search_show").innerHTML=xmlhttp.responseText;	
			}			
		}
			xmlhttp.open("GET","search.php?value="+value,true);
			xmlhttp.send();
		
	}
	}

</script>

	   
	  <!--<script type="text/javascript">

/* function popup(){
  cuteLittleWindow = window.open("signup form.html", "littleWindow", "location=no,width=320,height=200"); 
}*/

</script> -->

<script type="text/javascript">
    jQuery(document).ready(function($) {
      $('a[rel*=facebox]').facebox() 
    })
</script>