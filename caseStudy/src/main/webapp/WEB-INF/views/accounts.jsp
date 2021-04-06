<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="icon" href="../../shared/icons/3022339-hospital/png/hospital.png" type="image/png" sizes="16x16">
    <!--css files refrences-->
    <link rel="stylesheet" href="https://pro.fontawesome.com/releases/v5.10.0/css/all.css" integrity="sha384-AYmEC3Yw5cVb3ZcuHtOA93w35dYTsvhLPVnYs9eStHfGJvOvKxVfELGroGkvsg+p" crossorigin="anonymous"/>
    <link href="/bootstrap/css/bootstrap.min.css" rel="stylesheet" />
    <link href="/css/accounts.css" rel="stylesheet" />
    <link href="/css/navbar.css" rel="stylesheet" />
    <title>NanoCare</title>
</head>
<body>
    <div class="container-fluid mx-0 px-0">
        <!--********navbar_starts***********-->
       	<jsp:include page="navbar.jsp"></jsp:include>
        <!--********navbar_ends*************-->
        <div class="row">
            <div class="col-8 col-md-2 py-3" id="side-menu-box">
                <!--********side_menu*************-->
               <jsp:include page="side_navbar.jsp"></jsp:include>
                <!--********end_sidemenu*************-->
            </div>
            <div class="col-12 col-md-10 py-5 dashboard">
              <div class="row mb-5">
                <div class="col-6 col-md-10">
                  <h3>accounts</h3>
                </div>
                <div class="col-6 col-md-2 ">
                  <button class="btn btn-success py-2 px-3" id="backPayBtn" onclick="window.location='home'"><i class="fa fa-reply"></i> Go Back</button>
                </div>
              </div>
              <div class="row">
              		<c:if test="${accounts.isEmpty() == false }">
              		<table class="table">
	  				 <thead>
					    <tr>
					      <th scope="col">#</th>
					      <th scope="col">user name</th>
					      <th scope="col">Email</th>
					      <th scope="col">Password</th>
					          <th scope="col">role</th>
					   
					  
					    </tr>
					  </thead>
					  <tbody>
					    <c:forEach items="${accounts}" var="user">
					    	<tr>
						      <th scope="row">${user.id }</th>
						      <td>${user.userName}</td>
						      <td>${user.email}</td>
						      <td>${user.password }</td>
						      <td>${user.roles }</td>
						    </tr>
					    </c:forEach>
					  </tbody>
					</table>
              	</c:if>
              </div>
            </div>
        </div>  
        

    </div>
    <!--bootstrap js-->
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.6.0/dist/umd/popper.min.js" integrity="sha384-KsvD1yqQ1/1+IA7gi3P0tyJcT3vR+NdBTt13hSJ2lnve8agRGXTTyNaBYmCR/Nwi" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta2/dist/js/bootstrap.min.js" integrity="sha384-nsg8ua9HAw1y0W1btsyWgBklPnCUAFLuTMS2G72MMONqmOymq585AcH49TLBQObG" crossorigin="anonymous"></script>
    <!--chart maker-->
    <script src="https://cdn.jsdelivr.net/npm/apexcharts"></script>
    
    <script src="../home/js/navbar.js"></script>
    <script src="./js/scripts.js"></script>
    
  </body>
</html>