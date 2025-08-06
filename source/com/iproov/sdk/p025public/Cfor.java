package com.iproov.sdk.p025public;

import android.content.Context;
import android.media.AudioAttributes;
import android.os.Build;
import android.os.Handler;
import android.os.VibrationEffect;
import android.os.Vibrator;
import yv.a;

/* renamed from: com.iproov.sdk.public.for  reason: invalid class name and invalid package */
public class Cfor {

    /* renamed from: do  reason: not valid java name */
    private final Vibrator f1126do;

    /* renamed from: if  reason: not valid java name */
    private final Handler f1127if = new Handler();

    /* renamed from: com.iproov.sdk.public.for$do  reason: invalid class name */
    public enum Cdo {
        FACE_FOUND(50, new long[]{0, 20, 100, 20}, new int[]{0, 255, 0, 255}),
        COMPLETED(0, new long[]{0, 50, 100, 50}, new int[]{0, 255, 0, 255}),
        START_FLASHING(0, new long[]{0, 20}, new int[]{0, 255});
        
        /* access modifiers changed from: private */

        /* renamed from: do  reason: not valid java name */
        public long f1132do;
        /* access modifiers changed from: private */

        /* renamed from: for  reason: not valid java name */
        public int[] f1133for;
        /* access modifiers changed from: private */

        /* renamed from: if  reason: not valid java name */
        public long[] f1134if;

        private Cdo(long j11, long[] jArr, int[] iArr) {
            this.f1132do = j11;
            this.f1134if = jArr;
            this.f1133for = iArr;
        }
    }

    public Cfor(Context context) {
        this.f1126do = (Vibrator) context.getSystemService("vibrator");
    }

    /* access modifiers changed from: private */
    /* renamed from: do  reason: not valid java name */
    public void m1290if(Cdo doVar) {
        if (Build.VERSION.SDK_INT >= 26) {
            try {
                this.f1126do.vibrate(VibrationEffect.createWaveform(doVar.f1134if, doVar.f1133for, -1));
            } catch (IllegalArgumentException e11) {
                e11.printStackTrace();
            }
        } else {
            this.f1126do.vibrate(doVar.f1134if, -1, (AudioAttributes) null);
        }
    }

    /* renamed from: for  reason: not valid java name */
    public void m1291for(Cdo doVar) {
        if (this.f1126do.hasVibrator()) {
            this.f1127if.postDelayed(new a(this, doVar), doVar.f1132do);
        }
    }
}
