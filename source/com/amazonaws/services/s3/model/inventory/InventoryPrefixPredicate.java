package com.amazonaws.services.s3.model.inventory;

public final class InventoryPrefixPredicate extends InventoryFilterPredicate {
    private final String prefix;

    public InventoryPrefixPredicate(String str) {
        this.prefix = str;
    }

    public void accept(InventoryPredicateVisitor inventoryPredicateVisitor) {
        inventoryPredicateVisitor.a(this);
    }

    public String getPrefix() {
        return this.prefix;
    }
}
