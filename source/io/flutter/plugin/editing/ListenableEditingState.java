package io.flutter.plugin.editing;

import android.text.Editable;
import android.text.Selection;
import android.text.SpannableStringBuilder;
import android.view.View;
import android.view.inputmethod.BaseInputConnection;
import io.flutter.Log;
import io.flutter.embedding.engine.systemchannels.TextInputChannel;
import java.util.ArrayList;
import java.util.Iterator;

class ListenableEditingState extends SpannableStringBuilder {
    private static final String TAG = "ListenableEditingState";
    private int mBatchEditNestDepth = 0;
    private ArrayList<TextEditingDelta> mBatchTextEditingDeltas = new ArrayList<>();
    private int mChangeNotificationDepth = 0;
    private int mComposingEndWhenBeginBatchEdit;
    private int mComposingStartWhenBeginBatchEdit;
    private BaseInputConnection mDummyConnection;
    private ArrayList<EditingStateWatcher> mListeners = new ArrayList<>();
    private ArrayList<EditingStateWatcher> mPendingListeners = new ArrayList<>();
    private int mSelectionEndWhenBeginBatchEdit;
    private int mSelectionStartWhenBeginBatchEdit;
    private String mTextWhenBeginBatchEdit;
    private String mToStringCache;

    public interface EditingStateWatcher {
        void didChangeEditingState(boolean z11, boolean z12, boolean z13);
    }

    public ListenableEditingState(TextInputChannel.TextEditState textEditState, View view) {
        this.mDummyConnection = new BaseInputConnection(view, true) {
            public Editable getEditable() {
                return this;
            }
        };
        if (textEditState != null) {
            setEditingState(textEditState);
        }
    }

    private void notifyListener(EditingStateWatcher editingStateWatcher, boolean z11, boolean z12, boolean z13) {
        this.mChangeNotificationDepth++;
        editingStateWatcher.didChangeEditingState(z11, z12, z13);
        this.mChangeNotificationDepth--;
    }

    private void notifyListenersIfNeeded(boolean z11, boolean z12, boolean z13) {
        if (z11 || z12 || z13) {
            Iterator<EditingStateWatcher> it2 = this.mListeners.iterator();
            while (it2.hasNext()) {
                notifyListener(it2.next(), z11, z12, z13);
            }
        }
    }

    public void addEditingStateListener(EditingStateWatcher editingStateWatcher) {
        if (this.mChangeNotificationDepth > 0) {
            Log.e(TAG, "adding a listener " + editingStateWatcher.toString() + " in a listener callback");
        }
        if (this.mBatchEditNestDepth > 0) {
            Log.w(TAG, "a listener was added to EditingState while a batch edit was in progress");
            this.mPendingListeners.add(editingStateWatcher);
            return;
        }
        this.mListeners.add(editingStateWatcher);
    }

    public void beginBatchEdit() {
        this.mBatchEditNestDepth++;
        if (this.mChangeNotificationDepth > 0) {
            Log.e(TAG, "editing state should not be changed in a listener callback");
        }
        if (this.mBatchEditNestDepth == 1 && !this.mListeners.isEmpty()) {
            this.mTextWhenBeginBatchEdit = toString();
            this.mSelectionStartWhenBeginBatchEdit = getSelectionStart();
            this.mSelectionEndWhenBeginBatchEdit = getSelectionEnd();
            this.mComposingStartWhenBeginBatchEdit = getComposingStart();
            this.mComposingEndWhenBeginBatchEdit = getComposingEnd();
        }
    }

    public void clearBatchDeltas() {
        this.mBatchTextEditingDeltas.clear();
    }

    public void endBatchEdit() {
        int i11 = this.mBatchEditNestDepth;
        if (i11 == 0) {
            Log.e(TAG, "endBatchEdit called without a matching beginBatchEdit");
            return;
        }
        if (i11 == 1) {
            Iterator<EditingStateWatcher> it2 = this.mPendingListeners.iterator();
            while (it2.hasNext()) {
                notifyListener(it2.next(), true, true, true);
            }
            if (!this.mListeners.isEmpty()) {
                Log.v(TAG, "didFinishBatchEdit with " + String.valueOf(this.mListeners.size()) + " listener(s)");
                boolean equals = toString().equals(this.mTextWhenBeginBatchEdit) ^ true;
                boolean z11 = false;
                boolean z12 = (this.mSelectionStartWhenBeginBatchEdit == getSelectionStart() && this.mSelectionEndWhenBeginBatchEdit == getSelectionEnd()) ? false : true;
                if (!(this.mComposingStartWhenBeginBatchEdit == getComposingStart() && this.mComposingEndWhenBeginBatchEdit == getComposingEnd())) {
                    z11 = true;
                }
                notifyListenersIfNeeded(equals, z12, z11);
            }
        }
        this.mListeners.addAll(this.mPendingListeners);
        this.mPendingListeners.clear();
        this.mBatchEditNestDepth--;
    }

