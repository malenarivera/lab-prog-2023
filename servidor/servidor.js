const Joi = require("joi");
const express = require("express");
const app = express();

app.use(express.json());

const courses = [
  { id: 1, name: "curso1" },
  { id: 2, name: "curso2" },
  { id: 3, name: "curso3" },
];


app.get("/api/courses", (req, res) => {
  res.send(courses);
});

app.get("/api/courses/:id", (req, res) => {
  const course = courses.find((c) => c.id === parseInt(req.params.id));
  if (!course)
    res.status(404).send("El curso con el id proporcionado no se encontro");

  res.send(course);
});

app.post("/api/courses", (req, res) => {
  const { error } = validateCourse(req.body);
  if (error)  return res.status(404).send("El curso con el id proporcionado no se encontro");

  const course = {
    id: courses.length + 1,
    name: req.body.name,
  };
  courses.push(course);
  res.send(course);
});

app.put("/api/courses/:id", (req, res) => {
  //buscar el curso si no existe devolver un 404
  const course = courses.find((c) => c.id === parseInt(req.params.id));
  console.log(course);
if (!course)  return res.status(404).send("El curso con el id proporcionado no se encontro");
  
  //accedemos al error
  const { error } = validateCourse(req.body);
  if (error) return res.status(400).send(error.details[0].message); 

  

  //updatear el curso y devolverselo al cliente
  course.name = req.body.name;
  console.log(course);
  res.send(course);
});

function validateCourse(course) {
  const schema = Joi.object({
    name: Joi.string().min(3).required(),
  });

  return schema.validate(course);
}


app.delete('/api/courses/:id', (req, res)=>
{ 
  const course = courses.find((c) => c.id === parseInt(req.params.id));
  console.log(course);
  if (!course)  return res.status(404).send("El curso con el id proporcionado no se encontro");

  const index=courses.indexOf(course);
  courses.splice(index,1);
  res.send(course);

})

//asignamos un puerto, si hay un puerto determinado lo utilizamos sino por defecto el 3000
const port = process.env.PORT || 3000;
app.listen(port, () => console.log("En el puerto ", port));
