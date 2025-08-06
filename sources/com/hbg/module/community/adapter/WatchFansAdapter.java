package com.hbg.module.community.adapter;

import android.view.View;
import android.view.ViewGroup;
import android.widget.Checkable;
import android.widget.LinearLayout;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.MutableLiveData;
import com.hbg.lib.network.hbg.core.bean.PersonalCenterInfo;
import com.hbg.lib.network.hbg.core.bean.WatchFansBean;
import com.hbg.module.community.widgets.FollowView;
import com.hbg.module.content.R$drawable;
import com.hbg.module.huobi.im.view.AvatarView;
import com.hbg.module.libkt.base.ext.RequestExtKt;
import com.hbg.module.libkt.provider.HbgBaseProvider;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import he.c;
import kotlin.jvm.internal.x;
import kotlin.l;
import lc.c4;
import rd.s;

public final class WatchFansAdapter extends c<WatchFansBean, c.a<c4>> {

    /* renamed from: f  reason: collision with root package name */
    public int f17168f;

    /* renamed from: g  reason: collision with root package name */
    public int f17169g;

    /* renamed from: h  reason: collision with root package name */
    public HbgBaseProvider f17170h;

    public static final class a implements View.OnClickListener {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ View f17171b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ long f17172c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ WatchFansAdapter f17173d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ WatchFansBean f17174e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f17175f;

        public a(View view, long j11, WatchFansAdapter watchFansAdapter, WatchFansBean watchFansBean, int i11) {
            this.f17171b = view;
            this.f17172c = j11;
            this.f17173d = watchFansAdapter;
            this.f17174e = watchFansBean;
            this.f17175f = i11;
        }

        @SensorsDataInstrumented
        public final void onClick(View view) {
            long currentTimeMillis = System.currentTimeMillis();
            s sVar = s.f23381a;
            if (currentTimeMillis - sVar.b(this.f17171b) > this.f17172c || (this.f17171b instanceof Checkable)) {
                sVar.e(this.f17171b, currentTimeMillis);
                FollowView followView = (FollowView) this.f17171b;
                this.f17173d.l(this.f17174e, this.f17175f);
            }
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }
    }

    public static final class b implements View.OnClickListener {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ View f17176b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ long f17177c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ WatchFansBean f17178d;

        public b(View view, long j11, WatchFansBean watchFansBean) {
            this.f17176b = view;
            this.f17177c = j11;
            this.f17178d = watchFansBean;
        }

        @SensorsDataInstrumented
        public final void onClick(View view) {
            long currentTimeMillis = System.currentTimeMillis();
            s sVar = s.f23381a;
            if (currentTimeMillis - sVar.b(this.f17176b) > this.f17177c || (this.f17176b instanceof Checkable)) {
                sVar.e(this.f17176b, currentTimeMillis);
                LinearLayout linearLayout = (LinearLayout) this.f17176b;
                b2.a.d().a("/content/PersonalCenter").withString("uidUnique", this.f17178d.getUidUnique()).navigation();
            }
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }
    }

    public WatchFansAdapter(FragmentActivity fragmentActivity, int i11, int i12) {
        super(fragmentActivity);
        this.f17168f = i11;
        this.f17169g = i12;
    }

    public final void l(WatchFansBean watchFansBean, int i11) {
        HbgBaseProvider hbgBaseProvider = this.f17170h;
        if ((hbgBaseProvider != null && hbgBaseProvider.j(f())) && watchFansBean != null) {
            int i12 = watchFansBean.getFocusStatus() == 0 ? 1 : 0;
            RequestExtKt.d(v7.b.a().requestCommunityAttention(MapsKt__MapsKt.l(l.a("type", Integer.valueOf(i12)), l.a("uidUnique", watchFansBean.getUidUnique()))), new WatchFansAdapter$attentionAuthor$1$1(watchFansBean, i12, this, i11), WatchFansAdapter$attentionAuthor$1$2.INSTANCE, (MutableLiveData) null, 4, (Object) null);
        }
    }

    /* renamed from: m */
    public void onBindViewHolder(c.a<c4> aVar, int i11) {
        boolean z11;
        boolean z12;
        super.onBindViewHolder(aVar, i11);
        WatchFansBean watchFansBean = (WatchFansBean) g().get(i11);
        aVar.e().M(watchFansBean);
        String str = null;
        if (com.hbg.module.libkt.base.ext.b.x(watchFansBean.getUserAvatar())) {
            aVar.e().C.z(watchFansBean.getUidUnique(), (String) null).y(R$drawable.account_user_image, 0);
            AvatarView avatarView = aVar.e().C;
            if (avatarView != null) {
                if (watchFansBean.getUcExtInfo() != null) {
                    PersonalCenterInfo.UcExtInfo ucExtInfo = watchFansBean.getUcExtInfo();
                    if (ucExtInfo != null) {
                        str = ucExtInfo.showExtBusinessTag;
                    }
                    if ("BIG_V".equals(str)) {
                        z12 = true;
                        avatarView.A(z12);
                    }
                }
                z12 = false;
                avatarView.A(z12);
            }
        } else {
            AvatarView avatarView2 = aVar.e().C;
            String userAvatar = watchFansBean.getUserAvatar();
            PersonalCenterInfo.UcExtInfo ucExtInfo2 = watchFansBean.getUcExtInfo();
            boolean b11 = x.b(ucExtInfo2 != null ? ucExtInfo2.headImageType : null, "NFT");
            PersonalCenterInfo.UcExtInfo ucExtInfo3 = watchFansBean.getUcExtInfo();
            AvatarView.t(avatarView2.u(userAvatar, b11, ucExtInfo3 != null ? ucExtInfo3.frameUrl : null), 0, -1, watchFansBean.getUidUnique(), (String) null, (String) null, 0, 48, (Object) null);
            AvatarView avatarView3 = aVar.e().C;
            if (avatarView3 != null) {
                if (watchFansBean.getUcExtInfo() != null) {
                    PersonalCenterInfo.UcExtInfo ucExtInfo4 = watchFansBean.getUcExtInfo();
                    if (ucExtInfo4 != null) {
                        str = ucExtInfo4.showExtBusinessTag;
                    }
                    if ("BIG_V".equals(str)) {
                        z11 = true;
                        avatarView3.A(z11);
                    }
                }
                z11 = false;
                avatarView3.A(z11);
            }
        }
        if (watchFansBean.getFocusStatus() == 0) {
            aVar.e().B.setFollowType(0);
        } else {
            aVar.e().B.setFollowType(1);
        }
        s sVar = s.f23381a;
        FollowView followView = aVar.e().B;
        followView.setOnClickListener(new a(followView, 800, this, watchFansBean, i11));
        LinearLayout linearLayout = aVar.e().D;
        linearLayout.setOnClickListener(new b(linearLayout, 800, watchFansBean));
    }

    /* renamed from: n */
    public c.a<c4> onCreateViewHolder(ViewGroup viewGroup, int i11) {
        this.f17170h = (HbgBaseProvider) b2.a.d().a("/provider/content").navigation();
        return new c.a<>(c4.K(h(), viewGroup, false));
    }
}
