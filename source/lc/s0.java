package lc;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.databinding.c;
import androidx.databinding.f;
import androidx.recyclerview.widget.RecyclerView;
import com.hbg.lib.widgets.LoadingLayout;
import com.hbg.module.content.R$layout;

public abstract class s0 extends f {
    public final EditText B;
    public final ImageView C;
    public final ImageView D;
    public final LoadingLayout E;
    public final RecyclerView F;
    public final TextView G;
    public final View H;

    public s0(Object obj, View view, int i11, EditText editText, ImageView imageView, ImageView imageView2, LoadingLayout loadingLayout, RecyclerView recyclerView, TextView textView, View view2) {
        super(obj, view, i11);
        this.B = editText;
        this.C = imageView;
        this.D = imageView2;
        this.E = loadingLayout;
        this.F = recyclerView;
        this.G = textView;
        this.H = view2;
    }

    public static s0 K(LayoutInflater layoutInflater) {
        return L(layoutInflater, c.d());
    }

    @Deprecated
    public static s0 L(LayoutInflater layoutInflater, Object obj) {
        return (s0) f.s(layoutInflater, R$layout.dialog_search_user, (ViewGroup) null, false, obj);
    }
}
