package androidx.databinding;

import android.annotation.TargetApi;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Log;
import android.util.SparseIntArray;
import android.view.Choreographer;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.databinding.CallbackRegistry;
import androidx.databinding.Observable;
import androidx.databinding.ObservableList;
import androidx.databinding.ObservableMap;
import androidx.databinding.library.R$id;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.a0;
import androidx.lifecycle.u;
import androidx.lifecycle.z;
import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;

public abstract class f extends BaseObservable implements x1.a {
    public static final View.OnAttachStateChangeListener A;

    /* renamed from: r  reason: collision with root package name */
    public static int f8875r = 0;

    /* renamed from: s  reason: collision with root package name */
    public static final int f8876s = 8;

    /* renamed from: t  reason: collision with root package name */
    public static final boolean f8877t;

    /* renamed from: u  reason: collision with root package name */
    public static final a f8878u = new a();

    /* renamed from: v  reason: collision with root package name */
    public static final a f8879v = new b();

    /* renamed from: w  reason: collision with root package name */
    public static final a f8880w = new c();

    /* renamed from: x  reason: collision with root package name */
    public static final a f8881x = new d();

    /* renamed from: y  reason: collision with root package name */
    public static final CallbackRegistry.NotifierCallback<OnRebindCallback, f, Void> f8882y = new e();

    /* renamed from: z  reason: collision with root package name */
    public static final ReferenceQueue<f> f8883z = new ReferenceQueue<>();

    /* renamed from: b  reason: collision with root package name */
    public final Runnable f8884b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f8885c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f8886d;

    /* renamed from: e  reason: collision with root package name */
    public h[] f8887e;

    /* renamed from: f  reason: collision with root package name */
    public final View f8888f;

    /* renamed from: g  reason: collision with root package name */
    public CallbackRegistry<OnRebindCallback, f, Void> f8889g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f8890h;

    /* renamed from: i  reason: collision with root package name */
    public Choreographer f8891i;

    /* renamed from: j  reason: collision with root package name */
    public final Choreographer.FrameCallback f8892j;

    /* renamed from: k  reason: collision with root package name */
    public Handler f8893k;

    /* renamed from: l  reason: collision with root package name */
    public final b f8894l;

    /* renamed from: m  reason: collision with root package name */
    public f f8895m;

    /* renamed from: n  reason: collision with root package name */
    public LifecycleOwner f8896n;

    /* renamed from: o  reason: collision with root package name */
    public k f8897o;

    /* renamed from: p  reason: collision with root package name */
    public boolean f8898p;

    /* renamed from: q  reason: collision with root package name */
    public boolean f8899q;

    public class a implements a {
        public h a(f fVar, int i11, ReferenceQueue<f> referenceQueue) {
            return new n(fVar, i11, referenceQueue).f();
        }
    }

    public class b implements a {
        public h a(f fVar, int i11, ReferenceQueue<f> referenceQueue) {
            return new l(fVar, i11, referenceQueue).j();
        }
    }

    public class c implements a {
        public h a(f fVar, int i11, ReferenceQueue<f> referenceQueue) {
            return new m(fVar, i11, referenceQueue).f();
        }
    }

    public class d implements a {
        public h a(f fVar, int i11, ReferenceQueue<f> referenceQueue) {
            return new j(fVar, i11, referenceQueue).f();
        }
    }

    public class e extends CallbackRegistry.NotifierCallback<OnRebindCallback, f, Void> {
        /* renamed from: b */
        public void a(OnRebindCallback onRebindCallback, f fVar, int i11, Void voidR) {
            if (i11 != 1) {
                if (i11 == 2) {
                    onRebindCallback.b(fVar);
                } else if (i11 == 3) {
                    onRebindCallback.a(fVar);
                }
            } else if (!onRebindCallback.c(fVar)) {
                boolean unused = fVar.f8886d = true;
            }
        }
    }

    /* renamed from: androidx.databinding.f$f  reason: collision with other inner class name */
    public class C0032f implements View.OnAttachStateChangeListener {
        @TargetApi(19)
        public void onViewAttachedToWindow(View view) {
            f.o(view).f8884b.run();
            view.removeOnAttachStateChangeListener(this);
        }

        public void onViewDetachedFromWindow(View view) {
        }
    }

    public class g implements Runnable {
        public g() {
        }

