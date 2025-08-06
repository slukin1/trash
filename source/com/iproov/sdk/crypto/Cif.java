package com.iproov.sdk.crypto;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Build;
import android.security.KeyChain;
import android.security.KeyPairGeneratorSpec;
import android.security.keystore.KeyGenParameterSpec;
import android.security.keystore.KeyInfo;
import com.iproov.sdk.logging.IPLog;
import com.iproov.sdk.p031this.Cdo;
import com.sumsub.sns.prooface.network.b;
import java.math.BigInteger;
import java.security.InvalidAlgorithmParameterException;
import java.security.Key;
import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.PrivateKey;
import java.security.Provider;
import java.security.SecureRandom;
import java.security.Security;
import java.security.Signature;
import java.security.UnrecoverableEntryException;
import java.security.UnrecoverableKeyException;
import java.security.cert.Certificate;
import java.security.spec.AlgorithmParameterSpec;
import java.security.spec.ECGenParameterSpec;
import java.util.Date;
import javax.security.auth.x500.X500Principal;

/* renamed from: com.iproov.sdk.crypto.if  reason: invalid class name */
public final class Cif {

    /* renamed from: new  reason: not valid java name */
    private static final String f447new = ("🗝 " + Cif.class.getSimpleName());

    /* renamed from: try  reason: not valid java name */
    private static Cif f448try;

    /* renamed from: do  reason: not valid java name */
    private final Context f449do;

    /* renamed from: for  reason: not valid java name */
    private final KeyPair f450for;

    /* renamed from: if  reason: not valid java name */
    private final KeyStore f451if;

    private Cif(Context context) throws Cdo {
        this.f449do = context.getApplicationContext();
        try {
            KeyStore instance = KeyStore.getInstance("AndroidKeyStore");
            this.f451if = instance;
            instance.load((KeyStore.LoadStoreParameter) null);
            com.iproov.sdk.p019interface.Cif ifVar = new com.iproov.sdk.p019interface.Cif(context);
            if (m521goto() && ifVar.m1101break() && m522new()) {
                ifVar.m1106class();
            }
            KeyPair keyPair = m518try();
            this.f450for = keyPair;
            if (keyPair.getPublic() == null) {
                throw new IllegalStateException("Public Key cannot be null");
            } else if (keyPair.getPrivate() == null) {
                throw new IllegalStateException("Private Key cannot be null");
            }
        } catch (Exception e11) {
            e11.printStackTrace();
            throw new Cdo(e11);
        }
    }

    @SuppressLint({"WrongConstant"})
    /* renamed from: break  reason: not valid java name */
    private boolean m507break() {
        return KeyChain.isBoundKeyAlgorithm("EC");
    }

    /* renamed from: catch  reason: not valid java name */
    private boolean m508catch() {
        PrivateKey privateKey = this.f450for.getPrivate();
        try {
            return ((KeyInfo) KeyFactory.getInstance(privateKey.getAlgorithm(), "AndroidKeyStore").getKeySpec(privateKey, KeyInfo.class)).isInsideSecureHardware();
        } catch (Exception e11) {
            IPLog.w(f447new, "Error retrieving key info");
            e11.printStackTrace();
            return false;
        }
    }

    /* renamed from: class  reason: not valid java name */
    private static void m509class() {
        Provider[] providers = Security.getProviders();
        StringBuilder sb2 = new StringBuilder();
        sb2.append("Services available for SHA256withECDSA algorithm: [");
        for (Provider service : providers) {
            Provider.Service service2 = service.getService("Signature", "SHA256withECDSA");
            if (service2 != null) {
                sb2.append(service2.toString());
            }
        }
        sb2.append("]");
        IPLog.w(f447new, sb2.toString());
    }

    /* renamed from: do  reason: not valid java name */
    public static synchronized Cif m511do(Context context) throws Cdo {
        Cif ifVar;
        synchronized (Cif.class) {
            if (f448try == null) {
                f448try = new Cif(context);
            }
            ifVar = f448try;
        }
        return ifVar;
    }

    /* renamed from: else  reason: not valid java name */
    private Signature m514else() throws NoSuchAlgorithmException {
        try {
            return Signature.getInstance("SHA256withECDSA", Build.VERSION.SDK_INT >= 23 ? "AndroidKeyStoreBCWorkaround" : "AndroidOpenSSL");
        } catch (NoSuchProviderException e11) {
            e11.printStackTrace();
            m509class();
            return Signature.getInstance("SHA256withECDSA");
        }
    }

    /* renamed from: for  reason: not valid java name */
    private KeyPair m515for() throws NoSuchAlgorithmException, NoSuchProviderException, InvalidAlgorithmParameterException {
        AlgorithmParameterSpec algorithmParameterSpec;
        int i11 = Build.VERSION.SDK_INT;
        KeyPairGenerator instance = KeyPairGenerator.getInstance(i11 > 23 ? "EC" : "RSA", "AndroidKeyStore");
        if (i11 > 23) {
            algorithmParameterSpec = m517if();
        } else {
            algorithmParameterSpec = m513do();
        }
        instance.initialize(algorithmParameterSpec);
        return instance.generateKeyPair();
    }

    /* renamed from: if  reason: not valid java name */
    private AlgorithmParameterSpec m517if() {
        KeyGenParameterSpec.Builder digests = new KeyGenParameterSpec.Builder("com.iproov.sdk", 4).setAlgorithmParameterSpec(new ECGenParameterSpec(b.f40264g)).setDigests(new String[]{"SHA-256"});
        if (Build.VERSION.SDK_INT >= 28 && this.f449do.getPackageManager().hasSystemFeature("android.hardware.strongbox_keystore")) {
            digests.setIsStrongBoxBacked(false);
        }
        return digests.build();
    }

