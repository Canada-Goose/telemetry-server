package com.telemetryServer.service;

import com.telemetryServer.model.EntryRepository;
import com.telemetryServer.model.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ServiceImpl {
    @Autowired
    protected BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    protected UserRepository userRepository;

    @Autowired
    protected EntryRepository entryRepository;
}
