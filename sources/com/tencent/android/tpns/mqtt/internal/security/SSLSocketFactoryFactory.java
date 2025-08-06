package com.tencent.android.tpns.mqtt.internal.security;

import com.tencent.android.tpns.mqtt.MqttSecurityException;
import com.tencent.android.tpns.mqtt.logging.Logger;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.SecureRandom;
import java.util.Hashtable;
import java.util.Properties;
import java.util.Vector;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;

public class SSLSocketFactoryFactory {
    public static final String CIPHERSUITES = "com.ibm.ssl.enabledCipherSuites";
    private static final String CLASS_NAME = "com.tencent.android.tpns.mqtt.internal.security.SSLSocketFactoryFactory";
    public static final String CLIENTAUTH = "com.ibm.ssl.clientAuthentication";
    public static final String DEFAULT_PROTOCOL = "TLS";
    public static final String JSSEPROVIDER = "com.ibm.ssl.contextProvider";
    public static final String KEYSTORE = "com.ibm.ssl.keyStore";
    public static final String KEYSTOREMGR = "com.ibm.ssl.keyManager";
    public static final String KEYSTOREPROVIDER = "com.ibm.ssl.keyStoreProvider";
    public static final String KEYSTOREPWD = "com.ibm.ssl.keyStorePassword";
    public static final String KEYSTORETYPE = "com.ibm.ssl.keyStoreType";
    public static final String SSLPROTOCOL = "com.ibm.ssl.protocol";
    public static final String SYSKEYMGRALGO = "ssl.KeyManagerFactory.algorithm";
    public static final String SYSKEYSTORE = "javax.net.ssl.keyStore";
    public static final String SYSKEYSTOREPWD = "javax.net.ssl.keyStorePassword";
    public static final String SYSKEYSTORETYPE = "javax.net.ssl.keyStoreType";
    public static final String SYSTRUSTMGRALGO = "ssl.TrustManagerFactory.algorithm";
    public static final String SYSTRUSTSTORE = "javax.net.ssl.trustStore";
    public static final String SYSTRUSTSTOREPWD = "javax.net.ssl.trustStorePassword";
    public static final String SYSTRUSTSTORETYPE = "javax.net.ssl.trustStoreType";
    public static final String TRUSTSTORE = "com.ibm.ssl.trustStore";
    public static final String TRUSTSTOREMGR = "com.ibm.ssl.trustManager";
    public static final String TRUSTSTOREPROVIDER = "com.ibm.ssl.trustStoreProvider";
    public static final String TRUSTSTOREPWD = "com.ibm.ssl.trustStorePassword";
    public static final String TRUSTSTORETYPE = "com.ibm.ssl.trustStoreType";
    private static final byte[] key = {-99, -89, -39, Byte.MIN_VALUE, 5, -72, -119, -100};
    private static final String[] propertyKeys = {SSLPROTOCOL, JSSEPROVIDER, KEYSTORE, KEYSTOREPWD, KEYSTORETYPE, KEYSTOREPROVIDER, KEYSTOREMGR, TRUSTSTORE, TRUSTSTOREPWD, TRUSTSTORETYPE, TRUSTSTOREPROVIDER, TRUSTSTOREMGR, CIPHERSUITES, CLIENTAUTH};
    private static final String xorTag = "{xor}";
    private Hashtable configs;
    private Properties defaultProperties;
    private Logger logger;

    public SSLSocketFactoryFactory() {
        this.logger = null;
        this.configs = new Hashtable();
    }

    private void checkPropertyKeys(Properties properties) throws IllegalArgumentException {
        for (String str : properties.keySet()) {
            if (!keyValid(str)) {
                throw new IllegalArgumentException(str + " is not a valid IBM SSL property key.");
            }
        }
    }

    private void convertPassword(Properties properties) {
        String property = properties.getProperty(KEYSTOREPWD);
        if (property != null && !property.startsWith(xorTag)) {
            properties.put(KEYSTOREPWD, obfuscate(property.toCharArray()));
        }
        String property2 = properties.getProperty(TRUSTSTOREPWD);
        if (property2 != null && !property2.startsWith(xorTag)) {
            properties.put(TRUSTSTOREPWD, obfuscate(property2.toCharArray()));
        }
    }

