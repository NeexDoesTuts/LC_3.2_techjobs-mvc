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

    // add to avoid broken path like in demo, with no parameters or other than the two required
    @RequestMapping(value = "/results")
    public String results(Model model) {
        model.addAttribute("columns", ListController.columnChoices);
        model.addAttribute("title", "You have not searched for anything yet");
        return "search";
    }

    // renamed it because overloading search when results handles search/results seems strange
    @RequestMapping(value = "/results", method = RequestMethod.GET, params = {"searchType", "searchTerm"})
    public String results(Model model, @RequestParam String searchTerm, @RequestParam String searchType) {
        // grab parameters in params
        // call for appropriate JobData method
        // send results back to view to display

        ArrayList<HashMap<String, String>> jobs;

        if (searchType.equals("all") || searchType.equals("")) {
            jobs = JobData.findByValue(searchTerm);
        } else {
            jobs = JobData.findByColumnAndValue(searchType, searchTerm);
        }

        model.addAttribute("columns", ListController.columnChoices);
        model.addAttribute("jobs", jobs);
        model.addAttribute("jobsCount", jobs.size());
        model.addAttribute("searchTypeChosen", "You searched within: " + searchType);
        model.addAttribute("title", "The Job Hunt Roller coaster");
        return "search";
    }
}