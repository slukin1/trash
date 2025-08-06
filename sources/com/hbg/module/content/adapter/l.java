package com.hbg.module.content.adapter;

import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.hbg.lib.core.util.RxJavaHelper;
import com.hbg.lib.network.hbg.core.bean.LiveGroupUserListData;
import com.hbg.lib.network.hbg.core.bean.PersonalCenterInfo;
import com.hbg.lib.network.retrofit.exception.APIStatusErrorException;
import com.hbg.lib.network.retrofit.rxjava.BaseSubscriber;
import com.hbg.module.content.R$drawable;
import com.hbg.module.content.ui.activity.live.GroupUserInfoDialog;
import com.hbg.module.libkt.provider.HbgBaseProvider;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import com.tencent.imsdk.v2.V2TIMUserFullInfo;
import com.tencent.qcloud.tuicore.util.ToastUtil;
import he.c;
import lc.e5;
import rd.e;
import rd.f;
import u6.g;

public final class l extends c<LiveGroupUserListData.GroupUser, c.a<e5>> {

    /* renamed from: f  reason: collision with root package name */
    public HbgBaseProvider f17892f;

    /* renamed from: g  reason: collision with root package name */
    public String f17893g;

    /* renamed from: h  reason: collision with root package name */
    public int f17894h;

    public static final class a extends BaseSubscriber<PersonalCenterInfo> {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ l f17895b;

        public a(l lVar) {
            this.f17895b = lVar;
        }

        /* renamed from: a */
        public void onNext(PersonalCenterInfo personalCenterInfo) {
            super.onNext(personalCenterInfo);
            GroupUserInfoDialog.a aVar = GroupUserInfoDialog.f18403t;
            FragmentManager supportFragmentManager = this.f17895b.f().getSupportFragmentManager();
            String m11 = this.f17895b.f17893g;
            String account = personalCenterInfo.getAccount();
            String avatar = personalCenterInfo.getAvatar();
            String nickname = personalCenterInfo.getNickname();
            String uidUnique = personalCenterInfo.getUidUnique();
            int focusNum = personalCenterInfo.getFocusNum();
            int fansNum = personalCenterInfo.getFansNum();
            int dynamicNum = personalCenterInfo.getDynamicNum();
            int accessChat = personalCenterInfo.getAccessChat();
            int focusStatus = personalCenterInfo.getFocusStatus();
            int i11 = personalCenterInfo.getLiveRoleInfo().liveRole;
            boolean z11 = true;
            boolean z12 = personalCenterInfo.getIsSelf() == 1;
            if (personalCenterInfo.getLiveRoleInfo().isForbidden != 1) {
                z11 = false;
            }
            aVar.a(supportFragmentManager, m11, account, avatar, nickname, uidUnique, focusNum, fansNum, dynamicNum, accessChat, focusStatus, i11, z12, z11, this.f17895b.f17894h);
        }

        public void onError(Throwable th2) {
            super.onError(th2);
            if (th2 instanceof APIStatusErrorException) {
                ToastUtil.toastShortMessage(((APIStatusErrorException) th2).getErrMsg());
            }
        }
    }

    public static final class b implements e {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ LiveGroupUserListData.GroupUser f17896a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ l f17897b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ int f17898c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ c.a<e5> f17899d;

        public b(LiveGroupUserListData.GroupUser groupUser, l lVar, int i11, c.a<e5> aVar) {
            this.f17896a = groupUser;
            this.f17897b = lVar;
            this.f17898c = i11;
            this.f17899d = aVar;
        }

        public void a(int i11, String str) {
            e.a.a(this, i11, str);
            com.hbg.module.libkt.base.ext.b.K(this.f17899d.e().C, this.f17896a.getAvatar(), R$drawable.icon_community_user_header);
        }

        public void b(V2TIMUserFullInfo v2TIMUserFullInfo) {
            e.a.c(this, v2TIMUserFullInfo);
        }

        public void c(String str, String str2) {
            e.a.d(this, str, str2);
            LiveGroupUserListData.GroupUser groupUser = this.f17896a;
            if (str == null) {
                str = "";
            }
            groupUser.setAvatar(str);
            this.f17897b.notifyItemChanged(this.f17898c);
        }
    }

    public l(FragmentActivity fragmentActivity, String str, int i11) {
        super(fragmentActivity);
        this.f17893g = str;
        this.f17894h = i11;
    }

    @SensorsDataInstrumented
    public static final void p(l lVar, LiveGroupUserListData.GroupUser groupUser, View view) {
        int i11 = lVar.f17894h;
        if (i11 == 2 || i11 == 3) {
            lVar.n(lVar.f(), groupUser);
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    public final void n(FragmentActivity fragmentActivity, LiveGroupUserListData.GroupUser groupUser) {
        v7.b.a().M0("", groupUser.getAccount(), this.f17893g).b().compose(RxJavaHelper.t((g) null)).subscribe(new a(this));
    }

    /* renamed from: o */
    public void onBindViewHolder(c.a<e5> aVar, int i11) {
        super.onBindViewHolder(aVar, i11);
        LiveGroupUserListData.GroupUser groupUser = (LiveGroupUserListData.GroupUser) g().get(i11);
        aVar.e().M(groupUser);
        if (groupUser.getAvatar() == null) {
            f.a(groupUser.getAccount(), new b(groupUser, this, i11, aVar));
        } else {
            com.hbg.module.libkt.base.ext.b.K(aVar.e().C, groupUser.getAvatar(), R$drawable.icon_community_user_header);
        }
        int i12 = this.f17894h;
        if (i12 == 2 || i12 == 3) {
            aVar.e().F.setVisibility(8);
            aVar.e().D.setVisibility(0);
        } else {
            if (groupUser.getRole() == 2 || groupUser.getRole() == 3) {
                aVar.e().F.setVisibility(0);
            } else {
                aVar.e().F.setVisibility(8);
            }
            aVar.e().D.setVisibility(8);
        }
        aVar.e().E.setOnClickListener(new k(this, groupUser));
    }

    /* renamed from: q */
    public c.a<e5> onCreateViewHolder(ViewGroup viewGroup, int i11) {
        this.f17892f = (HbgBaseProvider) b2.a.d().a("/provider/content").navigation();
        return new c.a<>(e5.K(h(), viewGroup, false));
    }
}
