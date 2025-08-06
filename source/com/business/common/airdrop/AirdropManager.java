package com.business.common.airdrop;

import android.content.Context;
import android.util.Log;
import androidx.fragment.app.FragmentManager;
import com.airbnb.lottie.LottieAnimationView;
import com.business.common.airdrop.data.AirdropBusinessId;
import com.business.common.airdrop.data.AirdropChannelBean;
import com.business.common.airdrop.data.AirdropCloseIdBean;
import com.business.common.airdrop.data.AirdropCustomBean;
import com.business.common.airdrop.data.AirdropCustomData;
import com.business.common.airdrop.data.AirdropExtInfo;
import com.business.common.airdrop.data.AirdropHeaderBean;
import com.business.common.airdrop.dialog.AirdropClaimDialogFragment;
import com.business.common.airdrop.dialog.AirdropResultDialogFragment;
import com.hbg.lib.common.utils.LogAndWoodRecorder;
import com.hbg.lib.network.hbg.core.bean.AirdropDetailBean;
import com.hbg.lib.network.hbg.core.bean.AirdropResultBean;
import com.hbg.lib.network.hbg.core.bean.AirdropRuleBean;
import com.hbg.module.libkt.base.ext.b;
import com.hbg.module.libkt.base.ext.f;
import com.hbg.module.libkt.utils.i;
import com.huobi.utils.GsonHelper;
import com.huochat.community.base.CommunityConstants;
import com.tencent.imsdk.v2.V2TIMCallback;
import com.tencent.imsdk.v2.V2TIMGroupMemberInfo;
import com.tencent.imsdk.v2.V2TIMManager;
import com.tencent.imsdk.v2.V2TIMSimpleMsgListener;
import java.io.File;
import java.nio.charset.Charset;
import java.util.Calendar;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TimeZone;
import kotlin.Unit;
import kotlin.coroutines.c;
import kotlin.jvm.internal.x;
import kotlinx.coroutines.g;
import kotlinx.coroutines.v0;
import we.b;

public final class AirdropManager {

    /* renamed from: a  reason: collision with root package name */
    public static final AirdropManager f64272a = new AirdropManager();

    /* renamed from: b  reason: collision with root package name */
    public static final Set<String> f64273b = new LinkedHashSet();

    public static final class a implements V2TIMCallback {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f64274a;

        public a(String str) {
            this.f64274a = str;
        }

        public void onError(int i11, String str) {
            Log.d("空投", "加群失败 code=" + i11 + ", msg=" + str);
        }

        public void onSuccess() {
            Log.d("空投", "加群成功");
            Set a11 = AirdropManager.f64273b;
            String str = this.f64274a;
            synchronized (a11) {
                AirdropManager.f64273b.add(str);
            }
        }
    }

    static {
        V2TIMManager.getInstance().addSimpleMsgListener(new V2TIMSimpleMsgListener() {
            public void onRecvGroupCustomMessage(String str, String str2, V2TIMGroupMemberInfo v2TIMGroupMemberInfo, byte[] bArr) {
                AirdropCustomData data;
                AirdropExtInfo extInfo;
                AirdropBusinessId airdropBusinessId;
                if (!b.x(str2) && bArr != null && CollectionsKt___CollectionsKt.R(AirdropManager.f64273b, str2)) {
                    AirdropCustomBean airdropCustomBean = (AirdropCustomBean) f.e().fromJson(new String(bArr, kotlin.text.b.f56908b), new AirdropManager$1$onRecvGroupCustomMessage$$inlined$gsonToBean$1().getType());
                    if (airdropCustomBean != null && (data = airdropCustomBean.getData()) != null && (extInfo = data.getExtInfo()) != null) {
                        b.a<AirdropChannelBean> g11 = AirdropManager.f64272a.g();
                        String businessID = airdropCustomBean.getBusinessID();
                        AirdropBusinessId airdropBusinessId2 = AirdropBusinessId.OPEN;
                        if (x.b(businessID, airdropBusinessId2.getId())) {
                            airdropBusinessId = airdropBusinessId2;
                        } else {
                            airdropBusinessId = AirdropBusinessId.CLOSE;
                        }
                        g11.g(new AirdropChannelBean(airdropBusinessId, extInfo.getGroupId(), extInfo.getTopicType(), extInfo.getTopicIdList(), extInfo.getTs()));
                    }
                }
            }
        });
    }

