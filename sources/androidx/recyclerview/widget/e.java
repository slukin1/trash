package androidx.recyclerview.widget;

import android.annotation.SuppressLint;

public class e implements p {

    /* renamed from: b  reason: collision with root package name */
    public final p f10840b;

    /* renamed from: c  reason: collision with root package name */
    public int f10841c = 0;

    /* renamed from: d  reason: collision with root package name */
    public int f10842d = -1;

    /* renamed from: e  reason: collision with root package name */
    public int f10843e = -1;

    /* renamed from: f  reason: collision with root package name */
    public Object f10844f = null;

    public e(p pVar) {
        this.f10840b = pVar;
    }

    public void a() {
        int i11 = this.f10841c;
        if (i11 != 0) {
            if (i11 == 1) {
                this.f10840b.onInserted(this.f10842d, this.f10843e);
            } else if (i11 == 2) {
                this.f10840b.onRemoved(this.f10842d, this.f10843e);
            } else if (i11 == 3) {
                this.f10840b.onChanged(this.f10842d, this.f10843e, this.f10844f);
            }
            this.f10844f = null;
            this.f10841c = 0;
        }
    }

    @SuppressLint({"UnknownNullness"})
    public void onChanged(int i11, int i12, Object obj) {
        int i13;
        if (this.f10841c == 3) {
            int i14 = this.f10842d;
            int i15 = this.f10843e;
            if (i11 <= i14 + i15 && (i13 = i11 + i12) >= i14 && this.f10844f == obj) {
                this.f10842d = Math.min(i11, i14);
                this.f10843e = Math.max(i15 + i14, i13) - this.f10842d;
                return;
            }
        }
        a();
        this.f10842d = i11;
        this.f10843e = i12;
        this.f10844f = obj;
        this.f10841c = 3;
    }

    public void onInserted(int i11, int i12) {
        int i13;
        if (this.f10841c == 1 && i11 >= (i13 = this.f10842d)) {
            int i14 = this.f10843e;
            if (i11 <= i13 + i14) {
                this.f10843e = i14 + i12;
                this.f10842d = Math.min(i11, i13);
                return;
            }
        }
        a();
        this.f10842d = i11;
        this.f10843e = i12;
        this.f10841c = 1;
    }

    public void onMoved(int i11, int i12) {
        a();
        this.f10840b.onMoved(i11, i12);
    }

    public void onRemoved(int i11, int i12) {
        int i13;
        if (this.f10841c != 2 || (i13 = this.f10842d) < i11 || i13 > i11 + i12) {
            a();
            this.f10842d = i11;
            this.f10843e = i12;
            this.f10841c = 2;
            return;
        }
        this.f10843e += i12;
        this.f10842d = i11;
    }
}
