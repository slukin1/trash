package com.sumsub.sns.internal.core.android;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.ActivityResultRegistry;
import androidx.activity.result.contract.ActivityResultContract;
import androidx.activity.result.contract.ActivityResultContracts$OpenDocument;
import androidx.activity.result.contract.ActivityResultContracts$OpenMultipleDocuments;
import androidx.lifecycle.DefaultLifecycleObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.j;
import com.sumsub.log.logger.Logger;
import com.sumsub.sns.internal.core.analytics.Screen;
import com.sumsub.sns.internal.core.analytics.f;
import com.sumsub.sns.internal.core.analytics.o;
import com.sumsub.sns.internal.log.LoggerType;
import com.sumsub.sns.internal.log.c;
import d10.l;
import d10.p;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.r;
import kotlin.jvm.internal.x;

public final class a implements DefaultLifecycleObserver {

    /* renamed from: j  reason: collision with root package name */
    public static final C0320a f31926j = new C0320a((r) null);

    /* renamed from: k  reason: collision with root package name */
    public static final String f31927k = "singlePicker";

    /* renamed from: l  reason: collision with root package name */
    public static final String f31928l = "multiplePicker";

    /* renamed from: a  reason: collision with root package name */
    public final ActivityResultRegistry f31929a;

    /* renamed from: b  reason: collision with root package name */
    public final String f31930b;

    /* renamed from: c  reason: collision with root package name */
    public final String[] f31931c;

    /* renamed from: d  reason: collision with root package name */
    public final p<String, Uri, Unit> f31932d;

    /* renamed from: e  reason: collision with root package name */
    public final p<String, List<? extends Uri>, Unit> f31933e;

    /* renamed from: f  reason: collision with root package name */
    public ActivityResultLauncher<String[]> f31934f;

    /* renamed from: g  reason: collision with root package name */
    public ActivityResultLauncher<String[]> f31935g;

    /* renamed from: h  reason: collision with root package name */
    public String f31936h;

    /* renamed from: i  reason: collision with root package name */
    public final List<b<?, ?>> f31937i;

    /* renamed from: com.sumsub.sns.internal.core.android.a$a  reason: collision with other inner class name */
    public static final class C0320a {
        public /* synthetic */ C0320a(r rVar) {
            this();
        }

        public C0320a() {
        }
    }

    public static final class b<I, O> {

        /* renamed from: a  reason: collision with root package name */
        public final String f31938a;

        /* renamed from: b  reason: collision with root package name */
        public final l<I, Intent> f31939b;

        /* renamed from: c  reason: collision with root package name */
        public final p<Integer, Intent, O> f31940c;

        /* renamed from: d  reason: collision with root package name */
        public final l<O, Unit> f31941d;

        /* renamed from: e  reason: collision with root package name */
        public ActivityResultLauncher<I> f31942e;

        /* renamed from: com.sumsub.sns.internal.core.android.a$b$a  reason: collision with other inner class name */
        public static final class C0321a extends Lambda implements p<Integer, Intent, O> {

            /* renamed from: a  reason: collision with root package name */
            public static final C0321a f31943a = new C0321a();

            public C0321a() {
                super(2);
            }

            public final O a(int i11, Intent intent) {
                return intent;
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                return a(((Number) obj).intValue(), (Intent) obj2);
            }
        }

        /* renamed from: com.sumsub.sns.internal.core.android.a$b$b  reason: collision with other inner class name */
        public static final class C0322b extends ActivityResultContract<I, O> {

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ b<I, O> f31944a;

            public C0322b(b<I, O> bVar) {
                this.f31944a = bVar;
            }

            public Intent createIntent(Context context, I i11) {
                return this.f31944a.d().invoke(i11);
            }

            public O parseResult(int i11, Intent intent) {
                return this.f31944a.f().invoke(Integer.valueOf(i11), intent);
            }
        }

        public b(String str, l<? super I, ? extends Intent> lVar, p<? super Integer, ? super Intent, ? extends O> pVar, l<? super O, Unit> lVar2) {
            this.f31938a = str;
            this.f31939b = lVar;
            this.f31940c = pVar;
            this.f31941d = lVar2;
        }

        public final void a(Object obj) {
            ActivityResultLauncher<I> activityResultLauncher = this.f31942e;
            if (activityResultLauncher != null) {
                activityResultLauncher.a(obj);
            }
        }

        public final ActivityResultContract<I, O> b() {
            return new C0322b(this);
        }

        public final l<O, Unit> c() {
            return this.f31941d;
        }

        public final l<I, Intent> d() {
            return this.f31939b;
        }

        public final String e() {
            return this.f31938a;
        }

