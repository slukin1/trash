package com.hbg.module.kline.index;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.transition.ChangeBounds;
import androidx.transition.Fade;
import androidx.transition.TransitionManager;
import androidx.transition.TransitionSet;
import be.f;
import be.g;
import be.h;
import be.i;
import be.j;
import com.hbg.lib.core.ui.BaseActivity;
import com.hbg.module.kline.KLineHelper;
import com.hbg.module.kline.R$attr;
import com.hbg.module.kline.R$id;
import com.hbg.module.kline.R$layout;
import com.hbg.module.kline.R$string;
import com.hbg.module.kline.R$style;
import com.hbg.module.kline.index.IndexSettingGroup;
import com.hbg.module.kline.index.presenter.IndexSettingPresenter;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import com.xiaomi.mipush.sdk.Constants;
import java.util.ArrayList;
import java.util.List;

public class IndexSettingActivity extends BaseActivity<IndexSettingPresenter, IndexSettingPresenter.a> implements View.OnClickListener, IndexSettingPresenter.a {
    public IndexSettingGroup A;
    public IndexSettingContentGroup A0;
    public IndexSettingGroup B;
    public TransitionSet B0;
    public IndexSettingGroup C;
    public IndexSettingGroup D;
    public IndexSettingGroup E;
    public IndexSettingGroup F;
    public IndexSettingGroup G;
    public IndexSettingGroup H;
    public IndexSettingGroup I;
    public IndexSettingGroup J;
    public IndexSettingGroup K;
    public IndexSettingGroup L;
    public IndexSettingGroup M;
    public IndexSettingGroup N;
    public IndexSettingGroup O;
    public IndexSettingGroup P;
    public IndexSettingGroup Q;
    public IndexSettingGroup R;
    public TextView S;
    public TextView T;
    public TextView U;
    public TextView V;
    public TextView W;
    public TextView X;
    public TextView Y;
    public TextView Z;

    /* renamed from: a0  reason: collision with root package name */
    public TextView f23526a0;

    /* renamed from: b  reason: collision with root package name */
    public View f23527b;

    /* renamed from: b0  reason: collision with root package name */
    public TextView f23528b0;

    /* renamed from: c  reason: collision with root package name */
    public View f23529c;

    /* renamed from: c0  reason: collision with root package name */
    public TextView f23530c0;

    /* renamed from: d  reason: collision with root package name */
    public View f23531d;

    /* renamed from: d0  reason: collision with root package name */
    public TextView f23532d0;

    /* renamed from: e  reason: collision with root package name */
    public View f23533e;

    /* renamed from: e0  reason: collision with root package name */
    public IndexSettingGroup f23534e0;

    /* renamed from: f  reason: collision with root package name */
    public View f23535f;

    /* renamed from: f0  reason: collision with root package name */
    public IndexSettingGroup f23536f0;

    /* renamed from: g  reason: collision with root package name */
    public View f23537g;

    /* renamed from: g0  reason: collision with root package name */
    public IndexSettingGroup f23538g0;

    /* renamed from: h  reason: collision with root package name */
    public View f23539h;

    /* renamed from: h0  reason: collision with root package name */
    public IndexSettingGroup f23540h0;

    /* renamed from: i  reason: collision with root package name */
    public List<i> f23541i = new ArrayList();

    /* renamed from: i0  reason: collision with root package name */
    public IndexSettingGroup f23542i0;

    /* renamed from: j  reason: collision with root package name */
    public ImageView f23543j;

    /* renamed from: j0  reason: collision with root package name */
    public IndexSettingGroup f23544j0;

    /* renamed from: k  reason: collision with root package name */
    public ImageView f23545k;

    /* renamed from: k0  reason: collision with root package name */
    public IndexSettingGroup f23546k0;

    /* renamed from: l  reason: collision with root package name */
    public ImageView f23547l;

    /* renamed from: l0  reason: collision with root package name */
    public IndexSettingGroup f23548l0;

    /* renamed from: m  reason: collision with root package name */
    public ImageView f23549m;

    /* renamed from: m0  reason: collision with root package name */
    public IndexSettingGroup f23550m0;

    /* renamed from: n  reason: collision with root package name */
    public ImageView f23551n;

    /* renamed from: n0  reason: collision with root package name */
    public final String f23552n0 = "0";

