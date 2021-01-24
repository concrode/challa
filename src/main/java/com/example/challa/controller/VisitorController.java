package com.example.challa.controller;

import com.example.challa.model.Visitor;
import com.example.challa.service.VisitorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/visitor")
public class VisitorController {

    private final VisitorService visitorService;

    @Autowired
    public VisitorController(VisitorService visitorService) {
        this.visitorService = visitorService;
    }

    @GetMapping("/register")
    public String registerVisitor() {
        return "register";
    }

    @GetMapping("/allInfo")
    @PreAuthorize("hasRole('ADMIN')")
    public List<Visitor> getAllVisitors() {
        return this.visitorService.getAllVisitors();
    }

    @GetMapping("/report")
    @PreAuthorize("hasRole('ADMIN')")
    public String getVisitorReport() {
        return "Report Content.";
    }
}
