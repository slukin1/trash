package iy;

import android.graphics.Color;

public final class a {
    public static int a(int i11, int i12) {
        return 255 - (((255 - i12) * (255 - i11)) / 255);
    }

    public static int b(int i11, int i12) {
        int alpha = Color.alpha(i12);
        int alpha2 = Color.alpha(i11);
        int a11 = a(alpha2, alpha);
        return Color.argb(a11, c(Color.red(i11), alpha2, Color.red(i12), alpha, a11), c(Color.green(i11), alpha2, Color.green(i12), alpha, a11), c(Color.blue(i11), alpha2, Color.blue(i12), alpha, a11));
    }

    public static int c(int i11, int i12, int i13, int i14, int i15) {
        if (i15 == 0) {
            return 0;
        }
        return (((i11 * 255) * i12) + ((i13 * i14) * (255 - i12))) / (i15 * 255);
    }

    public static int d(int i11, int i12) {
        if (i12 >= 0 && i12 <= 255) {
            return (i11 & FlexItem.MAX_SIZE) | (i12 << 24);
        }
        throw new IllegalArgumentException("alpha must be between 0 and 255.");
    }
}
