var downloadBtn = document.getElementById("downloadBtn");
var invoice = document.querySelector(".invoice");

var fileName = 'invoice'; 

function downloadPdfInvoice(){
    var opt = {
        margin: 1,
        filename: `${fileName}.pdf`,
        image: { type: 'jpeg', quality: 0.98 },
        html2canvas: { scale: 2 },
        jsPDF: { unit: 'in', format: 'letter', orientation: 'portrait' }
    };
    html2pdf().from(invoice).set(opt).save();
}

downloadBtn.addEventListener("click", downloadPdfInvoice);