    /* renamed from: o  reason: collision with root package name */
    public ImageView f23553o;

    /* renamed from: p  reason: collision with root package name */
    public ImageView f23554p;

    /* renamed from: q  reason: collision with root package name */
    public RelativeLayout f23555q;

    /* renamed from: r  reason: collision with root package name */
    public RelativeLayout f23556r;

    /* renamed from: s  reason: collision with root package name */
    public RelativeLayout f23557s;

    /* renamed from: t  reason: collision with root package name */
    public RelativeLayout f23558t;

    /* renamed from: t0  reason: collision with root package name */
    public final String f23559t0 = "";

    /* renamed from: u  reason: collision with root package name */
    public RelativeLayout f23560u;

    /* renamed from: u0  reason: collision with root package name */
    public IndexSettingContentGroup f23561u0;

    /* renamed from: v  reason: collision with root package name */
    public RelativeLayout f23562v;

    /* renamed from: v0  reason: collision with root package name */
    public IndexSettingContentGroup f23563v0;

    /* renamed from: w  reason: collision with root package name */
    public RelativeLayout f23564w;

    /* renamed from: w0  reason: collision with root package name */
    public IndexSettingContentGroup f23565w0;

    /* renamed from: x  reason: collision with root package name */
    public IndexSettingGroup f23566x;

    /* renamed from: x0  reason: collision with root package name */
    public IndexSettingContentGroup f23567x0;

    /* renamed from: y  reason: collision with root package name */
    public IndexSettingGroup f23568y;

    /* renamed from: y0  reason: collision with root package name */
    public IndexSettingContentGroup f23569y0;

    /* renamed from: z  reason: collision with root package name */
    public IndexSettingGroup f23570z;

    /* renamed from: z0  reason: collision with root package name */
    public IndexSettingContentGroup f23571z0;

    public class a implements IndexSettingGroup.e {
        public a() {
        }

        public void a(boolean z11) {
            TextView Oh = IndexSettingActivity.this.S;
            IndexSettingActivity indexSettingActivity = IndexSettingActivity.this;
            Oh.setText(indexSettingActivity.Rh(indexSettingActivity.getString(R$string.index_setting_ma), IndexSettingActivity.this.f23566x, IndexSettingActivity.this.f23568y, IndexSettingActivity.this.f23570z, IndexSettingActivity.this.A, IndexSettingActivity.this.B, IndexSettingActivity.this.C, IndexSettingActivity.this.D, IndexSettingActivity.this.E));
        }

        public void b(String str, IndexSettingGroup indexSettingGroup) {
            TextView Oh = IndexSettingActivity.this.S;
            IndexSettingActivity indexSettingActivity = IndexSettingActivity.this;
            Oh.setText(indexSettingActivity.Rh(indexSettingActivity.getString(R$string.index_setting_ma), IndexSettingActivity.this.f23566x, IndexSettingActivity.this.f23568y, IndexSettingActivity.this.f23570z, IndexSettingActivity.this.A, IndexSettingActivity.this.B, IndexSettingActivity.this.C, IndexSettingActivity.this.D, IndexSettingActivity.this.E));
            indexSettingGroup.setSelectStatus(!TextUtils.isEmpty(indexSettingGroup.getEditText()));
        }

        public void c(boolean z11, IndexSettingGroup indexSettingGroup) {
        }
    }

    public class b implements IndexSettingGroup.e {
        public b() {
        }

        public void a(boolean z11) {
            TextView yh2 = IndexSettingActivity.this.T;
            IndexSettingActivity indexSettingActivity = IndexSettingActivity.this;
            yh2.setText(indexSettingActivity.Rh(indexSettingActivity.getString(R$string.index_setting_ema), IndexSettingActivity.this.F, IndexSettingActivity.this.G, IndexSettingActivity.this.H, IndexSettingActivity.this.I, IndexSettingActivity.this.J, IndexSettingActivity.this.K, IndexSettingActivity.this.L, IndexSettingActivity.this.M));
        }

