package com.google.firebase.components;

import java.util.List;

public interface ComponentRegistrarProcessor {
    public static final ComponentRegistrarProcessor NOOP = h.f66968a;

    List<Component<?>> processRegistrar(ComponentRegistrar componentRegistrar);
}
