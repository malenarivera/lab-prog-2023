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