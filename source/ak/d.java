package ak;

import android.content.Context;
import android.graphics.drawable.ShapeDrawable;
import com.huobi.edgeengine.template.widget.Widget;
import com.huobi.edgeengine.template.widget.list.RecyclerViewWidget;

public final /* synthetic */ class d implements Widget.u {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ShapeDrawable f3547a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Context f3548b;

    public /* synthetic */ d(ShapeDrawable shapeDrawable, Context context) {
        this.f3547a = shapeDrawable;
        this.f3548b = context;
    }

    public final void a(String str) {
        RecyclerViewWidget.j0(this.f3547a, this.f3548b, str);
    }
}
