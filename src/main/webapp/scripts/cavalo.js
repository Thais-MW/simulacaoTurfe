const MIN = 1;
const MAX = 5;
const PRECO_INICIAL = 1000;

const inputVelocidade = document.querySelector('input[name="velocidade"]');
const inputResistencia = document.querySelector('input[name="resistencia"]');
const inputPreco = document.querySelector('input[name="preco"]');
const buttonNovaAleatoridade = document.querySelector("#gerarNovaAleatoridade");
const form = document.querySelector("#formCavalo");

buttonNovaAleatoridade.addEventListener("click", () => {
    gerarValoresAleatoriosCavalo(2500);
});

form.addEventListener("submit", () => {
	eraseCookie("velocidadeCavalo");
	eraseCookie("resistenciaCavalo");
	eraseCookie("precoCavalo");
});

function gerarValoresAleatoriosCavalo(adicional) {
    const velocidadeAleatoria = getRandomValue();
    const resistenciaAleatoria = getRandomValue();

    setCookie("velocidadeCavalo", velocidadeAleatoria);
    setCookie("resistenciaCavalo", resistenciaAleatoria);
    inputVelocidade.value = velocidadeAleatoria;
    inputResistencia.value = resistenciaAleatoria;

    if (adicional) {
        const precoCavalo = parseInt(getCookie("precoCavalo")) + adicional;
        setCookie("precoCavalo", precoCavalo);
        inputPreco.value = precoCavalo;
    } else {
        const precoAleatorio = calcularPreco(
            velocidadeAleatoria,
            resistenciaAleatoria
        );
        setCookie("precoCavalo", precoAleatorio);
        inputPreco.value = precoAleatorio;
    }
}

function getRandomValue() {
    return Math.floor(Math.random() * (MAX - MIN + 1)) + MIN;
}

function calcularPreco(velocidade, resistencia) {
    return (PRECO_INICIAL * (velocidade * 80 + resistencia * 20)) / 100;
}

function getCookie(name) {
    let cookies = document.cookie.split("; ");
    for (let i = 0; i < cookies.length; i++) {
        let cookie = cookies[i];
        let [cookieName, cookieValue] = cookie.split("=");
        if (cookieName === name) {
            return cookieValue;
        }
    }
    return null;
}

function setCookie(name, value) {
    document.cookie = name + "=" + value;
}

function eraseCookie(name) {
    document.cookie = name + '=; Max-Age=0';
}

if (
    getCookie("velocidadeCavalo") &&
    getCookie("resistenciaCavalo") &&
    getCookie("precoCavalo")
) {
    inputVelocidade.value = getCookie("velocidadeCavalo");
    inputResistencia.value = getCookie("resistenciaCavalo");
    inputPreco.value = getCookie("precoCavalo");
} else {
    gerarValoresAleatoriosCavalo();
}
