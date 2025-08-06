package p0;

import android.app.Activity;
import androidx.core.app.ActivityCompat;

public final /* synthetic */ class a implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Activity f52993b;

    public /* synthetic */ a(Activity activity) {
        this.f52993b = activity;
    }

    public final void run() {
        ActivityCompat.lambda$recreate$0(this.f52993b);
    }
}
