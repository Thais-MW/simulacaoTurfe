<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="pt-br" data-bs-theme="dark">
<head>
<meta charset="UTF-8" />
<title>Edição de Corrida</title>
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
<script src="scripts/main.js" defer></script>
</head>
<body>
	<jsp:include page="../partials/header.html" />

	<div class="container mt-5">
		<div class="row">
			<div class="col-sm-8 mb-3 mb-sm-0">
				<div class="card">
					<div class="card-body">
						<h5 class="card-title">Altere uma corrida</h5>
						<form action="/simulacaoTurfe/CorridaUpdate" method="get">
							<input type="hidden" name="id" value="${ corrida.id }" />
							<div class="row">
								<div class="col-md-6 mb-3">
									<label for="inputDataHora" class="form-label">Data
										e hora:</label> <input name="dataHora" type="datetime-local" class="form-control"
										id="inputDataHora" required  value="${ corrida.data }" />
								</div>
								<div class="col-md-6 mb-3">
									<label for="inputPreco" class="form-label">Taxa
										de inscrição:</label>
									<div class="input-group">
										<span class="input-group-text">R$</span>
										<input name="taxaInscricao" type="number" class="form-control" id="inputPreco"
											aria-label="Amount (to the nearest dollar)" min="10" required value="${ corrida.getInscricao() }" />
										<span class="input-group-text">.00</span>
									</div>
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
				<strong class="me-auto">Corrida na data ${corrida.getData()} foi agendada com sucesso!</strong>
				<button type="button" class="btn-close" data-bs-dismiss="toast"
					aria-label="Close"></button>
			</div>
		</div>
	</div>
</body>
</html>