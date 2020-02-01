package com.example.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.micronaut.data.annotation.DateCreated;
import io.micronaut.data.annotation.DateUpdated;
import io.micronaut.data.annotation.MappedProperty;
import io.micronaut.data.model.DataType;

import java.util.Date;

public class BaseEntity {

    @DateCreated
    @MappedProperty(type = DataType.DATE)
    @JsonFormat(pattern = "dd/MM/yyyy")
    Date createdAt;

    @DateUpdated
    @MappedProperty(type = DataType.DATE)
    @JsonFormat(pattern = "dd/MM/yyyy")
    Date modifiedAt;

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getModifiedAt() {
        return modifiedAt;
    }

    public void setModifiedAt(Date modifiedAt) {
        this.modifiedAt = modifiedAt;
    }
}
