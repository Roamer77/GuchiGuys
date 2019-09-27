$(document).ready(function(){
    var productName=["Product 4","Product 5","Product 6"];
    var discription=["long product description 4","long product description 5","long product description 6"];
    var price=["$600","$750","$910"];
    var src=["/images/post4.jpg","/images/post5.jpg","/images/post6.jpg"];
    $(".loadBtn").click(function (){
        for (i=0;i<3;i++){
            var $product=$( "#first" ).clone();
            $product.find('.title').html(productName[i]);
            $product.find('.discription').html(discription[i]);
            $product.find('.st ').html("Our prise <strong>"+ price[i]+ "</strong>");
            $product.find('#picture').attr("src",src[i]);
            $product.appendTo( "#productList" );
        }


    });

});