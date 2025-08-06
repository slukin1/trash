package org.ejbca.cvc;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

public class DateField extends AbstractDataField {
    private static final int DATE_ARRAY_SIZE = 6;
    private static final DateFormat FORMAT_PRINTABLE;
    private static final TimeZone GMTTIMEZONE;
    private static final long serialVersionUID = 6092901788235446614L;
    private Date date;

    static {
        TimeZone timeZone = TimeZone.getTimeZone("GMT");
        GMTTIMEZONE = timeZone;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        FORMAT_PRINTABLE = simpleDateFormat;
        simpleDateFormat.setTimeZone(timeZone);
    }

    public DateField(CVCTagEnum cVCTagEnum) {
        super(cVCTagEnum);
    }

    public Date getDate() {
        return this.date;
    }

    public byte[] getEncoded() {
        Calendar instance = Calendar.getInstance(GMTTIMEZONE);
        instance.setTimeInMillis(this.date.getTime());
        int i11 = instance.get(1) - 2000;
        int i12 = instance.get(2) + 1;
        int i13 = instance.get(5);
        return new byte[]{(byte) (i11 / 10), (byte) (i11 % 10), (byte) (i12 / 10), (byte) (i12 % 10), (byte) (i13 / 10), (byte) (i13 % 10)};
    }

    public String valueAsText() {
        return FORMAT_PRINTABLE.format(this.date);
    }

    public DateField(CVCTagEnum cVCTagEnum, Date date2) {
        this(cVCTagEnum);
        Calendar instance = Calendar.getInstance(GMTTIMEZONE);
        instance.setTimeInMillis(date2.getTime());
        int i11 = instance.get(1);
        int i12 = instance.get(2);
        int i13 = instance.get(5);
        instance.clear();
        instance.set(i11, i12, i13);
        this.date = instance.getTime();
    }

    public DateField(CVCTagEnum cVCTagEnum, byte[] bArr) {
        this(cVCTagEnum);
        int i11 = 0;
        if (bArr == null || bArr.length != 6) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("data argument must have length 6, was ");
            sb2.append(bArr != null ? bArr.length : i11);
            throw new IllegalArgumentException(sb2.toString());
        }
        int i12 = (bArr[0] * 10) + 2000 + bArr[1];
        int i13 = ((bArr[2] * 10) + bArr[3]) - 1;
        int i14 = (bArr[4] * 10) + bArr[5];
        Calendar instance = Calendar.getInstance(GMTTIMEZONE);
        instance.clear();
        if (cVCTagEnum == CVCTagEnum.EFFECTIVE_DATE) {
            instance.set(i12, i13, i14, 0, 0, 0);
        } else {
            instance.set(i12, i13, i14, 23, 59, 59);
        }
        this.date = instance.getTime();
    }
}
