package com.sumsub.sns.internal.core.presentation.form;

import android.content.Context;
import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import com.sumsub.sns.internal.core.presentation.form.model.FormItem;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.r;
import kotlin.jvm.internal.x;
import kotlinx.coroutines.flow.j1;

public interface b {

    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        public final int f33718a;

        /* renamed from: b  reason: collision with root package name */
        public final List<C0375b> f33719b;

        /* renamed from: c  reason: collision with root package name */
        public final String f33720c;

        /* renamed from: d  reason: collision with root package name */
        public final c f33721d;

        public a(int i11, List<C0375b> list, String str, c cVar) {
            this.f33718a = i11;
            this.f33719b = list;
            this.f33720c = str;
            this.f33721d = cVar;
        }

        public final int a() {
            return this.f33718a;
        }

        public final List<C0375b> b() {
            return this.f33719b;
        }

        public final String c() {
            return this.f33720c;
        }

        public final c d() {
            return this.f33721d;
        }

        public final C0375b e() {
            return (C0375b) CollectionsKt___CollectionsKt.d0(this.f33719b, this.f33718a);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            return this.f33718a == aVar.f33718a && x.b(this.f33719b, aVar.f33719b) && x.b(this.f33720c, aVar.f33720c) && x.b(this.f33721d, aVar.f33721d);
        }

        public final int f() {
            return this.f33718a;
        }

        public final String g() {
            return this.f33720c;
        }

        public final List<C0375b> h() {
            return this.f33719b;
        }

        public int hashCode() {
            int hashCode = ((this.f33718a * 31) + this.f33719b.hashCode()) * 31;
            String str = this.f33720c;
            int i11 = 0;
            int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
            c cVar = this.f33721d;
            if (cVar != null) {
                i11 = cVar.hashCode();
            }
            return hashCode2 + i11;
        }

        public final c i() {
            return this.f33721d;
        }

        public String toString() {
            return "FormViewState(currentPageIndex=" + this.f33718a + ", pages=" + this.f33719b + ", mimeTypes=" + this.f33720c + ", validationStrings=" + this.f33721d + ')';
        }

        public final a a(int i11, List<C0375b> list, String str, c cVar) {
            return new a(i11, list, str, cVar);
        }

