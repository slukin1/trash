package lc;

import android.util.SparseIntArray;
import android.view.View;
import androidx.databinding.adapters.TextViewBindingAdapter;
import androidx.databinding.b;
import androidx.databinding.f;
import com.hbg.lib.network.hbg.core.bean.LiveCategoryData;
import com.hbg.module.content.BR;

public class r2 extends q2 {
    public static final f.i G = null;
    public static final SparseIntArray H = null;
    public long F;

    public r2(b bVar, View view) {
        this(bVar, view, f.w(bVar, view, 3, G, H));
    }

    public void M(LiveCategoryData liveCategoryData) {
        this.E = liveCategoryData;
        synchronized (this) {
            this.F |= 1;
        }
        notifyPropertyChanged(BR.f17725b);
        super.B();
    }

    public void i() {
        long j11;
        String str;
        synchronized (this) {
            j11 = this.F;
            this.F = 0;
        }
        LiveCategoryData liveCategoryData = this.E;
        int i11 = ((j11 & 3) > 0 ? 1 : ((j11 & 3) == 0 ? 0 : -1));
        String str2 = null;
        if (i11 == 0 || liveCategoryData == null) {
            str = null;
        } else {
            str2 = liveCategoryData.getLogo();
            str = liveCategoryData.getTitle();
        }
        if (i11 != 0) {
            he.b.h(this.B, str2);
            TextViewBindingAdapter.c(this.D, str);
        }
    }

    public boolean r() {
        synchronized (this) {
            if (this.F != 0) {
                return true;
            }
            return false;
        }
    }

    public void t() {
        synchronized (this) {
            this.F = 2;
        }
        B();
    }

    public boolean x(int i11, Object obj, int i12) {
        return false;
    }

    public r2(b bVar, View view, Object[] objArr) {
        super(bVar, view, 0, objArr[1], objArr[0], objArr[2]);
        this.F = -1;
        this.B.setTag((Object) null);
        this.C.setTag((Object) null);
        this.D.setTag((Object) null);
        G(view);
        t();
    }
}
