package com.hbg.module.content.ui.activity;

import android.view.View;
import android.widget.Checkable;
import android.widget.ImageView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.widget.ViewPager2;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.hbg.lib.core.BaseModuleConfig;
import com.hbg.lib.core.util.NightHelper;
import com.hbg.lib.network.hbg.core.bean.ContentNavigationInfo;
import com.hbg.lib.network.retrofit.util.SPUtil;
import com.hbg.module.community.ui.CommunityFragment;
import com.hbg.module.content.ui.ability.ContentAbility;
import com.hbg.module.content.ui.fragment.H5Fragment;
import com.hbg.module.content.ui.fragment.NewContentFragment;
import com.hbg.module.libkt.R$color;
import com.hbg.module.libkt.base.ext.f;
import com.hbg.module.libkt.base.ui.BaseActivity;
import com.hbg.module.libkt.custom.indicator.TabData;
import com.hbg.module.livesquare.ui.LiveSquareFragment;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import kotlin.Unit;
import kotlin.jvm.internal.r;
import lc.o;
import rd.s;

@Route(path = "/content/Index")
public final class NewContentActivity extends BaseActivity<o> {

    /* renamed from: i  reason: collision with root package name */
    public rj.b f18285i;

    /* renamed from: j  reason: collision with root package name */
    public final ArrayList<TabData> f18286j = new ArrayList<>();

    /* renamed from: k  reason: collision with root package name */
    public final ArrayList<Fragment> f18287k = new ArrayList<>();

    /* renamed from: l  reason: collision with root package name */
    public String f18288l = "0";

    /* renamed from: m  reason: collision with root package name */
    public HashMap<String, Integer> f18289m = new HashMap<>();

    public static final class a implements View.OnClickListener {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ View f18290b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ long f18291c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ NewContentActivity f18292d;

        public a(View view, long j11, NewContentActivity newContentActivity) {
            this.f18290b = view;
            this.f18291c = j11;
            this.f18292d = newContentActivity;
        }

        @SensorsDataInstrumented
        public final void onClick(View view) {
            long currentTimeMillis = System.currentTimeMillis();
            s sVar = s.f23381a;
            if (currentTimeMillis - sVar.b(this.f18290b) > this.f18291c || (this.f18290b instanceof Checkable)) {
                sVar.e(this.f18290b, currentTimeMillis);
                ImageView imageView = (ImageView) this.f18290b;
                BaseModuleConfig.a().h(this.f18292d);
            }
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }
    }

    public static final class b extends ViewPager2.OnPageChangeCallback {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ ArrayList<ContentNavigationInfo> f18293a;

        public b(ArrayList<ContentNavigationInfo> arrayList) {
            this.f18293a = arrayList;
        }

        public void onPageSelected(int i11) {
            super.onPageSelected(i11);
            SPUtil.m("newContentTabPos", String.valueOf(this.f18293a.get(i11).getType()));
        }
    }

