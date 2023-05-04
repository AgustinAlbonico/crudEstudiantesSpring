const d = document;

let btnEliminarEstudiante = d.querySelector(".eliminarEstudiante");

btnEliminarEstudiante.addEventListener("click", (e) => {
    let confirm = window.confirm("Desea borrar el usuario?");
    if(!confirm){
       e.preventDefault();
    }

})