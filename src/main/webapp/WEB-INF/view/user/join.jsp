<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Join</title>
</head>
<body>
    <h1>회원가입</h1>
    <div>
        <form action="/user/join" method="post">
            <div><input type="text" name="uid" placeholder="user id"></div>
            <div><input type="password" name="upw" placeholder="user password"></div>
            <div><input type="text" name="nm" placeholder="user name"></div>
            <div>
                gender : <lable>woman <input type="radio" name="gender" value="0"></lable>
                        <lable>man <input type="radio" name="gender" value="1"></lable>
            </div>
            <div>
                <input type="submit" value="join">
            </div>
        </form>
    </div>
</body>
</html>
