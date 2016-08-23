<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	
	<form:form method="post" action="/computador" commandName="computador">
		
		<label for="configuracao">Configuração</label>
		<form:input path="configuracao"/>	
		<form:errors path="configuracao" />
		
		<label for="numeroDeSerie">Numero de Série</label>
		<form:input path="numeroDeSerie"/>	
		<form:errors path="numeroDeSerie" />
			
		<label for="observacao">Observação</label>
		<form:input path="observacao"/>	
		<form:errors path="observacao" />
		
		<label for="sala">Sala</label>
		<form:select path="sala.id" itemLabel="numero" itemValue="id" items="${salas}"></form:select>
		<form:errors path="sala" />
		
		<label for="numeroNaSala">Número na sala</label>
		<form:input path="numeroNaSala"/>	
		<form:errors path="numeroNaSala" />
		
		<input type="submit" value="Gravar"/>
	</form:form>

</body>
</html>