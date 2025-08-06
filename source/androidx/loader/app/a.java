package androidx.loader.app;

import android.os.Bundle;
import android.os.Looper;
import android.util.Log;
import androidx.collection.SparseArrayCompat;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.o0;
import androidx.lifecycle.viewmodel.CreationExtras;
import androidx.lifecycle.z;
import androidx.loader.app.LoaderManager;
import com.sumsub.sns.internal.fingerprint.infoproviders.l;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.lang.reflect.Modifier;
import r1.b;

public class a extends LoaderManager {

    /* renamed from: c  reason: collision with root package name */
    public static boolean f10045c = false;

    /* renamed from: a  reason: collision with root package name */
    public final LifecycleOwner f10046a;

    /* renamed from: b  reason: collision with root package name */
    public final c f10047b;

    /* renamed from: androidx.loader.app.a$a  reason: collision with other inner class name */
    public static class C0045a<D> extends MutableLiveData<D> implements b.C0097b<D> {

        /* renamed from: a  reason: collision with root package name */
        public final int f10048a;

        /* renamed from: b  reason: collision with root package name */
        public final Bundle f10049b;

        /* renamed from: c  reason: collision with root package name */
        public final r1.b<D> f10050c;

        /* renamed from: d  reason: collision with root package name */
        public LifecycleOwner f10051d;

        /* renamed from: e  reason: collision with root package name */
        public b<D> f10052e;

        /* renamed from: f  reason: collision with root package name */
        public r1.b<D> f10053f;

        public C0045a(int i11, Bundle bundle, r1.b<D> bVar, r1.b<D> bVar2) {
            this.f10048a = i11;
            this.f10049b = bundle;
            this.f10050c = bVar;
            this.f10053f = bVar2;
            bVar.registerListener(i11, this);
        }

        public void a(r1.b<D> bVar, D d11) {
            if (a.f10045c) {
                Log.v("LoaderManager", "onLoadComplete: " + this);
            }
            if (Looper.myLooper() == Looper.getMainLooper()) {
                setValue(d11);
                return;
            }
            if (a.f10045c) {
                Log.w("LoaderManager", "onLoadComplete was incorrectly called on a background thread");
            }
            postValue(d11);
        }

        public r1.b<D> b(boolean z11) {
            if (a.f10045c) {
                Log.v("LoaderManager", "  Destroying: " + this);
            }
            this.f10050c.cancelLoad();
            this.f10050c.abandon();
            b<D> bVar = this.f10052e;
            if (bVar != null) {
                removeObserver(bVar);
                if (z11) {
                    bVar.c();
                }
            }
            this.f10050c.unregisterListener(this);
            if ((bVar == null || bVar.b()) && !z11) {
                return this.f10050c;
            }
            this.f10050c.reset();
            return this.f10053f;
        }

        public void c(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
            printWriter.print(str);
            printWriter.print("mId=");
            printWriter.print(this.f10048a);
            printWriter.print(" mArgs=");
            printWriter.println(this.f10049b);
            printWriter.print(str);
            printWriter.print("mLoader=");
            printWriter.println(this.f10050c);
            r1.b<D> bVar = this.f10050c;
            bVar.dump(str + "  ", fileDescriptor, printWriter, strArr);
            if (this.f10052e != null) {
                printWriter.print(str);
                printWriter.print("mCallbacks=");
                printWriter.println(this.f10052e);
                b<D> bVar2 = this.f10052e;
                bVar2.a(str + "  ", printWriter);
            }
            printWriter.print(str);
            printWriter.print("mData=");
            printWriter.println(d().dataToString(getValue()));
            printWriter.print(str);
            printWriter.print("mStarted=");
            printWriter.println(hasActiveObservers());
        }

        public r1.b<D> d() {
            return this.f10050c;
        }

        public void e() {
            LifecycleOwner lifecycleOwner = this.f10051d;
            b<D> bVar = this.f10052e;
            if (lifecycleOwner != null && bVar != null) {
                super.removeObserver(bVar);
                observe(lifecycleOwner, bVar);
            }
        }

