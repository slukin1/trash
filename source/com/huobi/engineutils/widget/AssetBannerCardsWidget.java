package com.huobi.engineutils.widget;

import al.p;
import android.content.Context;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.blankj.utilcode.util.h;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.hbg.lib.core.BaseModuleConfig;
import com.hbg.module.asset.AssetModuleConfig;
import com.hbg.module.asset.R$color;
import com.hbg.module.asset.R$id;
import com.hbg.module.asset.R$layout;
import com.huobi.edgeengine.template.widget.Widget;
import com.huobi.engineutils.bean.AssetBannerCardData;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import com.youth.banner.Banner;
import com.youth.banner.adapter.BannerAdapter;
import i6.d;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import jk.l;
import jk.m;
import rj.n;

public class AssetBannerCardsWidget extends Widget {

    /* renamed from: h0  reason: collision with root package name */
    public Banner<AssetBannerCardData, BannerAdapter<AssetBannerCardData, c>> f44565h0;

    /* renamed from: i0  reason: collision with root package name */
    public BannerAdapter<AssetBannerCardData, c> f44566i0;

    /* renamed from: j0  reason: collision with root package name */
    public ArrayList<AssetBannerCardData> f44567j0 = new ArrayList<>();

    /* renamed from: k0  reason: collision with root package name */
    public String f44568k0;

    public class a extends BannerAdapter<AssetBannerCardData, c> {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ Context f44569b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(List list, Context context) {
            super(list);
            this.f44569b = context;
        }

        @SensorsDataInstrumented
        public static /* synthetic */ void e(AssetBannerCardData assetBannerCardData, View view) {
            if (!TextUtils.isEmpty(assetBannerCardData.getJumpUrl())) {
                if (assetBannerCardData.getType() == 3) {
                    BaseModuleConfig.a().w("app_assets_product_recommendation_click", (HashMap) null);
                }
                AssetModuleConfig.a().m(assetBannerCardData.getJumpUrl());
            }
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }

        /* renamed from: f */
        public void onBindView(c cVar, AssetBannerCardData assetBannerCardData, int i11, int i12) {
            if (assetBannerCardData.getType() == 2) {
                String leftInfo = assetBannerCardData.getLeftInfo();
                String title = assetBannerCardData.getTitle();
                f6.c.a().f(cVar.f44572a, p.l(leftInfo), p.m());
                cVar.f44574c.setVisibility(0);
                cVar.f44573b.setVisibility(8);
                cVar.f44574c.setText(leftInfo);
                cVar.f44575d.setText(title);
                cVar.f44576e.setText(assetBannerCardData.getDesc());
                cVar.f44577f.setVisibility(0);
                cVar.f44577f.setText(assetBannerCardData.getRightInfo());
            } else {
                if (assetBannerCardData.getType() == 3) {
                    BaseModuleConfig.a().w("app_assets_product_recommendation_show", (HashMap) null);
                }
                if (assetBannerCardData.getDisplayIconList() != null && assetBannerCardData.getDisplayIconList().size() > 0) {
                    f6.c.a().f(cVar.f44572a, assetBannerCardData.getDisplayIconList().get(0), p.m());
                }
                if (assetBannerCardData.getDisplayIconList() == null || assetBannerCardData.getDisplayIconList().size() <= 1) {
                    cVar.f44573b.setVisibility(8);
                } else {
                    cVar.f44573b.setVisibility(0);
                    f6.c.a().f(cVar.f44573b, assetBannerCardData.getDisplayIconList().get(1), p.m());
                }
                cVar.f44574c.setVisibility(8);
                if (TextUtils.isEmpty(assetBannerCardData.getDisplayLeftName())) {
                    cVar.f44575d.setText("");
                } else if (assetBannerCardData.getMatchLeftList() != null) {
                    try {
                        AssetBannerCardsWidget.this.a0(cVar.f44575d, assetBannerCardData.getDisplayLeftName(), assetBannerCardData.getMatchLeftList());
                    } catch (Exception e11) {
                        d.g(e11);
                    }
                } else {
                    cVar.f44575d.setText(assetBannerCardData.getDisplayLeftName());
                }
                cVar.f44577f.setVisibility(8);
                if (TextUtils.isEmpty(assetBannerCardData.getDisplayRightName())) {
                    cVar.f44576e.setText("");
                } else if (assetBannerCardData.getMatchRightList() != null) {
                    try {
                        AssetBannerCardsWidget.this.a0(cVar.f44576e, assetBannerCardData.getDisplayRightName(), assetBannerCardData.getMatchRightList());
                    } catch (Exception e12) {
                        d.g(e12);
                    }
                } else {
                    cVar.f44576e.setText(assetBannerCardData.getDisplayRightName());
                }
            }
            cVar.itemView.setOnClickListener(new m(assetBannerCardData));
        }

