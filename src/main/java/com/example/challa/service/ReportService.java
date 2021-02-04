package com.example.challa.service;

import com.example.challa.model.Visitor;
import com.example.challa.repository.VisitorRepository;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ReportService {

    @Autowired
    private VisitorRepository visitorRepository;

    public String exportReport(String reportFormat) throws FileNotFoundException, JRException {
        List<Visitor> visitors = visitorRepository.findAll();

        // Load file and compile
        File file = ResourceUtils.getFile("classpath:visitors.jrxml");
        JasperReport jasperReport = JasperCompileManager.compileReport(file.getAbsolutePath());
        JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(visitors);

        Map<String, Object> parameters = new HashMap<>();
        parameters.put("createdBy", "Yuntian");
        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, dataSource);

        // Set path
        String downloadPath = System.getProperty("user.home") + "/Downloads/";
        if (reportFormat.equalsIgnoreCase("html")) {
            JasperExportManager.exportReportToHtmlFile(jasperPrint, downloadPath + "visitors.html");
        }

        if (reportFormat.equalsIgnoreCase("pdf")) {
            JasperExportManager.exportReportToHtmlFile(jasperPrint, downloadPath + "visitors.pdf");
        }

        return "Report generated in path:" + downloadPath;
    }
}

