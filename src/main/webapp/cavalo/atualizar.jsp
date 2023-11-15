<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="pt-br" data-bs-theme="light">
<head>
<meta charset="UTF-8" />
<title>Edição de Cavalo</title>
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
<script src="scripts/cavalo.js" defer></script>
</head>
<body>
	<jsp:include page="../partials/header.html" />

	<div class="container mt-5">
		<div class="row">
			<div class="col-sm-8 mb-3 mb-sm-0">
				<div class="card">
					<div class="card-body">
						<h5 class="card-title">Altere um cavalo</h5>
						<form action="/simulacaoTurfe/CavaloUpdate" method="get" id="formCavalo">
							<input type="hidden" name="id" value="${ cavalo.id }" />
							<div class="row">
								<div class="col-md-9 mb-3">
									<label for="inputNome" class="form-label">Nome:</label> <input
										name="nome" type="text" class="form-control" id="inputNome"
										required value="${ cavalo.nome }" />
								</div>
								<div class="col-md-3 mb-3">
									<label for="inputNumero" class="form-label">Número:</label> <input
										name="numero" type="number" class="form-control"
										id="inputNumero" min="1" max="99" required value="${ cavalo.numero }" />
								</div>
							</div>
							<div class="row">
								<div class="col-md-9 mb-3">
								<label for="inputProprietario" class="form-label">Proprietário:</label>
									<select name="idProprietario" class="form-select"
										id="inputProprietario" aria-label="Proprietário do Cavalo"
										required>
										<option>Selecione um Proprietário</option>
										<c:forEach var="proprietario" items="${proprietarios}">
											<c:choose>
												<c:when test="${ proprietario.id == cavalo.getProprietario().id }">
													<option selected value="${proprietario.getId()}">${proprietario.getNome()}</option>
												</c:when>
												<c:otherwise>
													<option value="${proprietario.getId()}">${ cavalo.getProprietario().nome }</option>
												</c:otherwise>
											</c:choose>
											
										</c:forEach>
									</select>
								</div>
								<div class="col-md-3 mb-3">
									<label for="inputColor" class="form-label">Cor:</label> <input
										name="cor" type="color"
										class="form-control form-control-color w-100" id="inputColor"
										value="${ cavalo.cor }" title="Choose your color" />
								</div>
							</div>
							<div class="row">
								<div class="col-md-6 mb-3">
									<label for="inputPreco" class="form-label">Preço:</label>
									<div class="input-group">
										<span class="input-group-text">R$</span> <input name="preco"
											type="number" class="form-control" id="inputPreco"
											aria-label="Amount (to the nearest dollar)" readonly value="${ cavalo.preco }" /> <span
											class="input-group-text">.00</span>
									</div>
								</div>
								<div class="col-md-3 mb-3">
									<label for="inputVelocidade" class="form-label">Velocidade:</label>
									<input name="velocidade" type="number" class="form-control"
										id="inputVelocidade" readonly value="${ cavalo.velocidade }" />
								</div>
								<div class="col-md-3 mb-3">
									<label for="inputResistencia" class="form-label">Resistência:</label>
									<input name="resistencia" type="number" class="form-control"
										id="inputResistencia" readonly value="${ cavalo.resistencia }" />
								</div>
							</div>
							<div class="btn btn-secondary" id="gerarNovaAleatoridade">
								Gerar novos valores</div>
							<button type="submit" class="btn btn-primary">Enviar</button>
						</form>
					</div>
				</div>
			</div>
			<div class="col-sm-4">
				<div class="card">
					<div class="card-body">
						<h5 class="card-title">Observações:</h5>
						<p class="card-text">Os valores de velocidade e resistência
							afetarão como seu cavalo executará as disputas de corridas.</p>
						<p class="card-text">Caso não tenha ficado satisfeito com o
							cavalo apresentado, é possível gerar um novo. Porém a
							aleatoriedade permanece e no preço será acrescido R$2500,00.</p>
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
				<strong class="me-auto">Cavalo ${cavalo.getNome()} -
					${cavalo.getNumero()} alterado com sucesso!</strong>
				<button type="button" class="btn-close" data-bs-dismiss="toast"
					aria-label="Close"></button>
			</div>
		</div>
	</div>
</body>
</html>
