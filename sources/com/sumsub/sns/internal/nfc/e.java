package com.sumsub.sns.internal.nfc;

import android.nfc.TagLostException;
import android.nfc.tech.IsoDep;
import com.xiaomi.mipush.sdk.Constants;
import d10.l;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Unit;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.r;
import kotlinx.coroutines.DelayKt;
import org.jmrtd.BACKeySpec;
import org.jmrtd.PassportService;

public final class e {

    /* renamed from: d  reason: collision with root package name */
    public static final b f35153d = new b((r) null);

    /* renamed from: e  reason: collision with root package name */
    public static final String f35154e = "NfcReader";

    /* renamed from: f  reason: collision with root package name */
    public static final int f35155f = 256;

    /* renamed from: g  reason: collision with root package name */
    public static final int f35156g = 223;

    /* renamed from: h  reason: collision with root package name */
    public static final Map<Short, String> f35157h;

    /* renamed from: i  reason: collision with root package name */
    public static final Map<String, Short> f35158i;

    /* renamed from: a  reason: collision with root package name */
    public final IsoDep f35159a;

    /* renamed from: b  reason: collision with root package name */
    public final byte[] f35160b;

    /* renamed from: c  reason: collision with root package name */
    public final b f35161c;

    public static final class a implements BACKeySpec {

        /* renamed from: a  reason: collision with root package name */
        public final byte[] f35162a;

        public a(byte[] bArr) {
            this.f35162a = Arrays.copyOf(bArr, 16);
        }

        public String getAlgorithm() {
            return "BAC";
        }

        public String getDateOfBirth() {
            return "";
        }

        public String getDateOfExpiry() {
            return "";
        }

        public String getDocumentNumber() {
            return "";
        }

        public byte[] getKey() {
            return this.f35162a;
        }
    }

    public static final class b {
        public /* synthetic */ b(r rVar) {
            this();
        }

        public final List<Short> a(String str) {
            ArrayList arrayList = new ArrayList();
            for (String str2 : StringsKt__StringsKt.L0(str, new String[]{Constants.ACCEPT_TIME_SEPARATOR_SP}, false, 0, 6, (Object) null)) {
                Short sh2 = (Short) e.f35158i.get(str2);
                if (sh2 != null) {
                    arrayList.add(Short.valueOf(sh2.shortValue()));
                }
            }
            return arrayList;
        }

        public b() {
        }
    }

    @kotlin.coroutines.jvm.internal.d(c = "com.sumsub.sns.internal.nfc.NfcReader", f = "NfcReader.kt", l = {44, 50, 52, 56, 60, 61, 69}, m = "read")
    public static final class c extends ContinuationImpl {

        /* renamed from: a  reason: collision with root package name */
        public Object f35163a;

        /* renamed from: b  reason: collision with root package name */
        public Object f35164b;

        /* renamed from: c  reason: collision with root package name */
        public Object f35165c;

        /* renamed from: d  reason: collision with root package name */
        public int f35166d;

        /* renamed from: e  reason: collision with root package name */
        public boolean f35167e;

        /* renamed from: f  reason: collision with root package name */
        public /* synthetic */ Object f35168f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ e f35169g;

        /* renamed from: h  reason: collision with root package name */
        public int f35170h;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public c(e eVar, kotlin.coroutines.c<? super c> cVar) {
            super(cVar);
            this.f35169g = eVar;
        }

        public final Object invokeSuspend(Object obj) {
            this.f35168f = obj;
            this.f35170h |= Integer.MIN_VALUE;
            return this.f35169g.a((l<? super Integer, Unit>) null, (kotlin.coroutines.c<? super NfcResult>) this);
        }
    }

    @kotlin.coroutines.jvm.internal.d(c = "com.sumsub.sns.internal.nfc.NfcReader", f = "NfcReader.kt", l = {209}, m = "readFile")
    public static final class d extends ContinuationImpl {

        /* renamed from: a  reason: collision with root package name */
        public short f35171a;

        /* renamed from: b  reason: collision with root package name */
        public Object f35172b;

        /* renamed from: c  reason: collision with root package name */
        public /* synthetic */ Object f35173c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ e f35174d;

        /* renamed from: e  reason: collision with root package name */
        public int f35175e;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public d(e eVar, kotlin.coroutines.c<? super d> cVar) {
            super(cVar);
            this.f35174d = eVar;
        }

        public final Object invokeSuspend(Object obj) {
            this.f35173c = obj;
            this.f35175e |= Integer.MIN_VALUE;
            return this.f35174d.a((PassportService) null, 0, (String) null, 0, 0, (kotlin.coroutines.c<? super byte[]>) this);
        }
    }

    /* renamed from: com.sumsub.sns.internal.nfc.e$e  reason: collision with other inner class name */
    public static final class C0419e extends Lambda implements d10.a<byte[]> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ PassportService f35176a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ short f35177b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public C0419e(PassportService passportService, short s11) {
            super(0);
            this.f35176a = passportService;
            this.f35177b = s11;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:13:0x0024, code lost:
            r3 = move-exception;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:15:?, code lost:
            kotlin.io.b.a(r2, r1);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:16:0x0028, code lost:
            throw r3;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:20:0x002b, code lost:
            r2 = move-exception;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:21:0x002c, code lost:
            kotlin.io.b.a(r0, r1);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:22:0x002f, code lost:
            throw r2;
         */
        /* renamed from: a */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final byte[] invoke() {
            /*
                r4 = this;
                org.jmrtd.PassportService r0 = r4.f35176a
                short r1 = r4.f35177b
                r2 = 223(0xdf, float:3.12E-43)
                net.sf.scuba.smartcards.CardFileInputStream r0 = r0.getInputStream(r1, r2)
                int r1 = r0.getLength()     // Catch:{ all -> 0x0029 }
                byte[] r1 = new byte[r1]     // Catch:{ all -> 0x0029 }
                java.io.DataInputStream r2 = new java.io.DataInputStream     // Catch:{ all -> 0x0029 }
                r2.<init>(r0)     // Catch:{ all -> 0x0029 }
                r2.readFully(r1)     // Catch:{ all -> 0x0022 }
                kotlin.Unit r3 = kotlin.Unit.f56620a     // Catch:{ all -> 0x0022 }
                r3 = 0
                kotlin.io.b.a(r2, r3)     // Catch:{ all -> 0x0029 }
                kotlin.io.b.a(r0, r3)
                return r1
            L_0x0022:
                r1 = move-exception
                throw r1     // Catch:{ all -> 0x0024 }
            L_0x0024:
                r3 = move-exception
                kotlin.io.b.a(r2, r1)     // Catch:{ all -> 0x0029 }
                throw r3     // Catch:{ all -> 0x0029 }
            L_0x0029:
                r1 = move-exception
                throw r1     // Catch:{ all -> 0x002b }
            L_0x002b:
                r2 = move-exception
                kotlin.io.b.a(r0, r1)
                throw r2
            */
            throw new UnsupportedOperationException("Method not decompiled: com.sumsub.sns.internal.nfc.e.C0419e.invoke():byte[]");
        }
    }

    @kotlin.coroutines.jvm.internal.d(c = "com.sumsub.sns.internal.nfc.NfcReader", f = "NfcReader.kt", l = {186, 198}, m = "readFiles")
    public static final class f extends ContinuationImpl {

        /* renamed from: a  reason: collision with root package name */
        public Object f35178a;

        /* renamed from: b  reason: collision with root package name */
        public Object f35179b;

        /* renamed from: c  reason: collision with root package name */
        public Object f35180c;

        /* renamed from: d  reason: collision with root package name */
        public Object f35181d;

        /* renamed from: e  reason: collision with root package name */
        public Object f35182e;

        /* renamed from: f  reason: collision with root package name */
        public Object f35183f;

        /* renamed from: g  reason: collision with root package name */
        public Object f35184g;

        /* renamed from: h  reason: collision with root package name */
        public int f35185h;

        /* renamed from: i  reason: collision with root package name */
        public /* synthetic */ Object f35186i;

        /* renamed from: j  reason: collision with root package name */
        public final /* synthetic */ e f35187j;

        /* renamed from: k  reason: collision with root package name */
        public int f35188k;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public f(e eVar, kotlin.coroutines.c<? super f> cVar) {
            super(cVar);
            this.f35187j = eVar;
        }

        public final Object invokeSuspend(Object obj) {
            this.f35186i = obj;
            this.f35188k |= Integer.MIN_VALUE;
            return this.f35187j.a((PassportService) null, 0, (l<? super Integer, Unit>) null, (List<Short>) null, (List<byte[]>) null, (kotlin.coroutines.c<? super Unit>) this);
        }
    }

    @kotlin.coroutines.jvm.internal.d(c = "com.sumsub.sns.internal.nfc.NfcReader", f = "NfcReader.kt", l = {153}, m = "tryBac")
    public static final class g extends ContinuationImpl {

        /* renamed from: a  reason: collision with root package name */
        public Object f35189a;

        /* renamed from: b  reason: collision with root package name */
        public Object f35190b;

        /* renamed from: c  reason: collision with root package name */
        public int f35191c;

        /* renamed from: d  reason: collision with root package name */
        public /* synthetic */ Object f35192d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ e f35193e;

        /* renamed from: f  reason: collision with root package name */
        public int f35194f;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public g(e eVar, kotlin.coroutines.c<? super g> cVar) {
            super(cVar);
            this.f35193e = eVar;
        }

        public final Object invokeSuspend(Object obj) {
            this.f35192d = obj;
            this.f35194f |= Integer.MIN_VALUE;
            return this.f35193e.a((PassportService) null, (kotlin.coroutines.c<? super Boolean>) this);
        }
    }

