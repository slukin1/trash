package com.huobi.setting.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.appcompat.widget.SwitchCompat;
import com.hbg.lib.common.utils.DateTimeUtils;
import com.hbg.lib.core.BaseModuleConfig;
import com.hbg.lib.core.network.rx.EasySubscriber;
import com.hbg.lib.core.util.RxJavaHelper;
import com.hbg.lib.network.hbg.core.bean.NoDisturbData;
import com.hbg.lib.network.retrofit.exception.APIStatusErrorException;
import com.hbg.lib.network.retrofit.rxjava.BaseSubscriber;
import com.huobi.view.pickerview.TimePickerBuilder;
import com.huobi.view.pickerview.TimePickerView;
import com.huobi.view.pickerview.listener.OnTimeSelectListener;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import pro.huobi.R;
import u6.g;

public class NoDisturbSwitchView extends RelativeLayout implements View.OnClickListener, CompoundButton.OnCheckedChangeListener {

    /* renamed from: b  reason: collision with root package name */
    public LinearLayout f80809b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f80810c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f80811d;

    /* renamed from: e  reason: collision with root package name */
    public View f80812e;

    /* renamed from: f  reason: collision with root package name */
    public SwitchCompat f80813f;

    /* renamed from: g  reason: collision with root package name */
    public int f80814g;

    /* renamed from: h  reason: collision with root package name */
    public final Calendar f80815h;

    /* renamed from: i  reason: collision with root package name */
    public final Calendar f80816i;

    public class a implements OnTimeSelectListener {
        public a() {
        }

        public void onTimeSelect(Date date, View view) {
            Log.d("NoDisturbSwitchView", "onTimeSelect: " + date.getHours() + ", " + date.getMinutes());
            NoDisturbSwitchView.this.f80815h.set(11, date.getHours());
            NoDisturbSwitchView.this.f80815h.set(12, date.getMinutes());
            NoDisturbSwitchView.this.f80810c.setText(NoDisturbSwitchView.this.getNoDisturbStartTime());
            NoDisturbSwitchView.this.k(false, false, (c6.b) null);
        }
    }

    public class b implements OnTimeSelectListener {
        public b() {
        }

        public void onTimeSelect(Date date, View view) {
            Log.d("NoDisturbSwitchView", "onTimeSelect: " + date.getHours() + ", " + date.getMinutes());
            NoDisturbSwitchView.this.f80816i.set(11, date.getHours());
            NoDisturbSwitchView.this.f80816i.set(12, date.getMinutes());
            NoDisturbSwitchView.this.f80811d.setText(NoDisturbSwitchView.this.getNoDisturbEndTime());
            NoDisturbSwitchView.this.k(false, false, (c6.b) null);
        }
    }

    public class c extends EasySubscriber<Object> {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ c6.b f80819b;

        public c(c6.b bVar) {
            this.f80819b = bVar;
        }

        public void onError2(Throwable th2) {
            super.onError2(th2);
            c6.b bVar = this.f80819b;
            if (bVar != null) {
                bVar.onCallback(Boolean.FALSE);
            }
        }

        public void onFailed(APIStatusErrorException aPIStatusErrorException) {
            super.onFailed(aPIStatusErrorException);
            c6.b bVar = this.f80819b;
            if (bVar != null) {
                bVar.onCallback(Boolean.FALSE);
            }
        }

        public void onNext(Object obj) {
            super.onNext(obj);
            c6.b bVar = this.f80819b;
            if (bVar != null) {
                bVar.onCallback(Boolean.TRUE);
            }
        }
    }

    public class d extends BaseSubscriber<NoDisturbData> {
        public d() {
        }

        /* renamed from: a */
        public void onNext(NoDisturbData noDisturbData) {
            super.onNext(noDisturbData);
            if (noDisturbData != null) {
                NoDisturbSwitchView.this.setViewData(noDisturbData);
                NoDisturbSwitchView.this.setVisibility(0);
            }
        }

