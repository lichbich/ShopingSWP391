<%-- 
    Document   : register
    Created on : Aug 9, 2024, 11:14:42 AM
    Author     : vinh
--%>

<%@page contentType="text/html" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Poppins:ital,wght@0,100;0,200;0,300;0,400;0,500;0,600;0,700;0,800;0,900;1,100;1,200;1,300;1,400;1,500;1,600;1,700;1,800;1,900&family=Roboto:ital,wght@0,100;0,300;0,400;0,500;0,700;0,900;1,100;1,300;1,400;1,500;1,700;1,900&display=swap"
          rel="stylesheet">
    <link rel="stylesheet" type="text/css" href="static/css/register.css">

    <title>Register</title>

</head>
<body>

<h2>Join with us!</h2>
<div class="container right-panel-active" id="container">
    <div class="form-container sign-up-container">
        <form method="post" class="form" action="register">
            <h3>Create Account</h3>
            <div class="column">
                <input name="firstname" type="text" value="${param.firstname != null ? param.firstname : ''}" placeholder="Firstname"/>
                <input name="lastname" type="text" value="${param.lastname != null ? param.lastname : ''}" placeholder="Lastname"/>
            </div>


            <input name="email" type="text" value="${param.email != null ? param.email : ''}" placeholder="Email"/>
            <input name="phonenumber" type="text" value="${param.phonenumber != null ? param.phonenumber : ''}" placeholder="phone number"/>
            <input name="dob" type="date" value="${param.dob != null ? param.dob : ''}">
            <div class="gender-box">

                <div class="gender-option">
                    <div class="gender">
                        <input type="radio" id="check-male" name="gender" value="male" checked/>
                        <label for="check-male">Male</label>
                    </div>
                    <div class="gender">
                        <input type="radio" id="check-female" name="gender" value="female"/>
                        <label for="check-female">Female</label>
                    </div>
                    <div class="gender">
                        <input type="radio" id="check-other" name="gender" value="other"/>
                        <label for="check-other">Prefer not to say</label>
                    </div>
                </div>

            </div>
            <input name="address" type="text" value="${param.address != null ? param.address : ''}" placeholder="Address"/>
            <input name="password" type="password" placeholder="Password"/>
            <input name="re-password" type="password" placeholder="Re-Password"/>
            <c:if test="${not empty error}">
                <p style="color:red; font-size: 12px; margin: 10px 0 10px;">${error}</p>
            </c:if>
            <button type="submit">Sign Up</button>


        </form>
    </div>

    <div class="overlay-container">
        <div class="overlay">
            <div class="overlay-panel overlay-left">
                <h1>Welcome Back!</h1>
                <p>To keep connected with us please login with your personal info</p>
                <button class="ghost" id="signIn">Sign In</button>
            </div>

        </div>
    </div>
</div>
</body>
</html>
