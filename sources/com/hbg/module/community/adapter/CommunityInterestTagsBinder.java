package com.hbg.module.community.adapter;

import android.content.Context;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Checkable;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.lifecycle.MutableLiveData;
import com.hbg.lib.network.hbg.core.bean.CommunityFeedInfo;
import com.hbg.module.community.multiadapter.ItemViewBinder;
import com.hbg.module.content.R$attr;
import com.hbg.module.content.R$drawable;
import com.hbg.module.libkt.base.ext.RequestExtKt;
import com.hbg.module.libkt.base.ext.c;
import com.hbg.module.libkt.provider.HbgBaseProvider;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import lc.o3;
import rd.s;
import v7.b;

public final class CommunityInterestTagsBinder extends ItemViewBinder<CommunityFeedInfo.ListBean, ItemViewBinder.a<o3>> {

    /* renamed from: e  reason: collision with root package name */
    public HbgBaseProvider f17082e = ((HbgBaseProvider) b2.a.d().a("/provider/content").navigation());

    public static final class a implements View.OnClickListener {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ View f17083b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ long f17084c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ CommunityInterestTagsBinder f17085d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Context f17086e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ CommunityFeedInfo.InterestTag f17087f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ AppCompatTextView f17088g;

        public a(View view, long j11, CommunityInterestTagsBinder communityInterestTagsBinder, Context context, CommunityFeedInfo.InterestTag interestTag, AppCompatTextView appCompatTextView) {
            this.f17083b = view;
            this.f17084c = j11;
            this.f17085d = communityInterestTagsBinder;
            this.f17086e = context;
            this.f17087f = interestTag;
            this.f17088g = appCompatTextView;
        }

        @SensorsDataInstrumented
        public final void onClick(View view) {
            long currentTimeMillis = System.currentTimeMillis();
            s sVar = s.f23381a;
            if (currentTimeMillis - sVar.b(this.f17083b) > this.f17084c || (this.f17083b instanceof Checkable)) {
                sVar.e(this.f17083b, currentTimeMillis);
                AppCompatTextView appCompatTextView = (AppCompatTextView) this.f17083b;
                HbgBaseProvider q11 = this.f17085d.f17082e;
                boolean z11 = true;
                if (q11 == null || !q11.j(this.f17086e)) {
                    z11 = false;
                }
                if (z11) {
                    RequestExtKt.d(b.a().s0(this.f17087f.tagName), new CommunityInterestTagsBinder$addInterestTag$1$1(this.f17087f, this.f17086e, this.f17088g), CommunityInterestTagsBinder$addInterestTag$1$2.INSTANCE, (MutableLiveData) null, 4, (Object) null);
                }
            }
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }
    }

    public final AppCompatTextView r(Context context, CommunityFeedInfo.InterestTag interestTag) {
        Drawable drawable;
        AppCompatTextView appCompatTextView = new AppCompatTextView(context);
        appCompatTextView.setLayoutParams(new ViewGroup.LayoutParams(-2, c.d(Float.valueOf(40.0f))));
        appCompatTextView.setGravity(17);
        appCompatTextView.setCompoundDrawablePadding(c.d(Float.valueOf(14.0f)));
        if (interestTag.isSel) {
            drawable = com.hbg.module.libkt.base.ext.b.p(context, R$attr.tags_selected);
        } else {
            drawable = context.getResources().getDrawable(R$drawable.icon_interest_tag);
        }
        appCompatTextView.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, drawable, (Drawable) null);
        appCompatTextView.setPadding(c.d(Float.valueOf(12.0f)), 0, c.d(Float.valueOf(12.0f)), 0);
        appCompatTextView.setMaxLines(1);
        appCompatTextView.setEllipsize(TextUtils.TruncateAt.END);
        appCompatTextView.setText(interestTag.tagName);
        appCompatTextView.setTextColor(com.hbg.module.libkt.base.ext.b.o(context, R$attr.base_color_primary_text));
        appCompatTextView.setBackgroundColor(com.hbg.module.libkt.base.ext.b.o(context, R$attr.kline_index_setting_bg_color));
        appCompatTextView.setTypeface(Typeface.create("roboto_regular", 1));
        s sVar = s.f23381a;
        appCompatTextView.setOnClickListener(new a(appCompatTextView, 800, this, context, interestTag, appCompatTextView));
        return appCompatTextView;
    }

    /* renamed from: s */
    public void c(ItemViewBinder.a<o3> aVar, CommunityFeedInfo.ListBean listBean, boolean z11, int i11) {
        Context context = aVar.itemView.getContext();
        aVar.e().E.removeAllViews();
        if (!com.hbg.module.libkt.base.ext.b.w(listBean.getInterestTags())) {
            for (CommunityFeedInfo.InterestTag r11 : listBean.getInterestTags()) {
                aVar.e().E.addView(r(context, r11));
            }
        }
    }

    /* renamed from: t */
    public ItemViewBinder.a<o3> m(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        return new ItemViewBinder.a<>(o3.K(layoutInflater, viewGroup, false));
    }
}
