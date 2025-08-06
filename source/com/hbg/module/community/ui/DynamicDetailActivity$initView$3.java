package com.hbg.module.community.ui;

import android.view.View;
import android.widget.Checkable;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import com.hbg.lib.core.BaseModuleConfig;
import com.hbg.lib.network.hbg.core.bean.DynamicDetailInfo;
import com.hbg.lib.network.hbg.core.bean.PersonalCenterInfo;
import com.hbg.module.community.widgets.rich.RichWebView;
import com.hbg.module.libkt.base.ext.VmState;
import com.hbg.module.libkt.provider.HbgBaseProvider;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import d10.l;
import kotlin.Unit;
import kotlin.jvm.internal.Lambda;
import rd.s;

public final class DynamicDetailActivity$initView$3 extends Lambda implements l<VmState<? extends DynamicDetailInfo>, Unit> {
    public final /* synthetic */ DynamicDetailActivity this$0;

    public static final class a implements View.OnClickListener {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ View f17362b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ long f17363c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ DynamicDetailActivity f17364d;

        public a(View view, long j11, DynamicDetailActivity dynamicDetailActivity) {
            this.f17362b = view;
            this.f17363c = j11;
            this.f17364d = dynamicDetailActivity;
        }

        @SensorsDataInstrumented
        public final void onClick(View view) {
            long currentTimeMillis = System.currentTimeMillis();
            s sVar = s.f23381a;
            if (currentTimeMillis - sVar.b(this.f17362b) > this.f17363c || (this.f17362b instanceof Checkable)) {
                sVar.e(this.f17362b, currentTimeMillis);
                boolean unused = this.f17364d.Xi((RichWebView) this.f17362b);
            }
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }
    }

    public static final class b implements View.OnClickListener {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ View f17365b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ long f17366c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ DynamicDetailActivity f17367d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f17368e;

        public b(View view, long j11, DynamicDetailActivity dynamicDetailActivity, String str) {
            this.f17365b = view;
            this.f17366c = j11;
            this.f17367d = dynamicDetailActivity;
            this.f17368e = str;
        }

        @SensorsDataInstrumented
        public final void onClick(View view) {
            long currentTimeMillis = System.currentTimeMillis();
            s sVar = s.f23381a;
            if (currentTimeMillis - sVar.b(this.f17365b) > this.f17366c || (this.f17365b instanceof Checkable)) {
                sVar.e(this.f17365b, currentTimeMillis);
                AppCompatTextView appCompatTextView = (AppCompatTextView) this.f17365b;
                HbgBaseProvider fg2 = this.f17367d.fg();
                if (fg2 != null) {
                    fg2.g(this.f17368e);
                }
            }
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }
    }

    public static final class c implements View.OnClickListener {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ View f17369b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ long f17370c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ PersonalCenterInfo.LiveRoleInfo f17371d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ DynamicDetailActivity f17372e;

        public c(View view, long j11, PersonalCenterInfo.LiveRoleInfo liveRoleInfo, DynamicDetailActivity dynamicDetailActivity) {
            this.f17369b = view;
            this.f17370c = j11;
            this.f17371d = liveRoleInfo;
            this.f17372e = dynamicDetailActivity;
        }

