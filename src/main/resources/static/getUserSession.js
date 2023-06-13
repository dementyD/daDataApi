$.ajax({
    method: 'GET',
    url: "/getUserSession",
    async: false,
    success: function (response) {
        let strRoles = '';
        for (let i = 0; i < response.roles.length; i++) {
            strRoles += response.roles[i] + " ";
        }

        let str =
            "<b>" + response.email + "</b>" +
            " with roles: " +
            strRoles;

        $("#headerInfo").append(str)

    },
    error: function (error) {
        console.log(error);
    }
})