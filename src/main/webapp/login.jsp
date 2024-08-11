<!DOCTYPE html>
<html lang="en">

<link rel="stylesheet" type="text/css" href="Static/css/login.css">
<div class="container" id="container">

    <div class="form-container sign-in-container">
        <form action="LoginController" method="post">
            <h1>Sign in</h1>
            <input type="email" placeholder="Email" name="email"/>
            <input type="password" placeholder="Password" name="password"/>
            <a href="#">Forgot your password?</a>
            <button type="submit">Sign In</button>
        </form>
    </div>
    <div class="overlay-container">
        <div class="overlay">
            <div class="overlay-panel overlay-left">
                <h1>Welcome Back!</h1>
                <p>To keep connected with us please login with your personal info</p>
                <button class="ghost" id="signIn">Sign In</button>
                <p>sdsd</p>
            </div>
            <div class="overlay-panel overlay-right">
                <h1>Hello, Manager!</h1>
                <p>To keep connected with us please login with your personal info</p>
            </div>
        </div>
    </div>
</div>
</html>


