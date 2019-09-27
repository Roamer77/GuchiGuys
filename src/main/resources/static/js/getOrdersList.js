$(document).ready(function () {
    $.ajax({
        type:"GET",
        url:"/admin/getListOfOrders",
        success:function (result) {
            for (var i=0;i<result.data.length;i++){
                loadOrders(i,result.data[i]);
            }
        },
        error : function(e) {
            console.log("ERROR: ", e);
        }
    });

    function loadOrders(i,orders) {
        var ordersExample=$('#orderExample').clone(true);
        ordersExample.find('#customerName').text("Customer name: "+orders.customerName);
        ordersExample.find('#customerSecondName').text("Customer second name: "+orders.customerSecondName);
        ordersExample.find('#customerAddress').text("Customer address: "+orders.customerAddress);
        ordersExample.find('#productId').text("Product Id: "+orders.productId);
        ordersExample.find('#productName').text("Product name: "+orders.productName );
        ordersExample.find('#amountOfProducts').text("Amount Of Products: "+orders.amountOfProducts);
        ordersExample.css('display','block');
        ordersExample.appendTo('#appendToMe');
    }
});
