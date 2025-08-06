package com.huobi.points.activity;

import android.content.Context;
import android.content.Intent;
import android.util.Pair;
import android.view.View;
import android.widget.TextView;
import com.hbg.lib.common.utils.DateTimeUtils;
import com.hbg.lib.core.ui.BaseActivity;
import com.hbg.lib.data.symbol.PrecisionUtil;
import com.hbg.lib.network.retrofit.util.MapParamsBuilder;
import com.hbg.lib.widgets.dialog.DialogUtils;
import com.hbg.lib.widgets.dialog.HBDialogFragment;
import com.huobi.account.ui.SecurityStrategyBottomMenuFragment;
import com.huobi.account.ui.SecurityStrategyControllerAdapter;
import com.huobi.login.usercenter.data.source.bean.SecurityStrategySet;
import com.huobi.login.usercenter.data.source.bean.UserSecurityInfoData;
import com.huobi.points.entity.Points;
import com.huobi.points.presenter.TransferToMePresenter;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import fq.u;
import fq.v;
import fq.w;
import i6.d;
import i6.m;
import java.util.HashMap;
import java.util.Map;
import jq.e;
import pro.huobi.R;

public class TransferToMeActivity extends BaseActivity<TransferToMePresenter, TransferToMePresenter.b> implements TransferToMePresenter.b, View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public float f80455b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f80456c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f80457d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f80458e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f80459f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f80460g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f80461h;

    /* renamed from: i  reason: collision with root package name */
    public TextView f80462i;

    /* renamed from: j  reason: collision with root package name */
    public TextView f80463j;

    /* renamed from: k  reason: collision with root package name */
    public TextView f80464k;

    /* renamed from: l  reason: collision with root package name */
    public Points f80465l;

    /* renamed from: m  reason: collision with root package name */
    public e f80466m;

    /* renamed from: n  reason: collision with root package name */
    public SecurityStrategyBottomMenuFragment f80467n = new SecurityStrategyBottomMenuFragment();

    public class a implements e.a {
        public a() {
        }

        public void a0() {
            TransferToMeActivity.this.f80466m.dismiss();
            ((TransferToMePresenter) TransferToMeActivity.this.getPresenter()).x0();
        }

        public void g0() {
            TransferToMeActivity.this.f80466m.dismiss();
        }
    }

    public class b extends SecurityStrategyControllerAdapter {

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ Pair f80469g;

        public b(Pair pair) {
            this.f80469g = pair;
        }

        public boolean C() {
            boolean isVerify_phone = ((SecurityStrategySet) this.f80469g.second).getSetting().isVerify_phone();
            d.b("PointsTransferActivity-->isNeedSmsCode-->" + isVerify_phone);
            return isVerify_phone;
        }

        public void i(String str, String str2, String str3, String str4) {
            super.i(str, str2, str3, str4);
            TransferToMeActivity.this.f80467n.dismiss();
            ((TransferToMePresenter) TransferToMeActivity.this.getPresenter()).y0(str, str2, str3);
        }

        public String n() {
            return ((UserSecurityInfoData) this.f80469g.first).getEmail();
        }

        public String o() {
            return ((UserSecurityInfoData) this.f80469g.first).getPhone();
        }

        public Map<String, Object> p() {
            return MapParamsBuilder.c().a("use_type", "VERIFY_SETTING_POLICY").b();
        }

        public Map<String, Object> s() {
            HashMap hashMap = new HashMap();
            hashMap.put("use_type", "VERIFY_SETTING_POLICY");
            hashMap.put("voice", Boolean.FALSE);
            return hashMap;
        }

        public boolean x() {
            boolean isVerify_email = ((SecurityStrategySet) this.f80469g.second).getSetting().isVerify_email();
            d.b("PointsTransferActivity-->isNeedEmailCode-->" + isVerify_email);
            return isVerify_email;
        }

        public boolean y() {
            boolean isVerify_ga = ((SecurityStrategySet) this.f80469g.second).getSetting().isVerify_ga();
            d.b("PointsTransferActivity-->isNeedGaCode-->" + isVerify_ga);
            return isVerify_ga;
        }
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void lambda$addEvent$0(View view) {
        finish();
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void qh(HBDialogFragment hBDialogFragment) {
        hBDialogFragment.dismiss();
        ((TransferToMePresenter) getPresenter()).v0();
    }

    public static void wh(Context context, long j11) {
        if (context != null) {
            Intent intent = new Intent(context, TransferToMeActivity.class);
            intent.putExtra("extra", j11);
            context.startActivity(intent);
        }
    }

    public void C(Pair<UserSecurityInfoData, SecurityStrategySet> pair) {
        this.f80467n.Ci(new b(pair));
        this.f80467n.show(getSupportFragmentManager(), "BottomMenuFragment");
    }

    /* renamed from: Qg */
    public TransferToMePresenter createPresenter() {
        return new TransferToMePresenter();
    }

    public void addEvent() {
        this.viewFinder.b(R.id.id_back).setOnClickListener(new u(this));
        this.viewFinder.b(R.id.id_transfer_to_me_bottom_btn_left).setOnClickListener(this);
        this.viewFinder.b(R.id.id_transfer_to_me_bottom_btn_right).setOnClickListener(this);
    }

    public int getContentView() {
        return R.layout.activity_transfer_to_me;
    }

    public void initView() {
        this.f80456c = (TextView) this.viewFinder.b(R.id.id_my_transfer_uid);
        this.f80457d = (TextView) this.viewFinder.b(R.id.id_my_transfer_account);
        this.f80458e = (TextView) this.viewFinder.b(R.id.id_my_transfer_single_price);
        this.f80459f = (TextView) this.viewFinder.b(R.id.id_my_transfer_usdt);
        this.f80460g = (TextView) this.viewFinder.b(R.id.id_points_history_details_amount);
        this.f80461h = (TextView) this.viewFinder.b(R.id.id_points_history_details_amount_unit);
        this.f80462i = (TextView) this.viewFinder.b(R.id.id_points_history_details_title);
        this.f80463j = (TextView) this.viewFinder.b(R.id.detail_date_tv);
        this.f80464k = (TextView) this.viewFinder.b(R.id.detail_points_id_tv);
        xh(getString(R.string.transfer_to_me_title));
        this.f80455b = getResources().getDimension(R.dimen.dimen_44);
    }

    /* renamed from: oh */
    public TransferToMePresenter.b getUI() {
        return this;
    }

    @SensorsDataInstrumented
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.id_transfer_to_me_bottom_btn_left:
                DialogUtils.b0(this, getString(R.string.my_transfer_btn_confirm_reject), getString(R.string.my_transfer_reject_tips), "", getString(R.string.string_cancel), getString(R.string.string_confirm), w.f54757a, new v(this));
                break;
            case R.id.id_transfer_to_me_bottom_btn_right:
                if (this.f80465l != null) {
                    if (this.f80466m == null) {
                        e eVar = new e(this);
                        this.f80466m = eVar;
                        eVar.c(new a());
                        this.f80466m.e(getString(R.string.points_transfer_confirm_receive));
                    }
                    this.f80466m.d(m.p0(m.m(this.f80465l.getTotalPoints(), PrecisionUtil.c((String) null))));
                    this.f80466m.f(m.p0(m.m(this.f80465l.getTotalAmount(), PrecisionUtil.c((String) null))));
                    this.f80466m.show();
                    break;
                } else {
                    SensorsDataAutoTrackHelper.trackViewOnClick(view);
                    return;
                }
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    public void rh(String str) {
        TextView textView = this.f80457d;
        if (textView != null) {
            textView.setText(str);
        }
    }

    public void sh(String str) {
        TextView textView = this.f80459f;
        if (textView != null) {
            textView.setText(str + " " + getString(R.string.string_usdt));
        }
    }

    public void th(String str) {
        TextView textView = this.f80460g;
        if (textView != null) {
            textView.setText(str);
        }
    }

    public void uh(String str) {
        TextView textView = this.f80458e;
        if (textView != null) {
            textView.setText(str + " USDT/" + getString(R.string.points_pts));
        }
    }

    public void vh(String str) {
        TextView textView = this.f80456c;
        if (textView != null) {
            textView.setText(str);
        }
    }

    public void xh(String str) {
        this.f80462i.setText(str);
    }

    public void z3(Points points) {
        this.f80465l = points;
        vh(points.getUid());
        uh(m.p0(m.m(this.f80465l.getPrice(), PrecisionUtil.c((String) null))));
        th("+ " + m.p0(m.m(this.f80465l.getTotalPoints(), PrecisionUtil.c((String) null))));
        rh(points.getAccount());
        sh(m.p0(points.getTotalAmount()));
        int color = getResources().getColor(R.color.baseColorMajorTheme100);
        this.f80460g.setTextColor(color);
        this.f80461h.setTextColor(color);
        this.f80463j.setText(DateTimeUtils.h(points.getCreatedAt(), "HH:mm:ss MM/dd/yyyy "));
        this.f80464k.setText(String.valueOf(points.getId()));
    }
}