        public final p<Integer, Intent, O> f() {
            return this.f31940c;
        }

        public final void g() {
            ActivityResultLauncher<I> activityResultLauncher = this.f31942e;
            if (activityResultLauncher != null) {
                activityResultLauncher.c();
            }
            this.f31942e = null;
        }

        public final ActivityResultCallback<O> a() {
            return new f(this);
        }

        public static final void a(b bVar, Object obj) {
            com.sumsub.sns.internal.log.a aVar = com.sumsub.sns.internal.log.a.f34862a;
            String a11 = c.a(bVar);
            com.sumsub.log.logger.a.d(aVar, a11, "PickerLifecycleObserver.callback: " + bVar.f31938a, (Throwable) null, 4, (Object) null);
            bVar.f31941d.invoke(obj);
        }

        public final void a(ActivityResultRegistry activityResultRegistry, String str) {
            this.f31942e = activityResultRegistry.i(this.f31938a + '_' + str, b(), a());
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ b(String str, l lVar, p pVar, l lVar2, int i11, r rVar) {
            this(str, lVar, (i11 & 4) != 0 ? C0321a.f31943a : pVar, lVar2);
        }
    }

    public a(ActivityResultRegistry activityResultRegistry, String str, String[] strArr, p<? super String, ? super Uri, Unit> pVar, p<? super String, ? super List<? extends Uri>, Unit> pVar2) {
        this.f31929a = activityResultRegistry;
        this.f31930b = str;
        this.f31931c = strArr;
        this.f31932d = pVar;
        this.f31933e = pVar2;
        this.f31937i = new ArrayList();
    }

    public final String[] a() {
        return this.f31931c;
    }

    public final String b() {
        return this.f31936h;
    }

    public final void c(String str) {
        this.f31936h = str;
    }

    public final void d() {
        o.a(f.a(0, 1, (Object) null).a(c() ? Screen.SystemImagePicker : Screen.SystemDocumentPicker).a().m().c(), false, 1, (Object) null);
    }

    public final void e() {
        o.a(f.a(0, 1, (Object) null).a(c() ? Screen.SystemImagePicker : Screen.SystemDocumentPicker).a().o().c(), false, 1, (Object) null);
    }

    public final void f() {
        o.a(f.a(0, 1, (Object) null).a(c() ? Screen.SystemImagePicker : Screen.SystemDocumentPicker).a().b().c(), false, 1, (Object) null);
    }

    public void onCreate(LifecycleOwner lifecycleOwner) {
        com.sumsub.sns.internal.log.a aVar = com.sumsub.sns.internal.log.a.f34862a;
        String a11 = c.a(this);
        com.sumsub.log.logger.a.d(aVar, a11, "PickerLifecycleObserver.onCreate: requestId=" + this.f31936h, (Throwable) null, 4, (Object) null);
        ActivityResultRegistry activityResultRegistry = this.f31929a;
        this.f31934f = activityResultRegistry.i("singlePicker_" + this.f31930b, new ActivityResultContracts$OpenDocument(), new d(this));
        ActivityResultRegistry activityResultRegistry2 = this.f31929a;
        this.f31935g = activityResultRegistry2.i("multiplePicker_" + this.f31930b, new ActivityResultContracts$OpenMultipleDocuments(), new e(this));
        for (b a12 : this.f31937i) {
            a12.a(this.f31929a, this.f31930b);
        }
    }

    public void onDestroy(LifecycleOwner lifecycleOwner) {
        j.b(this, lifecycleOwner);
        ActivityResultLauncher<String[]> activityResultLauncher = this.f31934f;
        if (activityResultLauncher != null) {
            activityResultLauncher.c();
        }
        ActivityResultLauncher<String[]> activityResultLauncher2 = this.f31935g;
        if (activityResultLauncher2 != null) {
            activityResultLauncher2.c();
        }
        for (b g11 : this.f31937i) {
            g11.g();
        }
    }

    public /* bridge */ /* synthetic */ void onPause(LifecycleOwner lifecycleOwner) {
        j.c(this, lifecycleOwner);
    }

    public /* bridge */ /* synthetic */ void onResume(LifecycleOwner lifecycleOwner) {
        j.d(this, lifecycleOwner);
    }

    public /* bridge */ /* synthetic */ void onStart(LifecycleOwner lifecycleOwner) {
        j.e(this, lifecycleOwner);
    }

    public /* bridge */ /* synthetic */ void onStop(LifecycleOwner lifecycleOwner) {
        j.f(this, lifecycleOwner);
    }

