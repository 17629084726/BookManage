﻿<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html><head><meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
<link type="text/css" rel="stylesheet" href="css/style.css">
<script type="text/javascript" src="js/jquery-1.8.3.min.js"></script>
</head>
<body>
	<div class="main">
		<div class="optitle clearfix">
			<div class="title">用户管理&gt;&gt;</div>
		</div>
			<div class="content">
				<table class="box"> 
					<tbody><tr>
						<td class="field">用户编号：</td>
						<td>1<input type="hidden" id="userId" value="1"></td>
						
					</tr>
					<tr>
						<td class="field">用户名：</td>
						<td>秦守新</td>
					</tr>
					<tr>
						<td class="field">用户账号：</td>
						<td>shouxin.qin</td>
					</tr>

					<tr>
						<td class="field">用户性别：</td>
						<td>
								男
								
							
						</td>
					</tr>
					<tr>
						<td class="field">出生日期：</td>
						<td>2014-09-09
						</td>
					</tr>
					<tr>
						<td class="field">用户年龄：</td>
						<td>2
						</td>
					</tr>
					<tr>
						<td class="field">用户电话：</td>
						<td>111
						</td>

					</tr>
					<tr>
						<td class="field">用户地址：</td>
						<td>
						</td>
					</tr>
					<tr>
						<td class="field">用户权限：</td>

						<td>
							
							普通员工
							
						</td>
					</tr>
				</tbody></table>
			</div>
			<div class="buttons">
				<input type="button" id="update" value="修改" class="input-button">
				<input type="button" id="del" value="删除" class="input-button"> 
				<input type="button" id="repassword" value="重置密码" class="input-button"> 
				<input type="button" id="backButton" onclick="history.back(-1)" value="返回" class="input-button">
			</div>
	</div>
	<script type="text/javascript" src="js/user/view.js"></script>


</body></html>