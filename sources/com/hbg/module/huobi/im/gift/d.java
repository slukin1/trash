package com.hbg.module.huobi.im.gift;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import androidx.fragment.app.FragmentActivity;
import com.google.gson.Gson;
import com.hbg.lib.core.BaseModuleConfig;
import com.hbg.lib.core.util.RxJavaHelper;
import com.hbg.lib.network.hbg.core.bean.RecommendTrader;
import com.hbg.lib.network.retrofit.exception.APIStatusErrorException;
import com.hbg.lib.network.retrofit.rxjava.BaseSubscriber;
import com.hbg.lib.widgets.utils.HuobiToastUtil;
import com.hbg.module.huobi.im.gift.bean.CusMsgGiftSend;
import com.hbg.module.huobi.im.gift.bean.CusMsgPrimeBox;
import com.hbg.module.huobi.im.gift.bean.DrawGiftBean;
import com.hbg.module.huobi.im.gift.bean.IntegralChangeBean;
import com.hbg.module.huobi.im.gift.bean.JackpotBean;
import com.hbg.module.huobi.im.gift.bean.Property;
import com.hbg.module.huobi.im.gift.ui.LiveGiftBottomDialog;
import com.hbg.module.huobi.im.gift.ui.LiveGiftDrawEmptyDialog;
import com.hbg.module.huobi.im.gift.ui.LiveGiftDrawErrorDialog;
import com.hbg.module.huobi.im.gift.ui.LiveGiftDrawSuccessDialog;
import com.hbg.module.huobi.im.gift.ui.LiveGiftFloatButton;
import com.hbg.module.huobi.im.gift.ui.LiveGiftRuleDialog;
import com.hbg.module.huobi.im.gift.ui.LiveGiftShowDialog;
import com.hbg.module.huobi.im.gift.ui.LiveGiftShowView;
import com.hbg.module.huobi.im.group.ui.active.RewardsAnim;
import com.hbg.module.huobi.im.utils.LiveGiftRule;
import com.huobi.framework.im.common.ImManager;
import com.huobi.view.button.StatusButton;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import com.tencent.imsdk.common.IMLog;
import com.tencent.qcloud.tuicore.util.ToastUtil;
import com.tencent.qcloud.tuikit.tuibarrage.manager.HbBarrageManager;
import com.tencent.qcloud.tuikit.tuibarrage.manager.TUIBarrageCallBack;
import com.twitter.sdk.android.core.internal.VineCardUtils;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.Result;
import kotlin.Unit;
import kotlin.jvm.internal.r;
import kotlin.jvm.internal.x;
import rd.q;

@SuppressLint({"StaticFieldLeak"})
public final class d {
    public static g A;
    public static b B;
    public static h C;

    /* renamed from: a  reason: collision with root package name */
    public static final d f19724a = new d();

    /* renamed from: b  reason: collision with root package name */
    public static final String f19725b = d.class.getSimpleName();

    /* renamed from: c  reason: collision with root package name */
    public static List<WeakReference<Object>> f19726c = new ArrayList();

    /* renamed from: d  reason: collision with root package name */
    public static TUIBarrageCallBack f19727d = new a();

    /* renamed from: e  reason: collision with root package name */
    public static FragmentActivity f19728e;

    /* renamed from: f  reason: collision with root package name */
    public static LiveGiftFloatButton f19729f;

    /* renamed from: g  reason: collision with root package name */
    public static LiveGiftShowView f19730g;

    /* renamed from: h  reason: collision with root package name */
    public static LiveGiftShowView f19731h;

    /* renamed from: i  reason: collision with root package name */
    public static String f19732i;

    /* renamed from: j  reason: collision with root package name */
    public static String f19733j;

    /* renamed from: k  reason: collision with root package name */
    public static String f19734k;

    /* renamed from: l  reason: collision with root package name */
    public static int f19735l = 2;

    /* renamed from: m  reason: collision with root package name */
    public static CusMsgGiftSend f19736m;

    /* renamed from: n  reason: collision with root package name */
    public static LiveGiftShowDialog f19737n;

    /* renamed from: o  reason: collision with root package name */
    public static LiveGiftBottomDialog f19738o;

    /* renamed from: p  reason: collision with root package name */
    public static final ld.f f19739p = new ld.f((ld.e) null);

    /* renamed from: q  reason: collision with root package name */
    public static d10.a<Unit> f19740q;

    /* renamed from: r  reason: collision with root package name */
    public static g f19741r;

    /* renamed from: s  reason: collision with root package name */
    public static HashMap<String, C0140d> f19742s = new HashMap<>();

    /* renamed from: t  reason: collision with root package name */
    public static HashMap<String, f> f19743t = new HashMap<>();

    /* renamed from: u  reason: collision with root package name */
    public static HashMap<String, c> f19744u = new HashMap<>();

    /* renamed from: v  reason: collision with root package name */
    public static HashMap<String, e> f19745v = new HashMap<>();

    /* renamed from: w  reason: collision with root package name */
    public static float f19746w;

    /* renamed from: x  reason: collision with root package name */
    public static float f19747x;

    /* renamed from: y  reason: collision with root package name */
    public static Handler f19748y = new Handler(Looper.getMainLooper());

    /* renamed from: z  reason: collision with root package name */
    public static boolean f19749z;

    public static final class a extends TUIBarrageCallBack {

        /* renamed from: com.hbg.module.huobi.im.gift.d$a$a  reason: collision with other inner class name */
        public static final class C0139a implements f {
            public void a(String str, String str2) {
                String d11 = d.f19725b;
                IMLog.d(d11, "观看时长无效，" + str + ',' + str2);
            }

            public void b(CusMsgGiftSend cusMsgGiftSend) {
                String d11 = d.f19725b;
                IMLog.d(d11, "观看时长有效，弹出红包：" + cusMsgGiftSend.getActiveJackpot());
                d dVar = d.f19724a;
                if (!dVar.I()) {
                    cusMsgGiftSend.getRedPotId();
                    if (cusMsgGiftSend.getRedPotId() == 0) {
                        IMLog.d(d.f19725b, "更新时间");
                        LiveGiftFloatButton C = dVar.C();
                        if (C != null) {
                            C.j(cusMsgGiftSend);
                        }
                    } else {
                        if (dVar.z() > 0) {
                            dVar.g(false);
                            LiveGiftFloatButton C2 = dVar.C();
                            if (C2 != null) {
                                C2.f();
                            }
                            LiveGiftFloatButton C3 = dVar.C();
                            if (C3 != null) {
                                C3.m();
                            }
                        } else {
                            LiveGiftFloatButton C4 = dVar.C();
                            if (C4 != null) {
                                C4.c();
                            }
                            d.h(dVar, false, 1, (Object) null);
                            dVar.Y(1);
                        }
                        LiveGiftBottomDialog l11 = dVar.l();
                        if (l11 != null) {
                            l11.dismiss();
                        }
                    }
                    dVar.b0(true);
                    return;
                }
                LiveGiftFloatButton C5 = dVar.C();
                if (C5 != null) {
                    C5.o(cusMsgGiftSend);
                }
            }
        }

