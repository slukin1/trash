package com.hbg.module.community.widgets;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Checkable;
import android.widget.TextView;
import com.alibaba.android.arouter.facade.Postcard;
import com.hbg.lib.network.hbg.core.bean.CommunityFeedInfo;
import com.hbg.module.content.R$dimen;
import com.hbg.module.content.R$drawable;
import com.hbg.module.content.R$id;
import com.hbg.module.content.R$layout;
import com.hbg.module.libkt.base.ext.b;
import com.huobi.view.roundimg.RoundedImageView;
import com.huobi.view.roundview.RoundLinearLayout;
import com.huochat.community.widget.expandable.ExpandableTextView;
import com.huochat.community.widget.expandable.StatusType;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import d10.l;
import d10.p;
import java.util.ArrayList;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.internal.r;
import rd.s;

public final class CommunityChildLayout extends RoundLinearLayout {

    /* renamed from: b  reason: collision with root package name */
    public CommunityFeedInfo.ListBean.ParentDynamic f17629b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f17630c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f17631d;

    /* renamed from: e  reason: collision with root package name */
    public ExpandableTextView f17632e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f17633f;

    /* renamed from: g  reason: collision with root package name */
    public ExpandableTextView f17634g;

    /* renamed from: h  reason: collision with root package name */
    public RoundedImageView f17635h;

    /* renamed from: i  reason: collision with root package name */
    public CommunityImageLayout f17636i;

    /* renamed from: j  reason: collision with root package name */
    public View f17637j;

    /* renamed from: k  reason: collision with root package name */
    public l<? super String, Unit> f17638k;

    /* renamed from: l  reason: collision with root package name */
    public p<? super Integer, ? super List<? extends CommunityFeedInfo.imgListBean>, Unit> f17639l;

    public static final class a implements View.OnClickListener {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ View f17640b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ long f17641c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ CommunityChildLayout f17642d;

        public a(View view, long j11, CommunityChildLayout communityChildLayout) {
            this.f17640b = view;
            this.f17641c = j11;
            this.f17642d = communityChildLayout;
        }

        @SensorsDataInstrumented
        public final void onClick(View view) {
            String uidUnique;
            l<String, Unit> onClickCommunityHeader;
            long currentTimeMillis = System.currentTimeMillis();
            s sVar = s.f23381a;
            if (currentTimeMillis - sVar.b(this.f17640b) > this.f17641c || (this.f17640b instanceof Checkable)) {
                sVar.e(this.f17640b, currentTimeMillis);
                RoundedImageView roundedImageView = (RoundedImageView) this.f17640b;
                CommunityFeedInfo.ListBean.ParentDynamic data = this.f17642d.getData();
                if (!(data == null || (uidUnique = data.getUidUnique()) == null || (onClickCommunityHeader = this.f17642d.getOnClickCommunityHeader()) == null)) {
                    onClickCommunityHeader.invoke(uidUnique);
                }
            }
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }
    }

