package com.huobi.finance.ui;

import android.content.Context;
import androidx.fragment.app.FragmentActivity;
import com.hbg.lib.core.util.RxJavaHelper;
import com.hbg.lib.widgets.dialog.DialogUtils;
import com.hbg.lib.widgets.dialog.HBDialogFragment;
import com.hbg.lib.widgets.utils.HuobiToastUtil;
import com.hbg.module.asset.AssetModuleConfig;
import com.hbg.module.asset.R$dimen;
import com.hbg.module.asset.R$drawable;
import com.hbg.module.asset.R$string;
import q6.d;
import u6.g;
import v7.b;

public class g7 {

    /* renamed from: a  reason: collision with root package name */
    public final Context f47136a;

    /* renamed from: b  reason: collision with root package name */
    public final g f47137b;

    /* renamed from: c  reason: collision with root package name */
    public a f47138c;

    public interface a {
        void onSuccess();
    }

    public g7(Context context, g gVar, a aVar) {
        this.f47136a = context;
        this.f47137b = gVar;
        this.f47138c = aVar;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void c(String str) {
        HuobiToastUtil.v(this.f47136a.getString(R$string.n_open_feature_success));
        AssetModuleConfig.a().E0((Boolean) null);
        a aVar = this.f47138c;
        if (aVar != null) {
            aVar.onSuccess();
        }
        AssetModuleConfig.a().N(this.f47136a);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void d(HBDialogFragment hBDialogFragment) {
        e();
        hBDialogFragment.dismiss();
    }

    public final void e() {
        b.a().n0(true).b().compose(RxJavaHelper.t(this.f47137b)).subscribe(d.c(this.f47137b, new f7(this)));
    }

    public void f() {
        FragmentActivity fragmentActivity = (FragmentActivity) oa.a.g().b();
        new DialogUtils.b.d(fragmentActivity).c1(fragmentActivity.getString(R$string.n_profit_open_confirm_title)).h1(Float.valueOf(fragmentActivity.getResources().getDimension(R$dimen.common_dialog_title_big_text_size))).G0(16).d1(true).C0(fragmentActivity.getString(R$string.n_profit_open_confirm_content)).i1(1).M0(Integer.valueOf(R$drawable.assets_dialog_enable_pic)).P0(fragmentActivity.getString(R$string.string_confirm)).s0(fragmentActivity.getString(R$string.string_cancel)).Q0(new e7(this)).N0(ad.b.f3517a).j0().show(fragmentActivity.getSupportFragmentManager(), "");
    }
}
