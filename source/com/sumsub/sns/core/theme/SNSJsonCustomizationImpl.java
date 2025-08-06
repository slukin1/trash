package com.sumsub.sns.core.theme;

import android.content.Context;
import com.sumsub.log.logger.a;
import com.sumsub.sns.internal.core.theme.d;
import com.sumsub.sns.internal.log.b;
import com.sumsub.sns.internal.log.c;
import java.util.Map;
import kotlin.Metadata;

@Metadata(bv = {}, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0015\u0010\u0016J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J \u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\nH\u0016J$\u0010\u0005\u001a\u00020\u00042\u0012\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\r0\f2\u0006\u0010\u000b\u001a\u00020\nH\u0016J\u0010\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u000fH\u0016J\n\u0010\u0013\u001a\u0004\u0018\u00010\u0012H\u0016R\u0018\u0010\u0003\u001a\u0004\u0018\u00010\u00128\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0003\u0010\u0014¨\u0006\u0017"}, d2 = {"Lcom/sumsub/sns/core/theme/SNSJsonCustomizationImpl;", "Lcom/sumsub/sns/core/theme/SNSJsonCustomization;", "Lcom/sumsub/sns/core/theme/SNSTheme;", "theme", "", "loadTheme", "Lkotlinx/serialization/json/a;", "json", "", "jsonString", "Lcom/sumsub/sns/core/theme/SNSCustomizationFileFormat;", "format", "", "", "map", "Landroid/content/Context;", "context", "loadResources", "Lcom/sumsub/sns/internal/core/theme/d;", "getTheme", "Lcom/sumsub/sns/internal/core/theme/d;", "<init>", "()V", "idensic-mobile-sdk-aar_release"}, k = 1, mv = {1, 7, 1})
public final class SNSJsonCustomizationImpl implements SNSJsonCustomization {
    private d theme;

    public void loadResources(Context context) {
        d dVar = this.theme;
        if (dVar != null) {
            dVar.a(context);
        }
    }

    public void loadTheme(SNSTheme sNSTheme) {
        a.a(com.sumsub.sns.internal.log.a.f34862a, c.a(this), "Loading native theme", (Throwable) null, 4, (Object) null);
        this.theme = d.f34050f.a(sNSTheme);
    }

    public d getTheme() {
        return this.theme;
    }

    public void loadTheme(kotlinx.serialization.json.a aVar, String str, SNSCustomizationFileFormat sNSCustomizationFileFormat) {
        a.a(com.sumsub.sns.internal.log.a.f34862a, c.a(this), "Loading JSON theme", (Throwable) null, 4, (Object) null);
        try {
            this.theme = d.f34050f.a(aVar, str, sNSCustomizationFileFormat);
        } catch (Exception unused) {
            com.sumsub.sns.internal.log.a aVar2 = com.sumsub.sns.internal.log.a.f34862a;
            String a11 = c.a(this);
            b.b(aVar2, a11, "Can't parse theme " + aVar, (Throwable) null, 4, (Object) null);
        }
    }

    public void loadTheme(Map<String, ? extends Object> map, SNSCustomizationFileFormat sNSCustomizationFileFormat) {
        a.a(com.sumsub.sns.internal.log.a.f34862a, c.a(this), "Loading theme from map", (Throwable) null, 4, (Object) null);
        this.theme = d.f34050f.a(map, sNSCustomizationFileFormat);
    }
}
