package com.example.backendApp.controller;

import com.example.backendApp.entity.backendEntry;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;

@RestController
@RequestMapping("/backend")
public class backendEntryController {

    public Map<String, backendEntry> backendEntries = new HashMap<>();
    @GetMapping
    public List<backendEntry> getAll(){
        return new ArrayList<>(backendEntries.values());
    }
    @PostMapping
    public backendEntry creatEntry(@RequestBody backendEntry entry){
        backendEntries.put(entry.getId(),entry);
         return entry;
    }

    @GetMapping("id/{myId}")
    public backendEntry getEntryByID(@PathVariable String myId){
        return backendEntries.get(myId);
    }

    @DeleteMapping("id/{myId}")
    public boolean deleteEntryById(@PathVariable String myId){
        backendEntries.remove(myId);
        return true;
    }

    @PutMapping("id/{myId}")
    public backendEntry updateById(@PathVariable String myId, @RequestBody backendEntry entry){
        return backendEntries.put(myId,entry);
    }
}

