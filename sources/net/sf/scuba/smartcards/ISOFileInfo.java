package net.sf.scuba.smartcards;

import java.math.BigInteger;
import net.sf.scuba.util.Hex;
import org.jmrtd.cbeff.ISO781611;

public class ISOFileInfo extends FileInfo {
    public static final byte A0 = -96;
    public static final byte A1 = -95;
    public static final byte A2 = -94;
    public static final byte A5 = -91;
    public static final byte AB = -85;
    public static final byte AC = -84;
    public static final byte CHANNEL_SECURITY = -114;
    public static final byte DATA_BYTES1 = Byte.MIN_VALUE;
    public static final byte DATA_BYTES2 = -127;
    public static final byte DF_NAME = -124;
    public static final byte ENV_TEMP_EF = -115;
    public static final byte FCI_BYTE = 111;
    public static final byte FCI_EXT = -121;
    public static final byte FCP_BYTE = 98;
    public static final byte FILE_DESCRIPTOR = -126;
    public static final byte FILE_IDENTIFIER = -125;
    public static final byte FMD_BYTE = 100;
    public static final byte LCS_BYTE = -118;
    public static final byte PROP_INFO = -123;
    public static final byte SECURITY_ATTR_COMPACT = -116;
    public static final byte SECURITY_ATTR_EXP = -117;
    public static final byte SECURITY_ATTR_PROP = -122;
    public static final byte SHORT_EF = -120;

    /* renamed from: a0  reason: collision with root package name */
    public byte[] f58532a0 = null;

    /* renamed from: a1  reason: collision with root package name */
    public byte[] f58533a1 = null;

    /* renamed from: a2  reason: collision with root package name */
    public byte[] f58534a2 = null;

    /* renamed from: a5  reason: collision with root package name */
    public byte[] f58535a5 = null;

    /* renamed from: ab  reason: collision with root package name */
    public byte[] f58536ab = null;

    /* renamed from: ac  reason: collision with root package name */
    public byte[] f58537ac = null;
    public byte channelSecurity = -1;
    public byte dataCodingByte = -1;
    public byte descriptorByte = -1;
    public byte[] dfName = null;
    public short envTempEF = -1;
    public short fciExt = -1;
    public short fid = -1;
    public int fileLength = -1;
    public int fileLengthFCI = -1;
    public byte lcsByte = -1;
    public byte mainTag = -1;
    public short maxRecordSize = -1;
    public short maxRecordsCount = -1;
    public byte[] propInfo = null;
    public byte[] secAttrCompact = null;
    public byte[] secAttrExp = null;
    public byte[] secAttrProp = null;
    public byte shortEF = -1;

