let sliderInner= document.querySelector(".slider-iner");
let images=sliderInner.querySelectorAll("img");

let index=1;

setInterval(function(){
    let percentage=index*-100;
    sliderInner.style.transform= "translateX("+percentage+"%)"; 
    index++;
    if (index>images.length-1){
        index=1;
    }
},1000);