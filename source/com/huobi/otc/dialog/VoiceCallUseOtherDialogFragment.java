package com.huobi.otc.dialog;

import android.content.Context;
import android.content.DialogInterface;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import com.hbg.lib.core.network.rx.EasySubscriber;
import com.hbg.lib.core.util.RxJavaHelper;
import com.hbg.lib.widgets.dialog.BaseDialogFragment;
import com.hbg.lib.widgets.input.ClearEditText;
import com.hbg.lib.widgets.utils.HuobiToastUtil;
import com.hbg.module.otc.R$color;
import com.hbg.module.otc.R$id;
import com.hbg.module.otc.R$layout;
import com.hbg.module.otc.R$string;
import com.hbg.module.otc.R$style;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import dp.a0;
import dp.b0;
import dp.c0;
import dp.d0;
import dp.e0;
import dp.f0;
import dp.y;
import dp.z;
import i6.m;
import i6.r;
import java.util.concurrent.TimeUnit;
import rx.Observable;
import rx.schedulers.Schedulers;
import rx.subscriptions.CompositeSubscription;
import u6.g;

public class VoiceCallUseOtherDialogFragment extends BaseDialogFragment {

    /* renamed from: b  reason: collision with root package name */
    public TextView f78323b;

    /* renamed from: c  reason: collision with root package name */
    public ClearEditText f78324c;

    /* renamed from: d  reason: collision with root package name */
    public ClearEditText f78325d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f78326e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f78327f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f78328g;

    /* renamed from: h  reason: collision with root package name */
    public View f78329h;

    /* renamed from: i  reason: collision with root package name */
    public View f78330i;

    /* renamed from: j  reason: collision with root package name */
    public final CompositeSubscription f78331j = new CompositeSubscription();

    /* renamed from: k  reason: collision with root package name */
    public b f78332k;

    /* renamed from: l  reason: collision with root package name */
    public boolean f78333l;

    public class a extends EasySubscriber<Long> {
        public a() {
        }

        public void onNext(Long l11) {
            if (l11.longValue() >= 0) {
                VoiceCallUseOtherDialogFragment.this.Ih(m.k0(l11 + ""));
            } else if (!isUnsubscribed()) {
                unsubscribe();
            }
        }
    }

    public interface b {
        void d(String str, String str2);

        void f(String str);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void Dh(View view, boolean z11) {
        int i11;
        View view2 = this.f78329h;
        Context context = view.getContext();
        if (z11) {
            i11 = R$color.baseColorMajorTheme100;
        } else {
            i11 = R$color.global_divider_color;
        }
        view2.setBackgroundColor(ContextCompat.getColor(context, i11));
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void Eh(View view, boolean z11) {
        int i11;
        View view2 = this.f78330i;
        Context context = view.getContext();
        if (z11) {
            i11 = R$color.baseColorMajorTheme100;
        } else {
            i11 = R$color.global_divider_color;
        }
        view2.setBackgroundColor(ContextCompat.getColor(context, i11));
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void Fh(CharSequence charSequence, int i11, int i12, int i13) {
        if (TextUtils.equals(this.f78327f.getText().toString(), getString(R$string.security_send))) {
            if (!TextUtils.isEmpty(charSequence)) {
                this.f78326e.setVisibility(0);
                this.f78327f.setVisibility(8);
            } else {
                this.f78326e.setVisibility(8);
                this.f78327f.setVisibility(0);
            }
        }
        Bh();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void Gh(CharSequence charSequence, int i11, int i12, int i13) {
        Bh();
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void lambda$addEvent$0(View view) {
        dismiss();
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void lambda$addEvent$1(View view) {
        if (this.f78332k != null) {
            if (!TextUtils.isEmpty(this.f78324c.getText().toString())) {
                this.f78332k.f(this.f78324c.getText().toString());
            } else {
                HuobiToastUtil.m(this.f78326e.getContext().getString(R$string.security_input_sms_hint));
            }
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void lambda$addEvent$2(View view) {
        b bVar = this.f78332k;
        if (bVar != null) {
            bVar.d(this.f78324c.getText().toString(), this.f78325d.getText().toString());
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    public final void Bh() {
        this.f78328g.setEnabled(!TextUtils.isEmpty(this.f78324c.getText()) && !TextUtils.isEmpty(this.f78325d.getText()) && this.f78333l);
    }

    public String Ch() {
        return this.f78324c.getText().toString();
    }

    public final void Ih(int i11) {
        if (i11 > 0) {
            TextView textView = this.f78327f;
            textView.setText(textView.getContext().getString(R$string.security_resend_after, new Object[]{Integer.valueOf(i11)}));
            this.f78326e.setVisibility(8);
            this.f78327f.setVisibility(0);
            return;
        }
        this.f78326e.setVisibility(0);
        this.f78327f.setVisibility(8);
        this.f78327f.setText(getString(R$string.security_send));
    }

    public void Jh(g gVar) {
        this.f78333l = true;
        Bh();
        this.f78331j.add(Observable.interval(0, 1, TimeUnit.SECONDS).map(f0.f53874b).compose(RxJavaHelper.u(gVar, Schedulers.computation())).subscribe(new a()));
    }

    public void addEvent(r rVar) {
        this.f78323b.setOnClickListener(new a0(this));
        this.f78326e.setOnClickListener(new y(this));
        this.f78328g.setOnClickListener(new z(this));
        this.f78324c.setClearEditTextOnFocusChangeListener(new c0(this));
        this.f78325d.setClearEditTextOnFocusChangeListener(new b0(this));
        this.f78324c.setOnTextChangedListener(new e0(this));
        this.f78325d.setOnTextChangedListener(new d0(this));
    }

    public void afterInit() {
    }

    public int getAnimationStyle() {
        return R$style.bottom_dialog_animation;
    }

    public int getContentViewResId() {
        return R$layout.fragment_dialog_change_phone_layout;
    }

    public int getGravity() {
        return 80;
    }

    public void initView(r rVar) {
        this.f78323b = (TextView) rVar.b(R$id.tv_cancel);
        this.f78324c = (ClearEditText) rVar.b(R$id.other_phone_input_et);
        this.f78325d = (ClearEditText) rVar.b(R$id.et_sms_input);
        this.f78326e = (TextView) rVar.b(R$id.tv_sms_send);
        this.f78327f = (TextView) rVar.b(R$id.sms_count_down_tv);
        this.f78328g = (TextView) rVar.b(R$id.btn_action);
        this.f78329h = rVar.b(R$id.input_phone_bottom_line);
        this.f78330i = rVar.b(R$id.v_sms_divider);
    }

    public boolean isTransparent() {
        return false;
    }

    public void onDestroy() {
        super.onDestroy();
        if (!this.f78331j.isUnsubscribed()) {
            this.f78331j.unsubscribe();
        }
    }

    public void onDismiss(DialogInterface dialogInterface) {
        super.onDismiss(dialogInterface);
        if (getActivity() != null && !getActivity().isFinishing()) {
            this.f78326e.setVisibility(0);
            this.f78327f.setVisibility(8);
            this.f78327f.setText(getString(R$string.security_send));
            this.f78325d.setText("");
            this.f78324c.setText("");
            this.f78328g.setEnabled(false);
            View view = this.f78329h;
            Context context = view.getContext();
            int i11 = R$color.global_divider_color;
            view.setBackgroundColor(ContextCompat.getColor(context, i11));
            View view2 = this.f78330i;
            view2.setBackgroundColor(ContextCompat.getColor(view2.getContext(), i11));
        }
    }
}
