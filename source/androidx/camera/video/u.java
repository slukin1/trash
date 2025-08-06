package androidx.camera.video;

import android.content.Context;
import androidx.camera.core.impl.utils.ContextUtil;
import androidx.core.util.Consumer;
import androidx.core.util.h;
import java.util.concurrent.Executor;
import q0.e;

public final class u {

    /* renamed from: a  reason: collision with root package name */
    public final Context f6357a;

    /* renamed from: b  reason: collision with root package name */
    public final Recorder f6358b;

    /* renamed from: c  reason: collision with root package name */
    public final t f6359c;

    /* renamed from: d  reason: collision with root package name */
    public Consumer<v1> f6360d;

    /* renamed from: e  reason: collision with root package name */
    public Executor f6361e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f6362f = false;

    /* renamed from: g  reason: collision with root package name */
    public boolean f6363g = false;

    public u(Context context, Recorder recorder, t tVar) {
        this.f6357a = ContextUtil.getApplicationContext(context);
        this.f6358b = recorder;
        this.f6359c = tVar;
    }

    public Context a() {
        return this.f6357a;
    }

    public Consumer<v1> b() {
        return this.f6360d;
    }

    public Executor c() {
        return this.f6361e;
    }

    public t d() {
        return this.f6359c;
    }

    public Recorder e() {
        return this.f6358b;
    }

    public boolean f() {
        return this.f6362f;
    }

    public boolean g() {
        return this.f6363g;
    }

    public z0 h(Executor executor, Consumer<v1> consumer) {
        h.h(executor, "Listener Executor can't be null.");
        h.h(consumer, "Event listener can't be null");
        this.f6361e = executor;
        this.f6360d = consumer;
        return this.f6358b.w0(this);
    }

    public u i() {
        if (e.b(this.f6357a, "android.permission.RECORD_AUDIO") != -1) {
            h.j(this.f6358b.E(), "The Recorder this recording is associated to doesn't support audio.");
            this.f6362f = true;
            return this;
        }
        throw new SecurityException("Attempted to enable audio for recording but application does not have RECORD_AUDIO permission granted.");
    }
}
