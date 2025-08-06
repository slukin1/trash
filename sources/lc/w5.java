package lc;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.databinding.f;
import androidx.recyclerview.widget.RecyclerView;

public abstract class w5 extends f {
    public final LinearLayout B;
    public final RecyclerView C;
    public final TextView D;

    public w5(Object obj, View view, int i11, LinearLayout linearLayout, RecyclerView recyclerView, TextView textView) {
        super(obj, view, i11);
        this.B = linearLayout;
        this.C = recyclerView;
        this.D = textView;
    }
}
