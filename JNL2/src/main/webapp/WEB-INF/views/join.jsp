<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
#join{width:1260px; height:1000px; margin:50px auto;}
#join_table{width:70%; margin:0 auto;}
#join_table td{border:1px solid #D8D8D8;}
.jnl_td_right input{margin-left:10px;}
.jnl_text{width:50%;}
#join_ok_btn, #join_no_btn{width:100px;}
</style>
</head>
<body>
	<div id="join">
		<form id="form1" action="" method="post">
			<table id="join_table">
				<tr>
					<td colspan="2" style="height:100px; border:none;">
						<span style="font-size:30px; font-weight:bolder;">회원가입</span>
					</td>
				</tr>
				<tr>
					<td class="jnl_td_left">
						<span>아이디</span>
					</td>
					<td class="jnl_td_right">
						<input type="text" id="id" name="id" class="jnl_text"> 
						<a href="#none" id="check_id_btn" class="jnl_button_silver">
							<span>중복확인</span>
						</a>
					</td>
				</tr>
				<tr>
					<td class="jnl_td_left">
						<span>비밀번호</span>
					</td>
					<td class="jnl_td_right">
						<input type="password" id="passwd" name="passwd" class="jnl_text">
					</td>
				</tr>
				<tr>
					<td class="jnl_td_left">
						<span>비밀번호 확인</span>
					</td>
					<td class="jnl_td_right">
						<input type="password" id="passwd2" class="jnl_text">
						<span id="passwd_check" style="font-weight:bolder;"></span>
					</td>
				</tr>
				<tr>
					<td class="jnl_td_left">
						<span>이름</span>
					</td>
					<td class="jnl_td_right">
						<input type="text" name="name" class="jnl_text">
					</td>
				</tr>
				<tr>
					<td class="jnl_td_left">
						<span>성별</span>
					</td>
					<td class="jnl_td_right">
						<input type="radio" id="gender_male" name="gender" value="M">
						<label for="gender_male" id="label_female">남성</label>
						<input type="radio" id="gender_female" name="gender" value="F">
						<label for="gender_female" id="label_female">여성</label>
					</td>
				</tr>
				<tr>
					<td class="jnl_td_left">
						<span>이메일</span>
					</td>
					<td class="jnl_td_right">
						<input type="email" name="email" class="jnl_text">
					</td>
				</tr>
				<tr>
					<td colspan="2" style="height:100px; text-align:center; border:none;">
						<a href="#none" id="join_ok_btn" class="jnl_button">
							<span>회원가입</span>
						</a>
						<a href="#none" id="join_no_btn" class="jnl_button">
							<span>뒤로가기</span>
						</a>
					</td>
				</tr>
			</table>
		</form>
	</div>
<script type="text/javascript">
var idCheckCount;
function checkId(id){
	var data = {
					"id" : id
				}
	ajaxTypeAsync("checkId","get","json",data,function(data){
		console.log(data.result)
		idCheckCount = data.result
	},function(error){
		alert("error...")
	})
}
$(document).ready(function(){
	   
	$(document).on("click","#check_id_btn",function(){
		var id=$("#id").val();
		if(id == ""){
			alert("아이디를 입력해주세요.")
			return;
		}
		checkId(id)
		if(idCheckCount > 0){
			alert("중복된 아이디 입니다.")
		}else{
			alert("사용 가능한 아이디 입니다.")
		}
	})
	
	$(document).on("keyup","#passwd2",function(){
		if($("#passwd").val() != $(this).val() && $(this).val() != ""){
			$("#passwd_check").css({"color":"red"})
			$("#passwd_check").html("비밀번호가 일치하지 않습니다.")
		}else if($("#passwd").val() != $(this).val() && $(this).val() == ""){
			$("#passwd_check").css({"color":"red"})
			$("#passwd_check").html("비밀번호를 입력해주세요.")
		}else if($("#passwd").val() == $(this).val() && $(this).val() != ""){
			$("#passwd_check").css({"color":"blue"})
			$("#passwd_check").html("비밀번호가 일치합니다.")
		}
	})
	
	$(document).on("click","#join_ok_btn",function(){
		//중복확인
		var id = $("#id").val();
		checkId(id)
		
		if(id == ""){
			alert("아이디를 입력해주세요.")
			return;
		}
		
		if(idCheckCount > 0){
			alert("중복된 아이디 입니다.");
			return;
		}
		
		if($("#passwd").val() != $("#passwd2").val()){
			alert("비밀번호가 일치하지 않습니다.");
			return;
		}
		
		if($("[name='gender']").prop("checked") == false){
			alert("성별을 선택해주세요.");
			return;
		}
		
		//폼 직렬화
		var form = $("#form1").serialize();
		ajax("user","post","json",form,function(data){
			var result = data.result
			if(result == "success"){
				alert("회원가입이 완료되었습니다.")
			}else{
				alert("회원가입에 실패했습니다. 관리자에게 문의해주세요.")
			}
		},function(error){
			alert("error...")
		})
	})
})
</script>
</body>
</html>