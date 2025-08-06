package lc;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.TextView;
import androidx.databinding.adapters.TextViewBindingAdapter;
import androidx.databinding.b;
import androidx.databinding.f;
import com.hbg.lib.network.hbg.core.bean.WatchFansBean;
import com.hbg.module.content.BR;
import com.hbg.module.content.R$id;

public class d4 extends c4 {
    public static final f.i H = null;
    public static final SparseIntArray I;
    public final TextView F;
    public long G;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        I = sparseIntArray;
        sparseIntArray.put(R$id.ivAvatar, 2);
        sparseIntArray.put(R$id.followView, 3);
    }

    public d4(b bVar, View view) {
        this(bVar, view, f.w(bVar, view, 4, H, I));
    }

    public void M(WatchFansBean watchFansBean) {
        this.E = watchFansBean;
        synchronized (this) {
            this.G |= 1;
        }
        notifyPropertyChanged(BR.f17725b);
        super.B();
    }

    public void i() {
        long j11;
        synchronized (this) {
            j11 = this.G;
            this.G = 0;
        }
        String str = null;
        WatchFansBean watchFansBean = this.E;
        int i11 = ((j11 & 3) > 0 ? 1 : ((j11 & 3) == 0 ? 0 : -1));
        if (!(i11 == 0 || watchFansBean == null)) {
            str = watchFansBean.getUserNickname();
        }
        if (i11 != 0) {
            TextViewBindingAdapter.c(this.F, str);
        }
    }

    public boolean r() {
        synchronized (this) {
            if (this.G != 0) {
                return true;
            }
            return false;
        }
    }

    public void t() {
        synchronized (this) {
            this.G = 2;
        }
        B();
    }

    public boolean x(int i11, Object obj, int i12) {
        return false;
    }

    public d4(b bVar, View view, Object[] objArr) {
        super(bVar, view, 0, objArr[3], objArr[2], objArr[0]);
        this.G = -1;
        this.D.setTag((Object) null);
        TextView textView = objArr[1];
        this.F = textView;
        textView.setTag((Object) null);
        G(view);
        t();
    }
}
