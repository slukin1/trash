package com.huobi.vulcan.core;

import com.huobi.finance.bean.VirtualAddressInfo;
import lu.a;

public final class SecurityKey {
    static {
        System.loadLibrary(VirtualAddressInfo.LEVEL_SECURITY);
    }

    private static native String _getAesKey();

    private static native String _getAppId();

    private static native String _getAppKey();

    private static native String _getExceptionLogIvParam();

    private static native String _getExceptionLogKey();

    private static native String _getIvParam();

    private static native String _getPublicKey();

    private static native String _getSwitchIvParam();

    private static native String _getSwitchKey();

    public static String a() {
        return _getAesKey();
    }

    public static String b() {
        return _getAppId();
    }

    public static String c() {
        return _getAppKey();
    }

    public static String d() {
        if (a.e()) {
            return "device-sdk-log-1";
        }
        return _getExceptionLogIvParam();
    }

    public static native int ddgp();

    public static native int ddtp();

    public static native int dffp();

    public static native int dfn();

    public static native int dfpm();

    public static native int dft();

    public static native int dxn();

    public static native int dxpm();

    public static native int dxr();

    public static String e() {
        if (a.e()) {
            return "device-sdk-log-12345678123456781";
        }
        return _getExceptionLogKey();
    }

    public static String f() {
        return _getIvParam();
    }

    public static String g() {
        if (a.e()) {
            return "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQCsSwEaiD3sngSuy0VcdrgPAeQz\nSrncQaoSA8Ns0NgTa5r9kd2S7LCkjxLCceGzFKptBKbKQsfVp6w7TOGzAoKNcrze\nY+qtNJqZQ01Vt/l8EnYF/xqZ5SiIjVvST/Mlomeqb+eCPaUMrtoc2msBubwipawT\nzSerUfYtrswM8gXWVQIDAQAB";
        }
        try {
            return _getPublicKey();
        } catch (UnsatisfiedLinkError e11) {
            a.d("SecurityKey", "getPublicKey failed:", e11);
            return "-----BEGIN PUBLIC KEY-----\nMIAfMJNKoeuGSIb3DQEBAQUAA4GNADCBiQKBgQPQkfegGMMVpEV93123456ULQ/g\noSXpcHJb9WLN/2EQwPjTyaovAIo3TfZXXv567890/xN7+05AsQqX/gpp8HO2Nfuk\nEaqlW1Cml0CYS1234567890Gu7IlUl3hWQfx6prXWcKteUmiwMMKGcoGJQG702aD\nOmG9rGvrbRcZ5x1234567890\n-----END PUBLIC KEY-----";
        }
    }

    public static Integer getBusinessLine() {
        return Integer.valueOf(iu.a.f().e());
    }

    @Deprecated
    private static native String getSecret();

    public static String h() {
        if (a.e()) {
            return "2234567890123456";
        }
        return _getSwitchIvParam();
    }

    public static String i() {
        if (a.e()) {
            return "23456789012345678901234567890123";
        }
        return _getSwitchKey();
    }

    public static native int ifse(Object[] objArr);

    public static native String jspg(String str);

    public static native String testMd5(String str);
}
