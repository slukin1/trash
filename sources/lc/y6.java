package lc;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.databinding.c;
import androidx.databinding.f;
import com.hbg.module.content.R$layout;

public abstract class y6 extends f {
    public final AppCompatImageView B;
    public final AppCompatTextView C;
    public final LinearLayoutCompat D;

    public y6(Object obj, View view, int i11, AppCompatImageView appCompatImageView, AppCompatTextView appCompatTextView, LinearLayoutCompat linearLayoutCompat) {
        super(obj, view, i11);
        this.B = appCompatImageView;
        this.C = appCompatTextView;
        this.D = linearLayoutCompat;
    }

    public static y6 K(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z11) {
        return L(layoutInflater, viewGroup, z11, c.d());
    }

    @Deprecated
    public static y6 L(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z11, Object obj) {
        return (y6) f.s(layoutInflater, R$layout.topic_news_item, viewGroup, z11, obj);
    }
}
