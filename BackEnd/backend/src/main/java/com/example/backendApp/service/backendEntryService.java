package com.example.backendApp.service;

import com.example.backendApp.Repository.backendEntryRepository;
import com.example.backendApp.entity.backendEntry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Component
public class backendEntryService {

    @Autowired
    private backendEntryRepository backendEntryRepository;

    public void saveEntry(backendEntry entry){
        entry.setDate(LocalDate.now());
        backendEntryRepository.save(entry);
    }
    public List<backendEntry> getEntries(){
        return backendEntryRepository.findAll();
    }
    public Optional<backendEntry> getEntryById(String myId){
        return backendEntryRepository.findById(myId);
    }
    public boolean deleteEntryById(String myId){
        backendEntryRepository.deleteById(myId);
        return true;
    }

    public backendEntry updateById(String myId, backendEntry newentry){
        backendEntry oldEntry = backendEntryRepository.findById(myId).orElse(null);
        if(oldEntry !=  null){
            oldEntry.setTitle(newentry.getTitle() != null && !newentry.getTitle().equals("")? newentry.getTitle() : oldEntry.getTitle());
            oldEntry.setContent(newentry.getContent() != null && !newentry.getContent().equals("") ? newentry.getContent() : oldEntry.getContent());
        }
        backendEntryRepository.save(oldEntry);
        return oldEntry;
    }

    public static class userDetailsService implements UserDetailsService {
        @Override
        public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
            return new myUserDetailsService().loadUserByUsername(username);
        }
    }
}