        public void b(String str, IndexSettingGroup indexSettingGroup) {
            TextView yh2 = IndexSettingActivity.this.T;
            IndexSettingActivity indexSettingActivity = IndexSettingActivity.this;
            yh2.setText(indexSettingActivity.Rh(indexSettingActivity.getString(R$string.index_setting_ema), IndexSettingActivity.this.F, IndexSettingActivity.this.G, IndexSettingActivity.this.H, IndexSettingActivity.this.I, IndexSettingActivity.this.J, IndexSettingActivity.this.K, IndexSettingActivity.this.L, IndexSettingActivity.this.M));
            indexSettingGroup.setSelectStatus(!TextUtils.isEmpty(indexSettingGroup.getEditText()));
        }

        public void c(boolean z11, IndexSettingGroup indexSettingGroup) {
        }
    }

    public class c implements IndexSettingGroup.e {
        public c() {
        }

        public void a(boolean z11) {
            d();
        }

        public void b(String str, IndexSettingGroup indexSettingGroup) {
            d();
            indexSettingGroup.setSelectStatus(!TextUtils.isEmpty(indexSettingGroup.getText()));
        }

        public void c(boolean z11, IndexSettingGroup indexSettingGroup) {
        }

        public final void d() {
            StringBuilder sb2 = new StringBuilder();
            IndexSettingActivity indexSettingActivity = IndexSettingActivity.this;
            sb2.append(indexSettingActivity.Rh(IndexSettingActivity.this.getResources().getString(R$string.index_setting_rsi1) + Constants.ACCEPT_TIME_SEPARATOR_SERVER, IndexSettingActivity.this.f23540h0));
            IndexSettingActivity indexSettingActivity2 = IndexSettingActivity.this;
            sb2.append(indexSettingActivity2.Rh(IndexSettingActivity.this.getResources().getString(R$string.index_setting_rsi2) + Constants.ACCEPT_TIME_SEPARATOR_SERVER, IndexSettingActivity.this.f23542i0));
            IndexSettingActivity indexSettingActivity3 = IndexSettingActivity.this;
            sb2.append(indexSettingActivity3.Rh(IndexSettingActivity.this.getResources().getString(R$string.index_setting_rsi3) + Constants.ACCEPT_TIME_SEPARATOR_SERVER, IndexSettingActivity.this.f23544j0));
            IndexSettingActivity.this.f23530c0.setText(sb2.toString());
        }
    }

    public class d implements IndexSettingGroup.e {
        public d() {
        }

        public void a(boolean z11) {
            d();
        }

        public void b(String str, IndexSettingGroup indexSettingGroup) {
            d();
            indexSettingGroup.setSelectStatus(!TextUtils.isEmpty(indexSettingGroup.getText()));
        }

        public void c(boolean z11, IndexSettingGroup indexSettingGroup) {
        }

        public final void d() {
            StringBuilder sb2 = new StringBuilder();
            IndexSettingActivity indexSettingActivity = IndexSettingActivity.this;
            sb2.append(indexSettingActivity.Rh(IndexSettingActivity.this.getResources().getString(R$string.index_setting_wr1) + Constants.ACCEPT_TIME_SEPARATOR_SERVER, IndexSettingActivity.this.f23546k0));
            IndexSettingActivity indexSettingActivity2 = IndexSettingActivity.this;
            sb2.append(indexSettingActivity2.Rh(IndexSettingActivity.this.getResources().getString(R$string.index_setting_wr2) + Constants.ACCEPT_TIME_SEPARATOR_SERVER, IndexSettingActivity.this.f23548l0));
            IndexSettingActivity indexSettingActivity3 = IndexSettingActivity.this;
            sb2.append(indexSettingActivity3.Rh(IndexSettingActivity.this.getResources().getString(R$string.index_setting_wr3) + Constants.ACCEPT_TIME_SEPARATOR_SERVER, IndexSettingActivity.this.f23550m0));
            IndexSettingActivity.this.f23532d0.setText(sb2.toString());
        }
    }

    public class e implements IndexSettingGroup.e {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ TextView f23576a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f23577b;

        public e(TextView textView, String str) {
            this.f23576a = textView;
            this.f23577b = str;
        }

        public void a(boolean z11) {
            if (z11) {
                this.f23576a.setVisibility(0);
            } else {
                this.f23576a.setVisibility(8);
            }
        }

