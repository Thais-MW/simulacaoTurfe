<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="pt-br" data-bs-theme="dark">
<head>
<meta charset="UTF-8" />
<title>Home</title>
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

	<div class="container-fluid mt-5">
		<div class="row">
			<div class="col">
				<h2>Cadastro</h2>
				<form action="/simulacaoTurfe/UsuarioAdd" method="post">
					<div>
						<label for="nomeCadastro">
							Nome:
						</label>
						<input type="text" name="nome" id="nomeCadastro" />
					</div>
					<div>
						<label for="emailCadastro">
							Email:
						</label>
						<input type="email" name="email" id="emailCadastro" />
					</div>
					<div>
						<label for="senhaCadastro">
							Senha:
						</label>
						<input type="password" name="senha" id="senhaCadastro" />
					</div>
					<button type="submit">Cadastrar</button>
				</form>
			</div>
			<div class="col">
				<h2>Login</h2>
				<form action="/simulacaoTurfe/UsuarioLogin" method="post">
					<div>
						<label for="emailLogin">
							Email:
						</label>
						<input type="email" name="email" id="emailLogin" />
					</div>
					<div>
						<label for="senhaLogin">
							Senha:
						</label>
						<input type="password" name="senha" id="senhaLogin" />
					</div>
					<button type="submit">Entrar</button>
				</form>
			</div>
		</div>
	</div>
</body>
</html>
