package androidx.transition;

import android.animation.TimeInterpolator;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.util.AndroidRuntimeException;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import androidx.transition.Transition;
import java.util.ArrayList;
import java.util.Iterator;
import s0.i;
import v1.l;
import v1.n;

public class TransitionSet extends Transition {

    /* renamed from: b  reason: collision with root package name */
    public ArrayList<Transition> f11857b = new ArrayList<>();

    /* renamed from: c  reason: collision with root package name */
    public boolean f11858c = true;

    /* renamed from: d  reason: collision with root package name */
    public int f11859d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f11860e = false;

    /* renamed from: f  reason: collision with root package name */
    public int f11861f = 0;

    public class a extends TransitionListenerAdapter {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ Transition f11862b;

        public a(Transition transition) {
            this.f11862b = transition;
        }

        public void onTransitionEnd(Transition transition) {
            this.f11862b.runAnimators();
            transition.removeListener(this);
        }
    }

    public static class b extends TransitionListenerAdapter {

        /* renamed from: b  reason: collision with root package name */
        public TransitionSet f11864b;

        public b(TransitionSet transitionSet) {
            this.f11864b = transitionSet;
        }

        public void onTransitionEnd(Transition transition) {
            TransitionSet transitionSet = this.f11864b;
            int i11 = transitionSet.f11859d - 1;
            transitionSet.f11859d = i11;
            if (i11 == 0) {
                transitionSet.f11860e = false;
                transitionSet.end();
            }
            transition.removeListener(this);
        }

        public void onTransitionStart(Transition transition) {
            TransitionSet transitionSet = this.f11864b;
            if (!transitionSet.f11860e) {
                transitionSet.start();
                this.f11864b.f11860e = true;
            }
        }
    }

    public TransitionSet() {
    }

    /* renamed from: b */
    public TransitionSet addListener(Transition.f fVar) {
        return (TransitionSet) super.addListener(fVar);
    }

    /* renamed from: c */
    public TransitionSet addTarget(int i11) {
        for (int i12 = 0; i12 < this.f11857b.size(); i12++) {
            this.f11857b.get(i12).addTarget(i11);
        }
        return (TransitionSet) super.addTarget(i11);
    }

    public void cancel() {
        super.cancel();
        int size = this.f11857b.size();
        for (int i11 = 0; i11 < size; i11++) {
            this.f11857b.get(i11).cancel();
        }
    }

    public void captureEndValues(TransitionValues transitionValues) {
        if (isValidTarget(transitionValues.f11866b)) {
            Iterator<Transition> it2 = this.f11857b.iterator();
            while (it2.hasNext()) {
                Transition next = it2.next();
                if (next.isValidTarget(transitionValues.f11866b)) {
                    next.captureEndValues(transitionValues);
                    transitionValues.f11867c.add(next);
                }
            }
        }
    }

    public void capturePropagationValues(TransitionValues transitionValues) {
        super.capturePropagationValues(transitionValues);
        int size = this.f11857b.size();
        for (int i11 = 0; i11 < size; i11++) {
            this.f11857b.get(i11).capturePropagationValues(transitionValues);
        }
    }

    public void captureStartValues(TransitionValues transitionValues) {
        if (isValidTarget(transitionValues.f11866b)) {
            Iterator<Transition> it2 = this.f11857b.iterator();
            while (it2.hasNext()) {
                Transition next = it2.next();
                if (next.isValidTarget(transitionValues.f11866b)) {
                    next.captureStartValues(transitionValues);
                    transitionValues.f11867c.add(next);
                }
            }
        }
    }

    public void createAnimators(ViewGroup viewGroup, n nVar, n nVar2, ArrayList<TransitionValues> arrayList, ArrayList<TransitionValues> arrayList2) {
        long startDelay = getStartDelay();
        int size = this.f11857b.size();
        for (int i11 = 0; i11 < size; i11++) {
            Transition transition = this.f11857b.get(i11);
            if (startDelay > 0 && (this.f11858c || i11 == 0)) {
                long startDelay2 = transition.getStartDelay();
                if (startDelay2 > 0) {
                    transition.setStartDelay(startDelay2 + startDelay);
                } else {
                    transition.setStartDelay(startDelay);
                }
            }
            transition.createAnimators(viewGroup, nVar, nVar2, arrayList, arrayList2);
        }
    }

    /* renamed from: d */
    public TransitionSet addTarget(View view) {
        for (int i11 = 0; i11 < this.f11857b.size(); i11++) {
            this.f11857b.get(i11).addTarget(view);
        }
        return (TransitionSet) super.addTarget(view);
    }

