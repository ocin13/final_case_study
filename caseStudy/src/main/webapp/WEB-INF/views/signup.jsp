<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <!--css files refrences-->
    <link rel="stylesheet" href="https://pro.fontawesome.com/releases/v5.10.0/css/all.css" integrity="sha384-AYmEC3Yw5cVb3ZcuHtOA93w35dYTsvhLPVnYs9eStHfGJvOvKxVfELGroGkvsg+p" crossorigin="anonymous"/>
    <link href="/bootstrap/css/bootstrap.min.css" rel="stylesheet" />
    <link href="/css/account.css" rel="stylesheet" />
    <title>NanoCare</title>
</head>
<body>
    <div class="container">
        <div class="row py-3">
            <div class="col-12 col-md-5 mx-auto form-box px-md-5 pb-5">
                <form action="signup" method="POST">
                    <div class="row">
                        <div class="col-12 py-4 text-center">
                            <img src="/icons/3022339-hospital/png/hospital.png" height="80px" width="80px" class="img-fluid" />
                        </div>
                        <h3>${message }</h3>
                        <div class="col-12 py-2">
                            <label for="userNameRegister" class="form-label">User Name</label>
                            <input type="text" name="userName" class="form-control" id="userNameRegister" placeholder="User Name">
                       		<p class="text-danger">${nameError }</p>
                        </div>
                        <div class="col-12 py-2">
                            <label for="useremailRegister" class="form-label">email</label>
                            <input type="email" name="email" class="form-control" id="useremailRegister" placeholder="email@example.com">
                       		<p class="text-danger">${emailError }</p>
                        </div>
                        <div class="col-12 py-2">
                            <label for="passwordRegister" class="form-label">password</label>
                            <input type="password" name="password" class="form-control" id="passwordRegister" placeholder="password">
                        	<p class="text-danger">${passError }</p>
                        </div>
                        <div class="col-12 py-2">
                            <label for="passwordConfirmRegister" class="form-label">password confirmation</label>
                            <input type="password" name="passCon" class="form-control" id="passwordConfirmRegister" placeholder="password">
                        	<p class="text-danger">${conPassError }</p>
                        </div>
                        <div class="col-12 py-2">
                                <input class="form-check-input" name="active" type="checkbox" value="true" id="acceptTermsCheckBox">
                                <label class="form-check-label" for="acceptTermsCheckBox">
                                    I have read and agree the Terms & Conditions
                                </label>
                        </div>
                        <div class="col-12 py-3 text-center">
                            <button class="btn btn-primary btn-lg" type="submit" id="accountBtn">Sign Up</button>
                        </div>
                        <div class="col-12 py-2 text-center">
                            <span>you already have an account?<a href="login" > sign in</a></span>
                        </div>
                    </div>
                </form>
            </div>
        </div>
    </div>
</body>
</html>