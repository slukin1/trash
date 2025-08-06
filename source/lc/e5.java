package lc;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.databinding.c;
import androidx.databinding.f;
import com.hbg.lib.network.hbg.core.bean.LiveGroupUserListData;
import com.hbg.module.content.R$layout;

public abstract class e5 extends f {
    public final FrameLayout B;
    public final ImageView C;
    public final ImageView D;
    public final LinearLayout E;
    public final TextView F;
    public final TextView G;
    public LiveGroupUserListData.GroupUser H;

    public e5(Object obj, View view, int i11, FrameLayout frameLayout, ImageView imageView, ImageView imageView2, LinearLayout linearLayout, TextView textView, TextView textView2) {
        super(obj, view, i11);
        this.B = frameLayout;
        this.C = imageView;
        this.D = imageView2;
        this.E = linearLayout;
        this.F = textView;
        this.G = textView2;
    }

    public static e5 K(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z11) {
        return L(layoutInflater, viewGroup, z11, c.d());
    }

    @Deprecated
    public static e5 L(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z11, Object obj) {
        return (e5) f.s(layoutInflater, R$layout.item_live_member, viewGroup, z11, obj);
    }

    public abstract void M(LiveGroupUserListData.GroupUser groupUser);
}
