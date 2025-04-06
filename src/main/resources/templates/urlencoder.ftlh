<html>
<head>
    <title>Our URLEncoder</title>
    <link rel="stylesheet" href="/style.css">
</head>
<body>
    <h1>URLEncoder</h1>
    <form method="POST">
        <p>
            <label for="input">Input</label>
            <br>
            <textarea name="input" id="input">${input!}</textarea>
        </p>
        <p>
            <input type="submit" name="action" value="Encode">
            <input type="submit" name="action" value="Decode">
            <input type="submit" name="action" value="Swap">
            <input type="submit" name="action" value="Clear">
        </p>
        <p>
            <label for="input">Output</label>
            <br>
            <textarea name="output" id="output" readonly>${output!}</textarea>
        </p>
    </form>
    <p><a href="/">Back to Home!</a></p>
</body>
</html>