        public void b(String str, IndexSettingGroup indexSettingGroup) {
            if (TextUtils.isEmpty(str) || "0".equals(str) || "".equals(str)) {
                this.f23576a.setVisibility(8);
                return;
            }
            TextView textView = this.f23576a;
            textView.setText(this.f23577b + str);
            if (indexSettingGroup.l() || !indexSettingGroup.getSelectVisible()) {
                this.f23576a.setVisibility(0);
            }
        }

        public void c(boolean z11, IndexSettingGroup indexSettingGroup) {
            indexSettingGroup.setSelectStatus(z11);
        }
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void Wh(View view) {
        finish();
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void Xh(View view) {
        this.f23566x.j();
        this.f23568y.j();
        this.f23570z.j();
        this.A.j();
        this.B.j();
        this.C.j();
        this.D.j();
        this.E.j();
        this.S.setText(getResources().getString(R$string.index_setting_ma_hint));
        this.S.setVisibility(0);
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void Yh(View view) {
        this.F.j();
        this.G.j();
        this.H.j();
        this.I.j();
        this.J.j();
        this.K.j();
        this.L.j();
        this.M.j();
        this.T.setText(getResources().getString(R$string.index_setting_ema_hint));
        this.T.setVisibility(0);
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void Zh(View view) {
        String str;
        this.N.j();
        this.O.j();
        TextView textView = this.U;
        String str2 = "";
        if (TextUtils.isEmpty(textView.getHint())) {
            str = str2;
        } else {
            str = this.U.getHint().toString();
        }
        textView.setText(str);
        TextView textView2 = this.V;
        if (!TextUtils.isEmpty(textView2.getHint())) {
            str2 = this.V.getHint().toString();
        }
        textView2.setText(str2);
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void ai(View view) {
        String str;
        String str2;
        this.P.j();
        this.Q.j();
        this.R.j();
        TextView textView = this.W;
        String str3 = "";
        if (TextUtils.isEmpty(textView.getHint())) {
            str = str3;
        } else {
            str = this.W.getHint().toString();
        }
        textView.setText(str);
        TextView textView2 = this.X;
        if (TextUtils.isEmpty(textView2.getHint())) {
            str2 = str3;
        } else {
            str2 = this.X.getHint().toString();
        }
        textView2.setText(str2);
        TextView textView3 = this.Y;
        if (!TextUtils.isEmpty(textView3.getHint())) {
            str3 = this.Y.getHint().toString();
        }
        textView3.setText(str3);
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void bi(View view) {
        String str;
        String str2;
        this.f23534e0.j();
        this.f23536f0.j();
        this.f23538g0.j();
        TextView textView = this.Z;
        String str3 = "";
        if (TextUtils.isEmpty(textView.getHint())) {
            str = str3;
        } else {
            str = this.Z.getHint().toString();
        }
        textView.setText(str);
        TextView textView2 = this.f23526a0;
        if (TextUtils.isEmpty(textView2.getHint())) {
            str2 = str3;
        } else {
            str2 = this.f23526a0.getHint().toString();
        }
        textView2.setText(str2);
        TextView textView3 = this.f23528b0;
        if (!TextUtils.isEmpty(textView3.getHint())) {
            str3 = this.f23528b0.getHint().toString();
        }
        textView3.setText(str3);
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void ci(View view) {
        this.f23540h0.j();
        this.f23542i0.j();
        this.f23544j0.j();
        this.f23530c0.setText(getResources().getString(R$string.index_setting_rsi1_2));
        this.f23530c0.setVisibility(0);
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void di(View view) {
        this.f23546k0.j();
        this.f23548l0.j();
        this.f23550m0.j();
        this.f23532d0.setText(getResources().getString(R$string.index_setting_wr1_14));
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* renamed from: Ph */
    public IndexSettingPresenter createPresenter() {
        return new IndexSettingPresenter();
    }

    public final void Qh() {
        this.f23541i.clear();
        this.f23541i.add(new i(this.f23566x.getKey(), this.f23566x.getEditText(), this.f23566x.l()));
        this.f23541i.add(new i(this.f23568y.getKey(), this.f23568y.getEditText(), this.f23568y.l()));
        this.f23541i.add(new i(this.f23570z.getKey(), this.f23570z.getEditText(), this.f23570z.l()));
        this.f23541i.add(new i(this.A.getKey(), this.A.getEditText(), this.A.l()));
        this.f23541i.add(new i(this.B.getKey(), this.B.getEditText(), this.B.l()));
        this.f23541i.add(new i(this.C.getKey(), this.C.getEditText(), this.C.l()));
        this.f23541i.add(new i(this.N.getKey(), this.N.getEditText(), true));
        this.f23541i.add(new i(this.O.getKey(), this.O.getEditText(), true));
        this.f23541i.add(new i(this.P.getKey(), this.P.getEditText(), true));
        this.f23541i.add(new i(this.Q.getKey(), this.Q.getEditText(), true));
        this.f23541i.add(new i(this.R.getKey(), this.R.getEditText(), true));
        this.f23541i.add(new i(this.f23534e0.getKey(), this.f23534e0.getEditText(), true));
        this.f23541i.add(new i(this.f23536f0.getKey(), this.f23536f0.getEditText(), true));
        this.f23541i.add(new i(this.f23538g0.getKey(), this.f23538g0.getEditText(), true));
        this.f23541i.add(new i(this.f23540h0.getKey(), this.f23540h0.getEditText(), this.f23540h0.l()));
        this.f23541i.add(new i(this.f23542i0.getKey(), this.f23542i0.getEditText(), this.f23542i0.l()));
        this.f23541i.add(new i(this.f23544j0.getKey(), this.f23544j0.getEditText(), this.f23544j0.l()));
        this.f23541i.add(new i(this.f23546k0.getKey(), this.f23546k0.getEditText(), this.f23546k0.l()));
        this.f23541i.add(new i(this.f23548l0.getKey(), this.f23548l0.getEditText(), this.f23548l0.l()));
        this.f23541i.add(new i(this.f23550m0.getKey(), this.f23550m0.getEditText(), this.f23550m0.l()));
        this.f23541i.add(new i(this.D.getKey(), this.D.getEditText(), this.D.l()));
        this.f23541i.add(new i(this.E.getKey(), this.E.getEditText(), this.E.l()));
        this.f23541i.add(new i(this.F.getKey(), this.F.getEditText(), this.F.l()));
        this.f23541i.add(new i(this.G.getKey(), this.G.getEditText(), this.G.l()));
        this.f23541i.add(new i(this.H.getKey(), this.H.getEditText(), this.H.l()));
        this.f23541i.add(new i(this.I.getKey(), this.I.getEditText(), this.I.l()));
        this.f23541i.add(new i(this.J.getKey(), this.J.getEditText(), this.J.l()));
        this.f23541i.add(new i(this.K.getKey(), this.K.getEditText(), this.K.l()));
        this.f23541i.add(new i(this.L.getKey(), this.L.getEditText(), this.L.l()));
        this.f23541i.add(new i(this.M.getKey(), this.M.getEditText(), this.M.l()));
        j.c().e(this.f23541i);
    }

    public final String Rh(String str, IndexSettingGroup... indexSettingGroupArr) {
        StringBuilder sb2 = new StringBuilder();
        if (indexSettingGroupArr != null) {
            for (IndexSettingGroup Sh : indexSettingGroupArr) {
                sb2.append(Sh(Sh, str));
            }
        }
        return sb2.toString();
    }

    public final String Sh(IndexSettingGroup indexSettingGroup, String str) {
        if (indexSettingGroup.l()) {
            String editText = indexSettingGroup.getEditText();
            if (!TextUtils.isEmpty(editText)) {
                return "  " + str + editText;
            }
        }
        return "";
    }

    public int Th(int i11) {
        TypedValue typedValue = new TypedValue();
        getTheme().resolveAttribute(i11, typedValue, true);
        return typedValue.data;
    }

    /* renamed from: Uh */
    public IndexSettingPresenter.a getUI() {
        return this;
    }

    public final void Vh() {
        setStatusBarColor(Th(R$attr.kline_activity_background_color));
        if (KLineHelper.f()) {
            getWindow().getDecorView().setSystemUiVisibility(getWindow().getDecorView().getSystemUiVisibility() | 16);
        }
        getWindow().setNavigationBarColor(Th(R$attr.kline_content_background_color));
        this.viewFinder.b(R$id.iv_back).setOnClickListener(new f(this));
    }

    public void addEvent() {
        this.f23531d.setOnClickListener(this);
        this.f23527b.setOnClickListener(this);
        this.f23529c.setOnClickListener(this);
        this.f23533e.setOnClickListener(this);
        this.f23535f.setOnClickListener(this);
        this.f23537g.setOnClickListener(this);
        this.f23539h.setOnClickListener(this);
        gi();
    }

    public final void ei() {
        List<i> a11 = j.c().a();
        if (a11 != null && a11.size() > 0) {
            this.f23566x.setBaseData(a11.get(0));
            this.f23568y.setBaseData(a11.get(1));
            this.f23570z.setBaseData(a11.get(2));
            this.A.setBaseData(a11.get(3));
            this.B.setBaseData(a11.get(4));
            this.C.setBaseData(a11.get(5));
            this.D.setBaseData(a11.get(20));
            this.E.setBaseData(a11.get(21));
            this.N.setBaseData(a11.get(6));
            this.O.setBaseData(a11.get(7));
            this.P.setBaseData(a11.get(8));
            this.Q.setBaseData(a11.get(9));
            this.R.setBaseData(a11.get(10));
            this.f23534e0.setBaseData(a11.get(11));
            this.f23536f0.setBaseData(a11.get(12));
            this.f23538g0.setBaseData(a11.get(13));
            this.f23540h0.setBaseData(a11.get(14));
            this.f23542i0.setBaseData(a11.get(15));
            this.f23544j0.setBaseData(a11.get(16));
            this.f23546k0.setBaseData(a11.get(17));
            this.f23548l0.setBaseData(a11.get(18));
            this.f23550m0.setBaseData(a11.get(19));
            this.F.setBaseData(a11.get(22));
            this.G.setBaseData(a11.get(23));
            this.H.setBaseData(a11.get(24));
            this.I.setBaseData(a11.get(25));
            this.J.setBaseData(a11.get(26));
            this.K.setBaseData(a11.get(27));
            this.L.setBaseData(a11.get(28));
            this.M.setBaseData(a11.get(29));
        }
    }

    public final void fi(TextView textView, String str, IndexSettingGroup indexSettingGroup) {
        indexSettingGroup.setCallback(new e(textView, str));
    }

    public int getContentView() {
        return R$layout.activity_index_setting;
    }

    public final void gi() {
        this.f23561u0.setRestClickListener(new be.c(this));
        this.f23563v0.setRestClickListener(new be.a(this));
        this.f23565w0.setRestClickListener(new h(this));
        this.f23567x0.setRestClickListener(new be.e(this));
        this.f23569y0.setRestClickListener(new be.b(this));
        this.f23571z0.setRestClickListener(new be.d(this));
        this.A0.setRestClickListener(new g(this));
    }

    public final void hi(View view, ImageView imageView) {
        if (view.getVisibility() == 0) {
            imageView.setSelected(false);
            view.setVisibility(8);
            return;
        }
        imageView.setSelected(true);
        view.setVisibility(0);
    }

    public final void ii() {
        this.f23527b = this.viewFinder.b(R$id.layout_ma);
        this.f23529c = this.viewFinder.b(R$id.layout_ema);
        this.f23531d = this.viewFinder.b(R$id.layout_boll);
        this.f23533e = this.viewFinder.b(R$id.layout_macd);
        this.f23535f = this.viewFinder.b(R$id.layout_kdj);
        this.f23537g = this.viewFinder.b(R$id.layout_rsi);
        this.f23539h = this.viewFinder.b(R$id.layout_wr);
        this.f23543j = (ImageView) this.viewFinder.b(R$id.ma_fold);
        this.f23545k = (ImageView) this.viewFinder.b(R$id.ema_fold);
        this.f23547l = (ImageView) this.viewFinder.b(R$id.boll_fold);
        this.f23549m = (ImageView) this.viewFinder.b(R$id.macd_fold);
        this.f23551n = (ImageView) this.viewFinder.b(R$id.kdj_fold);
        this.f23553o = (ImageView) this.viewFinder.b(R$id.rsi_fold);
        this.f23554p = (ImageView) this.viewFinder.b(R$id.wr_fold);
        this.f23555q = (RelativeLayout) this.viewFinder.b(R$id.ma_relative);
        this.f23556r = (RelativeLayout) this.viewFinder.b(R$id.ema_relative);
        this.f23557s = (RelativeLayout) this.viewFinder.b(R$id.boll_relative);
        this.f23558t = (RelativeLayout) this.viewFinder.b(R$id.macd_relative);
        this.f23560u = (RelativeLayout) this.viewFinder.b(R$id.kdj_relative);
        this.f23564w = (RelativeLayout) this.viewFinder.b(R$id.rsi_relative);
        this.f23562v = (RelativeLayout) this.viewFinder.b(R$id.wr_relative);
        this.f23566x = (IndexSettingGroup) this.viewFinder.b(R$id.ma1);
        this.f23568y = (IndexSettingGroup) this.viewFinder.b(R$id.ma2);
        this.f23570z = (IndexSettingGroup) this.viewFinder.b(R$id.ma3);
        this.A = (IndexSettingGroup) this.viewFinder.b(R$id.ma4);
        this.B = (IndexSettingGroup) this.viewFinder.b(R$id.ma5);
        this.C = (IndexSettingGroup) this.viewFinder.b(R$id.ma6);
        this.D = (IndexSettingGroup) this.viewFinder.b(R$id.ma7);
        this.E = (IndexSettingGroup) this.viewFinder.b(R$id.ma8);
        this.F = (IndexSettingGroup) this.viewFinder.b(R$id.ema1);
        this.G = (IndexSettingGroup) this.viewFinder.b(R$id.ema2);
        this.H = (IndexSettingGroup) this.viewFinder.b(R$id.ema3);
        this.I = (IndexSettingGroup) this.viewFinder.b(R$id.ema4);
        this.J = (IndexSettingGroup) this.viewFinder.b(R$id.ema5);
        this.K = (IndexSettingGroup) this.viewFinder.b(R$id.ema6);
        this.L = (IndexSettingGroup) this.viewFinder.b(R$id.ema7);
        this.M = (IndexSettingGroup) this.viewFinder.b(R$id.ema8);
        this.N = (IndexSettingGroup) this.viewFinder.b(R$id.boll1);
        this.O = (IndexSettingGroup) this.viewFinder.b(R$id.boll2);
        this.P = (IndexSettingGroup) this.viewFinder.b(R$id.macd1);
        this.Q = (IndexSettingGroup) this.viewFinder.b(R$id.macd2);
        this.R = (IndexSettingGroup) this.viewFinder.b(R$id.macd3);
        this.f23534e0 = (IndexSettingGroup) this.viewFinder.b(R$id.kdj1);
        this.f23536f0 = (IndexSettingGroup) this.viewFinder.b(R$id.kdj2);
        this.f23538g0 = (IndexSettingGroup) this.viewFinder.b(R$id.kdj3);
        this.f23540h0 = (IndexSettingGroup) this.viewFinder.b(R$id.rsi1);
        this.f23542i0 = (IndexSettingGroup) this.viewFinder.b(R$id.rsi2);
        this.f23544j0 = (IndexSettingGroup) this.viewFinder.b(R$id.rsi3);
        this.f23546k0 = (IndexSettingGroup) this.viewFinder.b(R$id.wr1);
        this.f23548l0 = (IndexSettingGroup) this.viewFinder.b(R$id.wr2);
        this.f23550m0 = (IndexSettingGroup) this.viewFinder.b(R$id.wr3);
        this.f23561u0 = (IndexSettingContentGroup) this.viewFinder.b(R$id.ma_content);
        this.f23563v0 = (IndexSettingContentGroup) this.viewFinder.b(R$id.ema_content);
        this.f23565w0 = (IndexSettingContentGroup) this.viewFinder.b(R$id.boll_content);
        this.f23567x0 = (IndexSettingContentGroup) this.viewFinder.b(R$id.macd_content);
        this.f23569y0 = (IndexSettingContentGroup) this.viewFinder.b(R$id.kdj_content);
        this.f23571z0 = (IndexSettingContentGroup) this.viewFinder.b(R$id.rsi_content);
        this.A0 = (IndexSettingContentGroup) this.viewFinder.b(R$id.wr_content);
        this.S = (TextView) this.viewFinder.b(R$id.text_m1);
        this.T = (TextView) this.viewFinder.b(R$id.text_em1);
        this.U = (TextView) this.viewFinder.b(R$id.text_boll1);
        this.V = (TextView) this.viewFinder.b(R$id.text_boll2);
        this.W = (TextView) this.viewFinder.b(R$id.text_macd1);
        this.X = (TextView) this.viewFinder.b(R$id.text_macd2);
        this.Y = (TextView) this.viewFinder.b(R$id.text_macd3);
        this.Z = (TextView) this.viewFinder.b(R$id.text_kdj1);
        this.f23526a0 = (TextView) this.viewFinder.b(R$id.text_kdj2);
        this.f23528b0 = (TextView) this.viewFinder.b(R$id.text_kdj3);
        this.f23530c0 = (TextView) this.viewFinder.b(R$id.text_rsi1);
        this.f23532d0 = (TextView) this.viewFinder.b(R$id.text_wr1);
        a aVar = new a();
        this.f23566x.setCallback(aVar);
        this.f23568y.setCallback(aVar);
        this.f23570z.setCallback(aVar);
        this.A.setCallback(aVar);
        this.B.setCallback(aVar);
        this.C.setCallback(aVar);
        this.D.setCallback(aVar);
        this.E.setCallback(aVar);
        b bVar = new b();
        this.F.setCallback(bVar);
        this.G.setCallback(bVar);
        this.H.setCallback(bVar);
        this.I.setCallback(bVar);
        this.J.setCallback(bVar);
        this.K.setCallback(bVar);
        this.L.setCallback(bVar);
        this.M.setCallback(bVar);
        TextView textView = this.U;
        int i11 = R$string.index_setting_n_hint;
        fi(textView, getString(i11), this.N);
        fi(this.V, getString(R$string.index_setting_p_hint), this.O);
        fi(this.W, getString(R$string.index_setting_s), this.P);
        fi(this.X, getString(R$string.index_setting_l), this.Q);
        fi(this.Y, getString(R$string.index_setting_m), this.R);
        fi(this.Z, getString(i11), this.f23534e0);
        TextView textView2 = this.f23526a0;
        StringBuilder sb2 = new StringBuilder();
        sb2.append(getString(R$string.index_setting_m1));
        int i12 = R$string.index_setting_line;
        sb2.append(getString(i12));
        fi(textView2, sb2.toString(), this.f23536f0);
        TextView textView3 = this.f23528b0;
        fi(textView3, getString(R$string.index_setting_m2) + getString(i12), this.f23538g0);
        c cVar = new c();
        this.f23540h0.setCallback(cVar);
        this.f23542i0.setCallback(cVar);
        this.f23544j0.setCallback(cVar);
        d dVar = new d();
        this.f23546k0.setCallback(dVar);
        this.f23548l0.setCallback(dVar);
        this.f23550m0.setCallback(dVar);
    }

    public void initView() {
        removeWinBg();
        Vh();
        ii();
        ei();
    }

    public boolean isLightStatusBar() {
        return !KLineHelper.f();
    }

    @SensorsDataInstrumented
    public void onClick(View view) {
        TransitionManager.b((ViewGroup) findViewById(16908290), this.B0);
        int id2 = view.getId();
        if (id2 == R$id.layout_ma) {
            hi(this.f23555q, this.f23543j);
        } else if (id2 == R$id.layout_ema) {
            hi(this.f23556r, this.f23545k);
        } else if (id2 == R$id.layout_boll) {
            hi(this.f23557s, this.f23547l);
        } else if (id2 == R$id.layout_macd) {
            hi(this.f23558t, this.f23549m);
        } else if (id2 == R$id.layout_kdj) {
            hi(this.f23560u, this.f23551n);
        } else if (id2 == R$id.layout_rsi) {
            hi(this.f23564w, this.f23553o);
        } else if (id2 == R$id.layout_wr) {
            hi(this.f23562v, this.f23554p);
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    public void onCreate(Bundle bundle) {
        if (KLineHelper.f()) {
            setTheme(R$style.ActivityKlineLight);
        } else {
            setTheme(R$style.ActivityKlineNight);
        }
        super.onCreate(bundle);
    }

    public void onPause() {
        super.onPause();
        Qh();
    }

    public void onStart() {
        super.onStart();
        TransitionSet transitionSet = new TransitionSet();
        this.B0 = transitionSet;
        transitionSet.g(new Fade(2));
        this.B0.g(new Fade(1));
        this.B0.g(new ChangeBounds());
        this.B0.s(0);
    }

    public boolean useNewStatusBarFunc() {
        return true;
    }
}
