<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="icon" href="/icons/3022339-hospital/png/hospital.png" type="image/png" sizes="16x16">
    <!--css files refrences-->
    <link rel="stylesheet" href="https://pro.fontawesome.com/releases/v5.10.0/css/all.css" integrity="sha384-AYmEC3Yw5cVb3ZcuHtOA93w35dYTsvhLPVnYs9eStHfGJvOvKxVfELGroGkvsg+p" crossorigin="anonymous"/>
    <link href="/bootstrap/css/bootstrap.min.css" rel="stylesheet" />
    <link href="/css/home.css" rel="stylesheet" />
    <link href="/css/navbar.css" rel="stylesheet" />
    <title>NanoCare</title>
</head>
<body>
    <div class="container-fluid mx-0 px-0">
        <!--********navbar_starts***********-->
       	<jsp:include page="navbar.jsp" />
        <!--********navbar_ends*************-->
        <div class="row">
            <div class="col-8 col-md-2 py-3" id="side-menu-box">
                <!--********side_menu*************-->
              
               <%@ include file="side_navbar.jsp" %>
                <!--********end_sidemenu*************-->
            </div>
            <div class="col-12 col-md-10 px-3 py-3 mx-auto" id="dashboard" >
              <!--********summary*************-->
	              <div class="row text-center" style="text-transform: capitalize;height: 100vh;letter-spacing: 10px;color: rgb(138, 135, 132);" >
		            <div class="col-12 my-auto">
		                <h1 class="py-3" style="font-size: 3.6em;">welcome</h1>
		                <h2 class="mb-5">nano care website</h2>
		                <h1 style="font-size: 5em;"><i class="fa fa-handshake"></i></h1>
		            </div>
	        	</div>
           </div>   
    	</div>
    <!--bootstrap js-->
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.6.0/dist/umd/popper.min.js" integrity="sha384-KsvD1yqQ1/1+IA7gi3P0tyJcT3vR+NdBTt13hSJ2lnve8agRGXTTyNaBYmCR/Nwi" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta2/dist/js/bootstrap.min.js" integrity="sha384-nsg8ua9HAw1y0W1btsyWgBklPnCUAFLuTMS2G72MMONqmOymq585AcH49TLBQObG" crossorigin="anonymous"></script>
    <!--chart maker-->
    <script src="https://cdn.jsdelivr.net/npm/apexcharts"></script>
    <script src="/js/navbar.js"></script>
    <script src="/js/home.js"></script>
  </body>
</html>        