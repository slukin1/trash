package com.yanzhenjie.recyclerview.swipe;

import android.view.View;
import android.widget.OverScroller;
import com.yanzhenjie.recyclerview.swipe.SwipeHorizontal;

public class a extends SwipeHorizontal {
    public a(View view) {
        super(1, view);
    }

    public void a(OverScroller overScroller, int i11, int i12) {
        overScroller.startScroll(-Math.abs(i11), 0, Math.abs(i11), 0, i12);
    }

    public void b(OverScroller overScroller, int i11, int i12) {
        overScroller.startScroll(Math.abs(i11), 0, f().getWidth() - Math.abs(i11), 0, i12);
    }

    public SwipeHorizontal.Checker d(int i11, int i12) {
        SwipeHorizontal.Checker checker = this.f52632c;
        checker.f52633a = i11;
        checker.f52634b = i12;
        checker.f52635c = false;
        if (i11 == 0) {
            checker.f52635c = true;
        }
        if (i11 >= 0) {
            checker.f52633a = 0;
        }
        if (checker.f52633a <= (-f().getWidth())) {
            this.f52632c.f52633a = -f().getWidth();
        }
        return this.f52632c;
    }

    public boolean h(int i11, float f11) {
        return f11 > ((float) f().getWidth());
    }

    public boolean j(int i11) {
        int e11 = (-f().getWidth()) * e();
        return i11 <= e11 && e11 != 0;
    }

    public boolean k(int i11) {
        return i11 < (-f().getWidth()) * e();
    }
}
