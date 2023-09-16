<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="pt-br" data-bs-theme="light">
    <head>
        <meta charset="UTF-8" />
        <title>Cadastro de Cavalo</title>
        <link
            href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css"
            rel="stylesheet"
            integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN"
            crossorigin="anonymous"
        />
        <script
            src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL"
            crossorigin="anonymous"
            defer
        ></script>
        <script src="../scripts/main.js" defer></script>
        <script src="../scripts/cavalo.js" defer></script>
    </head>
    <body>
        <jsp:include page="../partials/header.html" />

        <div class="container mt-5">
            <div class="row">
                <div class="col-sm-8 mb-3 mb-sm-0">
                    <div class="card">
                        <div class="card-body">
                            <h5 class="card-title">Cadastre um cavalo</h5>
                            <form>
                                <div class="row">
                                    <div class="col-md-8 mb-3">
                                        <label
                                            for="inputNome"
                                            class="form-label"
                                            >Nome:</label
                                        >
                                        <input
                                            type="text"
                                            class="form-control"
                                            id="inputNome"
                                            required
                                        />
                                    </div>
                                    <div class="col-md-2 mb-3">
                                        <label
                                            for="inputNumero"
                                            class="form-label"
                                            >Número:</label
                                        >
                                        <input
                                            type="number"
                                            class="form-control"
                                            id="inputNumero"
                                            min="1"
                                            max="99"
                                            required
                                        />
                                    </div>
                                    <div class="col-md-2 mb-3">
                                        <label
                                            for="inputColor"
                                            class="form-label"
                                            >Cor:</label
                                        >
                                        <input
                                            type="color"
                                            class="form-control form-control-color w-100"
                                            id="inputColor"
                                            value="#ff0000"
                                            title="Choose your color"
                                        />
                                    </div>
                                </div>
                                <div class="row">
                                    <div class="col-md-3 mb-3">
                                        <label
                                            for="inputVelocidade"
                                            class="form-label"
                                            >Velocidade:</label
                                        >
                                        <input
                                            type="number"
                                            class="form-control"
                                            id="inputVelocidade"
                                            name="velocidade"
                                            disabled
                                        />
                                    </div>
                                    <div class="col-md-3 mb-3">
                                        <label
                                            for="inputResistencia"
                                            class="form-label"
                                            >Resistência:</label
                                        >
                                        <input
                                            type="number"
                                            class="form-control"
                                            id="inputResistencia"
                                            name="resistencia"
                                            disabled
                                        />
                                    </div>
                                    <div class="col-md-6 mb-3">
                                        <label
                                            for="inputPreco"
                                            class="form-label"
                                            >Preço:</label
                                        >
                                        <div class="input-group">
                                            <span class="input-group-text"
                                                >R$</span
                                            >
                                            <input
                                                type="number"
                                                class="form-control"
                                                id="inputPreco"
                                                name="preco"
                                                aria-label="Amount (to the nearest dollar)"
                                                disabled
                                            />
                                            <span class="input-group-text"
                                                >.00</span
                                            >
                                        </div>
                                    </div>
                                </div>
                                <div
                                    class="btn btn-secondary"
                                    id="gerarNovaAleatoridade"
                                >
                                    Gerar novos valores
                                </div>
                                <button type="submit" class="btn btn-primary">
                                    Enviar
                                </button>
                            </form>
                        </div>
                    </div>
                </div>
                <div class="col-sm-4">
                    <div class="card">
                        <div class="card-body">
                            <h5 class="card-title">Observações:</h5>
                            <p class="card-text">
                                Os valores de velocidade e resistência afetarão
                                como seu cavalo executará as disputas de
                                corridas.
                            </p>
                            <p class="card-text">
                                Caso não tenha ficado satisfeito com o cavalo
                                apresentado, é possível gerar um novo. Porém a
                                aleatoriedade permanece e no preço será
                                acrescido R$1000,00.
                            </p>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>