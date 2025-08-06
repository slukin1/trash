package c5;

import android.annotation.TargetApi;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.utils.Utils;
import g5.g;
import java.util.List;

public abstract class c<T extends Entry> extends d<T> implements g<T> {
    public int A = Color.rgb(140, 234, 255);
    public Drawable B;
    public int C = 85;
    public float D = 2.5f;
    public boolean E = false;

    public c(List<T> list, String str) {
        super(list, str);
    }

    public int A() {
        return this.C;
    }

    public float C() {
        return this.D;
    }

    public boolean U() {
        return this.E;
    }

    public Drawable e() {
        return this.B;
    }

    public int n() {
        return this.A;
    }

    public void o0(boolean z11) {
        this.E = z11;
    }

    @TargetApi(18)
    public void p0(Drawable drawable) {
        this.B = drawable;
    }

    public void q0(float f11) {
        if (f11 < 0.0f) {
            f11 = 0.0f;
        }
        if (f11 > 10.0f) {
            f11 = 10.0f;
        }
        this.D = Utils.e(f11);
    }
}
