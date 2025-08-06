package com.huobi.index.viewhandler;

import android.content.Context;
import android.graphics.Color;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentActivity;
import cn.sharesdk.framework.InnerShareParams;
import com.hbg.lib.common.glide.SvgSoftwareLayerSetter;
import com.hbg.lib.common.utils.PixelUtils;
import com.hbg.lib.common.utils.SP;
import com.hbg.lib.core.util.NightHelper;
import com.hbg.lib.network.hbg.core.bean.HomePageBizData;
import com.huobi.index.bean.IndexBizData;
import com.huobi.index.bean.IndexFeatureItem;
import com.huobi.index.countdown.RecommendedCountDownLayout;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import gs.g;
import i6.r;
import java.util.HashMap;
import pro.huobi.R;
import s9.c;
import yl.o;

public class IndexBizItemHandler implements c {

    /* renamed from: b  reason: collision with root package name */
    public TextView f74099b;

    /* renamed from: c  reason: collision with root package name */
    public ImageView f74100c;

    /* renamed from: d  reason: collision with root package name */
    public ImageView f74101d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f74102e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f74103f;

    /* renamed from: g  reason: collision with root package name */
    public ImageView f74104g;

    /* renamed from: h  reason: collision with root package name */
    public ImageView f74105h;

    /* renamed from: i  reason: collision with root package name */
    public ImageView f74106i;

    /* renamed from: j  reason: collision with root package name */
    public ImageView f74107j;

    /* renamed from: k  reason: collision with root package name */
    public TextView f74108k;

    /* renamed from: l  reason: collision with root package name */
    public RecommendedCountDownLayout f74109l;

    public class a implements it.a {
        public a() {
        }

        public void b(int i11, long j11, long[] jArr) {
        }

        public void c(int i11) {
            IndexBizItemHandler.this.f74109l.setCountDownCallback((it.a) null);
            IndexBizItemHandler.this.f74109l.setVisibility(8);
            IndexBizItemHandler.this.f74102e.setVisibility(0);
        }
    }

