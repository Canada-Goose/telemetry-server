package com.telemetryServer.service;

import com.telemetryServer.model.Entry;
import com.telemetryServer.model.EntryRepository;
import com.telemetryServer.model.EntryTransfer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/telemetry")
public class EntryService {

    @Autowired
    protected EntryRepository entryRepository;

    @PostMapping(value = "/entry")
    public ResponseEntity<Entry> entry(@RequestBody EntryTransfer entryTransfer) {

        // Create a new entry
        Entry newEntry = new Entry();

        // Set the properties of the entry from the response body
        newEntry.setAppId(entryTransfer.getAppId());
        newEntry.setCorrelationId(entryTransfer.getCorrelationId());
        newEntry.setName(entryTransfer.getName());
        newEntry.setValue(entryTransfer.getValue());

        // Save the new entry
        this.entryRepository.save(newEntry);

        // Return an OK response
        return ResponseEntity.ok().build();
    }
}
