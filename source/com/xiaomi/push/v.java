package com.xiaomi.push;

import android.content.Context;
import java.io.File;
import java.io.IOException;

public abstract class v implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private Context f52617a;

    /* renamed from: a  reason: collision with other field name */
    private File f3451a;

    /* renamed from: a  reason: collision with other field name */
    private Runnable f3452a;

    public static void a(Context context, File file, final Runnable runnable) {
        new v(context, file) {
            public void a(Context context) {
                Runnable runnable = runnable;
                if (runnable != null) {
                    runnable.run();
                }
            }
        }.run();
    }

    public abstract void a(Context context);

    public final void run() {
        u uVar = null;
        try {
            if (this.f3451a == null) {
                this.f3451a = new File(this.f52617a.getFilesDir(), "default_locker");
            }
            uVar = u.a(this.f52617a, this.f3451a);
            Runnable runnable = this.f3452a;
            if (runnable != null) {
                runnable.run();
            }
            a(this.f52617a);
            if (uVar == null) {
                return;
            }
        } catch (IOException e11) {
            e11.printStackTrace();
            if (uVar == null) {
                return;
            }
        } catch (Throwable th2) {
            if (uVar != null) {
                uVar.a();
            }
            throw th2;
        }
        uVar.a();
    }

    private v(Context context, File file) {
        this.f52617a = context;
        this.f3451a = file;
    }
}
