package org.jmrtd.lds;

import com.iproov.sdk.bridge.OptionsBridge;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import net.sf.scuba.tlv.TLVOutputStream;
import org.jmrtd.cbeff.BiometricDataBlock;

public abstract class CBEFFDataGroup<R extends BiometricDataBlock> extends DataGroup {
    public static final Logger LOGGER = Logger.getLogger("org.jmrtd");
    private static final long serialVersionUID = 2702959939408371946L;
    private Random random;
    private List<R> subRecords;

    public CBEFFDataGroup(int i11, List<R> list) {
        super(i11);
        addAll(list);
        this.random = new SecureRandom();
    }

    public void add(R r11) {
        if (this.subRecords == null) {
            this.subRecords = new ArrayList();
        }
        this.subRecords.add(r11);
    }

    public void addAll(List<R> list) {
        if (this.subRecords == null) {
            this.subRecords = new ArrayList();
        }
        this.subRecords.addAll(list);
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof CBEFFDataGroup)) {
            return false;
        }
        try {
            List subRecords2 = getSubRecords();
            List subRecords3 = ((CBEFFDataGroup) obj).getSubRecords();
            int size = subRecords2.size();
            if (size != subRecords3.size()) {
                return false;
            }
            for (int i11 = 0; i11 < size; i11++) {
                BiometricDataBlock biometricDataBlock = (BiometricDataBlock) subRecords2.get(i11);
                BiometricDataBlock biometricDataBlock2 = (BiometricDataBlock) subRecords3.get(i11);
                if (biometricDataBlock == null) {
                    if (biometricDataBlock2 != null) {
                        return false;
                    }
                } else if (!biometricDataBlock.equals(biometricDataBlock2)) {
                    return false;
                }
            }
            return true;
        } catch (ClassCastException e11) {
            LOGGER.log(Level.WARNING, "Wrong class", e11);
            return false;
        }
    }

    public List<R> getSubRecords() {
        if (this.subRecords == null) {
            this.subRecords = new ArrayList();
        }
        return new ArrayList(this.subRecords);
    }

    public int hashCode() {
        int i11 = 1234567891;
        for (BiometricDataBlock biometricDataBlock : getSubRecords()) {
            if (biometricDataBlock == null) {
                i11 = (i11 * 3) + 5;
            } else {
                i11 = ((i11 + biometricDataBlock.hashCode()) * 5) + 7;
            }
        }
        return (i11 * 7) + 11;
    }

    public void remove(int i11) {
        if (this.subRecords == null) {
            this.subRecords = new ArrayList();
        }
        this.subRecords.remove(i11);
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("CBEFFDataGroup [");
        List<R> list = this.subRecords;
        if (list == null) {
            sb2.append(OptionsBridge.NULL_VALUE);
        } else {
            boolean z11 = true;
            for (R r11 : list) {
                if (!z11) {
                    sb2.append(", ");
                } else {
                    z11 = false;
                }
                sb2.append(r11 == null ? OptionsBridge.NULL_VALUE : r11.toString());
            }
        }
        sb2.append(']');
        return sb2.toString();
    }

    public void writeOptionalRandomData(OutputStream outputStream) throws IOException {
        if (this.subRecords.isEmpty()) {
            TLVOutputStream tLVOutputStream = outputStream instanceof TLVOutputStream ? (TLVOutputStream) outputStream : new TLVOutputStream(outputStream);
            tLVOutputStream.writeTag(83);
            byte[] bArr = new byte[8];
            this.random.nextBytes(bArr);
            tLVOutputStream.writeValue(bArr);
        }
    }

    public CBEFFDataGroup(int i11, InputStream inputStream) throws IOException {
        super(i11, inputStream);
        this.random = new Random();
    }
}
