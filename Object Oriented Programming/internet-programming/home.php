<?php
session_start();
if (!isset($_SESSION["username"])) {
    header("Location: index.php");
}
?>
<!DOCTYPE html>
<html>

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Homepage</title>
</head>

<body>
    This is the home page<br>
    <form action="home.php" method="post">
        <input type="submit" name="logout" value="logout">
    </form>
</body>

</html>
<?php


$_SESSION["username"] = "Benir";
$_SESSION["password"] = "Benir";
if (isset($_POST["logout"])) {
    session_destroy();
    header("Location: index.php");
}
