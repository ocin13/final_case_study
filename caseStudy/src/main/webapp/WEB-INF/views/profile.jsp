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
    <link href="/css/profile.css" rel="stylesheet" />
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
              <div class="row">
                <div class="col-6 col-md-10">
                  <h3 class="profileTitle">profile</h3>
                </div>
                <div class="col-6 col-md-2 ">
                  <button class="btn btn-success py-2 px-3" id="backBtn" onclick="window.location='home'"><i class="fa fa-reply"></i> Go Back</button>
                </div>
              </div>
              <form method="POST" action="edit_profile">
              <section class="row profile-section p-md-5 py-5">
                <h3 class="py-4">personal information</h3>
                <div class="col-5 col-md-2 pt-3">
                    <img src="/uploads/${profile.getFileName()}" alt="profile picture" id="profilePicture" class="profilePicture img-fluid"  style="border-radius: 50%;height:150px;"/>
                </div>
                <div class="col-7 col-md-5">
                    <div class="col-12 py-2">
                        <label for="profileFirstName" class="form-label">first name</label>
                        <input type="text" value="${profile.firstName }" name="firstName" class="form-control" id="profileFirstName"  required/>
                    </div>
                    <div class="col-12  py-2">
                        <label for="profileLastName" class="form-label">Last name</label>
                        <input type="text" value="${profile.lastName }" name="lastName" class="form-control" id="profileLastName"  required/>
                    </div>
                </div>
                <div class="col-12 col-md-5">
                    <div class="col-12  py-2">
                        <label for="profileBirthDate" class="form-label">birth date</label>
                        <input type="date" value="${profile.dateOfBirth }" name="dateOfBirth" class="form-control" id="profileBirthDate"  required/>
                    </div>
                    <div class="col-12  py-2">
                        <label for="profileGender" class="form-label">gender</label>
                        <select class="form-select" value="${profile.gender }" name="gender" aria-label="Select Gender" id="profileGender">
                            <option selected>Select Gender</option>
                            <option value="male">male</option>
                            <option value="femele">femele</option>
                            <option value="unknown">unknown</option>
                          </select>
                    </div>
                </div>
              </section>
              <section class="row profile-section p-md-5 py-5">
                  <h3 class="py-4">conatct information</h3>
                <div class="col-12 py-2">
                    <label for="profileAdress" class="form-label">Address</label>
                    <input type="text" class="form-control" value="${profile.address.street }" name="street" id="profileAdress" placeholder="1234 Main St" required>
                </div>
                  <div class="col-12 col-md-6 py-2">
                    <label for="profileApt" class="form-label">Address 2</label>
                    <input type="text" class="form-control" value="${profile.address.apt }" name="apt" id="profileApt" placeholder="Apartment, studio, or floor" required>
                  </div>
                  <div class="col-12 col-md-6 py-2">
                    <label for="profileCity" class="form-label">City</label>
                    <input type="text" class="form-control" name="city" value="${profile.address.city }" id="profileCity" required>
                  </div>
                  <div class="col-6 col-md-6 py-2">
                    <label for="profileState" class="form-label">State</label>
                    <input type="text" id="profileState" name="state" value="${profile.address.state }" class="form-control"  required/>
                  </div>
                  <div class="col-6 col-md-6 py-2">
                    <label for="profileZip" class="form-label">Zip</label>
                    <input type="number" class="form-control" name="zip" value="${profile.address.zip }" id="profileZip" required>
                  </div>
                  <div class="col-12 col-md-6 py-2">
                    <label for="profilePhone" class="form-label">phone</label>
                    <input type="tel" class="form-control" name="phone" value="${profile.phone }" id="profilePhone"  required/>
                </div>
                <div class="col-12 col-md-6 py-2">
                    <label for="profilePhone" class="form-label">email</label>
                    <input type="email" class="form-control" name="email" value="${profile.account.email }" id="profileEmail"  required/>
                </div>
              </section>
              <div class="col-12 py-4 text-center">
                <button type="submit" class="btn btn-primary" id="updateBtn"><i class="fa fa-hdd"></i> Save</button>
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
    
    <script src="/js/navbar.js"></script>
    <script src="/js/scripts.js"></script>
    
  </body>
</html>