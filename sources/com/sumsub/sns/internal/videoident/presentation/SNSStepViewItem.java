package com.sumsub.sns.internal.videoident.presentation;

import androidx.annotation.Keep;
import kotlin.Metadata;
import kotlin.jvm.internal.x;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\b\u0018\u00002\u00020\u0001:\u0001\u0019B!\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u000b\u0010\u000f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0007HÆ\u0003J+\u0010\u0012\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u001a"}, d2 = {"Lcom/sumsub/sns/internal/videoident/presentation/SNSStepViewItem;", "", "icon", "", "title", "", "state", "Lcom/sumsub/sns/internal/videoident/presentation/SNSStepViewItem$State;", "(Ljava/lang/String;Ljava/lang/CharSequence;Lcom/sumsub/sns/internal/videoident/presentation/SNSStepViewItem$State;)V", "getIcon", "()Ljava/lang/String;", "getState", "()Lcom/sumsub/sns/internal/videoident/presentation/SNSStepViewItem$State;", "getTitle", "()Ljava/lang/CharSequence;", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "State", "idensic-mobile-sdk-aar_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
@Keep
public final class SNSStepViewItem {
    private final String icon;
    private final State state;
    private final CharSequence title;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/sumsub/sns/internal/videoident/presentation/SNSStepViewItem$State;", "", "(Ljava/lang/String;I)V", "DEFAULT", "SELECTED", "DONE", "idensic-mobile-sdk-aar_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public enum State {
        DEFAULT,
        SELECTED,
        DONE
    }

    public SNSStepViewItem(String str, CharSequence charSequence, State state2) {
        this.icon = str;
        this.title = charSequence;
        this.state = state2;
    }

    public static /* synthetic */ SNSStepViewItem copy$default(SNSStepViewItem sNSStepViewItem, String str, CharSequence charSequence, State state2, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            str = sNSStepViewItem.icon;
        }
        if ((i11 & 2) != 0) {
            charSequence = sNSStepViewItem.title;
        }
        if ((i11 & 4) != 0) {
            state2 = sNSStepViewItem.state;
        }
        return sNSStepViewItem.copy(str, charSequence, state2);
    }

    public final String component1() {
        return this.icon;
    }

    public final CharSequence component2() {
        return this.title;
    }

    public final State component3() {
        return this.state;
    }

    public final SNSStepViewItem copy(String str, CharSequence charSequence, State state2) {
        return new SNSStepViewItem(str, charSequence, state2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SNSStepViewItem)) {
            return false;
        }
        SNSStepViewItem sNSStepViewItem = (SNSStepViewItem) obj;
        return x.b(this.icon, sNSStepViewItem.icon) && x.b(this.title, sNSStepViewItem.title) && this.state == sNSStepViewItem.state;
    }

    public final String getIcon() {
        return this.icon;
    }

    public final State getState() {
        return this.state;
    }

    public final CharSequence getTitle() {
        return this.title;
    }

    public int hashCode() {
        String str = this.icon;
        int i11 = 0;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        CharSequence charSequence = this.title;
        if (charSequence != null) {
            i11 = charSequence.hashCode();
        }
        return ((hashCode + i11) * 31) + this.state.hashCode();
    }

    public String toString() {
        return "SNSStepViewItem(icon=" + this.icon + ", title=" + this.title + ", state=" + this.state + ')';
    }
}
