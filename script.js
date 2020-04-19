function entrar() {
    var entrar = document.getElementById("entrar")
    var login = document.getElementById("login")
    var senha = document.getElementById("senha")
    if (login.value == "" && senha.value == "") {
        window.location.href = "menu.html";
    } else {
        window.alert("Senha ou login incorretos!")
    }
}