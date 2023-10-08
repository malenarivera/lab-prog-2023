document.querySelector('#boton').addEventListener('click', traerDatos);

function traerDatos() {
    console.log(Object);
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
                <tr>
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

function mostrarTabla() {
    // Obtén la referencia a la tabla y quita la clase "hidden" para mostrarla
    var tabla = document.querySelector('#tabla');
    tabla.classList.remove('hidden');
}