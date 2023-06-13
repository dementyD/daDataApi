$.ajax({
    method: 'GET',
    url: "/adminGetAll",
    async: false,
    success: function (response) {
        for (let i = 0; i < response.length; i++) {

            let strRoles = '';
            for (let j = 0; j < response[i].roles.length; j++) {
                strRoles += response[i].roles[j] + " ";
            }
            let ava = response[i].avatar;

            let str =
                "<tr>" +
                "<td> <img src=\"" + ava + "\"  class=\"rounded-circle\" style=\"width: 30px;\" /> </td>" +
                "<td>" + response[i].id + "</td>" +
                "<td>" + response[i].username + "</td>" +
                "<td>" + response[i].lastname + "</td>" +
                "<td>" + response[i].age + "</td>" +
                "<td>" + response[i].email + "</td>" +
                "<td>" + response[i].postalAddress + "</td>" +
                "<td>" + strRoles + "</td>" +
                "<td>" + "<button class=\"btn btn-info\" data-toggle=\"modal\" data-target=\"#edit\"  onclick='send(" + response[i].id + ")'>Edit</button>" + "</td>" +
                "<td>" + "<button class=\"btn btn-danger\" data-toggle=\"modal\" data-target=\"#delete\" onclick='send(" + response[i].id + ")'>Delete</button>" + "</td>" +
                "</tr>";

            $("#allUser").append(str)

        }

    },
    error: function (error) {
        console.log(error);
    }
})