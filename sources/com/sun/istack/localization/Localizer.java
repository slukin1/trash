package com.sun.istack.localization;

import java.util.HashMap;
import java.util.Locale;
import java.util.ResourceBundle;

public class Localizer {

    /* renamed from: a  reason: collision with root package name */
    public final Locale f40352a;

    /* renamed from: b  reason: collision with root package name */
    public final HashMap<String, ResourceBundle> f40353b;

    public Localizer() {
        this(Locale.getDefault());
    }

    public Localizer(Locale locale) {
        this.f40352a = locale;
        this.f40353b = new HashMap<>();
    }
}
