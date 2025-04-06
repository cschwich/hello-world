<html>
<head>
    <title>User Store: ${action?capitalize} User</title>
    <link rel="stylesheet" href="/style.css">
</head>
<body>
    <h1>User Store: ${action?capitalize} User</h1>
    <form method="post">
        <p>
            <label for="firstName">First name</label><br>
            <input name="firstName" id="firstName" value="${firstName!}" autofocus>
        </p>
        <p>
            <label for="lastName">Last name</label><br>
            <input name="lastName" id="lastName" value="${lastName!}">
        </p>
        <p>
            <input type="submit" value="Submit">
            <a href="/users"><button type="button">Cancel</button></a>
        </p>
    </form>
</body>
</html>
