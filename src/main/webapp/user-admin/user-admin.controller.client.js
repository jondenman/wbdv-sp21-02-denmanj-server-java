var $usernameFld, $passwordFld;
var $firstNameFld, $lastNameFld, $roleFld;
var $deleteBtn, $updateBtn, $createBtn;
var $userRowTemplate, $tbody;
var userService = new AdminUserServiceClient();

var users = [
    // {username: "usrnme", firstname: "first", lastname: "last", role: "FACULTY"},
    // {username: "usrname", firstname: "frst", lastname: "lst", role: "STUDENT"},
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
                    <i id="${i}" class="fa-2x fa fa-times wbdv-delete-btn"></i>
                    <i id="${user._id}" class="fa-2x fas fa-pencil wbdv-select-btn"></i>
                </td>
            </tr>
            `)
    }
    $(".wbdv-delete-btn").click(deleteUser)
    $(".wbdv-select-btn").click(selectUser)
    console.log("ha")
}

function createUser() {
    var newUser = {
        username: $usernameFld.val(),
        firstname: $firstNameFld.val(),
        lastname: $lastNameFld.val(),
        role: $roleFld.val(),
        num: 1
    }

    return (
    userService.createUser(newUser)
        .then(function (actualUser) {
            users.push(actualUser)
            renderUsers(users)
        })
    )
}

function deleteUser(event) {
    var button = $(event.target)
    var index = button.attr("id")
    var id = users[index]._id
    userService.deleteUser(id)
        .then(function (status) {
            users.splice(index, 1)
            renderUsers(users)
        })
}

var selectedUser = null
function selectUser(event) {
    var id = $(event.target).attr("id")
    console.log(id)
    selectedUser = users.find(user => user._id === id)
    $usernameFld.val(selectedUser.username)
    $firstNameFld.val(selectedUser.firstname)
    $lastNameFld.val(selectedUser.lastname)
    $roleFld.val(selectedUser.role)
}

function updateUser() {
    selectedUser.username = $usernameFld.val()
    selectedUser.firstname = $firstNameFld.val()
    selectedUser.lastname = $lastNameFld.val()
    selectedUser.role = $roleFld.val()
    userService.updateUser(selectedUser._id, selectedUser)
        .then(status => {
            var index = users.findIndex(user => user._id === selectedUser._id)
            users[index] = selectedUser
            renderUsers(users)
        })
}

function init() {
    $userRowTemplate = $(".wbdv-tbody")
    $createBtn = $(".wbdv-create-btn")
    $updateBtn = $(".wbdv-update-btn")

    $usernameFld = $(".wbdv-username-fld")
    $firstNameFld = $(".wbdv-firstname-fld")
    $lastNameFld = $(".wbdv-lastname-fld")
    $roleFld = $(".wbdv-role-fld")

    renderUsers(users)


    $updateBtn.click(updateUser)
    $createBtn.click(createUser)

    userService.findAllUsers().then(function (actualUsers) {
        users = actualUsers
        renderUsers(users)
    })
}
$(init)