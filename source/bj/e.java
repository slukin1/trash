package bj;

import com.hbg.lib.network.contract.core.bean.ContractCurrencyInfo;
import com.huobi.contract.entity.ContractCoinInfo;
import com.huobi.contract.entity.ContractLightLimitLevel;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import rx.Observable;

public interface e {
    int b(String str, int i11);

    int c(String str, int i11);

    int d(String str, int i11);

    ContractCurrencyInfo e(String str);

    ContractCurrencyInfo f();

    List<ContractCurrencyInfo> g();

    Observable<List<ContractCurrencyInfo>> h(boolean z11);

    Observable<List<ContractCoinInfo>> i(boolean z11, String str);

    List<ContractCoinInfo> j();

    LinkedHashSet<String> k();

    List<ContractCoinInfo> l();

    Observable<Map<String, ContractLightLimitLevel>> m(boolean z11);

    int n(String str, int i11);

    Observable<List<ContractCurrencyInfo>> o(boolean z11);

    List<ContractCurrencyInfo> p();

    int q(String str, int i11);
}
