package com.springmvc.SpringMvcBasicProject.controller;

import com.springmvc.SpringMvcBasicProject.Entities.Student;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class StudentController {

    @GetMapping("/student")
    public ResponseEntity<Student> getSingleStudent()
    {
        Student student=new Student("Pranav","Kumar","pranav@gmail.com");
        //return new Student("Pranav","Kumar","pranav@gmail.com");
        //return new ResponseEntity(student,HttpStatus.OK);
        //return ResponseEntity.ok(student);//this is the static method

        return ResponseEntity.ok().header("custom-header","Pranav").body(student);
    }


    @GetMapping("/students")
    public List<Student> getAllStudents()
    {
        List<Student> list=new ArrayList<>();
        list.add(new Student("Pranav","Kumar","pranav@gmail.com"));
        list.add(new Student("Prabhat","Kumar","pranav@gmail.com"));
        list.add(new Student("Murari","Kumar","pranav@gmail.com"));
        list.add(new Student("Kishan","Kumar","pranav@gmail.com"));
        return list;

    }

     //use of @PathVariable:-used to bind the value of URI template variable into method argument
    // http://localhost:1111/Pranav/Kumar/pranav@gmail.com
    @GetMapping("/{first_Name}/{last_Name}/{email}")
    public Student getStudentBySendingStudentData(@PathVariable String first_Name,
                                                  @PathVariable String last_Name,
                                                  @PathVariable String email)
    {
        return new Student(first_Name,last_Name,email);
    }

    //Use of @RequestParam:-used to extract the value of query parameter in a request URL
// http://localhost:1111/query?id=1&first_Name=Pranjal&last_Name=Kumar&email=pranav@gmail.com
    @GetMapping("query")
    public Student getStudentBySendingStudentDataWithRequestParam(@RequestParam String first_Name,
                                                                  @RequestParam String last_Name,
                                                                  @RequestParam String email)
    {
        return new Student(first_Name,last_Name,email);
    }

    @PostMapping("createStudent")
    @ResponseStatus(HttpStatus.CREATED)
    public Student addStudent(@RequestBody Student student)
    {
        return student;
    }



}
