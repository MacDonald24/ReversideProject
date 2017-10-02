package com.mrdfood.demo.boot.controller;


import com.mrdfood.demo.boot.model.Person;
import com.mrdfood.demo.boot.dao.PersonDao;
import com.mrdfood.demo.boot.repository.PersonRepository;
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
    private PersonRepository personRepository;
    @Autowired
    private PersonDao personDao;
    
    
    @RequestMapping(value="/all" ,method = RequestMethod.GET)
    @ResponseBody
    public List<Person> getPeople() {
       return personRepository.findAll();
    }
    
    @RequestMapping(value = "/post",method = RequestMethod.POST)
    @ResponseBody
    ResponseEntity<Person> save(@RequestBody @Valid Person person, BindingResult bindingResult) throws Exception {
        if (bindingResult.hasErrors()) {
            return new ResponseEntity(ValidationError.of(bindingResult), HttpStatus.BAD_REQUEST);
        }
        
		Person savedPerson = personRepository.save(person);

        return new ResponseEntity<Person>(savedPerson, HttpStatus.OK);
    }

    @RequestMapping(value = "/email/{email}", method = RequestMethod.GET)
    @ResponseBody
    ResponseEntity<Person> getPersonEmail(@PathVariable @Valid String email) {
        
      Person person = personDao.getPersonByEmail(email);
        
       return new ResponseEntity<Person>(person, HttpStatus.OK);
    }
    
    @RequestMapping(value = "/personId/{Id}", method = RequestMethod.GET)
    @ResponseBody
     ResponseEntity<Person> getPersonId(@PathVariable @Valid String Id) {
        
      Person person = personRepository.findOne(Id);
        
       return new ResponseEntity<Person>(person, HttpStatus.OK);
    }
     
     @RequestMapping(value = "/edit",method = RequestMethod.POST)
    @ResponseBody
    ResponseEntity<Person> editPersonProfile(@RequestBody @Valid Person person, BindingResult bindingResult) throws Exception {
        if (bindingResult.hasErrors()) {
            return new ResponseEntity(ValidationError.of(bindingResult), HttpStatus.BAD_REQUEST);
        }
                Person editedPerson = personDao.editProfile(person);

        return new ResponseEntity<Person>(editedPerson, HttpStatus.OK);
    }
}
