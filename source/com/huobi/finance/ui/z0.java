package com.huobi.finance.ui;

import android.text.method.LinkMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import androidx.core.widget.NestedScrollView;
import androidx.fragment.app.FragmentActivity;
import com.hbg.lib.common.utils.StringUtils;
import com.hbg.lib.core.network.rx.EasySubscriber;
import com.hbg.lib.widgets.TextCheckBox;
import com.hbg.lib.widgets.dialog.DialogUtils;
import com.hbg.lib.widgets.dialog.HBDialogFragment;
import com.hbg.lib.widgets.utils.HuobiToastUtil;
import com.huobi.utils.SpannableUtils;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import i6.d;
import i6.n;
import java.util.concurrent.TimeUnit;
import pro.huobi.R;
import rx.Observable;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import sn.f;

public class z0 {

    /* renamed from: a  reason: collision with root package name */
    public FragmentActivity f47420a;

    /* renamed from: b  reason: collision with root package name */
    public b f47421b;

    /* renamed from: c  reason: collision with root package name */
    public Button f47422c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f47423d;

    /* renamed from: e  reason: collision with root package name */
    public Subscription f47424e;

    public class a implements Action1<Long> {
        public a() {
        }

        /* renamed from: a */
        public void call(Long l11) {
            d.b("AntiFraudDialog count down, second = " + l11);
            long longValue = 5 - l11.longValue();
            if (z0.this.f47422c == null) {
                return;
            }
            if (longValue > 0) {
                Button h11 = z0.this.f47422c;
                String i11 = z0.this.l(R.string.n_withdraw_anti_fraud_check_count_down);
                h11.setText(StringUtils.d(i11, longValue + "S "));
                return;
            }
            z0.this.f47422c.setText(z0.this.l(R.string.login_dialog_confirm));
            z0.this.f47422c.setEnabled(true);
            z0.this.f47424e.unsubscribe();
        }
    }

    public interface b {
        void a();
    }

    public z0(FragmentActivity fragmentActivity, b bVar) {
        this.f47420a = fragmentActivity;
        this.f47421b = bVar;
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void m(View view) {
        this.f47423d = true;
        f.j0(view.getContext());
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void n(TextCheckBox textCheckBox, View view) {
        if (this.f47423d) {
            this.f47423d = false;
        } else {
            textCheckBox.d();
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    @SensorsDataInstrumented
    public static /* synthetic */ void o(View view) {
        f.k0(view.getContext());
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void p(NestedScrollView nestedScrollView) {
        int f11 = (n.f(this.f47420a) * 1) / 2;
        ViewGroup.LayoutParams layoutParams = nestedScrollView.getLayoutParams();
        if (nestedScrollView.getHeight() > f11) {
            layoutParams.height = f11;
        }
        nestedScrollView.setLayoutParams(layoutParams);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void q(HBDialogFragment hBDialogFragment) {
        this.f47424e.unsubscribe();
        hBDialogFragment.dismiss();
        this.f47420a.finish();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void r(View view, HBDialogFragment hBDialogFragment) {
        if (k(view)) {
            hBDialogFragment.dismiss();
            b bVar = this.f47421b;
            if (bVar != null) {
                bVar.a();
            }
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void s(DialogUtils.b bVar) {
        Button E0 = bVar.E0();
        this.f47422c = E0;
        E0.setEnabled(false);
    }

    public final boolean k(View view) {
        TextCheckBox textCheckBox = (TextCheckBox) view.findViewById(R.id.cb_2);
        TextCheckBox textCheckBox2 = (TextCheckBox) view.findViewById(R.id.cb_3);
        TextCheckBox textCheckBox3 = (TextCheckBox) view.findViewById(R.id.cb_read);
        if (!((TextCheckBox) view.findViewById(R.id.cb_1)).b() || !textCheckBox.b() || !textCheckBox2.b()) {
            HuobiToastUtil.j(R.string.n_withdraw_anti_fraud_check_risk);
            return false;
        } else if (textCheckBox3.b()) {
            return true;
        } else {
            HuobiToastUtil.j(R.string.n_withdraw_anti_fraud_check_notice);
            return false;
        }
    }

    public final String l(int i11) {
        return this.f47420a.getString(i11);
    }

    public final void t(TextCheckBox textCheckBox) {
        String l11 = l(R.string.n_withdraw_anti_fraud_agreement_read_book);
        textCheckBox.setText(SpannableUtils.a(this.f47420a, StringUtils.d(l(R.string.n_withdraw_anti_fraud_agreement_read), l11), l11, new s0(this)));
        TextView textView = textCheckBox.getTextView();
        textView.setMovementMethod(LinkMovementMethod.getInstance());
        textView.setOnClickListener(new t0(this, textCheckBox));
    }

    public void u() {
        View inflate = LayoutInflater.from(this.f47420a).inflate(R.layout.dialog_content_anti_fraud, (ViewGroup) null);
        t((TextCheckBox) inflate.findViewById(R.id.cb_read));
        ((TextView) inflate.findViewById(R.id.tv_more)).setOnClickListener(u0.f47343b);
        inflate.post(new x0(this, (NestedScrollView) inflate.findViewById(R.id.scroll_view)));
        DialogUtils.b m02 = new DialogUtils.b.d(this.f47420a).i1(4).c1(l(R.string.trade_reminder_text)).q0(true).N0(new v0(this)).P0(l(R.string.login_dialog_confirm)).Q0(new w0(this, inflate)).I0(inflate).m0();
        m02.y0(new y0(this, m02)).show(this.f47420a.getSupportFragmentManager(), "");
        v();
    }

    public final void v() {
        this.f47424e = Observable.interval(0, 1, TimeUnit.SECONDS).take(6).observeOn(AndroidSchedulers.mainThread()).subscribe(EasySubscriber.create(new a()));
    }
}
