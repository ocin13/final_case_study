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
    <link href="/css/employee.css" rel="stylesheet" />
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
               <c:if test="${employee == null }">
	               	 <h2>add Employee</h2>
	               	 <div style="color:#09d6a7;"><p>${message}</p></div>
	            </div>
	            <div class="row py-5">
                <form enctype="multipart/form-data" action="addEmployee" method="POST" class="row">
               </c:if>
               <c:if test="${employee != null }">
               		<h2>edit Employee information</h2>
	               	 <div><p>${message}</p></div>
	            </div>
	            <div class="row py-5">
                <form enctype="multipart/form-data" action="editEmployee" method="POST" class="row">
				<input type="hidden" name="empId" value="${employee.empId }" />
               </c:if>
                    <div class="col-12 col-md-6 py-2">
                        <label for="FirstName" class="form-label">first name</label>
                        <input type="text" autofocus min="1" max="30" name="firstName" value="${ employee.firstName }" class="form-control" id="FirstName"  required/>
                    </div>
                    <div class="col-12 col-md-6 py-2">
                        <label for="doctorLastName" class="form-label">Last name</label>
                        <input type="text" min="2" max="30" name="lastName" value="${ employee.lastName }"  class="form-control" id="LastName"  required/>
                    </div>

                    <div class="col-12 col-md-12 py-2">
                      <label for="occupation" class="form-label">employee occupation</label>
                      <input type="text" min="2" max="30" name="occupation" value="${ employee.occupation }"  class="form-control" id="occupation"  required/>
                  </div>
                  

                  

                    
                    <div class="col-12 py-2">
                        <label for="Email" class="form-label">email</label>
                        <input type="email" name="email" value="${ employee.account.email }"  class="form-control" id="Email"  required/>
                    </div>

                    <div class="col-12 col-md-6 py-2">
                        <label for="Password" class="form-label">password</label>
                        <input type="password" min="8"  pattern="(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{8,}" max="26" name="password" value="${ employee.account.password }"  class="form-control" id="Password"  required/>
                    	<small>numbers and uppercase and lowercase letters, and at least 8 characteres</small>
                    </div>
                   <div class="col-12 col-md-6 py-2">
                        <label for="UserName" class="form-label">user name</label>
                        <input type="text" min="4" max="30" name="userName" value="${ employee.account.userName }"  class="form-control" id="Username"/>
                    	
                    </div>

                    <div class="col-12 col-md-6 py-2">
                        <label for="BirthDate" class="form-label">birth date</label>
                        <input type="date" name="dateOfBirth" value="${ employee.dateOfBirth }"  class="form-control" id="BirthDate"  required/>
                    </div>
                    <div class="col-12 col-md-6 py-2">
                        <label for="Gender" class="form-label">gender</label>
                        <select class="form-select" name="gender" value="${ employee.gender }"  aria-label="Select Gender" id="Gender">
                            <option selected>Select Gender</option>
                            <option value="male">male</option>
                            <option value="femele">femele</option>
                            <option value="unknown">unknown</option>
                          </select>
                    </div>

                    <div class="col-12 col-md-6 py-2">
                        <label for="Adress" class="form-label">Address</label>
                        <input type="text" min="2" max="30" name="street" value="${ employee.address.street }"  class="form-control" id="Adress" placeholder="1234 Main St" required>
                    </div>
                      <div class="col-12 col-md-6 py-2">
                        <label for="inputAddress2" class="form-label">Address 2</label>
                        <input type="text" min="1" max="30" name="apt" value="${ employee.address.apt }"  class="form-control" id="inputAddress2" placeholder="Apartment, studio, or floor" required>
                      </div>
                      <div class="col-12 col-md-6 py-2">
                        <label for="City" class="form-label">City</label>
                        <input type="text" min="2" max="30" name="city" value="${ employee.address.city }"  class="form-control" id="City" required>
                      </div>
                      <div class="col-6 col-md-4 py-2">
                        <label for="State" class="form-label">State</label>
                        <input type="text" min="2" max="30" name="state" value="${ employee.address.state }"  id="State" class="form-control"  required/>
                      </div>
                      <div class="col-6 col-md-2 py-2">
                        <label for="Zip" class="form-label">Zip</label>
                        <input type="number" size="5" name="zip" value="${ employee.address.zip }"  class="form-control" id="Zip" required>
                      </div>
                      <div class="col-12 col-md-6 py-2">
                        <label for="Phone" class="form-label">phone</label>
                        <input type="tel" size="10" name="phone" value="${employee.phone}"  class="form-control" id="Phone"  required/>
                    </div>
                    <div class="col-12 col-md-6 py-2">
                        <label for="picture" class="form-label">profile picture</label>
                        <input type="file" name="file"  accept="*" class="form-control" id="picture" />
                    </div>
                      <div class="col-12 py-2">
                        <button type="submit" class="btn btn-primary" id="confirmEmpBtn">Validate</button>
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