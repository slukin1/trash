package lj;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.databinding.c;
import androidx.databinding.f;
import com.huobi.tradingbot.ui.BotCompleteActivity;
import pro.huobi.R;

public abstract class a extends f {
    public final FrameLayout B;
    public final LinearLayout C;
    public final TextView D;
    public final View E;
    public BotCompleteActivity F;

    public a(Object obj, View view, int i11, FrameLayout frameLayout, LinearLayout linearLayout, TextView textView, View view2) {
        super(obj, view, i11);
        this.B = frameLayout;
        this.C = linearLayout;
        this.D = textView;
        this.E = view2;
    }

    public static a K(LayoutInflater layoutInflater) {
        return L(layoutInflater, c.d());
    }

    @Deprecated
    public static a L(LayoutInflater layoutInflater, Object obj) {
        return (a) f.s(layoutInflater, R.layout.activity_contract_bot_complete, (ViewGroup) null, false, obj);
    }

    public abstract void M(BotCompleteActivity botCompleteActivity);
}
