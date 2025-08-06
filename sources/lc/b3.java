package lc;

import android.util.SparseIntArray;
import android.view.View;
import androidx.databinding.b;
import androidx.databinding.f;
import com.hbg.module.content.R$id;

public class b3 extends a3 {
    public static final f.i X = null;
    public static final SparseIntArray Y;
    public long W;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        Y = sparseIntArray;
        sparseIntArray.put(R$id.imageHeader, 1);
        sparseIntArray.put(R$id.tvNickName, 2);
        sparseIntArray.put(R$id.tvDateTime, 3);
        sparseIntArray.put(R$id.btnAttention, 4);
        sparseIntArray.put(R$id.imageAttentionPlus, 5);
        sparseIntArray.put(R$id.tvARAction, 6);
        sparseIntArray.put(R$id.tvTitle, 7);
        sparseIntArray.put(R$id.tvContent, 8);
        sparseIntArray.put(R$id.imageLayout, 9);
        sparseIntArray.put(R$id.childLayout, 10);
        sparseIntArray.put(R$id.rlShare, 11);
        sparseIntArray.put(R$id.imageShare, 12);
        sparseIntArray.put(R$id.rlCommon, 13);
        sparseIntArray.put(R$id.imageCommon, 14);
        sparseIntArray.put(R$id.tvCommon, 15);
        sparseIntArray.put(R$id.rlLike, 16);
        sparseIntArray.put(R$id.imageLike, 17);
        sparseIntArray.put(R$id.tvLike, 18);
        sparseIntArray.put(R$id.imageMore, 19);
        sparseIntArray.put(R$id.lineView, 20);
    }

    public b3(b bVar, View view) {
        this(bVar, view, f.w(bVar, view, 21, X, Y));
    }

    public void i() {
        synchronized (this) {
            this.W = 0;
        }
    }

    public boolean r() {
        synchronized (this) {
            if (this.W != 0) {
                return true;
            }
            return false;
        }
    }

    public void t() {
        synchronized (this) {
            this.W = 1;
        }
        B();
    }

    public boolean x(int i11, Object obj, int i12) {
        return false;
    }

    public b3(b bVar, View view, Object[] objArr) {
        super(bVar, view, 0, objArr[4], objArr[10], objArr[0], objArr[5], objArr[14], objArr[1], objArr[9], objArr[17], objArr[19], objArr[12], objArr[20], objArr[13], objArr[16], objArr[11], objArr[6], objArr[15], objArr[8], objArr[3], objArr[18], objArr[2], objArr[7]);
        this.W = -1;
        this.D.setTag((Object) null);
        G(view);
        t();
    }
}
