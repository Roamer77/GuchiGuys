$(document).ready(function () {

    $(".tvCategory").click(function () {
        var url="/products/loadProductByCategotyTv"
        $("#productList").empty();
        loadProductsByCategoryAjax(url);
    });
    $(".laptopCategory").click(function () {
        var url="/products/loadProductByCategotyTel";
        $("#productList").empty();
        loadProductsByCategoryAjax(url);
    });
    function loadProductsByCategoryAjax(url) {

        $.ajax({
            type : "GET",
            contentType : "application/json",
            url :  url,

            success : function(result) {
                if(result.status == "Done"){

                   for (var i=0;i<result.data.length;i++){
                       f(i,result.data[i]);
                   }
                }
                console.log(result);
            },
            error : function(e) {
                alert("Error!")
                console.log("ERROR: ", e);
            }
        });
    }


    function f (i, product) {
        var $product=$( "#first" ).clone();
        $product.find('.title').html(product.name);
        $product.find('.description').html(product.description);
        $product.find('.st ').html("Our prise <strong>"+ product.price + "</strong>");
        $product.find('#picture').attr("src",product.uri);
        $product.css("display","initial");
        $product.appendTo( '#productList' );

    }
});