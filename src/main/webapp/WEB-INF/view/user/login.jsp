<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Login</title>
    <style>
        .position {height: 100%; display: flex; flex-direction: column; justify-content: center; align-items: center; }
        .err {color: red;}
    </style>
</head>
<body class="position">
    <h1>로그인</h1>
    <div class="err">${err}</div>
    <div>
        <form action="/user/login" method="post">
            <div><input type="text" name="uid" placeholder="user id" value="gang"></div>
            <div><input type="password" name="upw" placeholder="user password" value="1111"></div>
            <div>
                <input type="submit" value="login">
            </div>
        </form>
        <div>
            <a href="/user/join"><input type="button" value="join"></a>
        </div>
    </div>
</body>
</html>
