package ly;

import android.view.View;
import android.view.ViewGroup;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import ky.f;
import ky.h;
import ky.i;

public class b extends d implements f, InvocationHandler {

    /* renamed from: d  reason: collision with root package name */
    public i f37220d;

    /* renamed from: e  reason: collision with root package name */
    public Method f37221e;

    /* renamed from: f  reason: collision with root package name */
    public Method f37222f;

    /* renamed from: g  reason: collision with root package name */
    public Method f37223g;

    public b(View view) {
        super(view);
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:0x0053  */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x0076 A[RETURN] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Object invoke(java.lang.Object r4, java.lang.reflect.Method r5, java.lang.Object[] r6) throws java.lang.Throwable {
        /*
            r3 = this;
            java.lang.Class<ky.i> r0 = ky.i.class
            ky.i r1 = r3.f37220d
            if (r1 == 0) goto L_0x0048
            java.lang.reflect.Method r1 = r3.f37221e
            boolean r1 = r5.equals(r1)
            r2 = 0
            if (r1 == 0) goto L_0x001d
            ky.i r1 = r3.f37220d
            r6 = r6[r2]
            java.lang.Integer r6 = (java.lang.Integer) r6
            int r6 = r6.intValue()
            r1.d(r6)
            goto L_0x0048
        L_0x001d:
            java.lang.reflect.Method r1 = r3.f37222f
            boolean r1 = r5.equals(r1)
            if (r1 == 0) goto L_0x002b
            ky.i r6 = r3.f37220d
            r6.o()
            goto L_0x0048
        L_0x002b:
            java.lang.reflect.Method r1 = r3.f37223g
            boolean r1 = r5.equals(r1)
            if (r1 == 0) goto L_0x0041
            ky.i r1 = r3.f37220d
            r6 = r6[r2]
            java.lang.Boolean r6 = (java.lang.Boolean) r6
            boolean r6 = r6.booleanValue()
            r1.n(r6)
            goto L_0x0048
        L_0x0041:
            ky.i r1 = r3.f37220d
            java.lang.Object r6 = r5.invoke(r1, r6)
            goto L_0x0049
        L_0x0048:
            r6 = 0
        L_0x0049:
            java.lang.Class r1 = r5.getReturnType()
            boolean r1 = r1.equals(r0)
            if (r1 == 0) goto L_0x0076
            ky.i r6 = r3.f37220d
            if (r6 != 0) goto L_0x0075
            java.lang.Class r6 = r5.getDeclaringClass()
            boolean r6 = r0.equals(r6)
            if (r6 == 0) goto L_0x0075
            java.lang.reflect.Method r6 = r3.f37221e
            if (r6 != 0) goto L_0x0068
            r3.f37221e = r5
            goto L_0x0075
        L_0x0068:
            java.lang.reflect.Method r6 = r3.f37222f
            if (r6 != 0) goto L_0x006f
            r3.f37222f = r5
            goto L_0x0075
        L_0x006f:
            java.lang.reflect.Method r6 = r3.f37223g
            if (r6 != 0) goto L_0x0075
            r3.f37223g = r5
        L_0x0075:
            return r4
        L_0x0076:
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: ly.b.invoke(java.lang.Object, java.lang.reflect.Method, java.lang.Object[]):java.lang.Object");
    }

    public void onInitialized(i iVar, int i11, int i12) {
        Class<i> cls = i.class;
        View view = this.f37228b;
        if (view instanceof h) {
            i iVar2 = (i) Proxy.newProxyInstance(cls.getClassLoader(), new Class[]{cls}, this);
            iVar2.c(0);
            iVar2.a();
            iVar2.e(false);
            this.f37220d = iVar;
            ((h) this.f37228b).onInitialized(iVar2, i11, i12);
            return;
        }
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams instanceof SmartRefreshLayout.LayoutParams) {
            iVar.d(((SmartRefreshLayout.LayoutParams) layoutParams).f29771a);
        }
    }

    public boolean setNoMoreData(boolean z11) {
        View view = this.f37228b;
        if (!(view instanceof f)) {
            return false;
        }
        ((f) view).setNoMoreData(z11);
        return false;
    }
}
