package com.nineoldandroids.animation;

import java.util.ArrayList;

public abstract class Animator implements Cloneable {

    /* renamed from: b  reason: collision with root package name */
    public ArrayList<a> f28226b = null;

    public interface a {
        void onAnimationEnd(Animator animator);

        void onAnimationRepeat(Animator animator);

        void onAnimationStart(Animator animator);
    }

    public void b(a aVar) {
        if (this.f28226b == null) {
            this.f28226b = new ArrayList<>();
        }
        this.f28226b.add(aVar);
    }

    /* renamed from: c */
    public Animator clone() {
        try {
            Animator animator = (Animator) super.clone();
            ArrayList<a> arrayList = this.f28226b;
            if (arrayList != null) {
                animator.f28226b = new ArrayList<>();
                int size = arrayList.size();
                for (int i11 = 0; i11 < size; i11++) {
                    animator.f28226b.add(arrayList.get(i11));
                }
            }
            return animator;
        } catch (CloneNotSupportedException unused) {
            throw new AssertionError();
        }
    }

    public ArrayList<a> d() {
        return this.f28226b;
    }
}
