package com.hackerrank.sample.controller;

import com.hackerrank.sample.model.Model;
import com.hackerrank.sample.service.ModelService;
import java.util.List;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@RestController
public class ModelController {
    @Autowired
    private ModelService modelService;

    @GetMapping("/")
    @ResponseBody
    public String home() {
        return "Default Java 21 Project Home Page";
    }

    @RequestMapping(value = "/model", method = RequestMethod.POST, consumes = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public void createNewModel(@RequestBody @Valid Model model) {
      
         modelService.saveModel(model);
    }

    @RequestMapping(value = "/erase", method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.OK)
    public void deleteAllModels() {
       
         modelService.deleteAllModels();
    }

    @RequestMapping(value = "/model/{id}", method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.OK)
    public void deleteModelById(@RequestParam Long id) {
     
         modelService.deleteModelById(id);
    }

    @RequestMapping(value = "/model", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public List<Model> getAllModels() {
       
        public List<Model> getAllModels();
        return modelService.getModelById(id);
    }

    @RequestMapping(value = "/model/{id}", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public Model getModelById(Long id) {
        
        return modelService.getModelById(id);
    }
}
