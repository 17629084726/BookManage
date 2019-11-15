<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title>超市账单管理系统-用户管理</title>
    <link type="text/css" rel="stylesheet" href="css/style.css">
</head>
<body>

<div class="menu">

    <table>
        <tbody>
        <tr>
            <td>
                <form method="post" action="<%=request.getContextPath()%>/userList.action">
                    <input name="method" value="query" class="input-text" type="hidden"> 用户名：<input name="name"
                                                                                                    class="input-text"
                                                                                                    type="text"
                                                                                                    value="">&nbsp;&nbsp;&nbsp;&nbsp;
                    <input value="查 询" type="submit">
                </form>
            </td>
        </tr>
        </tbody>
    </table>
</div>
<div class="main">

    <div class="optitle clearfix">
        <em>
            <form action="userAdd.jsp"><input value="添加用户" class="input-button"
                                                                               type="submit"></form>
        </em>
        </em>
        <div class="title">用户管理&gt;&gt;</div>
    </div>
    <div class="content">
        <table class="list">
            <tbody>
            <tr>
                <td width="70" height="29">
                    <div class="STYLE1" align="center">编号</div>
                </td>
                <td width="80">
                    <div class="STYLE1" align="center">用户名</div>
                </td>
                <td width="80">
                    <div class="STYLE1" align="center">用户账号</div>
                </td>
                <td width="100">
                    <div class="STYLE1" align="center">性别</div>
                </td>
                <td width="100">
                    <div class="STYLE1" align="center">年龄</div>
                </td>
                <td width="150">
                    <div class="STYLE1" align="center">电话</div>
                </td>
                <td width="150">
                    <div class="STYLE1" align="center">权限</div>
                </td>
            </tr>
            <c:forEach var="user" items="${pageInfo.list}">
            <tr>
                <td height="23"><span class="STYLE1">${user.id}</span></td>
                <td><span class="STYLE1">${user.name}</span></td>
                <td><span class="STYLE1"><a href="#">${user.loginName}</a></span></td>
                <td><span class="STYLE1"><c:if test="${user.gender==1}">男</c:if>
										 <c:if test="${user.gender==2}">女</c:if></span></td>
                <td><span class="STYLE1">${user.age}</span></td>
                <td><span class="STYLE1">${user.phone}</span></td>
                <td><span class="STYLE1"><c:if test="${user.userType==1}">管理员</c:if>
					<c:if test="${user.userType==2}">普通用户</c:if>
					<c:if test="${user.userType==3}">经理</c:if>
					     </span>
                </td>
            </tr>
			</c:forEach>
            </tbody>
        </table>
		<div align="center">
			共<span>${pageInfo.pages}</span>页
			当前是第<span>${pageInfo.pageNum}</span>页
			<c:if test="${pageInfo.isFirstPage==true}">上一页</c:if>
			<c:if test="${pageInfo.isFirstPage==false}"><a href="<%=request.getContextPath()%>/userList.action?page=${pageInfo.prePage}">上一页</a></c:if>
			<c:if test="${pageInfo.isLastPage==false}"><a href="<%=request.getContextPath()%>/userList.action?page=${pageInfo.nextPage}">下一页</a></c:if>
			<c:if test="${pageInfo.isLastPage==true}">下一页</c:if>
		</div>
    </div>
</div>

</body>
</html>