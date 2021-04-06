  //fetch api implementation
  
var patientsNumber = document.getElementById("patients");
var doctorsNumber = document.getElementById("doctors");
var availableAppointments = document.getElementById("available");
var reservedAppointments = document.getElementById("reserved");
var doctorsList = document.getElementById("doctorsList");
var appointementsList = document.getElementById("appointmentsList");
var patientsList = document.getElementById("patientList");


  
  fetch('http://localhost:9000/statistics')
  .then(response => response.json())
  .then(data =>  setValues(data.numberOfPatients,data.numberOfDoctors,data.numberOfAvailableAppointments,data.numberOfReservedAppointments,data.doctorsList,data.reservedAppointmentsList,data.patientsList,data.numberOfCardioPatients,data.numberOfChildrensPatients,data.numberOfDisabledPatients,data.numberOfPatientsPerDepartment,data.numberOfPatientsPerDay))
  .catch( err => {
    console.log(err);
  }); 



  function setValues(nop,nod,noaa,nora,docList,appList,pList,nocp,noc,nodp,noppd,nOfpatientPerDay){
    patientsNumber.innerHTML = `<p>${nop}</p>`;
    doctorsNumber.innerHTML = `<p>${nod}</p>`;
    availableAppointments.innerHTML = `<p>${noaa}</p>`;
    reservedAppointments.innerHTML = `<p>${nora}</p>`;
    for(i=0;i<docList.length;i++){
      doctorsList.innerHTML += `<li class="list-group-item"><div class="row align-items-center"><div class="col-2"><img src="/uploads/${docList[i].fileName}" height="50px" width="50px" style="border-radius: 50%;" /></div><div class="col-10"><h6>${docList[i].firstName} ${docList[i].lastName}</h6><p>${docList[i].speciality}</p></div></div></li>`;
    } 
    console.log(docList);
    for(i=0;i<appList.length;i++){
           appointementsList.innerHTML +=   `<tr>
                                            <th scope="row"><div class="row align-items-center"><div class="col-2"><img src="/uploads/${appList[i].doctor.fileName}" height="25px" width="25px" style="border-radius: 50%;" /></div><div class="col-10"><h6>${appList[i].email}</h6><p>${appList[i].date}</p></div></div></th>
                                            <td><h6>appointement with</h6><p>dr ${appList[i].doctor.lastName} ${appList[i].doctor.firstName}</p></td>
                                            <td>${appList[i].time}</td>
                                            <td><button type="button" class="btn ${appList[i].reserved? "btn-outline-danger":"btn-outline-success"}">${appList[i].reserved? "reserved":"available"}</button></td>
                                          </tr>`;
    } 
    console.log(appList); 
    //render list of patients
    for(i=0;i<pList.length;i++){
      patientsList.innerHTML +=  `<tr>
                        <th scope="row"><div class="row align-items-center"><div class="col-2"><img src="/uploads/${pList[i].fileName}" height="25px" width="25px" style="border-radius: 50%;" /></div><div class="col-10"><h6>${pList[i].firstName} ${pList[i].lastName}</h6></div></div></th>
                        <td><h6>${pList[i].account.email}</h6></td>
                        <td>${pList[i].phone}</td>
                        <td><button type="button" class="btn btn-outline-dark">${pList[i].gender}</button></td>
                      </tr>`;
    }

    //number of heart disease patienst
    //   /*chart5*/
  var options5 = {
    chart: {
      height: 170,
      type: "radialBar"
    },
    
    series: [Math.floor(nocp/(noaa+nora)*100)],
    
    plotOptions: {
      radialBar: {
        hollow: {
          margin: 15,
          size: "70%"
        },
       
        dataLabels: {
          showOn: "always",
          name: {
            offsetY: -10,
            show: true,
            color: "#888",
            fontSize: "13px"
          },
          value: {
            color: "#111",
            fontSize: "25px",
            show: true
          }
        }
      }
    },
  
    stroke: {
      lineCap: "round",
    },
    labels: ["heart disease"]
  };
  
  var chart5 = new ApexCharts(document.querySelector("#chart5"), options5);
  
  chart5.render();

  //************************************ */
    /*chart4*/
    var options4 = {
      chart: {
        height: 170,
        type: "radialBar"
      },
      
      series: [Math.floor(noc/(noaa+nora)*100)],
      
      plotOptions: {
        radialBar: {
          hollow: {
            margin: 15,
            size: "70%"
          },
         
          dataLabels: {
            showOn: "always",
            name: {
              offsetY: -10,
              show: true,
              color: "#888",
              fontSize: "13px"
            },
            value: {
              color: "#111",
              fontSize: "25px",
              show: true
            }
          }
        }
      },
    
      stroke: {
        lineCap: "round",
      },
      labels: ["children"]
    };
    
    var chart4 = new ApexCharts(document.querySelector("#chart4"), options4);
    
    chart4.render();

    /****** */
  
  var options3 = {
    chart: {
        height: 250,
        type: 'radialBar',
    },
    series: [Math.floor(nodp/(noaa+nora)*100)],
    labels: ['disabilities'],
  }

  var chart3 = new ApexCharts(document.querySelector("#chart3"), options3);
  
  chart3.render();
  
  /************************************
   * //************************************** */
  
  var departments = [];
for (var key in noppd) {
  departments.push(key);
}
var nOPatients = [];
for (var key in noppd) {
  nOPatients.push(noppd[key]);
}
var options1 = {
  chart: {
    type: 'line'
  },
  series: [{
    name: 'sales',
    data: [nOPatients[0],nOPatients[1],nOPatients[2],nOPatients[3],nOPatients[4],nOPatients[5]]
  }],
  xaxis: {
    categories: [departments[0],departments[1],departments[2],departments[3],departments[4],departments[5]]
  }
}

var chart = new ApexCharts(document.querySelector("#chart1"), options1);

chart.render();

//************************************ */
var patientsPerDay = [];
for (i = 0; i< nOfpatientPerDay.length; i++) {
  patientsPerDay.push(nOfpatientPerDay[i].an);
}
var dates = [];
for (i = 0; i< nOfpatientPerDay.length; i++) {
  dates.push(nOfpatientPerDay[i].d);
}







  //********* */
  var options2 = {
    chart: {
      height: 280,
      type: "area"
    },
    dataLabels: {
      enabled: false
    },
    series: [
      {
        name: "Series 1",
        data: [patientsPerDay[2],patientsPerDay[1],patientsPerDay[0]]
      }
    ],
    fill: {
      type: "gradient",
      gradient: {
        shadeIntensity: 1,
        opacityFrom: 0.7,
        opacityTo: 0.9,
        stops: [0, 90, 100]
      }
    },
    xaxis: {
      categories: [
        
        dates[2],
        dates[1],
        dates[0]
      ]
    }
  };
  
  var chart2 = new ApexCharts(document.querySelector("#chart2"), options2);
  
  chart2.render();

   
  }


 
  
