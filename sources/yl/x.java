package yl;

import android.annotation.SuppressLint;
import android.os.Handler;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentActivity;
import com.hbg.lib.core.network.rx.EasySubscriber;
import com.hbg.lib.network.hbg.core.bean.TransferSellList;
import com.hbg.lib.network.retrofit.exception.APIStatusErrorException;
import com.hbg.lib.widgets.dialog.DialogUtils;
import com.hbg.lib.widgets.dialog.HBDialogFragment;
import com.huobi.login.bean.JumpTarget;
import com.huobi.main.ui.HuobiMainActivity;
import com.huobi.utils.k0;
import com.xiaomi.mipush.sdk.Constants;
import java.util.Arrays;
import org.greenrobot.eventbus.EventBus;
import pro.huobi.R;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;
import tg.r;

public final class x {

    /* renamed from: a  reason: collision with root package name */
    public HBDialogFragment f76862a;

    /* renamed from: b  reason: collision with root package name */
    public int f76863b;

    /* renamed from: c  reason: collision with root package name */
    public int f76864c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f76865d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f76866e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f76867f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f76868g;

    /* renamed from: h  reason: collision with root package name */
    public String[] f76869h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f76870i;

    /* renamed from: j  reason: collision with root package name */
    public boolean f76871j;

    public class a extends EasySubscriber<Object> {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ c f76872b;

        public a(c cVar) {
            this.f76872b = cVar;
        }

        public void onError2(Throwable th2) {
            x.this.z(0);
        }

        public void onFailed(APIStatusErrorException aPIStatusErrorException) {
            if ("10009".equals(aPIStatusErrorException.getErrCode())) {
                x.this.z(1);
                c cVar = this.f76872b;
                if (cVar != null) {
                    cVar.a();
                }
            }
        }

        public void onNext(Object obj) {
            super.onNext(obj);
            x.this.z(2);
        }
    }

    public class b extends EasySubscriber<TransferSellList> {
        public b() {
        }

        /* renamed from: a */
        public void onNext(TransferSellList transferSellList) {
            super.onNext(transferSellList);
            String currencys = transferSellList.getCurrencys();
            boolean z11 = false;
            if (TextUtils.isEmpty(currencys)) {
                boolean unused = x.this.f76866e = false;
            } else {
                boolean unused2 = x.this.f76866e = true;
                if (currencys.contains("*")) {
                    boolean unused3 = x.this.f76868g = true;
                } else {
                    boolean unused4 = x.this.f76868g = false;
                    String[] unused5 = x.this.f76869h = currencys.toLowerCase().split(Constants.ACCEPT_TIME_SEPARATOR_SP);
                }
            }
            x xVar = x.this;
            if (transferSellList.getIsClearRange() == 1) {
                z11 = true;
            }
            boolean unused6 = xVar.f76867f = z11;
            boolean unused7 = x.this.f76871j = true;
            x.this.B();
        }

        public void onError2(Throwable th2) {
            boolean unused = x.this.f76871j = true;
            x.this.B();
        }

        public void onFailed(APIStatusErrorException aPIStatusErrorException) {
            boolean unused = x.this.f76871j = true;
            x.this.B();
        }
    }

    public interface c {
        void a();
    }

    public static class d {
        @SuppressLint({"StaticFieldLeak"})

        /* renamed from: a  reason: collision with root package name */
        public static x f76875a = new x((a) null);
    }

    public /* synthetic */ x(a aVar) {
        this();
    }

