package uk.co.senab.photoview;

import android.graphics.RectF;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.widget.ImageView;

public class a implements GestureDetector.OnDoubleTapListener {

    /* renamed from: b  reason: collision with root package name */
    public c f60713b;

    public a(c cVar) {
        a(cVar);
    }

    public void a(c cVar) {
        this.f60713b = cVar;
    }

    public boolean onDoubleTap(MotionEvent motionEvent) {
        c cVar = this.f60713b;
        if (cVar == null) {
            return false;
        }
        try {
            float z11 = cVar.z();
            float x11 = motionEvent.getX();
            float y11 = motionEvent.getY();
            if (z11 < this.f60713b.v()) {
                c cVar2 = this.f60713b;
                cVar2.W(cVar2.v(), x11, y11, true);
            } else if (z11 < this.f60713b.v() || z11 >= this.f60713b.u()) {
                c cVar3 = this.f60713b;
                cVar3.W(cVar3.w(), x11, y11, true);
            } else {
                c cVar4 = this.f60713b;
                cVar4.W(cVar4.u(), x11, y11, true);
            }
        } catch (ArrayIndexOutOfBoundsException unused) {
        }
        return true;
    }

    public boolean onDoubleTapEvent(MotionEvent motionEvent) {
        return false;
    }

    public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
        RectF n11;
        c cVar = this.f60713b;
        if (cVar == null) {
            return false;
        }
        ImageView r11 = cVar.r();
        if (!(this.f60713b.x() == null || (n11 = this.f60713b.n()) == null)) {
            float x11 = motionEvent.getX();
            float y11 = motionEvent.getY();
            if (n11.contains(x11, y11)) {
                this.f60713b.x().onPhotoTap(r11, (x11 - n11.left) / n11.width(), (y11 - n11.top) / n11.height());
                return true;
            }
            this.f60713b.x().onOutsidePhotoTap();
        }
        if (this.f60713b.y() != null) {
            this.f60713b.y().onViewTap(r11, motionEvent.getX(), motionEvent.getY());
        }
        return false;
    }
}
