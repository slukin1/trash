package c5;

import android.graphics.Color;
import com.github.mikephil.charting.data.DataSet;
import com.github.mikephil.charting.data.Entry;
import java.util.List;

public abstract class b<T extends Entry> extends DataSet<T> implements g5.b<T> {

    /* renamed from: v  reason: collision with root package name */
    public int f63174v = Color.rgb(255, 187, 115);

    public b(List<T> list, String str) {
        super(list, str);
    }

    public int getHighLightColor() {
        return this.f63174v;
    }
}
