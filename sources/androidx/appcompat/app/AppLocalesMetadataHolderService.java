package androidx.appcompat.app;

import android.app.Service;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ServiceInfo;
import android.os.Build;
import android.os.IBinder;
import com.sumsub.sns.internal.ml.autocapture.b;

public final class AppLocalesMetadataHolderService extends Service {

    public static class a {
        public static int a() {
            return 512;
        }
    }

    public static ServiceInfo a(Context context) throws PackageManager.NameNotFoundException {
        return context.getPackageManager().getServiceInfo(new ComponentName(context, AppLocalesMetadataHolderService.class), Build.VERSION.SDK_INT >= 24 ? a.a() | 128 : b.f34944a);
    }

    public IBinder onBind(Intent intent) {
        throw new UnsupportedOperationException();
    }
}
