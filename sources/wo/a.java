package wo;

import android.view.View;
import android.widget.TextView;
import com.huobi.order.bean.OrderFilterQuoteItem;
import com.huobi.order.handler.OrderFilterQuoteHandler;

public final /* synthetic */ class a implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ int f61493b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ OrderFilterQuoteItem f61494c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ TextView f61495d;

    public /* synthetic */ a(int i11, OrderFilterQuoteItem orderFilterQuoteItem, TextView textView) {
        this.f61493b = i11;
        this.f61494c = orderFilterQuoteItem;
        this.f61495d = textView;
    }

    public final void onClick(View view) {
        OrderFilterQuoteHandler.d(this.f61493b, this.f61494c, this.f61495d, view);
    }
}
