package com.bumptech.glide.load.model;

import f4.f;
import f4.i;
import java.util.Queue;

public class ModelCache<A, B> {

    /* renamed from: a  reason: collision with root package name */
    public final f<b<A>, B> f63969a;

    public class a extends f<b<A>, B> {
        public a(long j11) {
            super(j11);
        }

        /* renamed from: n */
        public void j(b<A> bVar, B b11) {
            bVar.c();
        }
    }

    public static final class b<A> {

        /* renamed from: d  reason: collision with root package name */
        public static final Queue<b<?>> f63971d = i.f(0);

        /* renamed from: a  reason: collision with root package name */
        public int f63972a;

        /* renamed from: b  reason: collision with root package name */
        public int f63973b;

        /* renamed from: c  reason: collision with root package name */
        public A f63974c;

        public static <A> b<A> a(A a11, int i11, int i12) {
            b<A> poll;
            Queue<b<?>> queue = f63971d;
            synchronized (queue) {
                poll = queue.poll();
            }
            if (poll == null) {
                poll = new b<>();
            }
            poll.b(a11, i11, i12);
            return poll;
        }

        public final void b(A a11, int i11, int i12) {
            this.f63974c = a11;
            this.f63973b = i11;
            this.f63972a = i12;
        }

        public void c() {
            Queue<b<?>> queue = f63971d;
            synchronized (queue) {
                queue.offer(this);
            }
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof b)) {
                return false;
            }
            b bVar = (b) obj;
            if (this.f63973b == bVar.f63973b && this.f63972a == bVar.f63972a && this.f63974c.equals(bVar.f63974c)) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            return (((this.f63972a * 31) + this.f63973b) * 31) + this.f63974c.hashCode();
        }
    }

    public ModelCache() {
        this(250);
    }

    public B a(A a11, int i11, int i12) {
        b a12 = b.a(a11, i11, i12);
        B g11 = this.f63969a.g(a12);
        a12.c();
        return g11;
    }

    public void b(A a11, int i11, int i12, B b11) {
        this.f63969a.k(b.a(a11, i11, i12), b11);
    }

    public ModelCache(long j11) {
        this.f63969a = new a(j11);
    }
}
