package lc;

import android.view.View;
import android.widget.TextView;
import androidx.databinding.f;
import androidx.recyclerview.widget.RecyclerView;

public abstract class g5 extends f {
    public final RecyclerView B;
    public final TextView C;

    public g5(Object obj, View view, int i11, RecyclerView recyclerView, TextView textView) {
        super(obj, view, i11);
        this.B = recyclerView;
        this.C = textView;
    }
}
