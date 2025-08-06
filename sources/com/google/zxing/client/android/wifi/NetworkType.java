package com.google.zxing.client.android.wifi;

enum NetworkType {
    WEP,
    WPA,
    NO_PASSWORD;

    public static NetworkType forIntentValue(String str) {
        if (str == null) {
            return NO_PASSWORD;
        }
        char c11 = 65535;
        switch (str.hashCode()) {
            case -1039816366:
                if (str.equals("nopass")) {
                    c11 = 0;
                    break;
                }
                break;
            case 85826:
                if (str.equals("WEP")) {
                    c11 = 1;
                    break;
                }
                break;
            case 86152:
                if (str.equals("WPA")) {
                    c11 = 2;
                    break;
                }
                break;
            case 2670762:
                if (str.equals("WPA2")) {
                    c11 = 3;
                    break;
                }
                break;
        }
        switch (c11) {
            case 0:
                return NO_PASSWORD;
            case 1:
                return WEP;
            case 2:
            case 3:
                return WPA;
            default:
                throw new IllegalArgumentException(str);
        }
    }
}
