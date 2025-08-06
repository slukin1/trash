package org.jmrtd.lds.icao;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;
import org.jmrtd.cbeff.BiometricDataBlock;
import org.jmrtd.cbeff.BiometricDataBlockDecoder;
import org.jmrtd.cbeff.BiometricDataBlockEncoder;
import org.jmrtd.cbeff.CBEFFInfo;
import org.jmrtd.cbeff.ComplexCBEFFInfo;
import org.jmrtd.cbeff.ISO781611Decoder;
import org.jmrtd.cbeff.ISO781611Encoder;
import org.jmrtd.cbeff.SimpleCBEFFInfo;
import org.jmrtd.cbeff.StandardBiometricHeader;
import org.jmrtd.lds.CBEFFDataGroup;
import org.jmrtd.lds.iso19794.FingerInfo;

public class DG3File extends CBEFFDataGroup<FingerInfo> {
    private static final ISO781611Decoder DECODER = new ISO781611Decoder(new BiometricDataBlockDecoder<FingerInfo>() {
        public FingerInfo decode(InputStream inputStream, StandardBiometricHeader standardBiometricHeader, int i11, int i12) throws IOException {
            return new FingerInfo(standardBiometricHeader, inputStream);
        }
    });
    private static final ISO781611Encoder<FingerInfo> ENCODER = new ISO781611Encoder<>(new BiometricDataBlockEncoder<FingerInfo>() {
        public void encode(FingerInfo fingerInfo, OutputStream outputStream) throws IOException {
            fingerInfo.writeObject(outputStream);
        }
    });
    private static final long serialVersionUID = -1037522331623814528L;
    private boolean shouldAddRandomDataIfEmpty;

    public DG3File(List<FingerInfo> list) {
        this(list, true);
    }

    public void addFingerInfo(FingerInfo fingerInfo) {
        add(fingerInfo);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!super.equals(obj) || getClass() != obj.getClass()) {
            return false;
        }
        if (this.shouldAddRandomDataIfEmpty == ((DG3File) obj).shouldAddRandomDataIfEmpty) {
            return true;
        }
        return false;
    }

    public List<FingerInfo> getFingerInfos() {
        return getSubRecords();
    }

    public int hashCode() {
        return (super.hashCode() * 31) + (this.shouldAddRandomDataIfEmpty ? 1231 : 1237);
    }

    public void readContent(InputStream inputStream) throws IOException {
        for (CBEFFInfo next : DECODER.decode(inputStream).getSubRecords()) {
            if (next instanceof SimpleCBEFFInfo) {
                BiometricDataBlock biometricDataBlock = ((SimpleCBEFFInfo) next).getBiometricDataBlock();
                if (biometricDataBlock instanceof FingerInfo) {
                    add((FingerInfo) biometricDataBlock);
                } else {
                    throw new IOException("Was expecting a FingerInfo, found " + biometricDataBlock.getClass().getSimpleName());
                }
            } else {
                throw new IOException("Was expecting a SimpleCBEFFInfo, found " + next.getClass().getSimpleName());
            }
        }
    }

    public void removeFingerInfo(int i11) {
        remove(i11);
    }

    public String toString() {
        return "DG3File [" + super.toString() + "]";
    }

    public void writeContent(OutputStream outputStream) throws IOException {
        ComplexCBEFFInfo complexCBEFFInfo = new ComplexCBEFFInfo();
        for (FingerInfo simpleCBEFFInfo : getSubRecords()) {
            complexCBEFFInfo.add(new SimpleCBEFFInfo(simpleCBEFFInfo));
        }
        ENCODER.encode(complexCBEFFInfo, outputStream);
        if (this.shouldAddRandomDataIfEmpty) {
            writeOptionalRandomData(outputStream);
        }
    }

    public DG3File(List<FingerInfo> list, boolean z11) {
        super(99, list);
        this.shouldAddRandomDataIfEmpty = z11;
    }

    public DG3File(InputStream inputStream) throws IOException {
        super(99, inputStream);
    }
}
