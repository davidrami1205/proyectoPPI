//Ejecutar función en el evento click

document.getElementById("btnOpen").addEventListener("click",open_close_menu);

//declarar variables
var optionsMenu = document.getElementById("optionsMenu");
var btnOpen = document.getElementById("btnOpen");
var body = document.getElementById("body");

//Evento para mostar y ocultar el menu
function open_close_menu(){
	body.classList.toggle("body_move");
	optionsMenu.classList.toggle("optionsMenu_move");
}