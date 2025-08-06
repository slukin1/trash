package com.hbg.module.community.ui;

import android.annotation.SuppressLint;
import android.os.Build;
import android.text.TextUtils;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Checkable;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.MutableLiveData;
import com.alibaba.android.arouter.facade.Postcard;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.fastjson.JSON;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.tabs.TabLayout;
import com.hbg.lib.core.BaseModuleConfig;
import com.hbg.lib.core.util.NightHelper;
import com.hbg.lib.network.hbg.IHbgApi;
import com.hbg.lib.network.hbg.core.bean.PersonalCenterInfo;
import com.hbg.lib.network.hbg.core.bean.TopicDetailInfo;
import com.hbg.lib.widgets.AutoSizeTextView;
import com.hbg.module.community.ui.PersonalCenterChildFragment;
import com.hbg.module.content.R$color;
import com.hbg.module.content.R$dimen;
import com.hbg.module.content.R$drawable;
import com.hbg.module.content.R$string;
import com.hbg.module.huobi.im.view.AvatarView;
import com.hbg.module.libkt.base.ext.RequestExtKt;
import com.hbg.module.libkt.base.ui.BaseActivity;
import com.hbg.module.libkt.provider.HbgBaseProvider;
import com.hbg.module.libkt.utils.o;
import com.hbg.module.livesquare.ui.LiveSquareFragment;
import com.huobi.utils.StatusBarUtils;
import com.huobi.view.roundview.RoundConstraintLayout;
import com.huobi.view.roundview.RoundTextView;
import com.huobi.view.roundview.RoundViewDelegate;
import com.huochat.community.util.NBStatusBarUtils;
import com.huochat.community.widget.expandable.StatusType;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import com.tencent.android.tpush.common.Constants;
import java.util.ArrayList;
import java.util.Map;
import kotlin.Pair;
import kotlin.jvm.internal.r;
import kotlin.l;
import lc.s;

@Route(path = "/content/PersonalCenter")
public final class PersonalCenterActivity extends BaseActivity<s> implements AppBarLayout.OnOffsetChangedListener, TabLayout.OnTabSelectedListener {

    /* renamed from: y  reason: collision with root package name */
    public static final a f17432y = new a((r) null);

    /* renamed from: i  reason: collision with root package name */
    public int f17433i = R$color.personal_center_header_bg;

    /* renamed from: j  reason: collision with root package name */
    public ArrayList<Fragment> f17434j;

    /* renamed from: k  reason: collision with root package name */
    public AppCompatImageView f17435k;

    /* renamed from: l  reason: collision with root package name */
    public AppCompatTextView f17436l;

    /* renamed from: m  reason: collision with root package name */
    public AvatarView f17437m;

    /* renamed from: n  reason: collision with root package name */
    public RoundConstraintLayout f17438n;

    /* renamed from: o  reason: collision with root package name */
    public ImageView f17439o;

    /* renamed from: p  reason: collision with root package name */
    public AutoSizeTextView f17440p;

    /* renamed from: q  reason: collision with root package name */
    public AppCompatImageView f17441q;

    /* renamed from: r  reason: collision with root package name */
    public ActionBar f17442r;

    /* renamed from: s  reason: collision with root package name */
    public PersonalCenterInfo f17443s = new PersonalCenterInfo();

    /* renamed from: t  reason: collision with root package name */
    public String f17444t;

    /* renamed from: u  reason: collision with root package name */
    public String f17445u;

    /* renamed from: v  reason: collision with root package name */
    public rj.b f17446v;

    /* renamed from: w  reason: collision with root package name */
    public boolean f17447w = true;

    /* renamed from: x  reason: collision with root package name */
    public int f17448x;

    public static final class a {
        public a() {
        }

        public /* synthetic */ a(r rVar) {
            this();
        }
    }

    public static final class b implements View.OnClickListener {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ View f17449b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ long f17450c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ PersonalCenterActivity f17451d;

        public b(View view, long j11, PersonalCenterActivity personalCenterActivity) {
            this.f17449b = view;
            this.f17450c = j11;
            this.f17451d = personalCenterActivity;
        }

        @SensorsDataInstrumented
        public final void onClick(View view) {
            long currentTimeMillis = System.currentTimeMillis();
            rd.s sVar = rd.s.f23381a;
            if (currentTimeMillis - sVar.b(this.f17449b) > this.f17450c || (this.f17449b instanceof Checkable)) {
                sVar.e(this.f17449b, currentTimeMillis);
                AppCompatImageView appCompatImageView = (AppCompatImageView) this.f17449b;
                Pair[] pairArr = new Pair[1];
                String Bh = this.f17451d.f17444t;
                if (Bh == null) {
                    Bh = null;
                }
                pairArr[0] = l.a("uid", Bh);
                nc.c.a("app_community_grzyht", MapsKt__MapsKt.j(pairArr));
                this.f17451d.finish();
            }
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }
    }

    public static final class c implements View.OnClickListener {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ View f17452b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ long f17453c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ PersonalCenterActivity f17454d;

        public c(View view, long j11, PersonalCenterActivity personalCenterActivity) {
            this.f17452b = view;
            this.f17453c = j11;
            this.f17454d = personalCenterActivity;
        }

        @SensorsDataInstrumented
        public final void onClick(View view) {
            long currentTimeMillis = System.currentTimeMillis();
            rd.s sVar = rd.s.f23381a;
            if (currentTimeMillis - sVar.b(this.f17452b) > this.f17453c || (this.f17452b instanceof Checkable)) {
                sVar.e(this.f17452b, currentTimeMillis);
                AppCompatImageView appCompatImageView = (AppCompatImageView) this.f17452b;
                PersonalCenterActivity personalCenterActivity = this.f17454d;
                String Bh = personalCenterActivity.f17444t;
                String str = null;
                if (Bh == null) {
                    Bh = null;
                }
                personalCenterActivity.Yh(Bh);
                Pair[] pairArr = new Pair[1];
                String Bh2 = this.f17454d.f17444t;
                if (Bh2 != null) {
                    str = Bh2;
                }
                pairArr[0] = l.a("uid", str);
                nc.c.a("app_community_fx", MapsKt__MapsKt.j(pairArr));
            }
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }
    }

