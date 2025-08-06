package com.huobi.kyc.binder;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.hbg.lib.core.util.AppLanguageHelper;
import com.hbg.lib.core.util.NightHelper;
import com.hbg.lib.network.newkyc.bean.KycCountryInfo;
import com.hbg.module.community.multiadapter.ItemViewBinder;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import f6.c;
import pro.huobi.R;
import sn.w;

public class KycCountryBinder extends ItemViewBinder<KycCountryInfo, a> {

    public static class a extends RecyclerView.ViewHolder {

        /* renamed from: a  reason: collision with root package name */
        public ImageView f74778a;

        /* renamed from: b  reason: collision with root package name */
        public TextView f74779b;

        public a(View view) {
            super(view);
            this.f74778a = (ImageView) view.findViewById(R.id.countryIcon);
            this.f74779b = (TextView) view.findViewById(R.id.countryName);
        }
    }

    @SensorsDataInstrumented
    public static /* synthetic */ void r(KycCountryInfo kycCountryInfo, Context context, View view) {
        Intent intent = new Intent();
        intent.putExtra("country_info", kycCountryInfo);
        Activity activity = (Activity) context;
        activity.setResult(-1, intent);
        activity.finish();
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* renamed from: s */
    public void c(a aVar, KycCountryInfo kycCountryInfo, boolean z11, int i11) {
        Context context = aVar.itemView.getContext();
        if (context != null) {
            if (AppLanguageHelper.getInstance().isChineseLanguage()) {
                aVar.f74779b.setText(kycCountryInfo.getNameCn());
                kycCountryInfo.setCountryName(kycCountryInfo.getNameCn());
            } else {
                aVar.f74779b.setText(kycCountryInfo.getNameEn());
                kycCountryInfo.setCountryName(kycCountryInfo.getNameEn());
            }
            if (i11 % 2 == 0) {
                aVar.itemView.setBackgroundColor(context.getResources().getColor(R.color.global_item_bg));
            } else {
                aVar.itemView.setBackgroundColor(context.getResources().getColor(R.color.kyc_nationality_list_item_odd));
            }
            String e11 = w.e(String.valueOf(kycCountryInfo.getCountryId()));
            kycCountryInfo.setFlagUrl(e11);
            c.a().l(aVar.itemView.getContext(), e11, aVar.f74778a, NightHelper.e().g() ? R.drawable.flag_default_night : R.drawable.flag_default);
            aVar.itemView.setOnClickListener(new qm.a(kycCountryInfo, context));
        }
    }

    /* renamed from: t */
    public a m(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        return new a(layoutInflater.inflate(R.layout.kyc_country_item, viewGroup, false));
    }
}
