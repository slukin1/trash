package com.huobi.activity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import com.hbg.lib.core.ui.BaseActivity;
import com.hbg.lib.core.util.NightHelper;
import com.hbg.lib.data.future.bean.FutureContractInfo;
import com.hbg.lib.data.symbol.TradeType;
import com.hbg.lib.network.contract.core.bean.ContractCurrencyInfo;
import com.hbg.lib.network.swap.core.bean.SwapCurrencyInfo;
import com.huobi.contract.entity.ContractCurrencyInfoDrawerItem;
import com.huobi.linearswap.bean.LinearSwapCurrencyInfoDrawerItem;
import com.huobi.main.helper.l;
import com.huobi.main.presenter.TradeContainerPresenter;
import com.huobi.main.trade.ui.SymbolSelectionFragment;
import com.huobi.swap.bean.SwapCurrencyInfoDrawerItem;
import com.huobi.view.keyboard.HuobiKeyboardHelper;
import pro.huobi.R;
import u6.g;
import xg.s;

public class FutureTradeContainerActivity extends BaseActivity<TradeContainerPresenter, g> {

    /* renamed from: b  reason: collision with root package name */
    public String f42067b = "";

    /* renamed from: c  reason: collision with root package name */
    public SymbolSelectionFragment f42068c;

    /* renamed from: d  reason: collision with root package name */
    public HuobiKeyboardHelper f42069d;

    public static /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f42070a;

        /* JADX WARNING: Can't wrap try/catch for region: R(14:0|1|2|3|4|5|6|7|8|9|10|11|12|14) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x003e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0033 */
        static {
            /*
                com.hbg.lib.data.symbol.TradeType[] r0 = com.hbg.lib.data.symbol.TradeType.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f42070a = r0
                com.hbg.lib.data.symbol.TradeType r1 = com.hbg.lib.data.symbol.TradeType.PRO     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f42070a     // Catch:{ NoSuchFieldError -> 0x001d }
                com.hbg.lib.data.symbol.TradeType r1 = com.hbg.lib.data.symbol.TradeType.MARGIN     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f42070a     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.hbg.lib.data.symbol.TradeType r1 = com.hbg.lib.data.symbol.TradeType.SUPERMARGIN     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = f42070a     // Catch:{ NoSuchFieldError -> 0x0033 }
                com.hbg.lib.data.symbol.TradeType r1 = com.hbg.lib.data.symbol.TradeType.C2C     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                int[] r0 = f42070a     // Catch:{ NoSuchFieldError -> 0x003e }
                com.hbg.lib.data.symbol.TradeType r1 = com.hbg.lib.data.symbol.TradeType.CONTRACT     // Catch:{ NoSuchFieldError -> 0x003e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                int[] r0 = f42070a     // Catch:{ NoSuchFieldError -> 0x0049 }
                com.hbg.lib.data.symbol.TradeType r1 = com.hbg.lib.data.symbol.TradeType.LINEAR_SWAP     // Catch:{ NoSuchFieldError -> 0x0049 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0049 }
                r2 = 6
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0049 }
            L_0x0049:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.huobi.activity.FutureTradeContainerActivity.a.<clinit>():void");
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void Zf(TradeType tradeType, String str, Object obj) {
        switch (a.f42070a[tradeType.ordinal()]) {
            case 1:
            case 2:
            case 3:
            case 4:
                ((TradeContainerPresenter) getPresenter()).T(str, tradeType);
                return;
            case 5:
                if (obj instanceof ContractCurrencyInfo) {
                    ((TradeContainerPresenter) getPresenter()).Q((ContractCurrencyInfo) obj, tradeType);
                    return;
                } else if (obj instanceof SwapCurrencyInfo) {
                    ((TradeContainerPresenter) getPresenter()).U((SwapCurrencyInfo) obj, tradeType);
                    return;
                } else {
                    return;
                }
            case 6:
                if (obj instanceof FutureContractInfo) {
                    ((TradeContainerPresenter) getPresenter()).S((FutureContractInfo) obj, tradeType);
                    return;
                }
                return;
            default:
                return;
        }
    }

    /* renamed from: Yf */
    public TradeContainerPresenter createPresenter() {
        return new TradeContainerPresenter();
    }

    public void addEvent() {
    }

    public void fg(TradeType tradeType, s9.a aVar) {
        String str;
        this.f42069d.getBoardView().hideKeyboardLayout();
        if (aVar instanceof ContractCurrencyInfoDrawerItem) {
            str = ((ContractCurrencyInfoDrawerItem) aVar).d().getContractShortType();
        } else if (aVar instanceof SwapCurrencyInfoDrawerItem) {
            str = ((SwapCurrencyInfoDrawerItem) aVar).d().getContractShortType();
        } else if (aVar instanceof LinearSwapCurrencyInfoDrawerItem) {
            str = ((LinearSwapCurrencyInfoDrawerItem) aVar).e().getContractShortType();
        } else {
            str = "";
        }
        l.f(str, "", tradeType, false);
        SymbolSelectionFragment symbolSelectionFragment = new SymbolSelectionFragment();
        this.f42068c = symbolSelectionFragment;
        symbolSelectionFragment.Kh(new s(this));
        this.f42068c.Oh(getSupportFragmentManager(), "trade", tradeType);
    }

    public int getContentView() {
        return R.layout.activity_container;
    }

    public g getUI() {
        return this;
    }

    public void initView() {
        this.f42069d = new HuobiKeyboardHelper().attach(this);
        hideStatusBar();
        try {
            NightHelper.e().d(this);
            Bundle extras = getIntent().getExtras();
            String stringExtra = getIntent().getStringExtra("FutureTradeContainerActivity");
            Fragment instanceFragment = instanceFragment(stringExtra, extras, stringExtra);
            FragmentTransaction q11 = getSupportFragmentManager().q();
            FragmentManager supportFragmentManager = getSupportFragmentManager();
            if (supportFragmentManager.B0() != null) {
                for (Fragment next : supportFragmentManager.B0()) {
                    if (next != null && !(next instanceof DialogFragment)) {
                        q11.q(next);
                    }
                }
            }
            if (!instanceFragment.isAdded()) {
                q11.c(R.id.root, instanceFragment, stringExtra);
            }
            q11.A(instanceFragment).k();
        } catch (Throwable unused) {
            finish();
        }
    }

    public void onCreate(Bundle bundle) {
        if (NightHelper.e().g()) {
            setTheme(R.style.ActivityKlineNight);
        } else {
            setTheme(R.style.ActivityKlineLight);
        }
        super.onCreate(bundle);
        removeWinBg();
        String stringExtra = getIntent().getStringExtra("type");
        if (!TextUtils.isEmpty(stringExtra)) {
            this.f42067b = stringExtra;
        }
    }

    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        String stringExtra = getIntent().getStringExtra("type");
        if (!TextUtils.isEmpty(stringExtra)) {
            this.f42067b = stringExtra;
        }
    }

    public boolean useNewStatusBarFunc() {
        return true;
    }
}