    public ISOFileInfo(byte[] bArr) throws CardServiceException {
        if (bArr.length != 0) {
            if (bArr[0] == 111 || bArr[0] == 98 || bArr[0] == 100) {
                this.mainTag = bArr[0];
                byte b11 = bArr[1];
                byte[] bArr2 = new byte[b11];
                System.arraycopy(bArr, 2, bArr2, 0, bArr[1]);
                byte b12 = 0;
                while (b12 < b11) {
                    int i11 = b12 + 1;
                    try {
                        byte b13 = bArr2[b12];
                        int i12 = i11 + 1;
                        byte b14 = bArr2[i11];
                        byte[] bArr3 = new byte[b14];
                        System.arraycopy(bArr2, i12, bArr3, 0, b14);
                        int i13 = i12 + b14;
                        if (b13 == -91) {
                            byte[] bArr4 = new byte[b14];
                            this.f58535a5 = bArr4;
                            System.arraycopy(bArr3, 0, bArr4, 0, b14);
                        } else if (b13 == -85) {
                            byte[] bArr5 = new byte[b14];
                            this.f58536ab = bArr5;
                            System.arraycopy(bArr3, 0, bArr5, 0, b14);
                        } else if (b13 != -84) {
                            switch (b13) {
                                case Byte.MIN_VALUE:
                                    this.fileLength = new BigInteger(bArr3).abs().intValue();
                                    break;
                                case -127:
                                    checkLen(b14, 2);
                                    this.fileLengthFCI = new BigInteger(bArr3).intValue();
                                    break;
                                case -126:
                                    checkLen(b14, 1, 6);
                                    this.descriptorByte = bArr3[0];
                                    if (1 != b14) {
                                        this.dataCodingByte = bArr3[1];
                                        if (2 != b14) {
                                            byte b15 = 3;
                                            if (b14 == 3) {
                                                this.maxRecordSize = (short) bArr3[2];
                                            } else {
                                                this.maxRecordSize = new BigInteger(new byte[]{bArr3[2], bArr3[3]}).shortValue();
                                                b15 = 4;
                                            }
                                            if (b15 != b14) {
                                                if (b14 != 5) {
                                                    this.maxRecordsCount = new BigInteger(new byte[]{bArr3[b15], bArr3[b15 + 1]}).shortValue();
                                                    break;
                                                } else {
                                                    this.maxRecordsCount = (short) bArr3[b15];
                                                    break;
                                                }
                                            } else {
                                                break;
                                            }
                                        } else {
                                            break;
                                        }
                                    } else {
                                        break;
                                    }
                                case -125:
                                    checkLen(b14, 2);
                                    this.fid = new BigInteger(bArr3).shortValue();
                                    break;
                                case -124:
                                    checkLen(b14, 0, 16);
                                    byte[] bArr6 = new byte[b14];
                                    this.dfName = bArr6;
                                    System.arraycopy(bArr3, 0, bArr6, 0, b14);
                                    break;
                                case -123:
                                    byte[] bArr7 = new byte[b14];
                                    this.propInfo = bArr7;
                                    System.arraycopy(bArr3, 0, bArr7, 0, b14);
                                    break;
                                case -122:
                                    byte[] bArr8 = new byte[b14];
                                    this.secAttrProp = bArr8;
                                    System.arraycopy(bArr3, 0, bArr8, 0, b14);
                                    break;
                                case -121:
                                    checkLen(b14, 2);
                                    this.fciExt = new BigInteger(bArr3).shortValue();
                                    break;
                                case -120:
                                    checkLen(b14, 0, 1);
                                    if (b14 != 0) {
                                        this.shortEF = bArr3[0];
                                        break;
                                    } else {
                                        this.shortEF = 0;
                                        break;
                                    }
                                default:
                                    switch (b13) {
                                        case -118:
                                            checkLen(b14, 1);
                                            this.lcsByte = bArr3[0];
                                            break;
                                        case -117:
                                            byte[] bArr9 = new byte[b14];
                                            this.secAttrExp = bArr9;
                                            System.arraycopy(bArr3, 0, bArr9, 0, b14);
                                            break;
                                        case -116:
                                            byte[] bArr10 = new byte[b14];
                                            this.secAttrCompact = bArr10;
                                            System.arraycopy(bArr3, 0, bArr10, 0, b14);
                                            break;
                                        case -115:
                                            checkLen(b14, 2);
                                            this.envTempEF = new BigInteger(bArr3).shortValue();
                                            break;
                                        case -114:
                                            checkLen(b14, 1);
                                            this.channelSecurity = bArr3[0];
                                            break;
                                        default:
                                            switch (b13) {
                                                case -96:
                                                    byte[] bArr11 = new byte[b14];
                                                    this.f58532a0 = bArr11;
                                                    System.arraycopy(bArr3, 0, bArr11, 0, b14);
                                                    break;
                                                case ISO781611.BIOMETRIC_HEADER_TEMPLATE_BASE_TAG /*-95*/:
                                                    byte[] bArr12 = new byte[b14];
                                                    this.f58533a1 = bArr12;
                                                    System.arraycopy(bArr3, 0, bArr12, 0, b14);
                                                    break;
                                                case -94:
                                                    byte[] bArr13 = new byte[b14];
                                                    this.f58534a2 = bArr13;
                                                    System.arraycopy(bArr3, 0, bArr13, 0, b14);
                                                    break;
                                                default:
                                                    throw new CardServiceException("Malformed FCI: unrecognized tag.");
                                            }
                                    }
                            }
                        } else {
                            byte[] bArr14 = new byte[b14];
                            this.f58537ac = bArr14;
                            System.arraycopy(bArr3, 0, bArr14, 0, b14);
                        }
                        b12 = i13;
                    } catch (ArrayIndexOutOfBoundsException unused) {
                        throw new CardServiceException("Malformed FCI.");
                    }
                }
                return;
            }
            throw new CardServiceException("Malformed FCI data");
        }
    }

