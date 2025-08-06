package androidx.transition;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import androidx.collection.ArrayMap;
import androidx.core.view.h0;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import v1.k;

public class TransitionManager {

    /* renamed from: c  reason: collision with root package name */
    public static Transition f11848c = new AutoTransition();

    /* renamed from: d  reason: collision with root package name */
    public static ThreadLocal<WeakReference<ArrayMap<ViewGroup, ArrayList<Transition>>>> f11849d = new ThreadLocal<>();

    /* renamed from: e  reason: collision with root package name */
    public static ArrayList<ViewGroup> f11850e = new ArrayList<>();

    /* renamed from: a  reason: collision with root package name */
    public ArrayMap<k, Transition> f11851a = new ArrayMap<>();

    /* renamed from: b  reason: collision with root package name */
    public ArrayMap<k, ArrayMap<k, Transition>> f11852b = new ArrayMap<>();

    public static class a implements ViewTreeObserver.OnPreDrawListener, View.OnAttachStateChangeListener {

        /* renamed from: b  reason: collision with root package name */
        public Transition f11853b;

        /* renamed from: c  reason: collision with root package name */
        public ViewGroup f11854c;

        /* renamed from: androidx.transition.TransitionManager$a$a  reason: collision with other inner class name */
        public class C0058a extends TransitionListenerAdapter {

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ ArrayMap f11855b;

            public C0058a(ArrayMap arrayMap) {
                this.f11855b = arrayMap;
            }

            public void onTransitionEnd(Transition transition) {
                ((ArrayList) this.f11855b.get(a.this.f11854c)).remove(transition);
                transition.removeListener(this);
            }
        }

        public a(Transition transition, ViewGroup viewGroup) {
            this.f11853b = transition;
            this.f11854c = viewGroup;
        }

        public final void a() {
            this.f11854c.getViewTreeObserver().removeOnPreDrawListener(this);
            this.f11854c.removeOnAttachStateChangeListener(this);
        }

        public boolean onPreDraw() {
            a();
            if (!TransitionManager.f11850e.remove(this.f11854c)) {
                return true;
            }
            ArrayMap<ViewGroup, ArrayList<Transition>> e11 = TransitionManager.e();
            ArrayList arrayList = e11.get(this.f11854c);
            ArrayList arrayList2 = null;
            if (arrayList == null) {
                arrayList = new ArrayList();
                e11.put(this.f11854c, arrayList);
            } else if (arrayList.size() > 0) {
                arrayList2 = new ArrayList(arrayList);
            }
            arrayList.add(this.f11853b);
            this.f11853b.addListener(new C0058a(e11));
            this.f11853b.captureValues(this.f11854c, false);
            if (arrayList2 != null) {
                Iterator it2 = arrayList2.iterator();
                while (it2.hasNext()) {
                    ((Transition) it2.next()).resume(this.f11854c);
                }
            }
            this.f11853b.playTransition(this.f11854c);
            return true;
        }

        public void onViewAttachedToWindow(View view) {
        }

        public void onViewDetachedFromWindow(View view) {
            a();
            TransitionManager.f11850e.remove(this.f11854c);
            ArrayList arrayList = TransitionManager.e().get(this.f11854c);
            if (arrayList != null && arrayList.size() > 0) {
                Iterator it2 = arrayList.iterator();
                while (it2.hasNext()) {
                    ((Transition) it2.next()).resume(this.f11854c);
                }
            }
            this.f11853b.clearValues(true);
        }
    }

    public static void a(ViewGroup viewGroup) {
        b(viewGroup, (Transition) null);
    }

    public static void b(ViewGroup viewGroup, Transition transition) {
        if (!f11850e.contains(viewGroup) && h0.a0(viewGroup)) {
            f11850e.add(viewGroup);
            if (transition == null) {
                transition = f11848c;
            }
            Transition clone = transition.clone();
            h(viewGroup, clone);
            k.f(viewGroup, (k) null);
            g(viewGroup, clone);
        }
    }

    public static void c(k kVar, Transition transition) {
        ViewGroup d11 = kVar.d();
        if (!f11850e.contains(d11)) {
            k c11 = k.c(d11);
            if (transition == null) {
                if (c11 != null) {
                    c11.b();
                }
                kVar.a();
                return;
            }
            f11850e.add(d11);
            Transition clone = transition.clone();
            clone.setSceneRoot(d11);
            if (c11 != null && c11.e()) {
                clone.setCanRemoveViews(true);
            }
            h(d11, clone);
            kVar.a();
            g(d11, clone);
        }
    }

    public static void d(ViewGroup viewGroup) {
        f11850e.remove(viewGroup);
        ArrayList arrayList = e().get(viewGroup);
        if (arrayList != null && !arrayList.isEmpty()) {
            ArrayList arrayList2 = new ArrayList(arrayList);
            for (int size = arrayList2.size() - 1; size >= 0; size--) {
                ((Transition) arrayList2.get(size)).forceToEnd(viewGroup);
            }
        }
    }

    public static ArrayMap<ViewGroup, ArrayList<Transition>> e() {
        ArrayMap<ViewGroup, ArrayList<Transition>> arrayMap;
        WeakReference weakReference = f11849d.get();
        if (weakReference != null && (arrayMap = (ArrayMap) weakReference.get()) != null) {
            return arrayMap;
        }
        ArrayMap<ViewGroup, ArrayList<Transition>> arrayMap2 = new ArrayMap<>();
        f11849d.set(new WeakReference(arrayMap2));
        return arrayMap2;
    }

    public static void f(k kVar, Transition transition) {
        c(kVar, transition);
    }

    public static void g(ViewGroup viewGroup, Transition transition) {
        if (transition != null && viewGroup != null) {
            a aVar = new a(transition, viewGroup);
            viewGroup.addOnAttachStateChangeListener(aVar);
            viewGroup.getViewTreeObserver().addOnPreDrawListener(aVar);
        }
    }

    public static void h(ViewGroup viewGroup, Transition transition) {
        ArrayList arrayList = e().get(viewGroup);
        if (arrayList != null && arrayList.size() > 0) {
            Iterator it2 = arrayList.iterator();
            while (it2.hasNext()) {
                ((Transition) it2.next()).pause(viewGroup);
            }
        }
        if (transition != null) {
            transition.captureValues(viewGroup, true);
        }
        k c11 = k.c(viewGroup);
        if (c11 != null) {
            c11.b();
        }
    }
}
