package androidx.browser.customtabs;

import android.content.ComponentName;
import android.content.Context;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.support.customtabs.ICustomTabsService;

public abstract class CustomTabsServiceConnection implements ServiceConnection {

    /* renamed from: b  reason: collision with root package name */
    public Context f4873b;

    public class a extends k.a {
        public a(ICustomTabsService iCustomTabsService, ComponentName componentName, Context context) {
            super(iCustomTabsService, componentName, context);
        }
    }

    public abstract void a(ComponentName componentName, k.a aVar);

    public void b(Context context) {
        this.f4873b = context;
    }

    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        if (this.f4873b != null) {
            a(componentName, new a(ICustomTabsService.Stub.asInterface(iBinder), componentName, this.f4873b));
            return;
        }
        throw new IllegalStateException("Custom Tabs Service connected before an applicationcontext has been provided.");
    }
}
