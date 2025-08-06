package yf;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.f;
import androidx.recyclerview.widget.RecyclerView;
import com.hbg.module.share.R$layout;
import com.hbg.module.share.ui.GroupShareActivity;

public abstract class c extends f {
    public final ConstraintLayout B;
    public final EditText C;
    public final LinearLayout D;
    public final RecyclerView E;
    public final TextView F;
    public GroupShareActivity G;

    public c(Object obj, View view, int i11, ConstraintLayout constraintLayout, EditText editText, LinearLayout linearLayout, RecyclerView recyclerView, TextView textView) {
        super(obj, view, i11);
        this.B = constraintLayout;
        this.C = editText;
        this.D = linearLayout;
        this.E = recyclerView;
        this.F = textView;
    }

    public static c K(LayoutInflater layoutInflater) {
        return L(layoutInflater, androidx.databinding.c.d());
    }

    @Deprecated
    public static c L(LayoutInflater layoutInflater, Object obj) {
        return (c) f.s(layoutInflater, R$layout.activity_group_share, (ViewGroup) null, false, obj);
    }

    public abstract void M(GroupShareActivity groupShareActivity);
}
