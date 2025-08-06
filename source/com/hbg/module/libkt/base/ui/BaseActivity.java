package com.hbg.module.libkt.base.ui;

import android.content.Context;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import androidx.core.view.h0;
import com.hbg.lib.common.ui.BaseCoreActivity;
import com.hbg.lib.core.util.AppLanguageHelper;
import com.hbg.lib.core.util.NightHelper;
import com.hbg.module.libkt.R$color;
import com.hbg.module.libkt.R$style;
import com.hbg.module.libkt.base.ext.b;
import com.hbg.module.libkt.base.state.EBaseViewStatus;
import com.hbg.module.libkt.provider.HbgBaseProvider;
import com.hbg.module.libkt.provider.HbgBaseShareProvider;
import com.hbg.module.libkt.utils.o;
import com.hbg.module.libkt.utils.r;
import com.huobi.woodpecker.monitor.OpPathMonitor;
import ie.c;
import java.util.ArrayList;
import ky.j;
import ny.d;
import x1.a;
import z9.g1;

public abstract class BaseActivity<VB extends a> extends BaseCoreActivity implements d {

    /* renamed from: b  reason: collision with root package name */
    public VB f24524b;

    /* renamed from: c  reason: collision with root package name */
    public EBaseViewStatus f24525c = EBaseViewStatus.SUCCESS;

    /* renamed from: d  reason: collision with root package name */
    public Handler f24526d;

    /* renamed from: e  reason: collision with root package name */
    public ue.a f24527e;

    /* renamed from: f  reason: collision with root package name */
    public g1 f24528f;

    /* renamed from: g  reason: collision with root package name */
    public HbgBaseProvider f24529g;

    /* renamed from: h  reason: collision with root package name */
    public HbgBaseShareProvider f24530h;

    public static final void Xf(BaseActivity baseActivity) {
        g1 g1Var;
        if (b.e(baseActivity)) {
            g1 g1Var2 = baseActivity.f24528f;
            boolean z11 = true;
            if (g1Var2 == null || !g1Var2.isShowing()) {
                z11 = false;
            }
            if (z11 && (g1Var = baseActivity.f24528f) != null) {
                g1Var.dismiss();
            }
        }
    }

    public static final void vh(BaseActivity baseActivity, boolean z11) {
        if (b.e(baseActivity)) {
            if (baseActivity.f24528f == null) {
                baseActivity.f24528f = new g1(baseActivity);
            }
            g1 g1Var = baseActivity.f24528f;
            if (g1Var != null) {
                g1Var.show();
            }
            g1 g1Var2 = baseActivity.f24528f;
            if (g1Var2 != null) {
                g1Var2.setCanceledOnTouchOutside(z11);
            }
            g1 g1Var3 = baseActivity.f24528f;
            if (g1Var3 != null) {
                g1Var3.setCancelable(z11);
            }
        }
    }

    public static final void wh(BaseActivity baseActivity, boolean z11, boolean z12) {
        if (b.e(baseActivity)) {
            if (baseActivity.f24528f == null) {
                baseActivity.f24528f = new g1(baseActivity);
            }
            g1 g1Var = baseActivity.f24528f;
            if (g1Var != null) {
                g1Var.show();
            }
            g1 g1Var2 = baseActivity.f24528f;
            if (g1Var2 != null) {
                g1Var2.setCanceledOnTouchOutside(z11);
            }
            g1 g1Var3 = baseActivity.f24528f;
            if (g1Var3 != null) {
                g1Var3.setCancelable(z12);
            }
        }
    }

    public final void Df() {
        Handler Zf = Zf();
        if (Zf != null) {
            Zf.post(new ie.a(this));
        }
    }

    public abstract VB Og();

    public void P8(j jVar) {
    }

    public final void Pg(boolean z11) {
        View findViewById = findViewById(getResources().getIdentifier("vTopBar", "id", getPackageName()));
        if (findViewById != null) {
            o.f24912a.c(this, findViewById, z11);
        }
    }