    public ArrayList<TextEditingDelta> extractBatchTextEditingDeltas() {
        ArrayList<TextEditingDelta> arrayList = new ArrayList<>(this.mBatchTextEditingDeltas);
        this.mBatchTextEditingDeltas.clear();
        return arrayList;
    }

    public final int getComposingEnd() {
        return BaseInputConnection.getComposingSpanEnd(this);
    }

    public final int getComposingStart() {
        return BaseInputConnection.getComposingSpanStart(this);
    }

    public final int getSelectionEnd() {
        return Selection.getSelectionEnd(this);
    }

    public final int getSelectionStart() {
        return Selection.getSelectionStart(this);
    }

    public void removeEditingStateListener(EditingStateWatcher editingStateWatcher) {
        if (this.mChangeNotificationDepth > 0) {
            Log.e(TAG, "removing a listener " + editingStateWatcher.toString() + " in a listener callback");
        }
        this.mListeners.remove(editingStateWatcher);
        if (this.mBatchEditNestDepth > 0) {
            this.mPendingListeners.remove(editingStateWatcher);
        }
    }

    public void setComposingRange(int i11, int i12) {
        if (i11 < 0 || i11 >= i12) {
            BaseInputConnection.removeComposingSpans(this);
        } else {
            this.mDummyConnection.setComposingRegion(i11, i12);
        }
    }

    public void setEditingState(TextInputChannel.TextEditState textEditState) {
        beginBatchEdit();
        replace(0, length(), textEditState.text);
        if (textEditState.hasSelection()) {
            Selection.setSelection(this, textEditState.selectionStart, textEditState.selectionEnd);
        } else {
            Selection.removeSelection(this);
        }
        setComposingRange(textEditState.composingStart, textEditState.composingEnd);
        clearBatchDeltas();
        endBatchEdit();
    }

    public void setSpan(Object obj, int i11, int i12, int i13) {
        super.setSpan(obj, i11, i12, i13);
        this.mBatchTextEditingDeltas.add(new TextEditingDelta(toString(), getSelectionStart(), getSelectionEnd(), getComposingStart(), getComposingEnd()));
    }

    public String toString() {
        String str = this.mToStringCache;
        if (str != null) {
            return str;
        }
        String spannableStringBuilder = super.toString();
        this.mToStringCache = spannableStringBuilder;
        return spannableStringBuilder;
    }

    public SpannableStringBuilder replace(int i11, int i12, CharSequence charSequence, int i13, int i14) {
        boolean z11;
        boolean z12;
        if (this.mChangeNotificationDepth > 0) {
            Log.e(TAG, "editing state should not be changed in a listener callback");
        }
        String listenableEditingState = toString();
        int i15 = i12 - i11;
        boolean z13 = i15 != i14 - i13;
        for (int i16 = 0; i16 < i15 && !z13; i16++) {
            z13 |= charAt(i11 + i16) != charSequence.charAt(i13 + i16);
        }
        CharSequence charSequence2 = charSequence;
        if (z13) {
            this.mToStringCache = null;
        }
        int selectionStart = getSelectionStart();
        int selectionEnd = getSelectionEnd();
        int composingStart = getComposingStart();
        int composingEnd = getComposingEnd();
        SpannableStringBuilder replace = super.replace(i11, i12, charSequence, i13, i14);
        TextEditingDelta textEditingDelta = r1;
        boolean z14 = z13;
        int i17 = composingEnd;
        TextEditingDelta textEditingDelta2 = new TextEditingDelta(listenableEditingState, i11, i12, charSequence, getSelectionStart(), getSelectionEnd(), getComposingStart(), getComposingEnd());
        this.mBatchTextEditingDeltas.add(textEditingDelta);
        if (this.mBatchEditNestDepth > 0) {
            return replace;
        }
        boolean z15 = (getSelectionStart() == selectionStart && getSelectionEnd() == selectionEnd) ? false : true;
        if (getComposingStart() == composingStart && getComposingEnd() == i17) {
            z11 = z14;
            z12 = false;
        } else {
            z11 = z14;
            z12 = true;
        }
        notifyListenersIfNeeded(z11, z15, z12);
        return replace;
    }
}
