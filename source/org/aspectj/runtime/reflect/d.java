package org.aspectj.runtime.reflect;

import java.util.Stack;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.runtime.internal.AroundClosure;
import w10.c;

public class d implements ProceedingJoinPoint {

    /* renamed from: a  reason: collision with root package name */
    public Object f59007a;

    /* renamed from: b  reason: collision with root package name */
    public Object f59008b;

    /* renamed from: c  reason: collision with root package name */
    public Object[] f59009c;

    /* renamed from: d  reason: collision with root package name */
    public JoinPoint.StaticPart f59010d;

    /* renamed from: e  reason: collision with root package name */
    public AroundClosure f59011e = null;

    /* renamed from: f  reason: collision with root package name */
    public Stack<AroundClosure> f59012f = null;

    public static class a implements JoinPoint.StaticPart {

        /* renamed from: a  reason: collision with root package name */
        public String f59013a;

        /* renamed from: b  reason: collision with root package name */
        public v10.a f59014b;

        /* renamed from: c  reason: collision with root package name */
        public c f59015c;

        /* renamed from: d  reason: collision with root package name */
        public int f59016d;

        public a(int i11, String str, v10.a aVar, c cVar) {
            this.f59013a = str;
            this.f59014b = aVar;
            this.f59015c = cVar;
            this.f59016d = i11;
        }

        public String a() {
            return this.f59013a;
        }

        public v10.a b() {
            return this.f59014b;
        }

        public String c(h hVar) {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append(hVar.d(a()));
            stringBuffer.append("(");
            stringBuffer.append(((SignatureImpl) b()).l(hVar));
            stringBuffer.append(")");
            return stringBuffer.toString();
        }

        public final String toString() {
            return c(h.f59022k);
        }
    }

    public d(JoinPoint.StaticPart staticPart, Object obj, Object obj2, Object[] objArr) {
        this.f59010d = staticPart;
        this.f59007a = obj;
        this.f59008b = obj2;
        this.f59009c = objArr;
    }

    public Object a() throws Throwable {
        Stack<AroundClosure> stack = this.f59012f;
        if (stack != null) {
            return stack.peek().run(this.f59012f.peek().getState());
        }
        AroundClosure aroundClosure = this.f59011e;
        if (aroundClosure == null) {
            return null;
        }
        return aroundClosure.run(aroundClosure.getState());
    }

    public Object b() {
        return this.f59007a;
    }

    public Object[] c() {
        if (this.f59009c == null) {
            this.f59009c = new Object[0];
        }
        Object[] objArr = this.f59009c;
        Object[] objArr2 = new Object[objArr.length];
        System.arraycopy(objArr, 0, objArr2, 0, objArr.length);
        return objArr2;
    }

    public void d(AroundClosure aroundClosure) {
        this.f59011e = aroundClosure;
    }

    public Object e(Object[] objArr) throws Throwable {
        AroundClosure aroundClosure;
        int i11;
        Stack<AroundClosure> stack = this.f59012f;
        if (stack == null) {
            aroundClosure = this.f59011e;
        } else {
            aroundClosure = stack.peek();
        }
        if (aroundClosure == null) {
            return null;
        }
        int flags = aroundClosure.getFlags();
        int i12 = 1;
        boolean z11 = (65536 & flags) != 0;
        int i13 = (flags & 4096) != 0 ? 1 : 0;
        int i14 = (flags & 256) != 0 ? 1 : 0;
        boolean z12 = (flags & 16) != 0;
        boolean z13 = (flags & 1) != 0;
        Object[] state = aroundClosure.getState();
        int i15 = i13 + 0 + ((!z12 || z11) ? 0 : 1);
        if (i13 == 0 || i14 == 0) {
            i11 = 0;
        } else {
            state[0] = objArr[0];
            i11 = 1;
        }
        if (z12 && z13) {
            if (z11) {
                i11 = i14 + 1;
                state[0] = objArr[i14];
            } else {
                char c11 = (i13 == 0 || i14 == 0) ? (char) 0 : 1;
                int i16 = (i13 == 0 || i14 == 0) ? 0 : 1;
                if (!z12 || !z13 || z11) {
                    i12 = 0;
                }
                state[i13] = objArr[c11];
                i11 = i16 + i12;
            }
        }
        for (int i17 = i11; i17 < objArr.length; i17++) {
            state[(i17 - i11) + i15] = objArr[i17];
        }
        return aroundClosure.run(state);
    }

    public void f(AroundClosure aroundClosure) {
        if (this.f59012f == null) {
            this.f59012f = new Stack<>();
        }
        if (aroundClosure == null) {
            this.f59012f.pop();
        } else {
            this.f59012f.push(aroundClosure);
        }
    }

    public Object getTarget() {
        return this.f59008b;
    }

    public final String toString() {
        return this.f59010d.toString();
    }
}
