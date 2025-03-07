package com.practicas.practica2.Controller;


import com.practicas.practica2.domain.Student;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/Estudiantes")
public class StudentController{

private List<Student> estudiantes = new ArrayList<>(Arrays.asList(
        new Student(1, "samuel", "sammmyvilla3006@gmail.com", 19, "SpringBoot" ),
        new Student(2, "Paula", "pvburgos@gmail.com", 20, "logística"),
        new Student(3, "Juan","jjvillagomez1117@gmail.com",18, "tráfico aéreo"),
        new Student(4, "Paola", "palita061984@gmail.com", 30, "Docencia")
));

@GetMapping
public List<Student> GetEstudiantes(){
    return estudiantes;
    }



@GetMapping("/{mail}")
    public Student getStudent(@PathVariable String mail){
    for(Student estudiante : estudiantes){
        if(estudiante.getCorreo().equals(mail)){
            return estudiante;

        }
    }
    return null;

}


@PostMapping
public Student AgregarEstudiante(@RequestBody Student estudiante){   //uso del requestbody para transformar el json a objeto - postmapping
    estudiantes.add((estudiante));
    return estudiante;
}

@PutMapping //modificar datos de manera total
public Student PutModificarEstudiante(@RequestBody Student estudiante){ //metodo para modificar los datos de un estudiante
    for(Student s : estudiantes){
        if (s.getID()==estudiante.getID()){
            s.setNombre(estudiante.getNombre());
            s.setCorreo(estudiante.getCorreo());
            s.setEdad(estudiante.getEdad());
            s.setCurso(estudiante.getCurso());

            return s;
        }

    }
    return null;
}

@PatchMapping //cambios parciales
    public Student PatchEstudiante(@RequestBody Student estudiante){ //request body para transformar el json
    for(Student s : estudiantes){
        if (s.getID()==estudiante.getID()){

            if (estudiante.getNombre()!=null){
                s.setNombre(estudiante.getNombre());
            }
            if (estudiante.getCorreo()!=null){
                s.setCorreo(estudiante.getCorreo());

            }
            if (estudiante.getCurso()!=null){
                s.setCurso(estudiante.getCurso());

            }
            return s;

        }
    }
    return null;
}

@DeleteMapping("/{ID}") //eliminar un usuario por su ID
    public Student DeleteStudent(@PathVariable int ID){
    for (Student s : estudiantes){
        if (s.getID()==ID){
            estudiantes.remove(s);
        }
        return s;

    }
    return null;
}






}
