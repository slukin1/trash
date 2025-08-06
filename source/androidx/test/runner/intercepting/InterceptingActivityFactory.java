package androidx.test.runner.intercepting;

import android.app.Activity;
import android.content.Intent;

public interface InterceptingActivityFactory {
    boolean a(ClassLoader classLoader, String str, Intent intent);

    Activity b(ClassLoader classLoader, String str, Intent intent);
}