        /* JADX WARNING: type inference failed for: r1v4, types: [kotlin.Unit] */
        /* JADX WARNING: type inference failed for: r1v6, types: [kotlin.Unit] */
        /* JADX WARNING: type inference failed for: r1v7, types: [kotlin.Unit] */
        /* JADX WARNING: type inference failed for: r7v14, types: [kotlin.Unit] */
        /* JADX WARNING: type inference failed for: r1v8, types: [kotlin.Unit] */
        /* JADX WARNING: type inference failed for: r7v23, types: [kotlin.Unit] */
        /* JADX WARNING: type inference failed for: r1v9, types: [kotlin.Unit] */
        /* JADX WARNING: type inference failed for: r7v32, types: [kotlin.Unit] */
        /* JADX WARNING: type inference failed for: r1v13, types: [kotlin.Unit] */
        /* JADX WARNING: type inference failed for: r7v41, types: [kotlin.Unit] */
        /* JADX WARNING: type inference failed for: r1v14, types: [kotlin.Unit] */
        /* JADX WARNING: type inference failed for: r7v48, types: [kotlin.Unit] */
        /* JADX WARNING: type inference failed for: r1v15, types: [kotlin.Unit] */
        /* JADX WARNING: type inference failed for: r1v16, types: [kotlin.Unit] */
        /* JADX WARNING: type inference failed for: r7v58 */
        /* JADX WARNING: type inference failed for: r7v62, types: [kotlin.Unit] */
        /* JADX WARNING: type inference failed for: r1v18, types: [kotlin.Unit] */
        /* JADX WARNING: type inference failed for: r1v19, types: [kotlin.Unit] */
        /* JADX WARNING: type inference failed for: r1v22, types: [kotlin.Unit] */
        /* JADX WARNING: type inference failed for: r1v25, types: [kotlin.Unit] */
        /* JADX WARNING: type inference failed for: r1v27, types: [kotlin.Unit] */
        /* JADX WARNING: type inference failed for: r1v29, types: [kotlin.Unit] */
        /* JADX WARNING: type inference failed for: r1v30, types: [kotlin.Unit] */
        /* JADX WARNING: type inference failed for: r1v31, types: [kotlin.Unit] */
        /* JADX WARNING: type inference failed for: r1v32, types: [kotlin.Unit] */
        /* JADX WARNING: Multi-variable type inference failed */
        /* JADX WARNING: No exception handlers in catch block: Catch:{  } */
        /* JADX WARNING: Removed duplicated region for block: B:14:0x0056 A[Catch:{ all -> 0x033d, all -> 0x046f }] */
        /* JADX WARNING: Removed duplicated region for block: B:15:0x0059 A[Catch:{ all -> 0x033d, all -> 0x046f }] */
        /* JADX WARNING: Removed duplicated region for block: B:18:0x0068 A[Catch:{ all -> 0x033d, all -> 0x046f }] */
        /* JADX WARNING: Removed duplicated region for block: B:39:0x00c4 A[Catch:{ all -> 0x033d, all -> 0x046f }] */
        /* JADX WARNING: Removed duplicated region for block: B:82:0x0174 A[Catch:{ all -> 0x033d, all -> 0x046f }] */
        /* JADX WARNING: Removed duplicated region for block: B:83:0x017b A[Catch:{ all -> 0x033d, all -> 0x046f }] */
        /* JADX WARNING: Unknown variable types count: 1 */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void onCustomCallback(int r7, com.tencent.qcloud.tuikit.tuibarrage.model.TUIBarrageMessage r8) {
            /*
                r6 = this;
                super.onCustomCallback(r7, r8)
                java.lang.String r7 = com.hbg.module.huobi.im.gift.d.f19725b
                java.lang.StringBuilder r0 = new java.lang.StringBuilder
                r0.<init>()
                java.lang.String r1 = "收到自定义消息："
                r0.append(r1)
                r0.append(r8)
                java.lang.String r0 = r0.toString()
                com.tencent.imsdk.common.IMLog.d(r7, r0)
                androidx.fragment.app.FragmentActivity r7 = com.hbg.module.huobi.im.gift.d.f19728e
                if (r7 != 0) goto L_0x0022
                return
            L_0x0022:
                kotlin.Result$a r7 = kotlin.Result.Companion     // Catch:{ all -> 0x046f }
                com.google.gson.Gson r7 = new com.google.gson.Gson     // Catch:{ all -> 0x046f }
                r7.<init>()     // Catch:{ all -> 0x046f }
                java.lang.String r0 = "extInfo"
                r1 = 0
                if (r8 == 0) goto L_0x0037
                java.util.Map<java.lang.String, java.lang.Object> r2 = r8.data     // Catch:{ all -> 0x046f }
                if (r2 == 0) goto L_0x0037
                java.lang.Object r2 = r2.get(r0)     // Catch:{ all -> 0x046f }
                goto L_0x0038
            L_0x0037:
                r2 = r1
            L_0x0038:
                java.lang.String r7 = r7.toJson((java.lang.Object) r2)     // Catch:{ all -> 0x046f }
                java.lang.String r2 = com.hbg.module.huobi.im.gift.d.f19725b     // Catch:{ all -> 0x046f }
                java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x046f }
                r3.<init>()     // Catch:{ all -> 0x046f }
                java.lang.String r4 = "提取data json："
                r3.append(r4)     // Catch:{ all -> 0x046f }
                r3.append(r7)     // Catch:{ all -> 0x046f }
                java.lang.String r3 = r3.toString()     // Catch:{ all -> 0x046f }
                com.tencent.imsdk.common.IMLog.d(r2, r3)     // Catch:{ all -> 0x046f }
                if (r8 == 0) goto L_0x0059
                java.lang.String r2 = r8.businessID     // Catch:{ all -> 0x046f }
                goto L_0x005a
            L_0x0059:
                r2 = r1
            L_0x005a:
                com.hbg.module.huobi.im.utils.MessageBusinessID r3 = com.hbg.module.huobi.im.utils.MessageBusinessID.MSG_BUSINESS_ID_HUOBI_ACTIVITY_GIFT_LAB     // Catch:{ all -> 0x046f }
                java.lang.String r3 = r3.getValue()     // Catch:{ all -> 0x046f }
                boolean r3 = kotlin.jvm.internal.x.b(r2, r3)     // Catch:{ all -> 0x046f }
                r4 = 1
                r5 = 0
                if (r3 == 0) goto L_0x00c4
                com.google.gson.Gson r8 = new com.google.gson.Gson     // Catch:{ all -> 0x046f }
                r8.<init>()     // Catch:{ all -> 0x046f }
                java.lang.Class<com.hbg.module.huobi.im.group.ui.active.RewardsAnim> r0 = com.hbg.module.huobi.im.group.ui.active.RewardsAnim.class
                java.lang.Object r7 = r8.fromJson((java.lang.String) r7, r0)     // Catch:{ all -> 0x046f }
                com.hbg.module.huobi.im.group.ui.active.RewardsAnim r7 = (com.hbg.module.huobi.im.group.ui.active.RewardsAnim) r7     // Catch:{ all -> 0x046f }
                if (r7 == 0) goto L_0x046b
                com.hbg.module.huobi.im.gift.d r8 = com.hbg.module.huobi.im.gift.d.f19724a     // Catch:{ all -> 0x046f }
                r8.E(r7)     // Catch:{ all -> 0x046f }
                java.util.ArrayList r8 = r7.getAccounts()     // Catch:{ all -> 0x046f }
                if (r8 == 0) goto L_0x0091
                com.tencent.imsdk.v2.V2TIMManager r0 = com.tencent.imsdk.v2.V2TIMManager.getInstance()     // Catch:{ all -> 0x046f }
                java.lang.String r0 = r0.getLoginUser()     // Catch:{ all -> 0x046f }
                boolean r8 = r8.contains(r0)     // Catch:{ all -> 0x046f }
                if (r8 != 0) goto L_0x0091
                r5 = r4
            L_0x0091:
                if (r5 == 0) goto L_0x00c0
                java.lang.Integer r8 = r7.getType()     // Catch:{ all -> 0x046f }
                if (r8 != 0) goto L_0x009a
                goto L_0x00aa
            L_0x009a:
                int r8 = r8.intValue()     // Catch:{ all -> 0x046f }
                if (r8 != 0) goto L_0x00aa
                com.hbg.module.huobi.im.manager.ActiveViewManager r8 = com.hbg.module.huobi.im.manager.ActiveViewManager.e()     // Catch:{ all -> 0x046f }
                com.hbg.module.huobi.im.gift.LiveGiftShowType r0 = com.hbg.module.huobi.im.gift.LiveGiftShowType.LIVE_GIFT_PORTRAIT_SCREEN_RECEIVED     // Catch:{ all -> 0x046f }
                r8.i(r7, r0)     // Catch:{ all -> 0x046f }
                goto L_0x00c0
            L_0x00aa:
                java.lang.Integer r8 = r7.getType()     // Catch:{ all -> 0x046f }
                if (r8 != 0) goto L_0x00b1
                goto L_0x00c0
            L_0x00b1:
                int r8 = r8.intValue()     // Catch:{ all -> 0x046f }
                if (r8 != r4) goto L_0x00c0
                com.hbg.module.huobi.im.manager.ActiveViewManager r8 = com.hbg.module.huobi.im.manager.ActiveViewManager.e()     // Catch:{ all -> 0x046f }
                com.hbg.module.huobi.im.gift.LiveGiftShowType r0 = com.hbg.module.huobi.im.gift.LiveGiftShowType.LIVE_GIFT_PORTRAIT_SCREEN_RECEIVED     // Catch:{ all -> 0x046f }
                r8.h(r7, r0)     // Catch:{ all -> 0x046f }
            L_0x00c0:
                kotlin.Unit r1 = kotlin.Unit.f56620a     // Catch:{ all -> 0x046f }
                goto L_0x046b
            L_0x00c4:
                com.hbg.module.huobi.im.utils.MessageBusinessID r3 = com.hbg.module.huobi.im.utils.MessageBusinessID.MSG_BUSINESS_ID_HUOBI_LIVE_INTEGRAL_CHANGE     // Catch:{ all -> 0x046f }
                java.lang.String r3 = r3.getValue()     // Catch:{ all -> 0x046f }
                boolean r3 = kotlin.jvm.internal.x.b(r2, r3)     // Catch:{ all -> 0x046f }
                if (r3 == 0) goto L_0x0100
                com.google.gson.Gson r8 = new com.google.gson.Gson     // Catch:{ all -> 0x046f }
                r8.<init>()     // Catch:{ all -> 0x046f }
                java.lang.Class<com.hbg.module.huobi.im.gift.bean.IntegralChangeBean> r0 = com.hbg.module.huobi.im.gift.bean.IntegralChangeBean.class
                java.lang.Object r7 = r8.fromJson((java.lang.String) r7, r0)     // Catch:{ all -> 0x046f }
                com.hbg.module.huobi.im.gift.bean.IntegralChangeBean r7 = (com.hbg.module.huobi.im.gift.bean.IntegralChangeBean) r7     // Catch:{ all -> 0x046f }
                if (r7 == 0) goto L_0x046b
                java.util.ArrayList r8 = r7.getAccounts()     // Catch:{ all -> 0x046f }
                if (r8 == 0) goto L_0x00f4
                com.tencent.imsdk.v2.V2TIMManager r0 = com.tencent.imsdk.v2.V2TIMManager.getInstance()     // Catch:{ all -> 0x046f }
                java.lang.String r0 = r0.getLoginUser()     // Catch:{ all -> 0x046f }
                boolean r8 = r8.contains(r0)     // Catch:{ all -> 0x046f }
                if (r8 != r4) goto L_0x00f4
                goto L_0x00f5
            L_0x00f4:
                r4 = r5
            L_0x00f5:
                if (r4 == 0) goto L_0x00fc
                com.hbg.module.huobi.im.gift.d r8 = com.hbg.module.huobi.im.gift.d.f19724a     // Catch:{ all -> 0x046f }
                r8.D(r7)     // Catch:{ all -> 0x046f }
            L_0x00fc:
                kotlin.Unit r1 = kotlin.Unit.f56620a     // Catch:{ all -> 0x046f }
                goto L_0x046b
            L_0x0100:
                com.hbg.module.huobi.im.utils.MessageBusinessID r3 = com.hbg.module.huobi.im.utils.MessageBusinessID.MSG_BUSINESS_ID_GIFT     // Catch:{ all -> 0x046f }
                java.lang.String r3 = r3.getValue()     // Catch:{ all -> 0x046f }
                boolean r3 = kotlin.jvm.internal.x.b(r2, r3)     // Catch:{ all -> 0x046f }
                if (r3 == 0) goto L_0x01a3
                com.hbg.module.huobi.im.gift.d r8 = com.hbg.module.huobi.im.gift.d.f19724a     // Catch:{ all -> 0x046f }
                com.google.gson.Gson r0 = new com.google.gson.Gson     // Catch:{ all -> 0x046f }
                r0.<init>()     // Catch:{ all -> 0x046f }
                java.lang.Class<com.hbg.module.huobi.im.gift.bean.CusMsgGiftSend> r2 = com.hbg.module.huobi.im.gift.bean.CusMsgGiftSend.class
                java.lang.Object r7 = r0.fromJson((java.lang.String) r7, r2)     // Catch:{ all -> 0x046f }
                com.hbg.module.huobi.im.gift.bean.CusMsgGiftSend r7 = (com.hbg.module.huobi.im.gift.bean.CusMsgGiftSend) r7     // Catch:{ all -> 0x046f }
                r8.N(r7)     // Catch:{ all -> 0x046f }
                java.lang.String r7 = r8.y()     // Catch:{ all -> 0x046f }
                if (r7 == 0) goto L_0x0149
                com.hbg.module.huobi.im.gift.bean.CusMsgGiftSend r7 = r8.j()     // Catch:{ all -> 0x046f }
                if (r7 == 0) goto L_0x0135
                java.lang.Integer r7 = r7.getId()     // Catch:{ all -> 0x046f }
                if (r7 == 0) goto L_0x0135
                java.lang.String r7 = r7.toString()     // Catch:{ all -> 0x046f }
                goto L_0x0136
            L_0x0135:
                r7 = r1
            L_0x0136:
                java.lang.String r0 = r8.y()     // Catch:{ all -> 0x046f }
                boolean r7 = kotlin.jvm.internal.x.b(r7, r0)     // Catch:{ all -> 0x046f }
                if (r7 != 0) goto L_0x0149
                r8.X(r1)     // Catch:{ all -> 0x046f }
                r8.Y(r5)     // Catch:{ all -> 0x046f }
                r8.b0(r5)     // Catch:{ all -> 0x046f }
            L_0x0149:
                java.lang.String r7 = r8.y()     // Catch:{ all -> 0x046f }
                if (r7 == 0) goto L_0x0189
                int r7 = r8.z()     // Catch:{ all -> 0x046f }
                if (r7 != 0) goto L_0x0156
                goto L_0x0189
            L_0x0156:
                int r7 = r8.z()     // Catch:{ all -> 0x046f }
                if (r7 != r4) goto L_0x0188
                com.hbg.module.huobi.im.gift.bean.CusMsgGiftSend r7 = r8.j()     // Catch:{ all -> 0x046f }
                if (r7 == 0) goto L_0x0171
                java.lang.Integer r7 = r7.getRule()     // Catch:{ all -> 0x046f }
                r0 = 2
                if (r7 != 0) goto L_0x016a
                goto L_0x0171
            L_0x016a:
                int r7 = r7.intValue()     // Catch:{ all -> 0x046f }
                if (r7 != r0) goto L_0x0171
                goto L_0x0172
            L_0x0171:
                r4 = r5
            L_0x0172:
                if (r4 == 0) goto L_0x017b
                r8.e0()     // Catch:{ all -> 0x046f }
                kotlin.Unit r1 = kotlin.Unit.f56620a     // Catch:{ all -> 0x046f }
                goto L_0x046b
            L_0x017b:
                com.hbg.module.huobi.im.gift.ui.LiveGiftFloatButton r7 = r8.C()     // Catch:{ all -> 0x046f }
                if (r7 == 0) goto L_0x046b
                r7.f()     // Catch:{ all -> 0x046f }
                kotlin.Unit r1 = kotlin.Unit.f56620a     // Catch:{ all -> 0x046f }
                goto L_0x046b
            L_0x0188:
                return
            L_0x0189:
                com.hbg.module.huobi.im.gift.bean.CusMsgGiftSend r7 = r8.j()     // Catch:{ all -> 0x046f }
                if (r7 == 0) goto L_0x0199
                java.lang.Integer r7 = r7.getId()     // Catch:{ all -> 0x046f }
                if (r7 == 0) goto L_0x0199
                java.lang.String r1 = r7.toString()     // Catch:{ all -> 0x046f }
            L_0x0199:
                r8.X(r1)     // Catch:{ all -> 0x046f }
                r8.e0()     // Catch:{ all -> 0x046f }
                kotlin.Unit r1 = kotlin.Unit.f56620a     // Catch:{ all -> 0x046f }
                goto L_0x046b
            L_0x01a3:
                com.hbg.module.huobi.im.utils.MessageBusinessID r3 = com.hbg.module.huobi.im.utils.MessageBusinessID.MSG_BUSINESS_ID_GIFT_END     // Catch:{ all -> 0x046f }
                java.lang.String r3 = r3.getValue()     // Catch:{ all -> 0x046f }
                boolean r3 = kotlin.jvm.internal.x.b(r2, r3)     // Catch:{ all -> 0x046f }
                if (r3 == 0) goto L_0x01fb
                com.hbg.module.huobi.im.gift.d r7 = com.hbg.module.huobi.im.gift.d.f19724a     // Catch:{ all -> 0x046f }
                com.hbg.module.huobi.im.gift.ui.LiveGiftBottomDialog r8 = r7.l()     // Catch:{ all -> 0x046f }
                if (r8 == 0) goto L_0x01ba
                r8.dismiss()     // Catch:{ all -> 0x046f }
            L_0x01ba:
                com.hbg.module.huobi.im.gift.ui.LiveGiftShowDialog r8 = r7.m()     // Catch:{ all -> 0x046f }
                if (r8 == 0) goto L_0x01c3
                r8.xh()     // Catch:{ all -> 0x046f }
            L_0x01c3:
                com.hbg.module.huobi.im.gift.ui.LiveGiftFloatButton r8 = r7.C()     // Catch:{ all -> 0x046f }
                if (r8 == 0) goto L_0x01cc
                r8.c()     // Catch:{ all -> 0x046f }
            L_0x01cc:
                com.hbg.module.huobi.im.gift.ui.LiveGiftFloatButton r8 = r7.C()     // Catch:{ all -> 0x046f }
                if (r8 == 0) goto L_0x01d5
                r8.e()     // Catch:{ all -> 0x046f }
            L_0x01d5:
                r7.S(r1)     // Catch:{ all -> 0x046f }
                r7.R(r1)     // Catch:{ all -> 0x046f }
                r7.b0(r5)     // Catch:{ all -> 0x046f }
                com.hbg.module.huobi.im.gift.ui.LiveGiftFloatButton r8 = r7.C()     // Catch:{ all -> 0x046f }
                if (r8 != 0) goto L_0x01e5
                goto L_0x01e8
            L_0x01e5:
                r8.setAlreadyTaskWatch(r5)     // Catch:{ all -> 0x046f }
            L_0x01e8:
                com.hbg.module.huobi.im.gift.ui.LiveGiftFloatButton r7 = r7.C()     // Catch:{ all -> 0x046f }
                if (r7 == 0) goto L_0x046b
                android.os.Handler r7 = r7.getHandler()     // Catch:{ all -> 0x046f }
                if (r7 == 0) goto L_0x046b
                r7.removeCallbacksAndMessages(r1)     // Catch:{ all -> 0x046f }
                kotlin.Unit r1 = kotlin.Unit.f56620a     // Catch:{ all -> 0x046f }
                goto L_0x046b
            L_0x01fb:
                com.hbg.module.huobi.im.utils.MessageBusinessID r3 = com.hbg.module.huobi.im.utils.MessageBusinessID.MSG_BUSINESS_ID_GIFT_VERIFY     // Catch:{ all -> 0x046f }
                java.lang.String r3 = r3.getValue()     // Catch:{ all -> 0x046f }
                boolean r3 = kotlin.jvm.internal.x.b(r2, r3)     // Catch:{ all -> 0x046f }
                if (r3 == 0) goto L_0x025f
                com.hbg.module.huobi.im.gift.d r8 = com.hbg.module.huobi.im.gift.d.f19724a     // Catch:{ all -> 0x046f }
                com.hbg.module.huobi.im.gift.bean.CusMsgGiftSend r0 = r8.j()     // Catch:{ all -> 0x046f }
                if (r0 == 0) goto L_0x0223
                java.lang.Integer r0 = r0.getRule()     // Catch:{ all -> 0x046f }
                com.hbg.module.huobi.im.utils.LiveGiftRule r1 = com.hbg.module.huobi.im.utils.LiveGiftRule.RULE_TASK     // Catch:{ all -> 0x046f }
                int r1 = r1.getValue()     // Catch:{ all -> 0x046f }
                if (r0 != 0) goto L_0x021c
                goto L_0x0223
            L_0x021c:
                int r0 = r0.intValue()     // Catch:{ all -> 0x046f }
                if (r0 != r1) goto L_0x0223
                r5 = r4
            L_0x0223:
                if (r5 != 0) goto L_0x0226
                return
            L_0x0226:
                com.google.gson.Gson r0 = new com.google.gson.Gson     // Catch:{ all -> 0x046f }
                r0.<init>()     // Catch:{ all -> 0x046f }
                java.lang.Class<com.hbg.module.huobi.im.gift.bean.CusMsgGiftVerify> r1 = com.hbg.module.huobi.im.gift.bean.CusMsgGiftVerify.class
                java.lang.Object r7 = r0.fromJson((java.lang.String) r7, r1)     // Catch:{ all -> 0x046f }
                com.hbg.module.huobi.im.gift.bean.CusMsgGiftVerify r7 = (com.hbg.module.huobi.im.gift.bean.CusMsgGiftVerify) r7     // Catch:{ all -> 0x046f }
                java.lang.String r0 = r7.getVerifyCode()     // Catch:{ all -> 0x046f }
                if (r0 == 0) goto L_0x025e
                java.lang.String r0 = r8.p()     // Catch:{ all -> 0x046f }
                if (r0 == 0) goto L_0x025e
                int r0 = r8.z()     // Catch:{ all -> 0x046f }
                if (r0 <= r4) goto L_0x0246
                goto L_0x025e
            L_0x0246:
                ld.f r0 = r8.q()     // Catch:{ all -> 0x046f }
                java.lang.String r7 = r7.getVerifyCode()     // Catch:{ all -> 0x046f }
                java.lang.String r8 = r8.p()     // Catch:{ all -> 0x046f }
                com.hbg.module.huobi.im.gift.d$a$a r1 = new com.hbg.module.huobi.im.gift.d$a$a     // Catch:{ all -> 0x046f }
                r1.<init>()     // Catch:{ all -> 0x046f }
                r0.d(r7, r8, r1)     // Catch:{ all -> 0x046f }
                kotlin.Unit r1 = kotlin.Unit.f56620a     // Catch:{ all -> 0x046f }
                goto L_0x046b
            L_0x025e:
                return
            L_0x025f:
                com.hbg.module.huobi.im.utils.MessageBusinessID r3 = com.hbg.module.huobi.im.utils.MessageBusinessID.MSG_BUSINESS_ID_HUOBI_PRIME_BOX     // Catch:{ all -> 0x046f }
                java.lang.String r3 = r3.getValue()     // Catch:{ all -> 0x046f }
                boolean r3 = kotlin.jvm.internal.x.b(r2, r3)     // Catch:{ all -> 0x046f }
                if (r3 == 0) goto L_0x0274
                com.hbg.module.huobi.im.gift.d r8 = com.hbg.module.huobi.im.gift.d.f19724a     // Catch:{ all -> 0x046f }
                r8.F(r7)     // Catch:{ all -> 0x046f }
                kotlin.Unit r1 = kotlin.Unit.f56620a     // Catch:{ all -> 0x046f }
                goto L_0x046b
            L_0x0274:
                com.hbg.module.huobi.im.utils.MessageBusinessID r3 = com.hbg.module.huobi.im.utils.MessageBusinessID.MSG_BUSINESS_ID_HUOBI_PRIME_BOX_NEW     // Catch:{ all -> 0x046f }
                java.lang.String r3 = r3.getValue()     // Catch:{ all -> 0x046f }
                boolean r3 = kotlin.jvm.internal.x.b(r2, r3)     // Catch:{ all -> 0x046f }
                if (r3 == 0) goto L_0x02b0
                com.google.gson.Gson r8 = new com.google.gson.Gson     // Catch:{ all -> 0x046f }
                r8.<init>()     // Catch:{ all -> 0x046f }
                java.lang.Class<com.hbg.module.huobi.im.gift.bean.CusMsgPrimeBox> r0 = com.hbg.module.huobi.im.gift.bean.CusMsgPrimeBox.class
                java.lang.Object r8 = r8.fromJson((java.lang.String) r7, r0)     // Catch:{ all -> 0x046f }
                com.hbg.module.huobi.im.gift.bean.CusMsgPrimeBox r8 = (com.hbg.module.huobi.im.gift.bean.CusMsgPrimeBox) r8     // Catch:{ all -> 0x046f }
                if (r8 == 0) goto L_0x046b
                java.util.ArrayList r8 = r8.getAccounts()     // Catch:{ all -> 0x046f }
                if (r8 == 0) goto L_0x02a4
                com.tencent.imsdk.v2.V2TIMManager r0 = com.tencent.imsdk.v2.V2TIMManager.getInstance()     // Catch:{ all -> 0x046f }
                java.lang.String r0 = r0.getLoginUser()     // Catch:{ all -> 0x046f }
                boolean r8 = r8.contains(r0)     // Catch:{ all -> 0x046f }
                if (r8 != r4) goto L_0x02a4
                goto L_0x02a5
            L_0x02a4:
                r4 = r5
            L_0x02a5:
                if (r4 == 0) goto L_0x02ac
                com.hbg.module.huobi.im.gift.d r8 = com.hbg.module.huobi.im.gift.d.f19724a     // Catch:{ all -> 0x046f }
                r8.F(r7)     // Catch:{ all -> 0x046f }
            L_0x02ac:
                kotlin.Unit r1 = kotlin.Unit.f56620a     // Catch:{ all -> 0x046f }
                goto L_0x046b
            L_0x02b0:
                com.hbg.module.huobi.im.utils.MessageBusinessID r3 = com.hbg.module.huobi.im.utils.MessageBusinessID.MSG_BUSINESS_ID_HUOBI_LIVE_GIFT_REWARD_CHANGE     // Catch:{ all -> 0x046f }
                java.lang.String r3 = r3.getValue()     // Catch:{ all -> 0x046f }
                boolean r3 = kotlin.jvm.internal.x.b(r2, r3)     // Catch:{ all -> 0x046f }
                if (r3 == 0) goto L_0x02e3
                com.google.gson.Gson r8 = new com.google.gson.Gson     // Catch:{ all -> 0x046f }
                r8.<init>()     // Catch:{ all -> 0x046f }
                java.lang.Class<com.hbg.module.huobi.im.gift.bean.RewardStatusBean> r0 = com.hbg.module.huobi.im.gift.bean.RewardStatusBean.class
                java.lang.Object r7 = r8.fromJson((java.lang.String) r7, r0)     // Catch:{ all -> 0x046f }
                com.hbg.module.huobi.im.gift.bean.RewardStatusBean r7 = (com.hbg.module.huobi.im.gift.bean.RewardStatusBean) r7     // Catch:{ all -> 0x046f }
                if (r7 == 0) goto L_0x046b
                com.hbg.module.huobi.im.gift.d r8 = com.hbg.module.huobi.im.gift.d.f19724a     // Catch:{ all -> 0x046f }
                com.hbg.module.huobi.im.gift.g r8 = r8.B()     // Catch:{ all -> 0x046f }
                if (r8 == 0) goto L_0x046b
                java.lang.String r0 = r7.getGroupId()     // Catch:{ all -> 0x046f }
                int r7 = r7.getStatus()     // Catch:{ all -> 0x046f }
                r8.b(r0, r7)     // Catch:{ all -> 0x046f }
                kotlin.Unit r7 = kotlin.Unit.f56620a     // Catch:{ all -> 0x046f }
            L_0x02e0:
                r1 = r7
                goto L_0x046b
            L_0x02e3:
                com.hbg.module.huobi.im.utils.MessageBusinessID r3 = com.hbg.module.huobi.im.utils.MessageBusinessID.MSG_BUSINESS_ID_HUOBI_LIVE_ACTIVITY_CHANGE     // Catch:{ all -> 0x046f }
                java.lang.String r3 = r3.getValue()     // Catch:{ all -> 0x046f }
                boolean r3 = kotlin.jvm.internal.x.b(r2, r3)     // Catch:{ all -> 0x046f }
                if (r3 == 0) goto L_0x02fe
                com.hbg.module.huobi.im.gift.d r7 = com.hbg.module.huobi.im.gift.d.f19724a     // Catch:{ all -> 0x046f }
                com.hbg.module.huobi.im.gift.g r7 = r7.B()     // Catch:{ all -> 0x046f }
                if (r7 == 0) goto L_0x046b
                r7.a()     // Catch:{ all -> 0x046f }
                kotlin.Unit r1 = kotlin.Unit.f56620a     // Catch:{ all -> 0x046f }
                goto L_0x046b
            L_0x02fe:
                com.hbg.module.huobi.im.utils.MessageBusinessID r3 = com.hbg.module.huobi.im.utils.MessageBusinessID.MSG_BUSINESS_ID_HUOBI_LIVE_IN     // Catch:{ all -> 0x046f }
                java.lang.String r3 = r3.getValue()     // Catch:{ all -> 0x046f }
                boolean r3 = kotlin.jvm.internal.x.b(r2, r3)     // Catch:{ all -> 0x046f }
                java.lang.String r4 = "nickname"
                if (r3 == 0) goto L_0x0344
                java.util.Map<java.lang.String, java.lang.Object> r7 = r8.data     // Catch:{ all -> 0x033d }
                if (r7 == 0) goto L_0x0315
                java.lang.Object r7 = r7.get(r0)     // Catch:{ all -> 0x033d }
                goto L_0x0316
            L_0x0315:
                r7 = r1
            L_0x0316:
                java.util.Map r7 = (java.util.Map) r7     // Catch:{ all -> 0x033d }
                java.lang.String r8 = "avatar"
                java.lang.Object r8 = r7.get(r8)     // Catch:{ all -> 0x033d }
                java.lang.String r8 = (java.lang.String) r8     // Catch:{ all -> 0x033d }
                java.lang.Object r0 = r7.get(r4)     // Catch:{ all -> 0x033d }
                java.lang.String r0 = (java.lang.String) r0     // Catch:{ all -> 0x033d }
                java.lang.String r2 = "uniqueUid"
                java.lang.Object r7 = r7.get(r2)     // Catch:{ all -> 0x033d }
                java.lang.String r7 = (java.lang.String) r7     // Catch:{ all -> 0x033d }
                com.hbg.module.huobi.im.gift.d r2 = com.hbg.module.huobi.im.gift.d.f19724a     // Catch:{ all -> 0x033d }
                com.hbg.module.huobi.im.gift.d$b r2 = r2.s()     // Catch:{ all -> 0x033d }
                if (r2 == 0) goto L_0x046b
                r2.a(r8, r0, r7)     // Catch:{ all -> 0x033d }
                kotlin.Unit r1 = kotlin.Unit.f56620a     // Catch:{ all -> 0x033d }
                goto L_0x046b
            L_0x033d:
                r7 = move-exception
                r7.printStackTrace()     // Catch:{ all -> 0x046f }
                kotlin.Unit r7 = kotlin.Unit.f56620a     // Catch:{ all -> 0x046f }
                goto L_0x02e0
            L_0x0344:
                com.hbg.module.huobi.im.utils.MessageBusinessID r3 = com.hbg.module.huobi.im.utils.MessageBusinessID.MSG_BUSINESS_ID_HUOBI_LIVE_RED_PACKET_SEND     // Catch:{ all -> 0x046f }
                java.lang.String r3 = r3.getValue()     // Catch:{ all -> 0x046f }
                boolean r3 = kotlin.jvm.internal.x.b(r2, r3)     // Catch:{ all -> 0x046f }
                if (r3 == 0) goto L_0x0373
                java.util.Map<java.lang.String, java.lang.Object> r7 = r8.data     // Catch:{ all -> 0x036b }
                if (r7 == 0) goto L_0x0359
                java.lang.Object r7 = r7.get(r0)     // Catch:{ all -> 0x036b }
                goto L_0x035a
            L_0x0359:
                r7 = r1
            L_0x035a:
                java.util.Map r7 = (java.util.Map) r7     // Catch:{ all -> 0x036b }
                com.hbg.module.huobi.im.gift.d r8 = com.hbg.module.huobi.im.gift.d.f19724a     // Catch:{ all -> 0x036b }
                com.hbg.module.huobi.im.gift.d$h r8 = r8.A()     // Catch:{ all -> 0x036b }
                if (r8 == 0) goto L_0x046b
                r8.a(r7)     // Catch:{ all -> 0x036b }
                kotlin.Unit r1 = kotlin.Unit.f56620a     // Catch:{ all -> 0x036b }
                goto L_0x046b
            L_0x036b:
                r7 = move-exception
                r7.printStackTrace()     // Catch:{ all -> 0x046f }
                kotlin.Unit r7 = kotlin.Unit.f56620a     // Catch:{ all -> 0x046f }
                goto L_0x02e0
            L_0x0373:
                com.hbg.module.huobi.im.utils.MessageBusinessID r3 = com.hbg.module.huobi.im.utils.MessageBusinessID.MSG_BUSINESS_ID_HUOBI_LIVE_RED_PACKET_SNATCH     // Catch:{ all -> 0x046f }
                java.lang.String r3 = r3.getValue()     // Catch:{ all -> 0x046f }
                boolean r3 = kotlin.jvm.internal.x.b(r2, r3)     // Catch:{ all -> 0x046f }
                if (r3 == 0) goto L_0x03b8
                java.util.Map<java.lang.String, java.lang.Object> r7 = r8.data     // Catch:{ all -> 0x03b0 }
                if (r7 == 0) goto L_0x0388
                java.lang.Object r7 = r7.get(r0)     // Catch:{ all -> 0x03b0 }
                goto L_0x0389
            L_0x0388:
                r7 = r1
            L_0x0389:
                java.util.Map r7 = (java.util.Map) r7     // Catch:{ all -> 0x03b0 }
                com.hbg.module.huobi.im.gift.d r8 = com.hbg.module.huobi.im.gift.d.f19724a     // Catch:{ all -> 0x03b0 }
                com.hbg.module.huobi.im.gift.d$h r8 = r8.A()     // Catch:{ all -> 0x03b0 }
                if (r8 == 0) goto L_0x046b
                java.lang.Object r0 = r7.get(r4)     // Catch:{ all -> 0x03b0 }
                java.lang.String r0 = (java.lang.String) r0     // Catch:{ all -> 0x03b0 }
                java.lang.String r1 = "currency"
                java.lang.Object r1 = r7.get(r1)     // Catch:{ all -> 0x03b0 }
                java.lang.String r1 = (java.lang.String) r1     // Catch:{ all -> 0x03b0 }
                java.lang.String r2 = "amount"
                java.lang.Object r7 = r7.get(r2)     // Catch:{ all -> 0x03b0 }
                java.lang.String r7 = (java.lang.String) r7     // Catch:{ all -> 0x03b0 }
                r8.d(r0, r1, r7)     // Catch:{ all -> 0x03b0 }
                kotlin.Unit r1 = kotlin.Unit.f56620a     // Catch:{ all -> 0x03b0 }
                goto L_0x046b
            L_0x03b0:
                r7 = move-exception
                r7.printStackTrace()     // Catch:{ all -> 0x046f }
                kotlin.Unit r7 = kotlin.Unit.f56620a     // Catch:{ all -> 0x046f }
                goto L_0x02e0
            L_0x03b8:
                com.hbg.module.huobi.im.utils.MessageBusinessID r3 = com.hbg.module.huobi.im.utils.MessageBusinessID.MSG_BUSINESS_ID_HUOBI_LIVE_RED_PACKET_THANK     // Catch:{ all -> 0x046f }
                java.lang.String r3 = r3.getValue()     // Catch:{ all -> 0x046f }
                boolean r3 = kotlin.jvm.internal.x.b(r2, r3)     // Catch:{ all -> 0x046f }
                if (r3 == 0) goto L_0x03ed
                java.util.Map<java.lang.String, java.lang.Object> r7 = r8.data     // Catch:{ all -> 0x03e5 }
                if (r7 == 0) goto L_0x03cd
                java.lang.Object r7 = r7.get(r0)     // Catch:{ all -> 0x03e5 }
                goto L_0x03ce
            L_0x03cd:
                r7 = r1
            L_0x03ce:
                java.util.Map r7 = (java.util.Map) r7     // Catch:{ all -> 0x03e5 }
                com.hbg.module.huobi.im.gift.d r8 = com.hbg.module.huobi.im.gift.d.f19724a     // Catch:{ all -> 0x03e5 }
                com.hbg.module.huobi.im.gift.d$h r8 = r8.A()     // Catch:{ all -> 0x03e5 }
                if (r8 == 0) goto L_0x046b
                java.lang.Object r7 = r7.get(r4)     // Catch:{ all -> 0x03e5 }
                java.lang.String r7 = (java.lang.String) r7     // Catch:{ all -> 0x03e5 }
                r8.b(r7)     // Catch:{ all -> 0x03e5 }
                kotlin.Unit r1 = kotlin.Unit.f56620a     // Catch:{ all -> 0x03e5 }
                goto L_0x046b
            L_0x03e5:
                r7 = move-exception
                r7.printStackTrace()     // Catch:{ all -> 0x046f }
                kotlin.Unit r7 = kotlin.Unit.f56620a     // Catch:{ all -> 0x046f }
                goto L_0x02e0
            L_0x03ed:
                com.hbg.module.huobi.im.utils.MessageBusinessID r3 = com.hbg.module.huobi.im.utils.MessageBusinessID.MSG_BUSINESS_ID_HUOBI_LIVE_RED_PACKET_CLOSE     // Catch:{ all -> 0x046f }
                java.lang.String r3 = r3.getValue()     // Catch:{ all -> 0x046f }
                boolean r3 = kotlin.jvm.internal.x.b(r2, r3)     // Catch:{ all -> 0x046f }
                if (r3 == 0) goto L_0x0425
                java.util.Map<java.lang.String, java.lang.Object> r7 = r8.data     // Catch:{ all -> 0x041d }
                if (r7 == 0) goto L_0x0402
                java.lang.Object r7 = r7.get(r0)     // Catch:{ all -> 0x041d }
                goto L_0x0403
            L_0x0402:
                r7 = r1
            L_0x0403:
                java.util.Map r7 = (java.util.Map) r7     // Catch:{ all -> 0x041d }
                com.hbg.module.huobi.im.gift.d r8 = com.hbg.module.huobi.im.gift.d.f19724a     // Catch:{ all -> 0x041d }
                com.hbg.module.huobi.im.gift.d$h r8 = r8.A()     // Catch:{ all -> 0x041d }
                if (r8 == 0) goto L_0x046b
                java.lang.String r0 = "packetId"
                java.lang.Object r7 = r7.get(r0)     // Catch:{ all -> 0x041d }
                java.lang.String r7 = java.lang.String.valueOf(r7)     // Catch:{ all -> 0x041d }
                r8.c(r7)     // Catch:{ all -> 0x041d }
                kotlin.Unit r1 = kotlin.Unit.f56620a     // Catch:{ all -> 0x041d }
                goto L_0x046b
            L_0x041d:
                r7 = move-exception
                r7.printStackTrace()     // Catch:{ all -> 0x046f }
                kotlin.Unit r7 = kotlin.Unit.f56620a     // Catch:{ all -> 0x046f }
                goto L_0x02e0
            L_0x0425:
                com.hbg.module.huobi.im.utils.MessageBusinessID r0 = com.hbg.module.huobi.im.utils.MessageBusinessID.MSG_BUSINESS_ID_HUOBI_LIVE_TRADER_RECOMMEND     // Catch:{ all -> 0x046f }
                java.lang.String r0 = r0.getValue()     // Catch:{ all -> 0x046f }
                boolean r0 = kotlin.jvm.internal.x.b(r2, r0)     // Catch:{ all -> 0x046f }
                if (r0 == 0) goto L_0x0439
                com.hbg.module.huobi.im.gift.d r8 = com.hbg.module.huobi.im.gift.d.f19724a     // Catch:{ all -> 0x046f }
                r8.G(r7)     // Catch:{ all -> 0x046f }
                kotlin.Unit r1 = kotlin.Unit.f56620a     // Catch:{ all -> 0x046f }
                goto L_0x046b
            L_0x0439:
                com.hbg.module.huobi.im.utils.MessageBusinessID r7 = com.hbg.module.huobi.im.utils.MessageBusinessID.MSG_BUSINESS_ID_HUOBI_LIVE_TRADER_RECOMMEND_CANCEL     // Catch:{ all -> 0x046f }
                java.lang.String r7 = r7.getValue()     // Catch:{ all -> 0x046f }
                boolean r7 = kotlin.jvm.internal.x.b(r2, r7)     // Catch:{ all -> 0x046f }
                if (r7 == 0) goto L_0x044d
                com.hbg.module.huobi.im.gift.d r7 = com.hbg.module.huobi.im.gift.d.f19724a     // Catch:{ all -> 0x046f }
                r7.G(r1)     // Catch:{ all -> 0x046f }
                kotlin.Unit r1 = kotlin.Unit.f56620a     // Catch:{ all -> 0x046f }
                goto L_0x046b
            L_0x044d:
                java.lang.String r7 = com.hbg.module.huobi.im.gift.d.f19725b     // Catch:{ all -> 0x046f }
                java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ all -> 0x046f }
                r0.<init>()     // Catch:{ all -> 0x046f }
                java.lang.String r2 = "businessID 错误："
                r0.append(r2)     // Catch:{ all -> 0x046f }
                if (r8 == 0) goto L_0x045f
                java.lang.String r1 = r8.businessID     // Catch:{ all -> 0x046f }
            L_0x045f:
                r0.append(r1)     // Catch:{ all -> 0x046f }
                java.lang.String r8 = r0.toString()     // Catch:{ all -> 0x046f }
                com.tencent.imsdk.common.IMLog.d(r7, r8)     // Catch:{ all -> 0x046f }
                kotlin.Unit r1 = kotlin.Unit.f56620a     // Catch:{ all -> 0x046f }
            L_0x046b:
                kotlin.Result.m3072constructorimpl(r1)     // Catch:{ all -> 0x046f }
                goto L_0x0479
            L_0x046f:
                r7 = move-exception
                kotlin.Result$a r8 = kotlin.Result.Companion
                java.lang.Object r7 = kotlin.k.a(r7)
                kotlin.Result.m3072constructorimpl(r7)
            L_0x0479:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.hbg.module.huobi.im.gift.d.a.onCustomCallback(int, com.tencent.qcloud.tuikit.tuibarrage.model.TUIBarrageMessage):void");
        }

        public void onFailed(int i11, String str) {
        }
    }

    public interface b {
        void a(String str, String str2, String str3);
    }

    public interface c {
        void a(IntegralChangeBean integralChangeBean);
    }

    /* renamed from: com.hbg.module.huobi.im.gift.d$d  reason: collision with other inner class name */
    public interface C0140d {
        void a(CusMsgPrimeBox cusMsgPrimeBox);
    }

    public interface e {
        void a(RewardsAnim rewardsAnim);
    }

    public interface f {
        void a(RecommendTrader recommendTrader);

        void onClose();
    }

    public interface g {
        void onHide();
    }

    public interface h {

        public static final class a {
            public static void a(h hVar, String str, String str2, String str3) {
            }
        }

        void a(Map<?, ?> map);

        void b(String str);

        void c(String str);

        void d(String str, String str2, String str3);
    }

    public static final class i implements LiveGiftShowDialog.a {

        public static final class a implements a {

            /* renamed from: com.hbg.module.huobi.im.gift.d$i$a$a  reason: collision with other inner class name */
            public static final class C0141a implements LiveGiftDrawErrorDialog.a {

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ LiveGiftDrawErrorDialog f19750a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ a f19751b;

                /* renamed from: com.hbg.module.huobi.im.gift.d$i$a$a$a  reason: collision with other inner class name */
                public static final class C0142a implements a {

                    /* renamed from: a  reason: collision with root package name */
                    public final /* synthetic */ LiveGiftDrawErrorDialog f19752a;

                    /* renamed from: b  reason: collision with root package name */
                    public final /* synthetic */ a f19753b;

                    public C0142a(LiveGiftDrawErrorDialog liveGiftDrawErrorDialog, a aVar) {
                        this.f19752a = liveGiftDrawErrorDialog;
                        this.f19753b = aVar;
                    }

                    public void a(String str, String str2) {
                        ToastUtil.toastShortMessage(str2);
                    }

                    public void b(DrawGiftBean drawGiftBean) {
                        if (x.b(drawGiftBean.getResult(), Boolean.TRUE)) {
                            this.f19752a.dismiss();
                            this.f19753b.d(drawGiftBean);
                        }
                    }
                }

                public C0141a(LiveGiftDrawErrorDialog liveGiftDrawErrorDialog, a aVar) {
                    this.f19750a = liveGiftDrawErrorDialog;
                    this.f19751b = aVar;
                }

                public void a() {
                    d dVar = d.f19724a;
                    ld.f q11 = dVar.q();
                    Context appContext = ImManager.INSTANCE.getAppContext();
                    CusMsgGiftSend j11 = dVar.j();
                    Integer num = null;
                    String valueOf = String.valueOf((j11 != null ? j11.getActiveJackpot() : null).intValue());
                    CusMsgGiftSend j12 = dVar.j();
                    if (j12 != null) {
                        num = j12.getId();
                    }
                    q11.e(appContext, valueOf, String.valueOf(num.intValue()), dVar.p(), new C0142a(this.f19750a, this.f19751b));
                }

                public void onCloseClick() {
                    this.f19750a.dismiss();
                    LiveGiftFloatButton C = d.f19724a.C();
                    if (C != null) {
                        C.f();
                    }
                }
            }

            public static final class b implements LiveGiftDrawEmptyDialog.a {
                public void a() {
                    d.f19724a.g0("APP_LIVE_giftbox_notprizeclk");
                }
            }

            public static final class c implements LiveGiftDrawSuccessDialog.a {
                public void a() {
                    d.f19724a.g0("APP_LIVE_giftbox_prizeclk");
                }

                public void onHide() {
                    IMLog.d("onDrawSuccessListener", "优惠券抖动开始");
                    g x11 = d.f19724a.x();
                    if (x11 != null) {
                        x11.onHide();
                    }
                }
            }

            public void a(String str, String str2) {
                if (d.f19728e != null) {
                    LiveGiftDrawErrorDialog liveGiftDrawErrorDialog = new LiveGiftDrawErrorDialog();
                    liveGiftDrawErrorDialog.wh(new C0141a(liveGiftDrawErrorDialog, this));
                    liveGiftDrawErrorDialog.show(d.f19728e.getSupportFragmentManager(), "");
                }
                LiveGiftShowDialog m11 = d.f19724a.m();
                if (m11 != null) {
                    m11.xh();
                }
            }

            public void b(DrawGiftBean drawGiftBean) {
                d dVar = d.f19724a;
                dVar.Y(2);
                if (d.f19728e != null) {
                    if (x.b(drawGiftBean.getResult(), Boolean.TRUE)) {
                        ArrayList<JackpotBean> drawDetailList = drawGiftBean.getDrawDetailList();
                        if (drawDetailList != null) {
                            for (JackpotBean jackpotBean : drawDetailList) {
                                try {
                                    Result.a aVar = Result.Companion;
                                    jackpotBean.setProperty((Property) new Gson().fromJson(jackpotBean.getProperties(), Property.class));
                                    Result.m3072constructorimpl(Unit.f56620a);
                                } catch (Throwable th2) {
                                    Result.a aVar2 = Result.Companion;
                                    Result.m3072constructorimpl(kotlin.k.a(th2));
                                }
                            }
                        }
                        d(drawGiftBean);
                    } else {
                        LiveGiftDrawEmptyDialog liveGiftDrawEmptyDialog = new LiveGiftDrawEmptyDialog();
                        liveGiftDrawEmptyDialog.show(d.f19728e.getSupportFragmentManager(), "");
                        liveGiftDrawEmptyDialog.wh(new b());
                        dVar.g0("APP_LIVE_giftbox_notprize");
                    }
                }
                d dVar2 = d.f19724a;
                StringBuilder sb2 = new StringBuilder();
                sb2.append("");
                CusMsgGiftSend j11 = dVar2.j();
                sb2.append(j11 != null ? j11.getId() : null);
                dVar2.X(sb2.toString());
                LiveGiftShowDialog m11 = dVar2.m();
                if (m11 != null) {
                    m11.xh();
                }
                LiveGiftFloatButton C = dVar2.C();
                if (C != null) {
                    C.c();
                }
            }

            public final void d(DrawGiftBean drawGiftBean) {
                if (d.f19728e != null) {
                    LiveGiftDrawSuccessDialog liveGiftDrawSuccessDialog = new LiveGiftDrawSuccessDialog();
                    Bundle bundle = new Bundle();
                    bundle.putParcelableArrayList("live_gift_jackpot_list", drawGiftBean.getDrawDetailList());
                    liveGiftDrawSuccessDialog.setArguments(bundle);
                    liveGiftDrawSuccessDialog.yh(new c());
                    liveGiftDrawSuccessDialog.show(d.f19728e.getSupportFragmentManager(), "");
                    d.f19724a.g0("APP_LIVE_giftbox_prize");
                }
            }
        }

        public static final void c() {
            LiveGiftFloatButton C = d.f19724a.C();
            if (C != null) {
                C.f();
            }
        }

        public void a() {
            StatusButton zh2;
            if (d.f19728e != null) {
                if (!BaseModuleConfig.a().m0(d.f19728e)) {
                    LiveGiftShowDialog m11 = d.f19724a.m();
                    if (m11 != null && (zh2 = m11.zh()) != null) {
                        zh2.dismissAnim();
                        return;
                    }
                    return;
                }
                d dVar = d.f19724a;
                CusMsgGiftSend j11 = dVar.j();
                Integer num = null;
                if ((j11 != null ? j11.getActiveJackpot() : null) != null && dVar.p() != null) {
                    ld.f q11 = dVar.q();
                    Context appContext = ImManager.INSTANCE.getAppContext();
                    CusMsgGiftSend j12 = dVar.j();
                    String valueOf = String.valueOf((j12 != null ? j12.getActiveJackpot() : null).intValue());
                    CusMsgGiftSend j13 = dVar.j();
                    if (j13 != null) {
                        num = j13.getId();
                    }
                    q11.e(appContext, valueOf, String.valueOf(num.intValue()), dVar.p(), new a());
                }
            }
        }

        public void onCloseClick() {
            d dVar = d.f19724a;
            LiveGiftShowDialog m11 = dVar.m();
            if (m11 != null) {
                m11.dismiss();
            }
            dVar.r().postDelayed(e.f19755b, 250);
        }
    }

    public static final class j implements LiveGiftFloatButton.a {
        public void a() {
            d dVar = d.f19724a;
            dVar.d0();
            LiveGiftBottomDialog l11 = dVar.l();
            if (l11 != null) {
                l11.dismiss();
            }
        }
    }

    public static final class k implements LiveGiftBottomDialog.a {

        public static final class a implements LiveGiftRuleDialog.a {

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ LiveGiftRuleDialog f19754a;

            public a(LiveGiftRuleDialog liveGiftRuleDialog) {
                this.f19754a = liveGiftRuleDialog;
            }

            public void a() {
                LiveGiftBottomDialog l11 = d.f19724a.l();
                if (l11 != null) {
                    l11.show(d.f19728e.getSupportFragmentManager(), "");
                }
                this.f19754a.dismiss();
            }

            public void c() {
                LiveGiftFloatButton C = d.f19724a.C();
                if (C != null) {
                    C.f();
                }
            }
        }

        public void b() {
            if (d.f19728e != null) {
                LiveGiftRuleDialog liveGiftRuleDialog = new LiveGiftRuleDialog();
                Bundle bundle = new Bundle();
                d dVar = d.f19724a;
                CusMsgGiftSend j11 = dVar.j();
                bundle.putString("live_gift_rule_text", j11 != null ? j11.getActiveRule() : null);
                liveGiftRuleDialog.setArguments(bundle);
                liveGiftRuleDialog.wh(new a(liveGiftRuleDialog));
                liveGiftRuleDialog.show(d.f19728e.getSupportFragmentManager(), "");
                LiveGiftBottomDialog l11 = dVar.l();
                if (l11 != null) {
                    l11.dismiss();
                }
            }
        }

        public void c() {
            LiveGiftFloatButton C = d.f19724a.C();
            if (C != null) {
                C.f();
            }
        }
    }

    public static final class l extends BaseSubscriber<Object> {
        public void onError(Throwable th2) {
            super.onError(th2);
            if (th2 instanceof APIStatusErrorException) {
                HuobiToastUtil.i(((APIStatusErrorException) th2).getErrMsg());
            }
        }

        public void onNext(Object obj) {
            super.onNext(obj);
        }
    }

    static {
        HbBarrageManager.getInstance().addBarrageCallBack(f19727d);
    }

    public static /* synthetic */ void K(d dVar, FragmentActivity fragmentActivity, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            fragmentActivity = null;
        }
        dVar.J(fragmentActivity);
    }

