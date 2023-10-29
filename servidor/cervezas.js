const Joi = require("joi");
const express = require("express");
const app = express();

app.use(express.json());


const cervezas = [
    { codigo: 1, nombre: "pilsen",  amargor:"bajo", graduacion:3.9},
    { codigo: 2, nombre: "coco scotish" ,  amargor:"bajo" , graduacion:4.0},
    { codigo: 3, nombre: "hoppy pilsen" ,  amargor:"suave", graduacion:4.8},
    { codigo: 4, nombre: "ipa argenta" ,  amargor:"medio", graduacion:5.6},
    { codigo: 5, nombre: "ipa session" ,  amargor:"suave", graduacion:4.3},
    { codigo: 6, nombre: "old ale",  amargor:"bajo" , graduacion:9.0}
  ];

  app.get("/api/cervezas", (req, res) => {
    res.send(cervezas);
  });

  app.get("/api/cervezas/:codigo", (req, res) => {
    const cerveza = cervezas.find((c) => c.codigo === parseInt(req.params.codigo));
    if (!cerveza)
      res.status(404).send("La cerveza con el codigo proporcionado no se encontro");
  
    res.send(cerveza);
  });

app.post("/api/cervezas", (req, res) => {
    const { error } = validarCerveza(req.body);
    if (error)  return res.status(404).send("El curso con el id proporcionado no se encontro");
  
    const cerveza = {
      codigo: cervezas.length + 1,
      nombre: req.body.nombre,
      amargor:req.body.amargor,
      graduacion:req.body.graduacion
    };
    cervezas.push(cerveza);
    res.send(cerveza);
  });

 


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
  
const puerto = process.env.puerto || 3000;
app.listen(puerto, () => console.log("En el puerto ", puerto));


  