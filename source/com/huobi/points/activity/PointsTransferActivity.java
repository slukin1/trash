package com.huobi.points.activity;

import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.Pair;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import androidx.core.content.res.ResourcesCompat;
import com.amazonaws.services.s3.model.InstructionFileId;
import com.hbg.lib.common.utils.StringUtils;
import com.hbg.lib.core.ui.BaseActivity;
import com.hbg.lib.data.symbol.PrecisionUtil;
import com.hbg.lib.network.retrofit.util.MapParamsBuilder;
import com.hbg.lib.widgets.dialog.DialogUtils;
import com.hbg.lib.widgets.utils.HuobiToastUtil;
import com.huobi.account.ui.SecurityStrategyBottomMenuFragment;
import com.huobi.account.ui.SecurityStrategyControllerAdapter;
import com.huobi.coupon.bean.CouponReturn;
import com.huobi.login.usercenter.data.source.bean.SecurityStrategySet;
import com.huobi.login.usercenter.data.source.bean.UserSecurityInfoData;
import com.huobi.points.presenter.PointsTransferPresenter;
import com.huobi.view.title.HbTitleBar;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import fq.k;
import fq.l;
import fq.n;
import fq.o;
import fq.p;
import i6.m;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.regex.Pattern;
import jq.e;
import pro.huobi.R;

