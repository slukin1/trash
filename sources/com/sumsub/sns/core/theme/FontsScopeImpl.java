package com.sumsub.sns.core.theme;

import java.util.HashMap;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0017\b\u0000\u0018\u00002\u00020\u0001B\u0019\u0012\u0012\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003¢\u0006\u0002\u0010\u0006R(\u0010\b\u001a\u0004\u0018\u00010\u00052\b\u0010\u0007\u001a\u0004\u0018\u00010\u00058V@VX\u000e¢\u0006\f\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR(\u0010\r\u001a\u0004\u0018\u00010\u00052\b\u0010\u0007\u001a\u0004\u0018\u00010\u00058V@VX\u000e¢\u0006\f\u001a\u0004\b\u000e\u0010\n\"\u0004\b\u000f\u0010\fR(\u0010\u0010\u001a\u0004\u0018\u00010\u00052\b\u0010\u0007\u001a\u0004\u0018\u00010\u00058V@VX\u000e¢\u0006\f\u001a\u0004\b\u0011\u0010\n\"\u0004\b\u0012\u0010\fR(\u0010\u0013\u001a\u0004\u0018\u00010\u00052\b\u0010\u0007\u001a\u0004\u0018\u00010\u00058V@VX\u000e¢\u0006\f\u001a\u0004\b\u0014\u0010\n\"\u0004\b\u0015\u0010\fR\u001a\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003X\u0004¢\u0006\u0002\n\u0000R(\u0010\u0016\u001a\u0004\u0018\u00010\u00052\b\u0010\u0007\u001a\u0004\u0018\u00010\u00058V@VX\u000e¢\u0006\f\u001a\u0004\b\u0017\u0010\n\"\u0004\b\u0018\u0010\fR(\u0010\u0019\u001a\u0004\u0018\u00010\u00052\b\u0010\u0007\u001a\u0004\u0018\u00010\u00058V@VX\u000e¢\u0006\f\u001a\u0004\b\u001a\u0010\n\"\u0004\b\u001b\u0010\f¨\u0006\u001c"}, d2 = {"Lcom/sumsub/sns/core/theme/FontsScopeImpl;", "Lcom/sumsub/sns/core/theme/FontsScope;", "map", "Ljava/util/HashMap;", "Lcom/sumsub/sns/core/theme/SNSTypographyElement;", "Lcom/sumsub/sns/core/theme/SNSThemeFont;", "(Ljava/util/HashMap;)V", "v", "body", "getBody", "()Lcom/sumsub/sns/core/theme/SNSThemeFont;", "setBody", "(Lcom/sumsub/sns/core/theme/SNSThemeFont;)V", "caption", "getCaption", "setCaption", "headline1", "getHeadline1", "setHeadline1", "headline2", "getHeadline2", "setHeadline2", "subtitle1", "getSubtitle1", "setSubtitle1", "subtitle2", "getSubtitle2", "setSubtitle2", "idensic-mobile-sdk-aar_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class FontsScopeImpl implements FontsScope {
    private final HashMap<SNSTypographyElement, SNSThemeFont> map;

    public FontsScopeImpl(HashMap<SNSTypographyElement, SNSThemeFont> hashMap) {
        this.map = hashMap;
    }

    public SNSThemeFont getBody() {
        return this.map.get(SNSTypographyElement.BODY);
    }

    public SNSThemeFont getCaption() {
        return this.map.get(SNSTypographyElement.CAPTION);
    }

    public SNSThemeFont getHeadline1() {
        return this.map.get(SNSTypographyElement.HEADLINE1);
    }

    public SNSThemeFont getHeadline2() {
        return this.map.get(SNSTypographyElement.HEADLINE2);
    }

    public SNSThemeFont getSubtitle1() {
        return this.map.get(SNSTypographyElement.SUBTITLE1);
    }

    public SNSThemeFont getSubtitle2() {
        return this.map.get(SNSTypographyElement.SUBTITLE2);
    }

    public void setBody(SNSThemeFont sNSThemeFont) {
        if (sNSThemeFont != null) {
            SNSThemeFont put = this.map.put(SNSTypographyElement.BODY, sNSThemeFont);
        }
    }

    public void setCaption(SNSThemeFont sNSThemeFont) {
        if (sNSThemeFont != null) {
            SNSThemeFont put = this.map.put(SNSTypographyElement.CAPTION, sNSThemeFont);
        }
    }

    public void setHeadline1(SNSThemeFont sNSThemeFont) {
        if (sNSThemeFont != null) {
            SNSThemeFont put = this.map.put(SNSTypographyElement.HEADLINE1, sNSThemeFont);
        }
    }

    public void setHeadline2(SNSThemeFont sNSThemeFont) {
        if (sNSThemeFont != null) {
            SNSThemeFont put = this.map.put(SNSTypographyElement.HEADLINE2, sNSThemeFont);
        }
    }

    public void setSubtitle1(SNSThemeFont sNSThemeFont) {
        if (sNSThemeFont != null) {
            SNSThemeFont put = this.map.put(SNSTypographyElement.SUBTITLE1, sNSThemeFont);
        }
    }

    public void setSubtitle2(SNSThemeFont sNSThemeFont) {
        if (sNSThemeFont != null) {
            SNSThemeFont put = this.map.put(SNSTypographyElement.SUBTITLE2, sNSThemeFont);
        }
    }
}
