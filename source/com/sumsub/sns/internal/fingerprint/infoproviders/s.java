package com.sumsub.sns.internal.fingerprint.infoproviders;

import android.os.Build;
import androidx.core.hardware.fingerprint.FingerprintManagerCompat;
import com.sumsub.sns.internal.fingerprint.tools.threading.safe.c;
import kotlin.Result;
import kotlin.jvm.internal.Lambda;

public final class s implements r {

    /* renamed from: a  reason: collision with root package name */
    public final FingerprintManagerCompat f34646a;

    public static final class a extends Lambda implements d10.a<FingerprintSensorStatus> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ s f34647a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(s sVar) {
            super(0);
            this.f34647a = sVar;
        }

        /* renamed from: a */
        public final FingerprintSensorStatus invoke() {
            if (Build.VERSION.SDK_INT < 23) {
                return FingerprintSensorStatus.NOT_SUPPORTED;
            }
            if (!this.f34647a.f34646a.e()) {
                return FingerprintSensorStatus.NOT_SUPPORTED;
            }
            if (!this.f34647a.f34646a.d()) {
                return FingerprintSensorStatus.SUPPORTED;
            }
            return FingerprintSensorStatus.ENABLED;
        }
    }

    public s(FingerprintManagerCompat fingerprintManagerCompat) {
        this.f34646a = fingerprintManagerCompat;
    }

    public FingerprintSensorStatus a() {
        Object a11 = c.a(0, new a(this), 1, (Object) null);
        FingerprintSensorStatus fingerprintSensorStatus = FingerprintSensorStatus.UNKNOWN;
        if (Result.m3078isFailureimpl(a11)) {
            a11 = fingerprintSensorStatus;
        }
        return (FingerprintSensorStatus) a11;
    }
}
