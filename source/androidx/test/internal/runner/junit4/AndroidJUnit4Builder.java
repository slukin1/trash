package androidx.test.internal.runner.junit4;

import android.util.Log;
import androidx.test.internal.util.AndroidRunnerParams;
import java.lang.reflect.Method;
import org.junit.Test;
import org.junit.internal.builders.JUnit4Builder;
import org.junit.runner.Runner;

public class AndroidJUnit4Builder extends JUnit4Builder {

    /* renamed from: b  reason: collision with root package name */
    public final AndroidRunnerParams f11542b;

    /* renamed from: c  reason: collision with root package name */
    public final boolean f11543c;

    public AndroidJUnit4Builder(AndroidRunnerParams androidRunnerParams, boolean z11) {
        this.f11542b = androidRunnerParams;
        this.f11543c = z11;
    }

    public static boolean c(Class<?> cls) {
        try {
            for (Method isAnnotationPresent : cls.getMethods()) {
                if (isAnnotationPresent.isAnnotationPresent(Test.class)) {
                    return true;
                }
            }
            return false;
        } catch (Throwable th2) {
            Log.w("AndroidJUnit4Builder", String.format("%s in hasTestMethods for %s", new Object[]{th2.toString(), cls.getName()}));
            return false;
        }
    }

    public Runner a(Class<?> cls) throws Throwable {
        try {
            if (!this.f11543c || c(cls)) {
                return new AndroidJUnit4ClassRunner(cls, this.f11542b);
            }
            return null;
        } catch (Throwable th2) {
            Log.e("AndroidJUnit4Builder", "Error constructing runner", th2);
            throw th2;
        }
    }
}
