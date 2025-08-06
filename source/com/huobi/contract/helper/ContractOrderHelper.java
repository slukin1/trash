package com.huobi.contract.helper;

import a7.e;
import android.content.Context;
import android.text.TextUtils;
import bj.c0;
import com.hbg.lib.contract.R$string;
import com.hbg.lib.core.util.w;
import com.hbg.lib.data.future.util.FuturePrecisionUtil;
import com.hbg.lib.data.symbol.TradeType;
import com.hbg.lib.network.contract.core.bean.ContractCurrencyInfo;
import com.hbg.lib.network.contract.core.response.ContractStatusResponse;
import com.hbg.lib.network.contract.retrofit.ContractRetrofit;
import com.hbg.module.contract.service.ContractService;
import com.huobi.contract.entity.ContractCancelResult;
import com.huobi.contract.entity.ContractCurrentOrderResult;
import com.huobi.contract.entity.ContractCurrentTriggerOrderResult;
import com.huobi.contract.entity.ContractOrderDetailResult;
import com.huobi.contract.entity.ContractOrderRspInfo;
import com.huobi.contract.entity.ContractPosition;
import com.huobi.contract.entity.ContractTriggerProtectInfo;
import com.huobi.currencyconfig.util.LegalCurrencyConfigUtil;
import com.huobi.finance.bean.AssetPositionContractData;
import com.sensorsdata.analytics.android.sdk.data.adapter.DbParams;
import com.xiaomi.mipush.sdk.Constants;
import ej.f;
import ej.g;
import i6.d;
import i6.m;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import rx.Observable;
import rx.functions.Func1;
import us.i;

public class ContractOrderHelper {
    public static Observable<ContractCancelResult> b(String str, String str2, int i11) {
        Observable<ContractStatusResponse<ContractCancelResult>> observable;
        HashMap hashMap = new HashMap();
        hashMap.put("order_id", str2);
        hashMap.put("symbol", str);
        ContractService contractService = (ContractService) ContractRetrofit.request(ContractService.class);
        if (i11 == 1) {
            observable = contractService.contractTriggerCancel(hashMap);
        } else {
            observable = contractService.contractCancel(hashMap);
        }
        return observable.compose(ContractRetrofit.h());
    }

    public static Observable<ContractOrderDetailResult> c(String str, int i11, long j11, long j12) {
        HashMap hashMap = new HashMap();
        hashMap.put("symbol", str);
        hashMap.put("order_type", Integer.valueOf(i11));
        hashMap.put("order_id", Long.valueOf(j11));
        hashMap.put(DbParams.KEY_CREATED_AT, Long.valueOf(j12));
        return ((ContractService) ContractRetrofit.request(ContractService.class)).contractOrderInfo(hashMap).compose(ContractRetrofit.h());
    }

    public static Func1<ContractPosition, AssetPositionContractData> d(Context context) {
        return new c0(context);
    }

    public static String e(String str, String str2, String str3) {
        return f(str, str2, str3, TradeType.CONTRACT);
    }

    public static String f(String str, String str2, String str3, TradeType tradeType) {
        String str4;
        BigDecimal bigDecimal;
        if (e.E(tradeType)) {
            BigDecimal multiply = m.a(str).multiply(m.a(str3));
            BigDecimal a11 = m.a(str2);
            if (a11.compareTo(BigDecimal.ZERO) == 0) {
                bigDecimal = BigDecimal.ZERO;
            } else {
                bigDecimal = multiply.divide(a11, 32, 1);
            }
            str4 = bigDecimal.toPlainString();
        } else {
            str4 = str;
        }
        d.b("ContractOrderHelper-->getCoinVolume--> volume:" + str + " price:" + str2 + " face:" + str3 + " result:" + str4);
        return str4;
    }

    public static Observable<List<ContractPosition>> g(Map<String, Object> map) {
        return ((ContractService) ContractRetrofit.request(ContractService.class)).getContractPosition(map).compose(ContractRetrofit.h());
    }

    public static Observable<ContractCurrentOrderResult> h(String str, int i11, int i12) {
        HashMap hashMap = new HashMap();
        if (!TextUtils.isEmpty(str)) {
            hashMap.put("symbol", str);
        }
        if (i11 != 0) {
            hashMap.put("page_index", Integer.valueOf(i11));
        }
        hashMap.put("page_size", Integer.valueOf(i12));
        return ((ContractService) ContractRetrofit.request(ContractService.class)).getCurrentOrder(hashMap).compose(ContractRetrofit.h());
    }

    public static Observable<ContractCurrentTriggerOrderResult> i(String str, String str2, int i11, int i12) {
        HashMap hashMap = new HashMap();
        if (!TextUtils.isEmpty(str)) {
            hashMap.put("symbol", str);
        }
        if (i11 != 0) {
            hashMap.put("page_index", Integer.valueOf(i11));
        }
        hashMap.put("page_size", Integer.valueOf(i12));
        if (!TextUtils.isEmpty(str2)) {
            hashMap.put("contract_code", str2);
        }
        return ((ContractService) ContractRetrofit.request(ContractService.class)).getCurrentTriggerOrder(hashMap).compose(ContractRetrofit.h());
    }

