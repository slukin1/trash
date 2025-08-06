package k;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.support.customtabs.ICustomTabsService;
import android.text.TextUtils;
import androidx.browser.customtabs.CustomTabsServiceConnection;

public class a {

    /* renamed from: a  reason: collision with root package name */
    public final ICustomTabsService f16010a;

    /* renamed from: b  reason: collision with root package name */
    public final ComponentName f16011b;

    /* renamed from: c  reason: collision with root package name */
    public final Context f16012c;

    public a(ICustomTabsService iCustomTabsService, ComponentName componentName, Context context) {
        this.f16010a = iCustomTabsService;
        this.f16011b = componentName;
        this.f16012c = context;
    }

    public static boolean a(Context context, String str, CustomTabsServiceConnection customTabsServiceConnection) {
        customTabsServiceConnection.b(context.getApplicationContext());
        Intent intent = new Intent("android.support.customtabs.action.CustomTabsService");
        if (!TextUtils.isEmpty(str)) {
            intent.setPackage(str);
        }
        return context.bindService(intent, customTabsServiceConnection, 33);
    }
}
