package androidx.biometric;

import android.hardware.biometrics.BiometricPrompt;
import android.os.Build;
import android.security.identity.IdentityCredential;
import android.security.keystore.KeyGenParameterSpec;
import android.util.Log;
import androidx.biometric.BiometricPrompt;
import androidx.core.hardware.fingerprint.FingerprintManagerCompat;
import java.io.IOException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.Signature;
import java.security.UnrecoverableKeyException;
import java.security.cert.CertificateException;
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.Mac;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;

public class d {

    public static class a {
        public static KeyGenParameterSpec a(KeyGenParameterSpec.Builder builder) {
            return builder.build();
        }

        public static KeyGenParameterSpec.Builder b(String str, int i11) {
            return new KeyGenParameterSpec.Builder(str, i11);
        }

        public static void c(KeyGenerator keyGenerator, KeyGenParameterSpec keyGenParameterSpec) throws InvalidAlgorithmParameterException {
            keyGenerator.init(keyGenParameterSpec);
        }

        public static void d(KeyGenParameterSpec.Builder builder) {
            builder.setBlockModes(new String[]{"CBC"});
        }

        public static void e(KeyGenParameterSpec.Builder builder) {
            builder.setEncryptionPaddings(new String[]{"PKCS7Padding"});
        }
    }

    public static class b {
        public static BiometricPrompt.CryptoObject a(Signature signature) {
            return new BiometricPrompt.CryptoObject(signature);
        }

        public static BiometricPrompt.CryptoObject b(Cipher cipher) {
            return new BiometricPrompt.CryptoObject(cipher);
        }

        public static BiometricPrompt.CryptoObject c(Mac mac) {
            return new BiometricPrompt.CryptoObject(mac);
        }

        public static Cipher d(BiometricPrompt.CryptoObject cryptoObject) {
            return cryptoObject.getCipher();
        }

        public static Mac e(BiometricPrompt.CryptoObject cryptoObject) {
            return cryptoObject.getMac();
        }

        public static Signature f(BiometricPrompt.CryptoObject cryptoObject) {
            return cryptoObject.getSignature();
        }
    }

    public static class c {
        public static BiometricPrompt.CryptoObject a(IdentityCredential identityCredential) {
            return new BiometricPrompt.CryptoObject(identityCredential);
        }

        public static IdentityCredential b(BiometricPrompt.CryptoObject cryptoObject) {
            return cryptoObject.getIdentityCredential();
        }
    }

    public static BiometricPrompt.b a() {
        try {
            KeyStore instance = KeyStore.getInstance("AndroidKeyStore");
            instance.load((KeyStore.LoadStoreParameter) null);
            KeyGenParameterSpec.Builder b11 = a.b("androidxBiometric", 3);
            a.d(b11);
            a.e(b11);
            KeyGenerator instance2 = KeyGenerator.getInstance(com.sumsub.sns.prooface.network.b.f40261d, "AndroidKeyStore");
            a.c(instance2, a.a(b11));
            instance2.generateKey();
            Cipher instance3 = Cipher.getInstance("AES/CBC/PKCS7Padding");
            instance3.init(1, (SecretKey) instance.getKey("androidxBiometric", (char[]) null));
            return new BiometricPrompt.b(instance3);
        } catch (IOException | InvalidAlgorithmParameterException | InvalidKeyException | KeyStoreException | NoSuchAlgorithmException | NoSuchProviderException | UnrecoverableKeyException | CertificateException | NoSuchPaddingException e11) {
            Log.w("CryptoObjectUtils", "Failed to create fake crypto object.", e11);
            return null;
        }
    }

    public static BiometricPrompt.b b(BiometricPrompt.CryptoObject cryptoObject) {
        IdentityCredential b11;
        if (cryptoObject == null) {
            return null;
        }
        Cipher d11 = b.d(cryptoObject);
        if (d11 != null) {
            return new BiometricPrompt.b(d11);
        }
        Signature f11 = b.f(cryptoObject);
        if (f11 != null) {
            return new BiometricPrompt.b(f11);
        }
        Mac e11 = b.e(cryptoObject);
        if (e11 != null) {
            return new BiometricPrompt.b(e11);
        }
        if (Build.VERSION.SDK_INT < 30 || (b11 = c.b(cryptoObject)) == null) {
            return null;
        }
        return new BiometricPrompt.b(b11);
    }

    public static BiometricPrompt.b c(FingerprintManagerCompat.d dVar) {
        if (dVar == null) {
            return null;
        }
        Cipher a11 = dVar.a();
        if (a11 != null) {
            return new BiometricPrompt.b(a11);
        }
        Signature c11 = dVar.c();
        if (c11 != null) {
            return new BiometricPrompt.b(c11);
        }
        Mac b11 = dVar.b();
        if (b11 != null) {
            return new BiometricPrompt.b(b11);
        }
        return null;
    }

    public static BiometricPrompt.CryptoObject d(BiometricPrompt.b bVar) {
        IdentityCredential b11;
        if (bVar == null) {
            return null;
        }
        Cipher a11 = bVar.a();
        if (a11 != null) {
            return b.b(a11);
        }
        Signature d11 = bVar.d();
        if (d11 != null) {
            return b.a(d11);
        }
        Mac c11 = bVar.c();
        if (c11 != null) {
            return b.c(c11);
        }
        if (Build.VERSION.SDK_INT < 30 || (b11 = bVar.b()) == null) {
            return null;
        }
        return c.a(b11);
    }

    public static FingerprintManagerCompat.d e(BiometricPrompt.b bVar) {
        if (bVar == null) {
            return null;
        }
        Cipher a11 = bVar.a();
        if (a11 != null) {
            return new FingerprintManagerCompat.d(a11);
        }
        Signature d11 = bVar.d();
        if (d11 != null) {
            return new FingerprintManagerCompat.d(d11);
        }
        Mac c11 = bVar.c();
        if (c11 != null) {
            return new FingerprintManagerCompat.d(c11);
        }
        if (Build.VERSION.SDK_INT >= 30 && bVar.b() != null) {
            Log.e("CryptoObjectUtils", "Identity credential is not supported by FingerprintManager.");
        }
        return null;
    }
}
