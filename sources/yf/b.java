package yf;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.LinearLayout;
import androidx.databinding.f;
import com.hbg.module.share.R$id;
import com.hbg.module.share.ui.FeedShareActivity;

public class b extends a {
    public static final f.i N = null;
    public static final SparseIntArray O;
    public final LinearLayout L;
    public long M;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        O = sparseIntArray;
        sparseIntArray.put(R$id.vTopBar, 1);
        sparseIntArray.put(R$id.tvCancel, 2);
        sparseIntArray.put(R$id.tvSend, 3);
        sparseIntArray.put(R$id.etContent, 4);
        sparseIntArray.put(R$id.llContent, 5);
        sparseIntArray.put(R$id.tvSource, 6);
        sparseIntArray.put(R$id.tvContentDesc, 7);
        sparseIntArray.put(R$id.ivPic, 8);
        sparseIntArray.put(R$id.tvLongPic, 9);
    }

    public b(androidx.databinding.b bVar, View view) {
        this(bVar, view, f.w(bVar, view, 10, N, O));
    }

    public void M(FeedShareActivity feedShareActivity) {
        this.K = feedShareActivity;
    }

    public void i() {
        synchronized (this) {
            this.M = 0;
        }
    }

    public boolean r() {
        synchronized (this) {
            if (this.M != 0) {
                return true;
            }
            return false;
        }
    }

    public void t() {
        synchronized (this) {
            this.M = 2;
        }
        B();
    }

    public boolean x(int i11, Object obj, int i12) {
        return false;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public b(androidx.databinding.b bVar, View view, Object[] objArr) {
        super(bVar, view, 0, objArr[4], objArr[8], objArr[5], objArr[2], objArr[7], objArr[9], objArr[3], objArr[6], objArr[1]);
        this.M = -1;
        LinearLayout linearLayout = objArr[0];
        this.L = linearLayout;
        linearLayout.setTag((Object) null);
        G(view);
        t();
    }
}
