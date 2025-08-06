package lc;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.FrameLayout;
import androidx.databinding.b;
import androidx.databinding.f;
import com.hbg.lib.network.hbg.core.bean.GiftUser;
import com.hbg.module.content.BR;
import com.hbg.module.content.R$drawable;

public class n4 extends m4 {
    public static final f.i F = null;
    public static final SparseIntArray G = null;
    public final FrameLayout D;
    public long E;

    public n4(b bVar, View view) {
        this(bVar, view, f.w(bVar, view, 2, F, G));
    }

    public void M(GiftUser giftUser) {
        this.C = giftUser;
        synchronized (this) {
            this.E |= 1;
        }
        notifyPropertyChanged(BR.f17725b);
        super.B();
    }

    public void i() {
        long j11;
        synchronized (this) {
            j11 = this.E;
            this.E = 0;
        }
        String str = null;
        int i11 = 0;
        GiftUser giftUser = this.C;
        int i12 = ((j11 & 3) > 0 ? 1 : ((j11 & 3) == 0 ? 0 : -1));
        if (i12 != 0) {
            i11 = R$drawable.icon_default_avatar;
            if (giftUser != null) {
                str = giftUser.avatar;
            }
        }
        if (i12 != 0) {
            he.b.p(this.B, str, i11);
        }
    }

    public boolean r() {
        synchronized (this) {
            if (this.E != 0) {
                return true;
            }
            return false;
        }
    }

    public void t() {
        synchronized (this) {
            this.E = 2;
        }
        B();
    }

    public boolean x(int i11, Object obj, int i12) {
        return false;
    }

    public n4(b bVar, View view, Object[] objArr) {
        super(bVar, view, 0, objArr[1]);
        this.E = -1;
        this.B.setTag((Object) null);
        FrameLayout frameLayout = objArr[0];
        this.D = frameLayout;
        frameLayout.setTag((Object) null);
        G(view);
        t();
    }
}
