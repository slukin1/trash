package com.hbg.module.kline.ui;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.hbg.lib.core.ui.BaseFragment;
import com.hbg.lib.data.future.bean.FutureContractInfo;
import com.hbg.lib.data.future.util.FuturePrecisionUtil;
import com.hbg.lib.data.symbol.TradeType;
import com.hbg.lib.widgets.LoadingLayout;
import com.hbg.module.kline.R$id;
import com.hbg.module.kline.R$layout;
import com.hbg.module.kline.presenter.MarketInfoDepthPresenter;
import com.hbg.module.kline.ui.KLineDepthLayout;
import com.huobi.contract.helper.ContractCurrencyUtils;
import td.i;

public class MarketInfoDepthFragment extends BaseFragment<MarketInfoDepthPresenter, MarketInfoDepthPresenter.a> implements MarketInfoDepthPresenter.a {

    /* renamed from: l  reason: collision with root package name */
    public String f23979l;

    /* renamed from: m  reason: collision with root package name */
    public LoadingLayout f23980m;

    /* renamed from: n  reason: collision with root package name */
    public KLineDepthLayout f23981n;

    public class a implements KLineDepthLayout.c {
        public a() {
        }

        public TradeType D0() {
            return ((MarketInfoDepthPresenter) MarketInfoDepthFragment.this.yh()).j0();
        }

        public String E0() {
            return ((MarketInfoDepthPresenter) MarketInfoDepthFragment.this.yh()).b0();
        }

        public String F0() {
            try {
                if (TradeType.isSwap(MarketInfoDepthFragment.this.f23979l)) {
                    return ((MarketInfoDepthPresenter) MarketInfoDepthFragment.this.yh()).h0().getContractFace();
                }
                if (TradeType.isOption(MarketInfoDepthFragment.this.f23979l)) {
                    return ((MarketInfoDepthPresenter) MarketInfoDepthFragment.this.yh()).g0().getContractFace();
                }
                if (TradeType.isLinearSwap(MarketInfoDepthFragment.this.f23979l)) {
                    return ((MarketInfoDepthPresenter) MarketInfoDepthFragment.this.yh()).g0().getContractFace();
                }
                return ((MarketInfoDepthPresenter) MarketInfoDepthFragment.this.yh()).c0().getContractFace();
            } catch (Throwable unused) {
                return ContractCurrencyUtils.i(((MarketInfoDepthPresenter) MarketInfoDepthFragment.this.yh()).f0());
            }
        }

        public String G0() {
            return ((MarketInfoDepthPresenter) MarketInfoDepthFragment.this.yh()).i0();
        }

        public String H0() {
            return ((MarketInfoDepthPresenter) MarketInfoDepthFragment.this.yh()).d0();
        }

        public int I0() {
            try {
                if (TradeType.isSwap(MarketInfoDepthFragment.this.f23979l)) {
                    return i.a().b().m(((MarketInfoDepthPresenter) MarketInfoDepthFragment.this.yh()).h0().getSymbol());
                } else if (TradeType.isOption(MarketInfoDepthFragment.this.f23979l)) {
                    return FuturePrecisionUtil.s(E0(), J0(), G0());
                } else {
                    if (TradeType.isLinearSwap(MarketInfoDepthFragment.this.f23979l)) {
                        return FuturePrecisionUtil.s(E0(), J0(), G0());
                    }
                    return i.a().b().t(((MarketInfoDepthPresenter) MarketInfoDepthFragment.this.yh()).c0().getContractCode());
                }
            } catch (Throwable unused) {
                return 0;
            }
        }

        public String J0() {
            FutureContractInfo futureContractInfo;
            if (MarketInfoDepthFragment.this.getActivity() == null || (futureContractInfo = (FutureContractInfo) MarketInfoDepthFragment.this.getActivity().getIntent().getSerializableExtra("contract_currency_info")) == null) {
                return "";
            }
            return futureContractInfo.getContractShortType();
        }

        public String k1() {
            return ((MarketInfoDepthPresenter) MarketInfoDepthFragment.this.yh()).i0();
        }
    }

    public void Ah() {
        super.Ah();
    }

    /* renamed from: Dh */
    public MarketInfoDepthPresenter xh() {
        return new MarketInfoDepthPresenter();
    }

    /* renamed from: Eh */
    public MarketInfoDepthPresenter.a zh() {
        return this;
    }

    public LoadingLayout f6() {
        return this.f23980m;
    }

    public void initViews() {
        super.initViews();
        this.f23979l = getActivity().getIntent().getStringExtra("market_trade_type");
        this.f23981n = (KLineDepthLayout) this.f67460i.b(R$id.id_kline_depth_layout);
        this.f23980m = (LoadingLayout) this.f67460i.b(R$id.depth_loading_layout);
    }

    public void kg() {
        this.f23981n.setCallback(new a());
    }

    public void onPause() {
        KLineDepthLayout kLineDepthLayout = this.f23981n;
        if (kLineDepthLayout != null) {
            kLineDepthLayout.B(false);
            this.f23981n.A();
        }
        super.onPause();
    }

    public void onResume() {
        KLineDepthLayout kLineDepthLayout = this.f23981n;
        if (kLineDepthLayout != null) {
            kLineDepthLayout.B(true);
            this.f23981n.A();
            this.f23981n.s();
        }
        super.onResume();
    }

    public View ph(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(R$layout.fragment_market_info_depth, viewGroup, false);
    }
}
