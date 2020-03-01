<%@ page language="java" contentType="text/html;charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<script src="/js/jquery/2.0.0/jquery.min.js"></script>

<c:if test="${!empty user}">
<div align="center">
当前用户：${user.name}
</div>
<table align="center">
    <tr>
    <td><a href="/bookingevents">我的预约</a></td>
    <td><a href="/listInstruments">预约仪器</a></td>
    </tr>
</table>
</c:if>