package com.alibaba.fastjson;

public enum PropertyNamingStrategy {
    CamelCase,
    PascalCase,
    SnakeCase,
    KebabCase;

    public static /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f14147a = null;

        /* JADX WARNING: Can't wrap try/catch for region: R(8:0|1|2|3|4|5|6|(3:7|8|10)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        static {
            /*
                com.alibaba.fastjson.PropertyNamingStrategy[] r0 = com.alibaba.fastjson.PropertyNamingStrategy.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f14147a = r0
                com.alibaba.fastjson.PropertyNamingStrategy r1 = com.alibaba.fastjson.PropertyNamingStrategy.SnakeCase     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f14147a     // Catch:{ NoSuchFieldError -> 0x001d }
                com.alibaba.fastjson.PropertyNamingStrategy r1 = com.alibaba.fastjson.PropertyNamingStrategy.KebabCase     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f14147a     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.alibaba.fastjson.PropertyNamingStrategy r1 = com.alibaba.fastjson.PropertyNamingStrategy.PascalCase     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = f14147a     // Catch:{ NoSuchFieldError -> 0x0033 }
                com.alibaba.fastjson.PropertyNamingStrategy r1 = com.alibaba.fastjson.PropertyNamingStrategy.CamelCase     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.alibaba.fastjson.PropertyNamingStrategy.a.<clinit>():void");
        }
    }

    public String translate(String str) {
        char charAt;
        int i11 = a.f14147a[ordinal()];
        int i12 = 0;
        if (i11 == 1) {
            StringBuilder sb2 = new StringBuilder();
            while (i12 < str.length()) {
                char charAt2 = str.charAt(i12);
                if (charAt2 < 'A' || charAt2 > 'Z') {
                    sb2.append(charAt2);
                } else {
                    char c11 = (char) (charAt2 + ' ');
                    if (i12 > 0) {
                        sb2.append('_');
                    }
                    sb2.append(c11);
                }
                i12++;
            }
            return sb2.toString();
        } else if (i11 == 2) {
            StringBuilder sb3 = new StringBuilder();
            while (i12 < str.length()) {
                char charAt3 = str.charAt(i12);
                if (charAt3 < 'A' || charAt3 > 'Z') {
                    sb3.append(charAt3);
                } else {
                    char c12 = (char) (charAt3 + ' ');
                    if (i12 > 0) {
                        sb3.append('-');
                    }
                    sb3.append(c12);
                }
                i12++;
            }
            return sb3.toString();
        } else if (i11 == 3) {
            char charAt4 = str.charAt(0);
            if (charAt4 < 'a' || charAt4 > 'z') {
                return str;
            }
            char[] charArray = str.toCharArray();
            charArray[0] = (char) (charArray[0] - ' ');
            return new String(charArray);
        } else if (i11 != 4 || (charAt = str.charAt(0)) < 'A' || charAt > 'Z') {
            return str;
        } else {
            char[] charArray2 = str.toCharArray();
            charArray2[0] = (char) (charArray2[0] + ' ');
            return new String(charArray2);
        }
    }
}
