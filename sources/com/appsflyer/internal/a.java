package com.appsflyer.internal;

public class a {
    private static int AppsFlyerConversionListener = 0;
    public static final int AppsFlyerInAppPurchaseValidatorListener = 0;
    public static final byte[] AppsFlyerLib = null;
    private static int getSdkVersion = 1;
    public static byte[] onAppOpenAttribution;
    private static Object onAttributionFailure;
    public static byte[] onConversionDataFail;
    private static Object onDeepLinking;
    private static int onValidateInApp;
    private static int onValidateInAppFailure;

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v4, resolved type: byte} */
    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0034, code lost:
        if ((r13 == null ? '/' : 'L') != 'L') goto L_0x0062;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0060, code lost:
        if (r8 != 12) goto L_0x0062;
     */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x009e  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static java.lang.String $$c(short r11, short r12, byte r13) {
        /*
            int r0 = onValidateInApp
            r1 = r0 | 71
            r2 = 1
            int r1 = r1 << r2
            r0 = r0 ^ 71
            int r1 = r1 - r0
            int r0 = r1 % 128
            getSdkVersion = r0
            int r1 = r1 % 2
            r3 = 0
            if (r1 != 0) goto L_0x0014
            r1 = r3
            goto L_0x0015
        L_0x0014:
            r1 = r2
        L_0x0015:
            r4 = 0
            r5 = -1
            if (r1 == r2) goto L_0x0037
            r1 = r13 ^ 27
            r13 = r13 & 27
            int r13 = r13 << r2
            int r1 = r1 + r13
            byte[] r13 = AppsFlyerLib
            r6 = 121(0x79, float:1.7E-43)
            int r12 = r6 >>> r12
            r6 = 28897(0x70e1, float:4.0493E-41)
            int r6 = r6 % r11
            byte[] r11 = new byte[r1]
            int r1 = r1 + 107
            r7 = 76
            if (r13 != 0) goto L_0x0033
            r8 = 47
            goto L_0x0034
        L_0x0033:
            r8 = r7
        L_0x0034:
            if (r8 == r7) goto L_0x0078
            goto L_0x0062
        L_0x0037:
            r1 = r13 ^ 116(0x74, float:1.63E-43)
            r13 = r13 & 116(0x74, float:1.63E-43)
            int r13 = r13 << r2
            int r1 = r1 + r13
            r13 = r1 ^ -115(0xffffffffffffff8d, float:NaN)
            r1 = r1 & -115(0xffffffffffffff8d, float:NaN)
            int r1 = r1 << r2
            int r13 = r13 + r1
            byte[] r1 = AppsFlyerLib
            int r12 = -r12
            r6 = r12 ^ 119(0x77, float:1.67E-43)
            r12 = r12 & 119(0x77, float:1.67E-43)
            int r12 = r12 << r2
            int r12 = r12 + r6
            int r11 = -r11
            int r11 = ~r11
            int r11 = 968 - r11
            int r6 = r11 + -1
            byte[] r11 = new byte[r13]
            int r13 = r13 + r5
            r7 = 12
            if (r1 != 0) goto L_0x005c
            r8 = 61
            goto L_0x005d
        L_0x005c:
            r8 = r7
        L_0x005d:
            r9 = r1
            r1 = r13
            r13 = r9
            if (r8 == r7) goto L_0x0078
        L_0x0062:
            int r0 = r0 + 26
            int r0 = r0 - r2
            int r12 = r0 % 128
            onValidateInApp = r12
            int r0 = r0 % 2
            if (r0 == 0) goto L_0x006f
            r12 = r2
            goto L_0x0070
        L_0x006f:
            r12 = r3
        L_0x0070:
            if (r12 == r2) goto L_0x0075
            r12 = r1
            r0 = r6
            goto L_0x00a6
        L_0x0075:
            throw r4     // Catch:{ all -> 0x0076 }
        L_0x0076:
            r11 = move-exception
            throw r11
        L_0x0078:
            int r5 = r5 + r2
            byte r0 = (byte) r12
            r11[r5] = r0
            if (r5 != r1) goto L_0x009e
            java.lang.String r12 = new java.lang.String
            r12.<init>(r11, r3)
            int r11 = onValidateInApp
            r13 = r11 & 49
            r11 = r11 | 49
            int r13 = r13 + r11
            int r11 = r13 % 128
            getSdkVersion = r11
            int r13 = r13 % 2
            r11 = 82
            if (r13 != 0) goto L_0x0097
            r13 = 8
            goto L_0x0098
        L_0x0097:
            r13 = r11
        L_0x0098:
            if (r13 != r11) goto L_0x009b
            return r12
        L_0x009b:
            throw r4     // Catch:{ all -> 0x009c }
        L_0x009c:
            r11 = move-exception
            throw r11
        L_0x009e:
            byte r0 = r13[r6]
            r9 = r1
            r1 = r12
            r12 = r9
            r10 = r6
            r6 = r0
            r0 = r10
        L_0x00a6:
            int r6 = -r6
            int r0 = r0 + r2
            r7 = r1 & r6
            r1 = r1 | r6
            int r1 = r1 + r7
            r6 = r0
            r9 = r1
            r1 = r12
            r12 = r9
            goto L_0x0078
        */
        throw new UnsupportedOperationException("Method not decompiled: com.appsflyer.internal.a.$$c(short, short, byte):java.lang.String");
    }

    /*  JADX ERROR: JadxRuntimeException in pass: InitCodeVariables
        jadx.core.utils.exceptions.JadxRuntimeException: Several immutable types in one variable: [int, byte[]], vars: [r6v12 ?, r6v13 ?, r6v23 ?, r6v18 ?, r6v17 ?, r6v14 ?, r6v16 ?, r6v65 ?, r6v64 ?, r6v94 ?, r6v157 ?, r6v19 ?, r6v91 ?, r6v28 ?, r6v22 ?, r6v198 ?, r6v41 ?, r6v44 ?, r6v50 ?, r6v53 ?, r6v54 ?, r6v63 ?, r6v102 ?, r6v105 ?, r6v109 ?, r6v112 ?, r6v131 ?, r6v115 ?, r6v114 ?, r6v113 ?, r6v153 ?, r6v141 ?, r6v124 ?, r6v142 ?, r6v140 ?, r6v139 ?, r6v138 ?, r6v137 ?, r6v156 ?, r6v135 ?, r6v87 ?, r6v15 ?]
        	at jadx.core.dex.visitors.InitCodeVariables.setCodeVarType(InitCodeVariables.java:102)
        	at jadx.core.dex.visitors.InitCodeVariables.setCodeVar(InitCodeVariables.java:78)
        	at jadx.core.dex.visitors.InitCodeVariables.initCodeVar(InitCodeVariables.java:69)
        	at jadx.core.dex.visitors.InitCodeVariables.initCodeVars(InitCodeVariables.java:51)
        	at jadx.core.dex.visitors.InitCodeVariables.visit(InitCodeVariables.java:32)
        */
    static {
        /*
            java.lang.Class<byte[]> r1 = byte[].class
            java.lang.Class<java.lang.String> r2 = java.lang.String.class
            init$0()
            r3 = -146535019(0xfffffffff7440d95, float:-3.9764284E33)
            AppsFlyerConversionListener = r3
            r3 = -1109362503(0xffffffffbde078b9, float:-0.10960526)
            onValidateInAppFailure = r3
            r3 = 753(0x2f1, float:1.055E-42)
            short r3 = (short) r3
            byte[] r4 = AppsFlyerLib     // Catch:{ Exception -> 0x192d }
            r5 = 40
            byte r6 = r4[r5]     // Catch:{ Exception -> 0x192d }
            byte r6 = (byte) r6     // Catch:{ Exception -> 0x192d }
            r7 = 450(0x1c2, float:6.3E-43)
            byte r7 = r4[r7]     // Catch:{ Exception -> 0x192d }
            byte r7 = (byte) r7     // Catch:{ Exception -> 0x192d }
            java.lang.String r3 = $$c(r3, r6, r7)     // Catch:{ Exception -> 0x192d }
            java.lang.Object r6 = onDeepLinking     // Catch:{ Exception -> 0x192d }
            r7 = 0
            r8 = 1
            if (r6 != 0) goto L_0x002c
            r6 = r8
            goto L_0x002d
        L_0x002c:
            r6 = r7
        L_0x002d:
            r9 = 0
            if (r6 == r8) goto L_0x0032
            r6 = r9
            goto L_0x0044
        L_0x0032:
            r6 = 65
            byte r6 = r4[r6]     // Catch:{ Exception -> 0x192d }
            int r6 = -r6
            short r6 = (short) r6     // Catch:{ Exception -> 0x192d }
            byte r10 = r4[r5]     // Catch:{ Exception -> 0x192d }
            byte r10 = (byte) r10     // Catch:{ Exception -> 0x192d }
            r11 = 100
            byte r11 = r4[r11]     // Catch:{ Exception -> 0x192d }
            byte r11 = (byte) r11     // Catch:{ Exception -> 0x192d }
            java.lang.String r6 = $$c(r6, r10, r11)     // Catch:{ Exception -> 0x192d }
        L_0x0044:
            r10 = 6
            r11 = 571(0x23b, float:8.0E-43)
            r12 = 389(0x185, float:5.45E-43)
            r13 = 2
            int r14 = AppsFlyerInAppPurchaseValidatorListener     // Catch:{ Exception -> 0x008d }
            r15 = r14 ^ 236(0xec, float:3.31E-43)
            r14 = r14 & 236(0xec, float:3.31E-43)
            r14 = r14 | r15
            short r14 = (short) r14     // Catch:{ Exception -> 0x008d }
            byte r15 = r4[r12]     // Catch:{ Exception -> 0x008d }
            byte r15 = (byte) r15     // Catch:{ Exception -> 0x008d }
            r16 = 450(0x1c2, float:6.3E-43)
            byte r8 = r4[r16]     // Catch:{ Exception -> 0x008d }
            byte r8 = (byte) r8     // Catch:{ Exception -> 0x008d }
            java.lang.String r8 = $$c(r14, r15, r8)     // Catch:{ Exception -> 0x008d }
            java.lang.Class r8 = java.lang.Class.forName(r8)     // Catch:{ Exception -> 0x008d }
            r14 = 898(0x382, float:1.258E-42)
            short r14 = (short) r14     // Catch:{ Exception -> 0x008d }
            byte r15 = r4[r5]     // Catch:{ Exception -> 0x008d }
            byte r15 = (byte) r15     // Catch:{ Exception -> 0x008d }
            r16 = 139(0x8b, float:1.95E-43)
            byte r4 = r4[r16]     // Catch:{ Exception -> 0x008d }
            byte r4 = (byte) r4     // Catch:{ Exception -> 0x008d }
            java.lang.String r4 = $$c(r14, r15, r4)     // Catch:{ Exception -> 0x008d }
            java.lang.Class[] r14 = new java.lang.Class[r7]     // Catch:{ Exception -> 0x008d }
            java.lang.reflect.Method r4 = r8.getMethod(r4, r14)     // Catch:{ Exception -> 0x008d }
            java.lang.Object r4 = r4.invoke(r9, r9)     // Catch:{ Exception -> 0x008d }
            if (r4 == 0) goto L_0x008e
            int r8 = onValidateInApp
            int r8 = r8 + 49
            int r14 = r8 % 128
            getSdkVersion = r14
            int r8 = r8 % r13
            if (r8 == 0) goto L_0x0089
            goto L_0x00b8
        L_0x0089:
            throw r9     // Catch:{ Exception -> 0x008e, all -> 0x008a }
        L_0x008a:
            r0 = move-exception
            r1 = r0
            throw r1
        L_0x008d:
            r4 = r9
        L_0x008e:
            r8 = 549(0x225, float:7.7E-43)
            short r8 = (short) r8
            byte[] r14 = AppsFlyerLib     // Catch:{ Exception -> 0x00b8 }
            byte r15 = r14[r12]     // Catch:{ Exception -> 0x00b8 }
            byte r15 = (byte) r15     // Catch:{ Exception -> 0x00b8 }
            byte r12 = r14[r10]     // Catch:{ Exception -> 0x00b8 }
            byte r12 = (byte) r12     // Catch:{ Exception -> 0x00b8 }
            java.lang.String r8 = $$c(r8, r15, r12)     // Catch:{ Exception -> 0x00b8 }
            java.lang.Class r8 = java.lang.Class.forName(r8)     // Catch:{ Exception -> 0x00b8 }
            r12 = 132(0x84, float:1.85E-43)
            short r12 = (short) r12     // Catch:{ Exception -> 0x00b8 }
            byte r15 = r14[r11]     // Catch:{ Exception -> 0x00b8 }
            byte r15 = (byte) r15     // Catch:{ Exception -> 0x00b8 }
            byte r14 = r14[r5]     // Catch:{ Exception -> 0x00b8 }
            byte r14 = (byte) r14     // Catch:{ Exception -> 0x00b8 }
            java.lang.String r12 = $$c(r12, r15, r14)     // Catch:{ Exception -> 0x00b8 }
            java.lang.Class[] r14 = new java.lang.Class[r7]     // Catch:{ Exception -> 0x00b8 }
            java.lang.reflect.Method r8 = r8.getMethod(r12, r14)     // Catch:{ Exception -> 0x00b8 }
            java.lang.Object r4 = r8.invoke(r9, r9)     // Catch:{ Exception -> 0x00b8 }
        L_0x00b8:
            if (r4 == 0) goto L_0x00d8
            java.lang.Class r8 = r4.getClass()     // Catch:{ Exception -> 0x00d8 }
            r12 = 728(0x2d8, float:1.02E-42)
            short r12 = (short) r12     // Catch:{ Exception -> 0x00d8 }
            byte[] r14 = AppsFlyerLib     // Catch:{ Exception -> 0x00d8 }
            byte r15 = r14[r11]     // Catch:{ Exception -> 0x00d8 }
            byte r15 = (byte) r15     // Catch:{ Exception -> 0x00d8 }
            r18 = 88
            byte r14 = r14[r18]     // Catch:{ Exception -> 0x00d8 }
            byte r14 = (byte) r14     // Catch:{ Exception -> 0x00d8 }
            java.lang.String r12 = $$c(r12, r15, r14)     // Catch:{ Exception -> 0x00d8 }
            java.lang.reflect.Method r8 = r8.getMethod(r12, r9)     // Catch:{ Exception -> 0x00d8 }
            java.lang.Object r8 = r8.invoke(r4, r9)     // Catch:{ Exception -> 0x00d8 }
            goto L_0x00d9
        L_0x00d8:
            r8 = r9
        L_0x00d9:
            if (r4 == 0) goto L_0x012b
            int r12 = onValidateInApp
            r14 = r12 & 1
            r15 = 1
            r12 = r12 | r15
            int r14 = r14 + r12
            int r12 = r14 % 128
            getSdkVersion = r12
            int r14 = r14 % r13
            if (r14 != 0) goto L_0x010f
            java.lang.Class r12 = r4.getClass()     // Catch:{ Exception -> 0x012b }
            int r14 = AppsFlyerInAppPurchaseValidatorListener     // Catch:{ Exception -> 0x012b }
            r15 = r14 & 30123(0x75ab, float:4.2211E-41)
            int r15 = ~r15     // Catch:{ Exception -> 0x012b }
            r14 = r14 | 30123(0x75ab, float:4.2211E-41)
            r14 = r14 & r15
            short r14 = (short) r14     // Catch:{ Exception -> 0x012b }
            byte[] r15 = AppsFlyerLib     // Catch:{ Exception -> 0x012b }
            r18 = 4008(0xfa8, float:5.616E-42)
            byte r10 = r15[r18]     // Catch:{ Exception -> 0x012b }
            byte r10 = (byte) r10     // Catch:{ Exception -> 0x012b }
            r18 = 25377(0x6321, float:3.5561E-41)
            byte r15 = r15[r18]     // Catch:{ Exception -> 0x012b }
            byte r15 = (byte) r15     // Catch:{ Exception -> 0x012b }
            java.lang.String r10 = $$c(r14, r10, r15)     // Catch:{ Exception -> 0x012b }
            java.lang.reflect.Method r10 = r12.getMethod(r10, r9)     // Catch:{ Exception -> 0x012b }
        L_0x010a:
            java.lang.Object r10 = r10.invoke(r4, r9)     // Catch:{ Exception -> 0x012b }
            goto L_0x012c
        L_0x010f:
            java.lang.Class r10 = r4.getClass()     // Catch:{ Exception -> 0x012b }
            int r12 = AppsFlyerInAppPurchaseValidatorListener     // Catch:{ Exception -> 0x012b }
            r12 = r12 | 632(0x278, float:8.86E-43)
            short r12 = (short) r12     // Catch:{ Exception -> 0x012b }
            byte[] r14 = AppsFlyerLib     // Catch:{ Exception -> 0x012b }
            byte r15 = r14[r11]     // Catch:{ Exception -> 0x012b }
            byte r15 = (byte) r15     // Catch:{ Exception -> 0x012b }
            r18 = 203(0xcb, float:2.84E-43)
            byte r14 = r14[r18]     // Catch:{ Exception -> 0x012b }
            byte r14 = (byte) r14     // Catch:{ Exception -> 0x012b }
            java.lang.String r12 = $$c(r12, r15, r14)     // Catch:{ Exception -> 0x012b }
            java.lang.reflect.Method r10 = r10.getMethod(r12, r9)     // Catch:{ Exception -> 0x012b }
            goto L_0x010a
        L_0x012b:
            r10 = r9
        L_0x012c:
            if (r4 == 0) goto L_0x0131
            r12 = 53
            goto L_0x0132
        L_0x0131:
            r12 = 7
        L_0x0132:
            r14 = 53
            if (r12 == r14) goto L_0x0137
            goto L_0x0160
        L_0x0137:
            int r12 = getSdkVersion
            int r12 = r12 + 58
            r14 = 1
            int r12 = r12 - r14
            int r14 = r12 % 128
            onValidateInApp = r14
            int r12 = r12 % r13
            java.lang.Class r12 = r4.getClass()     // Catch:{ Exception -> 0x0160 }
            r14 = 708(0x2c4, float:9.92E-43)
            short r14 = (short) r14     // Catch:{ Exception -> 0x0160 }
            byte[] r15 = AppsFlyerLib     // Catch:{ Exception -> 0x0160 }
            byte r13 = r15[r11]     // Catch:{ Exception -> 0x0160 }
            byte r13 = (byte) r13     // Catch:{ Exception -> 0x0160 }
            r19 = 88
            byte r15 = r15[r19]     // Catch:{ Exception -> 0x0160 }
            byte r15 = (byte) r15     // Catch:{ Exception -> 0x0160 }
            java.lang.String r13 = $$c(r14, r13, r15)     // Catch:{ Exception -> 0x0160 }
            java.lang.reflect.Method r12 = r12.getMethod(r13, r9)     // Catch:{ Exception -> 0x0160 }
            java.lang.Object r4 = r12.invoke(r4, r9)     // Catch:{ Exception -> 0x0160 }
            goto L_0x0161
        L_0x0160:
            r4 = r9
        L_0x0161:
            r12 = 60
            r13 = 17
            if (r8 == 0) goto L_0x0168
            goto L_0x01c2
        L_0x0168:
            if (r6 != 0) goto L_0x016d
            r8 = 55
            goto L_0x016f
        L_0x016d:
            r8 = 9
        L_0x016f:
            r14 = 55
            if (r8 == r14) goto L_0x01c1
            java.lang.StringBuilder r8 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x192d }
            r8.<init>()     // Catch:{ Exception -> 0x192d }
            r14 = 354(0x162, float:4.96E-43)
            short r14 = (short) r14     // Catch:{ Exception -> 0x192d }
            r15 = 72
            byte r15 = (byte) r15     // Catch:{ Exception -> 0x192d }
            byte[] r19 = AppsFlyerLib     // Catch:{ Exception -> 0x192d }
            r20 = 88
            byte r5 = r19[r20]     // Catch:{ Exception -> 0x192d }
            byte r5 = (byte) r5     // Catch:{ Exception -> 0x192d }
            java.lang.String r5 = $$c(r14, r15, r5)     // Catch:{ Exception -> 0x192d }
            r8.append(r5)     // Catch:{ Exception -> 0x192d }
            r8.append(r6)     // Catch:{ Exception -> 0x192d }
            java.lang.String r5 = r8.toString()     // Catch:{ Exception -> 0x192d }
            r6 = 1
            java.lang.Object[] r8 = new java.lang.Object[r6]     // Catch:{ all -> 0x01b7 }
            r8[r7] = r5     // Catch:{ all -> 0x01b7 }
            r5 = 112(0x70, float:1.57E-43)
            short r5 = (short) r5     // Catch:{ all -> 0x01b7 }
            byte r6 = r19[r13]     // Catch:{ all -> 0x01b7 }
            byte r6 = (byte) r6     // Catch:{ all -> 0x01b7 }
            byte r14 = r19[r12]     // Catch:{ all -> 0x01b7 }
            byte r14 = (byte) r14     // Catch:{ all -> 0x01b7 }
            java.lang.String r5 = $$c(r5, r6, r14)     // Catch:{ all -> 0x01b7 }
            java.lang.Class r5 = java.lang.Class.forName(r5)     // Catch:{ all -> 0x01b7 }
            r6 = 1
            java.lang.Class[] r14 = new java.lang.Class[r6]     // Catch:{ all -> 0x01b7 }
            r14[r7] = r2     // Catch:{ all -> 0x01b7 }
            java.lang.reflect.Constructor r5 = r5.getDeclaredConstructor(r14)     // Catch:{ all -> 0x01b7 }
            java.lang.Object r8 = r5.newInstance(r8)     // Catch:{ all -> 0x01b7 }
            goto L_0x01c2
        L_0x01b7:
            r0 = move-exception
            r1 = r0
            java.lang.Throwable r2 = r1.getCause()     // Catch:{ Exception -> 0x192d }
            if (r2 == 0) goto L_0x01c0
            throw r2     // Catch:{ Exception -> 0x192d }
        L_0x01c0:
            throw r1     // Catch:{ Exception -> 0x192d }
        L_0x01c1:
            r8 = r9
        L_0x01c2:
            if (r4 == 0) goto L_0x01c5
            goto L_0x022a
        L_0x01c5:
            r4 = 276(0x114, float:3.87E-43)
            short r4 = (short) r4     // Catch:{ Exception -> 0x192d }
            byte[] r5 = AppsFlyerLib     // Catch:{ Exception -> 0x192d }
            byte r6 = r5[r13]     // Catch:{ Exception -> 0x192d }
            byte r6 = (byte) r6     // Catch:{ Exception -> 0x192d }
            byte r14 = (byte) r6     // Catch:{ Exception -> 0x192d }
            java.lang.String r4 = $$c(r4, r6, r14)     // Catch:{ Exception -> 0x192d }
            r6 = 1
            java.lang.Object[] r14 = new java.lang.Object[r6]     // Catch:{ all -> 0x1923 }
            r14[r7] = r4     // Catch:{ all -> 0x1923 }
            r4 = 913(0x391, float:1.28E-42)
            short r4 = (short) r4     // Catch:{ all -> 0x1923 }
            byte r6 = r5[r13]     // Catch:{ all -> 0x1923 }
            byte r6 = (byte) r6     // Catch:{ all -> 0x1923 }
            r15 = 13
            byte r15 = r5[r15]     // Catch:{ all -> 0x1923 }
            byte r15 = (byte) r15     // Catch:{ all -> 0x1923 }
            java.lang.String r4 = $$c(r4, r6, r15)     // Catch:{ all -> 0x1923 }
            java.lang.Class r4 = java.lang.Class.forName(r4)     // Catch:{ all -> 0x1923 }
            int r6 = AppsFlyerInAppPurchaseValidatorListener     // Catch:{ all -> 0x1923 }
            r6 = r6 | 260(0x104, float:3.64E-43)
            short r6 = (short) r6     // Catch:{ all -> 0x1923 }
            byte r15 = r5[r11]     // Catch:{ all -> 0x1923 }
            byte r15 = (byte) r15     // Catch:{ all -> 0x1923 }
            r19 = 88
            byte r11 = r5[r19]     // Catch:{ all -> 0x1923 }
            byte r11 = (byte) r11     // Catch:{ all -> 0x1923 }
            java.lang.String r6 = $$c(r6, r15, r11)     // Catch:{ all -> 0x1923 }
            r11 = 1
            java.lang.Class[] r15 = new java.lang.Class[r11]     // Catch:{ all -> 0x1923 }
            r15[r7] = r2     // Catch:{ all -> 0x1923 }
            java.lang.reflect.Method r4 = r4.getMethod(r6, r15)     // Catch:{ all -> 0x1923 }
            java.lang.Object r4 = r4.invoke(r9, r14)     // Catch:{ all -> 0x1923 }
            java.lang.Object[] r6 = new java.lang.Object[r11]     // Catch:{ all -> 0x1919 }
            r6[r7] = r4     // Catch:{ all -> 0x1919 }
            r4 = 112(0x70, float:1.57E-43)
            short r4 = (short) r4     // Catch:{ all -> 0x1919 }
            byte r11 = r5[r13]     // Catch:{ all -> 0x1919 }
            byte r11 = (byte) r11     // Catch:{ all -> 0x1919 }
            byte r5 = r5[r12]     // Catch:{ all -> 0x1919 }
            byte r5 = (byte) r5     // Catch:{ all -> 0x1919 }
            java.lang.String r4 = $$c(r4, r11, r5)     // Catch:{ all -> 0x1919 }
            java.lang.Class r4 = java.lang.Class.forName(r4)     // Catch:{ all -> 0x1919 }
            r5 = 1
            java.lang.Class[] r11 = new java.lang.Class[r5]     // Catch:{ all -> 0x1919 }
            r11[r7] = r2     // Catch:{ all -> 0x1919 }
            java.lang.reflect.Constructor r4 = r4.getDeclaredConstructor(r11)     // Catch:{ all -> 0x1919 }
            java.lang.Object r4 = r4.newInstance(r6)     // Catch:{ all -> 0x1919 }
        L_0x022a:
            r5 = 4
            if (r10 != 0) goto L_0x028c
            if (r8 == 0) goto L_0x0231
            r6 = 1
            goto L_0x0232
        L_0x0231:
            r6 = r7
        L_0x0232:
            if (r6 == 0) goto L_0x028c
            int r6 = AppsFlyerInAppPurchaseValidatorListener     // Catch:{ Exception -> 0x192d }
            r10 = r6 ^ 672(0x2a0, float:9.42E-43)
            r6 = r6 & 672(0x2a0, float:9.42E-43)
            r6 = r6 | r10
            short r6 = (short) r6     // Catch:{ Exception -> 0x192d }
            byte[] r10 = AppsFlyerLib     // Catch:{ Exception -> 0x192d }
            r11 = 40
            byte r14 = r10[r11]     // Catch:{ Exception -> 0x192d }
            byte r11 = (byte) r14     // Catch:{ Exception -> 0x192d }
            byte r14 = r10[r5]     // Catch:{ Exception -> 0x192d }
            byte r14 = (byte) r14     // Catch:{ Exception -> 0x192d }
            java.lang.String r6 = $$c(r6, r11, r14)     // Catch:{ Exception -> 0x192d }
            r11 = 2
            java.lang.Object[] r14 = new java.lang.Object[r11]     // Catch:{ all -> 0x0282 }
            r11 = 1
            r14[r11] = r6     // Catch:{ all -> 0x0282 }
            r14[r7] = r8     // Catch:{ all -> 0x0282 }
            r6 = 112(0x70, float:1.57E-43)
            short r6 = (short) r6     // Catch:{ all -> 0x0282 }
            byte r11 = r10[r13]     // Catch:{ all -> 0x0282 }
            byte r11 = (byte) r11     // Catch:{ all -> 0x0282 }
            byte r15 = r10[r12]     // Catch:{ all -> 0x0282 }
            byte r15 = (byte) r15     // Catch:{ all -> 0x0282 }
            java.lang.String r11 = $$c(r6, r11, r15)     // Catch:{ all -> 0x0282 }
            java.lang.Class r11 = java.lang.Class.forName(r11)     // Catch:{ all -> 0x0282 }
            r15 = 2
            java.lang.Class[] r5 = new java.lang.Class[r15]     // Catch:{ all -> 0x0282 }
            byte r15 = r10[r13]     // Catch:{ all -> 0x0282 }
            byte r15 = (byte) r15     // Catch:{ all -> 0x0282 }
            byte r10 = r10[r12]     // Catch:{ all -> 0x0282 }
            byte r10 = (byte) r10     // Catch:{ all -> 0x0282 }
            java.lang.String r6 = $$c(r6, r15, r10)     // Catch:{ all -> 0x0282 }
            java.lang.Class r6 = java.lang.Class.forName(r6)     // Catch:{ all -> 0x0282 }
            r5[r7] = r6     // Catch:{ all -> 0x0282 }
            r6 = 1
            r5[r6] = r2     // Catch:{ all -> 0x0282 }
            java.lang.reflect.Constructor r5 = r11.getDeclaredConstructor(r5)     // Catch:{ all -> 0x0282 }
            java.lang.Object r10 = r5.newInstance(r14)     // Catch:{ all -> 0x0282 }
            goto L_0x028c
        L_0x0282:
            r0 = move-exception
            r1 = r0
            java.lang.Throwable r2 = r1.getCause()     // Catch:{ Exception -> 0x192d }
            if (r2 == 0) goto L_0x028b
            throw r2     // Catch:{ Exception -> 0x192d }
        L_0x028b:
            throw r1     // Catch:{ Exception -> 0x192d }
        L_0x028c:
            int r5 = getSdkVersion
            r6 = r5 & 87
            r5 = r5 | 87
            int r6 = r6 + r5
            int r5 = r6 % 128
            onValidateInApp = r5
            r5 = 2
            int r6 = r6 % r5
            r5 = 421(0x1a5, float:5.9E-43)
            short r5 = (short) r5
            byte[] r6 = AppsFlyerLib     // Catch:{ all -> 0x190f }
            r11 = 389(0x185, float:5.45E-43)
            byte r14 = r6[r11]     // Catch:{ all -> 0x190f }
            byte r11 = (byte) r14     // Catch:{ all -> 0x190f }
            r14 = 6
            byte r15 = r6[r14]     // Catch:{ all -> 0x190f }
            byte r14 = (byte) r15     // Catch:{ all -> 0x190f }
            java.lang.String r5 = $$c(r5, r11, r14)     // Catch:{ all -> 0x190f }
            java.lang.Class r5 = java.lang.Class.forName(r5)     // Catch:{ all -> 0x190f }
            r11 = 528(0x210, float:7.4E-43)
            short r11 = (short) r11     // Catch:{ all -> 0x190f }
            r14 = 571(0x23b, float:8.0E-43)
            byte r15 = r6[r14]     // Catch:{ all -> 0x190f }
            byte r14 = (byte) r15     // Catch:{ all -> 0x190f }
            r15 = r14 ^ 10
            r21 = r14 & 10
            r15 = r15 | r21
            byte r15 = (byte) r15     // Catch:{ all -> 0x190f }
            java.lang.String r11 = $$c(r11, r14, r15)     // Catch:{ all -> 0x190f }
            java.lang.reflect.Method r5 = r5.getMethod(r11, r9)     // Catch:{ all -> 0x190f }
            java.lang.Object r5 = r5.invoke(r9, r9)     // Catch:{ all -> 0x190f }
            r11 = 9
            r14 = 112(0x70, float:1.57E-43)
            short r14 = (short) r14
            byte r15 = r6[r13]     // Catch:{ Exception -> 0x192d }
            byte r15 = (byte) r15     // Catch:{ Exception -> 0x192d }
            byte r13 = r6[r12]     // Catch:{ Exception -> 0x192d }
            byte r13 = (byte) r13     // Catch:{ Exception -> 0x192d }
            java.lang.String r13 = $$c(r14, r15, r13)     // Catch:{ Exception -> 0x192d }
            java.lang.Class r13 = java.lang.Class.forName(r13)     // Catch:{ Exception -> 0x192d }
            java.lang.Object r11 = java.lang.reflect.Array.newInstance(r13, r11)     // Catch:{ Exception -> 0x192d }
            java.lang.Object[] r11 = (java.lang.Object[]) r11     // Catch:{ Exception -> 0x192d }
            r11[r7] = r9     // Catch:{ Exception -> 0x192d }
            r13 = 1
            r11[r13] = r10     // Catch:{ Exception -> 0x192d }
            r13 = 2
            r11[r13] = r8     // Catch:{ Exception -> 0x192d }
            r13 = 3
            r11[r13] = r4     // Catch:{ Exception -> 0x192d }
            r15 = 4
            r11[r15] = r5     // Catch:{ Exception -> 0x192d }
            r15 = 5
            r11[r15] = r10     // Catch:{ Exception -> 0x192d }
            r10 = 6
            r11[r10] = r8     // Catch:{ Exception -> 0x192d }
            r8 = 7
            r11[r8] = r4     // Catch:{ Exception -> 0x192d }
            r4 = 8
            r11[r4] = r5     // Catch:{ Exception -> 0x192d }
            r4 = 9
            boolean[] r4 = new boolean[r4]     // Catch:{ Exception -> 0x192d }
            r4[r7] = r7     // Catch:{ Exception -> 0x192d }
            r5 = 1
            r4[r5] = r5     // Catch:{ Exception -> 0x192d }
            r8 = 2
            r4[r8] = r5     // Catch:{ Exception -> 0x192d }
            r4[r13] = r5     // Catch:{ Exception -> 0x192d }
            r8 = 4
            r4[r8] = r5     // Catch:{ Exception -> 0x192d }
            r4[r15] = r5     // Catch:{ Exception -> 0x192d }
            r8 = 6
            r4[r8] = r5     // Catch:{ Exception -> 0x192d }
            r8 = 7
            r4[r8] = r5     // Catch:{ Exception -> 0x192d }
            r8 = 8
            r4[r8] = r5     // Catch:{ Exception -> 0x192d }
            r8 = 9
            boolean[] r8 = new boolean[r8]     // Catch:{ Exception -> 0x192d }
            r8[r7] = r7     // Catch:{ Exception -> 0x192d }
            r8[r5] = r7     // Catch:{ Exception -> 0x192d }
            r10 = 2
            r8[r10] = r7     // Catch:{ Exception -> 0x192d }
            r8[r13] = r7     // Catch:{ Exception -> 0x192d }
            r10 = 4
            r8[r10] = r7     // Catch:{ Exception -> 0x192d }
            r8[r15] = r5     // Catch:{ Exception -> 0x192d }
            r10 = 6
            r8[r10] = r5     // Catch:{ Exception -> 0x192d }
            r10 = 7
            r8[r10] = r5     // Catch:{ Exception -> 0x192d }
            r10 = 8
            r8[r10] = r5     // Catch:{ Exception -> 0x192d }
            r10 = 9
            boolean[] r9 = new boolean[r10]     // Catch:{ Exception -> 0x192d }
            r9[r7] = r7     // Catch:{ Exception -> 0x192d }
            r9[r5] = r7     // Catch:{ Exception -> 0x192d }
            r17 = 2
            r9[r17] = r5     // Catch:{ Exception -> 0x192d }
            r9[r13] = r5     // Catch:{ Exception -> 0x192d }
            r17 = 4
            r9[r17] = r7     // Catch:{ Exception -> 0x192d }
            r9[r15] = r7     // Catch:{ Exception -> 0x192d }
            r17 = 6
            r9[r17] = r5     // Catch:{ Exception -> 0x192d }
            r17 = 7
            r9[r17] = r5     // Catch:{ Exception -> 0x192d }
            r5 = 8
            r9[r5] = r7     // Catch:{ Exception -> 0x192d }
            r5 = 846(0x34e, float:1.185E-42)
            short r5 = (short) r5
            r22 = 367(0x16f, float:5.14E-43)
            r16 = 389(0x185, float:5.45E-43)
            byte r10 = r6[r16]     // Catch:{ ClassNotFoundException -> 0x03c7 }
            byte r10 = (byte) r10     // Catch:{ ClassNotFoundException -> 0x03c7 }
            byte r13 = r6[r22]     // Catch:{ ClassNotFoundException -> 0x03c7 }
            byte r13 = (byte) r13     // Catch:{ ClassNotFoundException -> 0x03c7 }
            java.lang.String r5 = $$c(r5, r10, r13)     // Catch:{ ClassNotFoundException -> 0x03c7 }
            java.lang.Class r5 = java.lang.Class.forName(r5)     // Catch:{ ClassNotFoundException -> 0x03c7 }
            int r10 = AppsFlyerInAppPurchaseValidatorListener     // Catch:{ ClassNotFoundException -> 0x03c7 }
            r13 = r10 ^ 332(0x14c, float:4.65E-43)
            r10 = r10 & 332(0x14c, float:4.65E-43)
            r10 = r10 | r13
            short r10 = (short) r10     // Catch:{ ClassNotFoundException -> 0x03c7 }
            r13 = 156(0x9c, float:2.19E-43)
            byte r13 = r6[r13]     // Catch:{ ClassNotFoundException -> 0x03c7 }
            byte r13 = (byte) r13     // Catch:{ ClassNotFoundException -> 0x03c7 }
            r24 = 66
            byte r6 = r6[r24]     // Catch:{ ClassNotFoundException -> 0x03c7 }
            byte r6 = (byte) r6     // Catch:{ ClassNotFoundException -> 0x03c7 }
            java.lang.String r6 = $$c(r10, r13, r6)     // Catch:{ ClassNotFoundException -> 0x03c7 }
            java.lang.reflect.Field r6 = r5.getDeclaredField(r6)     // Catch:{ ClassNotFoundException -> 0x03c7 }
            int r5 = r6.getInt(r5)     // Catch:{ ClassNotFoundException -> 0x03c7 }
            r6 = 26
            if (r5 < r6) goto L_0x0390
            r6 = 1
            goto L_0x0391
        L_0x0390:
            r6 = r7
        L_0x0391:
            r9[r7] = r6     // Catch:{ ClassNotFoundException -> 0x03c7 }
            r6 = 21
            if (r5 < r6) goto L_0x039a
            r6 = 65
            goto L_0x039c
        L_0x039a:
            r6 = 34
        L_0x039c:
            r10 = 34
            if (r6 == r10) goto L_0x03a4
            r6 = 1
            r17 = 1
            goto L_0x03a7
        L_0x03a4:
            r17 = r7
            r6 = 1
        L_0x03a7:
            r9[r6] = r17     // Catch:{ ClassNotFoundException -> 0x03c7 }
            r6 = 21
            if (r5 < r6) goto L_0x03af
            r6 = 1
            goto L_0x03b0
        L_0x03af:
            r6 = r7
        L_0x03b0:
            r9[r15] = r6     // Catch:{ ClassNotFoundException -> 0x03c7 }
            r6 = 16
            if (r5 >= r6) goto L_0x03b8
            r6 = 1
            goto L_0x03b9
        L_0x03b8:
            r6 = r7
        L_0x03b9:
            r10 = 4
            r9[r10] = r6     // Catch:{ ClassNotFoundException -> 0x03c7 }
            r6 = 8
            r10 = 16
            if (r5 >= r10) goto L_0x03c4
            r5 = 1
            goto L_0x03c5
        L_0x03c4:
            r5 = r7
        L_0x03c5:
            r9[r6] = r5     // Catch:{ ClassNotFoundException -> 0x03c7 }
        L_0x03c7:
            int r5 = onValidateInApp
            r6 = r5 ^ 7
            r5 = r5 & 7
            r10 = 1
            int r5 = r5 << r10
            int r6 = r6 + r5
            int r5 = r6 % 128
            getSdkVersion = r5
            r5 = 2
            int r6 = r6 % r5
            r5 = r7
            r6 = r5
        L_0x03d8:
            if (r5 != 0) goto L_0x190e
            r10 = 9
            if (r6 >= r10) goto L_0x190e
            boolean r10 = r9[r6]     // Catch:{ Exception -> 0x192d }
            if (r10 == 0) goto L_0x18d3
            boolean r13 = r4[r6]     // Catch:{ all -> 0x1843 }
            r15 = r11[r6]     // Catch:{ all -> 0x1843 }
            boolean r25 = r8[r6]     // Catch:{ all -> 0x1843 }
            r26 = 28
            if (r13 == 0) goto L_0x04db
            if (r15 == 0) goto L_0x03f1
            r27 = 76
            goto L_0x03f3
        L_0x03f1:
            r27 = 48
        L_0x03f3:
            r7 = r27
            r10 = 76
            if (r7 != r10) goto L_0x0451
            int r7 = getSdkVersion
            int r7 = r7 + 77
            int r10 = r7 % 128
            onValidateInApp = r10
            r10 = 2
            int r7 = r7 % r10
            byte[] r7 = AppsFlyerLib     // Catch:{ all -> 0x0443 }
            r10 = 17
            byte r12 = r7[r10]     // Catch:{ all -> 0x0443 }
            byte r10 = (byte) r12
            r29 = r3
            r12 = 60
            byte r3 = r7[r12]     // Catch:{ all -> 0x0441 }
            byte r3 = (byte) r3     // Catch:{ all -> 0x0441 }
            java.lang.String r3 = $$c(r14, r10, r3)     // Catch:{ all -> 0x0441 }
            java.lang.Class r3 = java.lang.Class.forName(r3)     // Catch:{ all -> 0x0441 }
            r10 = 185(0xb9, float:2.59E-43)
            short r10 = (short) r10
            r30 = r4
            r12 = 40
            byte r4 = r7[r12]     // Catch:{ all -> 0x043f }
            byte r4 = (byte) r4     // Catch:{ all -> 0x043f }
            r12 = 62
            byte r7 = r7[r12]     // Catch:{ all -> 0x043f }
            byte r7 = (byte) r7     // Catch:{ all -> 0x043f }
            java.lang.String r4 = $$c(r10, r4, r7)     // Catch:{ all -> 0x043f }
            r7 = 0
            java.lang.reflect.Method r3 = r3.getMethod(r4, r7)     // Catch:{ all -> 0x043f }
            java.lang.Object r3 = r3.invoke(r15, r7)     // Catch:{ all -> 0x043f }
            java.lang.Boolean r3 = (java.lang.Boolean) r3     // Catch:{ all -> 0x043f }
            boolean r3 = r3.booleanValue()     // Catch:{ all -> 0x043f }
            if (r3 == 0) goto L_0x0455
            goto L_0x04df
        L_0x043f:
            r0 = move-exception
            goto L_0x0448
        L_0x0441:
            r0 = move-exception
            goto L_0x0446
        L_0x0443:
            r0 = move-exception
            r29 = r3
        L_0x0446:
            r30 = r4
        L_0x0448:
            r3 = r0
            java.lang.Throwable r4 = r3.getCause()     // Catch:{ all -> 0x04cc }
            if (r4 == 0) goto L_0x0450
            throw r4     // Catch:{ all -> 0x04cc }
        L_0x0450:
            throw r3     // Catch:{ all -> 0x04cc }
        L_0x0451:
            r29 = r3
            r30 = r4
        L_0x0455:
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x04cc }
            r3.<init>()     // Catch:{ all -> 0x04cc }
            r4 = 581(0x245, float:8.14E-43)
            short r4 = (short) r4     // Catch:{ all -> 0x04cc }
            byte[] r7 = AppsFlyerLib     // Catch:{ all -> 0x04cc }
            r10 = 289(0x121, float:4.05E-43)
            byte r10 = r7[r10]     // Catch:{ all -> 0x04cc }
            byte r10 = (byte) r10     // Catch:{ all -> 0x04cc }
            byte r12 = r7[r26]     // Catch:{ all -> 0x04cc }
            byte r12 = (byte) r12     // Catch:{ all -> 0x04cc }
            java.lang.String r4 = $$c(r4, r10, r12)     // Catch:{ all -> 0x04cc }
            r3.append(r4)     // Catch:{ all -> 0x04cc }
            r3.append(r15)     // Catch:{ all -> 0x04cc }
            int r4 = AppsFlyerInAppPurchaseValidatorListener     // Catch:{ all -> 0x04cc }
            r10 = r4 ^ 692(0x2b4, float:9.7E-43)
            r4 = r4 & 692(0x2b4, float:9.7E-43)
            r4 = r4 | r10
            short r4 = (short) r4     // Catch:{ all -> 0x04cc }
            r10 = 371(0x173, float:5.2E-43)
            byte r10 = r7[r10]     // Catch:{ all -> 0x04cc }
            r12 = r10 | -1
            r13 = 1
            int r12 = r12 << r13
            r10 = r10 ^ -1
            int r12 = r12 - r10
            byte r10 = (byte) r12     // Catch:{ all -> 0x04cc }
            r12 = 14
            byte r12 = r7[r12]     // Catch:{ all -> 0x04cc }
            byte r12 = (byte) r12     // Catch:{ all -> 0x04cc }
            java.lang.String r4 = $$c(r4, r10, r12)     // Catch:{ all -> 0x04cc }
            r3.append(r4)     // Catch:{ all -> 0x04cc }
            java.lang.String r3 = r3.toString()     // Catch:{ all -> 0x04cc }
            r4 = 1
            java.lang.Object[] r10 = new java.lang.Object[r4]     // Catch:{ all -> 0x04c2 }
            r4 = 0
            r10[r4] = r3     // Catch:{ all -> 0x04c2 }
            r3 = 178(0xb2, float:2.5E-43)
            short r3 = (short) r3     // Catch:{ all -> 0x04c2 }
            r4 = 17
            byte r12 = r7[r4]     // Catch:{ all -> 0x04c2 }
            byte r4 = (byte) r12     // Catch:{ all -> 0x04c2 }
            r12 = 70
            byte r7 = r7[r12]     // Catch:{ all -> 0x04c2 }
            int r7 = -r7
            byte r7 = (byte) r7     // Catch:{ all -> 0x04c2 }
            java.lang.String r3 = $$c(r3, r4, r7)     // Catch:{ all -> 0x04c2 }
            java.lang.Class r3 = java.lang.Class.forName(r3)     // Catch:{ all -> 0x04c2 }
            r4 = 1
            java.lang.Class[] r7 = new java.lang.Class[r4]     // Catch:{ all -> 0x04c2 }
            r4 = 0
            r7[r4] = r2     // Catch:{ all -> 0x04c2 }
            java.lang.reflect.Constructor r3 = r3.getDeclaredConstructor(r7)     // Catch:{ all -> 0x04c2 }
            java.lang.Object r3 = r3.newInstance(r10)     // Catch:{ all -> 0x04c2 }
            java.lang.Throwable r3 = (java.lang.Throwable) r3     // Catch:{ all -> 0x04c2 }
            throw r3     // Catch:{ all -> 0x04c2 }
        L_0x04c2:
            r0 = move-exception
            r3 = r0
            java.lang.Throwable r4 = r3.getCause()     // Catch:{ all -> 0x04cc }
            if (r4 == 0) goto L_0x04cb
            throw r4     // Catch:{ all -> 0x04cc }
        L_0x04cb:
            throw r3     // Catch:{ all -> 0x04cc }
        L_0x04cc:
            r0 = move-exception
            r48 = r2
            r31 = r5
            r40 = r6
            r35 = r8
            r39 = r9
            r34 = r11
            goto L_0x0887
        L_0x04db:
            r29 = r3
            r30 = r4
        L_0x04df:
            if (r13 == 0) goto L_0x088c
            java.util.Random r3 = new java.util.Random     // Catch:{ all -> 0x087a }
            r3.<init>()     // Catch:{ all -> 0x087a }
            r4 = 913(0x391, float:1.28E-42)
            short r4 = (short) r4
            byte[] r7 = AppsFlyerLib     // Catch:{ all -> 0x0868 }
            r10 = 17
            byte r12 = r7[r10]     // Catch:{ all -> 0x0868 }
            byte r10 = (byte) r12     // Catch:{ all -> 0x0868 }
            r12 = 13
            byte r12 = r7[r12]     // Catch:{ all -> 0x0868 }
            byte r12 = (byte) r12     // Catch:{ all -> 0x0868 }
            java.lang.String r4 = $$c(r4, r10, r12)     // Catch:{ all -> 0x0868 }
            java.lang.Class r4 = java.lang.Class.forName(r4)     // Catch:{ all -> 0x0868 }
            r10 = 97
            short r10 = (short) r10
            r31 = r5
            r12 = 40
            byte r5 = r7[r12]     // Catch:{ all -> 0x0866 }
            byte r5 = (byte) r5     // Catch:{ all -> 0x0866 }
            r12 = 571(0x23b, float:8.0E-43)
            byte r7 = r7[r12]     // Catch:{ all -> 0x0866 }
            byte r7 = (byte) r7     // Catch:{ all -> 0x0866 }
            java.lang.String r5 = $$c(r10, r5, r7)     // Catch:{ all -> 0x0866 }
            r7 = 0
            java.lang.reflect.Method r4 = r4.getMethod(r5, r7)     // Catch:{ all -> 0x0866 }
            java.lang.Object r4 = r4.invoke(r7, r7)     // Catch:{ all -> 0x0866 }
            java.lang.Long r4 = (java.lang.Long) r4     // Catch:{ all -> 0x0866 }
            long r4 = r4.longValue()     // Catch:{ all -> 0x0866 }
            r32 = 982941918(0x3a9680de, double:4.856378335E-315)
            long r4 = r4 ^ r32
            r3.setSeed(r4)     // Catch:{ all -> 0x0864 }
            r4 = 0
            r5 = 0
            r7 = 0
            r10 = 0
        L_0x052b:
            if (r4 != 0) goto L_0x0530
            r12 = 72
            goto L_0x0532
        L_0x0530:
            r12 = 23
        L_0x0532:
            r32 = r4
            r4 = 72
            if (r12 == r4) goto L_0x0540
            r35 = r8
            r39 = r9
            r34 = r11
            goto L_0x0899
        L_0x0540:
            if (r5 != 0) goto L_0x0545
            r4 = 14
            goto L_0x0547
        L_0x0545:
            r4 = 35
        L_0x0547:
            r12 = 14
            if (r4 == r12) goto L_0x055f
            if (r7 != 0) goto L_0x054f
            r4 = 5
            goto L_0x0560
        L_0x054f:
            if (r10 != 0) goto L_0x055d
            int r4 = onValidateInApp
            int r4 = r4 + 103
            int r12 = r4 % 128
            getSdkVersion = r12
            r12 = 2
            int r4 = r4 % r12
            r4 = 4
            goto L_0x0560
        L_0x055d:
            r4 = 3
            goto L_0x0560
        L_0x055f:
            r4 = 6
        L_0x0560:
            java.lang.StringBuilder r12 = new java.lang.StringBuilder     // Catch:{ all -> 0x0864 }
            r33 = r4 | 1
            r17 = 1
            int r33 = r33 << 1
            r34 = r4 ^ 1
            r35 = r8
            int r8 = r33 - r34
            r12.<init>(r8)     // Catch:{ all -> 0x0862 }
            r8 = 46
            r12.append(r8)     // Catch:{ all -> 0x0862 }
            r8 = 0
        L_0x0577:
            if (r8 >= r4) goto L_0x05d6
            if (r25 == 0) goto L_0x0581
            r33 = r4
            r34 = r11
            r4 = 0
            goto L_0x0586
        L_0x0581:
            r33 = r4
            r34 = r11
            r4 = 1
        L_0x0586:
            r11 = 1
            if (r4 == r11) goto L_0x05b3
            r4 = 26
            int r4 = r3.nextInt(r4)     // Catch:{ all -> 0x05aa }
            boolean r11 = r3.nextBoolean()     // Catch:{ all -> 0x05aa }
            if (r11 == 0) goto L_0x059d
            int r4 = -r4
            int r4 = -r4
            r11 = r4 & 65
            r4 = r4 | 65
            int r11 = r11 + r4
            goto L_0x05a3
        L_0x059d:
            int r4 = ~r4     // Catch:{ all -> 0x05aa }
            int r4 = 96 - r4
            r11 = 1
            int r4 = r4 - r11
            r11 = r4
        L_0x05a3:
            char r4 = (char) r11     // Catch:{ all -> 0x05aa }
            r12.append(r4)     // Catch:{ all -> 0x05aa }
            r17 = 1
            goto L_0x05c6
        L_0x05aa:
            r0 = move-exception
            r48 = r2
            r40 = r6
            r39 = r9
            goto L_0x0887
        L_0x05b3:
            r4 = 12
            int r4 = r3.nextInt(r4)     // Catch:{ all -> 0x05aa }
            r11 = r4 ^ 8192(0x2000, float:1.14794E-41)
            r4 = r4 & 8192(0x2000, float:1.14794E-41)
            r17 = 1
            int r4 = r4 << 1
            int r11 = r11 + r4
            char r4 = (char) r11     // Catch:{ all -> 0x05aa }
            r12.append(r4)     // Catch:{ all -> 0x05aa }
        L_0x05c6:
            r4 = r8 | 25
            int r4 = r4 << 1
            r8 = r8 ^ 25
            int r4 = r4 - r8
            int r4 = r4 + -23
            int r8 = r4 + -1
            r4 = r33
            r11 = r34
            goto L_0x0577
        L_0x05d6:
            r34 = r11
            java.lang.String r4 = r12.toString()     // Catch:{ all -> 0x085e }
            if (r5 != 0) goto L_0x05e1
            r8 = 21
            goto L_0x05e3
        L_0x05e1:
            r8 = 43
        L_0x05e3:
            r11 = 43
            if (r8 == r11) goto L_0x063a
            r5 = 2
            java.lang.Object[] r8 = new java.lang.Object[r5]     // Catch:{ all -> 0x0630 }
            r5 = 1
            r8[r5] = r4     // Catch:{ all -> 0x0630 }
            r4 = 0
            r8[r4] = r15     // Catch:{ all -> 0x0630 }
            byte[] r4 = AppsFlyerLib     // Catch:{ all -> 0x0630 }
            r5 = 17
            byte r11 = r4[r5]     // Catch:{ all -> 0x0630 }
            byte r5 = (byte) r11     // Catch:{ all -> 0x0630 }
            r11 = 60
            byte r12 = r4[r11]     // Catch:{ all -> 0x0630 }
            byte r11 = (byte) r12     // Catch:{ all -> 0x0630 }
            java.lang.String r5 = $$c(r14, r5, r11)     // Catch:{ all -> 0x0630 }
            java.lang.Class r5 = java.lang.Class.forName(r5)     // Catch:{ all -> 0x0630 }
            r11 = 2
            java.lang.Class[] r12 = new java.lang.Class[r11]     // Catch:{ all -> 0x0630 }
            r33 = r3
            r11 = 17
            byte r3 = r4[r11]     // Catch:{ all -> 0x0630 }
            byte r3 = (byte) r3     // Catch:{ all -> 0x0630 }
            r11 = 60
            byte r4 = r4[r11]     // Catch:{ all -> 0x0630 }
            byte r4 = (byte) r4     // Catch:{ all -> 0x0630 }
            java.lang.String r3 = $$c(r14, r3, r4)     // Catch:{ all -> 0x0630 }
            java.lang.Class r3 = java.lang.Class.forName(r3)     // Catch:{ all -> 0x0630 }
            r4 = 0
            r12[r4] = r3     // Catch:{ all -> 0x0630 }
            r3 = 1
            r12[r3] = r2     // Catch:{ all -> 0x0630 }
            java.lang.reflect.Constructor r3 = r5.getDeclaredConstructor(r12)     // Catch:{ all -> 0x0630 }
            java.lang.Object r3 = r3.newInstance(r8)     // Catch:{ all -> 0x0630 }
            r5 = r3
        L_0x062a:
            r39 = r9
            r4 = r32
            goto L_0x084a
        L_0x0630:
            r0 = move-exception
            r3 = r0
            java.lang.Throwable r4 = r3.getCause()     // Catch:{ all -> 0x05aa }
            if (r4 == 0) goto L_0x0639
            throw r4     // Catch:{ all -> 0x05aa }
        L_0x0639:
            throw r3     // Catch:{ all -> 0x05aa }
        L_0x063a:
            r33 = r3
            if (r7 != 0) goto L_0x0641
            r3 = 89
            goto L_0x0643
        L_0x0641:
            r3 = 85
        L_0x0643:
            r8 = 89
            if (r3 == r8) goto L_0x07f4
            if (r10 != 0) goto L_0x064b
            r3 = 0
            goto L_0x064c
        L_0x064b:
            r3 = 1
        L_0x064c:
            r8 = 1
            if (r3 == r8) goto L_0x06a7
            int r3 = onValidateInApp
            r8 = r3 & 39
            r3 = r3 | 39
            int r8 = r8 + r3
            int r3 = r8 % 128
            getSdkVersion = r3
            r3 = 2
            int r8 = r8 % r3
            java.lang.Object[] r8 = new java.lang.Object[r3]     // Catch:{ all -> 0x069d }
            r3 = 1
            r8[r3] = r4     // Catch:{ all -> 0x069d }
            r3 = 0
            r8[r3] = r15     // Catch:{ all -> 0x069d }
            byte[] r3 = AppsFlyerLib     // Catch:{ all -> 0x069d }
            r4 = 17
            byte r10 = r3[r4]     // Catch:{ all -> 0x069d }
            byte r4 = (byte) r10     // Catch:{ all -> 0x069d }
            r10 = 60
            byte r11 = r3[r10]     // Catch:{ all -> 0x069d }
            byte r10 = (byte) r11     // Catch:{ all -> 0x069d }
            java.lang.String r4 = $$c(r14, r4, r10)     // Catch:{ all -> 0x069d }
            java.lang.Class r4 = java.lang.Class.forName(r4)     // Catch:{ all -> 0x069d }
            r10 = 2
            java.lang.Class[] r11 = new java.lang.Class[r10]     // Catch:{ all -> 0x069d }
            r10 = 17
            byte r12 = r3[r10]     // Catch:{ all -> 0x069d }
            byte r10 = (byte) r12     // Catch:{ all -> 0x069d }
            r12 = 60
            byte r3 = r3[r12]     // Catch:{ all -> 0x069d }
            byte r3 = (byte) r3     // Catch:{ all -> 0x069d }
            java.lang.String r3 = $$c(r14, r10, r3)     // Catch:{ all -> 0x069d }
            java.lang.Class r3 = java.lang.Class.forName(r3)     // Catch:{ all -> 0x069d }
            r10 = 0
            r11[r10] = r3     // Catch:{ all -> 0x069d }
            r3 = 1
            r11[r3] = r2     // Catch:{ all -> 0x069d }
            java.lang.reflect.Constructor r3 = r4.getDeclaredConstructor(r11)     // Catch:{ all -> 0x069d }
            java.lang.Object r3 = r3.newInstance(r8)     // Catch:{ all -> 0x069d }
            r10 = r3
            goto L_0x062a
        L_0x069d:
            r0 = move-exception
            r3 = r0
            java.lang.Throwable r4 = r3.getCause()     // Catch:{ all -> 0x05aa }
            if (r4 == 0) goto L_0x06a6
            throw r4     // Catch:{ all -> 0x05aa }
        L_0x06a6:
            throw r3     // Catch:{ all -> 0x05aa }
        L_0x06a7:
            r3 = 2
            java.lang.Object[] r8 = new java.lang.Object[r3]     // Catch:{ all -> 0x07e8 }
            r3 = 1
            r8[r3] = r4     // Catch:{ all -> 0x07e8 }
            r3 = 0
            r8[r3] = r15     // Catch:{ all -> 0x07e8 }
            byte[] r3 = AppsFlyerLib     // Catch:{ all -> 0x07e8 }
            r4 = 17
            byte r11 = r3[r4]     // Catch:{ all -> 0x07e8 }
            byte r4 = (byte) r11     // Catch:{ all -> 0x07e8 }
            r11 = 60
            byte r12 = r3[r11]     // Catch:{ all -> 0x07e8 }
            byte r11 = (byte) r12     // Catch:{ all -> 0x07e8 }
            java.lang.String r4 = $$c(r14, r4, r11)     // Catch:{ all -> 0x07e8 }
            java.lang.Class r4 = java.lang.Class.forName(r4)     // Catch:{ all -> 0x07e8 }
            r11 = 2
            java.lang.Class[] r12 = new java.lang.Class[r11]     // Catch:{ all -> 0x07e8 }
            r36 = r5
            r11 = 17
            byte r5 = r3[r11]     // Catch:{ all -> 0x07e8 }
            byte r5 = (byte) r5     // Catch:{ all -> 0x07e8 }
            r37 = r7
            r11 = 60
            byte r7 = r3[r11]     // Catch:{ all -> 0x07e8 }
            byte r7 = (byte) r7     // Catch:{ all -> 0x07e8 }
            java.lang.String r5 = $$c(r14, r5, r7)     // Catch:{ all -> 0x07e8 }
            java.lang.Class r5 = java.lang.Class.forName(r5)     // Catch:{ all -> 0x07e8 }
            r7 = 0
            r12[r7] = r5     // Catch:{ all -> 0x07e8 }
            r5 = 1
            r12[r5] = r2     // Catch:{ all -> 0x07e8 }
            java.lang.reflect.Constructor r4 = r4.getDeclaredConstructor(r12)     // Catch:{ all -> 0x07e8 }
            java.lang.Object r4 = r4.newInstance(r8)     // Catch:{ all -> 0x07e8 }
            java.lang.Object[] r7 = new java.lang.Object[r5]     // Catch:{ all -> 0x0760 }
            r5 = 0
            r7[r5] = r4     // Catch:{ all -> 0x0760 }
            r5 = 208(0xd0, float:2.91E-43)
            short r5 = (short) r5     // Catch:{ all -> 0x0760 }
            r8 = 17
            byte r11 = r3[r8]     // Catch:{ all -> 0x0760 }
            byte r8 = (byte) r11     // Catch:{ all -> 0x0760 }
            byte r11 = r3[r22]     // Catch:{ all -> 0x0760 }
            byte r11 = (byte) r11     // Catch:{ all -> 0x0760 }
            java.lang.String r8 = $$c(r5, r8, r11)     // Catch:{ all -> 0x0760 }
            java.lang.Class r8 = java.lang.Class.forName(r8)     // Catch:{ all -> 0x0760 }
            r11 = 1
            java.lang.Class[] r12 = new java.lang.Class[r11]     // Catch:{ all -> 0x0760 }
            r38 = r10
            r11 = 17
            byte r10 = r3[r11]     // Catch:{ all -> 0x0760 }
            byte r10 = (byte) r10
            r39 = r9
            r11 = 60
            byte r9 = r3[r11]     // Catch:{ all -> 0x075e }
            byte r9 = (byte) r9     // Catch:{ all -> 0x075e }
            java.lang.String r9 = $$c(r14, r10, r9)     // Catch:{ all -> 0x075e }
            java.lang.Class r9 = java.lang.Class.forName(r9)     // Catch:{ all -> 0x075e }
            r10 = 0
            r12[r10] = r9     // Catch:{ all -> 0x075e }
            java.lang.reflect.Constructor r8 = r8.getDeclaredConstructor(r12)     // Catch:{ all -> 0x075e }
            java.lang.Object r7 = r8.newInstance(r7)     // Catch:{ all -> 0x075e }
            r8 = 17
            byte r9 = r3[r8]     // Catch:{ all -> 0x0754 }
            byte r8 = (byte) r9     // Catch:{ all -> 0x0754 }
            byte r9 = r3[r22]     // Catch:{ all -> 0x0754 }
            byte r9 = (byte) r9     // Catch:{ all -> 0x0754 }
            java.lang.String r5 = $$c(r5, r8, r9)     // Catch:{ all -> 0x0754 }
            java.lang.Class r5 = java.lang.Class.forName(r5)     // Catch:{ all -> 0x0754 }
            r8 = 305(0x131, float:4.27E-43)
            short r8 = (short) r8     // Catch:{ all -> 0x0754 }
            r9 = 40
            byte r10 = r3[r9]     // Catch:{ all -> 0x0754 }
            byte r9 = (byte) r10     // Catch:{ all -> 0x0754 }
            byte r3 = r3[r26]     // Catch:{ all -> 0x0754 }
            byte r3 = (byte) r3     // Catch:{ all -> 0x0754 }
            java.lang.String r3 = $$c(r8, r9, r3)     // Catch:{ all -> 0x0754 }
            r8 = 0
            java.lang.reflect.Method r3 = r5.getMethod(r3, r8)     // Catch:{ all -> 0x0754 }
            r3.invoke(r7, r8)     // Catch:{ all -> 0x0754 }
            r5 = r36
            r7 = r37
            goto L_0x0848
        L_0x0754:
            r0 = move-exception
            r3 = r0
            java.lang.Throwable r5 = r3.getCause()     // Catch:{ Exception -> 0x076c }
            if (r5 == 0) goto L_0x075d
            throw r5     // Catch:{ Exception -> 0x076c }
        L_0x075d:
            throw r3     // Catch:{ Exception -> 0x076c }
        L_0x075e:
            r0 = move-exception
            goto L_0x0763
        L_0x0760:
            r0 = move-exception
            r39 = r9
        L_0x0763:
            r3 = r0
            java.lang.Throwable r5 = r3.getCause()     // Catch:{ Exception -> 0x076c }
            if (r5 == 0) goto L_0x076b
            throw r5     // Catch:{ Exception -> 0x076c }
        L_0x076b:
            throw r3     // Catch:{ Exception -> 0x076c }
        L_0x076c:
            r0 = move-exception
            r3 = r0
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ all -> 0x1840 }
            r5.<init>()     // Catch:{ all -> 0x1840 }
            r7 = 101(0x65, float:1.42E-43)
            short r7 = (short) r7     // Catch:{ all -> 0x1840 }
            byte[] r8 = AppsFlyerLib     // Catch:{ all -> 0x1840 }
            r9 = 289(0x121, float:4.05E-43)
            byte r9 = r8[r9]     // Catch:{ all -> 0x1840 }
            byte r9 = (byte) r9     // Catch:{ all -> 0x1840 }
            byte r10 = r8[r26]     // Catch:{ all -> 0x1840 }
            byte r10 = (byte) r10     // Catch:{ all -> 0x1840 }
            java.lang.String r7 = $$c(r7, r9, r10)     // Catch:{ all -> 0x1840 }
            r5.append(r7)     // Catch:{ all -> 0x1840 }
            r5.append(r4)     // Catch:{ all -> 0x1840 }
            int r4 = AppsFlyerInAppPurchaseValidatorListener     // Catch:{ all -> 0x1840 }
            r4 = r4 | 692(0x2b4, float:9.7E-43)
            short r4 = (short) r4     // Catch:{ all -> 0x1840 }
            r7 = 371(0x173, float:5.2E-43)
            byte r7 = r8[r7]     // Catch:{ all -> 0x1840 }
            r9 = r7 & -1
            r7 = r7 | -1
            int r9 = r9 + r7
            byte r7 = (byte) r9     // Catch:{ all -> 0x1840 }
            r9 = 14
            byte r9 = r8[r9]     // Catch:{ all -> 0x1840 }
            byte r9 = (byte) r9     // Catch:{ all -> 0x1840 }
            java.lang.String r4 = $$c(r4, r7, r9)     // Catch:{ all -> 0x1840 }
            r5.append(r4)     // Catch:{ all -> 0x1840 }
            java.lang.String r4 = r5.toString()     // Catch:{ all -> 0x1840 }
            r5 = 2
            java.lang.Object[] r7 = new java.lang.Object[r5]     // Catch:{ all -> 0x07de }
            r5 = 1
            r7[r5] = r3     // Catch:{ all -> 0x07de }
            r3 = 0
            r7[r3] = r4     // Catch:{ all -> 0x07de }
            r3 = 178(0xb2, float:2.5E-43)
            short r3 = (short) r3     // Catch:{ all -> 0x07de }
            r4 = 17
            byte r5 = r8[r4]     // Catch:{ all -> 0x07de }
            byte r4 = (byte) r5     // Catch:{ all -> 0x07de }
            r5 = 70
            byte r8 = r8[r5]     // Catch:{ all -> 0x07de }
            int r5 = -r8
            byte r5 = (byte) r5     // Catch:{ all -> 0x07de }
            java.lang.String r3 = $$c(r3, r4, r5)     // Catch:{ all -> 0x07de }
            java.lang.Class r3 = java.lang.Class.forName(r3)     // Catch:{ all -> 0x07de }
            r4 = 2
            java.lang.Class[] r5 = new java.lang.Class[r4]     // Catch:{ all -> 0x07de }
            r4 = 0
            r5[r4] = r2     // Catch:{ all -> 0x07de }
            java.lang.Class<java.lang.Throwable> r4 = java.lang.Throwable.class
            r8 = 1
            r5[r8] = r4     // Catch:{ all -> 0x07de }
            java.lang.reflect.Constructor r3 = r3.getDeclaredConstructor(r5)     // Catch:{ all -> 0x07de }
            java.lang.Object r3 = r3.newInstance(r7)     // Catch:{ all -> 0x07de }
            java.lang.Throwable r3 = (java.lang.Throwable) r3     // Catch:{ all -> 0x07de }
            throw r3     // Catch:{ all -> 0x07de }
        L_0x07de:
            r0 = move-exception
            r3 = r0
            java.lang.Throwable r4 = r3.getCause()     // Catch:{ all -> 0x1840 }
            if (r4 == 0) goto L_0x07e7
            throw r4     // Catch:{ all -> 0x1840 }
        L_0x07e7:
            throw r3     // Catch:{ all -> 0x1840 }
        L_0x07e8:
            r0 = move-exception
            r39 = r9
            r3 = r0
            java.lang.Throwable r4 = r3.getCause()     // Catch:{ all -> 0x1840 }
            if (r4 == 0) goto L_0x07f3
            throw r4     // Catch:{ all -> 0x1840 }
        L_0x07f3:
            throw r3     // Catch:{ all -> 0x1840 }
        L_0x07f4:
            r36 = r5
            r39 = r9
            r38 = r10
            int r3 = getSdkVersion
            int r3 = r3 + 123
            int r5 = r3 % 128
            onValidateInApp = r5
            r5 = 2
            int r3 = r3 % r5
            java.lang.Object[] r3 = new java.lang.Object[r5]     // Catch:{ all -> 0x0854 }
            r5 = 1
            r3[r5] = r4     // Catch:{ all -> 0x0854 }
            r4 = 0
            r3[r4] = r15     // Catch:{ all -> 0x0854 }
            byte[] r4 = AppsFlyerLib     // Catch:{ all -> 0x0854 }
            r5 = 17
            byte r7 = r4[r5]     // Catch:{ all -> 0x0854 }
            byte r5 = (byte) r7     // Catch:{ all -> 0x0854 }
            r7 = 60
            byte r8 = r4[r7]     // Catch:{ all -> 0x0854 }
            byte r7 = (byte) r8     // Catch:{ all -> 0x0854 }
            java.lang.String r5 = $$c(r14, r5, r7)     // Catch:{ all -> 0x0854 }
            java.lang.Class r5 = java.lang.Class.forName(r5)     // Catch:{ all -> 0x0854 }
            r7 = 2
            java.lang.Class[] r8 = new java.lang.Class[r7]     // Catch:{ all -> 0x0854 }
            r7 = 17
            byte r9 = r4[r7]     // Catch:{ all -> 0x0854 }
            byte r7 = (byte) r9     // Catch:{ all -> 0x0854 }
            r9 = 60
            byte r4 = r4[r9]     // Catch:{ all -> 0x0854 }
            byte r4 = (byte) r4     // Catch:{ all -> 0x0854 }
            java.lang.String r4 = $$c(r14, r7, r4)     // Catch:{ all -> 0x0854 }
            java.lang.Class r4 = java.lang.Class.forName(r4)     // Catch:{ all -> 0x0854 }
            r7 = 0
            r8[r7] = r4     // Catch:{ all -> 0x0854 }
            r4 = 1
            r8[r4] = r2     // Catch:{ all -> 0x0854 }
            java.lang.reflect.Constructor r4 = r5.getDeclaredConstructor(r8)     // Catch:{ all -> 0x0854 }
            java.lang.Object r3 = r4.newInstance(r3)     // Catch:{ all -> 0x0854 }
            r7 = r3
            r4 = r32
            r5 = r36
        L_0x0848:
            r10 = r38
        L_0x084a:
            r3 = r33
            r11 = r34
            r8 = r35
            r9 = r39
            goto L_0x052b
        L_0x0854:
            r0 = move-exception
            r3 = r0
            java.lang.Throwable r4 = r3.getCause()     // Catch:{ all -> 0x1840 }
            if (r4 == 0) goto L_0x085d
            throw r4     // Catch:{ all -> 0x1840 }
        L_0x085d:
            throw r3     // Catch:{ all -> 0x1840 }
        L_0x085e:
            r0 = move-exception
            r39 = r9
            goto L_0x0883
        L_0x0862:
            r0 = move-exception
            goto L_0x087f
        L_0x0864:
            r0 = move-exception
            goto L_0x087d
        L_0x0866:
            r0 = move-exception
            goto L_0x086b
        L_0x0868:
            r0 = move-exception
            r31 = r5
        L_0x086b:
            r35 = r8
            r39 = r9
            r34 = r11
            r3 = r0
            java.lang.Throwable r4 = r3.getCause()     // Catch:{ all -> 0x1840 }
            if (r4 == 0) goto L_0x0879
            throw r4     // Catch:{ all -> 0x1840 }
        L_0x0879:
            throw r3     // Catch:{ all -> 0x1840 }
        L_0x087a:
            r0 = move-exception
            r31 = r5
        L_0x087d:
            r35 = r8
        L_0x087f:
            r39 = r9
            r34 = r11
        L_0x0883:
            r48 = r2
            r40 = r6
        L_0x0887:
            r12 = r14
        L_0x0888:
            r6 = 60
            goto L_0x1856
        L_0x088c:
            r31 = r5
            r35 = r8
            r39 = r9
            r34 = r11
            r5 = 0
            r7 = 0
            r10 = 0
            r32 = 0
        L_0x0899:
            r3 = 7144(0x1be8, float:1.0011E-41)
            byte[] r3 = new byte[r3]     // Catch:{ all -> 0x1840 }
            java.lang.Class<com.appsflyer.internal.a> r4 = com.appsflyer.internal.a.class
            r8 = 301(0x12d, float:4.22E-43)
            short r8 = (short) r8     // Catch:{ all -> 0x1840 }
            r9 = 72
            byte r9 = (byte) r9     // Catch:{ all -> 0x1840 }
            byte[] r11 = AppsFlyerLib     // Catch:{ all -> 0x1840 }
            r12 = 450(0x1c2, float:6.3E-43)
            byte r12 = r11[r12]     // Catch:{ all -> 0x1840 }
            byte r12 = (byte) r12     // Catch:{ all -> 0x1840 }
            java.lang.String r8 = $$c(r8, r9, r12)     // Catch:{ all -> 0x1840 }
            java.io.InputStream r4 = r4.getResourceAsStream(r8)     // Catch:{ all -> 0x1840 }
            int r8 = getSdkVersion
            r9 = r8 & 67
            r8 = r8 | 67
            int r9 = r9 + r8
            int r8 = r9 % 128
            onValidateInApp = r8
            r8 = 2
            int r9 = r9 % r8
            r8 = 1
            java.lang.Object[] r9 = new java.lang.Object[r8]     // Catch:{ all -> 0x1829 }
            r8 = 0
            r9[r8] = r4     // Catch:{ all -> 0x1829 }
            r4 = 477(0x1dd, float:6.68E-43)
            short r4 = (short) r4     // Catch:{ all -> 0x1829 }
            r8 = 17
            byte r12 = r11[r8]     // Catch:{ all -> 0x1829 }
            byte r8 = (byte) r12     // Catch:{ all -> 0x1829 }
            r12 = 389(0x185, float:5.45E-43)
            byte r15 = r11[r12]     // Catch:{ all -> 0x1829 }
            byte r12 = (byte) r15     // Catch:{ all -> 0x1829 }
            java.lang.String r8 = $$c(r4, r8, r12)     // Catch:{ all -> 0x1829 }
            java.lang.Class r8 = java.lang.Class.forName(r8)     // Catch:{ all -> 0x1829 }
            r12 = 1
            java.lang.Class[] r15 = new java.lang.Class[r12]     // Catch:{ all -> 0x1829 }
            r25 = r5
            r12 = 14
            byte r5 = r11[r12]     // Catch:{ all -> 0x1829 }
            short r5 = (short) r5     // Catch:{ all -> 0x1829 }
            r33 = r7
            r12 = 17
            byte r7 = r11[r12]     // Catch:{ all -> 0x1829 }
            byte r7 = (byte) r7     // Catch:{ all -> 0x1829 }
            r36 = r10
            r12 = 70
            byte r10 = r11[r12]     // Catch:{ all -> 0x1829 }
            int r10 = -r10
            byte r10 = (byte) r10     // Catch:{ all -> 0x1829 }
            java.lang.String r5 = $$c(r5, r7, r10)     // Catch:{ all -> 0x1829 }
            java.lang.Class r5 = java.lang.Class.forName(r5)     // Catch:{ all -> 0x1829 }
            r7 = 0
            r15[r7] = r5     // Catch:{ all -> 0x1829 }
            java.lang.reflect.Constructor r5 = r8.getDeclaredConstructor(r15)     // Catch:{ all -> 0x1829 }
            java.lang.Object r5 = r5.newInstance(r9)     // Catch:{ all -> 0x1829 }
            r8 = 1
            java.lang.Object[] r9 = new java.lang.Object[r8]     // Catch:{ all -> 0x1814 }
            r9[r7] = r3     // Catch:{ all -> 0x1814 }
            r7 = 17
            byte r8 = r11[r7]     // Catch:{ all -> 0x1814 }
            byte r7 = (byte) r8     // Catch:{ all -> 0x1814 }
            r8 = 389(0x185, float:5.45E-43)
            byte r10 = r11[r8]     // Catch:{ all -> 0x1814 }
            byte r8 = (byte) r10     // Catch:{ all -> 0x1814 }
            java.lang.String r7 = $$c(r4, r7, r8)     // Catch:{ all -> 0x1814 }
            java.lang.Class r7 = java.lang.Class.forName(r7)     // Catch:{ all -> 0x1814 }
            r8 = 761(0x2f9, float:1.066E-42)
            short r8 = (short) r8     // Catch:{ all -> 0x1814 }
            r10 = 92
            byte r12 = r11[r10]     // Catch:{ all -> 0x1814 }
            byte r12 = (byte) r12     // Catch:{ all -> 0x1814 }
            r15 = 136(0x88, float:1.9E-43)
            byte r15 = r11[r15]     // Catch:{ all -> 0x1814 }
            byte r15 = (byte) r15     // Catch:{ all -> 0x1814 }
            java.lang.String r8 = $$c(r8, r12, r15)     // Catch:{ all -> 0x1814 }
            r12 = 1
            java.lang.Class[] r15 = new java.lang.Class[r12]     // Catch:{ all -> 0x1814 }
            r12 = 0
            r15[r12] = r1     // Catch:{ all -> 0x1814 }
            java.lang.reflect.Method r7 = r7.getMethod(r8, r15)     // Catch:{ all -> 0x1814 }
            r7.invoke(r5, r9)     // Catch:{ all -> 0x1814 }
            r7 = 17
            byte r8 = r11[r7]     // Catch:{ all -> 0x17ff }
            byte r7 = (byte) r8     // Catch:{ all -> 0x17ff }
            r8 = 389(0x185, float:5.45E-43)
            byte r9 = r11[r8]     // Catch:{ all -> 0x17ff }
            byte r8 = (byte) r9     // Catch:{ all -> 0x17ff }
            java.lang.String r4 = $$c(r4, r7, r8)     // Catch:{ all -> 0x17ff }
            java.lang.Class r4 = java.lang.Class.forName(r4)     // Catch:{ all -> 0x17ff }
            r7 = 305(0x131, float:4.27E-43)
            short r7 = (short) r7
            r8 = 40
            byte r9 = r11[r8]     // Catch:{ all -> 0x17f5 }
            byte r8 = (byte) r9
            byte r9 = r11[r26]     // Catch:{ all -> 0x17ff }
            byte r9 = (byte) r9     // Catch:{ all -> 0x17ff }
            java.lang.String r7 = $$c(r7, r8, r9)     // Catch:{ all -> 0x17ff }
            r8 = 0
            java.lang.reflect.Method r4 = r4.getMethod(r7, r8)     // Catch:{ all -> 0x17ff }
            r4.invoke(r5, r8)     // Catch:{ all -> 0x17ff }
            r4 = 16
            r7 = 7106(0x1bc2, float:9.958E-42)
            r9 = r29
            r8 = 0
        L_0x096d:
            int r11 = r4 + 1088
            r12 = r4 | 7127(0x1bd7, float:9.987E-42)
            r15 = 1
            int r12 = r12 << r15
            r15 = r4 ^ 7127(0x1bd7, float:9.987E-42)
            int r12 = r12 - r15
            byte r12 = r3[r12]     // Catch:{ all -> 0x1840 }
            r15 = r12 & -122(0xffffffffffffff86, float:NaN)
            r12 = r12 | -122(0xffffffffffffff86, float:NaN)
            int r15 = r15 + r12
            byte r12 = (byte) r15     // Catch:{ all -> 0x1840 }
            r3[r11] = r12     // Catch:{ all -> 0x1840 }
            int r11 = r3.length     // Catch:{ all -> 0x1840 }
            int r12 = -r4
            r15 = r11 ^ r12
            r11 = r11 & r12
            r12 = 1
            int r11 = r11 << r12
            int r15 = r15 + r11
            r11 = 3
            java.lang.Object[] r10 = new java.lang.Object[r11]     // Catch:{ all -> 0x17e0 }
            java.lang.Integer r11 = java.lang.Integer.valueOf(r15)     // Catch:{ all -> 0x17e0 }
            r15 = 2
            r10[r15] = r11     // Catch:{ all -> 0x17e0 }
            java.lang.Integer r11 = java.lang.Integer.valueOf(r4)     // Catch:{ all -> 0x17e0 }
            r10[r12] = r11     // Catch:{ all -> 0x17e0 }
            r11 = 0
            r10[r11] = r3     // Catch:{ all -> 0x17e0 }
            int r3 = AppsFlyerInAppPurchaseValidatorListener     // Catch:{ all -> 0x17e0 }
            r11 = r3 ^ 820(0x334, float:1.149E-42)
            r12 = r3 & 820(0x334, float:1.149E-42)
            r11 = r11 | r12
            short r11 = (short) r11     // Catch:{ all -> 0x17e0 }
            byte[] r12 = AppsFlyerLib     // Catch:{ all -> 0x17e0 }
            r15 = 17
            byte r5 = r12[r15]     // Catch:{ all -> 0x17e0 }
            byte r5 = (byte) r5     // Catch:{ all -> 0x17e0 }
            r15 = 19
            byte r15 = r12[r15]     // Catch:{ all -> 0x17e0 }
            byte r15 = (byte) r15     // Catch:{ all -> 0x17e0 }
            java.lang.String r5 = $$c(r11, r5, r15)     // Catch:{ all -> 0x17e0 }
            java.lang.Class r5 = java.lang.Class.forName(r5)     // Catch:{ all -> 0x17e0 }
            r11 = 3
            java.lang.Class[] r15 = new java.lang.Class[r11]     // Catch:{ all -> 0x17e0 }
            r11 = 0
            r15[r11] = r1     // Catch:{ all -> 0x17e0 }
            java.lang.Class r11 = java.lang.Integer.TYPE     // Catch:{ all -> 0x17e0 }
            r17 = 1
            r15[r17] = r11     // Catch:{ all -> 0x17e0 }
            r18 = 2
            r15[r18] = r11     // Catch:{ all -> 0x17e0 }
            java.lang.reflect.Constructor r5 = r5.getDeclaredConstructor(r15)     // Catch:{ all -> 0x17e0 }
            java.lang.Object r5 = r5.newInstance(r10)     // Catch:{ all -> 0x17e0 }
            r41 = r5
            java.io.InputStream r41 = (java.io.InputStream) r41     // Catch:{ all -> 0x17e0 }
            java.lang.Object r5 = onDeepLinking     // Catch:{ all -> 0x1840 }
            if (r5 != 0) goto L_0x0a5d
            r5 = 881(0x371, float:1.235E-42)
            short r5 = (short) r5
            r10 = 389(0x185, float:5.45E-43)
            byte r11 = r12[r10]     // Catch:{ all -> 0x0a53 }
            byte r10 = (byte) r11     // Catch:{ all -> 0x0a53 }
            r11 = 139(0x8b, float:1.95E-43)
            byte r11 = r12[r11]     // Catch:{ all -> 0x0a53 }
            byte r11 = (byte) r11     // Catch:{ all -> 0x0a53 }
            java.lang.String r5 = $$c(r5, r10, r11)     // Catch:{ all -> 0x0a53 }
            java.lang.Class r5 = java.lang.Class.forName(r5)     // Catch:{ all -> 0x0a53 }
            r10 = 535(0x217, float:7.5E-43)
            byte r10 = r12[r10]     // Catch:{ all -> 0x0a53 }
            short r10 = (short) r10     // Catch:{ all -> 0x0a53 }
            r11 = 88
            byte r11 = r12[r11]     // Catch:{ all -> 0x0a53 }
            byte r11 = (byte) r11     // Catch:{ all -> 0x0a53 }
            byte r15 = r12[r26]     // Catch:{ all -> 0x0a53 }
            byte r15 = (byte) r15     // Catch:{ all -> 0x0a53 }
            java.lang.String r10 = $$c(r10, r11, r15)     // Catch:{ all -> 0x0a53 }
            r11 = 0
            java.lang.reflect.Method r5 = r5.getMethod(r10, r11)     // Catch:{ all -> 0x0a53 }
            java.lang.Object r5 = r5.invoke(r11, r11)     // Catch:{ all -> 0x0a53 }
            java.lang.Integer r5 = (java.lang.Integer) r5     // Catch:{ all -> 0x0a53 }
            int r5 = r5.intValue()     // Catch:{ all -> 0x0a53 }
            int r5 = r5 >> 22
            int r5 = -r5
            int r5 = -r5
            int r5 = ~r5
            int r5 = 8 - r5
            r10 = 1
            int r5 = r5 - r10
            short r5 = (short) r5
            r10 = -814034428(0xffffffffcf7ad204, float:-4.20806758E9)
            long r42 = android.view.ViewConfiguration.getGlobalActionKeyTimeout()     // Catch:{ all -> 0x1840 }
            r44 = 0
            int r11 = (r42 > r44 ? 1 : (r42 == r44 ? 0 : -1))
            int r11 = -r11
            r15 = r11 & r10
            r10 = r10 | r11
            int r46 = r15 + r10
            r10 = -2100695835(0xffffffff82c9ece5, float:-2.9670266E-37)
            r11 = 0
            int r15 = android.graphics.Color.blue(r11)     // Catch:{ all -> 0x1840 }
            r11 = r15 ^ r10
            r10 = r10 & r15
            r15 = 1
            int r10 = r10 << r15
            int r43 = r11 + r10
            com.appsflyer.internal.bx r10 = new com.appsflyer.internal.bx     // Catch:{ all -> 0x1840 }
            int r42 = AppsFlyerConversionListener     // Catch:{ all -> 0x1840 }
            int r45 = onValidateInAppFailure     // Catch:{ all -> 0x1840 }
            r40 = r10
            r44 = r5
            r40.<init>(r41, r42, r43, r44, r45, r46)     // Catch:{ all -> 0x1840 }
            r24 = r4
            r40 = r6
            r42 = r7
            r43 = r8
            r44 = r9
            r45 = r14
        L_0x0a4f:
            r4 = 16
            goto L_0x0b68
        L_0x0a53:
            r0 = move-exception
            r3 = r0
            java.lang.Throwable r4 = r3.getCause()     // Catch:{ all -> 0x1840 }
            if (r4 == 0) goto L_0x0a5c
            throw r4     // Catch:{ all -> 0x1840 }
        L_0x0a5c:
            throw r3     // Catch:{ all -> 0x1840 }
        L_0x0a5d:
            java.lang.String r15 = ""
            r40 = 48
            int r42 = getSdkVersion
            r43 = r42 & 11
            r42 = r42 | 11
            int r10 = r43 + r42
            r42 = r7
            int r7 = r10 % 128
            onValidateInApp = r7
            r7 = 2
            int r10 = r10 % r7
            r7 = 4
            java.lang.Object[] r10 = new java.lang.Object[r7]     // Catch:{ all -> 0x17cb }
            r7 = 0
            java.lang.Integer r28 = java.lang.Integer.valueOf(r7)     // Catch:{ all -> 0x17cb }
            r23 = 3
            r10[r23] = r28     // Catch:{ all -> 0x17cb }
            java.lang.Integer r28 = java.lang.Integer.valueOf(r7)     // Catch:{ all -> 0x17cb }
            r18 = 2
            r10[r18] = r28     // Catch:{ all -> 0x17cb }
            java.lang.Character r28 = java.lang.Character.valueOf(r40)     // Catch:{ all -> 0x17cb }
            r17 = 1
            r10[r17] = r28     // Catch:{ all -> 0x17cb }
            r10[r7] = r15     // Catch:{ all -> 0x17cb }
            r7 = 160(0xa0, float:2.24E-43)
            short r7 = (short) r7
            r40 = r6
            r15 = 389(0x185, float:5.45E-43)
            byte r6 = r12[r15]     // Catch:{ all -> 0x17c7 }
            byte r6 = (byte) r6     // Catch:{ all -> 0x17c7 }
            r43 = r8
            r15 = 6
            byte r8 = r12[r15]     // Catch:{ all -> 0x17c7 }
            byte r8 = (byte) r8     // Catch:{ all -> 0x17c7 }
            java.lang.String r6 = $$c(r7, r6, r8)     // Catch:{ all -> 0x17c7 }
            java.lang.Class r6 = java.lang.Class.forName(r6)     // Catch:{ all -> 0x17c7 }
            r7 = 718(0x2ce, float:1.006E-42)
            short r7 = (short) r7     // Catch:{ all -> 0x17c7 }
            r8 = 203(0xcb, float:2.84E-43)
            byte r8 = r12[r8]     // Catch:{ all -> 0x17c7 }
            byte r8 = (byte) r8     // Catch:{ all -> 0x17c7 }
            r15 = 66
            byte r15 = r12[r15]     // Catch:{ all -> 0x17c7 }
            byte r15 = (byte) r15     // Catch:{ all -> 0x17c7 }
            java.lang.String r7 = $$c(r7, r8, r15)     // Catch:{ all -> 0x17c7 }
            r8 = 4
            java.lang.Class[] r15 = new java.lang.Class[r8]     // Catch:{ all -> 0x17c7 }
            java.lang.Class<java.lang.CharSequence> r8 = java.lang.CharSequence.class
            r28 = 0
            r15[r28] = r8     // Catch:{ all -> 0x17c7 }
            java.lang.Class r8 = java.lang.Character.TYPE     // Catch:{ all -> 0x17c7 }
            r17 = 1
            r15[r17] = r8     // Catch:{ all -> 0x17c7 }
            r8 = 2
            r15[r8] = r11     // Catch:{ all -> 0x17c7 }
            r8 = 3
            r15[r8] = r11     // Catch:{ all -> 0x17c7 }
            java.lang.reflect.Method r6 = r6.getMethod(r7, r15)     // Catch:{ all -> 0x17c7 }
            r7 = 0
            java.lang.Object r6 = r6.invoke(r7, r10)     // Catch:{ all -> 0x17c7 }
            java.lang.Integer r6 = (java.lang.Integer) r6     // Catch:{ all -> 0x17c7 }
            int r6 = r6.intValue()     // Catch:{ all -> 0x17c7 }
            int r6 = -r6
            r7 = -138233288(0xfffffffff7c2ba38, float:-7.8990825E33)
            r8 = r6 ^ r7
            r6 = r6 & r7
            r7 = 1
            int r6 = r6 << r7
            int r8 = r8 + r6
            int r6 = android.view.ViewConfiguration.getWindowTouchSlop()     // Catch:{ all -> 0x17c2 }
            int r6 = r6 >> 8
            r7 = 5
            int r15 = 5 - r6
            short r6 = (short) r15
            r10 = 3
            java.lang.Object[] r15 = new java.lang.Object[r10]     // Catch:{ all -> 0x17af }
            java.lang.Short r6 = java.lang.Short.valueOf(r6)     // Catch:{ all -> 0x17af }
            r10 = 2
            r15[r10] = r6     // Catch:{ all -> 0x17af }
            java.lang.Integer r6 = java.lang.Integer.valueOf(r8)     // Catch:{ all -> 0x17af }
            r8 = 1
            r15[r8] = r6     // Catch:{ all -> 0x17af }
            r6 = 0
            r15[r6] = r41     // Catch:{ all -> 0x17af }
            r6 = 938(0x3aa, float:1.314E-42)
            short r6 = (short) r6
            r8 = 40
            byte r10 = r12[r8]     // Catch:{ all -> 0x17a7 }
            byte r8 = (byte) r10
            r10 = 450(0x1c2, float:6.3E-43)
            byte r10 = r12[r10]     // Catch:{ all -> 0x17af }
            byte r10 = (byte) r10     // Catch:{ all -> 0x17af }
            java.lang.String r6 = $$c(r6, r8, r10)     // Catch:{ all -> 0x17af }
            java.lang.Object r8 = onAttributionFailure     // Catch:{ all -> 0x17af }
            java.lang.ClassLoader r8 = (java.lang.ClassLoader) r8     // Catch:{ all -> 0x17af }
            r10 = 1
            java.lang.Class r6 = java.lang.Class.forName(r6, r10, r8)     // Catch:{ all -> 0x17af }
            r8 = 621(0x26d, float:8.7E-43)
            short r8 = (short) r8     // Catch:{ all -> 0x17af }
            r10 = 93
            byte r10 = r12[r10]     // Catch:{ all -> 0x17af }
            byte r10 = (byte) r10     // Catch:{ all -> 0x17af }
            r24 = 13
            byte r7 = r12[r24]     // Catch:{ all -> 0x17af }
            byte r7 = (byte) r7     // Catch:{ all -> 0x17af }
            java.lang.String r7 = $$c(r8, r10, r7)     // Catch:{ all -> 0x17af }
            r8 = 3
            java.lang.Class[] r10 = new java.lang.Class[r8]     // Catch:{ all -> 0x17af }
            r24 = r4
            r8 = 14
            byte r4 = r12[r8]     // Catch:{ all -> 0x17af }
            short r4 = (short) r4     // Catch:{ all -> 0x17af }
            r44 = r9
            r8 = 17
            byte r9 = r12[r8]     // Catch:{ all -> 0x17af }
            byte r8 = (byte) r9
            r45 = r14
            r9 = 70
            byte r14 = r12[r9]     // Catch:{ all -> 0x17a1 }
            int r9 = -r14
            byte r9 = (byte) r9     // Catch:{ all -> 0x17a1 }
            java.lang.String r4 = $$c(r4, r8, r9)     // Catch:{ all -> 0x17a1 }
            java.lang.Class r4 = java.lang.Class.forName(r4)     // Catch:{ all -> 0x17a1 }
            r8 = 0
            r10[r8] = r4     // Catch:{ all -> 0x17a1 }
            r4 = 1
            r10[r4] = r11     // Catch:{ all -> 0x17a1 }
            java.lang.Class r4 = java.lang.Short.TYPE     // Catch:{ all -> 0x17a1 }
            r8 = 2
            r10[r8] = r4     // Catch:{ all -> 0x17a1 }
            java.lang.reflect.Method r4 = r6.getMethod(r7, r10)     // Catch:{ all -> 0x17a1 }
            java.lang.Object r4 = r4.invoke(r5, r15)     // Catch:{ all -> 0x17a1 }
            r10 = r4
            java.io.InputStream r10 = (java.io.InputStream) r10     // Catch:{ all -> 0x17a1 }
            goto L_0x0a4f
        L_0x0b68:
            long r5 = (long) r4
            r7 = 1
            java.lang.Object[] r8 = new java.lang.Object[r7]     // Catch:{ all -> 0x178d }
            java.lang.Long r5 = java.lang.Long.valueOf(r5)     // Catch:{ all -> 0x178d }
            r6 = 0
            r8[r6] = r5     // Catch:{ all -> 0x178d }
            r5 = 14
            byte r6 = r12[r5]     // Catch:{ all -> 0x178d }
            short r5 = (short) r6     // Catch:{ all -> 0x178d }
            r6 = 17
            byte r7 = r12[r6]     // Catch:{ all -> 0x178d }
            byte r6 = (byte) r7     // Catch:{ all -> 0x178d }
            r7 = 70
            byte r9 = r12[r7]     // Catch:{ all -> 0x178d }
            int r7 = -r9
            byte r7 = (byte) r7     // Catch:{ all -> 0x178d }
            java.lang.String r5 = $$c(r5, r6, r7)     // Catch:{ all -> 0x178d }
            java.lang.Class r5 = java.lang.Class.forName(r5)     // Catch:{ all -> 0x178d }
            r6 = 370(0x172, float:5.18E-43)
            short r6 = (short) r6     // Catch:{ all -> 0x178d }
            byte r7 = r12[r26]     // Catch:{ all -> 0x178d }
            byte r7 = (byte) r7     // Catch:{ all -> 0x178d }
            byte r3 = (byte) r3     // Catch:{ all -> 0x178d }
            java.lang.String r3 = $$c(r6, r7, r3)     // Catch:{ all -> 0x178d }
            r6 = 1
            java.lang.Class[] r7 = new java.lang.Class[r6]     // Catch:{ all -> 0x178d }
            java.lang.Class r6 = java.lang.Long.TYPE     // Catch:{ all -> 0x178d }
            r9 = 0
            r7[r9] = r6     // Catch:{ all -> 0x178d }
            java.lang.reflect.Method r3 = r5.getMethod(r3, r7)     // Catch:{ all -> 0x178d }
            java.lang.Object r3 = r3.invoke(r10, r8)     // Catch:{ all -> 0x178d }
            java.lang.Long r3 = (java.lang.Long) r3     // Catch:{ all -> 0x178d }
            r3.longValue()     // Catch:{ all -> 0x178d }
            if (r13 == 0) goto L_0x0bb0
            r3 = 78
            goto L_0x0bb2
        L_0x0bb0:
            r3 = 42
        L_0x0bb2:
            r5 = 78
            if (r3 == r5) goto L_0x0fd8
            java.util.zip.ZipInputStream r3 = new java.util.zip.ZipInputStream     // Catch:{ all -> 0x0fca }
            r3.<init>(r10)     // Catch:{ all -> 0x0fca }
            java.util.zip.ZipEntry r5 = r3.getNextEntry()     // Catch:{ all -> 0x0fca }
            r7 = 1
            java.lang.Object[] r8 = new java.lang.Object[r7]     // Catch:{ all -> 0x0fbb }
            r7 = 0
            r8[r7] = r3     // Catch:{ all -> 0x0fbb }
            r3 = 964(0x3c4, float:1.351E-42)
            short r3 = (short) r3     // Catch:{ all -> 0x0fbb }
            r7 = 17
            byte r9 = r12[r7]     // Catch:{ all -> 0x0fbb }
            byte r7 = (byte) r9     // Catch:{ all -> 0x0fbb }
            int r9 = r7 << 1
            byte r9 = (byte) r9     // Catch:{ all -> 0x0fbb }
            java.lang.String r7 = $$c(r3, r7, r9)     // Catch:{ all -> 0x0fbb }
            java.lang.Class r7 = java.lang.Class.forName(r7)     // Catch:{ all -> 0x0fbb }
            r9 = 1
            java.lang.Class[] r10 = new java.lang.Class[r9]     // Catch:{ all -> 0x0fbb }
            r9 = 14
            byte r11 = r12[r9]     // Catch:{ all -> 0x0fbb }
            short r9 = (short) r11     // Catch:{ all -> 0x0fbb }
            r11 = 17
            byte r14 = r12[r11]     // Catch:{ all -> 0x0fbb }
            byte r11 = (byte) r14     // Catch:{ all -> 0x0fbb }
            r14 = 70
            byte r15 = r12[r14]     // Catch:{ all -> 0x0fbb }
            int r14 = -r15
            byte r14 = (byte) r14     // Catch:{ all -> 0x0fbb }
            java.lang.String r9 = $$c(r9, r11, r14)     // Catch:{ all -> 0x0fbb }
            java.lang.Class r9 = java.lang.Class.forName(r9)     // Catch:{ all -> 0x0fbb }
            r11 = 0
            r10[r11] = r9     // Catch:{ all -> 0x0fbb }
            java.lang.reflect.Constructor r7 = r7.getDeclaredConstructor(r10)     // Catch:{ all -> 0x0fbb }
            java.lang.Object r7 = r7.newInstance(r8)     // Catch:{ all -> 0x0fbb }
            r8 = 449(0x1c1, float:6.29E-43)
            short r8 = (short) r8
            r9 = 17
            byte r10 = r12[r9]     // Catch:{ all -> 0x0fae }
            byte r9 = (byte) r10     // Catch:{ all -> 0x0fae }
            r10 = 832(0x340, float:1.166E-42)
            byte r10 = r12[r10]     // Catch:{ all -> 0x0fae }
            byte r10 = (byte) r10     // Catch:{ all -> 0x0fae }
            java.lang.String r9 = $$c(r8, r9, r10)     // Catch:{ all -> 0x0fae }
            java.lang.Class r9 = java.lang.Class.forName(r9)     // Catch:{ all -> 0x0fae }
            r10 = 0
            java.lang.reflect.Constructor r9 = r9.getDeclaredConstructor(r10)     // Catch:{ all -> 0x0fae }
            java.lang.Object r9 = r9.newInstance(r10)     // Catch:{ all -> 0x0fae }
            r10 = 1024(0x400, float:1.435E-42)
            byte[] r10 = new byte[r10]     // Catch:{ all -> 0x0fca }
            r11 = 0
        L_0x0c21:
            r12 = 1
            java.lang.Object[] r14 = new java.lang.Object[r12]     // Catch:{ all -> 0x0fa1 }
            r12 = 0
            r14[r12] = r10     // Catch:{ all -> 0x0fa1 }
            byte[] r12 = AppsFlyerLib     // Catch:{ all -> 0x0fa1 }
            r15 = 17
            byte r4 = r12[r15]     // Catch:{ all -> 0x0fa1 }
            byte r4 = (byte) r4     // Catch:{ all -> 0x0fa1 }
            int r15 = r4 << 1
            byte r15 = (byte) r15     // Catch:{ all -> 0x0fa1 }
            java.lang.String r4 = $$c(r3, r4, r15)     // Catch:{ all -> 0x0fa1 }
            java.lang.Class r4 = java.lang.Class.forName(r4)     // Catch:{ all -> 0x0fa1 }
            r15 = 698(0x2ba, float:9.78E-43)
            short r15 = (short) r15     // Catch:{ all -> 0x0fa1 }
            r37 = 92
            byte r6 = r12[r37]     // Catch:{ all -> 0x0fa1 }
            byte r6 = (byte) r6     // Catch:{ all -> 0x0fa1 }
            r47 = r13
            int r13 = AppsFlyerInAppPurchaseValidatorListener     // Catch:{ all -> 0x0fa1 }
            r48 = r2
            byte r2 = (byte) r13
            java.lang.String r2 = $$c(r15, r6, r2)     // Catch:{ all -> 0x0f9f }
            r6 = 1
            java.lang.Class[] r15 = new java.lang.Class[r6]     // Catch:{ all -> 0x0f9f }
            r6 = 0
            r15[r6] = r1     // Catch:{ all -> 0x0f9f }
            java.lang.reflect.Method r2 = r4.getMethod(r2, r15)     // Catch:{ all -> 0x0f9f }
            java.lang.Object r2 = r2.invoke(r7, r14)     // Catch:{ all -> 0x0f9f }
            java.lang.Integer r2 = (java.lang.Integer) r2     // Catch:{ all -> 0x0f9f }
            int r2 = r2.intValue()     // Catch:{ all -> 0x0f9f }
            if (r2 <= 0) goto L_0x0cd5
            long r14 = (long) r11
            long r49 = r5.getSize()     // Catch:{ all -> 0x0fc8 }
            int r4 = (r14 > r49 ? 1 : (r14 == r49 ? 0 : -1))
            if (r4 >= 0) goto L_0x0c6d
            r4 = 1
            goto L_0x0c6e
        L_0x0c6d:
            r4 = 0
        L_0x0c6e:
            if (r4 == 0) goto L_0x0cd5
            r4 = 3
            java.lang.Object[] r6 = new java.lang.Object[r4]     // Catch:{ all -> 0x0ccb }
            java.lang.Integer r4 = java.lang.Integer.valueOf(r2)     // Catch:{ all -> 0x0ccb }
            r13 = 2
            r6[r13] = r4     // Catch:{ all -> 0x0ccb }
            r4 = 0
            java.lang.Integer r13 = java.lang.Integer.valueOf(r4)     // Catch:{ all -> 0x0ccb }
            r14 = 1
            r6[r14] = r13     // Catch:{ all -> 0x0ccb }
            r6[r4] = r10     // Catch:{ all -> 0x0ccb }
            r4 = 17
            byte r13 = r12[r4]     // Catch:{ all -> 0x0ccb }
            byte r4 = (byte) r13     // Catch:{ all -> 0x0ccb }
            r13 = 832(0x340, float:1.166E-42)
            byte r13 = r12[r13]     // Catch:{ all -> 0x0ccb }
            byte r13 = (byte) r13     // Catch:{ all -> 0x0ccb }
            java.lang.String r4 = $$c(r8, r4, r13)     // Catch:{ all -> 0x0ccb }
            java.lang.Class r4 = java.lang.Class.forName(r4)     // Catch:{ all -> 0x0ccb }
            r13 = 712(0x2c8, float:9.98E-43)
            short r13 = (short) r13     // Catch:{ all -> 0x0ccb }
            r14 = 14
            byte r15 = r12[r14]     // Catch:{ all -> 0x0ccb }
            byte r14 = (byte) r15     // Catch:{ all -> 0x0ccb }
            byte r12 = r12[r26]     // Catch:{ all -> 0x0ccb }
            byte r12 = (byte) r12     // Catch:{ all -> 0x0ccb }
            java.lang.String r12 = $$c(r13, r14, r12)     // Catch:{ all -> 0x0ccb }
            r13 = 3
            java.lang.Class[] r14 = new java.lang.Class[r13]     // Catch:{ all -> 0x0ccb }
            r13 = 0
            r14[r13] = r1     // Catch:{ all -> 0x0ccb }
            java.lang.Class r13 = java.lang.Integer.TYPE     // Catch:{ all -> 0x0ccb }
            r15 = 1
            r14[r15] = r13     // Catch:{ all -> 0x0ccb }
            r15 = 2
            r14[r15] = r13     // Catch:{ all -> 0x0ccb }
            java.lang.reflect.Method r4 = r4.getMethod(r12, r14)     // Catch:{ all -> 0x0ccb }
            r4.invoke(r9, r6)     // Catch:{ all -> 0x0ccb }
            int r2 = -r2
            int r2 = -r2
            r4 = r11 ^ r2
            r2 = r2 & r11
            r6 = 1
            int r2 = r2 << r6
            int r11 = r4 + r2
            r13 = r47
            r2 = r48
            r4 = 16
            goto L_0x0c21
        L_0x0ccb:
            r0 = move-exception
            r2 = r0
            java.lang.Throwable r3 = r2.getCause()     // Catch:{ all -> 0x0fc8 }
            if (r3 == 0) goto L_0x0cd4
            throw r3     // Catch:{ all -> 0x0fc8 }
        L_0x0cd4:
            throw r2     // Catch:{ all -> 0x0fc8 }
        L_0x0cd5:
            r2 = 17
            byte r4 = r12[r2]     // Catch:{ all -> 0x0f94 }
            byte r2 = (byte) r4     // Catch:{ all -> 0x0f94 }
            r4 = 832(0x340, float:1.166E-42)
            byte r4 = r12[r4]     // Catch:{ all -> 0x0f94 }
            byte r4 = (byte) r4     // Catch:{ all -> 0x0f94 }
            java.lang.String r2 = $$c(r8, r2, r4)     // Catch:{ all -> 0x0f94 }
            java.lang.Class r2 = java.lang.Class.forName(r2)     // Catch:{ all -> 0x0f94 }
            r4 = 177(0xb1, float:2.48E-43)
            byte r4 = r12[r4]     // Catch:{ all -> 0x0f94 }
            r5 = 0
            int r4 = r4 - r5
            r5 = 1
            int r4 = r4 - r5
            short r4 = (short) r4     // Catch:{ all -> 0x0f94 }
            byte r5 = (byte) r13     // Catch:{ all -> 0x0f94 }
            r6 = 88
            byte r6 = r12[r6]     // Catch:{ all -> 0x0f94 }
            byte r6 = (byte) r6     // Catch:{ all -> 0x0f94 }
            java.lang.String r4 = $$c(r4, r5, r6)     // Catch:{ all -> 0x0f94 }
            r5 = 0
            java.lang.reflect.Method r2 = r2.getMethod(r4, r5)     // Catch:{ all -> 0x0f94 }
            java.lang.Object r2 = r2.invoke(r9, r5)     // Catch:{ all -> 0x0f94 }
            int r4 = onValidateInApp
            int r4 = r4 + 78
            r5 = 1
            int r4 = r4 - r5
            int r5 = r4 % 128
            getSdkVersion = r5
            r5 = 2
            int r4 = r4 % r5
            r4 = 17
            byte r5 = r12[r4]     // Catch:{ all -> 0x0d37 }
            byte r4 = (byte) r5     // Catch:{ all -> 0x0d37 }
            int r5 = r4 << 1
            byte r5 = (byte) r5     // Catch:{ all -> 0x0d37 }
            java.lang.String r3 = $$c(r3, r4, r5)     // Catch:{ all -> 0x0d37 }
            java.lang.Class r3 = java.lang.Class.forName(r3)     // Catch:{ all -> 0x0d37 }
            r4 = 305(0x131, float:4.27E-43)
            short r4 = (short) r4     // Catch:{ all -> 0x0d37 }
            r5 = 40
            byte r6 = r12[r5]     // Catch:{ all -> 0x0d37 }
            byte r5 = (byte) r6     // Catch:{ all -> 0x0d37 }
            byte r6 = r12[r26]     // Catch:{ all -> 0x0d37 }
            byte r6 = (byte) r6     // Catch:{ all -> 0x0d37 }
            java.lang.String r4 = $$c(r4, r5, r6)     // Catch:{ all -> 0x0d37 }
            r5 = 0
            java.lang.reflect.Method r3 = r3.getMethod(r4, r5)     // Catch:{ all -> 0x0d37 }
            r3.invoke(r7, r5)     // Catch:{ all -> 0x0d37 }
            goto L_0x0d41
        L_0x0d37:
            r0 = move-exception
            r3 = r0
            java.lang.Throwable r4 = r3.getCause()     // Catch:{ IOException -> 0x0d41 }
            if (r4 == 0) goto L_0x0d40
            throw r4     // Catch:{ IOException -> 0x0d41 }
        L_0x0d40:
            throw r3     // Catch:{ IOException -> 0x0d41 }
        L_0x0d41:
            int r3 = onValidateInApp
            r4 = r3 | 95
            r5 = 1
            int r4 = r4 << r5
            r3 = r3 ^ 95
            int r4 = r4 - r3
            int r3 = r4 % 128
            getSdkVersion = r3
            r3 = 2
            int r4 = r4 % r3
            byte[] r3 = AppsFlyerLib     // Catch:{ all -> 0x0d7c }
            r4 = 17
            byte r5 = r3[r4]     // Catch:{ all -> 0x0d7c }
            byte r4 = (byte) r5     // Catch:{ all -> 0x0d7c }
            r5 = 832(0x340, float:1.166E-42)
            byte r5 = r3[r5]     // Catch:{ all -> 0x0d7c }
            byte r5 = (byte) r5     // Catch:{ all -> 0x0d7c }
            java.lang.String r4 = $$c(r8, r4, r5)     // Catch:{ all -> 0x0d7c }
            java.lang.Class r4 = java.lang.Class.forName(r4)     // Catch:{ all -> 0x0d7c }
            r5 = 305(0x131, float:4.27E-43)
            short r5 = (short) r5     // Catch:{ all -> 0x0d7c }
            r6 = 40
            byte r7 = r3[r6]     // Catch:{ all -> 0x0d7c }
            byte r6 = (byte) r7     // Catch:{ all -> 0x0d7c }
            byte r3 = r3[r26]     // Catch:{ all -> 0x0d7c }
            byte r3 = (byte) r3     // Catch:{ all -> 0x0d7c }
            java.lang.String r3 = $$c(r5, r6, r3)     // Catch:{ all -> 0x0d7c }
            r5 = 0
            java.lang.reflect.Method r3 = r4.getMethod(r3, r5)     // Catch:{ all -> 0x0d7c }
            r3.invoke(r9, r5)     // Catch:{ all -> 0x0d7c }
            goto L_0x0d86
        L_0x0d7c:
            r0 = move-exception
            r3 = r0
            java.lang.Throwable r4 = r3.getCause()     // Catch:{ IOException -> 0x0d86 }
            if (r4 == 0) goto L_0x0d85
            throw r4     // Catch:{ IOException -> 0x0d86 }
        L_0x0d85:
            throw r3     // Catch:{ IOException -> 0x0d86 }
        L_0x0d86:
            java.lang.Class<com.appsflyer.internal.a> r3 = com.appsflyer.internal.a.class
            int r4 = getSdkVersion
            int r4 = r4 + 41
            int r5 = r4 % 128
            onValidateInApp = r5
            r5 = 2
            int r4 = r4 % r5
            java.lang.Class<java.lang.Class> r4 = java.lang.Class.class
            int r5 = AppsFlyerInAppPurchaseValidatorListener     // Catch:{ all -> 0x0f89 }
            r6 = r5 ^ 364(0x16c, float:5.1E-43)
            r7 = r5 & 364(0x16c, float:5.1E-43)
            r6 = r6 | r7
            short r6 = (short) r6     // Catch:{ all -> 0x0f89 }
            byte[] r7 = AppsFlyerLib     // Catch:{ all -> 0x0f89 }
            r8 = 571(0x23b, float:8.0E-43)
            byte r9 = r7[r8]     // Catch:{ all -> 0x0f89 }
            byte r8 = (byte) r9     // Catch:{ all -> 0x0f89 }
            r9 = 17
            byte r10 = r7[r9]     // Catch:{ all -> 0x0f89 }
            byte r9 = (byte) r10     // Catch:{ all -> 0x0f89 }
            java.lang.String r6 = $$c(r6, r8, r9)     // Catch:{ all -> 0x0f89 }
            r8 = 0
            java.lang.reflect.Method r4 = r4.getMethod(r6, r8)     // Catch:{ all -> 0x0f89 }
            java.lang.Object r3 = r4.invoke(r3, r8)     // Catch:{ all -> 0x0f89 }
            r4 = 796(0x31c, float:1.115E-42)
            short r4 = (short) r4
            r6 = 501(0x1f5, float:7.02E-43)
            byte r8 = r7[r6]     // Catch:{ all -> 0x0fc8 }
            byte r6 = (byte) r8     // Catch:{ all -> 0x0fc8 }
            r8 = 116(0x74, float:1.63E-43)
            byte r8 = r7[r8]     // Catch:{ all -> 0x0fc8 }
            byte r8 = (byte) r8     // Catch:{ all -> 0x0fc8 }
            java.lang.String r4 = $$c(r4, r6, r8)     // Catch:{ all -> 0x0fc8 }
            java.lang.Class r4 = java.lang.Class.forName(r4)     // Catch:{ all -> 0x0fc8 }
            r6 = 2
            java.lang.Class[] r8 = new java.lang.Class[r6]     // Catch:{ all -> 0x0fc8 }
            r6 = 864(0x360, float:1.211E-42)
            short r6 = (short) r6     // Catch:{ all -> 0x0fc8 }
            r9 = 17
            byte r10 = r7[r9]     // Catch:{ all -> 0x0fc8 }
            byte r9 = (byte) r10     // Catch:{ all -> 0x0fc8 }
            r10 = 70
            byte r11 = r7[r10]     // Catch:{ all -> 0x0fc8 }
            int r10 = -r11
            byte r10 = (byte) r10     // Catch:{ all -> 0x0fc8 }
            java.lang.String r9 = $$c(r6, r9, r10)     // Catch:{ all -> 0x0fc8 }
            java.lang.Class r9 = java.lang.Class.forName(r9)     // Catch:{ all -> 0x0fc8 }
            r10 = 0
            r8[r10] = r9     // Catch:{ all -> 0x0fc8 }
            r9 = 569(0x239, float:7.97E-43)
            short r9 = (short) r9     // Catch:{ all -> 0x0fc8 }
            r10 = 17
            byte r11 = r7[r10]     // Catch:{ all -> 0x0fc8 }
            byte r10 = (byte) r11     // Catch:{ all -> 0x0fc8 }
            r11 = 40
            byte r12 = r7[r11]     // Catch:{ all -> 0x0fc8 }
            byte r11 = (byte) r12     // Catch:{ all -> 0x0fc8 }
            java.lang.String r9 = $$c(r9, r10, r11)     // Catch:{ all -> 0x0fc8 }
            java.lang.Class r9 = java.lang.Class.forName(r9)     // Catch:{ all -> 0x0fc8 }
            r10 = 1
            r8[r10] = r9     // Catch:{ all -> 0x0fc8 }
            java.lang.reflect.Constructor r4 = r4.getDeclaredConstructor(r8)     // Catch:{ all -> 0x0fc8 }
            r8 = 2
            java.lang.Object[] r9 = new java.lang.Object[r8]     // Catch:{ all -> 0x0fc8 }
            java.lang.Object[] r8 = new java.lang.Object[r10]     // Catch:{ all -> 0x0f7e }
            r10 = 0
            r8[r10] = r2     // Catch:{ all -> 0x0f7e }
            r2 = 17
            byte r10 = r7[r2]     // Catch:{ all -> 0x0f7e }
            byte r2 = (byte) r10     // Catch:{ all -> 0x0f7e }
            r10 = 70
            byte r11 = r7[r10]     // Catch:{ all -> 0x0f7e }
            int r10 = -r11
            byte r10 = (byte) r10     // Catch:{ all -> 0x0f7e }
            java.lang.String r2 = $$c(r6, r2, r10)     // Catch:{ all -> 0x0f7e }
            java.lang.Class r2 = java.lang.Class.forName(r2)     // Catch:{ all -> 0x0f7e }
            r6 = 19
            byte r6 = r7[r6]     // Catch:{ all -> 0x0f7e }
            r10 = 1
            int r6 = r6 - r10
            short r6 = (short) r6     // Catch:{ all -> 0x0f7e }
            r11 = 14
            byte r12 = r7[r11]     // Catch:{ all -> 0x0f7e }
            byte r11 = (byte) r12     // Catch:{ all -> 0x0f7e }
            byte r12 = (byte) r5     // Catch:{ all -> 0x0f7e }
            java.lang.String r6 = $$c(r6, r11, r12)     // Catch:{ all -> 0x0f7e }
            java.lang.Class[] r11 = new java.lang.Class[r10]     // Catch:{ all -> 0x0f7e }
            r12 = 0
            r11[r12] = r1     // Catch:{ all -> 0x0f7e }
            java.lang.reflect.Method r2 = r2.getMethod(r6, r11)     // Catch:{ all -> 0x0f7e }
            r6 = 0
            java.lang.Object r2 = r2.invoke(r6, r8)     // Catch:{ all -> 0x0f7e }
            r9[r12] = r2     // Catch:{ all -> 0x0fc8 }
            r9[r10] = r3     // Catch:{ all -> 0x0fc8 }
            java.lang.Object r2 = r4.newInstance(r9)     // Catch:{ all -> 0x0fc8 }
            r4 = 666(0x29a, float:9.33E-43)
            short r4 = (short) r4
            r6 = 501(0x1f5, float:7.02E-43)
            byte r8 = r7[r6]     // Catch:{ Exception -> 0x0efe }
            byte r6 = (byte) r8     // Catch:{ Exception -> 0x0efe }
            r8 = 824(0x338, float:1.155E-42)
            byte r8 = r7[r8]     // Catch:{ Exception -> 0x0efe }
            byte r8 = (byte) r8     // Catch:{ Exception -> 0x0efe }
            java.lang.String r4 = $$c(r4, r6, r8)     // Catch:{ Exception -> 0x0efe }
            java.lang.Class r4 = java.lang.Class.forName(r4)     // Catch:{ Exception -> 0x0efe }
            r6 = r5 ^ 136(0x88, float:1.9E-43)
            r5 = r5 & 136(0x88, float:1.9E-43)
            r5 = r5 | r6
            short r5 = (short) r5     // Catch:{ Exception -> 0x0efe }
            r6 = 62
            byte r6 = r7[r6]     // Catch:{ Exception -> 0x0efe }
            byte r6 = (byte) r6     // Catch:{ Exception -> 0x0efe }
            byte r8 = (byte) r6     // Catch:{ Exception -> 0x0efe }
            java.lang.String r5 = $$c(r5, r6, r8)     // Catch:{ Exception -> 0x0efe }
            java.lang.reflect.Field r4 = r4.getDeclaredField(r5)     // Catch:{ Exception -> 0x0efe }
            r5 = 1
            r4.setAccessible(r5)     // Catch:{ Exception -> 0x0efe }
            java.lang.Object r5 = r4.get(r3)     // Catch:{ Exception -> 0x0efe }
            java.lang.Class r6 = r5.getClass()     // Catch:{ Exception -> 0x0efe }
            byte r8 = r7[r22]     // Catch:{ Exception -> 0x0efe }
            short r8 = (short) r8
            r9 = 4
            byte r10 = r7[r9]     // Catch:{ Exception -> 0x0efb }
            byte r9 = (byte) r10
            byte r10 = r7[r22]     // Catch:{ Exception -> 0x0efe }
            byte r10 = (byte) r10     // Catch:{ Exception -> 0x0efe }
            java.lang.String r8 = $$c(r8, r9, r10)     // Catch:{ Exception -> 0x0efe }
            java.lang.reflect.Field r8 = r6.getDeclaredField(r8)     // Catch:{ Exception -> 0x0efe }
            r9 = 1
            r8.setAccessible(r9)     // Catch:{ Exception -> 0x0efe }
            r9 = 329(0x149, float:4.61E-43)
            short r9 = (short) r9
            r11 = 4
            byte r10 = r7[r11]     // Catch:{ Exception -> 0x0ef9 }
            byte r10 = (byte) r10     // Catch:{ Exception -> 0x0ef9 }
            r12 = 397(0x18d, float:5.56E-43)
            byte r7 = r7[r12]     // Catch:{ Exception -> 0x0ef9 }
            byte r7 = (byte) r7     // Catch:{ Exception -> 0x0ef9 }
            java.lang.String r7 = $$c(r9, r10, r7)     // Catch:{ Exception -> 0x0ef9 }
            java.lang.reflect.Field r6 = r6.getDeclaredField(r7)     // Catch:{ Exception -> 0x0ef9 }
            r7 = 1
            r6.setAccessible(r7)     // Catch:{ Exception -> 0x0ef9 }
            java.lang.Object r7 = r8.get(r5)     // Catch:{ Exception -> 0x0ef9 }
            java.lang.Object r5 = r6.get(r5)     // Catch:{ Exception -> 0x0ef9 }
            java.lang.Object r4 = r4.get(r2)     // Catch:{ Exception -> 0x0ef9 }
            java.util.ArrayList r9 = new java.util.ArrayList     // Catch:{ Exception -> 0x0ef9 }
            java.util.List r7 = (java.util.List) r7     // Catch:{ Exception -> 0x0ef9 }
            r9.<init>(r7)     // Catch:{ Exception -> 0x0ef9 }
            java.lang.Class r7 = r5.getClass()     // Catch:{ Exception -> 0x0ef9 }
            java.lang.Class r7 = r7.getComponentType()     // Catch:{ Exception -> 0x0ef9 }
            int r10 = java.lang.reflect.Array.getLength(r5)     // Catch:{ Exception -> 0x0ef9 }
            java.lang.Object r7 = java.lang.reflect.Array.newInstance(r7, r10)     // Catch:{ Exception -> 0x0ef9 }
            r12 = 0
        L_0x0ecb:
            if (r12 >= r10) goto L_0x0ee2
            java.lang.Object r13 = java.lang.reflect.Array.get(r5, r12)     // Catch:{ Exception -> 0x0ef9 }
            java.lang.reflect.Array.set(r7, r12, r13)     // Catch:{ Exception -> 0x0ef9 }
            r13 = r12 | -42
            r14 = 1
            int r13 = r13 << r14
            r12 = r12 ^ -42
            int r13 = r13 - r12
            r12 = r13 | 43
            int r12 = r12 << r14
            r13 = r13 ^ 43
            int r12 = r12 - r13
            goto L_0x0ecb
        L_0x0ee2:
            r8.set(r4, r9)     // Catch:{ Exception -> 0x0ef9 }
            r6.set(r4, r7)     // Catch:{ Exception -> 0x0ef9 }
            java.lang.Object r3 = onAttributionFailure     // Catch:{ all -> 0x0fc8 }
            if (r3 != 0) goto L_0x0eee
            r3 = 1
            goto L_0x0eef
        L_0x0eee:
            r3 = 0
        L_0x0eef:
            if (r3 == 0) goto L_0x0ef3
            onAttributionFailure = r2     // Catch:{ all -> 0x0fc8 }
        L_0x0ef3:
            r12 = r45
            r5 = 3
            r11 = 6
            goto L_0x130c
        L_0x0ef9:
            r0 = move-exception
            goto L_0x0f00
        L_0x0efb:
            r0 = move-exception
            r11 = r9
            goto L_0x0f00
        L_0x0efe:
            r0 = move-exception
            r11 = 4
        L_0x0f00:
            r2 = r0
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x0fc8 }
            r4.<init>()     // Catch:{ all -> 0x0fc8 }
            r5 = 573(0x23d, float:8.03E-43)
            short r5 = (short) r5     // Catch:{ all -> 0x0fc8 }
            byte[] r6 = AppsFlyerLib     // Catch:{ all -> 0x0fc8 }
            r7 = 289(0x121, float:4.05E-43)
            byte r7 = r6[r7]     // Catch:{ all -> 0x0fc8 }
            byte r7 = (byte) r7     // Catch:{ all -> 0x0fc8 }
            byte r8 = r6[r26]     // Catch:{ all -> 0x0fc8 }
            byte r8 = (byte) r8     // Catch:{ all -> 0x0fc8 }
            java.lang.String r5 = $$c(r5, r7, r8)     // Catch:{ all -> 0x0fc8 }
            r4.append(r5)     // Catch:{ all -> 0x0fc8 }
            r4.append(r3)     // Catch:{ all -> 0x0fc8 }
            int r3 = AppsFlyerInAppPurchaseValidatorListener     // Catch:{ all -> 0x0fc8 }
            r5 = r3 ^ 692(0x2b4, float:9.7E-43)
            r3 = r3 & 692(0x2b4, float:9.7E-43)
            r3 = r3 | r5
            short r3 = (short) r3     // Catch:{ all -> 0x0fc8 }
            r5 = 371(0x173, float:5.2E-43)
            byte r5 = r6[r5]     // Catch:{ all -> 0x0fc8 }
            r7 = r5 & -1
            r5 = r5 | -1
            int r7 = r7 + r5
            byte r5 = (byte) r7     // Catch:{ all -> 0x0fc8 }
            r7 = 14
            byte r7 = r6[r7]     // Catch:{ all -> 0x0fc8 }
            byte r7 = (byte) r7     // Catch:{ all -> 0x0fc8 }
            java.lang.String r3 = $$c(r3, r5, r7)     // Catch:{ all -> 0x0fc8 }
            r4.append(r3)     // Catch:{ all -> 0x0fc8 }
            java.lang.String r3 = r4.toString()     // Catch:{ all -> 0x0fc8 }
            r4 = 2
            java.lang.Object[] r5 = new java.lang.Object[r4]     // Catch:{ all -> 0x0f74 }
            r4 = 1
            r5[r4] = r2     // Catch:{ all -> 0x0f74 }
            r2 = 0
            r5[r2] = r3     // Catch:{ all -> 0x0f74 }
            r2 = 178(0xb2, float:2.5E-43)
            short r2 = (short) r2     // Catch:{ all -> 0x0f74 }
            r3 = 17
            byte r4 = r6[r3]     // Catch:{ all -> 0x0f74 }
            byte r3 = (byte) r4     // Catch:{ all -> 0x0f74 }
            r4 = 70
            byte r6 = r6[r4]     // Catch:{ all -> 0x0f74 }
            int r4 = -r6
            byte r4 = (byte) r4     // Catch:{ all -> 0x0f74 }
            java.lang.String r2 = $$c(r2, r3, r4)     // Catch:{ all -> 0x0f74 }
            java.lang.Class r2 = java.lang.Class.forName(r2)     // Catch:{ all -> 0x0f74 }
            r3 = 2
            java.lang.Class[] r4 = new java.lang.Class[r3]     // Catch:{ all -> 0x0f74 }
            r3 = 0
            r4[r3] = r48     // Catch:{ all -> 0x0f74 }
            java.lang.Class<java.lang.Throwable> r3 = java.lang.Throwable.class
            r6 = 1
            r4[r6] = r3     // Catch:{ all -> 0x0f74 }
            java.lang.reflect.Constructor r2 = r2.getDeclaredConstructor(r4)     // Catch:{ all -> 0x0f74 }
            java.lang.Object r2 = r2.newInstance(r5)     // Catch:{ all -> 0x0f74 }
            java.lang.Throwable r2 = (java.lang.Throwable) r2     // Catch:{ all -> 0x0f74 }
            throw r2     // Catch:{ all -> 0x0f74 }
        L_0x0f74:
            r0 = move-exception
            r2 = r0
            java.lang.Throwable r3 = r2.getCause()     // Catch:{ all -> 0x0fc8 }
            if (r3 == 0) goto L_0x0f7d
            throw r3     // Catch:{ all -> 0x0fc8 }
        L_0x0f7d:
            throw r2     // Catch:{ all -> 0x0fc8 }
        L_0x0f7e:
            r0 = move-exception
            r11 = 4
            r2 = r0
            java.lang.Throwable r3 = r2.getCause()     // Catch:{ all -> 0x0fc8 }
            if (r3 == 0) goto L_0x0f88
            throw r3     // Catch:{ all -> 0x0fc8 }
        L_0x0f88:
            throw r2     // Catch:{ all -> 0x0fc8 }
        L_0x0f89:
            r0 = move-exception
            r11 = 4
            r2 = r0
            java.lang.Throwable r3 = r2.getCause()     // Catch:{ all -> 0x0fc8 }
            if (r3 == 0) goto L_0x0f93
            throw r3     // Catch:{ all -> 0x0fc8 }
        L_0x0f93:
            throw r2     // Catch:{ all -> 0x0fc8 }
        L_0x0f94:
            r0 = move-exception
            r11 = 4
            r2 = r0
            java.lang.Throwable r3 = r2.getCause()     // Catch:{ all -> 0x0fc8 }
            if (r3 == 0) goto L_0x0f9e
            throw r3     // Catch:{ all -> 0x0fc8 }
        L_0x0f9e:
            throw r2     // Catch:{ all -> 0x0fc8 }
        L_0x0f9f:
            r0 = move-exception
            goto L_0x0fa4
        L_0x0fa1:
            r0 = move-exception
            r48 = r2
        L_0x0fa4:
            r11 = 4
            r2 = r0
            java.lang.Throwable r3 = r2.getCause()     // Catch:{ all -> 0x0fc8 }
            if (r3 == 0) goto L_0x0fad
            throw r3     // Catch:{ all -> 0x0fc8 }
        L_0x0fad:
            throw r2     // Catch:{ all -> 0x0fc8 }
        L_0x0fae:
            r0 = move-exception
            r48 = r2
            r11 = 4
            r2 = r0
            java.lang.Throwable r3 = r2.getCause()     // Catch:{ all -> 0x0fc8 }
            if (r3 == 0) goto L_0x0fba
            throw r3     // Catch:{ all -> 0x0fc8 }
        L_0x0fba:
            throw r2     // Catch:{ all -> 0x0fc8 }
        L_0x0fbb:
            r0 = move-exception
            r48 = r2
            r11 = 4
            r2 = r0
            java.lang.Throwable r3 = r2.getCause()     // Catch:{ all -> 0x0fc8 }
            if (r3 == 0) goto L_0x0fc7
            throw r3     // Catch:{ all -> 0x0fc8 }
        L_0x0fc7:
            throw r2     // Catch:{ all -> 0x0fc8 }
        L_0x0fc8:
            r0 = move-exception
            goto L_0x0fcd
        L_0x0fca:
            r0 = move-exception
            r48 = r2
        L_0x0fcd:
            r2 = r0
            r12 = r45
        L_0x0fd0:
            r6 = 60
            r7 = 40
            r13 = 571(0x23b, float:8.0E-43)
            goto L_0x185b
        L_0x0fd8:
            r48 = r2
            r47 = r13
            r11 = 4
            java.lang.Object r2 = onDeepLinking     // Catch:{ all -> 0x1788 }
            if (r2 != 0) goto L_0x0fe3
            r3 = 1
            goto L_0x0fe4
        L_0x0fe3:
            r3 = 0
        L_0x0fe4:
            if (r3 == 0) goto L_0x0fe9
            r3 = r25
            goto L_0x0feb
        L_0x0fe9:
            r3 = r33
        L_0x0feb:
            if (r2 != 0) goto L_0x0ff0
            r2 = r36
            goto L_0x0ff2
        L_0x0ff0:
            r2 = r32
        L_0x0ff2:
            r4 = 1
            java.lang.Object[] r5 = new java.lang.Object[r4]     // Catch:{ all -> 0x1674 }
            r4 = 0
            r5[r4] = r3     // Catch:{ all -> 0x1674 }
            r4 = 208(0xd0, float:2.91E-43)
            short r4 = (short) r4     // Catch:{ all -> 0x1674 }
            r6 = 17
            byte r7 = r12[r6]     // Catch:{ all -> 0x1674 }
            byte r6 = (byte) r7     // Catch:{ all -> 0x1674 }
            byte r7 = r12[r22]     // Catch:{ all -> 0x1674 }
            byte r7 = (byte) r7     // Catch:{ all -> 0x1674 }
            java.lang.String r6 = $$c(r4, r6, r7)     // Catch:{ all -> 0x1674 }
            java.lang.Class r6 = java.lang.Class.forName(r6)     // Catch:{ all -> 0x1674 }
            r7 = 1
            java.lang.Class[] r8 = new java.lang.Class[r7]     // Catch:{ all -> 0x1674 }
            r7 = 17
            byte r9 = r12[r7]     // Catch:{ all -> 0x1674 }
            byte r7 = (byte) r9     // Catch:{ all -> 0x1674 }
            r9 = 60
            byte r12 = r12[r9]     // Catch:{ all -> 0x1674 }
            byte r9 = (byte) r12
            r12 = r45
            java.lang.String r7 = $$c(r12, r7, r9)     // Catch:{ all -> 0x1672 }
            java.lang.Class r7 = java.lang.Class.forName(r7)     // Catch:{ all -> 0x1672 }
            r9 = 0
            r8[r9] = r7     // Catch:{ all -> 0x1672 }
            java.lang.reflect.Constructor r6 = r6.getDeclaredConstructor(r8)     // Catch:{ all -> 0x1672 }
            java.lang.Object r5 = r6.newInstance(r5)     // Catch:{ all -> 0x1672 }
            r6 = 1024(0x400, float:1.435E-42)
            byte[] r7 = new byte[r6]     // Catch:{ all -> 0x166c }
            r8 = r42
        L_0x1033:
            if (r8 <= 0) goto L_0x1037
            r9 = 1
            goto L_0x1038
        L_0x1037:
            r9 = 0
        L_0x1038:
            r13 = 1
            if (r9 == r13) goto L_0x103d
            goto L_0x1125
        L_0x103d:
            int r9 = java.lang.Math.min(r6, r8)     // Catch:{ all -> 0x166c }
            int r13 = onValidateInApp
            int r13 = r13 + 77
            int r14 = r13 % 128
            getSdkVersion = r14
            r14 = 2
            int r13 = r13 % r14
            r13 = 3
            java.lang.Object[] r15 = new java.lang.Object[r13]     // Catch:{ all -> 0x165e }
            java.lang.Integer r9 = java.lang.Integer.valueOf(r9)     // Catch:{ all -> 0x165e }
            r15[r14] = r9     // Catch:{ all -> 0x165e }
            r9 = 0
            java.lang.Integer r13 = java.lang.Integer.valueOf(r9)     // Catch:{ all -> 0x165e }
            r14 = 1
            r15[r14] = r13     // Catch:{ all -> 0x165e }
            r15[r9] = r7     // Catch:{ all -> 0x165e }
            byte[] r9 = AppsFlyerLib     // Catch:{ all -> 0x165e }
            r13 = 14
            byte r14 = r9[r13]     // Catch:{ all -> 0x165e }
            short r13 = (short) r14     // Catch:{ all -> 0x165e }
            r14 = 17
            byte r6 = r9[r14]     // Catch:{ all -> 0x165e }
            byte r6 = (byte) r6     // Catch:{ all -> 0x165e }
            r14 = 70
            byte r11 = r9[r14]     // Catch:{ all -> 0x165e }
            int r11 = -r11
            byte r11 = (byte) r11     // Catch:{ all -> 0x165e }
            java.lang.String r6 = $$c(r13, r6, r11)     // Catch:{ all -> 0x165e }
            java.lang.Class r6 = java.lang.Class.forName(r6)     // Catch:{ all -> 0x165e }
            r11 = 698(0x2ba, float:9.78E-43)
            short r11 = (short) r11     // Catch:{ all -> 0x165e }
            r13 = 92
            byte r14 = r9[r13]     // Catch:{ all -> 0x165e }
            byte r13 = (byte) r14     // Catch:{ all -> 0x165e }
            int r14 = AppsFlyerInAppPurchaseValidatorListener     // Catch:{ all -> 0x165e }
            byte r14 = (byte) r14     // Catch:{ all -> 0x165e }
            java.lang.String r11 = $$c(r11, r13, r14)     // Catch:{ all -> 0x165e }
            r13 = 3
            java.lang.Class[] r14 = new java.lang.Class[r13]     // Catch:{ all -> 0x165e }
            r13 = 0
            r14[r13] = r1     // Catch:{ all -> 0x165e }
            java.lang.Class r13 = java.lang.Integer.TYPE     // Catch:{ all -> 0x165e }
            r17 = 1
            r14[r17] = r13     // Catch:{ all -> 0x165e }
            r18 = 2
            r14[r18] = r13     // Catch:{ all -> 0x165e }
            java.lang.reflect.Method r6 = r6.getMethod(r11, r14)     // Catch:{ all -> 0x165e }
            java.lang.Object r6 = r6.invoke(r10, r15)     // Catch:{ all -> 0x165e }
            java.lang.Integer r6 = (java.lang.Integer) r6     // Catch:{ all -> 0x165e }
            int r6 = r6.intValue()     // Catch:{ all -> 0x165e }
            r11 = -1
            if (r6 == r11) goto L_0x10ab
            r11 = 35
            goto L_0x10ad
        L_0x10ab:
            r11 = 22
        L_0x10ad:
            r14 = 22
            if (r11 == r14) goto L_0x1125
            int r11 = getSdkVersion
            r14 = r11 & 47
            r11 = r11 | 47
            int r14 = r14 + r11
            int r11 = r14 % 128
            onValidateInApp = r11
            r11 = 2
            int r14 = r14 % r11
            r14 = 3
            java.lang.Object[] r15 = new java.lang.Object[r14]     // Catch:{ all -> 0x1113 }
            java.lang.Integer r14 = java.lang.Integer.valueOf(r6)     // Catch:{ all -> 0x1113 }
            r15[r11] = r14     // Catch:{ all -> 0x1113 }
            r11 = 0
            java.lang.Integer r14 = java.lang.Integer.valueOf(r11)     // Catch:{ all -> 0x1113 }
            r17 = 1
            r15[r17] = r14     // Catch:{ all -> 0x1113 }
            r15[r11] = r7     // Catch:{ all -> 0x1113 }
            r11 = 17
            byte r14 = r9[r11]     // Catch:{ all -> 0x1113 }
            byte r11 = (byte) r14     // Catch:{ all -> 0x1113 }
            byte r14 = r9[r22]     // Catch:{ all -> 0x1113 }
            byte r14 = (byte) r14     // Catch:{ all -> 0x1113 }
            java.lang.String r11 = $$c(r4, r11, r14)     // Catch:{ all -> 0x1113 }
            java.lang.Class r11 = java.lang.Class.forName(r11)     // Catch:{ all -> 0x1113 }
            r14 = 712(0x2c8, float:9.98E-43)
            short r14 = (short) r14     // Catch:{ all -> 0x1113 }
            r45 = r7
            r27 = 14
            byte r7 = r9[r27]     // Catch:{ all -> 0x1113 }
            byte r7 = (byte) r7     // Catch:{ all -> 0x1113 }
            byte r9 = r9[r26]     // Catch:{ all -> 0x1113 }
            byte r9 = (byte) r9     // Catch:{ all -> 0x1113 }
            java.lang.String r7 = $$c(r14, r7, r9)     // Catch:{ all -> 0x1113 }
            r9 = 3
            java.lang.Class[] r14 = new java.lang.Class[r9]     // Catch:{ all -> 0x1113 }
            r9 = 0
            r14[r9] = r1     // Catch:{ all -> 0x1113 }
            r9 = 1
            r14[r9] = r13     // Catch:{ all -> 0x1113 }
            r9 = 2
            r14[r9] = r13     // Catch:{ all -> 0x1113 }
            java.lang.reflect.Method r7 = r11.getMethod(r7, r14)     // Catch:{ all -> 0x1113 }
            r7.invoke(r5, r15)     // Catch:{ all -> 0x1113 }
            int r6 = -r6
            r7 = r8 & r6
            r6 = r6 | r8
            int r8 = r7 + r6
            r7 = r45
            r6 = 1024(0x400, float:1.435E-42)
            r11 = 4
            goto L_0x1033
        L_0x1113:
            r0 = move-exception
            r4 = r0
            java.lang.Throwable r5 = r4.getCause()     // Catch:{ all -> 0x111d }
            if (r5 == 0) goto L_0x111c
            throw r5     // Catch:{ all -> 0x111d }
        L_0x111c:
            throw r4     // Catch:{ all -> 0x111d }
        L_0x111d:
            r0 = move-exception
            r4 = r0
            r7 = 40
            r13 = 571(0x23b, float:8.0E-43)
            goto L_0x1709
        L_0x1125:
            byte[] r6 = AppsFlyerLib     // Catch:{ all -> 0x1650 }
            r7 = 17
            byte r8 = r6[r7]     // Catch:{ all -> 0x1650 }
            byte r7 = (byte) r8     // Catch:{ all -> 0x1650 }
            byte r8 = r6[r22]     // Catch:{ all -> 0x1650 }
            byte r8 = (byte) r8     // Catch:{ all -> 0x1650 }
            java.lang.String r7 = $$c(r4, r7, r8)     // Catch:{ all -> 0x1650 }
            java.lang.Class r7 = java.lang.Class.forName(r7)     // Catch:{ all -> 0x1650 }
            int r8 = AppsFlyerInAppPurchaseValidatorListener     // Catch:{ all -> 0x1650 }
            r9 = r8 ^ 336(0x150, float:4.71E-43)
            r10 = r8 & 336(0x150, float:4.71E-43)
            r9 = r9 | r10
            short r9 = (short) r9
            r10 = 571(0x23b, float:8.0E-43)
            byte r11 = r6[r10]     // Catch:{ all -> 0x164b }
            byte r10 = (byte) r11
            byte r11 = r6[r26]     // Catch:{ all -> 0x1650 }
            byte r11 = (byte) r11     // Catch:{ all -> 0x1650 }
            java.lang.String r9 = $$c(r9, r10, r11)     // Catch:{ all -> 0x1650 }
            r10 = 0
            java.lang.reflect.Method r7 = r7.getMethod(r9, r10)     // Catch:{ all -> 0x1650 }
            java.lang.Object r7 = r7.invoke(r5, r10)     // Catch:{ all -> 0x1650 }
            int r9 = getSdkVersion
            r10 = r9 ^ 49
            r9 = r9 & 49
            r11 = 1
            int r9 = r9 << r11
            int r10 = r10 + r9
            int r9 = r10 % 128
            onValidateInApp = r9
            r9 = 2
            int r10 = r10 % r9
            r9 = 81
            short r9 = (short) r9
            r10 = 17
            byte r11 = r6[r10]     // Catch:{ all -> 0x163d }
            byte r10 = (byte) r11     // Catch:{ all -> 0x163d }
            r11 = 6
            byte r13 = r6[r11]     // Catch:{ all -> 0x163d }
            byte r13 = (byte) r13     // Catch:{ all -> 0x163d }
            java.lang.String r9 = $$c(r9, r10, r13)     // Catch:{ all -> 0x163d }
            java.lang.Class r9 = java.lang.Class.forName(r9)     // Catch:{ all -> 0x163d }
            r10 = 606(0x25e, float:8.49E-43)
            short r10 = (short) r10     // Catch:{ all -> 0x163d }
            byte r13 = r6[r26]     // Catch:{ all -> 0x163d }
            byte r13 = (byte) r13     // Catch:{ all -> 0x163d }
            byte r14 = (byte) r8     // Catch:{ all -> 0x163d }
            java.lang.String r10 = $$c(r10, r13, r14)     // Catch:{ all -> 0x163d }
            r13 = 0
            java.lang.reflect.Method r9 = r9.getMethod(r10, r13)     // Catch:{ all -> 0x163d }
            r9.invoke(r7, r13)     // Catch:{ all -> 0x163d }
            int r7 = getSdkVersion
            r9 = r7 & 41
            r7 = r7 | 41
            int r9 = r9 + r7
            int r7 = r9 % 128
            onValidateInApp = r7
            r7 = 2
            int r9 = r9 % r7
            r7 = 17
            byte r9 = r6[r7]     // Catch:{ all -> 0x162f }
            byte r7 = (byte) r9     // Catch:{ all -> 0x162f }
            byte r9 = r6[r22]     // Catch:{ all -> 0x162f }
            byte r9 = (byte) r9     // Catch:{ all -> 0x162f }
            java.lang.String r4 = $$c(r4, r7, r9)     // Catch:{ all -> 0x162f }
            java.lang.Class r4 = java.lang.Class.forName(r4)     // Catch:{ all -> 0x162f }
            r7 = 305(0x131, float:4.27E-43)
            short r7 = (short) r7
            r9 = 40
            byte r10 = r6[r9]     // Catch:{ all -> 0x162c }
            byte r9 = (byte) r10
            byte r10 = r6[r26]     // Catch:{ all -> 0x162f }
            byte r10 = (byte) r10     // Catch:{ all -> 0x162f }
            java.lang.String r7 = $$c(r7, r9, r10)     // Catch:{ all -> 0x162f }
            r9 = 0
            java.lang.reflect.Method r4 = r4.getMethod(r7, r9)     // Catch:{ all -> 0x162f }
            r4.invoke(r5, r9)     // Catch:{ all -> 0x162f }
            r4 = r8 | 692(0x2b4, float:9.7E-43)
            short r4 = (short) r4
            r5 = 501(0x1f5, float:7.02E-43)
            byte r7 = r6[r5]     // Catch:{ all -> 0x166c }
            byte r5 = (byte) r7
            r7 = 40
            byte r9 = r6[r7]     // Catch:{ all -> 0x162a }
            byte r7 = (byte) r9
            java.lang.String r4 = $$c(r4, r5, r7)     // Catch:{ all -> 0x166c }
            java.lang.Class r4 = java.lang.Class.forName(r4)     // Catch:{ all -> 0x166c }
            r5 = r8 ^ 452(0x1c4, float:6.33E-43)
            r7 = r8 & 452(0x1c4, float:6.33E-43)
            r5 = r5 | r7
            short r5 = (short) r5     // Catch:{ all -> 0x166c }
            r7 = 60
            byte r9 = r6[r7]     // Catch:{ all -> 0x166c }
            byte r7 = (byte) r9     // Catch:{ all -> 0x166c }
            r9 = 66
            byte r9 = r6[r9]     // Catch:{ all -> 0x166c }
            byte r9 = (byte) r9     // Catch:{ all -> 0x166c }
            java.lang.String r5 = $$c(r5, r7, r9)     // Catch:{ all -> 0x166c }
            r7 = 3
            java.lang.Class[] r9 = new java.lang.Class[r7]     // Catch:{ all -> 0x166c }
            r7 = 0
            r9[r7] = r48     // Catch:{ all -> 0x166c }
            r7 = 1
            r9[r7] = r48     // Catch:{ all -> 0x166c }
            java.lang.Class r7 = java.lang.Integer.TYPE     // Catch:{ all -> 0x166c }
            r10 = 2
            r9[r10] = r7     // Catch:{ all -> 0x166c }
            java.lang.reflect.Method r4 = r4.getDeclaredMethod(r5, r9)     // Catch:{ all -> 0x166c }
            r5 = 3
            java.lang.Object[] r7 = new java.lang.Object[r5]     // Catch:{ all -> 0x166c }
            r9 = 17
            byte r10 = r6[r9]     // Catch:{ all -> 0x161c }
            byte r9 = (byte) r10     // Catch:{ all -> 0x161c }
            r10 = 60
            byte r13 = r6[r10]     // Catch:{ all -> 0x161c }
            byte r10 = (byte) r13     // Catch:{ all -> 0x161c }
            java.lang.String r9 = $$c(r12, r9, r10)     // Catch:{ all -> 0x161c }
            java.lang.Class r9 = java.lang.Class.forName(r9)     // Catch:{ all -> 0x161c }
            r10 = 253(0xfd, float:3.55E-43)
            short r10 = (short) r10
            r13 = 571(0x23b, float:8.0E-43)
            byte r14 = r6[r13]     // Catch:{ all -> 0x1618 }
            byte r13 = (byte) r14
            r14 = 203(0xcb, float:2.84E-43)
            byte r14 = r6[r14]     // Catch:{ all -> 0x161c }
            byte r14 = (byte) r14     // Catch:{ all -> 0x161c }
            java.lang.String r13 = $$c(r10, r13, r14)     // Catch:{ all -> 0x161c }
            r14 = 0
            java.lang.reflect.Method r9 = r9.getMethod(r13, r14)     // Catch:{ all -> 0x161c }
            java.lang.Object r9 = r9.invoke(r3, r14)     // Catch:{ all -> 0x161c }
            r13 = 0
            r7[r13] = r9     // Catch:{ all -> 0x166c }
            r9 = 17
            byte r13 = r6[r9]     // Catch:{ all -> 0x160a }
            byte r9 = (byte) r13     // Catch:{ all -> 0x160a }
            r13 = 60
            byte r14 = r6[r13]     // Catch:{ all -> 0x160a }
            byte r13 = (byte) r14     // Catch:{ all -> 0x160a }
            java.lang.String r9 = $$c(r12, r9, r13)     // Catch:{ all -> 0x160a }
            java.lang.Class r9 = java.lang.Class.forName(r9)     // Catch:{ all -> 0x160a }
            r13 = 571(0x23b, float:8.0E-43)
            byte r14 = r6[r13]     // Catch:{ all -> 0x1606 }
            byte r13 = (byte) r14
            r14 = 203(0xcb, float:2.84E-43)
            byte r14 = r6[r14]     // Catch:{ all -> 0x160a }
            byte r14 = (byte) r14     // Catch:{ all -> 0x160a }
            java.lang.String r10 = $$c(r10, r13, r14)     // Catch:{ all -> 0x160a }
            r13 = 0
            java.lang.reflect.Method r9 = r9.getMethod(r10, r13)     // Catch:{ all -> 0x160a }
            java.lang.Object r9 = r9.invoke(r2, r13)     // Catch:{ all -> 0x160a }
            r10 = 1
            r7[r10] = r9     // Catch:{ all -> 0x166c }
            r9 = 0
            java.lang.Integer r10 = java.lang.Integer.valueOf(r9)     // Catch:{ all -> 0x166c }
            r9 = 2
            r7[r9] = r10     // Catch:{ all -> 0x166c }
            java.lang.Object r4 = r4.invoke(r13, r7)     // Catch:{ all -> 0x166c }
            r7 = 17
            byte r9 = r6[r7]     // Catch:{ all -> 0x15f2 }
            byte r7 = (byte) r9     // Catch:{ all -> 0x15f2 }
            r9 = 60
            byte r10 = r6[r9]     // Catch:{ all -> 0x15f2 }
            byte r9 = (byte) r10     // Catch:{ all -> 0x15f2 }
            java.lang.String r7 = $$c(r12, r7, r9)     // Catch:{ all -> 0x15f2 }
            java.lang.Class r7 = java.lang.Class.forName(r7)     // Catch:{ all -> 0x15f2 }
            r9 = 344(0x158, float:4.82E-43)
            short r9 = (short) r9     // Catch:{ all -> 0x15f2 }
            r10 = 501(0x1f5, float:7.02E-43)
            byte r13 = r6[r10]     // Catch:{ all -> 0x15f2 }
            byte r10 = (byte) r13     // Catch:{ all -> 0x15f2 }
            r13 = 92
            byte r14 = r6[r13]     // Catch:{ all -> 0x15f2 }
            byte r13 = (byte) r14     // Catch:{ all -> 0x15f2 }
            java.lang.String r10 = $$c(r9, r10, r13)     // Catch:{ all -> 0x15f2 }
            r13 = 0
            java.lang.reflect.Method r7 = r7.getMethod(r10, r13)     // Catch:{ all -> 0x15f2 }
            java.lang.Object r3 = r7.invoke(r3, r13)     // Catch:{ all -> 0x15f2 }
            java.lang.Boolean r3 = (java.lang.Boolean) r3     // Catch:{ all -> 0x15f2 }
            r3.booleanValue()     // Catch:{ all -> 0x15f2 }
            r3 = 17
            byte r7 = r6[r3]     // Catch:{ all -> 0x15e4 }
            byte r3 = (byte) r7     // Catch:{ all -> 0x15e4 }
            r7 = 60
            byte r10 = r6[r7]     // Catch:{ all -> 0x15e4 }
            byte r7 = (byte) r10     // Catch:{ all -> 0x15e4 }
            java.lang.String r3 = $$c(r12, r3, r7)     // Catch:{ all -> 0x15e4 }
            java.lang.Class r3 = java.lang.Class.forName(r3)     // Catch:{ all -> 0x15e4 }
            r7 = 501(0x1f5, float:7.02E-43)
            byte r10 = r6[r7]     // Catch:{ all -> 0x15e4 }
            byte r7 = (byte) r10     // Catch:{ all -> 0x15e4 }
            r10 = 92
            byte r13 = r6[r10]     // Catch:{ all -> 0x15e4 }
            byte r10 = (byte) r13     // Catch:{ all -> 0x15e4 }
            java.lang.String r7 = $$c(r9, r7, r10)     // Catch:{ all -> 0x15e4 }
            r9 = 0
            java.lang.reflect.Method r3 = r3.getMethod(r7, r9)     // Catch:{ all -> 0x15e4 }
            java.lang.Object r2 = r3.invoke(r2, r9)     // Catch:{ all -> 0x15e4 }
            java.lang.Boolean r2 = (java.lang.Boolean) r2     // Catch:{ all -> 0x15e4 }
            r2.booleanValue()     // Catch:{ all -> 0x15e4 }
            java.lang.Object r2 = onAttributionFailure     // Catch:{ all -> 0x15de }
            if (r2 != 0) goto L_0x12c9
            r2 = 80
            goto L_0x12cb
        L_0x12c9:
            r2 = 64
        L_0x12cb:
            r3 = 64
            if (r2 == r3) goto L_0x130b
            java.lang.Class<com.appsflyer.internal.a> r2 = com.appsflyer.internal.a.class
            int r3 = getSdkVersion
            int r3 = r3 + 65
            int r7 = r3 % 128
            onValidateInApp = r7
            r7 = 2
            int r3 = r3 % r7
            java.lang.Class<java.lang.Class> r3 = java.lang.Class.class
            r7 = r8 ^ 364(0x16c, float:5.1E-43)
            r8 = r8 & 364(0x16c, float:5.1E-43)
            r7 = r7 | r8
            short r7 = (short) r7     // Catch:{ all -> 0x12fd }
            r8 = 571(0x23b, float:8.0E-43)
            byte r9 = r6[r8]     // Catch:{ all -> 0x12fd }
            byte r8 = (byte) r9     // Catch:{ all -> 0x12fd }
            r9 = 17
            byte r6 = r6[r9]     // Catch:{ all -> 0x12fd }
            byte r6 = (byte) r6     // Catch:{ all -> 0x12fd }
            java.lang.String r6 = $$c(r7, r8, r6)     // Catch:{ all -> 0x12fd }
            r7 = 0
            java.lang.reflect.Method r3 = r3.getMethod(r6, r7)     // Catch:{ all -> 0x12fd }
            java.lang.Object r2 = r3.invoke(r2, r7)     // Catch:{ all -> 0x12fd }
            onAttributionFailure = r2     // Catch:{ all -> 0x1307 }
            goto L_0x130b
        L_0x12fd:
            r0 = move-exception
            r2 = r0
            java.lang.Throwable r3 = r2.getCause()     // Catch:{ all -> 0x1307 }
            if (r3 == 0) goto L_0x1306
            throw r3     // Catch:{ all -> 0x1307 }
        L_0x1306:
            throw r2     // Catch:{ all -> 0x1307 }
        L_0x1307:
            r0 = move-exception
            r2 = r0
            goto L_0x0fd0
        L_0x130b:
            r2 = r4
        L_0x130c:
            if (r47 == 0) goto L_0x1310
            r3 = 0
            goto L_0x1311
        L_0x1310:
            r3 = 1
        L_0x1311:
            r4 = 1
            if (r3 == r4) goto L_0x13f1
            int r3 = onValidateInApp
            r4 = r3 & 25
            r3 = r3 | 25
            int r4 = r4 + r3
            int r3 = r4 % 128
            getSdkVersion = r3
            r3 = 2
            int r4 = r4 % r3
            int r3 = AppsFlyerInAppPurchaseValidatorListener     // Catch:{ all -> 0x13e7 }
            r4 = r3 ^ 692(0x2b4, float:9.7E-43)
            r6 = r3 & 692(0x2b4, float:9.7E-43)
            r4 = r4 | r6
            short r4 = (short) r4     // Catch:{ all -> 0x13e7 }
            byte[] r6 = AppsFlyerLib     // Catch:{ all -> 0x13e7 }
            r7 = 501(0x1f5, float:7.02E-43)
            byte r7 = r6[r7]     // Catch:{ all -> 0x13e7 }
            byte r7 = (byte) r7
            r8 = 40
            byte r9 = r6[r8]     // Catch:{ all -> 0x13e0 }
            byte r8 = (byte) r9
            java.lang.String r4 = $$c(r4, r7, r8)     // Catch:{ all -> 0x13e7 }
            java.lang.Class r4 = java.lang.Class.forName(r4)     // Catch:{ all -> 0x13e7 }
            r7 = 289(0x121, float:4.05E-43)
            byte r7 = r6[r7]     // Catch:{ all -> 0x13e7 }
            short r7 = (short) r7
            r8 = 60
            byte r9 = r6[r8]     // Catch:{ all -> 0x13da }
            byte r8 = (byte) r9
            r9 = 136(0x88, float:1.9E-43)
            byte r9 = r6[r9]     // Catch:{ all -> 0x13e7 }
            byte r9 = (byte) r9     // Catch:{ all -> 0x13e7 }
            java.lang.String r7 = $$c(r7, r8, r9)     // Catch:{ all -> 0x13e7 }
            r8 = 2
            java.lang.Class[] r9 = new java.lang.Class[r8]     // Catch:{ all -> 0x13e7 }
            r8 = 0
            r9[r8] = r48     // Catch:{ all -> 0x13e7 }
            r8 = 569(0x239, float:7.97E-43)
            short r8 = (short) r8     // Catch:{ all -> 0x13e7 }
            r10 = 17
            byte r13 = r6[r10]     // Catch:{ all -> 0x13e7 }
            byte r10 = (byte) r13     // Catch:{ all -> 0x13e7 }
            r13 = 40
            byte r14 = r6[r13]     // Catch:{ all -> 0x13e7 }
            byte r13 = (byte) r14     // Catch:{ all -> 0x13e7 }
            java.lang.String r8 = $$c(r8, r10, r13)     // Catch:{ all -> 0x13e7 }
            java.lang.Class r8 = java.lang.Class.forName(r8)     // Catch:{ all -> 0x13e7 }
            r10 = 1
            r9[r10] = r8     // Catch:{ all -> 0x13e7 }
            java.lang.reflect.Method r7 = r4.getDeclaredMethod(r7, r9)     // Catch:{ all -> 0x13e7 }
            r8 = 2
            java.lang.Object[] r9 = new java.lang.Object[r8]     // Catch:{ all -> 0x13e7 }
            r8 = 0
            r9[r8] = r44     // Catch:{ all -> 0x13e7 }
            java.lang.Class<com.appsflyer.internal.a> r8 = com.appsflyer.internal.a.class
            int r10 = getSdkVersion
            r13 = r10 & 123(0x7b, float:1.72E-43)
            r10 = r10 | 123(0x7b, float:1.72E-43)
            int r13 = r13 + r10
            int r10 = r13 % 128
            onValidateInApp = r10
            r10 = 2
            int r13 = r13 % r10
            java.lang.Class<java.lang.Class> r10 = java.lang.Class.class
            r13 = r3 ^ 364(0x16c, float:5.1E-43)
            r3 = r3 & 364(0x16c, float:5.1E-43)
            r3 = r3 | r13
            short r3 = (short) r3
            r13 = 571(0x23b, float:8.0E-43)
            byte r14 = r6[r13]     // Catch:{ all -> 0x13cc }
            byte r14 = (byte) r14     // Catch:{ all -> 0x13cc }
            r15 = 17
            byte r5 = r6[r15]     // Catch:{ all -> 0x13cc }
            byte r5 = (byte) r5     // Catch:{ all -> 0x13cc }
            java.lang.String r3 = $$c(r3, r14, r5)     // Catch:{ all -> 0x13cc }
            r5 = 0
            java.lang.reflect.Method r3 = r10.getMethod(r3, r5)     // Catch:{ all -> 0x13cc }
            java.lang.Object r3 = r3.invoke(r8, r5)     // Catch:{ all -> 0x13cc }
            r5 = 1
            r9[r5] = r3     // Catch:{ all -> 0x1430 }
            java.lang.Object r3 = r7.invoke(r2, r9)     // Catch:{ all -> 0x1430 }
            if (r3 == 0) goto L_0x143c
            r5 = 305(0x131, float:4.27E-43)
            short r5 = (short) r5
            r7 = 40
            byte r8 = r6[r7]     // Catch:{ all -> 0x1600 }
            byte r7 = (byte) r8
            byte r6 = r6[r26]     // Catch:{ all -> 0x1430 }
            byte r6 = (byte) r6     // Catch:{ all -> 0x1430 }
            java.lang.String r5 = $$c(r5, r7, r6)     // Catch:{ all -> 0x1430 }
            r6 = 0
            java.lang.Class[] r7 = new java.lang.Class[r6]     // Catch:{ all -> 0x1430 }
            java.lang.reflect.Method r4 = r4.getDeclaredMethod(r5, r7)     // Catch:{ all -> 0x1430 }
            java.lang.Object[] r5 = new java.lang.Object[r6]     // Catch:{ all -> 0x1430 }
            r4.invoke(r2, r5)     // Catch:{ all -> 0x1430 }
            goto L_0x143c
        L_0x13cc:
            r0 = move-exception
            goto L_0x13d1
        L_0x13ce:
            r0 = move-exception
            r13 = 571(0x23b, float:8.0E-43)
        L_0x13d1:
            r2 = r0
            java.lang.Throwable r3 = r2.getCause()     // Catch:{ all -> 0x1430 }
            if (r3 == 0) goto L_0x13d9
            throw r3     // Catch:{ all -> 0x1430 }
        L_0x13d9:
            throw r2     // Catch:{ all -> 0x1430 }
        L_0x13da:
            r0 = move-exception
            r13 = 571(0x23b, float:8.0E-43)
            r2 = r0
            r6 = r8
            goto L_0x13ed
        L_0x13e0:
            r0 = move-exception
            r13 = 571(0x23b, float:8.0E-43)
            r2 = r0
            r7 = r8
            goto L_0x1602
        L_0x13e7:
            r0 = move-exception
            r13 = 571(0x23b, float:8.0E-43)
        L_0x13ea:
            r2 = r0
            r6 = 60
        L_0x13ed:
            r7 = 40
            goto L_0x185b
        L_0x13f1:
            r13 = 571(0x23b, float:8.0E-43)
            r3 = 569(0x239, float:7.97E-43)
            short r3 = (short) r3
            byte[] r4 = AppsFlyerLib     // Catch:{ all -> 0x15da }
            r5 = 17
            byte r6 = r4[r5]     // Catch:{ all -> 0x15da }
            byte r5 = (byte) r6
            r6 = 40
            byte r7 = r4[r6]     // Catch:{ all -> 0x15d7 }
            byte r6 = (byte) r7
            java.lang.String r3 = $$c(r3, r5, r6)     // Catch:{ all -> 0x15da }
            java.lang.Class r3 = java.lang.Class.forName(r3)     // Catch:{ all -> 0x15da }
            r5 = 289(0x121, float:4.05E-43)
            byte r5 = r4[r5]     // Catch:{ all -> 0x15da }
            short r5 = (short) r5
            r6 = 60
            byte r7 = r4[r6]     // Catch:{ all -> 0x15d2 }
            byte r6 = (byte) r7
            r7 = 136(0x88, float:1.9E-43)
            byte r4 = r4[r7]     // Catch:{ all -> 0x15da }
            byte r4 = (byte) r4     // Catch:{ all -> 0x15da }
            java.lang.String r4 = $$c(r5, r6, r4)     // Catch:{ all -> 0x15da }
            r5 = 1
            java.lang.Class[] r6 = new java.lang.Class[r5]     // Catch:{ all -> 0x15da }
            r7 = 0
            r6[r7] = r48     // Catch:{ all -> 0x15da }
            java.lang.reflect.Method r3 = r3.getDeclaredMethod(r4, r6)     // Catch:{ all -> 0x15da }
            java.lang.Object[] r4 = new java.lang.Object[r5]     // Catch:{ InvocationTargetException -> 0x1432 }
            r4[r7] = r44     // Catch:{ InvocationTargetException -> 0x1432 }
            java.lang.Object r3 = r3.invoke(r2, r4)     // Catch:{ InvocationTargetException -> 0x1432 }
            goto L_0x143c
        L_0x1430:
            r0 = move-exception
            goto L_0x13ea
        L_0x1432:
            r0 = move-exception
            r3 = r0
            java.lang.Throwable r3 = r3.getCause()     // Catch:{ ClassNotFoundException -> 0x143b }
            java.lang.Exception r3 = (java.lang.Exception) r3     // Catch:{ ClassNotFoundException -> 0x143b }
            throw r3     // Catch:{ ClassNotFoundException -> 0x143b }
        L_0x143b:
            r3 = 0
        L_0x143c:
            if (r3 == 0) goto L_0x1586
            r8 = r3
            java.lang.Class r8 = (java.lang.Class) r8     // Catch:{ all -> 0x15da }
            int r3 = AppsFlyerInAppPurchaseValidatorListener     // Catch:{ all -> 0x15da }
            r4 = r3 ^ 392(0x188, float:5.5E-43)
            r3 = r3 & 392(0x188, float:5.5E-43)
            r3 = r3 | r4
            short r3 = (short) r3     // Catch:{ all -> 0x15da }
            byte[] r4 = AppsFlyerLib     // Catch:{ all -> 0x15da }
            r5 = 40
            byte r6 = r4[r5]     // Catch:{ all -> 0x1582 }
            byte r5 = (byte) r6
            r6 = 450(0x1c2, float:6.3E-43)
            byte r6 = r4[r6]     // Catch:{ all -> 0x15da }
            byte r6 = (byte) r6     // Catch:{ all -> 0x15da }
            java.lang.String r9 = $$c(r3, r5, r6)     // Catch:{ all -> 0x15da }
            r3 = 2
            java.lang.Class[] r5 = new java.lang.Class[r3]     // Catch:{ all -> 0x15da }
            java.lang.Class<java.lang.Object> r3 = java.lang.Object.class
            r6 = 0
            r5[r6] = r3     // Catch:{ all -> 0x15da }
            java.lang.Class r3 = java.lang.Boolean.TYPE     // Catch:{ all -> 0x15da }
            r6 = 1
            r5[r6] = r3     // Catch:{ all -> 0x15da }
            java.lang.reflect.Constructor r3 = r8.getDeclaredConstructor(r5)     // Catch:{ all -> 0x15da }
            r3.setAccessible(r6)     // Catch:{ all -> 0x15da }
            r5 = 2
            java.lang.Object[] r6 = new java.lang.Object[r5]     // Catch:{ all -> 0x15da }
            r5 = 0
            r6[r5] = r2     // Catch:{ all -> 0x15da }
            if (r47 != 0) goto L_0x1485
            int r2 = onValidateInApp
            r5 = r2 & 17
            r7 = 17
            r2 = r2 | r7
            int r5 = r5 + r2
            int r2 = r5 % 128
            getSdkVersion = r2
            r2 = 2
            int r5 = r5 % r2
            r2 = 1
            goto L_0x1486
        L_0x1485:
            r2 = 0
        L_0x1486:
            java.lang.Boolean r2 = java.lang.Boolean.valueOf(r2)     // Catch:{ all -> 0x15da }
            r5 = 1
            r6[r5] = r2     // Catch:{ all -> 0x15da }
            java.lang.Object r2 = r3.newInstance(r6)     // Catch:{ all -> 0x15da }
            onDeepLinking = r2     // Catch:{ all -> 0x15da }
            r2 = 10736(0x29f0, float:1.5044E-41)
            byte[] r3 = new byte[r2]     // Catch:{ all -> 0x15da }
            java.lang.Class<com.appsflyer.internal.a> r2 = com.appsflyer.internal.a.class
            r5 = 502(0x1f6, float:7.03E-43)
            short r5 = (short) r5     // Catch:{ all -> 0x15da }
            r6 = 72
            byte r6 = (byte) r6     // Catch:{ all -> 0x15da }
            r10 = 450(0x1c2, float:6.3E-43)
            byte r10 = r4[r10]     // Catch:{ all -> 0x15da }
            byte r10 = (byte) r10     // Catch:{ all -> 0x15da }
            java.lang.String r5 = $$c(r5, r6, r10)     // Catch:{ all -> 0x15da }
            java.io.InputStream r2 = r2.getResourceAsStream(r5)     // Catch:{ all -> 0x15da }
            r5 = 1
            java.lang.Object[] r6 = new java.lang.Object[r5]     // Catch:{ all -> 0x1576 }
            r5 = 0
            r6[r5] = r2     // Catch:{ all -> 0x1576 }
            r2 = 477(0x1dd, float:6.68E-43)
            short r2 = (short) r2     // Catch:{ all -> 0x1576 }
            r5 = 17
            byte r10 = r4[r5]     // Catch:{ all -> 0x1576 }
            byte r5 = (byte) r10     // Catch:{ all -> 0x1576 }
            r10 = 389(0x185, float:5.45E-43)
            byte r14 = r4[r10]     // Catch:{ all -> 0x1576 }
            byte r10 = (byte) r14     // Catch:{ all -> 0x1576 }
            java.lang.String r5 = $$c(r2, r5, r10)     // Catch:{ all -> 0x1576 }
            java.lang.Class r5 = java.lang.Class.forName(r5)     // Catch:{ all -> 0x1576 }
            r10 = 1
            java.lang.Class[] r14 = new java.lang.Class[r10]     // Catch:{ all -> 0x1576 }
            r10 = 14
            byte r15 = r4[r10]     // Catch:{ all -> 0x1576 }
            short r10 = (short) r15     // Catch:{ all -> 0x1576 }
            r15 = 17
            byte r7 = r4[r15]     // Catch:{ all -> 0x1576 }
            byte r7 = (byte) r7     // Catch:{ all -> 0x1576 }
            r15 = 70
            byte r11 = r4[r15]     // Catch:{ all -> 0x1576 }
            int r11 = -r11
            byte r11 = (byte) r11     // Catch:{ all -> 0x1576 }
            java.lang.String r7 = $$c(r10, r7, r11)     // Catch:{ all -> 0x1576 }
            java.lang.Class r7 = java.lang.Class.forName(r7)     // Catch:{ all -> 0x1576 }
            r10 = 0
            r14[r10] = r7     // Catch:{ all -> 0x1576 }
            java.lang.reflect.Constructor r5 = r5.getDeclaredConstructor(r14)     // Catch:{ all -> 0x1576 }
            java.lang.Object r5 = r5.newInstance(r6)     // Catch:{ all -> 0x1576 }
            r6 = 1
            java.lang.Object[] r7 = new java.lang.Object[r6]     // Catch:{ all -> 0x156a }
            r7[r10] = r3     // Catch:{ all -> 0x156a }
            r6 = 17
            byte r10 = r4[r6]     // Catch:{ all -> 0x156a }
            byte r6 = (byte) r10     // Catch:{ all -> 0x156a }
            r10 = 389(0x185, float:5.45E-43)
            byte r11 = r4[r10]     // Catch:{ all -> 0x156a }
            byte r10 = (byte) r11     // Catch:{ all -> 0x156a }
            java.lang.String r6 = $$c(r2, r6, r10)     // Catch:{ all -> 0x156a }
            java.lang.Class r6 = java.lang.Class.forName(r6)     // Catch:{ all -> 0x156a }
            r10 = 761(0x2f9, float:1.066E-42)
            short r10 = (short) r10     // Catch:{ all -> 0x156a }
            r11 = 92
            byte r14 = r4[r11]     // Catch:{ all -> 0x156a }
            byte r11 = (byte) r14     // Catch:{ all -> 0x156a }
            r14 = 136(0x88, float:1.9E-43)
            byte r14 = r4[r14]     // Catch:{ all -> 0x156a }
            byte r14 = (byte) r14     // Catch:{ all -> 0x156a }
            java.lang.String r10 = $$c(r10, r11, r14)     // Catch:{ all -> 0x156a }
            r11 = 1
            java.lang.Class[] r14 = new java.lang.Class[r11]     // Catch:{ all -> 0x156a }
            r11 = 0
            r14[r11] = r1     // Catch:{ all -> 0x156a }
            java.lang.reflect.Method r6 = r6.getMethod(r10, r14)     // Catch:{ all -> 0x156a }
            r6.invoke(r5, r7)     // Catch:{ all -> 0x156a }
            r6 = 17
            byte r7 = r4[r6]     // Catch:{ all -> 0x155e }
            byte r6 = (byte) r7     // Catch:{ all -> 0x155e }
            r7 = 389(0x185, float:5.45E-43)
            byte r10 = r4[r7]     // Catch:{ all -> 0x155e }
            byte r7 = (byte) r10     // Catch:{ all -> 0x155e }
            java.lang.String r2 = $$c(r2, r6, r7)     // Catch:{ all -> 0x155e }
            java.lang.Class r2 = java.lang.Class.forName(r2)     // Catch:{ all -> 0x155e }
            r6 = 305(0x131, float:4.27E-43)
            short r6 = (short) r6
            r7 = 40
            byte r10 = r4[r7]     // Catch:{ all -> 0x155c }
            byte r10 = (byte) r10     // Catch:{ all -> 0x155c }
            byte r4 = r4[r26]     // Catch:{ all -> 0x155c }
            byte r4 = (byte) r4     // Catch:{ all -> 0x155c }
            java.lang.String r4 = $$c(r6, r10, r4)     // Catch:{ all -> 0x155c }
            r6 = 0
            java.lang.reflect.Method r2 = r2.getMethod(r4, r6)     // Catch:{ all -> 0x155c }
            r2.invoke(r5, r6)     // Catch:{ all -> 0x155c }
            int r4 = java.lang.Math.abs(r24)     // Catch:{ all -> 0x1600 }
            r14 = r12
            r6 = r40
            r13 = r47
            r2 = r48
            r7 = 10702(0x29ce, float:1.4997E-41)
            r10 = 92
            goto L_0x096d
        L_0x155c:
            r0 = move-exception
            goto L_0x1561
        L_0x155e:
            r0 = move-exception
            r7 = 40
        L_0x1561:
            r2 = r0
            java.lang.Throwable r3 = r2.getCause()     // Catch:{ all -> 0x1600 }
            if (r3 == 0) goto L_0x1569
            throw r3     // Catch:{ all -> 0x1600 }
        L_0x1569:
            throw r2     // Catch:{ all -> 0x1600 }
        L_0x156a:
            r0 = move-exception
            r7 = 40
            r2 = r0
            java.lang.Throwable r3 = r2.getCause()     // Catch:{ all -> 0x1600 }
            if (r3 == 0) goto L_0x1575
            throw r3     // Catch:{ all -> 0x1600 }
        L_0x1575:
            throw r2     // Catch:{ all -> 0x1600 }
        L_0x1576:
            r0 = move-exception
            r7 = 40
            r2 = r0
            java.lang.Throwable r3 = r2.getCause()     // Catch:{ all -> 0x1600 }
            if (r3 == 0) goto L_0x1581
            throw r3     // Catch:{ all -> 0x1600 }
        L_0x1581:
            throw r2     // Catch:{ all -> 0x1600 }
        L_0x1582:
            r0 = move-exception
            r7 = r5
            goto L_0x1601
        L_0x1586:
            r7 = 40
            r3 = 2
            java.lang.Class[] r4 = new java.lang.Class[r3]     // Catch:{ all -> 0x1600 }
            java.lang.Class<java.lang.Object> r3 = java.lang.Object.class
            r5 = 0
            r4[r5] = r3     // Catch:{ all -> 0x1600 }
            java.lang.Class r3 = java.lang.Boolean.TYPE     // Catch:{ all -> 0x1600 }
            r5 = 1
            r4[r5] = r3     // Catch:{ all -> 0x1600 }
            r8 = r43
            java.lang.reflect.Constructor r3 = r8.getDeclaredConstructor(r4)     // Catch:{ all -> 0x1600 }
            r3.setAccessible(r5)     // Catch:{ all -> 0x1600 }
            r4 = 2
            java.lang.Object[] r5 = new java.lang.Object[r4]     // Catch:{ all -> 0x1600 }
            r4 = 0
            r5[r4] = r2     // Catch:{ all -> 0x1600 }
            if (r47 != 0) goto L_0x15a8
            r2 = 1
            goto L_0x15a9
        L_0x15a8:
            r2 = 0
        L_0x15a9:
            java.lang.Boolean r2 = java.lang.Boolean.valueOf(r2)     // Catch:{ all -> 0x1600 }
            r4 = 1
            r5[r4] = r2     // Catch:{ all -> 0x1600 }
            java.lang.Object r2 = r3.newInstance(r5)     // Catch:{ all -> 0x1600 }
            onDeepLinking = r2     // Catch:{ all -> 0x1600 }
            int r2 = getSdkVersion
            r3 = r2 & 109(0x6d, float:1.53E-43)
            r2 = r2 | 109(0x6d, float:1.53E-43)
            int r3 = r3 + r2
            int r2 = r3 % 128
            onValidateInApp = r2
            r2 = 2
            int r3 = r3 % r2
            r2 = 0
            r3 = 2
            r4 = 9
            r5 = 389(0x185, float:5.45E-43)
            r6 = 60
            r8 = 17
            r9 = 0
            r31 = 1
            goto L_0x18f2
        L_0x15d2:
            r0 = move-exception
            r7 = 40
            goto L_0x185a
        L_0x15d7:
            r0 = move-exception
            r7 = r6
            goto L_0x1601
        L_0x15da:
            r0 = move-exception
            r7 = 40
            goto L_0x1601
        L_0x15de:
            r0 = move-exception
            r7 = 40
            r13 = 571(0x23b, float:8.0E-43)
            goto L_0x1601
        L_0x15e4:
            r0 = move-exception
            r7 = 40
            r13 = 571(0x23b, float:8.0E-43)
            r2 = r0
            java.lang.Throwable r3 = r2.getCause()     // Catch:{ all -> 0x1600 }
            if (r3 == 0) goto L_0x15f1
            throw r3     // Catch:{ all -> 0x1600 }
        L_0x15f1:
            throw r2     // Catch:{ all -> 0x1600 }
        L_0x15f2:
            r0 = move-exception
            r7 = 40
            r13 = 571(0x23b, float:8.0E-43)
            r2 = r0
            java.lang.Throwable r3 = r2.getCause()     // Catch:{ all -> 0x1600 }
            if (r3 == 0) goto L_0x15ff
            throw r3     // Catch:{ all -> 0x1600 }
        L_0x15ff:
            throw r2     // Catch:{ all -> 0x1600 }
        L_0x1600:
            r0 = move-exception
        L_0x1601:
            r2 = r0
        L_0x1602:
            r6 = 60
            goto L_0x185b
        L_0x1606:
            r0 = move-exception
            r7 = 40
            goto L_0x160f
        L_0x160a:
            r0 = move-exception
            r7 = 40
            r13 = 571(0x23b, float:8.0E-43)
        L_0x160f:
            r4 = r0
            java.lang.Throwable r5 = r4.getCause()     // Catch:{ all -> 0x1684 }
            if (r5 == 0) goto L_0x1617
            throw r5     // Catch:{ all -> 0x1684 }
        L_0x1617:
            throw r4     // Catch:{ all -> 0x1684 }
        L_0x1618:
            r0 = move-exception
            r7 = 40
            goto L_0x1621
        L_0x161c:
            r0 = move-exception
            r7 = 40
            r13 = 571(0x23b, float:8.0E-43)
        L_0x1621:
            r4 = r0
            java.lang.Throwable r5 = r4.getCause()     // Catch:{ all -> 0x1684 }
            if (r5 == 0) goto L_0x1629
            throw r5     // Catch:{ all -> 0x1684 }
        L_0x1629:
            throw r4     // Catch:{ all -> 0x1684 }
        L_0x162a:
            r0 = move-exception
            goto L_0x166f
        L_0x162c:
            r0 = move-exception
            r7 = r9
            goto L_0x1632
        L_0x162f:
            r0 = move-exception
            r7 = 40
        L_0x1632:
            r13 = 571(0x23b, float:8.0E-43)
            r4 = r0
            java.lang.Throwable r5 = r4.getCause()     // Catch:{ all -> 0x1684 }
            if (r5 == 0) goto L_0x163c
            throw r5     // Catch:{ all -> 0x1684 }
        L_0x163c:
            throw r4     // Catch:{ all -> 0x1684 }
        L_0x163d:
            r0 = move-exception
            r7 = 40
            r13 = 571(0x23b, float:8.0E-43)
            r4 = r0
            java.lang.Throwable r5 = r4.getCause()     // Catch:{ all -> 0x1684 }
            if (r5 == 0) goto L_0x164a
            throw r5     // Catch:{ all -> 0x1684 }
        L_0x164a:
            throw r4     // Catch:{ all -> 0x1684 }
        L_0x164b:
            r0 = move-exception
            r13 = r10
            r7 = 40
            goto L_0x1655
        L_0x1650:
            r0 = move-exception
            r7 = 40
            r13 = 571(0x23b, float:8.0E-43)
        L_0x1655:
            r4 = r0
            java.lang.Throwable r5 = r4.getCause()     // Catch:{ all -> 0x1684 }
            if (r5 == 0) goto L_0x165d
            throw r5     // Catch:{ all -> 0x1684 }
        L_0x165d:
            throw r4     // Catch:{ all -> 0x1684 }
        L_0x165e:
            r0 = move-exception
            r7 = 40
            r13 = 571(0x23b, float:8.0E-43)
            r4 = r0
            java.lang.Throwable r5 = r4.getCause()     // Catch:{ all -> 0x1684 }
            if (r5 == 0) goto L_0x166b
            throw r5     // Catch:{ all -> 0x1684 }
        L_0x166b:
            throw r4     // Catch:{ all -> 0x1684 }
        L_0x166c:
            r0 = move-exception
            r7 = 40
        L_0x166f:
            r13 = 571(0x23b, float:8.0E-43)
            goto L_0x1685
        L_0x1672:
            r0 = move-exception
            goto L_0x1677
        L_0x1674:
            r0 = move-exception
            r12 = r45
        L_0x1677:
            r7 = 40
            r13 = 571(0x23b, float:8.0E-43)
            r4 = r0
            java.lang.Throwable r5 = r4.getCause()     // Catch:{ Exception -> 0x1688 }
            if (r5 == 0) goto L_0x1683
            throw r5     // Catch:{ Exception -> 0x1688 }
        L_0x1683:
            throw r4     // Catch:{ Exception -> 0x1688 }
        L_0x1684:
            r0 = move-exception
        L_0x1685:
            r4 = r0
            goto L_0x1709
        L_0x1688:
            r0 = move-exception
            r4 = r0
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ all -> 0x1684 }
            r5.<init>()     // Catch:{ all -> 0x1684 }
            r6 = 577(0x241, float:8.09E-43)
            short r6 = (short) r6     // Catch:{ all -> 0x1684 }
            byte[] r8 = AppsFlyerLib     // Catch:{ all -> 0x1684 }
            r9 = 289(0x121, float:4.05E-43)
            byte r9 = r8[r9]     // Catch:{ all -> 0x1684 }
            byte r9 = (byte) r9     // Catch:{ all -> 0x1684 }
            byte r10 = r8[r26]     // Catch:{ all -> 0x1684 }
            byte r10 = (byte) r10     // Catch:{ all -> 0x1684 }
            java.lang.String r6 = $$c(r6, r9, r10)     // Catch:{ all -> 0x1684 }
            r5.append(r6)     // Catch:{ all -> 0x1684 }
            r5.append(r3)     // Catch:{ all -> 0x1684 }
            int r6 = AppsFlyerInAppPurchaseValidatorListener     // Catch:{ all -> 0x1684 }
            r9 = r6 ^ 692(0x2b4, float:9.7E-43)
            r6 = r6 & 692(0x2b4, float:9.7E-43)
            r6 = r6 | r9
            short r6 = (short) r6     // Catch:{ all -> 0x1684 }
            r9 = 371(0x173, float:5.2E-43)
            byte r9 = r8[r9]     // Catch:{ all -> 0x1684 }
            r10 = r9 ^ -1
            r9 = r9 & -1
            r11 = 1
            int r9 = r9 << r11
            int r10 = r10 + r9
            byte r9 = (byte) r10     // Catch:{ all -> 0x1684 }
            r10 = 14
            byte r10 = r8[r10]     // Catch:{ all -> 0x1684 }
            byte r10 = (byte) r10     // Catch:{ all -> 0x1684 }
            java.lang.String r6 = $$c(r6, r9, r10)     // Catch:{ all -> 0x1684 }
            r5.append(r6)     // Catch:{ all -> 0x1684 }
            java.lang.String r5 = r5.toString()     // Catch:{ all -> 0x1684 }
            r6 = 2
            java.lang.Object[] r9 = new java.lang.Object[r6]     // Catch:{ all -> 0x16ff }
            r6 = 1
            r9[r6] = r4     // Catch:{ all -> 0x16ff }
            r4 = 0
            r9[r4] = r5     // Catch:{ all -> 0x16ff }
            r4 = 178(0xb2, float:2.5E-43)
            short r4 = (short) r4     // Catch:{ all -> 0x16ff }
            r5 = 17
            byte r6 = r8[r5]     // Catch:{ all -> 0x16ff }
            byte r5 = (byte) r6     // Catch:{ all -> 0x16ff }
            r6 = 70
            byte r8 = r8[r6]     // Catch:{ all -> 0x16ff }
            int r6 = -r8
            byte r6 = (byte) r6     // Catch:{ all -> 0x16ff }
            java.lang.String r4 = $$c(r4, r5, r6)     // Catch:{ all -> 0x16ff }
            java.lang.Class r4 = java.lang.Class.forName(r4)     // Catch:{ all -> 0x16ff }
            r5 = 2
            java.lang.Class[] r6 = new java.lang.Class[r5]     // Catch:{ all -> 0x16ff }
            r5 = 0
            r6[r5] = r48     // Catch:{ all -> 0x16ff }
            java.lang.Class<java.lang.Throwable> r5 = java.lang.Throwable.class
            r8 = 1
            r6[r8] = r5     // Catch:{ all -> 0x16ff }
            java.lang.reflect.Constructor r4 = r4.getDeclaredConstructor(r6)     // Catch:{ all -> 0x16ff }
            java.lang.Object r4 = r4.newInstance(r9)     // Catch:{ all -> 0x16ff }
            java.lang.Throwable r4 = (java.lang.Throwable) r4     // Catch:{ all -> 0x16ff }
            throw r4     // Catch:{ all -> 0x16ff }
        L_0x16ff:
            r0 = move-exception
            r4 = r0
            java.lang.Throwable r5 = r4.getCause()     // Catch:{ all -> 0x1684 }
            if (r5 == 0) goto L_0x1708
            throw r5     // Catch:{ all -> 0x1684 }
        L_0x1708:
            throw r4     // Catch:{ all -> 0x1684 }
        L_0x1709:
            byte[] r5 = AppsFlyerLib     // Catch:{ all -> 0x177c }
            r6 = 17
            byte r8 = r5[r6]     // Catch:{ all -> 0x177c }
            byte r6 = (byte) r8
            r8 = 60
            byte r9 = r5[r8]     // Catch:{ all -> 0x1779 }
            byte r8 = (byte) r9
            java.lang.String r6 = $$c(r12, r6, r8)     // Catch:{ all -> 0x177c }
            java.lang.Class r6 = java.lang.Class.forName(r6)     // Catch:{ all -> 0x177c }
            r8 = 344(0x158, float:4.82E-43)
            short r8 = (short) r8     // Catch:{ all -> 0x177c }
            r9 = 501(0x1f5, float:7.02E-43)
            byte r10 = r5[r9]     // Catch:{ all -> 0x177c }
            byte r9 = (byte) r10     // Catch:{ all -> 0x177c }
            r10 = 92
            byte r11 = r5[r10]     // Catch:{ all -> 0x177c }
            byte r10 = (byte) r11     // Catch:{ all -> 0x177c }
            java.lang.String r9 = $$c(r8, r9, r10)     // Catch:{ all -> 0x177c }
            r10 = 0
            java.lang.reflect.Method r6 = r6.getMethod(r9, r10)     // Catch:{ all -> 0x177c }
            java.lang.Object r3 = r6.invoke(r3, r10)     // Catch:{ all -> 0x177c }
            java.lang.Boolean r3 = (java.lang.Boolean) r3     // Catch:{ all -> 0x177c }
            r3.booleanValue()     // Catch:{ all -> 0x177c }
            r3 = 17
            byte r6 = r5[r3]     // Catch:{ all -> 0x176d }
            byte r3 = (byte) r6
            r6 = 60
            byte r9 = r5[r6]     // Catch:{ all -> 0x176b }
            byte r9 = (byte) r9     // Catch:{ all -> 0x176b }
            java.lang.String r3 = $$c(r12, r3, r9)     // Catch:{ all -> 0x176b }
            java.lang.Class r3 = java.lang.Class.forName(r3)     // Catch:{ all -> 0x176b }
            r9 = 501(0x1f5, float:7.02E-43)
            byte r9 = r5[r9]     // Catch:{ all -> 0x176b }
            byte r9 = (byte) r9     // Catch:{ all -> 0x176b }
            r10 = 92
            byte r5 = r5[r10]     // Catch:{ all -> 0x176b }
            byte r5 = (byte) r5     // Catch:{ all -> 0x176b }
            java.lang.String r5 = $$c(r8, r9, r5)     // Catch:{ all -> 0x176b }
            r8 = 0
            java.lang.reflect.Method r3 = r3.getMethod(r5, r8)     // Catch:{ all -> 0x176b }
            java.lang.Object r2 = r3.invoke(r2, r8)     // Catch:{ all -> 0x176b }
            java.lang.Boolean r2 = (java.lang.Boolean) r2     // Catch:{ all -> 0x176b }
            r2.booleanValue()     // Catch:{ all -> 0x176b }
            throw r4     // Catch:{ all -> 0x183e }
        L_0x176b:
            r0 = move-exception
            goto L_0x1770
        L_0x176d:
            r0 = move-exception
            r6 = 60
        L_0x1770:
            r2 = r0
            java.lang.Throwable r3 = r2.getCause()     // Catch:{ all -> 0x183e }
            if (r3 == 0) goto L_0x1778
            throw r3     // Catch:{ all -> 0x183e }
        L_0x1778:
            throw r2     // Catch:{ all -> 0x183e }
        L_0x1779:
            r0 = move-exception
            r6 = r8
            goto L_0x177f
        L_0x177c:
            r0 = move-exception
            r6 = 60
        L_0x177f:
            r2 = r0
            java.lang.Throwable r3 = r2.getCause()     // Catch:{ all -> 0x183e }
            if (r3 == 0) goto L_0x1787
            throw r3     // Catch:{ all -> 0x183e }
        L_0x1787:
            throw r2     // Catch:{ all -> 0x183e }
        L_0x1788:
            r0 = move-exception
            r12 = r45
            goto L_0x0888
        L_0x178d:
            r0 = move-exception
            r48 = r2
            r12 = r45
            r6 = 60
            r7 = 40
            r13 = 571(0x23b, float:8.0E-43)
            r2 = r0
            java.lang.Throwable r3 = r2.getCause()     // Catch:{ all -> 0x183e }
            if (r3 == 0) goto L_0x17a0
            throw r3     // Catch:{ all -> 0x183e }
        L_0x17a0:
            throw r2     // Catch:{ all -> 0x183e }
        L_0x17a1:
            r0 = move-exception
            r48 = r2
            r12 = r45
            goto L_0x17b3
        L_0x17a7:
            r0 = move-exception
            r48 = r2
            r7 = r8
            r12 = r14
            r6 = 60
            goto L_0x17b7
        L_0x17af:
            r0 = move-exception
            r48 = r2
            r12 = r14
        L_0x17b3:
            r6 = 60
            r7 = 40
        L_0x17b7:
            r13 = 571(0x23b, float:8.0E-43)
            r2 = r0
            java.lang.Throwable r3 = r2.getCause()     // Catch:{ all -> 0x183e }
            if (r3 == 0) goto L_0x17c1
            throw r3     // Catch:{ all -> 0x183e }
        L_0x17c1:
            throw r2     // Catch:{ all -> 0x183e }
        L_0x17c2:
            r0 = move-exception
            r48 = r2
            goto L_0x0887
        L_0x17c7:
            r0 = move-exception
            r48 = r2
            goto L_0x17d0
        L_0x17cb:
            r0 = move-exception
            r48 = r2
            r40 = r6
        L_0x17d0:
            r12 = r14
            r6 = 60
            r7 = 40
            r13 = 571(0x23b, float:8.0E-43)
            r2 = r0
            java.lang.Throwable r3 = r2.getCause()     // Catch:{ all -> 0x183e }
            if (r3 == 0) goto L_0x17df
            throw r3     // Catch:{ all -> 0x183e }
        L_0x17df:
            throw r2     // Catch:{ all -> 0x183e }
        L_0x17e0:
            r0 = move-exception
            r48 = r2
            r40 = r6
            r12 = r14
            r6 = 60
            r7 = 40
            r13 = 571(0x23b, float:8.0E-43)
            r2 = r0
            java.lang.Throwable r3 = r2.getCause()     // Catch:{ all -> 0x183e }
            if (r3 == 0) goto L_0x17f4
            throw r3     // Catch:{ all -> 0x183e }
        L_0x17f4:
            throw r2     // Catch:{ all -> 0x183e }
        L_0x17f5:
            r0 = move-exception
            r48 = r2
            r40 = r6
            r7 = r8
            r12 = r14
            r6 = 60
            goto L_0x1809
        L_0x17ff:
            r0 = move-exception
            r48 = r2
            r40 = r6
            r12 = r14
            r6 = 60
            r7 = 40
        L_0x1809:
            r13 = 571(0x23b, float:8.0E-43)
            r2 = r0
            java.lang.Throwable r3 = r2.getCause()     // Catch:{ all -> 0x183e }
            if (r3 == 0) goto L_0x1813
            throw r3     // Catch:{ all -> 0x183e }
        L_0x1813:
            throw r2     // Catch:{ all -> 0x183e }
        L_0x1814:
            r0 = move-exception
            r48 = r2
            r40 = r6
            r12 = r14
            r6 = 60
            r7 = 40
            r13 = 571(0x23b, float:8.0E-43)
            r2 = r0
            java.lang.Throwable r3 = r2.getCause()     // Catch:{ all -> 0x183e }
            if (r3 == 0) goto L_0x1828
            throw r3     // Catch:{ all -> 0x183e }
        L_0x1828:
            throw r2     // Catch:{ all -> 0x183e }
        L_0x1829:
            r0 = move-exception
            r48 = r2
            r40 = r6
            r12 = r14
            r6 = 60
            r7 = 40
            r13 = 571(0x23b, float:8.0E-43)
            r2 = r0
            java.lang.Throwable r3 = r2.getCause()     // Catch:{ all -> 0x183e }
            if (r3 == 0) goto L_0x183d
            throw r3     // Catch:{ all -> 0x183e }
        L_0x183d:
            throw r2     // Catch:{ all -> 0x183e }
        L_0x183e:
            r0 = move-exception
            goto L_0x185a
        L_0x1840:
            r0 = move-exception
            goto L_0x0883
        L_0x1843:
            r0 = move-exception
            r48 = r2
            r29 = r3
            r30 = r4
            r31 = r5
            r40 = r6
            r35 = r8
            r39 = r9
            r34 = r11
            r6 = r12
            r12 = r14
        L_0x1856:
            r7 = 40
            r13 = 571(0x23b, float:8.0E-43)
        L_0x185a:
            r2 = r0
        L_0x185b:
            r3 = r40 | 1
            r4 = 1
            int r3 = r3 << r4
            r4 = r40 ^ 1
            int r3 = r3 - r4
        L_0x1862:
            r4 = 9
            if (r3 >= r4) goto L_0x186f
            boolean r5 = r39[r3]     // Catch:{ Exception -> 0x192d }
            if (r5 == 0) goto L_0x186c
            r3 = 1
            goto L_0x1870
        L_0x186c:
            int r3 = r3 + 1
            goto L_0x1862
        L_0x186f:
            r3 = 0
        L_0x1870:
            if (r3 == 0) goto L_0x187f
            r2 = 0
            onDeepLinking = r2     // Catch:{ Exception -> 0x192d }
            onAttributionFailure = r2     // Catch:{ Exception -> 0x192d }
            r3 = 2
            r5 = 389(0x185, float:5.45E-43)
            r8 = 17
            r9 = 0
            goto L_0x18f2
        L_0x187f:
            int r1 = AppsFlyerInAppPurchaseValidatorListener     // Catch:{ Exception -> 0x192d }
            r1 = r1 | 600(0x258, float:8.41E-43)
            short r1 = (short) r1     // Catch:{ Exception -> 0x192d }
            byte[] r3 = AppsFlyerLib     // Catch:{ Exception -> 0x192d }
            r4 = 289(0x121, float:4.05E-43)
            byte r4 = r3[r4]     // Catch:{ Exception -> 0x192d }
            byte r4 = (byte) r4     // Catch:{ Exception -> 0x192d }
            r5 = 389(0x185, float:5.45E-43)
            byte r5 = r3[r5]     // Catch:{ Exception -> 0x192d }
            byte r5 = (byte) r5     // Catch:{ Exception -> 0x192d }
            java.lang.String r1 = $$c(r1, r4, r5)     // Catch:{ Exception -> 0x192d }
            r4 = 2
            java.lang.Object[] r5 = new java.lang.Object[r4]     // Catch:{ all -> 0x18c9 }
            r4 = 1
            r5[r4] = r2     // Catch:{ all -> 0x18c9 }
            r2 = 0
            r5[r2] = r1     // Catch:{ all -> 0x18c9 }
            r1 = 178(0xb2, float:2.5E-43)
            short r1 = (short) r1     // Catch:{ all -> 0x18c9 }
            r8 = 17
            byte r2 = r3[r8]     // Catch:{ all -> 0x18c9 }
            byte r2 = (byte) r2     // Catch:{ all -> 0x18c9 }
            r4 = 70
            byte r3 = r3[r4]     // Catch:{ all -> 0x18c9 }
            int r3 = -r3
            byte r3 = (byte) r3     // Catch:{ all -> 0x18c9 }
            java.lang.String r1 = $$c(r1, r2, r3)     // Catch:{ all -> 0x18c9 }
            java.lang.Class r1 = java.lang.Class.forName(r1)     // Catch:{ all -> 0x18c9 }
            r3 = 2
            java.lang.Class[] r2 = new java.lang.Class[r3]     // Catch:{ all -> 0x18c9 }
            r9 = 0
            r2[r9] = r48     // Catch:{ all -> 0x18c9 }
            java.lang.Class<java.lang.Throwable> r3 = java.lang.Throwable.class
            r4 = 1
            r2[r4] = r3     // Catch:{ all -> 0x18c9 }
            java.lang.reflect.Constructor r1 = r1.getDeclaredConstructor(r2)     // Catch:{ all -> 0x18c9 }
            java.lang.Object r1 = r1.newInstance(r5)     // Catch:{ all -> 0x18c9 }
            java.lang.Throwable r1 = (java.lang.Throwable) r1     // Catch:{ all -> 0x18c9 }
            throw r1     // Catch:{ all -> 0x18c9 }
        L_0x18c9:
            r0 = move-exception
            r1 = r0
            java.lang.Throwable r2 = r1.getCause()     // Catch:{ Exception -> 0x192d }
            if (r2 == 0) goto L_0x18d2
            throw r2     // Catch:{ Exception -> 0x192d }
        L_0x18d2:
            throw r1     // Catch:{ Exception -> 0x192d }
        L_0x18d3:
            r48 = r2
            r29 = r3
            r30 = r4
            r31 = r5
            r40 = r6
            r35 = r8
            r39 = r9
            r34 = r11
            r6 = r12
            r12 = r14
            r2 = 0
            r3 = 2
            r4 = 9
            r5 = 389(0x185, float:5.45E-43)
            r8 = 17
            r13 = 571(0x23b, float:8.0E-43)
            r9 = r7
            r7 = 40
        L_0x18f2:
            r10 = r40 ^ 1
            r11 = r40 & 1
            r14 = 1
            int r11 = r11 << r14
            int r10 = r10 + r11
            r7 = r9
            r14 = r12
            r3 = r29
            r4 = r30
            r5 = r31
            r11 = r34
            r8 = r35
            r9 = r39
            r2 = r48
            r15 = 5
            r12 = r6
            r6 = r10
            goto L_0x03d8
        L_0x190e:
            return
        L_0x190f:
            r0 = move-exception
            r1 = r0
            java.lang.Throwable r2 = r1.getCause()     // Catch:{ Exception -> 0x192d }
            if (r2 == 0) goto L_0x1918
            throw r2     // Catch:{ Exception -> 0x192d }
        L_0x1918:
            throw r1     // Catch:{ Exception -> 0x192d }
        L_0x1919:
            r0 = move-exception
            r1 = r0
            java.lang.Throwable r2 = r1.getCause()     // Catch:{ Exception -> 0x192d }
            if (r2 == 0) goto L_0x1922
            throw r2     // Catch:{ Exception -> 0x192d }
        L_0x1922:
            throw r1     // Catch:{ Exception -> 0x192d }
        L_0x1923:
            r0 = move-exception
            r1 = r0
            java.lang.Throwable r2 = r1.getCause()     // Catch:{ Exception -> 0x192d }
            if (r2 == 0) goto L_0x192c
            throw r2     // Catch:{ Exception -> 0x192d }
        L_0x192c:
            throw r1     // Catch:{ Exception -> 0x192d }
        L_0x192d:
            r0 = move-exception
            r1 = r0
            java.lang.RuntimeException r2 = new java.lang.RuntimeException
            r2.<init>(r1)
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.appsflyer.internal.a.<clinit>():void");
    }

    private a() {
    }

    public static int AFInAppEventType(Object obj) {
        int i11 = onValidateInApp;
        int i12 = (i11 ^ 35) + ((i11 & 35) << 1);
        getSdkVersion = i12 % 128;
        int i13 = i12 % 2;
        Object obj2 = onDeepLinking;
        int i14 = i11 + 21;
        getSdkVersion = i14 % 128;
        int i15 = i14 % 2;
        try {
            byte[] bArr = AppsFlyerLib;
            int intValue = ((Integer) Class.forName($$c((short) 938, (byte) bArr[40], (byte) bArr[450]), true, (ClassLoader) onAttributionFailure).getMethod($$c((short) 400, (byte) bArr[15], (byte) bArr[92]), new Class[]{Object.class}).invoke(obj2, new Object[]{obj})).intValue();
            int i16 = onValidateInApp;
            int i17 = (i16 & 87) + (i16 | 87);
            getSdkVersion = i17 % 128;
            if ((i17 % 2 == 0 ? 6 : 'E') != 6) {
                return intValue;
            }
            throw null;
        } catch (Throwable th2) {
            Throwable cause = th2.getCause();
            if (cause != null) {
                throw cause;
            }
            throw th2;
        }
    }

    public static int AFKeystoreWrapper(int i11) {
        int i12 = onValidateInApp + 7;
        int i13 = i12 % 128;
        getSdkVersion = i13;
        int i14 = i12 % 2;
        Object obj = onDeepLinking;
        int i15 = (i13 + 48) - 1;
        int i16 = i15 % 128;
        onValidateInApp = i16;
        int i17 = i15 % 2;
        int i18 = (i16 ^ 109) + ((i16 & 109) << 1);
        getSdkVersion = i18 % 128;
        int i19 = i18 % 2;
        try {
            Object[] objArr = {Integer.valueOf(i11)};
            byte[] bArr = AppsFlyerLib;
            return ((Integer) Class.forName($$c((short) 938, (byte) bArr[40], (byte) bArr[450]), true, (ClassLoader) onAttributionFailure).getMethod($$c((short) 400, (byte) bArr[15], (byte) bArr[92]), new Class[]{Integer.TYPE}).invoke(obj, objArr)).intValue();
        } catch (Throwable th2) {
            Throwable cause = th2.getCause();
            if (cause != null) {
                throw cause;
            }
            throw th2;
        }
    }

    public static Object AFKeystoreWrapper(int i11, int i12, char c11) {
        int i13 = getSdkVersion;
        int i14 = (i13 ^ 99) + ((i13 & 99) << 1);
        int i15 = i14 % 128;
        onValidateInApp = i15;
        int i16 = i14 % 2;
        Object obj = onDeepLinking;
        int i17 = i15 + 33;
        int i18 = i17 % 128;
        getSdkVersion = i18;
        int i19 = i17 % 2;
        int i21 = (i18 + 50) - 1;
        onValidateInApp = i21 % 128;
        int i22 = i21 % 2;
        try {
            Object[] objArr = new Object[3];
            objArr[2] = Character.valueOf(c11);
            objArr[1] = Integer.valueOf(i12);
            objArr[0] = Integer.valueOf(i11);
            byte[] bArr = AppsFlyerLib;
            Class<?> cls = Class.forName($$c((short) 938, (byte) bArr[40], (byte) bArr[450]), true, (ClassLoader) onAttributionFailure);
            String $$c = $$c((short) 214, (byte) bArr[15], (byte) bArr[66]);
            Class cls2 = Integer.TYPE;
            return cls.getMethod($$c, new Class[]{cls2, cls2, Character.TYPE}).invoke(obj, objArr);
        } catch (Throwable th2) {
            Throwable cause = th2.getCause();
            if (cause != null) {
                throw cause;
            }
            throw th2;
        }
    }

    public static void init$0() {
        int i11 = (onValidateInApp + 2) - 1;
        getSdkVersion = i11 % 128;
        int i12 = i11 % 2;
        byte[] bArr = new byte[986];
        boolean z11 = false;
        System.arraycopy("]ót\të\u00153ÅúAìÍ\u000f\u0000\u0001ó\r\u0001\u001bÛþû\u0001!ß\u0002\r\u0004ôô\u0002?Íñ\u0000ý\rúó\u0014óDÅûú\u000fó\u0004\rõ>ÉA\u0000\të\u00153Â\u000bó\u00079ÛÚ\u0006ÿ\u000føî\u0003\u0000\r÷ú3Ñ\u0000\u0004\u0003\u0006\u0002í\u000bú\u0001ó\nò\u0003\u0006\u00056¿üEÞÞ\u0003\fþò\u0000\të\u00153À\u0005úAìÉ\u0005\u000f#Í\u000f\u0000\u0001óó\nò\u0003\u0006\u00056¿üEìÍ\fý\b@Î\u0011óÿ\nú\u0001\të\u00153ÅúAìÉ\u0005\u000f$Ï\u0000\u0011è0Ûþû\u0001!ß\u0002\r\u0004ô\u0003õö\rþ=»ú\u0006ÿ\u000fø?åÛ!èøþýù5ßí5×\u000bî\u0000'Ý\u000eýÿó\r\u0004ý\u001eÑ\t\u0000óô\u0002>Îñ\u0000ý\rúó\u0014óCÆûú\u000fó\u0004\rõ=ÊA\u0000\u0002ñ.Ýý\u0007ò/Û÷û\nÿí)é\u0005\tõ\u000f\u0002ñ1âþû\u0003!Û÷\r\u0004ý\u0003õö\rþ=»ú\u0006ÿ\u000fø?êßí2Ýý\u0007ô\u000bÿ\u0006ü\u0002þû\u0003\u0003õö\rþ=»ú\u0006ÿ\u000fø?ìáî\u000e!ßí5×\u000bî\u0000'Ý\u000eýÿó\u0002ñ1Ô\u000bÿ\"âþû\u0003!Û÷ûýÛ-Ñ\u0000+Ï\u0011÷ú Û\t\u000bú\u000b\u000b\u0015ù\u0017øºÿOº\u0005õ\u0000\n\u0001þøøS´\u0007ÿòK\u0015ú\u0016ø\u0015ü\u0014ø\u0015ø\u0018ø\të\u00153Â\u000bó\u00079ë×\u000bî\u0000'Ý\u000eýÿóó\nò\u0003\u0006\u00056Íñ\u0000BíÑ\u0000)Ûý\r\u0001õù\u0002ñ/Í\u0004\u000fó\u0004\rõ\u0019ß\u0005ý\u0011ú\u0002!Û÷\r\u0002ï\u0005ýùÌô\u0002>Îñ\u0000ý\rúó\u0014óCÆûú\u000fó\u0004\rõ=Í5\të\u00153ÅúAêãí\u0013\u0018Ûþû\u0001!ß\u0002\r\u0004ôý\u000eý ßí\të\u00153ÅúAìÉ\u0005\u000f$Ï\u0000\u0011è*Ú\u0001\u0004û\u0001!ß\u0002\r\u0004ôó\nò\u0003\u0006\u00056¿üEé×ø\r÷\u0003\u0001\u0001\b÷ú\u0015õ÷\u0010òô\u0002>Îñ\u0000ý\rúó\u0014óCÆûú\u000fó\u0004\rõ=Î=®\b\u0002ù\u0002ñ1×\u000bî\u0000'Ý\u000eýÿóË\u0003í\u00132Ë\u0003í\u00132ÿù\u0007ñ\u000f\u0002ñ.\u0002\u000fùì\u0016ûú\rí\u000bó\u0011\u0019ã\u0007ð\u0011ïù)ïí\f#Ù\u0007ø\b÷ú\u0001÷ýü\u000eÌô\u0002>Îñ\u0000ý\rúó\u0014óCÆûú\u000fó\u0004\rõ=Î4\të\u00153ÅúAº\u0007ý\fû÷\u0002ñ$Þ\u0003ÿ\u000bóþû\u0002ñ3ßï\u0004\u0003÷\u0001\u000f\u0015ïí\fó\nò\u0003\u0006\u00056Íñ\u0000BíÞï\u000bó\rõû%ìö\r\u0004ý\u0015õ÷\u0010\u0016é\të\u00153ÅúAèÝý\u0007\u0016Ú\u0001\u0004û\u0001!ß\u0002\r\u0004ô\u0002ó\u0017å\tõ\u000f\të\u00153ÅúAåú\nÍ\u0015þõü\u000bú\u0001ó\nò\u0003\u0006\u00056º\u000fí\u0004FÚïí\u0004\u001fá\u000býù\u000fí\f\u001cãöÿ\u0002ñ+Û\u0005õ\u000b\bõ+Ñ\u0000\u0004\u0003\u0006\u0002í\u000bú\u0001\të\u00153ÅúAèÝý\u0007\u0015ý\u0013øî\u0003\u0000\r÷ú ëü\b\u0018äý\u0000\u0003ö\të\u00153ÅúAèÝý\u0007!ßò\u0010ñ\tùü\u0005ý\u0005-É\u0005\u000f$Ï\u0000\u0011èý\u000eý!×\u000bî\u0000ô%ë\u0005ô\u0002?Íñ\u0000ý\rúó\u0014ó\u0005\u0011ñ\rí\u000bó\u0011\u0019ã\u0007ð\u0011ïù5Û÷\r\u0002ï\u0005ý\t\u0004ò\të\u00153ÅúAåÛþû\u0001!ß\u0002\r\u0004ô".getBytes("ISO-8859-1"), 0, bArr, 0, 986);
        AppsFlyerLib = bArr;
        AppsFlyerInAppPurchaseValidatorListener = 3;
        int i13 = onValidateInApp + 91;
        getSdkVersion = i13 % 128;
        if (i13 % 2 != 0) {
            z11 = true;
        }
        if (!z11) {
            throw null;
        }
    }
}
