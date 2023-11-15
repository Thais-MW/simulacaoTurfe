<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="pt-br" data-bs-theme="light">
<head>
<meta charset="UTF-8" />
<title>Inscrição de Cavalo</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN"
	crossorigin="anonymous" />
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL"
	crossorigin="anonymous" defer></script>
<script src="../scripts/main.js" defer></script>
</head>
<body>
	<jsp:include page="../partials/header.html" />
	
	<div class="container mt-5">
		<div class="row">
			<div class="col-sm-8 mb-3 mb-sm-0">
				<div class="card">
					<div class="card-body">
						<h5 class="card-title">Altere uma inscrição</h5>
						<form action="/simulacaoTurfe/InscricaoCorridaUpdate" method="get">
							<input type="hidden" name="id" value="${ inscricao.id }" />
							<div class="row">
								<div class="col-md-6 mb-3">
									<label for="inputCavalo" class="form-label">Cavalo:</label>
									<select name="idCavalo" class="form-select" id="inputCavalo"
										aria-label="Cavalo a disputir corrida" required>
										<option>Selecione um Cavalo</option>
										<c:forEach var="cavalo" items="${cavalos}">
											<c:choose>
												<c:when test="${ inscricao.getCavalo().id == cavalo.id }">
													<option selected value="${cavalo.getId()}">${cavalo.getNumero()} - ${cavalo.getNome()}</option>
												</c:when>
												<c:otherwise>
													<option value="${cavalo.getId()}">${cavalo.getNumero()} - ${cavalo.getNome()}</option>
												</c:otherwise>
											</c:choose>
										</c:forEach>
									</select>
								</div>
								<div class="col-md-6 mb-3">
									<label for="inputCorrida" class="form-label">Corrida:</label>
									<select name="idCorrida" class="form-select" id="inputCorrida"
										aria-label="Corrida a ser disputada">
										<option>Selecione uma Corrida</option>
										<c:forEach var="corrida" items="${corridas}">
											<c:choose>
												<c:when test="${ inscricao.getCorrida().id == corrida.id }">
													<option selected value="${corrida.getId()}">${corrida.getData()}</option>
												</c:when>
												<c:otherwise>
													<option value="${corrida.getId()}">${corrida.getData()}</option>
												</c:otherwise>
											</c:choose>
										</c:forEach>
									</select>
								</div>
							</div>
							<button type="submit" class="btn btn-primary">Enviar</button>
						</form>
					</div>
				</div>
			</div>
			<div class="col-sm-4">
				<div class="card">
					<div class="card-body">
						<h5 class="card-title">Observações:</h5>
						<p class="card-text"></p>
					</div>
				</div>
			</div>
		</div>
	</div>
	<div class="toast-container position-fixed bottom-0 end-0 p-3">
		<div id="liveToast"
			class="toast ${alterado ? 'show' : 'hide'}" role="alert"
			aria-live="assertive" aria-atomic="true">
			<div class="toast-header">
				<strong class="me-auto">Inscrição alterada com sucesso!</strong>
				<button type="button" class="btn-close" data-bs-dismiss="toast"
					aria-label="Close"></button>
			</div>
		</div>
	</div>
</body>
</html>
