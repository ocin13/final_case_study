
var options1 = {
    chart: {
      type: 'line'
    },
    series: [{
      name: 'sales',
      data: [30,40,35,50,49,60,70]
    }],
    xaxis: {
      categories: ['jan','feb','mar','apr','may','jun','jul']
    }
  }
  
  var chart = new ApexCharts(document.querySelector("#chart1"), options1);
  
  chart.render();

  /********* */
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
        data: [45, 52, 38, 45, 19, 23, 80]
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
        "01 Jan",
        "02 feb",
        "03 mar",
        "04 apr",
        "05 may",
        "06 jun",
        "07 jul"
      ]
    }
  };
  
  var chart2 = new ApexCharts(document.querySelector("#chart2"), options2);
  
  chart2.render();

  /****** */
  
  var options3 = {
    chart: {
        height: 250,
        type: 'radialBar',
    },
    series: [70],
    labels: ['patients'],
  }

  var chart3 = new ApexCharts(document.querySelector("#chart3"), options3);
  
  chart3.render();

  /*chart4*/
  var options4 = {
    chart: {
      height: 170,
      type: "radialBar"
    },
    
    series: [78],
    
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
    labels: ["tests"]
  };
  
  var chart4 = new ApexCharts(document.querySelector("#chart4"), options4);
  
  chart4.render();

  /*chart5*/
  var options5 = {
    chart: {
      height: 170,
      type: "radialBar"
    },
    
    series: [84],
    
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
    labels: ["treatement"]
  };
  
  var chart5 = new ApexCharts(document.querySelector("#chart5"), options5);
  
  chart5.render();