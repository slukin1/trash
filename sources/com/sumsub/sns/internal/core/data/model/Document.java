package com.sumsub.sns.internal.core.data.model;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Keep;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.x;

@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u000f\b\b\u0018\u00002\u00020\u0001:\u0001+B\u0019\u0012\u0006\u0010\u0006\u001a\u00020\u0002\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b)\u0010*J\t\u0010\u0003\u001a\u00020\u0002HÆ\u0003J\u000b\u0010\u0005\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u001f\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0006\u001a\u00020\u00022\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0004HÆ\u0001J\t\u0010\n\u001a\u00020\tHÖ\u0001J\t\u0010\f\u001a\u00020\u000bHÖ\u0001J\u0013\u0010\u0010\u001a\u00020\u000f2\b\u0010\u000e\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u0011\u001a\u00020\u000bHÖ\u0001J\u0019\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\u000bHÖ\u0001R\u0017\u0010\u0006\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019R\u0019\u0010\u0007\u001a\u0004\u0018\u00010\u00048\u0006¢\u0006\f\n\u0004\b\u0007\u0010\u001a\u001a\u0004\b\u001b\u0010\u001cR\u0013\u0010 \u001a\u0004\u0018\u00010\u001d8F¢\u0006\u0006\u001a\u0004\b\u001e\u0010\u001fR\u0013\u0010#\u001a\u0004\u0018\u00010\t8F¢\u0006\u0006\u001a\u0004\b!\u0010\"R\u0011\u0010$\u001a\u00020\u000f8F¢\u0006\u0006\u001a\u0004\b$\u0010%R\u0011\u0010&\u001a\u00020\u000f8F¢\u0006\u0006\u001a\u0004\b&\u0010%R\u0011\u0010'\u001a\u00020\u000f8F¢\u0006\u0006\u001a\u0004\b'\u0010%R\u0011\u0010(\u001a\u00020\u000f8F¢\u0006\u0006\u001a\u0004\b(\u0010%¨\u0006,"}, d2 = {"Lcom/sumsub/sns/internal/core/data/model/Document;", "Landroid/os/Parcelable;", "Lcom/sumsub/sns/internal/core/data/model/DocumentType;", "component1", "Lcom/sumsub/sns/internal/core/data/model/Document$b;", "component2", "type", "result", "copy", "", "toString", "", "hashCode", "", "other", "", "equals", "describeContents", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "Lcom/sumsub/sns/internal/core/data/model/DocumentType;", "getType", "()Lcom/sumsub/sns/internal/core/data/model/DocumentType;", "Lcom/sumsub/sns/internal/core/data/model/Document$b;", "getResult", "()Lcom/sumsub/sns/internal/core/data/model/Document$b;", "Lcom/sumsub/sns/internal/core/data/model/Document$b$b;", "getReview", "()Lcom/sumsub/sns/internal/core/data/model/Document$b$b;", "review", "getCountry", "()Ljava/lang/String;", "country", "isRejected", "()Z", "isApproved", "isSubmitted", "isReviewing", "<init>", "(Lcom/sumsub/sns/internal/core/data/model/DocumentType;Lcom/sumsub/sns/internal/core/data/model/Document$b;)V", "b", "idensic-mobile-sdk-aar_release"}, k = 1, mv = {1, 7, 1})
@Keep
public final class Document implements Parcelable {
    public static final Parcelable.Creator<Document> CREATOR = new a();
    private final b result;
    private final DocumentType type;

    public static final class a implements Parcelable.Creator<Document> {
        /* renamed from: a */
        public final Document createFromParcel(Parcel parcel) {
            return new Document(DocumentType.CREATOR.createFromParcel(parcel), parcel.readInt() == 0 ? null : b.CREATOR.createFromParcel(parcel));
        }

        /* renamed from: a */
        public final Document[] newArray(int i11) {
            return new Document[i11];
        }
    }

    public static final class b implements Parcelable {
        public static final Parcelable.Creator<b> CREATOR = new a();

