
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

	<form:form action="/computador" commandName="listaComputadoresFiltro" method="GET">
		<form:select path="salaId" items="${salas}" itemLabel="nome" itemValue="id"/>
		<input type="submit" value="Filtrar" />
	</form:form>

<table>
	<thead>
		<tr>
			<th>Número de Série</th>
			<th>Configuração</th>
			<th>Número na Sala</th>
			<th>Modelo</th>
			<th>Ações</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach var="computador" items="${computadores}">
			<tr>
				<td>${computador.numeroDeSerie}</td>
				<td>${computador.configuracao}</td>
				<td>${computador.numeroNaSala}</td>
				<td>${computador.modelo}</td>
				<td>
					<a href="/problema/computador/${computador.id}/criar"></a>
				</td>
			</tr>
		</c:forEach>
	</tbody>
</table>


</body>
</html>