package androidx.constraintlayout.motion.widget;

import android.graphics.Rect;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import androidx.constraintlayout.motion.widget.h;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;
import androidx.constraintlayout.widget.SharedValues;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;

public class i {

    /* renamed from: a  reason: collision with root package name */
    public final MotionLayout f7801a;

    /* renamed from: b  reason: collision with root package name */
    public ArrayList<h> f7802b = new ArrayList<>();

    /* renamed from: c  reason: collision with root package name */
    public HashSet<View> f7803c;

    /* renamed from: d  reason: collision with root package name */
    public String f7804d = "ViewTransitionController";

    /* renamed from: e  reason: collision with root package name */
    public ArrayList<h.b> f7805e;

    /* renamed from: f  reason: collision with root package name */
    public ArrayList<h.b> f7806f = new ArrayList<>();

    public class a implements SharedValues.a {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ h f7807b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ int f7808c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ boolean f7809d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ int f7810e;

        public a(h hVar, int i11, boolean z11, int i12) {
            this.f7807b = hVar;
            this.f7808c = i11;
            this.f7809d = z11;
            this.f7810e = i12;
        }
    }

    public i(MotionLayout motionLayout) {
        this.f7801a = motionLayout;
    }

    public void a(h hVar) {
        this.f7802b.add(hVar);
        this.f7803c = null;
        if (hVar.i() == 4) {
            f(hVar, true);
        } else if (hVar.i() == 5) {
            f(hVar, false);
        }
    }

    public void b(h.b bVar) {
        if (this.f7805e == null) {
            this.f7805e = new ArrayList<>();
        }
        this.f7805e.add(bVar);
    }

    public void c() {
        ArrayList<h.b> arrayList = this.f7805e;
        if (arrayList != null) {
            Iterator<h.b> it2 = arrayList.iterator();
            while (it2.hasNext()) {
                it2.next().a();
            }
            this.f7805e.removeAll(this.f7806f);
            this.f7806f.clear();
            if (this.f7805e.isEmpty()) {
                this.f7805e = null;
            }
        }
    }

    public boolean d(int i11, d dVar) {
        Iterator<h> it2 = this.f7802b.iterator();
        while (it2.hasNext()) {
            h next = it2.next();
            if (next.e() == i11) {
                next.f7767f.a(dVar);
                return true;
            }
        }
        return false;
    }

    public void e() {
        this.f7801a.invalidate();
    }

    public final void f(h hVar, boolean z11) {
        ConstraintLayout.getSharedValues().a(hVar.h(), new a(hVar, hVar.h(), z11, hVar.g()));
    }

    public void g(h.b bVar) {
        this.f7806f.add(bVar);
    }

    public void h(MotionEvent motionEvent) {
        h hVar;
        int currentState = this.f7801a.getCurrentState();
        if (currentState != -1) {
            if (this.f7803c == null) {
                this.f7803c = new HashSet<>();
                Iterator<h> it2 = this.f7802b.iterator();
                while (it2.hasNext()) {
                    h next = it2.next();
                    int childCount = this.f7801a.getChildCount();
                    for (int i11 = 0; i11 < childCount; i11++) {
                        View childAt = this.f7801a.getChildAt(i11);
                        if (next.k(childAt)) {
                            childAt.getId();
                            this.f7803c.add(childAt);
                        }
                    }
                }
            }
            float x11 = motionEvent.getX();
            float y11 = motionEvent.getY();
            Rect rect = new Rect();
            int action = motionEvent.getAction();
            ArrayList<h.b> arrayList = this.f7805e;
            if (arrayList != null && !arrayList.isEmpty()) {
                Iterator<h.b> it3 = this.f7805e.iterator();
                while (it3.hasNext()) {
                    it3.next().d(action, x11, y11);
                }
            }
            if (action == 0 || action == 1) {
                ConstraintSet c02 = this.f7801a.c0(currentState);
                Iterator<h> it4 = this.f7802b.iterator();
                while (it4.hasNext()) {
                    h next2 = it4.next();
                    if (next2.m(action)) {
                        Iterator<View> it5 = this.f7803c.iterator();
                        while (it5.hasNext()) {
                            View next3 = it5.next();
                            if (next2.k(next3)) {
                                next3.getHitRect(rect);
                                if (rect.contains((int) x11, (int) y11)) {
                                    hVar = next2;
                                    next2.c(this, this.f7801a, currentState, c02, next3);
                                } else {
                                    hVar = next2;
                                }
                                next2 = hVar;
                            }
                        }
                    }
                }
            }
        }
    }

    public void i(int i11, View... viewArr) {
        ArrayList arrayList = new ArrayList();
        Iterator<h> it2 = this.f7802b.iterator();
        h hVar = null;
        while (it2.hasNext()) {
            h next = it2.next();
            if (next.e() == i11) {
                for (View view : viewArr) {
                    if (next.d(view)) {
                        arrayList.add(view);
                    }
                }
                if (!arrayList.isEmpty()) {
                    j(next, (View[]) arrayList.toArray(new View[0]));
                    arrayList.clear();
                }
                hVar = next;
            }
        }
        if (hVar == null) {
            Log.e(this.f7804d, " Could not find ViewTransition");
        }
    }

    public final void j(h hVar, View... viewArr) {
        int currentState = this.f7801a.getCurrentState();
        if (hVar.f7766e == 2) {
            hVar.c(this, this.f7801a, currentState, (ConstraintSet) null, viewArr);
        } else if (currentState == -1) {
            String str = this.f7804d;
            Log.w(str, "No support for ViewTransition within transition yet. Currently: " + this.f7801a.toString());
        } else {
            ConstraintSet c02 = this.f7801a.c0(currentState);
            if (c02 != null) {
                hVar.c(this, this.f7801a, currentState, c02, viewArr);
            }
        }
    }
}
