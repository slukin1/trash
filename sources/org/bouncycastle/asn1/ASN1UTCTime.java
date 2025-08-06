package org.bouncycastle.asn1;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.SimpleTimeZone;
import org.bouncycastle.util.Arrays;
import org.bouncycastle.util.Strings;

public class ASN1UTCTime extends ASN1Primitive {
    public static final ASN1UniversalType TYPE = new ASN1UniversalType(ASN1UTCTime.class, 23) {
        public ASN1Primitive fromImplicitPrimitive(DEROctetString dEROctetString) {
            return ASN1UTCTime.createPrimitive(dEROctetString.getOctets());
        }
    };
    public final byte[] contents;

    public ASN1UTCTime(String str) {
        this.contents = Strings.toByteArray(str);
        try {
            getDate();
        } catch (ParseException e11) {
            throw new IllegalArgumentException("invalid date string: " + e11.getMessage());
        }
    }

    public ASN1UTCTime(Date date) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyMMddHHmmss'Z'", DateUtil.EN_Locale);
        simpleDateFormat.setTimeZone(new SimpleTimeZone(0, "Z"));
        this.contents = Strings.toByteArray(simpleDateFormat.format(date));
    }

    public ASN1UTCTime(Date date, Locale locale) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyMMddHHmmss'Z'", locale);
        simpleDateFormat.setTimeZone(new SimpleTimeZone(0, "Z"));
        this.contents = Strings.toByteArray(simpleDateFormat.format(date));
    }

    public ASN1UTCTime(byte[] bArr) {
        if (bArr.length >= 2) {
            this.contents = bArr;
            if (!isDigit(0) || !isDigit(1)) {
                throw new IllegalArgumentException("illegal characters in UTCTime string");
            }
            return;
        }
        throw new IllegalArgumentException("UTCTime string too short");
    }

    public static ASN1UTCTime createPrimitive(byte[] bArr) {
        return new ASN1UTCTime(bArr);
    }

    public static ASN1UTCTime getInstance(Object obj) {
        if (obj == null || (obj instanceof ASN1UTCTime)) {
            return (ASN1UTCTime) obj;
        }
        if (obj instanceof ASN1Encodable) {
            ASN1Primitive aSN1Primitive = ((ASN1Encodable) obj).toASN1Primitive();
            if (aSN1Primitive instanceof ASN1UTCTime) {
                return (ASN1UTCTime) aSN1Primitive;
            }
        }
        if (obj instanceof byte[]) {
            try {
                return (ASN1UTCTime) TYPE.fromByteArray((byte[]) obj);
            } catch (Exception e11) {
                throw new IllegalArgumentException("encoding error in getInstance: " + e11.toString());
            }
        } else {
            throw new IllegalArgumentException("illegal object in getInstance: " + obj.getClass().getName());
        }
    }

    public static ASN1UTCTime getInstance(ASN1TaggedObject aSN1TaggedObject, boolean z11) {
        return (ASN1UTCTime) TYPE.getContextInstance(aSN1TaggedObject, z11);
    }

    private boolean isDigit(int i11) {
        byte[] bArr = this.contents;
        return bArr.length > i11 && bArr[i11] >= 48 && bArr[i11] <= 57;
    }

    public boolean asn1Equals(ASN1Primitive aSN1Primitive) {
        if (!(aSN1Primitive instanceof ASN1UTCTime)) {
            return false;
        }
        return Arrays.areEqual(this.contents, ((ASN1UTCTime) aSN1Primitive).contents);
    }

    public void encode(ASN1OutputStream aSN1OutputStream, boolean z11) throws IOException {
        aSN1OutputStream.writeEncodingDL(z11, 23, this.contents);
    }

    public final boolean encodeConstructed() {
        return false;
    }

    public int encodedLength(boolean z11) {
        return ASN1OutputStream.getLengthOfEncodingDL(z11, this.contents.length);
    }

    public Date getAdjustedDate() throws ParseException {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMddHHmmssz");
        simpleDateFormat.setTimeZone(new SimpleTimeZone(0, "Z"));
        return DateUtil.epochAdjust(simpleDateFormat.parse(getAdjustedTime()));
    }

    public String getAdjustedTime() {
        StringBuilder sb2;
        String str;
        String time = getTime();
        if (time.charAt(0) < '5') {
            sb2 = new StringBuilder();
            str = "20";
        } else {
            sb2 = new StringBuilder();
            str = "19";
        }
        sb2.append(str);
        sb2.append(time);
        return sb2.toString();
    }

    public Date getDate() throws ParseException {
        return DateUtil.epochAdjust(new SimpleDateFormat("yyMMddHHmmssz").parse(getTime()));
    }

    public String getTime() {
        StringBuilder sb2;
        String substring;
        String fromByteArray = Strings.fromByteArray(this.contents);
        if (fromByteArray.indexOf(45) >= 0 || fromByteArray.indexOf(43) >= 0) {
            int indexOf = fromByteArray.indexOf(45);
            if (indexOf < 0) {
                indexOf = fromByteArray.indexOf(43);
            }
            if (indexOf == fromByteArray.length() - 3) {
                fromByteArray = fromByteArray + "00";
            }
            if (indexOf == 10) {
                sb2 = new StringBuilder();
                sb2.append(fromByteArray.substring(0, 10));
                sb2.append("00GMT");
                sb2.append(fromByteArray.substring(10, 13));
                sb2.append(":");
                substring = fromByteArray.substring(13, 15);
            } else {
                sb2 = new StringBuilder();
                sb2.append(fromByteArray.substring(0, 12));
                sb2.append("GMT");
                sb2.append(fromByteArray.substring(12, 15));
                sb2.append(":");
                substring = fromByteArray.substring(15, 17);
            }
        } else if (fromByteArray.length() == 11) {
            sb2 = new StringBuilder();
            sb2.append(fromByteArray.substring(0, 10));
            substring = "00GMT+00:00";
        } else {
            sb2 = new StringBuilder();
            sb2.append(fromByteArray.substring(0, 12));
            substring = "GMT+00:00";
        }
        sb2.append(substring);
        return sb2.toString();
    }

    public int hashCode() {
        return Arrays.hashCode(this.contents);
    }

    public String toString() {
        return Strings.fromByteArray(this.contents);
    }
}
