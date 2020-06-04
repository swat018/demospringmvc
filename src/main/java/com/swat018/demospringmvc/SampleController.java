package com.swat018.demospringmvc;

import org.springframework.core.io.Resource;
import org.springframework.hateoas.RepresentationModel;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
public class SampleController {

/*
    @GetMapping("/hello")
    public String hello(Model model) {
        model.addAttribute("name","jinwoo");
        return "hello";
    }
*/
/*
    @GetMapping("/hello")
    public String hello() throws SampleException {
        throw new SampleException();
    }
*/

/*    @ExceptionHandler(SampleException.class)
    public @ResponseBody AppError sampleError(SampleException e) {
        AppError appError = new AppError();
        appError.setMessage("error.app.key");
        appError.setReason("IDK IDK IDK");
        return appError;
    }*/
    @GetMapping("/hello")
    public RepresentationModel<Hello> hello() {
        Hello hello = new Hello();
        hello.setPrefix("Hey, ");
        hello.setName("jinwoo");

        RepresentationModel<Hello> helloRepresentationModel = new RepresentationModel<Hello>();
        helloRepresentationModel.add(linkTo(methodOn(SampleController.class).hello()).withSelfRel());


        return helloRepresentationModel;
    }
}
