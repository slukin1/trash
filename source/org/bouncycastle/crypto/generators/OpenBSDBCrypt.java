package org.bouncycastle.crypto.generators;

import java.io.ByteArrayOutputStream;
import java.util.HashSet;
import java.util.Set;
import net.sf.scuba.smartcards.ISO7816;
import net.sf.scuba.smartcards.ISOFileInfo;
import okio.Utf8;
import org.bouncycastle.crypto.DataLengthException;
import org.bouncycastle.util.Arrays;
import org.bouncycastle.util.Strings;
import org.jmrtd.lds.CVCAFile;

public class OpenBSDBCrypt {
    private static final Set<String> allowedVersions;
    private static final byte[] decodingTable = new byte[128];
    private static final String defaultVersion = "2y";
    private static final byte[] encodingTable = {46, 47, 65, CVCAFile.CAR_TAG, 67, ISO7816.INS_REHABILITATE_CHV, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, ISOFileInfo.FCP_BYTE, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, ISOFileInfo.FCI_BYTE, ISO7816.INS_MANAGE_CHANNEL, 113, 114, 115, 116, 117, 118, 119, Framer.EXIT_FRAME_PREFIX, 121, 122, ISO7816.INS_DECREASE, Framer.STDOUT_FRAME_PREFIX, 50, 51, ISO7816.INS_DECREASE_STAMPED, 53, 54, 55, 56, 57};

    static {
        HashSet hashSet = new HashSet();
        allowedVersions = hashSet;
        hashSet.add("2");
        hashSet.add("2x");
        hashSet.add("2a");
        hashSet.add(defaultVersion);
        hashSet.add("2b");
        int i11 = 0;
        int i12 = 0;
        while (true) {
            byte[] bArr = decodingTable;
            if (i12 >= bArr.length) {
                break;
            }
            bArr[i12] = -1;
            i12++;
        }
        while (true) {
            byte[] bArr2 = encodingTable;
            if (i11 < bArr2.length) {
                decodingTable[bArr2[i11]] = (byte) i11;
                i11++;
            } else {
                return;
            }
        }
    }

    private OpenBSDBCrypt() {
    }

    public static boolean checkPassword(String str, byte[] bArr) {
        if (bArr != null) {
            return doCheckPassword(str, Arrays.clone(bArr));
        }
        throw new IllegalArgumentException("Missing password.");
    }

    public static boolean checkPassword(String str, char[] cArr) {
        if (cArr != null) {
            return doCheckPassword(str, Strings.toUTF8ByteArray(cArr));
        }
        throw new IllegalArgumentException("Missing password.");
    }

    private static String createBcryptString(String str, byte[] bArr, byte[] bArr2, int i11) {
        String str2;
        if (allowedVersions.contains(str)) {
            StringBuilder sb2 = new StringBuilder(60);
            sb2.append(DecodedChar.FNC1);
            sb2.append(str);
            sb2.append(DecodedChar.FNC1);
            if (i11 < 10) {
                str2 = "0" + i11;
            } else {
                str2 = Integer.toString(i11);
            }
            sb2.append(str2);
            sb2.append(DecodedChar.FNC1);
            encodeData(sb2, bArr2);
            encodeData(sb2, BCrypt.generate(bArr, bArr2, i11));
            return sb2.toString();
        }
        throw new IllegalArgumentException("Version " + str + " is not accepted by this implementation.");
    }

    private static byte[] decodeSaltString(String str) {
        char[] charArray = str.toCharArray();
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(16);
        if (charArray.length == 22) {
            for (char c11 : charArray) {
                if (c11 > 'z' || c11 < '.' || (c11 > '9' && c11 < 'A')) {
                    throw new IllegalArgumentException("Salt string contains invalid character: " + c11);
                }
            }
            char[] cArr = new char[24];
            System.arraycopy(charArray, 0, cArr, 0, charArray.length);
            for (int i11 = 0; i11 < 24; i11 += 4) {
                byte[] bArr = decodingTable;
                byte b11 = bArr[cArr[i11]];
                byte b12 = bArr[cArr[i11 + 1]];
                byte b13 = bArr[cArr[i11 + 2]];
                byte b14 = bArr[cArr[i11 + 3]];
                byteArrayOutputStream.write((b11 << 2) | (b12 >> 4));
                byteArrayOutputStream.write((b12 << 4) | (b13 >> 2));
                byteArrayOutputStream.write(b14 | (b13 << 6));
            }
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            byte[] bArr2 = new byte[16];
            System.arraycopy(byteArray, 0, bArr2, 0, 16);
            return bArr2;
        }
        throw new DataLengthException("Invalid base64 salt length: " + charArray.length + " , 22 required.");
    }

