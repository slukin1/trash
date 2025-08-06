package com.huobi.index.viewhandler;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Checkable;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.lifecycle.MutableLiveData;
import com.hbg.module.community.view.FlowLayout;
import com.hbg.module.libkt.base.ext.RequestExtKt;
import com.hbg.module.libkt.provider.HbgBaseProvider;
import com.huobi.index.bean.HomeFeedInfoItem;
import com.huobi.index.bean.IndexContract;
import com.huobi.utils.HomeSensorsHelper;
import com.huobi.view.roundview.RoundTextView;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import gs.g;
import i6.r;
import java.util.ArrayList;
import java.util.Iterator;
import pro.huobi.R;
import rd.s;
import s9.c;
import v7.b;

public final class RecommendTagHandler implements c {

    /* renamed from: b  reason: collision with root package name */
    public HbgBaseProvider f74422b = ((HbgBaseProvider) b2.a.d().a("/provider/content").navigation());

    public static final class a implements View.OnClickListener {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ View f74423b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ long f74424c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ IndexContract.ElemsDTO f74425d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ RecommendTagHandler f74426e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ Context f74427f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ RoundTextView f74428g;

        public a(View view, long j11, IndexContract.ElemsDTO elemsDTO, RecommendTagHandler recommendTagHandler, Context context, RoundTextView roundTextView) {
            this.f74423b = view;
            this.f74424c = j11;
            this.f74425d = elemsDTO;
            this.f74426e = recommendTagHandler;
            this.f74427f = context;
            this.f74428g = roundTextView;
        }

        @SensorsDataInstrumented
        public final void onClick(View view) {
            long currentTimeMillis = System.currentTimeMillis();
            s sVar = s.f23381a;
            if (currentTimeMillis - sVar.b(this.f74423b) > this.f74424c || (this.f74423b instanceof Checkable)) {
                sVar.e(this.f74423b, currentTimeMillis);
                RoundTextView roundTextView = (RoundTextView) this.f74423b;
                g.g("app_recome_content_click", HomeSensorsHelper.d(0, this.f74425d.b(), this.f74425d.a(), "tag", 1, (String) null, 500));
                HbgBaseProvider b11 = this.f74426e.f74422b;
                boolean z11 = true;
                if (b11 == null || !b11.j(this.f74427f)) {
                    z11 = false;
                }
                if (z11) {
                    RequestExtKt.d(b.a().s0(this.f74425d.a()), new RecommendTagHandler$addInterestTag$1$1(this.f74425d, this.f74427f, this.f74428g), RecommendTagHandler$addInterestTag$1$2.INSTANCE, (MutableLiveData) null, 4, (Object) null);
                }
            }
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }
    }

    public final AppCompatTextView c(Context context, IndexContract.ElemsDTO elemsDTO) {
        Drawable drawable;
        RoundTextView roundTextView = new RoundTextView(context);
        roundTextView.setLayoutParams(new ViewGroup.LayoutParams(-2, com.hbg.module.libkt.base.ext.c.d(Float.valueOf(40.0f))));
        roundTextView.getDelegate().setCornerRadius(2);
        roundTextView.getDelegate().setBackgroundColor(com.hbg.module.libkt.base.ext.b.o(context, R.attr.kline_index_setting_bg_color));
        roundTextView.setGravity(17);
        roundTextView.setCompoundDrawablePadding(com.hbg.module.libkt.base.ext.c.d(Float.valueOf(14.0f)));
        if (elemsDTO.f73180c) {
            drawable = com.hbg.module.libkt.base.ext.b.p(context, R.attr.tags_selected);
        } else {
            drawable = context.getResources().getDrawable(R.drawable.icon_interest_tag);
        }
        roundTextView.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, drawable, (Drawable) null);
        roundTextView.setPadding(com.hbg.module.libkt.base.ext.c.d(Float.valueOf(12.0f)), 0, com.hbg.module.libkt.base.ext.c.d(Float.valueOf(12.0f)), 0);
        roundTextView.setMaxLines(1);
        roundTextView.setEllipsize(TextUtils.TruncateAt.END);
        roundTextView.setText(elemsDTO.a());
        roundTextView.setTextColor(com.hbg.module.libkt.base.ext.b.o(context, R.attr.base_color_primary_text));
        roundTextView.setTypeface(Typeface.create("roboto_regular", 1));
        s sVar = s.f23381a;
        roundTextView.setOnClickListener(new a(roundTextView, 800, elemsDTO, this, context, roundTextView));
        return roundTextView;
    }

    @SuppressLint({"SetTextI18n"})
    /* renamed from: d */
    public void handleView(v9.c cVar, int i11, HomeFeedInfoItem homeFeedInfoItem, ViewGroup viewGroup) {
        IndexContract indexContract;
        ArrayList<IndexContract.ElemsDTO> elems;
        r e11 = cVar.e();
        View b11 = e11.b(R.id.llRootView);
        FlowLayout flowLayout = (FlowLayout) e11.b(R.id.tlTags);
        View b12 = e11.b(R.id.lineView);
        Context context = flowLayout.getContext();
        b11.setBackgroundResource(R.color.baseColorContentBackground);
        b12.setVisibility(8);
        if (homeFeedInfoItem != null && (indexContract = homeFeedInfoItem.f73164o) != null && (elems = indexContract.getElems()) != null && !com.hbg.module.libkt.base.ext.b.w(elems)) {
            Iterator<IndexContract.ElemsDTO> it2 = elems.iterator();
            while (it2.hasNext()) {
                flowLayout.addView(c(context, it2.next()));
            }
        }
    }

    public int getResId() {
        return R.layout.item_community_interest_tag;
    }
}
