const Joi = require("joi");
const express = require("express");
const app = express();
const ejs= require('ejs');

//app.use(express.json);


const cervezas = [
    { codigo: 1, nombre: "pilsen",  amargor:"bajo", graduacion:3.9},
    { codigo: 2, nombre: "coco scotish" ,  amargor:"bajo" , graduacion:4.0},
    { codigo: 3, nombre: "hoppy pilsen" ,  amargor:"suave", graduacion:4.8},
    { codigo: 4, nombre: "ipa argenta" ,  amargor:"medio", graduacion:5.6},
    { codigo: 5, nombre: "ipa session" ,  amargor:"suave", graduacion:4.3},
    { codigo: 6, nombre: "old ale",  amargor:"bajo" , graduacion:9.0}
  ];

  //si los parametros no existen devuelvo todo 

  app.get("/api/cervezas", (req, res) => {

    const cantidadDeseada = parseInt(req.query.cantidad);
    const inicio = parseInt(req.query.from) || 0; 
  
    if (isNaN(cantidadDeseada) || cantidadDeseada <= 0) {
      return res.status(400).send("La cantidad debe ser un número entero positivo.");
    }
  
    if (inicio >= cervezas.length) {
      return res.status(404).send("No hay suficientes elementos a partir del índice proporcionado.");
    }
  
    // Limitar la cantidad de elementos a la cantidad deseada o al máximo disponible
    const cantidadReal = Math.min(cantidadDeseada, cervezas.length - inicio);
  
    const cervezasLimitadas = cervezas.slice(inicio, inicio + cantidadReal);
    res.status(200).send(cervezasLimitadas)
  
  });
//metodos GET
  app.get("/api/cervezas", (req, res) => {
    res.send(cervezas);
  });

  app.get("/api/cervezas/:codigo", (req, res) => {
    const cerveza = cervezas.find((c) => c.codigo === parseInt(req.params.codigo));
    if (!cerveza)
      res.status(404).send("La cerveza con el codigo proporcionado no se encontro");
  
    res.send(cerveza);
  });

  
  
  


  //metodo post
app.post("/api/cervezas", (req, res) => {
    const { error } = validarCerveza(req.body);
    if (error)  return res.status(404).send("La cerveza con el código proporcionado no se encontró");
  
    const cerveza = {
      codigo: cervezas.length + 1,
      nombre: req.body.nombre,
      amargor:req.body.amargor,
      graduacion:req.body.graduacion
    };
    cervezas.push(cerveza);
    res.send(cerveza);
  });

  let codigoHtml = (req, res) => {
    re.writeHead(200, {
        'Content-Type': 'text/html'
    });
    fs.readFile('./index.html', null, function (error, data) {
        if (error) {
            response.writeHead(404);
            respone.write('Whoops! File not found!');
        } else {
            response.write(data);
        }
        response.end();
    });
};

  //metodo put

  app.put("/api/cervezas/:codigo", (req, res) => {
    // Buscar la cerveza por su código
    const cerveza = cervezas.find((c) => c.codigo === parseInt(req.params.codigo));
  
    if (!cerveza) {
      return res.status(404).send("La cerveza con el código proporcionado no se encontró");
    }
  
    // Validar los datos de actualización
    const { error } = validarCerveza(req.body);
    if (error) {
      return res.status(400).send(error.details[0].message);
    }
  
    // Actualizar la cerveza si se proporcionan nuevos valores
    if (req.body.nombre !== undefined) {
      cerveza.nombre = req.body.nombre;
    }
    if (req.body.amargor !== undefined) {
      cerveza.amargor = req.body.amargor;
    }
    if (req.body.graduacion !== undefined) {
      cerveza.graduacion = req.body.graduacion;
    }
  
    // Enviar la cerveza actualizada como respuesta
    res.send(cerveza);
  });

  function validarCerveza(cerveza) {
    const schema = Joi.object({
      nombre: Joi.string().min(3),
      amargor: Joi.valid('suave', 'bajo', 'medio'),
      graduacion: Joi.number()
    });
  
    return schema.validate(cerveza);
  }
  
const puerto = process.env.PUERTO || 3000;
app.listen(puerto, () => console.log(`En el puerto ${puerto}`));

//assuming app is express Object.
app.get('/Users\Dell\Documents\LABPROG\lab-prog-2023-1\web',(req,res) =>{
  res.sendFile('index.html');
});


//METODOS GET

//pagina principal
app.get("/", (req,res)=>{
  res.sendFile(__dirname+'/webEstatica/index.html')
});
app.get("/index.css", (req,res)=>{
  res.sendFile(__dirname+'/webEstatica/index.css')
});
app.get("/index.js", (req,res)=>{
  res.sendFile(__dirname+'/webEstatica/index.js')
});

//pagina auxiliar
app.get("/cervezaDelDia.html", (req,res)=>{
  res.sendFile(__dirname+'/webEstatica/cervezaDelDia.html')
});

app.get("/cssCervezas.css", (req,res)=>{
  res.sendFile(__dirname+'/webEstatica/cssCervezas.css')
});
app.get("/datitos.json", (req,res)=>{
  res.sendFile(__dirname+'/webEstatica/datitos.json')
});
app.get("/jason.js", (req,res)=>{
  res.sendFile(__dirname+'/webEstatica/jason.js')
});


//imagenes 
const path = require('path');
app.use('/imagenes', express.static(path.join(__dirname, 'webEstatica', 'imagenes')));



