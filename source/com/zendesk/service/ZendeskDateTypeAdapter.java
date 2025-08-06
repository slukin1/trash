package com.zendesk.service;

import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import com.zendesk.logger.Logger;
import java.io.IOException;
import java.text.ParseException;
import java.text.ParsePosition;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.TimeZone;
import org.bouncycastle.pqc.math.linearalgebra.Matrix;

public class ZendeskDateTypeAdapter extends TypeAdapter<Date> {

    /* renamed from: a  reason: collision with root package name */
    public static final TimeZone f53460a = TimeZone.getTimeZone(UtcDates.UTC);

    public static int c(String str, int i11) {
        while (i11 < str.length()) {
            char charAt = str.charAt(i11);
            if (charAt < '0' || charAt > '9') {
                return i11;
            }
            i11++;
        }
        return str.length();
    }

    public final boolean a(String str, int i11, char c11) {
        return i11 < str.length() && str.charAt(i11) == c11;
    }

    public final String b(Date date) {
        GregorianCalendar gregorianCalendar = new GregorianCalendar(f53460a, Locale.US);
        gregorianCalendar.setTime(date);
        StringBuilder sb2 = new StringBuilder(21);
        d(sb2, gregorianCalendar.get(1), 4);
        sb2.append('-');
        d(sb2, gregorianCalendar.get(2) + 1, 2);
        sb2.append('-');
        d(sb2, gregorianCalendar.get(5), 2);
        sb2.append('T');
        d(sb2, gregorianCalendar.get(11), 2);
        sb2.append(':');
        d(sb2, gregorianCalendar.get(12), 2);
        sb2.append(':');
        d(sb2, gregorianCalendar.get(13), 2);
        sb2.append(Matrix.MATRIX_TYPE_ZERO);
        return sb2.toString();
    }

    public final void d(StringBuilder sb2, int i11, int i12) {
        String num = Integer.toString(i11);
        for (int length = i12 - num.length(); length > 0; length--) {
            sb2.append('0');
        }
        sb2.append(num);
    }

