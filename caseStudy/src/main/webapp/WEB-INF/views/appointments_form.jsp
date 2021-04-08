<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="icon" href="/icons/3022339-hospital/png/hospital.png" type="image/png" sizes="16x16">
    <!--css files refrences-->
    <link rel="stylesheet" href="https://pro.fontawesome.com/releases/v5.10.0/css/all.css" integrity="sha384-AYmEC3Yw5cVb3ZcuHtOA93w35dYTsvhLPVnYs9eStHfGJvOvKxVfELGroGkvsg+p" crossorigin="anonymous"/>
    <link href="/bootstrap/css/bootstrap.min.css" rel="stylesheet" />
    <link href="/css/appointment.css" rel="stylesheet" />
    <link href="/css/navbar.css" rel="stylesheet" />
    <title>NanoCare</title>
</head>
<body>
    <div class="container-fluid mx-0 px-0">
        <!--********navbar_starts***********-->
        <jsp:include page="navbar.jsp"></jsp:include>
        <!--********navbar_ends*************-->
       	<jsp:include page="side_navbar.jsp"></jsp:include>
                <!--********end_sidemenu*************-->
            </div>
            <div class="col-10 col-md-10 mx-auto p-md-5 dashboard">
              <div class="row">
                <!-- *************** if the object doctor does not equals null edit the current doctor information**************** -->
            <c:if test="${appointment != null}">
				<h1>edit appointment details</h1>
				<div style="color:#09d6a7;"><p>${message}</p></div>
				</div>
				<div class="row py-5">
				<form enctype="multipart/form-data"  action="editAppointment" method="POST" class="row">
			</c:if>
			<!-- *************** if the doctor object equals null add new doctor **************** -->
			<c:if test="${appointment == null}">
				<h1>add new appointment</h1>
				<div style="color:#09d6a7;"><p>${message}</p></div>
				</div>
				<div class="row py-5">
				<form enctype="multipart/form-data"  action="addAppointment" method="POST" class="row">
			</c:if>
			<c:if test="${appointment != null}">
                    <input type="hidden" name="aptId" value="<c:out value='${appointment.aptId}' />" />
               </c:if>
            <!-- ************************* -->
                    
					
                    <div class="col-12 col-md-12 py-2">
                        <label for="appointementDocName" class="form-label">doctor name</label>
                        <select name="doctorId" class="form-select"  id="appointementDocName"   required>
					        <c:forEach items="${doctorsList}" var="doctor">
					            <option value="${doctor.docId}">${doctor.lastName} ${doctor.firstName }</option>
					        </c:forEach>
					    </select>
                    </div>
                    <div class="col-12 col-md-12 py-2">
                    
                        <label for="appointementDep" class="form-label">departement</label>
                        <select name="depName" class="form-select"  id="appointementDep"   required>
					        <c:forEach items="${departmentsList}" var="dep">
					            <option value="${dep.name}">${dep.name}</option>
					        </c:forEach>
					    </select>
                       
                    </div>

                    <div class="col-12 col-md-6 py-2">
                        <label for="appointementTime" class="form-label">time</label>
                        <input type="time" name="time" value="${appointment.time }" class="form-control" id="appointementTime"  required/>
                    </div>

                    <div class="col-12 col-md-6 py-2">
                        <label for="appointementDate" class="form-label">appointement date</label>
                        <input type="date" name="date" value="${appointment.date }" class="form-control" id="appointementDate"  required/>
                    </div>

              
                      
                  
                   <div class="col-12 py-2">
                        <button type="submit" class="btn btn-primary" id="bookAppBtn">Create Appointement</button>
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

    <script src="/js/scripts.js"></script>
    <script src="/js/navbar.js"></script>
  </body>
</html>