<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form:form commandName="problemaForm" method="post" action="/sala/${sala.id}/problema">
		<fieldset>
			<legend>Sala: ${sala.numero}</legend>
			<div>
				<label for="titulo">Título</label>
				<form:input path="titulo" />
				<form:errors path="titulo" />
			</div>

			<div>
				<label for="descricao">Descrição</label>
				<form:textarea path="descricao" cols="20" rows="10" />
				<form:errors path="descricao" />
			</div>
			
			<form:hidden path="id" value="${sala.id}" />
			<input type="submit" value="Gravar" />
		</fieldset>
	</form:form>
</body>
</html>