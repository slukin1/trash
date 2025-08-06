package com.iproov.sdk.cameray;

import android.graphics.SurfaceTexture;
import android.util.Size;
import com.iproov.sdk.p021new.Cfor;
import com.iproov.sdk.p021new.Cnew;
import com.iproov.sdk.p021new.Cthis;

/* renamed from: com.iproov.sdk.cameray.try  reason: invalid class name */
public interface Ctry {

    /* renamed from: com.iproov.sdk.cameray.try$do  reason: invalid class name */
    public interface Cdo {
        /* renamed from: do  reason: not valid java name */
        void m214do();

        /* renamed from: do  reason: not valid java name */
        void m215do(Cif ifVar, Exception exc);

        /* renamed from: do  reason: not valid java name */
        void m216do(Cfor forR);

        /* renamed from: do  reason: not valid java name */
        void m217do(Cnew newR, Size size);

        /* renamed from: do  reason: not valid java name */
        void m218do(Cthis thisR);

        /* renamed from: do  reason: not valid java name */
        void m219do(Exception exc);

        /* renamed from: do  reason: not valid java name */
        void m220do(boolean z11);
    }

    /* renamed from: com.iproov.sdk.cameray.try$if  reason: invalid class name */
    public enum Cif {
        FAILED_TO_LOCK_EXPOSURE,
        FAILED_TO_STOP_GRACEFULLY,
        FAILED_TO_READ_EXIF_DATA,
        FAILED_TO_TAKE_PICTURE
    }

    /* renamed from: case  reason: not valid java name */
    void m207case();

    /* renamed from: catch  reason: not valid java name */
    void m208catch();

    /* renamed from: do  reason: not valid java name */
    Cconst m209do();

    /* renamed from: do  reason: not valid java name */
    void m210do(SurfaceTexture surfaceTexture);

    /* renamed from: do  reason: not valid java name */
    void m211do(Runnable runnable);

    /* renamed from: do  reason: not valid java name */
    void m212do(boolean z11);

    /* renamed from: if  reason: not valid java name */
    Cnew m213if();
}
