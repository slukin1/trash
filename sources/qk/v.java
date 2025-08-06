package qk;

import androidx.fragment.app.FragmentManager;
import com.huobi.feature.util.FutureTpSlHelper;

public final /* synthetic */ class v implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ FutureTpSlHelper f59999b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ FragmentManager f60000c;

    public /* synthetic */ v(FutureTpSlHelper futureTpSlHelper, FragmentManager fragmentManager) {
        this.f59999b = futureTpSlHelper;
        this.f60000c = fragmentManager;
    }

    public final void run() {
        this.f59999b.f1(this.f60000c);
    }
}