    /* JADX WARNING: Removed duplicated region for block: B:49:0x00d1 A[Catch:{ IndexOutOfBoundsException -> 0x012c }] */
    /* JADX WARNING: Removed duplicated region for block: B:55:0x0124 A[Catch:{ IndexOutOfBoundsException -> 0x012c }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.util.Date e(java.lang.String r19, java.text.ParsePosition r20) throws java.text.ParseException {
        /*
            r18 = this;
            r1 = r18
            r2 = r19
            r3 = r20
            java.lang.String r4 = "'"
            int r0 = r20.getIndex()     // Catch:{ IndexOutOfBoundsException -> 0x012c }
            int r5 = r0 + 4
            int r0 = r1.f(r2, r0, r5)     // Catch:{ IndexOutOfBoundsException -> 0x012c }
            r6 = 45
            boolean r7 = r1.a(r2, r5, r6)     // Catch:{ IndexOutOfBoundsException -> 0x012c }
            if (r7 == 0) goto L_0x001c
            int r5 = r5 + 1
        L_0x001c:
            int r7 = r5 + 2
            int r5 = r1.f(r2, r5, r7)     // Catch:{ IndexOutOfBoundsException -> 0x012c }
            boolean r8 = r1.a(r2, r7, r6)     // Catch:{ IndexOutOfBoundsException -> 0x012c }
            if (r8 == 0) goto L_0x002a
            int r7 = r7 + 1
        L_0x002a:
            int r8 = r7 + 2
            int r7 = r1.f(r2, r7, r8)     // Catch:{ IndexOutOfBoundsException -> 0x012c }
            r9 = 84
            boolean r9 = r1.a(r2, r8, r9)     // Catch:{ IndexOutOfBoundsException -> 0x012c }
            r10 = 1
            if (r9 != 0) goto L_0x004d
            int r11 = r19.length()     // Catch:{ IndexOutOfBoundsException -> 0x012c }
            if (r11 > r8) goto L_0x004d
            java.util.GregorianCalendar r6 = new java.util.GregorianCalendar     // Catch:{ IndexOutOfBoundsException -> 0x012c }
            int r5 = r5 - r10
            r6.<init>(r0, r5, r7)     // Catch:{ IndexOutOfBoundsException -> 0x012c }
            r3.setIndex(r8)     // Catch:{ IndexOutOfBoundsException -> 0x012c }
            java.util.Date r0 = r6.getTime()     // Catch:{ IndexOutOfBoundsException -> 0x012c }
            return r0
        L_0x004d:
            r11 = 90
            r13 = 2
            if (r9 == 0) goto L_0x00c7
            int r8 = r8 + 1
            int r9 = r8 + 2
            int r8 = r1.f(r2, r8, r9)     // Catch:{ IndexOutOfBoundsException -> 0x012c }
            r14 = 58
            boolean r15 = r1.a(r2, r9, r14)     // Catch:{ IndexOutOfBoundsException -> 0x012c }
            if (r15 == 0) goto L_0x0064
            int r9 = r9 + 1
        L_0x0064:
            int r15 = r9 + 2
            int r9 = r1.f(r2, r9, r15)     // Catch:{ IndexOutOfBoundsException -> 0x012c }
            boolean r14 = r1.a(r2, r15, r14)     // Catch:{ IndexOutOfBoundsException -> 0x012c }
            if (r14 == 0) goto L_0x0072
            int r15 = r15 + 1
        L_0x0072:
            int r14 = r19.length()     // Catch:{ IndexOutOfBoundsException -> 0x012c }
            if (r14 <= r15) goto L_0x00c4
            char r14 = r2.charAt(r15)     // Catch:{ IndexOutOfBoundsException -> 0x012c }
            if (r14 == r11) goto L_0x00c4
            r12 = 43
            if (r14 == r12) goto L_0x00c4
            if (r14 == r6) goto L_0x00c4
            int r6 = r15 + 2
            int r12 = r1.f(r2, r15, r6)     // Catch:{ IndexOutOfBoundsException -> 0x012c }
            r14 = 59
            if (r12 <= r14) goto L_0x0093
            r15 = 63
            if (r12 >= r15) goto L_0x0093
            r12 = r14
        L_0x0093:
            r14 = 46
            boolean r14 = r1.a(r2, r6, r14)     // Catch:{ IndexOutOfBoundsException -> 0x012c }
            if (r14 == 0) goto L_0x00bd
            int r6 = r6 + 1
            int r14 = r6 + 1
            int r14 = c(r2, r14)     // Catch:{ IndexOutOfBoundsException -> 0x012c }
            int r15 = r6 + 3
            int r15 = java.lang.Math.min(r14, r15)     // Catch:{ IndexOutOfBoundsException -> 0x012c }
            int r16 = r1.f(r2, r6, r15)     // Catch:{ IndexOutOfBoundsException -> 0x012c }
            int r15 = r15 - r6
            if (r15 == r10) goto L_0x00b6
            if (r15 == r13) goto L_0x00b3
            goto L_0x00b8
        L_0x00b3:
            int r16 = r16 * 10
            goto L_0x00b8
        L_0x00b6:
            int r16 = r16 * 100
        L_0x00b8:
            r6 = r8
            r8 = r14
            r14 = r16
            goto L_0x00cb
        L_0x00bd:
            r14 = 0
            r17 = r8
            r8 = r6
            r6 = r17
            goto L_0x00cb
        L_0x00c4:
            r6 = r8
            r8 = r15
            goto L_0x00c9
        L_0x00c7:
            r6 = 0
            r9 = 0
        L_0x00c9:
            r12 = 0
            r14 = 0
        L_0x00cb:
            int r15 = r19.length()     // Catch:{ IndexOutOfBoundsException -> 0x012c }
            if (r15 <= r8) goto L_0x0124
            char r15 = r2.charAt(r8)     // Catch:{ IndexOutOfBoundsException -> 0x012c }
            if (r15 != r11) goto L_0x010a
            java.util.TimeZone r11 = f53460a     // Catch:{ IndexOutOfBoundsException -> 0x012c }
            int r8 = r8 + r10
            java.util.GregorianCalendar r15 = new java.util.GregorianCalendar     // Catch:{ IndexOutOfBoundsException -> 0x012c }
            r15.<init>(r11)     // Catch:{ IndexOutOfBoundsException -> 0x012c }
            r11 = 0
            r15.setLenient(r11)     // Catch:{ IndexOutOfBoundsException -> 0x012c }
            r15.set(r10, r0)     // Catch:{ IndexOutOfBoundsException -> 0x012c }
            int r5 = r5 - r10
            r15.set(r13, r5)     // Catch:{ IndexOutOfBoundsException -> 0x012c }
            r0 = 5
            r15.set(r0, r7)     // Catch:{ IndexOutOfBoundsException -> 0x012c }
            r0 = 11
            r15.set(r0, r6)     // Catch:{ IndexOutOfBoundsException -> 0x012c }
            r0 = 12
            r15.set(r0, r9)     // Catch:{ IndexOutOfBoundsException -> 0x012c }
            r0 = 13
            r15.set(r0, r12)     // Catch:{ IndexOutOfBoundsException -> 0x012c }
            r0 = 14
            r15.set(r0, r14)     // Catch:{ IndexOutOfBoundsException -> 0x012c }
            r3.setIndex(r8)     // Catch:{ IndexOutOfBoundsException -> 0x012c }
            java.util.Date r0 = r15.getTime()     // Catch:{ IndexOutOfBoundsException -> 0x012c }
            return r0
        L_0x010a:
            java.lang.IndexOutOfBoundsException r0 = new java.lang.IndexOutOfBoundsException     // Catch:{ IndexOutOfBoundsException -> 0x012c }
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ IndexOutOfBoundsException -> 0x012c }
            r5.<init>()     // Catch:{ IndexOutOfBoundsException -> 0x012c }
            java.lang.String r6 = "Invalid time zone indicator '"
            r5.append(r6)     // Catch:{ IndexOutOfBoundsException -> 0x012c }
            r5.append(r15)     // Catch:{ IndexOutOfBoundsException -> 0x012c }
            r5.append(r4)     // Catch:{ IndexOutOfBoundsException -> 0x012c }
            java.lang.String r5 = r5.toString()     // Catch:{ IndexOutOfBoundsException -> 0x012c }
            r0.<init>(r5)     // Catch:{ IndexOutOfBoundsException -> 0x012c }
            throw r0     // Catch:{ IndexOutOfBoundsException -> 0x012c }
        L_0x0124:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException     // Catch:{ IndexOutOfBoundsException -> 0x012c }
            java.lang.String r5 = "No time zone indicator"
            r0.<init>(r5)     // Catch:{ IndexOutOfBoundsException -> 0x012c }
            throw r0     // Catch:{ IndexOutOfBoundsException -> 0x012c }
        L_0x012c:
            r0 = move-exception
            if (r2 != 0) goto L_0x0131
            r2 = 0
            goto L_0x0145
        L_0x0131:
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            r6 = 34
            r5.append(r6)
            r5.append(r2)
            r5.append(r4)
            java.lang.String r2 = r5.toString()
        L_0x0145:
            java.lang.String r4 = r0.getMessage()
            if (r4 == 0) goto L_0x0151
            boolean r5 = r4.isEmpty()
            if (r5 == 0) goto L_0x016f
        L_0x0151:
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.String r5 = "("
            r4.append(r5)
            java.lang.Class r5 = r0.getClass()
            java.lang.String r5 = r5.getName()
            r4.append(r5)
            java.lang.String r5 = ")"
            r4.append(r5)
            java.lang.String r4 = r4.toString()
        L_0x016f:
            java.text.ParseException r5 = new java.text.ParseException
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            java.lang.String r7 = "Failed to parse date ["
            r6.append(r7)
            r6.append(r2)
            java.lang.String r2 = "]: "
            r6.append(r2)
            r6.append(r4)
            java.lang.String r2 = r6.toString()
            int r3 = r20.getIndex()
            r5.<init>(r2, r3)
            r5.initCause(r0)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.zendesk.service.ZendeskDateTypeAdapter.e(java.lang.String, java.text.ParsePosition):java.util.Date");
    }

    public final int f(String str, int i11, int i12) throws NumberFormatException {
        int i13;
        int i14;
        if (i11 < 0 || i12 > str.length() || i11 > i12) {
            throw new NumberFormatException(str);
        }
        if (i11 < i12) {
            i14 = i11 + 1;
            int digit = Character.digit(str.charAt(i11), 10);
            if (digit >= 0) {
                i13 = -digit;
            } else {
                throw new NumberFormatException("Invalid number: " + str.substring(i11, i12));
            }
        } else {
            i13 = 0;
            i14 = i11;
        }
        while (i14 < i12) {
            int i15 = i14 + 1;
            int digit2 = Character.digit(str.charAt(i14), 10);
            if (digit2 >= 0) {
                i13 = (i13 * 10) - digit2;
                i14 = i15;
            } else {
                throw new NumberFormatException("Invalid number: " + str.substring(i11, i12));
            }
        }
        return -i13;
    }

    public Date read(JsonReader jsonReader) throws IOException {
        if (jsonReader.peek() == JsonToken.NULL) {
            jsonReader.nextNull();
            return null;
        }
        String nextString = jsonReader.nextString();
        try {
            return e(nextString, new ParsePosition(0));
        } catch (ParseException e11) {
            Logger.c("ZendeskDateTypeAdapter", String.format(Locale.US, "Failed to parse Date from: %s", new Object[]{nextString}), e11, new Object[0]);
            return null;
        }
    }

    public void write(JsonWriter jsonWriter, Date date) throws IOException {
        if (date == null) {
            jsonWriter.nullValue();
        } else {
            jsonWriter.value(b(date));
        }
    }
}
