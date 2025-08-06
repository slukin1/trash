package io.noties.markwon.image;

import android.graphics.Rect;
import com.facebook.appevents.UserDataStore;
import io.noties.markwon.image.a;
import yz.a;

public class ImageSizeResolverDef extends ImageSizeResolver {
    public Rect a(a aVar) {
        return c(aVar.a(), aVar.d().getBounds(), aVar.c(), aVar.b());
    }

    public int b(a.C0654a aVar, int i11, float f11) {
        float f12;
        if (UserDataStore.EMAIL.equals(aVar.f55409b)) {
            f12 = aVar.f55408a * f11;
        } else {
            f12 = aVar.f55408a;
        }
        return (int) (f12 + 0.5f);
    }

    public Rect c(a aVar, Rect rect, int i11, float f11) {
        Rect rect2;
        int i12;
        if (aVar == null) {
            int width = rect.width();
            if (width <= i11) {
                return rect;
            }
            return new Rect(0, 0, i11, (int) ((((float) rect.height()) / (((float) width) / ((float) i11))) + 0.5f));
        }
        a.C0654a aVar2 = aVar.f55406a;
        a.C0654a aVar3 = aVar.f55407b;
        int width2 = rect.width();
        int height = rect.height();
        float f12 = ((float) width2) / ((float) height);
        if (aVar2 != null) {
            if ("%".equals(aVar2.f55409b)) {
                i12 = (int) ((((float) i11) * (aVar2.f55408a / 100.0f)) + 0.5f);
            } else {
                i12 = b(aVar2, width2, f11);
            }
            rect2 = new Rect(0, 0, i12, (aVar3 == null || "%".equals(aVar3.f55409b)) ? (int) ((((float) i12) / f12) + 0.5f) : b(aVar3, height, f11));
        } else if (aVar3 == null || "%".equals(aVar3.f55409b)) {
            return rect;
        } else {
            int b11 = b(aVar3, height, f11);
            rect2 = new Rect(0, 0, (int) ((((float) b11) * f12) + 0.5f), b11);
        }
        return rect2;
    }
}
