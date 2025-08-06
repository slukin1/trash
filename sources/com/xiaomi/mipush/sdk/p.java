package com.xiaomi.mipush.sdk;

import android.content.Context;
import android.content.SharedPreferences;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class p {

    /* renamed from: a  reason: collision with root package name */
    private static volatile p f51327a;

    /* renamed from: a  reason: collision with other field name */
    private Context f2474a;

    /* renamed from: a  reason: collision with other field name */
    private List<n> f2475a = new ArrayList();

    private p(Context context) {
        Context applicationContext = context.getApplicationContext();
        this.f2474a = applicationContext;
        if (applicationContext == null) {
            this.f2474a = context;
        }
    }

    public static p a(Context context) {
        if (f51327a == null) {
            synchronized (p.class) {
                if (f51327a == null) {
                    f51327a = new p(context);
                }
            }
        }
        return f51327a;
    }

    public void b(String str) {
        synchronized (this.f2475a) {
            n nVar = new n();
            nVar.f2472a = str;
            if (this.f2475a.contains(nVar)) {
                Iterator<n> it2 = this.f2475a.iterator();
                while (true) {
                    if (!it2.hasNext()) {
                        break;
                    }
                    n next = it2.next();
                    if (nVar.equals(next)) {
                        nVar = next;
                        break;
                    }
                }
            }
            nVar.f51325a++;
            this.f2475a.remove(nVar);
            this.f2475a.add(nVar);
        }
    }

    public void c(String str) {
        synchronized (this.f2475a) {
            n nVar = new n();
            nVar.f2472a = str;
            if (this.f2475a.contains(nVar)) {
                this.f2475a.remove(nVar);
            }
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m2363a(String str) {
        synchronized (this.f2475a) {
            n nVar = new n();
            nVar.f51325a = 0;
            nVar.f2472a = str;
            if (this.f2475a.contains(nVar)) {
                this.f2475a.remove(nVar);
            }
            this.f2475a.add(nVar);
        }
    }

    public int a(String str) {
        synchronized (this.f2475a) {
            n nVar = new n();
            nVar.f2472a = str;
            if (this.f2475a.contains(nVar)) {
                for (n next : this.f2475a) {
                    if (next.equals(nVar)) {
                        int i11 = next.f51325a;
                        return i11;
                    }
                }
            }
            return 0;
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m2364a(String str) {
        synchronized (this.f2475a) {
            n nVar = new n();
            nVar.f2472a = str;
            if (this.f2475a.contains(nVar)) {
                return true;
            }
            return false;
        }
    }

    public synchronized String a(v vVar) {
        return this.f2474a.getSharedPreferences("mipush_extra", 0).getString(vVar.name(), "");
    }

    public synchronized void a(v vVar, String str) {
        SharedPreferences sharedPreferences = this.f2474a.getSharedPreferences("mipush_extra", 0);
        sharedPreferences.edit().putString(vVar.name(), str).apply();
    }
}
