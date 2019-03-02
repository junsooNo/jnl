<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="resources/css/style.css">
<script src="resources/js/jquery-3.3.1.min.js"></script>
<script src="resources/js/common.js"></script>
<title>Insert title here</title>
<style type="text/css">
html,body,ul,li,a,div,span{margin:0; padding:0; outline:0; font-size:12px;}
a{color:black; text-decoration:none;}
li{list-style:none;}
#header{width:100%; height:50px; border-bottom:1px solid black; position:fixed; top:0; left:0; background:white;}
#header ul:first-child{width:100%; height:50px; display:flex; flex-direction: row;}
#header li{width:10%; height:30px; text-align:center; margin-top:10px; line-height:30px;}

#join_li, #login_li, #user_li, #logout_li{position:absolute;}
#join_li, #logout_li{right:0;}
#login_li{right:10%;}
#user_li{width:20%;}


#top{width:100%; height:200px; text-align:center; line-height:200px; margin-top:50px; border-bottom:1px solid #D8D8D8;}
#top a{font-size:40px; font-weight:bolder;}

#center{width:100%;}

#footer{width:100%; height:300px; border-top:1px solid black; text-align:center;}

.small_menu:hover{background:#D8D8D8; -webkit-transtion-duration:0.5s;}

</style>
</head>
<body>
   <div id="header">
      <ul>
         <c:choose>
         	<c:when test="${userInfo != null }">
    			 <li id="logout_li"><a href="logout">로그아웃</a></li>
    			 <li id="user_li"><span style="font-weight:bolder;">${userInfo.name }</span>님 안녕하세요</li>
         	</c:when>
         	<c:otherwise>
		         <li id="login_li"><a href="login">로그인</a></li>
		         <li id="join_li"><a href="join">회원가입</a></li>
         	</c:otherwise>
         </c:choose>
      </ul>
   </div>
   <div id="top">
      <a href="#">JNL2</a>
   </div>
   <div id="center">
   		<a href="resources/upload_image/Workbench-Build123 (2).zip">다운로드 
   		
   		
   		
   		
   		
   		
   		
   		
   		</a>
   	  <jsp:include page="${center }" />
   </div>
   <div id="footer">
      <p>스터디명 : JNL2</p>
      <p>스터디원 : 정승우 / 노준수 / 이동원  / 이주승</p>
   </div>
<script type="text/javascript">
function makeLargeMenu(){
	var data = {
			"parent_menu" : "2"
	}
	
	//대분류
	ajax("menu","get","json",data,function(data){
		var menuList = data.menuList;   
		var html = "<li><a href='main' style='font-size:20px; font-weight:bolder; color:blue;'>JNL2</a></li>";
		$.each(menuList,function(i){
			html += "<li id='large_menu_"+menuList[i].menu_num+"' class='large_menu' style=' -webkit-transtion-duration:0.5s;'>";
			html += 	"<a href='post?menu_num="+menuList[i].menu_num+"' style='display:block; width:100%; height:100%;'>"+menuList[i].name+"</a>";
			html += "</li>";
			html += "";
		})
		$("#header").find("ul").prepend(html);
		var largeMenu = document.querySelectorAll("[id*='menu_']");
		
		//소분류 넣기
		$.each(largeMenu,function(i){
			var menu_num = $(this).attr("id").substring($(this).attr("id").lastIndexOf("_")+1);
			makeSmallMenu($(this),menu_num);
		})
	},function(error){
		alert("error...")
	})  
}

function makeSmallMenu(largeMenu,data){
	var data = {
			"parent_menu" : data
	}
	ajax("menu","get","json",data,function(data){
		var menuList = data.menuList;   
		console.log(menuList)
		var html = "";
		html += "<div style='width:100%; height:200px; border:1px solid #D8D8D8; background:white; display:none;'>";
		html += 	"<div style='width:90%; height:90%; margin:5% 5%;'>";
		html += 		"<ul style='width:100%; height: 100%; display:block;'>";
		$.each(menuList, function(i){
			html += 			"<li id='small_menu_"+menuList[i].menu_num+"' class='small_menu' style='width:100%; margin-top:0; height:30px; border-radius:5px; -webkit-transition-duration:0.5s;'>";
			html += 				"<a href='#' style='display:block; width:100%; height:100%;'>"+menuList[i].name+"</a>";
			html += 			"</li>";
		})
		html += 		"</ul>";
		html += 	"</div>";
		html += "</div>";
		
		largeMenu.append(html)
		
	},function(error){
		alert("error...")
	})
}

$(document).ready(function(){
	makeLargeMenu();	
	
	$(document).on("mouseover","li[id*='large_menu_']",function(){
		$(this).find("div").show();
	})
	$(document).on("mouseout","li[id*='large_menu_']",function(){
		var d = $(this).children("div").first().hide();
	})
})
</script>
</body>
</html>