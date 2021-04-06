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
        <div class="row py-5">
            <div class="col-12 col-md-4 mx-auto form-box px-md-5 pb-5">
                <form action="welcome" method="POST">
                    <div class="row">
                        <div class="col-12 py-5 text-center">
                            <img src="/icons/3022339-hospital/png/hospital.png" height="80px" width="80px" class="img-fluid" />
                        </div>
                        <div class="col-12 py-3">
                            <label for="userName" class="form-label">User Name</label>
                            <input type="text" name="username" class="form-control" id="userName" placeholder="User Name">
                        </div>
                        <div class="col-12 py-3">
                            <label for="password" class="form-label">password</label>
                            <input type="password" name="password" class="form-control" id="password" placeholder="password">
                        </div>
                        
                        <div class="col-12 py-3 text-center">
                            <button class="btn btn-primary btn-lg" type="submit"  id="accountBtn">Sign In</button>
                        </div>
                        <div class="col-12 py-2 text-center">
                            <span>dont have account?<a href="signup" >Register Now</a></span>
                        </div>
                    </div>
                </form>
            </div>
        </div>
    </div>
</body>
</html>