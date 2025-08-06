package org.joda.time.tz;

import java.io.DataInput;
import java.io.DataInputStream;
import java.io.DataOutput;
import java.io.IOException;
import java.io.InputStream;
import java.text.DateFormatSymbols;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Locale;
import org.joda.time.Chronology;
import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;
import org.joda.time.Period;
import org.joda.time.PeriodType;
import org.joda.time.chrono.ISOChronology;

public class DateTimeZoneBuilder {

    /* renamed from: a  reason: collision with root package name */
    public final ArrayList<Object> f25391a = new ArrayList<>(10);

    public static final class DSTZone extends DateTimeZone {
        private static final long serialVersionUID = 6941492635554961361L;
        public final b iEndRecurrence;
        public final int iStandardOffset;
        public final b iStartRecurrence;

        public DSTZone(String str, int i11, b bVar, b bVar2) {
            super(str);
            this.iStandardOffset = i11;
            this.iStartRecurrence = bVar;
            this.iEndRecurrence = bVar2;
        }

        private b findMatchingRecurrence(long j11) {
            long j12;
            int i11 = this.iStandardOffset;
            b bVar = this.iStartRecurrence;
            b bVar2 = this.iEndRecurrence;
            try {
                j12 = bVar.c(j11, i11, bVar2.b());
            } catch (ArithmeticException | IllegalArgumentException unused) {
                j12 = j11;
            }
            try {
                j11 = bVar2.c(j11, i11, bVar.b());
            } catch (ArithmeticException | IllegalArgumentException unused2) {
            }
            return j12 > j11 ? bVar : bVar2;
        }