        public void onError(Throwable th2) {
            super.onError(th2);
            NoDisturbSwitchView.this.setVisibility(8);
        }
    }

    public NoDisturbSwitchView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void j(boolean z11, Object obj) {
        int i11 = 0;
        if (!((Boolean) obj).booleanValue()) {
            this.f80813f.setChecked(!z11);
            LinearLayout linearLayout = this.f80809b;
            if (z11) {
                i11 = 8;
            }
            l(linearLayout, i11);
            return;
        }
        LinearLayout linearLayout2 = this.f80809b;
        if (!z11) {
            i11 = 8;
        }
        l(linearLayout2, i11);
    }

    /* access modifiers changed from: private */
    public void setViewData(NoDisturbData noDisturbData) {
        try {
            Date r11 = DateTimeUtils.r(noDisturbData.getStartTime(), "HH:mm");
            if (r11 != null) {
                this.f80815h.set(11, r11.getHours());
                this.f80815h.set(12, r11.getMinutes());
            }
            Date r12 = DateTimeUtils.r(noDisturbData.getEndTime(), "HH:mm");
            if (r12 != null) {
                this.f80816i.set(11, r12.getHours());
                this.f80816i.set(12, r12.getMinutes());
            }
            if (noDisturbData.getDisturbType() == 1) {
                this.f80813f.setChecked(true);
                l(this.f80809b, 0);
            } else {
                this.f80813f.setChecked(false);
                l(this.f80809b, 8);
            }
            this.f80813f.setOnCheckedChangeListener(this);
            this.f80810c.setText(getNoDisturbStartTime());
            this.f80811d.setText(getNoDisturbEndTime());
            i6.d.e("NoDisturbSwitchView", "startTime == " + this.f80815h.getTime() + " endTime == " + this.f80816i.getTime() + ", disturbType = " + noDisturbData.getDisturbType());
        } catch (Exception e11) {
            i6.d.d(Arrays.toString(e11.getStackTrace()));
        }
    }

    public final TimePickerView g(Calendar calendar, OnTimeSelectListener onTimeSelectListener) {
        return new TimePickerBuilder(getContext(), onTimeSelectListener).setType(new boolean[]{false, false, false, true, true, false}).setCancelText(getResources().getString(R.string.n_cancel)).setSubmitText(getResources().getString(R.string.n_sure)).setContentTextSize(getResources().getDimensionPixelSize(R.dimen.dimen_22)).setTitleSize(getResources().getDimensionPixelSize(R.dimen.dimen_22)).setBgColor(getResources().getColor(R.color.baseColorContentBackground)).setCancelColor(getResources().getColor(R.color.global_main_text_color)).setSubmitColor(getResources().getColor(R.color.global_main_text_color)).setDividerColor(getResources().getColor(R.color.global_divider_color)).setTextColorCenter(getResources().getColor(R.color.global_main_text_color)).setTextColorOut(getResources().getColor(R.color.baseColorSecondaryText)).setTitleBgColor(getResources().getColor(R.color.trade_dialog_safeguard_bg_color)).setOutSideCancelable(false).isCyclic(true).setDate(calendar).setLabel("", "", "", getResources().getString(R.string.n_notification_push_nodisturb_hour), getResources().getString(R.string.n_notification_push_nodisturb_minute), "").isCenterLabel(false).isDialog(false).build();
    }

    public String getNoDisturbEndTime() {
        Calendar calendar = this.f80816i;
        if (calendar == null) {
            return "";
        }
        try {
            return DateTimeUtils.A(calendar.getTimeInMillis());
        } catch (Exception e11) {
            i6.d.d(Arrays.toString(e11.getStackTrace()));
            return "";
        }
    }

