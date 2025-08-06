package qk;

import androidx.fragment.app.FragmentManager;
import com.huobi.feature.util.FutureTpSlHelper;

public final /* synthetic */ class w implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ FutureTpSlHelper f60001b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ FragmentManager f60002c;

    public /* synthetic */ w(FutureTpSlHelper futureTpSlHelper, FragmentManager fragmentManager) {
        this.f60001b = futureTpSlHelper;
        this.f60002c = fragmentManager;
    }

    public final void run() {
        this.f60001b.h1(this.f60002c);
    }
}
