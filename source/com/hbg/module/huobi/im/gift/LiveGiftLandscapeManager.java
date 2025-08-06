package com.hbg.module.huobi.im.gift;

import android.annotation.SuppressLint;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import androidx.fragment.app.FragmentActivity;
import com.hbg.module.huobi.im.gift.bean.CusMsgGiftSend;
import com.hbg.module.huobi.im.gift.bean.IntegralChangeBean;
import com.hbg.module.huobi.im.gift.d;
import com.hbg.module.huobi.im.gift.ui.LiveGiftShowView;
import com.hbg.module.huobi.im.gift.ui.LiveGiftTipsButton;
import com.hbg.module.huobi.im.group.ui.active.RewardsAnim;
import com.tencent.qcloud.tuikit.tuibarrage.manager.HbBarrageManager;
import com.tencent.qcloud.tuikit.tuibarrage.manager.TUIBarrageCallBack;
import java.util.HashMap;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.internal.r;

@SuppressLint({"StaticFieldLeak"})
public final class LiveGiftLandscapeManager {

    /* renamed from: a  reason: collision with root package name */
    public static final LiveGiftLandscapeManager f19698a = new LiveGiftLandscapeManager();

    /* renamed from: b  reason: collision with root package name */
    public static final String f19699b = LiveGiftLandscapeManager.class.getSimpleName();

    /* renamed from: c  reason: collision with root package name */
    public static boolean f19700c;

    /* renamed from: d  reason: collision with root package name */
    public static TUIBarrageCallBack f19701d;

    /* renamed from: e  reason: collision with root package name */
    public static String f19702e;

    /* renamed from: f  reason: collision with root package name */
    public static String f19703f;

    /* renamed from: g  reason: collision with root package name */
    public static CusMsgGiftSend f19704g;

    /* renamed from: h  reason: collision with root package name */
    public static LiveGiftTipsButton f19705h;

    /* renamed from: i  reason: collision with root package name */
    public static FrameLayout f19706i;

    /* renamed from: j  reason: collision with root package name */
    public static FrameLayout f19707j;

    /* renamed from: k  reason: collision with root package name */
    public static FrameLayout f19708k;

    /* renamed from: l  reason: collision with root package name */
    public static LiveGiftShowView f19709l;

    /* renamed from: m  reason: collision with root package name */
    public static LiveGiftShowView f19710m;

    /* renamed from: n  reason: collision with root package name */
    public static d10.a<Unit> f19711n;

    /* renamed from: o  reason: collision with root package name */
    public static d10.a<Unit> f19712o;

    /* renamed from: p  reason: collision with root package name */
    public static HashMap<String, d.c> f19713p = new HashMap<>();

    /* renamed from: q  reason: collision with root package name */
    public static HashMap<String, d.e> f19714q = new HashMap<>();

    /* renamed from: r  reason: collision with root package name */
    public static boolean f19715r = true;

    /* renamed from: s  reason: collision with root package name */
    public static g f19716s;

