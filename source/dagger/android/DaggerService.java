package dagger.android;

import android.app.Service;
import pz.a;

public abstract class DaggerService extends Service {
    public void onCreate() {
        a.d(this);
        super.onCreate();
    }
}
