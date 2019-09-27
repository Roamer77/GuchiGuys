
$( document ).ready(function() {
    var packCounter=1;

    // GET REQUEST
    $(".loadBtn").click(function(event){
        event.preventDefault();
        ajaxGet();
        packCounter++;
    });
    //добавить  в карзину
    $(".AddToCartBtn").click(function (event) {
        event.preventDefault();
        addToCart($(this).closest('.first').find('.productId').val()); //нужно посмотреть ещё раз

    });
    $(".deleteFromCart").click(function (event) {
        event.preventDefault();
        deleteFromCart($(this).closest('.first').find('.productId').val());
    });
    //загружаем продукты для стартовой страницы
    $.ajax({
        type : "GET",
        url : "/products/loadMore",
        success: function(result){
            var custList = "";
            for( var i=0;i<result.data.content.length;i++){
                f(i,result.data.content[i]);
            }
            console.log("скрипт уже в function");
            console.log(result);
        },
        error : function(e) {
            console.log("ERROR: ", e);
        }
    });
    // DO GET
    function ajaxGet(){
        $.ajax({
            type : "GET",
            url : "/products/loadMore",
            success: function(result){


                var custList = "";

                for( var i=0;i<result.data.content.length;i++){
                    f(i,result.data.content[i]);
                }
                console.log("скрипт уже в function");
                console.log(result);

            },
            error : function(e) {
                console.log("ERROR: ", e);
            }
        });
    }

    function f (i, product) {

            var $product=$( "#first" ).clone(true);
            $product.find('.title').html(product.name);
            $product.find('.description').html(product.description);
            $product.find('.st ').html("Цена <strong>"+ product.price + "</strong>");
            $product.find('#picture').attr("src",product.uri);
            $product.find('.productId').val(product.id);
            $product.css("display","initial");
            $product.appendTo( '#productList' );
    }
    function addToCart (id) {

        console.log("Значение из id="+id);
        var productID={
            id:id
        };
        $.ajax({
            type:"GET",
            url:"/cart/addToProductToCart",
            data:productID,
            success:function () {
                console.log("Я отправил всё что нужно ");
                console.log(productID.id);
            },
            error : function(e) {
                console.log("ERROR: ", e);
            }
        });
        console.log(productID.id + " и  "+ productID  );
    }
    function deleteFromCart(id) {
        console.log("Значение из id="+id);
        var productID={
            id:id
        };
        $.ajax({
            type:"GET",
            url:"/cart/deleteFromCart",
            data:productID,
            success:function () {
                console.log("(Скрипт на удаление из карзины )Я отправил всё что нужно ");
                console.log(productID.id);
            },
            error : function(e) {
                console.log("ERROR: ", e);
            }
        });
        console.log(productID.id + " и  "+ productID  );
        $(id).closest('.first').empty();
        alert("Продукт был удалён c id:"+id);
        location.reload();
        console.log("Я удалил элемент только что ");

    }

    $.ajax({
        type:"GET",
        url:"/main/checkUserName",
        success:function (result) {
          console.log("Админ :"+result.data);
          if (result.data==="admin"){
              console.log("Это админ !!");
              $('.OrderButton').css("display","block");
          }
          if(result.data==="anonymousUser"){
              $('#ProductCounter').css("display","none");
          }
        },
        error : function(e) {
            console.log("ERROR: ", e);
        }
    });
    checkProductCounterInCart();
    //функия нужна для того чтобы выводить на гланую страницу сколько у пользователя товаров в карзине
    function checkProductCounterInCart() {
        $.ajax({
            type:"GET",
            url:"/cart/checkProductCounterInCart",
            success:function (result) {
                $('#ProductCounter').text("Товаров в карзине: "+result.data);
            },
            error : function(e) {
                console.log("ERROR: ", e);
            }
        });
    }

});

