function submitCadastroMembro() {
    var formData = new FormData();
    formData.append('nome', $('#nome').val());
    formData.append('telefone', $('#telefone').val());
    formData.append('email', $('#email').val());
    $.ajax({
        url: "/membros/cadastro",
        type: "POST",
        data: formData,
        processData: false,
        contentType: false,
        success: function (res) {
            if (res === '202') {
                $(".modal-backdrop").remove();
                linkMembros();
            }
            else alert(res);
        },
        error: function () {
            alert("deu erro");
        }
    });
}