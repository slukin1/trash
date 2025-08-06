package androidx.test.runner.lifecycle;

import android.app.Application;

public interface ApplicationLifecycleCallback {
    void a(Application application, ApplicationStage applicationStage);
}
