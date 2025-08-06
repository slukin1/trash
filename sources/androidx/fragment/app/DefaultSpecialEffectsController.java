package androidx.fragment.app;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.content.Context;
import android.graphics.Rect;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import androidx.collection.ArrayMap;
import androidx.core.app.SharedElementCallback;
import androidx.core.os.CancellationSignal;
import androidx.core.view.h0;
import androidx.core.view.k0;
import androidx.core.view.y;
import androidx.fragment.app.SpecialEffectsController;
import androidx.fragment.app.o;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import kotlin.Pair;
import kotlin.jvm.internal.x;
import kotlin.l;

public final class DefaultSpecialEffectsController extends SpecialEffectsController {

    public static final class a extends b {

        /* renamed from: c  reason: collision with root package name */
        public final boolean f9484c;

        /* renamed from: d  reason: collision with root package name */
        public boolean f9485d;

        /* renamed from: e  reason: collision with root package name */
        public o.a f9486e;

        public a(SpecialEffectsController.Operation operation, CancellationSignal cancellationSignal, boolean z11) {
            super(operation, cancellationSignal);
            this.f9484c = z11;
        }

        public final o.a e(Context context) {
            if (this.f9485d) {
                return this.f9486e;
            }
            o.a b11 = o.b(context, b().h(), b().g() == SpecialEffectsController.Operation.State.VISIBLE, this.f9484c);
            this.f9486e = b11;
            this.f9485d = true;
            return b11;
        }
    }

    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public final SpecialEffectsController.Operation f9487a;

        /* renamed from: b  reason: collision with root package name */
        public final CancellationSignal f9488b;

        public b(SpecialEffectsController.Operation operation, CancellationSignal cancellationSignal) {
            this.f9487a = operation;
            this.f9488b = cancellationSignal;
        }

        public final void a() {
            this.f9487a.f(this.f9488b);
        }

        public final SpecialEffectsController.Operation b() {
            return this.f9487a;
        }

