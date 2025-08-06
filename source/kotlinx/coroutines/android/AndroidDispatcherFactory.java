package kotlinx.coroutines.android;

import android.os.Looper;
import java.util.List;
import kotlin.jvm.internal.r;
import kotlinx.coroutines.MainCoroutineDispatcher;
import kotlinx.coroutines.internal.s;

public final class AndroidDispatcherFactory implements s {
    public int a() {
        return 1073741823;
    }

    public String b() {
        return "For tests Dispatchers.setMain from kotlinx-coroutines-test module can be used";
    }

    public MainCoroutineDispatcher c(List<? extends s> list) {
        Looper mainLooper = Looper.getMainLooper();
        if (mainLooper != null) {
            return new HandlerContext(c.a(mainLooper, true), (String) null, 2, (r) null);
        }
        throw new IllegalStateException("The main looper is not available");
    }
}
