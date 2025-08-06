package com.sumsub.sns.internal.core.common;

import android.nfc.tech.IsoDep;
import android.os.Parcelable;
import com.sumsub.sns.internal.core.data.model.Document;
import com.sumsub.sns.internal.core.data.model.DocumentType;
import com.sumsub.sns.internal.core.data.model.o;
import com.sumsub.sns.internal.core.data.model.s;
import com.sumsub.sns.internal.core.domain.model.c;
import d10.l;
import java.io.File;
import kotlin.Unit;

public interface k0 {
    void a();

    void a(Document document);

    void a(DocumentType documentType);

    void a(o oVar);

    void a(s sVar);

    void a(c cVar, Parcelable parcelable);

    void a(l<? super IsoDep, Unit> lVar);

    void a(File file, int i11, String str, String str2);

    void a(String str);

    void a(String str, String str2);

    void a(boolean z11);

    void b();

    void b(o oVar);

    void c();
}
