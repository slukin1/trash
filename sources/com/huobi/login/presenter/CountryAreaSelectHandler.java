package com.huobi.login.presenter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.hbg.lib.core.util.AppLanguageHelper;
import com.hbg.lib.core.util.NightHelper;
import com.huobi.login.usercenter.data.source.bean.CountryListData;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import i6.r;
import nn.a;
import pro.huobi.R;
import s9.c;
import sn.w;

public class CountryAreaSelectHandler implements c {
    @SensorsDataInstrumented
    public static /* synthetic */ void d(v9.c cVar, TextView textView, CountryListData countryListData, View view) {
        Context context = cVar.itemView.getContext();
        Intent intent = new Intent();
        intent.putExtra("country_name", textView.getText().toString());
        intent.putExtra("country_name_cn", countryListData.d());
        intent.putExtra("country_name_en", countryListData.e());
        intent.putExtra("phone_area_code", countryListData.a());
        intent.putExtra("country_area_code", String.valueOf(countryListData.c()));
        Activity activity = (Activity) context;
        activity.setResult(-1, intent);
        activity.finish();
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* renamed from: c */
    public void handleView(v9.c cVar, int i11, CountryListData countryListData, ViewGroup viewGroup) {
        r e11 = cVar.e();
        TextView textView = (TextView) e11.b(R.id.area);
        TextView textView2 = (TextView) e11.b(R.id.area_code);
        if (AppLanguageHelper.getInstance().isChineseLanguage()) {
            textView.setText(countryListData.d());
        } else if (!TextUtils.isEmpty(countryListData.f())) {
            textView.setText(countryListData.f());
        } else {
            textView.setText(countryListData.e());
        }
        textView2.setText(countryListData.a().replace("00", "+"));
        ImageView imageView = (ImageView) e11.b(R.id.iv_country_icon);
        if (countryListData.g()) {
            imageView.setVisibility(0);
            f6.c.a().l(imageView.getContext(), w.e(String.valueOf(countryListData.c())), imageView, NightHelper.e().g() ? R.drawable.flag_default_night : R.drawable.flag_default);
        } else {
            imageView.setVisibility(4);
        }
        cVar.itemView.setOnClickListener(new a(cVar, textView, countryListData));
    }

    public int getResId() {
        return R.layout.content_areacode_item;
    }
}
