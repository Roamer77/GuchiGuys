$(document ).ready(function () {

    $.ajax({
        type:"GET",
        url:"/cart/getCartFoCurrentUser",
        success:function (result) {
            for( var i=0;i<result.data.length;i++){
                f(i,result.data[i]);
                console.log("Первй обектр нарисован ");
            }
            console.log("скрипт уже в function в скрипте CartInfo");
            console.log(result);
        },
        error:function(e) {
            console.log("ERROR: ", e);
        }
    });

    function f (i, product) {
        var $product=$( "#first" ).clone(true);
        $product.find('.title').html(product.name);
        $product.find('.description').html(product.description);
        $product.find('.st ').html("Our prise <strong>"+ product.price + "</strong>");
        $product.find('#picture').attr("src",product.uri);
        $product.find('.productId').val(product.id);
        $product.find('.productsInCart').text("Товаров добалено:"+product.productCounter);
        $product.css("display","initial");
        $product.appendTo( '#secret' );
    }
});