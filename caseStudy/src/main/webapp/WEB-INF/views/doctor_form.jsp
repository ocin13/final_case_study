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
    <link href="/css/doctors.css" rel="stylesheet" />
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
                <jsp:include page="side_navbar.jsp"></jsp:include>
                <!--********end_sidemenu*************-->
            </div>
            <div class="col-10 col-md-10 mx-auto p-md-5 dashboard">
              <div class="row">
                
            
            <!-- *************** if the object doctor does not equals null edit the current doctor information**************** -->
            <c:if test="${doctor != null}">
				<h1>edit doctor information</h1>
				<div style="color:#09d6a7;"><p>${message}</p></div>
				</div>
				<div class="row py-5">
				<form enctype="multipart/form-data"  action="editDoctor" method="POST" class="row">
			</c:if>
			<!-- *************** if the doctor object equals null add new doctor **************** -->
			<c:if test="${doctor == null}">
				<h1>add new doctor</h1>
				<div style="color:#09d6a7;"><p>${message}</p></div>
				</div>
				<div class="row py-5">
				<form enctype="multipart/form-data"  action="addDoctor" method="POST" class="row">
			</c:if>
			<c:if test="${doctor != null}">
                    <input type="hidden" name="docId" value="<c:out value='${doctor.getDocId()}' />" />
               </c:if>
            <!-- ************************* -->
            
                
                    <div class="col-12 col-md-6 py-2">
                        <label for="doctorFirstName" class="form-label">first name</label>
                        <input type="text" autofocus min="2" max="30" name="firstName" value="${ doctor.firstName }" class="form-control" id="doctorFirstName" />
                    	<p class="text-danger">${firstNameError }</p>
                    </div>
                    <div class="col-12 col-md-6 py-2">
                        <label for="doctorLastName" class="form-label">Last name</label>
                        <input type="text" min="1" max="30" name="lastName" value="${ doctor.lastName }"  class="form-control" id="doctorLastName"  required/>
                    	<p class="text-danger">${lastNameError }</p>
                    </div>

                    <div class="col-12 col-md-12 py-2">
                      <label for="doctorspecialties" class="form-label">doctor's specialty</label>
                      <input type="text" min="1" max="30" name="speciality" value="${ doctor.speciality }"  class="form-control" id="doctorspecialties"  required/>
                  		<p class="text-danger">${specialityError }</p>
                  </div>
                  

                  

                   
                    <div class="col-12  py-2">
                        <label for="doctorEmail" class="form-label">email</label>
                        <input type="email" name="email" value="${ doctor.account.email }"  class="form-control" id="doctorEmail"  required/>
                    </div>
                    
                     <div class="col-12 col-md-6 py-2">
                        <label for="doctorUserName" class="form-label">user name</label>
                        <input type="text" name="userName" value="${ doctor.account.userName }"  class="form-control" id="doctorUsername" required/>
                    </div>

                    <div class="col-12 col-md-6 py-2">
                        <label for="doctorPassword" class="form-label">password</label>
                        <input type="password" min="8"  pattern="(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{8,}" max="26" name="password" value="${ doctor.account.password }"  class="form-control" id="doctorPassword"  required/>
                   		<small>numbers and uppercase and lowercase letters, and at least 8 characteres</small>
                    </div>
                 	

                    <div class="col-12 col-md-6 py-2">
                        <label for="doctorBirthDate" class="form-label">birth date</label>
                        <input type="date" name="dateOfBirth" value="${ doctor.dateOfBirth }"  class="form-control" id="doctorBirthDate"  required/>
                    </div>
                    <div class="col-12 col-md-6 py-2">
                        <label for="doctorgender" class="form-label">gender</label>
                        <select class="form-select" name="gender" value="${ doctor.gender }"  aria-label="Select Gender" id="doctorGender">
                            <option selected>Select Gender</option>
                            <option value="male">male</option>
                            <option value="femele">femele</option>
                            <option value="unknown">unknown</option>
                          </select>
                    	<p class="text-danger">${genderError }</p>
                    </div>

                    <div class="col-12 col-md-6 py-2">
                        <label for="doctorAdress" class="form-label">Address</label>
                        <input type="text" min="1" max="40" name="street" value="${ doctor.address.street }"  class="form-control" id="doctorAdress" placeholder="1234 Main St" required>
                    </div>
                      <div class="col-12 col-md-6 py-2">
                        <label for="inputAddress2" class="form-label">Address 2</label>
                        <input type="text" name="apt" min="1" max="40" value="${ doctor.address.apt }"  class="form-control" id="inputAddress2" placeholder="Apartment, studio, or floor" required>
                      </div>
                      <div class="col-12 col-md-6 py-2">
                        <label for="doctorCity" class="form-label">City</label>
                        <input type="text" min="1" max="40" name="city" value="${ doctor.address.city }"  class="form-control" id="doctorCity" required>
                      </div>
                      <div class="col-6 col-md-4 py-2">
                        <label for="doctorState" class="form-label">State</label>
                        <input type="text" min="2" max="10" name="state" value="${ doctor.address.state }"  id="doctorState" class="form-control"  required/>
                      </div>
                      <div class="col-6 col-md-2 py-2">
                        <label for="doctorZip" class="form-label">Zip</label>
                        <input type="number" size="5" name="zip" value="${ doctor.address.zip }"  class="form-control" id="doctorZip" required>
                      </div>
                      <div class="col-12 col-md-6 py-2">
                        <label for="doctorPhone" class="form-label">phone</label>
                        <input type="tel" size="10" name="phone" value="${doctor.phone}"  class="form-control" id="doctorPhone"  required/>
                    	<p class="text-danger">${phoneError }</p>
                    </div>
                    <div class="col-12 col-md-6 py-2">
                        <label for="doctorpicture" class="form-label">profile picture</label>
                        <input type="file" name="file"  accept="*" class="form-control" id="doctorpicture" />
                    </div>
                      <div class="col-12 py-2">
                        <button type="submit" class="btn btn-primary" id="validateDocBtn">Validate</button>
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