    private static byte[] catArray(byte[] bArr, byte[] bArr2) {
        byte[] bArr3 = new byte[(bArr.length + bArr2.length)];
        System.arraycopy(bArr, 0, bArr3, 0, bArr.length);
        System.arraycopy(bArr2, 0, bArr3, bArr.length, bArr2.length);
        return bArr3;
    }

    private static void checkLen(int i11, int i12) throws CardServiceException {
        if (i11 != i12) {
            throw new CardServiceException("Malformed FCI.");
        }
    }

    private static byte[] getArray(byte b11, byte[] bArr) {
        byte[] bArr2 = new byte[(bArr.length + 2)];
        bArr2[0] = b11;
        bArr2[1] = (byte) bArr.length;
        System.arraycopy(bArr, 0, bArr2, 2, bArr.length);
        return bArr2;
    }

    public short getFID() {
        return this.fid;
    }

    public int getFileLength() {
        return this.fileLength;
    }

    public byte[] getFormatted() {
        byte[] bArr;
        String str;
        String str2;
        byte[] bArr2 = new byte[0];
        if (this.mainTag == -1) {
            return bArr2;
        }
        int i11 = this.fileLength;
        if (i11 != -1) {
            bArr2 = catArray(bArr2, getArray(Byte.MIN_VALUE, Hex.hexStringToBytes(Hex.shortToHexString((short) i11))));
        }
        int i12 = this.fileLengthFCI;
        if (i12 != -1) {
            bArr2 = catArray(bArr2, getArray(DATA_BYTES2, Hex.hexStringToBytes(Hex.shortToHexString((short) i12))));
        }
        byte b11 = this.descriptorByte;
        if (b11 != -1) {
            byte[] bArr3 = {b11};
            byte[] bArr4 = new byte[0];
            byte b12 = this.dataCodingByte;
            if (b12 != -1) {
                bArr4 = new byte[]{b12};
            }
            byte[] bArr5 = new byte[0];
            short s11 = this.maxRecordSize;
            if (s11 != -1) {
                if (s11 > 256) {
                    str2 = Hex.shortToHexString(s11);
                } else if (this.maxRecordsCount == -1) {
                    str2 = Hex.byteToHexString((byte) s11);
                } else {
                    str2 = Hex.shortToHexString(s11);
                }
                bArr5 = Hex.hexStringToBytes(str2);
            }
            byte[] bArr6 = new byte[0];
            short s12 = this.maxRecordsCount;
            if (s12 != -1) {
                if (s12 <= 256) {
                    str = Hex.byteToHexString((byte) s12);
                } else {
                    str = Hex.shortToHexString(s12);
                }
                bArr6 = Hex.hexStringToBytes(str);
            }
            bArr2 = catArray(bArr2, getArray((byte) -126, catArray(catArray(catArray(bArr3, bArr4), bArr5), bArr6)));
        }
        short s13 = this.fid;
        if (s13 != -1) {
            bArr2 = catArray(bArr2, getArray(FILE_IDENTIFIER, Hex.hexStringToBytes(Hex.shortToHexString(s13))));
        }
        byte[] bArr7 = this.dfName;
        if (bArr7 != null) {
            bArr2 = catArray(bArr2, getArray((byte) -124, bArr7));
        }
        byte[] bArr8 = this.propInfo;
        if (bArr8 != null) {
            bArr2 = catArray(bArr2, getArray(PROP_INFO, bArr8));
        }
        byte[] bArr9 = this.secAttrProp;
        if (bArr9 != null) {
            bArr2 = catArray(bArr2, getArray((byte) -122, bArr9));
        }
        short s14 = this.fciExt;
        if (s14 != -1) {
            bArr2 = catArray(bArr2, getArray(FCI_EXT, Hex.hexStringToBytes(Hex.shortToHexString(s14))));
        }
        byte b13 = this.shortEF;
        if (b13 != -1) {
            if (b13 == 0) {
                bArr = new byte[0];
            } else {
                bArr = new byte[]{b13};
            }
            bArr2 = catArray(bArr2, getArray((byte) -120, bArr));
        }
        byte b14 = this.lcsByte;
        if (b14 != -1) {
            bArr2 = catArray(bArr2, getArray(LCS_BYTE, new byte[]{b14}));
        }
        byte[] bArr10 = this.secAttrExp;
        if (bArr10 != null) {
            bArr2 = catArray(bArr2, getArray(SECURITY_ATTR_EXP, bArr10));
        }
        byte[] bArr11 = this.secAttrCompact;
        if (bArr11 != null) {
            bArr2 = catArray(bArr2, getArray(SECURITY_ATTR_COMPACT, bArr11));
        }
        short s15 = this.envTempEF;
        if (s15 != -1) {
            bArr2 = catArray(bArr2, getArray(ENV_TEMP_EF, Hex.hexStringToBytes(Hex.shortToHexString(s15))));
        }
        byte b15 = this.channelSecurity;
        if (b15 != -1) {
            bArr2 = catArray(bArr2, getArray(CHANNEL_SECURITY, new byte[]{b15}));
        }
        byte[] bArr12 = this.f58532a0;
        if (bArr12 != null) {
            bArr2 = catArray(bArr2, getArray(A0, bArr12));
        }
        byte[] bArr13 = this.f58533a1;
        if (bArr13 != null) {
            bArr2 = catArray(bArr2, getArray(A1, bArr13));
        }
        byte[] bArr14 = this.f58534a2;
        if (bArr14 != null) {
            bArr2 = catArray(bArr2, getArray((byte) -94, bArr14));
        }
        byte[] bArr15 = this.f58535a5;
        if (bArr15 != null) {
            bArr2 = catArray(bArr2, getArray(A5, bArr15));
        }
        byte[] bArr16 = this.f58536ab;
        if (bArr16 != null) {
            bArr2 = catArray(bArr2, getArray(AB, bArr16));
        }
        byte[] bArr17 = this.f58537ac;
        if (bArr17 != null) {
            bArr2 = catArray(bArr2, getArray((byte) -84, bArr17));
        }
        return getArray(this.mainTag, bArr2);
    }

