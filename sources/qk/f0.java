package qk;

import android.view.View;
import androidx.fragment.app.FragmentManager;
import com.huobi.feature.util.FutureTpSlHelper;

public final /* synthetic */ class f0 implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ FutureTpSlHelper f59965b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ FragmentManager f59966c;

    public /* synthetic */ f0(FutureTpSlHelper futureTpSlHelper, FragmentManager fragmentManager) {
        this.f59965b = futureTpSlHelper;
        this.f59966c = fragmentManager;
    }

    public final void onClick(View view) {
        this.f59965b.g1(this.f59966c, view);
    }
}
