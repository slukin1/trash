package com.dianping.logan;

import android.text.TextUtils;
import java.io.File;

public abstract class SendLogRunnable implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public f f64843b;

    /* renamed from: c  reason: collision with root package name */
    public a f64844c;

    public interface a {
        void a(int i11);
    }

    public void a() {
        a aVar = this.f64844c;
        if (aVar != null) {
            aVar.a(10002);
        }
    }

    public abstract void b(File file);

    public void c(a aVar) {
        this.f64844c = aVar;
    }

    public void d(f fVar) {
        this.f64843b = fVar;
    }

    public void run() {
        f fVar = this.f64843b;
        if (fVar == null || TextUtils.isEmpty(fVar.f64886b)) {
            a();
        } else if (TextUtils.isEmpty(this.f64843b.f64887c)) {
            a();
        } else {
            b(new File(this.f64843b.f64887c));
        }
    }
}
