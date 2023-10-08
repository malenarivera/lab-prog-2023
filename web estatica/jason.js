document.querySelector('#boton').addEventListener('click', function () {
    var boton = document.querySelector('#boton');
    var tabla = document.querySelector('#tabla');
    
    // Si la tabla está visible, oculta la tabla y muestra el botón
    if (!tabla.classList.contains('hidden')) {
        ocultarTabla();
        mostrarBoton();
    } else {
        mostrarTabla();
        ocultarBoton();
    }
});

function mostrarTabla() {
    var tabla = document.querySelector('#tabla');
    tabla.classList.remove('hidden');
}

function ocultarTabla() {
    var tabla = document.querySelector('#tabla');
    tabla.classList.add('hidden');
}

function mostrarBoton() {
    var boton = document.querySelector('#boton');
    boton.style.display = 'block';
}

function ocultarBoton() {
    var boton = document.querySelector('#boton');
    boton.style.display = 'none';
}

document.querySelector('#boton').addEventListener('click', traerDatos);

function traerDatos() {
    const jeje = new XMLHttpRequest();

    jeje.open('GET', 'datitos.json', true);
    jeje.send();
    jeje.onreadystatechange = function () {

        if (this.readyState == 4 && this.status == 200) {
            let datos = JSON.parse(this.responseText)
            let cervesitas = document.querySelector('#cervesitas');
            cervesitas.innerHTML = '';

            for (let cerveza of datos) {
                cervesitas.innerHTML += `
                <tr class"nombreCerveza">
                    <td>${cerveza.nombre}</td>
                    <td>${cerveza.fecha}</td>
                    <td>${cerveza.graduacion}</td>
                    <td>${cerveza.amargor}</td>
                </tr>
                `
            }

            // Mostrar la tabla una vez que se han cargado los datos
            mostrarTabla();
        }
    }
}
