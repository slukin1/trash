package com.hbg.module.community.viewmodel;

import androidx.lifecycle.MutableLiveData;
import com.hbg.lib.core.util.NightHelper;
import com.hbg.lib.network.hbg.core.bean.CommunityFeedInfo;
import com.hbg.lib.network.hbg.core.bean.CommunityUserPermissions;
import com.hbg.lib.network.hbg.core.bean.LiveBannerData;
import com.hbg.module.libkt.base.ext.RequestExtKt;
import com.sensorsdata.analytics.android.sdk.SensorsDataAPI;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;
import kotlin.Pair;
import kotlin.i;
import kotlin.jvm.internal.r;
import kotlin.l;
import kotlin.text.Regex;
import org.json.JSONObject;
import v7.b;

public final class CommunityViewModel extends BaseViewModel {

    /* renamed from: j  reason: collision with root package name */
    public static final a f17614j = new a((r) null);

    /* renamed from: a  reason: collision with root package name */
    public final i f17615a = LazyKt__LazyJVMKt.a(CommunityViewModel$communityFeedInfo$2.INSTANCE);

    /* renamed from: b  reason: collision with root package name */
    public final i f17616b = LazyKt__LazyJVMKt.a(CommunityViewModel$commonFeedList$2.INSTANCE);

    /* renamed from: c  reason: collision with root package name */
    public final i f17617c = LazyKt__LazyJVMKt.a(CommunityViewModel$feedLoadingError$2.INSTANCE);

    /* renamed from: d  reason: collision with root package name */
    public final i f17618d = LazyKt__LazyJVMKt.a(CommunityViewModel$communityUserPermissions$2.INSTANCE);

    /* renamed from: e  reason: collision with root package name */
    public final i f17619e = LazyKt__LazyJVMKt.a(CommunityViewModel$isLoadMore$2.INSTANCE);

    /* renamed from: f  reason: collision with root package name */
    public final i f17620f = LazyKt__LazyJVMKt.a(CommunityViewModel$bannerList$2.INSTANCE);

    /* renamed from: g  reason: collision with root package name */
    public final i f17621g = LazyKt__LazyJVMKt.a(CommunityViewModel$isBannerSuccess$2.INSTANCE);

    /* renamed from: h  reason: collision with root package name */
    public long f17622h;

    /* renamed from: i  reason: collision with root package name */
    public int f17623i;

    public static final class a {
        public a() {
        }

        public /* synthetic */ a(r rVar) {
            this();
        }
    }

    public final MutableLiveData<List<LiveBannerData>> h0() {
        return (MutableLiveData) this.f17620f.getValue();
    }

    public final MutableLiveData<List<CommunityFeedInfo.ListBean>> i0() {
        return (MutableLiveData) this.f17616b.getValue();
    }

    public final MutableLiveData<CommunityFeedInfo> j0() {
        return (MutableLiveData) this.f17615a.getValue();
    }

    public final MutableLiveData<CommunityUserPermissions> k0() {
        return (MutableLiveData) this.f17618d.getValue();
    }

    public final MutableLiveData<Boolean> l0() {
        return (MutableLiveData) this.f17617c.getValue();
    }

    public final MutableLiveData<Boolean> m0() {
        return (MutableLiveData) this.f17621g.getValue();
    }

    public final MutableLiveData<Boolean> n0() {
        return (MutableLiveData) this.f17619e.getValue();
    }

    public final void o0(int i11) {
        RequestExtKt.d(b.a().getLiveBanner(i11, NightHelper.e().g() ? 1 : 0), new CommunityViewModel$requestBanner$1(this), new CommunityViewModel$requestBanner$2(this), (MutableLiveData) null, 4, (Object) null);
    }

