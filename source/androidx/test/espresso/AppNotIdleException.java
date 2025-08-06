package androidx.test.espresso;

import android.os.Looper;
import androidx.test.espresso.core.internal.deps.guava.base.Joiner;
import androidx.test.espresso.core.internal.deps.guava.base.Preconditions;
import com.xiaomi.mipush.sdk.Constants;
import java.util.List;

public final class AppNotIdleException extends RuntimeException {
    private AppNotIdleException(String str) {
        super(str);
    }

    @Deprecated
    public static AppNotIdleException create(List<String> list, int i11, int i12) {
        Preconditions.o(Looper.myLooper() == Looper.getMainLooper());
        return new AppNotIdleException(String.format("App not idle within timeout of %s seconds evenafter trying for %s iterations. The following Idle Conditions failed %s", new Object[]{Integer.valueOf(i12), Integer.valueOf(i11), Joiner.f(Constants.ACCEPT_TIME_SEPARATOR_SP).d(list)}));
    }

    public static AppNotIdleException create(List<String> list, String str) {
        return new AppNotIdleException(String.format("%s The following Idle Conditions failed %s.", new Object[]{str, Joiner.f(Constants.ACCEPT_TIME_SEPARATOR_SP).d(list)}));
    }
}
