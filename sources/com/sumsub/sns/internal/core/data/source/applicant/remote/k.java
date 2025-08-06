package com.sumsub.sns.internal.core.data.source.applicant.remote;

import android.os.Parcel;
import android.os.Parcelable;
import com.sumsub.sns.internal.core.data.source.applicant.remote.r;
import com.tencent.qcloud.tuicore.TUIConstants;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.r;
import kotlin.jvm.internal.x;
import kotlinx.serialization.encoding.d;
import kotlinx.serialization.f;
import kotlinx.serialization.internal.PluginGeneratedSerialDescriptor;
import kotlinx.serialization.internal.d0;
import kotlinx.serialization.internal.e;
import kotlinx.serialization.internal.h;
import kotlinx.serialization.internal.h1;
import kotlinx.serialization.internal.q1;
import kotlinx.serialization.internal.v1;

@Metadata(bv = {}, d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u001e\n\u0002\u0018\u0002\n\u0002\b\u0004\b\b\u0018\u0000 I2\u00020\u0001:\u0002\b\nBy\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\r\u0012\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\t\u0012\u0010\b\u0002\u0010\u001e\u001a\n\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u0013¢\u0006\u0004\bC\u0010DB\u0001\b\u0017\u0012\u0006\u0010E\u001a\u00020!\u0012\n\b\u0001\u0010\u0016\u001a\u0004\u0018\u00010\t\u0012\n\b\u0001\u0010\u0017\u001a\u0004\u0018\u00010\t\u0012\n\b\u0001\u0010\u0018\u001a\u0004\u0018\u00010\t\u0012\n\b\u0001\u0010\u0019\u001a\u0004\u0018\u00010\t\u0012\n\b\u0001\u0010\u001a\u001a\u0004\u0018\u00010\r\u0012\n\b\u0001\u0010\u001b\u001a\u0004\u0018\u00010\t\u0012\n\b\u0001\u0010\u001c\u001a\u0004\u0018\u00010\t\u0012\n\b\u0001\u0010\u001d\u001a\u0004\u0018\u00010\t\u0012\u0010\b\u0001\u0010\u001e\u001a\n\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u0013\u0012\b\u0010G\u001a\u0004\u0018\u00010F¢\u0006\u0004\bC\u0010HJ!\u0010\b\u001a\u00020\u00072\u0006\u0010\u0002\u001a\u00020\u00002\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005HÇ\u0001J\u000b\u0010\b\u001a\u0004\u0018\u00010\tHÆ\u0003J\u000b\u0010\n\u001a\u0004\u0018\u00010\tHÆ\u0003J\u000b\u0010\u000b\u001a\u0004\u0018\u00010\tHÆ\u0003J\u000b\u0010\f\u001a\u0004\u0018\u00010\tHÆ\u0003J\u0012\u0010\u000e\u001a\u0004\u0018\u00010\rHÆ\u0003¢\u0006\u0004\b\u000e\u0010\u000fJ\u000b\u0010\u0010\u001a\u0004\u0018\u00010\tHÆ\u0003J\u000b\u0010\u0011\u001a\u0004\u0018\u00010\tHÆ\u0003J\u000b\u0010\u0012\u001a\u0004\u0018\u00010\tHÆ\u0003J\u0011\u0010\u0015\u001a\n\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u0013HÆ\u0003J\u0001\u0010\b\u001a\u00020\u00002\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\t2\u0010\b\u0002\u0010\u001e\u001a\n\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u0013HÆ\u0001¢\u0006\u0004\b\b\u0010\u001fJ\t\u0010 \u001a\u00020\tHÖ\u0001J\t\u0010\"\u001a\u00020!HÖ\u0001J\u0013\u0010%\u001a\u00020\r2\b\u0010$\u001a\u0004\u0018\u00010#HÖ\u0003J\t\u0010&\u001a\u00020!HÖ\u0001J\u0019\u0010*\u001a\u00020\u00072\u0006\u0010(\u001a\u00020'2\u0006\u0010)\u001a\u00020!HÖ\u0001R\"\u0010\u0016\u001a\u0004\u0018\u00010\t8\u0006X\u0004¢\u0006\u0012\n\u0004\b\b\u0010+\u0012\u0004\b.\u0010/\u001a\u0004\b,\u0010-R\"\u0010\u0017\u001a\u0004\u0018\u00010\t8\u0006X\u0004¢\u0006\u0012\n\u0004\b\n\u0010+\u0012\u0004\b1\u0010/\u001a\u0004\b0\u0010-R\"\u0010\u0018\u001a\u0004\u0018\u00010\t8\u0006X\u0004¢\u0006\u0012\n\u0004\b\u000b\u0010+\u0012\u0004\b3\u0010/\u001a\u0004\b2\u0010-R\"\u0010\u0019\u001a\u0004\u0018\u00010\t8\u0006X\u0004¢\u0006\u0012\n\u0004\b\f\u0010+\u0012\u0004\b5\u0010/\u001a\u0004\b4\u0010-R\"\u0010\u001a\u001a\u0004\u0018\u00010\r8\u0006X\u0004¢\u0006\u0012\n\u0004\b\u000e\u00106\u0012\u0004\b8\u0010/\u001a\u0004\b7\u0010\u000fR\"\u0010\u001b\u001a\u0004\u0018\u00010\t8\u0006X\u0004¢\u0006\u0012\n\u0004\b\u0010\u0010+\u0012\u0004\b:\u0010/\u001a\u0004\b9\u0010-R\"\u0010\u001c\u001a\u0004\u0018\u00010\t8\u0006X\u0004¢\u0006\u0012\n\u0004\b\u0011\u0010+\u0012\u0004\b<\u0010/\u001a\u0004\b;\u0010-R\"\u0010\u001d\u001a\u0004\u0018\u00010\t8\u0006X\u0004¢\u0006\u0012\n\u0004\b\u0012\u0010+\u0012\u0004\b>\u0010/\u001a\u0004\b=\u0010-R(\u0010\u001e\u001a\n\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u00138\u0006X\u0004¢\u0006\u0012\n\u0004\b\u0015\u0010?\u0012\u0004\bB\u0010/\u001a\u0004\b@\u0010A¨\u0006J"}, d2 = {"Lcom/sumsub/sns/internal/core/data/source/applicant/remote/k;", "Landroid/os/Parcelable;", "self", "Lkotlinx/serialization/encoding/b;", "output", "Lkotlinx/serialization/descriptors/f;", "serialDesc", "", "a", "", "b", "c", "d", "", "e", "()Ljava/lang/Boolean;", "f", "g", "h", "", "Lcom/sumsub/sns/internal/core/data/source/applicant/remote/r;", "i", "id", "title", "desc", "type", "required", "format", "placeholder", "condition", "options", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;)Lcom/sumsub/sns/internal/core/data/source/applicant/remote/k;", "toString", "", "hashCode", "", "other", "equals", "describeContents", "Landroid/os/Parcel;", "parcel", "flags", "writeToParcel", "Ljava/lang/String;", "p", "()Ljava/lang/String;", "getId$annotations", "()V", "x", "getTitle$annotations", "l", "getDesc$annotations", "z", "getType$annotations", "Ljava/lang/Boolean;", "v", "getRequired$annotations", "n", "getFormat$annotations", "t", "getPlaceholder$annotations", "j", "getCondition$annotations", "Ljava/util/List;", "r", "()Ljava/util/List;", "getOptions$annotations", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;)V", "seen1", "Lkotlinx/serialization/internal/q1;", "serializationConstructorMarker", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Lkotlinx/serialization/internal/q1;)V", "Companion", "idensic-mobile-sdk-aar_release"}, k = 1, mv = {1, 7, 1})
@f
public final class k implements Parcelable {
    public static final Parcelable.Creator<k> CREATOR = new c();
    public static final b Companion = new b((r) null);

