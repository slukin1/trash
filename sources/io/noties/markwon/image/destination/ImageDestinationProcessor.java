package io.noties.markwon.image.destination;

public abstract class ImageDestinationProcessor {

    public static class b extends ImageDestinationProcessor {
        public b() {
        }

        public String b(String str) {
            return str;
        }
    }

    public static ImageDestinationProcessor a() {
        return new b();
    }

    public abstract String b(String str);
}
