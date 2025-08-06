package net.sf.scuba.tlv;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import net.sf.scuba.util.Hex;

class ASN1Util implements ASN1Constants {
    private static final Logger LOGGER = Logger.getLogger("net.sf.scuba.tlv");
    private static final String SDF = "yyMMddhhmmss'Z'";

    private ASN1Util() {
    }

    public static Object interpretPrimitiveValue(int i11, byte[] bArr) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(SDF);
        if (TLVUtil.getTagClass(i11) != 0) {
            return bArr;
        }
        if (!(i11 == 12 || i11 == 30 || i11 == 19 || i11 == 20 || i11 == 22)) {
            if (i11 != 23) {
                switch (i11) {
                    case 26:
                    case 27:
                    case 28:
                        break;
                    default:
                        return bArr;
                }
            } else {
                try {
                    return simpleDateFormat.parse(new String(bArr));
                } catch (ParseException e11) {
                    LOGGER.log(Level.WARNING, "Parse exception parsing UTC time", e11);
                    return bArr;
                }
            }
        }
        return new String(bArr);
    }

    public static String tagToString(int i11) {
        if (TLVUtil.getTagClass(i11) != 0) {
            return "'0x" + Hex.intToHexString(i11) + "'";
        }
        if (TLVUtil.isPrimitive(i11)) {
            int i12 = i11 & 31;
            if (i12 == 9) {
                return "REAL";
            }
            if (i12 == 12) {
                return "UTF_STRING";
            }
            if (i12 == 30) {
                return "BMP_STRING";
            }
            if (i12 == 19) {
                return "PRINTABLE_STRING";
            }
            if (i12 == 20) {
                return "T61_STRING";
            }
            switch (i12) {
                case 1:
                    return "BOOLEAN";
                case 2:
                    return "INTEGER";
                case 3:
                    return "BIT_STRING";
                case 4:
                    return "OCTET_STRING";
                case 5:
                    return "NULL";
                case 6:
                    return "OBJECT_IDENTIFIER";
                default:
                    switch (i12) {
                        case 22:
                            return "IA5_STRING";
                        case 23:
                            return "UTC_TIME";
                        case 24:
                            return "GENERAL_TIME";
                        default:
                            switch (i12) {
                                case 26:
                                    return "VISIBLE_STRING";
                                case 27:
                                    return "GENERAL_STRING";
                                case 28:
                                    return "UNIVERSAL_STRING";
                            }
                    }
            }
        } else {
            int i13 = i11 & 31;
            if (i13 == 10) {
                return "ENUMERATED";
            }
            if (i13 == 16) {
                return "SEQUENCE";
            }
            if (i13 == 17) {
                return "SET";
            }
        }
        return "'0x" + Hex.intToHexString(i11) + "'";
    }
}
