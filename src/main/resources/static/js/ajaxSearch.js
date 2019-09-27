$(document ).ready(function () {
        $(".searchBtn").click(function (event) {
            event.preventDefault();
            $("#productList").empty();
            postSearch();
            }
        );
    function postSearch() {
        var searchData={
            name:$(".searchLine").val()
        };
        $.ajax({
            type: "GET",
            url:"/products/findProductByName",
            data:searchData,
            success:function (result) {
                for( var i=0;i<result.data.length;i++){
                    f(i,result.data[i]);

                }
                console.log("скрипт уже в function Search()");
                console.log(result);
            }

        });
    }
    function f (i, product) {

        var $product=$( "#first" ).clone(true);
        $product.find('.title').html(product.name);
        $product.find('.description').html(product.description);
        $product.find('.st ').html("Our prise <strong>"+ product.price + "</strong>");
        $product.find('#picture').attr("src",product.uri);
        $product.css("display","initial");
        $product.appendTo( '#productList' );
    }
});