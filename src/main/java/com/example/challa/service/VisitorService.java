package com.example.challa.service;

import com.example.challa.model.Visitor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class VisitorService {

    public List<Visitor> getAllVisitors() {
        List l = new ArrayList();
        Visitor v = new Visitor("a","b","03","sds@", new Date());
        l.add(v);
        return l;
    }
}
