package k;

import android.os.IBinder;
import androidx.browser.customtabs.CustomTabsService;

public final /* synthetic */ class b implements IBinder.DeathRecipient {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ CustomTabsService.a f56541a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ c f56542b;

    public /* synthetic */ b(CustomTabsService.a aVar, c cVar) {
        this.f56541a = aVar;
        this.f56542b = cVar;
    }

    public final void binderDied() {
        this.f56541a.h(this.f56542b);
    }
}
