package lc;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.databinding.c;
import androidx.databinding.f;
import com.hbg.module.content.R$layout;

public abstract class w3 extends f {
    public final AppCompatTextView B;
    public final TextView C;

    public w3(Object obj, View view, int i11, AppCompatTextView appCompatTextView, TextView textView) {
        super(obj, view, i11);
        this.B = appCompatTextView;
        this.C = textView;
    }

    public static w3 K(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z11) {
        return L(layoutInflater, viewGroup, z11, c.d());
    }

    @Deprecated
    public static w3 L(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z11, Object obj) {
        return (w3) f.s(layoutInflater, R$layout.item_community_topic_item, viewGroup, z11, obj);
    }
}
