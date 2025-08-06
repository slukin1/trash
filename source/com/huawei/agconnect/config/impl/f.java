package com.huawei.agconnect.config.impl;

import android.text.TextUtils;
import android.util.Log;
import com.huawei.agconnect.config.IDecrypt;
import java.io.UnsupportedEncodingException;
import java.security.GeneralSecurityException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import javax.crypto.SecretKey;

public class f implements IDecrypt {

    /* renamed from: a  reason: collision with root package name */
    private SecretKey f37505a;

    /* renamed from: b  reason: collision with root package name */
    private final d f37506b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f37507c = false;

    public f(d dVar) {
        this.f37506b = dVar;
    }

    private void a() {
        try {
            this.f37505a = j.a(this.f37506b);
        } catch (IllegalArgumentException | NoSuchAlgorithmException | InvalidKeySpecException unused) {
            Log.e("AGC_LocalResource", "Exception when reading the 'K&I' for 'Config'.");
            this.f37505a = null;
        }
        this.f37507c = true;
    }

    public String decrypt(String str, String str2) {
        if (!this.f37507c) {
            a();
        }
        if (this.f37505a != null && !TextUtils.isEmpty(str)) {
            try {
                return new String(j.a(this.f37505a, Hex.decodeHexString(str)), "UTF-8");
            } catch (UnsupportedEncodingException | IllegalArgumentException | GeneralSecurityException e11) {
                Log.e("AGC_LocalResource", "decrypt exception:" + e11.getMessage());
            }
        }
        return str2;
    }
}
