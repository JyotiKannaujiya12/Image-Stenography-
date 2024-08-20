<%@ page import="com.nits.util.*" %>
<html>
<head>
	<link href="<%=request.getContextPath() %>/Resources/CSS/message.css" rel="stylesheet" type="text/css" /> 
	<link rel="stylesheet" href="<%=request.getContextPath() %>/Resources/CSS/login.css" type="text/css"/>
	<script type="text/javascript" src="<%=request.getContextPath() %>/Resources/JS/style.js"></script>
	<script type="text/javascript" src="<%=request.getContextPath()%>/javascript/IndvMemberValidate.js"></script>
	


</head>
<body onload="startTimer()">
<div style="position:absolute;top:-20px;left:100" class="c">	
	<table id="login">
			<h1 align="center" id="label">Add User</h1>
			<hr size="10" color="#5E74D8"></hr>
			<form  action="<%=request.getContextPath() %>/UserList">
			<input type="hidden" name="submit" value="Add"></input>
			<input type="hidden" name="add1" value="YES"></input>
				<tr id="label">
					<td>User-ID</td>
					<td><input class="field" name="id" type="text" required="yes"/></td>
					<td>Address</td>
					<td><input class="field" name="add" type="text" /></td>
				</tr>
				<tr>
					<td>&nbsp;</td>
				</tr>
				<tr id="label">
					<td>Password</td>
					<td><input class="field" name="pass" type="password" required="yes"/></td>
					<td>City</td>
					<td><input class="field" name="city" type="text" required="yes"/></td>
				</tr>
				<tr>
					<td>&nbsp;</td>
				</tr>
				<tr id="label">
					<td>Name</td>
					<td><input class="field" name="name" type="text" required="yes" onkeypress="return isNumberKey(evt)"/></td>
					<td>Emai-ID</td>
					<td><input class="field" name="email" type="text" pattern="\w+([-+.]\w+)*@\w+([-.]\w+)*\.\w+([-.]\w+)*" 
									required="yes"/></td>
					
				</tr>
				<tr>
					<td>&nbsp;</td>
				</tr>
				<tr id="label">
					<td>&nbsp;</td>
					<td>
						&nbsp;&nbsp;&nbsp;Male<input name="gender" value="Male" type="radio" checked="true"/>
						&nbsp;&nbsp;&nbsp;Female<input name="gender" value="Female" type="radio"/>
					</td>
					<td>Contact No</td>
					<td><input class="field" name="cno" id="cno" type="text" pattern=^([0]|\+91)?\d{10} /></td>
					
					
					
				</tr>
				<tr>
					<td>&nbsp;</td>
				</tr>
				<tr>
					<td>&nbsp;</td>
					<td><input class="button" type="submit" value="Register"/> </td>
				</tr>
		</form>
		
	</table>
	

</div>		
<%
if(Utility.parse(request.getParameter("no"))==1)
{%>
	<div class="error" id="message" style="position:absolute">	
		<p>Sorry this user id is already exists.....!</p>
	</div>			
<%}
%>
</body>
</html>