package com.sumsub.sns.internal.presentation.screen.preview.ekyc.eid;

import android.app.Activity;
import com.sumsub.sns.internal.presentation.screen.preview.ekyc.eid.a;
import d10.l;
import de.authada.library.api.AuthadaAuthenticationLibrary;
import de.authada.library.api.AuthadaAuthenticationLibraryConfig;
import de.authada.library.api.Can;
import de.authada.library.api.CheckFailedReason;
import de.authada.library.api.RequiredData;
import de.authada.library.api.SecretWrong;
import de.authada.library.api.analytics.AnalyticsCallback;
import de.authada.library.api.authentication.Authentication;
import de.authada.library.api.authentication.AuthenticationCallback;
import de.authada.library.api.authentication.Pin;
import de.authada.library.api.authentication.PinTerminationReason;
import de.authada.library.api.authentication.StartCallback;
import de.authada.library.api.authentication.document.DocumentBuilder;
import de.authada.library.api.pinChanger.PinChanger;
import de.authada.library.api.pinChanger.PinChangerCallback;
import de.authada.library.api.pinChanger.TPin;
import de.authada.library.api.pinChanger.TerminationReason;
import de.authada.library.api.unblock.Puk;
import de.authada.library.api.unblock.Unblocker;
import de.authada.library.api.unblock.UnblockerCallback;
import java.lang.ref.WeakReference;
import java.net.URI;
import java.net.URL;
import kotlin.Unit;

public final class d {

    /* renamed from: a  reason: collision with root package name */
    public final WeakReference<Activity> f35581a;

    /* renamed from: b  reason: collision with root package name */
    public Authentication f35582b;

    /* renamed from: c  reason: collision with root package name */
    public PinChanger f35583c;

    /* renamed from: d  reason: collision with root package name */
    public Unblocker f35584d;

    public static final class a implements AuthenticationCallback {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b f35585a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ b f35586b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ Pin f35587c;

        public a(b bVar, Pin pin) {
            this.f35586b = bVar;
            this.f35587c = pin;
            this.f35585a = bVar;
        }

        public void onAdditionalDataRequired(RequiredData requiredData) {
            this.f35585a.onAdditionalDataRequired(requiredData);
        }

        public void onAuthenticationProgress(int i11) {
            this.f35585a.onAuthenticationProgress(i11);
        }

        public void onConnectionTimeout() {
            this.f35585a.onConnectionTimeout();
        }

        public void onEidCardCheckFailed(CheckFailedReason checkFailedReason) {
            this.f35586b.a(checkFailedReason, this.f35587c);
        }

        public void onEidCardFound() {
            this.f35585a.onEidCardFound();
        }

        public void onEidCardLost() {
            this.f35585a.onEidCardLost();
        }

        public void onImagesRequired(DocumentBuilder documentBuilder) {
            this.f35585a.onImagesRequired(documentBuilder);
        }

        public void onProcessTerminated(PinTerminationReason pinTerminationReason) {
            this.f35585a.onProcessTerminated(pinTerminationReason);
        }

        public void onReturnUrl(URI uri) {
            this.f35585a.onReturnUrl(uri);
        }

        public void onSecretWrong(SecretWrong secretWrong) {
            this.f35586b.a(secretWrong, this.f35587c);
        }

        public void onSuccess(String str) {
            this.f35585a.onSuccess(str);
        }
    }

    public static final class b implements PinChangerCallback {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ c f35588a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ c f35589b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ TPin f35590c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ Pin f35591d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Integer f35592e;

        public b(c cVar, TPin tPin, Pin pin, Integer num) {
            this.f35589b = cVar;
            this.f35590c = tPin;
            this.f35591d = pin;
            this.f35592e = num;
            this.f35588a = cVar;
        }

        public void onEidCardCheckFailed(CheckFailedReason checkFailedReason) {
            this.f35589b.a(checkFailedReason, this.f35590c, this.f35591d, this.f35592e);
        }

