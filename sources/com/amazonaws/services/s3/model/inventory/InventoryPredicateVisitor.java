package com.amazonaws.services.s3.model.inventory;

public interface InventoryPredicateVisitor {
    void a(InventoryPrefixPredicate inventoryPrefixPredicate);
}
