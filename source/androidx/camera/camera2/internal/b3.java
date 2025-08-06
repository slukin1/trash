package androidx.camera.camera2.internal;

public class b3 {
    public static int a(int i11) {
        if (i11 == 0) {
            return 0;
        }
        if (i11 == 1) {
            return 1;
        }
        if (i11 == 2) {
            return 2;
        }
        throw new IllegalArgumentException("The given lens facing integer: " + i11 + " can not be recognized.");
    }

    public static int b(int i11) {
        if (i11 == 0) {
            return 0;
        }
        if (i11 == 1) {
            return 1;
        }
        if (i11 == 2) {
            return 2;
        }
        throw new IllegalArgumentException("The given lens facing: " + i11 + " can not be recognized.");
    }
}
