package com.telemetryServer.model;

import org.springframework.data.repository.CrudRepository;


public interface EntryRepository extends CrudRepository<Entry, Long> {
    public Entry findByAppIdAndCorrelationIdAndName(String appId, String correlationId, String name);
}