public class PointsTransferActivity extends BaseActivity<PointsTransferPresenter, PointsTransferPresenter.b> implements PointsTransferPresenter.b, View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public float f80415b;

    /* renamed from: c  reason: collision with root package name */
    public HbTitleBar f80416c;

    /* renamed from: d  reason: collision with root package name */
    public View f80417d;

    /* renamed from: e  reason: collision with root package name */
    public EditText f80418e;

    /* renamed from: f  reason: collision with root package name */
    public EditText f80419f;

    /* renamed from: g  reason: collision with root package name */
    public EditText f80420g;

    /* renamed from: h  reason: collision with root package name */
    public EditText f80421h;

    /* renamed from: i  reason: collision with root package name */
    public TextView f80422i;

    /* renamed from: j  reason: collision with root package name */
    public View f80423j;

    /* renamed from: k  reason: collision with root package name */
    public TextView f80424k;

    /* renamed from: l  reason: collision with root package name */
    public jq.e f80425l;

    /* renamed from: m  reason: collision with root package name */
    public c f80426m = new c(this, (a) null);

    /* renamed from: n  reason: collision with root package name */
    public double f80427n;

    /* renamed from: o  reason: collision with root package name */
    public final Pattern f80428o = Pattern.compile("^[0-9]{4}$");

    /* renamed from: p  reason: collision with root package name */
    public SecurityStrategyBottomMenuFragment f80429p = new SecurityStrategyBottomMenuFragment();

    /* renamed from: q  reason: collision with root package name */
    public BigDecimal f80430q;

    public class a implements e.a {
        public a() {
        }

        public void a0() {
            PointsTransferActivity.this.f80425l.dismiss();
            ((PointsTransferPresenter) PointsTransferActivity.this.getPresenter()).w0();
        }

        public void g0() {
            PointsTransferActivity.this.f80425l.dismiss();
        }
    }

    public class b extends SecurityStrategyControllerAdapter {

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ Pair f80432g;

        public b(Pair pair) {
            this.f80432g = pair;
        }

        public boolean C() {
            boolean isVerify_phone = ((SecurityStrategySet) this.f80432g.second).getSetting().isVerify_phone();
            i6.d.b("PointsTransferActivity-->isNeedSmsCode-->" + isVerify_phone);
            return isVerify_phone;
        }

        public void i(String str, String str2, String str3, String str4) {
            super.i(str, str2, str3, str4);
            ((PointsTransferPresenter) PointsTransferActivity.this.getPresenter()).x0(str, str2, str3);
        }

        public String n() {
            return ((UserSecurityInfoData) this.f80432g.first).getEmail();
        }

        public String o() {
            return ((UserSecurityInfoData) this.f80432g.first).getPhone();
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
            boolean isVerify_email = ((SecurityStrategySet) this.f80432g.second).getSetting().isVerify_email();
            i6.d.b("PointsTransferActivity-->isNeedEmailCode-->" + isVerify_email);
            return isVerify_email;
        }

        public boolean y() {
            boolean isVerify_ga = ((SecurityStrategySet) this.f80432g.second).getSetting().isVerify_ga();
            i6.d.b("PointsTransferActivity-->isNeedGaCode-->" + isVerify_ga);
            return isVerify_ga;
        }
    }

    public class c implements TextWatcher {
        public c() {
        }

        public void afterTextChanged(Editable editable) {
            double d11;
            PointsTransferActivity.this.vh();
            BigDecimal a11 = m.a(PointsTransferActivity.this.f80421h.getText().toString());
            BigDecimal a12 = m.a(PointsTransferActivity.this.f80420g.getText().toString());
            PointsTransferActivity pointsTransferActivity = PointsTransferActivity.this;
            if (a12.compareTo(BigDecimal.ZERO) == 0) {
                d11 = 0.0d;
            } else {
                d11 = a11.divide(a12, 32, 1).doubleValue();
            }
            double unused = pointsTransferActivity.f80427n = d11;
            PointsTransferActivity.this.f80422i.setText(String.format(Locale.US, PointsTransferActivity.this.getString(R.string.n_point_transfer_price), new Object[]{PointsTransferActivity.this.f80427n > 0.0d ? m.p0(m.m(String.valueOf(PointsTransferActivity.this.f80427n), PrecisionUtil.c((String) null))) : "--"}));
        }

        public void beforeTextChanged(CharSequence charSequence, int i11, int i12, int i13) {
        }

        public void onTextChanged(CharSequence charSequence, int i11, int i12, int i13) {
        }

        public /* synthetic */ c(PointsTransferActivity pointsTransferActivity, a aVar) {
            this();
        }
    }

    public class d extends c {

        /* renamed from: c  reason: collision with root package name */
        public final int f80435c = PrecisionUtil.c((String) null);

        /* renamed from: d  reason: collision with root package name */
        public EditText f80436d;

        public d(EditText editText) {
            super(PointsTransferActivity.this, (a) null);
            this.f80436d = editText;
        }

        public void onTextChanged(CharSequence charSequence, int i11, int i12, int i13) {
            if (charSequence.toString().contains(InstructionFileId.DOT) && (charSequence.length() - 1) - charSequence.toString().indexOf(InstructionFileId.DOT) > this.f80435c) {
                charSequence = charSequence.toString().subSequence(0, charSequence.toString().indexOf(InstructionFileId.DOT) + this.f80435c + 1);
                this.f80436d.setText(charSequence);
                this.f80436d.setSelection(charSequence.length());
            }
            if (charSequence.toString().trim().equals(InstructionFileId.DOT)) {
                charSequence = "0" + charSequence;
                this.f80436d.setText(charSequence);
                this.f80436d.setSelection(2);
            }
            if (charSequence.toString().startsWith("0") && charSequence.toString().trim().length() > 1 && !charSequence.toString().substring(1, 2).equals(InstructionFileId.DOT)) {
                this.f80436d.setText(charSequence.subSequence(0, 1));
                this.f80436d.setSelection(1);
            }
        }
    }

    public class e extends d {
        public e(EditText editText) {
            super(editText);
        }

        public void afterTextChanged(Editable editable) {
            super.afterTextChanged(editable);
            if (TextUtils.isEmpty(PointsTransferActivity.this.f80421h.getText().toString())) {
                PointsTransferActivity.this.f80421h.setTypeface(ResourcesCompat.h(PointsTransferActivity.this.f80421h.getContext(), R.font.roboto_regular));
            } else {
                PointsTransferActivity.this.f80421h.setTypeface(ResourcesCompat.h(PointsTransferActivity.this.f80421h.getContext(), R.font.roboto_medium));
            }
        }
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void lambda$addEvent$3(View view) {
        doFinish();
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void lambda$addEvent$4(View view) {
        TransferOrderListActivity.uh(this);
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void zh(View view, boolean z11) {
        this.f80423j.setSelected(z11);
    }

    public final void Bh(boolean z11) {
        View view = this.f80417d;
        if (view != null) {
            view.setEnabled(z11);
            this.f80417d.setOnClickListener(z11 ? this : null);
        }
    }

    public void C(Pair<UserSecurityInfoData, SecurityStrategySet> pair) {
        this.f80429p.Ci(new b(pair));
        this.f80429p.show(getSupportFragmentManager(), "BottomMenuFragment");
    }

    public final void Ch() {
        if (this.f80425l == null) {
            jq.e eVar = new jq.e(this);
            this.f80425l = eVar;
            eVar.c(new a());
            this.f80425l.e(getString(R.string.points_transfer_confirm_transfer));
        }
        this.f80425l.d(x4());
        this.f80425l.f(i6());
        this.f80425l.show();
    }

    public void Dh() {
        DialogUtils.X(this, getString(R.string.lite_market_info_price_notice_title), getString(R.string.points_transfer_high_price_tips_text), "", getString(R.string.points_transfer_high_price_tips_btn_text), p.f54750a);
    }

    public void Ob(String str) {
        BigDecimal a11 = m.a(str);
        this.f80430q = a11;
        if (a11.compareTo(BigDecimal.ZERO) == 0) {
            this.f80424k.setText(String.format(getString(R.string.points_transfer_group_available_points_transfer), new Object[]{"0"}));
            return;
        }
        String q11 = m.q(this.f80430q, PrecisionUtil.c((String) null));
        this.f80424k.setText(String.format(getString(R.string.points_transfer_group_available_points_transfer), new Object[]{m.p0(q11)}));
    }

    public void addEvent() {
        fq.m mVar = fq.m.f54747b;
        this.f80418e.setOnClickListener(mVar);
        this.f80419f.setOnClickListener(mVar);
        this.f80420g.setOnClickListener(mVar);
        this.f80421h.setOnClickListener(mVar);
        this.f80418e.addTextChangedListener(this.f80426m);
        this.f80419f.addTextChangedListener(this.f80426m);
        EditText editText = this.f80420g;
        editText.addTextChangedListener(new d(editText));
        EditText editText2 = this.f80421h;
        editText2.addTextChangedListener(new e(editText2));
        o oVar = o.f54749b;
        this.f80418e.setOnFocusChangeListener(oVar);
        this.f80419f.setOnFocusChangeListener(oVar);
        this.f80420g.setOnFocusChangeListener(oVar);
        this.f80421h.setOnFocusChangeListener(new n(this));
        this.f80422i.setText(String.format(Locale.US, getString(R.string.n_point_transfer_price), new Object[]{"--"}));
        this.f80424k.setText(String.format(getString(R.string.points_transfer_group_available_points_transfer), new Object[]{"--"}));
        this.f80416c.setOnClickBackListener(new l(this));
        this.f80416c.setOnClickActionListener(new k(this));
    }

    public boolean canFullScreen() {
        return false;
    }

    public String cf() {
        return this.f80419f.getText().toString();
    }

    public int getContentView() {
        return R.layout.activity_points_transfer;
    }

    public String getUid() {
        return this.f80418e.getText().toString();
    }

    public String i6() {
        if (TextUtils.isEmpty(this.f80421h.getText())) {
            return "";
        }
        return m.p0(m.m(this.f80421h.getText().toString(), PrecisionUtil.c((String) null)));
    }

    public void initView() {
        this.f80416c = (HbTitleBar) this.viewFinder.b(R.id.hb_title_bar);
        this.f80417d = this.viewFinder.b(R.id.id_points_transfer_bottom_btn);
        this.f80418e = (EditText) this.viewFinder.b(R.id.id_points_transfer_uid);
        this.f80419f = (EditText) this.viewFinder.b(R.id.id_points_transfer_username);
        this.f80420g = (EditText) this.viewFinder.b(R.id.id_points_transfer_count);
        this.f80421h = (EditText) this.viewFinder.b(R.id.id_points_transfer_total_price);
        this.f80424k = (TextView) this.viewFinder.b(R.id.id_points_transfer_available_point);
        this.f80422i = (TextView) this.viewFinder.b(R.id.id_points_transfer_total_price_tips);
        this.f80423j = this.viewFinder.b(R.id.id_points_transfer_total_price_bg);
        this.f80416c.setTitle(getString(R.string.points_transfer_title));
        this.f80415b = getResources().getDimension(R.dimen.dimen_44);
    }

    @SensorsDataInstrumented
    public void onClick(View view) {
        if (view.getId() == R.id.id_points_transfer_bottom_btn) {
            String cf2 = cf();
            if (this.f80428o.matcher(cf2).matches() || StringUtils.o(cf2)) {
                BigDecimal a11 = m.a(x4());
                if (a11.compareTo(m.a(CouponReturn.TYPE_EXPERIENCE)) < 0) {
                    HuobiToastUtil.m(getString(R.string.points_transfer_0_points_tips));
                    SensorsDataAutoTrackHelper.trackViewOnClick(view);
                    return;
                }
                if (this.f80430q == null) {
                    this.f80430q = BigDecimal.ZERO;
                }
                if (a11.compareTo(this.f80430q) > 0) {
                    String string = getString(R.string.points_just_transfer_amount);
                    HuobiToastUtil.m(String.format(Locale.US, string, new Object[]{m.p0(m.q(this.f80430q, PrecisionUtil.c((String) null)))}));
                    SensorsDataAutoTrackHelper.trackViewOnClick(view);
                    return;
                } else if (a11.compareTo(m.a("1000000")) > 0) {
                    HuobiToastUtil.m(getString(R.string.points_transfer_max_points_tips));
                    SensorsDataAutoTrackHelper.trackViewOnClick(view);
                    return;
                } else {
                    String i62 = i6();
                    if (TextUtils.isEmpty(i62) || m.h0(i62) == 0.0d) {
                        HuobiToastUtil.m(getString(R.string.points_transfer_total_price_not_0));
                        SensorsDataAutoTrackHelper.trackViewOnClick(view);
                        return;
                    } else if (this.f80427n > 2.0d) {
                        Dh();
                        SensorsDataAutoTrackHelper.trackViewOnClick(view);
                        return;
                    } else {
                        Ch();
                    }
                }
            } else {
                HuobiToastUtil.m(getString(R.string.points_transfer_wrong_account_tips));
                SensorsDataAutoTrackHelper.trackViewOnClick(view);
                return;
            }
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    public void onDestroy() {
        super.onDestroy();
        jq.e eVar = this.f80425l;
        if (eVar != null && eVar.isShowing()) {
            this.f80425l.dismiss();
        }
    }

    public final void vh() {
        Bh(!TextUtils.isEmpty(getUid()) && !TextUtils.isEmpty(cf()) && !TextUtils.isEmpty(x4()) && !TextUtils.isEmpty(i6()));
    }

    /* renamed from: wh */
    public PointsTransferPresenter createPresenter() {
        return new PointsTransferPresenter();
    }

    public String x4() {
        if (TextUtils.isEmpty(this.f80420g.getText())) {
            return "";
        }
        return m.p0(m.m(this.f80420g.getText().toString(), PrecisionUtil.c((String) null)));
    }

    /* renamed from: xh */
    public PointsTransferPresenter.b getUI() {
        return this;
    }
}
