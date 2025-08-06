package com.huobi.edgeengine.ability;

import android.os.Handler;
import com.eclipsesource.v8.V8Array;
import com.eclipsesource.v8.V8Function;
import com.eclipsesource.v8.V8Object;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class u {

    /* renamed from: a  reason: collision with root package name */
    public int f43940a = 1;

    /* renamed from: b  reason: collision with root package name */
    public Map<Integer, Runnable> f43941b = new ConcurrentHashMap();

    /* renamed from: c  reason: collision with root package name */
    public Handler f43942c;

    public u(Handler handler) {
        this.f43942c = handler;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void d(V8Function v8Function, V8Object v8Object, int i11, int i12) {
        if (!v8Function.isReleased()) {
            v8Function.call(v8Object, (V8Array) null);
            if (this.f43941b.containsKey(Integer.valueOf(i11))) {
                this.f43942c.postDelayed(this.f43941b.get(Integer.valueOf(i11)), (long) i12);
            }
        }
    }

    public void b(int i11) {
        if (this.f43941b.containsKey(Integer.valueOf(i11))) {
            this.f43942c.removeCallbacks(this.f43941b.remove(Integer.valueOf(i11)));
        }
    }

    public void c() {
        if (this.f43941b.size() != 0) {
            for (Map.Entry<Integer, Runnable> key : this.f43941b.entrySet()) {
                b(((Integer) key.getKey()).intValue());
            }
        }
    }

    public int e(V8Object v8Object, V8Function v8Function, int i11) {
        if (this.f43942c == null) {
            return -1;
        }
        int i12 = this.f43940a;
        this.f43940a = i12 + 1;
        t tVar = new t(this, v8Function, v8Object, i12, i11);
        this.f43941b.put(Integer.valueOf(i12), tVar);
        this.f43942c.postDelayed(tVar, (long) i11);
        return i12;
    }
}
