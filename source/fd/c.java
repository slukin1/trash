package fd;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.databinding.f;
import androidx.recyclerview.widget.RecyclerView;
import com.hbg.module.huobi.im.R$layout;
import com.hbg.module.huobi.im.group.ui.JoinGroupAdminActivity;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;

public abstract class c extends f {
    public final ImageView B;
    public final TextView C;
    public final LinearLayout D;
    public final SmartRefreshLayout E;
    public final RecyclerView F;
    public final TextView G;
    public final View H;
    public JoinGroupAdminActivity I;

    public c(Object obj, View view, int i11, ImageView imageView, TextView textView, LinearLayout linearLayout, SmartRefreshLayout smartRefreshLayout, RecyclerView recyclerView, TextView textView2, View view2) {
        super(obj, view, i11);
        this.B = imageView;
        this.C = textView;
        this.D = linearLayout;
        this.E = smartRefreshLayout;
        this.F = recyclerView;
        this.G = textView2;
        this.H = view2;
    }

    public static c K(LayoutInflater layoutInflater) {
        return L(layoutInflater, androidx.databinding.c.d());
    }

    @Deprecated
    public static c L(LayoutInflater layoutInflater, Object obj) {
        return (c) f.s(layoutInflater, R$layout.activity_join_group_admin, (ViewGroup) null, false, obj);
    }

    public abstract void M(JoinGroupAdminActivity joinGroupAdminActivity);
}