    /* renamed from: a  reason: collision with root package name */
    public final String f33175a;

    /* renamed from: b  reason: collision with root package name */
    public final String f33176b;

    /* renamed from: c  reason: collision with root package name */
    public final String f33177c;

    /* renamed from: d  reason: collision with root package name */
    public final String f33178d;

    /* renamed from: e  reason: collision with root package name */
    public final Boolean f33179e;

    /* renamed from: f  reason: collision with root package name */
    public final String f33180f;

    /* renamed from: g  reason: collision with root package name */
    public final String f33181g;

    /* renamed from: h  reason: collision with root package name */
    public final String f33182h;

    /* renamed from: i  reason: collision with root package name */
    public final List<r> f33183i;

    public static final class a implements d0<k> {

        /* renamed from: a  reason: collision with root package name */
        public static final a f33184a;

        /* renamed from: b  reason: collision with root package name */
        public static final /* synthetic */ kotlinx.serialization.descriptors.f f33185b;

        static {
            a aVar = new a();
            f33184a = aVar;
            PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.sumsub.sns.internal.core.data.source.applicant.remote.Item", aVar, 9);
            pluginGeneratedSerialDescriptor.k("id", true);
            pluginGeneratedSerialDescriptor.k("title", true);
            pluginGeneratedSerialDescriptor.k("desc", true);
            pluginGeneratedSerialDescriptor.k("type", true);
            pluginGeneratedSerialDescriptor.k("required", true);
            pluginGeneratedSerialDescriptor.k(TUIConstants.TUIGroupNote.PLUGIN_GROUP_NOTE_FORMAT, true);
            pluginGeneratedSerialDescriptor.k("placeholder", true);
            pluginGeneratedSerialDescriptor.k("condition", true);
            pluginGeneratedSerialDescriptor.k("options", true);
            f33185b = pluginGeneratedSerialDescriptor;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:11:0x0081, code lost:
            r4 = 6;
            r10 = r10;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:19:0x00d8, code lost:
            r4 = r5;
            r10 = r10;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:21:0x00dd, code lost:
            r3 = 7;
            r10 = r10;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:26:0x005c, code lost:
            r10 = r10;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:30:0x005c, code lost:
            r10 = r10;
         */
        /* JADX WARNING: Multi-variable type inference failed */
        /* renamed from: a */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public com.sumsub.sns.internal.core.data.source.applicant.remote.k deserialize(kotlinx.serialization.encoding.c r21) {
            /*
                r20 = this;
                kotlinx.serialization.descriptors.f r0 = r20.getDescriptor()
                r1 = r21
                kotlinx.serialization.encoding.a r1 = r1.b(r0)
                boolean r2 = r1.k()
                r3 = 7
                r4 = 6
                r5 = 5
                r6 = 3
                r7 = 8
                r8 = 4
                r9 = 2
                r10 = 0
                r11 = 1
                r12 = 0
                if (r2 == 0) goto L_0x0051
                kotlinx.serialization.internal.v1 r2 = kotlinx.serialization.internal.v1.f57779a
                java.lang.Object r10 = r1.j(r0, r10, r2, r12)
                java.lang.Object r11 = r1.j(r0, r11, r2, r12)
                java.lang.Object r9 = r1.j(r0, r9, r2, r12)
                java.lang.Object r6 = r1.j(r0, r6, r2, r12)
                kotlinx.serialization.internal.h r13 = kotlinx.serialization.internal.h.f57720a
                java.lang.Object r8 = r1.j(r0, r8, r13, r12)
                java.lang.Object r5 = r1.j(r0, r5, r2, r12)
                java.lang.Object r4 = r1.j(r0, r4, r2, r12)
                java.lang.Object r2 = r1.j(r0, r3, r2, r12)
                kotlinx.serialization.internal.e r3 = new kotlinx.serialization.internal.e
                com.sumsub.sns.internal.core.data.source.applicant.remote.r$a r13 = com.sumsub.sns.internal.core.data.source.applicant.remote.r.a.f33207a
                r3.<init>(r13)
                java.lang.Object r3 = r1.j(r0, r7, r3, r12)
                r7 = 511(0x1ff, float:7.16E-43)
                r12 = r10
                r10 = r8
                r8 = r7
                goto L_0x00e9
            L_0x0051:
                r2 = r10
                r19 = r11
                r6 = r12
                r8 = r6
                r9 = r8
                r10 = r9
                r11 = r10
                r13 = r11
                r14 = r13
                r15 = r14
            L_0x005c:
                if (r19 == 0) goto L_0x00e1
                int r5 = r1.w(r0)
                switch(r5) {
                    case -1: goto L_0x00da;
                    case 0: goto L_0x00cd;
                    case 1: goto L_0x00c1;
                    case 2: goto L_0x00b5;
                    case 3: goto L_0x00a9;
                    case 4: goto L_0x009d;
                    case 5: goto L_0x008f;
                    case 6: goto L_0x0084;
                    case 7: goto L_0x0079;
                    case 8: goto L_0x006b;
                    default: goto L_0x0065;
                }
            L_0x0065:
                kotlinx.serialization.UnknownFieldException r0 = new kotlinx.serialization.UnknownFieldException
                r0.<init>((int) r5)
                throw r0
            L_0x006b:
                kotlinx.serialization.internal.e r5 = new kotlinx.serialization.internal.e
                com.sumsub.sns.internal.core.data.source.applicant.remote.r$a r4 = com.sumsub.sns.internal.core.data.source.applicant.remote.r.a.f33207a
                r5.<init>(r4)
                java.lang.Object r8 = r1.j(r0, r7, r5, r8)
                r2 = r2 | 256(0x100, float:3.59E-43)
                goto L_0x0081
            L_0x0079:
                kotlinx.serialization.internal.v1 r4 = kotlinx.serialization.internal.v1.f57779a
                java.lang.Object r6 = r1.j(r0, r3, r4, r6)
                r2 = r2 | 128(0x80, float:1.794E-43)
            L_0x0081:
                r4 = 6
                goto L_0x00de
            L_0x0084:
                kotlinx.serialization.internal.v1 r4 = kotlinx.serialization.internal.v1.f57779a
                r5 = 6
                java.lang.Object r9 = r1.j(r0, r5, r4, r9)
                r2 = r2 | 64
                r4 = r5
                goto L_0x00de
            L_0x008f:
                r5 = r4
                kotlinx.serialization.internal.v1 r4 = kotlinx.serialization.internal.v1.f57779a
                r3 = 5
                java.lang.Object r11 = r1.j(r0, r3, r4, r11)
                r2 = r2 | 32
                r4 = r5
                r5 = r3
                r3 = 7
                goto L_0x005c
            L_0x009d:
                r5 = r4
                r3 = 5
                kotlinx.serialization.internal.h r4 = kotlinx.serialization.internal.h.f57720a
                r3 = 4
                java.lang.Object r10 = r1.j(r0, r3, r4, r10)
                r2 = r2 | 16
                goto L_0x00d8
            L_0x00a9:
                r5 = r4
                r3 = 4
                kotlinx.serialization.internal.v1 r4 = kotlinx.serialization.internal.v1.f57779a
                r3 = 3
                java.lang.Object r15 = r1.j(r0, r3, r4, r15)
                r2 = r2 | 8
                goto L_0x00d8
            L_0x00b5:
                r5 = r4
                r3 = 3
                kotlinx.serialization.internal.v1 r4 = kotlinx.serialization.internal.v1.f57779a
                r3 = 2
                java.lang.Object r14 = r1.j(r0, r3, r4, r14)
                r2 = r2 | 4
                goto L_0x00d8
            L_0x00c1:
                r5 = r4
                r3 = 2
                kotlinx.serialization.internal.v1 r4 = kotlinx.serialization.internal.v1.f57779a
                r3 = 1
                java.lang.Object r13 = r1.j(r0, r3, r4, r13)
                r2 = r2 | 2
                goto L_0x00d8
            L_0x00cd:
                r5 = r4
                r3 = 1
                kotlinx.serialization.internal.v1 r4 = kotlinx.serialization.internal.v1.f57779a
                r3 = 0
                java.lang.Object r12 = r1.j(r0, r3, r4, r12)
                r2 = r2 | 1
            L_0x00d8:
                r4 = r5
                goto L_0x00dd
            L_0x00da:
                r3 = 0
                r19 = r3
            L_0x00dd:
                r3 = 7
            L_0x00de:
                r5 = 5
                goto L_0x005c
            L_0x00e1:
                r3 = r8
                r4 = r9
                r5 = r11
                r11 = r13
                r9 = r14
                r8 = r2
                r2 = r6
                r6 = r15
            L_0x00e9:
                r1.c(r0)
                com.sumsub.sns.internal.core.data.source.applicant.remote.k r0 = new com.sumsub.sns.internal.core.data.source.applicant.remote.k
                r1 = r12
                java.lang.String r1 = (java.lang.String) r1
                java.lang.String r11 = (java.lang.String) r11
                r12 = r9
                java.lang.String r12 = (java.lang.String) r12
                java.lang.String r6 = (java.lang.String) r6
                r13 = r10
                java.lang.Boolean r13 = (java.lang.Boolean) r13
                r14 = r5
                java.lang.String r14 = (java.lang.String) r14
                r15 = r4
                java.lang.String r15 = (java.lang.String) r15
                r16 = r2
                java.lang.String r16 = (java.lang.String) r16
                r17 = r3
                java.util.List r17 = (java.util.List) r17
                r18 = 0
                r7 = r0
                r9 = r1
                r10 = r11
                r11 = r12
                r12 = r6
                r7.<init>((int) r8, (java.lang.String) r9, (java.lang.String) r10, (java.lang.String) r11, (java.lang.String) r12, (java.lang.Boolean) r13, (java.lang.String) r14, (java.lang.String) r15, (java.lang.String) r16, (java.util.List) r17, (kotlinx.serialization.internal.q1) r18)
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.sumsub.sns.internal.core.data.source.applicant.remote.k.a.deserialize(kotlinx.serialization.encoding.c):com.sumsub.sns.internal.core.data.source.applicant.remote.k");
        }

        public kotlinx.serialization.b<?>[] childSerializers() {
            v1 v1Var = v1.f57779a;
            return new kotlinx.serialization.b[]{h10.a.u(v1Var), h10.a.u(v1Var), h10.a.u(v1Var), h10.a.u(v1Var), h10.a.u(h.f57720a), h10.a.u(v1Var), h10.a.u(v1Var), h10.a.u(v1Var), h10.a.u(new e(r.a.f33207a))};
        }

        public kotlinx.serialization.descriptors.f getDescriptor() {
            return f33185b;
        }

        public kotlinx.serialization.b<?>[] typeParametersSerializers() {
            return d0.a.a(this);
        }

        /* renamed from: a */
        public void serialize(d dVar, k kVar) {
            kotlinx.serialization.descriptors.f descriptor = getDescriptor();
            kotlinx.serialization.encoding.b b11 = dVar.b(descriptor);
            k.a(kVar, b11, descriptor);
            b11.c(descriptor);
        }
    }

    public static final class b {
        public /* synthetic */ b(kotlin.jvm.internal.r rVar) {
            this();
        }

        public final kotlinx.serialization.b<k> serializer() {
            return a.f33184a;
        }

        public b() {
        }
    }

    public static final class c implements Parcelable.Creator<k> {
        /* renamed from: a */
        public final k createFromParcel(Parcel parcel) {
            Boolean bool;
            String readString = parcel.readString();
            String readString2 = parcel.readString();
            String readString3 = parcel.readString();
            String readString4 = parcel.readString();
            ArrayList arrayList = null;
            if (parcel.readInt() == 0) {
                bool = null;
            } else {
                bool = Boolean.valueOf(parcel.readInt() != 0);
            }
            String readString5 = parcel.readString();
            String readString6 = parcel.readString();
            String readString7 = parcel.readString();
            if (parcel.readInt() != 0) {
                int readInt = parcel.readInt();
                arrayList = new ArrayList(readInt);
                for (int i11 = 0; i11 != readInt; i11++) {
                    arrayList.add(r.CREATOR.createFromParcel(parcel));
                }
            }
            return new k(readString, readString2, readString3, readString4, bool, readString5, readString6, readString7, arrayList);
        }

        /* renamed from: a */
        public final k[] newArray(int i11) {
            return new k[i11];
        }
    }

    public k() {
        this((String) null, (String) null, (String) null, (String) null, (Boolean) null, (String) null, (String) null, (String) null, (List) null, 511, (kotlin.jvm.internal.r) null);
    }

    public static /* synthetic */ void A() {
    }

    public static /* synthetic */ void k() {
    }

    public static /* synthetic */ void m() {
    }

    public static /* synthetic */ void o() {
    }

    public static /* synthetic */ void q() {
    }

    public static /* synthetic */ void s() {
    }

    public static /* synthetic */ void u() {
    }

    public static /* synthetic */ void w() {
    }

    public static /* synthetic */ void y() {
    }

    public final String a() {
        return this.f33175a;
    }

    public final String b() {
        return this.f33176b;
    }

    public final String c() {
        return this.f33177c;
    }

    public final String d() {
        return this.f33178d;
    }

    public int describeContents() {
        return 0;
    }

    public final Boolean e() {
        return this.f33179e;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof k)) {
            return false;
        }
        k kVar = (k) obj;
        return x.b(this.f33175a, kVar.f33175a) && x.b(this.f33176b, kVar.f33176b) && x.b(this.f33177c, kVar.f33177c) && x.b(this.f33178d, kVar.f33178d) && x.b(this.f33179e, kVar.f33179e) && x.b(this.f33180f, kVar.f33180f) && x.b(this.f33181g, kVar.f33181g) && x.b(this.f33182h, kVar.f33182h) && x.b(this.f33183i, kVar.f33183i);
    }

