var sideMenuBtn = document.querySelector("#sideMenuBtn");
var sideMenuContainer = document.getElementById("side-menu-box");
var dashboard = document.getElementById("dashboard");

sideMenuBtn.addEventListener("click", toggleMenu);
var pos = 0;


function toggleMenu(){
  if(pos > -1){
    document.getElementById("side-menu").style.left = -200 + 'px';
    pos = -1;
    dashboard.classList.remove("col-md-10");
    dashboard.classList.add("col-md-11");
  }else{
    dashboard.classList.add("col-md-10");
    dashboard.classList.remove("col-md-11");
    document.getElementById("side-menu").style.left = 0 + 'px';
    pos = 0;
  }
}