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
            <form action="validatepassword" method="post"> 
                Old Password: <input type="password" name="oldpassword" id="oldpassword" required><br>
                New Password: <input type="password" name="newpassword" id="newpassword" required><br>
                Confirm New Password: <input type="password" name="cfmnewpassword" id="cfmnewpassword" required><br><br>
                <input type="submit" value="Change Password">
            </form>
        </div>
        <br><hr><br>
        <a href="menu.jsp">Back to menu</a>
    </body>
</html>