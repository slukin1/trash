package qk;

import android.view.View;
import com.huobi.feature.util.FutureLimitOrderEditDialogHelper;

public final /* synthetic */ class o implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ FutureLimitOrderEditDialogHelper f59985b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ String f59986c;

    public /* synthetic */ o(FutureLimitOrderEditDialogHelper futureLimitOrderEditDialogHelper, String str) {
        this.f59985b = futureLimitOrderEditDialogHelper;
        this.f59986c = str;
    }

    public final void onClick(View view) {
        this.f59985b.n(this.f59986c, view);
    }
}
