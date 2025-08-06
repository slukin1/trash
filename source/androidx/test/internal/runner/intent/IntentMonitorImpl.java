package androidx.test.internal.runner.intent;

import androidx.test.runner.intent.IntentMonitor;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class IntentMonitorImpl implements IntentMonitor {

    /* renamed from: a  reason: collision with root package name */
    public List<WeakReference<Object>> f11521a = Collections.synchronizedList(new ArrayList());
}