    public String toString() {
        return "Length: " + this.fileLength + "\nLength FCI: " + this.fileLengthFCI + "\nDesc byte: " + this.descriptorByte + "\nData byte: " + this.dataCodingByte + "\nRecord size: " + this.maxRecordSize + "\nRecord count: " + this.maxRecordsCount + "\nFID: " + Hex.shortToHexString(this.fid) + "\nDF name: " + Hex.bytesToHexString(this.dfName) + "\npropInfo: " + Hex.bytesToHexString(this.propInfo) + "\nsecAttrProp: " + Hex.bytesToHexString(this.secAttrProp) + "\nsecAttrExp: " + Hex.bytesToHexString(this.secAttrExp) + "\nsecAttrComp: " + Hex.bytesToHexString(this.secAttrCompact) + "\nFCI ext: " + Hex.shortToHexString(this.fciExt) + "\nEF env temp: " + Hex.shortToHexString(this.envTempEF) + "\nShort EF: " + Hex.byteToHexString(this.shortEF) + "\nLCS byte: " + Hex.byteToHexString(this.lcsByte) + "\nChannel sec: " + Hex.byteToHexString(this.channelSecurity) + "\na0: " + Hex.bytesToHexString(this.f58532a0) + "\na1: " + Hex.bytesToHexString(this.f58533a1) + "\na2: " + Hex.bytesToHexString(this.f58534a2) + "\na5: " + Hex.bytesToHexString(this.f58535a5) + "\nab: " + Hex.bytesToHexString(this.f58536ab) + "\nac: " + Hex.bytesToHexString(this.f58537ac) + "\n";
    }

    private static void checkLen(int i11, int i12, int i13) throws CardServiceException {
        if (i11 < i12 || i11 > i13) {
            throw new CardServiceException("Malformed FCI.");
        }
    }
}
