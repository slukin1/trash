package pc;

import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import com.hbg.module.content.ui.activity.live.edgeengine.CornerView;
import com.huobi.edgeengine.template.widget.Widget;

public final /* synthetic */ class a implements Widget.u {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ GradientDrawable f53011a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Context f53012b;

    public /* synthetic */ a(GradientDrawable gradientDrawable, Context context) {
        this.f53011a = gradientDrawable;
        this.f53012b = context;
    }

    public final void a(String str) {
        CornerView.j0(this.f53011a, this.f53012b, str);
    }
}
