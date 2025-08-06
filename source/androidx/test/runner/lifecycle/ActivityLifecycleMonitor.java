package androidx.test.runner.lifecycle;

import android.app.Activity;
import java.util.Collection;

public interface ActivityLifecycleMonitor {
    Collection<Activity> a(Stage stage);
}
