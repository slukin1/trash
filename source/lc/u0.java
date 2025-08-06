package lc;

import android.view.View;
import android.widget.TextView;
import androidx.databinding.f;
import com.hbg.module.content.ui.activity.live.LiveDetailActivity;

public abstract class u0 extends f {
    public final TextView B;
    public final TextView C;
    public final View D;
    public LiveDetailActivity E;

    public u0(Object obj, View view, int i11, TextView textView, TextView textView2, View view2) {
        super(obj, view, i11);
        this.B = textView;
        this.C = textView2;
        this.D = view2;
    }

    public abstract void K(LiveDetailActivity liveDetailActivity);
}
