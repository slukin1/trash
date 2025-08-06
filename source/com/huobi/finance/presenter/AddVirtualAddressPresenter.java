package com.huobi.finance.presenter;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Build;
import android.text.TextUtils;
import androidx.annotation.Keep;
import com.google.zxing.client.android.CaptureActivity;
import com.hbg.lib.common.mvp.ActivityPresenter;
import com.hbg.lib.common.ui.BaseCoreActivity;
import com.hbg.lib.core.network.rx.SilentSubscriber;
import com.hbg.lib.core.permissions.AfterPermissionGranted;
import com.hbg.lib.core.permissions.AppSettingsDialog;
import com.hbg.lib.core.permissions.EasyPermissions;
import com.hbg.lib.core.util.RxJavaHelper;
import com.hbg.lib.network.pro.core.bean.ChainInfo;
import com.hbg.lib.network.pro.core.bean.RiskActionData;
import com.hbg.lib.network.pro.core.bean.WithdrawRiskInfo;
import com.hbg.lib.network.retrofit.exception.APIStatusErrorException;
import com.hbg.lib.network.retrofit.util.MapParamsBuilder;
import com.hbg.lib.widgets.utils.HuobiToastUtil;
import com.hbg.lib.widgets.utils.PermissionUtils;
import com.huobi.account.helper.AuthData;
import com.huobi.finance.api.FinanceService;
import com.huobi.finance.bean.AddVirtualAddressParams;
import com.huobi.finance.bean.VirtualAddressInfo;
import com.huobi.finance.controller.VirtualAddressProvider;
import com.huobi.finance.ui.AddAddrRiskActivity;
import com.huobi.finance.utils.DepositWithdrawHelper;
import com.huobi.login.usercenter.data.source.bean.SecurityStrategySet;
import com.huobi.login.usercenter.data.source.remote.UserCenterRemoteDataSource;
import com.huobi.utils.k0;
import com.luck.picture.lib.permissions.PermissionConfig;
import d7.k;
import i6.i;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import k20.h;
import org.greenrobot.eventbus.ThreadMode;
import pro.huobi.R;
import q6.d;
import tq.p;
import u6.g;

public class AddVirtualAddressPresenter extends ActivityPresenter<a> implements EasyPermissions.PermissionCallbacks {

    /* renamed from: b  reason: collision with root package name */
    public String f45458b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f45459c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f45460d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f45461e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f45462f;

    /* renamed from: g  reason: collision with root package name */
    public int f45463g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f45464h;

    /* renamed from: i  reason: collision with root package name */
    public String f45465i;

    /* renamed from: j  reason: collision with root package name */
    public ChainInfo f45466j;

    public interface a extends g {
        void P0();

        void l3();

