package lj;

import android.view.View;
import android.widget.TextView;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.databinding.f;
import androidx.recyclerview.widget.RecyclerView;

public abstract class g0 extends f {
    public final LinearLayoutCompat B;
    public final RecyclerView C;
    public final TextView D;

    public g0(Object obj, View view, int i11, LinearLayoutCompat linearLayoutCompat, RecyclerView recyclerView, TextView textView) {
        super(obj, view, i11);
        this.B = linearLayoutCompat;
        this.C = recyclerView;
        this.D = textView;
    }
}