    @kotlin.coroutines.jvm.internal.d(c = "com.sumsub.sns.internal.nfc.NfcReader", f = "NfcReader.kt", l = {114}, m = "tryPace")
    public static final class h extends ContinuationImpl {

        /* renamed from: a  reason: collision with root package name */
        public Object f35195a;

        /* renamed from: b  reason: collision with root package name */
        public Object f35196b;

        /* renamed from: c  reason: collision with root package name */
        public int f35197c;

        /* renamed from: d  reason: collision with root package name */
        public /* synthetic */ Object f35198d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ e f35199e;

        /* renamed from: f  reason: collision with root package name */
        public int f35200f;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public h(e eVar, kotlin.coroutines.c<? super h> cVar) {
            super(cVar);
            this.f35199e = eVar;
        }

        public final Object invokeSuspend(Object obj) {
            this.f35198d = obj;
            this.f35200f |= Integer.MIN_VALUE;
            return this.f35199e.b((PassportService) null, this);
        }
    }

    static {
        Map<Short, String> l11 = MapsKt__MapsKt.l(kotlin.l.a(Short.valueOf(PassportService.EF_COM), "COM"), kotlin.l.a((short) 285, "SOD"), kotlin.l.a(Short.valueOf(PassportService.EF_DG1), "DG1"), kotlin.l.a(Short.valueOf(PassportService.EF_DG2), "DG2"), kotlin.l.a(Short.valueOf(PassportService.EF_DG3), "DG3"), kotlin.l.a(Short.valueOf(PassportService.EF_DG4), "DG4"), kotlin.l.a(Short.valueOf(PassportService.EF_DG5), "DG5"), kotlin.l.a(Short.valueOf(PassportService.EF_DG6), "DG6"), kotlin.l.a(Short.valueOf(PassportService.EF_DG7), "DG7"), kotlin.l.a(Short.valueOf(PassportService.EF_DG8), "DG8"), kotlin.l.a(Short.valueOf(PassportService.EF_DG9), "DG9"), kotlin.l.a(Short.valueOf(PassportService.EF_DG10), "DG10"), kotlin.l.a(Short.valueOf(PassportService.EF_DG11), "DG11"), kotlin.l.a(Short.valueOf(PassportService.EF_DG12), "DG12"), kotlin.l.a(Short.valueOf(PassportService.EF_DG13), "DG13"), kotlin.l.a(Short.valueOf(PassportService.EF_DG14), "DG14"), kotlin.l.a(Short.valueOf(PassportService.EF_DG15), "DG15"), kotlin.l.a(Short.valueOf(PassportService.EF_DG16), "DG16"));
        f35157h = l11;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Map.Entry next : l11.entrySet()) {
            linkedHashMap.put(next.getValue(), next.getKey());
        }
        f35158i = linkedHashMap;
    }

    public e(IsoDep isoDep, byte[] bArr, b bVar) {
        this.f35159a = isoDep;
        this.f35160b = bArr;
        this.f35161c = bVar;
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:0x0040  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x00a5 A[Catch:{ Exception -> 0x0035 }] */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x0122  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x0124  */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x0136  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0025  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object b(org.jmrtd.PassportService r13, kotlin.coroutines.c<? super java.lang.Boolean> r14) {
        /*
            r12 = this;
            boolean r0 = r14 instanceof com.sumsub.sns.internal.nfc.e.h
            if (r0 == 0) goto L_0x0013
            r0 = r14
            com.sumsub.sns.internal.nfc.e$h r0 = (com.sumsub.sns.internal.nfc.e.h) r0
            int r1 = r0.f35200f
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.f35200f = r1
            goto L_0x0018
        L_0x0013:
            com.sumsub.sns.internal.nfc.e$h r0 = new com.sumsub.sns.internal.nfc.e$h
            r0.<init>(r12, r14)
        L_0x0018:
            r7 = r0
            java.lang.Object r14 = r7.f35198d
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.d()
            int r1 = r7.f35200f
            r10 = 0
            r11 = 1
            if (r1 == 0) goto L_0x0040
            if (r1 != r11) goto L_0x0038
            int r13 = r7.f35197c
            java.lang.Object r0 = r7.f35196b
            org.jmrtd.PassportService r0 = (org.jmrtd.PassportService) r0
            java.lang.Object r1 = r7.f35195a
            com.sumsub.sns.internal.nfc.e r1 = (com.sumsub.sns.internal.nfc.e) r1
            kotlin.k.b(r14)     // Catch:{ Exception -> 0x0035 }
            goto L_0x006c
        L_0x0035:
            r14 = move-exception
            goto L_0x010b
        L_0x0038:
            java.lang.IllegalStateException r13 = new java.lang.IllegalStateException
            java.lang.String r14 = "call to 'resume' before 'invoke' with coroutine"
            r13.<init>(r14)
            throw r13
        L_0x0040:
            kotlin.k.b(r14)
            com.sumsub.sns.internal.nfc.c r1 = com.sumsub.sns.internal.nfc.c.f35142a
            r4 = 0
            r5 = 4
            r6 = 0
            java.lang.String r2 = "NfcReader"
            java.lang.String r3 = "Trying PACE"
            com.sumsub.sns.internal.nfc.c.a(r1, r2, r3, r4, r5, r6)
            r3 = 284(0x11c, float:3.98E-43)
            java.lang.String r4 = "EF_CARD_ACCESS"
            r5 = 0
            r6 = 0
            r8 = 12
            r9 = 0
            r7.f35195a = r12     // Catch:{ Exception -> 0x0108 }
            r7.f35196b = r13     // Catch:{ Exception -> 0x0108 }
            r7.f35197c = r10     // Catch:{ Exception -> 0x0108 }
            r7.f35200f = r11     // Catch:{ Exception -> 0x0108 }
            r1 = r12
            r2 = r13
            java.lang.Object r14 = a(r1, r2, r3, r4, r5, r6, r7, r8, r9)     // Catch:{ Exception -> 0x0108 }
            if (r14 != r0) goto L_0x0069
            return r0
        L_0x0069:
            r1 = r12
            r0 = r13
            r13 = r10
        L_0x006c:
            byte[] r14 = (byte[]) r14     // Catch:{ Exception -> 0x0035 }
            java.io.ByteArrayInputStream r2 = new java.io.ByteArrayInputStream     // Catch:{ Exception -> 0x0035 }
            r2.<init>(r14)     // Catch:{ Exception -> 0x0035 }
            org.jmrtd.lds.CardAccessFile r14 = new org.jmrtd.lds.CardAccessFile     // Catch:{ Exception -> 0x0035 }
            r14.<init>((java.io.InputStream) r2)     // Catch:{ Exception -> 0x0035 }
            org.jmrtd.PACEKeySpec r2 = new org.jmrtd.PACEKeySpec     // Catch:{ Exception -> 0x0035 }
            byte[] r1 = r1.f35160b     // Catch:{ Exception -> 0x0035 }
            r2.<init>((byte[]) r1, (byte) r11)     // Catch:{ Exception -> 0x0035 }
            com.sumsub.sns.internal.nfc.c r1 = com.sumsub.sns.internal.nfc.c.f35142a     // Catch:{ Exception -> 0x0035 }
            java.lang.String r4 = "NfcReader"
            java.lang.String r5 = "Got input stream for EF_CARD_ACCESS"
            r6 = 0
            r7 = 4
            r8 = 0
            r3 = r1
            com.sumsub.sns.internal.nfc.c.a(r3, r4, r5, r6, r7, r8)     // Catch:{ Exception -> 0x0035 }
            java.util.Collection r14 = r14.getSecurityInfos()     // Catch:{ Exception -> 0x0035 }
            java.lang.String r4 = "NfcReader"
            java.lang.String r5 = "Iteration securityInfos"
            r6 = 0
            r7 = 4
            r8 = 0
            r3 = r1
            com.sumsub.sns.internal.nfc.c.a(r3, r4, r5, r6, r7, r8)     // Catch:{ Exception -> 0x0035 }
            java.util.Iterator r14 = r14.iterator()     // Catch:{ Exception -> 0x0035 }
        L_0x009f:
            boolean r1 = r14.hasNext()     // Catch:{ Exception -> 0x0035 }
            if (r1 == 0) goto L_0x0114
            java.lang.Object r1 = r14.next()     // Catch:{ Exception -> 0x0035 }
            org.jmrtd.lds.SecurityInfo r1 = (org.jmrtd.lds.SecurityInfo) r1     // Catch:{ Exception -> 0x0035 }
            com.sumsub.sns.internal.nfc.c r9 = com.sumsub.sns.internal.nfc.c.f35142a     // Catch:{ Exception -> 0x0035 }
            java.lang.String r4 = "NfcReader"
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0035 }
            r3.<init>()     // Catch:{ Exception -> 0x0035 }
            java.lang.String r5 = "Reading "
            r3.append(r5)     // Catch:{ Exception -> 0x0035 }
            java.lang.String r5 = r1.getProtocolOIDString()     // Catch:{ Exception -> 0x0035 }
            r3.append(r5)     // Catch:{ Exception -> 0x0035 }
            java.lang.String r5 = ", "
            r3.append(r5)     // Catch:{ Exception -> 0x0035 }
            java.lang.String r5 = r1.getObjectIdentifier()     // Catch:{ Exception -> 0x0035 }
            r3.append(r5)     // Catch:{ Exception -> 0x0035 }
            java.lang.String r5 = r3.toString()     // Catch:{ Exception -> 0x0035 }
            r6 = 0
            r7 = 4
            r8 = 0
            r3 = r9
            com.sumsub.sns.internal.nfc.c.a(r3, r4, r5, r6, r7, r8)     // Catch:{ Exception -> 0x0035 }
            boolean r3 = r1 instanceof org.jmrtd.lds.PACEInfo     // Catch:{ Exception -> 0x0035 }
            if (r3 == 0) goto L_0x009f
            java.lang.String r4 = "NfcReader"
            java.lang.String r5 = "Found PACEInfo, trying it"
            r6 = 0
            r7 = 4
            r8 = 0
            r3 = r9
            com.sumsub.sns.internal.nfc.c.a(r3, r4, r5, r6, r7, r8)     // Catch:{ Exception -> 0x0035 }
            r3 = r1
            org.jmrtd.lds.PACEInfo r3 = (org.jmrtd.lds.PACEInfo) r3     // Catch:{ Exception -> 0x0035 }
            java.lang.String r3 = r3.getObjectIdentifier()     // Catch:{ Exception -> 0x0035 }
            org.jmrtd.lds.PACEInfo r1 = (org.jmrtd.lds.PACEInfo) r1     // Catch:{ Exception -> 0x0035 }
            java.math.BigInteger r1 = r1.getParameterId()     // Catch:{ Exception -> 0x0035 }
            java.security.spec.AlgorithmParameterSpec r1 = org.jmrtd.lds.PACEInfo.toParameterSpec((java.math.BigInteger) r1)     // Catch:{ Exception -> 0x0035 }
            r4 = 0
            r0.doPACE(r2, r3, r1, r4)     // Catch:{ Exception -> 0x0035 }
            java.lang.String r4 = "NfcReader"
            java.lang.String r5 = "PACE succeeded"
            r6 = 0
            r7 = 4
            r8 = 0
            r3 = r9
            com.sumsub.sns.internal.nfc.c.a(r3, r4, r5, r6, r7, r8)     // Catch:{ Exception -> 0x0035 }
            r13 = r11
            goto L_0x009f
        L_0x0108:
            r13 = move-exception
            r14 = r13
            r13 = r10
        L_0x010b:
            com.sumsub.sns.internal.nfc.c r0 = com.sumsub.sns.internal.nfc.c.f35142a
            java.lang.String r1 = "NfcReader"
            java.lang.String r2 = "Failed to do PACE"
            r0.a(r1, r2, r14)
        L_0x0114:
            com.sumsub.sns.internal.nfc.c r0 = com.sumsub.sns.internal.nfc.c.f35142a
            java.lang.StringBuilder r14 = new java.lang.StringBuilder
            r14.<init>()
            java.lang.String r1 = "paceSucceeded = "
            r14.append(r1)
            if (r13 == 0) goto L_0x0124
            r1 = r11
            goto L_0x0125
        L_0x0124:
            r1 = r10
        L_0x0125:
            r14.append(r1)
            java.lang.String r2 = r14.toString()
            r3 = 0
            r4 = 4
            r5 = 0
            java.lang.String r1 = "NfcReader"
            com.sumsub.sns.internal.nfc.c.a(r0, r1, r2, r3, r4, r5)
            if (r13 == 0) goto L_0x0137
            r10 = r11
        L_0x0137:
            java.lang.Boolean r13 = kotlin.coroutines.jvm.internal.a.a(r10)
            return r13
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sumsub.sns.internal.nfc.e.b(org.jmrtd.PassportService, kotlin.coroutines.c):java.lang.Object");
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v5, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v16, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v17, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v13, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v14, resolved type: com.sumsub.sns.internal.nfc.e} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v18, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v20, resolved type: com.sumsub.sns.internal.nfc.e} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v40, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v41, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v42, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v43, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v44, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v45, resolved type: boolean} */
    /* JADX WARNING: Code restructure failed: missing block: B:100:0x0283, code lost:
        r2.w(f35154e, r3, r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:101:0x028d, code lost:
        return new com.sumsub.sns.internal.nfc.NfcResult.Failed(com.sumsub.sns.internal.nfc.NfcResult.Failed.Reason.READ_FAILED);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:103:0x0293, code lost:
        throw new java.lang.RuntimeException(r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:104:?, code lost:
        return new com.sumsub.sns.internal.nfc.NfcResult.a(r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:105:?, code lost:
        return new com.sumsub.sns.internal.nfc.NfcResult.Failed(com.sumsub.sns.internal.nfc.NfcResult.Failed.Reason.READ_FAILED);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0043, code lost:
        r0 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:44:0x011e, code lost:
        if (r6.f35161c.d() == false) goto L_0x0142;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:45:0x0120, code lost:
        r9.f35163a = r6;
        r9.f35164b = r0;
        r9.f35165c = r3;
        r9.f35170h = 2;
        r4 = r6.b(r3, r9);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:46:0x012d, code lost:
        if (r4 != r2) goto L_0x0130;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:47:0x012f, code lost:
        return r2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:48:0x0130, code lost:
        r20 = r4;
        r4 = r0;
        r0 = r20;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:49:0x0135, code lost:
        r20 = r3;
        r3 = ((java.lang.Boolean) r0).booleanValue();
        r0 = r4;
        r4 = r20;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:50:0x0142, code lost:
        r4 = r3;
        r3 = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:51:0x0144, code lost:
        r9.f35163a = r6;
        r9.f35164b = r0;
        r9.f35165c = r4;
        r9.f35166d = r3;
        r9.f35170h = 3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:52:0x0153, code lost:
        if (r6.a((kotlin.coroutines.c<? super kotlin.Unit>) r9) != r2) goto L_0x0156;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:53:0x0155, code lost:
        return r2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:54:0x0156, code lost:
        r5 = r0;
        r3 = r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:55:0x0157, code lost:
        if (r3 == false) goto L_0x015b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:56:0x0159, code lost:
        r0 = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:57:0x015b, code lost:
        r0 = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:58:0x015c, code lost:
        r4.sendSelectApplet(r0);
        r9.f35163a = r6;
        r9.f35164b = r5;
        r9.f35165c = r4;
        r9.f35166d = r3;
        r9.f35170h = 4;
        r3 = r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:59:0x016e, code lost:
        if (r6.a((kotlin.coroutines.c<? super kotlin.Unit>) r9) != r2) goto L_0x0171;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:60:0x0170, code lost:
        return r2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:61:0x0171, code lost:
        if (r3 != false) goto L_0x01a0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:62:0x0173, code lost:
        r9.f35163a = r6;
        r9.f35164b = r5;
        r9.f35165c = r4;
        r9.f35170h = 5;
        r0 = r6.a(r4, (kotlin.coroutines.c<? super java.lang.Boolean>) r9);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:63:0x0180, code lost:
        if (r0 != r2) goto L_0x0183;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:64:0x0182, code lost:
        return r2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:65:0x0183, code lost:
        r3 = ((java.lang.Boolean) r0).booleanValue();
        r9.f35163a = r6;
        r9.f35164b = r5;
        r9.f35165c = r4;
        r9.f35167e = r3;
        r9.f35170h = 6;
        r3 = r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:66:0x0198, code lost:
        if (r6.a((kotlin.coroutines.c<? super kotlin.Unit>) r9) != r2) goto L_0x01a0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:67:0x019a, code lost:
        return r2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:68:0x019b, code lost:
        r4 = r6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:69:0x019e, code lost:
        r0 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:70:0x01a0, code lost:
        r13 = r6;
        r6 = r5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:71:0x01a2, code lost:
        if (r3 == false) goto L_0x0215;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:73:?, code lost:
        com.sumsub.sns.internal.nfc.c.a(com.sumsub.sns.internal.nfc.c.f35142a, f35154e, "Reading files", (java.lang.Throwable) null, 4, (java.lang.Object) null);
        r0 = new java.util.ArrayList();
        r14 = r13.f35161c.c().size();
        r7 = r13.f35161c.c();
        r9.f35163a = r13;
        r9.f35164b = r0;
        r9.f35165c = null;
        r9.f35166d = r14;
        r9.f35170h = 7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:74:0x01db, code lost:
        if (r13.a(r4, r14, r6, r7, (java.util.List<byte[]>) r0, (kotlin.coroutines.c<? super kotlin.Unit>) r9) != r2) goto L_0x01de;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:75:0x01dd, code lost:
        return r2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:76:0x01de, code lost:
        r3 = r0;
        r4 = r13;
        r2 = r14;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:79:0x01e5, code lost:
        if (r3.isEmpty() == false) goto L_0x0200;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:80:0x01e7, code lost:
        if (r2 <= 0) goto L_0x0200;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:81:0x01e9, code lost:
        com.sumsub.sns.internal.nfc.c.a(com.sumsub.sns.internal.nfc.c.f35142a, f35154e, "No files was read", (java.lang.Throwable) null, 4, (java.lang.Object) null);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:82:0x0200, code lost:
        com.sumsub.sns.internal.nfc.c.a(com.sumsub.sns.internal.nfc.c.f35142a, f35154e, "NFC read success!", (java.lang.Throwable) null, 4, (java.lang.Object) null);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:84:?, code lost:
        com.sumsub.sns.internal.nfc.c.a(com.sumsub.sns.internal.nfc.c.f35142a, f35154e, "Auth failed", (java.lang.Throwable) null, 4, (java.lang.Object) null);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:85:0x0228, code lost:
        return new com.sumsub.sns.internal.nfc.NfcResult.Failed(com.sumsub.sns.internal.nfc.NfcResult.Failed.Reason.AUTH_FAILED);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:86:0x0229, code lost:
        r0 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:87:0x022a, code lost:
        r4 = r13;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:94:0x025f, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:96:0x0266, code lost:
        if (com.sumsub.sns.internal.core.common.e0.f32018a.isDebug() == false) goto L_0x0268;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:97:0x0268, code lost:
        r3 = "Class not found";
        com.sumsub.sns.internal.nfc.c.f35142a.a(f35154e, r3, r0);
        r2 = com.sumsub.sns.internal.log.a.f34862a.a(com.sumsub.sns.internal.log.LoggerType.KIBANA);
        r4 = r0.getMessage();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:98:0x027f, code lost:
        if (r4 != null) goto L_0x0282;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:99:0x0282, code lost:
        r3 = r4;
     */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [B:11:0x003e, B:42:0x0118] */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [B:15:0x0054, B:42:0x0118] */
    /* JADX WARNING: Failed to insert additional move for type inference */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:10:0x0034  */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x0046  */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x0059  */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x006d  */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0080  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x0093  */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x00a5  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x00bb  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x002c  */
    /* JADX WARNING: Removed duplicated region for block: B:92:0x023b  */
    /* JADX WARNING: Removed duplicated region for block: B:93:0x024d  */
    /* JADX WARNING: Removed duplicated region for block: B:94:0x025f A[ExcHandler: NoClassDefFoundError (r0v2 'e' java.lang.NoClassDefFoundError A[CUSTOM_DECLARE]), Splitter:B:42:0x0118] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object a(d10.l<? super java.lang.Integer, kotlin.Unit> r22, kotlin.coroutines.c<? super com.sumsub.sns.internal.nfc.NfcResult> r23) {
        /*
            r21 = this;
            r1 = r21
            r0 = r23
            boolean r2 = r0 instanceof com.sumsub.sns.internal.nfc.e.c
            if (r2 == 0) goto L_0x0017
            r2 = r0
            com.sumsub.sns.internal.nfc.e$c r2 = (com.sumsub.sns.internal.nfc.e.c) r2
            int r3 = r2.f35170h
            r4 = -2147483648(0xffffffff80000000, float:-0.0)
            r5 = r3 & r4
            if (r5 == 0) goto L_0x0017
            int r3 = r3 - r4
            r2.f35170h = r3
            goto L_0x001c
        L_0x0017:
            com.sumsub.sns.internal.nfc.e$c r2 = new com.sumsub.sns.internal.nfc.e$c
            r2.<init>(r1, r0)
        L_0x001c:
            r9 = r2
            java.lang.Object r0 = r9.f35168f
            java.lang.Object r2 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.d()
            int r3 = r9.f35170h
            r10 = 1
            java.lang.String r11 = "NfcReader"
            r12 = 0
            switch(r3) {
                case 0: goto L_0x00bb;
                case 1: goto L_0x00a5;
                case 2: goto L_0x0093;
                case 3: goto L_0x0080;
                case 4: goto L_0x006d;
                case 5: goto L_0x0059;
                case 6: goto L_0x0046;
                case 7: goto L_0x0034;
                default: goto L_0x002c;
            }
        L_0x002c:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r2 = "call to 'resume' before 'invoke' with coroutine"
            r0.<init>(r2)
            throw r0
        L_0x0034:
            int r2 = r9.f35166d
            java.lang.Object r3 = r9.f35164b
            java.util.List r3 = (java.util.List) r3
            java.lang.Object r4 = r9.f35163a
            com.sumsub.sns.internal.nfc.e r4 = (com.sumsub.sns.internal.nfc.e) r4
            kotlin.k.b(r0)     // Catch:{ NoClassDefFoundError -> 0x025f, all -> 0x0043 }
            goto L_0x01e1
        L_0x0043:
            r0 = move-exception
            goto L_0x022e
        L_0x0046:
            boolean r3 = r9.f35167e
            java.lang.Object r4 = r9.f35165c
            org.jmrtd.PassportService r4 = (org.jmrtd.PassportService) r4
            java.lang.Object r5 = r9.f35164b
            d10.l r5 = (d10.l) r5
            java.lang.Object r6 = r9.f35163a
            com.sumsub.sns.internal.nfc.e r6 = (com.sumsub.sns.internal.nfc.e) r6
            kotlin.k.b(r0)     // Catch:{ NoClassDefFoundError -> 0x025f, all -> 0x019e }
            goto L_0x01a0
        L_0x0059:
            java.lang.Object r3 = r9.f35165c
            org.jmrtd.PassportService r3 = (org.jmrtd.PassportService) r3
            java.lang.Object r4 = r9.f35164b
            d10.l r4 = (d10.l) r4
            java.lang.Object r5 = r9.f35163a
            r6 = r5
            com.sumsub.sns.internal.nfc.e r6 = (com.sumsub.sns.internal.nfc.e) r6
            kotlin.k.b(r0)     // Catch:{ NoClassDefFoundError -> 0x025f, all -> 0x019e }
            r5 = r4
            r4 = r3
            goto L_0x0183
        L_0x006d:
            int r3 = r9.f35166d
            java.lang.Object r4 = r9.f35165c
            org.jmrtd.PassportService r4 = (org.jmrtd.PassportService) r4
            java.lang.Object r5 = r9.f35164b
            d10.l r5 = (d10.l) r5
            java.lang.Object r6 = r9.f35163a
            com.sumsub.sns.internal.nfc.e r6 = (com.sumsub.sns.internal.nfc.e) r6
            kotlin.k.b(r0)     // Catch:{ NoClassDefFoundError -> 0x025f, all -> 0x019e }
            goto L_0x0171
        L_0x0080:
            int r3 = r9.f35166d
            java.lang.Object r4 = r9.f35165c
            org.jmrtd.PassportService r4 = (org.jmrtd.PassportService) r4
            java.lang.Object r5 = r9.f35164b
            d10.l r5 = (d10.l) r5
            java.lang.Object r6 = r9.f35163a
            com.sumsub.sns.internal.nfc.e r6 = (com.sumsub.sns.internal.nfc.e) r6
            kotlin.k.b(r0)     // Catch:{ NoClassDefFoundError -> 0x025f, all -> 0x019e }
            goto L_0x0157
        L_0x0093:
            java.lang.Object r3 = r9.f35165c
            org.jmrtd.PassportService r3 = (org.jmrtd.PassportService) r3
            java.lang.Object r4 = r9.f35164b
            d10.l r4 = (d10.l) r4
            java.lang.Object r5 = r9.f35163a
            r6 = r5
            com.sumsub.sns.internal.nfc.e r6 = (com.sumsub.sns.internal.nfc.e) r6
            kotlin.k.b(r0)     // Catch:{ NoClassDefFoundError -> 0x025f, all -> 0x019e }
            goto L_0x0135
        L_0x00a5:
            java.lang.Object r3 = r9.f35165c
            org.jmrtd.PassportService r3 = (org.jmrtd.PassportService) r3
            java.lang.Object r4 = r9.f35164b
            d10.l r4 = (d10.l) r4
            java.lang.Object r5 = r9.f35163a
            com.sumsub.sns.internal.nfc.e r5 = (com.sumsub.sns.internal.nfc.e) r5
            kotlin.k.b(r0)     // Catch:{ NoClassDefFoundError -> 0x025f, all -> 0x00b7 }
            r0 = r4
            r6 = r5
            goto L_0x0118
        L_0x00b7:
            r0 = move-exception
            r4 = r5
            goto L_0x022e
        L_0x00bb:
            kotlin.k.b(r0)
            com.sumsub.sns.internal.nfc.c r0 = com.sumsub.sns.internal.nfc.c.f35142a     // Catch:{ NoClassDefFoundError -> 0x025f, all -> 0x022c }
            java.lang.String r14 = "NfcReader"
            java.lang.String r15 = "Starting NFC reading"
            r16 = 0
            r17 = 4
            r18 = 0
            r13 = r0
            com.sumsub.sns.internal.nfc.c.a(r13, r14, r15, r16, r17, r18)     // Catch:{ NoClassDefFoundError -> 0x025f, all -> 0x022c }
            android.nfc.tech.IsoDep r3 = r1.f35159a     // Catch:{ NoClassDefFoundError -> 0x025f, all -> 0x022c }
            net.sf.scuba.smartcards.CardService r3 = net.sf.scuba.smartcards.CardService.getInstance(r3)     // Catch:{ NoClassDefFoundError -> 0x025f, all -> 0x022c }
            r3.open()     // Catch:{ NoClassDefFoundError -> 0x025f, all -> 0x022c }
            java.lang.String r14 = "NfcReader"
            java.lang.String r15 = "CardService is opened"
            r16 = 0
            r17 = 4
            r18 = 0
            r13 = r0
            com.sumsub.sns.internal.nfc.c.a(r13, r14, r15, r16, r17, r18)     // Catch:{ NoClassDefFoundError -> 0x025f, all -> 0x022c }
            org.jmrtd.PassportService r4 = new org.jmrtd.PassportService     // Catch:{ NoClassDefFoundError -> 0x025f, all -> 0x022c }
            r15 = 256(0x100, float:3.59E-43)
            r16 = 223(0xdf, float:3.12E-43)
            r17 = 0
            r18 = 0
            r13 = r4
            r14 = r3
            r13.<init>(r14, r15, r16, r17, r18)     // Catch:{ NoClassDefFoundError -> 0x025f, all -> 0x022c }
            r4.open()     // Catch:{ NoClassDefFoundError -> 0x025f, all -> 0x022c }
            java.lang.String r14 = "NfcReader"
            java.lang.String r15 = "Passport service is opened"
            r16 = 0
            r17 = 4
            r18 = 0
            r13 = r0
            com.sumsub.sns.internal.nfc.c.a(r13, r14, r15, r16, r17, r18)     // Catch:{ NoClassDefFoundError -> 0x025f, all -> 0x022c }
            r9.f35163a = r1     // Catch:{ NoClassDefFoundError -> 0x025f, all -> 0x022c }
            r0 = r22
            r9.f35164b = r0     // Catch:{ NoClassDefFoundError -> 0x025f, all -> 0x022c }
            r9.f35165c = r4     // Catch:{ NoClassDefFoundError -> 0x025f, all -> 0x022c }
            r9.f35170h = r10     // Catch:{ NoClassDefFoundError -> 0x025f, all -> 0x022c }
            java.lang.Object r3 = r1.a((kotlin.coroutines.c<? super kotlin.Unit>) r9)     // Catch:{ NoClassDefFoundError -> 0x025f, all -> 0x022c }
            if (r3 != r2) goto L_0x0116
            return r2
        L_0x0116:
            r6 = r1
            r3 = r4
        L_0x0118:
            com.sumsub.sns.internal.nfc.b r4 = r6.f35161c     // Catch:{ NoClassDefFoundError -> 0x025f, all -> 0x019e }
            boolean r4 = r4.d()     // Catch:{ NoClassDefFoundError -> 0x025f, all -> 0x019e }
            if (r4 == 0) goto L_0x0142
            r9.f35163a = r6     // Catch:{ NoClassDefFoundError -> 0x025f, all -> 0x019e }
            r9.f35164b = r0     // Catch:{ NoClassDefFoundError -> 0x025f, all -> 0x019e }
            r9.f35165c = r3     // Catch:{ NoClassDefFoundError -> 0x025f, all -> 0x019e }
            r4 = 2
            r9.f35170h = r4     // Catch:{ NoClassDefFoundError -> 0x025f, all -> 0x019e }
            java.lang.Object r4 = r6.b(r3, r9)     // Catch:{ NoClassDefFoundError -> 0x025f, all -> 0x019e }
            if (r4 != r2) goto L_0x0130
            return r2
        L_0x0130:
            r20 = r4
            r4 = r0
            r0 = r20
        L_0x0135:
            java.lang.Boolean r0 = (java.lang.Boolean) r0     // Catch:{ NoClassDefFoundError -> 0x025f, all -> 0x019e }
            boolean r0 = r0.booleanValue()     // Catch:{ NoClassDefFoundError -> 0x025f, all -> 0x019e }
            r20 = r3
            r3 = r0
            r0 = r4
            r4 = r20
            goto L_0x0144
        L_0x0142:
            r4 = r3
            r3 = r12
        L_0x0144:
            r9.f35163a = r6     // Catch:{ NoClassDefFoundError -> 0x025f, all -> 0x019e }
            r9.f35164b = r0     // Catch:{ NoClassDefFoundError -> 0x025f, all -> 0x019e }
            r9.f35165c = r4     // Catch:{ NoClassDefFoundError -> 0x025f, all -> 0x019e }
            r9.f35166d = r3     // Catch:{ NoClassDefFoundError -> 0x025f, all -> 0x019e }
            r5 = 3
            r9.f35170h = r5     // Catch:{ NoClassDefFoundError -> 0x025f, all -> 0x019e }
            java.lang.Object r5 = r6.a((kotlin.coroutines.c<? super kotlin.Unit>) r9)     // Catch:{ NoClassDefFoundError -> 0x025f, all -> 0x019e }
            if (r5 != r2) goto L_0x0156
            return r2
        L_0x0156:
            r5 = r0
        L_0x0157:
            if (r3 == 0) goto L_0x015b
            r0 = r10
            goto L_0x015c
        L_0x015b:
            r0 = r12
        L_0x015c:
            r4.sendSelectApplet(r0)     // Catch:{ NoClassDefFoundError -> 0x025f, all -> 0x019e }
            r9.f35163a = r6     // Catch:{ NoClassDefFoundError -> 0x025f, all -> 0x019e }
            r9.f35164b = r5     // Catch:{ NoClassDefFoundError -> 0x025f, all -> 0x019e }
            r9.f35165c = r4     // Catch:{ NoClassDefFoundError -> 0x025f, all -> 0x019e }
            r9.f35166d = r3     // Catch:{ NoClassDefFoundError -> 0x025f, all -> 0x019e }
            r0 = 4
            r9.f35170h = r0     // Catch:{ NoClassDefFoundError -> 0x025f, all -> 0x019e }
            java.lang.Object r0 = r6.a((kotlin.coroutines.c<? super kotlin.Unit>) r9)     // Catch:{ NoClassDefFoundError -> 0x025f, all -> 0x019e }
            if (r0 != r2) goto L_0x0171
            return r2
        L_0x0171:
            if (r3 != 0) goto L_0x01a0
            r9.f35163a = r6     // Catch:{ NoClassDefFoundError -> 0x025f, all -> 0x019e }
            r9.f35164b = r5     // Catch:{ NoClassDefFoundError -> 0x025f, all -> 0x019e }
            r9.f35165c = r4     // Catch:{ NoClassDefFoundError -> 0x025f, all -> 0x019e }
            r0 = 5
            r9.f35170h = r0     // Catch:{ NoClassDefFoundError -> 0x025f, all -> 0x019e }
            java.lang.Object r0 = r6.a((org.jmrtd.PassportService) r4, (kotlin.coroutines.c<? super java.lang.Boolean>) r9)     // Catch:{ NoClassDefFoundError -> 0x025f, all -> 0x019e }
            if (r0 != r2) goto L_0x0183
            return r2
        L_0x0183:
            java.lang.Boolean r0 = (java.lang.Boolean) r0     // Catch:{ NoClassDefFoundError -> 0x025f, all -> 0x019e }
            boolean r3 = r0.booleanValue()     // Catch:{ NoClassDefFoundError -> 0x025f, all -> 0x019e }
            r9.f35163a = r6     // Catch:{ NoClassDefFoundError -> 0x025f, all -> 0x019e }
            r9.f35164b = r5     // Catch:{ NoClassDefFoundError -> 0x025f, all -> 0x019e }
            r9.f35165c = r4     // Catch:{ NoClassDefFoundError -> 0x025f, all -> 0x019e }
            r9.f35167e = r3     // Catch:{ NoClassDefFoundError -> 0x025f, all -> 0x019e }
            r0 = 6
            r9.f35170h = r0     // Catch:{ NoClassDefFoundError -> 0x025f, all -> 0x019e }
            java.lang.Object r0 = r6.a((kotlin.coroutines.c<? super kotlin.Unit>) r9)     // Catch:{ NoClassDefFoundError -> 0x025f, all -> 0x019e }
            if (r0 != r2) goto L_0x01a0
            return r2
        L_0x019b:
            r4 = r6
            goto L_0x022e
        L_0x019e:
            r0 = move-exception
            goto L_0x019b
        L_0x01a0:
            r13 = r6
            r6 = r5
            if (r3 == 0) goto L_0x0215
            com.sumsub.sns.internal.nfc.c r14 = com.sumsub.sns.internal.nfc.c.f35142a     // Catch:{ NoClassDefFoundError -> 0x025f, all -> 0x0229 }
            java.lang.String r15 = "NfcReader"
            java.lang.String r16 = "Reading files"
            r17 = 0
            r18 = 4
            r19 = 0
            com.sumsub.sns.internal.nfc.c.a(r14, r15, r16, r17, r18, r19)     // Catch:{ NoClassDefFoundError -> 0x025f, all -> 0x0229 }
            java.util.ArrayList r0 = new java.util.ArrayList     // Catch:{ NoClassDefFoundError -> 0x025f, all -> 0x0229 }
            r0.<init>()     // Catch:{ NoClassDefFoundError -> 0x025f, all -> 0x0229 }
            com.sumsub.sns.internal.nfc.b r3 = r13.f35161c     // Catch:{ NoClassDefFoundError -> 0x025f, all -> 0x0229 }
            java.util.List r3 = r3.c()     // Catch:{ NoClassDefFoundError -> 0x025f, all -> 0x0229 }
            int r14 = r3.size()     // Catch:{ NoClassDefFoundError -> 0x025f, all -> 0x0229 }
            com.sumsub.sns.internal.nfc.b r3 = r13.f35161c     // Catch:{ NoClassDefFoundError -> 0x025f, all -> 0x0229 }
            java.util.List r7 = r3.c()     // Catch:{ NoClassDefFoundError -> 0x025f, all -> 0x0229 }
            r9.f35163a = r13     // Catch:{ NoClassDefFoundError -> 0x025f, all -> 0x0229 }
            r9.f35164b = r0     // Catch:{ NoClassDefFoundError -> 0x025f, all -> 0x0229 }
            r3 = 0
            r9.f35165c = r3     // Catch:{ NoClassDefFoundError -> 0x025f, all -> 0x0229 }
            r9.f35166d = r14     // Catch:{ NoClassDefFoundError -> 0x025f, all -> 0x0229 }
            r3 = 7
            r9.f35170h = r3     // Catch:{ NoClassDefFoundError -> 0x025f, all -> 0x0229 }
            r3 = r13
            r5 = r14
            r8 = r0
            java.lang.Object r3 = r3.a((org.jmrtd.PassportService) r4, (int) r5, (d10.l<? super java.lang.Integer, kotlin.Unit>) r6, (java.util.List<java.lang.Short>) r7, (java.util.List<byte[]>) r8, (kotlin.coroutines.c<? super kotlin.Unit>) r9)     // Catch:{ NoClassDefFoundError -> 0x025f, all -> 0x0229 }
            if (r3 != r2) goto L_0x01de
            return r2
        L_0x01de:
            r3 = r0
            r4 = r13
            r2 = r14
        L_0x01e1:
            boolean r0 = r3.isEmpty()     // Catch:{ NoClassDefFoundError -> 0x025f, all -> 0x0043 }
            if (r0 == 0) goto L_0x0200
            if (r2 <= 0) goto L_0x0200
            com.sumsub.sns.internal.nfc.c r13 = com.sumsub.sns.internal.nfc.c.f35142a     // Catch:{ NoClassDefFoundError -> 0x025f, all -> 0x0043 }
            java.lang.String r14 = "NfcReader"
            java.lang.String r15 = "No files was read"
            r16 = 0
            r17 = 4
            r18 = 0
            com.sumsub.sns.internal.nfc.c.a(r13, r14, r15, r16, r17, r18)     // Catch:{ NoClassDefFoundError -> 0x025f, all -> 0x0043 }
            com.sumsub.sns.internal.nfc.NfcResult$Failed r0 = new com.sumsub.sns.internal.nfc.NfcResult$Failed     // Catch:{ NoClassDefFoundError -> 0x025f, all -> 0x0043 }
            com.sumsub.sns.internal.nfc.NfcResult$Failed$Reason r2 = com.sumsub.sns.internal.nfc.NfcResult.Failed.Reason.READ_FAILED     // Catch:{ NoClassDefFoundError -> 0x025f, all -> 0x0043 }
            r0.<init>(r2)     // Catch:{ NoClassDefFoundError -> 0x025f, all -> 0x0043 }
            goto L_0x0214
        L_0x0200:
            com.sumsub.sns.internal.nfc.c r13 = com.sumsub.sns.internal.nfc.c.f35142a     // Catch:{ NoClassDefFoundError -> 0x025f, all -> 0x0043 }
            java.lang.String r14 = "NfcReader"
            java.lang.String r15 = "NFC read success!"
            r16 = 0
            r17 = 4
            r18 = 0
            com.sumsub.sns.internal.nfc.c.a(r13, r14, r15, r16, r17, r18)     // Catch:{ NoClassDefFoundError -> 0x025f, all -> 0x0043 }
            com.sumsub.sns.internal.nfc.NfcResult$a r0 = new com.sumsub.sns.internal.nfc.NfcResult$a     // Catch:{ NoClassDefFoundError -> 0x025f, all -> 0x0043 }
            r0.<init>(r3)     // Catch:{ NoClassDefFoundError -> 0x025f, all -> 0x0043 }
        L_0x0214:
            return r0
        L_0x0215:
            com.sumsub.sns.internal.nfc.c r2 = com.sumsub.sns.internal.nfc.c.f35142a     // Catch:{ NoClassDefFoundError -> 0x025f, all -> 0x0229 }
            java.lang.String r3 = "NfcReader"
            java.lang.String r4 = "Auth failed"
            r5 = 0
            r6 = 4
            r7 = 0
            com.sumsub.sns.internal.nfc.c.a(r2, r3, r4, r5, r6, r7)     // Catch:{ NoClassDefFoundError -> 0x025f, all -> 0x0229 }
            com.sumsub.sns.internal.nfc.NfcResult$Failed r0 = new com.sumsub.sns.internal.nfc.NfcResult$Failed     // Catch:{ NoClassDefFoundError -> 0x025f, all -> 0x0229 }
            com.sumsub.sns.internal.nfc.NfcResult$Failed$Reason r2 = com.sumsub.sns.internal.nfc.NfcResult.Failed.Reason.AUTH_FAILED     // Catch:{ NoClassDefFoundError -> 0x025f, all -> 0x0229 }
            r0.<init>(r2)     // Catch:{ NoClassDefFoundError -> 0x025f, all -> 0x0229 }
            return r0
        L_0x0229:
            r0 = move-exception
            r4 = r13
            goto L_0x022e
        L_0x022c:
            r0 = move-exception
            r4 = r1
        L_0x022e:
            com.sumsub.sns.internal.nfc.c r5 = com.sumsub.sns.internal.nfc.c.f35142a
            java.lang.String r2 = "Failed to auth or read"
            r5.a(r11, r2, r0)
            boolean r0 = r4.a((java.lang.Throwable) r0)
            if (r0 == 0) goto L_0x024d
            r8 = 0
            r9 = 4
            r10 = 0
            java.lang.String r6 = "NfcReader"
            java.lang.String r7 = "Tag was lost"
            com.sumsub.sns.internal.nfc.c.a(r5, r6, r7, r8, r9, r10)
            com.sumsub.sns.internal.nfc.NfcResult$Failed r0 = new com.sumsub.sns.internal.nfc.NfcResult$Failed
            com.sumsub.sns.internal.nfc.NfcResult$Failed$Reason r2 = com.sumsub.sns.internal.nfc.NfcResult.Failed.Reason.TAG_WAS_LOST
            r0.<init>(r2)
            goto L_0x025e
        L_0x024d:
            r8 = 0
            r9 = 4
            r10 = 0
            java.lang.String r6 = "NfcReader"
            java.lang.String r7 = "Generic read failure"
            com.sumsub.sns.internal.nfc.c.a(r5, r6, r7, r8, r9, r10)
            com.sumsub.sns.internal.nfc.NfcResult$Failed r0 = new com.sumsub.sns.internal.nfc.NfcResult$Failed
            com.sumsub.sns.internal.nfc.NfcResult$Failed$Reason r2 = com.sumsub.sns.internal.nfc.NfcResult.Failed.Reason.READ_FAILED
            r0.<init>(r2)
        L_0x025e:
            return r0
        L_0x025f:
            r0 = move-exception
            com.sumsub.sns.internal.core.common.e0 r2 = com.sumsub.sns.internal.core.common.e0.f32018a
            boolean r2 = r2.isDebug()
            if (r2 != 0) goto L_0x028e
            com.sumsub.sns.internal.nfc.c r2 = com.sumsub.sns.internal.nfc.c.f35142a
            java.lang.String r3 = "Class not found"
            r2.a(r11, r3, r0)
            com.sumsub.sns.internal.log.a r2 = com.sumsub.sns.internal.log.a.f34862a
            com.sumsub.sns.internal.log.LoggerType[] r4 = new com.sumsub.sns.internal.log.LoggerType[r10]
            com.sumsub.sns.internal.log.LoggerType r5 = com.sumsub.sns.internal.log.LoggerType.KIBANA
            r4[r12] = r5
            com.sumsub.log.logger.Logger r2 = r2.a((com.sumsub.sns.internal.log.LoggerType[]) r4)
            java.lang.String r4 = r0.getMessage()
            if (r4 != 0) goto L_0x0282
            goto L_0x0283
        L_0x0282:
            r3 = r4
        L_0x0283:
            r2.w(r11, r3, r0)
            com.sumsub.sns.internal.nfc.NfcResult$Failed r0 = new com.sumsub.sns.internal.nfc.NfcResult$Failed
            com.sumsub.sns.internal.nfc.NfcResult$Failed$Reason r2 = com.sumsub.sns.internal.nfc.NfcResult.Failed.Reason.READ_FAILED
            r0.<init>(r2)
            return r0
        L_0x028e:
            java.lang.RuntimeException r2 = new java.lang.RuntimeException
            r2.<init>(r0)
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sumsub.sns.internal.nfc.e.a(d10.l, kotlin.coroutines.c):java.lang.Object");
    }

    /* JADX WARNING: Removed duplicated region for block: B:16:0x0040  */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x008f  */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x0091  */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x00a3  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0025  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object a(org.jmrtd.PassportService r13, kotlin.coroutines.c<? super java.lang.Boolean> r14) {
        /*
            r12 = this;
            boolean r0 = r14 instanceof com.sumsub.sns.internal.nfc.e.g
            if (r0 == 0) goto L_0x0013
            r0 = r14
            com.sumsub.sns.internal.nfc.e$g r0 = (com.sumsub.sns.internal.nfc.e.g) r0
            int r1 = r0.f35194f
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.f35194f = r1
            goto L_0x0018
        L_0x0013:
            com.sumsub.sns.internal.nfc.e$g r0 = new com.sumsub.sns.internal.nfc.e$g
            r0.<init>(r12, r14)
        L_0x0018:
            r7 = r0
            java.lang.Object r14 = r7.f35192d
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.d()
            int r1 = r7.f35194f
            r10 = 0
            r11 = 1
            if (r1 == 0) goto L_0x0040
            if (r1 != r11) goto L_0x0038
            int r13 = r7.f35191c
            java.lang.Object r0 = r7.f35190b
            org.jmrtd.PassportService r0 = (org.jmrtd.PassportService) r0
            java.lang.Object r1 = r7.f35189a
            com.sumsub.sns.internal.nfc.e r1 = (com.sumsub.sns.internal.nfc.e) r1
            kotlin.k.b(r14)     // Catch:{ Exception -> 0x0035 }
            goto L_0x0075
        L_0x0035:
            r14 = r13
            r13 = r0
            goto L_0x006b
        L_0x0038:
            java.lang.IllegalStateException r13 = new java.lang.IllegalStateException
            java.lang.String r14 = "call to 'resume' before 'invoke' with coroutine"
            r13.<init>(r14)
            throw r13
        L_0x0040:
            kotlin.k.b(r14)
            com.sumsub.sns.internal.nfc.c r1 = com.sumsub.sns.internal.nfc.c.f35142a
            r4 = 0
            r5 = 4
            r6 = 0
            java.lang.String r2 = "NfcReader"
            java.lang.String r3 = "Trying BAC"
            com.sumsub.sns.internal.nfc.c.a(r1, r2, r3, r4, r5, r6)
            r3 = 286(0x11e, float:4.01E-43)
            java.lang.String r4 = "EF_COM"
            r5 = 0
            r6 = 0
            r8 = 12
            r9 = 0
            r7.f35189a = r12     // Catch:{ Exception -> 0x0069 }
            r7.f35190b = r13     // Catch:{ Exception -> 0x0069 }
            r7.f35191c = r10     // Catch:{ Exception -> 0x0069 }
            r7.f35194f = r11     // Catch:{ Exception -> 0x0069 }
            r1 = r12
            r2 = r13
            java.lang.Object r13 = a(r1, r2, r3, r4, r5, r6, r7, r8, r9)     // Catch:{ Exception -> 0x0069 }
            if (r13 != r0) goto L_0x0075
            return r0
        L_0x0069:
            r1 = r12
            r14 = r10
        L_0x006b:
            com.sumsub.sns.internal.nfc.e$a r0 = new com.sumsub.sns.internal.nfc.e$a     // Catch:{ Exception -> 0x0077 }
            byte[] r1 = r1.f35160b     // Catch:{ Exception -> 0x0077 }
            r0.<init>(r1)     // Catch:{ Exception -> 0x0077 }
            r13.doBAC(r0)     // Catch:{ Exception -> 0x0077 }
        L_0x0075:
            r14 = r11
            goto L_0x0081
        L_0x0077:
            r13 = move-exception
            com.sumsub.sns.internal.nfc.c r0 = com.sumsub.sns.internal.nfc.c.f35142a
            java.lang.String r1 = "NfcReader"
            java.lang.String r2 = "Failed to do BAC"
            r0.a(r1, r2, r13)
        L_0x0081:
            com.sumsub.sns.internal.nfc.c r0 = com.sumsub.sns.internal.nfc.c.f35142a
            java.lang.StringBuilder r13 = new java.lang.StringBuilder
            r13.<init>()
            java.lang.String r1 = "bacSucceeded = "
            r13.append(r1)
            if (r14 == 0) goto L_0x0091
            r1 = r11
            goto L_0x0092
        L_0x0091:
            r1 = r10
        L_0x0092:
            r13.append(r1)
            java.lang.String r2 = r13.toString()
            r3 = 0
            r4 = 4
            r5 = 0
            java.lang.String r1 = "NfcReader"
            com.sumsub.sns.internal.nfc.c.a(r0, r1, r2, r3, r4, r5)
            if (r14 == 0) goto L_0x00a4
            r10 = r11
        L_0x00a4:
            java.lang.Boolean r13 = kotlin.coroutines.jvm.internal.a.a(r10)
            return r13
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sumsub.sns.internal.nfc.e.a(org.jmrtd.PassportService, kotlin.coroutines.c):java.lang.Object");
    }

    public final boolean a(Throwable th2) {
        if (th2 == null) {
            return false;
        }
        if (th2 instanceof TagLostException) {
            return true;
        }
        return a(th2.getCause());
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(11:20|(1:22)(1:23)|24|25|(1:27)|28|29|30|31|(1:33)(7:34|35|36|37|44|(0)|46)|33) */
    /* JADX WARNING: Code restructure failed: missing block: B:39:0x0166, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:40:0x0168, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:41:0x0169, code lost:
        r18 = r10;
        r19 = r11;
        r5 = r12;
        r6 = r13;
        r20 = r14;
        r16 = r15;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:0x0173, code lost:
        r12 = r5;
        r13 = r6;
        r15 = r16;
        r10 = r18;
        r11 = r19;
        r14 = r20;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:43:0x017d, code lost:
        r5 = com.sumsub.sns.internal.nfc.c.f35142a;
        r5.a(f35154e, "Error while reading " + r10 + ". Ignoring...", r0);
        r0 = r4;
        r7 = r14;
        r10 = r15;
        r4 = r3;
        r3 = r12;
        r12 = r1;
        r1 = r13;
     */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x007d  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0096  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x01d2 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x01d3  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x002a  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object a(org.jmrtd.PassportService r23, int r24, d10.l<? super java.lang.Integer, kotlin.Unit> r25, java.util.List<java.lang.Short> r26, java.util.List<byte[]> r27, kotlin.coroutines.c<? super kotlin.Unit> r28) {
        /*
            r22 = this;
            r0 = r28
            boolean r1 = r0 instanceof com.sumsub.sns.internal.nfc.e.f
            if (r1 == 0) goto L_0x0017
            r1 = r0
            com.sumsub.sns.internal.nfc.e$f r1 = (com.sumsub.sns.internal.nfc.e.f) r1
            int r2 = r1.f35188k
            r3 = -2147483648(0xffffffff80000000, float:-0.0)
            r4 = r2 & r3
            if (r4 == 0) goto L_0x0017
            int r2 = r2 - r3
            r1.f35188k = r2
            r2 = r22
            goto L_0x001e
        L_0x0017:
            com.sumsub.sns.internal.nfc.e$f r1 = new com.sumsub.sns.internal.nfc.e$f
            r2 = r22
            r1.<init>(r2, r0)
        L_0x001e:
            java.lang.Object r0 = r1.f35186i
            java.lang.Object r3 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.d()
            int r4 = r1.f35188k
            r5 = 2
            r6 = 1
            if (r4 == 0) goto L_0x007d
            if (r4 == r6) goto L_0x0057
            if (r4 != r5) goto L_0x004f
            int r4 = r1.f35185h
            java.lang.Object r7 = r1.f35182e
            java.util.Iterator r7 = (java.util.Iterator) r7
            java.lang.Object r8 = r1.f35181d
            java.util.List r8 = (java.util.List) r8
            java.lang.Object r9 = r1.f35180c
            d10.l r9 = (d10.l) r9
            java.lang.Object r10 = r1.f35179b
            org.jmrtd.PassportService r10 = (org.jmrtd.PassportService) r10
            java.lang.Object r11 = r1.f35178a
            com.sumsub.sns.internal.nfc.e r11 = (com.sumsub.sns.internal.nfc.e) r11
            kotlin.k.b(r0)
            r13 = r1
            r12 = r3
            r3 = r4
            r14 = r7
            r15 = r8
            r4 = r9
            r1 = r10
            goto L_0x0090
        L_0x004f:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "call to 'resume' before 'invoke' with coroutine"
            r0.<init>(r1)
            throw r0
        L_0x0057:
            int r4 = r1.f35185h
            java.lang.Object r7 = r1.f35184g
            java.util.List r7 = (java.util.List) r7
            java.lang.Object r8 = r1.f35183f
            java.lang.String r8 = (java.lang.String) r8
            java.lang.Object r9 = r1.f35182e
            java.util.Iterator r9 = (java.util.Iterator) r9
            java.lang.Object r10 = r1.f35181d
            java.util.List r10 = (java.util.List) r10
            java.lang.Object r11 = r1.f35180c
            d10.l r11 = (d10.l) r11
            java.lang.Object r12 = r1.f35179b
            org.jmrtd.PassportService r12 = (org.jmrtd.PassportService) r12
            java.lang.Object r13 = r1.f35178a
            com.sumsub.sns.internal.nfc.e r13 = (com.sumsub.sns.internal.nfc.e) r13
            kotlin.k.b(r0)     // Catch:{ Exception -> 0x007a }
            goto L_0x012b
        L_0x007a:
            r0 = move-exception
            goto L_0x0159
        L_0x007d:
            kotlin.k.b(r0)
            java.util.Iterator r0 = r26.iterator()
            r4 = r25
            r15 = r27
            r14 = r0
            r13 = r1
            r11 = r2
            r12 = r3
            r1 = r23
            r3 = r24
        L_0x0090:
            boolean r0 = r14.hasNext()
            if (r0 == 0) goto L_0x01dc
            java.lang.Object r0 = r14.next()
            java.lang.Number r0 = (java.lang.Number) r0
            short r0 = r0.shortValue()
            java.util.Map<java.lang.Short, java.lang.String> r7 = f35157h
            short r9 = (short) r0
            java.lang.Short r0 = kotlin.coroutines.jvm.internal.a.e(r9)
            java.lang.Object r0 = r7.get(r0)
            java.lang.String r0 = (java.lang.String) r0
            java.lang.String r8 = "Unknown file"
            if (r0 != 0) goto L_0x00b3
            r10 = r8
            goto L_0x00b4
        L_0x00b3:
            r10 = r0
        L_0x00b4:
            com.sumsub.sns.internal.nfc.c r0 = com.sumsub.sns.internal.nfc.c.f35142a     // Catch:{ Exception -> 0x0168 }
            java.lang.String r16 = "NfcReader"
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0168 }
            r5.<init>()     // Catch:{ Exception -> 0x0168 }
            java.lang.String r6 = "Reading "
            r5.append(r6)     // Catch:{ Exception -> 0x0168 }
            r5.append(r10)     // Catch:{ Exception -> 0x0168 }
            java.lang.String r5 = r5.toString()     // Catch:{ Exception -> 0x0168 }
            r6 = 0
            r17 = 4
            r18 = 0
            r23 = r0
            r24 = r16
            r25 = r5
            r26 = r6
            r27 = r17
            r28 = r18
            com.sumsub.sns.internal.nfc.c.a(r23, r24, r25, r26, r27, r28)     // Catch:{ Exception -> 0x0168 }
            java.lang.Short r0 = kotlin.coroutines.jvm.internal.a.e(r9)     // Catch:{ Exception -> 0x0168 }
            java.lang.Object r0 = r7.get(r0)     // Catch:{ Exception -> 0x0168 }
            java.lang.String r0 = (java.lang.String) r0     // Catch:{ Exception -> 0x0168 }
            if (r0 != 0) goto L_0x00ea
            r0 = r8
        L_0x00ea:
            r5 = 0
            r6 = 0
            r16 = 12
            r17 = 0
            r13.f35178a = r11     // Catch:{ Exception -> 0x0168 }
            r13.f35179b = r1     // Catch:{ Exception -> 0x0168 }
            r13.f35180c = r4     // Catch:{ Exception -> 0x0168 }
            r13.f35181d = r15     // Catch:{ Exception -> 0x0168 }
            r13.f35182e = r14     // Catch:{ Exception -> 0x0168 }
            r13.f35183f = r10     // Catch:{ Exception -> 0x0168 }
            r13.f35184g = r15     // Catch:{ Exception -> 0x0168 }
            r13.f35185h = r3     // Catch:{ Exception -> 0x0168 }
            r7 = 1
            r13.f35188k = r7     // Catch:{ Exception -> 0x0168 }
            r7 = r11
            r8 = r1
            r18 = r10
            r10 = r0
            r19 = r11
            r11 = r5
            r5 = r12
            r12 = r6
            r6 = r13
            r20 = r14
            r14 = r16
            r16 = r15
            r15 = r17
            java.lang.Object r0 = a(r7, r8, r9, r10, r11, r12, r13, r14, r15)     // Catch:{ Exception -> 0x0166 }
            if (r0 != r5) goto L_0x011d
            return r5
        L_0x011d:
            r12 = r1
            r11 = r4
            r1 = r6
            r7 = r16
            r10 = r7
            r8 = r18
            r13 = r19
            r9 = r20
            r4 = r3
            r3 = r5
        L_0x012b:
            r7.add(r0)     // Catch:{ Exception -> 0x007a }
            com.sumsub.sns.internal.nfc.c r0 = com.sumsub.sns.internal.nfc.c.f35142a     // Catch:{ Exception -> 0x007a }
            java.lang.String r5 = "NfcReader"
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x007a }
            r6.<init>()     // Catch:{ Exception -> 0x007a }
            r6.append(r8)     // Catch:{ Exception -> 0x007a }
            java.lang.String r7 = " read successfully"
            r6.append(r7)     // Catch:{ Exception -> 0x007a }
            java.lang.String r6 = r6.toString()     // Catch:{ Exception -> 0x007a }
            r7 = 0
            r14 = 4
            r15 = 0
            r23 = r0
            r24 = r5
            r25 = r6
            r26 = r7
            r27 = r14
            r28 = r15
            com.sumsub.sns.internal.nfc.c.a(r23, r24, r25, r26, r27, r28)     // Catch:{ Exception -> 0x007a }
            r7 = r9
            r0 = r11
            r11 = r13
            goto L_0x01a1
        L_0x0159:
            r14 = r9
            r15 = r10
            r10 = r8
            r21 = r13
            r13 = r1
            r1 = r12
            r12 = r3
            r3 = r4
            r4 = r11
            r11 = r21
            goto L_0x017d
        L_0x0166:
            r0 = move-exception
            goto L_0x0173
        L_0x0168:
            r0 = move-exception
            r18 = r10
            r19 = r11
            r5 = r12
            r6 = r13
            r20 = r14
            r16 = r15
        L_0x0173:
            r12 = r5
            r13 = r6
            r15 = r16
            r10 = r18
            r11 = r19
            r14 = r20
        L_0x017d:
            com.sumsub.sns.internal.nfc.c r5 = com.sumsub.sns.internal.nfc.c.f35142a
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            java.lang.String r7 = "Error while reading "
            r6.append(r7)
            r6.append(r10)
            java.lang.String r7 = ". Ignoring..."
            r6.append(r7)
            java.lang.String r6 = r6.toString()
            java.lang.String r7 = "NfcReader"
            r5.a(r7, r6, r0)
            r0 = r4
            r7 = r14
            r10 = r15
            r4 = r3
            r3 = r12
            r12 = r1
            r1 = r13
        L_0x01a1:
            int r5 = r10.size()
            float r5 = (float) r5
            r6 = 1
            int r8 = java.lang.Math.max(r4, r6)
            float r8 = (float) r8
            float r5 = r5 / r8
            r8 = 1120403456(0x42c80000, float:100.0)
            float r5 = r5 * r8
            int r5 = (int) r5
            java.lang.Integer r5 = kotlin.coroutines.jvm.internal.a.c(r5)
            r0.invoke(r5)
            r1.f35178a = r11
            r1.f35179b = r12
            r1.f35180c = r0
            r1.f35181d = r10
            r1.f35182e = r7
            r5 = 0
            r1.f35183f = r5
            r1.f35184g = r5
            r1.f35185h = r4
            r5 = 2
            r1.f35188k = r5
            java.lang.Object r8 = r11.a((kotlin.coroutines.c<? super kotlin.Unit>) r1)
            if (r8 != r3) goto L_0x01d3
            return r3
        L_0x01d3:
            r13 = r1
            r14 = r7
            r15 = r10
            r1 = r12
            r12 = r3
            r3 = r4
            r4 = r0
            goto L_0x0090
        L_0x01dc:
            kotlin.Unit r0 = kotlin.Unit.f56620a
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sumsub.sns.internal.nfc.e.a(org.jmrtd.PassportService, int, d10.l, java.util.List, java.util.List, kotlin.coroutines.c):java.lang.Object");
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v3, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v4, resolved type: java.lang.String} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x0038  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object a(org.jmrtd.PassportService r5, short r6, java.lang.String r7, int r8, int r9, kotlin.coroutines.c<? super byte[]> r10) {
        /*
            r4 = this;
            boolean r0 = r10 instanceof com.sumsub.sns.internal.nfc.e.d
            if (r0 == 0) goto L_0x0013
            r0 = r10
            com.sumsub.sns.internal.nfc.e$d r0 = (com.sumsub.sns.internal.nfc.e.d) r0
            int r1 = r0.f35175e
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.f35175e = r1
            goto L_0x0018
        L_0x0013:
            com.sumsub.sns.internal.nfc.e$d r0 = new com.sumsub.sns.internal.nfc.e$d
            r0.<init>(r4, r10)
        L_0x0018:
            java.lang.Object r10 = r0.f35173c
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.d()
            int r2 = r0.f35175e
            r3 = 1
            if (r2 == 0) goto L_0x0038
            if (r2 != r3) goto L_0x0030
            short r6 = r0.f35171a
            java.lang.Object r5 = r0.f35172b
            r7 = r5
            java.lang.String r7 = (java.lang.String) r7
            kotlin.k.b(r10)     // Catch:{ Exception -> 0x0051 }
            goto L_0x004e
        L_0x0030:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L_0x0038:
            kotlin.k.b(r10)
            com.sumsub.sns.internal.nfc.e$e r10 = new com.sumsub.sns.internal.nfc.e$e     // Catch:{ Exception -> 0x0051 }
            short r2 = (short) r6     // Catch:{ Exception -> 0x0051 }
            r10.<init>(r5, r2)     // Catch:{ Exception -> 0x0051 }
            r0.f35172b = r7     // Catch:{ Exception -> 0x0051 }
            r0.f35171a = r6     // Catch:{ Exception -> 0x0051 }
            r0.f35175e = r3     // Catch:{ Exception -> 0x0051 }
            java.lang.Object r10 = com.sumsub.sns.internal.nfc.f.a(r8, r9, r10, r0)     // Catch:{ Exception -> 0x0051 }
            if (r10 != r1) goto L_0x004e
            return r1
        L_0x004e:
            byte[] r10 = (byte[]) r10     // Catch:{ Exception -> 0x0051 }
            return r10
        L_0x0051:
            r5 = move-exception
            com.sumsub.sns.internal.nfc.c r8 = com.sumsub.sns.internal.nfc.c.f35142a
            java.lang.StringBuilder r9 = new java.lang.StringBuilder
            r9.<init>()
            java.lang.String r10 = "Failed to read file "
            r9.append(r10)
            r9.append(r7)
            java.lang.String r7 = " ("
            r9.append(r7)
            r9.append(r6)
            java.lang.String r6 = ") "
            r9.append(r6)
            java.lang.String r6 = r9.toString()
            java.lang.String r7 = "NfcReader"
            r8.a(r7, r6, r5)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sumsub.sns.internal.nfc.e.a(org.jmrtd.PassportService, short, java.lang.String, int, int, kotlin.coroutines.c):java.lang.Object");
    }

    public static /* synthetic */ Object a(e eVar, PassportService passportService, short s11, String str, int i11, int i12, kotlin.coroutines.c cVar, int i13, Object obj) {
        if ((i13 & 4) != 0) {
            i11 = 1;
        }
        int i14 = i11;
        if ((i13 & 8) != 0) {
            i12 = 300;
        }
        return eVar.a(passportService, s11, str, i14, i12, (kotlin.coroutines.c<? super byte[]>) cVar);
    }

    public final Object a(kotlin.coroutines.c<? super Unit> cVar) {
        Object b11 = DelayKt.b(50, cVar);
        return b11 == IntrinsicsKt__IntrinsicsKt.d() ? b11 : Unit.f56620a;
    }
}
