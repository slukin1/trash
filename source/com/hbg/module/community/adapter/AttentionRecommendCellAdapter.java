package com.hbg.module.community.adapter;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Checkable;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.MutableLiveData;
import com.google.android.gms.common.Scopes;
import com.hbg.lib.network.hbg.core.bean.CommunityFeedInfo;
import com.hbg.module.content.R$color;
import com.hbg.module.content.R$dimen;
import com.hbg.module.content.R$drawable;
import com.hbg.module.content.R$string;
import com.hbg.module.huobi.im.view.AvatarView;
import com.hbg.module.libkt.base.ext.RequestExtKt;
import com.hbg.module.libkt.provider.HbgBaseProvider;
import com.huobi.view.roundview.RoundConstraintLayout;
import com.huobi.view.roundview.RoundViewDelegate;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import he.c;
import kotlin.Unit;
import kotlin.jvm.internal.x;
import kotlin.l;
import lc.w2;
import rd.s;

public final class AttentionRecommendCellAdapter extends c<CommunityFeedInfo.FocusBean, c.a<w2>> {

    /* renamed from: f  reason: collision with root package name */
    public HbgBaseProvider f16951f = ((HbgBaseProvider) b2.a.d().a("/provider/content").navigation());

    /* renamed from: g  reason: collision with root package name */
    public d10.a<Unit> f16952g;

    /* renamed from: h  reason: collision with root package name */
    public d10.a<Unit> f16953h;

    public static final class a implements View.OnClickListener {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ View f16954b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ long f16955c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ CommunityFeedInfo.FocusBean f16956d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ AttentionRecommendCellAdapter f16957e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ Context f16958f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ c.a f16959g;

        public a(View view, long j11, CommunityFeedInfo.FocusBean focusBean, AttentionRecommendCellAdapter attentionRecommendCellAdapter, Context context, c.a aVar) {
            this.f16954b = view;
            this.f16955c = j11;
            this.f16956d = focusBean;
            this.f16957e = attentionRecommendCellAdapter;
            this.f16958f = context;
            this.f16959g = aVar;
        }

        @SensorsDataInstrumented
        public final void onClick(View view) {
            long currentTimeMillis = System.currentTimeMillis();
            s sVar = s.f23381a;
            if (currentTimeMillis - sVar.b(this.f16954b) > this.f16955c || (this.f16954b instanceof Checkable)) {
                sVar.e(this.f16954b, currentTimeMillis);
                RoundConstraintLayout roundConstraintLayout = (RoundConstraintLayout) this.f16954b;
                if (this.f16956d.getFocusStatus() == 0) {
                    this.f16957e.q(1, this.f16956d.getUidUnique(), new AttentionRecommendCellAdapter$onBindViewHolder$2$1(this.f16956d, this.f16957e, this.f16958f, this.f16959g));
                    nc.c.a("app_community_gz", MapsKt__MapsKt.j(l.a("uid", this.f16956d.getUidUnique())));
                    nc.c.a("app_community_recpeopleclick", MapsKt__MapsKt.j(l.a("uid", this.f16956d.getUidUnique()), l.a("clicktype", "follow"), l.a("recom_base_info", this.f16956d.getRecom_base_info())));
                } else {
                    b2.a.d().a("/content/PersonalCenter").withString("uidUnique", this.f16956d.getUidUnique()).navigation();
                }
            }
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }
    }

    public static final class b implements AvatarView.a {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ CommunityFeedInfo.FocusBean f16960a;

        public b(CommunityFeedInfo.FocusBean focusBean) {
            this.f16960a = focusBean;
        }

        public void a() {
            AvatarView.a.C0156a.b(this);
            nc.c.a("app_community_tx", MapsKt__MapsKt.j(l.a("uid", this.f16960a.getUidUnique())));
            nc.c.a("app_community_recpeopleclick", MapsKt__MapsKt.j(l.a("uid", this.f16960a.getUidUnique()), l.a("clicktype", Scopes.PROFILE), l.a("recom_base_info", this.f16960a.getRecom_base_info())));
        }

        public void b(int i11, int i12) {
            AvatarView.a.C0156a.a(this, i11, i12);
        }
    }