        public static /* synthetic */ a a(a aVar, int i11, List<C0375b> list, String str, c cVar, int i12, Object obj) {
            if ((i12 & 1) != 0) {
                i11 = aVar.f33718a;
            }
            if ((i12 & 2) != 0) {
                list = aVar.f33719b;
            }
            if ((i12 & 4) != 0) {
                str = aVar.f33720c;
            }
            if ((i12 & 8) != 0) {
                cVar = aVar.f33721d;
            }
            return aVar.a(i11, list, str, cVar);
        }
    }

    /* renamed from: com.sumsub.sns.internal.core.presentation.form.b$b  reason: collision with other inner class name */
    public static final class C0375b implements Parcelable {
        public static final Parcelable.Creator<C0375b> CREATOR = new a();

        /* renamed from: a  reason: collision with root package name */
        public final int f33722a;

        /* renamed from: b  reason: collision with root package name */
        public final String f33723b;

        /* renamed from: c  reason: collision with root package name */
        public final String f33724c;

        /* renamed from: d  reason: collision with root package name */
        public final List<FormItem> f33725d;

        /* renamed from: com.sumsub.sns.internal.core.presentation.form.b$b$a */
        public static final class a implements Parcelable.Creator<C0375b> {
            /* renamed from: a */
            public final C0375b createFromParcel(Parcel parcel) {
                int readInt = parcel.readInt();
                String readString = parcel.readString();
                String readString2 = parcel.readString();
                int readInt2 = parcel.readInt();
                ArrayList arrayList = new ArrayList(readInt2);
                for (int i11 = 0; i11 != readInt2; i11++) {
                    arrayList.add(parcel.readParcelable(C0375b.class.getClassLoader()));
                }
                return new C0375b(readInt, readString, readString2, arrayList);
            }

            /* renamed from: a */
            public final C0375b[] newArray(int i11) {
                return new C0375b[i11];
            }
        }

        public C0375b(int i11, String str, String str2, List<? extends FormItem> list) {
            this.f33722a = i11;
            this.f33723b = str;
            this.f33724c = str2;
            this.f33725d = list;
        }

        public final int a() {
            return this.f33722a;
        }

        public final String b() {
            return this.f33723b;
        }

        public final String c() {
            return this.f33724c;
        }

        public final List<FormItem> d() {
            return this.f33725d;
        }

        public int describeContents() {
            return 0;
        }

        public final int e() {
            return this.f33722a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof C0375b)) {
                return false;
            }
            C0375b bVar = (C0375b) obj;
            return this.f33722a == bVar.f33722a && x.b(this.f33723b, bVar.f33723b) && x.b(this.f33724c, bVar.f33724c) && x.b(this.f33725d, bVar.f33725d);
        }

        public final List<FormItem> f() {
            return this.f33725d;
        }

        public final String g() {
            return this.f33724c;
        }

        public final String h() {
            return this.f33723b;
        }

        public int hashCode() {
            int i11 = this.f33722a * 31;
            String str = this.f33723b;
            int i12 = 0;
            int hashCode = (i11 + (str == null ? 0 : str.hashCode())) * 31;
            String str2 = this.f33724c;
            if (str2 != null) {
                i12 = str2.hashCode();
            }
            return ((hashCode + i12) * 31) + this.f33725d.hashCode();
        }

        public String toString() {
            return "Page(index=" + this.f33722a + ", title=" + this.f33723b + ", subtitle=" + this.f33724c + ", items=" + this.f33725d + ')';
        }

        public void writeToParcel(Parcel parcel, int i11) {
            parcel.writeInt(this.f33722a);
            parcel.writeString(this.f33723b);
            parcel.writeString(this.f33724c);
            List<FormItem> list = this.f33725d;
            parcel.writeInt(list.size());
            for (FormItem writeParcelable : list) {
                parcel.writeParcelable(writeParcelable, i11);
            }
        }

        public final C0375b a(int i11, String str, String str2, List<? extends FormItem> list) {
            return new C0375b(i11, str, str2, list);
        }

        public static /* synthetic */ C0375b a(C0375b bVar, int i11, String str, String str2, List<FormItem> list, int i12, Object obj) {
            if ((i12 & 1) != 0) {
                i11 = bVar.f33722a;
            }
            if ((i12 & 2) != 0) {
                str = bVar.f33723b;
            }
            if ((i12 & 4) != 0) {
                str2 = bVar.f33724c;
            }
            if ((i12 & 8) != 0) {
                list = bVar.f33725d;
            }
            return bVar.a(i11, str, str2, list);
        }
    }

    public static final class c {

        /* renamed from: a  reason: collision with root package name */
        public final String f33726a;

        /* renamed from: b  reason: collision with root package name */
        public final String f33727b;

        public c() {
            this((String) null, (String) null, 3, (r) null);
        }

        public final String a() {
            return this.f33726a;
        }

        public final String b() {
            return this.f33727b;
        }

        public final String c() {
            return this.f33727b;
        }

        public final String d() {
            return this.f33726a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof c)) {
                return false;
            }
            c cVar = (c) obj;
            return x.b(this.f33726a, cVar.f33726a) && x.b(this.f33727b, cVar.f33727b);
        }

        public int hashCode() {
            String str = this.f33726a;
            int i11 = 0;
            int hashCode = (str == null ? 0 : str.hashCode()) * 31;
            String str2 = this.f33727b;
            if (str2 != null) {
                i11 = str2.hashCode();
            }
            return hashCode + i11;
        }

        public String toString() {
            return "ValidationStrings(isRequired=" + this.f33726a + ", isNotValid=" + this.f33727b + ')';
        }

        public c(String str, String str2) {
            this.f33726a = str;
            this.f33727b = str2;
        }

        public final c a(String str, String str2) {
            return new c(str, str2);
        }

        public static /* synthetic */ c a(c cVar, String str, String str2, int i11, Object obj) {
            if ((i11 & 1) != 0) {
                str = cVar.f33726a;
            }
            if ((i11 & 2) != 0) {
                str2 = cVar.f33727b;
            }
            return cVar.a(str, str2);
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ c(String str, String str2, int i11, r rVar) {
            this((i11 & 1) != 0 ? null : str, (i11 & 2) != 0 ? null : str2);
        }
    }

    d a();

    void a(Context context, FieldId fieldId, List<? extends Uri> list);

    void a(FormItem formItem, String str);

    void a(FormItem formItem, List<String> list);

    j1<a> b();

    void b(FormItem formItem, String str);
}
