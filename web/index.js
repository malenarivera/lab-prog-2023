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

document.addEventListener("DOMContentLoaded", function () {
  // Tu código JavaScript aquí
  // Obtén el elemento de texto invisible
  var textoInvisible = document.querySelector(".texto-invisible");

  console.log(textoInvisible);

  // Función para verificar la visibilidad del texto
  function verificarVisibilidad() {
    // Obtén la posición de desplazamiento vertical actual
    var scrollPos = window.scrollY;

    // La altura a la que quieres que aparezca el texto
    var triggerPos =
      window.innerHeight *
      0.7; /* Aparecerá cuando el 70% de la ventana esté visible */

    // Verifica si el usuario ha desplazado lo suficiente para mostrar el texto
    if (scrollPos >= triggerPos) {
      textoInvisible.style.opacity = "1"; // Hace que el texto sea visible
    }
  }

  // Agrega un evento de desplazamiento a la ventana
  window.addEventListener("scroll", verificarVisibilidad);

  // Llama a verificarVisibilidad() al cargar la página para manejar el texto inicialmente visible si está cerca de la parte superior de la página
  window.addEventListener("load", verificarVisibilidad);
});


// Obtén una referencia al enlace y al contenedor de imágenes
var botonVerMas = document.getElementById("boton-ver-mas");
var contenedorImagenes = document.getElementById("imagenes-adicionales");

// Agrega un evento de clic al enlace
botonVerMas.addEventListener("click", function(event) {
  event.preventDefault(); // Evita que el enlace realice la acción predeterminada (navegar a una nueva página)

  // Verifica si el contenedor de imágenes está visible
  if (contenedorImagenes.style.display === "none" || contenedorImagenes.style.display === "") {
    // Si está oculto, muéstralo
    contenedorImagenes.style.display = "block";
  } else {
    // Si está visible, ocúltalo
    contenedorImagenes.style.display = "none";
  }
});