    public String getNoDisturbStartTime() {
        Calendar calendar = this.f80815h;
        if (calendar == null) {
            return "";
        }
        try {
            return DateTimeUtils.A(calendar.getTimeInMillis());
        } catch (Exception e11) {
            i6.d.d(Arrays.toString(e11.getStackTrace()));
            return "";
        }
    }

    public final void h(Context context) {
        LayoutInflater.from(context).inflate(R.layout.layout_setting_notification_push_expand_list_item, this, true);
        if (this.f80814g == -1) {
            this.f80814g = getResources().getDimensionPixelOffset(R.dimen.dimen_100);
        }
        this.f80810c = (TextView) findViewById(R.id.tv_nodisturb_start_time_content);
        this.f80811d = (TextView) findViewById(R.id.tv_nodisturb_end_time_content);
        this.f80813f = (SwitchCompat) findViewById(R.id.push_timepicker_switch);
        this.f80812e = findViewById(R.id.setting_list_item_divider2);
        LinearLayout linearLayout = (LinearLayout) findViewById(R.id.rl_expand_area);
        this.f80809b = linearLayout;
        linearLayout.setZ(-20.0f);
        this.f80815h.set(11, 1);
        this.f80815h.set(12, 0);
        this.f80816i.set(11, 8);
        this.f80816i.set(12, 0);
        ((RelativeLayout) findViewById(R.id.rl_nodisturb_start_time)).setOnClickListener(this);
        ((RelativeLayout) findViewById(R.id.rl_nodisturb_end_time)).setOnClickListener(this);
        this.f80810c.setText(getNoDisturbStartTime());
        this.f80811d.setText(getNoDisturbEndTime());
        i();
    }

    public void i() {
        v7.b.a().getNoDisturb().b().compose(RxJavaHelper.t((g) null)).subscribe(new d());
    }

    public void k(boolean z11, boolean z12, c6.b bVar) {
        boolean z13 = !z11;
        try {
            String A = DateTimeUtils.A(this.f80815h.getTimeInMillis());
            String A2 = DateTimeUtils.A(this.f80816i.getTimeInMillis());
            String valueOf = String.valueOf(z13 ? 1 : 0);
            if (z12) {
                HashMap hashMap = new HashMap(4);
                hashMap.put("button", Integer.valueOf(z11 ^ true ? 1 : 0));
                hashMap.put("startTime", A);
                hashMap.put("endTime", A2);
                BaseModuleConfig.a().w("NMG_not_disturb", hashMap);
            }
            Log.d("NoDisturbSwitchView", "savePushNoDisturbSubscribe: startT=" + A + ",endT=" + A2 + ",dType=" + valueOf);
            v7.b.a().K(A, A2, valueOf).b().compose(RxJavaHelper.t((g) null)).subscribe(new c(bVar));
        } catch (Exception e11) {
            i6.d.d(Arrays.toString(e11.getStackTrace()));
        }
    }

    public final void l(View view, int i11) {
        if (i11 == 0) {
            this.f80812e.setVisibility(0);
            view.setVisibility(0);
            return;
        }
        this.f80812e.setVisibility(8);
        view.setVisibility(8);
    }

    @SensorsDataInstrumented
    public void onCheckedChanged(CompoundButton compoundButton, boolean z11) {
        k(!z11, true, new jr.c(this, z11));
        SensorsDataAutoTrackHelper.trackViewOnClick(compoundButton);
    }

    @SensorsDataInstrumented
    public void onClick(View view) {
        TimePickerView g11;
        if (view.getId() == R.id.rl_nodisturb_start_time) {
            TimePickerView g12 = g(this.f80815h, new a());
            if (g12 != null) {
                g12.show();
            }
        } else if (view.getId() == R.id.rl_nodisturb_end_time && (g11 = g(this.f80816i, new b())) != null) {
            g11.show();
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    public NoDisturbSwitchView(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        this.f80814g = -1;
        this.f80815h = Calendar.getInstance();
        this.f80816i = Calendar.getInstance();
        h(context);
    }
}