    public CommunityChildLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, (r) null);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ CommunityChildLayout(Context context, AttributeSet attributeSet, int i11, int i12, r rVar) {
        this(context, (i12 & 2) != 0 ? null : attributeSet, (i12 & 4) != 0 ? 0 : i11);
    }

    public static final void d(CommunityChildLayout communityChildLayout, StatusType statusType) {
        Postcard a11 = b2.a.d().a("/content/DynamicDetail");
        CommunityFeedInfo.ListBean.ParentDynamic parentDynamic = communityChildLayout.f17629b;
        a11.withString("dynamicId", String.valueOf(parentDynamic != null ? Integer.valueOf(parentDynamic.getId()) : null)).navigation();
    }

    public static final void e(CommunityChildLayout communityChildLayout, StatusType statusType) {
        Postcard a11 = b2.a.d().a("/content/DynamicDetail");
        CommunityFeedInfo.ListBean.ParentDynamic parentDynamic = communityChildLayout.f17629b;
        a11.withString("dynamicId", String.valueOf(parentDynamic != null ? Integer.valueOf(parentDynamic.getId()) : null)).navigation();
    }

    public final void c() {
        ArrayList<CommunityFeedInfo.imgListBean> imgList;
        removeAllViews();
        removeAllViewsInLayout();
        CommunityFeedInfo.ListBean.ParentDynamic parentDynamic = this.f17629b;
        ArrayList<CommunityFeedInfo.imgListBean> arrayList = null;
        boolean z11 = true;
        if ((parentDynamic != null ? Integer.valueOf(parentDynamic.getType()) : null).intValue() == 1) {
            setVisibility(0);
            View inflate = LayoutInflater.from(getContext()).inflate(R$layout.item_community_feed_comment, this, true);
            this.f17637j = inflate;
            this.f17630c = inflate != null ? (TextView) inflate.findViewById(R$id.tvNickName) : null;
            View view = this.f17637j;
            this.f17635h = view != null ? (RoundedImageView) view.findViewById(R$id.imageHeader) : null;
            View view2 = this.f17637j;
            this.f17631d = view2 != null ? (TextView) view2.findViewById(R$id.tvTitle) : null;
            View view3 = this.f17637j;
            this.f17632e = view3 != null ? (ExpandableTextView) view3.findViewById(R$id.tvContent) : null;
            View view4 = this.f17637j;
            this.f17636i = view4 != null ? (CommunityImageLayout) view4.findViewById(R$id.imageLayout) : null;
            TextView textView = this.f17630c;
            if (textView != null) {
                CommunityFeedInfo.ListBean.ParentDynamic parentDynamic2 = this.f17629b;
                textView.setText(parentDynamic2 != null ? parentDynamic2.getUserNickname() : null);
            }
            CommunityFeedInfo.ListBean.ParentDynamic parentDynamic3 = this.f17629b;
            String title = parentDynamic3 != null ? parentDynamic3.getTitle() : null;
            if (title == null || title.length() == 0) {
                TextView textView2 = this.f17631d;
                if (textView2 != null) {
                    textView2.setVisibility(8);
                }
            } else {
                TextView textView3 = this.f17631d;
                if (textView3 != null) {
                    textView3.setVisibility(0);
                }
                TextView textView4 = this.f17631d;
                if (textView4 != null) {
                    CommunityFeedInfo.ListBean.ParentDynamic parentDynamic4 = this.f17629b;
                    textView4.setText(parentDynamic4 != null ? parentDynamic4.getTitle() : null);
                }
            }
            CommunityFeedInfo.ListBean.ParentDynamic parentDynamic5 = this.f17629b;
            String content = parentDynamic5 != null ? parentDynamic5.getContent() : null;
            if (!(content == null || content.length() == 0)) {
                z11 = false;
            }
            if (z11) {
                ExpandableTextView expandableTextView = this.f17632e;
                if (expandableTextView != null) {
                    expandableTextView.setVisibility(8);
                }
            } else {
                ExpandableTextView expandableTextView2 = this.f17632e;
                if (expandableTextView2 != null) {
                    expandableTextView2.setVisibility(0);
                }
                ExpandableTextView expandableTextView3 = this.f17632e;
                if (expandableTextView3 != null) {
                    CommunityFeedInfo.ListBean.ParentDynamic parentDynamic6 = this.f17629b;
                    expandableTextView3.setContent((CharSequence) parentDynamic6 != null ? parentDynamic6.getContent() : null, (StatusType) null);
                }
            }
            ExpandableTextView expandableTextView4 = this.f17632e;
            if (expandableTextView4 != null) {
                expandableTextView4.setExpandOrContractClickListener(new a(this), false);
            }
            RoundedImageView roundedImageView = this.f17635h;
            CommunityFeedInfo.ListBean.ParentDynamic parentDynamic7 = this.f17629b;
            b.K(roundedImageView, parentDynamic7 != null ? parentDynamic7.getUserAvatar() : null, R$drawable.icon_community_user_header);
            RoundedImageView roundedImageView2 = this.f17635h;
            if (roundedImageView2 != null) {
                s sVar = s.f23381a;
                roundedImageView2.setOnClickListener(new a(roundedImageView2, 800, this));
            }
            CommunityFeedInfo.ListBean.ParentDynamic parentDynamic8 = this.f17629b;
            if ((parentDynamic8 != null ? parentDynamic8.getImgList() : null) != null) {
                CommunityFeedInfo.ListBean.ParentDynamic parentDynamic9 = this.f17629b;
                if (((parentDynamic9 == null || (imgList = parentDynamic9.getImgList()) == null) ? null : Integer.valueOf(imgList.size())).intValue() > 0) {
                    CommunityImageLayout communityImageLayout = this.f17636i;
                    if (communityImageLayout != null) {
                        communityImageLayout.setVisibility(0);
                    }
                    CommunityImageLayout communityImageLayout2 = this.f17636i;
                    if (communityImageLayout2 != null) {
                        communityImageLayout2.setImgPadding(getContext().getResources().getDimension(R$dimen.dimen_27));
                    }
                    CommunityImageLayout communityImageLayout3 = this.f17636i;
                    if (communityImageLayout3 != null) {
                        CommunityFeedInfo.ListBean.ParentDynamic parentDynamic10 = this.f17629b;
                        if (parentDynamic10 != null) {
                            arrayList = parentDynamic10.getImgList();
                        }
                        communityImageLayout3.a(arrayList);
                    }
                    CommunityImageLayout communityImageLayout4 = this.f17636i;
                    if (communityImageLayout4 != null) {
                        communityImageLayout4.setOnImageClick(new CommunityChildLayout$onView$3(this));
                        return;
                    }
                    return;
                }
            }
            CommunityImageLayout communityImageLayout5 = this.f17636i;
            if (communityImageLayout5 != null) {
                communityImageLayout5.setVisibility(8);
                return;
            }
            return;
        }
        CommunityFeedInfo.ListBean.ParentDynamic parentDynamic11 = this.f17629b;
        if ((parentDynamic11 != null ? Integer.valueOf(parentDynamic11.getType()) : null).intValue() == 3) {
            setVisibility(0);
            View inflate2 = LayoutInflater.from(getContext()).inflate(R$layout.item_community_feed_reply_comment, this, true);
            this.f17637j = inflate2;
            this.f17633f = inflate2 != null ? (TextView) inflate2.findViewById(R$id.tvAbout) : null;
            View view5 = this.f17637j;
            this.f17634g = view5 != null ? (ExpandableTextView) view5.findViewById(R$id.tvContent) : null;
            TextView textView5 = this.f17633f;
            if (textView5 != null) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append('@');
                CommunityFeedInfo.ListBean.ParentDynamic parentDynamic12 = this.f17629b;
                sb2.append(parentDynamic12 != null ? parentDynamic12.getUserNickname() : null);
                textView5.setText(sb2.toString());
            }
            ExpandableTextView expandableTextView5 = this.f17634g;
            if (expandableTextView5 != null) {
                CommunityFeedInfo.ListBean.ParentDynamic parentDynamic13 = this.f17629b;
                expandableTextView5.setContent((CharSequence) parentDynamic13 != null ? parentDynamic13.getContent() : null, (StatusType) null);
            }
            ExpandableTextView expandableTextView6 = this.f17634g;
            if (expandableTextView6 != null) {
                expandableTextView6.setExpandOrContractClickListener(new b(this), false);
                return;
            }
            return;
        }
        setVisibility(8);
    }

    public final CommunityFeedInfo.ListBean.ParentDynamic getData() {
        return this.f17629b;
    }

    public final l<String, Unit> getOnClickCommunityHeader() {
        return this.f17638k;
    }

    public final p<Integer, List<? extends CommunityFeedInfo.imgListBean>, Unit> getOnImageClick() {
        return this.f17639l;
    }

    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.f17629b != null) {
            c();
        }
    }

    public final void setData(CommunityFeedInfo.ListBean.ParentDynamic parentDynamic) {
        this.f17629b = parentDynamic;
    }

    public final void setOnClickCommunityHeader(l<? super String, Unit> lVar) {
        this.f17638k = lVar;
    }

    public final void setOnImageClick(p<? super Integer, ? super List<? extends CommunityFeedInfo.imgListBean>, Unit> pVar) {
        this.f17639l = pVar;
    }

    public CommunityChildLayout(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
    }
}
