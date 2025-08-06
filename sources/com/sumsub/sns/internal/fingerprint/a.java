package com.sumsub.sns.internal.fingerprint;

import android.app.ActivityManager;
import android.app.KeyguardManager;
import android.app.admin.DevicePolicyManager;
import android.content.ContentResolver;
import android.content.Context;
import android.content.pm.PackageManager;
import android.content.res.AssetManager;
import android.content.res.Configuration;
import android.hardware.SensorManager;
import android.hardware.input.InputManager;
import android.media.MediaCodecList;
import android.media.RingtoneManager;
import android.os.Environment;
import android.os.StatFs;
import androidx.core.hardware.fingerprint.FingerprintManagerCompat;
import com.sumsub.sns.internal.fingerprint.fingerprintingsignals.x;
import com.sumsub.sns.internal.fingerprint.infoproviders.a0;
import com.sumsub.sns.internal.fingerprint.infoproviders.c0;
import com.sumsub.sns.internal.fingerprint.infoproviders.f0;
import com.sumsub.sns.internal.fingerprint.infoproviders.i0;
import com.sumsub.sns.internal.fingerprint.infoproviders.k0;
import com.sumsub.sns.internal.fingerprint.infoproviders.s;
import com.sumsub.sns.internal.fingerprint.infoproviders.u;
import com.sumsub.sns.internal.fingerprint.infoproviders.z;
import java.io.File;
import kotlin.Result;
import kotlin.jvm.internal.Lambda;

public final class a {

    /* renamed from: a  reason: collision with root package name */
    public static final a f34278a = new a();

    /* renamed from: com.sumsub.sns.internal.fingerprint.a$a  reason: collision with other inner class name */
    public static final class C0389a extends Lambda implements d10.a<MediaCodecList> {

        /* renamed from: a  reason: collision with root package name */
        public static final C0389a f34279a = new C0389a();

        public C0389a() {
            super(0);
        }

        /* renamed from: a */
        public final MediaCodecList invoke() {
            return new MediaCodecList(1);
        }
    }

    public static final class b extends Lambda implements d10.a<RingtoneManager> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Context f34280a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public b(Context context) {
            super(0);
            this.f34280a = context;
        }