    public final void Qg(boolean z11) {
        int i11;
        try {
            o oVar = o.f24912a;
            boolean z12 = false;
            oVar.h(this, false);
            oVar.l(this);
            Window window = getWindow();
            if (z11) {
                i11 = getResources().getColor(R$color.black);
            } else {
                getWindow().getDecorView().setSystemUiVisibility(getWindow().getDecorView().getSystemUiVisibility() | 16);
                i11 = getResources().getColor(R$color.white);
            }
            window.setNavigationBarColor(i11);
            if (!z11) {
                z12 = true;
            }
            if (!oVar.j(this, z12)) {
                oVar.i(this, 1426063360);
            }
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
    }

    public VB Yf() {
        VB vb2 = this.f24524b;
        if (vb2 != null) {
            return vb2;
        }
        return null;
    }

    public Handler Zf() {
        return this.f24526d;
    }

    public void applyOverrideConfiguration(Configuration configuration) {
        if (configuration != null) {
            int i11 = configuration.uiMode;
            configuration.setTo(getBaseContext().getResources().getConfiguration());
            configuration.uiMode = i11;
        }
        super.applyOverrideConfiguration(configuration);
    }

    public void attachBaseContext(Context context) {
        super.attachBaseContext(AppLanguageHelper.getInstance().attachBaseContext(context));
    }

    public void bf(j jVar) {
    }

    public final HbgBaseProvider fg() {
        return this.f24529g;
    }

    public final HbgBaseShareProvider gg() {
        return this.f24530h;
    }

    public void initView() {
        View findViewById = findViewById(getResources().getIdentifier("vTopBar", "id", getPackageName()));
        if (findViewById != null) {
            o.f24912a.d(this, findViewById);
        }
    }

    public void oh() {
    }

    public void onCreate(Bundle bundle) {
        xh(false);
        if (!NightHelper.e().g()) {
            setTheme(R$style.ActivityKlineLight);
        } else {
            setTheme(R$style.ActivityKlineNight);
        }
        super.onCreate(bundle);
        ph();
        qh(Og());
        rh(new Handler(getMainLooper()));
        setContentView(Yf().getRoot());
        oh();
        initView();
    }

    public void onDestroy() {
        super.onDestroy();
        Handler Zf = Zf();
        if (Zf != null) {
            Zf.removeCallbacksAndMessages((Object) null);
        }
    }

    public void onRequestPermissionsResult(int i11, String[] strArr, int[] iArr) {
        super.onRequestPermissionsResult(i11, strArr, iArr);
        if (i11 == 1) {
            if (!(iArr.length == 0)) {
                ArrayList arrayList = new ArrayList();
                int length = iArr.length;
                for (int i12 = 0; i12 < length; i12++) {
                    if (iArr[i12] != 0) {
                        arrayList.add(strArr[i12]);
                    }
                }
                if (this.f24527e == null) {
                    return;
                }
                if (arrayList.isEmpty()) {
                    ue.a aVar = this.f24527e;
                    if (aVar != null) {
                        aVar.onGranted();
                        return;
                    }
                    return;
                }
                ue.a aVar2 = this.f24527e;
                if (aVar2 != null) {
                    aVar2.a(arrayList);
                }
            }
        }
    }

    public void onResume() {
        super.onResume();
        OpPathMonitor.c().a(getClass().getSimpleName(), getIntent().getExtras() == null ? null : String.valueOf(getIntent().getExtras()));
    }

    public final void ph() {
        this.f24529g = (HbgBaseProvider) b2.a.d().a("/provider/content").navigation();
        this.f24530h = (HbgBaseShareProvider) b2.a.d().a("/provider/share/h5").navigation();
    }

    public void qh(VB vb2) {
        this.f24524b = vb2;
    }

    public void rh(Handler handler) {
        this.f24526d = handler;
    }

    public final void setStatusBarColor(int i11) {
        View findViewById = findViewById(getResources().getIdentifier("vTopBar", "id", getPackageName()));
        if (findViewById != null) {
            r.f24939a.c(findViewById, i11);
        }
    }

    public final void sh() {
        th(true);
    }

    public final void th(boolean z11) {
        Handler Zf = Zf();
        if (Zf != null) {
            Zf.post(new ie.b(this, z11));
        }
    }

    public final void uh(boolean z11, boolean z12) {
        Handler Zf = Zf();
        if (Zf != null) {
            Zf.post(new c(this, z11, z12));
        }
    }

    public final void xh(boolean z11) {
        getWindow().addFlags(Integer.MIN_VALUE);
        if (z11) {
            getWindow().clearFlags(67108864);
            getWindow().setStatusBarColor(0);
            getWindow().getDecorView().setSystemUiVisibility(0);
        } else {
            getWindow().clearFlags(67108864);
            getWindow().setNavigationBarColor(0);
            getWindow().getDecorView().setSystemUiVisibility(1280);
            getWindow().addFlags(Integer.MIN_VALUE);
            getWindow().setStatusBarColor(0);
        }
        View childAt = ((ViewGroup) getWindow().findViewById(16908290)).getChildAt(0);
        if (childAt != null) {
            h0.G0(childAt, false);
            h0.u0(childAt);
        }
    }
}
