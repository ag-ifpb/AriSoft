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
function adicionarMembrosAoJogo (id){
    var choices = "";
    $(".select2-selection__choice").each(function (){
        choices += $(this).attr("title")+",";
    });
    var formData = new FormData();
    formData.append('emails', choices);
    $.ajax({
        url: "/conf/jogo/"+id+"/membros/adicionar",
        type: "POST",
        data: formData,
        processData: false,
        contentType: false,
        success: function (res) {
            if (res === '202') {
                linkJogoMembros(id);
            }
            else alert(res);
        },
        error: function () {
            alert("deu erro");
        }
    });
}
function encerrarJogo(id){
    $.ajax({
        url: "/conf/jogo/"+id+"/encerrar",
        context: document.body
    }).done(function (data) {
        linkPaginaJogo(id);
    });
}
function cancelarJogo(id){
    $.ajax({
        url: "/conf/jogo/"+id+"/cancelar",
        context: document.body
    }).done(function (data) {
        linkPaginaJogo(id);
    });
}
function ativarInputImagens (){
    $('#addImagens').click();
}
function addImagensJogo (input, id){
    var formData = new FormData();
    $.each(input.files, function (i, file){
        formData.append('files['+i+']', file);
    });
    $.ajax({
        url: "/conf/jogo/"+id+"/addalbum",
        type: "POST",
        data: formData,
        processData: false,
        contentType: false,
        success: function (res) {
            if (res === '202') {
                linkJogoAlbum(id);
            }
            else alert(res);
        },
        error: function () {
            alert("deu erro");
        }
    });
}