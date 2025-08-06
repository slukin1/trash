package sk;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.huobi.finance.bean.BaseAssetTotal;

public interface a<T extends BaseAssetTotal> {
    void a();

    void b(T t11);

    int c();

    View d(Context context, ViewGroup viewGroup, View.OnClickListener onClickListener);
}
