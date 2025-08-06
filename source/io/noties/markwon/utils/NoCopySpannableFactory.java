package io.noties.markwon.utils;

import android.text.Spannable;
import android.text.SpannableString;

public class NoCopySpannableFactory extends Spannable.Factory {
    public Spannable newSpannable(CharSequence charSequence) {
        if (charSequence instanceof Spannable) {
            return (Spannable) charSequence;
        }
        return new SpannableString(charSequence);
    }
}