    public static final void Ch(NewContentActivity newContentActivity, Object obj) {
        Object obj2;
        ArrayList arrayList = (ArrayList) f.e().fromJson(f.f(obj), new NewContentActivity$initView$lambda$5$$inlined$gsonToBean$1().getType());
        if (arrayList != null) {
            if (!com.hbg.module.libkt.base.ext.b.w(arrayList)) {
                newContentActivity.f18286j.clear();
                newContentActivity.f18287k.clear();
                Iterator it2 = arrayList.iterator();
                int i11 = 0;
                while (it2.hasNext()) {
                    int i12 = i11 + 1;
                    ContentNavigationInfo contentNavigationInfo = (ContentNavigationInfo) it2.next();
                    newContentActivity.f18286j.add(new TabData(contentNavigationInfo.getTitle(), 0, 0, 6, (r) null));
                    newContentActivity.f18289m.put(String.valueOf(contentNavigationInfo.getType()), Integer.valueOf(i11));
                    ArrayList<Fragment> arrayList2 = newContentActivity.f18287k;
                    int type = contentNavigationInfo.getType();
                    if (type == 1) {
                        obj2 = NewContentFragment.a.b(NewContentFragment.B, newContentActivity.f18285i, 0, 2, (Object) null);
                    } else if (type == 2) {
                        obj2 = LiveSquareFragment.Rh(contentNavigationInfo.getType(), "");
                    } else if (type == 3) {
                        obj2 = NewContentFragment.B.a(newContentActivity.f18285i, contentNavigationInfo.getType());
                    } else if (type == 5) {
                        obj2 = CommunityFragment.E.a(contentNavigationInfo.getType(), 1, "");
                    } else if (type != 8) {
                        String url = contentNavigationInfo.getUrl();
                        if (url != null && StringsKt__StringsJVMKt.M(url, "/", false, 2, (Object) null)) {
                            contentNavigationInfo.setUrl(contentNavigationInfo.getUrl().substring(1));
                        }
                        obj2 = H5Fragment.a.b(H5Fragment.f18742s, BaseModuleConfig.a().k(contentNavigationInfo.getUrl()), false, 2, (Object) null);
                    } else {
                        obj2 = NewContentFragment.B.a(newContentActivity.f18285i, contentNavigationInfo.getType());
                    }
                    arrayList2.add(obj2);
                    i11 = i12;
                }
                if (!com.hbg.module.libkt.base.ext.b.w(newContentActivity.f18286j)) {
                    he.a aVar = new he.a((FragmentActivity) newContentActivity);
                    aVar.a(newContentActivity.f18287k);
                    ((o) newContentActivity.Yf()).E.setAdapter(aVar);
                    newContentActivity.Ah();
                    ((o) newContentActivity.Yf()).E.registerOnPageChangeCallback(new b(arrayList));
                }
                ViewPager2 viewPager2 = ((o) newContentActivity.Yf()).E;
                Integer num = newContentActivity.f18289m.get(newContentActivity.f18288l);
                if (num == null) {
                    num = 0;
                }
                viewPager2.setCurrentItem(num.intValue(), false);
            }
            Unit unit = Unit.f56620a;
        }
    }

