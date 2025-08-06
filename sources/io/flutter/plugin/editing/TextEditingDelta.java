package io.flutter.plugin.editing;

import io.flutter.Log;
import org.json.JSONException;
import org.json.JSONObject;

public final class TextEditingDelta {
    private static final String TAG = "TextEditingDelta";
    private int deltaEnd;
    private int deltaStart;
    private CharSequence deltaText;
    private int newComposingEnd;
    private int newComposingStart;
    private int newSelectionEnd;
    private int newSelectionStart;
    private CharSequence oldText;

    public TextEditingDelta(CharSequence charSequence, int i11, int i12, CharSequence charSequence2, int i13, int i14, int i15, int i16) {
        this.newSelectionStart = i13;
        this.newSelectionEnd = i14;
        this.newComposingStart = i15;
        this.newComposingEnd = i16;
        setDeltas(charSequence, charSequence2.toString(), i11, i12);
    }

    private void setDeltas(CharSequence charSequence, CharSequence charSequence2, int i11, int i12) {
        this.oldText = charSequence;
        this.deltaText = charSequence2;
        this.deltaStart = i11;
        this.deltaEnd = i12;
    }

    public int getDeltaEnd() {
        return this.deltaEnd;
    }

    public int getDeltaStart() {
        return this.deltaStart;
    }

    public CharSequence getDeltaText() {
        return this.deltaText;
    }

    public int getNewComposingEnd() {
        return this.newComposingEnd;
    }

    public int getNewComposingStart() {
        return this.newComposingStart;
    }

    public int getNewSelectionEnd() {
        return this.newSelectionEnd;
    }

    public int getNewSelectionStart() {
        return this.newSelectionStart;
    }

    public CharSequence getOldText() {
        return this.oldText;
    }

    public JSONObject toJSON() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("oldText", this.oldText.toString());
            jSONObject.put("deltaText", this.deltaText.toString());
            jSONObject.put("deltaStart", this.deltaStart);
            jSONObject.put("deltaEnd", this.deltaEnd);
            jSONObject.put("selectionBase", this.newSelectionStart);
            jSONObject.put("selectionExtent", this.newSelectionEnd);
            jSONObject.put("composingBase", this.newComposingStart);
            jSONObject.put("composingExtent", this.newComposingEnd);
        } catch (JSONException e11) {
            Log.e(TAG, "unable to create JSONObject: " + e11);
        }
        return jSONObject;
    }

    public TextEditingDelta(CharSequence charSequence, int i11, int i12, int i13, int i14) {
        this.newSelectionStart = i11;
        this.newSelectionEnd = i12;
        this.newComposingStart = i13;
        this.newComposingEnd = i14;
        setDeltas(charSequence, "", -1, -1);
    }
}
