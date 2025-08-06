package com.huobi.edgeengine.ability;

import android.os.CountDownTimer;
import com.eclipsesource.v8.V8;
import com.eclipsesource.v8.V8Array;
import com.eclipsesource.v8.V8Function;
import com.eclipsesource.v8.V8Object;

public class e0 extends V8Function {

    public class a extends CountDownTimer {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ V8Function f43918a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ V8 f43919b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(long j11, long j12, V8Function v8Function, V8 v82) {
            super(j11, j12);
            this.f43918a = v8Function;
            this.f43919b = v82;
        }

        public void onFinish() {
            if (!this.f43918a.isReleased()) {
                this.f43918a.call(this.f43919b, (V8Array) null);
            }
        }

        public void onTick(long j11) {
        }
    }

    public e0(V8 v82) {
        super(v82, new d0(v82));
    }

    public static /* synthetic */ Object f(V8 v82, V8Object v8Object, V8Array v8Array) {
        if (v8Array != null && v8Array.length() == 2 && (v8Array.get(0) instanceof V8Function) && (v8Array.get(1) instanceof Integer)) {
            Integer num = (Integer) v8Array.get(1);
            new a((long) num.intValue(), (long) num.intValue(), (V8Function) v8Array.get(0), v82).start();
        }
        return null;
    }
}
