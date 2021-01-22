<%-- 
    Document   : registration
    Created on : 22 Jan, 2021, 10:06:30 AM
    Author     : 182471F
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Registration</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    </head>
    <body>

        <h1>Registration Form</h1>
        <form name="register" action="register" method="post">

            <p>
                <font color="red">
                <%=session.getAttribute("message")==null?"":session.getAttribute("message")%><br/>
                </font>
            </p>
            
            
            <h2>Personal Info</h2>
            NRIC No*: <input type="text" name="nricNo" maxlength="9" required /><br/>
            Title*: <input type="text" name="title"  maxlength="16" required /><br/>
            Name*: <input type="text" name="name"    required /><br/>
            Email*: <input type="email" name="email" required /><br/>
            Home Address*: <input type="text" name="homeAdd" required /><br/>
            
            
            Passport No*: <input type="text" name="passportNo"  maxlength="15" required /><br/>
            Passport Expiry Date*: <input type="date" name="passportExpiry" required /><br/>
            Mobile No*: <input type="text" name="mobilePhone" required /><br/>
            
            <p>Billing address is required if x reason is needed</p>
            Billing Address: <input type="text" name="billingAdd"  />
            <br/>
            <br/>
            
            Date of Birth: <input type="date" name="dob"  /><br/>
            Office Phone No: <input type="text" name="officePhone"  /><br/>
            Home Phone No: <input type="text" name="homePhone"  /><br/>
            KrisFlyer Membership No: <input type="text"   name="krisFlyer"  /><br/>

            Password*: <input type="password" name="password"   maxlength="36" required /><br/>
            Confirm Password*: <input type="password" name="password2"  maxlength="36" required /><br/>
            <br>


            <input type="submit" value="Submit"/><br/>
        <a href="login.jsp">Have an account? Login here</a>
            <p>* - means field is compulsory </p>
        </form>









    </body>
</html>
