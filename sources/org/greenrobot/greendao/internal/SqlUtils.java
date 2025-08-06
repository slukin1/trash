package org.greenrobot.greendao.internal;

import org.greenrobot.greendao.DaoException;
import org.greenrobot.greendao.Property;

public class SqlUtils {
    private static final char[] HEX_ARRAY = "0123456789ABCDEF".toCharArray();

    public static StringBuilder appendColumn(StringBuilder sb2, String str) {
        sb2.append('\"');
        sb2.append(str);
        sb2.append('\"');
        return sb2;
    }

    public static StringBuilder appendColumns(StringBuilder sb2, String str, String[] strArr) {
        int length = strArr.length;
        for (int i11 = 0; i11 < length; i11++) {
            appendColumn(sb2, str, strArr[i11]);
            if (i11 < length - 1) {
                sb2.append(',');
            }
        }
        return sb2;
    }

    public static StringBuilder appendColumnsEqValue(StringBuilder sb2, String str, String[] strArr) {
        for (int i11 = 0; i11 < strArr.length; i11++) {
            appendColumn(sb2, str, strArr[i11]).append("=?");
            if (i11 < strArr.length - 1) {
                sb2.append(',');
            }
        }
        return sb2;
    }

    public static StringBuilder appendColumnsEqualPlaceholders(StringBuilder sb2, String[] strArr) {
        for (int i11 = 0; i11 < strArr.length; i11++) {
            appendColumn(sb2, strArr[i11]).append("=?");
            if (i11 < strArr.length - 1) {
                sb2.append(',');
            }
        }
        return sb2;
    }

    public static StringBuilder appendPlaceholders(StringBuilder sb2, int i11) {
        for (int i12 = 0; i12 < i11; i12++) {
            if (i12 < i11 - 1) {
                sb2.append("?,");
            } else {
                sb2.append('?');
            }
        }
        return sb2;
    }

    public static StringBuilder appendProperty(StringBuilder sb2, String str, Property property) {
        if (str != null) {
            sb2.append(str);
            sb2.append('.');
        }
        sb2.append('\"');
        sb2.append(property.columnName);
        sb2.append('\"');
        return sb2;
    }

    public static String createSqlCount(String str) {
        return "SELECT COUNT(*) FROM \"" + str + '\"';
    }

    public static String createSqlDelete(String str, String[] strArr) {
        String str2 = '\"' + str + '\"';
        StringBuilder sb2 = new StringBuilder("DELETE FROM ");
        sb2.append(str2);
        if (strArr != null && strArr.length > 0) {
            sb2.append(" WHERE ");
            appendColumnsEqValue(sb2, str2, strArr);
        }
        return sb2.toString();
    }

    public static String createSqlInsert(String str, String str2, String[] strArr) {
        StringBuilder sb2 = new StringBuilder(str);
        sb2.append('\"');
        sb2.append(str2);
        sb2.append('\"');
        sb2.append(" (");
        appendColumns(sb2, strArr);
        sb2.append(") VALUES (");
        appendPlaceholders(sb2, strArr.length);
        sb2.append(')');
        return sb2.toString();
    }

    public static String createSqlSelect(String str, String str2, String[] strArr, boolean z11) {
        if (str2 == null || str2.length() < 0) {
            throw new DaoException("Table alias required");
        }
        StringBuilder sb2 = new StringBuilder(z11 ? "SELECT DISTINCT " : "SELECT ");
        appendColumns(sb2, str2, strArr).append(" FROM ");
        sb2.append('\"');
        sb2.append(str);
        sb2.append('\"');
        sb2.append(' ');
        sb2.append(str2);
        sb2.append(' ');
        return sb2.toString();
    }

    public static String createSqlSelectCountStar(String str, String str2) {
        StringBuilder sb2 = new StringBuilder("SELECT COUNT(*) FROM ");
        sb2.append('\"');
        sb2.append(str);
        sb2.append('\"');
        sb2.append(' ');
        if (str2 != null) {
            sb2.append(str2);
            sb2.append(' ');
        }
        return sb2.toString();
    }

    public static String createSqlUpdate(String str, String[] strArr, String[] strArr2) {
        String str2 = '\"' + str + '\"';
        StringBuilder sb2 = new StringBuilder("UPDATE ");
        sb2.append(str2);
        sb2.append(" SET ");
        appendColumnsEqualPlaceholders(sb2, strArr);
        sb2.append(" WHERE ");
        appendColumnsEqValue(sb2, str2, strArr2);
        return sb2.toString();
    }

    public static String escapeBlobArgument(byte[] bArr) {
        return "X'" + toHex(bArr) + '\'';
    }

    public static String toHex(byte[] bArr) {
        char[] cArr = new char[(bArr.length * 2)];
        for (int i11 = 0; i11 < bArr.length; i11++) {
            byte b11 = bArr[i11] & 255;
            int i12 = i11 * 2;
            char[] cArr2 = HEX_ARRAY;
            cArr[i12] = cArr2[b11 >>> 4];
            cArr[i12 + 1] = cArr2[b11 & 15];
        }
        return new String(cArr);
    }

    public static StringBuilder appendColumn(StringBuilder sb2, String str, String str2) {
        sb2.append(str);
        sb2.append(".\"");
        sb2.append(str2);
        sb2.append('\"');
        return sb2;
    }

    public static StringBuilder appendColumns(StringBuilder sb2, String[] strArr) {
        int length = strArr.length;
        for (int i11 = 0; i11 < length; i11++) {
            sb2.append('\"');
            sb2.append(strArr[i11]);
            sb2.append('\"');
            if (i11 < length - 1) {
                sb2.append(',');
            }
        }
        return sb2;
    }
}