        /* renamed from: a */
        public final RingtoneManager invoke() {
            return new RingtoneManager(this.f34280a);
        }
    }

    public static final class c extends Lambda implements d10.a<AssetManager> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Context f34281a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public c(Context context) {
            super(0);
            this.f34281a = context;
        }

        /* renamed from: a */
        public final AssetManager invoke() {
            return this.f34281a.getAssets();
        }
    }

    public static final class d extends Lambda implements d10.a<Configuration> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Context f34282a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public d(Context context) {
            super(0);
            this.f34282a = context;
        }

        /* renamed from: a */
        public final Configuration invoke() {
            return this.f34282a.getResources().getConfiguration();
        }
    }

    public static final class e extends Lambda implements d10.a<DevicePolicyManager> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Context f34283a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public e(Context context) {
            super(0);
            this.f34283a = context;
        }

        /* renamed from: a */
        public final DevicePolicyManager invoke() {
            return (DevicePolicyManager) this.f34283a.getSystemService("device_policy");
        }
    }

    public static final class f extends Lambda implements d10.a<KeyguardManager> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Context f34284a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public f(Context context) {
            super(0);
            this.f34284a = context;
        }

        /* renamed from: a */
        public final KeyguardManager invoke() {
            return (KeyguardManager) this.f34284a.getSystemService("keyguard");
        }
    }

    public static final class g extends Lambda implements d10.a<FingerprintManagerCompat> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Context f34285a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public g(Context context) {
            super(0);
            this.f34285a = context;
        }

        /* renamed from: a */
        public final FingerprintManagerCompat invoke() {
            return FingerprintManagerCompat.b(this.f34285a);
        }
    }

    public static final class h extends Lambda implements d10.a<b> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Context f34286a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public h(Context context) {
            super(0);
            this.f34286a = context;
        }

        /* renamed from: a */
        public final b invoke() {
            return new b(a.f34278a.g(this.f34286a));
        }
    }

    public static final class i extends Lambda implements d10.a<ActivityManager> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Context f34287a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public i(Context context) {
            super(0);
            this.f34287a = context;
        }

        /* renamed from: a */
        public final ActivityManager invoke() {
            return (ActivityManager) this.f34287a.getSystemService("activity");
        }
    }

    public static final class j extends Lambda implements d10.a<InputManager> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Context f34288a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public j(Context context) {
            super(0);
            this.f34288a = context;
        }

        /* renamed from: a */
        public final InputManager invoke() {
            return (InputManager) this.f34288a.getSystemService("input");
        }
    }

    public static final class k extends Lambda implements d10.a<ActivityManager> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Context f34289a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public k(Context context) {
            super(0);
            this.f34289a = context;
        }

        /* renamed from: a */
        public final ActivityManager invoke() {
            return (ActivityManager) this.f34289a.getSystemService("activity");
        }
    }

    public static final class l extends Lambda implements d10.a<StatFs> {

        /* renamed from: a  reason: collision with root package name */
        public static final l f34290a = new l();

        public l() {
            super(0);
        }

        /* renamed from: a */
        public final StatFs invoke() {
            return new StatFs(Environment.getRootDirectory().getAbsolutePath());
        }
    }

    public static final class m extends Lambda implements d10.a<StatFs> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Context f34291a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public m(Context context) {
            super(0);
            this.f34291a = context;
        }

        /* renamed from: a */
        public final StatFs invoke() {
            File externalFilesDir = this.f34291a.getExternalFilesDir((String) null);
            if (externalFilesDir == null) {
                return null;
            }
            if (!externalFilesDir.canRead()) {
                externalFilesDir = null;
            }
            if (externalFilesDir != null) {
                return new StatFs(externalFilesDir.getAbsolutePath());
            }
            return null;
        }
    }

    public static final class n extends Lambda implements d10.a<PackageManager> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Context f34292a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public n(Context context) {
            super(0);
            this.f34292a = context;
        }

        /* renamed from: a */
        public final PackageManager invoke() {
            return this.f34292a.getPackageManager();
        }
    }

    public static final class o extends Lambda implements d10.a<SensorManager> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Context f34293a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public o(Context context) {
            super(0);
            this.f34293a = context;
        }

        /* renamed from: a */
        public final SensorManager invoke() {
            return (SensorManager) this.f34293a.getSystemService("sensor");
        }
    }

    public static final class p extends Lambda implements d10.a<ContentResolver> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Context f34294a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public p(Context context) {
            super(0);
            this.f34294a = context;
        }

        /* renamed from: a */
        public final ContentResolver invoke() {
            return this.f34294a.getContentResolver();
        }
    }

    public final com.sumsub.sns.internal.fingerprint.infoproviders.h b() {
        MediaCodecList mediaCodecList = null;
        Object a11 = com.sumsub.sns.internal.fingerprint.tools.threading.safe.c.a(0, C0389a.f34279a, 1, (Object) null);
        if (!Result.m3078isFailureimpl(a11)) {
            mediaCodecList = a11;
        }
        return new com.sumsub.sns.internal.fingerprint.infoproviders.h(mediaCodecList);
    }

    public final com.sumsub.sns.internal.fingerprint.infoproviders.k c() {
        return new com.sumsub.sns.internal.fingerprint.infoproviders.k();
    }

    public final c0 d() {
        return new c0();
    }

    public final s e(Context context) {
        FingerprintManagerCompat fingerprintManagerCompat = null;
        Object a11 = com.sumsub.sns.internal.fingerprint.tools.threading.safe.c.a(0, new g(context), 1, (Object) null);
        if (!Result.m3078isFailureimpl(a11)) {
            fingerprintManagerCompat = a11;
        }
        return new s(fingerprintManagerCompat);
    }

    public final Fingerprinter f(Context context) {
        return new Fingerprinter(new h(context));
    }

    public final x g(Context context) {
        return new x(c(), j(context), l(context), i(context), b(context), a(), h(context), d(), b(), d(context), k(context), m(context), c(context), e(context));
    }

    public final u h(Context context) {
        ActivityManager activityManager = null;
        Object a11 = com.sumsub.sns.internal.fingerprint.tools.threading.safe.c.a(0, new i(context), 1, (Object) null);
        if (!Result.m3078isFailureimpl(a11)) {
            activityManager = a11;
        }
        return new u(activityManager);
    }

    public final com.sumsub.sns.internal.fingerprint.infoproviders.x i(Context context) {
        InputManager inputManager = null;
        Object a11 = com.sumsub.sns.internal.fingerprint.tools.threading.safe.c.a(0, new j(context), 1, (Object) null);
        if (!Result.m3078isFailureimpl(a11)) {
            inputManager = a11;
        }
        return new com.sumsub.sns.internal.fingerprint.infoproviders.x(inputManager);
    }

    public final z j(Context context) {
        StatFs statFs = null;
        Object a11 = com.sumsub.sns.internal.fingerprint.tools.threading.safe.c.a(0, new k(context), 1, (Object) null);
        if (Result.m3078isFailureimpl(a11)) {
            a11 = null;
        }
        ActivityManager activityManager = (ActivityManager) a11;
        Object a12 = com.sumsub.sns.internal.fingerprint.tools.threading.safe.c.a(0, l.f34290a, 1, (Object) null);
        if (Result.m3078isFailureimpl(a12)) {
            a12 = null;
        }
        StatFs statFs2 = (StatFs) a12;
        Object a13 = com.sumsub.sns.internal.fingerprint.tools.threading.safe.c.a(0, new m(context), 1, (Object) null);
        if (!Result.m3078isFailureimpl(a13)) {
            statFs = a13;
        }
        return new a0(activityManager, statFs2, statFs);
    }

    public final f0 k(Context context) {
        PackageManager packageManager = null;
        Object a11 = com.sumsub.sns.internal.fingerprint.tools.threading.safe.c.a(0, new n(context), 1, (Object) null);
        if (!Result.m3078isFailureimpl(a11)) {
            packageManager = a11;
        }
        return new f0(packageManager);
    }

    public final i0 l(Context context) {
        SensorManager sensorManager = null;
        Object a11 = com.sumsub.sns.internal.fingerprint.tools.threading.safe.c.a(0, new o(context), 1, (Object) null);
        if (!Result.m3078isFailureimpl(a11)) {
            sensorManager = a11;
        }
        return new i0(sensorManager);
    }

    public final k0 m(Context context) {
        ContentResolver contentResolver = null;
        Object a11 = com.sumsub.sns.internal.fingerprint.tools.threading.safe.c.a(0, new p(context), 1, (Object) null);
        if (!Result.m3078isFailureimpl(a11)) {
            contentResolver = a11;
        }
        return new k0(contentResolver);
    }

    public static final Fingerprinter a(Context context) {
        return f34278a.f(context);
    }

    public final com.sumsub.sns.internal.fingerprint.infoproviders.n c(Context context) {
        Configuration configuration = null;
        Object a11 = com.sumsub.sns.internal.fingerprint.tools.threading.safe.c.a(0, new b(context), 1, (Object) null);
        if (Result.m3078isFailureimpl(a11)) {
            a11 = null;
        }
        RingtoneManager ringtoneManager = (RingtoneManager) a11;
        Object a12 = com.sumsub.sns.internal.fingerprint.tools.threading.safe.c.a(0, new c(context), 1, (Object) null);
        if (Result.m3078isFailureimpl(a12)) {
            a12 = null;
        }
        AssetManager assetManager = (AssetManager) a12;
        Object a13 = com.sumsub.sns.internal.fingerprint.tools.threading.safe.c.a(0, new d(context), 1, (Object) null);
        if (!Result.m3078isFailureimpl(a13)) {
            configuration = a13;
        }
        return new com.sumsub.sns.internal.fingerprint.infoproviders.n(ringtoneManager, assetManager, configuration);
    }

    public final com.sumsub.sns.internal.fingerprint.infoproviders.p d(Context context) {
        KeyguardManager keyguardManager = null;
        Object a11 = com.sumsub.sns.internal.fingerprint.tools.threading.safe.c.a(0, new e(context), 1, (Object) null);
        if (Result.m3078isFailureimpl(a11)) {
            a11 = null;
        }
        DevicePolicyManager devicePolicyManager = (DevicePolicyManager) a11;
        Object a12 = com.sumsub.sns.internal.fingerprint.tools.threading.safe.c.a(0, new f(context), 1, (Object) null);
        if (!Result.m3078isFailureimpl(a12)) {
            keyguardManager = a12;
        }
        return new com.sumsub.sns.internal.fingerprint.infoproviders.p(devicePolicyManager, keyguardManager);
    }

    public final com.sumsub.sns.internal.fingerprint.infoproviders.e a() {
        return new com.sumsub.sns.internal.fingerprint.infoproviders.f();
    }

    public final com.sumsub.sns.internal.fingerprint.infoproviders.b b(Context context) {
        return new com.sumsub.sns.internal.fingerprint.infoproviders.b(context);
    }
}
