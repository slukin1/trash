package lc;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.databinding.c;
import androidx.databinding.f;
import com.hbg.module.content.R$layout;
import com.huobi.view.roundview.RoundConstraintLayout;
import com.huochat.community.widget.expandable.ExpandableTextView;

public abstract class g3 extends f {
    public final RoundConstraintLayout B;
    public final TextView C;
    public final ExpandableTextView D;

    public g3(Object obj, View view, int i11, RoundConstraintLayout roundConstraintLayout, TextView textView, ExpandableTextView expandableTextView) {
        super(obj, view, i11);
        this.B = roundConstraintLayout;
        this.C = textView;
        this.D = expandableTextView;
    }

    public static g3 K(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z11) {
        return L(layoutInflater, viewGroup, z11, c.d());
    }

    @Deprecated
    public static g3 L(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z11, Object obj) {
        return (g3) f.s(layoutInflater, R$layout.item_community_feed_reply_comment, viewGroup, z11, obj);
    }
}
