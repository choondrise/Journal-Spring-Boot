package com.choondrise.journal.controller;

import com.choondrise.journal.model.Day;
import com.choondrise.journal.service.JournalService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.concurrent.ExecutionException;

@RestController
@AllArgsConstructor
public class JournalController {

    private JournalService journalService;

    @PostMapping("/create")
    public ResponseEntity<String> createDay(@RequestBody Day day) throws ExecutionException, InterruptedException {
        journalService.createDay(day);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping("/get/{dayId}")
    public ResponseEntity<Day> getDay(@PathVariable String dayId) throws ExecutionException, InterruptedException {
        return new ResponseEntity<>(journalService.getDay(dayId), HttpStatus.OK);
    }

    @GetMapping("/get")
    public ResponseEntity<List<Day>> getAllDays() throws ExecutionException, InterruptedException {
        return new ResponseEntity<>(journalService.getAllDays(), HttpStatus.OK);
    }


}
