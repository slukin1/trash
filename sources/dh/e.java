package dh;

import com.huobi.app.util.StartAppUtil;
import java.util.concurrent.ThreadFactory;

public final /* synthetic */ class e implements ThreadFactory {

    /* renamed from: b  reason: collision with root package name */
    public static final /* synthetic */ e f53634b = new e();

    public final Thread newThread(Runnable runnable) {
        return StartAppUtil.d(runnable);
    }
}
