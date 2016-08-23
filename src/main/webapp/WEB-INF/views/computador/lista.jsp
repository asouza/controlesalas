<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Lista de computadores</title>
</head>
<body>
	<table>
		<thead>
			<tr>
				<th>Configuração</th>
				<th>Número de série</th>
				<th>Observação</th>
				<th>Sala</th>
				<th>Número na Sala</th>
				<th>Ações</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="computador" items="${computadores }">
				<tr>
					<td>${computador.configuracao}</td>
					<td>${computador.numeroDeSerie}</td>
					<td>${computador.observacao}</td>
					<td>${computador.sala.numero}</td>
					<td>${computador.numeroNaSala}</td>
					<td><a href="/problema/${computador.id}/form">Adicionar Problema</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	

</body>
</html>