        void y(boolean z11);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void B0() {
        ((a) getUI()).y(true);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void C0(String[] strArr, int i11) {
        if (i11 == 0) {
            Intent intent = new Intent(getActivity(), CaptureActivity.class);
            intent.putExtra(CaptureActivity.PARAM_HINT_TEXT, getString(R.string.scan_text_hint));
            getActivity().startActivityForResult(intent, 200);
        } else if (i11 == 2) {
            EasyPermissions.requestPermissions(getActivity(), 123, strArr);
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void r0(SecurityStrategySet securityStrategySet) {
        this.f45459c = securityStrategySet.getSetting().isVerify_phone();
        this.f45460d = securityStrategySet.getSetting().isVerify_email();
        this.f45461e = securityStrategySet.getSetting().isVerify_ga();
        this.f45462f = securityStrategySet.getSetting().isVerifyPassword();
        ((a) getUI()).P0();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void s0() {
        getActivity().setResult(-1, new Intent());
        getActivity().finish();
    }

    public static /* synthetic */ void t0(ArrayList arrayList) {
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void u0(WithdrawRiskInfo withdrawRiskInfo) {
        String orderState = withdrawRiskInfo.getRiskActionData().getOrderState();
        if (RiskActionData.ORDER_STATE_DONE.equalsIgnoreCase(orderState)) {
            E0();
        } else if (RiskActionData.ORDER_STATE_TODO.equalsIgnoreCase(orderState)) {
            F0(withdrawRiskInfo.getAddressId());
        } else if (RiskActionData.ORDER_STATE_FAIL.equalsIgnoreCase(orderState)) {
            D0();
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void v0(APIStatusErrorException aPIStatusErrorException) {
        D0();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void w0(Throwable th2) {
        D0();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void x0() {
        ((a) getUI()).y(false);
    }

    public final void D0() {
        HuobiToastUtil.j(R.string.n_risk_add_withdraw_addr_fail_subtitle);
    }

    public final void E0() {
        HuobiToastUtil.p(R.string.add_address_successful);
        i.b().g(new d(this), 50);
        VirtualAddressProvider.f().e(this.f45458b, this.f45465i, false).compose(RxJavaHelper.s()).subscribe(SilentSubscriber.a(c.f45828b));
    }

    public final void F0(String str) {
        AddAddrRiskActivity.Gh(getActivity(), str);
        getActivity().finish();
    }

    /* renamed from: G0 */
    public void onUIReady(BaseCoreActivity baseCoreActivity, a aVar) {
        super.onUIReady(baseCoreActivity, aVar);
        Intent intent = getActivity().getIntent();
        if (intent != null) {
            this.f45458b = intent.getStringExtra("coin_type");
            this.f45465i = intent.getStringExtra("chain");
            this.f45466j = k.C().F(this.f45458b, this.f45465i);
            this.f45463g = intent.getIntExtra("number", 0);
            this.f45464h = DepositWithdrawHelper.t(this.f45466j);
        }
        ((a) getUI()).l3();
    }

    /* renamed from: H0 */
    public final void y0(VirtualAddressInfo virtualAddressInfo, String str, String str2, String str3, String str4) {
        AuthData authData = new AuthData();
        if (!TextUtils.isEmpty(str)) {
            authData.setEmail_code(str);
        }
        if (!TextUtils.isEmpty(str2)) {
            authData.setSms_code(str2);
        }
        if (!TextUtils.isEmpty(str3)) {
            authData.setGa_code(str3);
        }
        Map<String, Object> b11 = MapParamsBuilder.c().a("AuthData", authData.toString()).b();
        virtualAddressInfo.setToken(str4);
        ((FinanceService) p.W(FinanceService.class)).addWithdrawAddressWithRisk(b11, AddVirtualAddressParams.create(getActivity(), virtualAddressInfo)).compose(p.a0()).compose(RxJavaHelper.t((g) getUI())).subscribe(d.d((g) getUI(), new g(this), new h(this), new j(this)));
    }

    public void I0(String str, String str2, String str3, String str4, String str5, VirtualAddressInfo virtualAddressInfo) {
        UserCenterRemoteDataSource.G(str, str2, str3, str4, (Map<String, Object>) null, str5, d.b((g) getUI(), new f(this), new k(this, virtualAddressInfo, str, str2, str3), l.f45963b, b.f45810b, new e(this)), (g) getUI());
    }

    @AfterPermissionGranted(123)
    public void J0() {
        String[] strArr;
        if (Build.VERSION.SDK_INT >= 33) {
            strArr = new String[]{"android.permission.CAMERA", PermissionConfig.READ_MEDIA_IMAGES};
        } else {
            strArr = new String[]{"android.permission.CAMERA", PermissionConfig.WRITE_EXTERNAL_STORAGE};
        }
        PermissionUtils.g(getActivity(), new a(this, strArr));
    }

    public void c0() {
        UserCenterRemoteDataSource.A().F().compose(p.c0()).compose(RxJavaHelper.t((g) getUI())).subscribe(d.c((g) getUI(), new i(this)));
    }

    public String d0() {
        String e11 = DepositWithdrawHelper.e(k.C().F(this.f45458b, this.f45465i));
        return String.format(getString(R.string.add_address_et_hint2), new Object[]{g0(), e11});
    }

    public String f0() {
        return this.f45458b.toUpperCase(Locale.US);
    }

    public String g0() {
        return this.f45458b.toUpperCase(Locale.US);
    }

    public String h0() {
        return this.f45458b;
    }

    public String i0() {
        String e11 = DepositWithdrawHelper.e(k.C().F(this.f45458b, this.f45465i));
        return String.format(getString(R.string.add_address_default_note), new Object[]{g0(), e11, String.valueOf(this.f45463g)});
    }

    public String j0() {
        return String.format(getString(R.string.add_address_title), new Object[]{f0()});
    }

    public VirtualAddressInfo k0() {
        VirtualAddressInfo virtualAddressInfo = new VirtualAddressInfo();
        virtualAddressInfo.setCurrency(this.f45458b);
        virtualAddressInfo.setChain(this.f45465i);
        return virtualAddressInfo;
    }

    public boolean l0() {
        return this.f45464h;
    }

    public boolean m0() {
        return this.f45460d;
    }

    public boolean n0() {
        return this.f45461e;
    }

    public void onPermissionsDenied(int i11, List<String> list) {
        if (EasyPermissions.somePermissionPermanentlyDenied(getActivity(), list)) {
            new AppSettingsDialog.Builder((Activity) getActivity(), getString(R.string.permission_camera_write_external_storage_apply)).setTitle(getString(R.string.permission_apply)).setPositiveButton(getString(R.string.go_to_settings)).setNegativeButton(getString(R.string.global_string_cancel), (DialogInterface.OnClickListener) null).setRequestCode(125).build().show();
        }
    }

    public void onPermissionsGranted(int i11, List<String> list) {
    }

    public boolean p0() {
        return this.f45462f;
    }

    public boolean q0() {
        return this.f45459c;
    }

    @h(threadMode = ThreadMode.MAIN)
    @Keep
    public void tokenError(mo.a aVar) {
        getActivity().startActivity(k0.h(getActivity()));
        getActivity().finish();
    }
}
