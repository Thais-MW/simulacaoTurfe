<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="pt-br" data-bs-theme="light">
<head>
<meta charset="UTF-8" />
<title>Inscrições nas Corridas</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN"
	crossorigin="anonymous" />
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL"
	crossorigin="anonymous" defer></script>
<script src="scripts/main.js" defer></script>
</head>
<body>
	<jsp:include page="../partials/header.html" />

	<div class="container mt-5">
		<div class="card">
			<div class="card-body">
				<h5 class="card-title">Inscrições nas Corridas</h5>
				<table class="table">
					<thead>
						<tr>
							<th scope="col">Id</th>
							<th scope="col">Cavalo</th>
							<th scope="col">Data da Corrida</th>
							<th scope="col"></th>
							<th scope="col"></th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="inscricao" items="${inscricoes}">
							<tr>
								<th scope="row">${inscricao.getId()}</th>
								<td>${inscricao.getCavalo().getNome()}</td>
								<td>${inscricao.getCorrida().getData()}</td>
								<td><a href="/simulacaoTurfe/InscricaoCorridaPrepare?id=${inscricao.id}" class="btn btn-primary">Editar</a></td>
								<td><a href="/simulacaoTurfe/InscricaoCorridaDelete?id=${inscricao.id}" class="btn btn-primary">Excluir</a></td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</div>
	</div>
	<div class="toast-container position-fixed bottom-0 end-0 p-3">
		<div id="liveToast"
			class="toast ${apagado ? 'show' : 'hide'}" role="alert"
			aria-live="assertive" aria-atomic="true">
			<div class="toast-header">
				<strong class="me-auto">Inscrição apagada com sucesso!</strong>
				<button type="button" class="btn-close" data-bs-dismiss="toast"
					aria-label="Close"></button>
			</div>
		</div>
	</div>
</body>
</html>
