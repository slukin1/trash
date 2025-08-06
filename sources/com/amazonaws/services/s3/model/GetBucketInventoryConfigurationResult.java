package com.amazonaws.services.s3.model;

import com.amazonaws.services.s3.model.inventory.InventoryConfiguration;

public class GetBucketInventoryConfigurationResult {

    /* renamed from: a  reason: collision with root package name */
    public InventoryConfiguration f15221a;

    public void a(InventoryConfiguration inventoryConfiguration) {
        this.f15221a = inventoryConfiguration;
    }

    public GetBucketInventoryConfigurationResult b(InventoryConfiguration inventoryConfiguration) {
        a(inventoryConfiguration);
        return this;
    }
}
