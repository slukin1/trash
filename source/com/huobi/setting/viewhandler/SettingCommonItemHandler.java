package com.huobi.setting.viewhandler;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.TextView;
import androidx.appcompat.widget.SwitchCompat;
import com.hbg.lib.common.utils.ViewUtil;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import hr.b;
import i6.r;
import pro.huobi.R;
import s9.c;

public class SettingCommonItemHandler implements c, View.OnClickListener, CompoundButton.OnCheckedChangeListener {
    /* renamed from: b */
    public void handleView(v9.c cVar, int i11, b bVar, ViewGroup viewGroup) {
        if (cVar != null && bVar != null) {
            r e11 = cVar.e();
            SwitchCompat switchCompat = (SwitchCompat) e11.b(R.id.quickly_withdraw_cb);
            TextView textView = (TextView) e11.b(R.id.id_setting_list_item_title);
            View b11 = e11.b(R.id.setting_list_item_divider);
            switchCompat.setOnCheckedChangeListener((CompoundButton.OnCheckedChangeListener) null);
            switchCompat.setChecked(bVar.a().s(bVar.c()));
            textView.setOnClickListener(this);
            switchCompat.setOnCheckedChangeListener(this);
            ViewUtil.m(b11, bVar.d());
            textView.setTag(bVar);
            switchCompat.setTag(bVar);
            d(textView, bVar);
            c(textView, bVar);
        }
    }

    public final void c(TextView textView, b bVar) {
        Resources resources = textView.getResources();
        int c11 = bVar.a() != null ? bVar.a().c(bVar.c()) : 0;
        Drawable drawable = c11 != 0 ? resources.getDrawable(c11) : null;
        if (drawable != null) {
            drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
        }
        textView.setCompoundDrawables((Drawable) null, (Drawable) null, drawable, (Drawable) null);
    }

    public final void d(TextView textView, b bVar) {
        if (textView != null && bVar != null && bVar.a() != null) {
            textView.setText(bVar.a().a(bVar.c()));
        }
    }

    public int getResId() {
        return R.layout.layout_setting_check_list_item;
    }

    @SensorsDataInstrumented
    public void onCheckedChanged(CompoundButton compoundButton, boolean z11) {
        b bVar = (b) compoundButton.getTag();
        if (!(compoundButton.getId() != R.id.quickly_withdraw_cb || bVar == null || bVar.a() == null)) {
            bVar.a().d(bVar.c(), compoundButton.isChecked());
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(compoundButton);
    }

    @SensorsDataInstrumented
    public void onClick(View view) {
        b bVar = (b) view.getTag();
        if (!(view.getId() != R.id.id_setting_list_item_title || bVar == null || bVar.a() == null)) {
            bVar.a().b(bVar.c());
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }
}
