<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%> <!-- errorPage="error500.jsp" -->
<%@ page import="java.util.ArrayList, java.util.Date" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>page지시어</h1>
	
	<%
		ArrayList<String> list = new ArrayList<>();
		list.add("Servlet");
		list.add("JSP");
	
		Date today = new Date();
	%>
	
	0번째 인덱스 : <%=list.get(0) %>
	현재날짜 및 시간 : <%=today %>
<%-- 
    <h1>include 지시어</h1>
    <div style="border : 1px solid block">
    <%@ include file="01_01_scripting_element.jsp" %>
    정적포함 -> 컴파일 전에 include되는 방식으로 코드 전체를 다 가져와 사요할 수 있음 <br> --%>


</body>
</html>