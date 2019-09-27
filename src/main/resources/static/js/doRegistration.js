$(document).ready(function () {

    $('#submitButton').click(function () {
        sendInfo();
        getInfo();
    });
    function getInfo() {
        alert("Вы успешно зарегестрировались");
       $("#registrationForm").find('#login').val('');
       $("#registrationForm").find('#password').val('');
        $("#registrationForm").find('#email').val('');
    }
    function  sendInfo() {
        var info={
            login:$('#login').val(),
            password:$('#password').val(),
            email:$('#email').val()
        };
        $.ajax({
            type:"POST",
            url:"/main/registration",
            data:info,
            dataType:"json",
            success:function () {
                console.log("я отправил");
            },
            error:function(e) {
                console.log("ERROR: ", e);
            }
        });
    }
});