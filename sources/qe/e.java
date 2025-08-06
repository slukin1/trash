package qe;

import android.graphics.Canvas;
import com.hbg.module.libkt.custom.indicator.view.option.IndicatorOptions;
import qe.a;

public final class e implements f {

    /* renamed from: a  reason: collision with root package name */
    public f f25613a;

    public e(IndicatorOptions indicatorOptions) {
        b(indicatorOptions);
    }

    public void a(Canvas canvas) {
        f fVar = this.f25613a;
        if (fVar == null) {
            fVar = null;
        }
        fVar.a(canvas);
    }

    public final void b(IndicatorOptions indicatorOptions) {
        this.f25613a = d.f25612a.a(indicatorOptions);
    }

    public void c(boolean z11, int i11, int i12, int i13, int i14) {
    }

    public a.b d(int i11, int i12) {
        f fVar = this.f25613a;
        if (fVar == null) {
            fVar = null;
        }
        return fVar.d(i11, i12);
    }

    public final void e(IndicatorOptions indicatorOptions) {
        b(indicatorOptions);
    }
}
