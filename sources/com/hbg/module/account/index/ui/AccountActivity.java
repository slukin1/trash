package com.hbg.module.account.index.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.fastjson.JSON;
import com.hbg.lib.core.BaseModuleConfig;
import com.hbg.lib.core.util.AppLanguageHelper;
import com.hbg.lib.core.util.NightHelper;
import com.hbg.lib.network.newkyc.bean.UserKycInfoNew;
import com.hbg.module.account.R$anim;
import com.hbg.module.libkt.base.ui.BaseActivity;
import com.hbg.module.libkt.provider.BaseJumpPageProvider;
import com.hbg.module.libkt.provider.HbgBaseProvider;
import com.hbg.module.libkt.provider.JumpPageScheme;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import com.tencent.android.tpush.common.Constants;
import java.util.HashMap;
import kotlin.Pair;
import kotlin.l;
import rd.q;

@Route(path = "/newAccount/index")
public final class AccountActivity extends BaseActivity<wb.a> {

    /* renamed from: i  reason: collision with root package name */
    public rj.b f77666i;

    /* renamed from: j  reason: collision with root package name */
    public String f77667j = "";

    /* renamed from: k  reason: collision with root package name */
    public String f77668k = "";

    public static final class a implements View.OnClickListener {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ View f77669b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ long f77670c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ AccountActivity f77671d;

        /* renamed from: com.hbg.module.account.index.ui.AccountActivity$a$a  reason: collision with other inner class name */
        public static final class C0831a implements Runnable {

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ View f77672b;

            public C0831a(View view) {
                this.f77672b = view;
            }

            public final void run() {
                this.f77672b.setClickable(true);
            }
        }

        public a(View view, long j11, AccountActivity accountActivity) {
            this.f77669b = view;
            this.f77670c = j11;
            this.f77671d = accountActivity;
        }

        @SensorsDataInstrumented
        public final void onClick(View view) {
            this.f77669b.setClickable(false);
            this.f77671d.Gh();
            View view2 = this.f77669b;
            view2.postDelayed(new C0831a(view2), this.f77670c);
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }
    }

    public static final class b implements View.OnClickListener {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ View f77673b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ long f77674c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ AccountActivity f77675d;

        public static final class a implements Runnable {

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ View f77676b;

            public a(View view) {
                this.f77676b = view;
            }

            public final void run() {
                this.f77676b.setClickable(true);
            }
        }

        public b(View view, long j11, AccountActivity accountActivity) {
            this.f77673b = view;
            this.f77674c = j11;
            this.f77675d = accountActivity;
        }

        @SensorsDataInstrumented
        public final void onClick(View view) {
            this.f77673b.setClickable(false);
            this.f77675d.Fh();
            View view2 = this.f77673b;
            view2.postDelayed(new a(view2), this.f77674c);
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }
    }

    public static final class c implements ve.a {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ AccountActivity f77677a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f77678b;

        public c(AccountActivity accountActivity, String str) {
            this.f77677a = accountActivity;
            this.f77678b = str;
        }