    public static final class a extends TUIBarrageCallBack {
        /* JADX WARNING: Code restructure failed: missing block: B:7:0x002c, code lost:
            r1 = r7.data;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void onCustomCallback(int r6, com.tencent.qcloud.tuikit.tuibarrage.model.TUIBarrageMessage r7) {
            /*
                r5 = this;
                super.onCustomCallback(r6, r7)
                boolean r6 = com.hbg.module.huobi.im.gift.LiveGiftLandscapeManager.f19700c
                if (r6 == 0) goto L_0x000a
                return
            L_0x000a:
                java.lang.String r6 = com.hbg.module.huobi.im.gift.LiveGiftLandscapeManager.f19699b
                java.lang.StringBuilder r0 = new java.lang.StringBuilder
                r0.<init>()
                java.lang.String r1 = "收到自定义消息："
                r0.append(r1)
                r0.append(r7)
                java.lang.String r0 = r0.toString()
                com.tencent.imsdk.common.IMLog.d(r6, r0)
                kotlin.Result$a r6 = kotlin.Result.Companion     // Catch:{ all -> 0x01e3 }
                com.google.gson.Gson r6 = new com.google.gson.Gson     // Catch:{ all -> 0x01e3 }
                r6.<init>()     // Catch:{ all -> 0x01e3 }
                r0 = 0
                if (r7 == 0) goto L_0x0037
                java.util.Map<java.lang.String, java.lang.Object> r1 = r7.data     // Catch:{ all -> 0x01e3 }
                if (r1 == 0) goto L_0x0037
                java.lang.String r2 = "extInfo"
                java.lang.Object r1 = r1.get(r2)     // Catch:{ all -> 0x01e3 }
                goto L_0x0038
            L_0x0037:
                r1 = r0
            L_0x0038:
                java.lang.String r6 = r6.toJson((java.lang.Object) r1)     // Catch:{ all -> 0x01e3 }
                java.lang.String r1 = com.hbg.module.huobi.im.gift.LiveGiftLandscapeManager.f19699b     // Catch:{ all -> 0x01e3 }
                java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x01e3 }
                r2.<init>()     // Catch:{ all -> 0x01e3 }
                java.lang.String r3 = "提取data json："
                r2.append(r3)     // Catch:{ all -> 0x01e3 }
                r2.append(r6)     // Catch:{ all -> 0x01e3 }
                java.lang.String r2 = r2.toString()     // Catch:{ all -> 0x01e3 }
                com.tencent.imsdk.common.IMLog.d(r1, r2)     // Catch:{ all -> 0x01e3 }
                if (r7 == 0) goto L_0x0059
                java.lang.String r1 = r7.businessID     // Catch:{ all -> 0x01e3 }
                goto L_0x005a
            L_0x0059:
                r1 = r0
            L_0x005a:
                com.hbg.module.huobi.im.utils.MessageBusinessID r2 = com.hbg.module.huobi.im.utils.MessageBusinessID.MSG_BUSINESS_ID_HUOBI_ACTIVITY_GIFT_LAB     // Catch:{ all -> 0x01e3 }
                java.lang.String r2 = r2.getValue()     // Catch:{ all -> 0x01e3 }
                boolean r2 = kotlin.jvm.internal.x.b(r1, r2)     // Catch:{ all -> 0x01e3 }
                r3 = 1
                r4 = 0
                if (r2 == 0) goto L_0x00c4
                com.google.gson.Gson r7 = new com.google.gson.Gson     // Catch:{ all -> 0x01e3 }
                r7.<init>()     // Catch:{ all -> 0x01e3 }
                java.lang.Class<com.hbg.module.huobi.im.group.ui.active.RewardsAnim> r0 = com.hbg.module.huobi.im.group.ui.active.RewardsAnim.class
                java.lang.Object r6 = r7.fromJson((java.lang.String) r6, r0)     // Catch:{ all -> 0x01e3 }
                com.hbg.module.huobi.im.group.ui.active.RewardsAnim r6 = (com.hbg.module.huobi.im.group.ui.active.RewardsAnim) r6     // Catch:{ all -> 0x01e3 }
                if (r6 == 0) goto L_0x01dd
                java.util.ArrayList r7 = r6.getAccounts()     // Catch:{ all -> 0x01e3 }
                if (r7 == 0) goto L_0x008c
                com.tencent.imsdk.v2.V2TIMManager r0 = com.tencent.imsdk.v2.V2TIMManager.getInstance()     // Catch:{ all -> 0x01e3 }
                java.lang.String r0 = r0.getLoginUser()     // Catch:{ all -> 0x01e3 }
                boolean r7 = r7.contains(r0)     // Catch:{ all -> 0x01e3 }
                if (r7 != 0) goto L_0x008c
                r4 = r3
            L_0x008c:
                if (r4 == 0) goto L_0x01dd
                com.hbg.module.huobi.im.gift.LiveGiftLandscapeManager r7 = com.hbg.module.huobi.im.gift.LiveGiftLandscapeManager.f19698a     // Catch:{ all -> 0x01e3 }
                r7.n(r6)     // Catch:{ all -> 0x01e3 }
                java.lang.Integer r7 = r6.getType()     // Catch:{ all -> 0x01e3 }
                if (r7 != 0) goto L_0x009a
                goto L_0x00ab
            L_0x009a:
                int r7 = r7.intValue()     // Catch:{ all -> 0x01e3 }
                if (r7 != 0) goto L_0x00ab
                com.hbg.module.huobi.im.manager.ActiveViewManager r7 = com.hbg.module.huobi.im.manager.ActiveViewManager.e()     // Catch:{ all -> 0x01e3 }
                com.hbg.module.huobi.im.gift.LiveGiftShowType r0 = com.hbg.module.huobi.im.gift.LiveGiftShowType.LIVE_GIFT_LANDSCAPE_SCREEN_RECEIVED     // Catch:{ all -> 0x01e3 }
                r7.i(r6, r0)     // Catch:{ all -> 0x01e3 }
                goto L_0x01dd
            L_0x00ab:
                java.lang.Integer r7 = r6.getType()     // Catch:{ all -> 0x01e3 }
                if (r7 != 0) goto L_0x00b3
                goto L_0x01dd
            L_0x00b3:
                int r7 = r7.intValue()     // Catch:{ all -> 0x01e3 }
                if (r7 != r3) goto L_0x01dd
                com.hbg.module.huobi.im.manager.ActiveViewManager r7 = com.hbg.module.huobi.im.manager.ActiveViewManager.e()     // Catch:{ all -> 0x01e3 }
                com.hbg.module.huobi.im.gift.LiveGiftShowType r0 = com.hbg.module.huobi.im.gift.LiveGiftShowType.LIVE_GIFT_LANDSCAPE_SCREEN_RECEIVED     // Catch:{ all -> 0x01e3 }
                r7.h(r6, r0)     // Catch:{ all -> 0x01e3 }
                goto L_0x01dd
            L_0x00c4:
                com.hbg.module.huobi.im.utils.MessageBusinessID r2 = com.hbg.module.huobi.im.utils.MessageBusinessID.MSG_BUSINESS_ID_HUOBI_LIVE_INTEGRAL_CHANGE     // Catch:{ all -> 0x01e3 }
                java.lang.String r2 = r2.getValue()     // Catch:{ all -> 0x01e3 }
                boolean r2 = kotlin.jvm.internal.x.b(r1, r2)     // Catch:{ all -> 0x01e3 }
                if (r2 == 0) goto L_0x00fe
                com.google.gson.Gson r7 = new com.google.gson.Gson     // Catch:{ all -> 0x01e3 }
                r7.<init>()     // Catch:{ all -> 0x01e3 }
                java.lang.Class<com.hbg.module.huobi.im.gift.bean.IntegralChangeBean> r0 = com.hbg.module.huobi.im.gift.bean.IntegralChangeBean.class
                java.lang.Object r6 = r7.fromJson((java.lang.String) r6, r0)     // Catch:{ all -> 0x01e3 }
                com.hbg.module.huobi.im.gift.bean.IntegralChangeBean r6 = (com.hbg.module.huobi.im.gift.bean.IntegralChangeBean) r6     // Catch:{ all -> 0x01e3 }
                if (r6 == 0) goto L_0x01dd
                java.util.ArrayList r7 = r6.getAccounts()     // Catch:{ all -> 0x01e3 }
                if (r7 == 0) goto L_0x00f4
                com.tencent.imsdk.v2.V2TIMManager r0 = com.tencent.imsdk.v2.V2TIMManager.getInstance()     // Catch:{ all -> 0x01e3 }
                java.lang.String r0 = r0.getLoginUser()     // Catch:{ all -> 0x01e3 }
                boolean r7 = r7.contains(r0)     // Catch:{ all -> 0x01e3 }
                if (r7 != r3) goto L_0x00f4
                goto L_0x00f5
            L_0x00f4:
                r3 = r4
            L_0x00f5:
                if (r3 == 0) goto L_0x01dd
                com.hbg.module.huobi.im.gift.LiveGiftLandscapeManager r7 = com.hbg.module.huobi.im.gift.LiveGiftLandscapeManager.f19698a     // Catch:{ all -> 0x01e3 }
                r7.m(r6)     // Catch:{ all -> 0x01e3 }
                goto L_0x01dd
            L_0x00fe:
                com.hbg.module.huobi.im.utils.MessageBusinessID r2 = com.hbg.module.huobi.im.utils.MessageBusinessID.MSG_BUSINESS_ID_GIFT     // Catch:{ all -> 0x01e3 }
                java.lang.String r2 = r2.getValue()     // Catch:{ all -> 0x01e3 }
                boolean r2 = kotlin.jvm.internal.x.b(r1, r2)     // Catch:{ all -> 0x01e3 }
                if (r2 == 0) goto L_0x0170
                com.hbg.module.huobi.im.gift.LiveGiftLandscapeManager r7 = com.hbg.module.huobi.im.gift.LiveGiftLandscapeManager.f19698a     // Catch:{ all -> 0x01e3 }
                com.google.gson.Gson r1 = new com.google.gson.Gson     // Catch:{ all -> 0x01e3 }
                r1.<init>()     // Catch:{ all -> 0x01e3 }
                java.lang.Class<com.hbg.module.huobi.im.gift.bean.CusMsgGiftSend> r2 = com.hbg.module.huobi.im.gift.bean.CusMsgGiftSend.class
                java.lang.Object r6 = r1.fromJson((java.lang.String) r6, r2)     // Catch:{ all -> 0x01e3 }
                com.hbg.module.huobi.im.gift.bean.CusMsgGiftSend r6 = (com.hbg.module.huobi.im.gift.bean.CusMsgGiftSend) r6     // Catch:{ all -> 0x01e3 }
                com.hbg.module.huobi.im.gift.LiveGiftLandscapeManager.f19704g = r6     // Catch:{ all -> 0x01e3 }
                com.hbg.module.huobi.im.gift.bean.CusMsgGiftSend r6 = com.hbg.module.huobi.im.gift.LiveGiftLandscapeManager.f19704g     // Catch:{ all -> 0x01e3 }
                if (r6 == 0) goto L_0x0127
                java.lang.Integer r6 = r6.getId()     // Catch:{ all -> 0x01e3 }
                goto L_0x0128
            L_0x0127:
                r6 = r0
            L_0x0128:
                java.lang.String r6 = java.lang.String.valueOf(r6)     // Catch:{ all -> 0x01e3 }
                com.hbg.module.huobi.im.gift.d r1 = com.hbg.module.huobi.im.gift.d.f19724a     // Catch:{ all -> 0x01e3 }
                java.lang.String r2 = r1.y()     // Catch:{ all -> 0x01e3 }
                boolean r6 = kotlin.jvm.internal.x.b(r6, r2)     // Catch:{ all -> 0x01e3 }
                if (r6 == 0) goto L_0x014a
                int r6 = r1.z()     // Catch:{ all -> 0x01e3 }
                r1 = 2
                if (r6 != r1) goto L_0x014a
                com.hbg.module.huobi.im.gift.ui.LiveGiftTipsButton r6 = com.hbg.module.huobi.im.gift.LiveGiftLandscapeManager.f19705h     // Catch:{ all -> 0x01e3 }
                if (r6 == 0) goto L_0x01dd
                r6.c()     // Catch:{ all -> 0x01e3 }
                goto L_0x01dd
            L_0x014a:
                com.hbg.module.huobi.im.gift.ui.LiveGiftTipsButton r6 = com.hbg.module.huobi.im.gift.LiveGiftLandscapeManager.f19705h     // Catch:{ all -> 0x01e3 }
                if (r6 == 0) goto L_0x015d
                com.hbg.module.huobi.im.gift.bean.CusMsgGiftSend r1 = com.hbg.module.huobi.im.gift.LiveGiftLandscapeManager.f19704g     // Catch:{ all -> 0x01e3 }
                if (r1 == 0) goto L_0x015a
                java.lang.String r0 = r1.getTitle()     // Catch:{ all -> 0x01e3 }
            L_0x015a:
                r6.e(r0)     // Catch:{ all -> 0x01e3 }
            L_0x015d:
                boolean r6 = r7.r()     // Catch:{ all -> 0x01e3 }
                if (r6 == 0) goto L_0x01dd
                r7.A(r4)     // Catch:{ all -> 0x01e3 }
                d10.a r6 = r7.k()     // Catch:{ all -> 0x01e3 }
                if (r6 == 0) goto L_0x01dd
                r6.invoke()     // Catch:{ all -> 0x01e3 }
                goto L_0x01dd
            L_0x0170:
                com.hbg.module.huobi.im.utils.MessageBusinessID r2 = com.hbg.module.huobi.im.utils.MessageBusinessID.MSG_BUSINESS_ID_GIFT_END     // Catch:{ all -> 0x01e3 }
                java.lang.String r2 = r2.getValue()     // Catch:{ all -> 0x01e3 }
                boolean r2 = kotlin.jvm.internal.x.b(r1, r2)     // Catch:{ all -> 0x01e3 }
                if (r2 == 0) goto L_0x0186
                com.hbg.module.huobi.im.gift.ui.LiveGiftTipsButton r6 = com.hbg.module.huobi.im.gift.LiveGiftLandscapeManager.f19705h     // Catch:{ all -> 0x01e3 }
                if (r6 == 0) goto L_0x01dd
                r6.c()     // Catch:{ all -> 0x01e3 }
                goto L_0x01dd
            L_0x0186:
                com.hbg.module.huobi.im.utils.MessageBusinessID r2 = com.hbg.module.huobi.im.utils.MessageBusinessID.MSG_BUSINESS_ID_GIFT_VERIFY     // Catch:{ all -> 0x01e3 }
                java.lang.String r2 = r2.getValue()     // Catch:{ all -> 0x01e3 }
                boolean r2 = kotlin.jvm.internal.x.b(r1, r2)     // Catch:{ all -> 0x01e3 }
                if (r2 != 0) goto L_0x01dd
                com.hbg.module.huobi.im.utils.MessageBusinessID r2 = com.hbg.module.huobi.im.utils.MessageBusinessID.MSG_BUSINESS_ID_HUOBI_LIVE_GIFT_REWARD_CHANGE     // Catch:{ all -> 0x01e3 }
                java.lang.String r2 = r2.getValue()     // Catch:{ all -> 0x01e3 }
                boolean r1 = kotlin.jvm.internal.x.b(r1, r2)     // Catch:{ all -> 0x01e3 }
                if (r1 == 0) goto L_0x01c1
                com.google.gson.Gson r7 = new com.google.gson.Gson     // Catch:{ all -> 0x01e3 }
                r7.<init>()     // Catch:{ all -> 0x01e3 }
                java.lang.Class<com.hbg.module.huobi.im.gift.bean.RewardStatusBean> r0 = com.hbg.module.huobi.im.gift.bean.RewardStatusBean.class
                java.lang.Object r6 = r7.fromJson((java.lang.String) r6, r0)     // Catch:{ all -> 0x01e3 }
                com.hbg.module.huobi.im.gift.bean.RewardStatusBean r6 = (com.hbg.module.huobi.im.gift.bean.RewardStatusBean) r6     // Catch:{ all -> 0x01e3 }
                if (r6 == 0) goto L_0x01dd
                com.hbg.module.huobi.im.gift.LiveGiftLandscapeManager r7 = com.hbg.module.huobi.im.gift.LiveGiftLandscapeManager.f19698a     // Catch:{ all -> 0x01e3 }
                com.hbg.module.huobi.im.gift.g r7 = r7.l()     // Catch:{ all -> 0x01e3 }
                if (r7 == 0) goto L_0x01dd
                java.lang.String r0 = r6.getGroupId()     // Catch:{ all -> 0x01e3 }
                int r6 = r6.getStatus()     // Catch:{ all -> 0x01e3 }
                r7.b(r0, r6)     // Catch:{ all -> 0x01e3 }
                goto L_0x01dd
            L_0x01c1:
                java.lang.String r6 = com.hbg.module.huobi.im.gift.LiveGiftLandscapeManager.f19699b     // Catch:{ all -> 0x01e3 }
                java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x01e3 }
                r1.<init>()     // Catch:{ all -> 0x01e3 }
                java.lang.String r2 = "businessID 错误："
                r1.append(r2)     // Catch:{ all -> 0x01e3 }
                if (r7 == 0) goto L_0x01d3
                java.lang.String r0 = r7.businessID     // Catch:{ all -> 0x01e3 }
            L_0x01d3:
                r1.append(r0)     // Catch:{ all -> 0x01e3 }
                java.lang.String r7 = r1.toString()     // Catch:{ all -> 0x01e3 }
                com.tencent.imsdk.common.IMLog.d(r6, r7)     // Catch:{ all -> 0x01e3 }
            L_0x01dd:
                kotlin.Unit r6 = kotlin.Unit.f56620a     // Catch:{ all -> 0x01e3 }
                kotlin.Result.m3072constructorimpl(r6)     // Catch:{ all -> 0x01e3 }
                goto L_0x01ed
            L_0x01e3:
                r6 = move-exception
                kotlin.Result$a r7 = kotlin.Result.Companion
                java.lang.Object r6 = kotlin.k.a(r6)
                kotlin.Result.m3072constructorimpl(r6)
            L_0x01ed:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.hbg.module.huobi.im.gift.LiveGiftLandscapeManager.a.onCustomCallback(int, com.tencent.qcloud.tuikit.tuibarrage.model.TUIBarrageMessage):void");
        }

        public void onFailed(int i11, String str) {
        }
    }

    public final void A(boolean z11) {
        f19715r = z11;
    }

    public final void B(g gVar) {
        f19716s = gVar;
    }

    public final LiveGiftShowView f() {
        return f19710m;
    }

    public final LiveGiftShowView g() {
        return f19709l;
    }

    public final HashMap<String, d.c> h() {
        return f19713p;
    }

    public final d10.a<Unit> i() {
        return f19711n;
    }

    public final HashMap<String, d.e> j() {
        return f19714q;
    }

    public final d10.a<Unit> k() {
        return f19712o;
    }

    public final g l() {
        return f19716s;
    }

    public final void m(IntegralChangeBean integralChangeBean) {
        try {
            for (Map.Entry<String, d.c> value : f19713p.entrySet()) {
                d.c cVar = (d.c) value.getValue();
                if (cVar != null) {
                    cVar.a(integralChangeBean);
                }
            }
        } catch (Exception e11) {
            e11.printStackTrace();
        }
    }

    public final void n(RewardsAnim rewardsAnim) {
        try {
            for (Map.Entry<String, d.e> value : f19714q.entrySet()) {
                d.e eVar = (d.e) value.getValue();
                if (eVar != null) {
                    eVar.a(rewardsAnim);
                }
            }
        } catch (Exception e11) {
            e11.printStackTrace();
        }
    }

    public final void o() {
        f19701d = new a();
        HbBarrageManager.getInstance().addBarrageCallBack(f19701d);
    }

    public final void p(FragmentActivity fragmentActivity) {
        f19700c = false;
        LiveGiftTipsButton liveGiftTipsButton = new LiveGiftTipsButton(fragmentActivity, (AttributeSet) null, 0, 6, (r) null);
        f19705h = liveGiftTipsButton;
        liveGiftTipsButton.setOnOpenLiveGiftClick(LiveGiftLandscapeManager$initGiftManager$1.INSTANCE);
        o();
    }

    public final void q(FragmentActivity fragmentActivity) {
        f19709l = new LiveGiftShowView(fragmentActivity, (AttributeSet) null, 2, (r) null);
        f19710m = new LiveGiftShowView(fragmentActivity, (AttributeSet) null, 2, (r) null);
    }

    public final boolean r() {
        return f19715r;
    }

    public final void s() {
        f19700c = true;
        f19701d = null;
        t(f19706i);
        f19705h = null;
        f19706i = null;
        f19713p.clear();
        f19714q.clear();
        f19716s = null;
    }

    public final void t(FrameLayout frameLayout) {
        LiveGiftTipsButton liveGiftTipsButton;
        if (frameLayout != null && (liveGiftTipsButton = f19705h) != null) {
            if (frameLayout.indexOfChild(liveGiftTipsButton) != -1) {
                LiveGiftTipsButton liveGiftTipsButton2 = f19705h;
                if (liveGiftTipsButton2 != null) {
                    liveGiftTipsButton2.c();
                }
                frameLayout.setVisibility(8);
                frameLayout.removeAllViewsInLayout();
                frameLayout.removeAllViews();
            }
        }
    }

    public final void u(String str) {
        f19703f = str;
    }

    public final void v(FrameLayout frameLayout, FrameLayout frameLayout2) {
        LiveGiftShowView liveGiftShowView;
        LiveGiftShowView liveGiftShowView2;
        f19707j = frameLayout;
        f19708k = frameLayout2;
        boolean z11 = true;
        if (!(frameLayout == null || (liveGiftShowView2 = f19709l) == null)) {
            if (!(frameLayout.indexOfChild(liveGiftShowView2) != -1)) {
                frameLayout.setVisibility(0);
                frameLayout.addView(f19709l);
            }
        }
        if (frameLayout2 != null && (liveGiftShowView = f19710m) != null) {
            if (frameLayout2.indexOfChild(liveGiftShowView) == -1) {
                z11 = false;
            }
            if (!z11) {
                frameLayout2.setVisibility(0);
                frameLayout2.addView(f19710m);
            }
        }
    }

    public final void w(FrameLayout frameLayout) {
        LiveGiftTipsButton liveGiftTipsButton;
        f19706i = frameLayout;
        if (frameLayout != null && (liveGiftTipsButton = f19705h) != null) {
            if (!(frameLayout.indexOfChild(liveGiftTipsButton) != -1)) {
                frameLayout.setVisibility(0);
                frameLayout.addView(f19705h);
            }
        }
    }

    public final void x(String str) {
        f19702e = str;
    }

    public final void y(d10.a<Unit> aVar) {
        f19711n = aVar;
    }

    public final void z(d10.a<Unit> aVar) {
        f19712o = aVar;
    }
}
