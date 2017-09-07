package org.launchcode.controllers;

import org.launchcode.models.JobData;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.HashMap;

@Controller
@RequestMapping("search")
public class SearchController {

    @RequestMapping(value = "", method = RequestMethod.GET)
    public String search(Model model) {
        model.addAttribute("columns", ListController.columnChoices);
        return "search";
    }

    @RequestMapping(value = "/results", method = RequestMethod.GET, params = {"searchType", "searchTerm"})
    public String search(Model model, @RequestParam String searchTerm, @RequestParam String searchType) {
        // grab parameters
        // call for appropriate ListController method
        // send results back to view to display



        model.addAttribute("columns", ListController.columnChoices);
        return "search";
    }


    // TODO: #1 - Create handler to process search request and display results

}

// https://stackoverflow.com/questions/30380498/overload-controller-method-in-java-spring
//
//    @RequestMapping(method = RequestMethod.GET, params = {"id", "query"})
//    public A getA(@RequestParam int id, @RequestParam String query) {
//    ...
//    }
//
//
//    @RequestMapping(method = RequestMethod.GET, params = {"id"})
//    public A getA(@RequestParam int id) {
//    ...
//    }