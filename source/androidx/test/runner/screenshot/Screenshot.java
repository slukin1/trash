package androidx.test.runner.screenshot;

import android.os.Build;
import androidx.test.annotation.Beta;
import java.util.HashSet;
import java.util.Set;

@Beta
public final class Screenshot {

    /* renamed from: a  reason: collision with root package name */
    public static int f11703a = Build.VERSION.SDK_INT;

    /* renamed from: b  reason: collision with root package name */
    public static UiAutomationWrapper f11704b = new UiAutomationWrapper();

    /* renamed from: c  reason: collision with root package name */
    public static Set<ScreenCaptureProcessor> f11705c = new HashSet();

    /* renamed from: d  reason: collision with root package name */
    public static TakeScreenshotCallable$Factory f11706d = new TakeScreenshotCallable$Factory();

    public static final class ScreenShotException extends RuntimeException {
        public ScreenShotException(Throwable th2) {
            super(th2);
        }
    }

    public static void a(Set<ScreenCaptureProcessor> set) {
        f11705c.addAll(set);
    }
}