    public static final void e(String str) {
        try {
            AirdropHeaderBean airdropHeaderBean = (AirdropHeaderBean) GsonHelper.a().fromJson(str, AirdropHeaderBean.class);
            AirdropManager airdropManager = f64272a;
            airdropManager.j("拦截 Header : " + f.f(airdropHeaderBean));
            airdropManager.i().g(airdropHeaderBean);
            LogAndWoodRecorder.a("Airdrop", "Header-Success(" + f.f(airdropHeaderBean) + ')');
        } catch (Exception e11) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Header-Error(");
            String message = e11.getMessage();
            if (message == null) {
                message = "";
            }
            sb2.append(message);
            sb2.append(')');
            LogAndWoodRecorder.a("Airdrop", sb2.toString());
            AirdropManager airdropManager2 = f64272a;
            airdropManager2.j("Header : " + str + ", Exception : " + e11.getMessage());
        }
    }

    public final long c(AirdropDetailBean airdropDetailBean) {
        Integer prizeTime;
        long timeInMillis = Calendar.getInstance(TimeZone.getTimeZone(UtcDates.UTC)).getTimeInMillis();
        Long firstTimeMillis = airdropDetailBean.getFirstTimeMillis();
        long longValue = firstTimeMillis != null ? firstTimeMillis.longValue() : 0;
        AirdropRuleBean rule = airdropDetailBean.getRule();
        return ((longValue + ((long) (((rule == null || (prizeTime = rule.getPrizeTime()) == null) ? 0 : prizeTime.intValue()) * 1000))) - timeInMillis) / ((long) 1000);
    }

    public final Object d(Context context, String str, c<? super Unit> cVar) {
        Object g11 = g.g(v0.b(), new AirdropManager$downloadAnimation$2(str, context, (c<? super AirdropManager$downloadAnimation$2>) null), cVar);
        return g11 == IntrinsicsKt__IntrinsicsKt.d() ? g11 : Unit.f56620a;
    }

    public final void f(String str, String str2) {
        if (!com.hbg.module.libkt.base.ext.b.x(str) && !com.hbg.module.libkt.base.ext.b.x(str2)) {
            Set<String> set = f64273b;
            synchronized (set) {
                if (!set.contains(str)) {
                    Unit unit = Unit.f56620a;
                    V2TIMManager.getInstance().joinGroup(str, "", new a(str));
                }
            }
        }
    }

    public final b.a<AirdropChannelBean> g() {
        return we.b.l("EventNameAirdropChannel", AirdropChannelBean.class);
    }

    public final b.a<AirdropCloseIdBean> h() {
        return we.b.l("EventNameAirdropClose", AirdropCloseIdBean.class);
    }

    public final b.a<AirdropHeaderBean> i() {
        return we.b.l("EventNameAirdropHeader", AirdropHeaderBean.class);
    }