    public static /* synthetic */ AssetPositionContractData j(Context context, ContractPosition contractPosition) {
        String str;
        ContractCurrencyInfo h11 = ContractCurrencyUtils.h(contractPosition.getContractCode());
        contractPosition.setContractCurrencyInfo(h11);
        AssetPositionContractData assetPositionContractData = new AssetPositionContractData();
        TradeType tradeType = TradeType.CONTRACT;
        assetPositionContractData.d0(tradeType);
        assetPositionContractData.a0(contractPosition.getSymbol());
        assetPositionContractData.b0(contractPosition.getSymbol() + "/USD");
        assetPositionContractData.P(contractPosition.getDirection());
        assetPositionContractData.N(false);
        String c11 = g.c(h11.getContractShortType());
        String contractCode = contractPosition.getContractCode();
        String str2 = "";
        assetPositionContractData.T(contractPosition.getLeverRate() + "X·" + c11 + ((TextUtils.isEmpty(contractCode) || contractCode.length() <= 4) ? str2 : contractCode.substring(contractCode.length() - 4)));
        assetPositionContractData.R(contractPosition.getLeverRate());
        assetPositionContractData.Y("--");
        if (!TextUtils.isEmpty(contractPosition.getRiskRate())) {
            assetPositionContractData.Y(m.Q(contractPosition.getRiskRate(), FuturePrecisionUtil.r(contractPosition.getSymbol()), 1));
        }
        if (!TextUtils.isEmpty(contractPosition.getPositionMargin())) {
            assetPositionContractData.U(m.q(m.a(LegalCurrencyConfigUtil.E(contractPosition.getSymbol(), contractPosition.getPositionMargin())), i.c(contractPosition.getSymbol())));
        } else {
            assetPositionContractData.U("--");
        }
        boolean E = e.E(tradeType);
        if (!E) {
            assetPositionContractData.H(m.m(contractPosition.getVolume(), f.g(contractPosition.getSymbol())));
            assetPositionContractData.J(m.m(contractPosition.getAvailable(), f.g(contractPosition.getSymbol())));
        } else if (m.a(contractPosition.getLastPrice()).compareTo(BigDecimal.ZERO) == 0) {
            assetPositionContractData.H(m.m("0", f.n(contractPosition.getContractCode())));
        } else {
            if (contractPosition.getContractCurrencyInfo() != null) {
                str2 = contractPosition.getContractCurrencyInfo().getContractFace();
            }
            BigDecimal divide = m.a(contractPosition.getVolume()).multiply(m.a(str2)).divide(m.a(contractPosition.getLastPrice()), 32, 1);
            BigDecimal divide2 = m.a(contractPosition.getAvailable()).multiply(m.a(str2)).divide(m.a(contractPosition.getLastPrice()), 32, 1);
            assetPositionContractData.H(m.q(divide, f.n(contractPosition.getContractCode())));
            assetPositionContractData.J(m.q(divide2, f.n(contractPosition.getContractCode())));
        }
        if (E) {
            str = contractPosition.getSymbol();
        } else {
            str = context.getString(R$string.contract_market_vol_sheet);
        }
        assetPositionContractData.I(str);
        assetPositionContractData.K(E);
        if (contractPosition.getContractCurrencyInfo() != null) {
            assetPositionContractData.M(m.a(contractPosition.getContractCurrencyInfo().getContractFace()).divide(m.a(contractPosition.getLastPrice()), 12, 1).toPlainString());
        }
        assetPositionContractData.Z(m.m(contractPosition.getCostOpen(), f.p(contractPosition.getContractCode())));
        assetPositionContractData.Q(m.m(contractPosition.getLastPrice(), f.p(contractPosition.getContractCode())));
        assetPositionContractData.V(LegalCurrencyConfigUtil.E(contractPosition.getSymbol(), contractPosition.getProfit()));
        String Q = m.Q(contractPosition.getProfitRate(), f.i(contractPosition.getSymbol()), 1);
        if (!Q.startsWith(Constants.ACCEPT_TIME_SEPARATOR_SERVER)) {
            Q = "+" + Q;
        }
        assetPositionContractData.X(Q);
        assetPositionContractData.O(contractPosition.getProfitRate());
        assetPositionContractData.L(contractPosition.getContractCode());
        assetPositionContractData.W(w.a(contractPosition.getProfit()));
        return assetPositionContractData;
    }

    public static Observable<List<ContractOrderRspInfo>> k(String str, long j11) {
        HashMap hashMap = new HashMap();
        hashMap.put("symbol", str);
        hashMap.put("order_id", Long.valueOf(j11));
        return ((ContractService) ContractRetrofit.request(ContractService.class)).requestContractOrderInfo(hashMap).compose(ContractRetrofit.h());
    }

    public static Observable<ContractTriggerProtectInfo> l(String str) {
        return ((ContractService) ContractRetrofit.request(ContractService.class)).triggerProtect(str).compose(ContractRetrofit.h());
    }
}