    public static final class d implements View.OnClickListener {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ View f17455b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ long f17456c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ PersonalCenterActivity f17457d;

        public d(View view, long j11, PersonalCenterActivity personalCenterActivity) {
            this.f17455b = view;
            this.f17456c = j11;
            this.f17457d = personalCenterActivity;
        }

        @SensorsDataInstrumented
        public final void onClick(View view) {
            long currentTimeMillis = System.currentTimeMillis();
            rd.s sVar = rd.s.f23381a;
            if (currentTimeMillis - sVar.b(this.f17455b) > this.f17456c || (this.f17455b instanceof Checkable)) {
                sVar.e(this.f17455b, currentTimeMillis);
                RoundConstraintLayout roundConstraintLayout = (RoundConstraintLayout) this.f17455b;
                this.f17457d.Rh();
            }
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }
    }

    public static final class e implements View.OnClickListener {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ View f17458b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ long f17459c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ PersonalCenterActivity f17460d;

        public e(View view, long j11, PersonalCenterActivity personalCenterActivity) {
            this.f17458b = view;
            this.f17459c = j11;
            this.f17460d = personalCenterActivity;
        }

        @SensorsDataInstrumented
        public final void onClick(View view) {
            long currentTimeMillis = System.currentTimeMillis();
            rd.s sVar = rd.s.f23381a;
            if (currentTimeMillis - sVar.b(this.f17458b) > this.f17459c || (this.f17458b instanceof Checkable)) {
                sVar.e(this.f17458b, currentTimeMillis);
                LinearLayout linearLayout = (LinearLayout) this.f17458b;
                this.f17460d.Rh();
            }
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }
    }

    public static final class f implements View.OnClickListener {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ View f17461b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ long f17462c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ PersonalCenterActivity f17463d;

        public f(View view, long j11, PersonalCenterActivity personalCenterActivity) {
            this.f17461b = view;
            this.f17462c = j11;
            this.f17463d = personalCenterActivity;
        }

        @SensorsDataInstrumented
        public final void onClick(View view) {
            long currentTimeMillis = System.currentTimeMillis();
            rd.s sVar = rd.s.f23381a;
            if (currentTimeMillis - sVar.b(this.f17461b) > this.f17462c || (this.f17461b instanceof Checkable)) {
                sVar.e(this.f17461b, currentTimeMillis);
                RoundTextView roundTextView = (RoundTextView) this.f17461b;
                b2.a.d().a("/account/userInfoPage").withString(Constants.FLAG_ACCOUNT_NAME, this.f17463d.f17443s.getNickname()).navigation();
            }
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }
    }

    public static final class g implements View.OnClickListener {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ View f17464b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ long f17465c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ PersonalCenterActivity f17466d;

        public g(View view, long j11, PersonalCenterActivity personalCenterActivity) {
            this.f17464b = view;
            this.f17465c = j11;
            this.f17466d = personalCenterActivity;
        }

        @SensorsDataInstrumented
        public final void onClick(View view) {
            long currentTimeMillis = System.currentTimeMillis();
            rd.s sVar = rd.s.f23381a;
            if (currentTimeMillis - sVar.b(this.f17464b) > this.f17465c || (this.f17464b instanceof Checkable)) {
                sVar.e(this.f17464b, currentTimeMillis);
                LinearLayoutCompat linearLayoutCompat = (LinearLayoutCompat) this.f17464b;
                Pair[] pairArr = new Pair[1];
                String Bh = this.f17466d.f17444t;
                if (Bh == null) {
                    Bh = null;
                }
                pairArr[0] = l.a("uid", Bh);
                nc.c.a("app_community_grzygzdj", MapsKt__MapsKt.j(pairArr));
                PersonalCenterActivity.ai(this.f17466d, 0, 1, (Object) null);
            }
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }
    }

    public static final class h implements View.OnClickListener {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ View f17467b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ long f17468c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ PersonalCenterActivity f17469d;

        public h(View view, long j11, PersonalCenterActivity personalCenterActivity) {
            this.f17467b = view;
            this.f17468c = j11;
            this.f17469d = personalCenterActivity;
        }

        @SensorsDataInstrumented
        public final void onClick(View view) {
            long currentTimeMillis = System.currentTimeMillis();
            rd.s sVar = rd.s.f23381a;
            if (currentTimeMillis - sVar.b(this.f17467b) > this.f17468c || (this.f17467b instanceof Checkable)) {
                sVar.e(this.f17467b, currentTimeMillis);
                LinearLayoutCompat linearLayoutCompat = (LinearLayoutCompat) this.f17467b;
                Pair[] pairArr = new Pair[1];
                String Bh = this.f17469d.f17444t;
                if (Bh == null) {
                    Bh = null;
                }
                pairArr[0] = l.a("uid", Bh);
                nc.c.a("app_community_grzyfsdj", MapsKt__MapsKt.j(pairArr));
                this.f17469d.Zh(1);
            }
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }
    }

    public static final class i implements View.OnTouchListener {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ View f17470b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ long f17471c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ PersonalCenterActivity f17472d;

        public i(View view, long j11, PersonalCenterActivity personalCenterActivity) {
            this.f17470b = view;
            this.f17471c = j11;
            this.f17472d = personalCenterActivity;
        }