        public void run() {
            synchronized (this) {
                boolean unused = f.this.f8885c = false;
            }
            f.z();
            if (Build.VERSION.SDK_INT < 19 || f.this.f8888f.isAttachedToWindow()) {
                f.this.l();
                return;
            }
            f.this.f8888f.removeOnAttachStateChangeListener(f.A);
            f.this.f8888f.addOnAttachStateChangeListener(f.A);
        }
    }

    public class h implements Choreographer.FrameCallback {
        public h() {
        }

        public void doFrame(long j11) {
            f.this.f8884b.run();
        }
    }

    public static class i {

        /* renamed from: a  reason: collision with root package name */
        public final String[][] f8902a;

        /* renamed from: b  reason: collision with root package name */
        public final int[][] f8903b;

        /* renamed from: c  reason: collision with root package name */
        public final int[][] f8904c;

        public i(int i11) {
            this.f8902a = new String[i11][];
            this.f8903b = new int[i11][];
            this.f8904c = new int[i11][];
        }

        public void a(int i11, String[] strArr, int[] iArr, int[] iArr2) {
            this.f8902a[i11] = strArr;
            this.f8903b[i11] = iArr;
            this.f8904c[i11] = iArr2;
        }
    }

    public static class j implements z, e<LiveData<?>> {

        /* renamed from: b  reason: collision with root package name */
        public final h<LiveData<?>> f8905b;

        /* renamed from: c  reason: collision with root package name */
        public WeakReference<LifecycleOwner> f8906c = null;

        public j(f fVar, int i11, ReferenceQueue<f> referenceQueue) {
            this.f8905b = new h<>(fVar, i11, this, referenceQueue);
        }

        public void a(LifecycleOwner lifecycleOwner) {
            LifecycleOwner e11 = e();
            LiveData b11 = this.f8905b.b();
            if (b11 != null) {
                if (e11 != null) {
                    b11.removeObserver(this);
                }
                if (lifecycleOwner != null) {
                    b11.observe(lifecycleOwner, this);
                }
            }
            if (lifecycleOwner != null) {
                this.f8906c = new WeakReference<>(lifecycleOwner);
            }
        }

        /* renamed from: d */
        public void c(LiveData<?> liveData) {
            LifecycleOwner e11 = e();
            if (e11 != null) {
                liveData.observe(e11, this);
            }
        }

        public final LifecycleOwner e() {
            WeakReference<LifecycleOwner> weakReference = this.f8906c;
            if (weakReference == null) {
                return null;
            }
            return (LifecycleOwner) weakReference.get();
        }

        public h<LiveData<?>> f() {
            return this.f8905b;
        }

        /* renamed from: g */
        public void b(LiveData<?> liveData) {
            liveData.removeObserver(this);
        }

        public void onChanged(Object obj) {
            f a11 = this.f8905b.a();
            if (a11 != null) {
                h<LiveData<?>> hVar = this.f8905b;
                a11.q(hVar.f8912b, hVar.b(), 0);
            }
        }
    }

    public static class k implements u {

        /* renamed from: b  reason: collision with root package name */
        public final WeakReference<f> f8907b;

        public /* synthetic */ k(f fVar, a aVar) {
            this(fVar);
        }

        @a0(Lifecycle.Event.ON_START)
        public void onStart() {
            f fVar = (f) this.f8907b.get();
            if (fVar != null) {
                fVar.l();
            }
        }

        public k(f fVar) {
            this.f8907b = new WeakReference<>(fVar);
        }
    }

    public static class l extends ObservableList.OnListChangedCallback implements e<ObservableList> {

        /* renamed from: b  reason: collision with root package name */
        public final h<ObservableList> f8908b;

        public l(f fVar, int i11, ReferenceQueue<f> referenceQueue) {
            this.f8908b = new h<>(fVar, i11, this, referenceQueue);
        }

        public void a(LifecycleOwner lifecycleOwner) {
        }

        public void d(ObservableList observableList) {
            ObservableList b11;
            f a11 = this.f8908b.a();
            if (a11 != null && (b11 = this.f8908b.b()) == observableList) {
                a11.q(this.f8908b.f8912b, b11, 0);
            }
        }

        public void e(ObservableList observableList, int i11, int i12) {
            d(observableList);
        }

        public void f(ObservableList observableList, int i11, int i12) {
            d(observableList);
        }

        public void g(ObservableList observableList, int i11, int i12, int i13) {
            d(observableList);
        }

        public void h(ObservableList observableList, int i11, int i12) {
            d(observableList);
        }

        /* renamed from: i */
        public void c(ObservableList observableList) {
            observableList.addOnListChangedCallback(this);
        }

