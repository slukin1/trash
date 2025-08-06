package lc;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.databinding.adapters.TextViewBindingAdapter;
import androidx.databinding.b;
import androidx.databinding.f;
import com.hbg.lib.network.hbg.core.bean.LiveGroup;
import com.hbg.module.content.BR;
import com.hbg.module.content.R$id;
import com.hbg.module.content.R$string;

public class f6 extends e6 {
    public static final f.i K = null;
    public static final SparseIntArray L;
    public final RelativeLayout G;
    public final TextView H;
    public final TextView I;
    public long J;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        L = sparseIntArray;
        sparseIntArray.put(R$id.vBg, 3);
        sparseIntArray.put(R$id.ivGroupIcon, 4);
        sparseIntArray.put(R$id.llGroupInfo, 5);
        sparseIntArray.put(R$id.tvJoinGroup, 6);
    }

    public f6(b bVar, View view) {
        this(bVar, view, f.w(bVar, view, 7, K, L));
    }

    public void K(LiveGroup liveGroup) {
        this.F = liveGroup;
        synchronized (this) {
            this.J |= 1;
        }
        notifyPropertyChanged(BR.f17730g);
        super.B();
    }

    public void i() {
        long j11;
        String str;
        synchronized (this) {
            j11 = this.J;
            this.J = 0;
        }
        LiveGroup liveGroup = this.F;
        int i11 = ((j11 & 3) > 0 ? 1 : ((j11 & 3) == 0 ? 0 : -1));
        String str2 = null;
        if (i11 == 0 || liveGroup == null) {
            str = null;
        } else {
            str = liveGroup.userCount;
            str2 = liveGroup.title;
        }
        if (i11 != 0) {
            TextViewBindingAdapter.c(this.H, str2);
            TextView textView = this.I;
            he.b.g(textView, textView.getResources().getString(R$string.n_live_member_num), str);
        }
    }

    public boolean r() {
        synchronized (this) {
            if (this.J != 0) {
                return true;
            }
            return false;
        }
    }

    public void t() {
        synchronized (this) {
            this.J = 2;
        }
        B();
    }

    public boolean x(int i11, Object obj, int i12) {
        return false;
    }

    public f6(b bVar, View view, Object[] objArr) {
        super(bVar, view, 0, objArr[4], objArr[5], objArr[6], objArr[3]);
        this.J = -1;
        RelativeLayout relativeLayout = objArr[0];
        this.G = relativeLayout;
        relativeLayout.setTag((Object) null);
        TextView textView = objArr[1];
        this.H = textView;
        textView.setTag((Object) null);
        TextView textView2 = objArr[2];
        this.I = textView2;
        textView2.setTag((Object) null);
        G(view);
        t();
    }
}
