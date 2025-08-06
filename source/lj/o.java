package lj;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.databinding.c;
import androidx.databinding.f;
import com.huobi.edgeengine.ui.EdgeEnginePageActivity;
import pro.huobi.R;

public abstract class o extends f {
    public final LinearLayout B;
    public final LinearLayout C;
    public final TextView D;
    public final View E;
    public EdgeEnginePageActivity F;

    public o(Object obj, View view, int i11, LinearLayout linearLayout, LinearLayout linearLayout2, TextView textView, View view2) {
        super(obj, view, i11);
        this.B = linearLayout;
        this.C = linearLayout2;
        this.D = textView;
        this.E = view2;
    }

    public static o K(LayoutInflater layoutInflater) {
        return L(layoutInflater, c.d());
    }

    @Deprecated
    public static o L(LayoutInflater layoutInflater, Object obj) {
        return (o) f.s(layoutInflater, R.layout.activity_edge_engine_page, (ViewGroup) null, false, obj);
    }

    public abstract void M(EdgeEnginePageActivity edgeEnginePageActivity);
}
