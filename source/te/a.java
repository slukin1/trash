package te;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.databinding.c;
import androidx.databinding.f;
import com.hbg.module.libkt.R$layout;

public abstract class a extends f {
    public final TextView B;
    public final TextView C;
    public final TextView D;
    public Boolean E;

    public a(Object obj, View view, int i11, TextView textView, TextView textView2, TextView textView3) {
        super(obj, view, i11);
        this.B = textView;
        this.C = textView2;
        this.D = textView3;
    }

    public static a K(LayoutInflater layoutInflater) {
        return L(layoutInflater, c.d());
    }

    @Deprecated
    public static a L(LayoutInflater layoutInflater, Object obj) {
        return (a) f.s(layoutInflater, R$layout.dialog_button, (ViewGroup) null, false, obj);
    }

    public abstract void M(Boolean bool);
}
