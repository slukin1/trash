package wn;

import android.app.Activity;
import android.view.View;
import com.huobi.account.entity.MultipleAccountData;

public final /* synthetic */ class v implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ b0 f61484b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ MultipleAccountData f61485c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ Activity f61486d;

    public /* synthetic */ v(b0 b0Var, MultipleAccountData multipleAccountData, Activity activity) {
        this.f61484b = b0Var;
        this.f61485c = multipleAccountData;
        this.f61486d = activity;
    }

    public final void onClick(View view) {
        this.f61484b.D(this.f61485c, this.f61486d, view);
    }
}
