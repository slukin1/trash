package com.adjust.sdk.sig;

import android.content.Context;
import android.util.Log;

class NativeLibHelper implements a {
    static {
        try {
            System.loadLibrary("signer");
        } catch (UnsatisfiedLinkError e11) {
            Log.e("NativeLibHelper", "Signer Library could not be loaded: " + e11.getMessage());
        }
    }

    private native void nOnResume();

    private native byte[] nSign(Context context, Object obj, byte[] bArr, int i11);

    public final void a() {
        nOnResume();
    }

    public final byte[] a(Context context, Object obj, byte[] bArr, int i11) {
        return nSign(context, obj, bArr, i11);
    }
}
