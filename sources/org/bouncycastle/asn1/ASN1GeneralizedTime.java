package org.bouncycastle.asn1;

import com.xiaomi.mipush.sdk.Constants;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.SimpleTimeZone;
import java.util.TimeZone;
import org.bouncycastle.util.Arrays;
import org.bouncycastle.util.Strings;

public class ASN1GeneralizedTime extends ASN1Primitive {
    public static final ASN1UniversalType TYPE = new ASN1UniversalType(ASN1GeneralizedTime.class, 24) {
        public ASN1Primitive fromImplicitPrimitive(DEROctetString dEROctetString) {
            return ASN1GeneralizedTime.createPrimitive(dEROctetString.getOctets());
        }
    };
    public final byte[] contents;

    public ASN1GeneralizedTime(String str) {
        this.contents = Strings.toByteArray(str);
        try {
            getDate();
        } catch (ParseException e11) {
            throw new IllegalArgumentException("invalid date string: " + e11.getMessage());
        }
    }

    public ASN1GeneralizedTime(Date date) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMddHHmmss'Z'", DateUtil.EN_Locale);
        simpleDateFormat.setTimeZone(new SimpleTimeZone(0, "Z"));
        this.contents = Strings.toByteArray(simpleDateFormat.format(date));
    }

    public ASN1GeneralizedTime(Date date, Locale locale) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMddHHmmss'Z'", locale);
        simpleDateFormat.setTimeZone(new SimpleTimeZone(0, "Z"));
        this.contents = Strings.toByteArray(simpleDateFormat.format(date));
    }

    public ASN1GeneralizedTime(byte[] bArr) {
        if (bArr.length >= 4) {
            this.contents = bArr;
            if (!isDigit(0) || !isDigit(1) || !isDigit(2) || !isDigit(3)) {
                throw new IllegalArgumentException("illegal characters in GeneralizedTime string");
            }
            return;
        }
        throw new IllegalArgumentException("GeneralizedTime string too short");
    }

    private SimpleDateFormat calculateGMTDateFormat() {
        SimpleDateFormat simpleDateFormat = hasFractionalSeconds() ? new SimpleDateFormat("yyyyMMddHHmmss.SSSz") : hasSeconds() ? new SimpleDateFormat("yyyyMMddHHmmssz") : hasMinutes() ? new SimpleDateFormat("yyyyMMddHHmmz") : new SimpleDateFormat("yyyyMMddHHz");
        simpleDateFormat.setTimeZone(new SimpleTimeZone(0, "Z"));
        return simpleDateFormat;
    }

    private String calculateGMTOffset(String str) {
        String str2;
        TimeZone timeZone = TimeZone.getDefault();
        int rawOffset = timeZone.getRawOffset();
        if (rawOffset < 0) {
            rawOffset = -rawOffset;
            str2 = Constants.ACCEPT_TIME_SEPARATOR_SERVER;
        } else {
            str2 = "+";
        }
        int i11 = rawOffset / com.adjust.sdk.Constants.ONE_HOUR;
        int i12 = (rawOffset - (((i11 * 60) * 60) * 1000)) / 60000;
        try {
            if (timeZone.useDaylightTime()) {
                if (hasFractionalSeconds()) {
                    str = pruneFractionalSeconds(str);
                }
                SimpleDateFormat calculateGMTDateFormat = calculateGMTDateFormat();
                if (timeZone.inDaylightTime(calculateGMTDateFormat.parse(str + "GMT" + str2 + convert(i11) + ":" + convert(i12)))) {
                    i11 += str2.equals("+") ? 1 : -1;
                }
            }
        } catch (ParseException unused) {
        }
        return "GMT" + str2 + convert(i11) + ":" + convert(i12);
    }

    private String convert(int i11) {
        if (i11 >= 10) {
            return Integer.toString(i11);
        }
        return "0" + i11;
    }

    public static ASN1GeneralizedTime createPrimitive(byte[] bArr) {
        return new ASN1GeneralizedTime(bArr);
    }

    public static ASN1GeneralizedTime getInstance(Object obj) {
        if (obj == null || (obj instanceof ASN1GeneralizedTime)) {
            return (ASN1GeneralizedTime) obj;
        }
        if (obj instanceof ASN1Encodable) {
            ASN1Primitive aSN1Primitive = ((ASN1Encodable) obj).toASN1Primitive();
            if (aSN1Primitive instanceof ASN1GeneralizedTime) {
                return (ASN1GeneralizedTime) aSN1Primitive;
            }
        }
        if (obj instanceof byte[]) {
            try {
                return (ASN1GeneralizedTime) TYPE.fromByteArray((byte[]) obj);
            } catch (Exception e11) {
                throw new IllegalArgumentException("encoding error in getInstance: " + e11.toString());
            }
        } else {
            throw new IllegalArgumentException("illegal object in getInstance: " + obj.getClass().getName());
        }
    }

    public static ASN1GeneralizedTime getInstance(ASN1TaggedObject aSN1TaggedObject, boolean z11) {
        return (ASN1GeneralizedTime) TYPE.getContextInstance(aSN1TaggedObject, z11);
    }

    private boolean isDigit(int i11) {
        byte[] bArr = this.contents;
        return bArr.length > i11 && bArr[i11] >= 48 && bArr[i11] <= 57;
    }

    private String pruneFractionalSeconds(String str) {
        String str2;
        StringBuilder sb2;
        String substring = str.substring(14);
        int i11 = 1;
        while (i11 < substring.length() && '0' <= (r4 = substring.charAt(i11)) && r4 <= '9') {
            i11++;
        }
        int i12 = i11 - 1;
        if (i12 > 3) {
            str2 = substring.substring(0, 4) + substring.substring(i11);
            sb2 = new StringBuilder();
        } else if (i12 == 1) {
            str2 = substring.substring(0, i11) + "00" + substring.substring(i11);
            sb2 = new StringBuilder();
        } else if (i12 != 2) {
            return str;
        } else {
            str2 = substring.substring(0, i11) + "0" + substring.substring(i11);
            sb2 = new StringBuilder();
        }
        sb2.append(str.substring(0, 14));
        sb2.append(str2);
        return sb2.toString();
    }

    public boolean asn1Equals(ASN1Primitive aSN1Primitive) {
        if (!(aSN1Primitive instanceof ASN1GeneralizedTime)) {
            return false;
        }
        return Arrays.areEqual(this.contents, ((ASN1GeneralizedTime) aSN1Primitive).contents);
    }

    public void encode(ASN1OutputStream aSN1OutputStream, boolean z11) throws IOException {
        aSN1OutputStream.writeEncodingDL(z11, 24, this.contents);
    }

    public final boolean encodeConstructed() {
        return false;
    }

    public int encodedLength(boolean z11) {
        return ASN1OutputStream.getLengthOfEncodingDL(z11, this.contents.length);
    }

    public Date getDate() throws ParseException {
        SimpleDateFormat simpleDateFormat;
        String fromByteArray = Strings.fromByteArray(this.contents);
        if (fromByteArray.endsWith("Z")) {
            simpleDateFormat = hasFractionalSeconds() ? new SimpleDateFormat("yyyyMMddHHmmss.SSS'Z'") : hasSeconds() ? new SimpleDateFormat("yyyyMMddHHmmss'Z'") : hasMinutes() ? new SimpleDateFormat("yyyyMMddHHmm'Z'") : new SimpleDateFormat("yyyyMMddHH'Z'");
            simpleDateFormat.setTimeZone(new SimpleTimeZone(0, "Z"));
        } else if (fromByteArray.indexOf(45) > 0 || fromByteArray.indexOf(43) > 0) {
            fromByteArray = getTime();
            simpleDateFormat = calculateGMTDateFormat();
        } else {
            simpleDateFormat = hasFractionalSeconds() ? new SimpleDateFormat("yyyyMMddHHmmss.SSS") : hasSeconds() ? new SimpleDateFormat("yyyyMMddHHmmss") : hasMinutes() ? new SimpleDateFormat("yyyyMMddHHmm") : new SimpleDateFormat("yyyyMMddHH");
            simpleDateFormat.setTimeZone(new SimpleTimeZone(0, TimeZone.getDefault().getID()));
        }
        if (hasFractionalSeconds()) {
            fromByteArray = pruneFractionalSeconds(fromByteArray);
        }
        return DateUtil.epochAdjust(simpleDateFormat.parse(fromByteArray));
    }

    public String getTime() {
        String fromByteArray = Strings.fromByteArray(this.contents);
        if (fromByteArray.charAt(fromByteArray.length() - 1) == 'Z') {
            return fromByteArray.substring(0, fromByteArray.length() - 1) + "GMT+00:00";
        }
        int length = fromByteArray.length() - 6;
        char charAt = fromByteArray.charAt(length);
        if ((charAt == '-' || charAt == '+') && fromByteArray.indexOf("GMT") == length - 3) {
            return fromByteArray;
        }
        int length2 = fromByteArray.length() - 5;
        char charAt2 = fromByteArray.charAt(length2);
        if (charAt2 == '-' || charAt2 == '+') {
            StringBuilder sb2 = new StringBuilder();
            sb2.append(fromByteArray.substring(0, length2));
            sb2.append("GMT");
            int i11 = length2 + 3;
            sb2.append(fromByteArray.substring(length2, i11));
            sb2.append(":");
            sb2.append(fromByteArray.substring(i11));
            return sb2.toString();
        }
        int length3 = fromByteArray.length() - 3;
        char charAt3 = fromByteArray.charAt(length3);
        if (charAt3 == '-' || charAt3 == '+') {
            return fromByteArray.substring(0, length3) + "GMT" + fromByteArray.substring(length3) + ":00";
        }
        return fromByteArray + calculateGMTOffset(fromByteArray);
    }

    public String getTimeString() {
        return Strings.fromByteArray(this.contents);
    }

    public boolean hasFractionalSeconds() {
        int i11 = 0;
        while (true) {
            byte[] bArr = this.contents;
            if (i11 == bArr.length) {
                return false;
            }
            if (bArr[i11] == 46 && i11 == 14) {
                return true;
            }
            i11++;
        }
    }

    public boolean hasMinutes() {
        return isDigit(10) && isDigit(11);
    }

    public boolean hasSeconds() {
        return isDigit(12) && isDigit(13);
    }

    public int hashCode() {
        return Arrays.hashCode(this.contents);
    }

    public ASN1Primitive toDERObject() {
        return new DERGeneralizedTime(this.contents);
    }

    public ASN1Primitive toDLObject() {
        return new DERGeneralizedTime(this.contents);
    }
}
