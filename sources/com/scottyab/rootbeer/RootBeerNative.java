package com.scottyab.rootbeer;

import ey.a;

public class RootBeerNative {

    /* renamed from: a  reason: collision with root package name */
    public static boolean f28867a = true;

    static {
        try {
            System.loadLibrary("toolChecker");
        } catch (UnsatisfiedLinkError e11) {
            a.b(e11);
        }
    }

    public boolean a() {
        return f28867a;
    }

    public native int checkForRoot(Object[] objArr);

    public native int setLogDebugMessages(boolean z11);
}
