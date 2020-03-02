<%@ page language="java" contentType="text/html;charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<script src="/js/jquery/2.0.0/jquery.min.js"></script>


<c:if test="${!empty user}">
<div align="center">
当前用户：${user.name}
</div>
</c:if>

<table align="center" cellspacing="20">
    <tr>
        <td align="center">仪器名称</td>
        <td colspan=2 align="center">预约时间</td>
        <td align="center">备注</td>
    </tr>
    <tr>
        <td></td>
        <td align="center">起始时间</td>
        <td align="center">结束时间</td>
        <td></td>
    </tr>
<c:forEach items="${bookingevents}" var="bookingevent" varStatus="st">
    <tr>
        <td>${bookingevent.instrumentName}</td>
        <td>${bookingevent.startTime}</td>
        <td>${bookingevent.endTime}</td>
        <td>${bookingevent.comment}</td>
    </tr>

</c:forEach>
</table>
<div align="center"><a href="/home_page.jsp">返回</a></div>