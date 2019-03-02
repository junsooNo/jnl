<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
#login{width:1260px; height:1000px; margin:50px auto;}

#login_body{width:500px; height:400px; border:1px solid #D8D8D8; margin:50px auto;}
#login_body h1{text-align:center;}

#login_input_body{width:90%; height:70%; margin:10% 5%;}
#login_input_body div{width:100%; height:40px; line-height:5px; text-align:center;}
</style>
</head>
<body>
	<div id="login">
		<div id="login_body">
			<h1>LOGIN</h1>
			<form id="form01" action="" method="post">
				<div id="login_input_body">
					<div>
						<input type="text" id="id" name="id" class="jnl_text" placeholder="ID">
					</div>
					<div>
						<input type="password" id="passwd" name="passwd" class="jnl_text" placeholder="PASSWORD">
					</div>
					<div>
						<a href="#none" id="login_btn" class="jnl_button"><span>로그인</span></a>
					</div>
					<div style="height:60px;">
						<a href="https://kauth.kakao.com/oauth/authorize
						?client_id=64d617d3a9432635af13fadf550649e1
						&redirect_uri=http%3A%2F%2F192.168.200.107%3A8080%2Fstudy%2FkakaoSession
						&response_type=code" style="width:80%; margin-top:5px; height:50px; display:inline-block;">
							<img src="resources/icon/button_image/kakao_account_login_btn_medium_wide.png" style="width:100%; height:100%;">
						</a>
					</div>
					<div style="height:60px;">
						<a href="https://nid.naver.com/oauth2.0/authorize
						?response_type=code
						&client_id=aY9BM1w0R9qFTSRtXioA
						&state=219005893879948815616441961109802182879
						&redirect_uri=http%3A%2F%2F192.168.200.107%3A8080%2Fstudy%2FnaverSession" style="width:80%; margin-top:5px; height:50px; display:inline-block;">
							<img src="resources/icon/button_image/네이버 아이디로 로그인_완성형_Green.PNG" style="width:100%; height:100%;">
						</a>
					</div>
					<div style="height:60px;">
						<a href="https://api.instagram.com/oauth/authorize/
						?client_id=c4347c8992804d8ab56b3b10c4a9e579
						&redirect_uri=http%3A%2F%2Flocalhost%3A8080%2Fstudy%2FinstagramSession
						&response_type=code" style="width:80%; margin-top:5px; height:50px; display:inline-block;">
							인스타그램 아이디로 로그인
						</a>
					</div>
				</div>
			</form>
		</div>
	</div>
<script type="text/javascript">
$(document).ready(function(){
	
	$(document).on("keyup","#passwd",function(e){
		if(e.keyCode == 13){
			$("#login_btn").click();
		}
	})
	
	$(document).on("click","#login_btn",function(){
		var form = $("#form01").serialize();
		ajax("loginSession","post","json",form,function(data){
			if(data.result == "success"){
				location.href="main";
			}else{
				alert("아이디 또는 비밀번호가 틀렸습니다.");
				return;
			}
		},function(error){
			alert("error...")
		})
	})
})
</script>
</body>
</html>