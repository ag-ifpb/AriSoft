function mudarImagemJogo() {
    $("#imagem").click();
}
function selecionouImagemJogo(input) {
    var reader = new FileReader();
    reader.onload = function (e) {
        $(".cover").css("background-image", "url(" + e.target.result + ")");
    };
    reader.readAsDataURL(input.files[0]);
}
function submitCadastroJogo() {
    var formData = new FormData();
    formData.append('imagem', $('#imagem')[0].files[0]);
    formData.append('objetivo', $('#objetivo').val());
    formData.append('enredo', $('#enredo').val());
    formData.append('missao', $('#missao').val());
    formData.append('local', $('#local').val());
    formData.append('horario', $('#horario').val());
    $.ajax({
        url: "/jogo/cadastro/adicionar",
        type: "POST",
        data: formData,
        processData: false,
        contentType: false,
        success: function (res) {
            if (res === '202') {
                linkJogo();
            }
            else alert(res);
        },
        error: function () {
            alert("deu erro");
        }
    });
}