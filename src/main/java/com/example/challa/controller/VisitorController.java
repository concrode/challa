package com.example.challa.controller;

import com.example.challa.model.Visitor;
import com.example.challa.payload.request.RegisterRequest;
import com.example.challa.payload.response.RegisterResponse;
import com.example.challa.repository.VisitorRepository;
import com.example.challa.service.VisitorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/visitor")
public class VisitorController {

    @Autowired
    private VisitorRepository visitorRepository;

    private final VisitorService visitorService;

    @Autowired
    public VisitorController(VisitorService visitorService) {
        this.visitorService = visitorService;
    }

    @PostMapping("/register")
    public ResponseEntity<?> registerUser(@RequestBody RegisterRequest registerRequest) {
        Visitor visitor = new Visitor(registerRequest.getFirstName(), registerRequest.getLastName(),
                registerRequest.getPhoneNumber(), registerRequest.getEmail(), registerRequest.getCheckinTime());

        visitorRepository.save(visitor);
        return ResponseEntity.ok(new RegisterResponse("success"));
    }

    @GetMapping("/all")
    public List<Visitor> getAllVisitors() {
        return this.visitorService.getAllVisitors();
    }


//    @GetMapping("/all")
//    @PreAuthorize("hasRole('ADMIN')")
//    public List<Visitor> getAllVisitors() {
//        return this.visitorService.getAllVisitors();
//    }

    @GetMapping("/report")
    @PreAuthorize("hasRole('ADMIN')")
    public String getVisitorReport() {
        return "Report Content.";
    }
}
