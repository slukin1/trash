package kotlin.text;

class StringsKt__StringNumberConversionsJVMKt extends StringsKt__StringBuilderKt {
    public static Double j(String str) {
        try {
            if (i.f56929b.matches(str)) {
                return Double.valueOf(Double.parseDouble(str));
            }
            return null;
        } catch (NumberFormatException unused) {
            return null;
        }
    }

    public static Float k(String str) {
        try {
            if (i.f56929b.matches(str)) {
                return Float.valueOf(Float.parseFloat(str));
            }
            return null;
        } catch (NumberFormatException unused) {
            return null;
        }
    }
}
