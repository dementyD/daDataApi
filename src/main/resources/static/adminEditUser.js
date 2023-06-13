$(document).ready(function () {

    $('#editBtn').click(function (event) {
        event.preventDefault();
        let user = {
            id: $('#idEdit').val(),
            username: $('#firstnameEdit').val(),
            lastname: $('#lastnameEdit').val(),
            age: $('#ageEdit').val(),
            email: $('#emailEdit').val(),
            password: $('#passwordEdit').val(),
            roles: [$('#roleEdit').val()],
        }
        $.ajax({
            method: "PUT",
            url: "admin/edit",
            async: false,
            contentType: "application/json",
            data: JSON.stringify(user),
            success: () => {
                location.reload()
            },
            error: function (error) {
                console.log(error);
                let strErrorAge = "";
                let strErrorEmail = "";

                for (let i = 0; i < error.responseJSON.violations.length; i++) {
                    if (error.responseJSON.violations[i].fieldName == "age") {
                        strErrorAge += error.responseJSON.violations[i].message;
                    }
                    if (error.responseJSON.violations[i].fieldName == "email") {
                        strErrorEmail += error.responseJSON.violations[i].message;
                    }
                }
                $("#errorAge").empty();
                $("#errorAge").append(strErrorAge);
                $("#errorEmail").empty();
                $("#errorEmail").append(strErrorEmail);
            }
        })
    })
})
