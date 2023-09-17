<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="pt-br" data-bs-theme="dark">
<head>
<meta charset="UTF-8" />
<title>Agendamento de Corrida</title>
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
						<h5 class="card-title">Agende uma corrida</h5>
						<form>
							<div class="row">
								<div class="col-md-6 mb-3">
									<label for="inputDataHora" class="form-label">Data
										e hora:</label> <input type="datetime-local" class="form-control"
										id="inputDataHora" name="data-hora" required />
								</div>
								<div class="col-md-6 mb-3">
									<label for="inputPreco" class="form-label">Taxa
										de inscrição:</label>
									<div class="input-group">
										<span class="input-group-text">R$</span>
										<input type="number" class="form-control" id="inputPreco"
											aria-label="Amount (to the nearest dollar)" min="10" required />
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
</body>
</html>