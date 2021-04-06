<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="icon" href="/icons/3022339-hospital/png/hospital.png" type="image/png" sizes="16x16">
    <!--css files refrences-->
    <link rel="stylesheet" href="https://pro.fontawesome.com/releases/v5.10.0/css/all.css" integrity="sha384-AYmEC3Yw5cVb3ZcuHtOA93w35dYTsvhLPVnYs9eStHfGJvOvKxVfELGroGkvsg+p" crossorigin="anonymous"/>
    <link href="/bootstrap/css/bootstrap.min.css" rel="stylesheet" />
    <link href="/css/style.css" rel="stylesheet" />
    <title>NanoCare</title>
</head>
<body>
        <!--********navbar_starts***********-->
        <nav class="navbar navbar-expand-lg navbar-dark bg-dark sticky-top mx-0">
            <div class="container-fluid px-md-5">
              <a class="navbar-brand" href="index"><img src="/icons/3022339-hospital/png/hospital.png" width="50px" height="50px"/> <strong>NanoCare</strong></a>
              <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#mainNavbar" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
              </button>
              <div class="collapse navbar-collapse" id="mainNavbar">
                <ul class="pt-2">
                  <li><a href="#" id="sideMenuBtn"><i class="fa fa-bars"></i></a></li>
                </ul>
                <ul class="navbar-nav">
                  <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-bs-toggle="dropdown" aria-expanded="false">
                      <img src="/uploads/${profile.getFileName()}" width="25px" height="25px" style="border-radius: 50%;"/>
                      <c:out value="${pageContext.request.remoteUser}"/>
                    </a>
                    <ul class="dropdown-menu" aria-labelledby="navbarDropdown">
                      <li><a style="color:black;" class="dropdown-item" href="profile">my profile</a></li>
                      <li><a style="color:black;" class="dropdown-item" href="profile">edit profile</a></li>
                      <li><hr class="dropdown-divider"></li>
                      <li><a style="color:black;" class="dropdown-item" href="logout">log out</a></li>
                    </ul>
                  </li>
                </ul>
              </div>
            </div>
          </nav>
        <!--********navbar_ends*************-->
    </body>
</html>