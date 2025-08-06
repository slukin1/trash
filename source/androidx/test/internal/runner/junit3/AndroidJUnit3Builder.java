package androidx.test.internal.runner.junit3;

import android.util.Log;
import androidx.test.internal.util.AndroidRunnerBuilderUtil;
import androidx.test.internal.util.AndroidRunnerParams;
import org.junit.internal.builders.JUnit3Builder;
import org.junit.runner.Description;
import org.junit.runner.Runner;
import org.junit.runner.notification.RunNotifier;

public class AndroidJUnit3Builder extends JUnit3Builder {

    /* renamed from: d  reason: collision with root package name */
    public static final Runner f11522d = new Runner() {
        public void b(RunNotifier runNotifier) {
        }

        public Description getDescription() {
            return Description.EMPTY;
        }
    };

    /* renamed from: b  reason: collision with root package name */
    public final AndroidRunnerParams f11523b;

    /* renamed from: c  reason: collision with root package name */
    public final boolean f11524c;

    public AndroidJUnit3Builder(AndroidRunnerParams androidRunnerParams, boolean z11) {
        this.f11523b = androidRunnerParams;
        this.f11524c = z11;
    }

    public Runner a(Class<?> cls) throws Throwable {
        try {
            if (!AndroidRunnerBuilderUtil.c(cls)) {
                return null;
            }
            if (!this.f11524c || AndroidRunnerBuilderUtil.a(cls)) {
                return new JUnit38ClassRunner(new AndroidTestSuite(cls, this.f11523b));
            }
            return f11522d;
        } catch (Throwable th2) {
            Log.e("AndroidJUnit3Builder", "Error constructing runner", th2);
            throw th2;
        }
    }
}
