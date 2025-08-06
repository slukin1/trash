package pf;

import android.view.View;
import android.widget.TextView;
import com.hbg.module.market.widget.viewhandler.MarketHotSearchItemHandler;

public final /* synthetic */ class a implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ TextView f53019b;

    public /* synthetic */ a(TextView textView) {
        this.f53019b = textView;
    }

    public final void onClick(View view) {
        MarketHotSearchItemHandler.d(this.f53019b, view);
    }
}
