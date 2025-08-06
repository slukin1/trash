package vg;

import android.content.Context;
import android.view.View;
import com.huobi.account.bean.PersonalCenterActivityData;
import com.huobi.account.viewhandler.PersonalCenterActivityHandler;

public final /* synthetic */ class e implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ PersonalCenterActivityData f61016b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Context f61017c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ int f61018d;

    public /* synthetic */ e(PersonalCenterActivityData personalCenterActivityData, Context context, int i11) {
        this.f61016b = personalCenterActivityData;
        this.f61017c = context;
        this.f61018d = i11;
    }

    public final void onClick(View view) {
        PersonalCenterActivityHandler.d(this.f61016b, this.f61017c, this.f61018d, view);
    }
}
