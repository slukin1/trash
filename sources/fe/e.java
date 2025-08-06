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
import com.hbg.module.kline.draw.LineStyleEnum;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import java.util.ArrayList;
import java.util.List;
import yd.b;

public class e extends PopupWindow implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public Context f25244b;

    /* renamed from: c  reason: collision with root package name */
    public EasyRecyclerView f25245c;

    /* renamed from: d  reason: collision with root package name */
    public List<b> f25246d;

    /* renamed from: e  reason: collision with root package name */
    public a f25247e;

    public interface a {
        void a(b bVar);
    }

    public e(Context context) {
        super(context);
        a(context);
    }

    public final void a(Context context) {
        this.f25244b = context;
        View inflate = LayoutInflater.from(context).inflate(R$layout.kline_draw_line_info_window_layout, (ViewGroup) null);
        this.f25245c = (EasyRecyclerView) inflate.findViewById(R$id.recyclerView);
        setContentView(inflate);
        setWidth(context.getResources().getDimensionPixelSize(R$dimen.dimen_52));
        setHeight(context.getResources().getDimensionPixelSize(R$dimen.dimen_72));
        setBackgroundDrawable(new ColorDrawable(0));
        setOutsideTouchable(true);
        setFocusable(true);
        b();
        setAnimationStyle(R$style.klineDrawEditSelectionWindowAnimation);
        this.f25245c.setLayoutManager(new LinearLayoutManager(this.f25244b, 1, false));
        this.f25245c.setData(this.f25246d);
    }

    public final void b() {
        ArrayList arrayList = new ArrayList();
        this.f25246d = arrayList;
        arrayList.add(new b(LineStyleEnum.DOT_LINE_BIG, false, this));
        this.f25246d.add(new b(LineStyleEnum.DOT_LINE, false, this));
        this.f25246d.add(new b(LineStyleEnum.SOLID_LINE, false, this));
    }

    public void c(LineStyleEnum lineStyleEnum) {
        for (b next : this.f25246d) {
            next.f(next.d() == lineStyleEnum);
        }
        this.f25245c.getAdapter().notifyDataSetChanged();
    }

    public void d(a aVar) {
        this.f25247e = aVar;
    }

    @SensorsDataInstrumented
    public void onClick(View view) {
        a aVar = this.f25247e;
        if (aVar != null) {
            aVar.a((b) view.getTag());
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }
}