        public h<ObservableList> j() {
            return this.f8908b;
        }

        /* renamed from: k */
        public void b(ObservableList observableList) {
            observableList.removeOnListChangedCallback(this);
        }
    }

    public static class m extends ObservableMap.OnMapChangedCallback implements e<ObservableMap> {

        /* renamed from: b  reason: collision with root package name */
        public final h<ObservableMap> f8909b;

        public m(f fVar, int i11, ReferenceQueue<f> referenceQueue) {
            this.f8909b = new h<>(fVar, i11, this, referenceQueue);
        }

        public void a(LifecycleOwner lifecycleOwner) {
        }

        public void d(ObservableMap observableMap, Object obj) {
            f a11 = this.f8909b.a();
            if (a11 != null && observableMap == this.f8909b.b()) {
                a11.q(this.f8909b.f8912b, observableMap, 0);
            }
        }

        /* renamed from: e */
        public void c(ObservableMap observableMap) {
            observableMap.b(this);
        }

        public h<ObservableMap> f() {
            return this.f8909b;
        }

        /* renamed from: g */
        public void b(ObservableMap observableMap) {
            observableMap.g(this);
        }
    }

    public static class n extends Observable.OnPropertyChangedCallback implements e<Observable> {

        /* renamed from: b  reason: collision with root package name */
        public final h<Observable> f8910b;

        public n(f fVar, int i11, ReferenceQueue<f> referenceQueue) {
            this.f8910b = new h<>(fVar, i11, this, referenceQueue);
        }

        public void a(LifecycleOwner lifecycleOwner) {
        }

        public void d(Observable observable, int i11) {
            f a11 = this.f8910b.a();
            if (a11 != null && this.f8910b.b() == observable) {
                a11.q(this.f8910b.f8912b, observable, i11);
            }
        }

        /* renamed from: e */
        public void c(Observable observable) {
            observable.addOnPropertyChangedCallback(this);
        }

        public h<Observable> f() {
            return this.f8910b;
        }

        /* renamed from: g */
        public void b(Observable observable) {
            observable.removeOnPropertyChangedCallback(this);
        }
    }

    static {
        int i11 = Build.VERSION.SDK_INT;
        f8875r = i11;
        f8877t = i11 >= 16;
        if (i11 < 19) {
            A = null;
        } else {
            A = new C0032f();
        }
    }

    public f(b bVar, View view, int i11) {
        this.f8884b = new g();
        this.f8885c = false;
        this.f8886d = false;
        this.f8894l = bVar;
        this.f8887e = new h[i11];
        this.f8888f = view;
        if (Looper.myLooper() == null) {
            throw new IllegalStateException("DataBinding must be created in view's UI Thread");
        } else if (f8877t) {
            this.f8891i = Choreographer.getInstance();
            this.f8892j = new h();
        } else {
            this.f8892j = null;
            this.f8893k = new Handler(Looper.myLooper());
        }
    }

    public static int C(Integer num) {
        if (num == null) {
            return 0;
        }
        return num.intValue();
    }

    public static boolean D(Boolean bool) {
        if (bool == null) {
            return false;
        }
        return bool.booleanValue();
    }

    public static b h(Object obj) {
        if (obj == null) {
            return null;
        }
        if (obj instanceof b) {
            return (b) obj;
        }
        throw new IllegalArgumentException("The provided bindingComponent parameter must be an instance of DataBindingComponent. See  https://issuetracker.google.com/issues/116541301 for details of why this parameter is not defined as DataBindingComponent");
    }

    public static void k(f fVar) {
        fVar.j();
    }

    public static int m(String str, int i11, i iVar, int i12) {
        CharSequence subSequence = str.subSequence(str.indexOf(47) + 1, str.length() - 2);
        String[] strArr = iVar.f8902a[i12];
        int length = strArr.length;
        while (i11 < length) {
            if (TextUtils.equals(subSequence, strArr[i11])) {
                return i11;
            }
            i11++;
        }
        return -1;
    }

    public static int n(ViewGroup viewGroup, int i11) {
        String str = (String) viewGroup.getChildAt(i11).getTag();
        String substring = str.substring(0, str.length() - 1);
        int length = substring.length();
        int childCount = viewGroup.getChildCount();
        for (int i12 = i11 + 1; i12 < childCount; i12++) {
            View childAt = viewGroup.getChildAt(i12);
            String str2 = childAt.getTag() instanceof String ? (String) childAt.getTag() : null;
            if (str2 != null && str2.startsWith(substring)) {
                if (str2.length() == str.length() && str2.charAt(str2.length() - 1) == '0') {
                    return i11;
                }
                if (u(str2, length)) {
                    i11 = i12;
                }
            }
        }
        return i11;
    }