        public final CancellationSignal c() {
            return this.f9488b;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:2:0x0016, code lost:
            r2 = androidx.fragment.app.SpecialEffectsController.Operation.State.VISIBLE;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final boolean d() {
            /*
                r3 = this;
                androidx.fragment.app.SpecialEffectsController$Operation$State$a r0 = androidx.fragment.app.SpecialEffectsController.Operation.State.Companion
                androidx.fragment.app.SpecialEffectsController$Operation r1 = r3.f9487a
                androidx.fragment.app.Fragment r1 = r1.h()
                android.view.View r1 = r1.mView
                androidx.fragment.app.SpecialEffectsController$Operation$State r0 = r0.a(r1)
                androidx.fragment.app.SpecialEffectsController$Operation r1 = r3.f9487a
                androidx.fragment.app.SpecialEffectsController$Operation$State r1 = r1.g()
                if (r0 == r1) goto L_0x001f
                androidx.fragment.app.SpecialEffectsController$Operation$State r2 = androidx.fragment.app.SpecialEffectsController.Operation.State.VISIBLE
                if (r0 == r2) goto L_0x001d
                if (r1 == r2) goto L_0x001d
                goto L_0x001f
            L_0x001d:
                r0 = 0
                goto L_0x0020
            L_0x001f:
                r0 = 1
            L_0x0020:
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.fragment.app.DefaultSpecialEffectsController.b.d():boolean");
        }
    }

    public static final class c extends b {

        /* renamed from: c  reason: collision with root package name */
        public final Object f9489c;

        /* renamed from: d  reason: collision with root package name */
        public final boolean f9490d;

        /* renamed from: e  reason: collision with root package name */
        public final Object f9491e;

        public c(SpecialEffectsController.Operation operation, CancellationSignal cancellationSignal, boolean z11, boolean z12) {
            super(operation, cancellationSignal);
            Object obj;
            boolean z13;
            Object obj2;
            SpecialEffectsController.Operation.State g11 = operation.g();
            SpecialEffectsController.Operation.State state = SpecialEffectsController.Operation.State.VISIBLE;
            if (g11 == state) {
                Fragment h11 = operation.h();
                obj = z11 ? h11.getReenterTransition() : h11.getEnterTransition();
            } else {
                Fragment h12 = operation.h();
                obj = z11 ? h12.getReturnTransition() : h12.getExitTransition();
            }
            this.f9489c = obj;
            if (operation.g() == state) {
                z13 = z11 ? operation.h().getAllowReturnTransitionOverlap() : operation.h().getAllowEnterTransitionOverlap();
            } else {
                z13 = true;
            }
            this.f9490d = z13;
            if (z12) {
                obj2 = z11 ? operation.h().getSharedElementReturnTransition() : operation.h().getSharedElementEnterTransition();
            } else {
                obj2 = null;
            }
            this.f9491e = obj2;
        }

        public final FragmentTransitionImpl e() {
            FragmentTransitionImpl f11 = f(this.f9489c);
            FragmentTransitionImpl f12 = f(this.f9491e);
            if (f11 == null || f12 == null || f11 == f12) {
                return f11 == null ? f12 : f11;
            }
            throw new IllegalArgumentException(("Mixing framework transitions and AndroidX transitions is not allowed. Fragment " + b().h() + " returned Transition " + this.f9489c + " which uses a different Transition  type than its shared element transition " + this.f9491e).toString());
        }

        public final FragmentTransitionImpl f(Object obj) {
            if (obj == null) {
                return null;
            }
            FragmentTransitionImpl fragmentTransitionImpl = g0.f9732b;
            if (fragmentTransitionImpl != null && fragmentTransitionImpl.e(obj)) {
                return fragmentTransitionImpl;
            }
            FragmentTransitionImpl fragmentTransitionImpl2 = g0.f9733c;
            if (fragmentTransitionImpl2 != null && fragmentTransitionImpl2.e(obj)) {
                return fragmentTransitionImpl2;
            }
            throw new IllegalArgumentException("Transition " + obj + " for fragment " + b().h() + " is not a valid framework Transition or AndroidX Transition");
        }

        public final Object g() {
            return this.f9491e;
        }

        public final Object h() {
            return this.f9489c;
        }

        public final boolean i() {
            return this.f9491e != null;
        }

        public final boolean j() {
            return this.f9490d;
        }
    }

    public static final class d extends AnimatorListenerAdapter {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ DefaultSpecialEffectsController f9492b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ View f9493c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ boolean f9494d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ SpecialEffectsController.Operation f9495e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ a f9496f;

        public d(DefaultSpecialEffectsController defaultSpecialEffectsController, View view, boolean z11, SpecialEffectsController.Operation operation, a aVar) {
            this.f9492b = defaultSpecialEffectsController;
            this.f9493c = view;
            this.f9494d = z11;
            this.f9495e = operation;
            this.f9496f = aVar;
        }

        public void onAnimationEnd(Animator animator) {
            this.f9492b.q().endViewTransition(this.f9493c);
            if (this.f9494d) {
                this.f9495e.g().applyState(this.f9493c);
            }
            this.f9496f.a();
            if (FragmentManager.P0(2)) {
                Log.v("FragmentManager", "Animator from operation " + this.f9495e + " has ended.");
            }
        }
    }

    public static final class e implements Animation.AnimationListener {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ SpecialEffectsController.Operation f9497a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ DefaultSpecialEffectsController f9498b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ View f9499c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ a f9500d;

        public e(SpecialEffectsController.Operation operation, DefaultSpecialEffectsController defaultSpecialEffectsController, View view, a aVar) {
            this.f9497a = operation;
            this.f9498b = defaultSpecialEffectsController;
            this.f9499c = view;
            this.f9500d = aVar;
        }

        public static final void b(DefaultSpecialEffectsController defaultSpecialEffectsController, View view, a aVar) {
            defaultSpecialEffectsController.q().endViewTransition(view);
            aVar.a();
        }

        public void onAnimationEnd(Animation animation) {
            this.f9498b.q().post(new i(this.f9498b, this.f9499c, this.f9500d));
            if (FragmentManager.P0(2)) {
                Log.v("FragmentManager", "Animation from operation " + this.f9497a + " has ended.");
            }
        }

        public void onAnimationRepeat(Animation animation) {
        }

        public void onAnimationStart(Animation animation) {
            if (FragmentManager.P0(2)) {
                Log.v("FragmentManager", "Animation from operation " + this.f9497a + " has reached onAnimationStart.");
            }
        }
    }

    public DefaultSpecialEffectsController(ViewGroup viewGroup) {
        super(viewGroup);
    }

    public static final void F(List list, SpecialEffectsController.Operation operation, DefaultSpecialEffectsController defaultSpecialEffectsController) {
        if (list.contains(operation)) {
            list.remove(operation);
            defaultSpecialEffectsController.D(operation);
        }
    }

    public static final void J(Animator animator, SpecialEffectsController.Operation operation) {
        animator.end();
        if (FragmentManager.P0(2)) {
            Log.v("FragmentManager", "Animator from operation " + operation + " has been canceled.");
        }
    }

    public static final void K(View view, DefaultSpecialEffectsController defaultSpecialEffectsController, a aVar, SpecialEffectsController.Operation operation) {
        view.clearAnimation();
        defaultSpecialEffectsController.q().endViewTransition(view);
        aVar.a();
        if (FragmentManager.P0(2)) {
            Log.v("FragmentManager", "Animation from operation " + operation + " has been cancelled.");
        }
    }

    public static final void M(FragmentTransitionImpl fragmentTransitionImpl, View view, Rect rect) {
        fragmentTransitionImpl.h(view, rect);
    }

    public static final void N(ArrayList arrayList) {
        g0.e(arrayList, 4);
    }

    public static final void O(c cVar, SpecialEffectsController.Operation operation) {
        cVar.a();
        if (FragmentManager.P0(2)) {
            Log.v("FragmentManager", "Transition for operation " + operation + " has completed");
        }
    }

    public static final void P(SpecialEffectsController.Operation operation, SpecialEffectsController.Operation operation2, boolean z11, ArrayMap arrayMap) {
        g0.a(operation.h(), operation2.h(), z11, arrayMap, false);
    }

    public final void D(SpecialEffectsController.Operation operation) {
        operation.g().applyState(operation.h().mView);
    }

    public final void E(ArrayList<View> arrayList, View view) {
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            if (!k0.a(viewGroup)) {
                int childCount = viewGroup.getChildCount();
                for (int i11 = 0; i11 < childCount; i11++) {
                    View childAt = viewGroup.getChildAt(i11);
                    if (childAt.getVisibility() == 0) {
                        E(arrayList, childAt);
                    }
                }
            } else if (!arrayList.contains(view)) {
                arrayList.add(view);
            }
        } else if (!arrayList.contains(view)) {
            arrayList.add(view);
        }
    }

