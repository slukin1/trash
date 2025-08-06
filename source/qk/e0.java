package qk;

import android.view.View;
import androidx.fragment.app.FragmentManager;
import com.huobi.feature.util.FutureTpSlHelper;

public final /* synthetic */ class e0 implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ FutureTpSlHelper f59962b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ FragmentManager f59963c;

    public /* synthetic */ e0(FutureTpSlHelper futureTpSlHelper, FragmentManager fragmentManager) {
        this.f59962b = futureTpSlHelper;
        this.f59963c = fragmentManager;
    }

    public final void onClick(View view) {
        this.f59962b.i1(this.f59963c, view);
    }
}
