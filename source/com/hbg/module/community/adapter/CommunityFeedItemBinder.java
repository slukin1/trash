package com.hbg.module.community.adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Checkable;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.MutableLiveData;
import com.hbg.lib.core.BaseModuleConfig;
import com.hbg.lib.network.hbg.core.bean.CommunityFeedInfo;
import com.hbg.lib.widgets.dialog.DialogUtils;
import com.hbg.module.community.multiadapter.ItemViewBinder;
import com.hbg.module.content.R$color;
import com.hbg.module.content.R$drawable;
import com.hbg.module.content.R$string;
import com.hbg.module.libkt.base.ext.RequestExtKt;
import com.hbg.module.libkt.provider.HbgBaseProvider;
import com.hbg.module.libkt.provider.HbgBaseShareProvider;
import com.huobi.view.roundimg.RoundedImageView;
import com.huobi.view.roundview.RoundConstraintLayout;
import com.huobi.view.roundview.RoundViewDelegate;
import com.huochat.community.widget.expandable.StatusType;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import d10.l;
import d10.p;
import java.util.ArrayList;
import kotlin.Unit;
import lc.a3;
import rd.s;

public final class CommunityFeedItemBinder extends ItemViewBinder<CommunityFeedInfo.ListBean, ItemViewBinder.a<a3>> {

    /* renamed from: e  reason: collision with root package name */
    public HbgBaseProvider f17049e = ((HbgBaseProvider) b2.a.d().a("/provider/content").navigation());

    /* renamed from: f  reason: collision with root package name */
    public HbgBaseShareProvider f17050f = ((HbgBaseShareProvider) b2.a.d().a("/provider/share/h5").navigation());

    /* renamed from: g  reason: collision with root package name */
    public boolean f17051g;

    public static final class a implements View.OnClickListener {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ View f17052b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ long f17053c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ CommunityFeedItemBinder f17054d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ CommunityFeedInfo.ListBean f17055e;

        public a(View view, long j11, CommunityFeedItemBinder communityFeedItemBinder, CommunityFeedInfo.ListBean listBean) {
            this.f17052b = view;
            this.f17053c = j11;
            this.f17054d = communityFeedItemBinder;
            this.f17055e = listBean;
        }

        @SensorsDataInstrumented
        public final void onClick(View view) {
            long currentTimeMillis = System.currentTimeMillis();
            s sVar = s.f23381a;
            if (currentTimeMillis - sVar.b(this.f17052b) > this.f17053c || (this.f17052b instanceof Checkable)) {
                sVar.e(this.f17052b, currentTimeMillis);
                RoundedImageView roundedImageView = (RoundedImageView) this.f17052b;
                if (!this.f17054d.y()) {
                    b2.a.d().a("/content/PersonalCenter").withString("uidUnique", this.f17055e.getUidUnique()).navigation();
                }
            }
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }
    }

    public static final class b implements View.OnClickListener {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ View f17056b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ long f17057c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ CommunityFeedInfo.ListBean f17058d;

        public b(View view, long j11, CommunityFeedInfo.ListBean listBean) {
            this.f17056b = view;
            this.f17057c = j11;
            this.f17058d = listBean;
        }

        @SensorsDataInstrumented
        public final void onClick(View view) {
            long currentTimeMillis = System.currentTimeMillis();
            s sVar = s.f23381a;
            if (currentTimeMillis - sVar.b(this.f17056b) > this.f17057c || (this.f17056b instanceof Checkable)) {
                sVar.e(this.f17056b, currentTimeMillis);
                b2.a.d().a("/content/DynamicDetail").withString("dynamicId", String.valueOf(this.f17058d.getId())).navigation();
            }
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }
    }

    public static final class c implements View.OnClickListener {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ View f17059b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ long f17060c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ CommunityFeedInfo.ListBean f17061d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ CommunityFeedItemBinder f17062e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ Context f17063f;

