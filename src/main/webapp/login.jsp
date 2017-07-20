<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<STYLE type="text/css">
		#login{
			width:400px;
			height:280px;
			position:absolute;
			left: 50%;
			top: 50%;
			margin-left:-200px;
			margin-top:-140px;
			border:1px;
				
			align:center;
			
			
		}	
		#form{
			width:300px;
			height:160px;
			position:relative;
   			 left:50%;
  			  top:50%;
  			  margin-left:-150px;
  			  margin-top:-80px;
		
		}
		
	</STYLE>

<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>
<div id="login">
<div id="form">
<form id="loginForm" action="login" method="post">
      <table>
         <tr>
            <td> 用户名：</td>
            <td><input type="text" name="username"/></td>
         </tr>
         <tr>
            <td> 密码：</td>
            <td><input type="password" name="password"/></td>
         </tr>
         <tr align="center">
            <td colspan="2" align="center" valign="midlle">
                <input type="submit" value=" 登录 "/>
                <input type="reset" value=" 重置 "/>
            </td>
         </tr>
      </table>
   </form>
   </div>
   </div>
</body>
</html>