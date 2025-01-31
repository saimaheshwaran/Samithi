package org.sai.samithi.controllers;

import org.sai.samithi.services.VisitorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class VisitorController {

    @Autowired
    private VisitorService visitorService;

    @GetMapping("/visitor/list")
    public String getVisitors(@RequestParam(defaultValue = "0") int page, Model model) {
        model.addAttribute("visitorPage",
                visitorService.visitorPageRequest(page, 10));
        return "visitor/list";
    }

}
