package bl;

import android.view.View;
import com.huobi.finance.viewhandler.PieChartItemViewAdapter;
import com.huobi.view.chart.data.PieEntry;

public final /* synthetic */ class z2 implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ PieEntry f12809b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ int f12810c;

    public /* synthetic */ z2(PieEntry pieEntry, int i11) {
        this.f12809b = pieEntry;
        this.f12810c = i11;
    }

    public final void onClick(View view) {
        PieChartItemViewAdapter.d(this.f12809b, this.f12810c, view);
    }
}
