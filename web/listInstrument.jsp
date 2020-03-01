<%@ page language="java" contentType="text/html;charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<script src="/js/jquery/2.0.0/jquery.min.js"></script>

<table align="center">
    <tr>
        <td>仪器名称</td>
        <td>起始时间</td>
        <td>结束时间</td>
        <td></td>
    </tr>
<c:forEach items="${instruments}" var="instrument" varStatus="st" >
    <tr>
        <td>${instrument.name}</td>
        <td><input list="startTime">
            <datalist id = "startTime">
                <option value=1>
                <option value=2>
            </datalist>
        </td>
        <td>
            <input list="endTime">
                        <datalist id = "endTime">
                            <option value=1>
                            <option value=2>
                        </datalist>
        </td>
        <td>
            <input type="submit"class="bookButton" iid="${instrument.id}" value="预约">
        <td>
    <tr>
</c:forEach>
</table>