    @SensorsDataInstrumented
    public static /* synthetic */ void g(HomePageBizData homePageBizData, Context context, int i11, View view) {
        IndexFeatureItem F = o.F(homePageBizData.getUrl());
        if (F != null && (context instanceof FragmentActivity)) {
            o.p((FragmentActivity) context, F);
        }
        HashMap hashMap = new HashMap();
        hashMap.put(InnerShareParams.SITE, Integer.valueOf(i11 + 1));
        hashMap.put("type", homePageBizData.getName());
        hashMap.put("material_id", Integer.valueOf(homePageBizData.getMaterialId()));
        hashMap.put("reserve_byte1", homePageBizData.getExtension());
        hashMap.put("reserve_byte2", homePageBizData.getExtensionText());
        hashMap.put("testKey", SP.i("key_home_page_layout_type", "A"));
        g.i("tofu_click", hashMap);
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    public final void e(int i11, IndexBizData indexBizData) {
        this.f74109l.getCountDownManager().u(i11, indexBizData.getTimeData(), true);
        this.f74102e.setVisibility(4);
        this.f74109l.setValid(true);
        this.f74109l.setVisibility(0);
        this.f74109l.setCountDownCallback(new a());
    }

    /* renamed from: f */
    public void handleView(v9.c cVar, int i11, IndexBizData indexBizData, ViewGroup viewGroup) {
        r e11 = cVar.e();
        Context context = cVar.itemView.getContext();
        View b11 = e11.b(R.id.item_recommended_layout);
        this.f74099b = (TextView) e11.b(R.id.item_recommended_title);
        this.f74100c = (ImageView) e11.b(R.id.item_recommended_title_tips);
        this.f74101d = (ImageView) e11.b(R.id.iv_cover);
        this.f74102e = (TextView) e11.b(R.id.item_recommended_sub_title);
        this.f74103f = (TextView) e11.b(R.id.item_recommended_content);
        this.f74104g = (ImageView) e11.b(R.id.iv_recommended_arrow);
        this.f74105h = (ImageView) e11.b(R.id.item_recommended_image_bg);
        this.f74106i = (ImageView) e11.b(R.id.item_recommended_image_front);
        this.f74107j = (ImageView) e11.b(R.id.item_recommended_image);
        this.f74108k = (TextView) e11.b(R.id.item_recommended_name_tag);
        this.f74109l = (RecommendedCountDownLayout) e11.b(R.id.item_time_view);
        if (indexBizData.getData() != null) {
            HomePageBizData data = indexBizData.getData();
            boolean g11 = NightHelper.e().g();
            this.f74099b.setText(data.getTitle());
            this.f74099b.setTextColor(g11 ? ContextCompat.getColor(context, R.color.color_808799) : ContextCompat.getColor(context, R.color.color_909090));
            this.f74102e.setVisibility(0);
            this.f74102e.setText(data.getFocusContent());
            this.f74102e.setTextColor(Color.parseColor(g11 ? "#F0F1F4" : "#14181F"));
            this.f74102e.setMaxLines(1);
            HomePageBizData.Summary summary = data.getSummary();
            if (summary != null) {
                this.f74103f.setText(summary.getContent());
            } else {
                this.f74103f.setText(" ");
            }
            this.f74103f.setTextColor(g11 ? ContextCompat.getColor(context, R.color.color_808799) : ContextCompat.getColor(context, R.color.color_909090));
            this.f74103f.setVisibility(0);
            this.f74101d.setVisibility(8);
            this.f74104g.setVisibility(8);
            this.f74109l.setValid(false);
            this.f74109l.setCountDownCallback((it.a) null);
            this.f74109l.setVisibility(8);
            switch (data.getStyle()) {
                case 2:
                    this.f74103f.setTextColor(ContextCompat.getColor(context, R.color.color_0066ED));
                    if (!TextUtils.isEmpty(this.f74103f.getText())) {
                        this.f74104g.setVisibility(0);
                        break;
                    }
                    break;
                case 3:
                    this.f74103f.setVisibility(4);
                    break;
                case 4:
                    this.f74102e.setMaxLines(2);
                    this.f74103f.setVisibility(4);
                    break;
                case 5:
                    e(i11, indexBizData);
                    break;
                case 6:
                    e(i11, indexBizData);
                    TextView textView = this.f74103f;
                    textView.setTextColor(ContextCompat.getColor(textView.getContext(), R.color.color_0066ED));
                    if (!TextUtils.isEmpty(this.f74103f.getText())) {
                        this.f74104g.setVisibility(0);
                        break;
                    }
                    break;
                case 7:
                    this.f74101d.setVisibility(0);
                    this.f74101d.setScaleType(ImageView.ScaleType.CENTER_CROP);
                    h(context, this.f74101d, data.getImageUrl(), false);
                    break;
            }
            h(context, this.f74100c, data.getTagUrl(), false);
            h(context, this.f74105h, data.getBgImageUrl(), false);
            h(context, this.f74107j, data.getImageUrl(), true);
            h(context, this.f74106i, data.getFrontImageUrl(), false);
            if (!TextUtils.isEmpty(data.getIconLabel())) {
                this.f74108k.setVisibility(0);
                this.f74108k.setText(data.getIconLabel());
            } else {
                this.f74108k.setVisibility(8);
            }
            b11.setOnClickListener(new b(data, context, i11));
        }
    }

    public int getResId() {
        return R.layout.layout_index_recommended_item;
    }

    public final void h(Context context, ImageView imageView, String str, boolean z11) {
        if (!TextUtils.isEmpty(str)) {
            imageView.setVisibility(0);
            if (str.endsWith("svg")) {
                if (z11) {
                    f6.c.a().n(context, str, imageView, (SvgSoftwareLayerSetter) null);
                    return;
                }
                f6.c.a().o(context, str, imageView, PixelUtils.a(2.0f), (SvgSoftwareLayerSetter) null);
            } else if (str.endsWith("gif")) {
                if (z11) {
                    f6.c.a().c(imageView, str);
                } else {
                    f6.c.a().d(imageView, str, PixelUtils.a(2.0f));
                }
            } else if (z11) {
                f6.c.a().i(imageView, str);
            } else {
                f6.c.a().k(imageView, str, PixelUtils.a(2.0f));
            }
        } else {
            imageView.setVisibility(4);
        }
    }
}
