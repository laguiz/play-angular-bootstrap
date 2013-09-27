requirejs.config({
    //By default load any module IDs from js/lib
    baseUrl: 'assets/javascripts'
});

require(["helper/lib", "jquery/lib/jquery-1.9.1"],function(l) {
    var s = l.sum(4, 5);
    alert(s);
});