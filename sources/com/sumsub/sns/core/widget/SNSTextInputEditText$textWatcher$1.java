package com.sumsub.sns.core.widget;

import android.text.Editable;
import android.text.TextWatcher;
import com.sumsub.log.logger.a;
import com.sumsub.sns.core.widget.SNSTextInputEditText;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.x;

@Metadata(d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J*\u0010\u0006\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\tH\u0016J*\u0010\f\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\tH\u0016¨\u0006\u000e"}, d2 = {"com/sumsub/sns/core/widget/SNSTextInputEditText$textWatcher$1", "Landroid/text/TextWatcher;", "afterTextChanged", "", "s", "Landroid/text/Editable;", "beforeTextChanged", "", "start", "", "count", "after", "onTextChanged", "before", "idensic-mobile-sdk-aar_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class SNSTextInputEditText$textWatcher$1 implements TextWatcher {
    public final /* synthetic */ SNSTextInputEditText this$0;

    public SNSTextInputEditText$textWatcher$1(SNSTextInputEditText sNSTextInputEditText) {
        this.this$0 = sNSTextInputEditText;
    }

    public void afterTextChanged(Editable editable) {
        int i11;
        if (this.this$0.getMasksEnabled() && this.this$0.isTextChangingBefore && !this.this$0.isTextChangingAfter) {
            int selectionStart = this.this$0.getSelectionStart();
            a.d(com.sumsub.sns.internal.log.a.f34862a, "SNSInputEditText", "afterTextChanged, original s=" + editable + ", selection=" + selectionStart, (Throwable) null, 4, (Object) null);
            int i12 = 1;
            this.this$0.isTextChangingAfter = true;
            this.this$0.isTextChangingBefore = false;
            this.this$0.cleanRaw();
            SNSTextInputEditText.Mask access$getMask$p = this.this$0.mask;
            SNSTextInputEditText.Mask access$findNewMask = this.this$0.findNewMask();
            if (access$findNewMask != null) {
                this.this$0.prepareMask(access$findNewMask);
            } else {
                SNSTextInputEditText sNSTextInputEditText = this.this$0;
                selectionStart -= SNSTextInputEditText.getSpecialSymbolsInMaskedTextCount$default(sNSTextInputEditText, sNSTextInputEditText.getRemovedSymbolsCount() + selectionStart, (String) null, 2, (Object) null);
                this.this$0.prepareMask((SNSTextInputEditText.Mask) null);
            }
            int access$getRemovedSymbolsCount = this.this$0.getRemovedSymbolsCount();
            HashMap access$getMaskSymbolPositions$p = this.this$0.maskSymbolPositions;
            SNSTextInputEditText.Mask access$getMask$p2 = this.this$0.mask;
            List list = (List) access$getMaskSymbolPositions$p.get(access$getMask$p2 != null ? access$getMask$p2.getMask() : null);
            if (!x.b(access$getMask$p, this.this$0.mask) && this.this$0.mask == null) {
                if (editable != null) {
                    SNSTextInputEditText.removeHintSpans$default(this.this$0, editable, false, 1, (Object) null);
                }
                if (editable != null) {
                    editable.append(this.this$0.raw);
                }
            } else if (!x.b(access$getMask$p, this.this$0.mask)) {
                this.this$0.applyMask(editable);
                List list2 = (List) this.this$0.maskSymbolPositions.get(access$getMask$p != null ? access$getMask$p.getMask() : null);
                if (list2 != null) {
                    int i13 = (access$getRemovedSymbolsCount > 0 ? access$getRemovedSymbolsCount : 0) + selectionStart;
                    int size = list2.size();
                    i11 = selectionStart;
                    int i14 = 0;
                    while (i14 < size && i14 != i13) {
                        if (((SNSTextInputEditText.CharHolder) list2.get(i14)).getPos() < 0) {
                            i11--;
                        }
                        i14++;
                    }
                } else {
                    i11 = selectionStart;
                }
                if (list != null) {
                    SNSTextInputEditText sNSTextInputEditText2 = this.this$0;
                    Iterator it2 = list.iterator();
                    int i15 = 0;
                    while (true) {
                        if (!it2.hasNext()) {
                            i15 = -1;
                            break;
                        }
                        if (((SNSTextInputEditText.CharHolder) it2.next()).getPos() == i11) {
                            break;
                        }
                        i15++;
                    }
                    if (access$getRemovedSymbolsCount > 0 || access$getMask$p == null) {
                        int max = Math.max(0, i15) - access$getRemovedSymbolsCount;
                        if (i15 != 0) {
                            if (max < 0 || max >= list.size()) {
                                selectionStart += SNSTextInputEditText.getSpecialSymbolsInMaskedTextCount$default(sNSTextInputEditText2, selectionStart, (String) null, 2, (Object) null);
                            } else if (((SNSTextInputEditText.CharHolder) list.get(max)).getPos() < 0) {
                                while (true) {
                                    if (-1 >= max) {
                                        break;
                                    } else if (((SNSTextInputEditText.CharHolder) list.get(max)).getPos() > 0) {
                                        selectionStart = max + 1;
                                        break;
                                    } else {
                                        max--;
                                    }
                                }
                            } else if (i15 < 0) {
                                selectionStart = list.size();
                            }
                        }
                    }
                    selectionStart = i15;
                } else {
                    selectionStart = i11;
                }
            } else {
                if (access$getRemovedSymbolsCount > 0 && list != null) {
                    int access$getStartingPosition = this.this$0.getStartingPosition();
                    if (this.this$0.raw.length() + SNSTextInputEditText.getSpecialSymbolsInMaskedTextCount$default(this.this$0, selectionStart, (String) null, 2, (Object) null) >= selectionStart) {
                        i12 = 0;
                    }
                    while (selectionStart > access$getStartingPosition && selectionStart + 1 < list.size() && ((SNSTextInputEditText.CharHolder) list.get(selectionStart + i12)).getPos() < 0) {
                        selectionStart--;
                    }
                }
                this.this$0.applyMask(editable);
            }
            com.sumsub.sns.internal.log.a aVar = com.sumsub.sns.internal.log.a.f34862a;
            a.d(aVar, "SNSInputEditText", "afterTextChanged, new s=" + editable, (Throwable) null, 4, (Object) null);
            this.this$0.isTextChangingAfter = false;
            if (selectionStart > this.this$0.length()) {
                selectionStart = this.this$0.length();
            }
            if (selectionStart < 0) {
                selectionStart = this.this$0.length();
            }
            this.this$0.setSelection(selectionStart);
            a.c(aVar, "SNSInputEditText", "Text changed in " + (System.currentTimeMillis() - this.this$0.benchmark) + "ms", (Throwable) null, 4, (Object) null);
        }
    }

    public void beforeTextChanged(CharSequence charSequence, int i11, int i12, int i13) {
        if (this.this$0.getMasksEnabled() && !this.this$0.isTextChangingAfter) {
            this.this$0.benchmark = System.currentTimeMillis();
            com.sumsub.sns.internal.log.a aVar = com.sumsub.sns.internal.log.a.f34862a;
            a.d(aVar, "SNSInputEditText", "beforeTextChanged, start=" + i11 + ", count=" + i12 + ", after=" + i13 + ", s=" + charSequence, (Throwable) null, 4, (Object) null);
            this.this$0.isTextChangingBefore = true;
        }
    }

    public void onTextChanged(CharSequence charSequence, int i11, int i12, int i13) {
        CharSequence subSequence;
        if (this.this$0.getMasksEnabled() && this.this$0.isTextChangingBefore && !this.this$0.isTextChangingAfter) {
            com.sumsub.sns.internal.log.a aVar = com.sumsub.sns.internal.log.a.f34862a;
            a.d(aVar, "SNSInputEditText", "onTextChanged, start=" + i11 + ", before=" + i12 + ", count=" + i13 + ", s=" + charSequence, (Throwable) null, 4, (Object) null);
            if (this.this$0.mask != null) {
                SNSTextInputEditText sNSTextInputEditText = this.this$0;
                sNSTextInputEditText.lastRaw = sNSTextInputEditText.raw.toString();
                if (i13 > 0) {
                    if (charSequence != null && (subSequence = charSequence.subSequence(i11, i11 + i13)) != null) {
                        int maskSymbolsCount$default = SNSTextInputEditText.getMaskSymbolsCount$default(this.this$0, i11, (String) null, 2, (Object) null);
                        a.d(aVar, "SNSInputEditText", "onTextChanged, start=" + i11 + ", rawStart=" + maskSymbolsCount$default + ", addedText=" + subSequence, (Throwable) null, 4, (Object) null);
                        if (maskSymbolsCount$default > this.this$0.raw.length()) {
                            this.this$0.raw.append(subSequence);
                        } else {
                            int i14 = i13 + maskSymbolsCount$default;
                            if (this.this$0.raw.length() >= i14) {
                                this.this$0.raw.insert(maskSymbolsCount$default, subSequence);
                            } else {
                                this.this$0.raw.replace(maskSymbolsCount$default, i14, subSequence.toString());
                            }
                        }
                    } else {
                        return;
                    }
                } else if (i11 >= this.this$0.getStartingPosition()) {
                    int access$prevValidCharPosition = this.this$0.prevValidCharPosition(i11);
                    this.this$0.raw.delete(access$prevValidCharPosition, Math.min(i12 + access$prevValidCharPosition, this.this$0.raw.length()));
                }
            } else {
                StringBuilder unused = StringsKt__StringBuilderJVMKt.i(this.this$0.raw);
                this.this$0.raw.append(charSequence);
            }
            a.d(aVar, "SNSInputEditText", "onTextChanged, RawText = " + this.this$0.raw, (Throwable) null, 4, (Object) null);
        }
    }
}