    /* renamed from: try  reason: not valid java name */
    private KeyPair m518try() throws KeyStoreException, UnrecoverableEntryException, NoSuchAlgorithmException, NoSuchProviderException, InvalidAlgorithmParameterException, Cdo {
        if (!this.f451if.containsAlias("com.iproov.sdk")) {
            return m515for();
        }
        if (Build.VERSION.SDK_INT >= 28) {
            return m516if(this.f451if);
        }
        return m512do(this.f451if);
    }

    /* renamed from: case  reason: not valid java name */
    public com.iproov.sdk.p031this.Cif m519case() {
        return new PublicKeyImpl(this.f450for.getPublic());
    }

    /* renamed from: goto  reason: not valid java name */
    public boolean m521goto() {
        return Build.VERSION.SDK_INT >= 28 && this.f449do.getPackageManager().hasSystemFeature("android.hardware.strongbox_keystore");
    }

    /* renamed from: new  reason: not valid java name */
    public boolean m522new() {
        try {
            this.f451if.deleteEntry("com.iproov.sdk");
            return true;
        } catch (KeyStoreException e11) {
            IPLog.e(f447new, e11.getLocalizedMessage());
            e11.printStackTrace();
            return false;
        }
    }

    /* renamed from: this  reason: not valid java name */
    public boolean m523this() {
        synchronized (this) {
            if (Build.VERSION.SDK_INT < 23) {
                boolean z11 = m507break();
                return z11;
            }
            boolean z12 = m508catch();
            return z12;
        }
    }

    /* renamed from: do  reason: not valid java name */
    public synchronized byte[] m520do(byte[] bArr) throws Cdo {
        Signature signature;
        try {
            signature = m514else();
            signature.initSign(this.f450for.getPrivate());
            signature.update(bArr);
        } catch (Exception e11) {
            e11.printStackTrace();
            throw new Cdo(e11);
        }
        return signature.sign();
    }

    /* renamed from: if  reason: not valid java name */
    private KeyPair m516if(KeyStore keyStore) throws KeyStoreException, UnrecoverableKeyException, NoSuchAlgorithmException {
        Key key = keyStore.getKey("com.iproov.sdk", (char[]) null);
        Certificate certificate = keyStore.getCertificate("com.iproov.sdk");
        if (key instanceof PrivateKey) {
            return new KeyPair(certificate.getPublicKey(), (PrivateKey) key);
        }
        throw new IllegalStateException("Unsupported Key type");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0015, code lost:
        return r1;
     */
    /* renamed from: do  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static synchronized com.iproov.sdk.crypto.Cdo m510do(com.iproov.sdk.crypto.Cif r1) {
        /*
            java.lang.Class<com.iproov.sdk.crypto.if> r0 = com.iproov.sdk.crypto.Cif.class
            monitor-enter(r0)
            if (r1 != 0) goto L_0x0009
            com.iproov.sdk.crypto.do r1 = com.iproov.sdk.crypto.Cdo.UNSUPPORTED     // Catch:{ all -> 0x0016 }
            monitor-exit(r0)
            return r1
        L_0x0009:
            boolean r1 = r1.m523this()     // Catch:{ all -> 0x0016 }
            if (r1 == 0) goto L_0x0012
            com.iproov.sdk.crypto.do r1 = com.iproov.sdk.crypto.Cdo.HARDWARE     // Catch:{ all -> 0x0016 }
            goto L_0x0014
        L_0x0012:
            com.iproov.sdk.crypto.do r1 = com.iproov.sdk.crypto.Cdo.SOFTWARE     // Catch:{ all -> 0x0016 }
        L_0x0014:
            monitor-exit(r0)
            return r1
        L_0x0016:
            r1 = move-exception
            monitor-exit(r0)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.iproov.sdk.crypto.Cif.m510do(com.iproov.sdk.crypto.if):com.iproov.sdk.crypto.do");
    }

    @SuppressLint({"WrongConstant"})
    /* renamed from: do  reason: not valid java name */
    private AlgorithmParameterSpec m513do() throws NoSuchAlgorithmException {
        return new KeyPairGeneratorSpec.Builder(this.f449do).setAlias("com.iproov.sdk").setSubject(new X500Principal("CN=com.iproov.sdk")).setAlgorithmParameterSpec(new ECGenParameterSpec(b.f40264g)).setSerialNumber(new BigInteger(25, new SecureRandom())).setStartDate(new Date(0)).setEndDate(new Date(2461449600000L)).setKeyType("EC").build();
    }

    /* renamed from: do  reason: not valid java name */
    private KeyPair m512do(KeyStore keyStore) throws KeyStoreException, UnrecoverableEntryException, NoSuchAlgorithmException, Cdo {
        try {
            KeyStore.Entry entry = keyStore.getEntry("com.iproov.sdk", (KeyStore.ProtectionParameter) null);
            if (entry instanceof KeyStore.PrivateKeyEntry) {
                KeyStore.PrivateKeyEntry privateKeyEntry = (KeyStore.PrivateKeyEntry) entry;
                return new KeyPair(privateKeyEntry.getCertificate().getPublicKey(), privateKeyEntry.getPrivateKey());
            }
            throw new IllegalStateException("Unsupported Key type");
        } catch (NullPointerException e11) {
            throw new Cdo(e11);
        }
    }
}
