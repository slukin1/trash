package androidx.lifecycle;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

public class LifecycleService extends Service implements LifecycleOwner {
    private final j0 dispatcher = new j0(this);

    public Lifecycle getLifecycle() {
        return this.dispatcher.a();
    }

    public IBinder onBind(Intent intent) {
        this.dispatcher.b();
        return null;
    }

    public void onCreate() {
        this.dispatcher.c();
        super.onCreate();
    }

    public void onDestroy() {
        this.dispatcher.d();
        super.onDestroy();
    }

    public void onStart(Intent intent, int i11) {
        this.dispatcher.e();
        super.onStart(intent, i11);
    }

    public int onStartCommand(Intent intent, int i11, int i12) {
        return super.onStartCommand(intent, i11, i12);
    }
}
