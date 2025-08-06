package lc;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import androidx.databinding.c;
import androidx.databinding.f;
import com.hbg.module.content.R$layout;

public abstract class q0 extends f {
    public final EditText B;
    public final TextView C;
    public final TextView D;
    public final TextView E;

    public q0(Object obj, View view, int i11, EditText editText, TextView textView, TextView textView2, TextView textView3) {
        super(obj, view, i11);
        this.B = editText;
        this.C = textView;
        this.D = textView2;
        this.E = textView3;
    }

    public static q0 K(LayoutInflater layoutInflater) {
        return L(layoutInflater, c.d());
    }

    @Deprecated
    public static q0 L(LayoutInflater layoutInflater, Object obj) {
        return (q0) f.s(layoutInflater, R$layout.dialog_reason, (ViewGroup) null, false, obj);
    }
}