        /* JADX WARNING: Removed duplicated region for block: B:53:0x009e  */
        /* JADX WARNING: Removed duplicated region for block: B:56:0x00a7  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void a(com.hbg.lib.network.hbg.core.bean.UserOtherInfoData r8) {
            /*
                r7 = this;
                com.hbg.lib.core.BaseModuleConfig$a r0 = com.hbg.lib.core.BaseModuleConfig.a()
                r1 = 1
                r2 = 0
                if (r0 == 0) goto L_0x0010
                boolean r3 = r0.c()
                if (r3 != r1) goto L_0x0010
                r3 = r1
                goto L_0x0011
            L_0x0010:
                r3 = r2
            L_0x0011:
                r4 = 0
                if (r3 == 0) goto L_0x001f
                if (r0 == 0) goto L_0x001c
                java.lang.String r1 = r0.i()
                goto L_0x008d
            L_0x001c:
                r1 = r4
                goto L_0x008d
            L_0x001f:
                if (r0 == 0) goto L_0x0026
                com.hbg.lib.network.newkyc.bean.UserKycInfoNew r3 = r0.q()
                goto L_0x0027
            L_0x0026:
                r3 = r4
            L_0x0027:
                if (r3 == 0) goto L_0x0038
                com.hbg.lib.network.newkyc.bean.AuthInfoNew r5 = r3.getAuth_info()
                if (r5 == 0) goto L_0x0038
                int r5 = r5.getPro_auth_type()
                r6 = 10
                if (r5 != r6) goto L_0x0038
                goto L_0x0039
            L_0x0038:
                r1 = r2
            L_0x0039:
                if (r1 == 0) goto L_0x0048
                if (r3 == 0) goto L_0x001c
                com.hbg.lib.network.newkyc.bean.AuthInfoNew r1 = r3.getAuth_info()
                if (r1 == 0) goto L_0x001c
                java.lang.String r1 = r1.getPro_org_name()
                goto L_0x008d
            L_0x0048:
                if (r8 == 0) goto L_0x004f
                java.lang.String r1 = r8.getNick_name()
                goto L_0x0050
            L_0x004f:
                r1 = r4
            L_0x0050:
                boolean r1 = sd.a.c(r1)
                if (r1 != 0) goto L_0x005d
                if (r8 == 0) goto L_0x001c
                java.lang.String r1 = r8.getNick_name()
                goto L_0x008d
            L_0x005d:
                if (r8 == 0) goto L_0x0064
                java.lang.String r1 = r8.getPhone()
                goto L_0x0065
            L_0x0064:
                r1 = r4
            L_0x0065:
                boolean r1 = sd.a.c(r1)
                if (r1 != 0) goto L_0x0072
                if (r8 == 0) goto L_0x001c
                java.lang.String r1 = r8.getPhone()
                goto L_0x008d
            L_0x0072:
                if (r8 == 0) goto L_0x0079
                java.lang.String r1 = r8.getEmail()
                goto L_0x007a
            L_0x0079:
                r1 = r4
            L_0x007a:
                boolean r1 = sd.a.c(r1)
                if (r1 != 0) goto L_0x0087
                if (r8 == 0) goto L_0x001c
                java.lang.String r1 = r8.getEmail()
                goto L_0x008d
            L_0x0087:
                if (r0 == 0) goto L_0x001c
                java.lang.String r1 = r0.i()
            L_0x008d:
                if (r8 == 0) goto L_0x0095
                if (r0 != 0) goto L_0x0092
                goto L_0x0095
            L_0x0092:
                r0.I(r8)
            L_0x0095:
                com.hbg.module.account.index.ui.AccountActivity r0 = r7.f77677a
                boolean r2 = android.text.TextUtils.isEmpty(r1)
                if (r2 != 0) goto L_0x009e
                goto L_0x00a0
            L_0x009e:
                java.lang.String r1 = r7.f77678b
            L_0x00a0:
                r0.f77667j = r1
                com.hbg.module.account.index.ui.AccountActivity r0 = r7.f77677a
                if (r8 == 0) goto L_0x00ab
                java.lang.String r4 = r8.getHead_image()
            L_0x00ab:
                r0.f77668k = r4
                com.hbg.module.account.index.ui.AccountActivity r8 = r7.f77677a
                r8.Eh()
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.hbg.module.account.index.ui.AccountActivity.c.a(com.hbg.lib.network.hbg.core.bean.UserOtherInfoData):void");
        }
    }

    /* renamed from: Dh */
    public wb.a Og() {
        return wb.a.K(getLayoutInflater());
    }

