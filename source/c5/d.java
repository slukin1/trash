package c5;

import android.graphics.DashPathEffect;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.utils.Utils;
import g5.h;
import java.util.List;

public abstract class d<T extends Entry> extends b<T> implements h<T> {

    /* renamed from: w  reason: collision with root package name */
    public boolean f63175w;

    /* renamed from: x  reason: collision with root package name */
    public boolean f63176x;

    /* renamed from: y  reason: collision with root package name */
    public float f63177y;

    /* renamed from: z  reason: collision with root package name */
    public DashPathEffect f63178z;

    public d(List<T> list, String str) {
        super(list, str);
        this.f63175w = true;
        this.f63176x = true;
        this.f63177y = 0.5f;
        this.f63178z = null;
        this.f63177y = Utils.e(0.5f);
    }

    public float Q() {
        return this.f63177y;
    }

    public DashPathEffect X() {
        return this.f63178z;
    }

    public boolean a0() {
        return this.f63176x;
    }

    public boolean k() {
        return this.f63175w;
    }

    public void n0(boolean z11) {
        this.f63176x = z11;
    }
}
