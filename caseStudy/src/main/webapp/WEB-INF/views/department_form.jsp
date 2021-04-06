<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="icon" href="/icons/3022339-hospital/png/hospital.png" type="image/png" sizes="16x16">
    <!--css files refrences-->
    <link rel="stylesheet" href="https://pro.fontawesome.com/releases/v5.10.0/css/all.css" integrity="sha384-AYmEC3Yw5cVb3ZcuHtOA93w35dYTsvhLPVnYs9eStHfGJvOvKxVfELGroGkvsg+p" crossorigin="anonymous"/>
    <link href="/bootstrap/css/bootstrap.min.css" rel="stylesheet" />
    <link href="/css/department.css" rel="stylesheet" />
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
            <div class="col-10 col-md-10 mx-auto p-md-5 dashboard">
              <div class="row">
              <c:if test="${department != null}">
             	<h1>edit department details</h1>
				<div style="color:#09d6a7;"><p>${message}</p></div>
				</div>
				<div class="row py-5">
				<form enctype="multipart/form-data"  action="editDepartment" method="POST" class="row">
			</c:if>
			<!-- *************** if the doctor object equals null add new doctor **************** -->
			<c:if test="${department == null}">
				<h1>add new department</h1>
				<div style="color:#09d6a7;"><p>${message}</p></div>
				</div>
				<div class="row py-5">
				<form enctype="multipart/form-data"  action="addDepartment" method="POST" class="row">
			</c:if>
                    <div class="col-12 col-md-6 py-2">
                        <label for="departmentId" class="form-label">department Id</label>
                        <input type="text" name="depId" value="${department.depId }" class="form-control" id="departmentId"/>
                    </div>
                    <div class="col-12 col-md-6 py-2">
                        <label for="departmentName" class="form-label">departement name</label>
                        <input type="text" name="name" value="${department.name}" class="form-control" id="departmentName"  required/>
                   		<p class="text-danger">${nameError }</p>
                    </div>

                      <div class="col-12  py-2">
                        <label for="inputMess" class="form-label">description</label>
                        <textarea type="text" name="description"   class="form-control" id="inputMess" placeholder="description"  required>${department.description}</textarea>
                      	<p class="text-danger">${descError }</p>
                      </div>
                      
                      <div class="col-12 py-2">
                        <button type="submit" class="btn btn-primary" id="newDepBtn">Add Departement</button>
                      </div>
                </form>
            </div>
        </div>  
        

    </div>
    <!--bootstrap js-->
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.6.0/dist/umd/popper.min.js" integrity="sha384-KsvD1yqQ1/1+IA7gi3P0tyJcT3vR+NdBTt13hSJ2lnve8agRGXTTyNaBYmCR/Nwi" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta2/dist/js/bootstrap.min.js" integrity="sha384-nsg8ua9HAw1y0W1btsyWgBklPnCUAFLuTMS2G72MMONqmOymq585AcH49TLBQObG" crossorigin="anonymous"></script>
    <!--chart maker-->
    <script src="https://cdn.jsdelivr.net/npm/apexcharts"></script>

    <script src="./js/scripts.js"></script>
    <script src="../home/js/navbar.js"></script>
  </body>
</html>