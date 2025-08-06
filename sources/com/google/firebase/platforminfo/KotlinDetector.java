package com.google.firebase.platforminfo;

import kotlin.g;

public final class KotlinDetector {
    private KotlinDetector() {
    }

    public static String detectVersion() {
        try {
            return g.f56691g.toString();
        } catch (NoClassDefFoundError unused) {
            return null;
        }
    }
}
