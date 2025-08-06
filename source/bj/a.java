package bj;

import com.huobi.contract.entity.ContractAccountInfo;
import com.huobi.contract.entity.ContractHeartBeat;
import com.huobi.contract.entity.ContractPriceInfo;
import java.util.List;
import java.util.Map;
import rx.Observable;

public interface a {
    Observable<ContractHeartBeat> a();

    void b();

    ContractHeartBeat c();

    Observable<List<ContractAccountInfo>> d(Map<String, Object> map);

    Observable<List<ContractAccountInfo>> k(boolean z11);

    Observable<List<ContractPriceInfo>> l(boolean z11);
}
