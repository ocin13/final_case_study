<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="icon" href="/icons/3022339-hospital/png/hospital.png" type="image/png" sizes="16x16">
    <!--css files refrences-->
    <link rel="stylesheet" href="https://pro.fontawesome.com/releases/v5.10.0/css/all.css" integrity="sha384-AYmEC3Yw5cVb3ZcuHtOA93w35dYTsvhLPVnYs9eStHfGJvOvKxVfELGroGkvsg+p" crossorigin="anonymous"/>
    <link href="/bootstrap/css/bootstrap.min.css" rel="stylesheet" />
    <link href="/css/styles.css" rel="stylesheet" />
    <link href="/css/navbar.css" rel="stylesheet" />
    <title>NanoCare</title>
</head>
<body>
    <div class="container-fluid mx-0 px-0">
        <!--********navbar_starts***********-->
        <nav class="navbar navbar-expand-lg navbar-dark bg-dark sticky-top">
            <div class="container-fluid px-md-5">
              <a class="navbar-brand" href="index"><img src="/icons/3022339-hospital/png/hospital.png" width="50px" height="50px"/> <strong>NanoCare</strong></a>
              <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#mainNavbar" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
              </button>
              <div class="collapse navbar-collapse" id="mainNavbar">
                <ul class="pt-2 homeNavbar mx-5">
                  
                  
                  
                  	<sec:authorize access="!isAuthenticated()">
					 <li><a href="welcome"> Login</a></li>
					</sec:authorize>
					<sec:authorize access="isAuthenticated()">
					  <li><a href="logout"> Logout</a></li>
					</sec:authorize>
                  	
                  
                  
                </ul>
              </div>
            </div>
          </nav>
        <!--********navbar_ends*************-->
        <section class="row banner align-items-center mx-0">
            <div class="col-md-8"></div>
           <div class="col-md-4  d-md-block ">
             <h6 class="mb-3" style="color: rgb(123, 215, 243);letter-spacing: 5px;">one of our best doctors</h6>
                <h1 class="mb-5">meet with <br>expert doctors</h1>
                <button class="btn btn-danger btn-lg px-5" id="aptBtn" onclick="window.location='appointments'">need appointement</button></div>
        </section>  
       <section class="row bg-2 text-center p-5">
          <!--**********************departments********************-->
          <h3 class="mb-2"><i class="fa fa-chevron-circle-right d-none d-md-inline-block"></i> the highest standard of health care <i class="fa fa-chevron-circle-left d-none d-md-inline-block"></i></h3>
          <small>clinic services we offer include: primary care, cardiology, parasitology testing laboratory and disabled patient assistance</small>
         <div class="row mt-5">
          <div class="col-12 col-md-2 px-3 mx-auto services">
            <h1><i class="fa fa-medkit"></i></h1>
            <h5>first aid</h5>
            <small>immediate assistance given to any person suffering from either a minor or serious illness or injury,</small>
          </div>
          <div class="col-12 col-md-2 px-3 mx-auto services">
            <h1><i class="fa fa-heartbeat"></i></h1>
            <h5>heart defect</h5>
            <small>congenital heart defects, coronary artery disease, heart failure, valvular heart disease and electrophysiology</small>
          </div>
          <div class="col-12 col-md-2 px-3 mx-auto services">
            <h1><i class="fa fa-wheelchair"></i></h1>
            <h5>patient assistance</h5>
            <small>help patients with tasks such as bathing, dressing, and eating.</small>
          </div>
          <div class="col-12 col-md-2 px-3 mx-auto services">
            <h1><i class="fa fa-bug"></i></h1>
            <h5>parasitology lab</h5>
            <small>direct examination of stool for ova and parasites (O&P) in order to determine the presence of parasites.</small>
          </div>
          
         </div>
       </section>
       <section class="row py-5 presentation">
        <div class="col-12 col-md-5 px-5 mx-auto mb-2">
          <img src="https://cdn.pixabay.com/photo/2017/10/04/09/56/laboratory-2815641__340.jpg" class="img-fluid mb-3"  style="width: 80%;height: 180px;box-shadow: 2px 2px 5px rgb(152, 169, 170);">
          <h4>welcome to our clinic</h4>
          <small>Greets patients and confirms appointments; inspects insurance cards or authorization notices; identifies and collects deductibles
            , co-payments or deposits on services; explains and satisfies any necessary patient signature requirements.</small>
        </div>
        <div class="col-12 col-md-2 text-center mx-auto mb-2">
          <div class="oh-box px-3 py-5">
            <h4 class="mb-5">openings hours:</h4>
            <h5>monday-friday</h5>
            <p>08:00am-11:00pm</p>
            <hr>
            <h5>saturday</h5>
            <p>10:00am-9:00pm</p>
          </div>
        </div>
        <div class="col-12 col-md-2 mx-auto mb-2">
          <div class="contact-box px-3 pt-3">
            <h4 class="mb-4">get in touch:</h4>
            <p><i class="fa fa-globe"></i> address: ${company.address} ${company.city }, ${company.state } ${company.zip} ${company.country }</p>
            <hr>
            <p><i class="fa fa-phone"></i> phone: ${company.phone}</p>
            <hr>
            <p><i class="fa fa-envelope"></i> email: ${company.email}</p>
            <hr>
            <p><i class="fa fa-web"></i> website: ${company.website}</p>
          </div>
        </div>
       </section>
       <section class="row py-5 benifitSection">
        <h5 class="text-center mb-3">see what we provide for your health </h5>
         <div class="col-12 col-md-3 mx-auto benefits">
          <div class="row">
            <div class="col-3 text-center py-3">
              <h1><i class="fa fa-users"></i></h1>
            </div>
            <div class="col-9">
              <h6>expert doctor</h6>
              <small>check our full list of benifts when you subscribe to our website</small>
            </div>
          </div>
         </div> 
        
         <div class="col-12 col-md-3 mx-auto py-3 benefits">
          <div class="row">
            <div class="col-3 text-center py-3">
              <h1><i class="fa fa-hourglass-half"></i></h1>
            </div>
            <div class="col-9">
              <h6>quick visit</h6>
              <small>check our full list of benifts when you subscribe to our website</small>
            </div>
          </div>
         </div> 
         <div class="col-12 col-md-3 mx-auto py-3 benefits">
          <div class="row">
            <div class="col-3 text-center py-3">
              <h1><i class="fa fa-credit-card"></i></h1>
            </div>
            <div class="col-9">
              <h6>card payment</h6>
              <small>check our full list of benifts when you subscribe to our website</small>
            </div>
          </div>
         </div> 
         <div class="bs-linebreak">

         </div>
         <div class="col-12 col-md-3 mx-auto py-3 benefits">
          <div class="row">
            <div class="col-3 text-center py-3">
              <h1><i class="fa fa-folder-open"></i></h1>
            </div>
            <div class="col-9">
              <h6>patient history</h6>
              <small>check our full list of benifts when you subscribe to our website</small>
            </div>
          </div>
         </div> 
         <div class="col-12 col-md-3 mx-auto py-3 benefits">
          <div class="row">
            <div class="col-3 text-center py-3">
              <h1><i class="fa fa-leaf"></i></h1>
            </div>
            <div class="col-9">
              <h6>natural medecine</h6>
              <small>check our full list of benifts when you subscribe to our website</small>
            </div>
          </div>
         </div> 
         <div class="col-12 col-md-3 mx-auto py-3 benefits">
          <div class="row">
            <div class="col-3 text-center py-3">
              <h1><i class="fa fa-calendar"></i></h1>
            </div>
            <div class="col-9">
              <h6>online appointments</h6>
              <small>check our full list of benifts when you subscribe to our website</small>
            </div>
          </div>
         </div> 
       </section>
       <section class="row py-5 newsletter">
        <div class="col-12 col-md-4 mx-auto text-center">
          <h4>do you want to visit our clinic ? </h4>
        </div>
        <div class="col-12 col-md-4 mx-auto p-4">
          <form method="POST" action="newsLetter">
            <div class="input-group mb-3">
              <input type="email" style="border: 2px gray solid;" class="form-control" placeholder="exemple@gmail.com" aria-label="user email" aria-describedby="newsLetterBtn">
              <button class="btn btn-secondary"  type="submit" id="newsLetterBtn">Send</button>
            </div>
          </form>
        </div>
       </section>
       <section class="row p-5 doctors">
        <div class="col-12 col-md-5 mx-auto">
          <div class="row">
            <div class="col-3 text-center py-3">
              <img src="https://cdn.pixabay.com/photo/2016/02/08/23/36/isolated-1188036__340.png" class="img-fluid" style="height: 150px;">
            </div>
            <div class="col-9 py-3">
              <h6>Dr.david man</h6>
              <h6>cardiologist</h6>
              <div class="blue-line my-2"></div>
              <small> licensed health professionals who maintain and restore human health through the practice of medicine</small>
            </div>
          </div>
        </div>
        <div class="col-12 col-md-5 mx-auto">
          <div class="row">
            <div class="col-3 text-center py-3">
              <img src="https://cdn.pixabay.com/photo/2017/03/20/00/51/dr-2157993__340.jpg" class="img-fluid" style="height: 150px;">
            </div>
            <div class="col-9 py-3">
              <h6>Dr.jennifer alex</h6>
              <h6>cardiologist</h6>
              <div class="blue-line my-2"></div>
              <small> licensed health professionals who maintain and restore human health through the practice of medicine</small>
            </div>
          </div>
        </div>
       </section>
       <footer class="row footer py-3 bg-dark text-light">
        <div class="col-12 col-md-4 mx-auto text-center">
          <p>facebook  instegram  google+   twitter</p>
        </div>
      </footer>


    </div>
    <!--bootstrap js-->
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.6.0/dist/umd/popper.min.js" integrity="sha384-KsvD1yqQ1/1+IA7gi3P0tyJcT3vR+NdBTt13hSJ2lnve8agRGXTTyNaBYmCR/Nwi" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta2/dist/js/bootstrap.min.js" integrity="sha384-nsg8ua9HAw1y0W1btsyWgBklPnCUAFLuTMS2G72MMONqmOymq585AcH49TLBQObG" crossorigin="anonymous"></script>
  </body>
</html>