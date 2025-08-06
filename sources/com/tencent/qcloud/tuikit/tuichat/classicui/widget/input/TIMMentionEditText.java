package com.tencent.qcloud.tuikit.tuichat.classicui.widget.input;

import android.content.Context;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.view.inputmethod.InputConnectionWrapper;
import android.widget.EditText;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class TIMMentionEditText extends EditText {
    public static final String TIM_MENTION_TAG = "@";
    public static final String TIM_MENTION_TAG_FULL = "＠";
    /* access modifiers changed from: private */
    public boolean mIsSelected;
    /* access modifiers changed from: private */
    public Range mLastSelectedRange;
    /* access modifiers changed from: private */
    public OnMentionInputListener mOnMentionInputListener;
    private List<Range> mRangeArrayList = new ArrayList();
    private Map<String, String> mentionMap = new HashMap();
    /* access modifiers changed from: private */
    public List<String> mentionTagList = new ArrayList();

    public class HackInputConnection extends InputConnectionWrapper {
        private EditText editText;

        public HackInputConnection(InputConnection inputConnection, boolean z11, TIMMentionEditText tIMMentionEditText) {
            super(inputConnection, z11);
            this.editText = tIMMentionEditText;
        }

        public boolean deleteSurroundingText(int i11, int i12) {
            if (i11 != 1 || i12 != 0) {
                return super.deleteSurroundingText(i11, i12);
            }
            if (!sendKeyEvent(new KeyEvent(0, 67)) || !sendKeyEvent(new KeyEvent(1, 67))) {
                return false;
            }
            return true;
        }

        public boolean sendKeyEvent(KeyEvent keyEvent) {
            if (keyEvent.getAction() != 0 || keyEvent.getKeyCode() != 67) {
                return super.sendKeyEvent(keyEvent);
            }
            int selectionStart = this.editText.getSelectionStart();
            Range access$300 = TIMMentionEditText.this.getRangeOfClosestMentionString(selectionStart, this.editText.getSelectionEnd());
            if (access$300 == null) {
                boolean unused = TIMMentionEditText.this.mIsSelected = false;
                return super.sendKeyEvent(keyEvent);
            } else if (TIMMentionEditText.this.mIsSelected || selectionStart == access$300.from) {
                boolean unused2 = TIMMentionEditText.this.mIsSelected = false;
                return super.sendKeyEvent(keyEvent);
            } else {
                boolean unused3 = TIMMentionEditText.this.mIsSelected = true;
                Range unused4 = TIMMentionEditText.this.mLastSelectedRange = access$300;
                setSelection(access$300.f48589to, access$300.from);
                sendKeyEvent(new KeyEvent(0, 67));
                return true;
            }
        }
    }

    public class MentionTextWatcher implements TextWatcher {
        private MentionTextWatcher() {
        }

        public void afterTextChanged(Editable editable) {
        }

        public void beforeTextChanged(CharSequence charSequence, int i11, int i12, int i13) {
        }

        public void onTextChanged(CharSequence charSequence, int i11, int i12, int i13) {
            if (i13 == 1 && !TextUtils.isEmpty(charSequence) && TIMMentionEditText.this.hasFocus()) {
                char charAt = charSequence.toString().charAt(i11);
                for (String str : TIMMentionEditText.this.mentionTagList) {
                    if (str.equals(String.valueOf(charAt)) && TIMMentionEditText.this.mOnMentionInputListener != null) {
                        TIMMentionEditText.this.mOnMentionInputListener.onMentionCharacterInput(str);
                    }
                }
            }
        }
    }

    public interface OnMentionInputListener {
        void onMentionCharacterInput(String str);
    }

    public class Range {
        public int from;

        /* renamed from: to  reason: collision with root package name */
        public int f48589to;
        public String userID;

        public Range(int i11, int i12, String str) {
            this.from = i11;
            this.f48589to = i12;
            this.userID = str;
        }

        public boolean contains(int i11, int i12) {
            return this.from <= i11 && this.f48589to >= i12;
        }

        public int getAnchorPosition(int i11) {
            int i12 = this.from;
            int i13 = this.f48589to;
            return (i11 - i12) - (i13 - i11) >= 0 ? i13 : i12;
        }

        public boolean isEqual(int i11, int i12) {
            int i13 = this.from;
            return (i13 == i11 && this.f48589to == i12) || (i13 == i12 && this.f48589to == i11);
        }

        public boolean isWrappedBy(int i11, int i12) {
            int i13 = this.from;
            return (i11 > i13 && i11 < this.f48589to) || (i12 > i13 && i12 < this.f48589to);
        }
    }

    public TIMMentionEditText(Context context) {
        super(context);
        init();
    }

    /* access modifiers changed from: private */
    public Range getRangeOfClosestMentionString(int i11, int i12) {
        List<Range> list = this.mRangeArrayList;
        if (list == null) {
            return null;
        }
        for (Range next : list) {
            if (next.contains(i11, i12)) {
                return next;
            }
        }
        return null;
    }

    private Range getRangeOfNearbyMentionString(int i11, int i12) {
        List<Range> list = this.mRangeArrayList;
        if (list == null) {
            return null;
        }
        for (Range next : list) {
            if (next.isWrappedBy(i11, i12)) {
                return next;
            }
        }
        return null;
    }

    private void init() {
        this.mentionTagList.clear();
        this.mentionTagList.add(TIM_MENTION_TAG);
        this.mentionTagList.add(TIM_MENTION_TAG_FULL);
        addTextChangedListener(new MentionTextWatcher());
    }

    private void setMentionStringRange() {
        updateMentionList();
        this.mIsSelected = false;
        List<Range> list = this.mRangeArrayList;
        if (list != null) {
            list.clear();
        }
        Editable text = getText();
        if (text != null && !TextUtils.isEmpty(text.toString())) {
            String obj = text.toString();
            if (!TextUtils.isEmpty(obj)) {
                for (String next : this.mentionMap.keySet()) {
                    if (!TextUtils.isEmpty(next)) {
                        int i11 = 0;
                        while (true) {
                            int indexOf = obj.indexOf(next, i11);
                            if (indexOf == -1) {
                                break;
                            }
                            int length = next.length() + indexOf;
                            this.mRangeArrayList.add(new Range(indexOf, length, this.mentionMap.get(next)));
                            i11 = length;
                        }
                    }
                }
                Collections.sort(this.mRangeArrayList, new Comparator<Range>() {
                    public int compare(Range range, Range range2) {
                        return range.from - range2.from;
                    }
                });
            }
        }
    }

    private void updateMentionList() {
        Editable text;
        if (this.mentionMap != null && (text = getText()) != null) {
            String obj = text.toString();
            if (TextUtils.isEmpty(obj)) {
                this.mentionMap.clear();
            }
            Iterator it2 = new ArrayList(this.mentionMap.keySet()).iterator();
            while (it2.hasNext()) {
                String str = (String) it2.next();
                if (!obj.contains(str)) {
                    this.mentionMap.remove(str);
                }
            }
        }
    }

    public List<String> getMentionIdList() {
        ArrayList arrayList = new ArrayList();
        for (Range range : this.mRangeArrayList) {
            arrayList.add(range.userID);
        }
        return arrayList;
    }

    public InputConnection onCreateInputConnection(EditorInfo editorInfo) {
        return new HackInputConnection(super.onCreateInputConnection(editorInfo), true, this);
    }

    public void onSelectionChanged(int i11, int i12) {
        super.onSelectionChanged(i11, i12);
        Range range = this.mLastSelectedRange;
        if (range == null || !range.isEqual(i11, i12)) {
            Range rangeOfClosestMentionString = getRangeOfClosestMentionString(i11, i12);
            if (rangeOfClosestMentionString != null && rangeOfClosestMentionString.f48589to == i12) {
                this.mIsSelected = false;
            }
            Range rangeOfNearbyMentionString = getRangeOfNearbyMentionString(i11, i12);
            if (rangeOfNearbyMentionString != null) {
                if (i11 == i12) {
                    setSelection(rangeOfNearbyMentionString.getAnchorPosition(i11));
                    return;
                }
                int i13 = rangeOfNearbyMentionString.f48589to;
                if (i12 < i13) {
                    setSelection(i11, i13);
                }
                int i14 = rangeOfNearbyMentionString.from;
                if (i11 > i14) {
                    setSelection(i14, i12);
                }
            }
        }
    }

    public void onTextChanged(CharSequence charSequence, int i11, int i12, int i13) {
        setMentionStringRange();
    }

    public void setMentionMap(Map<String, String> map) {
        this.mentionMap.putAll(map);
    }

    public void setOnMentionInputListener(OnMentionInputListener onMentionInputListener) {
        this.mOnMentionInputListener = onMentionInputListener;
    }

    public TIMMentionEditText(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public TIMMentionEditText(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        init();
    }
}