        /* renamed from: a  reason: collision with root package name */
        public final C0329b f32338a;

        /* renamed from: b  reason: collision with root package name */
        public final String f32339b;

        /* renamed from: c  reason: collision with root package name */
        public final String f32340c;

        /* renamed from: d  reason: collision with root package name */
        public final List<Integer> f32341d;

        /* renamed from: e  reason: collision with root package name */
        public final Map<Integer, C0329b> f32342e;

        public static final class a implements Parcelable.Creator<b> {
            /* renamed from: a */
            public final b createFromParcel(Parcel parcel) {
                ArrayList arrayList;
                LinkedHashMap linkedHashMap = null;
                C0329b createFromParcel = parcel.readInt() == 0 ? null : C0329b.CREATOR.createFromParcel(parcel);
                String readString = parcel.readString();
                String readString2 = parcel.readString();
                if (parcel.readInt() == 0) {
                    arrayList = null;
                } else {
                    int readInt = parcel.readInt();
                    arrayList = new ArrayList(readInt);
                    for (int i11 = 0; i11 != readInt; i11++) {
                        arrayList.add(Integer.valueOf(parcel.readInt()));
                    }
                }
                if (parcel.readInt() != 0) {
                    int readInt2 = parcel.readInt();
                    linkedHashMap = new LinkedHashMap(readInt2);
                    for (int i12 = 0; i12 != readInt2; i12++) {
                        linkedHashMap.put(Integer.valueOf(parcel.readInt()), C0329b.CREATOR.createFromParcel(parcel));
                    }
                }
                return new b(createFromParcel, readString, readString2, arrayList, linkedHashMap);
            }

            /* renamed from: a */
            public final b[] newArray(int i11) {
                return new b[i11];
            }
        }

        /* renamed from: com.sumsub.sns.internal.core.data.model.Document$b$b  reason: collision with other inner class name */
        public static final class C0329b implements Parcelable {
            public static final Parcelable.Creator<C0329b> CREATOR = new a();

            /* renamed from: a  reason: collision with root package name */
            public final ReviewAnswerType f32343a;

            /* renamed from: b  reason: collision with root package name */
            public final String f32344b;

            /* renamed from: c  reason: collision with root package name */
            public final String f32345c;

            /* renamed from: d  reason: collision with root package name */
            public final List<String> f32346d;

            /* renamed from: com.sumsub.sns.internal.core.data.model.Document$b$b$a */
            public static final class a implements Parcelable.Creator<C0329b> {
                /* renamed from: a */
                public final C0329b createFromParcel(Parcel parcel) {
                    return new C0329b(parcel.readInt() == 0 ? null : ReviewAnswerType.valueOf(parcel.readString()), parcel.readString(), parcel.readString(), parcel.createStringArrayList());
                }

                /* renamed from: a */
                public final C0329b[] newArray(int i11) {
                    return new C0329b[i11];
                }
            }

            public C0329b(ReviewAnswerType reviewAnswerType, String str, String str2, List<String> list) {
                this.f32343a = reviewAnswerType;
                this.f32344b = str;
                this.f32345c = str2;
                this.f32346d = list;
            }

            public final ReviewAnswerType a() {
                return this.f32343a;
            }

            public final String b() {
                return this.f32344b;
            }

            public final String c() {
                return this.f32345c;
            }

            public final List<String> d() {
                return this.f32346d;
            }

            public int describeContents() {
                return 0;
            }

            public final ReviewAnswerType e() {
                return this.f32343a;
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (!(obj instanceof C0329b)) {
                    return false;
                }
                C0329b bVar = (C0329b) obj;
                return this.f32343a == bVar.f32343a && x.b(this.f32344b, bVar.f32344b) && x.b(this.f32345c, bVar.f32345c) && x.b(this.f32346d, bVar.f32346d);
            }

            public final String f() {
                return this.f32345c;
            }

            public final String g() {
                return this.f32344b;
            }

            public final List<String> h() {
                return this.f32346d;
            }

