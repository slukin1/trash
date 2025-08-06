package k5;

import com.github.mikephil.charting.utils.ViewPortHandler;

public class b extends a {
    public b(ViewPortHandler viewPortHandler) {
        super(viewPortHandler);
    }

    public void l(boolean z11) {
        this.f66458b.reset();
        if (!z11) {
            this.f66458b.postTranslate(this.f66459c.G(), this.f66459c.l() - this.f66459c.F());
            return;
        }
        this.f66458b.setTranslate(-(this.f66459c.m() - this.f66459c.H()), this.f66459c.l() - this.f66459c.F());
        this.f66458b.postScale(-1.0f, 1.0f);
    }
}