        /* renamed from: g */
        public c onCreateHolder(ViewGroup viewGroup, int i11) {
            return new c(LayoutInflater.from(this.f44569b).inflate(R$layout.item_asset_banner_card, (ViewGroup) null));
        }
    }

    public class b extends TypeToken<List<AssetBannerCardData>> {
        public b() {
        }
    }

    public static class c extends RecyclerView.ViewHolder {

        /* renamed from: a  reason: collision with root package name */
        public ImageView f44572a;

        /* renamed from: b  reason: collision with root package name */
        public ImageView f44573b;

        /* renamed from: c  reason: collision with root package name */
        public TextView f44574c;

        /* renamed from: d  reason: collision with root package name */
        public TextView f44575d;

        /* renamed from: e  reason: collision with root package name */
        public TextView f44576e;

        /* renamed from: f  reason: collision with root package name */
        public TextView f44577f;

        public c(View view) {
            super(view);
            view.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
            this.f44572a = (ImageView) view.findViewById(R$id.banner_card_image_icon);
            this.f44573b = (ImageView) view.findViewById(R$id.banner_card_image_icon_2);
            this.f44574c = (TextView) view.findViewById(R$id.banner_card_icon_left_info);
            this.f44575d = (TextView) view.findViewById(R$id.banner_card_title);
            this.f44576e = (TextView) view.findViewById(R$id.banner_card_icon_des);
            this.f44577f = (TextView) view.findViewById(R$id.banner_card_icon_right_info);
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void Z(String str) {
        ArrayList<AssetBannerCardData> arrayList = (ArrayList) new Gson().fromJson(str, new b().getType());
        this.f44567j0 = arrayList;
        this.f44565h0.setDatas(arrayList);
        Log.e("handleData", str);
    }

    public void C(Context context, Map<String, String> map) {
        super.C(context, map);
        this.f44568k0 = map.get("banners");
    }

    public View Q(Context context, n nVar) {
        View Q = super.Q(context, nVar);
        w(context, this.f44568k0, new l(this), nVar);
        return Q;
    }

    public final void a0(TextView textView, String str, List<String> list) {
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(str);
        for (int i11 = 0; i11 < list.size(); i11++) {
            int indexOf = spannableStringBuilder.toString().indexOf("{");
            spannableStringBuilder.replace(indexOf, spannableStringBuilder.toString().indexOf("}") + 1, list.get(i11));
            spannableStringBuilder.setSpan(new ForegroundColorSpan(h.a(R$color.kColorPriceGreen)), indexOf, list.get(i11).length() + indexOf, 17);
        }
        textView.setText(spannableStringBuilder);
    }

    public View q(Context context) {
        View inflate = LayoutInflater.from(context).inflate(R$layout.asset_banner_cards_widget_layout, (ViewGroup) null);
        this.f44565h0 = (Banner) inflate.findViewById(R$id.card_banners);
        a aVar = new a(this.f44567j0, context);
        this.f44566i0 = aVar;
        this.f44565h0.setAdapter(aVar);
        this.f44565h0.setOrientation(1);
        this.f44565h0.setLoopTime(5000);
        return inflate;
    }
}