    public static char[] deObfuscate(String str) {
        if (str == null) {
            return null;
        }
        try {
            byte[] decode = SimpleBase64Encoder.decode(str.substring(5));
            for (int i11 = 0; i11 < decode.length; i11++) {
                byte b11 = decode[i11];
                byte[] bArr = key;
                decode[i11] = (byte) ((b11 ^ bArr[i11 % bArr.length]) & 255);
            }
            return toChar(decode);
        } catch (Throwable unused) {
            return null;
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v0, resolved type: javax.net.ssl.KeyManager[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v1, resolved type: javax.net.ssl.KeyManager[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v3, resolved type: javax.net.ssl.KeyManager[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v4, resolved type: javax.net.ssl.KeyManager[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r14v1, resolved type: java.io.FileInputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v9, resolved type: javax.net.ssl.KeyManager[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v17, resolved type: javax.net.ssl.KeyManager[]} */
    /* JADX WARNING: type inference failed for: r3v2, types: [java.io.FileInputStream] */
    /* JADX WARNING: type inference failed for: r3v10 */
    /* JADX WARNING: type inference failed for: r3v16 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:98:0x011f A[SYNTHETIC, Splitter:B:98:0x011f] */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private javax.net.ssl.KeyManager[] getKeyManagersForSSLContext(java.lang.String r18) throws java.security.NoSuchAlgorithmException, java.security.NoSuchProviderException, com.tencent.android.tpns.mqtt.MqttSecurityException {
        /*
            r17 = this;
            r1 = r17
            r0 = r18
            java.lang.String r2 = "com.ibm.ssl.keyStore"
            r3 = 0
            java.lang.String r4 = r1.getProperty(r0, r2, r3)
            if (r4 != 0) goto L_0x0013
            java.lang.String r4 = "javax.net.ssl.keyStore"
            java.lang.String r4 = r1.getProperty(r0, r2, r4)
        L_0x0013:
            com.tencent.android.tpns.mqtt.logging.Logger r2 = r1.logger
            java.lang.String r5 = "null"
            r6 = 1
            java.lang.String r7 = "null (broker defaults)"
            r8 = 0
            r9 = 2
            java.lang.String r10 = "com.tencent.android.tpns.mqtt.internal.security.SSLSocketFactoryFactory"
            java.lang.String r11 = "getKeyManagersForSSLContext"
            if (r2 == 0) goto L_0x0037
            java.lang.Object[] r12 = new java.lang.Object[r9]
            if (r0 == 0) goto L_0x0028
            r13 = r0
            goto L_0x0029
        L_0x0028:
            r13 = r7
        L_0x0029:
            r12[r8] = r13
            if (r4 == 0) goto L_0x002f
            r13 = r4
            goto L_0x0030
        L_0x002f:
            r13 = r5
        L_0x0030:
            r12[r6] = r13
            java.lang.String r13 = "12004"
            r2.fine(r10, r11, r13, r12)
        L_0x0037:
            char[] r2 = r17.getKeyStorePassword(r18)
            com.tencent.android.tpns.mqtt.logging.Logger r12 = r1.logger
            if (r12 == 0) goto L_0x0057
            java.lang.Object[] r13 = new java.lang.Object[r9]
            if (r0 == 0) goto L_0x0045
            r14 = r0
            goto L_0x0046
        L_0x0045:
            r14 = r7
        L_0x0046:
            r13[r8] = r14
            if (r2 == 0) goto L_0x004f
            java.lang.String r14 = obfuscate(r2)
            goto L_0x0050
        L_0x004f:
            r14 = r5
        L_0x0050:
            r13[r6] = r14
            java.lang.String r14 = "12005"
            r12.fine(r10, r11, r14, r13)
        L_0x0057:
            java.lang.String r12 = r17.getKeyStoreType(r18)
            if (r12 != 0) goto L_0x0061
            java.lang.String r12 = java.security.KeyStore.getDefaultType()
        L_0x0061:
            com.tencent.android.tpns.mqtt.logging.Logger r13 = r1.logger
            if (r13 == 0) goto L_0x0078
            java.lang.Object[] r14 = new java.lang.Object[r9]
            if (r0 == 0) goto L_0x006b
            r15 = r0
            goto L_0x006c
        L_0x006b:
            r15 = r7
        L_0x006c:
            r14[r8] = r15
            if (r12 == 0) goto L_0x0071
            r5 = r12
        L_0x0071:
            r14[r6] = r5
            java.lang.String r5 = "12006"
            r13.fine(r10, r11, r5, r14)
        L_0x0078:
            java.lang.String r5 = javax.net.ssl.KeyManagerFactory.getDefaultAlgorithm()
            java.lang.String r13 = r17.getKeyStoreProvider(r18)
            java.lang.String r14 = r17.getKeyManager(r18)
            if (r14 == 0) goto L_0x0087
            r5 = r14
        L_0x0087:
            if (r4 == 0) goto L_0x012c
            if (r12 == 0) goto L_0x012c
            if (r5 == 0) goto L_0x012c
            java.security.KeyStore r12 = java.security.KeyStore.getInstance(r12)     // Catch:{ KeyStoreException -> 0x0116, CertificateException -> 0x010f, FileNotFoundException -> 0x0108, IOException -> 0x0101, UnrecoverableKeyException -> 0x00fa }
            java.io.FileInputStream r14 = new java.io.FileInputStream     // Catch:{ KeyStoreException -> 0x0116, CertificateException -> 0x010f, FileNotFoundException -> 0x0108, IOException -> 0x0101, UnrecoverableKeyException -> 0x00fa }
            r14.<init>(r4)     // Catch:{ KeyStoreException -> 0x0116, CertificateException -> 0x010f, FileNotFoundException -> 0x0108, IOException -> 0x0101, UnrecoverableKeyException -> 0x00fa }
            r12.load(r14, r2)     // Catch:{ KeyStoreException -> 0x00f5, CertificateException -> 0x00f2, FileNotFoundException -> 0x00ef, IOException -> 0x00ec, UnrecoverableKeyException -> 0x00e9, all -> 0x00e6 }
            if (r13 == 0) goto L_0x00a0
            javax.net.ssl.KeyManagerFactory r3 = javax.net.ssl.KeyManagerFactory.getInstance(r5, r13)     // Catch:{ KeyStoreException -> 0x00f5, CertificateException -> 0x00f2, FileNotFoundException -> 0x00ef, IOException -> 0x00ec, UnrecoverableKeyException -> 0x00e9, all -> 0x00e6 }
            goto L_0x00a4
        L_0x00a0:
            javax.net.ssl.KeyManagerFactory r3 = javax.net.ssl.KeyManagerFactory.getInstance(r5)     // Catch:{ KeyStoreException -> 0x00f5, CertificateException -> 0x00f2, FileNotFoundException -> 0x00ef, IOException -> 0x00ec, UnrecoverableKeyException -> 0x00e9, all -> 0x00e6 }
        L_0x00a4:
            com.tencent.android.tpns.mqtt.logging.Logger r4 = r1.logger     // Catch:{ KeyStoreException -> 0x00f5, CertificateException -> 0x00f2, FileNotFoundException -> 0x00ef, IOException -> 0x00ec, UnrecoverableKeyException -> 0x00e9, all -> 0x00e6 }
            if (r4 == 0) goto L_0x00d3
            java.lang.String r13 = "12010"
            java.lang.Object[] r15 = new java.lang.Object[r9]     // Catch:{ KeyStoreException -> 0x00f5, CertificateException -> 0x00f2, FileNotFoundException -> 0x00ef, IOException -> 0x00ec, UnrecoverableKeyException -> 0x00e9, all -> 0x00e6 }
            if (r0 == 0) goto L_0x00b1
            r16 = r0
            goto L_0x00b3
        L_0x00b1:
            r16 = r7
        L_0x00b3:
            r15[r8] = r16     // Catch:{ KeyStoreException -> 0x00f5, CertificateException -> 0x00f2, FileNotFoundException -> 0x00ef, IOException -> 0x00ec, UnrecoverableKeyException -> 0x00e9, all -> 0x00e6 }
            r15[r6] = r5     // Catch:{ KeyStoreException -> 0x00f5, CertificateException -> 0x00f2, FileNotFoundException -> 0x00ef, IOException -> 0x00ec, UnrecoverableKeyException -> 0x00e9, all -> 0x00e6 }
            r4.fine(r10, r11, r13, r15)     // Catch:{ KeyStoreException -> 0x00f5, CertificateException -> 0x00f2, FileNotFoundException -> 0x00ef, IOException -> 0x00ec, UnrecoverableKeyException -> 0x00e9, all -> 0x00e6 }
            com.tencent.android.tpns.mqtt.logging.Logger r4 = r1.logger     // Catch:{ KeyStoreException -> 0x00f5, CertificateException -> 0x00f2, FileNotFoundException -> 0x00ef, IOException -> 0x00ec, UnrecoverableKeyException -> 0x00e9, all -> 0x00e6 }
            java.lang.String r5 = "12009"
            java.lang.Object[] r9 = new java.lang.Object[r9]     // Catch:{ KeyStoreException -> 0x00f5, CertificateException -> 0x00f2, FileNotFoundException -> 0x00ef, IOException -> 0x00ec, UnrecoverableKeyException -> 0x00e9, all -> 0x00e6 }
            if (r0 == 0) goto L_0x00c3
            goto L_0x00c4
        L_0x00c3:
            r0 = r7
        L_0x00c4:
            r9[r8] = r0     // Catch:{ KeyStoreException -> 0x00f5, CertificateException -> 0x00f2, FileNotFoundException -> 0x00ef, IOException -> 0x00ec, UnrecoverableKeyException -> 0x00e9, all -> 0x00e6 }
            java.security.Provider r0 = r3.getProvider()     // Catch:{ KeyStoreException -> 0x00f5, CertificateException -> 0x00f2, FileNotFoundException -> 0x00ef, IOException -> 0x00ec, UnrecoverableKeyException -> 0x00e9, all -> 0x00e6 }
            java.lang.String r0 = r0.getName()     // Catch:{ KeyStoreException -> 0x00f5, CertificateException -> 0x00f2, FileNotFoundException -> 0x00ef, IOException -> 0x00ec, UnrecoverableKeyException -> 0x00e9, all -> 0x00e6 }
            r9[r6] = r0     // Catch:{ KeyStoreException -> 0x00f5, CertificateException -> 0x00f2, FileNotFoundException -> 0x00ef, IOException -> 0x00ec, UnrecoverableKeyException -> 0x00e9, all -> 0x00e6 }
            r4.fine(r10, r11, r5, r9)     // Catch:{ KeyStoreException -> 0x00f5, CertificateException -> 0x00f2, FileNotFoundException -> 0x00ef, IOException -> 0x00ec, UnrecoverableKeyException -> 0x00e9, all -> 0x00e6 }
        L_0x00d3:
            r3.init(r12, r2)     // Catch:{ KeyStoreException -> 0x00f5, CertificateException -> 0x00f2, FileNotFoundException -> 0x00ef, IOException -> 0x00ec, UnrecoverableKeyException -> 0x00e9, all -> 0x00e6 }
            javax.net.ssl.KeyManager[] r3 = r3.getKeyManagers()     // Catch:{ KeyStoreException -> 0x00f5, CertificateException -> 0x00f2, FileNotFoundException -> 0x00ef, IOException -> 0x00ec, UnrecoverableKeyException -> 0x00e9, all -> 0x00e6 }
            r14.close()     // Catch:{ IOException -> 0x00de }
            goto L_0x012c
        L_0x00de:
            r0 = move-exception
            r2 = r0
            com.tencent.android.tpns.mqtt.MqttSecurityException r0 = new com.tencent.android.tpns.mqtt.MqttSecurityException
            r0.<init>((java.lang.Throwable) r2)
            throw r0
        L_0x00e6:
            r0 = move-exception
            r3 = r14
            goto L_0x011d
        L_0x00e9:
            r0 = move-exception
            r3 = r14
            goto L_0x00fb
        L_0x00ec:
            r0 = move-exception
            r3 = r14
            goto L_0x0102
        L_0x00ef:
            r0 = move-exception
            r3 = r14
            goto L_0x0109
        L_0x00f2:
            r0 = move-exception
            r3 = r14
            goto L_0x0110
        L_0x00f5:
            r0 = move-exception
            r3 = r14
            goto L_0x0117
        L_0x00f8:
            r0 = move-exception
            goto L_0x011d
        L_0x00fa:
            r0 = move-exception
        L_0x00fb:
            com.tencent.android.tpns.mqtt.MqttSecurityException r2 = new com.tencent.android.tpns.mqtt.MqttSecurityException     // Catch:{ all -> 0x00f8 }
            r2.<init>((java.lang.Throwable) r0)     // Catch:{ all -> 0x00f8 }
            throw r2     // Catch:{ all -> 0x00f8 }
        L_0x0101:
            r0 = move-exception
        L_0x0102:
            com.tencent.android.tpns.mqtt.MqttSecurityException r2 = new com.tencent.android.tpns.mqtt.MqttSecurityException     // Catch:{ all -> 0x00f8 }
            r2.<init>((java.lang.Throwable) r0)     // Catch:{ all -> 0x00f8 }
            throw r2     // Catch:{ all -> 0x00f8 }
        L_0x0108:
            r0 = move-exception
        L_0x0109:
            com.tencent.android.tpns.mqtt.MqttSecurityException r2 = new com.tencent.android.tpns.mqtt.MqttSecurityException     // Catch:{ all -> 0x00f8 }
            r2.<init>((java.lang.Throwable) r0)     // Catch:{ all -> 0x00f8 }
            throw r2     // Catch:{ all -> 0x00f8 }
        L_0x010f:
            r0 = move-exception
        L_0x0110:
            com.tencent.android.tpns.mqtt.MqttSecurityException r2 = new com.tencent.android.tpns.mqtt.MqttSecurityException     // Catch:{ all -> 0x00f8 }
            r2.<init>((java.lang.Throwable) r0)     // Catch:{ all -> 0x00f8 }
            throw r2     // Catch:{ all -> 0x00f8 }
        L_0x0116:
            r0 = move-exception
        L_0x0117:
            com.tencent.android.tpns.mqtt.MqttSecurityException r2 = new com.tencent.android.tpns.mqtt.MqttSecurityException     // Catch:{ all -> 0x00f8 }
            r2.<init>((java.lang.Throwable) r0)     // Catch:{ all -> 0x00f8 }
            throw r2     // Catch:{ all -> 0x00f8 }
        L_0x011d:
            if (r3 == 0) goto L_0x012b
            r3.close()     // Catch:{ IOException -> 0x0123 }
            goto L_0x012b
        L_0x0123:
            r0 = move-exception
            r2 = r0
            com.tencent.android.tpns.mqtt.MqttSecurityException r0 = new com.tencent.android.tpns.mqtt.MqttSecurityException
            r0.<init>((java.lang.Throwable) r2)
            throw r0
        L_0x012b:
            throw r0
        L_0x012c:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.android.tpns.mqtt.internal.security.SSLSocketFactoryFactory.getKeyManagersForSSLContext(java.lang.String):javax.net.ssl.KeyManager[]");
    }

    private String getProperty(String str, String str2, String str3) {
        String propertyFromConfig = getPropertyFromConfig(str, str2);
        return (propertyFromConfig == null && str3 != null) ? System.getProperty(str3) : propertyFromConfig;
    }

    private String getPropertyFromConfig(String str, String str2) {
        String str3 = null;
        Properties properties = str != null ? (Properties) this.configs.get(str) : null;
        if (properties != null && (str3 = properties.getProperty(str2)) != null) {
            return str3;
        }
        Properties properties2 = this.defaultProperties;
        if (properties2 == null || (str3 = properties2.getProperty(str2)) != null) {
        }
        return str3;
    }

    private SSLContext getSSLContext(String str) throws MqttSecurityException {
        SSLContext sSLContext;
        String sSLProtocol = getSSLProtocol(str);
        if (sSLProtocol == null) {
            sSLProtocol = DEFAULT_PROTOCOL;
        }
        Logger logger2 = this.logger;
        String str2 = "null (broker defaults)";
        if (logger2 != null) {
            Object[] objArr = new Object[2];
            objArr[0] = str != null ? str : str2;
            objArr[1] = sSLProtocol;
            logger2.fine(CLASS_NAME, "getSSLContext", "12000", objArr);
        }
        String jSSEProvider = getJSSEProvider(str);
        if (jSSEProvider == null) {
            try {
                sSLContext = SSLContext.getInstance(sSLProtocol);
            } catch (NoSuchAlgorithmException e11) {
                throw new MqttSecurityException((Throwable) e11);
            } catch (NoSuchProviderException e12) {
                throw new MqttSecurityException((Throwable) e12);
            } catch (KeyManagementException e13) {
                throw new MqttSecurityException((Throwable) e13);
            }
        } else {
            sSLContext = SSLContext.getInstance(sSLProtocol, jSSEProvider);
        }
        Logger logger3 = this.logger;
        if (logger3 != null) {
            Object[] objArr2 = new Object[2];
            if (str != null) {
                str2 = str;
            }
            objArr2[0] = str2;
            objArr2[1] = sSLContext.getProvider().getName();
            logger3.fine(CLASS_NAME, "getSSLContext", "12001", objArr2);
        }
        sSLContext.init(getKeyManagersForSSLContext(str), getTrustManagersForSSLContext(str), (SecureRandom) null);
        return sSLContext;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v1, resolved type: javax.net.ssl.TrustManager[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v2, resolved type: javax.net.ssl.TrustManager[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v4, resolved type: javax.net.ssl.TrustManager[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v5, resolved type: javax.net.ssl.TrustManager[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r12v0, resolved type: java.io.FileInputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v9, resolved type: javax.net.ssl.TrustManager[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v23, resolved type: javax.net.ssl.TrustManager[]} */
    /* JADX WARNING: type inference failed for: r11v3, types: [java.io.FileInputStream] */
    /* JADX WARNING: type inference failed for: r11v10 */
    /* JADX WARNING: type inference failed for: r11v22 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:91:0x0104 A[SYNTHETIC, Splitter:B:91:0x0104] */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private javax.net.ssl.TrustManager[] getTrustManagersForSSLContext(java.lang.String r15) throws java.security.NoSuchAlgorithmException, java.security.NoSuchProviderException, com.tencent.android.tpns.mqtt.MqttSecurityException {
        /*
            r14 = this;
            java.lang.String r0 = r14.getTrustStore(r15)
            com.tencent.android.tpns.mqtt.logging.Logger r1 = r14.logger
            java.lang.String r2 = "null"
            r3 = 1
            java.lang.String r4 = "null (broker defaults)"
            r5 = 0
            r6 = 2
            java.lang.String r7 = "com.tencent.android.tpns.mqtt.internal.security.SSLSocketFactoryFactory"
            java.lang.String r8 = "getTrustManagersForSSLContext"
            if (r1 == 0) goto L_0x0028
            java.lang.Object[] r9 = new java.lang.Object[r6]
            if (r15 == 0) goto L_0x0019
            r10 = r15
            goto L_0x001a
        L_0x0019:
            r10 = r4
        L_0x001a:
            r9[r5] = r10
            if (r0 == 0) goto L_0x0020
            r10 = r0
            goto L_0x0021
        L_0x0020:
            r10 = r2
        L_0x0021:
            r9[r3] = r10
            java.lang.String r10 = "12011"
            r1.fine(r7, r8, r10, r9)
        L_0x0028:
            char[] r1 = r14.getTrustStorePassword(r15)
            com.tencent.android.tpns.mqtt.logging.Logger r9 = r14.logger
            if (r9 == 0) goto L_0x0048
            java.lang.Object[] r10 = new java.lang.Object[r6]
            if (r15 == 0) goto L_0x0036
            r11 = r15
            goto L_0x0037
        L_0x0036:
            r11 = r4
        L_0x0037:
            r10[r5] = r11
            if (r1 == 0) goto L_0x0040
            java.lang.String r11 = obfuscate(r1)
            goto L_0x0041
        L_0x0040:
            r11 = r2
        L_0x0041:
            r10[r3] = r11
            java.lang.String r11 = "12012"
            r9.fine(r7, r8, r11, r10)
        L_0x0048:
            java.lang.String r9 = r14.getTrustStoreType(r15)
            if (r9 != 0) goto L_0x0052
            java.lang.String r9 = java.security.KeyStore.getDefaultType()
        L_0x0052:
            com.tencent.android.tpns.mqtt.logging.Logger r10 = r14.logger
            if (r10 == 0) goto L_0x0069
            java.lang.Object[] r11 = new java.lang.Object[r6]
            if (r15 == 0) goto L_0x005c
            r12 = r15
            goto L_0x005d
        L_0x005c:
            r12 = r4
        L_0x005d:
            r11[r5] = r12
            if (r9 == 0) goto L_0x0062
            r2 = r9
        L_0x0062:
            r11[r3] = r2
            java.lang.String r2 = "12013"
            r10.fine(r7, r8, r2, r11)
        L_0x0069:
            java.lang.String r2 = javax.net.ssl.TrustManagerFactory.getDefaultAlgorithm()
            java.lang.String r10 = r14.getTrustStoreProvider(r15)
            java.lang.String r11 = r14.getTrustManager(r15)
            if (r11 == 0) goto L_0x0078
            r2 = r11
        L_0x0078:
            r11 = 0
            if (r0 == 0) goto L_0x0110
            if (r9 == 0) goto L_0x0110
            if (r2 == 0) goto L_0x0110
            java.security.KeyStore r9 = java.security.KeyStore.getInstance(r9)     // Catch:{ KeyStoreException -> 0x00fb, CertificateException -> 0x00f4, FileNotFoundException -> 0x00ed, IOException -> 0x00e6 }
            java.io.FileInputStream r12 = new java.io.FileInputStream     // Catch:{ KeyStoreException -> 0x00fb, CertificateException -> 0x00f4, FileNotFoundException -> 0x00ed, IOException -> 0x00e6 }
            r12.<init>(r0)     // Catch:{ KeyStoreException -> 0x00fb, CertificateException -> 0x00f4, FileNotFoundException -> 0x00ed, IOException -> 0x00e6 }
            r9.load(r12, r1)     // Catch:{ KeyStoreException -> 0x00e1, CertificateException -> 0x00de, FileNotFoundException -> 0x00db, IOException -> 0x00d8, all -> 0x00d5 }
            if (r10 == 0) goto L_0x0092
            javax.net.ssl.TrustManagerFactory r0 = javax.net.ssl.TrustManagerFactory.getInstance(r2, r10)     // Catch:{ KeyStoreException -> 0x00e1, CertificateException -> 0x00de, FileNotFoundException -> 0x00db, IOException -> 0x00d8, all -> 0x00d5 }
            goto L_0x0096
        L_0x0092:
            javax.net.ssl.TrustManagerFactory r0 = javax.net.ssl.TrustManagerFactory.getInstance(r2)     // Catch:{ KeyStoreException -> 0x00e1, CertificateException -> 0x00de, FileNotFoundException -> 0x00db, IOException -> 0x00d8, all -> 0x00d5 }
        L_0x0096:
            com.tencent.android.tpns.mqtt.logging.Logger r1 = r14.logger     // Catch:{ KeyStoreException -> 0x00e1, CertificateException -> 0x00de, FileNotFoundException -> 0x00db, IOException -> 0x00d8, all -> 0x00d5 }
            if (r1 == 0) goto L_0x00c3
            java.lang.String r10 = "12017"
            java.lang.Object[] r11 = new java.lang.Object[r6]     // Catch:{ KeyStoreException -> 0x00e1, CertificateException -> 0x00de, FileNotFoundException -> 0x00db, IOException -> 0x00d8, all -> 0x00d5 }
            if (r15 == 0) goto L_0x00a2
            r13 = r15
            goto L_0x00a3
        L_0x00a2:
            r13 = r4
        L_0x00a3:
            r11[r5] = r13     // Catch:{ KeyStoreException -> 0x00e1, CertificateException -> 0x00de, FileNotFoundException -> 0x00db, IOException -> 0x00d8, all -> 0x00d5 }
            r11[r3] = r2     // Catch:{ KeyStoreException -> 0x00e1, CertificateException -> 0x00de, FileNotFoundException -> 0x00db, IOException -> 0x00d8, all -> 0x00d5 }
            r1.fine(r7, r8, r10, r11)     // Catch:{ KeyStoreException -> 0x00e1, CertificateException -> 0x00de, FileNotFoundException -> 0x00db, IOException -> 0x00d8, all -> 0x00d5 }
            com.tencent.android.tpns.mqtt.logging.Logger r1 = r14.logger     // Catch:{ KeyStoreException -> 0x00e1, CertificateException -> 0x00de, FileNotFoundException -> 0x00db, IOException -> 0x00d8, all -> 0x00d5 }
            java.lang.String r2 = "12016"
            java.lang.Object[] r6 = new java.lang.Object[r6]     // Catch:{ KeyStoreException -> 0x00e1, CertificateException -> 0x00de, FileNotFoundException -> 0x00db, IOException -> 0x00d8, all -> 0x00d5 }
            if (r15 == 0) goto L_0x00b3
            goto L_0x00b4
        L_0x00b3:
            r15 = r4
        L_0x00b4:
            r6[r5] = r15     // Catch:{ KeyStoreException -> 0x00e1, CertificateException -> 0x00de, FileNotFoundException -> 0x00db, IOException -> 0x00d8, all -> 0x00d5 }
            java.security.Provider r15 = r0.getProvider()     // Catch:{ KeyStoreException -> 0x00e1, CertificateException -> 0x00de, FileNotFoundException -> 0x00db, IOException -> 0x00d8, all -> 0x00d5 }
            java.lang.String r15 = r15.getName()     // Catch:{ KeyStoreException -> 0x00e1, CertificateException -> 0x00de, FileNotFoundException -> 0x00db, IOException -> 0x00d8, all -> 0x00d5 }
            r6[r3] = r15     // Catch:{ KeyStoreException -> 0x00e1, CertificateException -> 0x00de, FileNotFoundException -> 0x00db, IOException -> 0x00d8, all -> 0x00d5 }
            r1.fine(r7, r8, r2, r6)     // Catch:{ KeyStoreException -> 0x00e1, CertificateException -> 0x00de, FileNotFoundException -> 0x00db, IOException -> 0x00d8, all -> 0x00d5 }
        L_0x00c3:
            r0.init(r9)     // Catch:{ KeyStoreException -> 0x00e1, CertificateException -> 0x00de, FileNotFoundException -> 0x00db, IOException -> 0x00d8, all -> 0x00d5 }
            javax.net.ssl.TrustManager[] r11 = r0.getTrustManagers()     // Catch:{ KeyStoreException -> 0x00e1, CertificateException -> 0x00de, FileNotFoundException -> 0x00db, IOException -> 0x00d8, all -> 0x00d5 }
            r12.close()     // Catch:{ IOException -> 0x00ce }
            goto L_0x0110
        L_0x00ce:
            r15 = move-exception
            com.tencent.android.tpns.mqtt.MqttSecurityException r0 = new com.tencent.android.tpns.mqtt.MqttSecurityException
            r0.<init>((java.lang.Throwable) r15)
            throw r0
        L_0x00d5:
            r15 = move-exception
            r11 = r12
            goto L_0x0102
        L_0x00d8:
            r15 = move-exception
            r11 = r12
            goto L_0x00e7
        L_0x00db:
            r15 = move-exception
            r11 = r12
            goto L_0x00ee
        L_0x00de:
            r15 = move-exception
            r11 = r12
            goto L_0x00f5
        L_0x00e1:
            r15 = move-exception
            r11 = r12
            goto L_0x00fc
        L_0x00e4:
            r15 = move-exception
            goto L_0x0102
        L_0x00e6:
            r15 = move-exception
        L_0x00e7:
            com.tencent.android.tpns.mqtt.MqttSecurityException r0 = new com.tencent.android.tpns.mqtt.MqttSecurityException     // Catch:{ all -> 0x00e4 }
            r0.<init>((java.lang.Throwable) r15)     // Catch:{ all -> 0x00e4 }
            throw r0     // Catch:{ all -> 0x00e4 }
        L_0x00ed:
            r15 = move-exception
        L_0x00ee:
            com.tencent.android.tpns.mqtt.MqttSecurityException r0 = new com.tencent.android.tpns.mqtt.MqttSecurityException     // Catch:{ all -> 0x00e4 }
            r0.<init>((java.lang.Throwable) r15)     // Catch:{ all -> 0x00e4 }
            throw r0     // Catch:{ all -> 0x00e4 }
        L_0x00f4:
            r15 = move-exception
        L_0x00f5:
            com.tencent.android.tpns.mqtt.MqttSecurityException r0 = new com.tencent.android.tpns.mqtt.MqttSecurityException     // Catch:{ all -> 0x00e4 }
            r0.<init>((java.lang.Throwable) r15)     // Catch:{ all -> 0x00e4 }
            throw r0     // Catch:{ all -> 0x00e4 }
        L_0x00fb:
            r15 = move-exception
        L_0x00fc:
            com.tencent.android.tpns.mqtt.MqttSecurityException r0 = new com.tencent.android.tpns.mqtt.MqttSecurityException     // Catch:{ all -> 0x00e4 }
            r0.<init>((java.lang.Throwable) r15)     // Catch:{ all -> 0x00e4 }
            throw r0     // Catch:{ all -> 0x00e4 }
        L_0x0102:
            if (r11 == 0) goto L_0x010f
            r11.close()     // Catch:{ IOException -> 0x0108 }
            goto L_0x010f
        L_0x0108:
            r15 = move-exception
            com.tencent.android.tpns.mqtt.MqttSecurityException r0 = new com.tencent.android.tpns.mqtt.MqttSecurityException
            r0.<init>((java.lang.Throwable) r15)
            throw r0
        L_0x010f:
            throw r15
        L_0x0110:
            return r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.android.tpns.mqtt.internal.security.SSLSocketFactoryFactory.getTrustManagersForSSLContext(java.lang.String):javax.net.ssl.TrustManager[]");
    }

    public static boolean isSupportedOnJVM() throws LinkageError, ExceptionInInitializerError {
        try {
            Class.forName("javax.net.ssl.SSLServerSocketFactory");
            return true;
        } catch (ClassNotFoundException unused) {
            return false;
        }
    }

    private boolean keyValid(String str) {
        String[] strArr;
        int i11 = 0;
        while (true) {
            strArr = propertyKeys;
            if (i11 < strArr.length && !strArr[i11].equals(str)) {
                i11++;
            }
        }
        if (i11 < strArr.length) {
            return true;
        }
        return false;
    }

    public static String obfuscate(char[] cArr) {
        if (cArr == null) {
            return null;
        }
        byte[] bArr = toByte(cArr);
        for (int i11 = 0; i11 < bArr.length; i11++) {
            byte b11 = bArr[i11];
            byte[] bArr2 = key;
            bArr[i11] = (byte) ((b11 ^ bArr2[i11 % bArr2.length]) & 255);
        }
        return xorTag + new String(SimpleBase64Encoder.encode(bArr));
    }

    public static String packCipherSuites(String[] strArr) {
        if (strArr == null) {
            return null;
        }
        StringBuffer stringBuffer = new StringBuffer();
        for (int i11 = 0; i11 < strArr.length; i11++) {
            stringBuffer.append(strArr[i11]);
            if (i11 < strArr.length - 1) {
                stringBuffer.append(',');
            }
        }
        return stringBuffer.toString();
    }

    public static byte[] toByte(char[] cArr) {
        if (cArr == null) {
            return null;
        }
        byte[] bArr = new byte[(cArr.length * 2)];
        int i11 = 0;
        for (int i12 = 0; i12 < cArr.length; i12++) {
            int i13 = i11 + 1;
            bArr[i11] = (byte) (cArr[i12] & 255);
            i11 = i13 + 1;
            bArr[i13] = (byte) ((cArr[i12] >> 8) & 255);
        }
        return bArr;
    }

    public static char[] toChar(byte[] bArr) {
        if (bArr == null) {
            return null;
        }
        char[] cArr = new char[(bArr.length / 2)];
        int i11 = 0;
        int i12 = 0;
        while (i11 < bArr.length) {
            int i13 = i11 + 1;
            cArr[i12] = (char) ((bArr[i11] & 255) + ((bArr[i13] & 255) << 8));
            i12++;
            i11 = i13 + 1;
        }
        return cArr;
    }

    public static String[] unpackCipherSuites(String str) {
        if (str == null) {
            return null;
        }
        Vector vector = new Vector();
        int indexOf = str.indexOf(44);
        int i11 = 0;
        while (indexOf > -1) {
            vector.add(str.substring(i11, indexOf));
            i11 = indexOf + 1;
            indexOf = str.indexOf(44, i11);
        }
        vector.add(str.substring(i11));
        String[] strArr = new String[vector.size()];
        vector.toArray(strArr);
        return strArr;
    }

    public SSLSocketFactory createSocketFactory(String str) throws MqttSecurityException {
        SSLContext sSLContext = getSSLContext(str);
        Logger logger2 = this.logger;
        if (logger2 != null) {
            Object[] objArr = new Object[2];
            objArr[0] = str != null ? str : "null (broker defaults)";
            objArr[1] = getEnabledCipherSuites(str) != null ? getProperty(str, CIPHERSUITES, (String) null) : "null (using platform-enabled cipher suites)";
            logger2.fine(CLASS_NAME, "createSocketFactory", "12020", objArr);
        }
        return sSLContext.getSocketFactory();
    }

    public boolean getClientAuthentication(String str) {
        String property = getProperty(str, CLIENTAUTH, (String) null);
        if (property != null) {
            return Boolean.valueOf(property).booleanValue();
        }
        return false;
    }

    public Properties getConfiguration(String str) {
        Object obj;
        if (str == null) {
            obj = this.defaultProperties;
        } else {
            obj = this.configs.get(str);
        }
        return (Properties) obj;
    }

    public String[] getEnabledCipherSuites(String str) {
        return unpackCipherSuites(getProperty(str, CIPHERSUITES, (String) null));
    }

    public String getJSSEProvider(String str) {
        return getProperty(str, JSSEPROVIDER, (String) null);
    }

    public String getKeyManager(String str) {
        return getProperty(str, KEYSTOREMGR, SYSKEYMGRALGO);
    }

    public String getKeyStore(String str) {
        String propertyFromConfig = getPropertyFromConfig(str, KEYSTORE);
        if (propertyFromConfig != null) {
            return propertyFromConfig;
        }
        return System.getProperty(SYSKEYSTORE);
    }

    public char[] getKeyStorePassword(String str) {
        String property = getProperty(str, KEYSTOREPWD, SYSKEYSTOREPWD);
        if (property == null) {
            return null;
        }
        if (property.startsWith(xorTag)) {
            return deObfuscate(property);
        }
        return property.toCharArray();
    }

    public String getKeyStoreProvider(String str) {
        return getProperty(str, KEYSTOREPROVIDER, (String) null);
    }

    public String getKeyStoreType(String str) {
        return getProperty(str, KEYSTORETYPE, SYSKEYSTORETYPE);
    }

    public String getSSLProtocol(String str) {
        return getProperty(str, SSLPROTOCOL, (String) null);
    }

    public String getTrustManager(String str) {
        return getProperty(str, TRUSTSTOREMGR, SYSTRUSTMGRALGO);
    }

    public String getTrustStore(String str) {
        return getProperty(str, TRUSTSTORE, SYSTRUSTSTORE);
    }

    public char[] getTrustStorePassword(String str) {
        String property = getProperty(str, TRUSTSTOREPWD, SYSTRUSTSTOREPWD);
        if (property == null) {
            return null;
        }
        if (property.startsWith(xorTag)) {
            return deObfuscate(property);
        }
        return property.toCharArray();
    }

    public String getTrustStoreProvider(String str) {
        return getProperty(str, TRUSTSTOREPROVIDER, (String) null);
    }

    public String getTrustStoreType(String str) {
        return getProperty(str, TRUSTSTORETYPE, (String) null);
    }

    public void initialize(Properties properties, String str) throws IllegalArgumentException {
        checkPropertyKeys(properties);
        Properties properties2 = new Properties();
        properties2.putAll(properties);
        convertPassword(properties2);
        if (str != null) {
            this.configs.put(str, properties2);
        } else {
            this.defaultProperties = properties2;
        }
    }

    public void merge(Properties properties, String str) throws IllegalArgumentException {
        checkPropertyKeys(properties);
        Properties properties2 = this.defaultProperties;
        if (str != null) {
            properties2 = (Properties) this.configs.get(str);
        }
        if (properties2 == null) {
            properties2 = new Properties();
        }
        convertPassword(properties);
        properties2.putAll(properties);
        if (str != null) {
            this.configs.put(str, properties2);
        } else {
            this.defaultProperties = properties2;
        }
    }

    public boolean remove(String str) {
        if (str != null) {
            if (this.configs.remove(str) != null) {
                return true;
            }
        } else if (this.defaultProperties != null) {
            this.defaultProperties = null;
            return true;
        }
        return false;
    }

    public SSLSocketFactoryFactory(Logger logger2) {
        this();
        this.logger = logger2;
    }
}
