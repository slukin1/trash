package lc;

import android.util.SparseIntArray;
import android.view.View;
import androidx.databinding.b;
import androidx.databinding.f;
import com.hbg.module.content.R$id;

public class d3 extends c3 {
    public static final f.i O = null;
    public static final SparseIntArray P;
    public long N;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        P = sparseIntArray;
        sparseIntArray.put(R$id.imageHeader, 1);
        sparseIntArray.put(R$id.tvNickName, 2);
        sparseIntArray.put(R$id.llContent, 3);
        sparseIntArray.put(R$id.tvTitle, 4);
        sparseIntArray.put(R$id.tvContent, 5);
        sparseIntArray.put(R$id.dpcImgs, 6);
        sparseIntArray.put(R$id.llLiveStatus, 7);
        sparseIntArray.put(R$id.slvLivePlaying, 8);
        sparseIntArray.put(R$id.ivLivePlaying, 9);
        sparseIntArray.put(R$id.tvLiveType, 10);
        sparseIntArray.put(R$id.attachmentContainer, 11);
    }

    public d3(b bVar, View view) {
        this(bVar, view, f.w(bVar, view, 12, O, P));
    }

    public void i() {
        synchronized (this) {
            this.N = 0;
        }
    }

    public boolean r() {
        synchronized (this) {
            if (this.N != 0) {
                return true;
            }
            return false;
        }
    }

    public void t() {
        synchronized (this) {
            this.N = 1;
        }
        B();
    }

    public boolean x(int i11, Object obj, int i12) {
        return false;
    }

    public d3(b bVar, View view, Object[] objArr) {
        super(bVar, view, 0, objArr[11], objArr[0], objArr[6], objArr[1], objArr[9], objArr[3], objArr[7], objArr[8], objArr[5], objArr[10], objArr[2], objArr[4]);
        this.N = -1;
        this.C.setTag((Object) null);
        G(view);
        t();
    }
}
