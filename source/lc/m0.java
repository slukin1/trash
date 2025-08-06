package lc;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.databinding.c;
import androidx.databinding.f;
import androidx.recyclerview.widget.RecyclerView;
import com.hbg.lib.widgets.LoadingLayout;
import com.hbg.module.content.R$layout;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;

public abstract class m0 extends f {
    public final EditText B;
    public final ImageView C;
    public final LoadingLayout D;
    public final LinearLayout E;
    public final RecyclerView F;
    public final SmartRefreshLayout G;
    public final TextView H;
    public final View I;

    public m0(Object obj, View view, int i11, EditText editText, ImageView imageView, LoadingLayout loadingLayout, LinearLayout linearLayout, RecyclerView recyclerView, SmartRefreshLayout smartRefreshLayout, TextView textView, View view2) {
        super(obj, view, i11);
        this.B = editText;
        this.C = imageView;
        this.D = loadingLayout;
        this.E = linearLayout;
        this.F = recyclerView;
        this.G = smartRefreshLayout;
        this.H = textView;
        this.I = view2;
    }

    public static m0 K(LayoutInflater layoutInflater) {
        return L(layoutInflater, c.d());
    }

    @Deprecated
    public static m0 L(LayoutInflater layoutInflater, Object obj) {
        return (m0) f.s(layoutInflater, R$layout.dialog_live_trader, (ViewGroup) null, false, obj);
    }
}
