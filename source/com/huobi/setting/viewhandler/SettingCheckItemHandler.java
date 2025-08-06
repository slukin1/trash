package com.huobi.setting.viewhandler;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.TextView;
import androidx.appcompat.widget.SwitchCompat;
import com.huobi.login.usercenter.data.source.bean.KvStore;
import com.huobi.login.usercenter.data.source.remote.UserCenterRemoteDataSource;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import hr.a;
import i6.r;
import java.util.Map;
import pro.huobi.R;
import s9.c;

public class SettingCheckItemHandler implements c, View.OnClickListener, CompoundButton.OnCheckedChangeListener {
    /* renamed from: b */
    public void handleView(v9.c cVar, int i11, a aVar, ViewGroup viewGroup) {
        if (cVar != null && aVar != null) {
            r e11 = cVar.e();
            SwitchCompat switchCompat = (SwitchCompat) e11.b(R.id.quickly_withdraw_cb);
            TextView textView = (TextView) e11.b(R.id.id_setting_list_item_title);
            Map<String, String> B = UserCenterRemoteDataSource.A().B();
            switchCompat.setOnCheckedChangeListener((CompoundButton.OnCheckedChangeListener) null);
            if (B != null) {
                boolean z11 = B.get(KvStore.QUICK_WITHDRAW) != null && KvStore.Y.equals(B.get(KvStore.QUICK_WITHDRAW));
                if (switchCompat.isChecked() != z11) {
                    switchCompat.setChecked(z11);
                }
            }
            textView.setOnClickListener(this);
            switchCompat.setOnCheckedChangeListener(this);
            textView.setTag(aVar);
            switchCompat.setTag(aVar);
            d(textView, aVar);
            c(textView, aVar);
        }
    }

    public final void c(TextView textView, a aVar) {
        Resources resources = textView.getResources();
        int c11 = aVar.a() != null ? aVar.a().c(aVar.c()) : 0;
        Drawable drawable = c11 != 0 ? resources.getDrawable(c11) : null;
        if (drawable != null) {
            drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
        }
        textView.setCompoundDrawables((Drawable) null, (Drawable) null, drawable, (Drawable) null);
    }

    public final void d(TextView textView, a aVar) {
        if (textView != null && aVar != null && aVar.a() != null) {
            textView.setText(aVar.a().a(aVar.c()));
        }
    }

    public int getResId() {
        return R.layout.layout_setting_check_list_item;
    }

    @SensorsDataInstrumented
    public void onCheckedChanged(CompoundButton compoundButton, boolean z11) {
        a aVar = (a) compoundButton.getTag();
        if (!(compoundButton.getId() != R.id.quickly_withdraw_cb || aVar == null || aVar.a() == null)) {
            aVar.a().d(aVar.c(), compoundButton.isChecked());
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(compoundButton);
    }

    @SensorsDataInstrumented
    public void onClick(View view) {
        a aVar = (a) view.getTag();
        if (!(view.getId() != R.id.id_setting_list_item_title || aVar == null || aVar.a() == null)) {
            aVar.a().b(aVar.c());
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }
}