        public c(View view, long j11, CommunityFeedInfo.ListBean listBean, CommunityFeedItemBinder communityFeedItemBinder, Context context) {
            this.f17059b = view;
            this.f17060c = j11;
            this.f17061d = listBean;
            this.f17062e = communityFeedItemBinder;
            this.f17063f = context;
        }

        @SensorsDataInstrumented
        public final void onClick(View view) {
            CommunityFeedInfo.imgListBean imglistbean;
            ArrayList<CommunityFeedInfo.imgListBean> imgList;
            long currentTimeMillis = System.currentTimeMillis();
            s sVar = s.f23381a;
            if (currentTimeMillis - sVar.b(this.f17059b) > this.f17060c || (this.f17059b instanceof Checkable)) {
                sVar.e(this.f17059b, currentTimeMillis);
                RelativeLayout relativeLayout = (RelativeLayout) this.f17059b;
                String str = null;
                if (!com.hbg.module.libkt.base.ext.b.w(this.f17061d.getImgList()) && (imgList = this.f17061d.getImgList()) != null) {
                    imglistbean = imgList.get(0);
                } else {
                    imglistbean = null;
                }
                HbgBaseShareProvider t11 = this.f17062e.f17050f;
                if (t11 != null) {
                    FragmentActivity fragmentActivity = (FragmentActivity) this.f17063f;
                    String k11 = BaseModuleConfig.a().k("views/feed/details/community-details/" + this.f17061d.getId());
                    if (imglistbean != null) {
                        str = imglistbean.getImage();
                    }
                    t11.r(fragmentActivity, "", "", k11, "community", str, String.valueOf(this.f17061d.getId()), (this.f17061d.getShareType() == 20 || this.f17061d.getShareType() == 21) ? this.f17061d.getShareType() : 4);
                }
            }
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }
    }

    public static final class d implements View.OnClickListener {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ View f17064b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ long f17065c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ CommunityFeedInfo.ListBean f17066d;

        public d(View view, long j11, CommunityFeedInfo.ListBean listBean) {
            this.f17064b = view;
            this.f17065c = j11;
            this.f17066d = listBean;
        }

        @SensorsDataInstrumented
        public final void onClick(View view) {
            long currentTimeMillis = System.currentTimeMillis();
            s sVar = s.f23381a;
            if (currentTimeMillis - sVar.b(this.f17064b) > this.f17065c || (this.f17064b instanceof Checkable)) {
                sVar.e(this.f17064b, currentTimeMillis);
                RelativeLayout relativeLayout = (RelativeLayout) this.f17064b;
                b2.a.d().a("/content/DynamicDetail").withString("dynamicId", String.valueOf(this.f17066d.getId())).navigation();
            }
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }
    }

    public static final class e implements View.OnClickListener {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ View f17067b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ long f17068c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ CommunityFeedItemBinder f17069d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Context f17070e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ CommunityFeedInfo.ListBean f17071f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ ItemViewBinder.a f17072g;

        public e(View view, long j11, CommunityFeedItemBinder communityFeedItemBinder, Context context, CommunityFeedInfo.ListBean listBean, ItemViewBinder.a aVar) {
            this.f17067b = view;
            this.f17068c = j11;
            this.f17069d = communityFeedItemBinder;
            this.f17070e = context;
            this.f17071f = listBean;
            this.f17072g = aVar;
        }

        @SensorsDataInstrumented
        public final void onClick(View view) {
            long currentTimeMillis = System.currentTimeMillis();
            s sVar = s.f23381a;
            if (currentTimeMillis - sVar.b(this.f17067b) > this.f17068c || (this.f17067b instanceof Checkable)) {
                sVar.e(this.f17067b, currentTimeMillis);
                RelativeLayout relativeLayout = (RelativeLayout) this.f17067b;
                HbgBaseProvider s11 = this.f17069d.f17049e;
                if ((s11 != null ? Boolean.valueOf(s11.j((Activity) this.f17070e)) : null).booleanValue()) {
                    this.f17069d.H(this.f17071f.getId(), new CommunityFeedItemBinder$onBindViewHolder$7$1(this.f17071f, this.f17072g, this.f17069d));
                }
            }
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }
    }

