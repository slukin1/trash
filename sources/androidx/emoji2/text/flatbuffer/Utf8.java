package androidx.emoji2.text.flatbuffer;

public abstract class Utf8 {

    /* renamed from: a  reason: collision with root package name */
    public static Utf8 f9473a;

    public static class UnpairedSurrogateException extends IllegalArgumentException {
        public UnpairedSurrogateException(int i11, int i12) {
            super("Unpaired surrogate at index " + i11 + " of " + i12);
        }
    }

    public static Utf8 a() {
        if (f9473a == null) {
            f9473a = new Utf8Safe();
        }
        return f9473a;
    }
}
