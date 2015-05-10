$(document).ready(function() {
$("#linkeBtn").removeAttr("disabled");
$("#unlinkeBtn").removeAttr("disabled");
$('#linkeBtn').click(function(e)
    {
        var val = parseInt($("#linkeBtn").val());
        $.post("mainvideo.php", {op:"like"},function(data)
        {
            if(data)
            {
                $("#status").html("Liked Sucessfully!!");
                val = val+1;
                $("#linkeBtn").val(val);
                $("#linkeBtn").attr("disabled", "disabled");
                $("#linkeBtn").css("background-image","url(likebw.png)");
            }
            else
            {
                $("#status").html("Already Liked!!");
            }
        })
    });
    $('#unlinkeBtn').click(function(e)
    {
        var val = parseInt($("#unlinkeBtn").val());
        $.post("mainvideo.php", {op:"un-like"},function(data)
        {
            if(data)
            {
                val = val+1;
                $("#unlinkeBtn").val(val);
                $("#unlinkeBtn").attr("disabled", "disabled");
                $("#unlinkeBtn").css("background-image","url(likebw.png)");
                $("#status").html("Un-liked Sucessfully!!");
            }
            else
            {
                $("#status").html("Already Un-liked!!");
            }
        })
    });
	$('#commit-btn').click(function(){
		if($('#in-comm').val()==''){
			alert("enter commint");
			return false;
			}
		else{
			var comm = $('#in-comm').val();
			}
			jQuery.post("mainvideo.php", {
			comment:comm
			},  function(data,textstatus){
			if(data == 1){
			$('#response').html(" successfull!!");
			$('#response').css('color','green');
			}else{
			$('#response').html("Some Error Occurred");
			$('#response').css('color','red');
			}
			});
					
					});    
});