    public static x n() {
        return d.f76875a;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void u() {
        FragmentActivity fragmentActivity = (FragmentActivity) oa.a.g().f(HuobiMainActivity.class);
        if (fragmentActivity != null) {
            new Handler().postDelayed(new v(this, fragmentActivity), 500);
        }
    }

    public static /* synthetic */ void v(FragmentActivity fragmentActivity, HBDialogFragment hBDialogFragment) {
        if (r.x().F0()) {
            rn.c.i().d(fragmentActivity, new JumpTarget(k0.c(fragmentActivity), k0.h(fragmentActivity)));
        } else {
            rn.c.i().d(fragmentActivity, (kn.a) null);
        }
        hBDialogFragment.dismiss();
    }

    public final void A(FragmentActivity fragmentActivity) {
        String str;
        String str2;
        if (r.x().F0()) {
            str = fragmentActivity.getString(R.string.n_discharge_optimize_conuntry_alert);
        } else {
            str = fragmentActivity.getString(R.string.n_discharge_optimize_ip_alert);
        }
        SpannableString spannableString = new SpannableString(str);
        spannableString.setSpan(new ForegroundColorSpan(ContextCompat.getColor(fragmentActivity, R.color.base_down_color)), 0, str.length(), 33);
        if (r.x().F0()) {
            str2 = fragmentActivity.getString(R.string.n_discharge_optimize_get_coin);
        } else {
            str2 = fragmentActivity.getString(R.string.n_discharge_optimize_login);
        }
        HBDialogFragment j02 = new DialogUtils.b.d(fragmentActivity).c1(fragmentActivity.getString(R.string.trade_reminder_text)).n0(false).C0(spannableString).D0(Integer.valueOf(fragmentActivity.getResources().getColor(R.color.base_down_color))).T0(true).R0(fragmentActivity.getString(R.string.n_discharge_optimize_alert_message)).S0(Integer.valueOf(fragmentActivity.getResources().getColor(R.color.baseColorPrimaryText))).P0(str2).q0(false).Q0(new u(fragmentActivity)).j0();
        this.f76862a = j02;
        j02.show(fragmentActivity.getSupportFragmentManager(), HBDialogFragment.class.getName());
    }

    public final void B() {
        if (s()) {
            EventBus.d().k(new rg.a(p()));
        }
    }

    public void k() {
        HBDialogFragment hBDialogFragment = this.f76862a;
        if (hBDialogFragment != null && hBDialogFragment.th()) {
            this.f76862a.dismiss();
        }
        this.f76862a = null;
        this.f76864c = 0;
        x(new w(this));
        y();
    }

    /* renamed from: l */
    public void t(FragmentActivity fragmentActivity) {
        if (!this.f76865d && o() == 1) {
            HBDialogFragment hBDialogFragment = this.f76862a;
            if (hBDialogFragment == null || !hBDialogFragment.th()) {
                A(fragmentActivity);
            }
        }
    }

    public boolean m(String str) {
        if (this.f76868g) {
            return true;
        }
        String[] strArr = this.f76869h;
        if (strArr == null || strArr.length <= 0) {
            return false;
        }
        return Arrays.asList(strArr).contains(str.toLowerCase());
    }

    public final int o() {
        if (r.x().F0()) {
            return this.f76864c;
        }
        return this.f76863b;
    }

    public boolean p() {
        return o() == 1 || this.f76867f;
    }

    public boolean q() {
        return this.f76867f && this.f76866e;
    }

    public boolean r() {
        return this.f76867f;
    }

    public boolean s() {
        return this.f76870i && this.f76871j;
    }

    public void w(boolean z11) {
        HBDialogFragment hBDialogFragment;
        this.f76865d = z11;
        if (z11 && (hBDialogFragment = this.f76862a) != null && hBDialogFragment.th()) {
            this.f76862a.dismiss();
        }
    }

    public void x(c cVar) {
        v7.b.a().getDeprecated().b().subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new a(cVar));
    }

    public void y() {
        v7.b.a().getTransferSellList().b().subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new b());
    }

    public final void z(int i11) {
        if (r.x().F0()) {
            this.f76864c = i11;
            this.f76870i = true;
            B();
            return;
        }
        this.f76863b = i11;
    }

    public x() {
        this.f76863b = 0;
        this.f76864c = 0;
        this.f76865d = false;
        this.f76866e = false;
        this.f76867f = false;
        this.f76868g = false;
        this.f76870i = false;
        this.f76871j = false;
    }
}
