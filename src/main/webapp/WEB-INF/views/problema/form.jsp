
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form:form action="/problema/${tipo}/${id}/criar" commandName="formProblema">
		<label for="titulo">Título</label>
		<form:input path="titulo" />
		<form:errors path="titulo" />
		
		<label for="descricao">Descrição</label>
		<form:textarea path="descricao" />
		<form:errors path="descricao" />
		
		<input type="submit" value="Gravar" />
	</form:form>

</body>
</html>