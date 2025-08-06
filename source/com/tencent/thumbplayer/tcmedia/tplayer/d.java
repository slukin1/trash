package com.tencent.thumbplayer.tcmedia.tplayer;

import android.content.res.AssetFileDescriptor;
import android.os.ParcelFileDescriptor;
import com.tencent.thumbplayer.tcmedia.utils.TPLogUtil;
import com.tencent.thumbplayer.tcmedia.utils.n;
import com.tencent.thumbplayer.tcmedia.utils.q;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class d implements InvocationHandler {

    /* renamed from: a  reason: collision with root package name */
    private b f49617a;

    /* renamed from: b  reason: collision with root package name */
    private q f49618b;

    public d(b bVar) {
        this.f49617a = bVar;
        this.f49618b = new q(bVar.b(), this.f49617a.a(), this.f49617a);
    }

    private int a(Object[] objArr) {
        if (objArr == null) {
            return 0;
        }
        return objArr.length;
    }

    private boolean a(Method method, Object[] objArr) {
        return n.a(this.f49617a.getClass(), method.getName(), objArr) != null;
    }

    private Object b(Method method, Object[] objArr) {
        String name = method.getName();
        if (name.equals("setDataSource")) {
            objArr = b(objArr);
        }
        if (method.getReturnType().getName().equals("void")) {
            this.f49618b.b(name, objArr);
            return null;
        }
        Object a11 = this.f49618b.a(name, (Object) objArr);
        String b11 = this.f49617a.b();
        TPLogUtil.i(b11, "dealThreadSwitch: " + name + ", var count:" + a(objArr) + ", result:" + a11);
        return a11;
    }

    private Object[] b(Object[] objArr) {
        String b11;
        StringBuilder sb2;
        if (objArr[0] != null && (objArr[0] instanceof ParcelFileDescriptor)) {
            try {
                ParcelFileDescriptor parcelFileDescriptor = (ParcelFileDescriptor) objArr[0];
                objArr[0] = ParcelFileDescriptor.fromFd(parcelFileDescriptor.detachFd());
                parcelFileDescriptor.close();
            } catch (Exception e11) {
                e = e11;
                b11 = this.f49617a.b();
                sb2 = new StringBuilder("setDataSource, fromFd has exception:");
            }
        } else if (objArr[0] != null && (objArr[0] instanceof AssetFileDescriptor)) {
            try {
                AssetFileDescriptor assetFileDescriptor = (AssetFileDescriptor) objArr[0];
                objArr[0] = new AssetFileDescriptor(ParcelFileDescriptor.fromFd(assetFileDescriptor.getParcelFileDescriptor().detachFd()), assetFileDescriptor.getStartOffset(), assetFileDescriptor.getLength());
                assetFileDescriptor.close();
            } catch (Exception e12) {
                e = e12;
                b11 = this.f49617a.b();
                sb2 = new StringBuilder("setDataSource, fromFd has exception:");
            }
        }
        return objArr;
        sb2.append(e.toString());
        TPLogUtil.e(b11, sb2.toString());
        return objArr;
    }

    public Object a() {
        return Proxy.newProxyInstance(this.f49617a.getClass().getClassLoader(), this.f49617a.getClass().getInterfaces(), this);
    }

    public Object invoke(Object obj, Method method, Object[] objArr) {
        return !a(method, objArr) ? method.invoke(this.f49617a, objArr) : b(method, objArr);
    }
}
