package fe;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.PopupWindow;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.hbg.lib.widgets.adapter.recyclerview.EasyRecyclerView;
import com.hbg.module.kline.R$dimen;
import com.hbg.module.kline.R$id;
import com.hbg.module.kline.R$layout;
import com.hbg.module.kline.R$style;
import com.hbg.module.kline.draw.LineSizeEnum;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import java.util.ArrayList;
import java.util.List;

public class d extends PopupWindow implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public Context f25240b;

    /* renamed from: c  reason: collision with root package name */
    public EasyRecyclerView f25241c;

    /* renamed from: d  reason: collision with root package name */
    public List<yd.a> f25242d;

    /* renamed from: e  reason: collision with root package name */
    public a f25243e;

    public interface a {
        void a(yd.a aVar);
    }

    public d(Context context) {
        super(context);
        a(context);
    }

    public final void a(Context context) {
        this.f25240b = context;
        View inflate = LayoutInflater.from(context).inflate(R$layout.kline_draw_line_info_window_layout, (ViewGroup) null);
        this.f25241c = (EasyRecyclerView) inflate.findViewById(R$id.recyclerView);
        setContentView(inflate);
        setWidth(context.getResources().getDimensionPixelSize(R$dimen.dimen_52));
        setHeight(context.getResources().getDimensionPixelSize(R$dimen.dimen_100));
        setBackgroundDrawable(new ColorDrawable(0));
        setOutsideTouchable(true);
        setFocusable(true);
        b();
        setAnimationStyle(R$style.klineDrawEditSelectionWindowAnimation);
        this.f25241c.setLayoutManager(new LinearLayoutManager(this.f25240b, 1, false));
        this.f25241c.setData(this.f25242d);
    }

    public final void b() {
        ArrayList arrayList = new ArrayList();
        this.f25242d = arrayList;
        arrayList.add(new yd.a(LineSizeEnum.LINE_SIZE_1, false, this));
        this.f25242d.add(new yd.a(LineSizeEnum.LINE_SIZE_2, false, this));
        this.f25242d.add(new yd.a(LineSizeEnum.LINE_SIZE_3, false, this));
        this.f25242d.add(new yd.a(LineSizeEnum.LINE_SIZE_4, false, this));
    }

    public void c(LineSizeEnum lineSizeEnum) {
        for (yd.a next : this.f25242d) {
            next.f(next.d() == lineSizeEnum);
        }
        this.f25241c.getAdapter().notifyDataSetChanged();
    }

    public void d(a aVar) {
        this.f25243e = aVar;
    }

    @SensorsDataInstrumented
    public void onClick(View view) {
        a aVar = this.f25243e;
        if (aVar != null) {
            aVar.a((yd.a) view.getTag());
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }
}
