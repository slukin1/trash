package org.bouncycastle.jcajce;

import com.huawei.secure.android.common.encrypt.hash.PBKDF2;
import org.bouncycastle.crypto.CharToByteConverter;
import org.bouncycastle.util.Arrays;

public class PBKDF2Key implements PBKDFKey {
    private final CharToByteConverter converter;
    private final char[] password;

    public PBKDF2Key(char[] cArr, CharToByteConverter charToByteConverter) {
        this.password = Arrays.clone(cArr);
        this.converter = charToByteConverter;
    }

    public String getAlgorithm() {
        return PBKDF2.f38633a;
    }

    public byte[] getEncoded() {
        return this.converter.convert(this.password);
    }

    public String getFormat() {
        return this.converter.getType();
    }

    public char[] getPassword() {
        return this.password;
    }
}