            public int hashCode() {
                ReviewAnswerType reviewAnswerType = this.f32343a;
                int i11 = 0;
                int hashCode = (reviewAnswerType == null ? 0 : reviewAnswerType.hashCode()) * 31;
                String str = this.f32344b;
                int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
                String str2 = this.f32345c;
                int hashCode3 = (hashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
                List<String> list = this.f32346d;
                if (list != null) {
                    i11 = list.hashCode();
                }
                return hashCode3 + i11;
            }

            public String toString() {
                return "Review(answer=" + this.f32343a + ", moderationComment=" + this.f32344b + ", clientComment=" + this.f32345c + ", rejectLabels=" + this.f32346d + ')';
            }

            public void writeToParcel(Parcel parcel, int i11) {
                ReviewAnswerType reviewAnswerType = this.f32343a;
                if (reviewAnswerType == null) {
                    parcel.writeInt(0);
                } else {
                    parcel.writeInt(1);
                    parcel.writeString(reviewAnswerType.name());
                }
                parcel.writeString(this.f32344b);
                parcel.writeString(this.f32345c);
                parcel.writeStringList(this.f32346d);
            }

            public final C0329b a(ReviewAnswerType reviewAnswerType, String str, String str2, List<String> list) {
                return new C0329b(reviewAnswerType, str, str2, list);
            }

            public static /* synthetic */ C0329b a(C0329b bVar, ReviewAnswerType reviewAnswerType, String str, String str2, List<String> list, int i11, Object obj) {
                if ((i11 & 1) != 0) {
                    reviewAnswerType = bVar.f32343a;
                }
                if ((i11 & 2) != 0) {
                    str = bVar.f32344b;
                }
                if ((i11 & 4) != 0) {
                    str2 = bVar.f32345c;
                }
                if ((i11 & 8) != 0) {
                    list = bVar.f32346d;
                }
                return bVar.a(reviewAnswerType, str, str2, list);
            }
        }

        public b(C0329b bVar, String str, String str2, List<Integer> list, Map<Integer, C0329b> map) {
            this.f32338a = bVar;
            this.f32339b = str;
            this.f32340c = str2;
            this.f32341d = list;
            this.f32342e = map;
        }

        public final C0329b a() {
            return this.f32338a;
        }

        public final String b() {
            return this.f32339b;
        }

        public final String c() {
            return this.f32340c;
        }

        public final List<Integer> d() {
            return this.f32341d;
        }

        public int describeContents() {
            return 0;
        }

        public final Map<Integer, C0329b> e() {
            return this.f32342e;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof b)) {
                return false;
            }
            b bVar = (b) obj;
            return x.b(this.f32338a, bVar.f32338a) && x.b(this.f32339b, bVar.f32339b) && x.b(this.f32340c, bVar.f32340c) && x.b(this.f32341d, bVar.f32341d) && x.b(this.f32342e, bVar.f32342e);
        }

        public final String f() {
            return this.f32339b;
        }

        public final String g() {
            return this.f32340c;
        }

        public final List<Integer> h() {
            return this.f32341d;
        }

