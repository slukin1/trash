package com.hbg.module.community.multiadapter;

public final class DelegateNotFoundException extends RuntimeException {
    public DelegateNotFoundException(Class<?> cls) {
        super("Have you registered the " + cls.getName() + " type and its delegate or binder?");
    }
}