    /* renamed from: e */
    public TransitionSet addTarget(Class<?> cls) {
        for (int i11 = 0; i11 < this.f11857b.size(); i11++) {
            this.f11857b.get(i11).addTarget(cls);
        }
        return (TransitionSet) super.addTarget(cls);
    }

    public Transition excludeTarget(View view, boolean z11) {
        for (int i11 = 0; i11 < this.f11857b.size(); i11++) {
            this.f11857b.get(i11).excludeTarget(view, z11);
        }
        return super.excludeTarget(view, z11);
    }

    /* renamed from: f */
    public TransitionSet addTarget(String str) {
        for (int i11 = 0; i11 < this.f11857b.size(); i11++) {
            this.f11857b.get(i11).addTarget(str);
        }
        return (TransitionSet) super.addTarget(str);
    }

    public void forceToEnd(ViewGroup viewGroup) {
        super.forceToEnd(viewGroup);
        int size = this.f11857b.size();
        for (int i11 = 0; i11 < size; i11++) {
            this.f11857b.get(i11).forceToEnd(viewGroup);
        }
    }

    public TransitionSet g(Transition transition) {
        h(transition);
        long j11 = this.mDuration;
        if (j11 >= 0) {
            transition.setDuration(j11);
        }
        if ((this.f11861f & 1) != 0) {
            transition.setInterpolator(getInterpolator());
        }
        if ((this.f11861f & 2) != 0) {
            transition.setPropagation(getPropagation());
        }
        if ((this.f11861f & 4) != 0) {
            transition.setPathMotion(getPathMotion());
        }
        if ((this.f11861f & 8) != 0) {
            transition.setEpicenterCallback(getEpicenterCallback());
        }
        return this;
    }

    public final void h(Transition transition) {
        this.f11857b.add(transition);
        transition.mParent = this;
    }

    public Transition i(int i11) {
        if (i11 < 0 || i11 >= this.f11857b.size()) {
            return null;
        }
        return this.f11857b.get(i11);
    }

    public int j() {
        return this.f11857b.size();
    }

    /* renamed from: k */
    public TransitionSet removeListener(Transition.f fVar) {
        return (TransitionSet) super.removeListener(fVar);
    }

    /* renamed from: l */
    public TransitionSet removeTarget(int i11) {
        for (int i12 = 0; i12 < this.f11857b.size(); i12++) {
            this.f11857b.get(i12).removeTarget(i11);
        }
        return (TransitionSet) super.removeTarget(i11);
    }

    /* renamed from: m */
    public TransitionSet removeTarget(View view) {
        for (int i11 = 0; i11 < this.f11857b.size(); i11++) {
            this.f11857b.get(i11).removeTarget(view);
        }
        return (TransitionSet) super.removeTarget(view);
    }

    /* renamed from: n */
    public TransitionSet removeTarget(Class<?> cls) {
        for (int i11 = 0; i11 < this.f11857b.size(); i11++) {
            this.f11857b.get(i11).removeTarget(cls);
        }
        return (TransitionSet) super.removeTarget(cls);
    }

    /* renamed from: o */
    public TransitionSet removeTarget(String str) {
        for (int i11 = 0; i11 < this.f11857b.size(); i11++) {
            this.f11857b.get(i11).removeTarget(str);
        }
        return (TransitionSet) super.removeTarget(str);
    }

    public TransitionSet p(Transition transition) {
        this.f11857b.remove(transition);
        transition.mParent = null;
        return this;
    }

    public void pause(View view) {
        super.pause(view);
        int size = this.f11857b.size();
        for (int i11 = 0; i11 < size; i11++) {
            this.f11857b.get(i11).pause(view);
        }
    }

    /* renamed from: q */
    public TransitionSet setDuration(long j11) {
        ArrayList<Transition> arrayList;
        super.setDuration(j11);
        if (this.mDuration >= 0 && (arrayList = this.f11857b) != null) {
            int size = arrayList.size();
            for (int i11 = 0; i11 < size; i11++) {
                this.f11857b.get(i11).setDuration(j11);
            }
        }
        return this;
    }

    /* renamed from: r */
    public TransitionSet setInterpolator(TimeInterpolator timeInterpolator) {
        this.f11861f |= 1;
        ArrayList<Transition> arrayList = this.f11857b;
        if (arrayList != null) {
            int size = arrayList.size();
            for (int i11 = 0; i11 < size; i11++) {
                this.f11857b.get(i11).setInterpolator(timeInterpolator);
            }
        }
        return (TransitionSet) super.setInterpolator(timeInterpolator);
    }

    public void resume(View view) {
        super.resume(view);
        int size = this.f11857b.size();
        for (int i11 = 0; i11 < size; i11++) {
            this.f11857b.get(i11).resume(view);
        }
    }

