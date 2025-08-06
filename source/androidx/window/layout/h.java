package androidx.window.layout;

import android.annotation.SuppressLint;
import android.app.Activity;
import androidx.core.util.Consumer;
import androidx.window.extensions.layout.WindowLayoutComponent;
import androidx.window.extensions.layout.WindowLayoutInfo;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Executor;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.Metadata;
import kotlin.Unit;

@Metadata(bv = {}, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\b\b\b\u0000\u0018\u00002\u00020\u0001:\u0001\nB\u000f\u0012\u0006\u0010\u000e\u001a\u00020\f¢\u0006\u0004\b\u0019\u0010\u001aJ&\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\u0016J\u0016\u0010\u000b\u001a\u00020\t2\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\u0016R\u0014\u0010\u000e\u001a\u00020\f8\u0002X\u0004¢\u0006\u0006\n\u0004\b\n\u0010\rR\u0014\u0010\u0011\u001a\u00020\u000f8\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\u0010R \u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00130\u00128\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015R&\u0010\u0018\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u0006\u0012\u0004\u0012\u00020\u00020\u00128\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0017\u0010\u0015¨\u0006\u001b"}, d2 = {"Landroidx/window/layout/h;", "Landroidx/window/layout/n;", "Landroid/app/Activity;", "activity", "Ljava/util/concurrent/Executor;", "executor", "Landroidx/core/util/Consumer;", "Landroidx/window/layout/s;", "callback", "", "a", "b", "Landroidx/window/extensions/layout/WindowLayoutComponent;", "Landroidx/window/extensions/layout/WindowLayoutComponent;", "component", "Ljava/util/concurrent/locks/ReentrantLock;", "Ljava/util/concurrent/locks/ReentrantLock;", "extensionWindowBackendLock", "", "Landroidx/window/layout/h$a;", "c", "Ljava/util/Map;", "activityToListeners", "d", "listenerToActivity", "<init>", "(Landroidx/window/extensions/layout/WindowLayoutComponent;)V", "window_release"}, k = 1, mv = {1, 6, 0})
public final class h implements n {

    /* renamed from: a  reason: collision with root package name */
    public final WindowLayoutComponent f12110a;

    /* renamed from: b  reason: collision with root package name */
    public final ReentrantLock f12111b = new ReentrantLock();

    /* renamed from: c  reason: collision with root package name */
    public final Map<Activity, a> f12112c = new LinkedHashMap();

    /* renamed from: d  reason: collision with root package name */
    public final Map<Consumer<s>, Activity> f12113d = new LinkedHashMap();

    @SuppressLint({"NewApi"})
    @Metadata(bv = {}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010#\n\u0002\b\u0006\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\u000f\u001a\u00020\r¢\u0006\u0004\b\u0019\u0010\u001aJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0014\u0010\t\u001a\u00020\u00042\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006J\u0014\u0010\n\u001a\u00020\u00042\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006J\u0006\u0010\f\u001a\u00020\u000bR\u0014\u0010\u000f\u001a\u00020\r8\u0002X\u0004¢\u0006\u0006\n\u0004\b\t\u0010\u000eR\u0014\u0010\u0012\u001a\u00020\u00108\u0002X\u0004¢\u0006\u0006\n\u0004\b\f\u0010\u0011R\u0018\u0010\u0014\u001a\u0004\u0018\u00010\u00078\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\n\u0010\u0013R \u0010\u0018\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00060\u00158\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017¨\u0006\u001b"}, d2 = {"Landroidx/window/layout/h$a;", "Ljava/util/function/Consumer;", "Landroidx/window/extensions/layout/WindowLayoutInfo;", "value", "", "a", "Landroidx/core/util/Consumer;", "Landroidx/window/layout/s;", "listener", "b", "d", "", "c", "Landroid/app/Activity;", "Landroid/app/Activity;", "activity", "Ljava/util/concurrent/locks/ReentrantLock;", "Ljava/util/concurrent/locks/ReentrantLock;", "multicastConsumerLock", "Landroidx/window/layout/s;", "lastKnownValue", "", "e", "Ljava/util/Set;", "registeredListeners", "<init>", "(Landroid/app/Activity;)V", "window_release"}, k = 1, mv = {1, 6, 0})
    public static final class a implements java.util.function.Consumer<WindowLayoutInfo> {

        /* renamed from: b  reason: collision with root package name */
        public final Activity f12114b;

        /* renamed from: c  reason: collision with root package name */
        public final ReentrantLock f12115c = new ReentrantLock();

        /* renamed from: d  reason: collision with root package name */
        public s f12116d;

        /* renamed from: e  reason: collision with root package name */
        public final Set<Consumer<s>> f12117e = new LinkedHashSet();

        public a(Activity activity) {
            this.f12114b = activity;
        }

        /* renamed from: a */
        public void accept(WindowLayoutInfo windowLayoutInfo) {
            ReentrantLock reentrantLock = this.f12115c;
            reentrantLock.lock();
            try {
                this.f12116d = i.f12118a.b(this.f12114b, windowLayoutInfo);
                for (Consumer accept : this.f12117e) {
                    accept.accept(this.f12116d);
                }
                Unit unit = Unit.f56620a;
            } finally {
                reentrantLock.unlock();
            }
        }

        public final void b(Consumer<s> consumer) {
            ReentrantLock reentrantLock = this.f12115c;
            reentrantLock.lock();
            try {
                s sVar = this.f12116d;
                if (sVar != null) {
                    consumer.accept(sVar);
                }
                this.f12117e.add(consumer);
            } finally {
                reentrantLock.unlock();
            }
        }

        public final boolean c() {
            return this.f12117e.isEmpty();
        }

        public final void d(Consumer<s> consumer) {
            ReentrantLock reentrantLock = this.f12115c;
            reentrantLock.lock();
            try {
                this.f12117e.remove(consumer);
            } finally {
                reentrantLock.unlock();
            }
        }
    }

    public h(WindowLayoutComponent windowLayoutComponent) {
        this.f12110a = windowLayoutComponent;
    }

    public void a(Activity activity, Executor executor, Consumer<s> consumer) {
        Unit unit;
        ReentrantLock reentrantLock = this.f12111b;
        reentrantLock.lock();
        try {
            a aVar = this.f12112c.get(activity);
            if (aVar == null) {
                unit = null;
            } else {
                aVar.b(consumer);
                this.f12113d.put(consumer, activity);
                unit = Unit.f56620a;
            }
            if (unit == null) {
                a aVar2 = new a(activity);
                this.f12112c.put(activity, aVar2);
                this.f12113d.put(consumer, activity);
                aVar2.b(consumer);
                this.f12110a.addWindowLayoutInfoListener(activity, aVar2);
            }
            Unit unit2 = Unit.f56620a;
        } finally {
            reentrantLock.unlock();
        }
    }

    public void b(Consumer<s> consumer) {
        ReentrantLock reentrantLock = this.f12111b;
        reentrantLock.lock();
        try {
            Activity activity = this.f12113d.get(consumer);
            if (activity != null) {
                a aVar = this.f12112c.get(activity);
                if (aVar == null) {
                    reentrantLock.unlock();
                    return;
                }
                aVar.d(consumer);
                if (aVar.c()) {
                    this.f12110a.removeWindowLayoutInfoListener(aVar);
                }
                Unit unit = Unit.f56620a;
                reentrantLock.unlock();
            }
        } finally {
            reentrantLock.unlock();
        }
    }
}