        public void onEidCardFound() {
            this.f35588a.onEidCardFound();
        }

        public void onEidCardLost() {
            this.f35588a.onEidCardLost();
        }

        public void onProcessTerminated(TerminationReason terminationReason) {
            this.f35588a.onProcessTerminated(terminationReason);
        }

        public void onSecretWrong(SecretWrong secretWrong) {
            this.f35588a.onSecretWrong(secretWrong);
        }

        public void onSuccess() {
            this.f35588a.onSuccess();
        }
    }

    public d(Activity activity) {
        this.f35581a = new WeakReference<>(activity);
    }

    public final void a(a aVar) {
        if (aVar instanceof a.g) {
            a.g gVar = (a.g) aVar;
            a(gVar.i(), gVar.j(), gVar.h(), gVar.f(), gVar.g());
        } else if (aVar instanceof a.d) {
            a.d dVar = (a.d) aVar;
            a(dVar.h(), dVar.f(), dVar.e(), dVar.g());
        } else if (aVar instanceof a.e) {
            a.e eVar = (a.e) aVar;
            a(eVar.l(), eVar.k(), eVar.h(), eVar.j(), eVar.g(), eVar.i());
        } else if (aVar instanceof a.f) {
            a.f fVar = (a.f) aVar;
            a(fVar.f(), fVar.d(), fVar.e());
        } else if (aVar instanceof a.C0435a) {
            c();
        } else if (aVar instanceof a.b) {
            d();
        } else if (aVar instanceof a.c) {
            b();
        }
    }

    public final void b() {
        Authentication authentication = this.f35582b;
        if (authentication != null) {
            authentication.stop();
        }
        this.f35582b = null;
    }

    public final void c() {
        PinChanger pinChanger = this.f35583c;
        if (pinChanger != null) {
            pinChanger.stop();
        }
        this.f35583c = null;
    }

    public final void d() {
        Unblocker unblocker = this.f35584d;
        if (unblocker != null) {
            unblocker.stop();
        }
        this.f35584d = null;
    }

    public final void a() {
        b();
        c();
        d();
    }

