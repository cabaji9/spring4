<html>
<head></head>

<body>
<h1>Login</h1>

<form name='f' action="login?${_csrf.parameterName}=${_csrf.token}" method='POST'>

    <table>
        <tr>
            <td>User:</td>
            <td><input type='text' name='username' value=''></td>
        </tr>
        <tr>
            <td>Password:</td>
            <td><input type='password' name='password' /></td>
        </tr>
        <tr>
            <td>
                <input id="remember_me" name="_spring_security_remember_me" type="checkbox"/>
                <label for="remember_me" class="inline">Remember me</label>

            </td>

        </tr>
        <tr>
            <td><input name="submit" type="submit" value="submit" /></td>
        </tr>
    </table>

</form>

</body>
</html>