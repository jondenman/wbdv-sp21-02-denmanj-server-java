var $usernameFld, $passwordFld;
var $firstNameFld, $lastNameFld, $roleFld;
var $removeBtn, $editBtn, $createBtn;
var $userRowTemplate, $tbody;
//var userService = new AdminUserServiceClient();

var users = [
    {username: "usrnme", firstname: "first", lastname: "last", role: "FACULTY"},
    {username: "usrname", firstname: "frst", lastname: "lst", role: "STUDENT"},
]

function renderUsers(users) {
    $userRowTemplate.empty()
    for(var i=0; i<users.length; i++) {
        var user = users[i]
        $userRowTemplate
            .prepend(`
            <tr>
                <td>${user.username}</td>
                <td></td>
                <td>${user.firstname}</td>
                <td>${user.lastname}</td>
                <td>${user.role}</td>
                <td class="pull-right" style="white-space: nowrap">
                    <button id="${i} class="wbdv-delete-btn">Delete</button>
                    <button class="wbdv-select-btn">Select</button>
                </td>
            </tr>
            `)
    }
    // $(".wbdv-delete-btn").click(deleteUser)
    // $(".wbdv-select-btn").click(selectUser)
}

function main() {
    $userRowTemplate = $(".wbdv-tbody")

    renderUsers(users)
}
$(main)