        public r1.b<D> f(LifecycleOwner lifecycleOwner, LoaderManager.a<D> aVar) {
            b<D> bVar = new b<>(this.f10050c, aVar);
            observe(lifecycleOwner, bVar);
            b<D> bVar2 = this.f10052e;
            if (bVar2 != null) {
                removeObserver(bVar2);
            }
            this.f10051d = lifecycleOwner;
            this.f10052e = bVar;
            return this.f10050c;
        }

        public void onActive() {
            if (a.f10045c) {
                Log.v("LoaderManager", "  Starting: " + this);
            }
            this.f10050c.startLoading();
        }

        public void onInactive() {
            if (a.f10045c) {
                Log.v("LoaderManager", "  Stopping: " + this);
            }
            this.f10050c.stopLoading();
        }

        public void removeObserver(z<? super D> zVar) {
            super.removeObserver(zVar);
            this.f10051d = null;
            this.f10052e = null;
        }

        public void setValue(D d11) {
            super.setValue(d11);
            r1.b<D> bVar = this.f10053f;
            if (bVar != null) {
                bVar.reset();
                this.f10053f = null;
            }
        }

        public String toString() {
            StringBuilder sb2 = new StringBuilder(64);
            sb2.append("LoaderInfo{");
            sb2.append(Integer.toHexString(System.identityHashCode(this)));
            sb2.append(" #");
            sb2.append(this.f10048a);
            sb2.append(" : ");
            androidx.core.util.a.a(this.f10050c, sb2);
            sb2.append("}}");
            return sb2.toString();
        }
    }

    public static class b<D> implements z<D> {

        /* renamed from: b  reason: collision with root package name */
        public final r1.b<D> f10054b;

        /* renamed from: c  reason: collision with root package name */
        public final LoaderManager.a<D> f10055c;

        /* renamed from: d  reason: collision with root package name */
        public boolean f10056d = false;

        public b(r1.b<D> bVar, LoaderManager.a<D> aVar) {
            this.f10054b = bVar;
            this.f10055c = aVar;
        }

        public void a(String str, PrintWriter printWriter) {
            printWriter.print(str);
            printWriter.print("mDeliveredData=");
            printWriter.println(this.f10056d);
        }

        public boolean b() {
            return this.f10056d;
        }

        public void c() {
            if (this.f10056d) {
                if (a.f10045c) {
                    Log.v("LoaderManager", "  Resetting: " + this.f10054b);
                }
                this.f10055c.onLoaderReset(this.f10054b);
            }
        }

        public void onChanged(D d11) {
            if (a.f10045c) {
                Log.v("LoaderManager", "  onLoadFinished in " + this.f10054b + l.f34627b + this.f10054b.dataToString(d11));
            }
            this.f10055c.onLoadFinished(this.f10054b, d11);
            this.f10056d = true;
        }

        public String toString() {
            return this.f10055c.toString();
        }
    }

    public static class c extends ViewModel {

        /* renamed from: c  reason: collision with root package name */
        public static final ViewModelProvider.Factory f10057c = new C0046a();

        /* renamed from: a  reason: collision with root package name */
        public SparseArrayCompat<C0045a> f10058a = new SparseArrayCompat<>();

        /* renamed from: b  reason: collision with root package name */
        public boolean f10059b = false;

        /* renamed from: androidx.loader.app.a$c$a  reason: collision with other inner class name */
        public static class C0046a implements ViewModelProvider.Factory {
            public <T extends ViewModel> T create(Class<T> cls) {
                return new c();
            }

            public /* synthetic */ ViewModel create(Class cls, CreationExtras creationExtras) {
                return o0.b(this, cls, creationExtras);
            }
        }

        public static c i0(ViewModelStore viewModelStore) {
            return (c) new ViewModelProvider(viewModelStore, f10057c).a(c.class);
        }

