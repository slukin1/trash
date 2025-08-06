package com.mob.mcl.c;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class g {

    /* renamed from: a  reason: collision with root package name */
    private static g f27464a;

    /* renamed from: b  reason: collision with root package name */
    private List<Map<String, Object>> f27465b;

    private g() {
    }

    public static g a() {
        if (f27464a == null) {
            synchronized (g.class) {
                if (f27464a == null) {
                    f27464a = new g();
                }
            }
        }
        return f27464a;
    }

    public boolean b() {
        List<Map<String, Object>> list = this.f27465b;
        return list != null && !list.isEmpty();
    }

    public List<Map<String, Object>> c() {
        return this.f27465b;
    }

    public void b(Map<String, Object> map) {
        List<Map<String, Object>> list = this.f27465b;
        if (list != null && list.contains(map)) {
            this.f27465b.remove(map);
        }
    }

    public void a(Map<String, Object> map) {
        if (this.f27465b == null) {
            this.f27465b = new ArrayList();
        }
        this.f27465b.add(map);
    }
}
