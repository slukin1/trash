package z8;

import com.hbg.lib.network.pro.db.ProDbHelper;
import java.util.List;

public final /* synthetic */ class b implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ List f62017b;

    public /* synthetic */ b(List list) {
        this.f62017b = list;
    }

    public final void run() {
        ProDbHelper.e(this.f62017b);
    }
}
