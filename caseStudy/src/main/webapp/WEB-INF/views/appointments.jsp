<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="icon" href="/icons/3022339-hospital/png/hospital.png"
	type="image/png" sizes="16x16">
<!--css files refrences-->
<link rel="stylesheet"
	href="https://pro.fontawesome.com/releases/v5.10.0/css/all.css"
	integrity="sha384-AYmEC3Yw5cVb3ZcuHtOA93w35dYTsvhLPVnYs9eStHfGJvOvKxVfELGroGkvsg+p"
	crossorigin="anonymous" />
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
		<div class="row">
			<div class="col-8 col-md-2 py-3" id="side-menu-box">
				<!--********side_menu*************-->
				<jsp:include page="side_navbar.jsp"></jsp:include>
				</nav>
				<!--********end_sidemenu*************-->
			</div>
			<div class="col-12 col-md-10 py-5 dashboard">
				<div class="row mb-3">
					<div class="col-6 col-md-10">
						<h3>appointements</h3>
						<h6>number of appointments: ${appointmentsList.size() }</h6>
						<h3>${message }</h3>
					</div>
					<div class="col-6 col-md-2 ">
						<sec:authorize access="hasAuthority('ADMIN')">
							<button class="btn btn-success py-2 px-3" id="addAppBtn"
								onclick="window.location='newAppointment'">
								<i class="fa fa-plus"></i> Add Appointement
							</button>
						</sec:authorize>
					</div>
				</div>
				<div class="row py-4">
					<c:if test="${reservedApp != null }">
					 <h5 class="text-info">you have an appointment on: ${reservedApp.date } at: ${reservedApp.time } with: dr.${reservedApp.doctor.lastName } ${reservedApp.doctor.firstName }</h5>
					</c:if>
				</div>
				<div class="row">
					<c:if test="${appointmentsList.isEmpty() == false }">
						<table class="table">
							<thead>
								<tr>
									<th scope="col">#</th>
									<th scope="col">Patient Name</th>
									<th scope="col">Doctor Name</th>
									<th scope="col">Email</th>
									<th scope="col">Department</th>
									
									<th scope="col">date</th>
									<th scope="col">time</th>
									<th scope="col">status</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach items="${appointmentsList}" var="app">
									<tr>
										<th scope="row">${app.aptId }</th>
										<td>${app.userName}</td>
										<td>${doctor.firstName} ${app.doctor.firstName} ${app.doctor.lastName }</td>
										<td>${app.email}</td>
										<td>${app.depName}</td>
										<td>${app.date}</td>
										<td>${app.time}</td>
										<td>
											<a style="color: black; text-decoration: none;"
												href="reserveAppointment${app.aptId}">
													 <c:if test="${app.reserved == true }"><button class="btn btn-danger">Reserved</button></c:if>
													<c:if test="${app.reserved == false }"><button class="btn btn-success">Available</button></c:if>
											</a>
										</td>
										<td>
											<sec:authorize access="hasAuthority('ADMIN')">
												<a style="color: black; text-decoration: none;"
												href="cancelAppointment${app.aptId}"><button class="btn btn-primary">Cancel</button></a>
											</sec:authorize>
										</td>
										<td>
											<sec:authorize access="hasAuthority('ADMIN')">
												<a style="color: black; text-decoration: none;"
												href="editAppointment${app.aptId}"><i
													class="fa fa-pencil"></i> Edit</a>
											</sec:authorize>
										</td>
												
										<td>
										<sec:authorize access="hasAuthority('ADMIN')">
										<a style="color: black; text-decoration: none;"
											href="deleteAppointment${app.aptId}"><i
												class="fa fa-trash"></i> Delete</a>
										</sec:authorize>
										</td>
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
	<script
		src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.6.0/dist/umd/popper.min.js"
		integrity="sha384-KsvD1yqQ1/1+IA7gi3P0tyJcT3vR+NdBTt13hSJ2lnve8agRGXTTyNaBYmCR/Nwi"
		crossorigin="anonymous"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta2/dist/js/bootstrap.min.js"
		integrity="sha384-nsg8ua9HAw1y0W1btsyWgBklPnCUAFLuTMS2G72MMONqmOymq585AcH49TLBQObG"
		crossorigin="anonymous"></script>
	<!--chart maker-->
	<script src="https://cdn.jsdelivr.net/npm/apexcharts"></script>

	<script src="/js/scripts.js"></script>
	<script src="/js/navbar.js"></script>
</body>
</html>