    public static final class f implements View.OnClickListener {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ View f17073b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ long f17074c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ Context f17075d;

        public f(View view, long j11, Context context) {
            this.f17073b = view;
            this.f17074c = j11;
            this.f17075d = context;
        }

        @SensorsDataInstrumented
        public final void onClick(View view) {
            long currentTimeMillis = System.currentTimeMillis();
            s sVar = s.f23381a;
            if (currentTimeMillis - sVar.b(this.f17073b) > this.f17074c || (this.f17073b instanceof Checkable)) {
                sVar.e(this.f17073b, currentTimeMillis);
                ImageView imageView = (ImageView) this.f17073b;
                DialogUtils.V((FragmentActivity) this.f17075d);
            }
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }
    }

    public static final class g implements View.OnClickListener {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ View f17076b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ long f17077c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ CommunityFeedItemBinder f17078d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Context f17079e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ CommunityFeedInfo.ListBean f17080f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ ItemViewBinder.a f17081g;

        public g(View view, long j11, CommunityFeedItemBinder communityFeedItemBinder, Context context, CommunityFeedInfo.ListBean listBean, ItemViewBinder.a aVar) {
            this.f17076b = view;
            this.f17077c = j11;
            this.f17078d = communityFeedItemBinder;
            this.f17079e = context;
            this.f17080f = listBean;
            this.f17081g = aVar;
        }

        @SensorsDataInstrumented
        public final void onClick(View view) {
            long currentTimeMillis = System.currentTimeMillis();
            s sVar = s.f23381a;
            if (currentTimeMillis - sVar.b(this.f17076b) > this.f17077c || (this.f17076b instanceof Checkable)) {
                sVar.e(this.f17076b, currentTimeMillis);
                RoundConstraintLayout roundConstraintLayout = (RoundConstraintLayout) this.f17076b;
                HbgBaseProvider s11 = this.f17078d.f17049e;
                if ((s11 != null ? Boolean.valueOf(s11.j((Activity) this.f17079e)) : null).booleanValue()) {
                    if (this.f17080f.getFocusStatus() == 0) {
                        this.f17078d.G(this.f17080f.getFocusStatus() == 0 ? 1 : 0, this.f17080f.getUidUnique(), new CommunityFeedItemBinder$onBindViewHolder$11$1(this.f17080f, this.f17078d, this.f17081g));
                    } else {
                        b2.a.d().a("/content/PersonalCenter").withString("uidUnique", this.f17080f.getUidUnique()).navigation();
                    }
                }
            }
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }
    }

