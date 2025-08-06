package com.amazonaws.services.s3.model.inventory;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class InventoryConfiguration implements Serializable {
    private InventoryDestination destination;

    /* renamed from: id  reason: collision with root package name */
    private String f15370id;
    private String includedObjectVersions;
    private InventoryFilter inventoryFilter;
    private Boolean isEnabled;
    private List<String> optionalFields;
    private InventorySchedule schedule;

    public void addOptionalField(String str) {
        if (str != null) {
            if (this.optionalFields == null) {
                this.optionalFields = new ArrayList();
            }
            this.optionalFields.add(str);
        }
    }

    public InventoryDestination getDestination() {
        return this.destination;
    }

    public String getId() {
        return this.f15370id;
    }

    public String getIncludedObjectVersions() {
        return this.includedObjectVersions;
    }

    public InventoryFilter getInventoryFilter() {
        return this.inventoryFilter;
    }

    public List<String> getOptionalFields() {
        return this.optionalFields;
    }

    public InventorySchedule getSchedule() {
        return this.schedule;
    }

    public Boolean isEnabled() {
        return this.isEnabled;
    }

    public void setDestination(InventoryDestination inventoryDestination) {
        this.destination = inventoryDestination;
    }

    public void setEnabled(Boolean bool) {
        this.isEnabled = bool;
    }

    public void setId(String str) {
        this.f15370id = str;
    }

    public void setIncludedObjectVersions(String str) {
        this.includedObjectVersions = str;
    }

    public void setInventoryFilter(InventoryFilter inventoryFilter2) {
        this.inventoryFilter = inventoryFilter2;
    }

    public void setOptionalFields(List<String> list) {
        this.optionalFields = list;
    }

    public void setSchedule(InventorySchedule inventorySchedule) {
        this.schedule = inventorySchedule;
    }

    public InventoryConfiguration withDestination(InventoryDestination inventoryDestination) {
        setDestination(inventoryDestination);
        return this;
    }

    public InventoryConfiguration withEnabled(Boolean bool) {
        setEnabled(bool);
        return this;
    }

    public InventoryConfiguration withFilter(InventoryFilter inventoryFilter2) {
        setInventoryFilter(inventoryFilter2);
        return this;
    }

    public InventoryConfiguration withId(String str) {
        setId(str);
        return this;
    }

    public InventoryConfiguration withIncludedObjectVersions(String str) {
        setIncludedObjectVersions(str);
        return this;
    }

    public InventoryConfiguration withOptionalFields(List<String> list) {
        setOptionalFields(list);
        return this;
    }

    public InventoryConfiguration withSchedule(InventorySchedule inventorySchedule) {
        setSchedule(inventorySchedule);
        return this;
    }

    public void setIncludedObjectVersions(InventoryIncludedObjectVersions inventoryIncludedObjectVersions) {
        setIncludedObjectVersions(inventoryIncludedObjectVersions == null ? null : inventoryIncludedObjectVersions.toString());
    }

    public InventoryConfiguration withIncludedObjectVersions(InventoryIncludedObjectVersions inventoryIncludedObjectVersions) {
        setIncludedObjectVersions(inventoryIncludedObjectVersions);
        return this;
    }

    public void addOptionalField(InventoryOptionalField inventoryOptionalField) {
        addOptionalField(inventoryOptionalField == null ? null : inventoryOptionalField.toString());
    }
}
