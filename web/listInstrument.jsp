<%@ page language="java" contentType="text/html;charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<script src="/js/jquery/2.0.0/jquery.min.js"></script>

<script>
$(function(){
    $("input.bookButton").click(function(){
        var iid = $(this).attr("iid");
        var startTime = $("input.startTime[iid="+iid+"]").val();
        var endTime = $("input.endTime[iid="+iid+"]").val();
        var url = "/bookingEvent";
            $.post(
                url,
                {"startTime":startTime, "iid":iid, "endTime":endTime},
                function(result){
                    alert("预约成功");
                }
            );
    });
});
</script>

<c:if test="${!empty user}">
<div align="center">
当前用户：${user.name}
</div>
</c:if>

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
        <td><input type="datetime-local" class="startTime" iid="${instrument.id}">
        </td>
        <td>
            <input type="datetime-local" class="endTime" iid="${instrument.id}">
        </td>
        <td>
            <input type="submit" class="bookButton" iid="${instrument.id}" value="预约">
        <td>
    </tr>
</c:forEach>
</table>