    private static boolean doCheckPassword(String str, byte[] bArr) {
        String str2;
        if (str == null) {
            throw new IllegalArgumentException("Missing bcryptString.");
        } else if (str.charAt(1) == '2') {
            int length = str.length();
            if (length == 60 || (length == 59 && str.charAt(2) == '$')) {
                int i11 = 3;
                if (str.charAt(2) == '$') {
                    if (!(str.charAt(0) == '$' && str.charAt(5) == '$')) {
                        throw new IllegalArgumentException("Invalid Bcrypt String format.");
                    }
                } else if (!(str.charAt(0) == '$' && str.charAt(3) == '$' && str.charAt(6) == '$')) {
                    throw new IllegalArgumentException("Invalid Bcrypt String format.");
                }
                if (str.charAt(2) == '$') {
                    str2 = str.substring(1, 2);
                } else {
                    str2 = str.substring(1, 3);
                    i11 = 4;
                }
                if (allowedVersions.contains(str2)) {
                    String substring = str.substring(i11, i11 + 2);
                    try {
                        int parseInt = Integer.parseInt(substring);
                        if (parseInt >= 4 && parseInt <= 31) {
                            return Strings.constantTimeAreEqual(str, doGenerate(str2, bArr, decodeSaltString(str.substring(str.lastIndexOf(36) + 1, length - 31)), parseInt));
                        }
                        throw new IllegalArgumentException("Invalid cost factor: " + parseInt + ", 4 < cost < 31 expected.");
                    } catch (NumberFormatException unused) {
                        throw new IllegalArgumentException("Invalid cost factor: " + substring);
                    }
                } else {
                    throw new IllegalArgumentException("Bcrypt version '" + str2 + "' is not supported by this implementation");
                }
            } else {
                throw new DataLengthException("Bcrypt String length: " + length + ", 60 required.");
            }
        } else {
            throw new IllegalArgumentException("not a Bcrypt string");
        }
    }

    private static String doGenerate(String str, byte[] bArr, byte[] bArr2, int i11) {
        if (!allowedVersions.contains(str)) {
            throw new IllegalArgumentException("Version " + str + " is not accepted by this implementation.");
        } else if (bArr2 == null) {
            throw new IllegalArgumentException("Salt required.");
        } else if (bArr2.length != 16) {
            throw new DataLengthException("16 byte salt required: " + bArr2.length);
        } else if (i11 < 4 || i11 > 31) {
            throw new IllegalArgumentException("Invalid cost factor.");
        } else {
            int i12 = 72;
            if (bArr.length < 72) {
                i12 = bArr.length + 1;
            }
            byte[] bArr3 = new byte[i12];
            if (i12 > bArr.length) {
                i12 = bArr.length;
            }
            System.arraycopy(bArr, 0, bArr3, 0, i12);
            Arrays.fill(bArr, (byte) 0);
            String createBcryptString = createBcryptString(str, bArr3, bArr2, i11);
            Arrays.fill(bArr3, (byte) 0);
            return createBcryptString;
        }
    }

    private static void encodeData(StringBuilder sb2, byte[] bArr) {
        boolean z11;
        if (bArr.length == 24 || bArr.length == 16) {
            if (bArr.length == 16) {
                byte[] bArr2 = new byte[18];
                System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
                bArr = bArr2;
                z11 = true;
            } else {
                bArr[bArr.length - 1] = 0;
                z11 = false;
            }
            int length = bArr.length;
            for (int i11 = 0; i11 < length; i11 += 3) {
                byte b11 = bArr[i11] & 255;
                byte b12 = bArr[i11 + 1] & 255;
                byte b13 = bArr[i11 + 2] & 255;
                byte[] bArr3 = encodingTable;
                sb2.append((char) bArr3[(b11 >>> 2) & 63]);
                sb2.append((char) bArr3[((b11 << 4) | (b12 >>> 4)) & 63]);
                sb2.append((char) bArr3[((b12 << 2) | (b13 >>> 6)) & 63]);
                sb2.append((char) bArr3[b13 & Utf8.REPLACEMENT_BYTE]);
            }
            int length2 = sb2.length();
            sb2.setLength(z11 ? length2 - 2 : length2 - 1);
            return;
        }
        throw new DataLengthException("Invalid length: " + bArr.length + ", 24 for key or 16 for salt expected");
    }

    public static String generate(String str, byte[] bArr, byte[] bArr2, int i11) {
        if (bArr != null) {
            return doGenerate(str, Arrays.clone(bArr), bArr2, i11);
        }
        throw new IllegalArgumentException("Password required.");
    }

    public static String generate(String str, char[] cArr, byte[] bArr, int i11) {
        if (cArr != null) {
            return doGenerate(str, Strings.toUTF8ByteArray(cArr), bArr, i11);
        }
        throw new IllegalArgumentException("Password required.");
    }

    public static String generate(byte[] bArr, byte[] bArr2, int i11) {
        return generate(defaultVersion, bArr, bArr2, i11);
    }

    public static String generate(char[] cArr, byte[] bArr, int i11) {
        return generate(defaultVersion, cArr, bArr, i11);
    }
}
