package com.huobi.view;

import android.content.Context;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import com.hbg.lib.widgets.input.ClearEditText;

public class CardInputEditText extends ClearEditText {
    private boolean mFourWatcherEnable;
    /* access modifiers changed from: private */
    public TextWatcher watcher;

    public CardInputEditText(Context context) {
        this(context, (AttributeSet) null);
    }

    public String getTextWithoutSpace() {
        Editable text = super.getText();
        if (text == null) {
            return null;
        }
        return text.toString().replace(" ", "");
    }

    public void setFourTextWatcherEnable(boolean z11) {
        if (this.mFourWatcherEnable != z11) {
            this.mFourWatcherEnable = z11;
            setText("");
            if (this.mFourWatcherEnable) {
                addTextChangedListener(this.watcher);
            } else {
                removeTextChangedListener(this.watcher);
            }
        }
    }

    public CardInputEditText(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.watcher = new TextWatcher() {
            public void afterTextChanged(Editable editable) {
            }

            public void beforeTextChanged(CharSequence charSequence, int i11, int i12, int i13) {
            }

            public void onTextChanged(CharSequence charSequence, int i11, int i12, int i13) {
                if (charSequence != null) {
                    int i14 = i11 + i13;
                    int i15 = 0;
                    boolean z11 = i14 < charSequence.length();
                    boolean z12 = !z11 && charSequence.length() > 0 && charSequence.length() % 5 == 0;
                    if (z11 || z12) {
                        String replace = charSequence.toString().replace(" ", "");
                        StringBuilder sb2 = new StringBuilder();
                        int i16 = 0;
                        while (i16 < replace.length()) {
                            if (i16 > 0) {
                                sb2.append(" ");
                            }
                            int i17 = i16 + 4;
                            if (i17 <= replace.length()) {
                                sb2.append(replace.substring(i16, i17));
                            } else {
                                sb2.append(replace.substring(i16, replace.length()));
                            }
                            i16 = i17;
                        }
                        CardInputEditText cardInputEditText = CardInputEditText.this;
                        cardInputEditText.removeTextChangedListener(cardInputEditText.watcher);
                        CardInputEditText.this.setText(sb2);
                        if (!z11 || i13 > 1) {
                            CardInputEditText cardInputEditText2 = CardInputEditText.this;
                            cardInputEditText2.setSelection(cardInputEditText2.getText().length());
                        } else if (z11) {
                            if (i13 == 0) {
                                int i18 = i11 - i12;
                                int i19 = i18 + 1;
                                if (i19 % 5 == 0) {
                                    CardInputEditText cardInputEditText3 = CardInputEditText.this;
                                    if (i18 > 0) {
                                        i15 = i18;
                                    }
                                    cardInputEditText3.setSelection(i15);
                                } else {
                                    CardInputEditText cardInputEditText4 = CardInputEditText.this;
                                    if (i19 > sb2.length()) {
                                        i19 = sb2.length();
                                    }
                                    cardInputEditText4.setSelection(i19);
                                }
                            } else if (((i11 - i12) + i13) % 5 == 0) {
                                CardInputEditText cardInputEditText5 = CardInputEditText.this;
                                int i21 = (i14 - i12) + 1;
                                if (i21 >= sb2.length()) {
                                    i21 = sb2.length();
                                }
                                cardInputEditText5.setSelection(i21);
                            } else {
                                CardInputEditText.this.setSelection(i14 - i12);
                            }
                        }
                        CardInputEditText cardInputEditText6 = CardInputEditText.this;
                        cardInputEditText6.addTextChangedListener(cardInputEditText6.watcher);
                    }
                }
            }
        };
    }

    public CardInputEditText(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        this.watcher = new TextWatcher() {
            public void afterTextChanged(Editable editable) {
            }

            public void beforeTextChanged(CharSequence charSequence, int i11, int i12, int i13) {
            }

            public void onTextChanged(CharSequence charSequence, int i11, int i12, int i13) {
                if (charSequence != null) {
                    int i14 = i11 + i13;
                    int i15 = 0;
                    boolean z11 = i14 < charSequence.length();
                    boolean z12 = !z11 && charSequence.length() > 0 && charSequence.length() % 5 == 0;
                    if (z11 || z12) {
                        String replace = charSequence.toString().replace(" ", "");
                        StringBuilder sb2 = new StringBuilder();
                        int i16 = 0;
                        while (i16 < replace.length()) {
                            if (i16 > 0) {
                                sb2.append(" ");
                            }
                            int i17 = i16 + 4;
                            if (i17 <= replace.length()) {
                                sb2.append(replace.substring(i16, i17));
                            } else {
                                sb2.append(replace.substring(i16, replace.length()));
                            }
                            i16 = i17;
                        }
                        CardInputEditText cardInputEditText = CardInputEditText.this;
                        cardInputEditText.removeTextChangedListener(cardInputEditText.watcher);
                        CardInputEditText.this.setText(sb2);
                        if (!z11 || i13 > 1) {
                            CardInputEditText cardInputEditText2 = CardInputEditText.this;
                            cardInputEditText2.setSelection(cardInputEditText2.getText().length());
                        } else if (z11) {
                            if (i13 == 0) {
                                int i18 = i11 - i12;
                                int i19 = i18 + 1;
                                if (i19 % 5 == 0) {
                                    CardInputEditText cardInputEditText3 = CardInputEditText.this;
                                    if (i18 > 0) {
                                        i15 = i18;
                                    }
                                    cardInputEditText3.setSelection(i15);
                                } else {
                                    CardInputEditText cardInputEditText4 = CardInputEditText.this;
                                    if (i19 > sb2.length()) {
                                        i19 = sb2.length();
                                    }
                                    cardInputEditText4.setSelection(i19);
                                }
                            } else if (((i11 - i12) + i13) % 5 == 0) {
                                CardInputEditText cardInputEditText5 = CardInputEditText.this;
                                int i21 = (i14 - i12) + 1;
                                if (i21 >= sb2.length()) {
                                    i21 = sb2.length();
                                }
                                cardInputEditText5.setSelection(i21);
                            } else {
                                CardInputEditText.this.setSelection(i14 - i12);
                            }
                        }
                        CardInputEditText cardInputEditText6 = CardInputEditText.this;
                        cardInputEditText6.addTextChangedListener(cardInputEditText6.watcher);
                    }
                }
            }
        };
    }
}
