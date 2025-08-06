package fe;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import com.hbg.module.kline.R$dimen;
import com.hbg.module.kline.R$id;
import com.hbg.module.kline.R$layout;
import com.hbg.module.kline.R$style;
import com.hbg.module.kline.draw.LineTypeEnum;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import java.util.List;

public class c extends PopupWindow implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public LinearLayout f25237b;

    /* renamed from: c  reason: collision with root package name */
    public Context f25238c;

    /* renamed from: d  reason: collision with root package name */
    public a f25239d;

    public interface a {
        void rb(LineTypeEnum lineTypeEnum);
    }

    public c(Context context, List<LineTypeEnum> list) {
        super(context);
        b(context, list);
    }

    public final void a(List<LineTypeEnum> list) {
        if (list != null && list.size() > 0) {
            for (LineTypeEnum next : list) {
                View inflate = LayoutInflater.from(this.f25237b.getContext()).inflate(R$layout.kline_draw_line_selection_item, (ViewGroup) null, false);
                ((ImageView) inflate.findViewById(R$id.icon)).setImageResource(LineTypeEnum.getIconResourceId(this.f25238c, next));
                ((TextView) inflate.findViewById(R$id.name)).setText(this.f25238c.getResources().getString(next.getNameId()));
                inflate.setTag(next);
                inflate.setOnClickListener(this);
                this.f25237b.addView(inflate);
            }
        }
    }

    public final void b(Context context, List<LineTypeEnum> list) {
        this.f25238c = context;
        View inflate = LayoutInflater.from(context).inflate(R$layout.kline_draw_line_selecion_window_layout, (ViewGroup) null);
        this.f25237b = (LinearLayout) inflate.findViewById(R$id.contentLayout);
        a(list);
        setContentView(inflate);
        setWidth(context.getResources().getDimensionPixelSize(R$dimen.dimen_135));
        setHeight(-2);
        setBackgroundDrawable(new ColorDrawable(0));
        setOutsideTouchable(true);
        setFocusable(true);
        setClippingEnabled(false);
        getContentView().setSystemUiVisibility(4);
        setAnimationStyle(R$style.klineDrawLineTypeWindowAnimation);
    }

    public void c(a aVar) {
        this.f25239d = aVar;
    }

    public void d(LineTypeEnum lineTypeEnum) {
        int childCount = this.f25237b.getChildCount();
        for (int i11 = 0; i11 < childCount; i11++) {
            View childAt = this.f25237b.getChildAt(i11);
            Object tag = childAt.getTag();
            if (lineTypeEnum == null || tag == null || !(tag instanceof LineTypeEnum)) {
                childAt.setSelected(false);
            } else {
                childAt.setSelected(((LineTypeEnum) tag).getType() == lineTypeEnum.getType());
            }
        }
    }

    @SensorsDataInstrumented
    public void onClick(View view) {
        a aVar = this.f25239d;
        if (aVar != null) {
            aVar.rb((LineTypeEnum) view.getTag());
        }
        dismiss();
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }
}
