package androidx.transition;

import android.annotation.SuppressLint;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.os.CancellationSignal;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransitionImpl;
import androidx.transition.Transition;
import java.util.ArrayList;
import java.util.List;

@SuppressLint({"RestrictedApi"})
public class FragmentTransitionSupport extends FragmentTransitionImpl {

    public class a extends Transition.EpicenterCallback {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Rect f11797a;

        public a(Rect rect) {
            this.f11797a = rect;
        }

        public Rect a(Transition transition) {
            return this.f11797a;
        }
    }

    public class b implements Transition.f {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ View f11799b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ ArrayList f11800c;

        public b(View view, ArrayList arrayList) {
            this.f11799b = view;
            this.f11800c = arrayList;
        }

        public void onTransitionCancel(Transition transition) {
        }

        public void onTransitionEnd(Transition transition) {
            transition.removeListener(this);
            this.f11799b.setVisibility(8);
            int size = this.f11800c.size();
            for (int i11 = 0; i11 < size; i11++) {
                ((View) this.f11800c.get(i11)).setVisibility(0);
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

    public class c extends TransitionListenerAdapter {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ Object f11802b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ ArrayList f11803c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ Object f11804d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ ArrayList f11805e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ Object f11806f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ ArrayList f11807g;

        public c(Object obj, ArrayList arrayList, Object obj2, ArrayList arrayList2, Object obj3, ArrayList arrayList3) {
            this.f11802b = obj;
            this.f11803c = arrayList;
            this.f11804d = obj2;
            this.f11805e = arrayList2;
            this.f11806f = obj3;
            this.f11807g = arrayList3;
        }

        public void onTransitionEnd(Transition transition) {
            transition.removeListener(this);
        }

        public void onTransitionStart(Transition transition) {
            Object obj = this.f11802b;
            if (obj != null) {
                FragmentTransitionSupport.this.w(obj, this.f11803c, (ArrayList<View>) null);
            }
            Object obj2 = this.f11804d;
            if (obj2 != null) {
                FragmentTransitionSupport.this.w(obj2, this.f11805e, (ArrayList<View>) null);
            }
            Object obj3 = this.f11806f;
            if (obj3 != null) {
                FragmentTransitionSupport.this.w(obj3, this.f11807g, (ArrayList<View>) null);
            }
        }
    }

    public class d implements CancellationSignal.b {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Transition f11809a;

        public d(Transition transition) {
            this.f11809a = transition;
        }

        public void onCancel() {
            this.f11809a.cancel();
        }
    }

    public class e implements Transition.f {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ Runnable f11811b;

        public e(Runnable runnable) {
            this.f11811b = runnable;
        }

        public void onTransitionCancel(Transition transition) {
        }

        public void onTransitionEnd(Transition transition) {
            this.f11811b.run();
        }

        public void onTransitionPause(Transition transition) {
        }

        public void onTransitionResume(Transition transition) {
        }

        public void onTransitionStart(Transition transition) {
        }
    }

    public class f extends Transition.EpicenterCallback {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Rect f11813a;

        public f(Rect rect) {
            this.f11813a = rect;
        }

        public Rect a(Transition transition) {
            Rect rect = this.f11813a;
            if (rect == null || rect.isEmpty()) {
                return null;
            }
            return this.f11813a;
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
                int j11 = transitionSet.j();
                while (i11 < j11) {
                    b(transitionSet.i(i11), arrayList);
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
        TransitionManager.b(viewGroup, (Transition) obj);
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
            transition = new TransitionSet().g(transition).g(transition2).s(1);
        } else if (transition == null) {
            transition = transition2 != null ? transition2 : null;
        }
        if (transition3 == null) {
            return transition;
        }
        TransitionSet transitionSet = new TransitionSet();
        if (transition != null) {
            transitionSet.g(transition);
        }
        transitionSet.g(transition3);
        return transitionSet;
    }

    public Object k(Object obj, Object obj2, Object obj3) {
        TransitionSet transitionSet = new TransitionSet();
        if (obj != null) {
            transitionSet.g((Transition) obj);
        }
        if (obj2 != null) {
            transitionSet.g((Transition) obj2);
        }
        if (obj3 != null) {
            transitionSet.g((Transition) obj3);
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
            ((Transition) obj).setEpicenterCallback(new f(rect));
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
        Transition transition = (Transition) obj;
        cancellationSignal.c(new d(transition));
        transition.addListener(new e(runnable));
    }

    public void s(Object obj, View view, ArrayList<View> arrayList) {
        TransitionSet transitionSet = (TransitionSet) obj;
        List<View> targets = transitionSet.getTargets();
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
        transitionSet.g((Transition) obj);
        return transitionSet;
    }

    public void w(Object obj, ArrayList<View> arrayList, ArrayList<View> arrayList2) {
        int i11;
        Transition transition = (Transition) obj;
        int i12 = 0;
        if (transition instanceof TransitionSet) {
            TransitionSet transitionSet = (TransitionSet) transition;
            int j11 = transitionSet.j();
            while (i12 < j11) {
                w(transitionSet.i(i12), arrayList, arrayList2);
                i12++;
            }
        } else if (!v(transition)) {
            List<View> targets = transition.getTargets();
            if (targets.size() == arrayList.size() && targets.containsAll(arrayList)) {
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
}
