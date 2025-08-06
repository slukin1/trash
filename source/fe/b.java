package fe;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.PopupWindow;
import androidx.recyclerview.widget.GridLayoutManager;
import com.hbg.lib.common.utils.PixelUtils;
import com.hbg.lib.widgets.adapter.recyclerview.EasyRecyclerView;
import com.hbg.module.kline.R$dimen;
import com.hbg.module.kline.R$id;
import com.hbg.module.kline.R$layout;
import com.hbg.module.kline.R$style;
import com.hbg.module.kline.draw.LineColorEnum;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import java.util.ArrayList;
import java.util.List;
import yd.c;

public class b extends PopupWindow implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public Context f25233b;

    /* renamed from: c  reason: collision with root package name */
    public EasyRecyclerView f25234c;

    /* renamed from: d  reason: collision with root package name */
    public List<c> f25235d;

    /* renamed from: e  reason: collision with root package name */
    public a f25236e;

    public interface a {
        void a(c cVar);
    }

    public b(Context context) {
        super(context);
        a(context);
    }

    public final void a(Context context) {
        this.f25233b = context;
        View inflate = LayoutInflater.from(context).inflate(R$layout.kline_draw_line_palette_window_layout, (ViewGroup) null);
        this.f25234c = (EasyRecyclerView) inflate.findViewById(R$id.paletteRecyclerView);
        setContentView(inflate);
        setWidth(context.getResources().getDimensionPixelSize(R$dimen.dimen_125));
        setHeight(context.getResources().getDimensionPixelSize(R$dimen.dimen_72));
        setBackgroundDrawable(new ColorDrawable(0));
        setOutsideTouchable(true);
        setFocusable(true);
        b();
        setAnimationStyle(R$style.klineDrawEditSelectionWindowAnimation);
        this.f25234c.setLayoutManager(new GridLayoutManager(this.f25233b, 4));
        this.f25234c.addItemDecoration(new ea.a(this.f25233b, PixelUtils.a(4.0f)));
        this.f25234c.setData(this.f25235d);
    }

    public final void b() {
        ArrayList arrayList = new ArrayList();
        this.f25235d = arrayList;
        arrayList.add(new c(LineColorEnum.LINE_COLOR_1, false, this));
        this.f25235d.add(new c(LineColorEnum.LINE_COLOR_2, false, this));
        this.f25235d.add(new c(LineColorEnum.LINE_COLOR_3, false, this));
        this.f25235d.add(new c(LineColorEnum.LINE_COLOR_4, false, this));
        this.f25235d.add(new c(LineColorEnum.LINE_COLOR_5, false, this));
        this.f25235d.add(new c(LineColorEnum.LINE_COLOR_6, false, this));
        this.f25235d.add(new c(LineColorEnum.LINE_COLOR_7, false, this));
        this.f25235d.add(new c(LineColorEnum.LINE_COLOR_8, false, this));
    }

    public void c(LineColorEnum lineColorEnum) {
        for (c next : this.f25235d) {
            next.f(next.c() == lineColorEnum);
        }
        this.f25234c.getAdapter().notifyDataSetChanged();
    }

    public void d(a aVar) {
        this.f25236e = aVar;
    }

    @SensorsDataInstrumented
    public void onClick(View view) {
        a aVar = this.f25236e;
        if (aVar != null) {
            aVar.a((c) view.getTag());
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }
}
