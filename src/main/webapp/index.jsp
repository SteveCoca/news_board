<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>登录界面</title>
		<script src="js/jquery-2.2.1.min.js"></script>
		<script type="text/javascript">
		var code;
		function createCode() {
		    code = "";
		    $.ajax({
			 		type:"post",
			 		url:"json/user_validateCode_inputCode.do",
		     		success:function(data){
		     			code = data;
						$("#checkCode").val(code+"");
		     		}
			});
		}
		</script>
	</head>
	
	<body>
		${msg}
		<form action="user!signIn.do" method="post">
		<table>
		<tr>
		 <td>name</td>
		 <td><input type="text" name="name" /></td>
		</tr>
		<tr>
		 <td>password</td>
		 <td><input type="password" name="password" /></td>
		</tr>
		<tr>
		 <td colspan="2"><input type="submit" value="登录" /></td>
		</tr>
		</table>
		</form>
		
		<form action="user!signUp.do" method="post">
		<table>
		<tr>
		 <td>name</td>
		 <td><input type="text" name="name" /></td>
		</tr>
		<tr>
		 <td>password</td>
		 <td><input type="password" name="password" /></td>
		</tr>
		<tr>
		 <td>email</td>
		 <td><input type="text" name="user.email" /></td>
		</tr>
		<tr>
		 <td>phone</td>
		 <td><input type="text" name="user.phone" /></td>
		</tr>
		<tr>
		 <td>inputCode</td>
		 <td><input type="text" name="inputCode" /></td>
		</tr>
		<tr>
		 <td><input type="button" value="获取" onclick="createCode()" /></td>
		 <td><input type="text" id = "checkCode" /></td>
		</tr>
		<tr>
		 <td colspan="2"><input type="submit" value="注册" /></td>
		</tr>
		</table>
		</form>
	</body>
</html>