package androidx.fragment.app;

import android.annotation.SuppressLint;
import android.graphics.Rect;
import android.transition.Transition;
import android.transition.TransitionManager;
import android.transition.TransitionSet;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.os.CancellationSignal;
import java.util.ArrayList;
import java.util.List;

public class h0 extends FragmentTransitionImpl {

    public class a extends Transition.EpicenterCallback {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Rect f9737a;

        public a(Rect rect) {
            this.f9737a = rect;
        }

        public Rect onGetEpicenter(Transition transition) {
            return this.f9737a;
        }
    }

    public class b implements Transition.TransitionListener {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ View f9739a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ ArrayList f9740b;

        public b(View view, ArrayList arrayList) {
            this.f9739a = view;
            this.f9740b = arrayList;
        }

        public void onTransitionCancel(Transition transition) {
        }

        public void onTransitionEnd(Transition transition) {
            transition.removeListener(this);
            this.f9739a.setVisibility(8);
            int size = this.f9740b.size();
            for (int i11 = 0; i11 < size; i11++) {
                ((View) this.f9740b.get(i11)).setVisibility(0);
            }
        }

        public void onTransitionPause(Transition transition) {
        }

        public void onTransitionResume(Transition transition) {
        }

        public void onTransitionStart(Transition transition) {
            transition.removeListener(this);
            transition.addListener(this);
        }
    }

    public class c implements Transition.TransitionListener {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Object f9742a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ ArrayList f9743b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ Object f9744c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ ArrayList f9745d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Object f9746e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ ArrayList f9747f;

        public c(Object obj, ArrayList arrayList, Object obj2, ArrayList arrayList2, Object obj3, ArrayList arrayList3) {
            this.f9742a = obj;
            this.f9743b = arrayList;
            this.f9744c = obj2;
            this.f9745d = arrayList2;
            this.f9746e = obj3;
            this.f9747f = arrayList3;
        }

        public void onTransitionCancel(Transition transition) {
        }

        public void onTransitionEnd(Transition transition) {
            transition.removeListener(this);
        }

        public void onTransitionPause(Transition transition) {
        }

        public void onTransitionResume(Transition transition) {
        }

        public void onTransitionStart(Transition transition) {
            Object obj = this.f9742a;
            if (obj != null) {
                h0.this.w(obj, this.f9743b, (ArrayList<View>) null);
            }
            Object obj2 = this.f9744c;
            if (obj2 != null) {
                h0.this.w(obj2, this.f9745d, (ArrayList<View>) null);
            }
            Object obj3 = this.f9746e;
            if (obj3 != null) {
                h0.this.w(obj3, this.f9747f, (ArrayList<View>) null);
            }
        }
    }

    public class d implements Transition.TransitionListener {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Runnable f9749a;

        public d(Runnable runnable) {
            this.f9749a = runnable;
        }

        public void onTransitionCancel(Transition transition) {
        }

        public void onTransitionEnd(Transition transition) {
            this.f9749a.run();
        }

        public void onTransitionPause(Transition transition) {
        }

        public void onTransitionResume(Transition transition) {
        }

        public void onTransitionStart(Transition transition) {
        }
    }

    public class e extends Transition.EpicenterCallback {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Rect f9751a;

        public e(Rect rect) {
            this.f9751a = rect;
        }

        public Rect onGetEpicenter(Transition transition) {
            Rect rect = this.f9751a;
            if (rect == null || rect.isEmpty()) {
                return null;
            }
            return this.f9751a;
        }
    }

    public static boolean v(Transition transition) {
        return !FragmentTransitionImpl.i(transition.getTargetIds()) || !FragmentTransitionImpl.i(transition.getTargetNames()) || !FragmentTransitionImpl.i(transition.getTargetTypes());
    }

    public void a(Object obj, View view) {
        if (obj != null) {
            ((Transition) obj).addTarget(view);
        }
    }

    public void b(Object obj, ArrayList<View> arrayList) {
        Transition transition = (Transition) obj;
        if (transition != null) {
            int i11 = 0;
            if (transition instanceof TransitionSet) {
                TransitionSet transitionSet = (TransitionSet) transition;
                int transitionCount = transitionSet.getTransitionCount();
                while (i11 < transitionCount) {
                    b(transitionSet.getTransitionAt(i11), arrayList);
                    i11++;
                }
            } else if (!v(transition) && FragmentTransitionImpl.i(transition.getTargets())) {
                int size = arrayList.size();
                while (i11 < size) {
                    transition.addTarget(arrayList.get(i11));
                    i11++;
                }
            }
        }
    }

