package com.airbnb.lottie.model;

import android.graphics.Typeface;

public class Font {
    private final float ascent;
    private final String family;
    private final String name;
    private final String style;
    private Typeface typeface;

    public Font(String str, String str2, String str3, float f11) {
        this.family = str;
        this.name = str2;
        this.style = str3;
        this.ascent = f11;
    }

    public float getAscent() {
        return this.ascent;
    }

    public String getFamily() {
        return this.family;
    }

    public String getName() {
        return this.name;
    }

    public String getStyle() {
        return this.style;
    }

    public Typeface getTypeface() {
        return this.typeface;
    }

    public void setTypeface(Typeface typeface2) {
        this.typeface = typeface2;
    }
}
