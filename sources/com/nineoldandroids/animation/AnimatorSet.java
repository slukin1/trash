package com.nineoldandroids.animation;

import com.nineoldandroids.animation.Animator;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public final class AnimatorSet extends Animator {

    /* renamed from: c  reason: collision with root package name */
    public ArrayList<Animator> f28230c = new ArrayList<>();

    /* renamed from: d  reason: collision with root package name */
    public HashMap<Animator, b> f28231d = new HashMap<>();

    /* renamed from: e  reason: collision with root package name */
    public ArrayList<b> f28232e = new ArrayList<>();

    /* renamed from: f  reason: collision with root package name */
    public ArrayList<b> f28233f = new ArrayList<>();

    /* renamed from: g  reason: collision with root package name */
    public boolean f28234g = true;

    /* renamed from: h  reason: collision with root package name */
    public boolean f28235h = false;

    /* renamed from: i  reason: collision with root package name */
    public boolean f28236i = false;

    /* renamed from: j  reason: collision with root package name */
    public long f28237j = 0;

    /* renamed from: k  reason: collision with root package name */
    public ValueAnimator f28238k = null;

    /* renamed from: l  reason: collision with root package name */
    public long f28239l = -1;

    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public b f28240a;

        /* renamed from: b  reason: collision with root package name */
        public int f28241b;

        public a(b bVar, int i11) {
            this.f28240a = bVar;
            this.f28241b = i11;
        }
    }

    public static class b implements Cloneable {

        /* renamed from: b  reason: collision with root package name */
        public Animator f28242b;

        /* renamed from: c  reason: collision with root package name */
        public ArrayList<a> f28243c;

        /* renamed from: d  reason: collision with root package name */
        public ArrayList<a> f28244d;

        /* renamed from: e  reason: collision with root package name */
        public ArrayList<b> f28245e;

        /* renamed from: f  reason: collision with root package name */
        public ArrayList<b> f28246f;

        public void b(a aVar) {
            if (this.f28243c == null) {
                this.f28243c = new ArrayList<>();
                this.f28245e = new ArrayList<>();
            }
            this.f28243c.add(aVar);
            if (!this.f28245e.contains(aVar.f28240a)) {
                this.f28245e.add(aVar.f28240a);
            }
            b bVar = aVar.f28240a;
            if (bVar.f28246f == null) {
                bVar.f28246f = new ArrayList<>();
            }
            bVar.f28246f.add(this);
        }

        /* renamed from: c */
        public b clone() {
            try {
                b bVar = (b) super.clone();
                bVar.f28242b = this.f28242b.clone();
                return bVar;
            } catch (CloneNotSupportedException unused) {
                throw new AssertionError();
            }
        }
    }

    /* renamed from: e */
    public AnimatorSet clone() {
        AnimatorSet animatorSet = (AnimatorSet) super.clone();
        animatorSet.f28234g = true;
        animatorSet.f28235h = false;
        animatorSet.f28236i = false;
        animatorSet.f28230c = new ArrayList<>();
        animatorSet.f28231d = new HashMap<>();
        animatorSet.f28232e = new ArrayList<>();
        animatorSet.f28233f = new ArrayList<>();
        HashMap hashMap = new HashMap();
        Iterator<b> it2 = this.f28232e.iterator();
        while (it2.hasNext()) {
            b next = it2.next();
            b c11 = next.clone();
            hashMap.put(next, c11);
            animatorSet.f28232e.add(c11);
            animatorSet.f28231d.put(c11.f28242b, c11);
            c11.f28243c = null;
            c11.f28244d = null;
            c11.f28246f = null;
            c11.f28245e = null;
            ArrayList<Animator.a> d11 = c11.f28242b.d();
            if (d11 != null) {
                Iterator<Animator.a> it3 = d11.iterator();
                while (it3.hasNext()) {
                    Animator.a next2 = it3.next();
                }
            }
        }
        Iterator<b> it4 = this.f28232e.iterator();
        while (it4.hasNext()) {
            b next3 = it4.next();
            b bVar = (b) hashMap.get(next3);
            ArrayList<a> arrayList = next3.f28243c;
            if (arrayList != null) {
                Iterator<a> it5 = arrayList.iterator();
                while (it5.hasNext()) {
                    a next4 = it5.next();
                    bVar.b(new a((b) hashMap.get(next4.f28240a), next4.f28241b));
                }
            }
        }
        return animatorSet;
    }
}