    public void c(ViewGroup viewGroup, Object obj) {
        TransitionManager.beginDelayedTransition(viewGroup, (Transition) obj);
    }

    public boolean e(Object obj) {
        return obj instanceof Transition;
    }

    public Object f(Object obj) {
        if (obj != null) {
            return ((Transition) obj).clone();
        }
        return null;
    }

    public Object j(Object obj, Object obj2, Object obj3) {
        Transition transition = (Transition) obj;
        Transition transition2 = (Transition) obj2;
        Transition transition3 = (Transition) obj3;
        if (transition != null && transition2 != null) {
            transition = new TransitionSet().addTransition(transition).addTransition(transition2).setOrdering(1);
        } else if (transition == null) {
            transition = transition2 != null ? transition2 : null;
        }
        if (transition3 == null) {
            return transition;
        }
        TransitionSet transitionSet = new TransitionSet();
        if (transition != null) {
            transitionSet.addTransition(transition);
        }
        transitionSet.addTransition(transition3);
        return transitionSet;
    }

    public Object k(Object obj, Object obj2, Object obj3) {
        TransitionSet transitionSet = new TransitionSet();
        if (obj != null) {
            transitionSet.addTransition((Transition) obj);
        }
        if (obj2 != null) {
            transitionSet.addTransition((Transition) obj2);
        }
        if (obj3 != null) {
            transitionSet.addTransition((Transition) obj3);
        }
        return transitionSet;
    }

    public void m(Object obj, View view, ArrayList<View> arrayList) {
        ((Transition) obj).addListener(new b(view, arrayList));
    }

    public void n(Object obj, Object obj2, ArrayList<View> arrayList, Object obj3, ArrayList<View> arrayList2, Object obj4, ArrayList<View> arrayList3) {
        ((Transition) obj).addListener(new c(obj2, arrayList, obj3, arrayList2, obj4, arrayList3));
    }

    public void o(Object obj, Rect rect) {
        if (obj != null) {
            ((Transition) obj).setEpicenterCallback(new e(rect));
        }
    }

    public void p(Object obj, View view) {
        if (view != null) {
            Rect rect = new Rect();
            h(view, rect);
            ((Transition) obj).setEpicenterCallback(new a(rect));
        }
    }

    public void q(Fragment fragment, Object obj, CancellationSignal cancellationSignal, Runnable runnable) {
        ((Transition) obj).addListener(new d(runnable));
    }

    public void s(Object obj, View view, ArrayList<View> arrayList) {
        TransitionSet transitionSet = (TransitionSet) obj;
        List targets = transitionSet.getTargets();
        targets.clear();
        int size = arrayList.size();
        for (int i11 = 0; i11 < size; i11++) {
            FragmentTransitionImpl.d(targets, arrayList.get(i11));
        }
        targets.add(view);
        arrayList.add(view);
        b(transitionSet, arrayList);
    }

    public void t(Object obj, ArrayList<View> arrayList, ArrayList<View> arrayList2) {
        TransitionSet transitionSet = (TransitionSet) obj;
        if (transitionSet != null) {
            transitionSet.getTargets().clear();
            transitionSet.getTargets().addAll(arrayList2);
            w(transitionSet, arrayList, arrayList2);
        }
    }

    public Object u(Object obj) {
        if (obj == null) {
            return null;
        }
        TransitionSet transitionSet = new TransitionSet();
        transitionSet.addTransition((Transition) obj);
        return transitionSet;
    }

    public void w(Object obj, @SuppressLint({"UnknownNullness"}) ArrayList<View> arrayList, @SuppressLint({"UnknownNullness"}) ArrayList<View> arrayList2) {
        List<View> targets;
        int i11;
        Transition transition = (Transition) obj;
        int i12 = 0;
        if (transition instanceof TransitionSet) {
            TransitionSet transitionSet = (TransitionSet) transition;
            int transitionCount = transitionSet.getTransitionCount();
            while (i12 < transitionCount) {
                w(transitionSet.getTransitionAt(i12), arrayList, arrayList2);
                i12++;
            }
        } else if (!v(transition) && (targets = transition.getTargets()) != null && targets.size() == arrayList.size() && targets.containsAll(arrayList)) {
            if (arrayList2 == null) {
                i11 = 0;
            } else {
                i11 = arrayList2.size();
            }
            while (i12 < i11) {
                transition.addTarget(arrayList2.get(i12));
                i12++;
            }
            for (int size = arrayList.size() - 1; size >= 0; size--) {
                transition.removeTarget(arrayList.get(size));
            }
        }
    }
}