    public AttentionRecommendCellAdapter(FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    public final d10.a<Unit> m() {
        return this.f16953h;
    }

    /* renamed from: n */
    public void onBindViewHolder(c.a<w2> aVar, int i11) {
        c.a<w2> aVar2 = aVar;
        CommunityFeedInfo.FocusBean focusBean = (CommunityFeedInfo.FocusBean) g().get(i11);
        Context context = aVar2.itemView.getContext();
        if (com.hbg.module.libkt.base.ext.b.x(focusBean.getUserAvatar())) {
            aVar.e().F.z(focusBean.getUidUnique(), (String) null).y(R$drawable.account_user_image, focusBean.getIsAlive());
        } else {
            AvatarView.t(aVar.e().F.u(focusBean.getUserAvatar(), x.b(focusBean.getAvatarType(), "NFT"), focusBean.getFrameUrl()), focusBean.getIsAlive(), -1, focusBean.getUidUnique(), (String) null, (String) null, 0, 48, (Object) null);
        }
        aVar.e().F.setAvatarClickListener(new b(focusBean));
        String userNickname = focusBean.getUserNickname();
        boolean z11 = true;
        if (userNickname == null || userNickname.length() == 0) {
            aVar.e().H.setVisibility(8);
        } else {
            aVar.e().H.setText(focusBean.getUserNickname());
            aVar.e().H.setVisibility(0);
        }
        String intro = focusBean.getIntro();
        if (!(intro == null || intro.length() == 0)) {
            z11 = false;
        }
        if (z11) {
            aVar.e().B.setVisibility(8);
        } else {
            aVar.e().B.setText(focusBean.getIntro());
            aVar.e().B.setVisibility(0);
        }
        if (TextUtils.isEmpty(focusBean.getRecommendWord())) {
            aVar.e().C.setVisibility(8);
        } else {
            aVar.e().C.setText(focusBean.getRecommendWord());
            aVar.e().C.setVisibility(0);
        }
        t(context, focusBean.getFocusStatus(), aVar2);
        s sVar = s.f23381a;
        RoundConstraintLayout roundConstraintLayout = aVar.e().D;
        roundConstraintLayout.setOnClickListener(new a(roundConstraintLayout, 800, focusBean, this, context, aVar));
    }

    /* renamed from: o */
    public c.a<w2> onCreateViewHolder(ViewGroup viewGroup, int i11) {
        return new c.a<>(w2.K(h(), viewGroup, false));
    }

    /* renamed from: p */
    public void onViewAttachedToWindow(c.a<w2> aVar) {
        super.onViewAttachedToWindow(aVar);
        nc.c.a("app_community_recpeoplebg", MapsKt__MapsKt.j(l.a("uid", ((CommunityFeedInfo.FocusBean) g().get(aVar.getBindingAdapterPosition())).getUidUnique()), l.a("recom_base_info", ((CommunityFeedInfo.FocusBean) g().get(aVar.getBindingAdapterPosition())).getRecom_base_info())));
    }

    public final void q(int i11, String str, d10.a<Unit> aVar) {
        HbgBaseProvider hbgBaseProvider = this.f16951f;
        if ((hbgBaseProvider != null ? Boolean.valueOf(hbgBaseProvider.j(f())) : null).booleanValue()) {
            d10.a<Unit> aVar2 = this.f16952g;
            if (aVar2 != null) {
                Unit invoke = aVar2.invoke();
            }
            RequestExtKt.d(v7.b.a().requestCommunityAttention(MapsKt__MapsKt.l(l.a("type", Integer.valueOf(i11)), l.a("uidUnique", str))), new AttentionRecommendCellAdapter$requestAttention$1(this, aVar), new AttentionRecommendCellAdapter$requestAttention$2(this), (MutableLiveData) null, 4, (Object) null);
        }
    }

    public final void r(d10.a<Unit> aVar) {
        this.f16953h = aVar;
    }

    public final void s(d10.a<Unit> aVar) {
        this.f16952g = aVar;
    }

    public final void t(Context context, int i11, c.a<w2> aVar) {
        if (i11 == 0) {
            aVar.e().D.getDelegate().setStrokeWidth((int) context.getResources().getDimension(R$dimen.dimen_0_5));
            RoundViewDelegate delegate = aVar.e().D.getDelegate();
            Resources resources = context.getResources();
            int i12 = R$color.baseColorMajorTheme100;
            delegate.setStrokeColor(resources.getColor(i12));
            aVar.e().D.getDelegate().setStrokePressColor(context.getResources().getColor(i12));
            RoundViewDelegate delegate2 = aVar.e().D.getDelegate();
            Resources resources2 = context.getResources();
            int i13 = R$color.community_cell_attention_btn_background;
            delegate2.setBackgroundColor(resources2.getColor(i13));
            aVar.e().D.getDelegate().setBackgroundPressColor(context.getResources().getColor(i13));
            aVar.e().E.setImageResource(R$drawable.icon_blue_plus);
            aVar.e().G.setTextColor(context.getResources().getColor(i12));
            aVar.e().G.setText(context.getResources().getString(R$string.n_content_communityList_attention));
            return;
        }
        aVar.e().D.getDelegate().setStrokeWidth((int) context.getResources().getDimension(R$dimen.dimen_0));
        RoundViewDelegate delegate3 = aVar.e().D.getDelegate();
        Resources resources3 = context.getResources();
        int i14 = R$color.baseColorRemarksBackground;
        delegate3.setStrokeColor(resources3.getColor(i14));
        aVar.e().D.getDelegate().setStrokePressColor(context.getResources().getColor(i14));
        aVar.e().D.getDelegate().setBackgroundColor(context.getResources().getColor(i14));
        aVar.e().D.getDelegate().setBackgroundPressColor(context.getResources().getColor(i14));
        aVar.e().E.setImageResource(R$drawable.icon_hook_focus_on);
        aVar.e().G.setTextColor(context.getResources().getColor(R$color.community_cell_attentioned_text));
        aVar.e().G.setText(context.getResources().getString(R$string.n_content_communityList_attention));
    }
}
