package qk;

import android.view.View;
import androidx.fragment.app.FragmentManager;
import com.huobi.feature.util.FutureTpSlHelper;

public final /* synthetic */ class x implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ FutureTpSlHelper f60003b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ FragmentManager f60004c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ View f60005d;

    public /* synthetic */ x(FutureTpSlHelper futureTpSlHelper, FragmentManager fragmentManager, View view) {
        this.f60003b = futureTpSlHelper;
        this.f60004c = fragmentManager;
        this.f60005d = view;
    }

    public final void run() {
        this.f60003b.n1(this.f60004c, this.f60005d);
    }
}
