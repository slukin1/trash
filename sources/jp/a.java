package jp;

import android.text.Editable;
import android.text.Selection;
import android.text.TextWatcher;
import android.widget.EditText;

public class a implements TextWatcher {

    /* renamed from: b  reason: collision with root package name */
    public int f84305b = 26;

    /* renamed from: c  reason: collision with root package name */
    public int f84306c = 0;

    /* renamed from: d  reason: collision with root package name */
    public boolean f84307d = false;

    /* renamed from: e  reason: collision with root package name */
    public int f84308e = 0;

    /* renamed from: f  reason: collision with root package name */
    public StringBuffer f84309f = new StringBuffer();

    /* renamed from: g  reason: collision with root package name */
    public EditText f84310g;

    public a(EditText editText, int i11) {
        this.f84310g = editText;
        this.f84305b = i11;
        editText.addTextChangedListener(this);
    }

    public static void a(EditText editText) {
        new a(editText, 26);
    }

    public void afterTextChanged(Editable editable) {
        if (this.f84307d) {
            int selectionEnd = this.f84310g.getSelectionEnd();
            int i11 = 0;
            while (i11 < this.f84309f.length()) {
                if (this.f84309f.charAt(i11) == ' ') {
                    this.f84309f.deleteCharAt(i11);
                } else {
                    i11++;
                }
            }
            int i12 = 0;
            for (int i13 = 0; i13 < this.f84309f.length(); i13++) {
                if (i13 == 4 || i13 == 9 || i13 == 14 || i13 == 19 || i13 == 24) {
                    this.f84309f.insert(i13, ' ');
                    i12++;
                }
            }
            int i14 = this.f84308e;
            if (i12 > i14) {
                selectionEnd += i12 - i14;
            }
            StringBuffer stringBuffer = this.f84309f;
            stringBuffer.getChars(0, stringBuffer.length(), new char[this.f84309f.length()], 0);
            String stringBuffer2 = this.f84309f.toString();
            if (selectionEnd > stringBuffer2.length()) {
                selectionEnd = stringBuffer2.length();
            } else if (selectionEnd < 0) {
                selectionEnd = 0;
            }
            this.f84310g.setText(stringBuffer2);
            Editable text = this.f84310g.getText();
            int i15 = this.f84305b;
            if (selectionEnd >= i15) {
                selectionEnd = i15;
            }
            Selection.setSelection(text, selectionEnd);
            this.f84307d = false;
        }
    }

    public void beforeTextChanged(CharSequence charSequence, int i11, int i12, int i13) {
        this.f84306c = charSequence.length();
        if (this.f84309f.length() > 0) {
            StringBuffer stringBuffer = this.f84309f;
            stringBuffer.delete(0, stringBuffer.length());
        }
        this.f84308e = 0;
        for (int i14 = 0; i14 < charSequence.length(); i14++) {
            if (charSequence.charAt(i14) == ' ') {
                this.f84308e++;
            }
        }
    }

    public void onTextChanged(CharSequence charSequence, int i11, int i12, int i13) {
        int length = charSequence.length();
        this.f84309f.append(charSequence.toString());
        if (length == this.f84306c || length <= 3 || this.f84307d) {
            this.f84307d = false;
        } else {
            this.f84307d = true;
        }
    }
}