        @SensorsDataInstrumented
        public final void onClick(View view) {
            long currentTimeMillis = System.currentTimeMillis();
            s sVar = s.f23381a;
            if (currentTimeMillis - sVar.b(this.f17369b) > this.f17370c || (this.f17369b instanceof Checkable)) {
                sVar.e(this.f17369b, currentTimeMillis);
                AppCompatImageView appCompatImageView = (AppCompatImageView) this.f17369b;
                boolean z11 = false;
                try {
                    nc.c.a("app_community_imclick", MapsKt__MapsKt.j(kotlin.l.a("groupId", this.f17371d.groupId), kotlin.l.a("uid", BaseModuleConfig.a().getUid())));
                } catch (Throwable unused) {
                }
                HbgBaseProvider fg2 = this.f17372e.fg();
                if (fg2 != null && fg2.j(this.f17372e)) {
                    z11 = true;
                }
                if (z11) {
                    PersonalCenterInfo.LiveRoleInfo liveRoleInfo = this.f17371d;
                    if (liveRoleInfo.hasJion == 1 || liveRoleInfo.hasGroup == 0) {
                        dd.b.k(dd.b.f22740a, this.f17372e, liveRoleInfo.groupId, (String) null, (String) null, 8, (Object) null);
                    } else {
                        b2.a.d().a("/webView/index").withString("url", BaseModuleConfig.a().k("live/community/privateGroup?groupId=" + this.f17371d.groupId)).navigation(this.f17372e);
                    }
                }
            }
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public DynamicDetailActivity$initView$3(DynamicDetailActivity dynamicDetailActivity) {
        super(1);
        this.this$0 = dynamicDetailActivity;
    }

    /* access modifiers changed from: private */
    public static final boolean invoke$lambda$1(DynamicDetailActivity dynamicDetailActivity, View view) {
        return dynamicDetailActivity.Yi((RichWebView) view);
    }

    /* access modifiers changed from: private */
    public static final void invoke$lambda$7$lambda$6(DynamicDetailActivity dynamicDetailActivity) {
        dynamicDetailActivity.finish();
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((VmState<? extends DynamicDetailInfo>) (VmState) obj);
        return Unit.f56620a;
    }

    /* JADX WARNING: Removed duplicated region for block: B:140:0x0360  */
    /* JADX WARNING: Removed duplicated region for block: B:141:0x0365  */
    /* JADX WARNING: Removed duplicated region for block: B:144:0x036e  */
    /* JADX WARNING: Removed duplicated region for block: B:145:0x0373  */
    /* JADX WARNING: Removed duplicated region for block: B:148:0x038a  */
    /* JADX WARNING: Removed duplicated region for block: B:149:0x038f  */
    /* JADX WARNING: Removed duplicated region for block: B:154:0x03a1  */
    /* JADX WARNING: Removed duplicated region for block: B:158:0x03fa  */
    /* JADX WARNING: Removed duplicated region for block: B:160:0x03fd  */
    /* JADX WARNING: Removed duplicated region for block: B:163:0x0419  */
    /* JADX WARNING: Removed duplicated region for block: B:164:0x041c  */
    /* JADX WARNING: Removed duplicated region for block: B:167:0x0423  */
    /* JADX WARNING: Removed duplicated region for block: B:170:0x043c  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void invoke(com.hbg.module.libkt.base.ext.VmState<? extends com.hbg.lib.network.hbg.core.bean.DynamicDetailInfo> r19) {
        /*
            r18 = this;
            r0 = r18
            r1 = r19
            com.hbg.module.community.ui.DynamicDetailActivity r2 = r0.this$0
            lc.c r2 = com.hbg.module.community.ui.DynamicDetailActivity.Mh(r2)
            com.scwang.smartrefresh.layout.SmartRefreshLayout r2 = r2.f19150e0
            r2.finishRefresh()
            com.hbg.module.community.ui.DynamicDetailActivity r2 = r0.this$0
            lc.c r2 = com.hbg.module.community.ui.DynamicDetailActivity.Mh(r2)
            com.scwang.smartrefresh.layout.SmartRefreshLayout r2 = r2.f19150e0
            r2.w()
            boolean r2 = r1 instanceof com.hbg.module.libkt.base.ext.VmState.b
            if (r2 == 0) goto L_0x0459
            com.hbg.module.community.ui.DynamicDetailActivity r2 = r0.this$0
            com.hbg.module.libkt.base.ext.VmState$b r1 = (com.hbg.module.libkt.base.ext.VmState.b) r1
            java.lang.Object r3 = r1.a()
            com.hbg.lib.network.hbg.core.bean.DynamicDetailInfo r3 = (com.hbg.lib.network.hbg.core.bean.DynamicDetailInfo) r3
            r2.f17332n = r3
            com.hbg.module.community.ui.DynamicDetailActivity r2 = r0.this$0
            lc.c r2 = com.hbg.module.community.ui.DynamicDetailActivity.Mh(r2)
            com.hbg.module.community.ui.DynamicDetailActivity r3 = r0.this$0
            com.hbg.lib.network.hbg.core.bean.DynamicDetailInfo r3 = r3.f17332n
            r2.M(r3)
            com.hbg.module.community.ui.DynamicDetailActivity r2 = r0.this$0
            lc.c r2 = com.hbg.module.community.ui.DynamicDetailActivity.Mh(r2)
            androidx.appcompat.widget.AppCompatTextView r2 = r2.f19158m0
            com.hbg.module.community.ui.DynamicDetailActivity r3 = r0.this$0
            java.lang.Object r4 = r1.a()
            com.hbg.lib.network.hbg.core.bean.DynamicDetailInfo r4 = (com.hbg.lib.network.hbg.core.bean.DynamicDetailInfo) r4
            if (r4 == 0) goto L_0x0051
            long r4 = r4.getCreatedTime()
            goto L_0x0053
        L_0x0051:
            r4 = 0
        L_0x0053:
            java.lang.String r3 = com.hbg.module.huobi.im.utils.DateUtils.f(r3, r4)
            r2.setText(r3)
            com.hbg.module.community.ui.DynamicDetailActivity r2 = r0.this$0
            r3 = 6
            kotlin.Pair[] r3 = new kotlin.Pair[r3]
            com.hbg.lib.network.hbg.core.bean.DynamicDetailInfo r4 = r2.f17332n
            if (r4 == 0) goto L_0x006a
            java.lang.String r4 = r4.getUidUnique()
            goto L_0x006b
        L_0x006a:
            r4 = 0
        L_0x006b:
            java.lang.String r6 = "uid"
            kotlin.Pair r4 = kotlin.l.a(r6, r4)
            r7 = 0
            r3[r7] = r4
            com.hbg.module.community.ui.DynamicDetailActivity r4 = r0.this$0
            com.hbg.lib.network.hbg.core.bean.DynamicDetailInfo r4 = r4.f17332n
            if (r4 == 0) goto L_0x0081
            java.lang.String r4 = r4.getTitle()
            goto L_0x0082
        L_0x0081:
            r4 = 0
        L_0x0082:
            java.lang.String r8 = "title"
            kotlin.Pair r4 = kotlin.l.a(r8, r4)
            r8 = 1
            r3[r8] = r4
            com.hbg.module.community.ui.DynamicDetailActivity r4 = r0.this$0
            com.hbg.lib.network.hbg.core.bean.DynamicDetailInfo r4 = r4.f17332n
            if (r4 == 0) goto L_0x0098
            java.lang.String r4 = r4.getId()
            goto L_0x0099
        L_0x0098:
            r4 = 0
        L_0x0099:
            java.lang.String r9 = "communityId"
            kotlin.Pair r4 = kotlin.l.a(r9, r4)
            r9 = 2
            r3[r9] = r4
            com.hbg.module.community.ui.DynamicDetailActivity r4 = r0.this$0
            com.hbg.lib.network.hbg.core.bean.DynamicDetailInfo r4 = r4.f17332n
            if (r4 == 0) goto L_0x00b3
            int r4 = r4.getType()
            java.lang.Integer r4 = java.lang.Integer.valueOf(r4)
            goto L_0x00b4
        L_0x00b3:
            r4 = 0
        L_0x00b4:
            java.lang.String r10 = "type"
            kotlin.Pair r4 = kotlin.l.a(r10, r4)
            r10 = 3
            r3[r10] = r4
            r4 = 4
            com.hbg.module.community.ui.DynamicDetailActivity r11 = r0.this$0
            com.hbg.lib.network.hbg.core.bean.DynamicDetailInfo r11 = r11.f17332n
            if (r11 == 0) goto L_0x00cf
            int r11 = r11.getPraiseNum()
            java.lang.Integer r11 = java.lang.Integer.valueOf(r11)
            goto L_0x00d0
        L_0x00cf:
            r11 = 0
        L_0x00d0:
            java.lang.String r12 = "praiseNum"
            kotlin.Pair r11 = kotlin.l.a(r12, r11)
            r3[r4] = r11
            r4 = 5
            com.hbg.module.community.ui.DynamicDetailActivity r11 = r0.this$0
            com.hbg.lib.network.hbg.core.bean.DynamicDetailInfo r11 = r11.f17332n
            if (r11 == 0) goto L_0x00ea
            int r11 = r11.getCommentNum()
            java.lang.Integer r11 = java.lang.Integer.valueOf(r11)
            goto L_0x00eb
        L_0x00ea:
            r11 = 0
        L_0x00eb:
            java.lang.String r12 = "commentNum"
            kotlin.Pair r11 = kotlin.l.a(r12, r11)
            r3[r4] = r11
            java.util.HashMap r3 = kotlin.collections.MapsKt__MapsKt.j(r3)
            r2.f17336r = r3
            com.hbg.module.community.ui.DynamicDetailActivity r2 = r0.this$0
            boolean r2 = r2.f17337s
            if (r2 == 0) goto L_0x0112
            com.hbg.module.community.ui.DynamicDetailActivity r2 = r0.this$0
            java.util.HashMap r2 = r2.f17336r
            java.lang.String r3 = "app_community_tzxq"
            nc.c.a(r3, r2)
            com.hbg.module.community.ui.DynamicDetailActivity r2 = r0.this$0
            r2.f17337s = r7
        L_0x0112:
            com.hbg.module.community.ui.DynamicDetailActivity r2 = r0.this$0
            com.hbg.module.huobi.im.view.AvatarView[] r3 = new com.hbg.module.huobi.im.view.AvatarView[r8]
            lc.c r4 = com.hbg.module.community.ui.DynamicDetailActivity.Mh(r2)
            com.hbg.module.huobi.im.view.AvatarView r4 = r4.K
            r3[r7] = r4
            r2.Oi(r3)
            com.hbg.module.community.ui.DynamicDetailActivity r2 = r0.this$0
            lc.c r2 = com.hbg.module.community.ui.DynamicDetailActivity.Mh(r2)
            android.widget.LinearLayout r2 = r2.T
            r2.setVisibility(r7)
            com.hbg.module.community.ui.DynamicDetailActivity r2 = r0.this$0
            com.hbg.lib.network.hbg.core.bean.DynamicDetailInfo r2 = r2.f17332n
            if (r2 == 0) goto L_0x013c
            int r2 = r2.getTextType()
            if (r2 != r8) goto L_0x013c
            r2 = r8
            goto L_0x013d
        L_0x013c:
            r2 = r7
        L_0x013d:
            java.lang.String r3 = ""
            r4 = 8
            if (r2 == 0) goto L_0x01f1
            com.hbg.module.community.ui.DynamicDetailActivity r2 = r0.this$0
            r2.Bi()
            com.hbg.module.community.ui.DynamicDetailActivity r2 = r0.this$0
            lc.c r2 = com.hbg.module.community.ui.DynamicDetailActivity.Mh(r2)
            com.hbg.module.community.widgets.rich.RichWebView r2 = r2.Z
            com.hbg.module.community.ui.DynamicDetailActivity$b r11 = new com.hbg.module.community.ui.DynamicDetailActivity$b
            com.hbg.module.community.ui.DynamicDetailActivity r12 = r0.this$0
            v6.u r13 = r12.f17341w
            r11.<init>(r13)
            r2.setWebChromeClient(r11)
            com.hbg.module.community.ui.DynamicDetailActivity r2 = r0.this$0
            lc.c r2 = com.hbg.module.community.ui.DynamicDetailActivity.Mh(r2)
            androidx.appcompat.widget.AppCompatTextView r2 = r2.f19157l0
            r2.setVisibility(r4)
            rd.s r2 = rd.s.f23381a
            com.hbg.module.community.ui.DynamicDetailActivity r2 = r0.this$0
            lc.c r2 = com.hbg.module.community.ui.DynamicDetailActivity.Mh(r2)
            com.hbg.module.community.widgets.rich.RichWebView r2 = r2.Z
            com.hbg.module.community.ui.DynamicDetailActivity r11 = r0.this$0
            r12 = 800(0x320, double:3.953E-321)
            com.hbg.module.community.ui.DynamicDetailActivity$initView$3$a r14 = new com.hbg.module.community.ui.DynamicDetailActivity$initView$3$a
            r14.<init>(r2, r12, r11)
            r2.setOnClickListener(r14)
            com.hbg.module.community.ui.DynamicDetailActivity r2 = r0.this$0
            lc.c r2 = com.hbg.module.community.ui.DynamicDetailActivity.Mh(r2)
            com.hbg.module.community.widgets.rich.RichWebView r2 = r2.Z
            com.hbg.module.community.ui.DynamicDetailActivity r11 = r0.this$0
            com.hbg.module.community.ui.h r12 = new com.hbg.module.community.ui.h
            r12.<init>(r11)
            r2.setOnLongClickListener(r12)
            com.hbg.module.community.ui.DynamicDetailActivity r2 = r0.this$0
            com.hbg.lib.network.hbg.core.bean.DynamicDetailInfo r2 = r2.f17332n
            if (r2 != 0) goto L_0x019a
            goto L_0x01dc
        L_0x019a:
            com.hbg.module.community.ui.DynamicDetailActivity r11 = r0.this$0
            com.hbg.lib.network.hbg.core.bean.DynamicDetailInfo r11 = r11.f17332n
            if (r11 == 0) goto L_0x01d8
            java.lang.String r12 = r11.getRichText()
            if (r12 == 0) goto L_0x01d8
            java.lang.StringBuilder r11 = new java.lang.StringBuilder
            r11.<init>()
            java.lang.String r13 = "<video poster=\""
            r11.append(r13)
            com.hbg.module.community.ui.DynamicDetailActivity r13 = r0.this$0
            com.hbg.lib.network.hbg.core.bean.DynamicDetailInfo r13 = r13.f17332n
            if (r13 == 0) goto L_0x01bf
            java.lang.String r13 = r13.getVideoImage()
            goto L_0x01c0
        L_0x01bf:
            r13 = 0
        L_0x01c0:
            r11.append(r13)
            java.lang.String r13 = "\" controls controlsList=\"nodownload\""
            r11.append(r13)
            java.lang.String r14 = r11.toString()
            r15 = 0
            r16 = 4
            r17 = 0
            java.lang.String r13 = "<video controls=\"\""
            java.lang.String r11 = kotlin.text.StringsKt__StringsJVMKt.G(r12, r13, r14, r15, r16, r17)
            goto L_0x01d9
        L_0x01d8:
            r11 = 0
        L_0x01d9:
            r2.setRichText(r11)
        L_0x01dc:
            com.hbg.module.community.ui.DynamicDetailActivity r2 = r0.this$0
            com.hbg.lib.network.hbg.core.bean.DynamicDetailInfo r11 = r2.f17332n
            if (r11 == 0) goto L_0x01e9
            java.lang.String r11 = r11.getRichText()
            goto L_0x01ea
        L_0x01e9:
            r11 = 0
        L_0x01ea:
            if (r11 != 0) goto L_0x01ed
            r11 = r3
        L_0x01ed:
            r2.Ri(r11)
            goto L_0x0236
        L_0x01f1:
            com.hbg.module.community.ui.DynamicDetailActivity r2 = r0.this$0
            com.hbg.lib.network.hbg.core.bean.DynamicDetailInfo r2 = r2.f17332n
            if (r2 == 0) goto L_0x0201
            int r2 = r2.getTextType()
            if (r2 != r9) goto L_0x0201
            r2 = r8
            goto L_0x0202
        L_0x0201:
            r2 = r7
        L_0x0202:
            if (r2 == 0) goto L_0x020a
            com.hbg.module.community.ui.DynamicDetailActivity r2 = r0.this$0
            r2.Mi()
            goto L_0x0236
        L_0x020a:
            com.hbg.module.community.ui.DynamicDetailActivity r2 = r0.this$0
            r2.Ci()
            com.hbg.module.community.ui.DynamicDetailActivity r2 = r0.this$0
            com.hbg.lib.network.hbg.core.bean.DynamicDetailInfo r2 = r2.f17332n
            if (r2 == 0) goto L_0x021c
            java.lang.String r2 = r2.getContent()
            goto L_0x021d
        L_0x021c:
            r2 = 0
        L_0x021d:
            if (r2 == 0) goto L_0x0228
            int r2 = r2.length()
            if (r2 != 0) goto L_0x0226
            goto L_0x0228
        L_0x0226:
            r2 = r7
            goto L_0x0229
        L_0x0228:
            r2 = r8
        L_0x0229:
            if (r2 != 0) goto L_0x0236
            com.hbg.module.community.ui.DynamicDetailActivity r2 = r0.this$0
            lc.c r2 = com.hbg.module.community.ui.DynamicDetailActivity.Mh(r2)
            androidx.appcompat.widget.AppCompatTextView r2 = r2.f19157l0
            r2.setVisibility(r7)
        L_0x0236:
            java.lang.Object r1 = r1.a()
            com.hbg.lib.network.hbg.core.bean.DynamicDetailInfo r1 = (com.hbg.lib.network.hbg.core.bean.DynamicDetailInfo) r1
            if (r1 == 0) goto L_0x0247
            com.hbg.module.community.ui.DynamicDetailActivity r2 = r0.this$0
            lc.c r11 = com.hbg.module.community.ui.DynamicDetailActivity.Mh(r2)
            r2.Pi(r1, r11)
        L_0x0247:
            com.hbg.module.community.ui.DynamicDetailActivity r1 = r0.this$0
            com.hbg.lib.network.hbg.core.bean.DynamicDetailInfo r1 = r1.f17332n
            if (r1 == 0) goto L_0x0254
            com.hbg.lib.network.hbg.core.bean.CommonPkData r1 = r1.getVote()
            goto L_0x0255
        L_0x0254:
            r1 = 0
        L_0x0255:
            if (r1 == 0) goto L_0x0277
            com.hbg.module.community.ui.DynamicDetailActivity r1 = r0.this$0
            lc.c r1 = com.hbg.module.community.ui.DynamicDetailActivity.Mh(r1)
            com.hbg.module.libkt.common.PkCommonView r1 = r1.W
            com.hbg.module.community.ui.DynamicDetailActivity r2 = r0.this$0
            com.hbg.lib.network.hbg.core.bean.DynamicDetailInfo r2 = r2.f17332n
            com.hbg.lib.network.hbg.core.bean.CommonPkData r2 = r2.getVote()
            r1.setView(r2)
            com.hbg.module.community.ui.DynamicDetailActivity r1 = r0.this$0
            lc.c r1 = com.hbg.module.community.ui.DynamicDetailActivity.Mh(r1)
            com.hbg.module.libkt.common.PkCommonView r1 = r1.W
            r1.setVisibility(r7)
        L_0x0277:
            com.hbg.module.community.ui.DynamicDetailActivity r1 = r0.this$0
            com.hbg.lib.network.hbg.core.bean.DynamicDetailInfo r1 = r1.f17332n
            if (r1 == 0) goto L_0x0284
            int r1 = r1.getShareType()
            goto L_0x0285
        L_0x0284:
            r1 = r7
        L_0x0285:
            com.hbg.module.community.ui.DynamicDetailActivity r2 = r0.this$0
            com.hbg.lib.network.hbg.core.bean.DynamicDetailInfo r2 = r2.f17332n
            if (r2 == 0) goto L_0x0292
            java.lang.String r2 = r2.getShareLink()
            goto L_0x0293
        L_0x0292:
            r2 = 0
        L_0x0293:
            if (r2 == 0) goto L_0x029e
            int r2 = r2.length()
            if (r2 != 0) goto L_0x029c
            goto L_0x029e
        L_0x029c:
            r2 = r7
            goto L_0x029f
        L_0x029e:
            r2 = r8
        L_0x029f:
            if (r2 != 0) goto L_0x02b8
            if (r1 <= 0) goto L_0x02b8
            com.hbg.module.community.ui.DynamicDetailActivity r1 = r0.this$0
            lc.c r1 = com.hbg.module.community.ui.DynamicDetailActivity.Mh(r1)
            lc.i3 r1 = r1.f19151f0
            android.view.View r1 = r1.getRoot()
            r1.setVisibility(r7)
            com.hbg.module.community.ui.DynamicDetailActivity r1 = r0.this$0
            r1.Fi()
            goto L_0x02c7
        L_0x02b8:
            com.hbg.module.community.ui.DynamicDetailActivity r1 = r0.this$0
            lc.c r1 = com.hbg.module.community.ui.DynamicDetailActivity.Mh(r1)
            lc.i3 r1 = r1.f19151f0
            android.view.View r1 = r1.getRoot()
            r1.setVisibility(r4)
        L_0x02c7:
            com.hbg.module.community.ui.DynamicDetailActivity r1 = r0.this$0
            com.hbg.lib.network.hbg.core.bean.DynamicDetailInfo r1 = r1.f17332n
            if (r1 == 0) goto L_0x02d4
            int r1 = r1.getJumpType()
            goto L_0x02d5
        L_0x02d4:
            r1 = r7
        L_0x02d5:
            com.hbg.module.community.ui.DynamicDetailActivity r2 = r0.this$0
            com.hbg.lib.network.hbg.core.bean.DynamicDetailInfo r2 = r2.f17332n
            if (r2 == 0) goto L_0x02e2
            java.lang.String r2 = r2.getShareLinkTitle()
            goto L_0x02e3
        L_0x02e2:
            r2 = 0
        L_0x02e3:
            if (r2 != 0) goto L_0x02e6
            r2 = r3
        L_0x02e6:
            com.hbg.module.community.ui.DynamicDetailActivity r11 = r0.this$0
            com.hbg.lib.network.hbg.core.bean.DynamicDetailInfo r11 = r11.f17332n
            if (r11 == 0) goto L_0x02f3
            java.lang.String r11 = r11.getShareLink()
            goto L_0x02f4
        L_0x02f3:
            r11 = 0
        L_0x02f4:
            if (r11 != 0) goto L_0x02f9
            r17 = r3
            goto L_0x02fb
        L_0x02f9:
            r17 = r11
        L_0x02fb:
            if (r1 == r8) goto L_0x0301
            if (r1 == r9) goto L_0x0301
            if (r1 != r10) goto L_0x0348
        L_0x0301:
            int r1 = r2.length()
            if (r1 <= 0) goto L_0x0309
            r1 = r8
            goto L_0x030a
        L_0x0309:
            r1 = r7
        L_0x030a:
            if (r1 == 0) goto L_0x0348
            int r1 = r17.length()
            if (r1 <= 0) goto L_0x0314
            r1 = r8
            goto L_0x0315
        L_0x0314:
            r1 = r7
        L_0x0315:
            if (r1 == 0) goto L_0x0348
            com.hbg.module.community.ui.DynamicDetailActivity r1 = r0.this$0
            lc.c r1 = com.hbg.module.community.ui.DynamicDetailActivity.Mh(r1)
            androidx.appcompat.widget.AppCompatTextView r1 = r1.f19154i0
            r1.setText(r2)
            rd.s r1 = rd.s.f23381a
            com.hbg.module.community.ui.DynamicDetailActivity r1 = r0.this$0
            lc.c r1 = com.hbg.module.community.ui.DynamicDetailActivity.Mh(r1)
            androidx.appcompat.widget.AppCompatTextView r1 = r1.f19154i0
            com.hbg.module.community.ui.DynamicDetailActivity r2 = r0.this$0
            r14 = 800(0x320, double:3.953E-321)
            com.hbg.module.community.ui.DynamicDetailActivity$initView$3$b r3 = new com.hbg.module.community.ui.DynamicDetailActivity$initView$3$b
            r12 = r3
            r13 = r1
            r16 = r2
            r12.<init>(r13, r14, r16, r17)
            r1.setOnClickListener(r3)
            com.hbg.module.community.ui.DynamicDetailActivity r1 = r0.this$0
            lc.c r1 = com.hbg.module.community.ui.DynamicDetailActivity.Mh(r1)
            androidx.appcompat.widget.AppCompatTextView r1 = r1.f19154i0
            r1.setVisibility(r7)
            goto L_0x0353
        L_0x0348:
            com.hbg.module.community.ui.DynamicDetailActivity r1 = r0.this$0
            lc.c r1 = com.hbg.module.community.ui.DynamicDetailActivity.Mh(r1)
            androidx.appcompat.widget.AppCompatTextView r1 = r1.f19154i0
            r1.setVisibility(r4)
        L_0x0353:
            com.hbg.module.community.ui.DynamicDetailActivity r1 = r0.this$0
            r1.wi()
            com.hbg.module.community.ui.DynamicDetailActivity r1 = r0.this$0
            com.hbg.lib.network.hbg.core.bean.DynamicDetailInfo r2 = r1.f17332n
            if (r2 == 0) goto L_0x0365
            int r2 = r2.getFocusStatus()
            goto L_0x0366
        L_0x0365:
            r2 = r7
        L_0x0366:
            com.hbg.module.community.ui.DynamicDetailActivity r3 = r0.this$0
            com.hbg.lib.network.hbg.core.bean.DynamicDetailInfo r3 = r3.f17332n
            if (r3 == 0) goto L_0x0373
            int r3 = r3.getIsSelf()
            goto L_0x0374
        L_0x0373:
            r3 = r7
        L_0x0374:
            r1.Qi(r2, r3)
            com.hbg.module.community.ui.DynamicDetailActivity r1 = r0.this$0
            lc.c r1 = com.hbg.module.community.ui.DynamicDetailActivity.Mh(r1)
            com.hbg.lib.widgets.LoadingLayout r1 = r1.R
            r1.g()
            com.hbg.module.community.ui.DynamicDetailActivity r1 = r0.this$0
            com.hbg.lib.network.hbg.core.bean.DynamicDetailInfo r2 = r1.f17332n
            if (r2 == 0) goto L_0x038f
            int r2 = r2.getPraiseStatus()
            goto L_0x0390
        L_0x038f:
            r2 = r7
        L_0x0390:
            r1.Ui(r2)
            com.hbg.module.community.ui.DynamicDetailActivity r1 = r0.this$0
            com.hbg.lib.network.hbg.core.bean.DynamicDetailInfo r1 = r1.f17332n
            if (r1 == 0) goto L_0x03fa
            com.hbg.lib.network.hbg.core.bean.PersonalCenterInfo$LiveRoleInfo r1 = r1.getLiveRoleInfo()
            if (r1 == 0) goto L_0x03fa
            com.hbg.module.community.ui.DynamicDetailActivity r2 = r0.this$0
            java.lang.String r3 = r1.groupId
            boolean r3 = com.hbg.module.libkt.base.ext.b.x(r3)
            if (r3 != 0) goto L_0x03f7
            rd.s r3 = rd.s.f23381a
            lc.c r3 = com.hbg.module.community.ui.DynamicDetailActivity.Mh(r2)
            androidx.appcompat.widget.AppCompatImageView r3 = r3.L
            r12 = 800(0x320, double:3.953E-321)
            com.hbg.module.community.ui.DynamicDetailActivity$initView$3$c r15 = new com.hbg.module.community.ui.DynamicDetailActivity$initView$3$c
            r10 = r15
            r11 = r3
            r14 = r1
            r5 = r15
            r15 = r2
            r10.<init>(r11, r12, r14, r15)
            r3.setOnClickListener(r5)
            lc.c r3 = com.hbg.module.community.ui.DynamicDetailActivity.Mh(r2)
            androidx.appcompat.widget.AppCompatImageView r3 = r3.L
            r3.setVisibility(r7)
            lc.c r2 = com.hbg.module.community.ui.DynamicDetailActivity.Mh(r2)
            android.view.View r2 = r2.I0
            r2.setVisibility(r7)
            kotlin.Pair[] r2 = new kotlin.Pair[r9]
            java.lang.String r1 = r1.groupId
            java.lang.String r3 = "groupId"
            kotlin.Pair r1 = kotlin.l.a(r3, r1)
            r2[r7] = r1
            com.hbg.lib.core.BaseModuleConfig$a r1 = com.hbg.lib.core.BaseModuleConfig.a()
            java.lang.String r1 = r1.getUid()
            kotlin.Pair r1 = kotlin.l.a(r6, r1)
            r2[r8] = r1
            java.util.HashMap r1 = kotlin.collections.MapsKt__MapsKt.j(r2)
            java.lang.String r2 = "app_community_imshow"
            nc.c.a(r2, r1)
        L_0x03f7:
            kotlin.Unit r1 = kotlin.Unit.f56620a
            goto L_0x03fb
        L_0x03fa:
            r1 = 0
        L_0x03fb:
            if (r1 != 0) goto L_0x0411
            com.hbg.module.community.ui.DynamicDetailActivity r1 = r0.this$0
            lc.c r2 = com.hbg.module.community.ui.DynamicDetailActivity.Mh(r1)
            androidx.appcompat.widget.AppCompatImageView r2 = r2.L
            r2.setVisibility(r4)
            lc.c r1 = com.hbg.module.community.ui.DynamicDetailActivity.Mh(r1)
            android.view.View r1 = r1.I0
            r1.setVisibility(r4)
        L_0x0411:
            com.hbg.module.community.ui.DynamicDetailActivity r1 = r0.this$0
            com.hbg.lib.network.hbg.core.bean.DynamicDetailInfo r1 = r1.f17332n
            if (r1 == 0) goto L_0x041c
            java.util.List<com.hbg.lib.network.hbg.core.bean.NewFlashInformationCoinTags> r5 = r1.coinTags
            goto L_0x041d
        L_0x041c:
            r5 = 0
        L_0x041d:
            boolean r1 = com.hbg.module.libkt.base.ext.b.w(r5)
            if (r1 != 0) goto L_0x0428
            com.hbg.module.community.ui.DynamicDetailActivity r1 = r0.this$0
            r1.zi()
        L_0x0428:
            com.hbg.module.community.ui.DynamicDetailActivity r1 = r0.this$0
            android.content.res.Resources r1 = r1.getResources()
            int r2 = com.hbg.module.content.R$string.n_community_reply_number
            java.lang.String r8 = r1.getString(r2)
            com.hbg.module.community.ui.DynamicDetailActivity r1 = r0.this$0
            com.hbg.lib.network.hbg.core.bean.DynamicDetailInfo r1 = r1.f17332n
            if (r1 == 0) goto L_0x0440
            int r7 = r1.getCommentNum()
        L_0x0440:
            com.hbg.module.community.ui.DynamicDetailActivity r1 = r0.this$0
            lc.c r1 = com.hbg.module.community.ui.DynamicDetailActivity.Mh(r1)
            androidx.appcompat.widget.AppCompatTextView r1 = r1.f19155j0
            java.lang.String r10 = java.lang.String.valueOf(r7)
            r11 = 0
            r12 = 4
            r13 = 0
            java.lang.String r9 = "%s"
            java.lang.String r2 = kotlin.text.StringsKt__StringsJVMKt.G(r8, r9, r10, r11, r12, r13)
            r1.setText(r2)
            goto L_0x04a1
        L_0x0459:
            boolean r2 = r1 instanceof com.hbg.module.libkt.base.ext.VmState.a
            if (r2 == 0) goto L_0x0496
            com.hbg.module.community.ui.DynamicDetailActivity r2 = r0.this$0
            lc.c r2 = com.hbg.module.community.ui.DynamicDetailActivity.Mh(r2)
            com.hbg.lib.widgets.LoadingLayout r2 = r2.R
            r2.k()
            com.hbg.module.libkt.base.ext.VmState$a r1 = (com.hbg.module.libkt.base.ext.VmState.a) r1
            com.hbg.lib.network.retrofit.exception.APIStatusErrorException r1 = r1.a()
            if (r1 == 0) goto L_0x04a1
            com.hbg.module.community.ui.DynamicDetailActivity r2 = r0.this$0
            java.lang.String r3 = r1.getErrMsg()
            com.hbg.lib.widgets.utils.HuobiToastUtil.i(r3)
            java.lang.String r1 = r1.getErrCode()
            java.lang.String r3 = "2103"
            boolean r1 = kotlin.jvm.internal.x.b(r1, r3)
            if (r1 == 0) goto L_0x04a1
            android.os.Handler r1 = r2.Zf()
            if (r1 == 0) goto L_0x04a1
            com.hbg.module.community.ui.i r3 = new com.hbg.module.community.ui.i
            r3.<init>(r2)
            r4 = 2000(0x7d0, double:9.88E-321)
            r1.postDelayed(r3, r4)
            goto L_0x04a1
        L_0x0496:
            com.hbg.module.community.ui.DynamicDetailActivity r1 = r0.this$0
            lc.c r1 = com.hbg.module.community.ui.DynamicDetailActivity.Mh(r1)
            com.hbg.lib.widgets.LoadingLayout r1 = r1.R
            r1.k()
        L_0x04a1:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.hbg.module.community.ui.DynamicDetailActivity$initView$3.invoke(com.hbg.module.libkt.base.ext.VmState):void");
    }
}
