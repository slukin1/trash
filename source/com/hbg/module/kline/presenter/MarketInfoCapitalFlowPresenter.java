package com.hbg.module.kline.presenter;

import ce.e;
import com.hbg.lib.common.mvp.BaseFragmentPresenter;
import com.hbg.lib.common.ui.BaseCoreActivity;
import com.hbg.lib.core.network.rx.EasySubscriber;
import com.hbg.lib.core.util.RxJavaHelper;
import com.hbg.lib.network.pro.core.bean.SymbolBean;
import com.hbg.lib.network.pro.core.util.Period;
import com.hbg.lib.network.pro.retrofit.ProRetrofit;
import com.hbg.lib.network.pro.retrofit.service.ProApiService;
import com.hbg.lib.network.pro.socket.bean.FundSituationBean;
import com.hbg.lib.network.retrofit.exception.APIStatusErrorException;
import com.hbg.module.kline.R$string;
import com.hbg.module.kline.view.histogram.HistogramChartBean;
import com.huobi.view.barchart.BarChartBean;
import com.huobi.view.realline.RealLineBean;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import rx.Observable;
import u6.g;

public class MarketInfoCapitalFlowPresenter extends BaseFragmentPresenter<b> {

    /* renamed from: c  reason: collision with root package name */
    public List<FundSituationBean.FundSituationItem> f23614c;

    /* renamed from: d  reason: collision with root package name */
    public List<FundSituationBean.FundSituationItem> f23615d;

    /* renamed from: e  reason: collision with root package name */
    public FundSituationBean f23616e;

    /* renamed from: f  reason: collision with root package name */
    public Period f23617f;

    public class a extends EasySubscriber<Object> {
        public a() {
        }

        public void onAfter() {
            int size;
            super.onAfter();
            ((b) MarketInfoCapitalFlowPresenter.this.getUI()).r9();
            if (MarketInfoCapitalFlowPresenter.this.f23615d != null) {
                MarketInfoCapitalFlowPresenter marketInfoCapitalFlowPresenter = MarketInfoCapitalFlowPresenter.this;
                marketInfoCapitalFlowPresenter.j0(marketInfoCapitalFlowPresenter.f23615d);
            }
            if (MarketInfoCapitalFlowPresenter.this.f23616e != null) {
                if (MarketInfoCapitalFlowPresenter.this.f23617f == null) {
                    MarketInfoCapitalFlowPresenter.this.k0(Period.min15);
                } else {
                    MarketInfoCapitalFlowPresenter marketInfoCapitalFlowPresenter2 = MarketInfoCapitalFlowPresenter.this;
                    marketInfoCapitalFlowPresenter2.k0(marketInfoCapitalFlowPresenter2.f23617f);
                }
            }
            if (MarketInfoCapitalFlowPresenter.this.f23614c != null && (size = MarketInfoCapitalFlowPresenter.this.f23614c.size()) > 0) {
                RealLineBean[] realLineBeanArr = new RealLineBean[size];
                for (int i11 = 0; i11 < size; i11++) {
                    FundSituationBean.FundSituationItem fundSituationItem = (FundSituationBean.FundSituationItem) MarketInfoCapitalFlowPresenter.this.f23614c.get(i11);
                    RealLineBean realLineBean = new RealLineBean();
                    realLineBean.setId(fundSituationItem.getTs());
                    realLineBean.setAmount(fundSituationItem.getTotalInflow());
                    realLineBeanArr[i11] = realLineBean;
                }
                ((b) MarketInfoCapitalFlowPresenter.this.getUI()).O4(realLineBeanArr);
            }
        }

        public void onError2(Throwable th2) {
            super.onError2(th2);
            ((b) MarketInfoCapitalFlowPresenter.this.getUI()).m0();
        }

        public void onFailed(APIStatusErrorException aPIStatusErrorException) {
            super.onFailed(aPIStatusErrorException);
            ((b) MarketInfoCapitalFlowPresenter.this.getUI()).m0();
        }
    }

    public interface b extends g {
        void Mb(HistogramChartBean histogramChartBean);

        void O4(RealLineBean[] realLineBeanArr);

        void Sf(BarChartBean barChartBean);

        SymbolBean T4();

        String k1();

        void m0();

        void r9();

        void zg(FundSituationBean.FundSituationItem fundSituationItem);
    }

    public static String l0(long j11) {
        return new SimpleDateFormat("MM-dd").format(new Date(Long.parseLong(String.valueOf(j11 * 1000))));
    }

    /* access modifiers changed from: private */
    public /* synthetic */ Object m0(List list, List list2, FundSituationBean fundSituationBean) {
        this.f23614c = list;
        this.f23615d = list2;
        this.f23616e = fundSituationBean;
        return null;
    }

