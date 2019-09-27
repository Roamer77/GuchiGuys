$(document).ready(function () {
    $('.details-button').click(function (event ) {
        let target=event.target;
        showUpDown(target);
    });
});

function showUpDown(target) {
    $(target).find('.description').slideToggle(200);
}