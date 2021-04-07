<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="icon" href="/icons/3022339-hospital/png/hospital.png" type="image/png" sizes="16x16">
    <!--css files refrences-->
    <link rel="stylesheet" href="https://pro.fontawesome.com/releases/v5.10.0/css/all.css" integrity="sha384-AYmEC3Yw5cVb3ZcuHtOA93w35dYTsvhLPVnYs9eStHfGJvOvKxVfELGroGkvsg+p" crossorigin="anonymous"/>
    <link href="/bootstrap/css/bootstrap.min.css" rel="stylesheet" />
    <title>NanoCare</title>
</head>
<body>
       
           
                <!--********side_menu*************-->
                <nav class="nav side-menu flex-column pl-3" id="side-menu">
                <a class="nav-link active py-3" aria-current="page" href="welcome"><i class="fa fa-home"></i> welcome</a>
         		<sec:authorize url="/home">
				    <a class="nav-link active py-3" aria-current="page" href="home"><i class="fa fa-tachometer"></i> dashboard</a>
				   </sec:authorize>
				    
				
				 <sec:authorize url="/doctors">
				    <a class="nav-link py-3" href="doctors"><i class="fa fa-user-md"></i>    doctors</a>
				</sec:authorize>
				    
				
				<sec:authorize url="/departments">
				    <a class="nav-link py-3" href="departments"><i class="fa fa-building"></i>    departments</a>
				</sec:authorize>
				  
				
				
				<sec:authorize url="/patients">
				    <a class="nav-link py-3" href="patients"><i class="fa fa-user"></i>    patients</a>
				</sec:authorize>
				
				
				<sec:authorize url="/appointments">
				    <a class="nav-link py-3" href="appointments"><i class="fa fa-calendar"></i>    appointments </a>
				</sec:authorize>
                 
                  
                  
                  <sec:authorize url="/employees">
				    <a class="nav-link py-3" href="employees"><i class="fa fa-users"></i>    employees </a>
				</sec:authorize>
				
				     <sec:authorize url="/accounts">
				    <a class="nav-link py-3" href="accounts"><i class="fa fa-credit-card"></i>    accounts</a>
				</sec:authorize>
				
				<sec:authorize url="/settings">
				    <a class="nav-link py-3" href="settings"><i class="fa fa-tasks"></i>    settings</a>
				</sec:authorize>
				    
				
                  
                  
                  
                  
                </nav>
                <!--********end_sidemenu*************-->
           
         
          </body>
</html>