    public final void Ah() {
        ((o) Yf()).E.setOffscreenPageLimit(this.f18286j.size());
        ne.b.o(this, this.f18286j, ((o) Yf()).B, ((o) Yf()).E, 18.0f, R$color.baseColorPrimaryText, R$color.baseColorSecondaryTextNew, (Float) null, (Integer) null, (Integer) null, true, 896, (Object) null);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0024, code lost:
        if (r1 == null) goto L_0x0070;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x0049, code lost:
        if (r1 == null) goto L_0x0070;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:0x006e, code lost:
        if (r1 == null) goto L_0x0070;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void Bh(rj.b r11) {
        /*
            r10 = this;
            if (r11 == 0) goto L_0x014e
            com.hbg.lib.core.BaseModuleConfig$a r0 = com.hbg.lib.core.BaseModuleConfig.a()
            com.hbg.module.libkt.provider.HbgBaseProvider r1 = r10.fg()
            r2 = 1
            r3 = 0
            if (r1 == 0) goto L_0x0016
            boolean r1 = r1.n()
            if (r1 != 0) goto L_0x0016
            r1 = r2
            goto L_0x0017
        L_0x0016:
            r1 = r3
        L_0x0017:
            java.lang.String r4 = ""
            r5 = 0
            if (r1 == 0) goto L_0x0027
            if (r0 == 0) goto L_0x0023
            java.lang.String r1 = r0.P()
            goto L_0x0024
        L_0x0023:
            r1 = r5
        L_0x0024:
            if (r1 != 0) goto L_0x0071
            goto L_0x0070
        L_0x0027:
            if (r0 == 0) goto L_0x0034
            com.hbg.lib.network.hbg.core.bean.UserOtherInfoData r1 = r0.Z()
            if (r1 == 0) goto L_0x0034
            java.lang.String r1 = r1.getPhone()
            goto L_0x0035
        L_0x0034:
            r1 = r5
        L_0x0035:
            boolean r1 = sd.a.c(r1)
            if (r1 != 0) goto L_0x004c
            if (r0 == 0) goto L_0x0048
            com.hbg.lib.network.hbg.core.bean.UserOtherInfoData r1 = r0.Z()
            if (r1 == 0) goto L_0x0048
            java.lang.String r1 = r1.getPhone()
            goto L_0x0049
        L_0x0048:
            r1 = r5
        L_0x0049:
            if (r1 != 0) goto L_0x0071
            goto L_0x0070
        L_0x004c:
            if (r0 == 0) goto L_0x0059
            com.hbg.lib.network.hbg.core.bean.UserOtherInfoData r1 = r0.Z()
            if (r1 == 0) goto L_0x0059
            java.lang.String r1 = r1.getEmail()
            goto L_0x005a
        L_0x0059:
            r1 = r5
        L_0x005a:
            boolean r1 = sd.a.c(r1)
            if (r1 != 0) goto L_0x0070
            if (r0 == 0) goto L_0x006d
            com.hbg.lib.network.hbg.core.bean.UserOtherInfoData r1 = r0.Z()
            if (r1 == 0) goto L_0x006d
            java.lang.String r1 = r1.getEmail()
            goto L_0x006e
        L_0x006d:
            r1 = r5
        L_0x006e:
            if (r1 != 0) goto L_0x0071
        L_0x0070:
            r1 = r4
        L_0x0071:
            r6 = -1
            if (r0 == 0) goto L_0x0088
            com.hbg.lib.network.newkyc.bean.UserKycInfoNew r7 = r0.q()
            if (r7 == 0) goto L_0x0088
            com.hbg.lib.network.newkyc.bean.AuthInfoNew r8 = r7.getAuth_info()
            if (r8 == 0) goto L_0x0088
            com.hbg.lib.network.newkyc.bean.AuthInfoNew r6 = r7.getAuth_info()
            int r6 = r6.getPro_status()
        L_0x0088:
            r7 = 9
            kotlin.Pair[] r7 = new kotlin.Pair[r7]
            com.hbg.module.libkt.provider.HbgBaseProvider r8 = r10.fg()
            if (r8 == 0) goto L_0x009a
            boolean r8 = r8.n()
            if (r8 != r2) goto L_0x009a
            r8 = r2
            goto L_0x009b
        L_0x009a:
            r8 = r3
        L_0x009b:
            java.lang.Integer r8 = java.lang.Integer.valueOf(r8)
            java.lang.String r9 = "isLogin"
            kotlin.Pair r8 = kotlin.l.a(r9, r8)
            r7[r3] = r8
            java.lang.String r8 = "platform"
            java.lang.String r9 = "1"
            kotlin.Pair r8 = kotlin.l.a(r8, r9)
            r7[r2] = r8
            r2 = 2
            com.hbg.lib.core.util.NightHelper r8 = com.hbg.lib.core.util.NightHelper.e()
            boolean r8 = r8.g()
            java.lang.Integer r8 = java.lang.Integer.valueOf(r8)
            java.lang.String r9 = "nightMode"
            kotlin.Pair r8 = kotlin.l.a(r9, r8)
            r7[r2] = r8
            r2 = 3
            if (r0 == 0) goto L_0x00ce
            java.lang.String r8 = r0.getUid()
            goto L_0x00cf
        L_0x00ce:
            r8 = r5
        L_0x00cf:
            if (r8 != 0) goto L_0x00d2
            r8 = r4
        L_0x00d2:
            java.lang.String r9 = "uid"
            kotlin.Pair r8 = kotlin.l.a(r9, r8)
            r7[r2] = r8
            r2 = 4
            java.lang.String r8 = "account"
            kotlin.Pair r1 = kotlin.l.a(r8, r1)
            r7[r2] = r1
            r1 = 5
            if (r0 == 0) goto L_0x00ea
            boolean r3 = r0.t()
        L_0x00ea:
            java.lang.Boolean r2 = java.lang.Boolean.valueOf(r3)
            java.lang.String r3 = "hasNewVersion"
            kotlin.Pair r2 = kotlin.l.a(r3, r2)
            r7[r1] = r2
            r1 = 6
            com.hbg.lib.core.util.AppLanguageHelper r2 = com.hbg.lib.core.util.AppLanguageHelper.getInstance()
            java.lang.String r2 = r2.getCurAppLocaleName()
            java.lang.String r3 = "language"
            kotlin.Pair r2 = kotlin.l.a(r3, r2)
            r7[r1] = r2
            r1 = 7
            java.lang.Integer r2 = java.lang.Integer.valueOf(r6)
            java.lang.String r3 = "pro_status"
            kotlin.Pair r2 = kotlin.l.a(r3, r2)
            r7[r1] = r2
            r1 = 8
            if (r0 == 0) goto L_0x011c
            java.lang.String r5 = r0.j()
        L_0x011c:
            if (r5 != 0) goto L_0x011f
            goto L_0x0120
        L_0x011f:
            r4 = r5
        L_0x0120:
            java.lang.String r0 = "webhost"
            kotlin.Pair r0 = kotlin.l.a(r0, r4)
            r7[r1] = r0
            java.util.HashMap r0 = kotlin.collections.MapsKt__MapsKt.j(r7)
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "nav.initNativeData('"
            r1.append(r2)
            java.lang.String r0 = com.hbg.module.libkt.base.ext.f.f(r0)
            r1.append(r0)
            java.lang.String r0 = "')"
            r1.append(r0)
            java.lang.String r0 = r1.toString()
            r11.I(r0)
            java.lang.String r0 = "nativeRes.initRes()"
            r11.I(r0)
        L_0x014e:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.hbg.module.content.ui.activity.NewContentActivity.Bh(rj.b):void");
    }

    public void initView() {
        super.initView();
        ((o) Yf()).M(this);
        Qg(NightHelper.e().g());
        s sVar = s.f23381a;
        ImageView imageView = ((o) Yf()).C;
        imageView.setOnClickListener(new a(imageView, 800, this));
        rj.b bVar = new rj.b(getApplicationContext(), "content");
        this.f18285i = bVar;
        bVar.t("contentBridge", ContentAbility.class);
        rj.b bVar2 = this.f18285i;
        if (bVar2 != null) {
            bVar2.H();
        }
        rj.b bVar3 = this.f18285i;
        if (bVar3 != null) {
            Bh(bVar3);
        }
        rj.b bVar4 = this.f18285i;
        if (bVar4 != null) {
            bVar4.u("nav.contentNavList", new e(this));
        }
        rj.b bVar5 = this.f18285i;
        if (bVar5 != null) {
            bVar5.I("nav.getContentNav()");
        }
    }

    public void oh() {
        Unit unit;
        super.oh();
        String stringExtra = getIntent().getStringExtra("type");
        if (stringExtra != null) {
            if (stringExtra.hashCode() == 48 && stringExtra.equals("0")) {
                stringExtra = SPUtil.d("newContentTabPos", "0");
            }
            this.f18288l = stringExtra;
            unit = Unit.f56620a;
        } else {
            unit = null;
        }
        if (unit == null) {
            this.f18288l = SPUtil.d("newContentTabPos", "0");
        }
    }

    public void onDestroy() {
        super.onDestroy();
        rj.b bVar = this.f18285i;
        if (bVar != null) {
            bVar.B();
        }
    }

    public void onResume() {
        super.onResume();
        rj.b bVar = this.f18285i;
        if (bVar != null) {
            Bh(bVar);
        }
    }

    /* renamed from: zh */
    public o Og() {
        return o.K(getLayoutInflater());
    }
}
