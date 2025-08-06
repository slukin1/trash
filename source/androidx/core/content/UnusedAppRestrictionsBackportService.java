package androidx.core.content;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;
import androidx.core.app.unusedapprestrictions.IUnusedAppRestrictionsBackportCallback;
import androidx.core.app.unusedapprestrictions.IUnusedAppRestrictionsBackportService;
import q0.f;

public abstract class UnusedAppRestrictionsBackportService extends Service {

    /* renamed from: b  reason: collision with root package name */
    public IUnusedAppRestrictionsBackportService.Stub f8338b = new a();

    public class a extends IUnusedAppRestrictionsBackportService.Stub {
        public a() {
        }

        public void c(IUnusedAppRestrictionsBackportCallback iUnusedAppRestrictionsBackportCallback) throws RemoteException {
            if (iUnusedAppRestrictionsBackportCallback != null) {
                UnusedAppRestrictionsBackportService.this.a(new f(iUnusedAppRestrictionsBackportCallback));
            }
        }
    }

    public abstract void a(f fVar);

    public IBinder onBind(Intent intent) {
        return this.f8338b;
    }
}
