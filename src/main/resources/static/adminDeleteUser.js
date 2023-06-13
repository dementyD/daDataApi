$(document).ready(function () {
    $("#deleteBtn").click(function () {

        let user = {
            id: $('#idDelete').val(),
        }

        $.ajax({
            method: "DELETE",
            url: "admin/delete",
            async: false,
            contentType: "application/json",
            data: JSON.stringify(user),
            success: () => {
                location.reload()
            },
            error: function (error) {
                console.log(error)
            }
        })
    })
})