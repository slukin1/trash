package com.fluttercandies.photo_manager.core.entity;

public enum PermissionResult {
    NotDetermined(0),
    Denied(2),
    Authorized(3);
    
    private final int value;

    private PermissionResult(int i11) {
        this.value = i11;
    }

    public final int getValue() {
        return this.value;
    }
}
