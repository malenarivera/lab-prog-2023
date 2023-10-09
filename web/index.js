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
  }, 3000); // Cambia la imagen cada 3 segundos (ajusta el tiempo según tus necesidades)
});

function cervezaDelDia() {
  let imagenes = [
    "ipa_argenta",
    "ipasession",
    "cocoscotish",
    "pilsen",
    "hoppypilsen",
    "oldale",
  ];
  let random = Math.floor(Math.random() * 6);
  let conteinerCerveza = document.getElementById("cerveza-del-dia");

  // Crear un elemento img
  let img = document.createElement("img");

  let r = imagenes[random];
  // Establecer el atributo src con la URL de la imagen
  img.src = "imagenes/" + r + ".jfif"; // Reemplaza "ruta-de-tu-imagen.jpg" con la ruta de tu imagen

  console.log(r);
  // Establecer el ancho y alto de la imagen
  img.style.maxWidth = "100%"; // Ancho en píxeles
  img.style.maxHeight = "100%";; // Alto en píxeles
  // Agregar la imagen al contenedor
  conteinerCerveza.appendChild(img);
}

// Llama a la función para mostrar una cerveza al cargar la página
document.addEventListener("DOMContentLoaded", cervezaDelDia);
