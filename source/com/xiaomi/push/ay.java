package com.xiaomi.push;

import java.util.LinkedList;

public class ay {

    /* renamed from: a  reason: collision with root package name */
    private LinkedList<a> f51412a = new LinkedList<>();

    public static class a {
        /* access modifiers changed from: private */

        /* renamed from: a  reason: collision with root package name */
        public static final ay f51413a = new ay();

        /* renamed from: a  reason: collision with other field name */
        public int f2546a;

        /* renamed from: a  reason: collision with other field name */
        public Object f2547a;

        /* renamed from: a  reason: collision with other field name */
        public String f2548a;

        public a(int i11, Object obj) {
            this.f2546a = i11;
            this.f2547a = obj;
        }
    }

    public static ay a() {
        return a.f51413a;
    }

    public synchronized void a(Object obj) {
        this.f51412a.add(new a(0, obj));
        a();
    }

    /* renamed from: a  reason: collision with other method in class */
    private void m2414a() {
        if (this.f51412a.size() > 100) {
            this.f51412a.removeFirst();
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public synchronized int m2415a() {
        return this.f51412a.size();
    }

    /* renamed from: a  reason: collision with other method in class */
    public synchronized LinkedList<a> m2416a() {
        LinkedList<a> linkedList;
        linkedList = this.f51412a;
        this.f51412a = new LinkedList<>();
        return linkedList;
    }
}
