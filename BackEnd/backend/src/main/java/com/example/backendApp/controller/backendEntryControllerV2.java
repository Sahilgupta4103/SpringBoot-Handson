package com.example.backendApp.controller;

import com.example.backendApp.entity.backendEntry;
import com.example.backendApp.service.backendEntryService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/backend")
public class backendEntryControllerV2 {

    @Autowired
    private backendEntryService backendEntryService;

    @GetMapping()
    public List<backendEntry> getAll() {
        return backendEntryService.getEntries();
    }

    @GetMapping("/csrf-token")
    public CsrfToken getToken(HttpServletRequest request) {
        return (CsrfToken) request.getAttribute("_csrf");
    }

    @PostMapping
    public backendEntry creatEntry(@RequestBody backendEntry entry) {
        backendEntryService.saveEntry(entry);
        return entry;
    }

    @GetMapping("id/{myId}")
    public backendEntry getEntryByID(@PathVariable String myId) {
        return backendEntryService.getEntryById(myId).orElse(null);
    }

    @DeleteMapping("id/{myId}")
    public boolean deleteEntryById(@PathVariable String myId) {
        return backendEntryService.deleteEntryById(myId);
    }

    @PutMapping("id/{myId}")
    public backendEntry updateById(@PathVariable String myId, @RequestBody backendEntry newentry) {
        return backendEntryService.updateById(myId, newentry);
    }
}


