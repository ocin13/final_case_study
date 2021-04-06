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
    <link href="/css/settings.css" rel="stylesheet" />
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
        		<jsp:include page="side_navbar.jsp"></jsp:include>
                <!--********end_sidemenu*************-->
            </div>
            <div class="col-10 col-md-10 mx-auto p-md-5 dashboard">
              <div class="row">
                <h2>company settings</h2>
            </div>
            <div class="row py-5">
                <form action="saveSettings" method="POST" class="row">
                	<input type="hidden" name="id" value="${company.id }" class="form-control" id="companyId"  />
                    <div class="col-12 col-md-6 py-2">
                        <label for="companyName" class="form-label">company name</label>
                        <input type="text" min="2" max="30" name="name" value="${company.name }" class="form-control" id="companyName"  required/>
                    </div>
                    <div class="col-12 col-md-6 py-2">
                        <label for="ceoName" class="form-label">contact person</label>
                        <input type="text"  name="contact" value="${company.contact }" class="form-control" id="ceoName"  required/>
                    </div>

                    <div class="col-12 col-md-6 py-2">
                        <label for="companyPhone" class="form-label">phone number</label>
                        <input type="tel" size="10" name="phone" value="${company.phone }" class="form-control" id="companyPhone"  required/>
                    </div>
                    <div class="col-12 col-md-6 py-2">
                        <label for="employeeEmail" class="form-label">email</label>
                        <input type="email" name="email" value="${company.email }" class="form-control" id="employeeEmail"  required/>
                    </div>

                    <div class="col-12 col-md-6 py-2">
                        <label for="companyMobile" class="form-label">mobile number</label>
                        <input type="tel" size="10" class="form-control" name="mobile" value="${company.mobile }" id="companyMobile"  required/>
                    </div>
                    <div class="col-12 col-md-6 py-2">
                        <label for="companyFax" class="form-label">fax number</label>
                        <input type="tel" size="10" name="fax" value="${company.fax }" class="form-control" id="companyFax"  required/>
                    </div>

                


                    <div class="col-12 col-md-12 py-2">
                        <label for="employeeAdress" class="form-label">Address</label>
                        <input type="text" min="2" max="30" name="address" value="${company.address }" class="form-control" id="employeeAdress" placeholder="1234 Main St" required>
                    </div>
                      <div class="col-12 col-md-3 py-2">
                        <label for="companyCountry" class="form-label">country</label>
                        <input type="text" min="2" max="30"  name="country" value="${company.country }" class="form-control" id="companyCountry" placeholder="USA" required>
                      </div>
                      <div class="col-12 col-md-3 py-2">
                        <label for="companyCity" class="form-label">City</label>
                        <input type="text" min="2" max="30"  name="city" value="${company.city }" class="form-control" id="companyCity" required>
                      </div>
                      <div class="col-6 col-md-3 py-2">
                        <label for="companyState" class="form-label">State</label>
                        <input type="text" min="2" max="10"  name="state" value="${company.state }" id="companyState" class="form-control"  required/>
                      </div>
                      <div class="col-6 col-md-3 py-2">
                        <label for="companyZip" class="form-label">Zip</label>
                        <input type="number" size="5" name="zip" value="${company.zip }" class="form-control" id="companyZip" required>
                      </div>

                      <div class="col-12 col-md-12 py-2">
                        <label for="companyWebsite" class="form-label">web site</label>
                        <input type="text" pattern="www.+" name="website" value="${company.website }" class="form-control" id="companyWebsite" placeholder="HTTPS://WWW.NANOCARE.COM" required>
                      </div>
                      
                      
                      <div class="col-12 py-3 text-center">
                        <button type="submit" class="btn btn-primary py-2 px-5" id="saveBtn"><i class="fa fa-hdd"></i>    Save</button>
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