    public final void p0(int i11) {
        if (i11 == -1 || i11 == 1) {
            this.f17622h = 0;
        }
        RequestExtKt.d(b.a().getCommunityFeedInfo(10, this.f17622h), new CommunityViewModel$requestCommunityFeedInfo$1(i11, this), new CommunityViewModel$requestCommunityFeedInfo$2(this), (MutableLiveData) null, 4, (Object) null);
    }

    public final void q0(int i11) {
        if (i11 == -1 || i11 == 1) {
            this.f17622h = 0;
            this.f17623i = 0;
        }
        HashMap hashMap = new HashMap();
        JSONObject presetProperties = SensorsDataAPI.sharedInstance().getPresetProperties();
        if (presetProperties != null) {
            Iterator<String> keys = presetProperties.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                Object opt = presetProperties.opt(next);
                if (opt != null) {
                    hashMap.put(new Regex("\\$").replace((CharSequence) next, ""), opt);
                }
            }
        }
        hashMap.put("frompage", "huobi_pro");
        hashMap.put("orgpage", "homepage");
        Pair[] pairArr = new Pair[6];
        pairArr[0] = l.a("requestId", UUID.randomUUID().toString());
        pairArr[1] = l.a("actionType", Integer.valueOf(i11 == -1 ? 1 : i11));
        pairArr[2] = l.a("requestNum", 10);
        pairArr[3] = l.a("lastTime", Long.valueOf(this.f17622h));
        pairArr[4] = l.a("lastCommunityId", Integer.valueOf(this.f17623i));
        pairArr[5] = l.a("realtimeFeastures", hashMap);
        RequestExtKt.d(b.a().getCommunityFeedInfoNew(MapsKt__MapsKt.l(pairArr)), new CommunityViewModel$requestCommunityFeedInfoNew$1(i11, this), new CommunityViewModel$requestCommunityFeedInfoNew$2(this, i11), (MutableLiveData) null, 4, (Object) null);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:14:0x005c, code lost:
        r3 = r3.getList();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void r0(int r10, java.lang.String r11, java.lang.String r12, int r13) {
        /*
            r9 = this;
            r0 = -1
            r1 = 1
            if (r10 == r0) goto L_0x0007
            if (r10 == r1) goto L_0x0007
            goto L_0x000b
        L_0x0007:
            r2 = 0
            r9.f17622h = r2
        L_0x000b:
            java.util.HashMap r2 = new java.util.HashMap
            r2.<init>()
            com.sensorsdata.analytics.android.sdk.SensorsDataAPI r3 = com.sensorsdata.analytics.android.sdk.SensorsDataAPI.sharedInstance()
            org.json.JSONObject r3 = r3.getPresetProperties()
            if (r3 == 0) goto L_0x0041
            java.util.Iterator r4 = r3.keys()
        L_0x001e:
            boolean r5 = r4.hasNext()
            if (r5 == 0) goto L_0x0041
            java.lang.Object r5 = r4.next()
            java.lang.String r5 = (java.lang.String) r5
            java.lang.Object r6 = r3.opt(r5)
            if (r6 == 0) goto L_0x001e
            kotlin.text.Regex r7 = new kotlin.text.Regex
            java.lang.String r8 = "\\$"
            r7.<init>((java.lang.String) r8)
            java.lang.String r8 = ""
            java.lang.String r5 = r7.replace((java.lang.CharSequence) r5, (java.lang.String) r8)
            r2.put(r5, r6)
            goto L_0x001e
        L_0x0041:
            java.lang.String r3 = "frompage"
            java.lang.String r4 = "huobi_pro"
            r2.put(r3, r4)
            java.lang.String r3 = "orgpage"
            java.lang.String r4 = "homepage"
            r2.put(r3, r4)
            androidx.lifecycle.MutableLiveData r3 = r9.j0()
            java.lang.Object r3 = r3.getValue()
            com.hbg.lib.network.hbg.core.bean.CommunityFeedInfo r3 = (com.hbg.lib.network.hbg.core.bean.CommunityFeedInfo) r3
            r4 = 0
            if (r3 == 0) goto L_0x0067
            java.util.List r3 = r3.getList()
            if (r3 == 0) goto L_0x0067
            int r3 = r3.size()
            goto L_0x0068
        L_0x0067:
            r3 = r4
        L_0x0068:
            androidx.lifecycle.MutableLiveData r5 = r9.i0()
            java.lang.Object r5 = r5.getValue()
            java.util.List r5 = (java.util.List) r5
            if (r5 == 0) goto L_0x0079
            int r5 = r5.size()
            goto L_0x007a
        L_0x0079:
            r5 = r4
        L_0x007a:
            r6 = 8
            kotlin.Pair[] r6 = new kotlin.Pair[r6]
            long r7 = r9.f17622h
            java.lang.Long r7 = java.lang.Long.valueOf(r7)
            java.lang.String r8 = "lastTime"
            kotlin.Pair r7 = kotlin.l.a(r8, r7)
            r6[r4] = r7
            java.lang.String r4 = "symbol"
            kotlin.Pair r11 = kotlin.l.a(r4, r11)
            r6[r1] = r11
            java.lang.String r11 = "plateId"
            kotlin.Pair r11 = kotlin.l.a(r11, r12)
            r12 = 2
            r6[r12] = r11
            r11 = 3
            java.lang.String r4 = "realtimeFeastures"
            kotlin.Pair r2 = kotlin.l.a(r4, r2)
            r6[r11] = r2
            r11 = 4
            if (r10 != r0) goto L_0x00ab
            r0 = r1
            goto L_0x00ac
        L_0x00ab:
            r0 = r10
        L_0x00ac:
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
            java.lang.String r2 = "actionType"
            kotlin.Pair r0 = kotlin.l.a(r2, r0)
            r6[r11] = r0
            r11 = 5
            int r3 = r3 + r5
            java.lang.Integer r0 = java.lang.Integer.valueOf(r3)
            java.lang.String r2 = "showNum"
            kotlin.Pair r0 = kotlin.l.a(r2, r0)
            r6[r11] = r0
            r11 = 6
            r0 = 20
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
            java.lang.String r2 = "requestNum"
            kotlin.Pair r0 = kotlin.l.a(r2, r0)
            r6[r11] = r0
            r11 = 7
            if (r13 != r1) goto L_0x00d9
            r1 = r12
        L_0x00d9:
            java.lang.Integer r12 = java.lang.Integer.valueOf(r1)
            java.lang.String r0 = "bizType"
            kotlin.Pair r12 = kotlin.l.a(r0, r12)
            r6[r11] = r12
            java.util.Map r11 = kotlin.collections.MapsKt__MapsKt.l(r6)
            com.hbg.lib.network.hbg.IHbgApi r12 = v7.b.a()
            d9.a r0 = r12.getCommunityFeedHotInfoByKLine(r11)
            com.hbg.module.community.viewmodel.CommunityViewModel$requestFeedInfoByKline$1 r1 = new com.hbg.module.community.viewmodel.CommunityViewModel$requestFeedInfoByKline$1
            r1.<init>(r10, r9, r13)
            com.hbg.module.community.viewmodel.CommunityViewModel$requestFeedInfoByKline$2 r2 = new com.hbg.module.community.viewmodel.CommunityViewModel$requestFeedInfoByKline$2
            r2.<init>(r9, r10)
            r3 = 0
            r4 = 4
            r5 = 0
            com.hbg.module.libkt.base.ext.RequestExtKt.d(r0, r1, r2, r3, r4, r5)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.hbg.module.community.viewmodel.CommunityViewModel.r0(int, java.lang.String, java.lang.String, int):void");
    }

    public final void s0() {
        RequestExtKt.d(b.a().getCommunityUserPermissions(), new CommunityViewModel$requestUserInfo$1(this), CommunityViewModel$requestUserInfo$2.INSTANCE, (MutableLiveData) null, 4, (Object) null);
    }
}
