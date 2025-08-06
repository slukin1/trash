package jumio.core;

import android.content.Context;
import android.graphics.Canvas;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

public final class c1 extends RelativeLayout {

    /* renamed from: a  reason: collision with root package name */
    public a f56150a;

    public interface a {
        void addChildren(ViewGroup viewGroup);

        int getPreferredBrandTextColor();

        void onDrawViewDraw(Canvas canvas);

        void onDrawViewMeasure(int i11, int i12);
    }

    public c1(Context context) {
        super(context);
        setWillNotDraw(false);
    }

    public final void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        a aVar = this.f56150a;
        if (aVar != null) {
            aVar.onDrawViewDraw(canvas);
        }
    }

    public final void onMeasure(int i11, int i12) {
        a aVar;
        super.onMeasure(i11, i12);
        int measuredWidth = getMeasuredWidth();
        int measuredHeight = getMeasuredHeight();
        if (measuredWidth != 0 && measuredHeight != 0 && (aVar = this.f56150a) != null) {
            aVar.onDrawViewMeasure(measuredWidth, measuredHeight);
        }
    }

    public final void setDrawViewInterface(a aVar) {
        this.f56150a = aVar;
        if (aVar != null) {
            aVar.addChildren(this);
        }
    }
}
