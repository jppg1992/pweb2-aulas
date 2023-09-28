<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html></head>
<body>
<c:import url="/components-jstl/cabecalho.jsp" />
<br />
[...]
<br/>
<c:if test="${10>5 }" >
		número 10
</c:if>
<br/>
<c:set var="idade" value="3"/>

<c:choose>
  <c:when test="${idade > 18 }">
   Maior de idade
  </c:when>
  <c:otherwise>
   Menor de idade
  </c:otherwise>
</c:choose>

<br/>
Sua idade é <c:out value = "${idade }" />

<br />
<c:forEach var="i" begin = "1" end = "5">
Item atual: <c:out value="${i}" />
</c:forEach>
<br/>

<c:forEach var="i" begin = "1" end = "10">
 <c:out value="${i}"/> X 3 = <c:out value="${i*3}" />
 <br/>
</c:forEach>

<br/>

<c:import url="/components-jstl/rodape.jsp" />
</body>
</html>