    public final String f() {
        return this.f33180f;
    }

    public final String g() {
        return this.f33181g;
    }

    public final String h() {
        return this.f33182h;
    }

    public int hashCode() {
        String str = this.f33175a;
        int i11 = 0;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.f33176b;
        int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.f33177c;
        int hashCode3 = (hashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.f33178d;
        int hashCode4 = (hashCode3 + (str4 == null ? 0 : str4.hashCode())) * 31;
        Boolean bool = this.f33179e;
        int hashCode5 = (hashCode4 + (bool == null ? 0 : bool.hashCode())) * 31;
        String str5 = this.f33180f;
        int hashCode6 = (hashCode5 + (str5 == null ? 0 : str5.hashCode())) * 31;
        String str6 = this.f33181g;
        int hashCode7 = (hashCode6 + (str6 == null ? 0 : str6.hashCode())) * 31;
        String str7 = this.f33182h;
        int hashCode8 = (hashCode7 + (str7 == null ? 0 : str7.hashCode())) * 31;
        List<r> list = this.f33183i;
        if (list != null) {
            i11 = list.hashCode();
        }
        return hashCode8 + i11;
    }

    public final List<r> i() {
        return this.f33183i;
    }

    public final String j() {
        return this.f33182h;
    }

    public final String l() {
        return this.f33177c;
    }

    public final String n() {
        return this.f33180f;
    }

    public final String p() {
        return this.f33175a;
    }

    public final List<r> r() {
        return this.f33183i;
    }

    public final String t() {
        return this.f33181g;
    }

    public String toString() {
        return "Item(id=" + this.f33175a + ", title=" + this.f33176b + ", desc=" + this.f33177c + ", type=" + this.f33178d + ", required=" + this.f33179e + ", format=" + this.f33180f + ", placeholder=" + this.f33181g + ", condition=" + this.f33182h + ", options=" + this.f33183i + ')';
    }

    public final Boolean v() {
        return this.f33179e;
    }

    public void writeToParcel(Parcel parcel, int i11) {
        parcel.writeString(this.f33175a);
        parcel.writeString(this.f33176b);
        parcel.writeString(this.f33177c);
        parcel.writeString(this.f33178d);
        Boolean bool = this.f33179e;
        if (bool == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            parcel.writeInt(bool.booleanValue() ? 1 : 0);
        }
        parcel.writeString(this.f33180f);
        parcel.writeString(this.f33181g);
        parcel.writeString(this.f33182h);
        List<r> list = this.f33183i;
        if (list == null) {
            parcel.writeInt(0);
            return;
        }
        parcel.writeInt(1);
        parcel.writeInt(list.size());
        for (r writeToParcel : list) {
            writeToParcel.writeToParcel(parcel, i11);
        }
    }

    public final String x() {
        return this.f33176b;
    }

    public final String z() {
        return this.f33178d;
    }

    public /* synthetic */ k(int i11, String str, String str2, String str3, String str4, Boolean bool, String str5, String str6, String str7, List list, q1 q1Var) {
        if ((i11 & 0) != 0) {
            h1.a(i11, 0, a.f33184a.getDescriptor());
        }
        if ((i11 & 1) == 0) {
            this.f33175a = null;
        } else {
            this.f33175a = str;
        }
        if ((i11 & 2) == 0) {
            this.f33176b = null;
        } else {
            this.f33176b = str2;
        }
        if ((i11 & 4) == 0) {
            this.f33177c = null;
        } else {
            this.f33177c = str3;
        }
        if ((i11 & 8) == 0) {
            this.f33178d = null;
        } else {
            this.f33178d = str4;
        }
        if ((i11 & 16) == 0) {
            this.f33179e = null;
        } else {
            this.f33179e = bool;
        }
        if ((i11 & 32) == 0) {
            this.f33180f = null;
        } else {
            this.f33180f = str5;
        }
        if ((i11 & 64) == 0) {
            this.f33181g = null;
        } else {
            this.f33181g = str6;
        }
        if ((i11 & 128) == 0) {
            this.f33182h = null;
        } else {
            this.f33182h = str7;
        }
        if ((i11 & 256) == 0) {
            this.f33183i = CollectionsKt__CollectionsKt.k();
        } else {
            this.f33183i = list;
        }
    }

    public final k a(String str, String str2, String str3, String str4, Boolean bool, String str5, String str6, String str7, List<r> list) {
        return new k(str, str2, str3, str4, bool, str5, str6, str7, list);
    }

    public static /* synthetic */ k a(k kVar, String str, String str2, String str3, String str4, Boolean bool, String str5, String str6, String str7, List list, int i11, Object obj) {
        k kVar2 = kVar;
        int i12 = i11;
        return kVar.a((i12 & 1) != 0 ? kVar2.f33175a : str, (i12 & 2) != 0 ? kVar2.f33176b : str2, (i12 & 4) != 0 ? kVar2.f33177c : str3, (i12 & 8) != 0 ? kVar2.f33178d : str4, (i12 & 16) != 0 ? kVar2.f33179e : bool, (i12 & 32) != 0 ? kVar2.f33180f : str5, (i12 & 64) != 0 ? kVar2.f33181g : str6, (i12 & 128) != 0 ? kVar2.f33182h : str7, (i12 & 256) != 0 ? kVar2.f33183i : list);
    }

    public static final void a(k kVar, kotlinx.serialization.encoding.b bVar, kotlinx.serialization.descriptors.f fVar) {
        boolean z11 = false;
        if (bVar.q(fVar, 0) || kVar.f33175a != null) {
            bVar.y(fVar, 0, v1.f57779a, kVar.f33175a);
        }
        if (bVar.q(fVar, 1) || kVar.f33176b != null) {
            bVar.y(fVar, 1, v1.f57779a, kVar.f33176b);
        }
        if (bVar.q(fVar, 2) || kVar.f33177c != null) {
            bVar.y(fVar, 2, v1.f57779a, kVar.f33177c);
        }
        if (bVar.q(fVar, 3) || kVar.f33178d != null) {
            bVar.y(fVar, 3, v1.f57779a, kVar.f33178d);
        }
        if (bVar.q(fVar, 4) || kVar.f33179e != null) {
            bVar.y(fVar, 4, h.f57720a, kVar.f33179e);
        }
        if (bVar.q(fVar, 5) || kVar.f33180f != null) {
            bVar.y(fVar, 5, v1.f57779a, kVar.f33180f);
        }
        if (bVar.q(fVar, 6) || kVar.f33181g != null) {
            bVar.y(fVar, 6, v1.f57779a, kVar.f33181g);
        }
        if (bVar.q(fVar, 7) || kVar.f33182h != null) {
            bVar.y(fVar, 7, v1.f57779a, kVar.f33182h);
        }
        if (bVar.q(fVar, 8) || !x.b(kVar.f33183i, CollectionsKt__CollectionsKt.k())) {
            z11 = true;
        }
        if (z11) {
            bVar.y(fVar, 8, new e(r.a.f33207a), kVar.f33183i);
        }
    }

    public k(String str, String str2, String str3, String str4, Boolean bool, String str5, String str6, String str7, List<r> list) {
        this.f33175a = str;
        this.f33176b = str2;
        this.f33177c = str3;
        this.f33178d = str4;
        this.f33179e = bool;
        this.f33180f = str5;
        this.f33181g = str6;
        this.f33182h = str7;
        this.f33183i = list;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ k(java.lang.String r11, java.lang.String r12, java.lang.String r13, java.lang.String r14, java.lang.Boolean r15, java.lang.String r16, java.lang.String r17, java.lang.String r18, java.util.List r19, int r20, kotlin.jvm.internal.r r21) {
        /*
            r10 = this;
            r0 = r20
            r1 = r0 & 1
            r2 = 0
            if (r1 == 0) goto L_0x0009
            r1 = r2
            goto L_0x000a
        L_0x0009:
            r1 = r11
        L_0x000a:
            r3 = r0 & 2
            if (r3 == 0) goto L_0x0010
            r3 = r2
            goto L_0x0011
        L_0x0010:
            r3 = r12
        L_0x0011:
            r4 = r0 & 4
            if (r4 == 0) goto L_0x0017
            r4 = r2
            goto L_0x0018
        L_0x0017:
            r4 = r13
        L_0x0018:
            r5 = r0 & 8
            if (r5 == 0) goto L_0x001e
            r5 = r2
            goto L_0x001f
        L_0x001e:
            r5 = r14
        L_0x001f:
            r6 = r0 & 16
            if (r6 == 0) goto L_0x0025
            r6 = r2
            goto L_0x0026
        L_0x0025:
            r6 = r15
        L_0x0026:
            r7 = r0 & 32
            if (r7 == 0) goto L_0x002c
            r7 = r2
            goto L_0x002e
        L_0x002c:
            r7 = r16
        L_0x002e:
            r8 = r0 & 64
            if (r8 == 0) goto L_0x0034
            r8 = r2
            goto L_0x0036
        L_0x0034:
            r8 = r17
        L_0x0036:
            r9 = r0 & 128(0x80, float:1.794E-43)
            if (r9 == 0) goto L_0x003b
            goto L_0x003d
        L_0x003b:
            r2 = r18
        L_0x003d:
            r0 = r0 & 256(0x100, float:3.59E-43)
            if (r0 == 0) goto L_0x0046
            java.util.List r0 = kotlin.collections.CollectionsKt__CollectionsKt.k()
            goto L_0x0048
        L_0x0046:
            r0 = r19
        L_0x0048:
            r11 = r10
            r12 = r1
            r13 = r3
            r14 = r4
            r15 = r5
            r16 = r6
            r17 = r7
            r18 = r8
            r19 = r2
            r20 = r0
            r11.<init>(r12, r13, r14, r15, r16, r17, r18, r19, r20)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sumsub.sns.internal.core.data.source.applicant.remote.k.<init>(java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.Boolean, java.lang.String, java.lang.String, java.lang.String, java.util.List, int, kotlin.jvm.internal.r):void");
    }
}
