//espera a que se hayan cargado todos los elementos
document.addEventListener("DOMContentLoaded", function () {
  let sliderInner = document.querySelector(".slider-iner");
  let images = sliderInner.querySelectorAll("img");
  let index = 0;

  setInterval(function () {
    index++;
    if (index >= 2) {
      index = 0;
    }
    let percentage = index * -100;
    sliderInner.style.transform = "translateX(" + percentage + "%)";
  }, 3000);
});

function cervezaDelDia() {
  const imagenes = [
    "ipa_argenta",
    "ipasession",
    "cocoscotish",
    "pilsen",
    "hoppypilsen",
    "oldale",
  ];
  let random = Math.floor(Math.random() * 6);
  let conteinerCerveza = document.getElementById("cerveza-del-dia");


  let img = document.createElement("img");

  let r = imagenes[random];

  img.src = "imagenes/" + r + ".jpeg"; 



  img.style.maxWidth = "100%"; 
  img.style.maxHeight = "100%";; 

  conteinerCerveza.appendChild(img);
}

// Llama a la función para mostrar una cerveza al cargar la página
document.addEventListener("DOMContentLoaded", cervezaDelDia);

document.getElementById("logoImagen").addEventListener("click", function() {
  // Redirige a la página principal
location.reload();
});
