package com.hbg.lib.widgets.input;

import android.text.InputFilter;
import android.text.Spanned;
import com.amazonaws.services.s3.model.InstructionFileId;

public class PointLengthFilter implements InputFilter {

    /* renamed from: b  reason: collision with root package name */
    public int f72050b = 0;

    public void a(int i11) {
        this.f72050b = i11;
    }

    public CharSequence filter(CharSequence charSequence, int i11, int i12, Spanned spanned, int i13, int i14) {
        int length = spanned.length();
        int i15 = 0;
        while (true) {
            if (i15 >= length) {
                i15 = -1;
                break;
            } else if (spanned.charAt(i15) == '.') {
                break;
            } else {
                i15++;
            }
        }
        if (i15 >= 0) {
            if (InstructionFileId.DOT.equals(charSequence)) {
                return "";
            }
            if (i14 > i15 && length - i15 > this.f72050b) {
                return "";
            }
        }
        return null;
    }
}