        public void b(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
            if (this.f10058a.p() > 0) {
                printWriter.print(str);
                printWriter.println("Loaders:");
                String str2 = str + "    ";
                for (int i11 = 0; i11 < this.f10058a.p(); i11++) {
                    C0045a q11 = this.f10058a.q(i11);
                    printWriter.print(str);
                    printWriter.print("  #");
                    printWriter.print(this.f10058a.l(i11));
                    printWriter.print(l.f34627b);
                    printWriter.println(q11.toString());
                    q11.c(str2, fileDescriptor, printWriter, strArr);
                }
            }
        }

        public void h0() {
            this.f10059b = false;
        }

        public <D> C0045a<D> j0(int i11) {
            return this.f10058a.g(i11);
        }

        public boolean k0() {
            return this.f10059b;
        }

        public void l0() {
            int p11 = this.f10058a.p();
            for (int i11 = 0; i11 < p11; i11++) {
                this.f10058a.q(i11).e();
            }
        }

        public void m0(int i11, C0045a aVar) {
            this.f10058a.m(i11, aVar);
        }

        public void n0() {
            this.f10059b = true;
        }

        public void onCleared() {
            super.onCleared();
            int p11 = this.f10058a.p();
            for (int i11 = 0; i11 < p11; i11++) {
                this.f10058a.q(i11).b(true);
            }
            this.f10058a.c();
        }
    }

    public a(LifecycleOwner lifecycleOwner, ViewModelStore viewModelStore) {
        this.f10046a = lifecycleOwner;
        this.f10047b = c.i0(viewModelStore);
    }

    @Deprecated
    public void a(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        this.f10047b.b(str, fileDescriptor, printWriter, strArr);
    }

    public <D> r1.b<D> c(int i11, Bundle bundle, LoaderManager.a<D> aVar) {
        if (this.f10047b.k0()) {
            throw new IllegalStateException("Called while creating a loader");
        } else if (Looper.getMainLooper() == Looper.myLooper()) {
            C0045a j02 = this.f10047b.j0(i11);
            if (f10045c) {
                Log.v("LoaderManager", "initLoader in " + this + ": args=" + bundle);
            }
            if (j02 == null) {
                return e(i11, bundle, aVar, (r1.b) null);
            }
            if (f10045c) {
                Log.v("LoaderManager", "  Re-using existing loader " + j02);
            }
            return j02.f(this.f10046a, aVar);
        } else {
            throw new IllegalStateException("initLoader must be called on the main thread");
        }
    }

    public void d() {
        this.f10047b.l0();
    }

    /* JADX INFO: finally extract failed */
    public final <D> r1.b<D> e(int i11, Bundle bundle, LoaderManager.a<D> aVar, r1.b<D> bVar) {
        try {
            this.f10047b.n0();
            r1.b<D> onCreateLoader = aVar.onCreateLoader(i11, bundle);
            if (onCreateLoader != null) {
                if (onCreateLoader.getClass().isMemberClass()) {
                    if (!Modifier.isStatic(onCreateLoader.getClass().getModifiers())) {
                        throw new IllegalArgumentException("Object returned from onCreateLoader must not be a non-static inner member class: " + onCreateLoader);
                    }
                }
                C0045a aVar2 = new C0045a(i11, bundle, onCreateLoader, bVar);
                if (f10045c) {
                    Log.v("LoaderManager", "  Created new loader " + aVar2);
                }
                this.f10047b.m0(i11, aVar2);
                this.f10047b.h0();
                return aVar2.f(this.f10046a, aVar);
            }
            throw new IllegalArgumentException("Object returned from onCreateLoader must not be null");
        } catch (Throwable th2) {
            this.f10047b.h0();
            throw th2;
        }
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder(128);
        sb2.append("LoaderManager{");
        sb2.append(Integer.toHexString(System.identityHashCode(this)));
        sb2.append(" in ");
        androidx.core.util.a.a(this.f10046a, sb2);
        sb2.append("}}");
        return sb2.toString();
    }
}
