package i5;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.drawable.Drawable;
import com.amazonaws.services.s3.model.InstructionFileId;
import com.github.mikephil.charting.animation.ChartAnimator;
import com.github.mikephil.charting.utils.Utils;
import com.github.mikephil.charting.utils.ViewPortHandler;

public abstract class k extends l {
    public k(ChartAnimator chartAnimator, ViewPortHandler viewPortHandler) {
        super(chartAnimator, viewPortHandler);
    }

    public final boolean l() {
        return Utils.s() >= 18;
    }

    public void m(Canvas canvas, Path path, int i11, int i12) {
        int i13 = (i11 & FlexItem.MAX_SIZE) | (i12 << 24);
        if (l()) {
            int save = canvas.save();
            canvas.clipPath(path);
            canvas.drawColor(i13);
            canvas.restoreToCount(save);
            return;
        }
        Paint.Style style = this.f66317c.getStyle();
        int color = this.f66317c.getColor();
        this.f66317c.setStyle(Paint.Style.FILL);
        this.f66317c.setColor(i13);
        canvas.drawPath(path, this.f66317c);
        this.f66317c.setColor(color);
        this.f66317c.setStyle(style);
    }

    public void n(Canvas canvas, Path path, Drawable drawable) {
        if (l()) {
            int save = canvas.save();
            canvas.clipPath(path);
            drawable.setBounds((int) this.f66370a.h(), (int) this.f66370a.j(), (int) this.f66370a.i(), (int) this.f66370a.f());
            drawable.draw(canvas);
            canvas.restoreToCount(save);
            return;
        }
        throw new RuntimeException("Fill-drawables not (yet) supported below API level 18, this code was run on API level " + Utils.s() + InstructionFileId.DOT);
    }
}