    public final <I, O> void a(b<I, O> bVar) {
        T t11;
        Iterator<T> it2 = this.f31937i.iterator();
        while (true) {
            if (!it2.hasNext()) {
                t11 = null;
                break;
            }
            t11 = it2.next();
            if (x.b(((b) t11).e(), bVar.e())) {
                break;
            }
        }
        if (t11 == null) {
            this.f31937i.add(bVar);
            return;
        }
        throw new IllegalStateException("Check failed.".toString());
    }

    public final void b(String str) {
        com.sumsub.sns.internal.log.a aVar = com.sumsub.sns.internal.log.a.f34862a;
        String a11 = c.a(this);
        com.sumsub.log.logger.a.d(aVar, a11, "PickerLifecycleObserver.selectMultipleFile: " + str, (Throwable) null, 4, (Object) null);
        f();
        this.f31936h = str;
        ActivityResultLauncher<String[]> activityResultLauncher = this.f31935g;
        if (activityResultLauncher != null) {
            activityResultLauncher.a(this.f31931c);
        }
    }

    public final boolean c() {
        String[] strArr = this.f31931c;
        if (strArr == null) {
            return false;
        }
        for (String R : strArr) {
            if (!StringsKt__StringsKt.R(R, "image", false, 2, (Object) null)) {
                return false;
            }
        }
        return true;
    }

    public static final void a(a aVar, Uri uri) {
        if (uri == null) {
            aVar.d();
        } else {
            aVar.e();
        }
        com.sumsub.sns.internal.log.a aVar2 = com.sumsub.sns.internal.log.a.f34862a;
        String a11 = c.a(aVar);
        com.sumsub.log.logger.a.d(aVar2, a11, "PickerLifecycleObserver.getSingleContent.callback requestId=" + aVar.f31936h, (Throwable) null, 4, (Object) null);
        String str = aVar.f31936h;
        if (str != null) {
            p<String, Uri, Unit> pVar = aVar.f31932d;
            if (pVar != null) {
                pVar.invoke(str, uri);
            }
            aVar.f31936h = null;
        }
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ a(ActivityResultRegistry activityResultRegistry, String str, String[] strArr, p pVar, p pVar2, int i11, r rVar) {
        this(activityResultRegistry, (i11 & 2) != 0 ? "" : str, (i11 & 4) != 0 ? null : strArr, (i11 & 8) != 0 ? null : pVar, (i11 & 16) != 0 ? null : pVar2);
    }

    public static final void a(a aVar, List list) {
        com.sumsub.sns.internal.log.a aVar2 = com.sumsub.sns.internal.log.a.f34862a;
        String a11 = c.a(aVar);
        com.sumsub.log.logger.a.d(aVar2, a11, "PickerLifecycleObserver.getMultipleContent.callback requestId=" + aVar.f31936h, (Throwable) null, 4, (Object) null);
        if (list == null) {
            aVar.d();
        } else {
            aVar.e();
        }
        String str = aVar.f31936h;
        if (str != null) {
            p<String, List<? extends Uri>, Unit> pVar = aVar.f31933e;
            if (pVar != null) {
                pVar.invoke(str, list);
            }
            aVar.f31936h = null;
        }
    }

    public final boolean a(String str) {
        com.sumsub.sns.internal.log.a aVar = com.sumsub.sns.internal.log.a.f34862a;
        String a11 = c.a(this);
        com.sumsub.log.logger.a.d(aVar, a11, "PickerLifecycleObserver.selectFile: " + str, (Throwable) null, 4, (Object) null);
        f();
        this.f31936h = str;
        try {
            ActivityResultLauncher<String[]> activityResultLauncher = this.f31934f;
            if (activityResultLauncher != null) {
                activityResultLauncher.a(this.f31931c);
            }
            return true;
        } catch (ActivityNotFoundException e11) {
            Logger a12 = com.sumsub.sns.internal.log.a.f34862a.a(LoggerType.KIBANA);
            String a13 = c.a(this);
            a12.e(a13, "PickerLifecycleObserver.selectMultipleFile: " + str, e11);
            return false;
        }
    }

    public final void a(String str, Object obj) {
        T t11;
        com.sumsub.sns.internal.log.a aVar = com.sumsub.sns.internal.log.a.f34862a;
        String a11 = c.a(this);
        com.sumsub.log.logger.a.d(aVar, a11, "PickerLifecycleObserver.startRequest: " + str, (Throwable) null, 4, (Object) null);
        Iterator<T> it2 = this.f31937i.iterator();
        while (true) {
            if (!it2.hasNext()) {
                t11 = null;
                break;
            }
            t11 = it2.next();
            if (x.b(((b) t11).e(), str)) {
                break;
            }
        }
        b bVar = (b) t11;
        if (bVar != null) {
            bVar.a(obj);
        }
    }
}