    @SensorsDataInstrumented
    public static final void M(View view) {
        if (f19728e == null) {
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
        } else if (!BaseModuleConfig.a().m0(f19728e)) {
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
        } else {
            d dVar = f19724a;
            LiveGiftFloatButton liveGiftFloatButton = f19729f;
            if (liveGiftFloatButton != null) {
                liveGiftFloatButton.c();
            }
            dVar.d0();
            dVar.g0("APP_LIVE_notice_luckdrawclk");
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }
    }

    public static /* synthetic */ void h(d dVar, boolean z11, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            z11 = true;
        }
        dVar.g(z11);
    }

    public static final void i() {
        if (f19735l == 0) {
            f19735l = 1;
        }
    }

    public final h A() {
        return C;
    }

    public final g B() {
        return A;
    }

    public final LiveGiftFloatButton C() {
        return f19729f;
    }

    public final void D(IntegralChangeBean integralChangeBean) {
        try {
            for (Map.Entry<String, c> value : f19744u.entrySet()) {
                c cVar = (c) value.getValue();
                if (cVar != null) {
                    cVar.a(integralChangeBean);
                }
            }
        } catch (Exception e11) {
            e11.printStackTrace();
        }
    }

    public final void E(RewardsAnim rewardsAnim) {
        try {
            for (Map.Entry<String, e> value : f19745v.entrySet()) {
                e eVar = (e) value.getValue();
                if (eVar != null) {
                    eVar.a(rewardsAnim);
                }
            }
        } catch (Exception e11) {
            e11.printStackTrace();
        }
    }

