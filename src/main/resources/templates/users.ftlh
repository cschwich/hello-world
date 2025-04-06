<html>
<head>
    <title>User Store</title>
    <link rel="stylesheet" href="/style.css">
</head>
<body>
    <h1>User Store</h1>
    <#list users>
        <table id="users">
            <thead>
                <tr>
                    <th>Id</th>
                    <th>First name</th>
                    <th>Last name</th>
                    <th>Action</th>
                </tr>
            </thead>
            <tbody>
                <#items as user>
                    <tr>
                        <td>${user.id()}</td>
                        <td>${user.firstName()}</td>
                        <td>${user.lastName()}</td>
                        <td>
                            <a href="users/edit/${user.id()}">edit</a>
                            |
                            <a href="users/delete/${user.id()}">delete</a>
                        </td>
                    </tr>
                </#items>
            </tbody>
            <tfoot>
                <tr><td colspan="4">${users?size} users</td></tr>
            </tfoot>
        </table>
    <#else>
        <p>No users defined.</p>
    </#list>
    <p><a href="/users/add"><button type="button">Add user</button></a></p>
    <p><a href="/">Back to Home!</a></p>
</body>
</html>