        public int hashCode() {
            C0329b bVar = this.f32338a;
            int i11 = 0;
            int hashCode = (bVar == null ? 0 : bVar.hashCode()) * 31;
            String str = this.f32339b;
            int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
            String str2 = this.f32340c;
            int hashCode3 = (hashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
            List<Integer> list = this.f32341d;
            int hashCode4 = (hashCode3 + (list == null ? 0 : list.hashCode())) * 31;
            Map<Integer, C0329b> map = this.f32342e;
            if (map != null) {
                i11 = map.hashCode();
            }
            return hashCode4 + i11;
        }

        public final Map<Integer, C0329b> i() {
            return this.f32342e;
        }

        public final C0329b j() {
            return this.f32338a;
        }

        public String toString() {
            return "Result(review=" + this.f32338a + ", country=" + this.f32339b + ", identity=" + this.f32340c + ", imageIds=" + this.f32341d + ", imageResult=" + this.f32342e + ')';
        }

        public void writeToParcel(Parcel parcel, int i11) {
            C0329b bVar = this.f32338a;
            if (bVar == null) {
                parcel.writeInt(0);
            } else {
                parcel.writeInt(1);
                bVar.writeToParcel(parcel, i11);
            }
            parcel.writeString(this.f32339b);
            parcel.writeString(this.f32340c);
            List<Integer> list = this.f32341d;
            if (list == null) {
                parcel.writeInt(0);
            } else {
                parcel.writeInt(1);
                parcel.writeInt(list.size());
                for (Integer intValue : list) {
                    parcel.writeInt(intValue.intValue());
                }
            }
            Map<Integer, C0329b> map = this.f32342e;
            if (map == null) {
                parcel.writeInt(0);
                return;
            }
            parcel.writeInt(1);
            parcel.writeInt(map.size());
            for (Map.Entry next : map.entrySet()) {
                parcel.writeInt(((Number) next.getKey()).intValue());
                ((C0329b) next.getValue()).writeToParcel(parcel, i11);
            }
        }

        public final b a(C0329b bVar, String str, String str2, List<Integer> list, Map<Integer, C0329b> map) {
            return new b(bVar, str, str2, list, map);
        }

        public static /* synthetic */ b a(b bVar, C0329b bVar2, String str, String str2, List<Integer> list, Map<Integer, C0329b> map, int i11, Object obj) {
            if ((i11 & 1) != 0) {
                bVar2 = bVar.f32338a;
            }
            if ((i11 & 2) != 0) {
                str = bVar.f32339b;
            }
            String str3 = str;
            if ((i11 & 4) != 0) {
                str2 = bVar.f32340c;
            }
            String str4 = str2;
            if ((i11 & 8) != 0) {
                list = bVar.f32341d;
            }
            List<Integer> list2 = list;
            if ((i11 & 16) != 0) {
                map = bVar.f32342e;
            }
            return bVar.a(bVar2, str3, str4, list2, map);
        }
    }

    public Document(DocumentType documentType, b bVar) {
        this.type = documentType;
        this.result = bVar;
    }