        public final boolean onTouch(View view, MotionEvent motionEvent) {
            long currentTimeMillis = System.currentTimeMillis();
            rd.s sVar = rd.s.f23381a;
            if (currentTimeMillis - sVar.b(this.f17470b) > this.f17471c || (this.f17470b instanceof Checkable)) {
                sVar.e(this.f17470b, currentTimeMillis);
                ImageView imageView = (ImageView) this.f17470b;
                if (this.f17472d.fg() != null) {
                    HbgBaseProvider fg2 = this.f17472d.fg();
                    if (!(fg2 != null && !fg2.j(this.f17472d))) {
                        if (wf.a.f40622a.e()) {
                            gc.b.d(gc.b.f19131a, (String) null, (TopicDetailInfo.HeaderInfo) null, (String) null, (String) null, 15, (Object) null);
                            nc.c.a("app_community_fbdj", MapsKt__MapsKt.j(l.a("pagename", "myprofile")));
                        } else {
                            gc.b.f();
                        }
                    }
                }
            }
            return true;
        }
    }

    public static final class j implements View.OnClickListener {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ View f17473b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ long f17474c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ PersonalCenterActivity f17475d;

        public j(View view, long j11, PersonalCenterActivity personalCenterActivity) {
            this.f17473b = view;
            this.f17474c = j11;
            this.f17475d = personalCenterActivity;
        }

        @SensorsDataInstrumented
        public final void onClick(View view) {
            long currentTimeMillis = System.currentTimeMillis();
            rd.s sVar = rd.s.f23381a;
            if (currentTimeMillis - sVar.b(this.f17473b) > this.f17474c || (this.f17473b instanceof Checkable)) {
                sVar.e(this.f17473b, currentTimeMillis);
                ImageView imageView = (ImageView) this.f17473b;
                dd.b bVar = dd.b.f22740a;
                PersonalCenterActivity personalCenterActivity = this.f17475d;
                bVar.h(personalCenterActivity, personalCenterActivity.f17443s.getAccount(), this.f17475d.f17443s.getNickname());
            }
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }
    }

    public static final class k implements View.OnClickListener {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ View f17476b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ long f17477c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ PersonalCenterInfo.LiveRoleInfo f17478d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ PersonalCenterActivity f17479e;

        public k(View view, long j11, PersonalCenterInfo.LiveRoleInfo liveRoleInfo, PersonalCenterActivity personalCenterActivity) {
            this.f17476b = view;
            this.f17477c = j11;
            this.f17478d = liveRoleInfo;
            this.f17479e = personalCenterActivity;
        }

        @SensorsDataInstrumented
        public final void onClick(View view) {
            long currentTimeMillis = System.currentTimeMillis();
            rd.s sVar = rd.s.f23381a;
            if (currentTimeMillis - sVar.b(this.f17476b) > this.f17477c || (this.f17476b instanceof Checkable)) {
                sVar.e(this.f17476b, currentTimeMillis);
                ImageView imageView = (ImageView) this.f17476b;
                boolean z11 = false;
                try {
                    nc.c.a("app_community_profile_imclick", MapsKt__MapsKt.j(l.a("groupId", this.f17478d.groupId), l.a("uid", BaseModuleConfig.a().getUid())));
                } catch (Throwable unused) {
                }
                HbgBaseProvider fg2 = this.f17479e.fg();
                if (fg2 != null && fg2.j(this.f17479e)) {
                    z11 = true;
                }
                if (z11) {
                    PersonalCenterInfo.LiveRoleInfo liveRoleInfo = this.f17478d;
                    if (liveRoleInfo.hasJion == 1 || liveRoleInfo.hasGroup == 0) {
                        dd.b.k(dd.b.f22740a, this.f17479e, liveRoleInfo.groupId, (String) null, (String) null, 8, (Object) null);
                    } else {
                        b2.a.d().a("/webView/index").withString("url", BaseModuleConfig.a().k("live/community/privateGroup?groupId=" + this.f17478d.groupId)).navigation(this.f17479e);
                    }
                }
            }
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }
    }

    public static final void Ph(StatusType statusType) {
        StatusType statusType2 = StatusType.STATUS_CONTRACT;
    }

    public static /* synthetic */ void Uh(PersonalCenterActivity personalCenterActivity, int i11, int i12, Object obj) {
        if ((i12 & 1) != 0) {
            i11 = 0;
        }
        personalCenterActivity.Th(i11);
    }

    public static /* synthetic */ void Wh(PersonalCenterActivity personalCenterActivity, int i11, int i12, Object obj) {
        if ((i12 & 1) != 0) {
            i11 = 0;
        }
        personalCenterActivity.Vh(i11);
    }

    public static /* synthetic */ void ai(PersonalCenterActivity personalCenterActivity, int i11, int i12, Object obj) {
        if ((i12 & 1) != 0) {
            i11 = 0;
        }
        personalCenterActivity.Zh(i11);
    }

    public static final /* synthetic */ s zh(PersonalCenterActivity personalCenterActivity) {
        return (s) personalCenterActivity.Yf();
    }

    public final void Kh() {
        sh();
        IHbgApi a11 = v7.b.a();
        String str = this.f17444t;
        if (str == null) {
            str = null;
        }
        RequestExtKt.d(a11.M0(str, this.f17445u, ""), new PersonalCenterActivity$getHeaderInfo$1(this), new PersonalCenterActivity$getHeaderInfo$2(this), (MutableLiveData) null, 4, (Object) null);
    }

    /* renamed from: Lh */
    public s Og() {
        return s.K(getLayoutInflater());
    }