    public final void Eh() {
        String str;
        boolean g11 = NightHelper.e().g();
        BaseModuleConfig.a a11 = BaseModuleConfig.a();
        HbgBaseProvider fg2 = fg();
        if (fg2 != null && !fg2.n()) {
            str = a11.P();
        } else if (a11.Z() != null && !sd.a.c(a11.Z().getPhone())) {
            str = a11.Z().getPhone();
        } else if (a11.Z() == null || sd.a.c(a11.Z().getEmail())) {
            str = "";
        } else {
            str = a11.Z().getEmail();
        }
        if (a11.c()) {
            str = a11.i();
        }
        int i11 = -1;
        UserKycInfoNew q11 = a11.q();
        if (!(q11 == null || q11.getAuth_info() == null)) {
            i11 = q11.getAuth_info().getPro_status();
        }
        Pair[] pairArr = new Pair[12];
        HbgBaseProvider fg3 = fg();
        pairArr[0] = l.a("isLogin", Integer.valueOf((fg3 == null || !fg3.n()) ? 0 : 1));
        pairArr[1] = l.a("platform", "1");
        pairArr[2] = l.a("nightMode", Integer.valueOf(g11 ? 1 : 0));
        pairArr[3] = l.a("uid", a11.getUid());
        pairArr[4] = l.a("nickName", this.f77667j);
        pairArr[5] = l.a(Constants.FLAG_ACCOUNT, str);
        pairArr[6] = l.a("hasNewVersion", Boolean.valueOf(a11.t()));
        pairArr[7] = l.a("language", AppLanguageHelper.getInstance().getCurAppLocaleName());
        pairArr[8] = l.a("pro_status", Integer.valueOf(i11));
        pairArr[9] = l.a("webhost", a11.j());
        pairArr[10] = l.a("flaghost", a11.j() + "/-/x/hb");
        pairArr[11] = l.a("childAccount", Boolean.valueOf(a11.c()));
        HashMap j11 = MapsKt__MapsKt.j(pairArr);
        try {
            rj.b bVar = this.f77666i;
            if (bVar != null) {
                bVar.I("uc.viewWillAppear(`" + JSON.toJSONString(j11) + "`)");
            }
        } catch (Throwable th2) {
            String message = th2.getMessage();
            if (message != null) {
                Log.e("", message);
                th2.printStackTrace();
            }
        }
    }

    public final void Fh() {
        BaseModuleConfig.a a11 = BaseModuleConfig.a();
        if (a11 != null) {
            a11.B(this);
        }
    }

    public final void Gh() {
        BaseJumpPageProvider baseJumpPageProvider = (BaseJumpPageProvider) b2.a.d().a("/provider/jumpPage").navigation();
        if (baseJumpPageProvider != null) {
            baseJumpPageProvider.d(this, JumpPageScheme.SETTING);
        }
    }

    public final void Hh() {
        rj.b bVar = this.f77666i;
        ((wb.a) Yf()).E.addView(bVar != null ? bVar.D("index.xml", this) : null);
        ImageView imageView = ((wb.a) Yf()).G;
        imageView.setOnClickListener(new a(imageView, 600, this));
        ImageView imageView2 = ((wb.a) Yf()).F;
        imageView2.setOnClickListener(new b(imageView2, 600, this));
    }

    public final void Ih() {
        rj.b bVar = this.f77666i;
        if (bVar != null) {
            ac.b.f76981a.c(bVar);
        }
        this.f77666i = ac.b.f76981a.b(this);
    }

    public final void Jh() {
        BaseModuleConfig.a a11;
        String str = sd.a.c(this.f77667j) ? "" : this.f77667j;
        HbgBaseProvider fg2 = fg();
        boolean z11 = true;
        if (fg2 == null || !fg2.n()) {
            z11 = false;
        }
        if (z11) {
            HbgBaseProvider fg3 = fg();
            if (fg3 != null) {
                fg3.a(new c(this, str));
                return;
            }
            return;
        }
        if (sd.a.c(str) && (a11 = BaseModuleConfig.a()) != null) {
            this.f77667j = a11.P();
        }
        Eh();
    }

    public void finish() {
        super.finish();
        overridePendingTransition(0, R$anim.account_slide_right_out);
    }

    public void initView() {
        super.initView();
        q.a("PV_Me_view", (HashMap<?, ?>) null);
        NightHelper.e().d(this);
        ((wb.a) Yf()).M(this);
        Qg(NightHelper.e().g());
        Ih();
        Hh();
        overridePendingTransition(R$anim.account_slide_right_in, R$anim.anim_no);
    }

    public View onCreateView(String str, Context context, AttributeSet attributeSet) {
        return super.onCreateView(str, context, attributeSet);
    }

    public void onDestroy() {
        super.onDestroy();
        ac.b.f76981a.c(this.f77666i);
    }

    public void onResume() {
        super.onResume();
        Jh();
    }
}
