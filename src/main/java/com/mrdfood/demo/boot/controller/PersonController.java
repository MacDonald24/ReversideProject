package com.mrdfood.demo.boot.controller;


import com.mrdfood.demo.boot.Services.PersonServiceImp;
import com.mrdfood.demo.boot.model.Person;
import com.mrdfood.demo.boot.model.ValidationError;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;



import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/person")
class PersonController {

    @Autowired 
    private PersonServiceImp personServiceImp;
    
    @RequestMapping(value="/all" ,method = RequestMethod.GET)
    @ResponseBody
    public List<Person> getPeople() {
       return personServiceImp.findAll();
    }
    
    @RequestMapping(value = "/post",method = RequestMethod.POST)
    @ResponseBody
    ResponseEntity<Person> save(@RequestBody @Valid Person person, BindingResult bindingResult) throws Exception {
        if (bindingResult.hasErrors()) {
            return new ResponseEntity(ValidationError.of(bindingResult), HttpStatus.BAD_REQUEST);
        }
        
		Person savedPerson = personServiceImp.create(person);

        return new ResponseEntity<Person>(savedPerson, HttpStatus.OK);
    }

    @RequestMapping(value = "/email/{email}", method = RequestMethod.GET)
    @ResponseBody
    ResponseEntity<Person> getPersonEmail(@PathVariable @Valid String email) {
        
      Person person = personServiceImp.findByEmail(email);
        
       return new ResponseEntity<Person>(person, HttpStatus.OK);
    }
    
    @RequestMapping(value = "/personId/{Id}", method = RequestMethod.GET)
    @ResponseBody
     ResponseEntity<Person> getPersonId(@PathVariable @Valid String Id) {
        
      Person person = personServiceImp.findById(Id);
        
       return new ResponseEntity<Person>(person, HttpStatus.OK);
    }
     
     @RequestMapping(value = "/edit",method = RequestMethod.POST)
    @ResponseBody
    ResponseEntity<Person> editPersonProfile(@RequestBody @Valid Person person, BindingResult bindingResult) throws Exception {
        if (bindingResult.hasErrors()) {
            return new ResponseEntity(ValidationError.of(bindingResult), HttpStatus.BAD_REQUEST);
        }
                Person editedPerson = personServiceImp.update(person);

        return new ResponseEntity<Person>(editedPerson, HttpStatus.OK);
    }
    
    @RequestMapping(value = "/person/{firstName}", method = RequestMethod.GET)
    @ResponseBody
     ResponseEntity<Person> getPersonByFirstName(@PathVariable @Valid String firstName) {
        
      Person savedPerson = personServiceImp.findByFirstName(firstName);
        
       return new ResponseEntity<Person>(savedPerson, HttpStatus.OK);
    }
     
     @RequestMapping(value = "/remove/{id}", method = RequestMethod.DELETE)
    @ResponseBody
     ResponseEntity<Person> deletePerson(@PathVariable @Valid String id) {
        
      Person savedPerson = personServiceImp.delete(id);
        
       return new ResponseEntity<Person>(savedPerson, HttpStatus.OK);
    }
    
}
