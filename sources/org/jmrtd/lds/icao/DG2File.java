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
import org.jmrtd.lds.iso19794.FaceInfo;

public class DG2File extends CBEFFDataGroup<FaceInfo> {
    private static final ISO781611Decoder DECODER = new ISO781611Decoder(new BiometricDataBlockDecoder<FaceInfo>() {
        public FaceInfo decode(InputStream inputStream, StandardBiometricHeader standardBiometricHeader, int i11, int i12) throws IOException {
            return new FaceInfo(standardBiometricHeader, inputStream);
        }
    });
    private static final ISO781611Encoder<FaceInfo> ENCODER = new ISO781611Encoder<>(new BiometricDataBlockEncoder<FaceInfo>() {
        public void encode(FaceInfo faceInfo, OutputStream outputStream) throws IOException {
            faceInfo.writeObject(outputStream);
        }
    });
    private static final long serialVersionUID = 414300652684010416L;

    public DG2File(List<FaceInfo> list) {
        super(117, list);
    }

    public void addFaceInfo(FaceInfo faceInfo) {
        add(faceInfo);
    }

    public List<FaceInfo> getFaceInfos() {
        return getSubRecords();
    }

    public void readContent(InputStream inputStream) throws IOException {
        for (CBEFFInfo next : DECODER.decode(inputStream).getSubRecords()) {
            if (next instanceof SimpleCBEFFInfo) {
                BiometricDataBlock biometricDataBlock = ((SimpleCBEFFInfo) next).getBiometricDataBlock();
                if (biometricDataBlock instanceof FaceInfo) {
                    add((FaceInfo) biometricDataBlock);
                } else {
                    throw new IOException("Was expecting a FaceInfo, found " + biometricDataBlock.getClass().getSimpleName());
                }
            } else {
                throw new IOException("Was expecting a SimpleCBEFFInfo, found " + next.getClass().getSimpleName());
            }
        }
    }

    public void removeFaceInfo(int i11) {
        remove(i11);
    }

    public String toString() {
        return "DG2File [" + super.toString() + "]";
    }

    public void writeContent(OutputStream outputStream) throws IOException {
        ComplexCBEFFInfo complexCBEFFInfo = new ComplexCBEFFInfo();
        for (FaceInfo simpleCBEFFInfo : getSubRecords()) {
            complexCBEFFInfo.add(new SimpleCBEFFInfo(simpleCBEFFInfo));
        }
        ENCODER.encode(complexCBEFFInfo, outputStream);
    }

    public DG2File(InputStream inputStream) throws IOException {
        super(117, inputStream);
    }
}