    public final void F(String str) {
        try {
            CusMsgPrimeBox cusMsgPrimeBox = (CusMsgPrimeBox) new Gson().fromJson(str, CusMsgPrimeBox.class);
            for (Map.Entry<String, C0140d> value : f19742s.entrySet()) {
                C0140d dVar = (C0140d) value.getValue();
                if (dVar != null) {
                    dVar.a(cusMsgPrimeBox);
                }
            }
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
        IMLog.d(f19725b, "收到newlisting自定义消息");
    }

    public final void G(String str) {
        RecommendTrader recommendTrader;
        if (str == null) {
            recommendTrader = null;
        } else {
            try {
                recommendTrader = (RecommendTrader) new Gson().fromJson(str, RecommendTrader.class);
            } catch (Throwable th2) {
                th2.printStackTrace();
            }
        }
        for (Map.Entry<String, f> value : f19743t.entrySet()) {
            f fVar = (f) value.getValue();
            if (recommendTrader == null) {
                if (fVar != null) {
                    fVar.onClose();
                }
            } else if (fVar != null) {
                fVar.a(recommendTrader);
            }
        }
        IMLog.d(f19725b, "收到跟单推荐自定义消息");
    }

    public final void H(FragmentActivity fragmentActivity) {
        f19730g = new LiveGiftShowView(fragmentActivity, (AttributeSet) null, 2, (r) null);
        f19731h = new LiveGiftShowView(fragmentActivity, (AttributeSet) null, 2, (r) null);
    }

    public final boolean I() {
        return f19749z;
    }

    public final void J(FragmentActivity fragmentActivity) {
        if (fragmentActivity == null || x.b(fragmentActivity, f19728e)) {
            f19742s.clear();
            f19743t.clear();
            f19744u.clear();
            f19728e = null;
            LiveGiftFloatButton liveGiftFloatButton = f19729f;
            if (liveGiftFloatButton != null) {
                liveGiftFloatButton.e();
            }
            f19729f = null;
            f19737n = null;
            f19738o = null;
            f19740q = null;
            f19741r = null;
            f19749z = false;
            A = null;
        }
    }

    public final void L(FragmentActivity fragmentActivity) {
        K(this, (FragmentActivity) null, 1, (Object) null);
        f19728e = fragmentActivity;
        LiveGiftFloatButton liveGiftFloatButton = new LiveGiftFloatButton(fragmentActivity);
        f19729f = liveGiftFloatButton;
        liveGiftFloatButton.setOnClickListener(b.f19717b);
        LiveGiftFloatButton liveGiftFloatButton2 = f19729f;
        if (liveGiftFloatButton2 != null) {
            liveGiftFloatButton2.setCountDownListener(new j());
        }
        LiveGiftFloatButton liveGiftFloatButton3 = f19729f;
        if (liveGiftFloatButton3 != null) {
            liveGiftFloatButton3.c();
        }
    }

    public final void N(CusMsgGiftSend cusMsgGiftSend) {
        f19736m = cusMsgGiftSend;
    }

    public final void O(float f11) {
        f19746w = f11;
    }

    public final void P(float f11) {
        f19747x = f11;
    }

    public final void Q(String str) {
        f19733j = str;
    }

    public final void R(LiveGiftBottomDialog liveGiftBottomDialog) {
        f19738o = liveGiftBottomDialog;
    }

    public final void S(LiveGiftShowDialog liveGiftShowDialog) {
        f19737n = liveGiftShowDialog;
    }

    public final void T(String str) {
        f19732i = str;
    }

    public final void U(b bVar) {
        B = bVar;
    }

    public final void V(d10.a<Unit> aVar) {
        f19740q = aVar;
    }

    public final void W(g gVar) {
        f19741r = gVar;
    }

    public final void X(String str) {
        f19734k = str;
    }

    public final void Y(int i11) {
        f19735l = i11;
    }

    public final void Z(h hVar) {
        C = hVar;
    }

    public final void a0(g gVar) {
        A = gVar;
    }

    public final void b0(boolean z11) {
        f19749z = z11;
    }

    public final void c0() {
        if (f19737n != null) {
            f0();
            d10.a<Unit> aVar = f19740q;
            if (aVar != null) {
                Unit invoke = aVar.invoke();
                return;
            }
            return;
        }
        if (f19738o == null) {
            f19738o = new LiveGiftBottomDialog();
            Bundle bundle = new Bundle();
            bundle.putParcelable("live_gift_send_bean", f19736m);
            LiveGiftBottomDialog liveGiftBottomDialog = f19738o;
            if (liveGiftBottomDialog != null) {
                liveGiftBottomDialog.setArguments(bundle);
            }
            LiveGiftBottomDialog liveGiftBottomDialog2 = f19738o;
            if (liveGiftBottomDialog2 != null) {
                liveGiftBottomDialog2.zh(new k());
            }
        }
        LiveGiftBottomDialog liveGiftBottomDialog3 = f19738o;
        if (liveGiftBottomDialog3 != null) {
            liveGiftBottomDialog3.show(f19728e.getSupportFragmentManager(), "LiveGiftBottomDialog");
        }
    }

    public final void d0() {
        Integer prizeTime;
        Long startTime;
        CusMsgGiftSend cusMsgGiftSend = f19736m;
        Integer rule = cusMsgGiftSend != null ? cusMsgGiftSend.getRule() : null;
        int value = LiveGiftRule.RULE_REALTIME.getValue();
        if (rule != null && rule.intValue() == value) {
            f0();
            h(this, false, 1, (Object) null);
            d10.a<Unit> aVar = f19740q;
            if (aVar != null) {
                Unit invoke = aVar.invoke();
                return;
            }
            return;
        }
        int value2 = LiveGiftRule.RULE_FIXED_TIME.getValue();
        if (rule != null && rule.intValue() == value2) {
            CusMsgGiftSend cusMsgGiftSend2 = f19736m;
            long longValue = (cusMsgGiftSend2 == null || (startTime = cusMsgGiftSend2.getStartTime()) == null) ? 0 : startTime.longValue();
            CusMsgGiftSend cusMsgGiftSend3 = f19736m;
            if (longValue + ((long) (((cusMsgGiftSend3 == null || (prizeTime = cusMsgGiftSend3.getPrizeTime()) == null) ? 0 : prizeTime.intValue()) * 1000)) > System.currentTimeMillis()) {
                c0();
            } else if (f19737n == null) {
                h(this, false, 1, (Object) null);
            } else {
                d10.a<Unit> aVar2 = f19740q;
                if (aVar2 != null) {
                    Unit invoke2 = aVar2.invoke();
                }
                f0();
            }
        } else {
            int value3 = LiveGiftRule.RULE_TASK.getValue();
            if (rule != null && rule.intValue() == value3) {
                c0();
            }
        }
    }

    public final void e0() {
        LiveGiftFloatButton liveGiftFloatButton;
        CusMsgGiftSend cusMsgGiftSend = f19736m;
        if (TextUtils.equals(cusMsgGiftSend != null ? cusMsgGiftSend.getGroupId() : null, f19733j)) {
            CusMsgGiftSend cusMsgGiftSend2 = f19736m;
            Integer rule = cusMsgGiftSend2 != null ? cusMsgGiftSend2.getRule() : null;
            int value = LiveGiftRule.RULE_REALTIME.getValue();
            boolean z11 = true;
            if (rule != null && rule.intValue() == value) {
                h(this, false, 1, (Object) null);
                return;
            }
            int value2 = LiveGiftRule.RULE_FIXED_TIME.getValue();
            if (rule != null && rule.intValue() == value2) {
                LiveGiftShowDialog liveGiftShowDialog = f19737n;
                if (!(liveGiftShowDialog != null && !liveGiftShowDialog.isHidden())) {
                    LiveGiftBottomDialog liveGiftBottomDialog = f19738o;
                    if (liveGiftBottomDialog == null || liveGiftBottomDialog.isHidden()) {
                        z11 = false;
                    }
                    if (!z11 && (liveGiftFloatButton = f19729f) != null) {
                        liveGiftFloatButton.g(f19736m);
                        return;
                    }
                    return;
                }
                return;
            }
            LiveGiftRule.RULE_TASK.getValue();
            if (rule != null) {
                rule.intValue();
            }
        }
    }

    public final void f0() {
        Unit unit;
        try {
            Result.a aVar = Result.Companion;
            LiveGiftShowDialog liveGiftShowDialog = f19737n;
            if (liveGiftShowDialog != null) {
                liveGiftShowDialog.showNow(f19728e.getSupportFragmentManager(), "");
                unit = Unit.f56620a;
            } else {
                unit = null;
            }
            Result.m3072constructorimpl(unit);
        } catch (Throwable th2) {
            Result.a aVar2 = Result.Companion;
            Result.m3072constructorimpl(kotlin.k.a(th2));
        }
        v7.b.a().M(f19732i, f19734k).b().compose(RxJavaHelper.t((u6.g) null)).subscribe(new l());
    }

    public final void g(boolean z11) {
        if (f19737n == null) {
            IMLog.d(f19725b, "创建并弹出红包");
            f19737n = new LiveGiftShowDialog(f19746w, f19747x);
            Bundle bundle = new Bundle();
            bundle.putParcelable("live_gift_send_bean", f19736m);
            LiveGiftShowDialog liveGiftShowDialog = f19737n;
            if (liveGiftShowDialog != null) {
                liveGiftShowDialog.setArguments(bundle);
            }
            LiveGiftShowDialog liveGiftShowDialog2 = f19737n;
            if (liveGiftShowDialog2 != null) {
                liveGiftShowDialog2.setDialogDismissListener(c.f19723a);
            }
            LiveGiftShowDialog liveGiftShowDialog3 = f19737n;
            if (liveGiftShowDialog3 != null) {
                liveGiftShowDialog3.Ah(new i());
            }
            d10.a<Unit> aVar = f19740q;
            if (aVar != null) {
                Unit invoke = aVar.invoke();
            }
        }
        if (z11) {
            f0();
        }
    }

    public final void g0(String str) {
        Object rule;
        HashMap hashMap = new HashMap();
        String str2 = f19733j;
        if (str2 == null) {
            str2 = "";
        }
        hashMap.put("groupid", str2);
        String str3 = f19732i;
        if (str3 == null) {
            str3 = "";
        }
        hashMap.put("liveid", str3);
        Object obj = "1";
        hashMap.put(VineCardUtils.PLAYER_CARD, obj);
        StringBuilder sb2 = new StringBuilder();
        sb2.append("");
        CusMsgGiftSend cusMsgGiftSend = f19736m;
        if (!(cusMsgGiftSend == null || (rule = cusMsgGiftSend.getRule()) == null)) {
            obj = rule;
        }
        sb2.append(obj);
        hashMap.put("lotterytype", sb2.toString());
        q.a(str, hashMap);
    }

    public final CusMsgGiftSend j() {
        return f19736m;
    }

    public final String k() {
        return f19733j;
    }

    public final LiveGiftBottomDialog l() {
        return f19738o;
    }

    public final LiveGiftShowDialog m() {
        return f19737n;
    }

    public final LiveGiftShowView n() {
        return f19731h;
    }

    public final LiveGiftShowView o() {
        return f19730g;
    }

    public final String p() {
        return f19732i;
    }

    public final ld.f q() {
        return f19739p;
    }

    public final Handler r() {
        return f19748y;
    }

    public final b s() {
        return B;
    }

    public final HashMap<String, c> t() {
        return f19744u;
    }

    public final HashMap<String, C0140d> u() {
        return f19742s;
    }

    public final HashMap<String, e> v() {
        return f19745v;
    }

    public final HashMap<String, f> w() {
        return f19743t;
    }

    public final g x() {
        return f19741r;
    }

    public final String y() {
        return f19734k;
    }

    public final int z() {
        return f19735l;
    }
}
