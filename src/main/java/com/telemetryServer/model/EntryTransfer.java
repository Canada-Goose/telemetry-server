package com.telemetryServer.model;

public class EntryTransfer {

    private String appId;
    private String correlationId;
    private String name;
    private int value;

    public EntryTransfer() {}

    public EntryTransfer(String appId, String correlationId, String name, int value) {
        this.appId = appId;
        this.correlationId = correlationId;
        this.name = name;
        this.value = value;
    }

    public String getAppId() {
        return this.appId;
    }

    public void setAppId(String appId) {
        this.appId = appId;
    }

    public String getCorrelationId() {
        return this.correlationId;
    }

    public void setCorrelationId(String correlationId) {
        this.correlationId = correlationId;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getValue() {
        return this.value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}
