package qk;

import android.view.View;
import androidx.fragment.app.FragmentManager;
import com.huobi.feature.util.FutureTpSlHelper;

public final /* synthetic */ class l0 implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ FutureTpSlHelper f59981b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ View f59982c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ FragmentManager f59983d;

    public /* synthetic */ l0(FutureTpSlHelper futureTpSlHelper, View view, FragmentManager fragmentManager) {
        this.f59981b = futureTpSlHelper;
        this.f59982c = view;
        this.f59983d = fragmentManager;
    }

    public final void run() {
        this.f59981b.Y0(this.f59982c, this.f59983d);
    }
}
