<%-- 
    Document   : register
    Created on : Aug 9, 2024, 11:14:42 AM
    Author     : vinh
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="preconnect" href="https://fonts.googleapis.com">
        <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
        <link href="https://fonts.googleapis.com/css2?family=Poppins:ital,wght@0,100;0,200;0,300;0,400;0,500;0,600;0,700;0,800;0,900;1,100;1,200;1,300;1,400;1,500;1,600;1,700;1,800;1,900&family=Roboto:ital,wght@0,100;0,300;0,400;0,500;0,700;0,900;1,100;1,300;1,400;1,500;1,700;1,900&display=swap" rel="stylesheet">
        <style>
            *{
                font-family: "Poppins", sans-serif;
                margin: 0;
                padding: 0;
                box-sizing: border-box;
            }

            body{
                min-height: 100vh;
                display: flex;
                align-items: center;
                justify-content: center;
                padding: 10px;
                /*                background: rgb(228, 44, 117);*/
                backdrop-filter: blur( 7.5px );
                -webkit-backdrop-filter: blur( 7.5px );
                background-image: url('static/images/nike.jpg');
                background-repeat: repeat;
                background-attachment: fixed;
                background-size: auto;


            }

            




            .container{
                position: relative;
                max-width: 700px;
                width: 100%;
                background: #fff;
                padding: 25px;
                border-radius: 8px;
                box-shadow: 0 0 15px rgba(0, 0, 0, 0.1);
            }

            .container header{
                font-size: 1.5rem;
                color: #333;
                font-weight: 500;
                text-align: center;
            }

            .container .form{
                margin-top:30px;
            }

            .form .input-box{
                width:100%;
                margin-top: 20px;
            }

            .name-box label{
                color: #333;
            }

            .form .input-box input{
                position: relative;
                height: 50px;
                width: 100%;
                outline: none;
                font-size: 1rem;
                color: #707070;
                margin-top: 8px;
                border: 1px solid #ddd;
                border-radius: 6px;
                padding: 0 15px;
            }

            .input-box input:focus{
                box-shadow: 0 2px 0 rgba(0, 0, 0, 0.1);
            }


            .form .column{
                display: flex;
                column-gap: 15px;
            }

            .form .gender-box{
                margin-top: 20px;
            }

            .gender-box h3{
                color: #333;
                font-size: 1rem;
                font-weight: 400;
                margin-bottom: 8px;
            }

            .form :where(.gender-option, .gender) {
                display: flex;
                align-items: center;
                column-gap: 50px;
                flex-wrap: wrap;
            }
            .form .gender{
                column-gap: 5px;
            }

            .gender input{
                accent-color: rgb(228, 44, 117);
            }
            .form :where(.gender input, .gender label){
                cursor: pointer;
            }



            .form button{
                height: 50px;
                width: 100%;
                color: #fff;
                font-size: 1rem;
                border: none;
                margin-top: 30px;
                cursor: pointer;
                border-radius: 6px;
                font-weight: 400;
                transition: all 0.2s ease;
                background-color: rgb(228, 44, 117);
            }
            .form button:hover{
                background-color: rgb(230, 76, 138);
            }

            .form .text-center{
                margin-top: 5px;
                text-align: center;
            }
            .form .text-center a{
                color: rgb(228, 44, 117);
            }

            /* Responsive */
            @media screen and (max-width: 500px){
                .form .column{
                    flex-wrap: wrap;
                }

                .form :where(.gender-option, .gender){
                    row-gap: 15px;
                }
            }


        </style>
        <title>Register</title>

    </head>
    <body>

        


        <section class="container">
            <header>Join with us!</header>

            <form method="" action="" class="form">
                <div class="input-box">
                    <label>First Name </label>
                    <input type ="text" placeholder="Enter your firstname" required/>
                </div>
                <div class="input-box">
                    <label>Last Name </label>
                    <input type ="text" placeholder="Enter your lastname" required/>
                </div>
                <div class="input-box">
                    <label>Email Address </label>
                    <input type ="text" placeholder="Enter your email" required/>
                </div>
                <div class="column">
                    <div class="input-box">
                        <label>Phone </label>
                        <input type ="number" placeholder="Enter phone number" required/>
                    </div>
                    <div class="input-box">
                        <label>Birth Date </label>
                        <input type ="date" placeholder="Enter birth date" required/>
                    </div>
                </div>

                <div class="gender-box">
                    <h3>Gender</h3>
                    <div class="gender-option">
                        <div class="gender">
                            <input type="radio" id="check-male" name="gender" checked/>
                            <label for="check-male">Male</label>
                        </div>
                        <div class="gender">
                            <input type="radio" id="check-female" name="gender"/>
                            <label for="check-female">Female</label>
                        </div>
                        <div class="gender">
                            <input type="radio" id="check-other" name="gender"/>
                            <label for="check-other">Prefer not to say</label>
                        </div>
                    </div>

                </div>

                <div class="input-box">
                    <label>Address </label>
                    <input type ="text" placeholder="Enter your address" required/>
                </div>

                <div class="column">
                    <div class="input-box">
                        <label>Password </label>
                        <input type ="text" placeholder="Password" required/>                    

                    </div>
                    <div class="input-box">
                        <label>Re-Password </label>
                        <input type ="text" placeholder="Enter password again" required/>
                    </div>
                </div>

                <button>Register</button>

                <p class="text-center">Have an account? <a href="">Log In</a> </p>

            </form>

        </section>


    </body>
</html>
