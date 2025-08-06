package wk;

import com.huobi.finance.bean.SuperMarginDetailInfo;
import com.huobi.finance.model.AssetDataCacheManager;
import java.util.Comparator;

public final /* synthetic */ class a implements Comparator {

    /* renamed from: b  reason: collision with root package name */
    public static final /* synthetic */ a f61375b = new a();

    public final int compare(Object obj, Object obj2) {
        return AssetDataCacheManager.y1((SuperMarginDetailInfo) obj, (SuperMarginDetailInfo) obj2);
    }
}
