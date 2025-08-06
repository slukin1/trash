package androidx.test.runner.permission;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import androidx.test.InstrumentationRegistry;
import androidx.test.annotation.Beta;
import androidx.test.internal.util.Checks;
import java.util.HashSet;

@TargetApi(23)
@Beta
public class PermissionRequester {

    /* renamed from: a  reason: collision with root package name */
    public int f11694a;

    /* renamed from: b  reason: collision with root package name */
    public final Context f11695b;

    /* renamed from: c  reason: collision with root package name */
    public final HashSet<Object> f11696c;

    public PermissionRequester() {
        this(InstrumentationRegistry.b());
    }

    public PermissionRequester(Context context) {
        this.f11694a = Build.VERSION.SDK_INT;
        this.f11696c = new HashSet<>();
        this.f11695b = (Context) Checks.c(context, "targetContext cannot be null!");
    }
}
