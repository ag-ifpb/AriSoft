var pagina = 0;
function linkJogo() {
    $.ajax({
        url: "/jogos",
        context: document.body
    }).done(function (data) {
        var wrapper = $('.content-wrapper');
        wrapper.empty();
        wrapper.append(data);
        pagina = 0;
        carregarPaginaJogos();
    });
}
function carregarPaginaJogos (){
    $.ajax({
        url: "/jogos/page/"+pagina,
        context: document.body
    }).done(function (data) {
        var wrapper = $('.content-wrapper .content');
        wrapper.empty();
        wrapper.append(data);
        pagina++;
    });
}
function linkCadastrarJogo() {
    $.ajax({
        url: "/jogo/cadastro",
        context: document.body
    }).done(function (data) {
        var wrapper = $('.content-wrapper');
        wrapper.empty();
        wrapper.append(data);
    });
}