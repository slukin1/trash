package com.sumsub.sns.core.widget;

import android.content.Context;
import android.graphics.Typeface;
import android.text.Editable;
import android.text.InputFilter;
import android.text.style.ForegroundColorSpan;
import android.util.AttributeSet;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.view.inputmethod.InputConnectionWrapper;
import com.google.android.material.textfield.TextInputEditText;
import com.sumsub.log.logger.a;
import com.sumsub.sns.R;
import com.sumsub.sns.internal.core.common.n0;
import com.sumsub.sns.internal.log.c;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.r;
import kotlin.jvm.internal.x;

@Metadata(d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0010\f\n\u0002\b\f*\u0001/\u0018\u0000 _2\u00020\u0001:\u0007^_`abcdB%\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0012\u00101\u001a\u0002022\b\u00103\u001a\u0004\u0018\u000104H\u0002J\b\u00105\u001a\u000202H\u0002J\n\u00106\u001a\u0004\u0018\u00010\u0015H\u0002J\u001c\u00107\u001a\u00020\u00072\u0006\u00108\u001a\u00020\u00072\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0013H\u0002J\b\u00109\u001a\u00020\u0007H\u0002J\u001c\u0010:\u001a\u00020\u00072\u0006\u00108\u001a\u00020\u00072\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0013H\u0002J\b\u0010;\u001a\u00020\u0007H\u0002J\n\u0010<\u001a\u0004\u0018\u000104H\u0016J\b\u0010=\u001a\u00020\u000fH\u0016J\u001a\u0010>\u001a\u00020?2\u0006\u0010@\u001a\u00020A2\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0002J\u0012\u0010B\u001a\u0004\u0018\u00010C2\u0006\u0010D\u001a\u00020EH\u0016J\u0018\u0010F\u001a\u0002022\u0006\u0010G\u001a\u00020\u00072\u0006\u0010H\u001a\u00020\u0007H\u0014J\u0012\u0010I\u001a\u0002022\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0002J\b\u0010J\u001a\u000202H\u0002J\u0010\u0010K\u001a\u00020\u00072\u0006\u0010L\u001a\u00020\u0007H\u0002J\b\u0010M\u001a\u000202H\u0002J\u0012\u0010N\u001a\u0002022\b\u0010O\u001a\u0004\u0018\u00010AH\u0016J\u0016\u0010P\u001a\u0002022\u000e\u0010Q\u001a\n\u0012\u0004\u0012\u00020\u0015\u0018\u00010\u001eJ\u001d\u0010P\u001a\u0002022\u000e\u0010Q\u001a\n\u0012\u0004\u0012\u00020\u0013\u0018\u00010\u001eH\u0007¢\u0006\u0002\bRJ\u000e\u0010S\u001a\u0002022\u0006\u00108\u001a\u00020\u0007J\u0017\u0010T\u001a\u0002022\n\b\u0002\u0010U\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010VJ'\u0010W\u001a\u000202*\u00060\fj\u0002`\r2\b\u0010X\u001a\u0004\u0018\u00010Y2\u0006\u0010Z\u001a\u00020\u000fH\u0002¢\u0006\u0002\u0010[J\u0018\u0010\\\u001a\u000202*\u0004\u0018\u0001042\b\b\u0002\u0010]\u001a\u00020\u000fH\u0002R\u000e\u0010\t\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u000b\u001a\u00060\fj\u0002`\rX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u000fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u000fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR6\u0010\u001c\u001a*\u0012\u0004\u0012\u00020\u0013\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001f0\u001e0\u001dj\u0014\u0012\u0004\u0012\u00020\u0013\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001f0\u001e` X\u000e¢\u0006\u0002\n\u0000R6\u0010!\u001a*\u0012\u0004\u0012\u00020\u0013\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001f0\u001e0\u001dj\u0014\u0012\u0004\u0012\u00020\u0013\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001f0\u001e` X\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\"\u001a\u00020\u000f8F¢\u0006\u0006\u001a\u0004\b#\u0010$R.\u0010&\u001a\n\u0012\u0004\u0012\u00020\u0015\u0018\u00010\u001e2\u000e\u0010%\u001a\n\u0012\u0004\u0012\u00020\u0015\u0018\u00010\u001e@BX\u000e¢\u0006\b\n\u0000\"\u0004\b'\u0010(R\u000e\u0010)\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000R\u0012\u0010*\u001a\u00060\fj\u0002`\rX\u000e¢\u0006\u0002\n\u0000R\u0011\u0010+\u001a\u00020\u00138F¢\u0006\u0006\u001a\u0004\b,\u0010-R\u0010\u0010.\u001a\u00020/X\u0004¢\u0006\u0004\n\u0002\u00100¨\u0006e"}, d2 = {"Lcom/sumsub/sns/core/widget/SNSTextInputEditText;", "Lcom/google/android/material/textfield/TextInputEditText;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "benchmark", "", "buffer", "Ljava/lang/StringBuilder;", "Lkotlin/text/StringBuilder;", "isSelectionChanging", "", "isTextChangingAfter", "isTextChangingBefore", "lastRaw", "", "mask", "Lcom/sumsub/sns/core/widget/SNSTextInputEditText$Mask;", "maskListener", "Lcom/sumsub/sns/core/widget/SNSTextInputEditText$MaskListener;", "getMaskListener", "()Lcom/sumsub/sns/core/widget/SNSTextInputEditText$MaskListener;", "setMaskListener", "(Lcom/sumsub/sns/core/widget/SNSTextInputEditText$MaskListener;)V", "maskSymbolPositions", "Ljava/util/HashMap;", "", "Lcom/sumsub/sns/core/widget/SNSTextInputEditText$CharHolder;", "Lkotlin/collections/HashMap;", "masksCleared", "masksEnabled", "getMasksEnabled", "()Z", "value", "masksInternal", "setMasksInternal", "(Ljava/util/List;)V", "maxRawLength", "raw", "rawText", "getRawText", "()Ljava/lang/String;", "textWatcher", "com/sumsub/sns/core/widget/SNSTextInputEditText$textWatcher$1", "Lcom/sumsub/sns/core/widget/SNSTextInputEditText$textWatcher$1;", "applyMask", "", "s", "Landroid/text/Editable;", "cleanRaw", "findNewMask", "getMaskSymbolsCount", "maxLength", "getRemovedSymbolsCount", "getSpecialSymbolsInMaskedTextCount", "getStartingPosition", "getText", "isSuggestionsEnabled", "maskMatches", "Lcom/sumsub/sns/core/widget/SNSTextInputEditText$MaskMatchResult;", "text", "", "onCreateInputConnection", "Landroid/view/inputmethod/InputConnection;", "outAttrs", "Landroid/view/inputmethod/EditorInfo;", "onSelectionChanged", "selStart", "selEnd", "prepareMask", "prepareMasks", "prevValidCharPosition", "start", "setDefaultMask", "setError", "error", "setMasks", "masks", "setMasksString", "setMaxLength", "updateInputType", "defaultInputType", "(Ljava/lang/Integer;)V", "appendMaskChar", "char", "", "escaped", "(Ljava/lang/StringBuilder;Ljava/lang/Character;Z)V", "removeHintSpans", "clear", "CharHolder", "Companion", "EditableProxy", "Mask", "MaskListener", "MaskMatchResult", "MyInputConnectionWrapper", "idensic-mobile-sdk-aar_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class SNSTextInputEditText extends TextInputEditText {
    public static final Companion Companion = new Companion((r) null);
    private static final String LOG_TAG = "SNSInputEditText";
    /* access modifiers changed from: private */
    public static final Character[] maskSymbols = {Character.valueOf(n0.h.f32179b), '?', '*'};
    /* access modifiers changed from: private */
    public long benchmark;
    private StringBuilder buffer;
    private boolean isSelectionChanging;
    /* access modifiers changed from: private */
    public boolean isTextChangingAfter;
    /* access modifiers changed from: private */
    public boolean isTextChangingBefore;
    /* access modifiers changed from: private */
    public String lastRaw;
    /* access modifiers changed from: private */
    public Mask mask;
    private MaskListener maskListener;
    /* access modifiers changed from: private */
    public HashMap<String, List<CharHolder>> maskSymbolPositions;
    private HashMap<String, List<CharHolder>> masksCleared;
    private List<Mask> masksInternal;
    private int maxRawLength;
    /* access modifiers changed from: private */
    public StringBuilder raw;
    private final SNSTextInputEditText$textWatcher$1 textWatcher;

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\f\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000f\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0007HÆ\u0003J'\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00072\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0005HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u0018"}, d2 = {"Lcom/sumsub/sns/core/widget/SNSTextInputEditText$CharHolder;", "", "char", "", "pos", "", "escaped", "", "(CIZ)V", "getChar", "()C", "getEscaped", "()Z", "getPos", "()I", "component1", "component2", "component3", "copy", "equals", "other", "hashCode", "toString", "", "idensic-mobile-sdk-aar_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class CharHolder {

        /* renamed from: char  reason: not valid java name */
        private final char f9char;
        private final boolean escaped;
        private final int pos;

        public CharHolder(char c11, int i11, boolean z11) {
            this.f9char = c11;
            this.pos = i11;
            this.escaped = z11;
        }

        public static /* synthetic */ CharHolder copy$default(CharHolder charHolder, char c11, int i11, boolean z11, int i12, Object obj) {
            if ((i12 & 1) != 0) {
                c11 = charHolder.f9char;
            }
            if ((i12 & 2) != 0) {
                i11 = charHolder.pos;
            }
            if ((i12 & 4) != 0) {
                z11 = charHolder.escaped;
            }
            return charHolder.copy(c11, i11, z11);
        }

        public final char component1() {
            return this.f9char;
        }

        public final int component2() {
            return this.pos;
        }

        public final boolean component3() {
            return this.escaped;
        }

        public final CharHolder copy(char c11, int i11, boolean z11) {
            return new CharHolder(c11, i11, z11);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof CharHolder)) {
                return false;
            }
            CharHolder charHolder = (CharHolder) obj;
            return this.f9char == charHolder.f9char && this.pos == charHolder.pos && this.escaped == charHolder.escaped;
        }

        public final char getChar() {
            return this.f9char;
        }

        public final boolean getEscaped() {
            return this.escaped;
        }

        public final int getPos() {
            return this.pos;
        }

        public int hashCode() {
            int i11 = ((this.f9char * 31) + this.pos) * 31;
            boolean z11 = this.escaped;
            if (z11) {
                z11 = true;
            }
            return i11 + (z11 ? 1 : 0);
        }

        public String toString() {
            return "CharHolder(char=" + this.f9char + ", pos=" + this.pos + ", escaped=" + this.escaped + ')';
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ CharHolder(char c11, int i11, boolean z11, int i12, r rVar) {
            this(c11, (i12 & 2) != 0 ? -1 : i11, (i12 & 4) != 0 ? false : z11);
        }
    }

    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\f\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0007H\u0002J\u0010\u0010\f\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\u0007H\u0002J\u001f\u0010\r\u001a\u00020\u00072\b\u0010\u000e\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u000f\u001a\u00020\u0007H\u0002¢\u0006\u0002\u0010\u0010J \u0010\u0011\u001a\u00020\n2\u0006\u0010\u000f\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\nH\u0002J\f\u0010\u0014\u001a\u00020\n*\u00020\u0007H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u0016\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0004¢\u0006\u0004\n\u0002\u0010\b¨\u0006\u0015"}, d2 = {"Lcom/sumsub/sns/core/widget/SNSTextInputEditText$Companion;", "", "()V", "LOG_TAG", "", "maskSymbols", "", "", "[Ljava/lang/Character;", "isCharMaskPart", "", "symbol", "maskCharToPlaceholder", "modifyCharRegister", "maskChar", "char", "(Ljava/lang/Character;C)C", "symbolMatches", "Lcom/sumsub/sns/core/widget/SNSTextInputEditText$CharHolder;", "softMatch", "isUpperCaseMaskChar", "idensic-mobile-sdk-aar_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(r rVar) {
            this();
        }

        /* access modifiers changed from: private */
        public final boolean isCharMaskPart(char c11) {
            return ArraysKt___ArraysKt.C(SNSTextInputEditText.maskSymbols, Character.valueOf(c11)) || Character.isLetterOrDigit(c11);
        }

        private final boolean isUpperCaseMaskChar(char c11) {
            return c11 == '?' || c11 == '*' || Character.isUpperCase(c11);
        }

        /* access modifiers changed from: private */
        public final char maskCharToPlaceholder(char c11) {
            if (c11 == '#') {
                return '0';
            }
            if (c11 == '?' || c11 == '*') {
                return 'A';
            }
            return c11;
        }

        /* access modifiers changed from: private */
        public final char modifyCharRegister(Character ch2, char c11) {
            boolean z11 = true;
            if (ch2 == null || !isUpperCaseMaskChar(ch2.charValue())) {
                z11 = false;
            }
            return z11 ? Character.toUpperCase(c11) : c11;
        }

        /* access modifiers changed from: private */
        public final boolean symbolMatches(char c11, CharHolder charHolder, boolean z11) {
            boolean z12;
            if (charHolder.getEscaped()) {
                return CharsKt__CharKt.e(c11, charHolder.getChar(), true);
            }
            if (charHolder.getChar() == '#') {
                return Character.isDigit(c11);
            }
            if (charHolder.getChar() == '?') {
                return Character.isLetter(c11);
            }
            if (charHolder.getChar() == '*') {
                if (Character.isDigit(c11) || Character.isLetter(c11)) {
                    return true;
                }
            } else if (!z11) {
                return CharsKt__CharKt.e(c11, charHolder.getChar(), true);
            } else {
                if (CharsKt__CharKt.e(c11, charHolder.getChar(), true)) {
                    return true;
                }
                if (Character.isDigit(c11)) {
                    z12 = Character.isDigit(charHolder.getChar());
                } else {
                    z12 = Character.isLetter(c11) ? Character.isLetter(charHolder.getChar()) : true;
                }
                if (z12) {
                    return true;
                }
            }
            return false;
        }

        private Companion() {
        }
    }

    @Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\f\n\u0002\u0010\r\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0019\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u000e\n\u0000\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0001¢\u0006\u0002\u0010\u0003J\u0019\u0010\b\u001a\n \t*\u0004\u0018\u00010\u00010\u00012\u0006\u0010\n\u001a\u00020\u000bH\u0001J!\u0010\b\u001a\n \t*\u0004\u0018\u00010\u00010\u00012\u000e\u0010\n\u001a\n \t*\u0004\u0018\u00010\f0\fH\u0001J1\u0010\b\u001a\n \t*\u0004\u0018\u00010\u00010\u00012\u000e\u0010\n\u001a\n \t*\u0004\u0018\u00010\f0\f2\u0006\u0010\r\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\u0005H\u0001J\b\u0010\u000f\u001a\u00020\u0010H\u0016J\t\u0010\u0011\u001a\u00020\u0010H\u0001J!\u0010\u0012\u001a\n \t*\u0004\u0018\u00010\u00010\u00012\u0006\u0010\n\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u0005H\u0001J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0002J\u0011\u0010\u0017\u001a\u00020\u000b2\u0006\u0010\u0018\u001a\u00020\u0005H\u0003J1\u0010\u0019\u001a\u00020\u00102\u0006\u0010\n\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u00052\u000e\u0010\u000e\u001a\n \t*\u0004\u0018\u00010\u001a0\u001a2\u0006\u0010\u001b\u001a\u00020\u0005H\u0001J4\u0010\u001c\u001a(\u0012\f\u0012\n \t*\u0004\u0018\u00010\u001e0\u001e \t*\u0014\u0012\u000e\b\u0001\u0012\n \t*\u0004\u0018\u00010\u001e0\u001e\u0018\u00010\u001d0\u001dH\u0001¢\u0006\u0002\u0010\u001fJ\u0019\u0010 \u001a\u00020\u00052\u000e\u0010\n\u001a\n \t*\u0004\u0018\u00010\u00160\u0016H\u0001J\u0019\u0010!\u001a\u00020\u00052\u000e\u0010\n\u001a\n \t*\u0004\u0018\u00010\u00160\u0016H\u0001J\u0019\u0010\"\u001a\u00020\u00052\u000e\u0010\n\u001a\n \t*\u0004\u0018\u00010\u00160\u0016H\u0001J\u0001\u0010#\u001a(\u0012\f\u0012\n \t*\u0004\u0018\u0001H$H$ \t*\u0014\u0012\u000e\b\u0001\u0012\n \t*\u0004\u0018\u0001H$H$\u0018\u00010\u001d0\u001d\"\u0010\b\u0000\u0010$*\n \t*\u0004\u0018\u00010\u00160\u00162\u0006\u0010\n\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u00052*\u0010\u000e\u001a&\u0012\f\u0012\n \t*\u0004\u0018\u0001H$H$ \t*\u0012\u0012\f\u0012\n \t*\u0004\u0018\u0001H$H$\u0018\u00010%0%H\u0001¢\u0006\u0002\u0010&J\b\u0010'\u001a\u00020\u0005H\u0016J)\u0010(\u001a\n \t*\u0004\u0018\u00010\u00010\u00012\u0006\u0010\n\u001a\u00020\u00052\u000e\u0010\r\u001a\n \t*\u0004\u0018\u00010\f0\fH\u0001J9\u0010(\u001a\n \t*\u0004\u0018\u00010\u00010\u00012\u0006\u0010\n\u001a\u00020\u00052\u000e\u0010\r\u001a\n \t*\u0004\u0018\u00010\f0\f2\u0006\u0010\u000e\u001a\u00020\u00052\u0006\u0010\u001b\u001a\u00020\u0005H\u0001JA\u0010)\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u00052&\u0010\u000e\u001a\"\u0012\f\u0012\n \t*\u0004\u0018\u00010\u00160\u0016 \t*\u000b\u0012\u0002\b\u0003\u0018\u00010%¨\u0006\u00010%¨\u0006\u0001H\u0001J\u0019\u0010*\u001a\u00020\u00102\u000e\u0010\n\u001a\n \t*\u0004\u0018\u00010\u00160\u0016H\u0001J1\u0010+\u001a\n \t*\u0004\u0018\u00010\u00010\u00012\u0006\u0010\n\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u00052\u000e\u0010\u000e\u001a\n \t*\u0004\u0018\u00010\f0\fH\u0001JA\u0010+\u001a\n \t*\u0004\u0018\u00010\u00010\u00012\u0006\u0010\n\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u00052\u000e\u0010\u000e\u001a\n \t*\u0004\u0018\u00010\f0\f2\u0006\u0010\u001b\u001a\u00020\u00052\u0006\u0010,\u001a\u00020\u0005H\u0001J<\u0010-\u001a\u00020\u00102,\u0010\n\u001a(\u0012\f\u0012\n \t*\u0004\u0018\u00010\u001e0\u001e \t*\u0014\u0012\u000e\b\u0001\u0012\n \t*\u0004\u0018\u00010\u001e0\u001e\u0018\u00010\u001d0\u001dH\u0001¢\u0006\u0002\u0010.J1\u0010/\u001a\u00020\u00102\u000e\u0010\n\u001a\n \t*\u0004\u0018\u00010\u00160\u00162\u0006\u0010\r\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\u00052\u0006\u0010\u001b\u001a\u00020\u0005H\u0001J\u0019\u00100\u001a\u00020\f2\u0006\u00101\u001a\u00020\u00052\u0006\u00102\u001a\u00020\u0005H\u0001J\b\u00103\u001a\u000204H\u0016R\u000e\u0010\u0002\u001a\u00020\u0001X\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\u0004\u001a\u00020\u0005X\u0005¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007¨\u00065"}, d2 = {"Lcom/sumsub/sns/core/widget/SNSTextInputEditText$EditableProxy;", "Landroid/text/Editable;", "editable", "(Lcom/sumsub/sns/core/widget/SNSTextInputEditText;Landroid/text/Editable;)V", "length", "", "getLength", "()I", "append", "kotlin.jvm.PlatformType", "p0", "", "", "p1", "p2", "clear", "", "clearSpans", "delete", "equals", "", "other", "", "get", "index", "getChars", "", "p3", "getFilters", "", "Landroid/text/InputFilter;", "()[Landroid/text/InputFilter;", "getSpanEnd", "getSpanFlags", "getSpanStart", "getSpans", "T", "Ljava/lang/Class;", "(IILjava/lang/Class;)[Ljava/lang/Object;", "hashCode", "insert", "nextSpanTransition", "removeSpan", "replace", "p4", "setFilters", "([Landroid/text/InputFilter;)V", "setSpan", "subSequence", "startIndex", "endIndex", "toString", "", "idensic-mobile-sdk-aar_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public final class EditableProxy implements Editable {
        private final Editable editable;

        public EditableProxy(Editable editable2) {
            this.editable = editable2;
        }

        public Editable append(char c11) {
            return this.editable.append(c11);
        }

        public final /* bridge */ char charAt(int i11) {
            return get(i11);
        }

        public void clear() {
            this.editable.clear();
            StringBuilder unused = StringsKt__StringBuilderJVMKt.i(SNSTextInputEditText.this.raw);
            SNSTextInputEditText.this.setText("");
        }

        public void clearSpans() {
            this.editable.clearSpans();
        }

        public Editable delete(int i11, int i12) {
            return this.editable.delete(i11, i12);
        }

        public boolean equals(Object obj) {
            return this.editable.equals(obj);
        }

        public char get(int i11) {
            return this.editable.charAt(i11);
        }

        public void getChars(int i11, int i12, char[] cArr, int i13) {
            this.editable.getChars(i11, i12, cArr, i13);
        }

        public InputFilter[] getFilters() {
            return this.editable.getFilters();
        }

        public int getLength() {
            return this.editable.length();
        }

        public int getSpanEnd(Object obj) {
            return this.editable.getSpanEnd(obj);
        }

        public int getSpanFlags(Object obj) {
            return this.editable.getSpanFlags(obj);
        }

        public int getSpanStart(Object obj) {
            return this.editable.getSpanStart(obj);
        }

        public <T> T[] getSpans(int i11, int i12, Class<T> cls) {
            return this.editable.getSpans(i11, i12, cls);
        }

        public int hashCode() {
            return this.editable.hashCode();
        }

        public Editable insert(int i11, CharSequence charSequence) {
            return this.editable.insert(i11, charSequence);
        }

        public final /* bridge */ int length() {
            return getLength();
        }

        public int nextSpanTransition(int i11, int i12, Class cls) {
            return this.editable.nextSpanTransition(i11, i12, cls);
        }

        public void removeSpan(Object obj) {
            this.editable.removeSpan(obj);
        }

        public Editable replace(int i11, int i12, CharSequence charSequence) {
            return this.editable.replace(i11, i12, charSequence);
        }

        public void setFilters(InputFilter[] inputFilterArr) {
            this.editable.setFilters(inputFilterArr);
        }

        public void setSpan(Object obj, int i11, int i12, int i13) {
            this.editable.setSpan(obj, i11, i12, i13);
        }

        public CharSequence subSequence(int i11, int i12) {
            return this.editable.subSequence(i11, i12);
        }

        public String toString() {
            return this.editable.toString();
        }

        public Editable append(CharSequence charSequence) {
            return this.editable.append(charSequence);
        }

        public Editable insert(int i11, CharSequence charSequence, int i12, int i13) {
            return this.editable.insert(i11, charSequence, i12, i13);
        }

        public Editable replace(int i11, int i12, CharSequence charSequence, int i13, int i14) {
            return this.editable.replace(i11, i12, charSequence, i13, i14);
        }

        public Editable append(CharSequence charSequence, int i11, int i12) {
            return this.editable.append(charSequence, i11, i12);
        }
    }

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\r\n\u0000\bf\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&J\u0018\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\tH\u0016ø\u0001\u0000\u0002\u0006\n\u0004\b!0\u0001¨\u0006\nÀ\u0006\u0001"}, d2 = {"Lcom/sumsub/sns/core/widget/SNSTextInputEditText$MaskListener;", "", "onMaskChanged", "", "newMask", "Lcom/sumsub/sns/core/widget/SNSTextInputEditText$Mask;", "preFilterMasks", "", "raw", "", "idensic-mobile-sdk-aar_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public interface MaskListener {
        void onMaskChanged(Mask mask);

        List<Mask> preFilterMasks(CharSequence charSequence);
    }

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\bJ\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0005HÆ\u0003J\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0007HÆ\u0003J)\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00032\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0005HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u0018"}, d2 = {"Lcom/sumsub/sns/core/widget/SNSTextInputEditText$MaskMatchResult;", "", "matches", "", "weight", "", "mask", "Lcom/sumsub/sns/core/widget/SNSTextInputEditText$Mask;", "(ZILcom/sumsub/sns/core/widget/SNSTextInputEditText$Mask;)V", "getMask", "()Lcom/sumsub/sns/core/widget/SNSTextInputEditText$Mask;", "getMatches", "()Z", "getWeight", "()I", "component1", "component2", "component3", "copy", "equals", "other", "hashCode", "toString", "", "idensic-mobile-sdk-aar_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class MaskMatchResult {
        private final Mask mask;
        private final boolean matches;
        private final int weight;

        public MaskMatchResult(boolean z11, int i11, Mask mask2) {
            this.matches = z11;
            this.weight = i11;
            this.mask = mask2;
        }

        public static /* synthetic */ MaskMatchResult copy$default(MaskMatchResult maskMatchResult, boolean z11, int i11, Mask mask2, int i12, Object obj) {
            if ((i12 & 1) != 0) {
                z11 = maskMatchResult.matches;
            }
            if ((i12 & 2) != 0) {
                i11 = maskMatchResult.weight;
            }
            if ((i12 & 4) != 0) {
                mask2 = maskMatchResult.mask;
            }
            return maskMatchResult.copy(z11, i11, mask2);
        }

        public final boolean component1() {
            return this.matches;
        }

        public final int component2() {
            return this.weight;
        }

        public final Mask component3() {
            return this.mask;
        }

        public final MaskMatchResult copy(boolean z11, int i11, Mask mask2) {
            return new MaskMatchResult(z11, i11, mask2);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof MaskMatchResult)) {
                return false;
            }
            MaskMatchResult maskMatchResult = (MaskMatchResult) obj;
            return this.matches == maskMatchResult.matches && this.weight == maskMatchResult.weight && x.b(this.mask, maskMatchResult.mask);
        }

        public final Mask getMask() {
            return this.mask;
        }

        public final boolean getMatches() {
            return this.matches;
        }

        public final int getWeight() {
            return this.weight;
        }

        public int hashCode() {
            boolean z11 = this.matches;
            if (z11) {
                z11 = true;
            }
            int i11 = (((z11 ? 1 : 0) * true) + this.weight) * 31;
            Mask mask2 = this.mask;
            return i11 + (mask2 == null ? 0 : mask2.hashCode());
        }

        public String toString() {
            return "MaskMatchResult(matches=" + this.matches + ", weight=" + this.weight + ", mask=" + this.mask + ')';
        }
    }

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0018\u0010\u0007\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\tH\u0016¨\u0006\u000b"}, d2 = {"Lcom/sumsub/sns/core/widget/SNSTextInputEditText$MyInputConnectionWrapper;", "Landroid/view/inputmethod/InputConnectionWrapper;", "target", "Landroid/view/inputmethod/InputConnection;", "mutable", "", "(Lcom/sumsub/sns/core/widget/SNSTextInputEditText;Landroid/view/inputmethod/InputConnection;Z)V", "deleteSurroundingText", "beforeLength", "", "afterLength", "idensic-mobile-sdk-aar_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public final class MyInputConnectionWrapper extends InputConnectionWrapper {
        public MyInputConnectionWrapper(InputConnection inputConnection, boolean z11) {
            super(inputConnection, z11);
        }

        public boolean deleteSurroundingText(int i11, int i12) {
            if (!(SNSTextInputEditText.this.raw.length() == 0)) {
                return super.deleteSurroundingText(i11, i12);
            }
            a.c(com.sumsub.sns.internal.log.a.f34862a, SNSTextInputEditText.LOG_TAG, "Delete event return", (Throwable) null, 4, (Object) null);
            SNSTextInputEditText.this.setText((CharSequence) null);
            return true;
        }
    }

    public SNSTextInputEditText(Context context) {
        this(context, (AttributeSet) null, 0, 6, (r) null);
    }

    private final void appendMaskChar(StringBuilder sb2, Character ch2, boolean z11) {
        if (ch2 != null) {
            if (z11) {
                sb2.append(ch2.charValue());
            } else {
                sb2.append(Companion.maskCharToPlaceholder(ch2.charValue()));
            }
        }
    }

    /* access modifiers changed from: private */
    public final void applyMask(Editable editable) {
        int i11;
        int i12;
        if (getMasksEnabled()) {
            if (this.mask != null) {
                StringBuilder unused = StringsKt__StringBuilderJVMKt.i(this.buffer);
                String str = null;
                if (editable != null) {
                    removeHintSpans$default(this, editable, false, 1, (Object) null);
                }
                HashMap<String, List<CharHolder>> hashMap = this.maskSymbolPositions;
                Mask mask2 = this.mask;
                if (mask2 != null) {
                    str = mask2.getMask();
                }
                List<CharHolder> list = hashMap.get(str);
                if (list != null) {
                    i11 = 0;
                    for (CharHolder charHolder : list) {
                        char c11 = charHolder.getChar();
                        if (charHolder.getPos() < 0) {
                            appendMaskChar(this.buffer, Character.valueOf(c11), charHolder.getEscaped());
                        } else if (charHolder.getPos() < this.raw.length()) {
                            this.buffer.append(Companion.modifyCharRegister(Character.valueOf(c11), this.raw.charAt(charHolder.getPos())));
                            i11++;
                        } else {
                            appendMaskChar(this.buffer, Character.valueOf(c11), charHolder.getEscaped());
                        }
                    }
                } else {
                    i11 = 0;
                }
                int length = this.raw.length();
                for (int i13 = i11; i13 < length; i13++) {
                    this.buffer.append(this.raw.charAt(i13));
                }
                if (editable != null) {
                    editable.append(this.buffer);
                }
                if (list != null) {
                    Iterator it2 = list.iterator();
                    i12 = 0;
                    while (true) {
                        if (!it2.hasNext()) {
                            break;
                        }
                        if (((CharHolder) it2.next()).getPos() == i11) {
                            break;
                        }
                        i12++;
                    }
                    if (i12 >= 0 && editable != null) {
                        editable.setSpan(new ForegroundColorSpan(getCurrentHintTextColor()), i12, editable.length(), 0);
                        return;
                    }
                }
                i12 = -1;
                if (i12 >= 0) {
                }
            } else if (editable != null) {
                removeHintSpans(editable, false);
            }
        }
    }

    /* access modifiers changed from: private */
    public final void cleanRaw() {
        if (this.mask != null) {
            StringBuilder sb2 = this.raw;
            StringBuilder sb3 = new StringBuilder();
            int length = sb2.length();
            boolean z11 = false;
            for (int i11 = 0; i11 < length; i11++) {
                char charAt = sb2.charAt(i11);
                if (Companion.isCharMaskPart(charAt)) {
                    sb3.append(charAt);
                }
            }
            CharSequence p12 = StringsKt___StringsKt.p1(sb3, this.maxRawLength);
            if (p12.length() != this.raw.length()) {
                StringBuilder unused = StringsKt__StringBuilderJVMKt.i(this.raw);
                this.raw.append(p12);
            }
            if (this.raw.length() == 0) {
                z11 = true;
            }
            if (z11) {
                setDefaultMask();
            }
        }
    }

    /* access modifiers changed from: private */
    public final Mask findNewMask() {
        List<Mask> list;
        ArrayList arrayList;
        ArrayList arrayList2;
        MaskMatchResult maskMatchResult;
        Object obj;
        boolean z11;
        Mask mask2 = this.mask;
        StringBuilder sb2 = this.raw;
        MaskListener maskListener2 = this.maskListener;
        if (maskListener2 == null || (list = maskListener2.preFilterMasks(sb2)) == null) {
            list = this.masksInternal;
        }
        if (list != null) {
            arrayList = new ArrayList(CollectionsKt__IterablesKt.u(list, 10));
            for (Mask maskMatches : list) {
                arrayList.add(maskMatches(sb2, maskMatches));
            }
        } else {
            arrayList = null;
        }
        if (arrayList != null) {
            arrayList2 = new ArrayList();
            for (Object next : arrayList) {
                if (((MaskMatchResult) next).getMatches()) {
                    arrayList2.add(next);
                }
            }
        } else {
            arrayList2 = null;
        }
        boolean z12 = true;
        if (arrayList2 != null && (arrayList2.isEmpty() ^ true)) {
            if (!(arrayList2 instanceof Collection) || !arrayList2.isEmpty()) {
                Iterator it2 = arrayList2.iterator();
                while (true) {
                    if (it2.hasNext()) {
                        if (((MaskMatchResult) it2.next()).getWeight() == ((MaskMatchResult) arrayList2.get(0)).getWeight()) {
                            z11 = true;
                            continue;
                        } else {
                            z11 = false;
                            continue;
                        }
                        if (!z11) {
                            z12 = false;
                            break;
                        }
                    } else {
                        break;
                    }
                }
            }
            if (z12) {
                MaskMatchResult maskMatches2 = maskMatches(sb2, mask2);
                if (maskMatches2.getMatches() && maskMatches2.getWeight() >= ((MaskMatchResult) arrayList2.get(0)).getWeight()) {
                    return mask2;
                }
            }
        }
        if (arrayList2 != null) {
            Iterator it3 = arrayList2.iterator();
            if (!it3.hasNext()) {
                obj = null;
            } else {
                obj = it3.next();
                if (it3.hasNext()) {
                    int weight = ((MaskMatchResult) obj).getWeight();
                    do {
                        Object next2 = it3.next();
                        int weight2 = ((MaskMatchResult) next2).getWeight();
                        if (weight < weight2) {
                            obj = next2;
                            weight = weight2;
                        }
                    } while (it3.hasNext());
                }
            }
            maskMatchResult = (MaskMatchResult) obj;
        } else {
            maskMatchResult = null;
        }
        if (maskMatchResult != null) {
            return maskMatchResult.getMask();
        }
        return null;
    }

    private final int getMaskSymbolsCount(int i11, String str) {
        List list = this.maskSymbolPositions.get(str);
        int i12 = 0;
        if (list == null) {
            return 0;
        }
        int size = list.size();
        int i13 = 0;
        while (i12 < size && i12 != i11) {
            if (((CharHolder) list.get(i12)).getPos() >= 0) {
                i13++;
            }
            i12++;
        }
        return i11 > i13 ? i11 - getSpecialSymbolsInMaskedTextCount(i11, str) : i13;
    }

    public static /* synthetic */ int getMaskSymbolsCount$default(SNSTextInputEditText sNSTextInputEditText, int i11, String str, int i12, Object obj) {
        if ((i12 & 2) != 0) {
            Mask mask2 = sNSTextInputEditText.mask;
            str = mask2 != null ? mask2.getMask() : null;
        }
        return sNSTextInputEditText.getMaskSymbolsCount(i11, str);
    }

    /* access modifiers changed from: private */
    public final int getRemovedSymbolsCount() {
        return this.lastRaw.length() - this.raw.length();
    }

    private final int getSpecialSymbolsInMaskedTextCount(int i11, String str) {
        List list;
        int i12 = 0;
        if (i11 <= 0 || (list = this.maskSymbolPositions.get(str)) == null) {
            return 0;
        }
        int length = this.raw.length();
        int size = list.size();
        int i13 = 0;
        int i14 = 0;
        while (i12 < size && i12 != i11 && i13 != length) {
            if (((CharHolder) list.get(i12)).getPos() < 0) {
                i14++;
            } else {
                i13++;
            }
            i12++;
        }
        return i14;
    }

    public static /* synthetic */ int getSpecialSymbolsInMaskedTextCount$default(SNSTextInputEditText sNSTextInputEditText, int i11, String str, int i12, Object obj) {
        if ((i12 & 2) != 0) {
            Mask mask2 = sNSTextInputEditText.mask;
            str = mask2 != null ? mask2.getMask() : null;
        }
        return sNSTextInputEditText.getSpecialSymbolsInMaskedTextCount(i11, str);
    }

    /* access modifiers changed from: private */
    public final int getStartingPosition() {
        boolean z11;
        HashMap<String, List<CharHolder>> hashMap = this.maskSymbolPositions;
        Mask mask2 = this.mask;
        Integer num = null;
        List list = hashMap.get(mask2 != null ? mask2.getMask() : null);
        if (list == null) {
            return 0;
        }
        Iterator it2 = list.iterator();
        int i11 = 0;
        while (true) {
            z11 = true;
            if (!it2.hasNext()) {
                i11 = -1;
                break;
            }
            if (((CharHolder) it2.next()).getPos() >= 0) {
                break;
            }
            i11++;
        }
        Integer valueOf = Integer.valueOf(i11);
        if (valueOf.intValue() < 0) {
            z11 = false;
        }
        if (z11) {
            num = valueOf;
        }
        if (num != null) {
            return num.intValue();
        }
        return 0;
    }

    private final MaskMatchResult maskMatches(CharSequence charSequence, Mask mask2) {
        if (mask2 == null) {
            return new MaskMatchResult(false, 0, mask2);
        }
        List list = this.masksCleared.get(mask2.getMask());
        if (list == null) {
            return new MaskMatchResult(false, 0, mask2);
        }
        int i11 = 0;
        int i12 = 0;
        int i13 = 0;
        while (true) {
            int i14 = 1;
            if (i11 >= charSequence.length()) {
                return new MaskMatchResult(true, i12, mask2);
            }
            char charAt = charSequence.charAt(i11);
            int i15 = i13 + 1;
            if (i13 >= list.size()) {
                return new MaskMatchResult(mask2.getMaskValidIfOverflow(), i12, mask2);
            }
            if (!Companion.symbolMatches(charAt, (CharHolder) list.get(i13), mask2.getSoftMatch())) {
                return new MaskMatchResult(false, i12, mask2);
            }
            if (CharsKt__CharKt.e(charAt, ((CharHolder) list.get(i13)).getChar(), true)) {
                i14 = 4;
            } else if ((((CharHolder) list.get(i13)).getChar() == '#' && Character.isDigit(charAt)) || (((CharHolder) list.get(i13)).getChar() == '?' && Character.isLetter(charAt))) {
                i14 = 2;
            }
            i12 += i14;
            i11++;
            i13 = i15;
        }
    }

    /* access modifiers changed from: private */
    public final void prepareMask(Mask mask2) {
        if (!x.b(this.mask, mask2)) {
            com.sumsub.sns.internal.log.a aVar = com.sumsub.sns.internal.log.a.f34862a;
            a.c(aVar, LOG_TAG, "prepareMask " + mask2, (Throwable) null, 4, (Object) null);
            this.mask = mask2;
            MaskListener maskListener2 = this.maskListener;
            if (maskListener2 != null) {
                maskListener2.onMaskChanged(mask2);
            }
        }
    }

    private final void prepareMasks() {
        SNSTextInputEditText sNSTextInputEditText = this;
        List<Mask> list = sNSTextInputEditText.masksInternal;
        if (list != null) {
            int i11 = 0;
            for (T next : list) {
                int i12 = i11 + 1;
                if (i11 < 0) {
                    CollectionsKt__CollectionsKt.t();
                }
                Mask mask2 = (Mask) next;
                ArrayList arrayList = new ArrayList();
                sNSTextInputEditText.maskSymbolPositions.put(mask2.getMask(), arrayList);
                ArrayList arrayList2 = new ArrayList();
                sNSTextInputEditText.masksCleared.put(mask2.getMask(), arrayList2);
                String mask3 = mask2.getMask();
                int i13 = 0;
                int i14 = 0;
                boolean z11 = false;
                while (i13 < mask3.length()) {
                    char charAt = mask3.charAt(i13);
                    if (charAt != '\\' || z11) {
                        if (!Companion.isCharMaskPart(charAt) || z11) {
                            arrayList.add(new CharHolder(charAt, -1, z11));
                            i14 = i14;
                        } else {
                            CharHolder charHolder = r9;
                            int i15 = i14;
                            CharHolder charHolder2 = new CharHolder(charAt, 0, z11, 2, (r) null);
                            arrayList2.add(charHolder);
                            arrayList.add(new CharHolder(charAt, i15, z11));
                            i14 = i15 + 1;
                        }
                        z11 = false;
                    } else {
                        z11 = true;
                    }
                    i13++;
                }
                a.c(com.sumsub.sns.internal.log.a.f34862a, c.a(this), "Mask " + mask2 + " cleared " + arrayList2, (Throwable) null, 4, (Object) null);
                sNSTextInputEditText = this;
                i11 = i12;
            }
        }
        setDefaultMask();
    }

    /* access modifiers changed from: private */
    public final int prevValidCharPosition(int i11) {
        CharHolder charHolder;
        if (i11 < 0) {
            return 0;
        }
        HashMap<String, List<CharHolder>> hashMap = this.maskSymbolPositions;
        Mask mask2 = this.mask;
        List list = hashMap.get(mask2 != null ? mask2.getMask() : null);
        if (list == null || (charHolder = (CharHolder) CollectionsKt___CollectionsKt.d0(list, i11)) == null) {
            return i11 - getSpecialSymbolsInMaskedTextCount$default(this, i11, (String) null, 2, (Object) null);
        }
        if (charHolder.getPos() < 0) {
            return prevValidCharPosition(i11 - 1);
        }
        return charHolder.getPos();
    }

    private final void removeHintSpans(Editable editable, boolean z11) {
        if (editable != null) {
            if (z11) {
                editable.clear();
            }
            for (Object obj : editable.getSpans(0, editable.length(), ForegroundColorSpan.class)) {
                editable.removeSpan((ForegroundColorSpan) obj);
            }
        }
    }

    public static /* synthetic */ void removeHintSpans$default(SNSTextInputEditText sNSTextInputEditText, Editable editable, boolean z11, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            z11 = true;
        }
        sNSTextInputEditText.removeHintSpans(editable, z11);
    }

    private final void setDefaultMask() {
        List<Mask> list = this.masksInternal;
        T t11 = null;
        if (list != null) {
            Iterator<T> it2 = list.iterator();
            if (it2.hasNext()) {
                t11 = it2.next();
                if (it2.hasNext()) {
                    int length = ((Mask) t11).getMask().length();
                    do {
                        T next = it2.next();
                        int length2 = ((Mask) next).getMask().length();
                        if (length > length2) {
                            t11 = next;
                            length = length2;
                        }
                    } while (it2.hasNext());
                }
            }
            t11 = (Mask) t11;
        }
        prepareMask(t11);
    }

    private final void setMasksInternal(List<Mask> list) {
        this.masksInternal = list;
        if (list != null && (list.isEmpty() ^ true)) {
            updateInputType$default(this, (Integer) null, 1, (Object) null);
        }
        prepareMasks();
    }

    public static /* synthetic */ void updateInputType$default(SNSTextInputEditText sNSTextInputEditText, Integer num, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            num = null;
        }
        sNSTextInputEditText.updateInputType(num);
    }

    public final MaskListener getMaskListener() {
        return this.maskListener;
    }

    public final boolean getMasksEnabled() {
        List<Mask> list = this.masksInternal;
        return list != null && (list.isEmpty() ^ true);
    }

    public final String getRawText() {
        return (!getMasksEnabled() || this.mask == null) ? String.valueOf(getText()) : this.raw.toString();
    }

    public boolean isSuggestionsEnabled() {
        if (getMasksEnabled()) {
            return false;
        }
        return super.isSuggestionsEnabled();
    }

    public InputConnection onCreateInputConnection(EditorInfo editorInfo) {
        if (!getMasksEnabled()) {
            return super.onCreateInputConnection(editorInfo);
        }
        InputConnection onCreateInputConnection = super.onCreateInputConnection(editorInfo);
        if (onCreateInputConnection == null) {
            return null;
        }
        return new MyInputConnectionWrapper(onCreateInputConnection, true);
    }

    public void onSelectionChanged(int i11, int i12) {
        if (!this.isTextChangingAfter && !this.isTextChangingBefore && !this.isSelectionChanging && getMasksEnabled()) {
            super.onSelectionChanged(i11, i12);
            HashMap<String, List<CharHolder>> hashMap = this.maskSymbolPositions;
            Mask mask2 = this.mask;
            List list = hashMap.get(mask2 != null ? mask2.getMask() : null);
            if (list != null) {
                int length = this.raw.length() + getSpecialSymbolsInMaskedTextCount$default(this, i11, (String) null, 2, (Object) null);
                int length2 = this.raw.length() + getSpecialSymbolsInMaskedTextCount$default(this, i12, (String) null, 2, (Object) null);
                int startingPosition = getStartingPosition();
                int max = Math.max(startingPosition, Math.min(length, i11));
                int max2 = Math.max(startingPosition, Math.min(length2, i12));
                while (max < list.size() && ((CharHolder) list.get(max)).getPos() < 0) {
                    max++;
                }
                while (max2 < list.size() && ((CharHolder) list.get(max2)).getPos() < 0) {
                    max2++;
                }
                this.isSelectionChanging = true;
                setSelection(max, max2);
                com.sumsub.sns.internal.log.a aVar = com.sumsub.sns.internal.log.a.f34862a;
                String a11 = c.a(this);
                a.c(aVar, a11, "onSelectionChanged, selStart=" + i11 + ", selEnd=" + i12 + ", start=" + max + ", end=" + max2, (Throwable) null, 4, (Object) null);
                this.isSelectionChanging = false;
            }
        }
    }

    public void setError(CharSequence charSequence) {
        super.setError(charSequence);
    }

    public final void setMaskListener(MaskListener maskListener2) {
        this.maskListener = maskListener2;
    }

    public final void setMasks(List<Mask> list) {
        setMasksInternal(list);
    }

    public final void setMasksString(List<String> list) {
        ArrayList arrayList;
        if (list != null) {
            arrayList = new ArrayList(CollectionsKt__IterablesKt.u(list, 10));
            for (String mask2 : list) {
                arrayList.add(new Mask(mask2, false, false, false, (Object) null, 30, (r) null));
            }
        } else {
            arrayList = null;
        }
        setMasksInternal(arrayList);
    }

    public final void setMaxLength(int i11) {
        this.maxRawLength = i11;
    }

    public final void updateInputType(Integer num) {
        Typeface typeface = getTypeface();
        int i11 = 524432;
        if (num != null) {
            i11 = 524432 | num.intValue();
        }
        setInputType(i11);
        setFilters(new InputFilter[0]);
        setTypeface(typeface);
    }

    public SNSTextInputEditText(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, (r) null);
    }

    public Editable getText() {
        Editable text = super.getText();
        return (!getMasksEnabled() || text == null) ? text : new EditableProxy(text);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ SNSTextInputEditText(Context context, AttributeSet attributeSet, int i11, int i12, r rVar) {
        this(context, (i12 & 2) != 0 ? null : attributeSet, (i12 & 4) != 0 ? R.attr.sns_TextInputEditTextStyle : i11);
    }

    public SNSTextInputEditText(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        this.masksCleared = new HashMap<>();
        this.maskSymbolPositions = new HashMap<>();
        this.raw = new StringBuilder();
        this.lastRaw = "";
        this.buffer = new StringBuilder();
        this.maxRawLength = Integer.MAX_VALUE;
        SNSTextInputEditText$textWatcher$1 sNSTextInputEditText$textWatcher$1 = new SNSTextInputEditText$textWatcher$1(this);
        this.textWatcher = sNSTextInputEditText$textWatcher$1;
        addTextChangedListener(sNSTextInputEditText$textWatcher$1);
    }

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0015\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B7\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0005\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0001¢\u0006\u0002\u0010\tJ\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0005HÆ\u0003J\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÆ\u0003J=\u0010\u0017\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00052\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0001HÆ\u0001J\u0013\u0010\u0018\u001a\u00020\u00052\b\u0010\u0019\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001a\u001a\u00020\u001bHÖ\u0001J\t\u0010\u001c\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000bR\u0013\u0010\b\u001a\u0004\u0018\u00010\u0001¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0007\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000b¨\u0006\u001d"}, d2 = {"Lcom/sumsub/sns/core/widget/SNSTextInputEditText$Mask;", "", "mask", "", "limitInputByLength", "", "maskValidIfOverflow", "softMatch", "payload", "(Ljava/lang/String;ZZZLjava/lang/Object;)V", "getLimitInputByLength", "()Z", "getMask", "()Ljava/lang/String;", "getMaskValidIfOverflow", "getPayload", "()Ljava/lang/Object;", "getSoftMatch", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "other", "hashCode", "", "toString", "idensic-mobile-sdk-aar_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class Mask {
        private final boolean limitInputByLength;
        private final String mask;
        private final boolean maskValidIfOverflow;
        private final Object payload;
        private final boolean softMatch;

        public Mask(String str, boolean z11, boolean z12, boolean z13, Object obj) {
            this.mask = str;
            this.limitInputByLength = z11;
            this.maskValidIfOverflow = z12;
            this.softMatch = z13;
            this.payload = obj;
        }

        public static /* synthetic */ Mask copy$default(Mask mask2, String str, boolean z11, boolean z12, boolean z13, Object obj, int i11, Object obj2) {
            if ((i11 & 1) != 0) {
                str = mask2.mask;
            }
            if ((i11 & 2) != 0) {
                z11 = mask2.limitInputByLength;
            }
            boolean z14 = z11;
            if ((i11 & 4) != 0) {
                z12 = mask2.maskValidIfOverflow;
            }
            boolean z15 = z12;
            if ((i11 & 8) != 0) {
                z13 = mask2.softMatch;
            }
            boolean z16 = z13;
            if ((i11 & 16) != 0) {
                obj = mask2.payload;
            }
            return mask2.copy(str, z14, z15, z16, obj);
        }

        public final String component1() {
            return this.mask;
        }

        public final boolean component2() {
            return this.limitInputByLength;
        }

        public final boolean component3() {
            return this.maskValidIfOverflow;
        }

        public final boolean component4() {
            return this.softMatch;
        }

        public final Object component5() {
            return this.payload;
        }

        public final Mask copy(String str, boolean z11, boolean z12, boolean z13, Object obj) {
            return new Mask(str, z11, z12, z13, obj);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Mask)) {
                return false;
            }
            Mask mask2 = (Mask) obj;
            return x.b(this.mask, mask2.mask) && this.limitInputByLength == mask2.limitInputByLength && this.maskValidIfOverflow == mask2.maskValidIfOverflow && this.softMatch == mask2.softMatch && x.b(this.payload, mask2.payload);
        }

        public final boolean getLimitInputByLength() {
            return this.limitInputByLength;
        }

        public final String getMask() {
            return this.mask;
        }

        public final boolean getMaskValidIfOverflow() {
            return this.maskValidIfOverflow;
        }

        public final Object getPayload() {
            return this.payload;
        }

        public final boolean getSoftMatch() {
            return this.softMatch;
        }

        public int hashCode() {
            int hashCode = this.mask.hashCode() * 31;
            boolean z11 = this.limitInputByLength;
            boolean z12 = true;
            if (z11) {
                z11 = true;
            }
            int i11 = (hashCode + (z11 ? 1 : 0)) * 31;
            boolean z13 = this.maskValidIfOverflow;
            if (z13) {
                z13 = true;
            }
            int i12 = (i11 + (z13 ? 1 : 0)) * 31;
            boolean z14 = this.softMatch;
            if (!z14) {
                z12 = z14;
            }
            int i13 = (i12 + (z12 ? 1 : 0)) * 31;
            Object obj = this.payload;
            return i13 + (obj == null ? 0 : obj.hashCode());
        }

        public String toString() {
            return "Mask(mask=" + this.mask + ", limitInputByLength=" + this.limitInputByLength + ", maskValidIfOverflow=" + this.maskValidIfOverflow + ", softMatch=" + this.softMatch + ", payload=" + this.payload + ')';
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ Mask(String str, boolean z11, boolean z12, boolean z13, Object obj, int i11, r rVar) {
            this(str, (i11 & 2) != 0 ? false : z11, (i11 & 4) != 0 ? true : z12, (i11 & 8) != 0 ? true : z13, (i11 & 16) != 0 ? null : obj);
        }
    }
}
