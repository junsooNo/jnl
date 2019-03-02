<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
#post{width:900px; height:1000px; margin:50px auto;}
#button_div{width:100%; height:50px; line-height:50px;}
</style>
</head>
<body>
	<div id="post">
	<!-- <form id="reg_form" method="post" enctype="multipart/form-data">
		<input type="file" name="file" id="file">
		<input type="button" id="register_btn" value="!@#!@#" onclick="ok()">
	</form> -->
		<h1>${menuName }</h1>
		<div id="button_div">
			<a href="#register" class="jnl_button" onclick="registerPost()" style="width:80px; float:right;">
				<span>작성하기</span>
			</a>
		</div>
		<div id="post_body">
		
		</div>
	</div>
<script type="text/javascript">
var fileCount = 0;
var contentTarget;
function registerPost(){
	console.log("!!!")
	var html = "";
	html += "<div style='width:900px; height:800px; background-color:white; border:1px solid #D8D8D8; position:fixed; top:10%; left:25%;'>";
	html += 	"<div style='width:90%; height:90%; margin:5% 5%;'>";
	html += 		"<form id='reg_form' method='post' enctype='multipart/form-data'>";
	html += 			"<h1>글작성</h1>";
	html += 			"<div style='width:100%; height:50px; line-height:50px;'>";
	html += 				"<input type='text' name='title' class='jnl_text' style='width:100%;' placeholder='제목을 입력해주세요'>";
	html += 			"</div>";
	html +=				 "<div id='content_body' style='width:100%; height:500px; position:relative;'>";
	html += 				"<div name='content' id='content' contentEditable='true' style='width:100%; height:100%; border:1px solid #D8D8D8; overflow-y:scroll;'><div><br></div></div>";
	html += 				"<label for='content' id='content_label' style='position:absolute; top:10px; left:10px; font-size:15px;'>내용을 입력해주세요</label>";
	html +=				 "</div>";
	html += 			"<div style='width:100%; line-height:50px; display:flex;'>";
	html += 				"<input type='file' id='file_"+fileCount+"' name='file' style='display:none;'>";
	html += 				"<label for='file_"+fileCount+"' style='width:40px; height:40px; text-align:center; cursor:pointer; font-size:20px; line-height:40px; border:1px solid black; display:inline-block;'>+</label>";
	html += 			"</div>";
	html += 			"<div style='width:100%; height:50px; line-height:50px; text-align:center;'>";
	html += 				"<a href='#register' class='jnl_button' onclick='learnPost()' style='width:100px;'> ";
	html += 					"<span>작성완료</span>";
	html += 				"</a>";
	html += 				" <a href='#register' class='jnl_button' style='width:100px;'>";
	html += 					"<span>취소</span>";
	html += 				"</a>";
	html += 			"</div>";
	html += 			"";
	html += 		"</form>";
	html += 	"</div>";
	html += "</div>";
	$("body").append(html)
	contentTarget = $("#content")
}







function learnPost(){
	var form = $("#reg_form")[0];
	var formData = new FormData(form);
	console.log(formData)
	ajaxTypeFile("learnPost","POST","json",formData,function(data){
			if(data.result == "success"){
				location.href="main";
			}else{
				alert("아이디 또는 비밀번호가 틀렸습니다.");
				return;
			}
		},function(error){
			alert("error...")
		})
	
}

function addFile(element,index){
	var html = "";
	html += "<input type='file' id='file_"+fileCount+"' name='file' style='display:none;'>";
	html += "<label for='file_"+fileCount+"' style='width:40px; height:40px; text-align:center; cursor:pointer; font-size:20px; line-height:40px; border:1px solid black; display:inline-block;'>+</label>";
	element.parent("div").append(html);
	
	element.attr("id","file_ok_"+index)
	$("[for='file_"+index+"']").attr("for","file_ok_"+index)
}

$(document).ready(function(){
	console.log(contentTarget)
	$(document).on("click","#register_btn",function(){
		var form = $("#reg_form");
	})
	$(document).on("focus","[name='content']",function(){
		$("#content_label").hide();
	})
	$(document).on("blur","[name='content']",function(){
		if($(this).html() == ""){
			$("#content_label").show();
		}
	})
	$(document).on("change","[id*='file_']",function(target){
		var index = $(this).attr("id").substring($(this).attr("id").lastIndexOf("_")+1);
		var url = URL.createObjectURL(event.target.files[0]);
		var image = "<img src='"+url+"' style='width:100%; height:100%;'>"
		$("[for='file_"+index+"']").html(image)
		
		//var html = "";
		//html += 	"<img id='content_image_"+fileCount+"' src='"+url+"' style='width:500px; height:500px;'>";
		//$(contentTarget).append(html);
		
		fileCount++;
		
		//파일 추가
		addFile($(this),index);
	})
	$(document).on("click","[for*='file_ok_']",function(){
		var index = $(this).attr("for").substring($(this).attr("for").lastIndexOf("_")+1);
		$(this).remove();
		$("#file_ok_"+index).remove();
		$("#content_image_"+index).remove();
	})
	$(document).on("keyup","#content",function(e){
		console.log(e.keyCode)
		if(e.keyCode == 8 || e.keyCode == 46){
			var img = $(this).find("img")
			$.each($("[id*='file_ok_']"),function(){
				var index = $(this).attr("id").substring($(this).attr("id").lastIndexOf("_")+1)
				console.log($("#content_image_"+index).length)
				if($("#content_image_"+index).length == 0){
					$(this).remove();
					$("[for='file_ok_"+index+"']").remove();
				}
			})			
		}else{
			//contentTarget = $(document.activeElement);
			var el = document.getElementById("content"); 
			var range = document.createRange(); 
			var sel = window.getSelection(); 
			var node = sel.focusNode;
			var ele = node.tagName;
			contentTarget = sel.focusNode;
		}
	})
	$(document).on("click","#content",function(e){
		var sel = window.getSelection();
		//contentTarget = e.target;
		contentTarget = sel.focusNode;
		console.log(contentTarget)
		console.log($(contentTarget))  
	})
})
</script>
</body>
</html>