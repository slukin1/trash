package com.tencent.thumbplayer.tcmedia.c;

import com.tencent.thumbplayer.tcmedia.core.downloadproxy.api.ITPPlayListener;
import com.tencent.thumbplayer.tcmedia.d.b;
import com.tencent.thumbplayer.tcmedia.utils.TPLogUtil;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Map;

public class d implements InvocationHandler {

    /* renamed from: a  reason: collision with root package name */
    private e f49049a;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public com.tencent.thumbplayer.tcmedia.tplayer.a f49050b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public ITPPlayListener f49051c;

    /* renamed from: d  reason: collision with root package name */
    private a f49052d = new a();

    /* renamed from: e  reason: collision with root package name */
    private Object f49053e;

    public class a implements ITPPlayListener {
        private a() {
        }

        public long getAdvRemainTime() {
            return d.this.f49051c.getAdvRemainTime();
        }

        public String getContentType(int i11, String str) {
            return d.this.f49051c.getContentType(i11, str);
        }

        public int getCurrentPlayClipNo() {
            return d.this.f49051c.getCurrentPlayClipNo();
        }

        public long getCurrentPlayOffset() {
            return d.this.f49051c.getCurrentPlayOffset();
        }

        public long getCurrentPosition() {
            return d.this.f49051c.getCurrentPosition();
        }

        public String getDataFilePath(int i11, String str) {
            return d.this.f49051c.getDataFilePath(i11, str);
        }

        public long getDataTotalSize(int i11, String str) {
            return d.this.f49051c.getDataTotalSize(i11, str);
        }

        public Object getPlayInfo(long j11) {
            return d.this.f49051c.getPlayInfo(j11);
        }

        public Object getPlayInfo(String str) {
            return d.this.f49051c.getPlayInfo(str);
        }

        public long getPlayerBufferLength() {
            return d.this.f49051c.getPlayerBufferLength();
        }

        public void onDownloadCdnUrlExpired(Map<String, String> map) {
            d.this.f49051c.onDownloadCdnUrlExpired(map);
        }

        public void onDownloadCdnUrlInfoUpdate(String str, String str2, String str3, String str4) {
            b.d dVar = new b.d();
            dVar.a(str2);
            dVar.b(str3);
            d.this.f49050b.b().a((b.a) dVar);
            d.this.f49051c.onDownloadCdnUrlInfoUpdate(str, str2, str3, str4);
        }

        public void onDownloadCdnUrlUpdate(String str) {
            d.this.f49051c.onDownloadCdnUrlUpdate(str);
        }

        public void onDownloadError(int i11, int i12, String str) {
            d.this.f49051c.onDownloadError(i11, i12, str);
        }

        public void onDownloadFinish() {
            d.this.f49051c.onDownloadFinish();
        }

        public void onDownloadProgressUpdate(int i11, int i12, long j11, long j12, String str) {
            b.e eVar = new b.e();
            eVar.b(i12 * 8);
            d.this.f49050b.b().a((b.a) eVar);
            d.this.f49051c.onDownloadProgressUpdate(i11, i12, j11, j12, str);
        }

        public void onDownloadProtocolUpdate(String str, String str2) {
            b.f fVar = new b.f();
            fVar.b(str);
            fVar.a(str2);
            d.this.f49050b.b().a((b.a) fVar);
            d.this.f49051c.onDownloadProtocolUpdate(str, str2);
        }

        public void onDownloadStatusUpdate(int i11) {
            d.this.f49051c.onDownloadStatusUpdate(i11);
        }

        public Object onPlayCallback(int i11, Object obj, Object obj2, Object obj3, Object obj4) {
            return d.this.f49051c.onPlayCallback(i11, obj, obj2, obj3, obj4);
        }

        public int onReadData(int i11, String str, long j11, long j12) {
            return d.this.f49051c.onReadData(i11, str, j11, j12);
        }

        public int onStartReadData(int i11, String str, long j11, long j12) {
            return d.this.f49051c.onStartReadData(i11, str, j11, j12);
        }

        public int onStopReadData(int i11, String str, int i12) {
            return d.this.f49051c.onStopReadData(i11, str, i12);
        }
    }

    public d(e eVar, com.tencent.thumbplayer.tcmedia.tplayer.a aVar) {
        this.f49049a = eVar;
        this.f49050b = aVar;
    }

    private static Object a(Method method) {
        String name = method.getReturnType().getName();
        if (name.equals("boolean")) {
            return Boolean.FALSE;
        }
        if (name.equals("int")) {
            return 0;
        }
        if (name.equals("long")) {
            return 0L;
        }
        if (name.equals("float")) {
            return Float.valueOf(0.0f);
        }
        return null;
    }

    private void a(Method method, Object[] objArr) {
        String name = method.getName();
        name.hashCode();
        if (name.equals("startDownloadPlayByAsset") || name.equals("startDownloadPlay")) {
            a(objArr);
        }
    }

    private void a(Object[] objArr) {
        this.f49050b.b().a((b.a) new b.g());
    }

    private void b(Method method, Object[] objArr) {
        if (method.getName().equals("setPlayListener")) {
            this.f49051c = objArr[0];
            objArr[0] = this.f49052d;
        }
    }

    public synchronized Object a() {
        if (this.f49053e == null) {
            this.f49053e = Proxy.newProxyInstance(this.f49049a.getClass().getClassLoader(), this.f49049a.getClass().getInterfaces(), this);
        }
        return this.f49053e;
    }

    public Object invoke(Object obj, Method method, Object[] objArr) {
        StringBuilder sb2;
        String invocationTargetException;
        b(method, objArr);
        try {
            Object invoke = method.invoke(this.f49049a, objArr);
            a(method, objArr);
            return invoke;
        } catch (InvocationTargetException e11) {
            if (e11.getTargetException() == null) {
                sb2 = new StringBuilder("invokeMethod ");
                sb2.append(method.getName());
                sb2.append(" has excecption: ");
                invocationTargetException = e11.toString();
                sb2.append(invocationTargetException);
                TPLogUtil.e("TPDataTransportManagerProxy", sb2.toString());
                return a(method);
            }
            throw e11.getTargetException();
        } catch (Throwable th2) {
            sb2 = new StringBuilder("invokeMethod ");
            sb2.append(method.getName());
            sb2.append(" has excecption: ");
            invocationTargetException = th2.toString();
            sb2.append(invocationTargetException);
            TPLogUtil.e("TPDataTransportManagerProxy", sb2.toString());
            return a(method);
        }
    }
}