    public final void G(Map<String, View> map, View view) {
        String P = h0.P(view);
        if (P != null) {
            map.put(P, view);
        }
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            int childCount = viewGroup.getChildCount();
            for (int i11 = 0; i11 < childCount; i11++) {
                View childAt = viewGroup.getChildAt(i11);
                if (childAt.getVisibility() == 0) {
                    G(map, childAt);
                }
            }
        }
    }

    public final void H(ArrayMap<String, View> arrayMap, Collection<String> collection) {
        boolean unused = CollectionsKt__MutableCollectionsKt.J(arrayMap.entrySet(), new DefaultSpecialEffectsController$retainMatchingViews$1(collection));
    }

    public final void I(List<a> list, List<SpecialEffectsController.Operation> list2, boolean z11, Map<SpecialEffectsController.Operation, Boolean> map) {
        Context context = q().getContext();
        ArrayList<a> arrayList = new ArrayList<>();
        boolean z12 = false;
        for (a next : list) {
            if (next.d()) {
                next.a();
            } else {
                o.a e11 = next.e(context);
                if (e11 == null) {
                    next.a();
                } else {
                    Animator animator = e11.f9769b;
                    if (animator == null) {
                        arrayList.add(next);
                    } else {
                        SpecialEffectsController.Operation b11 = next.b();
                        Fragment h11 = b11.h();
                        if (x.b(map.get(b11), Boolean.TRUE)) {
                            if (FragmentManager.P0(2)) {
                                Log.v("FragmentManager", "Ignoring Animator set on " + h11 + " as this Fragment was involved in a Transition.");
                            }
                            next.a();
                        } else {
                            boolean z13 = b11.g() == SpecialEffectsController.Operation.State.GONE;
                            List<SpecialEffectsController.Operation> list3 = list2;
                            if (z13) {
                                list3.remove(b11);
                            }
                            View view = h11.mView;
                            q().startViewTransition(view);
                            d dVar = r0;
                            View view2 = view;
                            boolean z14 = z13;
                            SpecialEffectsController.Operation operation = b11;
                            Animator animator2 = animator;
                            d dVar2 = new d(this, view2, z14, b11, next);
                            animator2.addListener(dVar2);
                            animator2.setTarget(view2);
                            animator2.start();
                            if (FragmentManager.P0(2)) {
                                Log.v("FragmentManager", "Animator from operation " + operation + " has started.");
                            }
                            next.c().c(new b(animator2, operation));
                            z12 = true;
                        }
                    }
                }
            }
            Map<SpecialEffectsController.Operation, Boolean> map2 = map;
        }
        for (a aVar : arrayList) {
            SpecialEffectsController.Operation b12 = aVar.b();
            Fragment h12 = b12.h();
            if (z11) {
                if (FragmentManager.P0(2)) {
                    Log.v("FragmentManager", "Ignoring Animation set on " + h12 + " as Animations cannot run alongside Transitions.");
                }
                aVar.a();
            } else if (z12) {
                if (FragmentManager.P0(2)) {
                    Log.v("FragmentManager", "Ignoring Animation set on " + h12 + " as Animations cannot run alongside Animators.");
                }
                aVar.a();
            } else {
                View view3 = h12.mView;
                o.a e12 = aVar.e(context);
                if (e12 != null) {
                    Animation animation = e12.f9768a;
                    if (animation != null) {
                        if (b12.g() != SpecialEffectsController.Operation.State.REMOVED) {
                            view3.startAnimation(animation);
                            aVar.a();
                        } else {
                            q().startViewTransition(view3);
                            o.b bVar = new o.b(animation, q(), view3);
                            bVar.setAnimationListener(new e(b12, this, view3, aVar));
                            view3.startAnimation(bVar);
                            if (FragmentManager.P0(2)) {
                                Log.v("FragmentManager", "Animation from operation " + b12 + " has started.");
                            }
                        }
                        aVar.c().c(new c(view3, this, aVar, b12));
                    } else {
                        throw new IllegalStateException("Required value was null.".toString());
                    }
                } else {
                    throw new IllegalStateException("Required value was null.".toString());
                }
            }
        }
    }

    public final Map<SpecialEffectsController.Operation, Boolean> L(List<c> list, List<SpecialEffectsController.Operation> list2, boolean z11, SpecialEffectsController.Operation operation, SpecialEffectsController.Operation operation2) {
        FragmentTransitionImpl fragmentTransitionImpl;
        View view;
        Object obj;
        View view2;
        Object obj2;
        ArrayList arrayList;
        SpecialEffectsController.Operation operation3;
        LinkedHashMap linkedHashMap;
        Object obj3;
        Object obj4;
        View view3;
        Rect rect;
        Rect rect2;
        Pair pair;
        Object obj5;
        Object obj6;
        View view4;
        Rect rect3;
        View view5;
        String b11;
        DefaultSpecialEffectsController defaultSpecialEffectsController = this;
        boolean z12 = z11;
        SpecialEffectsController.Operation operation4 = operation;
        SpecialEffectsController.Operation operation5 = operation2;
        LinkedHashMap linkedHashMap2 = new LinkedHashMap();
        ArrayList arrayList2 = new ArrayList();
        for (T next : list) {
            if (!((c) next).d()) {
                arrayList2.add(next);
            }
        }
        ArrayList<c> arrayList3 = new ArrayList<>();
        for (Object next2 : arrayList2) {
            if (((c) next2).e() != null) {
                arrayList3.add(next2);
            }
        }
        FragmentTransitionImpl fragmentTransitionImpl2 = null;
        for (c cVar : arrayList3) {
            FragmentTransitionImpl e11 = cVar.e();
            if (fragmentTransitionImpl == null || e11 == fragmentTransitionImpl) {
                fragmentTransitionImpl2 = e11;
            } else {
                throw new IllegalArgumentException(("Mixing framework transitions and AndroidX transitions is not allowed. Fragment " + cVar.b().h() + " returned Transition " + cVar.h() + " which uses a different Transition type than other Fragments.").toString());
            }
        }
        if (fragmentTransitionImpl == null) {
            for (c next3 : list) {
                linkedHashMap2.put(next3.b(), Boolean.FALSE);
                next3.a();
            }
            return linkedHashMap2;
        }
        View view6 = new View(q().getContext());
        Rect rect4 = new Rect();
        ArrayList arrayList4 = new ArrayList();
        ArrayList arrayList5 = new ArrayList();
        ArrayMap arrayMap = new ArrayMap();
        View view7 = null;
        Object obj7 = null;
        boolean z13 = false;
        for (c next4 : list) {
            if (!next4.i() || operation4 == null || operation5 == null) {
                rect2 = rect4;
                view6 = view6;
                arrayList5 = arrayList5;
                arrayList4 = arrayList4;
                linkedHashMap2 = linkedHashMap2;
                view7 = view7;
                arrayMap = arrayMap;
            } else {
                Object u11 = fragmentTransitionImpl.u(fragmentTransitionImpl.f(next4.g()));
                ArrayList<String> sharedElementSourceNames = operation2.h().getSharedElementSourceNames();
                ArrayList<String> sharedElementSourceNames2 = operation.h().getSharedElementSourceNames();
                View view8 = view7;
                ArrayList<String> sharedElementTargetNames = operation.h().getSharedElementTargetNames();
                LinkedHashMap linkedHashMap3 = linkedHashMap2;
                int size = sharedElementTargetNames.size();
                View view9 = view6;
                Rect rect5 = rect4;
                int i11 = 0;
                while (i11 < size) {
                    int i12 = size;
                    int indexOf = sharedElementSourceNames.indexOf(sharedElementTargetNames.get(i11));
                    if (indexOf != -1) {
                        sharedElementSourceNames.set(indexOf, sharedElementSourceNames2.get(i11));
                    }
                    i11++;
                    size = i12;
                }
                ArrayList<String> sharedElementTargetNames2 = operation2.h().getSharedElementTargetNames();
                if (!z12) {
                    pair = l.a(operation.h().getExitTransitionCallback(), operation2.h().getEnterTransitionCallback());
                } else {
                    pair = l.a(operation.h().getEnterTransitionCallback(), operation2.h().getExitTransitionCallback());
                }
                SharedElementCallback sharedElementCallback = (SharedElementCallback) pair.component1();
                SharedElementCallback sharedElementCallback2 = (SharedElementCallback) pair.component2();
                int size2 = sharedElementSourceNames.size();
                int i13 = 0;
                while (i13 < size2) {
                    arrayMap.put(sharedElementSourceNames.get(i13), sharedElementTargetNames2.get(i13));
                    i13++;
                    size2 = size2;
                    fragmentTransitionImpl = fragmentTransitionImpl;
                }
                FragmentTransitionImpl fragmentTransitionImpl3 = fragmentTransitionImpl;
                if (FragmentManager.P0(2)) {
                    Log.v("FragmentManager", ">>> entering view names <<<");
                    for (Iterator<String> it2 = sharedElementTargetNames2.iterator(); it2.hasNext(); it2 = it2) {
                        Log.v("FragmentManager", "Name: " + it2.next());
                    }
                    Log.v("FragmentManager", ">>> exiting view names <<<");
                    for (Iterator<String> it3 = sharedElementSourceNames.iterator(); it3.hasNext(); it3 = it3) {
                        Log.v("FragmentManager", "Name: " + it3.next());
                    }
                }
                ArrayMap arrayMap2 = new ArrayMap();
                defaultSpecialEffectsController.G(arrayMap2, operation.h().mView);
                arrayMap2.r(sharedElementSourceNames);
                if (sharedElementCallback != null) {
                    if (FragmentManager.P0(2)) {
                        Log.v("FragmentManager", "Executing exit callback for operation " + operation4);
                    }
                    sharedElementCallback.d(sharedElementSourceNames, arrayMap2);
                    int size3 = sharedElementSourceNames.size() - 1;
                    if (size3 >= 0) {
                        while (true) {
                            int i14 = size3 - 1;
                            String str = sharedElementSourceNames.get(size3);
                            View view10 = (View) arrayMap2.get(str);
                            if (view10 == null) {
                                arrayMap.remove(str);
                                obj5 = u11;
                            } else {
                                obj5 = u11;
                                if (!x.b(str, h0.P(view10))) {
                                    arrayMap.put(h0.P(view10), (String) arrayMap.remove(str));
                                }
                            }
                            if (i14 < 0) {
                                break;
                            }
                            size3 = i14;
                            u11 = obj5;
                        }
                    } else {
                        obj5 = u11;
                    }
                } else {
                    obj5 = u11;
                    arrayMap.r(arrayMap2.keySet());
                }
                ArrayMap arrayMap3 = new ArrayMap();
                defaultSpecialEffectsController.G(arrayMap3, operation2.h().mView);
                arrayMap3.r(sharedElementTargetNames2);
                arrayMap3.r(arrayMap.values());
                if (sharedElementCallback2 != null) {
                    if (FragmentManager.P0(2)) {
                        Log.v("FragmentManager", "Executing enter callback for operation " + operation5);
                    }
                    sharedElementCallback2.d(sharedElementTargetNames2, arrayMap3);
                    int size4 = sharedElementTargetNames2.size() - 1;
                    if (size4 >= 0) {
                        while (true) {
                            int i15 = size4 - 1;
                            String str2 = sharedElementTargetNames2.get(size4);
                            View view11 = (View) arrayMap3.get(str2);
                            if (view11 == null) {
                                String b12 = g0.b(arrayMap, str2);
                                if (b12 != null) {
                                    arrayMap.remove(b12);
                                }
                            } else if (!x.b(str2, h0.P(view11)) && (b11 = g0.b(arrayMap, str2)) != null) {
                                arrayMap.put(b11, h0.P(view11));
                            }
                            if (i15 < 0) {
                                break;
                            }
                            size4 = i15;
                        }
                    }
                } else {
                    g0.d(arrayMap, arrayMap3);
                }
                defaultSpecialEffectsController.H(arrayMap2, arrayMap.keySet());
                defaultSpecialEffectsController.H(arrayMap3, arrayMap.values());
                if (arrayMap.isEmpty()) {
                    arrayList4.clear();
                    arrayList5.clear();
                    rect4 = rect5;
                    view7 = view8;
                    linkedHashMap2 = linkedHashMap3;
                    view6 = view9;
                    fragmentTransitionImpl = fragmentTransitionImpl3;
                    obj7 = null;
                } else {
                    g0.a(operation2.h(), operation.h(), z12, arrayMap2, true);
                    y.a(q(), new f(operation5, operation4, z12, arrayMap3));
                    arrayList4.addAll(arrayMap2.values());
                    if (!sharedElementSourceNames.isEmpty()) {
                        view4 = (View) arrayMap2.get(sharedElementSourceNames.get(0));
                        obj6 = obj5;
                        fragmentTransitionImpl = fragmentTransitionImpl3;
                        fragmentTransitionImpl.p(obj6, view4);
                    } else {
                        obj6 = obj5;
                        fragmentTransitionImpl = fragmentTransitionImpl3;
                        view4 = view8;
                    }
                    arrayList5.addAll(arrayMap3.values());
                    if (!(!sharedElementTargetNames2.isEmpty()) || (view5 = (View) arrayMap3.get(sharedElementTargetNames2.get(0))) == null) {
                        rect3 = rect5;
                    } else {
                        rect3 = rect5;
                        y.a(q(), new e(fragmentTransitionImpl, view5, rect3));
                        z13 = true;
                    }
                    View view12 = view9;
                    fragmentTransitionImpl.s(obj6, view12, arrayList4);
                    obj7 = obj6;
                    ArrayList arrayList6 = arrayList5;
                    rect2 = rect3;
                    fragmentTransitionImpl.n(obj7, (Object) null, (ArrayList<View>) null, (Object) null, (ArrayList<View>) null, obj6, arrayList6);
                    Boolean bool = Boolean.TRUE;
                    LinkedHashMap linkedHashMap4 = linkedHashMap3;
                    linkedHashMap4.put(operation4, bool);
                    linkedHashMap4.put(operation5, bool);
                    view7 = view4;
                    arrayList5 = arrayList6;
                    arrayList4 = arrayList4;
                    arrayMap = arrayMap;
                    view6 = view12;
                    linkedHashMap2 = linkedHashMap4;
                }
            }
            rect4 = rect2;
        }
        View view13 = view7;
        ArrayMap arrayMap4 = arrayMap;
        ArrayList arrayList7 = arrayList5;
        ArrayList arrayList8 = arrayList4;
        Rect rect6 = rect4;
        LinkedHashMap linkedHashMap5 = linkedHashMap2;
        View view14 = view6;
        ArrayList arrayList9 = new ArrayList();
        Iterator<c> it4 = list.iterator();
        Object obj8 = null;
        Object obj9 = null;
        while (it4.hasNext()) {
            c next5 = it4.next();
            if (next5.d()) {
                linkedHashMap5.put(next5.b(), Boolean.FALSE);
                next5.a();
            } else {
                Object f11 = fragmentTransitionImpl.f(next5.h());
                SpecialEffectsController.Operation b13 = next5.b();
                boolean z14 = obj7 != null && (b13 == operation4 || b13 == operation5);
                if (f11 != null) {
                    LinkedHashMap linkedHashMap6 = linkedHashMap5;
                    ArrayList arrayList10 = new ArrayList();
                    Iterator<c> it5 = it4;
                    defaultSpecialEffectsController.E(arrayList10, b13.h().mView);
                    if (z14) {
                        if (b13 == operation4) {
                            arrayList10.removeAll(CollectionsKt___CollectionsKt.N0(arrayList8));
                        } else {
                            arrayList10.removeAll(CollectionsKt___CollectionsKt.N0(arrayList7));
                        }
                    }
                    if (arrayList10.isEmpty()) {
                        fragmentTransitionImpl.a(f11, view14);
                        view = view14;
                        obj = obj7;
                        obj4 = obj8;
                        obj3 = obj9;
                        arrayList = arrayList10;
                        view2 = view13;
                        linkedHashMap = linkedHashMap6;
                        operation3 = b13;
                        obj2 = f11;
                        List<SpecialEffectsController.Operation> list3 = list2;
                    } else {
                        fragmentTransitionImpl.b(f11, arrayList10);
                        SpecialEffectsController.Operation operation6 = b13;
                        view2 = view13;
                        obj = obj7;
                        Object obj10 = f11;
                        obj4 = obj8;
                        view = view14;
                        obj3 = obj9;
                        ArrayList arrayList11 = arrayList10;
                        linkedHashMap = linkedHashMap6;
                        fragmentTransitionImpl.n(f11, f11, arrayList10, (Object) null, (ArrayList<View>) null, (Object) null, (ArrayList<View>) null);
                        if (operation6.g() == SpecialEffectsController.Operation.State.GONE) {
                            operation3 = operation6;
                            list2.remove(operation3);
                            arrayList = arrayList11;
                            ArrayList arrayList12 = new ArrayList(arrayList);
                            arrayList12.remove(operation3.h().mView);
                            obj2 = obj10;
                            fragmentTransitionImpl.m(obj2, operation3.h().mView, arrayList12);
                            y.a(q(), new g(arrayList));
                        } else {
                            List<SpecialEffectsController.Operation> list4 = list2;
                            operation3 = operation6;
                            obj2 = obj10;
                            arrayList = arrayList11;
                        }
                    }
                    if (operation3.g() == SpecialEffectsController.Operation.State.VISIBLE) {
                        arrayList9.addAll(arrayList);
                        rect = rect6;
                        if (z13) {
                            fragmentTransitionImpl.o(obj2, rect);
                        }
                        view3 = view2;
                    } else {
                        rect = rect6;
                        view3 = view2;
                        fragmentTransitionImpl.p(obj2, view3);
                    }
                    linkedHashMap.put(operation3, Boolean.TRUE);
                    if (next5.j()) {
                        obj9 = fragmentTransitionImpl.k(obj3, obj2, (Object) null);
                    } else {
                        obj4 = fragmentTransitionImpl.k(obj4, obj2, (Object) null);
                        obj9 = obj3;
                    }
                    linkedHashMap5 = linkedHashMap;
                    rect6 = rect;
                    view13 = view3;
                    obj7 = obj;
                    view14 = view;
                    it4 = it5;
                    obj8 = obj4;
                    defaultSpecialEffectsController = this;
                } else if (!z14) {
                    linkedHashMap5.put(b13, Boolean.FALSE);
                    next5.a();
                }
            }
        }
        LinkedHashMap linkedHashMap7 = linkedHashMap5;
        Object obj11 = obj7;
        Object j11 = fragmentTransitionImpl.j(obj9, obj8, obj11);
        if (j11 == null) {
            return linkedHashMap7;
        }
        ArrayList<c> arrayList13 = new ArrayList<>();
        for (T next6 : list) {
            if (!((c) next6).d()) {
                arrayList13.add(next6);
            }
        }
        for (c cVar2 : arrayList13) {
            Object h11 = cVar2.h();
            SpecialEffectsController.Operation b14 = cVar2.b();
            boolean z15 = obj11 != null && (b14 == operation4 || b14 == operation5);
            if (h11 != null || z15) {
                if (!h0.a0(q())) {
                    if (FragmentManager.P0(2)) {
                        Log.v("FragmentManager", "SpecialEffectsController: Container " + q() + " has not been laid out. Completing operation " + b14);
                    }
                    cVar2.a();
                } else {
                    fragmentTransitionImpl.q(cVar2.b().h(), j11, cVar2.c(), new d(cVar2, b14));
                }
            }
        }
        if (!h0.a0(q())) {
            return linkedHashMap7;
        }
        g0.e(arrayList9, 4);
        ArrayList<String> l11 = fragmentTransitionImpl.l(arrayList7);
        if (FragmentManager.P0(2)) {
            Log.v("FragmentManager", ">>>>> Beginning transition <<<<<");
            Log.v("FragmentManager", ">>>>> SharedElementFirstOutViews <<<<<");
            Iterator it6 = arrayList8.iterator();
            while (it6.hasNext()) {
                View view15 = (View) it6.next();
                Log.v("FragmentManager", "View: " + view15 + " Name: " + h0.P(view15));
            }
            Log.v("FragmentManager", ">>>>> SharedElementLastInViews <<<<<");
            Iterator it7 = arrayList7.iterator();
            while (it7.hasNext()) {
                View view16 = (View) it7.next();
                Log.v("FragmentManager", "View: " + view16 + " Name: " + h0.P(view16));
            }
        }
        fragmentTransitionImpl.c(q(), j11);
        fragmentTransitionImpl.r(q(), arrayList8, arrayList7, l11, arrayMap4);
        g0.e(arrayList9, 0);
        fragmentTransitionImpl.t(obj11, arrayList8, arrayList7);
        return linkedHashMap7;
    }

    public final void Q(List<? extends SpecialEffectsController.Operation> list) {
        Fragment h11 = ((SpecialEffectsController.Operation) CollectionsKt___CollectionsKt.m0(list)).h();
        for (SpecialEffectsController.Operation operation : list) {
            operation.h().mAnimationInfo.f9509c = h11.mAnimationInfo.f9509c;
            operation.h().mAnimationInfo.f9510d = h11.mAnimationInfo.f9510d;
            operation.h().mAnimationInfo.f9511e = h11.mAnimationInfo.f9511e;
            operation.h().mAnimationInfo.f9512f = h11.mAnimationInfo.f9512f;
        }
    }

    public void j(List<? extends SpecialEffectsController.Operation> list, boolean z11) {
        SpecialEffectsController.Operation operation;
        T t11;
        boolean z12;
        boolean z13;
        boolean z14 = z11;
        Iterator<T> it2 = list.iterator();
        while (true) {
            operation = null;
            if (!it2.hasNext()) {
                t11 = null;
                break;
            }
            t11 = it2.next();
            SpecialEffectsController.Operation operation2 = (SpecialEffectsController.Operation) t11;
            SpecialEffectsController.Operation.State a11 = SpecialEffectsController.Operation.State.Companion.a(operation2.h().mView);
            SpecialEffectsController.Operation.State state = SpecialEffectsController.Operation.State.VISIBLE;
            if (a11 != state || operation2.g() == state) {
                z13 = false;
                continue;
            } else {
                z13 = true;
                continue;
            }
            if (z13) {
                break;
            }
        }
        SpecialEffectsController.Operation operation3 = (SpecialEffectsController.Operation) t11;
        ListIterator<? extends SpecialEffectsController.Operation> listIterator = list.listIterator(list.size());
        while (true) {
            if (!listIterator.hasPrevious()) {
                break;
            }
            Object previous = listIterator.previous();
            SpecialEffectsController.Operation operation4 = (SpecialEffectsController.Operation) previous;
            SpecialEffectsController.Operation.State a12 = SpecialEffectsController.Operation.State.Companion.a(operation4.h().mView);
            SpecialEffectsController.Operation.State state2 = SpecialEffectsController.Operation.State.VISIBLE;
            if (a12 == state2 || operation4.g() != state2) {
                z12 = false;
                continue;
            } else {
                z12 = true;
                continue;
            }
            if (z12) {
                operation = previous;
                break;
            }
        }
        SpecialEffectsController.Operation operation5 = operation;
        if (FragmentManager.P0(2)) {
            Log.v("FragmentManager", "Executing operations from " + operation3 + " to " + operation5);
        }
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        List<SpecialEffectsController.Operation> L0 = CollectionsKt___CollectionsKt.L0(list);
        Q(list);
        for (SpecialEffectsController.Operation operation6 : list) {
            CancellationSignal cancellationSignal = new CancellationSignal();
            operation6.l(cancellationSignal);
            arrayList.add(new a(operation6, cancellationSignal, z14));
            CancellationSignal cancellationSignal2 = new CancellationSignal();
            operation6.l(cancellationSignal2);
            arrayList2.add(new c(operation6, cancellationSignal2, z14, !z14 ? operation6 == operation5 : operation6 == operation3));
            operation6.c(new h(L0, operation6, this));
        }
        Map<SpecialEffectsController.Operation, Boolean> L = L(arrayList2, L0, z11, operation3, operation5);
        I(arrayList, L0, L.containsValue(Boolean.TRUE), L);
        for (SpecialEffectsController.Operation D : L0) {
            D(D);
        }
        L0.clear();
        if (FragmentManager.P0(2)) {
            Log.v("FragmentManager", "Completed executing operations from " + operation3 + " to " + operation5);
        }
    }
}