    public final void j(String str) {
        String str2 = "空投-" + AirdropManager.class.getSimpleName();
        if (str == null) {
            str = "--";
        }
        Log.d(str2, str);
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0035  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object k(int r5, java.lang.String r6, kotlin.coroutines.c<? super com.hbg.module.libkt.base.ext.g<? extends java.lang.Object>> r7) {
        /*
            r4 = this;
            boolean r0 = r7 instanceof com.business.common.airdrop.AirdropManager$requestAirdropClose$1
            if (r0 == 0) goto L_0x0013
            r0 = r7
            com.business.common.airdrop.AirdropManager$requestAirdropClose$1 r0 = (com.business.common.airdrop.AirdropManager$requestAirdropClose$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.label = r1
            goto L_0x0018
        L_0x0013:
            com.business.common.airdrop.AirdropManager$requestAirdropClose$1 r0 = new com.business.common.airdrop.AirdropManager$requestAirdropClose$1
            r0.<init>(r4, r7)
        L_0x0018:
            java.lang.Object r7 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.d()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L_0x0035
            if (r2 != r3) goto L_0x002d
            java.lang.Object r5 = r0.L$0
            com.business.common.airdrop.AirdropManager r5 = (com.business.common.airdrop.AirdropManager) r5
            kotlin.k.b(r7)
            goto L_0x004c
        L_0x002d:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L_0x0035:
            kotlin.k.b(r7)
            com.hbg.lib.network.hbg.IHbgApi r7 = v7.b.a()
            d9.a r5 = r7.A(r5, r6)
            r0.L$0 = r4
            r0.label = r3
            java.lang.Object r7 = com.hbg.module.libkt.base.ext.RequestExtKt.a(r5, r0)
            if (r7 != r1) goto L_0x004b
            return r1
        L_0x004b:
            r5 = r4
        L_0x004c:
            com.hbg.module.libkt.base.ext.g r7 = (com.hbg.module.libkt.base.ext.g) r7
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            java.lang.String r0 = "关闭空投 : "
            r6.append(r0)
            java.lang.String r0 = com.hbg.module.libkt.base.ext.f.f(r7)
            r6.append(r0)
            java.lang.String r6 = r6.toString()
            r5.j(r6)
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.business.common.airdrop.AirdropManager.k(int, java.lang.String, kotlin.coroutines.c):java.lang.Object");
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0035  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object l(int r5, java.lang.String r6, kotlin.coroutines.c<? super com.hbg.module.libkt.base.ext.g<com.hbg.lib.network.hbg.core.bean.AirdropDetailBean>> r7) {
        /*
            r4 = this;
            boolean r0 = r7 instanceof com.business.common.airdrop.AirdropManager$requestAirdropDetail$1
            if (r0 == 0) goto L_0x0013
            r0 = r7
            com.business.common.airdrop.AirdropManager$requestAirdropDetail$1 r0 = (com.business.common.airdrop.AirdropManager$requestAirdropDetail$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.label = r1
            goto L_0x0018
        L_0x0013:
            com.business.common.airdrop.AirdropManager$requestAirdropDetail$1 r0 = new com.business.common.airdrop.AirdropManager$requestAirdropDetail$1
            r0.<init>(r4, r7)
        L_0x0018:
            java.lang.Object r7 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.d()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L_0x0035
            if (r2 != r3) goto L_0x002d
            java.lang.Object r5 = r0.L$0
            com.business.common.airdrop.AirdropManager r5 = (com.business.common.airdrop.AirdropManager) r5
            kotlin.k.b(r7)
            goto L_0x004c
        L_0x002d:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L_0x0035:
            kotlin.k.b(r7)
            com.hbg.lib.network.hbg.IHbgApi r7 = v7.b.a()
            d9.a r5 = r7.airdropDetail(r5, r6)
            r0.L$0 = r4
            r0.label = r3
            java.lang.Object r7 = com.hbg.module.libkt.base.ext.RequestExtKt.a(r5, r0)
            if (r7 != r1) goto L_0x004b
            return r1
        L_0x004b:
            r5 = r4
        L_0x004c:
            com.hbg.module.libkt.base.ext.g r7 = (com.hbg.module.libkt.base.ext.g) r7
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            java.lang.String r0 = "空头详情 : "
            r6.append(r0)
            java.lang.String r0 = com.hbg.module.libkt.base.ext.f.f(r7)
            r6.append(r0)
            java.lang.String r6 = r6.toString()
            r5.j(r6)
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.business.common.airdrop.AirdropManager.l(int, java.lang.String, kotlin.coroutines.c):java.lang.Object");
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0035  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object m(int r5, java.lang.String r6, kotlin.coroutines.c<? super com.hbg.module.libkt.base.ext.g<com.hbg.lib.network.hbg.core.bean.AirdropResultBean>> r7) {
        /*
            r4 = this;
            boolean r0 = r7 instanceof com.business.common.airdrop.AirdropManager$requestAirdropDraw$1
            if (r0 == 0) goto L_0x0013
            r0 = r7
            com.business.common.airdrop.AirdropManager$requestAirdropDraw$1 r0 = (com.business.common.airdrop.AirdropManager$requestAirdropDraw$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.label = r1
            goto L_0x0018
        L_0x0013:
            com.business.common.airdrop.AirdropManager$requestAirdropDraw$1 r0 = new com.business.common.airdrop.AirdropManager$requestAirdropDraw$1
            r0.<init>(r4, r7)
        L_0x0018:
            java.lang.Object r7 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.d()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L_0x0035
            if (r2 != r3) goto L_0x002d
            java.lang.Object r5 = r0.L$0
            com.business.common.airdrop.AirdropManager r5 = (com.business.common.airdrop.AirdropManager) r5
            kotlin.k.b(r7)
            goto L_0x004c
        L_0x002d:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L_0x0035:
            kotlin.k.b(r7)
            com.hbg.lib.network.hbg.IHbgApi r7 = v7.b.a()
            d9.a r5 = r7.u0(r5, r6)
            r0.L$0 = r4
            r0.label = r3
            java.lang.Object r7 = com.hbg.module.libkt.base.ext.RequestExtKt.a(r5, r0)
            if (r7 != r1) goto L_0x004b
            return r1
        L_0x004b:
            r5 = r4
        L_0x004c:
            com.hbg.module.libkt.base.ext.g r7 = (com.hbg.module.libkt.base.ext.g) r7
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            java.lang.String r0 = "领取空投 : "
            r6.append(r0)
            java.lang.String r0 = com.hbg.module.libkt.base.ext.f.f(r7)
            r6.append(r0)
            java.lang.String r6 = r6.toString()
            r5.j(r6)
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.business.common.airdrop.AirdropManager.m(int, java.lang.String, kotlin.coroutines.c):java.lang.Object");
    }

    public final void n(LottieAnimationView lottieAnimationView, String str) {
        String a11 = i.a(str);
        File cacheDir = lottieAnimationView.getContext().getCacheDir();
        File file = new File(cacheDir, "animation/" + a11 + ".json");
        if (file.exists()) {
            lottieAnimationView.setAnimationFromJson(FilesKt__FileReadWriteKt.b(file, Charset.forName("UTF-8")), a11);
            j("缓存加载: " + str);
            return;
        }
        lottieAnimationView.setAnimationFromUrl(str);
        j("网络加载: " + str);
    }

    public final void o(FragmentManager fragmentManager, AirdropDetailBean airdropDetailBean, int i11, String str) {
        new AirdropClaimDialogFragment(airdropDetailBean, i11, str).Ih(fragmentManager);
    }

    public final void p(FragmentManager fragmentManager, AirdropDetailBean airdropDetailBean, AirdropResultBean airdropResultBean, int i11, String str) {
        new AirdropResultDialogFragment(airdropDetailBean, airdropResultBean, i11, str).yh(fragmentManager);
    }

    public final void q(int i11, String str, int i12) {
        String str2 = "";
        if (i11 == 4) {
            HashMap hashMap = new HashMap();
            hashMap.put("location", "app_community_dynamic_details_sideways");
            if (i12 == 1) {
                str2 = "remind_confirm";
            } else if (i12 == 2) {
                str2 = "remind_cancel";
            }
            hashMap.put("button_name", str2);
            hashMap.put(CommunityConstants.TOPIC_ID, str);
            vf.a.a("app_community_sideways_click", hashMap);
        } else if (i11 == 20) {
            HashMap hashMap2 = new HashMap();
            hashMap2.put("location", "app_community_homepage_find_sideways");
            if (i12 == 1) {
                str2 = "remind_confirm";
            } else if (i12 == 2) {
                str2 = "remind_cancel";
            }
            hashMap2.put("button_name", str2);
            vf.a.a("app_community_sideways_click", hashMap2);
        } else if (i11 == 28) {
            HashMap hashMap3 = new HashMap();
            hashMap3.put("location", "community_k_line_comment_sideways");
            if (i12 == 1) {
                str2 = "remind_confirm";
            } else if (i12 == 2) {
                str2 = "remind_cancel";
            }
            hashMap3.put("button_name", str2);
            hashMap3.put(CommunityConstants.TOPIC_ID, str);
            vf.a.a("app_community_sideways_click", hashMap3);
        }
    }

    public final void r(int i11, String str, boolean z11, int i12) {
        String str2 = "sideways_blue";
        if (i11 == 4) {
            HashMap hashMap = new HashMap();
            hashMap.put("location", "app_community_dynamic_details_sideways");
            if (!z11) {
                str2 = "sideways_close";
            }
            hashMap.put("button_name", str2);
            hashMap.put("button_state", Integer.valueOf(i12));
            hashMap.put(CommunityConstants.TOPIC_ID, str);
            vf.a.a("app_community_sideways_click", hashMap);
        } else if (i11 == 20) {
            HashMap hashMap2 = new HashMap();
            hashMap2.put("location", "app_community_homepage_find_sideways");
            if (!z11) {
                str2 = "sideways_close";
            }
            hashMap2.put("button_name", str2);
            hashMap2.put("button_state", Integer.valueOf(i12));
            vf.a.a("app_community_sideways_click", hashMap2);
        } else if (i11 == 28) {
            HashMap hashMap3 = new HashMap();
            hashMap3.put("location", "community_k_line_comment_sideways");
            if (!z11) {
                str2 = "sideways_close";
            }
            hashMap3.put("button_name", str2);
            hashMap3.put("button_state", Integer.valueOf(i12));
            hashMap3.put(CommunityConstants.TOPIC_ID, str);
            vf.a.a("app_community_sideways_click", hashMap3);
        }
    }

    public final void s(int i11, String str) {
        if (i11 == 4) {
            HashMap hashMap = new HashMap();
            hashMap.put("location", "app_community_dynamic_details_sideways");
            hashMap.put(CommunityConstants.TOPIC_ID, str);
            vf.a.a("app_community_sideways_show", hashMap);
        } else if (i11 == 20) {
            HashMap hashMap2 = new HashMap();
            hashMap2.put("location", "app_community_homepage_find_sideways");
            vf.a.a("app_community_sideways_show", hashMap2);
        } else if (i11 == 28) {
            HashMap hashMap3 = new HashMap();
            hashMap3.put("location", "community_k_line_comment_sideways");
            hashMap3.put(CommunityConstants.TOPIC_ID, str);
            vf.a.a("app_community_sideways_show", hashMap3);
        }
    }
}
