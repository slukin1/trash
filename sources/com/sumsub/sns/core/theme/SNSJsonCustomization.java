package com.sumsub.sns.core.theme;

import android.content.Context;
import d10.a;
import java.util.Map;
import kotlin.Metadata;

@Metadata(bv = {}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u0000 \u00132\u00020\u0001:\u0001\u0013J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&J \u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\nH&J$\u0010\u0005\u001a\u00020\u00042\u0012\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00010\f2\u0006\u0010\u000b\u001a\u00020\nH&J\u0010\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u000eH&J\n\u0010\u0012\u001a\u0004\u0018\u00010\u0011H&ø\u0001\u0000\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0014À\u0006\u0001"}, d2 = {"Lcom/sumsub/sns/core/theme/SNSJsonCustomization;", "", "Lcom/sumsub/sns/core/theme/SNSTheme;", "theme", "", "loadTheme", "Lkotlinx/serialization/json/a;", "json", "", "jsonString", "Lcom/sumsub/sns/core/theme/SNSCustomizationFileFormat;", "format", "", "map", "Landroid/content/Context;", "context", "loadResources", "Lcom/sumsub/sns/core/theme/SNSCustomizationTheme;", "getTheme", "Companion", "idensic-mobile-sdk-aar_release"}, k = 1, mv = {1, 7, 1})
public interface SNSJsonCustomization {
    public static final Companion Companion = Companion.$$INSTANCE;

    @Metadata(bv = {}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u000b\u0010\fJ\b\u0010\u0003\u001a\u00020\u0002H\u0007R(\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00020\u00048\u0006@\u0006X.¢\u0006\u0012\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\n¨\u0006\r"}, d2 = {"Lcom/sumsub/sns/core/theme/SNSJsonCustomization$Companion;", "", "Lcom/sumsub/sns/core/theme/SNSJsonCustomization;", "create", "Lkotlin/Function0;", "defaultJsonCustomizationProvider", "Ld10/a;", "getDefaultJsonCustomizationProvider", "()Ld10/a;", "setDefaultJsonCustomizationProvider", "(Ld10/a;)V", "<init>", "()V", "idensic-mobile-sdk-aar_release"}, k = 1, mv = {1, 7, 1})
    public static final class Companion {
        public static final /* synthetic */ Companion $$INSTANCE = new Companion();
        public static a<? extends SNSJsonCustomization> defaultJsonCustomizationProvider;

        private Companion() {
        }

        public final SNSJsonCustomization create() {
            return getDefaultJsonCustomizationProvider().invoke();
        }

        public final a<SNSJsonCustomization> getDefaultJsonCustomizationProvider() {
            a<? extends SNSJsonCustomization> aVar = defaultJsonCustomizationProvider;
            if (aVar != null) {
                return aVar;
            }
            return null;
        }

        public final void setDefaultJsonCustomizationProvider(a<? extends SNSJsonCustomization> aVar) {
            defaultJsonCustomizationProvider = aVar;
        }
    }

    SNSCustomizationTheme getTheme();

    void loadResources(Context context);

    void loadTheme(SNSTheme sNSTheme);

    void loadTheme(Map<String, ? extends Object> map, SNSCustomizationFileFormat sNSCustomizationFileFormat);

    void loadTheme(kotlinx.serialization.json.a aVar, String str, SNSCustomizationFileFormat sNSCustomizationFileFormat);
}
