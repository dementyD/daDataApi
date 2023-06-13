$.ajax({
    method: 'GET',
    url: "/getUser",
    async: false,
    success: function (response) {
        let strRoles = '';
        for (let i = 0; i < response.roles.length; i++) {
            strRoles += response.roles[i] + " ";
        }
        let ava = response.avatar;
        let str =
            "<tr>" +
            "<td> <img src=\"" + ava + "\"  class=\"rounded-circle\" style=\"width: 30px;\" /> </td>" +
            "<td>" + response.id + "</td>" +
            "<td>" + response.username + "</td>" +
            "<td>" + response.lastname + "</td>" +
            "<td>" + response.age + "</td>" +
            "<td>" + response.email + "</td>" +
            "<td>" + response.postalAddress + "</td>" +
            "<td>" + strRoles + "</td>" +
            "</tr>";
        $("#allUsers").append(str)
    },
    error: function (error) {
        console.log(error);
    }
})