    public static f o(View view) {
        if (view != null) {
            return (f) view.getTag(R$id.dataBinding);
        }
        return null;
    }

    public static int p(View view, int i11) {
        if (Build.VERSION.SDK_INT >= 23) {
            return view.getContext().getColor(i11);
        }
        return view.getResources().getColor(i11);
    }

    public static <T extends f> T s(LayoutInflater layoutInflater, int i11, ViewGroup viewGroup, boolean z11, Object obj) {
        return c.f(layoutInflater, i11, viewGroup, z11, h(obj));
    }

    public static boolean u(String str, int i11) {
        int length = str.length();
        if (length == i11) {
            return false;
        }
        while (i11 < length) {
            if (!Character.isDigit(str.charAt(i11))) {
                return false;
            }
            i11++;
        }
        return true;
    }

    /* JADX WARNING: Removed duplicated region for block: B:68:0x0101  */
    /* JADX WARNING: Removed duplicated region for block: B:72:0x010e A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void v(androidx.databinding.b r17, android.view.View r18, java.lang.Object[] r19, androidx.databinding.f.i r20, android.util.SparseIntArray r21, boolean r22) {
        /*
            r6 = r17
            r0 = r18
            r7 = r20
            r8 = r21
            androidx.databinding.f r1 = o(r18)
            if (r1 == 0) goto L_0x000f
            return
        L_0x000f:
            java.lang.Object r1 = r18.getTag()
            boolean r2 = r1 instanceof java.lang.String
            if (r2 == 0) goto L_0x001a
            java.lang.String r1 = (java.lang.String) r1
            goto L_0x001b
        L_0x001a:
            r1 = 0
        L_0x001b:
            java.lang.String r9 = "layout"
            r2 = -1
            r11 = 1
            if (r22 == 0) goto L_0x004b
            if (r1 == 0) goto L_0x004b
            boolean r3 = r1.startsWith(r9)
            if (r3 == 0) goto L_0x004b
            r3 = 95
            int r3 = r1.lastIndexOf(r3)
            if (r3 <= 0) goto L_0x0047
            int r3 = r3 + r11
            boolean r4 = u(r1, r3)
            if (r4 == 0) goto L_0x0047
            int r1 = y(r1, r3)
            r3 = r19[r1]
            if (r3 != 0) goto L_0x0042
            r19[r1] = r0
        L_0x0042:
            if (r7 != 0) goto L_0x0045
            r1 = r2
        L_0x0045:
            r3 = r11
            goto L_0x0049
        L_0x0047:
            r1 = r2
            r3 = 0
        L_0x0049:
            r12 = r1
            goto L_0x0069
        L_0x004b:
            if (r1 == 0) goto L_0x0067
            java.lang.String r3 = "binding_"
            boolean r3 = r1.startsWith(r3)
            if (r3 == 0) goto L_0x0067
            int r3 = f8876s
            int r1 = y(r1, r3)
            r3 = r19[r1]
            if (r3 != 0) goto L_0x0061
            r19[r1] = r0
        L_0x0061:
            if (r7 != 0) goto L_0x0064
            r1 = r2
        L_0x0064:
            r12 = r1
            r3 = r11
            goto L_0x0069
        L_0x0067:
            r12 = r2
            r3 = 0
        L_0x0069:
            if (r3 != 0) goto L_0x007f
            int r1 = r18.getId()
            if (r1 <= 0) goto L_0x007f
            if (r8 == 0) goto L_0x007f
            int r1 = r8.get(r1, r2)
            if (r1 < 0) goto L_0x007f
            r2 = r19[r1]
            if (r2 != 0) goto L_0x007f
            r19[r1] = r0
        L_0x007f:
            boolean r1 = r0 instanceof android.view.ViewGroup
            if (r1 == 0) goto L_0x0119
            r13 = r0
            android.view.ViewGroup r13 = (android.view.ViewGroup) r13
            int r14 = r13.getChildCount()
            r0 = 0
            r1 = 0
        L_0x008c:
            if (r0 >= r14) goto L_0x0119
            android.view.View r2 = r13.getChildAt(r0)
            if (r12 < 0) goto L_0x00fc
            java.lang.Object r3 = r2.getTag()
            boolean r3 = r3 instanceof java.lang.String
            if (r3 == 0) goto L_0x00fc
            java.lang.Object r3 = r2.getTag()
            java.lang.String r3 = (java.lang.String) r3
            java.lang.String r4 = "_0"
            boolean r4 = r3.endsWith(r4)
            if (r4 == 0) goto L_0x00fc
            boolean r4 = r3.startsWith(r9)
            if (r4 == 0) goto L_0x00fc
            r4 = 47
            int r4 = r3.indexOf(r4)
            if (r4 <= 0) goto L_0x00fc
            int r3 = m(r3, r1, r7, r12)
            if (r3 < 0) goto L_0x00fc
            int r1 = r3 + 1
            int[][] r4 = r7.f8903b
            r4 = r4[r12]
            r4 = r4[r3]
            int[][] r5 = r7.f8904c
            r5 = r5[r12]
            r3 = r5[r3]
            int r5 = n(r13, r0)
            if (r5 != r0) goto L_0x00dc
            androidx.databinding.f r3 = androidx.databinding.c.a(r6, r2, r3)
            r19[r4] = r3
            r10 = r0
            r0 = r11
            r11 = r1
            goto L_0x00ff
        L_0x00dc:
            int r5 = r5 - r0
            int r5 = r5 + r11
            android.view.View[] r15 = new android.view.View[r5]
            r10 = 0
        L_0x00e1:
            if (r10 >= r5) goto L_0x00ef
            int r11 = r0 + r10
            android.view.View r11 = r13.getChildAt(r11)
            r15[r10] = r11
            int r10 = r10 + 1
            r11 = 1
            goto L_0x00e1
        L_0x00ef:
            androidx.databinding.f r3 = androidx.databinding.c.b(r6, r15, r3)
            r19[r4] = r3
            int r5 = r5 + -1
            int r0 = r0 + r5
            r10 = r0
            r11 = r1
            r0 = 1
            goto L_0x00ff
        L_0x00fc:
            r10 = r0
            r11 = r1
            r0 = 0
        L_0x00ff:
            if (r0 != 0) goto L_0x010e
            r5 = 0
            r0 = r17
            r1 = r2
            r2 = r19
            r3 = r20
            r4 = r21
            v(r0, r1, r2, r3, r4, r5)
        L_0x010e:
            r0 = 1
            int r1 = r10 + 1
            r16 = r11
            r11 = r0
            r0 = r1
            r1 = r16
            goto L_0x008c
        L_0x0119:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.databinding.f.v(androidx.databinding.b, android.view.View, java.lang.Object[], androidx.databinding.f$i, android.util.SparseIntArray, boolean):void");
    }

    public static Object[] w(b bVar, View view, int i11, i iVar, SparseIntArray sparseIntArray) {
        Object[] objArr = new Object[i11];
        v(bVar, view, objArr, iVar, sparseIntArray, true);
        return objArr;
    }

    public static int y(String str, int i11) {
        int length = str.length();
        int i12 = 0;
        while (i11 < length) {
            i12 = (i12 * 10) + (str.charAt(i11) - '0');
            i11++;
        }
        return i12;
    }

    public static void z() {
        while (true) {
            Reference<? extends f> poll = f8883z.poll();
            if (poll == null) {
                return;
            }
            if (poll instanceof h) {
                ((h) poll).e();
            }
        }
    }

    public void A(int i11, Object obj, a aVar) {
        if (obj != null) {
            h hVar = this.f8887e[i11];
            if (hVar == null) {
                hVar = aVar.a(this, i11, f8883z);
                this.f8887e[i11] = hVar;
                LifecycleOwner lifecycleOwner = this.f8896n;
                if (lifecycleOwner != null) {
                    hVar.c(lifecycleOwner);
                }
            }
            hVar.d(obj);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:17:0x002a, code lost:
        if (f8877t == false) goto L_0x0034;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x002c, code lost:
        r2.f8891i.postFrameCallback(r2.f8892j);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0034, code lost:
        r2.f8893k.post(r2.f8884b);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:?, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void B() {
        /*
            r2 = this;
            androidx.databinding.f r0 = r2.f8895m
            if (r0 == 0) goto L_0x0008
            r0.B()
            goto L_0x003b
        L_0x0008:
            androidx.lifecycle.LifecycleOwner r0 = r2.f8896n
            if (r0 == 0) goto L_0x001d
            androidx.lifecycle.Lifecycle r0 = r0.getLifecycle()
            androidx.lifecycle.Lifecycle$State r0 = r0.b()
            androidx.lifecycle.Lifecycle$State r1 = androidx.lifecycle.Lifecycle.State.STARTED
            boolean r0 = r0.isAtLeast(r1)
            if (r0 != 0) goto L_0x001d
            return
        L_0x001d:
            monitor-enter(r2)
            boolean r0 = r2.f8885c     // Catch:{ all -> 0x003c }
            if (r0 == 0) goto L_0x0024
            monitor-exit(r2)     // Catch:{ all -> 0x003c }
            return
        L_0x0024:
            r0 = 1
            r2.f8885c = r0     // Catch:{ all -> 0x003c }
            monitor-exit(r2)     // Catch:{ all -> 0x003c }
            boolean r0 = f8877t
            if (r0 == 0) goto L_0x0034
            android.view.Choreographer r0 = r2.f8891i
            android.view.Choreographer$FrameCallback r1 = r2.f8892j
            r0.postFrameCallback(r1)
            goto L_0x003b
        L_0x0034:
            android.os.Handler r0 = r2.f8893k
            java.lang.Runnable r1 = r2.f8884b
            r0.post(r1)
        L_0x003b:
            return
        L_0x003c:
            r0 = move-exception
            monitor-exit(r2)     // Catch:{ all -> 0x003c }
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.databinding.f.B():void");
    }

    public void E(f fVar) {
        if (fVar != null) {
            fVar.f8895m = this;
        }
    }

    public void F(LifecycleOwner lifecycleOwner) {
        if (lifecycleOwner instanceof Fragment) {
            Log.w("DataBinding", "Setting the fragment as the LifecycleOwner might cause memory leaks because views lives shorter than the Fragment. Consider using Fragment's view lifecycle");
        }
        LifecycleOwner lifecycleOwner2 = this.f8896n;
        if (lifecycleOwner2 != lifecycleOwner) {
            if (lifecycleOwner2 != null) {
                lifecycleOwner2.getLifecycle().d(this.f8897o);
            }
            this.f8896n = lifecycleOwner;
            if (lifecycleOwner != null) {
                if (this.f8897o == null) {
                    this.f8897o = new k(this, (a) null);
                }
                lifecycleOwner.getLifecycle().a(this.f8897o);
            }
            for (h hVar : this.f8887e) {
                if (hVar != null) {
                    hVar.c(lifecycleOwner);
                }
            }
        }
    }

    public void G(View view) {
        view.setTag(R$id.dataBinding, this);
    }

    public boolean H(int i11) {
        h hVar = this.f8887e[i11];
        if (hVar != null) {
            return hVar.e();
        }
        return false;
    }

    public boolean I(int i11, LiveData<?> liveData) {
        this.f8898p = true;
        try {
            return J(i11, liveData, f8881x);
        } finally {
            this.f8898p = false;
        }
    }

    public boolean J(int i11, Object obj, a aVar) {
        if (obj == null) {
            return H(i11);
        }
        h hVar = this.f8887e[i11];
        if (hVar == null) {
            A(i11, obj, aVar);
            return true;
        } else if (hVar.b() == obj) {
            return false;
        } else {
            H(i11);
            A(i11, obj, aVar);
            return true;
        }
    }

    public View getRoot() {
        return this.f8888f;
    }

    public abstract void i();

    public final void j() {
        if (this.f8890h) {
            B();
        } else if (r()) {
            this.f8890h = true;
            this.f8886d = false;
            CallbackRegistry<OnRebindCallback, f, Void> callbackRegistry = this.f8889g;
            if (callbackRegistry != null) {
                callbackRegistry.e(this, 1, null);
                if (this.f8886d) {
                    this.f8889g.e(this, 2, null);
                }
            }
            if (!this.f8886d) {
                i();
                CallbackRegistry<OnRebindCallback, f, Void> callbackRegistry2 = this.f8889g;
                if (callbackRegistry2 != null) {
                    callbackRegistry2.e(this, 3, null);
                }
            }
            this.f8890h = false;
        }
    }

    public void l() {
        f fVar = this.f8895m;
        if (fVar == null) {
            j();
        } else {
            fVar.l();
        }
    }

    public void q(int i11, Object obj, int i12) {
        if (!this.f8898p && !this.f8899q && x(i11, obj, i12)) {
            B();
        }
    }

    public abstract boolean r();

    public abstract void t();

    public abstract boolean x(int i11, Object obj, int i12);

    public f(Object obj, View view, int i11) {
        this(h(obj), view, i11);
    }
}
