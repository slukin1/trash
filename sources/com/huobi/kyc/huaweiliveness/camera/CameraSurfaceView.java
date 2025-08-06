package com.huobi.kyc.huaweiliveness.camera;

import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import com.huobi.kyc.huaweiliveness.camera.a;
import java.util.concurrent.atomic.AtomicBoolean;

public class CameraSurfaceView extends SurfaceView {

    /* renamed from: b  reason: collision with root package name */
    public a f74802b;

    /* renamed from: c  reason: collision with root package name */
    public int f74803c;

    /* renamed from: d  reason: collision with root package name */
    public int f74804d;

    /* renamed from: e  reason: collision with root package name */
    public AtomicBoolean f74805e;

    /* renamed from: f  reason: collision with root package name */
    public final SurfaceHolder.Callback f74806f;

    public class a implements SurfaceHolder.Callback {
        public a() {
        }

        public void surfaceChanged(SurfaceHolder surfaceHolder, int i11, int i12, int i13) {
            int d11 = CameraSurfaceView.this.f74802b.d();
            int c11 = CameraSurfaceView.this.f74802b.c();
            if (i12 > i13) {
                CameraSurfaceView.this.e(d11, c11);
            } else {
                CameraSurfaceView.this.e(c11, d11);
            }
            CameraSurfaceView.this.f74802b.k(surfaceHolder);
        }

        public void surfaceCreated(SurfaceHolder surfaceHolder) {
            CameraSurfaceView.this.d();
        }

        public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
            CameraSurfaceView.this.f74802b.h();
            CameraSurfaceView.this.f74802b.a().finish();
        }
    }

    public CameraSurfaceView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public final void c(Context context) {
        getHolder().addCallback(this.f74806f);
        this.f74802b = new a((Activity) context);
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(4:5|6|7|8) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0016 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void d() {
        /*
            r4 = this;
            monitor-enter(r4)
            java.util.concurrent.atomic.AtomicBoolean r0 = r4.f74805e     // Catch:{ all -> 0x0026 }
            boolean r0 = r0.get()     // Catch:{ all -> 0x0026 }
            r1 = 0
            r2 = 1
            if (r0 != 0) goto L_0x001b
            com.huobi.kyc.huaweiliveness.camera.a r0 = r4.f74802b     // Catch:{ Exception -> 0x0016 }
            r0.g()     // Catch:{ Exception -> 0x0016 }
            java.util.concurrent.atomic.AtomicBoolean r0 = r4.f74805e     // Catch:{ Exception -> 0x0016 }
            r0.set(r2)     // Catch:{ Exception -> 0x0016 }
            goto L_0x001b
        L_0x0016:
            java.util.concurrent.atomic.AtomicBoolean r0 = r4.f74805e     // Catch:{ all -> 0x0026 }
            r0.set(r1)     // Catch:{ all -> 0x0026 }
        L_0x001b:
            android.view.SurfaceHolder$Callback r0 = r4.f74806f     // Catch:{ all -> 0x0026 }
            android.view.SurfaceHolder r3 = r4.getHolder()     // Catch:{ all -> 0x0026 }
            r0.surfaceChanged(r3, r2, r1, r2)     // Catch:{ all -> 0x0026 }
            monitor-exit(r4)
            return
        L_0x0026:
            r0 = move-exception
            monitor-exit(r4)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huobi.kyc.huaweiliveness.camera.CameraSurfaceView.d():void");
    }

    public final void e(int i11, int i12) {
        if (i11 < 0 || i12 < 0) {
            throw new IllegalArgumentException("Size cannot be negative.");
        }
        this.f74803c = i11;
        this.f74804d = i12;
        requestLayout();
    }

    public a getCameraProxy() {
        return this.f74802b;
    }

    public void onMeasure(int i11, int i12) {
        int i13;
        super.onMeasure(i11, i12);
        int size = View.MeasureSpec.getSize(i11);
        int size2 = View.MeasureSpec.getSize(i12);
        int i14 = this.f74803c;
        if (i14 == 0 || (i13 = this.f74804d) == 0) {
            setMeasuredDimension(size, size2);
        } else if (size < (size2 * i14) / i13) {
            setMeasuredDimension(size, (i13 * size) / i14);
        } else {
            setMeasuredDimension((i14 * size2) / i13, size2);
        }
    }

    public void setPreviewDataCallback(a.c cVar) {
        getCameraProxy().j(cVar);
    }

    public CameraSurfaceView(Context context, AttributeSet attributeSet, int i11) {
        this(context, attributeSet, i11, 0);
    }

    public CameraSurfaceView(Context context, AttributeSet attributeSet, int i11, int i12) {
        super(context, attributeSet, i11, i12);
        this.f74803c = 0;
        this.f74804d = 0;
        this.f74805e = new AtomicBoolean(false);
        this.f74806f = new a();
        c(context);
    }
}