    public void runAnimators() {
        if (this.f11857b.isEmpty()) {
            start();
            end();
            return;
        }
        v();
        if (!this.f11858c) {
            for (int i11 = 1; i11 < this.f11857b.size(); i11++) {
                this.f11857b.get(i11 - 1).addListener(new a(this.f11857b.get(i11)));
            }
            Transition transition = this.f11857b.get(0);
            if (transition != null) {
                transition.runAnimators();
                return;
            }
            return;
        }
        Iterator<Transition> it2 = this.f11857b.iterator();
        while (it2.hasNext()) {
            it2.next().runAnimators();
        }
    }

    public TransitionSet s(int i11) {
        if (i11 == 0) {
            this.f11858c = true;
        } else if (i11 == 1) {
            this.f11858c = false;
        } else {
            throw new AndroidRuntimeException("Invalid parameter for TransitionSet ordering: " + i11);
        }
        return this;
    }

    public void setCanRemoveViews(boolean z11) {
        super.setCanRemoveViews(z11);
        int size = this.f11857b.size();
        for (int i11 = 0; i11 < size; i11++) {
            this.f11857b.get(i11).setCanRemoveViews(z11);
        }
    }

    public void setEpicenterCallback(Transition.EpicenterCallback epicenterCallback) {
        super.setEpicenterCallback(epicenterCallback);
        this.f11861f |= 8;
        int size = this.f11857b.size();
        for (int i11 = 0; i11 < size; i11++) {
            this.f11857b.get(i11).setEpicenterCallback(epicenterCallback);
        }
    }

    public void setPathMotion(PathMotion pathMotion) {
        super.setPathMotion(pathMotion);
        this.f11861f |= 4;
        if (this.f11857b != null) {
            for (int i11 = 0; i11 < this.f11857b.size(); i11++) {
                this.f11857b.get(i11).setPathMotion(pathMotion);
            }
        }
    }

    public void setPropagation(TransitionPropagation transitionPropagation) {
        super.setPropagation(transitionPropagation);
        this.f11861f |= 2;
        int size = this.f11857b.size();
        for (int i11 = 0; i11 < size; i11++) {
            this.f11857b.get(i11).setPropagation(transitionPropagation);
        }
    }

    /* renamed from: t */
    public TransitionSet setSceneRoot(ViewGroup viewGroup) {
        super.setSceneRoot(viewGroup);
        int size = this.f11857b.size();
        for (int i11 = 0; i11 < size; i11++) {
            this.f11857b.get(i11).setSceneRoot(viewGroup);
        }
        return this;
    }

    public String toString(String str) {
        String transition = super.toString(str);
        for (int i11 = 0; i11 < this.f11857b.size(); i11++) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append(transition);
            sb2.append("\n");
            sb2.append(this.f11857b.get(i11).toString(str + "  "));
            transition = sb2.toString();
        }
        return transition;
    }

    /* renamed from: u */
    public TransitionSet setStartDelay(long j11) {
        return (TransitionSet) super.setStartDelay(j11);
    }

    public final void v() {
        b bVar = new b(this);
        Iterator<Transition> it2 = this.f11857b.iterator();
        while (it2.hasNext()) {
            it2.next().addListener(bVar);
        }
        this.f11859d = this.f11857b.size();
    }

    public Transition clone() {
        TransitionSet transitionSet = (TransitionSet) super.clone();
        transitionSet.f11857b = new ArrayList<>();
        int size = this.f11857b.size();
        for (int i11 = 0; i11 < size; i11++) {
            transitionSet.h(this.f11857b.get(i11).clone());
        }
        return transitionSet;
    }

    public Transition excludeTarget(String str, boolean z11) {
        for (int i11 = 0; i11 < this.f11857b.size(); i11++) {
            this.f11857b.get(i11).excludeTarget(str, z11);
        }
        return super.excludeTarget(str, z11);
    }

    @SuppressLint({"RestrictedApi"})
    public TransitionSet(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, l.f16670i);
        s(i.g(obtainStyledAttributes, (XmlResourceParser) attributeSet, "transitionOrdering", 0, 0));
        obtainStyledAttributes.recycle();
    }

    public Transition excludeTarget(int i11, boolean z11) {
        for (int i12 = 0; i12 < this.f11857b.size(); i12++) {
            this.f11857b.get(i12).excludeTarget(i11, z11);
        }
        return super.excludeTarget(i11, z11);
    }

    public Transition excludeTarget(Class<?> cls, boolean z11) {
        for (int i11 = 0; i11 < this.f11857b.size(); i11++) {
            this.f11857b.get(i11).excludeTarget(cls, z11);
        }
        return super.excludeTarget(cls, z11);
    }
}