    @SensorsDataInstrumented
    public static final void A(CommunityFeedInfo.ListBean listBean, View view) {
        b2.a.d().a("/content/DynamicDetail").withString("dynamicId", String.valueOf(listBean.getId())).navigation();
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    public static final void B(CommunityFeedInfo.ListBean listBean, StatusType statusType) {
        b2.a.d().a("/content/DynamicDetail").withString("dynamicId", String.valueOf(listBean.getId())).navigation();
    }

    public static /* synthetic */ void E(CommunityFeedItemBinder communityFeedItemBinder, ItemViewBinder.a aVar, int i11, int i12, int i13, Object obj) {
        if ((i13 & 4) != 0) {
            i12 = 0;
        }
        communityFeedItemBinder.D(aVar, i11, i12);
    }

    /* renamed from: C */
    public ItemViewBinder.a<a3> m(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        return new ItemViewBinder.a<>(a3.K(layoutInflater, viewGroup, false));
    }

    public final void D(ItemViewBinder.a<a3> aVar, int i11, int i12) {
        if (this.f17051g) {
            aVar.e().B.setVisibility(8);
        } else if (i12 == 0) {
            aVar.e().B.setVisibility(0);
            if (i11 == 0) {
                s sVar = s.f23381a;
                RoundViewDelegate delegate = aVar.e().B.getDelegate();
                int i13 = R$color.community_cell_attention_btn_background;
                sVar.c(delegate, i13);
                sVar.d(aVar.e().B.getDelegate(), i13);
                RoundViewDelegate delegate2 = aVar.e().B.getDelegate();
                int i14 = R$color.community_action_btn;
                sVar.f(delegate2, i14);
                sVar.g(aVar.e().B.getDelegate(), i14);
                aVar.e().E.setVisibility(0);
                sVar.i(aVar.e().P, i14);
                sVar.j(aVar.e().P, R$string.n_content_communityList_attention);
                return;
            }
            s sVar2 = s.f23381a;
            RoundViewDelegate delegate3 = aVar.e().B.getDelegate();
            int i15 = R$color.community_cell_attentioned_btn_background;
            sVar2.c(delegate3, i15);
            sVar2.d(aVar.e().B.getDelegate(), i15);
            sVar2.f(aVar.e().B.getDelegate(), i15);
            sVar2.g(aVar.e().B.getDelegate(), i15);
            aVar.e().E.setVisibility(8);
            sVar2.i(aVar.e().P, R$color.community_cell_attentioned_text);
            sVar2.j(aVar.e().P, R$string.n_content_communityList_attentioned);
        } else {
            aVar.e().B.setVisibility(8);
        }
    }

    public final void F(ItemViewBinder.a<a3> aVar, int i11, boolean z11) {
        if (i11 == 0) {
            aVar.e().I.setImageResource(R$drawable.information_like);
        } else {
            aVar.e().I.setImageResource(R$drawable.information_like_focus);
        }
    }

    public final void G(int i11, String str, l<? super Integer, Unit> lVar) {
        RequestExtKt.d(v7.b.a().requestCommunityAttention(MapsKt__MapsKt.l(kotlin.l.a("type", Integer.valueOf(i11)), kotlin.l.a("uidUnique", str))), new CommunityFeedItemBinder$requestAttention$1(lVar, i11), CommunityFeedItemBinder$requestAttention$2.INSTANCE, (MutableLiveData) null, 4, (Object) null);
    }

    public final void H(int i11, p<? super Integer, ? super Integer, Unit> pVar) {
        RequestExtKt.d(v7.b.a().D0(String.valueOf(i11), 4), new CommunityFeedItemBinder$requestLike$1(pVar), CommunityFeedItemBinder$requestLike$2.INSTANCE, (MutableLiveData) null, 4, (Object) null);
    }

    public final boolean y() {
        return this.f17051g;
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x00b1  */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x00b3  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x00b6  */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x00c2  */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x00ed  */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x00f9  */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x0119  */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x0125  */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x0172  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x01d7  */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x020f  */
    /* renamed from: z */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void c(com.hbg.module.community.multiadapter.ItemViewBinder.a<lc.a3> r18, com.hbg.lib.network.hbg.core.bean.CommunityFeedInfo.ListBean r19, boolean r20, int r21) {
        /*
            r17 = this;
            r8 = r19
            r0 = 8
            r9 = 0
            if (r20 == 0) goto L_0x0013
            androidx.databinding.f r1 = r18.e()
            lc.a3 r1 = (lc.a3) r1
            android.view.View r1 = r1.L
            r1.setVisibility(r0)
            goto L_0x001e
        L_0x0013:
            androidx.databinding.f r1 = r18.e()
            lc.a3 r1 = (lc.a3) r1
            android.view.View r1 = r1.L
            r1.setVisibility(r9)
        L_0x001e:
            androidx.databinding.f r1 = r18.e()
            lc.a3 r1 = (lc.a3) r1
            androidx.constraintlayout.widget.ConstraintLayout r1 = r1.D
            android.content.Context r10 = r1.getContext()
            androidx.databinding.f r1 = r18.e()
            lc.a3 r1 = (lc.a3) r1
            com.huobi.view.roundimg.RoundedImageView r1 = r1.G
            java.lang.String r2 = r19.getUserAvatar()
            int r3 = com.hbg.module.content.R$drawable.icon_community_user_header
            com.hbg.module.libkt.base.ext.b.K(r1, r2, r3)
            androidx.databinding.f r1 = r18.e()
            lc.a3 r1 = (lc.a3) r1
            android.widget.TextView r1 = r1.U
            java.lang.String r2 = r19.getUserNickname()
            r1.setText(r2)
            int r1 = r19.getIsShowEventTag()
            r2 = 1
            if (r1 != r2) goto L_0x0074
            int r1 = r19.getType()
            if (r1 != r2) goto L_0x0062
            android.content.res.Resources r1 = r10.getResources()
            int r3 = com.hbg.module.content.R$string.n_content_communityList_publishAticle
            java.lang.String r1 = r1.getString(r3)
            goto L_0x0076
        L_0x0062:
            int r1 = r19.getType()
            r3 = 3
            if (r1 != r3) goto L_0x0074
            android.content.res.Resources r1 = r10.getResources()
            int r3 = com.hbg.module.content.R$string.n_content_communityList_commentAticle
            java.lang.String r1 = r1.getString(r3)
            goto L_0x0076
        L_0x0074:
            java.lang.String r1 = ""
        L_0x0076:
            androidx.databinding.f r3 = r18.e()
            lc.a3 r3 = (lc.a3) r3
            android.widget.TextView r3 = r3.S
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.Long r5 = r19.getCreatedTime()
            long r5 = r5.longValue()
            java.lang.String r5 = com.hbg.module.huobi.im.utils.DateUtils.f(r10, r5)
            r4.append(r5)
            r5 = 32
            r4.append(r5)
            r4.append(r1)
            r4.append(r5)
            java.lang.String r1 = r4.toString()
            r3.setText(r1)
            java.lang.String r1 = r19.getTitle()
            if (r1 == 0) goto L_0x00b3
            int r1 = r1.length()
            if (r1 != 0) goto L_0x00b1
            goto L_0x00b3
        L_0x00b1:
            r1 = r9
            goto L_0x00b4
        L_0x00b3:
            r1 = r2
        L_0x00b4:
            if (r1 == 0) goto L_0x00c2
            androidx.databinding.f r1 = r18.e()
            lc.a3 r1 = (lc.a3) r1
            android.widget.TextView r1 = r1.V
            r1.setVisibility(r0)
            goto L_0x00dc
        L_0x00c2:
            androidx.databinding.f r1 = r18.e()
            lc.a3 r1 = (lc.a3) r1
            android.widget.TextView r1 = r1.V
            r1.setVisibility(r9)
            androidx.databinding.f r1 = r18.e()
            lc.a3 r1 = (lc.a3) r1
            android.widget.TextView r1 = r1.V
            java.lang.String r3 = r19.getTitle()
            r1.setText(r3)
        L_0x00dc:
            java.lang.String r1 = r19.getContent()
            if (r1 == 0) goto L_0x00ea
            int r1 = r1.length()
            if (r1 != 0) goto L_0x00e9
            goto L_0x00ea
        L_0x00e9:
            r2 = r9
        L_0x00ea:
            r1 = 0
            if (r2 == 0) goto L_0x00f9
            androidx.databinding.f r2 = r18.e()
            lc.a3 r2 = (lc.a3) r2
            com.huochat.community.widget.expandable.ExpandableTextView r2 = r2.R
            r2.setVisibility(r0)
            goto L_0x0113
        L_0x00f9:
            androidx.databinding.f r2 = r18.e()
            lc.a3 r2 = (lc.a3) r2
            com.huochat.community.widget.expandable.ExpandableTextView r2 = r2.R
            r2.setVisibility(r9)
            androidx.databinding.f r2 = r18.e()
            lc.a3 r2 = (lc.a3) r2
            com.huochat.community.widget.expandable.ExpandableTextView r2 = r2.R
            java.lang.String r3 = r19.getContent()
            r2.setContent((java.lang.CharSequence) r3, (com.huochat.community.widget.expandable.StatusType) r1)
        L_0x0113:
            int r2 = r19.getIsSelf()
            if (r2 != 0) goto L_0x0125
            androidx.databinding.f r2 = r18.e()
            lc.a3 r2 = (lc.a3) r2
            android.widget.ImageView r2 = r2.J
            r2.setVisibility(r9)
            goto L_0x0130
        L_0x0125:
            androidx.databinding.f r2 = r18.e()
            lc.a3 r2 = (lc.a3) r2
            android.widget.ImageView r2 = r2.J
            r2.setVisibility(r0)
        L_0x0130:
            androidx.databinding.f r2 = r18.e()
            lc.a3 r2 = (lc.a3) r2
            android.widget.TextView r2 = r2.Q
            int r3 = r19.getCommentNum()
            java.lang.String r3 = java.lang.String.valueOf(r3)
            he.b.l(r2, r3)
            androidx.databinding.f r2 = r18.e()
            lc.a3 r2 = (lc.a3) r2
            android.widget.TextView r2 = r2.T
            int r3 = r19.getPraiseNum()
            java.lang.String r3 = java.lang.String.valueOf(r3)
            he.b.l(r2, r3)
            int r13 = r19.getFocusStatus()
            r14 = 0
            r15 = 4
            r16 = 0
            r11 = r17
            r12 = r18
            E(r11, r12, r13, r14, r15, r16)
            int r2 = r19.getPraiseStatus()
            r11.F(r12, r2, r9)
            java.util.ArrayList r2 = r19.getImgList()
            if (r2 == 0) goto L_0x01c6
            java.util.ArrayList r2 = r19.getImgList()
            if (r2 == 0) goto L_0x0180
            int r1 = r2.size()
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)
        L_0x0180:
            int r1 = r1.intValue()
            if (r1 <= 0) goto L_0x01c6
            androidx.databinding.f r1 = r18.e()
            lc.a3 r1 = (lc.a3) r1
            com.hbg.module.community.widgets.CommunityImageLayout r1 = r1.H
            r1.setVisibility(r9)
            androidx.databinding.f r1 = r18.e()
            lc.a3 r1 = (lc.a3) r1
            com.hbg.module.community.widgets.CommunityImageLayout r1 = r1.H
            android.content.res.Resources r2 = r10.getResources()
            int r3 = com.hbg.module.content.R$dimen.dimen_15
            float r2 = r2.getDimension(r3)
            r1.setImgPadding(r2)
            androidx.databinding.f r1 = r18.e()
            lc.a3 r1 = (lc.a3) r1
            com.hbg.module.community.widgets.CommunityImageLayout r1 = r1.H
            java.util.ArrayList r2 = r19.getImgList()
            r1.a(r2)
            androidx.databinding.f r1 = r18.e()
            lc.a3 r1 = (lc.a3) r1
            com.hbg.module.community.widgets.CommunityImageLayout r1 = r1.H
            com.hbg.module.community.adapter.CommunityFeedItemBinder$onBindViewHolder$1 r2 = new com.hbg.module.community.adapter.CommunityFeedItemBinder$onBindViewHolder$1
            r2.<init>(r10)
            r1.setOnImageClick(r2)
            goto L_0x01d1
        L_0x01c6:
            androidx.databinding.f r1 = r18.e()
            lc.a3 r1 = (lc.a3) r1
            com.hbg.module.community.widgets.CommunityImageLayout r1 = r1.H
            r1.setVisibility(r0)
        L_0x01d1:
            com.hbg.lib.network.hbg.core.bean.CommunityFeedInfo$ListBean$ParentDynamic r1 = r19.getParentDynamic()
            if (r1 != 0) goto L_0x020f
            androidx.databinding.f r1 = r18.e()
            lc.a3 r1 = (lc.a3) r1
            com.hbg.module.community.widgets.CommunityChildLayout r1 = r1.C
            r1.setVisibility(r0)
            androidx.databinding.f r0 = r18.e()
            lc.a3 r0 = (lc.a3) r0
            android.widget.ImageView r0 = r0.J
            r0.setVisibility(r9)
            androidx.databinding.f r0 = r18.e()
            lc.a3 r0 = (lc.a3) r0
            android.widget.RelativeLayout r0 = r0.N
            r0.setVisibility(r9)
            androidx.databinding.f r0 = r18.e()
            lc.a3 r0 = (lc.a3) r0
            android.widget.RelativeLayout r0 = r0.M
            r0.setVisibility(r9)
            androidx.databinding.f r0 = r18.e()
            lc.a3 r0 = (lc.a3) r0
            android.widget.RelativeLayout r0 = r0.O
            r0.setVisibility(r9)
            goto L_0x0265
        L_0x020f:
            androidx.databinding.f r1 = r18.e()
            lc.a3 r1 = (lc.a3) r1
            android.widget.ImageView r1 = r1.J
            r1.setVisibility(r0)
            androidx.databinding.f r1 = r18.e()
            lc.a3 r1 = (lc.a3) r1
            android.widget.RelativeLayout r1 = r1.N
            r1.setVisibility(r0)
            androidx.databinding.f r1 = r18.e()
            lc.a3 r1 = (lc.a3) r1
            android.widget.RelativeLayout r1 = r1.M
            r1.setVisibility(r0)
            androidx.databinding.f r1 = r18.e()
            lc.a3 r1 = (lc.a3) r1
            android.widget.RelativeLayout r1 = r1.O
            r1.setVisibility(r0)
            androidx.databinding.f r0 = r18.e()
            lc.a3 r0 = (lc.a3) r0
            com.hbg.module.community.widgets.CommunityChildLayout r0 = r0.C
            r0.setVisibility(r9)
            androidx.databinding.f r0 = r18.e()
            lc.a3 r0 = (lc.a3) r0
            com.hbg.module.community.widgets.CommunityChildLayout r0 = r0.C
            com.hbg.lib.network.hbg.core.bean.CommunityFeedInfo$ListBean$ParentDynamic r1 = r19.getParentDynamic()
            r0.setData(r1)
            androidx.databinding.f r0 = r18.e()
            lc.a3 r0 = (lc.a3) r0
            com.hbg.module.community.widgets.CommunityChildLayout r0 = r0.C
            com.hbg.module.community.adapter.CommunityFeedItemBinder$onBindViewHolder$2 r1 = new com.hbg.module.community.adapter.CommunityFeedItemBinder$onBindViewHolder$2
            r1.<init>(r10)
            r0.setOnImageClick(r1)
        L_0x0265:
            rd.s r0 = rd.s.f23381a
            androidx.databinding.f r0 = r18.e()
            lc.a3 r0 = (lc.a3) r0
            com.huobi.view.roundimg.RoundedImageView r6 = r0.G
            r2 = 800(0x320, double:3.953E-321)
            com.hbg.module.community.adapter.CommunityFeedItemBinder$a r7 = new com.hbg.module.community.adapter.CommunityFeedItemBinder$a
            r0 = r7
            r1 = r6
            r4 = r17
            r5 = r19
            r0.<init>(r1, r2, r4, r5)
            r6.setOnClickListener(r7)
            androidx.databinding.f r0 = r18.e()
            lc.a3 r0 = (lc.a3) r0
            android.view.View r0 = r0.getRoot()
            com.hbg.module.community.adapter.CommunityFeedItemBinder$b r1 = new com.hbg.module.community.adapter.CommunityFeedItemBinder$b
            r13 = 800(0x320, double:3.953E-321)
            r1.<init>(r0, r13, r8)
            r0.setOnClickListener(r1)
            androidx.databinding.f r0 = r18.e()
            lc.a3 r0 = (lc.a3) r0
            android.widget.RelativeLayout r7 = r0.O
            com.hbg.module.community.adapter.CommunityFeedItemBinder$c r15 = new com.hbg.module.community.adapter.CommunityFeedItemBinder$c
            r0 = r15
            r1 = r7
            r4 = r19
            r5 = r17
            r6 = r10
            r0.<init>(r1, r2, r4, r5, r6)
            r7.setOnClickListener(r15)
            androidx.databinding.f r0 = r18.e()
            lc.a3 r0 = (lc.a3) r0
            android.widget.RelativeLayout r0 = r0.M
            com.hbg.module.community.adapter.CommunityFeedItemBinder$d r1 = new com.hbg.module.community.adapter.CommunityFeedItemBinder$d
            r1.<init>(r0, r13, r8)
            r0.setOnClickListener(r1)
            androidx.databinding.f r0 = r18.e()
            lc.a3 r0 = (lc.a3) r0
            android.widget.RelativeLayout r15 = r0.N
            com.hbg.module.community.adapter.CommunityFeedItemBinder$e r7 = new com.hbg.module.community.adapter.CommunityFeedItemBinder$e
            r0 = r7
            r1 = r15
            r4 = r17
            r5 = r10
            r6 = r19
            r9 = r7
            r7 = r18
            r0.<init>(r1, r2, r4, r5, r6, r7)
            r15.setOnClickListener(r9)
            androidx.databinding.f r0 = r18.e()
            lc.a3 r0 = (lc.a3) r0
            android.widget.ImageView r0 = r0.J
            com.hbg.module.community.adapter.CommunityFeedItemBinder$f r1 = new com.hbg.module.community.adapter.CommunityFeedItemBinder$f
            r1.<init>(r0, r13, r10)
            r0.setOnClickListener(r1)
            androidx.databinding.f r0 = r18.e()
            lc.a3 r0 = (lc.a3) r0
            com.huochat.community.widget.expandable.ExpandableTextView r0 = r0.R
            com.hbg.module.community.adapter.m r1 = new com.hbg.module.community.adapter.m
            r1.<init>(r8)
            r0.setOnClickListener(r1)
            androidx.databinding.f r0 = r18.e()
            lc.a3 r0 = (lc.a3) r0
            com.huochat.community.widget.expandable.ExpandableTextView r0 = r0.R
            com.hbg.module.community.adapter.n r1 = new com.hbg.module.community.adapter.n
            r1.<init>(r8)
            r2 = 0
            r0.setExpandOrContractClickListener(r1, r2)
            androidx.databinding.f r0 = r18.e()
            lc.a3 r0 = (lc.a3) r0
            com.huobi.view.roundview.RoundConstraintLayout r9 = r0.B
            r2 = 800(0x320, double:3.953E-321)
            com.hbg.module.community.adapter.CommunityFeedItemBinder$g r13 = new com.hbg.module.community.adapter.CommunityFeedItemBinder$g
            r0 = r13
            r1 = r9
            r0.<init>(r1, r2, r4, r5, r6, r7)
            r9.setOnClickListener(r13)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.hbg.module.community.adapter.CommunityFeedItemBinder.c(com.hbg.module.community.multiadapter.ItemViewBinder$a, com.hbg.lib.network.hbg.core.bean.CommunityFeedInfo$ListBean, boolean, int):void");
    }
}
