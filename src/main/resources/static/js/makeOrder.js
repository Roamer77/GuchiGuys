$(document).ready(function () {
    var id=null;
    var prductName=null;
    $('.popup-open').click(function() {
         id=$(this).closest('.first').find('.productId').val();
         prductName=$(this).closest('.first').find('.title').text();
        $('.popup-fade').fadeIn();
        return false;
    });

    $('.popup-close').click(function() {
        $(this).parents('.popup-fade').fadeOut();
        return false;
    });
    $('#submitBtn').click(function () {
        makeOrder(id,prductName);
        $('.popup-fade').fadeOut();
        alert("Заказ оформлен");
        return false;
    });

    $(document).keydown(function(e) {
        if (e.keyCode === 27) {
            e.stopPropagation();
            $('.popup-fade').fadeOut();
        }
    });

    $('.popup-fade').click(function(e) {
        if ($(e.target).closest('.popup').length == 0) {
            $(this).fadeOut();
        }
    });

    function makeOrder(id,prdName) {
        var someData={
            name:$('[name="Username"]').val(),
            secondName:$('[name="UserSecondName"]').val(),
            address:$('[name="UserAddress"]').val(),
            productCounter:$('[name="ProductCounter"]').val(),
            productID:id,
            productName:prdName
        };
        $.ajax({
            type:"GET",
            url:"/cart/makeOrder",
            data:someData,
            success:function () {
                console.log("Я отправил всё что нужно");
                for (let i in someData) { console.log(someData[i]);}
            },
            error : function(e) {
                console.log("ERROR: ", e);
            }
        });
    }


});
