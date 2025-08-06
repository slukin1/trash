package d7;

import android.os.Handler;
import android.os.Looper;
import com.hbg.lib.network.pro.db.DepthsInfoSymbolDbHelper;

public final /* synthetic */ class n implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ String f53518b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ long f53519c;

    public /* synthetic */ n(String str, long j11) {
        this.f53518b = str;
        this.f53519c = j11;
    }

    public final void run() {
        new Handler(Looper.getMainLooper()).post(new o(this.f53518b, DepthsInfoSymbolDbHelper.g(this.f53518b), this.f53519c));
    }
}
