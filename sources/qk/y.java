package qk;

import android.view.View;
import androidx.fragment.app.FragmentManager;
import com.huobi.feature.util.FutureTpSlHelper;

public final /* synthetic */ class y implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ FutureTpSlHelper f60006b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ FragmentManager f60007c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ View f60008d;

    public /* synthetic */ y(FutureTpSlHelper futureTpSlHelper, FragmentManager fragmentManager, View view) {
        this.f60006b = futureTpSlHelper;
        this.f60007c = fragmentManager;
        this.f60008d = view;
    }

    public final void run() {
        this.f60006b.l1(this.f60007c, this.f60008d);
    }
}
