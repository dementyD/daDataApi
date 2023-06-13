
$(document).ready(function () {
    $('#registerBtn').click(function () {

        let user = {
            id: $('#idEdit').val(),
            username: $('#name').val(),
            lastname: $('#lastName').val(),
            age: $('#age').val(),
            email: $('#email').val(),
            password: $('#password').val(),
            roles: [$('#role').val()],
            coords: globalCoords,
        }
        $.ajax({
            method: "POST",
            url: "/register",
            async: false,
            contentType: "application/json",
            data: JSON.stringify(user),
            success: function () {
                $(document).ready(function () {
                    $(location).prop("href", "http://localhost:8080/login");
                });
            },
            error: function (error) {
                console.log(error);
                let strErrorAge = "";

                for (let i = 0; i < error.responseJSON.violations.length; i++) {
                    (error.responseJSON.violations[i].fieldName == "age")
                    strErrorAge += error.responseJSON.violations[i].message;
                }
                $("#errorAgeRegister").empty();
                $("#errorAgeRegister").append(strErrorAge);
            }
        })
    })
})