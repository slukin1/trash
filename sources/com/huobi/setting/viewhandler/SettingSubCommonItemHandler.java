package com.huobi.setting.viewhandler;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.TextView;
import androidx.appcompat.widget.SwitchCompat;
import com.hbg.lib.common.utils.ViewUtil;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import hr.f;
import i6.r;
import pro.huobi.R;
import s9.c;

public class SettingSubCommonItemHandler implements c, View.OnClickListener, CompoundButton.OnCheckedChangeListener {
    /* renamed from: b */
    public void handleView(v9.c cVar, int i11, f fVar, ViewGroup viewGroup) {
        if (cVar != null && fVar != null) {
            r e11 = cVar.e();
            SwitchCompat switchCompat = (SwitchCompat) e11.b(R.id.quickly_withdraw_cb);
            TextView textView = (TextView) e11.b(R.id.id_setting_list_item_title);
            TextView textView2 = (TextView) e11.b(R.id.id_setting_list_item_sub_title);
            View b11 = e11.b(R.id.setting_list_item_divider);
            switchCompat.setOnCheckedChangeListener((CompoundButton.OnCheckedChangeListener) null);
            boolean s11 = fVar.a().s(fVar.c());
            if (s11 != switchCompat.isChecked()) {
                switchCompat.setChecked(s11);
            }
            textView.setOnClickListener(this);
            switchCompat.setOnCheckedChangeListener(this);
            ViewUtil.m(b11, fVar.d());
            String g11 = fVar.a().g(fVar.c());
            if (!TextUtils.isEmpty(g11)) {
                textView2.setText(g11);
            }
            textView.setTag(fVar);
            switchCompat.setTag(fVar);
            d(textView, fVar);
            c(textView, fVar);
        }
    }

    public final void c(TextView textView, f fVar) {
        Resources resources = textView.getResources();
        int c11 = fVar.a() != null ? fVar.a().c(fVar.c()) : 0;
        Drawable drawable = c11 != 0 ? resources.getDrawable(c11) : null;
        if (drawable != null) {
            drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
        }
        textView.setCompoundDrawables((Drawable) null, (Drawable) null, drawable, (Drawable) null);
    }

    public final void d(TextView textView, f fVar) {
        if (textView != null && fVar != null && fVar.a() != null) {
            textView.setText(fVar.a().a(fVar.c()));
        }
    }

    public int getResId() {
        return R.layout.layout_sub_setting_check_list_item;
    }

    @SensorsDataInstrumented
    public void onCheckedChanged(CompoundButton compoundButton, boolean z11) {
        f fVar = (f) compoundButton.getTag();
        if (!(compoundButton.getId() != R.id.quickly_withdraw_cb || fVar == null || fVar.a() == null)) {
            fVar.a().d(fVar.c(), compoundButton.isChecked());
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(compoundButton);
    }

    @SensorsDataInstrumented
    public void onClick(View view) {
        f fVar = (f) view.getTag();
        if (!(view.getId() != R.id.id_setting_list_item_title || fVar == null || fVar.a() == null)) {
            fVar.a().b(fVar.c());
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }
}