    public void R() {
        Class cls = ProApiService.class;
        Observable.zip(((ProApiService) ProRetrofit.request(cls)).getHistoryFundSituation(((b) getUI()).k1(), Period.min15.value, 96).compose(ProRetrofit.h()).compose(RxJavaHelper.t((g) getUI())), ((ProApiService) ProRetrofit.request(cls)).getHistoryFundSituation(((b) getUI()).k1(), Period.day.value, 5).compose(ProRetrofit.h()).compose(RxJavaHelper.t((g) getUI())), ((ProApiService) ProRetrofit.request(cls)).getLastFundSituation(((b) getUI()).k1()).compose(ProRetrofit.h()).compose(RxJavaHelper.t((g) getUI())), new e(this)).subscribe(new a());
    }

    public final void i0(FundSituationBean.FundSituationItem fundSituationItem) {
        BarChartBean barChartBean;
        if (fundSituationItem != null) {
            barChartBean = new BarChartBean();
            barChartBean.setTotalAmount(fundSituationItem.getSmallBuy() + fundSituationItem.getSmallSell() + fundSituationItem.getMiddleBuy() + fundSituationItem.getMiddleSell() + fundSituationItem.getBigBuy() + fundSituationItem.getBigSell());
            ArrayList arrayList = new ArrayList();
            BarChartBean.BarChartItem barChartItem = new BarChartBean.BarChartItem();
            barChartItem.setLabel(getActivity().getString(R$string.n_kline_money_flow_large_buy));
            barChartItem.setAmount(fundSituationItem.getBigBuy());
            arrayList.add(barChartItem);
            BarChartBean.BarChartItem barChartItem2 = new BarChartBean.BarChartItem();
            barChartItem2.setLabel(getActivity().getString(R$string.n_kline_money_flow_mid_buy));
            barChartItem2.setAmount(fundSituationItem.getMiddleBuy());
            arrayList.add(barChartItem2);
            BarChartBean.BarChartItem barChartItem3 = new BarChartBean.BarChartItem();
            barChartItem3.setLabel(getActivity().getString(R$string.n_kline_money_flow_small_buy));
            barChartItem3.setAmount(fundSituationItem.getSmallBuy());
            arrayList.add(barChartItem3);
            BarChartBean.BarChartItem barChartItem4 = new BarChartBean.BarChartItem();
            barChartItem4.setLabel(getActivity().getString(R$string.n_kline_money_flow_small_sell));
            barChartItem4.setAmount(fundSituationItem.getSmallSell());
            arrayList.add(barChartItem4);
            BarChartBean.BarChartItem barChartItem5 = new BarChartBean.BarChartItem();
            barChartItem5.setLabel(getActivity().getString(R$string.n_kline_money_flow_mid_sell));
            barChartItem5.setAmount(fundSituationItem.getMiddleSell());
            arrayList.add(barChartItem5);
            BarChartBean.BarChartItem barChartItem6 = new BarChartBean.BarChartItem();
            barChartItem6.setLabel(getActivity().getString(R$string.n_kline_money_flow_large_sell));
            barChartItem6.setAmount(fundSituationItem.getBigSell());
            arrayList.add(barChartItem6);
            barChartBean.setAmounts(arrayList);
        } else {
            barChartBean = null;
        }
        ((b) getUI()).Sf(barChartBean);
        ((b) getUI()).zg(fundSituationItem);
    }

    public final void j0(List<FundSituationBean.FundSituationItem> list) {
        ArrayList arrayList = new ArrayList();
        HistogramChartBean histogramChartBean = new HistogramChartBean();
        double d11 = 0.0d;
        for (int i11 = 0; i11 < list.size(); i11++) {
            FundSituationBean.FundSituationItem fundSituationItem = list.get((list.size() - i11) - 1);
            arrayList.add(new ge.a(String.valueOf(i11), (float) fundSituationItem.getTotalInflow(), l0(fundSituationItem.getTs())));
            d11 += fundSituationItem.getTotalInflow();
        }
        histogramChartBean.setDatas(arrayList);
        histogramChartBean.setTotalAmount(d11);
        SymbolBean T4 = ((b) getUI()).T4();
        if (T4 != null) {
            histogramChartBean.setCoinType(T4.getBaseCurrencyDisplayName());
        } else {
            histogramChartBean.setCoinType(getResources().getString(R$string.global_crossbar));
        }
        ((b) getUI()).Mb(histogramChartBean);
    }

    public void k0(Period period) {
        this.f23617f = period;
        FundSituationBean fundSituationBean = this.f23616e;
        if (fundSituationBean == null) {
            return;
        }
        if (period == Period.day) {
            i0(fundSituationBean.getOneDay());
        } else if (period == Period.hour4) {
            i0(fundSituationBean.getFourHour());
        } else if (period == Period.hour2) {
            i0(fundSituationBean.getTwoHour());
        } else if (period == Period.min60) {
            i0(fundSituationBean.getOneHour());
        } else if (period == Period.min30) {
            i0(fundSituationBean.getThirtyMin());
        } else if (period == Period.min15) {
            i0(fundSituationBean.getFifteenMin());
        }
    }

    /* renamed from: n0 */
    public void onUIReady(BaseCoreActivity baseCoreActivity, b bVar) {
        super.onUIReady(baseCoreActivity, bVar);
    }
}