    public static /* synthetic */ Document copy$default(Document document, DocumentType documentType, b bVar, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            documentType = document.type;
        }
        if ((i11 & 2) != 0) {
            bVar = document.result;
        }
        return document.copy(documentType, bVar);
    }

    public final DocumentType component1() {
        return this.type;
    }

    public final b component2() {
        return this.result;
    }

    public final Document copy(DocumentType documentType, b bVar) {
        return new Document(documentType, bVar);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Document)) {
            return false;
        }
        Document document = (Document) obj;
        return x.b(this.type, document.type) && x.b(this.result, document.result);
    }

    public final String getCountry() {
        b bVar = this.result;
        if (bVar != null) {
            return bVar.f();
        }
        return null;
    }

    public final b getResult() {
        return this.result;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0005, code lost:
        r0 = r0.j();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.sumsub.sns.internal.core.data.model.Document.b.C0329b getReview() {
        /*
            r4 = this;
            com.sumsub.sns.internal.core.data.model.Document$b r0 = r4.result
            r1 = 0
            if (r0 == 0) goto L_0x0010
            com.sumsub.sns.internal.core.data.model.Document$b$b r0 = r0.j()
            if (r0 == 0) goto L_0x0010
            com.sumsub.sns.internal.core.data.model.ReviewAnswerType r0 = r0.e()
            goto L_0x0011
        L_0x0010:
            r0 = r1
        L_0x0011:
            if (r0 == 0) goto L_0x001a
            com.sumsub.sns.internal.core.data.model.Document$b r0 = r4.result
            com.sumsub.sns.internal.core.data.model.Document$b$b r0 = r0.j()
            return r0
        L_0x001a:
            com.sumsub.sns.internal.core.data.model.Document$b r0 = r4.result
            if (r0 == 0) goto L_0x0049
            java.util.Map r0 = r0.i()
            if (r0 == 0) goto L_0x0049
            java.util.Collection r0 = r0.values()
            if (r0 == 0) goto L_0x0049
            java.util.Iterator r0 = r0.iterator()
        L_0x002e:
            boolean r2 = r0.hasNext()
            if (r2 == 0) goto L_0x0047
            java.lang.Object r2 = r0.next()
            r3 = r2
            com.sumsub.sns.internal.core.data.model.Document$b$b r3 = (com.sumsub.sns.internal.core.data.model.Document.b.C0329b) r3
            com.sumsub.sns.internal.core.data.model.ReviewAnswerType r3 = r3.e()
            if (r3 == 0) goto L_0x0043
            r3 = 1
            goto L_0x0044
        L_0x0043:
            r3 = 0
        L_0x0044:
            if (r3 == 0) goto L_0x002e
            r1 = r2
        L_0x0047:
            com.sumsub.sns.internal.core.data.model.Document$b$b r1 = (com.sumsub.sns.internal.core.data.model.Document.b.C0329b) r1
        L_0x0049:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sumsub.sns.internal.core.data.model.Document.getReview():com.sumsub.sns.internal.core.data.model.Document$b$b");
    }

    public final DocumentType getType() {
        return this.type;
    }

    public int hashCode() {
        int hashCode = this.type.hashCode() * 31;
        b bVar = this.result;
        return hashCode + (bVar == null ? 0 : bVar.hashCode());
    }

    public final boolean isApproved() {
        b.C0329b j11;
        Map<Integer, b.C0329b> i11;
        Collection<b.C0329b> values;
        boolean z11;
        b bVar = this.result;
        if (bVar == null || (i11 = bVar.i()) == null || (values = i11.values()) == null) {
            b bVar2 = this.result;
            if (bVar2 != null && (j11 = bVar2.j()) != null && j11.e() == ReviewAnswerType.Green) {
                return true;
            }
        } else if (values.isEmpty()) {
            return true;
        } else {
            for (b.C0329b e11 : values) {
                if (e11.e() == ReviewAnswerType.Green) {
                    z11 = true;
                    continue;
                } else {
                    z11 = false;
                    continue;
                }
                if (!z11) {
                }
            }
            return true;
        }
        return false;
    }

    public final boolean isRejected() {
        b.C0329b j11;
        Map<Integer, b.C0329b> i11;
        Collection<b.C0329b> values;
        boolean z11;
        b bVar = this.result;
        if (bVar == null || (i11 = bVar.i()) == null || (values = i11.values()) == null) {
            b bVar2 = this.result;
            if (!(bVar2 == null || (j11 = bVar2.j()) == null || j11.e() != ReviewAnswerType.Red)) {
                return true;
            }
        } else if (!values.isEmpty()) {
            for (b.C0329b e11 : values) {
                if (e11.e() == ReviewAnswerType.Red) {
                    z11 = true;
                    continue;
                } else {
                    z11 = false;
                    continue;
                }
                if (z11) {
                    return true;
                }
            }
        }
        return false;
    }

    public final boolean isReviewing() {
        Map<Integer, b.C0329b> i11;
        Collection<b.C0329b> values;
        boolean z11;
        b bVar = this.result;
        if (!(bVar == null || (i11 = bVar.i()) == null || (values = i11.values()) == null || values.isEmpty())) {
            for (b.C0329b e11 : values) {
                if (e11.e() == null) {
                    z11 = true;
                    continue;
                } else {
                    z11 = false;
                    continue;
                }
                if (z11) {
                    return true;
                }
            }
        }
        return false;
    }

    public final boolean isSubmitted() {
        b bVar = this.result;
        return (bVar != null ? bVar.j() : null) != null;
    }

    public String toString() {
        return "Document(type=" + this.type + ", result=" + this.result + ')';
    }

    public void writeToParcel(Parcel parcel, int i11) {
        this.type.writeToParcel(parcel, i11);
        b bVar = this.result;
        if (bVar == null) {
            parcel.writeInt(0);
            return;
        }
        parcel.writeInt(1);
        bVar.writeToParcel(parcel, i11);
    }
}
