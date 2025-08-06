package dagger.android;

import android.app.IntentService;
import pz.a;

public abstract class DaggerIntentService extends IntentService {
    public void onCreate() {
        a.d(this);
        super.onCreate();
    }
}
