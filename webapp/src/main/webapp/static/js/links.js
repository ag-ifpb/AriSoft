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
function linkJogoMembros(id) {
    $.ajax({
        url: "/jogos/jogo/"+id+"/membros",
        context: document.body
    }).done(function (data) {
        var wrapper = $('.game-infos');
        wrapper.empty();
        wrapper.append(data);
        $(".select2").select2();
    });
}
function linkJogoInfo(id) {
    $.ajax({
        url: "/jogos/jogo/"+id+"/info",
        context: document.body
    }).done(function (data) {
        var wrapper = $('.game-infos');
        wrapper.empty();
        wrapper.append(data);
    });
}

function carregarPaginaJogos (){
    $.ajax({
        url: "/jogos/page/"+pagina,
        context: document.body
    }).done(function (data) {
        $(".load-more").remove();
        var wrapper = $('.content-wrapper .content');        
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
function linkPaginaJogo(id) {
    $.ajax({
        url: "/jogos/jogo/"+id,
        context: document.body
    }).done(function (data) {
        var wrapper = $('.content-wrapper');
        wrapper.empty();
        wrapper.append(data);
    });
}
function linkMembros() {
    $.ajax({
        url: "/membros",
        context: document.body
    }).done(function (data) {
        var wrapper = $('.content-wrapper');
        wrapper.empty();
        wrapper.append(data);
    });
}