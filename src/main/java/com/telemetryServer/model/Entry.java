package com.telemetryServer.model;

import org.springframework.lang.NonNull;
import org.springframework.lang.Nullable;

import javax.persistence.*;

@Entity
public class Entry extends Auditable {

    @NonNull
    private String appId;

    @Nullable
    private String correlationId;

    @NonNull
    private String name;

    @NonNull
    private int value;

    public Entry() {}

    @NonNull
    public String getAppId() {
        return appId;
    }

    public void setAppId(@NonNull String appId) {
        this.appId = appId;
    }

    @Nullable
    public String getCorrelationId() {
        return correlationId;
    }

    public void setCorrelationId(@Nullable String correlationId) {
        this.correlationId = correlationId;
    }

    @NonNull
    public String getName() {
        return this.name;
    }

    public void setName(@NonNull String name) {
        this.name = name;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}