    public final void a(String str, URL url, String str2, StartCallback startCallback, l<? super Throwable, Unit> lVar) {
        a();
        try {
            Activity activity = this.f35581a.get();
            if (activity != null) {
                Authentication authenticate = AuthadaAuthenticationLibrary.INSTANCE.authenticate(AuthadaAuthenticationLibraryConfig.Companion.newInstance(url, str2, activity));
                this.f35582b = authenticate;
                if (authenticate != null) {
                    Authentication.DefaultImpls.start$default(authenticate, str, startCallback, (AnalyticsCallback) null, 4, (Object) null);
                    return;
                }
                return;
            }
            throw new IllegalStateException("Activity is null".toString());
        } catch (Throwable th2) {
            lVar.invoke(th2);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:4:0x001a, code lost:
        r0 = r11.getCan();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(de.authada.library.api.authentication.Pin r10, de.authada.library.api.Can r11, com.sumsub.sns.internal.presentation.screen.preview.ekyc.eid.b r12, d10.l<? super java.lang.Throwable, kotlin.Unit> r13) {
        /*
            r9 = this;
            de.authada.library.api.authentication.Authentication r0 = r9.f35582b
            if (r0 != 0) goto L_0x0037
            com.sumsub.sns.internal.presentation.screen.preview.ekyc.eid.h r12 = new com.sumsub.sns.internal.presentation.screen.preview.ekyc.eid.h
            int[] r0 = r10.getPin()
            r2 = 0
            r3 = 0
            r4 = 0
            r5 = 0
            r6 = 0
            r7 = 62
            r8 = 0
            java.lang.String r1 = ""
            java.lang.String r10 = kotlin.collections.ArraysKt___ArraysKt.g0(r0, r1, r2, r3, r4, r5, r6, r7, r8)
            if (r11 == 0) goto L_0x002f
            int[] r0 = r11.getCan()
            if (r0 == 0) goto L_0x002f
            r2 = 0
            r3 = 0
            r4 = 0
            r5 = 0
            r6 = 0
            r7 = 62
            r8 = 0
            java.lang.String r1 = ""
            java.lang.String r11 = kotlin.collections.ArraysKt___ArraysKt.g0(r0, r1, r2, r3, r4, r5, r6, r7, r8)
            goto L_0x0030
        L_0x002f:
            r11 = 0
        L_0x0030:
            r12.<init>(r10, r11)
            r13.invoke(r12)
            return
        L_0x0037:
            com.sumsub.sns.internal.presentation.screen.preview.ekyc.eid.d$a r0 = new com.sumsub.sns.internal.presentation.screen.preview.ekyc.eid.d$a
            r0.<init>(r12, r10)
            if (r11 == 0) goto L_0x0045
            de.authada.library.api.authentication.Authentication r12 = r9.f35582b     // Catch:{ all -> 0x004d }
            if (r12 == 0) goto L_0x0045
            r12.setCan(r11)     // Catch:{ all -> 0x004d }
        L_0x0045:
            de.authada.library.api.authentication.Authentication r11 = r9.f35582b     // Catch:{ all -> 0x004d }
            if (r11 == 0) goto L_0x0051
            r11.pinAuthentication(r10, r0)     // Catch:{ all -> 0x004d }
            goto L_0x0051
        L_0x004d:
            r10 = move-exception
            r13.invoke(r10)
        L_0x0051:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sumsub.sns.internal.presentation.screen.preview.ekyc.eid.d.a(de.authada.library.api.authentication.Pin, de.authada.library.api.Can, com.sumsub.sns.internal.presentation.screen.preview.ekyc.eid.b, d10.l):void");
    }

    public static /* synthetic */ void a(d dVar, TPin tPin, Pin pin, Can can, Integer num, c cVar, l lVar, int i11, Object obj) {
        if ((i11 & 4) != 0) {
            can = null;
        }
        dVar.a(tPin, pin, can, num, cVar, lVar);
    }

    public final void a(TPin tPin, Pin pin, Can can, Integer num, c cVar, l<? super Throwable, Unit> lVar) {
        b bVar = new b(cVar, tPin, pin, num);
        try {
            Activity activity = this.f35581a.get();
            if (activity != null) {
                PinChanger pinChanger = AuthadaAuthenticationLibrary.INSTANCE.pinChanger();
                this.f35583c = pinChanger;
                if (!(can == null || pinChanger == null)) {
                    pinChanger.setCan(can);
                }
                if (num != null) {
                    num.intValue();
                    PinChanger pinChanger2 = this.f35583c;
                    if (pinChanger2 != null) {
                        pinChanger2._useForTestingOnlySetSixthDigitOfOldPin(num.intValue());
                    }
                }
                PinChanger pinChanger3 = this.f35583c;
                if (pinChanger3 != null) {
                    pinChanger3.changeFiveDigitPin(tPin, pin, activity, bVar);
                    return;
                }
                return;
            }
            throw new IllegalStateException("Activity is null".toString());
        } catch (Throwable th2) {
            lVar.invoke(th2);
        }
    }

    public final void a(Puk puk, UnblockerCallback unblockerCallback, l<? super Throwable, Unit> lVar) {
        try {
            Activity activity = this.f35581a.get();
            if (activity != null) {
                Unblocker unblocker = AuthadaAuthenticationLibrary.INSTANCE.unblocker();
                this.f35584d = unblocker;
                if (unblocker != null) {
                    unblocker.unblock(puk, activity, unblockerCallback);
                    return;
                }
                return;
            }
            throw new IllegalStateException("Activity is null".toString());
        } catch (Throwable th2) {
            lVar.invoke(th2);
        }
    }
}
