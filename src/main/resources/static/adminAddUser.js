$(document).ready(function () {
    $('#formNew').on('submit', function (event) {
        event.preventDefault();

        let user = {
            username: $('#firstname').val(),
            lastname: $('#lastname').val(),
            age: $('#age').val(),
            email: $('#email').val(),
            password: $('#password').val(),
            roles: [$('#myselect').val()],
            coords: globalCoords,
        }
        $.ajax({
            method: 'POST',
            url: "/admin",
            async: false,
            contentType: "application/json",
            data: JSON.stringify(user),
            success: () => {
                location.reload()
            },
            error: function (error) {
                console.log(error);
                let strErrorAge = "";

                for (let i = 0; i < error.responseJSON.violations.length; i++) {
                    (error.responseJSON.violations[i].fieldName == "age")
                    strErrorAge += error.responseJSON.violations[i].message;
                }
                $("#errorAgeFormNew").empty();
                $("#errorAgeFormNew").append(strErrorAge);
            }
        });
    });
});