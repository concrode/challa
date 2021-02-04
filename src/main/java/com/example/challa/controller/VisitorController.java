package com.example.challa.controller;

import com.example.challa.model.Visitor;
import com.example.challa.payload.request.RegisterRequest;
import com.example.challa.payload.response.RegisterResponse;
import com.example.challa.repository.VisitorRepository;
import com.example.challa.service.ReportService;
import com.example.challa.service.VisitorService;
import net.sf.jasperreports.engine.JRException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.io.FileNotFoundException;
import java.util.Collections;
import java.util.List;
import java.util.Map;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/visitor")
public class VisitorController {

    @Autowired
    private VisitorRepository visitorRepository;

    @Autowired
    private  VisitorService visitorService;

    @Autowired
    private  ReportService reportService;

    @PostMapping("/register")
    public ResponseEntity<?> registerUser(@RequestBody RegisterRequest registerRequest) {
        Visitor visitor = new Visitor(registerRequest.getFirstName(), registerRequest.getLastName(),
                registerRequest.getPhoneNumber(), registerRequest.getEmail(), registerRequest.getCheckinTime());

        visitorRepository.save(visitor);
        return ResponseEntity.ok(new RegisterResponse("success"));
    }

    @GetMapping("/all")
    @PreAuthorize("hasRole('ADMIN')")
    public List<Visitor> getAllVisitors() {
        return this.visitorService.getAllVisitors();
    }


    @GetMapping("/report/{reportFormat}")
    @PreAuthorize("hasRole('ADMIN')")
    public Map getVisitorReport(@PathVariable String reportFormat) throws FileNotFoundException, JRException {
          return Collections.singletonMap("response", this.reportService.exportReport(reportFormat));
    }
}
