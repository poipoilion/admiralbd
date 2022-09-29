// Загрузка лоадера
function viewLoader(){
    document.getElementById('formUpEx').style.display='none';
    document.getElementById('loader').style.display='block';
}
document.getElementById('buttSend').addEventListener("click", viewLoader);

// Показ, что файл выбран
let input = document.getElementById('excelFile');
let labAddFile = document.getElementById('labAddFile');
input.addEventListener('change', function (e) {
    labAddFile.innerText = 'Файл выбран';
    labAddFile.style.paddingLeft='50px';
});