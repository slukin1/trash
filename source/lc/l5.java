package lc;

import android.util.SparseIntArray;
import android.view.View;
import androidx.databinding.b;
import androidx.databinding.f;
import com.hbg.module.content.R$id;

public class l5 extends k5 {
    public static final f.i Q = null;
    public static final SparseIntArray R;
    public long P;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        R = sparseIntArray;
        sparseIntArray.put(R$id.cardView, 1);
        sparseIntArray.put(R$id.rlRoot, 2);
        sparseIntArray.put(R$id.ivCover, 3);
        sparseIntArray.put(R$id.blurView, 4);
        sparseIntArray.put(R$id.tvTitle, 5);
        sparseIntArray.put(R$id.llLiveHint, 6);
        sparseIntArray.put(R$id.ivLivePlaying, 7);
        sparseIntArray.put(R$id.ivLiveIcon, 8);
        sparseIntArray.put(R$id.tvLiveType, 9);
        sparseIntArray.put(R$id.llBottom, 10);
        sparseIntArray.put(R$id.flAvatar, 11);
        sparseIntArray.put(R$id.ivAvatar, 12);
        sparseIntArray.put(R$id.tvNickname, 13);
    }

    public l5(b bVar, View view) {
        this(bVar, view, f.w(bVar, view, 14, Q, R));
    }

    public void i() {
        synchronized (this) {
            this.P = 0;
        }
    }

    public boolean r() {
        synchronized (this) {
            if (this.P != 0) {
                return true;
            }
            return false;
        }
    }

    public void t() {
        synchronized (this) {
            this.P = 1;
        }
        B();
    }

    public boolean x(int i11, Object obj, int i12) {
        return false;
    }

    public l5(b bVar, View view, Object[] objArr) {
        super(bVar, view, 0, objArr[4], objArr[1], objArr[11], objArr[12], objArr[3], objArr[8], objArr[7], objArr[10], objArr[6], objArr[2], objArr[0], objArr[9], objArr[13], objArr[5]);
        this.P = -1;
        this.L.setTag((Object) null);
        G(view);
        t();
    }
}
