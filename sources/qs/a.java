package qs;

import com.hbg.lib.network.swap.core.bean.ProductInfo;
import com.huobi.swap.controller.SwapBalanceCurrencyConfigImp;
import java.util.List;
import rx.Observable;

public interface a {

    /* renamed from: a  reason: collision with root package name */
    public static final a f84586a = new SwapBalanceCurrencyConfigImp();

    List<ProductInfo> a();

    int b(String str, int i11);

    int c(String str, int i11);

    int d(String str, int i11);

    int e();

    Observable<List<ProductInfo>> f(boolean z11);
}
