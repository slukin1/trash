package com.huobi.woodpecker.kalle;

import java.util.Locale;

public enum RequestMethod {
    GET("GET"),
    POST("POST"),
    PUT("PUT"),
    DELETE("DELETE"),
    HEAD("HEAD"),
    PATCH("PATCH"),
    OPTIONS("OPTIONS"),
    TRACE("TRACE");
    
    private final String value;

    public static /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f21026a = null;

        /* JADX WARNING: Can't wrap try/catch for region: R(8:0|1|2|3|4|5|6|(3:7|8|10)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        static {
            /*
                com.huobi.woodpecker.kalle.RequestMethod[] r0 = com.huobi.woodpecker.kalle.RequestMethod.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f21026a = r0
                com.huobi.woodpecker.kalle.RequestMethod r1 = com.huobi.woodpecker.kalle.RequestMethod.POST     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f21026a     // Catch:{ NoSuchFieldError -> 0x001d }
                com.huobi.woodpecker.kalle.RequestMethod r1 = com.huobi.woodpecker.kalle.RequestMethod.PUT     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f21026a     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.huobi.woodpecker.kalle.RequestMethod r1 = com.huobi.woodpecker.kalle.RequestMethod.PATCH     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = f21026a     // Catch:{ NoSuchFieldError -> 0x0033 }
                com.huobi.woodpecker.kalle.RequestMethod r1 = com.huobi.woodpecker.kalle.RequestMethod.DELETE     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.huobi.woodpecker.kalle.RequestMethod.a.<clinit>():void");
        }
    }

    private RequestMethod(String str) {
        this.value = str;
    }

    public static RequestMethod reverse(String str) {
        String upperCase = str.toUpperCase(Locale.ENGLISH);
        upperCase.hashCode();
        char c11 = 65535;
        switch (upperCase.hashCode()) {
            case -531492226:
                if (upperCase.equals("OPTIONS")) {
                    c11 = 0;
                    break;
                }
                break;
            case 70454:
                if (upperCase.equals("GET")) {
                    c11 = 1;
                    break;
                }
                break;
            case 79599:
                if (upperCase.equals("PUT")) {
                    c11 = 2;
                    break;
                }
                break;
            case 2213344:
                if (upperCase.equals("HEAD")) {
                    c11 = 3;
                    break;
                }
                break;
            case 2461856:
                if (upperCase.equals("POST")) {
                    c11 = 4;
                    break;
                }
                break;
            case 75900968:
                if (upperCase.equals("PATCH")) {
                    c11 = 5;
                    break;
                }
                break;
            case 80083237:
                if (upperCase.equals("TRACE")) {
                    c11 = 6;
                    break;
                }
                break;
            case 2012838315:
                if (upperCase.equals("DELETE")) {
                    c11 = 7;
                    break;
                }
                break;
        }
        switch (c11) {
            case 0:
                return OPTIONS;
            case 1:
                return GET;
            case 2:
                return PUT;
            case 3:
                return HEAD;
            case 4:
                return POST;
            case 5:
                return PATCH;
            case 6:
                return TRACE;
            case 7:
                return DELETE;
            default:
                return GET;
        }
    }

    public boolean allowBody() {
        int i11 = a.f21026a[ordinal()];
        return i11 == 1 || i11 == 2 || i11 == 3 || i11 == 4;
    }

    public String toString() {
        return this.value;
    }
}
