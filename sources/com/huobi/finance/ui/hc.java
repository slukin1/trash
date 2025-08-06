package com.huobi.finance.ui;

import ad.b;
import android.content.Intent;
import android.text.SpannableStringBuilder;
import android.text.method.LinkMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.core.widget.NestedScrollView;
import androidx.fragment.app.FragmentActivity;
import com.hbg.lib.common.utils.StringUtils;
import com.hbg.lib.widgets.dialog.DialogUtils;
import com.huobi.account.ui.HelpCenterActivity;
import com.huobi.utils.SpannableUtils;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import i6.n;
import is.a;
import pro.huobi.R;
import sn.f;

public class hc {

    /* renamed from: a  reason: collision with root package name */
    public FragmentActivity f47159a;

    public hc(FragmentActivity fragmentActivity) {
        this.f47159a = fragmentActivity;
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void f(View view) {
        a.i("4063", a.d());
        f.Z(this.f47159a);
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void g(View view) {
        e();
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void h(NestedScrollView nestedScrollView) {
        int f11 = (n.f(this.f47159a) * 1) / 2;
        ViewGroup.LayoutParams layoutParams = nestedScrollView.getLayoutParams();
        if (nestedScrollView.getHeight() > f11) {
            layoutParams.height = f11;
        }
        nestedScrollView.setLayoutParams(layoutParams);
    }

    public final String d(int i11) {
        return this.f47159a.getString(i11);
    }

    public final void e() {
        this.f47159a.startActivity(new Intent(this.f47159a, HelpCenterActivity.class));
    }

    public void i() {
        View inflate = LayoutInflater.from(this.f47159a).inflate(R.layout.dialog_withdraw_high_risk, (ViewGroup) null);
        TextView textView = (TextView) inflate.findViewById(R.id.tv_content);
        String d11 = d(R.string.n_withdraw_offical_check_channel);
        String d12 = d(R.string.n_withdraw_help_center);
        SpannableStringBuilder a11 = SpannableUtils.a(this.f47159a, SpannableUtils.a(this.f47159a, StringUtils.d(d(R.string.n_withdraw_risk_desc), d11, d12), d11, new ec(this)), d12, new fc(this));
        textView.setMovementMethod(LinkMovementMethod.getInstance());
        textView.setText(a11);
        inflate.post(new gc(this, (NestedScrollView) inflate.findViewById(R.id.scroll_view)));
        new DialogUtils.b.d(this.f47159a).i1(4).f1(false).q0(false).P0(d(R.string.n_withdraw_think)).Q0(b.f3517a).I0(inflate).j0().show(this.f47159a.getSupportFragmentManager(), "");
    }
}
