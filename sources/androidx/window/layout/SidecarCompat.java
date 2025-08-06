package androidx.window.layout;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.ComponentCallbacks;
import android.content.Context;
import android.content.res.Configuration;
import android.os.IBinder;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import androidx.window.core.SpecificationComputer;
import androidx.window.core.Version;
import androidx.window.layout.g;
import androidx.window.sidecar.SidecarDeviceState;
import androidx.window.sidecar.SidecarInterface;
import androidx.window.sidecar.SidecarProvider;
import androidx.window.sidecar.SidecarWindowLayoutInfo;
import java.lang.ref.WeakReference;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.WeakHashMap;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.r;
import kotlin.jvm.internal.x;

@Metadata(bv = {}, d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0000\u0018\u0000 (2\u00020\u0001:\u0005\u0005\n)\u000e*B\u001d\b\u0007\u0012\n\b\u0001\u0010\u0017\u001a\u0004\u0018\u00010\u0013\u0012\u0006\u0010\u001a\u001a\u00020\u0018¢\u0006\u0004\b#\u0010$B\u0011\b\u0016\u0012\u0006\u0010&\u001a\u00020%¢\u0006\u0004\b#\u0010'J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0007J\u0010\u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\u0016\u0010\r\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0007\u001a\u00020\u0006J\u0010\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\b\u0010\u0010\u001a\u00020\u000fH\u0017J\u0010\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u0010\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002R\u0019\u0010\u0017\u001a\u0004\u0018\u00010\u00138\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016R\u0014\u0010\u001a\u001a\u00020\u00188\u0002X\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u0019R \u0010\u001d\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u00060\u001b8\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u001cR \u0010 \u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u001e0\u001b8\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001f\u0010\u001cR\u0018\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b!\u0010\"¨\u0006+"}, d2 = {"Landroidx/window/layout/SidecarCompat;", "Landroidx/window/layout/g;", "Landroidx/window/layout/g$a;", "extensionCallback", "", "a", "Landroid/app/Activity;", "activity", "Landroidx/window/layout/s;", "h", "b", "Landroid/os/IBinder;", "windowToken", "i", "c", "", "l", "j", "k", "Landroidx/window/sidecar/SidecarInterface;", "Landroidx/window/sidecar/SidecarInterface;", "g", "()Landroidx/window/sidecar/SidecarInterface;", "sidecar", "Landroidx/window/layout/SidecarAdapter;", "Landroidx/window/layout/SidecarAdapter;", "sidecarAdapter", "", "Ljava/util/Map;", "windowListenerRegisteredContexts", "Landroid/content/ComponentCallbacks;", "d", "componentCallbackMap", "e", "Landroidx/window/layout/g$a;", "<init>", "(Landroidx/window/sidecar/SidecarInterface;Landroidx/window/layout/SidecarAdapter;)V", "Landroid/content/Context;", "context", "(Landroid/content/Context;)V", "f", "DistinctSidecarElementCallback", "TranslatingCallback", "window_release"}, k = 1, mv = {1, 6, 0})
public final class SidecarCompat implements g {

    /* renamed from: f  reason: collision with root package name */
    public static final a f12083f = new a((r) null);

    /* renamed from: a  reason: collision with root package name */
    public final SidecarInterface f12084a;

    /* renamed from: b  reason: collision with root package name */
    public final SidecarAdapter f12085b;

    /* renamed from: c  reason: collision with root package name */
    public final Map<IBinder, Activity> f12086c;

    /* renamed from: d  reason: collision with root package name */
    public final Map<Activity, ComponentCallbacks> f12087d;

    /* renamed from: e  reason: collision with root package name */
    public g.a f12088e;

    @Metadata(bv = {}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0002\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u000e\u001a\u00020\u000b\u0012\u0006\u0010\u0011\u001a\u00020\u0001¢\u0006\u0004\b\u001d\u0010\u001eJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0018\u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0016R\u0014\u0010\u000e\u001a\u00020\u000b8\u0002X\u0004¢\u0006\u0006\n\u0004\b\f\u0010\rR\u0014\u0010\u0011\u001a\u00020\u00018\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0015\u001a\u00020\u00128\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0018\u0010\u0018\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017R \u0010\u001c\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\b0\u00198\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001a\u0010\u001b¨\u0006\u001f"}, d2 = {"Landroidx/window/layout/SidecarCompat$DistinctSidecarElementCallback;", "Landroidx/window/sidecar/SidecarInterface$SidecarCallback;", "Landroidx/window/sidecar/SidecarDeviceState;", "newDeviceState", "", "onDeviceStateChanged", "Landroid/os/IBinder;", "token", "Landroidx/window/sidecar/SidecarWindowLayoutInfo;", "newLayout", "onWindowLayoutChanged", "Landroidx/window/layout/SidecarAdapter;", "a", "Landroidx/window/layout/SidecarAdapter;", "sidecarAdapter", "b", "Landroidx/window/sidecar/SidecarInterface$SidecarCallback;", "callbackInterface", "Ljava/util/concurrent/locks/ReentrantLock;", "c", "Ljava/util/concurrent/locks/ReentrantLock;", "lock", "d", "Landroidx/window/sidecar/SidecarDeviceState;", "lastDeviceState", "Ljava/util/WeakHashMap;", "e", "Ljava/util/WeakHashMap;", "mActivityWindowLayoutInfo", "<init>", "(Landroidx/window/layout/SidecarAdapter;Landroidx/window/sidecar/SidecarInterface$SidecarCallback;)V", "window_release"}, k = 1, mv = {1, 6, 0})
    public static final class DistinctSidecarElementCallback implements SidecarInterface.SidecarCallback {

        /* renamed from: a  reason: collision with root package name */
        public final SidecarAdapter f12089a;

        /* renamed from: b  reason: collision with root package name */
        public final SidecarInterface.SidecarCallback f12090b;

        /* renamed from: c  reason: collision with root package name */
        public final ReentrantLock f12091c = new ReentrantLock();

        /* renamed from: d  reason: collision with root package name */
        public SidecarDeviceState f12092d;

        /* renamed from: e  reason: collision with root package name */
        public final WeakHashMap<IBinder, SidecarWindowLayoutInfo> f12093e = new WeakHashMap<>();

        public DistinctSidecarElementCallback(SidecarAdapter sidecarAdapter, SidecarInterface.SidecarCallback sidecarCallback) {
            this.f12089a = sidecarAdapter;
            this.f12090b = sidecarCallback;
        }

        public void onDeviceStateChanged(SidecarDeviceState sidecarDeviceState) {
            ReentrantLock reentrantLock = this.f12091c;
            reentrantLock.lock();
            try {
                if (!this.f12089a.a(this.f12092d, sidecarDeviceState)) {
                    this.f12092d = sidecarDeviceState;
                    this.f12090b.onDeviceStateChanged(sidecarDeviceState);
                    Unit unit = Unit.f56620a;
                    reentrantLock.unlock();
                }
            } finally {
                reentrantLock.unlock();
            }
        }

        public void onWindowLayoutChanged(IBinder iBinder, SidecarWindowLayoutInfo sidecarWindowLayoutInfo) {
            synchronized (this.f12091c) {
                if (!this.f12089a.d(this.f12093e.get(iBinder), sidecarWindowLayoutInfo)) {
                    SidecarWindowLayoutInfo put = this.f12093e.put(iBinder, sidecarWindowLayoutInfo);
                    this.f12090b.onWindowLayoutChanged(iBinder, sidecarWindowLayoutInfo);
                }
            }
        }
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0004\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0017J\u0018\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0017¨\u0006\f"}, d2 = {"Landroidx/window/layout/SidecarCompat$TranslatingCallback;", "Landroidx/window/sidecar/SidecarInterface$SidecarCallback;", "(Landroidx/window/layout/SidecarCompat;)V", "onDeviceStateChanged", "", "newDeviceState", "Landroidx/window/sidecar/SidecarDeviceState;", "onWindowLayoutChanged", "windowToken", "Landroid/os/IBinder;", "newLayout", "Landroidx/window/sidecar/SidecarWindowLayoutInfo;", "window_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public final class TranslatingCallback implements SidecarInterface.SidecarCallback {
        public TranslatingCallback() {
        }

        @SuppressLint({"SyntheticAccessor"})
        public void onDeviceStateChanged(SidecarDeviceState sidecarDeviceState) {
            SidecarInterface g11;
            Collection<Activity> values = SidecarCompat.this.f12086c.values();
            SidecarCompat sidecarCompat = SidecarCompat.this;
            for (Activity activity : values) {
                IBinder a11 = SidecarCompat.f12083f.a(activity);
                SidecarWindowLayoutInfo sidecarWindowLayoutInfo = null;
                if (!(a11 == null || (g11 = sidecarCompat.g()) == null)) {
                    sidecarWindowLayoutInfo = g11.getWindowLayoutInfo(a11);
                }
                g.a d11 = sidecarCompat.f12088e;
                if (d11 != null) {
                    d11.a(activity, sidecarCompat.f12085b.e(sidecarWindowLayoutInfo, sidecarDeviceState));
                }
            }
        }

        @SuppressLint({"SyntheticAccessor"})
        public void onWindowLayoutChanged(IBinder iBinder, SidecarWindowLayoutInfo sidecarWindowLayoutInfo) {
            Activity activity = (Activity) SidecarCompat.this.f12086c.get(iBinder);
            if (activity == null) {
                Log.w("SidecarCompat", "Unable to resolve activity from window token. Missing a call to #onWindowLayoutChangeListenerAdded()?");
                return;
            }
            SidecarAdapter e11 = SidecarCompat.this.f12085b;
            SidecarInterface g11 = SidecarCompat.this.g();
            SidecarDeviceState deviceState = g11 == null ? null : g11.getDeviceState();
            if (deviceState == null) {
                deviceState = new SidecarDeviceState();
            }
            s e12 = e11.e(sidecarWindowLayoutInfo, deviceState);
            g.a d11 = SidecarCompat.this.f12088e;
            if (d11 != null) {
                d11.a(activity, e12);
            }
        }
    }

    @Metadata(bv = {}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0013\u0010\u0014J\u0019\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0000¢\u0006\u0004\b\u0005\u0010\u0006J\u001b\u0010\n\u001a\u0004\u0018\u00010\t2\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0000¢\u0006\u0004\b\n\u0010\u000bR\u0013\u0010\u000f\u001a\u0004\u0018\u00010\f8F¢\u0006\u0006\u001a\u0004\b\r\u0010\u000eR\u0014\u0010\u0011\u001a\u00020\u00108\u0002XT¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012¨\u0006\u0015"}, d2 = {"Landroidx/window/layout/SidecarCompat$a;", "", "Landroid/content/Context;", "context", "Landroidx/window/sidecar/SidecarInterface;", "b", "(Landroid/content/Context;)Landroidx/window/sidecar/SidecarInterface;", "Landroid/app/Activity;", "activity", "Landroid/os/IBinder;", "a", "(Landroid/app/Activity;)Landroid/os/IBinder;", "Landroidx/window/core/Version;", "c", "()Landroidx/window/core/Version;", "sidecarVersion", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "window_release"}, k = 1, mv = {1, 6, 0})
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(r rVar) {
            this();
        }

        public final IBinder a(Activity activity) {
            Window window;
            WindowManager.LayoutParams attributes;
            if (activity == null || (window = activity.getWindow()) == null || (attributes = window.getAttributes()) == null) {
                return null;
            }
            return attributes.token;
        }

        public final SidecarInterface b(Context context) {
            return SidecarProvider.getSidecarImpl(context.getApplicationContext());
        }

        public final Version c() {
            try {
                String apiVersion = SidecarProvider.getApiVersion();
                if (!TextUtils.isEmpty(apiVersion)) {
                    return Version.f12043g.b(apiVersion);
                }
                return null;
            } catch (NoClassDefFoundError | UnsupportedOperationException unused) {
                return null;
            }
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\t\u001a\u00020\u0001¢\u0006\u0004\b\u0012\u0010\u0013J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016R\u0014\u0010\t\u001a\u00020\u00018\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\bR\u0014\u0010\r\u001a\u00020\n8\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\fR \u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00040\u000e8\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010¨\u0006\u0014"}, d2 = {"Landroidx/window/layout/SidecarCompat$b;", "Landroidx/window/layout/g$a;", "Landroid/app/Activity;", "activity", "Landroidx/window/layout/s;", "newLayout", "", "a", "Landroidx/window/layout/g$a;", "callbackInterface", "Ljava/util/concurrent/locks/ReentrantLock;", "b", "Ljava/util/concurrent/locks/ReentrantLock;", "lock", "Ljava/util/WeakHashMap;", "c", "Ljava/util/WeakHashMap;", "activityWindowLayoutInfo", "<init>", "(Landroidx/window/layout/g$a;)V", "window_release"}, k = 1, mv = {1, 6, 0})
    public static final class b implements g.a {

        /* renamed from: a  reason: collision with root package name */
        public final g.a f12095a;

        /* renamed from: b  reason: collision with root package name */
        public final ReentrantLock f12096b = new ReentrantLock();

        /* renamed from: c  reason: collision with root package name */
        public final WeakHashMap<Activity, s> f12097c = new WeakHashMap<>();

        public b(g.a aVar) {
            this.f12095a = aVar;
        }

        public void a(Activity activity, s sVar) {
            ReentrantLock reentrantLock = this.f12096b;
            reentrantLock.lock();
            try {
                if (!x.b(sVar, this.f12097c.get(activity))) {
                    s put = this.f12097c.put(activity, sVar);
                    reentrantLock.unlock();
                    this.f12095a.a(activity, sVar);
                }
            } finally {
                reentrantLock.unlock();
            }
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\b\u0002\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\n\u001a\u00020\u0007\u0012\u0006\u0010\u0011\u001a\u00020\f¢\u0006\u0004\b\u0012\u0010\u0013J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016R\u0014\u0010\n\u001a\u00020\u00078\u0002X\u0004¢\u0006\u0006\n\u0004\b\b\u0010\tR\"\u0010\u0010\u001a\u0010\u0012\f\u0012\n \r*\u0004\u0018\u00010\f0\f0\u000b8\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u000f¨\u0006\u0014"}, d2 = {"Landroidx/window/layout/SidecarCompat$c;", "Landroid/view/View$OnAttachStateChangeListener;", "Landroid/view/View;", "view", "", "onViewAttachedToWindow", "onViewDetachedFromWindow", "Landroidx/window/layout/SidecarCompat;", "b", "Landroidx/window/layout/SidecarCompat;", "sidecarCompat", "Ljava/lang/ref/WeakReference;", "Landroid/app/Activity;", "kotlin.jvm.PlatformType", "c", "Ljava/lang/ref/WeakReference;", "activityWeakReference", "activity", "<init>", "(Landroidx/window/layout/SidecarCompat;Landroid/app/Activity;)V", "window_release"}, k = 1, mv = {1, 6, 0})
    public static final class c implements View.OnAttachStateChangeListener {

        /* renamed from: b  reason: collision with root package name */
        public final SidecarCompat f12098b;

        /* renamed from: c  reason: collision with root package name */
        public final WeakReference<Activity> f12099c;

        public c(SidecarCompat sidecarCompat, Activity activity) {
            this.f12098b = sidecarCompat;
            this.f12099c = new WeakReference<>(activity);
        }

        public void onViewAttachedToWindow(View view) {
            view.removeOnAttachStateChangeListener(this);
            Activity activity = (Activity) this.f12099c.get();
            IBinder a11 = SidecarCompat.f12083f.a(activity);
            if (activity != null && a11 != null) {
                this.f12098b.i(a11, activity);
            }
        }

        public void onViewDetachedFromWindow(View view) {
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0006\u001a\u00020\u0004H\u0016¨\u0006\u0007"}, d2 = {"androidx/window/layout/SidecarCompat$d", "Landroid/content/ComponentCallbacks;", "Landroid/content/res/Configuration;", "newConfig", "", "onConfigurationChanged", "onLowMemory", "window_release"}, k = 1, mv = {1, 6, 0})
    public static final class d implements ComponentCallbacks {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ SidecarCompat f12100b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ Activity f12101c;

        public d(SidecarCompat sidecarCompat, Activity activity) {
            this.f12100b = sidecarCompat;
            this.f12101c = activity;
        }

        public void onConfigurationChanged(Configuration configuration) {
            g.a d11 = this.f12100b.f12088e;
            if (d11 != null) {
                Activity activity = this.f12101c;
                d11.a(activity, this.f12100b.h(activity));
            }
        }

        public void onLowMemory() {
        }
    }

    public SidecarCompat(SidecarInterface sidecarInterface, SidecarAdapter sidecarAdapter) {
        this.f12084a = sidecarInterface;
        this.f12085b = sidecarAdapter;
        this.f12086c = new LinkedHashMap();
        this.f12087d = new LinkedHashMap();
    }

    public void a(g.a aVar) {
        this.f12088e = new b(aVar);
        SidecarInterface sidecarInterface = this.f12084a;
        if (sidecarInterface != null) {
            sidecarInterface.setSidecarCallback(new DistinctSidecarElementCallback(this.f12085b, new TranslatingCallback()));
        }
    }

    public void b(Activity activity) {
        IBinder a11 = f12083f.a(activity);
        if (a11 != null) {
            i(a11, activity);
            return;
        }
        activity.getWindow().getDecorView().addOnAttachStateChangeListener(new c(this, activity));
    }

    public void c(Activity activity) {
        SidecarInterface sidecarInterface;
        IBinder a11 = f12083f.a(activity);
        if (a11 != null) {
            SidecarInterface sidecarInterface2 = this.f12084a;
            if (sidecarInterface2 != null) {
                sidecarInterface2.onWindowLayoutChangeListenerRemoved(a11);
            }
            k(activity);
            boolean z11 = this.f12086c.size() == 1;
            this.f12086c.remove(a11);
            if (z11 && (sidecarInterface = this.f12084a) != null) {
                sidecarInterface.onDeviceStateListenersChanged(true);
            }
        }
    }

    public final SidecarInterface g() {
        return this.f12084a;
    }

    public final s h(Activity activity) {
        IBinder a11 = f12083f.a(activity);
        if (a11 == null) {
            return new s(CollectionsKt__CollectionsKt.k());
        }
        SidecarInterface sidecarInterface = this.f12084a;
        SidecarDeviceState sidecarDeviceState = null;
        SidecarWindowLayoutInfo windowLayoutInfo = sidecarInterface == null ? null : sidecarInterface.getWindowLayoutInfo(a11);
        SidecarAdapter sidecarAdapter = this.f12085b;
        SidecarInterface sidecarInterface2 = this.f12084a;
        if (sidecarInterface2 != null) {
            sidecarDeviceState = sidecarInterface2.getDeviceState();
        }
        if (sidecarDeviceState == null) {
            sidecarDeviceState = new SidecarDeviceState();
        }
        return sidecarAdapter.e(windowLayoutInfo, sidecarDeviceState);
    }

    public final void i(IBinder iBinder, Activity activity) {
        SidecarInterface sidecarInterface;
        this.f12086c.put(iBinder, activity);
        SidecarInterface sidecarInterface2 = this.f12084a;
        if (sidecarInterface2 != null) {
            sidecarInterface2.onWindowLayoutChangeListenerAdded(iBinder);
        }
        if (this.f12086c.size() == 1 && (sidecarInterface = this.f12084a) != null) {
            sidecarInterface.onDeviceStateListenersChanged(false);
        }
        g.a aVar = this.f12088e;
        if (aVar != null) {
            aVar.a(activity, h(activity));
        }
        j(activity);
    }

    public final void j(Activity activity) {
        if (this.f12087d.get(activity) == null) {
            d dVar = new d(this, activity);
            this.f12087d.put(activity, dVar);
            activity.registerComponentCallbacks(dVar);
        }
    }

    public final void k(Activity activity) {
        activity.unregisterComponentCallbacks(this.f12087d.get(activity));
        this.f12087d.remove(activity);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v0, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v1, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v1, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v4, resolved type: int} */
    /* JADX WARNING: type inference failed for: r1v3, types: [java.util.List] */
    /* JADX WARNING: Can't wrap try/catch for region: R(10:58|59|60|61|69|70|71|72|73|(2:75|(2:77|97)(2:78|79))(2:80|81)) */
    /* JADX WARNING: Code restructure failed: missing block: B:98:?, code lost:
        return true;
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:72:0x010d */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:10:0x001e A[Catch:{ NoSuchFieldError -> 0x00bf, all -> 0x0195 }] */
    /* JADX WARNING: Removed duplicated region for block: B:11:0x0020 A[Catch:{ NoSuchFieldError -> 0x00bf, all -> 0x0195 }] */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x002c A[Catch:{ NoSuchFieldError -> 0x00bf, all -> 0x0195 }] */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x0057 A[Catch:{ NoSuchFieldError -> 0x00bf, all -> 0x0195 }] */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x0059 A[Catch:{ NoSuchFieldError -> 0x00bf, all -> 0x0195 }] */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x0065 A[Catch:{ NoSuchFieldError -> 0x00bf, all -> 0x0195 }] */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x0080 A[Catch:{ NoSuchFieldError -> 0x00bf, all -> 0x0195 }] */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x0082 A[Catch:{ NoSuchFieldError -> 0x00bf, all -> 0x0195 }] */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x008e A[Catch:{ NoSuchFieldError -> 0x00bf, all -> 0x0195 }] */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x00a9 A[Catch:{ NoSuchFieldError -> 0x00bf, all -> 0x0195 }] */
    /* JADX WARNING: Removed duplicated region for block: B:55:0x00aa A[Catch:{ NoSuchFieldError -> 0x00bf, all -> 0x0195 }] */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x00b6 A[Catch:{ NoSuchFieldError -> 0x00bf, all -> 0x0195 }] */
    /* JADX WARNING: Removed duplicated region for block: B:75:0x013c A[Catch:{ NoSuchFieldError -> 0x00bf, all -> 0x0195 }] */
    /* JADX WARNING: Removed duplicated region for block: B:80:0x014d A[Catch:{ NoSuchFieldError -> 0x00bf, all -> 0x0195 }] */
    /* JADX WARNING: Removed duplicated region for block: B:86:0x0165 A[Catch:{ NoSuchFieldError -> 0x00bf, all -> 0x0195 }] */
    /* JADX WARNING: Removed duplicated region for block: B:88:0x0171 A[Catch:{ NoSuchFieldError -> 0x00bf, all -> 0x0195 }] */
    /* JADX WARNING: Removed duplicated region for block: B:90:0x017d A[Catch:{ NoSuchFieldError -> 0x00bf, all -> 0x0195 }] */
    /* JADX WARNING: Removed duplicated region for block: B:92:0x0189 A[Catch:{ NoSuchFieldError -> 0x00bf, all -> 0x0195 }] */
    @android.annotation.SuppressLint({"BanUncheckedReflection"})
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean l() {
        /*
            r8 = this;
            r0 = 1
            r1 = 0
            androidx.window.sidecar.SidecarInterface r2 = r8.f12084a     // Catch:{ all -> 0x0195 }
            r3 = 0
            if (r2 != 0) goto L_0x0009
        L_0x0007:
            r2 = r3
            goto L_0x001c
        L_0x0009:
            java.lang.Class r2 = r2.getClass()     // Catch:{ all -> 0x0195 }
            if (r2 != 0) goto L_0x0010
            goto L_0x0007
        L_0x0010:
            java.lang.String r4 = "setSidecarCallback"
            java.lang.Class[] r5 = new java.lang.Class[r0]     // Catch:{ all -> 0x0195 }
            java.lang.Class<androidx.window.sidecar.SidecarInterface$SidecarCallback> r6 = androidx.window.sidecar.SidecarInterface.SidecarCallback.class
            r5[r1] = r6     // Catch:{ all -> 0x0195 }
            java.lang.reflect.Method r2 = r2.getMethod(r4, r5)     // Catch:{ all -> 0x0195 }
        L_0x001c:
            if (r2 != 0) goto L_0x0020
            r2 = r3
            goto L_0x0024
        L_0x0020:
            java.lang.Class r2 = r2.getReturnType()     // Catch:{ all -> 0x0195 }
        L_0x0024:
            java.lang.Class r4 = java.lang.Void.TYPE     // Catch:{ all -> 0x0195 }
            boolean r4 = kotlin.jvm.internal.x.b(r2, r4)     // Catch:{ all -> 0x0195 }
            if (r4 == 0) goto L_0x0189
            androidx.window.sidecar.SidecarInterface r2 = r8.f12084a     // Catch:{ all -> 0x0195 }
            if (r2 != 0) goto L_0x0031
            goto L_0x0034
        L_0x0031:
            r2.getDeviceState()     // Catch:{ all -> 0x0195 }
        L_0x0034:
            androidx.window.sidecar.SidecarInterface r2 = r8.f12084a     // Catch:{ all -> 0x0195 }
            if (r2 != 0) goto L_0x0039
            goto L_0x003c
        L_0x0039:
            r2.onDeviceStateListenersChanged(r0)     // Catch:{ all -> 0x0195 }
        L_0x003c:
            androidx.window.sidecar.SidecarInterface r2 = r8.f12084a     // Catch:{ all -> 0x0195 }
            if (r2 != 0) goto L_0x0042
        L_0x0040:
            r2 = r3
            goto L_0x0055
        L_0x0042:
            java.lang.Class r2 = r2.getClass()     // Catch:{ all -> 0x0195 }
            if (r2 != 0) goto L_0x0049
            goto L_0x0040
        L_0x0049:
            java.lang.String r4 = "getWindowLayoutInfo"
            java.lang.Class[] r5 = new java.lang.Class[r0]     // Catch:{ all -> 0x0195 }
            java.lang.Class<android.os.IBinder> r6 = android.os.IBinder.class
            r5[r1] = r6     // Catch:{ all -> 0x0195 }
            java.lang.reflect.Method r2 = r2.getMethod(r4, r5)     // Catch:{ all -> 0x0195 }
        L_0x0055:
            if (r2 != 0) goto L_0x0059
            r2 = r3
            goto L_0x005d
        L_0x0059:
            java.lang.Class r2 = r2.getReturnType()     // Catch:{ all -> 0x0195 }
        L_0x005d:
            java.lang.Class<androidx.window.sidecar.SidecarWindowLayoutInfo> r4 = androidx.window.sidecar.SidecarWindowLayoutInfo.class
            boolean r4 = kotlin.jvm.internal.x.b(r2, r4)     // Catch:{ all -> 0x0195 }
            if (r4 == 0) goto L_0x017d
            androidx.window.sidecar.SidecarInterface r2 = r8.f12084a     // Catch:{ all -> 0x0195 }
            if (r2 != 0) goto L_0x006b
        L_0x0069:
            r2 = r3
            goto L_0x007e
        L_0x006b:
            java.lang.Class r2 = r2.getClass()     // Catch:{ all -> 0x0195 }
            if (r2 != 0) goto L_0x0072
            goto L_0x0069
        L_0x0072:
            java.lang.String r4 = "onWindowLayoutChangeListenerAdded"
            java.lang.Class[] r5 = new java.lang.Class[r0]     // Catch:{ all -> 0x0195 }
            java.lang.Class<android.os.IBinder> r6 = android.os.IBinder.class
            r5[r1] = r6     // Catch:{ all -> 0x0195 }
            java.lang.reflect.Method r2 = r2.getMethod(r4, r5)     // Catch:{ all -> 0x0195 }
        L_0x007e:
            if (r2 != 0) goto L_0x0082
            r2 = r3
            goto L_0x0086
        L_0x0082:
            java.lang.Class r2 = r2.getReturnType()     // Catch:{ all -> 0x0195 }
        L_0x0086:
            java.lang.Class r4 = java.lang.Void.TYPE     // Catch:{ all -> 0x0195 }
            boolean r4 = kotlin.jvm.internal.x.b(r2, r4)     // Catch:{ all -> 0x0195 }
            if (r4 == 0) goto L_0x0171
            androidx.window.sidecar.SidecarInterface r2 = r8.f12084a     // Catch:{ all -> 0x0195 }
            if (r2 != 0) goto L_0x0094
        L_0x0092:
            r2 = r3
            goto L_0x00a7
        L_0x0094:
            java.lang.Class r2 = r2.getClass()     // Catch:{ all -> 0x0195 }
            if (r2 != 0) goto L_0x009b
            goto L_0x0092
        L_0x009b:
            java.lang.String r4 = "onWindowLayoutChangeListenerRemoved"
            java.lang.Class[] r5 = new java.lang.Class[r0]     // Catch:{ all -> 0x0195 }
            java.lang.Class<android.os.IBinder> r6 = android.os.IBinder.class
            r5[r1] = r6     // Catch:{ all -> 0x0195 }
            java.lang.reflect.Method r2 = r2.getMethod(r4, r5)     // Catch:{ all -> 0x0195 }
        L_0x00a7:
            if (r2 != 0) goto L_0x00aa
            goto L_0x00ae
        L_0x00aa:
            java.lang.Class r3 = r2.getReturnType()     // Catch:{ all -> 0x0195 }
        L_0x00ae:
            java.lang.Class r2 = java.lang.Void.TYPE     // Catch:{ all -> 0x0195 }
            boolean r2 = kotlin.jvm.internal.x.b(r3, r2)     // Catch:{ all -> 0x0195 }
            if (r2 == 0) goto L_0x0165
            androidx.window.sidecar.SidecarDeviceState r2 = new androidx.window.sidecar.SidecarDeviceState     // Catch:{ all -> 0x0195 }
            r2.<init>()     // Catch:{ all -> 0x0195 }
            r3 = 3
            r2.posture = r3     // Catch:{ NoSuchFieldError -> 0x00bf }
            goto L_0x00f2
        L_0x00bf:
            java.lang.Class<androidx.window.sidecar.SidecarDeviceState> r4 = androidx.window.sidecar.SidecarDeviceState.class
            java.lang.String r5 = "setPosture"
            java.lang.Class[] r6 = new java.lang.Class[r0]     // Catch:{ all -> 0x0195 }
            java.lang.Class r7 = java.lang.Integer.TYPE     // Catch:{ all -> 0x0195 }
            r6[r1] = r7     // Catch:{ all -> 0x0195 }
            java.lang.reflect.Method r4 = r4.getMethod(r5, r6)     // Catch:{ all -> 0x0195 }
            java.lang.Object[] r5 = new java.lang.Object[r0]     // Catch:{ all -> 0x0195 }
            java.lang.Integer r6 = java.lang.Integer.valueOf(r3)     // Catch:{ all -> 0x0195 }
            r5[r1] = r6     // Catch:{ all -> 0x0195 }
            r4.invoke(r2, r5)     // Catch:{ all -> 0x0195 }
            java.lang.Class<androidx.window.sidecar.SidecarDeviceState> r4 = androidx.window.sidecar.SidecarDeviceState.class
            java.lang.String r5 = "getPosture"
            java.lang.Class[] r6 = new java.lang.Class[r1]     // Catch:{ all -> 0x0195 }
            java.lang.reflect.Method r4 = r4.getMethod(r5, r6)     // Catch:{ all -> 0x0195 }
            java.lang.Object[] r5 = new java.lang.Object[r1]     // Catch:{ all -> 0x0195 }
            java.lang.Object r2 = r4.invoke(r2, r5)     // Catch:{ all -> 0x0195 }
            if (r2 == 0) goto L_0x015d
            java.lang.Integer r2 = (java.lang.Integer) r2     // Catch:{ all -> 0x0195 }
            int r2 = r2.intValue()     // Catch:{ all -> 0x0195 }
            if (r2 != r3) goto L_0x0155
        L_0x00f2:
            androidx.window.sidecar.SidecarDisplayFeature r2 = new androidx.window.sidecar.SidecarDisplayFeature     // Catch:{ all -> 0x0195 }
            r2.<init>()     // Catch:{ all -> 0x0195 }
            android.graphics.Rect r3 = r2.getRect()     // Catch:{ all -> 0x0195 }
            r2.setRect(r3)     // Catch:{ all -> 0x0195 }
            r2.getType()     // Catch:{ all -> 0x0195 }
            r2.setType(r0)     // Catch:{ all -> 0x0195 }
            androidx.window.sidecar.SidecarWindowLayoutInfo r3 = new androidx.window.sidecar.SidecarWindowLayoutInfo     // Catch:{ all -> 0x0195 }
            r3.<init>()     // Catch:{ all -> 0x0195 }
            java.util.List r1 = r3.displayFeatures     // Catch:{ NoSuchFieldError -> 0x010d }
            goto L_0x0196
        L_0x010d:
            java.util.ArrayList r4 = new java.util.ArrayList     // Catch:{ all -> 0x0195 }
            r4.<init>()     // Catch:{ all -> 0x0195 }
            r4.add(r2)     // Catch:{ all -> 0x0195 }
            java.lang.Class<androidx.window.sidecar.SidecarWindowLayoutInfo> r2 = androidx.window.sidecar.SidecarWindowLayoutInfo.class
            java.lang.String r5 = "setDisplayFeatures"
            java.lang.Class[] r6 = new java.lang.Class[r0]     // Catch:{ all -> 0x0195 }
            java.lang.Class<java.util.List> r7 = java.util.List.class
            r6[r1] = r7     // Catch:{ all -> 0x0195 }
            java.lang.reflect.Method r2 = r2.getMethod(r5, r6)     // Catch:{ all -> 0x0195 }
            java.lang.Object[] r5 = new java.lang.Object[r0]     // Catch:{ all -> 0x0195 }
            r5[r1] = r4     // Catch:{ all -> 0x0195 }
            r2.invoke(r3, r5)     // Catch:{ all -> 0x0195 }
            java.lang.Class<androidx.window.sidecar.SidecarWindowLayoutInfo> r2 = androidx.window.sidecar.SidecarWindowLayoutInfo.class
            java.lang.String r5 = "getDisplayFeatures"
            java.lang.Class[] r6 = new java.lang.Class[r1]     // Catch:{ all -> 0x0195 }
            java.lang.reflect.Method r2 = r2.getMethod(r5, r6)     // Catch:{ all -> 0x0195 }
            java.lang.Object[] r5 = new java.lang.Object[r1]     // Catch:{ all -> 0x0195 }
            java.lang.Object r2 = r2.invoke(r3, r5)     // Catch:{ all -> 0x0195 }
            if (r2 == 0) goto L_0x014d
            java.util.List r2 = (java.util.List) r2     // Catch:{ all -> 0x0195 }
            boolean r2 = kotlin.jvm.internal.x.b(r4, r2)     // Catch:{ all -> 0x0195 }
            if (r2 == 0) goto L_0x0145
            goto L_0x0196
        L_0x0145:
            java.lang.Exception r0 = new java.lang.Exception     // Catch:{ all -> 0x0195 }
            java.lang.String r2 = "Invalid display feature getter/setter"
            r0.<init>(r2)     // Catch:{ all -> 0x0195 }
            throw r0     // Catch:{ all -> 0x0195 }
        L_0x014d:
            java.lang.NullPointerException r0 = new java.lang.NullPointerException     // Catch:{ all -> 0x0195 }
            java.lang.String r2 = "null cannot be cast to non-null type kotlin.collections.List<androidx.window.sidecar.SidecarDisplayFeature>"
            r0.<init>(r2)     // Catch:{ all -> 0x0195 }
            throw r0     // Catch:{ all -> 0x0195 }
        L_0x0155:
            java.lang.Exception r0 = new java.lang.Exception     // Catch:{ all -> 0x0195 }
            java.lang.String r2 = "Invalid device posture getter/setter"
            r0.<init>(r2)     // Catch:{ all -> 0x0195 }
            throw r0     // Catch:{ all -> 0x0195 }
        L_0x015d:
            java.lang.NullPointerException r0 = new java.lang.NullPointerException     // Catch:{ all -> 0x0195 }
            java.lang.String r2 = "null cannot be cast to non-null type kotlin.Int"
            r0.<init>(r2)     // Catch:{ all -> 0x0195 }
            throw r0     // Catch:{ all -> 0x0195 }
        L_0x0165:
            java.lang.NoSuchMethodException r0 = new java.lang.NoSuchMethodException     // Catch:{ all -> 0x0195 }
            java.lang.String r2 = "Illegal return type for 'onWindowLayoutChangeListenerRemoved': "
            java.lang.String r2 = kotlin.jvm.internal.x.i(r2, r3)     // Catch:{ all -> 0x0195 }
            r0.<init>(r2)     // Catch:{ all -> 0x0195 }
            throw r0     // Catch:{ all -> 0x0195 }
        L_0x0171:
            java.lang.NoSuchMethodException r0 = new java.lang.NoSuchMethodException     // Catch:{ all -> 0x0195 }
            java.lang.String r3 = "Illegal return type for 'onWindowLayoutChangeListenerAdded': "
            java.lang.String r2 = kotlin.jvm.internal.x.i(r3, r2)     // Catch:{ all -> 0x0195 }
            r0.<init>(r2)     // Catch:{ all -> 0x0195 }
            throw r0     // Catch:{ all -> 0x0195 }
        L_0x017d:
            java.lang.NoSuchMethodException r0 = new java.lang.NoSuchMethodException     // Catch:{ all -> 0x0195 }
            java.lang.String r3 = "Illegal return type for 'getWindowLayoutInfo': "
            java.lang.String r2 = kotlin.jvm.internal.x.i(r3, r2)     // Catch:{ all -> 0x0195 }
            r0.<init>(r2)     // Catch:{ all -> 0x0195 }
            throw r0     // Catch:{ all -> 0x0195 }
        L_0x0189:
            java.lang.NoSuchMethodException r0 = new java.lang.NoSuchMethodException     // Catch:{ all -> 0x0195 }
            java.lang.String r3 = "Illegal return type for 'setSidecarCallback': "
            java.lang.String r2 = kotlin.jvm.internal.x.i(r3, r2)     // Catch:{ all -> 0x0195 }
            r0.<init>(r2)     // Catch:{ all -> 0x0195 }
            throw r0     // Catch:{ all -> 0x0195 }
        L_0x0195:
            r0 = r1
        L_0x0196:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.window.layout.SidecarCompat.l():boolean");
    }

    public SidecarCompat(Context context) {
        this(f12083f.b(context), new SidecarAdapter((SpecificationComputer.VerificationMode) null, 1, (r) null));
    }
}
