package r10;

import java.util.concurrent.ThreadFactory;
import okhttp3.internal.Util;

public final /* synthetic */ class a implements ThreadFactory {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ String f70502b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ boolean f70503c;

    public /* synthetic */ a(String str, boolean z11) {
        this.f70502b = str;
        this.f70503c = z11;
    }

    public final Thread newThread(Runnable runnable) {
        return Util.threadFactory$lambda$1(this.f70502b, this.f70503c, runnable);
    }
}
