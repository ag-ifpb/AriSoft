var pagina = 0;
var paginaRealizados = 0;
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
function linkJogosRealizados() {    
    $.ajax({
        url: "/jogos/realizados",
        context: document.body
    }).done(function (data) {
        var wrapper = $('.content-wrapper');
        wrapper.empty();
        wrapper.append(data);
        paginaRealizados = 0;
        carregarPaginaJogosRealizados();
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
function linkJogoAlbum(id) {
    $.ajax({
        url: "/jogos/jogo/"+id+"/album",
        context: document.body
    }).done(function (data) {
        var wrapper = $('.game-infos');
        wrapper.empty();
        wrapper.append(data);
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
function carregarPaginaJogosRealizados (){
    $.ajax({
        url: "/jogos/page/"+ paginaRealizados +"/realizados",
        context: document.body
    }).done(function (data) {
        $(".load-more").remove();
        var wrapper = $('.content-wrapper .content');        
        wrapper.append(data);
        paginaRealizados++;
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