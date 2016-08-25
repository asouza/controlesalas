
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Lista de Problemas</title>
</head>
<body>

<h2>${problematico}</h2>

<form:form action="/problema/${problemaId}/solucionar" commandName="infoSolucao">
	<label for="comentario">Solução</label>
	<form:input path="comentario" />
	<input type="submit" value="Solucionar" />
</form:form>

</body>
</html>