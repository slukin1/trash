package org.bouncycastle.asn1.eac;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.SimpleTimeZone;
import net.sf.scuba.smartcards.ISO7816;
import org.bouncycastle.util.Arrays;

public class PackedDate {
    private byte[] time;

    public PackedDate(String str) {
        this.time = convert(str);
    }

    public PackedDate(Date date) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyMMdd'Z'");
        simpleDateFormat.setTimeZone(new SimpleTimeZone(0, "Z"));
        this.time = convert(simpleDateFormat.format(date));
    }

    public PackedDate(Date date, Locale locale) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyMMdd'Z'", locale);
        simpleDateFormat.setTimeZone(new SimpleTimeZone(0, "Z"));
        this.time = convert(simpleDateFormat.format(date));
    }

    public PackedDate(byte[] bArr) {
        this.time = bArr;
    }

    private byte[] convert(String str) {
        char[] charArray = str.toCharArray();
        byte[] bArr = new byte[6];
        for (int i11 = 0; i11 != 6; i11++) {
            bArr[i11] = (byte) (charArray[i11] - '0');
        }
        return bArr;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof PackedDate)) {
            return false;
        }
        return Arrays.areEqual(this.time, ((PackedDate) obj).time);
    }

    public Date getDate() throws ParseException {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd");
        return simpleDateFormat.parse("20" + toString());
    }

    public byte[] getEncoding() {
        return Arrays.clone(this.time);
    }

    public int hashCode() {
        return Arrays.hashCode(this.time);
    }

    public String toString() {
        int length = this.time.length;
        char[] cArr = new char[length];
        for (int i11 = 0; i11 != length; i11++) {
            cArr[i11] = (char) ((this.time[i11] & 255) + ISO7816.INS_DECREASE);
        }
        return new String(cArr);
    }
}
