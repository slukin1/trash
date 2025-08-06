package org.bouncycastle.jcajce.spec;

import com.google.common.base.Ascii;
import java.security.spec.EncodedKeySpec;
import org.bouncycastle.util.Arrays;
import org.bouncycastle.util.Strings;

public class OpenSSHPublicKeySpec extends EncodedKeySpec {
    private static final String[] allowedTypes = {"ssh-rsa", "ssh-ed25519", "ssh-dss"};
    private final String type;

    public OpenSSHPublicKeySpec(byte[] bArr) {
        super(bArr);
        int i11 = 0;
        int i12 = (((bArr[0] & 255) << Ascii.CAN) | ((bArr[1] & 255) << 16) | ((bArr[2] & 255) << 8) | (bArr[3] & 255)) + 4;
        if (i12 < bArr.length) {
            String fromByteArray = Strings.fromByteArray(Arrays.copyOfRange(bArr, 4, i12));
            this.type = fromByteArray;
            if (!fromByteArray.startsWith("ecdsa")) {
                while (true) {
                    String[] strArr = allowedTypes;
                    if (i11 >= strArr.length) {
                        throw new IllegalArgumentException("unrecognised public key type " + this.type);
                    } else if (!strArr[i11].equals(this.type)) {
                        i11++;
                    } else {
                        return;
                    }
                }
            }
        } else {
            throw new IllegalArgumentException("invalid public key blob: type field longer than blob");
        }
    }

    public String getFormat() {
        return "OpenSSH";
    }

    public String getType() {
        return this.type;
    }
}
