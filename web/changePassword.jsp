<%@page import="java.util.List"%>
<%@page import="sg.edu.nyp.entities.Customer"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Change Password</title>
    </head>
    <body>
        <h1>Change your password</h1><hr><br>
        <div class="changepassword">
            <form action="changepassword" method="post">
                Old Password: <input type="text" name="oldpassword" id="oldpassword"><br>
                New Password: <input type="text" name="newpassword" id="newpassword"><br>
                Confirm New Password: <input type="text" name="cfmnewpassword" id="cfmnewpassword"><br><br>
                <input type="submit" value="Change Password">
            </form>
        </div>
        <br><hr><br>
        <a href="index.html">Back to index</a>
    </body>
</html>