        public static DSTZone readFrom(DataInput dataInput, String str) throws IOException {
            return new DSTZone(str, (int) DateTimeZoneBuilder.c(dataInput), b.e(dataInput), b.e(dataInput));
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof DSTZone)) {
                return false;
            }
            DSTZone dSTZone = (DSTZone) obj;
            if (!getID().equals(dSTZone.getID()) || this.iStandardOffset != dSTZone.iStandardOffset || !this.iStartRecurrence.equals(dSTZone.iStartRecurrence) || !this.iEndRecurrence.equals(dSTZone.iEndRecurrence)) {
                return false;
            }
            return true;
        }

        public String getNameKey(long j11) {
            return findMatchingRecurrence(j11).a();
        }

        public int getOffset(long j11) {
            return this.iStandardOffset + findMatchingRecurrence(j11).b();
        }

        public int getStandardOffset(long j11) {
            return this.iStandardOffset;
        }

        public boolean isFixed() {
            return false;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:6:0x0016, code lost:
            if (r5 < 0) goto L_0x0018;
         */
        /* JADX WARNING: Removed duplicated region for block: B:19:0x002f  */
        /* JADX WARNING: Removed duplicated region for block: B:21:? A[RETURN, SYNTHETIC] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public long nextTransition(long r9) {
            /*
                r8 = this;
                int r0 = r8.iStandardOffset
                org.joda.time.tz.DateTimeZoneBuilder$b r1 = r8.iStartRecurrence
                org.joda.time.tz.DateTimeZoneBuilder$b r2 = r8.iEndRecurrence
                r3 = 0
                int r5 = r2.b()     // Catch:{ ArithmeticException | IllegalArgumentException -> 0x0018 }
                long r5 = r1.c(r9, r0, r5)     // Catch:{ ArithmeticException | IllegalArgumentException -> 0x0018 }
                int r7 = (r9 > r3 ? 1 : (r9 == r3 ? 0 : -1))
                if (r7 <= 0) goto L_0x0019
                int r7 = (r5 > r3 ? 1 : (r5 == r3 ? 0 : -1))
                if (r7 >= 0) goto L_0x0019
            L_0x0018:
                r5 = r9
            L_0x0019:
                int r1 = r1.b()     // Catch:{ ArithmeticException | IllegalArgumentException -> 0x002b }
                long r0 = r2.c(r9, r0, r1)     // Catch:{ ArithmeticException | IllegalArgumentException -> 0x002b }
                int r2 = (r9 > r3 ? 1 : (r9 == r3 ? 0 : -1))
                if (r2 <= 0) goto L_0x002a
                int r2 = (r0 > r3 ? 1 : (r0 == r3 ? 0 : -1))
                if (r2 >= 0) goto L_0x002a
                goto L_0x002b
            L_0x002a:
                r9 = r0
            L_0x002b:
                int r0 = (r5 > r9 ? 1 : (r5 == r9 ? 0 : -1))
                if (r0 <= 0) goto L_0x0030
                r5 = r9
            L_0x0030:
                return r5
            */
            throw new UnsupportedOperationException("Method not decompiled: org.joda.time.tz.DateTimeZoneBuilder.DSTZone.nextTransition(long):long");
        }

        /* JADX WARNING: Code restructure failed: missing block: B:6:0x0019, code lost:
            if (r7 > 0) goto L_0x001b;
         */
        /* JADX WARNING: Removed duplicated region for block: B:19:0x0033  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public long previousTransition(long r11) {
            /*
                r10 = this;
                r0 = 1
                long r11 = r11 + r0
                int r2 = r10.iStandardOffset
                org.joda.time.tz.DateTimeZoneBuilder$b r3 = r10.iStartRecurrence
                org.joda.time.tz.DateTimeZoneBuilder$b r4 = r10.iEndRecurrence
                r5 = 0
                int r7 = r4.b()     // Catch:{ ArithmeticException | IllegalArgumentException -> 0x001b }
                long r7 = r3.d(r11, r2, r7)     // Catch:{ ArithmeticException | IllegalArgumentException -> 0x001b }
                int r9 = (r11 > r5 ? 1 : (r11 == r5 ? 0 : -1))
                if (r9 >= 0) goto L_0x001c
                int r9 = (r7 > r5 ? 1 : (r7 == r5 ? 0 : -1))
                if (r9 <= 0) goto L_0x001c
            L_0x001b:
                r7 = r11
            L_0x001c:
                int r3 = r3.b()     // Catch:{ ArithmeticException | IllegalArgumentException -> 0x002e }
                long r2 = r4.d(r11, r2, r3)     // Catch:{ ArithmeticException | IllegalArgumentException -> 0x002e }
                int r4 = (r11 > r5 ? 1 : (r11 == r5 ? 0 : -1))
                if (r4 >= 0) goto L_0x002d
                int r4 = (r2 > r5 ? 1 : (r2 == r5 ? 0 : -1))
                if (r4 <= 0) goto L_0x002d
                goto L_0x002e
            L_0x002d:
                r11 = r2
            L_0x002e:
                int r2 = (r7 > r11 ? 1 : (r7 == r11 ? 0 : -1))
                if (r2 <= 0) goto L_0x0033
                goto L_0x0034
            L_0x0033:
                r7 = r11
            L_0x0034:
                long r7 = r7 - r0
                return r7
            */
            throw new UnsupportedOperationException("Method not decompiled: org.joda.time.tz.DateTimeZoneBuilder.DSTZone.previousTransition(long):long");
        }

        public void writeTo(DataOutput dataOutput) throws IOException {
            DateTimeZoneBuilder.d(dataOutput, (long) this.iStandardOffset);
            this.iStartRecurrence.h(dataOutput);
            this.iEndRecurrence.h(dataOutput);
        }
    }

    public static final class PrecalculatedZone extends DateTimeZone {
        private static final long serialVersionUID = 7811976468055766265L;
        private final String[] iNameKeys;
        private final int[] iStandardOffsets;
        private final DSTZone iTailZone;
        private final long[] iTransitions;
        private final int[] iWallOffsets;

        private PrecalculatedZone(String str, long[] jArr, int[] iArr, int[] iArr2, String[] strArr, DSTZone dSTZone) {
            super(str);
            this.iTransitions = jArr;
            this.iWallOffsets = iArr;
            this.iStandardOffsets = iArr2;
            this.iNameKeys = strArr;
            this.iTailZone = dSTZone;
        }

        public static PrecalculatedZone create(String str, boolean z11, ArrayList<c> arrayList, DSTZone dSTZone) {
            DSTZone dSTZone2;
            DSTZone dSTZone3;
            String str2 = str;
            DSTZone dSTZone4 = dSTZone;
            int size = arrayList.size();
            if (size != 0) {
                long[] jArr = new long[size];
                int[] iArr = new int[size];
                int[] iArr2 = new int[size];
                String[] strArr = new String[size];
                c cVar = null;
                int i11 = 0;
                int i12 = 0;
                while (i12 < size) {
                    c cVar2 = arrayList.get(i12);
                    if (cVar2.e(cVar)) {
                        jArr[i12] = cVar2.a();
                        iArr[i12] = cVar2.d();
                        iArr2[i12] = cVar2.c();
                        strArr[i12] = cVar2.b();
                        i12++;
                        cVar = cVar2;
                    } else {
                        throw new IllegalArgumentException(str2);
                    }
                }
                String[] strArr2 = new String[5];
                String[][] zoneStrings = new DateFormatSymbols(Locale.ENGLISH).getZoneStrings();
                for (String[] strArr3 : zoneStrings) {
                    if (strArr3 != null && strArr3.length == 5 && str2.equals(strArr3[0])) {
                        strArr2 = strArr3;
                    }
                }
                ISOChronology instanceUTC = ISOChronology.getInstanceUTC();
                while (i11 < size - 1) {
                    String str3 = strArr[i11];
                    int i13 = i11 + 1;
                    String str4 = strArr[i13];
                    long j11 = (long) iArr[i11];
                    long j12 = (long) iArr[i13];
                    String[] strArr4 = strArr;
                    String[] strArr5 = strArr2;
                    long j13 = (long) iArr2[i11];
                    int[] iArr3 = iArr;
                    int[] iArr4 = iArr2;
                    long j14 = (long) iArr2[i13];
                    int i14 = size;
                    String str5 = str4;
                    Period period = new Period(jArr[i11], jArr[i13], PeriodType.yearMonthDay(), (Chronology) instanceUTC);
                    int i15 = (j11 > j12 ? 1 : (j11 == j12 ? 0 : -1));
                    if (i15 != 0 && j13 == j14 && str3.equals(str5) && period.getYears() == 0 && period.getMonths() > 4 && period.getMonths() < 8 && str3.equals(strArr5[2]) && str3.equals(strArr5[4])) {
                        if (ZoneInfoCompiler.a()) {
                            System.out.println("Fixing duplicate name key - " + str5);
                            System.out.println("     - " + new DateTime(jArr[i11], (Chronology) instanceUTC) + " - " + new DateTime(jArr[i13], (Chronology) instanceUTC));
                        }
                        if (i15 > 0) {
                            strArr4[i11] = (str3 + "-Summer").intern();
                        } else if (i15 < 0) {
                            strArr4[i13] = (str5 + "-Summer").intern();
                            i11 = i13;
                        }
                    }
                    i11++;
                    String str6 = str;
                    strArr2 = strArr5;
                    dSTZone4 = dSTZone;
                    strArr = strArr4;
                    iArr = iArr3;
                    iArr2 = iArr4;
                    size = i14;
                }
                DSTZone dSTZone5 = dSTZone4;
                int[] iArr5 = iArr;
                int[] iArr6 = iArr2;
                String[] strArr6 = strArr;
                if (dSTZone5 == null || !dSTZone5.iStartRecurrence.a().equals(dSTZone5.iEndRecurrence.a())) {
                    dSTZone2 = dSTZone5;
                } else {
                    if (ZoneInfoCompiler.a()) {
                        System.out.println("Fixing duplicate recurrent name key - " + dSTZone5.iStartRecurrence.a());
                    }
                    if (dSTZone5.iStartRecurrence.b() > 0) {
                        dSTZone3 = new DSTZone(dSTZone.getID(), dSTZone5.iStandardOffset, dSTZone5.iStartRecurrence.g("-Summer"), dSTZone5.iEndRecurrence);
                    } else {
                        dSTZone3 = new DSTZone(dSTZone.getID(), dSTZone5.iStandardOffset, dSTZone5.iStartRecurrence, dSTZone5.iEndRecurrence.g("-Summer"));
                    }
                    dSTZone2 = dSTZone3;
                }
                return new PrecalculatedZone(z11 ? str : "", jArr, iArr5, iArr6, strArr6, dSTZone2);
            }
            throw new IllegalArgumentException();
        }

        public static PrecalculatedZone readFrom(DataInput dataInput, String str) throws IOException {
            int i11;
            int readUnsignedShort = dataInput.readUnsignedShort();
            String[] strArr = new String[readUnsignedShort];
            for (int i12 = 0; i12 < readUnsignedShort; i12++) {
                strArr[i12] = dataInput.readUTF();
            }
            int readInt = dataInput.readInt();
            long[] jArr = new long[readInt];
            int[] iArr = new int[readInt];
            int[] iArr2 = new int[readInt];
            String[] strArr2 = new String[readInt];
            for (int i13 = 0; i13 < readInt; i13++) {
                jArr[i13] = DateTimeZoneBuilder.c(dataInput);
                iArr[i13] = (int) DateTimeZoneBuilder.c(dataInput);
                iArr2[i13] = (int) DateTimeZoneBuilder.c(dataInput);
                if (readUnsignedShort < 256) {
                    try {
                        i11 = dataInput.readUnsignedByte();
                    } catch (ArrayIndexOutOfBoundsException unused) {
                        throw new IOException("Invalid encoding");
                    }
                } else {
                    i11 = dataInput.readUnsignedShort();
                }
                strArr2[i13] = strArr[i11];
            }
            return new PrecalculatedZone(str, jArr, iArr, iArr2, strArr2, dataInput.readBoolean() ? DSTZone.readFrom(dataInput, str) : null);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof PrecalculatedZone)) {
                return false;
            }
            PrecalculatedZone precalculatedZone = (PrecalculatedZone) obj;
            if (getID().equals(precalculatedZone.getID()) && Arrays.equals(this.iTransitions, precalculatedZone.iTransitions) && Arrays.equals(this.iNameKeys, precalculatedZone.iNameKeys) && Arrays.equals(this.iWallOffsets, precalculatedZone.iWallOffsets) && Arrays.equals(this.iStandardOffsets, precalculatedZone.iStandardOffsets)) {
                DSTZone dSTZone = this.iTailZone;
                DSTZone dSTZone2 = precalculatedZone.iTailZone;
                if (dSTZone == null) {
                    if (dSTZone2 == null) {
                        return true;
                    }
                } else if (dSTZone.equals(dSTZone2)) {
                    return true;
                }
            }
            return false;
        }

        public String getNameKey(long j11) {
            long[] jArr = this.iTransitions;
            int binarySearch = Arrays.binarySearch(jArr, j11);
            if (binarySearch >= 0) {
                return this.iNameKeys[binarySearch];
            }
            int i11 = ~binarySearch;
            if (i11 < jArr.length) {
                return i11 > 0 ? this.iNameKeys[i11 - 1] : UtcDates.UTC;
            }
            DSTZone dSTZone = this.iTailZone;
            if (dSTZone == null) {
                return this.iNameKeys[i11 - 1];
            }
            return dSTZone.getNameKey(j11);
        }

        public int getOffset(long j11) {
            long[] jArr = this.iTransitions;
            int binarySearch = Arrays.binarySearch(jArr, j11);
            if (binarySearch >= 0) {
                return this.iWallOffsets[binarySearch];
            }
            int i11 = ~binarySearch;
            if (i11 >= jArr.length) {
                DSTZone dSTZone = this.iTailZone;
                if (dSTZone == null) {
                    return this.iWallOffsets[i11 - 1];
                }
                return dSTZone.getOffset(j11);
            } else if (i11 > 0) {
                return this.iWallOffsets[i11 - 1];
            } else {
                return 0;
            }
        }

        public int getStandardOffset(long j11) {
            long[] jArr = this.iTransitions;
            int binarySearch = Arrays.binarySearch(jArr, j11);
            if (binarySearch >= 0) {
                return this.iStandardOffsets[binarySearch];
            }
            int i11 = ~binarySearch;
            if (i11 >= jArr.length) {
                DSTZone dSTZone = this.iTailZone;
                if (dSTZone == null) {
                    return this.iStandardOffsets[i11 - 1];
                }
                return dSTZone.getStandardOffset(j11);
            } else if (i11 > 0) {
                return this.iStandardOffsets[i11 - 1];
            } else {
                return 0;
            }
        }

        public boolean isCachable() {
            if (this.iTailZone != null) {
                return true;
            }
            long[] jArr = this.iTransitions;
            if (jArr.length <= 1) {
                return false;
            }
            double d11 = 0.0d;
            int i11 = 0;
            for (int i12 = 1; i12 < jArr.length; i12++) {
                long j11 = jArr[i12] - jArr[i12 - 1];
                if (j11 < 63158400000L) {
                    d11 += (double) j11;
                    i11++;
                }
            }
            if (i11 <= 0 || (d11 / ((double) i11)) / 8.64E7d < 25.0d) {
                return false;
            }
            return true;
        }

        public boolean isFixed() {
            return false;
        }

        public long nextTransition(long j11) {
            long[] jArr = this.iTransitions;
            int binarySearch = Arrays.binarySearch(jArr, j11);
            int i11 = binarySearch >= 0 ? binarySearch + 1 : ~binarySearch;
            if (i11 < jArr.length) {
                return jArr[i11];
            }
            DSTZone dSTZone = this.iTailZone;
            if (dSTZone == null) {
                return j11;
            }
            long j12 = jArr[jArr.length - 1];
            if (j11 < j12) {
                j11 = j12;
            }
            return dSTZone.nextTransition(j11);
        }

        public long previousTransition(long j11) {
            long[] jArr = this.iTransitions;
            int binarySearch = Arrays.binarySearch(jArr, j11);
            if (binarySearch >= 0) {
                return j11 > Long.MIN_VALUE ? j11 - 1 : j11;
            }
            int i11 = ~binarySearch;
            if (i11 < jArr.length) {
                if (i11 > 0) {
                    long j12 = jArr[i11 - 1];
                    if (j12 > Long.MIN_VALUE) {
                        return j12 - 1;
                    }
                }
                return j11;
            }
            DSTZone dSTZone = this.iTailZone;
            if (dSTZone != null) {
                long previousTransition = dSTZone.previousTransition(j11);
                if (previousTransition < j11) {
                    return previousTransition;
                }
            }
            long j13 = jArr[i11 - 1];
            return j13 > Long.MIN_VALUE ? j13 - 1 : j11;
        }

        public void writeTo(DataOutput dataOutput) throws IOException {
            int length = this.iTransitions.length;
            HashSet<String> hashSet = new HashSet<>();
            boolean z11 = false;
            for (int i11 = 0; i11 < length; i11++) {
                hashSet.add(this.iNameKeys[i11]);
            }
            int size = hashSet.size();
            if (size <= 65535) {
                String[] strArr = new String[size];
                int i12 = 0;
                for (String str : hashSet) {
                    strArr[i12] = str;
                    i12++;
                }
                dataOutput.writeShort(size);
                for (int i13 = 0; i13 < size; i13++) {
                    dataOutput.writeUTF(strArr[i13]);
                }
                dataOutput.writeInt(length);
                for (int i14 = 0; i14 < length; i14++) {
                    DateTimeZoneBuilder.d(dataOutput, this.iTransitions[i14]);
                    DateTimeZoneBuilder.d(dataOutput, (long) this.iWallOffsets[i14]);
                    DateTimeZoneBuilder.d(dataOutput, (long) this.iStandardOffsets[i14]);
                    String str2 = this.iNameKeys[i14];
                    int i15 = 0;
                    while (true) {
                        if (i15 >= size) {
                            break;
                        } else if (!strArr[i15].equals(str2)) {
                            i15++;
                        } else if (size < 256) {
                            dataOutput.writeByte(i15);
                        } else {
                            dataOutput.writeShort(i15);
                        }
                    }
                }
                if (this.iTailZone != null) {
                    z11 = true;
                }
                dataOutput.writeBoolean(z11);
                DSTZone dSTZone = this.iTailZone;
                if (dSTZone != null) {
                    dSTZone.writeTo(dataOutput);
                    return;
                }
                return;
            }
            throw new UnsupportedOperationException("String pool is too large");
        }
    }

    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        public final char f25392a;

        /* renamed from: b  reason: collision with root package name */
        public final int f25393b;

        /* renamed from: c  reason: collision with root package name */
        public final int f25394c;

        /* renamed from: d  reason: collision with root package name */
        public final int f25395d;

        /* renamed from: e  reason: collision with root package name */
        public final boolean f25396e;

        /* renamed from: f  reason: collision with root package name */
        public final int f25397f;

        public a(char c11, int i11, int i12, int i13, boolean z11, int i14) {
            if (c11 == 'u' || c11 == 'w' || c11 == 's') {
                this.f25392a = c11;
                this.f25393b = i11;
                this.f25394c = i12;
                this.f25395d = i13;
                this.f25396e = z11;
                this.f25397f = i14;
                return;
            }
            throw new IllegalArgumentException("Unknown mode: " + c11);
        }

        public static a c(DataInput dataInput) throws IOException {
            return new a((char) dataInput.readUnsignedByte(), dataInput.readUnsignedByte(), dataInput.readByte(), dataInput.readUnsignedByte(), dataInput.readBoolean(), (int) DateTimeZoneBuilder.c(dataInput));
        }

        public long a(long j11, int i11, int i12) {
            char c11 = this.f25392a;
            if (c11 == 'w') {
                i11 += i12;
            } else if (c11 != 's') {
                i11 = 0;
            }
            long j12 = (long) i11;
            long j13 = j11 + j12;
            ISOChronology instanceUTC = ISOChronology.getInstanceUTC();
            long e11 = e(instanceUTC, instanceUTC.millisOfDay().add(instanceUTC.millisOfDay().set(instanceUTC.monthOfYear().set(j13, this.f25393b), 0), this.f25397f));
            if (this.f25395d != 0) {
                e11 = g(instanceUTC, e11);
                if (e11 <= j13) {
                    e11 = g(instanceUTC, e(instanceUTC, instanceUTC.monthOfYear().set(instanceUTC.year().add(e11, 1), this.f25393b)));
                }
            } else if (e11 <= j13) {
                e11 = e(instanceUTC, instanceUTC.year().add(e11, 1));
            }
            return e11 - j12;
        }

        public long b(long j11, int i11, int i12) {
            char c11 = this.f25392a;
            if (c11 == 'w') {
                i11 += i12;
            } else if (c11 != 's') {
                i11 = 0;
            }
            long j12 = (long) i11;
            long j13 = j11 + j12;
            ISOChronology instanceUTC = ISOChronology.getInstanceUTC();
            long f11 = f(instanceUTC, instanceUTC.millisOfDay().add(instanceUTC.millisOfDay().set(instanceUTC.monthOfYear().set(j13, this.f25393b), 0), this.f25397f));
            if (this.f25395d != 0) {
                f11 = g(instanceUTC, f11);
                if (f11 >= j13) {
                    f11 = g(instanceUTC, f(instanceUTC, instanceUTC.monthOfYear().set(instanceUTC.year().add(f11, -1), this.f25393b)));
                }
            } else if (f11 >= j13) {
                f11 = f(instanceUTC, instanceUTC.year().add(f11, -1));
            }
            return f11 - j12;
        }

        public final long d(Chronology chronology, long j11) {
            if (this.f25394c >= 0) {
                return chronology.dayOfMonth().set(j11, this.f25394c);
            }
            return chronology.dayOfMonth().add(chronology.monthOfYear().add(chronology.dayOfMonth().set(j11, 1), 1), this.f25394c);
        }

        public final long e(Chronology chronology, long j11) {
            try {
                return d(chronology, j11);
            } catch (IllegalArgumentException e11) {
                if (this.f25393b == 2 && this.f25394c == 29) {
                    while (!chronology.year().isLeap(j11)) {
                        j11 = chronology.year().add(j11, 1);
                    }
                    return d(chronology, j11);
                }
                throw e11;
            }
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            if (this.f25392a == aVar.f25392a && this.f25393b == aVar.f25393b && this.f25394c == aVar.f25394c && this.f25395d == aVar.f25395d && this.f25396e == aVar.f25396e && this.f25397f == aVar.f25397f) {
                return true;
            }
            return false;
        }

        public final long f(Chronology chronology, long j11) {
            try {
                return d(chronology, j11);
            } catch (IllegalArgumentException e11) {
                if (this.f25393b == 2 && this.f25394c == 29) {
                    while (!chronology.year().isLeap(j11)) {
                        j11 = chronology.year().add(j11, -1);
                    }
                    return d(chronology, j11);
                }
                throw e11;
            }
        }

        public final long g(Chronology chronology, long j11) {
            int i11 = this.f25395d - chronology.dayOfWeek().get(j11);
            if (i11 == 0) {
                return j11;
            }
            if (this.f25396e) {
                if (i11 < 0) {
                    i11 += 7;
                }
            } else if (i11 > 0) {
                i11 -= 7;
            }
            return chronology.dayOfWeek().add(j11, i11);
        }

        public void h(DataOutput dataOutput) throws IOException {
            dataOutput.writeByte(this.f25392a);
            dataOutput.writeByte(this.f25393b);
            dataOutput.writeByte(this.f25394c);
            dataOutput.writeByte(this.f25395d);
            dataOutput.writeBoolean(this.f25396e);
            DateTimeZoneBuilder.d(dataOutput, (long) this.f25397f);
        }
    }

    public static final class b {

        /* renamed from: a  reason: collision with root package name */
        public final a f25398a;

        /* renamed from: b  reason: collision with root package name */
        public final String f25399b;

        /* renamed from: c  reason: collision with root package name */
        public final int f25400c;

        public b(a aVar, String str, int i11) {
            this.f25398a = aVar;
            this.f25399b = str;
            this.f25400c = i11;
        }

        public static b e(DataInput dataInput) throws IOException {
            return new b(a.c(dataInput), dataInput.readUTF(), (int) DateTimeZoneBuilder.c(dataInput));
        }

        public String a() {
            return this.f25399b;
        }

        public int b() {
            return this.f25400c;
        }

        public long c(long j11, int i11, int i12) {
            return this.f25398a.a(j11, i11, i12);
        }

        public long d(long j11, int i11, int i12) {
            return this.f25398a.b(j11, i11, i12);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof b)) {
                return false;
            }
            b bVar = (b) obj;
            if (this.f25400c != bVar.f25400c || !this.f25399b.equals(bVar.f25399b) || !this.f25398a.equals(bVar.f25398a)) {
                return false;
            }
            return true;
        }

        public b f(String str) {
            return new b(this.f25398a, str, this.f25400c);
        }

        public b g(String str) {
            return f((this.f25399b + str).intern());
        }

        public void h(DataOutput dataOutput) throws IOException {
            this.f25398a.h(dataOutput);
            dataOutput.writeUTF(this.f25399b);
            DateTimeZoneBuilder.d(dataOutput, (long) this.f25400c);
        }
    }

    public static final class c {

        /* renamed from: a  reason: collision with root package name */
        public final long f25401a;

        /* renamed from: b  reason: collision with root package name */
        public final String f25402b;

        /* renamed from: c  reason: collision with root package name */
        public final int f25403c;

        /* renamed from: d  reason: collision with root package name */
        public final int f25404d;

        public long a() {
            return this.f25401a;
        }

        public String b() {
            return this.f25402b;
        }

        public int c() {
            return this.f25404d;
        }

        public int d() {
            return this.f25403c;
        }

        public boolean e(c cVar) {
            if (cVar == null) {
                return true;
            }
            return this.f25401a > cVar.f25401a && (this.f25403c != cVar.f25403c || !this.f25402b.equals(cVar.f25402b));
        }
    }

    public static DateTimeZone a(DataInput dataInput, String str) throws IOException {
        int readUnsignedByte = dataInput.readUnsignedByte();
        if (readUnsignedByte == 67) {
            return CachedDateTimeZone.forZone(PrecalculatedZone.readFrom(dataInput, str));
        }
        if (readUnsignedByte == 70) {
            FixedDateTimeZone fixedDateTimeZone = new FixedDateTimeZone(str, dataInput.readUTF(), (int) c(dataInput), (int) c(dataInput));
            DateTimeZone dateTimeZone = DateTimeZone.UTC;
            return fixedDateTimeZone.equals(dateTimeZone) ? dateTimeZone : fixedDateTimeZone;
        } else if (readUnsignedByte == 80) {
            return PrecalculatedZone.readFrom(dataInput, str);
        } else {
            throw new IOException("Invalid encoding");
        }
    }

    public static DateTimeZone b(InputStream inputStream, String str) throws IOException {
        if (inputStream instanceof DataInput) {
            return a((DataInput) inputStream, str);
        }
        return a(new DataInputStream(inputStream), str);
    }

    public static long c(DataInput dataInput) throws IOException {
        long readUnsignedByte;
        long j11;
        int readUnsignedByte2 = dataInput.readUnsignedByte();
        int i11 = readUnsignedByte2 >> 6;
        if (i11 == 1) {
            readUnsignedByte = (long) (dataInput.readUnsignedByte() | ((readUnsignedByte2 << 26) >> 2) | (dataInput.readUnsignedByte() << 16) | (dataInput.readUnsignedByte() << 8));
            j11 = 60000;
        } else if (i11 == 2) {
            readUnsignedByte = ((((long) readUnsignedByte2) << 58) >> 26) | ((long) (dataInput.readUnsignedByte() << 24)) | ((long) (dataInput.readUnsignedByte() << 16)) | ((long) (dataInput.readUnsignedByte() << 8)) | ((long) dataInput.readUnsignedByte());
            j11 = 1000;
        } else if (i11 == 3) {
            return dataInput.readLong();
        } else {
            readUnsignedByte = (long) ((readUnsignedByte2 << 26) >> 26);
            j11 = com.hbg.lib.network.pro.core.util.Period.MIN30_MILLS;
        }
        return readUnsignedByte * j11;
    }

    public static void d(DataOutput dataOutput, long j11) throws IOException {
        if (j11 % com.hbg.lib.network.pro.core.util.Period.MIN30_MILLS == 0) {
            long j12 = j11 / com.hbg.lib.network.pro.core.util.Period.MIN30_MILLS;
            if (((j12 << 58) >> 58) == j12) {
                dataOutput.writeByte((int) (j12 & 63));
                return;
            }
        }
        if (j11 % 60000 == 0) {
            long j13 = j11 / 60000;
            if (((j13 << 34) >> 34) == j13) {
                dataOutput.writeInt(1073741824 | ((int) (j13 & 1073741823)));
                return;
            }
        }
        if (j11 % 1000 == 0) {
            long j14 = j11 / 1000;
            if (((j14 << 26) >> 26) == j14) {
                dataOutput.writeByte(((int) ((j14 >> 32) & 63)) | 128);
                dataOutput.writeInt((int) (-1 & j14));
                return;
            }
        }
        dataOutput.writeByte(j11 < 0 ? 255 : 192);
        dataOutput.writeLong(j11);
    }
}
