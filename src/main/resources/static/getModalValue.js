function send(value) {
    $.ajax({
        method: "GET",
        url: "/admin/" + value,
        async: false,

        success: function (response) {
            $("#idEdit").val(response.id)
            $("#firstnameEdit").val(response.username)
            $("#lastnameEdit").val(response.lastname)
            $("#ageEdit").val(response.age)
            $("#emailEdit").val(response.email)

            $("#idDelete").val(response.id)
            $("#firstnameDelete").val(response.username)
            $("#lastnameDelete").val(response.lastname)
            $("#ageDelete").val(response.age)
            $("#emailDelete").val(response.email)

        }
    })
}