    /* JADX WARNING: Code restructure failed: missing block: B:21:0x004b, code lost:
        if ("BIG_V".equals((r6 == null || (r6 = r6.getUcExtInfo()) == null) ? null : r6.showExtBusinessTag) != false) goto L_0x004f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:47:0x00b8, code lost:
        if ("BIG_V".equals((r6 == null || (r6 = r6.getUcExtInfo()) == null) ? null : r6.showExtBusinessTag) != false) goto L_0x00bc;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void Mh(com.hbg.module.huobi.im.view.AvatarView... r22) {
        /*
            r21 = this;
            r0 = r21
            r1 = r22
            int r2 = r1.length
            r3 = 0
            r4 = r3
        L_0x0007:
            if (r4 >= r2) goto L_0x00c8
            r5 = r1[r4]
            com.hbg.lib.network.hbg.core.bean.PersonalCenterInfo r6 = r0.f17443s
            java.lang.String r6 = r6.getAvatar()
            boolean r6 = com.hbg.module.libkt.base.ext.b.x(r6)
            java.lang.String r7 = "BIG_V"
            r8 = 0
            r9 = 1
            if (r6 == 0) goto L_0x0054
            if (r5 == 0) goto L_0x0028
            int r6 = com.hbg.module.content.R$drawable.account_user_image
            com.hbg.lib.network.hbg.core.bean.PersonalCenterInfo r10 = r0.f17443s
            int r10 = r10.getIsAlive()
            r5.y(r6, r10)
        L_0x0028:
            if (r5 == 0) goto L_0x00bf
            com.hbg.lib.network.hbg.core.bean.PersonalCenterInfo r6 = r0.f17443s
            if (r6 == 0) goto L_0x0036
            int r6 = r6.getIsAlive()
            if (r6 != 0) goto L_0x0036
            r6 = r9
            goto L_0x0037
        L_0x0036:
            r6 = r3
        L_0x0037:
            if (r6 == 0) goto L_0x004e
            com.hbg.lib.network.hbg.core.bean.PersonalCenterInfo r6 = r0.f17443s
            if (r6 == 0) goto L_0x0046
            com.hbg.lib.network.hbg.core.bean.PersonalCenterInfo$UcExtInfo r6 = r6.getUcExtInfo()
            if (r6 == 0) goto L_0x0046
            java.lang.String r6 = r6.showExtBusinessTag
            goto L_0x0047
        L_0x0046:
            r6 = r8
        L_0x0047:
            boolean r6 = r7.equals(r6)
            if (r6 == 0) goto L_0x004e
            goto L_0x004f
        L_0x004e:
            r9 = r3
        L_0x004f:
            r5.A(r9)
            goto L_0x00bf
        L_0x0054:
            if (r5 == 0) goto L_0x0095
            com.hbg.lib.network.hbg.core.bean.PersonalCenterInfo r6 = r0.f17443s
            java.lang.String r6 = r6.getAvatar()
            com.hbg.lib.network.hbg.core.bean.PersonalCenterInfo r10 = r0.f17443s
            com.hbg.lib.network.hbg.core.bean.PersonalCenterInfo$UcExtInfo r10 = r10.getUcExtInfo()
            java.lang.String r10 = r10.headImageType
            java.lang.String r11 = "NFT"
            boolean r10 = kotlin.jvm.internal.x.b(r10, r11)
            com.hbg.lib.network.hbg.core.bean.PersonalCenterInfo r11 = r0.f17443s
            com.hbg.lib.network.hbg.core.bean.PersonalCenterInfo$UcExtInfo r11 = r11.getUcExtInfo()
            java.lang.String r11 = r11.frameUrl
            com.hbg.module.huobi.im.view.AvatarView r12 = r5.u(r6, r10, r11)
            if (r12 == 0) goto L_0x0095
            com.hbg.lib.network.hbg.core.bean.PersonalCenterInfo r6 = r0.f17443s
            int r13 = r6.getIsAlive()
            r14 = -1
            java.lang.String r6 = r0.f17444t
            if (r6 != 0) goto L_0x0085
            r15 = r8
            goto L_0x0086
        L_0x0085:
            r15 = r6
        L_0x0086:
            java.lang.String r6 = r0.f17445u
            r17 = 0
            r18 = 0
            r19 = 48
            r20 = 0
            r16 = r6
            com.hbg.module.huobi.im.view.AvatarView.t(r12, r13, r14, r15, r16, r17, r18, r19, r20)
        L_0x0095:
            if (r5 == 0) goto L_0x00bf
            com.hbg.lib.network.hbg.core.bean.PersonalCenterInfo r6 = r0.f17443s
            if (r6 == 0) goto L_0x00a3
            int r6 = r6.getIsAlive()
            if (r6 != 0) goto L_0x00a3
            r6 = r9
            goto L_0x00a4
        L_0x00a3:
            r6 = r3
        L_0x00a4:
            if (r6 == 0) goto L_0x00bb
            com.hbg.lib.network.hbg.core.bean.PersonalCenterInfo r6 = r0.f17443s
            if (r6 == 0) goto L_0x00b3
            com.hbg.lib.network.hbg.core.bean.PersonalCenterInfo$UcExtInfo r6 = r6.getUcExtInfo()
            if (r6 == 0) goto L_0x00b3
            java.lang.String r6 = r6.showExtBusinessTag
            goto L_0x00b4
        L_0x00b3:
            r6 = r8
        L_0x00b4:
            boolean r6 = r7.equals(r6)
            if (r6 == 0) goto L_0x00bb
            goto L_0x00bc
        L_0x00bb:
            r9 = r3
        L_0x00bc:
            r5.A(r9)
        L_0x00bf:
            if (r5 == 0) goto L_0x00c4
            r5.setOnClickListener(r8)
        L_0x00c4:
            int r4 = r4 + 1
            goto L_0x0007
        L_0x00c8:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.hbg.module.community.ui.PersonalCenterActivity.Mh(com.hbg.module.huobi.im.view.AvatarView[]):void");
    }

    public final void Nh() {
        if (this.f17434j == null) {
            this.f17434j = new ArrayList<>();
        }
        ArrayList<Fragment> arrayList = this.f17434j;
        boolean z11 = false;
        if (arrayList != null && arrayList.size() == 0) {
            z11 = true;
        }
        if (z11 && this.f17443s.getTabList() != null && this.f17443s.getTabList().size() > 0) {
            for (PersonalCenterInfo.TabInfo next : this.f17443s.getTabList()) {
                String str = null;
                if (next.getId() == 3) {
                    ArrayList<Fragment> arrayList2 = this.f17434j;
                    if (arrayList2 != null) {
                        String str2 = this.f17444t;
                        if (str2 != null) {
                            str = str2;
                        }
                        arrayList2.add(LiveSquareFragment.Rh(-1, str));
                    }
                } else {
                    ArrayList<Fragment> arrayList3 = this.f17434j;
                    if (arrayList3 != null) {
                        PersonalCenterChildFragment.a aVar = PersonalCenterChildFragment.f17480x;
                        String str3 = this.f17444t;
                        if (str3 != null) {
                            str = str3;
                        }
                        arrayList3.add(aVar.a(next, str, this.f17443s.getIsSelf()));
                    }
                }
            }
            ((s) Yf()).f19318b0.setOffscreenPageLimit(this.f17443s.getTabList().size());
            ((s) Yf()).f19318b0.setAdapter(new com.hbg.module.community.adapter.s(getSupportFragmentManager(), this.f17434j, this.f17443s.getTabList()));
            ((s) Yf()).T.addOnTabSelectedListener((TabLayout.OnTabSelectedListener) this);
            ((s) Yf()).T.setupWithViewPager(((s) Yf()).f19318b0);
        }
    }

    public final void Oh() {
        ((s) Yf()).B.addOnOffsetChangedListener((AppBarLayout.OnOffsetChangedListener) this);
        AppCompatImageView appCompatImageView = this.f17435k;
        if (appCompatImageView != null) {
            rd.s sVar = rd.s.f23381a;
            appCompatImageView.setOnClickListener(new b(appCompatImageView, 800, this));
        }
        AppCompatImageView appCompatImageView2 = this.f17441q;
        if (appCompatImageView2 != null) {
            rd.s sVar2 = rd.s.f23381a;
            appCompatImageView2.setOnClickListener(new c(appCompatImageView2, 800, this));
        }
        RoundConstraintLayout roundConstraintLayout = this.f17438n;
        if (roundConstraintLayout != null) {
            rd.s sVar3 = rd.s.f23381a;
            roundConstraintLayout.setOnClickListener(new d(roundConstraintLayout, 800, this));
        }
        rd.s sVar4 = rd.s.f23381a;
        LinearLayout linearLayout = ((s) Yf()).D;
        linearLayout.setOnClickListener(new e(linearLayout, 800, this));
        RoundTextView roundTextView = ((s) Yf()).J;
        roundTextView.setOnClickListener(new f(roundTextView, 800, this));
        ((s) Yf()).Z.setExpandOrContractClickListener(l.f17558a);
        LinearLayoutCompat linearLayoutCompat = ((s) Yf()).Q;
        linearLayoutCompat.setOnClickListener(new g(linearLayoutCompat, 800, this));
        LinearLayoutCompat linearLayoutCompat2 = ((s) Yf()).P;
        linearLayoutCompat2.setOnClickListener(new h(linearLayoutCompat2, 800, this));
    }

    /* JADX WARNING: type inference failed for: r0v9, types: [android.view.View] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void Qh() {
        /*
            r6 = this;
            x1.a r0 = r6.Yf()
            lc.s r0 = (lc.s) r0
            androidx.appcompat.widget.Toolbar r0 = r0.U
            r6.setSupportActionBar(r0)
            androidx.appcompat.app.ActionBar r0 = r6.getSupportActionBar()
            r6.f17442r = r0
            android.view.LayoutInflater r0 = android.view.LayoutInflater.from(r6)
            int r1 = com.hbg.module.content.R$layout.titlebar_personal_center
            r2 = 0
            r3 = 0
            android.view.View r0 = r0.inflate(r1, r2, r3)
            r6.Xh()
            androidx.appcompat.app.ActionBar r1 = r6.f17442r
            if (r1 != 0) goto L_0x0025
            goto L_0x002a
        L_0x0025:
            r4 = 16
            r1.setDisplayOptions(r4)
        L_0x002a:
            androidx.appcompat.app.ActionBar r1 = r6.f17442r
            if (r1 == 0) goto L_0x0037
            androidx.appcompat.app.ActionBar$LayoutParams r4 = new androidx.appcompat.app.ActionBar$LayoutParams
            r5 = -1
            r4.<init>((int) r5, (int) r5)
            r1.setCustomView(r0, r4)
        L_0x0037:
            androidx.appcompat.app.ActionBar r0 = r6.f17442r
            if (r0 == 0) goto L_0x003e
            r0.setDisplayHomeAsUpEnabled(r3)
        L_0x003e:
            androidx.appcompat.app.ActionBar r0 = r6.f17442r
            if (r0 == 0) goto L_0x0047
            android.view.View r0 = r0.getCustomView()
            goto L_0x0048
        L_0x0047:
            r0 = r2
        L_0x0048:
            if (r0 == 0) goto L_0x0053
            int r1 = com.hbg.module.content.R$id.iv_personal_back
            android.view.View r1 = r0.findViewById(r1)
            androidx.appcompat.widget.AppCompatImageView r1 = (androidx.appcompat.widget.AppCompatImageView) r1
            goto L_0x0054
        L_0x0053:
            r1 = r2
        L_0x0054:
            r6.f17435k = r1
            if (r0 == 0) goto L_0x0061
            int r1 = com.hbg.module.content.R$id.iv_personal_user_icon
            android.view.View r1 = r0.findViewById(r1)
            com.hbg.module.huobi.im.view.AvatarView r1 = (com.hbg.module.huobi.im.view.AvatarView) r1
            goto L_0x0062
        L_0x0061:
            r1 = r2
        L_0x0062:
            r6.f17437m = r1
            if (r0 == 0) goto L_0x006f
            int r1 = com.hbg.module.content.R$id.tv_personal_user_nickname
            android.view.View r1 = r0.findViewById(r1)
            androidx.appcompat.widget.AppCompatTextView r1 = (androidx.appcompat.widget.AppCompatTextView) r1
            goto L_0x0070
        L_0x006f:
            r1 = r2
        L_0x0070:
            r6.f17436l = r1
            if (r0 == 0) goto L_0x007d
            int r1 = com.hbg.module.content.R$id.btnAttention
            android.view.View r1 = r0.findViewById(r1)
            com.huobi.view.roundview.RoundConstraintLayout r1 = (com.huobi.view.roundview.RoundConstraintLayout) r1
            goto L_0x007e
        L_0x007d:
            r1 = r2
        L_0x007e:
            r6.f17438n = r1
            if (r0 == 0) goto L_0x008b
            int r1 = com.hbg.module.content.R$id.imageAttentionPlus
            android.view.View r1 = r0.findViewById(r1)
            android.widget.ImageView r1 = (android.widget.ImageView) r1
            goto L_0x008c
        L_0x008b:
            r1 = r2
        L_0x008c:
            r6.f17439o = r1
            if (r0 == 0) goto L_0x0099
            int r1 = com.hbg.module.content.R$id.tvARAction
            android.view.View r1 = r0.findViewById(r1)
            com.hbg.lib.widgets.AutoSizeTextView r1 = (com.hbg.lib.widgets.AutoSizeTextView) r1
            goto L_0x009a
        L_0x0099:
            r1 = r2
        L_0x009a:
            r6.f17440p = r1
            if (r0 == 0) goto L_0x00a7
            int r1 = com.hbg.module.content.R$id.iv_personal_share
            android.view.View r0 = r0.findViewById(r1)
            r2 = r0
            androidx.appcompat.widget.AppCompatImageView r2 = (androidx.appcompat.widget.AppCompatImageView) r2
        L_0x00a7:
            r6.f17441q = r2
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.hbg.module.community.ui.PersonalCenterActivity.Qh():void");
    }

    public final void Rh() {
        if (((HbgBaseProvider) b2.a.d().a("/provider/content").navigation()).j(this)) {
            int i11 = this.f17443s.getFocusStatus() == 0 ? 1 : 0;
            sh();
            IHbgApi a11 = v7.b.a();
            Pair[] pairArr = new Pair[2];
            pairArr[0] = l.a("type", Integer.valueOf(i11));
            String str = this.f17444t;
            if (str == null) {
                str = null;
            }
            pairArr[1] = l.a("uidUnique", str);
            RequestExtKt.d(a11.requestCommunityAttention(MapsKt__MapsKt.l(pairArr)), new PersonalCenterActivity$requestFollow$1(this, i11), new PersonalCenterActivity$requestFollow$2(this), (MutableLiveData) null, 4, (Object) null);
        }
    }

    public final void Sh(boolean z11) {
        AvatarView avatarView;
        int i11 = 8;
        if (z11) {
            AvatarView avatarView2 = this.f17437m;
            if (avatarView2 != null) {
                avatarView2.setVisibility(8);
            }
            AppCompatTextView appCompatTextView = this.f17436l;
            if (appCompatTextView != null) {
                appCompatTextView.setVisibility(8);
            }
            RoundConstraintLayout roundConstraintLayout = this.f17438n;
            if (roundConstraintLayout != null) {
                roundConstraintLayout.setVisibility(8);
            }
            if (NightHelper.e().g()) {
                AppCompatImageView appCompatImageView = this.f17435k;
                if (appCompatImageView != null) {
                    appCompatImageView.setBackgroundResource(R$drawable.ic_personal_back_white);
                }
                AppCompatImageView appCompatImageView2 = this.f17441q;
                if (appCompatImageView2 != null) {
                    appCompatImageView2.setBackgroundResource(R$drawable.ic_personal_share_white);
                }
                NBStatusBarUtils.setStatusBarDarkMode(this);
                return;
            }
            AppCompatImageView appCompatImageView3 = this.f17435k;
            if (appCompatImageView3 != null) {
                appCompatImageView3.setBackgroundResource(R$drawable.ic_personal_back_black);
            }
            AppCompatImageView appCompatImageView4 = this.f17441q;
            if (appCompatImageView4 != null) {
                appCompatImageView4.setBackgroundResource(R$drawable.ic_personal_share_black);
            }
            NBStatusBarUtils.setStatusBarLightMode(this);
            return;
        }
        if (this.f17443s.getIsSelf() == 0 && (avatarView = this.f17437m) != null) {
            avatarView.setVisibility(0);
        }
        AppCompatTextView appCompatTextView2 = this.f17436l;
        if (appCompatTextView2 != null) {
            appCompatTextView2.setVisibility(0);
        }
        RoundConstraintLayout roundConstraintLayout2 = this.f17438n;
        if (roundConstraintLayout2 != null) {
            if (this.f17443s.getIsSelf() != 1) {
                i11 = 0;
            }
            roundConstraintLayout2.setVisibility(i11);
        }
        if (!NightHelper.e().g()) {
            AppCompatImageView appCompatImageView5 = this.f17435k;
            if (appCompatImageView5 != null) {
                appCompatImageView5.setBackgroundResource(R$drawable.ic_personal_back_black);
            }
            AppCompatImageView appCompatImageView6 = this.f17441q;
            if (appCompatImageView6 != null) {
                appCompatImageView6.setBackgroundResource(R$drawable.ic_personal_share_black);
            }
            NBStatusBarUtils.setStatusBarLightMode(this);
        }
    }

    public final void Th(int i11) {
        boolean z11 = true;
        if (this.f17443s.getIsSelf() == 1) {
            ((s) Yf()).D.setVisibility(8);
            HbgBaseProvider fg2 = fg();
            if (fg2 == null || !fg2.c()) {
                z11 = false;
            }
            if (!z11) {
                ((s) Yf()).J.setVisibility(0);
                ((s) Yf()).J.setText(getResources().getString(R$string.n_content_community_userinfo_edit));
                RoundViewDelegate delegate = ((s) Yf()).J.getDelegate();
                if (delegate != null) {
                    rd.s.f23381a.c(delegate, R$color.community_cell_attention_btn_background);
                }
                RoundViewDelegate delegate2 = ((s) Yf()).J.getDelegate();
                if (delegate2 != null) {
                    rd.s.f23381a.d(delegate2, R$color.community_cell_attention_btn_background);
                }
                RoundViewDelegate delegate3 = ((s) Yf()).J.getDelegate();
                if (delegate3 != null) {
                    rd.s.f23381a.f(delegate3, R$color.baseColorMajorTheme100);
                }
                RoundViewDelegate delegate4 = ((s) Yf()).J.getDelegate();
                if (delegate4 != null) {
                    rd.s.f23381a.g(delegate4, R$color.baseColorMajorTheme100);
                }
                rd.s sVar = rd.s.f23381a;
                sVar.i(((s) Yf()).J, R$color.baseColorMajorTheme100);
                RoundViewDelegate delegate5 = ((s) Yf()).J.getDelegate();
                if (delegate5 != null) {
                    sVar.h(delegate5, R$dimen.dimen_0_5);
                    return;
                }
                return;
            }
            return;
        }
        ((s) Yf()).J.setVisibility(8);
        ((s) Yf()).D.setVisibility(0);
        if (i11 == 0) {
            ((s) Yf()).K.setImageResource(R$drawable.icon_blue_plus);
            rd.s sVar2 = rd.s.f23381a;
            sVar2.i(((s) Yf()).V, R$color.baseColorMajorTheme100);
            sVar2.j(((s) Yf()).V, R$string.n_content_communityList_attention);
            return;
        }
        ((s) Yf()).K.setImageResource(R$drawable.icon_hook_focus_on);
        rd.s sVar3 = rd.s.f23381a;
        sVar3.i(((s) Yf()).V, R$color.community_cell_attentioned_text);
        sVar3.j(((s) Yf()).V, R$string.n_content_communityList_attention);
    }

    public final void Vh(int i11) {
        if (this.f17443s.getIsSelf() == 1) {
            RoundConstraintLayout roundConstraintLayout = this.f17438n;
            if (roundConstraintLayout != null) {
                roundConstraintLayout.setVisibility(8);
            }
        } else if (i11 == 0) {
            ImageView imageView = this.f17439o;
            if (imageView != null) {
                imageView.setImageResource(R$drawable.icon_blue_plus);
            }
            AutoSizeTextView autoSizeTextView = this.f17440p;
            if (autoSizeTextView != null) {
                rd.s.f23381a.i(autoSizeTextView, R$color.baseColorMajorTheme100);
            }
            AutoSizeTextView autoSizeTextView2 = this.f17440p;
            if (autoSizeTextView2 != null) {
                rd.s.f23381a.j(autoSizeTextView2, R$string.n_content_communityList_attention);
            }
        } else {
            ImageView imageView2 = this.f17439o;
            if (imageView2 != null) {
                imageView2.setImageResource(R$drawable.icon_hook_focus_on);
            }
            AutoSizeTextView autoSizeTextView3 = this.f17440p;
            if (autoSizeTextView3 != null) {
                rd.s.f23381a.i(autoSizeTextView3, R$color.community_cell_attentioned_text);
            }
            AutoSizeTextView autoSizeTextView4 = this.f17440p;
            if (autoSizeTextView4 != null) {
                rd.s.f23381a.j(autoSizeTextView4, R$string.n_content_communityList_attention);
            }
        }
    }

    public final void Xh() {
        int i11 = Build.VERSION.SDK_INT;
        if (i11 >= 19) {
            if (i11 >= 21) {
                getWindow().setStatusBarColor(0);
                getWindow().getDecorView().setSystemUiVisibility(1280);
            } else if (i11 >= 19) {
                getWindow().setFlags(67108864, 67108864);
            }
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) ((s) Yf()).U.getLayoutParams();
            marginLayoutParams.setMargins(marginLayoutParams.leftMargin, marginLayoutParams.topMargin + StatusBarUtils.a(this), marginLayoutParams.rightMargin, marginLayoutParams.bottomMargin);
        }
    }

    public final void Yh(String str) {
        Map l11 = MapsKt__MapsKt.l(l.a("avatar", this.f17443s.getAvatar()), l.a("nickName", this.f17443s.getNickname()), l.a("articleNum", Integer.valueOf(this.f17443s.getDynamicNum())), l.a("praiseNum", Integer.valueOf(this.f17443s.getPraiseForMe())), l.a("shareUrl", BaseModuleConfig.a().k("live/community/dynamic/h5?uidUnique=" + str)));
        try {
            String str2 = "postersharing.shareWithParams(`" + JSON.toJSONString(l11) + "`)";
            rj.b bVar = this.f17446v;
            if (bVar == null) {
                bVar = null;
            }
            bVar.I(str2);
        } catch (Throwable th2) {
            String message = th2.getMessage();
            if (message != null) {
                Log.e("", message);
                th2.printStackTrace();
            }
        }
    }

    public final void Zh(int i11) {
        Postcard a11 = b2.a.d().a(i11 == 1 ? "/content/FansFollowList" : "/content/UserFollowList");
        String str = this.f17444t;
        if (str == null) {
            str = null;
        }
        a11.withString("uidUnique", str).withString("isSelf", String.valueOf(this.f17443s.getIsSelf())).withString("nickname", this.f17443s.getNickname()).navigation();
    }

    public final void bi() {
        Integer num;
        Integer num2;
        if (TextUtils.isEmpty(this.f17443s.getIntro())) {
            ((s) Yf()).Z.setVisibility(8);
        } else {
            ((s) Yf()).Z.setVisibility(0);
            ((s) Yf()).Z.setContent((CharSequence) this.f17443s.getIntro(), StatusType.STATUS_EXPAND);
        }
        AppCompatTextView appCompatTextView = this.f17436l;
        if (appCompatTextView != null) {
            appCompatTextView.setText(this.f17443s.getNickname());
        }
        Mh(this.f17437m, ((s) Yf()).X);
        ((s) Yf()).W.setVisibility(8);
        if (!com.hbg.module.libkt.base.ext.b.w(this.f17443s.getRoles())) {
            Integer num3 = this.f17443s.getRoles().get(0);
            if (num3 != null && num3.intValue() == 1) {
                ((s) Yf()).X.o(this.f17443s.getRoles().get(0).intValue(), 28.0f);
            } else if (this.f17443s.getRoles().size() >= 2 && (num2 = this.f17443s.getRoles().get(1)) != null && num2.intValue() == 8) {
                ((s) Yf()).X.o(8, 28.0f);
            }
            if (this.f17443s.getRoles().size() >= 2 && (num = this.f17443s.getRoles().get(1)) != null && num.intValue() == 8) {
                ((s) Yf()).W.setVisibility(0);
            }
        }
        if (this.f17443s.getIsSelf() == 1) {
            AvatarView avatarView = this.f17437m;
            if (avatarView != null) {
                avatarView.setVisibility(8);
            }
            AppCompatTextView appCompatTextView2 = this.f17436l;
            if (appCompatTextView2 != null) {
                appCompatTextView2.setGravity(17);
            }
            AppCompatTextView appCompatTextView3 = this.f17436l;
            if (appCompatTextView3 != null) {
                appCompatTextView3.setTextSize(1, 18.0f);
            }
            Wh(this, 0, 1, (Object) null);
            Uh(this, 0, 1, (Object) null);
        } else if (this.f17443s.getFocusStatus() == 0) {
            Vh(0);
            Th(0);
        } else if (this.f17443s.getFocusStatus() == 1) {
            Vh(1);
            Th(1);
        }
        if (this.f17443s.getAccessChat() == 1) {
            ((s) Yf()).L.setVisibility(0);
            rd.s sVar = rd.s.f23381a;
            ImageView imageView = ((s) Yf()).L;
            imageView.setOnClickListener(new j(imageView, 800, this));
        }
        PersonalCenterInfo.LiveRoleInfo liveRoleInfo = this.f17443s.getLiveRoleInfo();
        if (liveRoleInfo != null && !com.hbg.module.libkt.base.ext.b.x(liveRoleInfo.groupId)) {
            ((s) Yf()).M.setVisibility(0);
            try {
                nc.c.a("app_community_profile_imopen", MapsKt__MapsKt.j(l.a("groupId", liveRoleInfo.groupId), l.a("uid", BaseModuleConfig.a().getUid())));
            } catch (Throwable unused) {
            }
            rd.s sVar2 = rd.s.f23381a;
            ImageView imageView2 = ((s) Yf()).M;
            imageView2.setOnClickListener(new k(imageView2, 800, liveRoleInfo, this));
        }
        Nh();
    }

    @SuppressLint({"SetTextI18n"})
    public void initView() {
        super.initView();
        o.f24912a.d(this, ((s) Yf()).f19317a0);
        Qh();
        Oh();
        Sh(true);
        Pair[] pairArr = new Pair[1];
        String str = this.f17444t;
        if (str == null) {
            str = null;
        }
        pairArr[0] = l.a("uid", str);
        nc.c.a("app_community_grzy", MapsKt__MapsKt.j(pairArr));
        rd.s sVar = rd.s.f23381a;
        ImageView imageView = ((s) Yf()).E;
        imageView.setOnTouchListener(new i(imageView, 800, this));
    }

    public void oh() {
        super.oh();
        String stringExtra = getIntent().getStringExtra("uidUnique");
        if (stringExtra == null) {
            stringExtra = "";
        }
        this.f17444t = stringExtra;
        this.f17445u = getIntent().getStringExtra(Constants.FLAG_ACCOUNT);
        this.f17446v = BaseModuleConfig.a().F(this, Constants.FLAG_ACCOUNT);
    }

    public void onDestroy() {
        ((s) Yf()).B.removeOnOffsetChangedListener((AppBarLayout.OnOffsetChangedListener) this);
        ((s) Yf()).T.removeOnTabSelectedListener((TabLayout.OnTabSelectedListener) this);
        BaseModuleConfig.a().C(Constants.FLAG_ACCOUNT);
        super.onDestroy();
    }

    public void onOffsetChanged(AppBarLayout appBarLayout, int i11) {
        boolean z11 = Math.abs(i11) < (appBarLayout.getTotalScrollRange() * 7) / 10;
        if (this.f17447w != z11) {
            this.f17447w = z11;
            Sh(z11);
        }
    }

    public void onResume() {
        super.onResume();
        Kh();
    }

    public void onTabReselected(TabLayout.Tab tab) {
    }

    @SensorsDataInstrumented
    public void onTabSelected(TabLayout.Tab tab) {
        ((s) Yf()).f19319c0.setContentScrimColor(ContextCompat.getColor(this, this.f17433i));
        int position = tab != null ? tab.getPosition() : 0;
        this.f17448x = position;
        if (position == 1) {
            Pair[] pairArr = new Pair[1];
            String str = this.f17444t;
            if (str == null) {
                str = null;
            }
            pairArr[0] = l.a("uid", str);
            nc.c.a("app_community_grzywz", MapsKt__MapsKt.j(pairArr));
        }
        SensorsDataAutoTrackHelper.trackTabLayoutSelected(this, tab);
    }

    public void onTabUnselected(TabLayout.Tab tab) {
    }
}
