package io.flutter.plugin.editing;

import android.annotation.SuppressLint;
import android.graphics.Rect;
import android.os.Build;
import android.os.Bundle;
import android.text.Editable;
import android.util.SparseArray;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewStructure;
import android.view.WindowInsets;
import android.view.autofill.AutofillId;
import android.view.autofill.AutofillManager;
import android.view.autofill.AutofillValue;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.view.inputmethod.InputMethodManager;
import androidx.core.view.inputmethod.EditorInfoCompat;
import com.tencent.thumbplayer.tcmedia.core.common.TPMediaCodecProfileLevel;
import io.flutter.Log;
import io.flutter.embedding.android.KeyboardManager;
import io.flutter.embedding.engine.systemchannels.TextInputChannel;
import io.flutter.plugin.editing.ListenableEditingState;
import io.flutter.plugin.platform.PlatformViewsController;
import java.util.HashMap;

public class TextInputPlugin implements ListenableEditingState.EditingStateWatcher {
    private static final String TAG = "TextInputPlugin";
    /* access modifiers changed from: private */
    public final AutofillManager afm;
    private SparseArray<TextInputChannel.Configuration> autofillConfiguration;
    private TextInputChannel.Configuration configuration;
    private ImeSyncDeferringInsetsCallback imeSyncCallback;
    /* access modifiers changed from: private */
    public InputTarget inputTarget = new InputTarget(InputTarget.Type.NO_TARGET, 0);
    private boolean isInputConnectionLocked;
    private Rect lastClientRect;
    private InputConnection lastInputConnection;
    private ListenableEditingState mEditable;
    private final InputMethodManager mImm;
    private TextInputChannel.TextEditState mLastKnownFrameworkTextEditingState;
    private boolean mRestartInputPending;
    /* access modifiers changed from: private */
    public final View mView;
    private PlatformViewsController platformViewsController;
    private final TextInputChannel textInputChannel;

    public static class InputTarget {

        /* renamed from: id  reason: collision with root package name */
        public int f55158id;
        public Type type;

        public enum Type {
            NO_TARGET,
            FRAMEWORK_CLIENT,
            VIRTUAL_DISPLAY_PLATFORM_VIEW,
            PHYSICAL_DISPLAY_PLATFORM_VIEW
        }

        public InputTarget(Type type2, int i11) {
            this.type = type2;
            this.f55158id = i11;
        }
    }

    public interface MinMax {
        void inspect(double d11, double d12);
    }

    @SuppressLint({"NewApi"})
    public TextInputPlugin(View view, TextInputChannel textInputChannel2, PlatformViewsController platformViewsController2) {
        int i11 = 0;
        this.mView = view;
        this.mEditable = new ListenableEditingState((TextInputChannel.TextEditState) null, view);
        this.mImm = (InputMethodManager) view.getContext().getSystemService("input_method");
        int i12 = Build.VERSION.SDK_INT;
        if (i12 >= 26) {
            this.afm = (AutofillManager) view.getContext().getSystemService(AutofillManager.class);
        } else {
            this.afm = null;
        }
        if (i12 >= 30) {
            i11 = (view.getWindowSystemUiVisibility() & 2) == 0 ? 0 | WindowInsets.Type.navigationBars() : i11;
            ImeSyncDeferringInsetsCallback imeSyncDeferringInsetsCallback = new ImeSyncDeferringInsetsCallback(view, (view.getWindowSystemUiVisibility() & 4) == 0 ? i11 | WindowInsets.Type.statusBars() : i11, WindowInsets.Type.ime());
            this.imeSyncCallback = imeSyncDeferringInsetsCallback;
            imeSyncDeferringInsetsCallback.install();
        }
        this.textInputChannel = textInputChannel2;
        textInputChannel2.setTextInputMethodHandler(new TextInputChannel.TextInputMethodHandler() {
            public void clearClient() {
                TextInputPlugin.this.clearTextInputClient();
            }

            public void finishAutofillContext(boolean z11) {
                if (Build.VERSION.SDK_INT >= 26 && TextInputPlugin.this.afm != null) {
                    if (z11) {
                        TextInputPlugin.this.afm.commit();
                    } else {
                        TextInputPlugin.this.afm.cancel();
                    }
                }
            }

            public void hide() {
                if (TextInputPlugin.this.inputTarget.type == InputTarget.Type.PHYSICAL_DISPLAY_PLATFORM_VIEW) {
                    TextInputPlugin.this.notifyViewExited();
                    return;
                }
                TextInputPlugin textInputPlugin = TextInputPlugin.this;
                textInputPlugin.hideTextInput(textInputPlugin.mView);
            }

            public void requestAutofill() {
                TextInputPlugin.this.notifyViewEntered();
            }

            public void sendAppPrivateCommand(String str, Bundle bundle) {
                TextInputPlugin.this.sendTextInputAppPrivateCommand(str, bundle);
            }

            public void setClient(int i11, TextInputChannel.Configuration configuration) {
                TextInputPlugin.this.setTextInputClient(i11, configuration);
            }

            public void setEditableSizeAndTransform(double d11, double d12, double[] dArr) {
                TextInputPlugin.this.saveEditableSizeAndTransform(d11, d12, dArr);
            }

            public void setEditingState(TextInputChannel.TextEditState textEditState) {
                TextInputPlugin textInputPlugin = TextInputPlugin.this;
                textInputPlugin.setTextInputEditingState(textInputPlugin.mView, textEditState);
            }

            public void setPlatformViewClient(int i11, boolean z11) {
                TextInputPlugin.this.setPlatformViewTextInputClient(i11, z11);
            }

            public void show() {
                TextInputPlugin textInputPlugin = TextInputPlugin.this;
                textInputPlugin.showTextInput(textInputPlugin.mView);
            }
        });
        textInputChannel2.requestExistingInputState();
        this.platformViewsController = platformViewsController2;
        platformViewsController2.attachTextInputPlugin(this);
    }

    private boolean canShowTextInput() {
        TextInputChannel.InputType inputType;
        TextInputChannel.Configuration configuration2 = this.configuration;
        if (configuration2 == null || (inputType = configuration2.inputType) == null || inputType.type != TextInputChannel.TextInputType.NONE) {
            return true;
        }
        return false;
    }

    private static boolean composingChanged(TextInputChannel.TextEditState textEditState, TextInputChannel.TextEditState textEditState2) {
        int i11 = textEditState.composingEnd - textEditState.composingStart;
        if (i11 != textEditState2.composingEnd - textEditState2.composingStart) {
            return true;
        }
        for (int i12 = 0; i12 < i11; i12++) {
            if (textEditState.text.charAt(textEditState.composingStart + i12) != textEditState2.text.charAt(textEditState2.composingStart + i12)) {
                return true;
            }
        }
        return false;
    }

    /* access modifiers changed from: private */
    public void hideTextInput(View view) {
        notifyViewExited();
        this.mImm.hideSoftInputFromWindow(view.getApplicationWindowToken(), 0);
    }

    private static int inputTypeFromTextInputType(TextInputChannel.InputType inputType, boolean z11, boolean z12, boolean z13, boolean z14, TextInputChannel.TextCapitalization textCapitalization) {
        TextInputChannel.TextInputType textInputType = inputType.type;
        if (textInputType == TextInputChannel.TextInputType.DATETIME) {
            return 4;
        }
        if (textInputType == TextInputChannel.TextInputType.NUMBER) {
            int i11 = 2;
            if (inputType.isSigned) {
                i11 = 4098;
            }
            return inputType.isDecimal ? i11 | 8192 : i11;
        } else if (textInputType == TextInputChannel.TextInputType.PHONE) {
            return 3;
        } else {
            if (textInputType == TextInputChannel.TextInputType.NONE) {
                return 0;
            }
            int i12 = 1;
            if (textInputType == TextInputChannel.TextInputType.MULTILINE) {
                i12 = 131073;
            } else if (textInputType == TextInputChannel.TextInputType.EMAIL_ADDRESS) {
                i12 = 33;
            } else if (textInputType == TextInputChannel.TextInputType.URL) {
                i12 = 17;
            } else if (textInputType == TextInputChannel.TextInputType.VISIBLE_PASSWORD) {
                i12 = 145;
            } else if (textInputType == TextInputChannel.TextInputType.NAME) {
                i12 = 97;
            } else if (textInputType == TextInputChannel.TextInputType.POSTAL_ADDRESS) {
                i12 = 113;
            }
            if (z11) {
                i12 = i12 | 524288 | 128;
            } else {
                if (z12) {
                    i12 |= 32768;
                }
                if (!z13) {
                    i12 |= 524288;
                }
            }
            if (textCapitalization == TextInputChannel.TextCapitalization.CHARACTERS) {
                return i12 | 4096;
            }
            if (textCapitalization == TextInputChannel.TextCapitalization.WORDS) {
                return i12 | 8192;
            }
            return textCapitalization == TextInputChannel.TextCapitalization.SENTENCES ? i12 | 16384 : i12;
        }
    }

    private boolean needsAutofill() {
        return this.autofillConfiguration != null;
    }

    private void notifyValueChanged(String str) {
        if (Build.VERSION.SDK_INT >= 26 && this.afm != null && needsAutofill()) {
            this.afm.notifyValueChanged(this.mView, this.configuration.autofill.uniqueIdentifier.hashCode(), AutofillValue.forText(str));
        }
    }

    /* access modifiers changed from: private */
    public void notifyViewEntered() {
        if (Build.VERSION.SDK_INT >= 26 && this.afm != null && needsAutofill()) {
            String str = this.configuration.autofill.uniqueIdentifier;
            int[] iArr = new int[2];
            this.mView.getLocationOnScreen(iArr);
            Rect rect = new Rect(this.lastClientRect);
            rect.offset(iArr[0], iArr[1]);
            this.afm.notifyViewEntered(this.mView, str.hashCode(), rect);
        }
    }

    /* access modifiers changed from: private */
    public void notifyViewExited() {
        TextInputChannel.Configuration configuration2;
        if (Build.VERSION.SDK_INT >= 26 && this.afm != null && (configuration2 = this.configuration) != null && configuration2.autofill != null && needsAutofill()) {
            this.afm.notifyViewExited(this.mView, this.configuration.autofill.uniqueIdentifier.hashCode());
        }
    }

    /* access modifiers changed from: private */
    public void saveEditableSizeAndTransform(double d11, double d12, double[] dArr) {
        double d13 = d11;
        double d14 = d12;
        final double[] dArr2 = dArr;
        final double[] dArr3 = new double[4];
        final boolean z11 = dArr2[3] == 0.0d && dArr2[7] == 0.0d && dArr2[15] == 1.0d;
        double d15 = dArr2[12] / dArr2[15];
        dArr3[1] = d15;
        dArr3[0] = d15;
        double d16 = dArr2[13] / dArr2[15];
        dArr3[3] = d16;
        dArr3[2] = d16;
        AnonymousClass2 r14 = new MinMax() {
            public void inspect(double d11, double d12) {
                double d13 = 1.0d;
                if (!z11) {
                    double[] dArr = dArr2;
                    d13 = 1.0d / (((dArr[3] * d11) + (dArr[7] * d12)) + dArr[15]);
                }
                double[] dArr2 = dArr2;
                double d14 = ((dArr2[0] * d11) + (dArr2[4] * d12) + dArr2[12]) * d13;
                double d15 = ((dArr2[1] * d11) + (dArr2[5] * d12) + dArr2[13]) * d13;
                double[] dArr3 = dArr3;
                if (d14 < dArr3[0]) {
                    dArr3[0] = d14;
                } else if (d14 > dArr3[1]) {
                    dArr3[1] = d14;
                }
                if (d15 < dArr3[2]) {
                    dArr3[2] = d15;
                } else if (d15 > dArr3[3]) {
                    dArr3[3] = d15;
                }
            }
        };
        r14.inspect(d13, 0.0d);
        r14.inspect(d13, d14);
        r14.inspect(0.0d, d14);
        Float valueOf = Float.valueOf(this.mView.getContext().getResources().getDisplayMetrics().density);
        this.lastClientRect = new Rect((int) (dArr3[0] * ((double) valueOf.floatValue())), (int) (dArr3[2] * ((double) valueOf.floatValue())), (int) Math.ceil(dArr3[1] * ((double) valueOf.floatValue())), (int) Math.ceil(dArr3[3] * ((double) valueOf.floatValue())));
    }

    /* access modifiers changed from: private */
    public void setPlatformViewTextInputClient(int i11, boolean z11) {
        if (z11) {
            this.mView.requestFocus();
            this.inputTarget = new InputTarget(InputTarget.Type.VIRTUAL_DISPLAY_PLATFORM_VIEW, i11);
            this.mImm.restartInput(this.mView);
            this.mRestartInputPending = false;
            return;
        }
        this.inputTarget = new InputTarget(InputTarget.Type.PHYSICAL_DISPLAY_PLATFORM_VIEW, i11);
        this.lastInputConnection = null;
    }

    private void updateAutofillConfigurationIfNeeded(TextInputChannel.Configuration configuration2) {
        if (Build.VERSION.SDK_INT >= 26) {
            if (configuration2 == null || configuration2.autofill == null) {
                this.autofillConfiguration = null;
                return;
            }
            TextInputChannel.Configuration[] configurationArr = configuration2.fields;
            SparseArray<TextInputChannel.Configuration> sparseArray = new SparseArray<>();
            this.autofillConfiguration = sparseArray;
            if (configurationArr == null) {
                sparseArray.put(configuration2.autofill.uniqueIdentifier.hashCode(), configuration2);
                return;
            }
            for (TextInputChannel.Configuration configuration3 : configurationArr) {
                TextInputChannel.Configuration.Autofill autofill = configuration3.autofill;
                if (autofill != null) {
                    this.autofillConfiguration.put(autofill.uniqueIdentifier.hashCode(), configuration3);
                    this.afm.notifyValueChanged(this.mView, autofill.uniqueIdentifier.hashCode(), AutofillValue.forText(autofill.editState.text));
                }
            }
        }
    }

    public void autofill(SparseArray<AutofillValue> sparseArray) {
        TextInputChannel.Configuration configuration2;
        TextInputChannel.Configuration.Autofill autofill;
        TextInputChannel.Configuration.Autofill autofill2;
        if (Build.VERSION.SDK_INT >= 26 && (configuration2 = this.configuration) != null && this.autofillConfiguration != null && (autofill = configuration2.autofill) != null) {
            HashMap hashMap = new HashMap();
            for (int i11 = 0; i11 < sparseArray.size(); i11++) {
                TextInputChannel.Configuration configuration3 = this.autofillConfiguration.get(sparseArray.keyAt(i11));
                if (!(configuration3 == null || (autofill2 = configuration3.autofill) == null)) {
                    String charSequence = sparseArray.valueAt(i11).getTextValue().toString();
                    TextInputChannel.TextEditState textEditState = new TextInputChannel.TextEditState(charSequence, charSequence.length(), charSequence.length(), -1, -1);
                    if (autofill2.uniqueIdentifier.equals(autofill.uniqueIdentifier)) {
                        this.mEditable.setEditingState(textEditState);
                    } else {
                        hashMap.put(autofill2.uniqueIdentifier, textEditState);
                    }
                }
            }
            this.textInputChannel.updateEditingStateWithTag(this.inputTarget.f55158id, hashMap);
        }
    }

    public void clearPlatformViewClient(int i11) {
        InputTarget inputTarget2 = this.inputTarget;
        InputTarget.Type type = inputTarget2.type;
        if ((type == InputTarget.Type.VIRTUAL_DISPLAY_PLATFORM_VIEW || type == InputTarget.Type.PHYSICAL_DISPLAY_PLATFORM_VIEW) && inputTarget2.f55158id == i11) {
            this.inputTarget = new InputTarget(InputTarget.Type.NO_TARGET, 0);
            notifyViewExited();
            this.mImm.hideSoftInputFromWindow(this.mView.getApplicationWindowToken(), 0);
            this.mImm.restartInput(this.mView);
            this.mRestartInputPending = false;
        }
    }

    public void clearTextInputClient() {
        if (this.inputTarget.type != InputTarget.Type.VIRTUAL_DISPLAY_PLATFORM_VIEW) {
            this.mEditable.removeEditingStateListener(this);
            notifyViewExited();
            this.configuration = null;
            updateAutofillConfigurationIfNeeded((TextInputChannel.Configuration) null);
            this.inputTarget = new InputTarget(InputTarget.Type.NO_TARGET, 0);
            unlockPlatformViewInputConnection();
            this.lastClientRect = null;
        }
    }

    public InputConnection createInputConnection(View view, KeyboardManager keyboardManager, EditorInfo editorInfo) {
        int i11;
        InputTarget inputTarget2 = this.inputTarget;
        InputTarget.Type type = inputTarget2.type;
        if (type == InputTarget.Type.NO_TARGET) {
            this.lastInputConnection = null;
            return null;
        } else if (type == InputTarget.Type.PHYSICAL_DISPLAY_PLATFORM_VIEW) {
            return null;
        } else {
            if (type != InputTarget.Type.VIRTUAL_DISPLAY_PLATFORM_VIEW) {
                TextInputChannel.Configuration configuration2 = this.configuration;
                int inputTypeFromTextInputType = inputTypeFromTextInputType(configuration2.inputType, configuration2.obscureText, configuration2.autocorrect, configuration2.enableSuggestions, configuration2.enableIMEPersonalizedLearning, configuration2.textCapitalization);
                editorInfo.inputType = inputTypeFromTextInputType;
                editorInfo.imeOptions = TPMediaCodecProfileLevel.HEVCHighTierLevel62;
                if (Build.VERSION.SDK_INT >= 26 && !this.configuration.enableIMEPersonalizedLearning) {
                    editorInfo.imeOptions = 33554432 | 16777216;
                }
                Integer num = this.configuration.inputAction;
                if (num == null) {
                    i11 = (inputTypeFromTextInputType & 131072) != 0 ? 1 : 6;
                } else {
                    i11 = num.intValue();
                }
                TextInputChannel.Configuration configuration3 = this.configuration;
                String str = configuration3.actionLabel;
                if (str != null) {
                    editorInfo.actionLabel = str;
                    editorInfo.actionId = i11;
                }
                editorInfo.imeOptions = i11 | editorInfo.imeOptions;
                String[] strArr = configuration3.contentCommitMimeTypes;
                if (strArr != null) {
                    EditorInfoCompat.d(editorInfo, strArr);
                }
                InputConnectionAdaptor inputConnectionAdaptor = new InputConnectionAdaptor(view, this.inputTarget.f55158id, this.textInputChannel, keyboardManager, this.mEditable, editorInfo);
                editorInfo.initialSelStart = this.mEditable.getSelectionStart();
                editorInfo.initialSelEnd = this.mEditable.getSelectionEnd();
                this.lastInputConnection = inputConnectionAdaptor;
                return inputConnectionAdaptor;
            } else if (this.isInputConnectionLocked) {
                return this.lastInputConnection;
            } else {
                InputConnection onCreateInputConnection = this.platformViewsController.getPlatformViewById(inputTarget2.f55158id).onCreateInputConnection(editorInfo);
                this.lastInputConnection = onCreateInputConnection;
                return onCreateInputConnection;
            }
        }
    }

    @SuppressLint({"NewApi"})
    public void destroy() {
        this.platformViewsController.detachTextInputPlugin();
        this.textInputChannel.setTextInputMethodHandler((TextInputChannel.TextInputMethodHandler) null);
        notifyViewExited();
        this.mEditable.removeEditingStateListener(this);
        ImeSyncDeferringInsetsCallback imeSyncDeferringInsetsCallback = this.imeSyncCallback;
        if (imeSyncDeferringInsetsCallback != null) {
            imeSyncDeferringInsetsCallback.remove();
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:13:0x004d, code lost:
        if (r7 == r1.composingEnd) goto L_0x0052;
     */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x0055  */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x00ac  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void didChangeEditingState(boolean r9, boolean r10, boolean r11) {
        /*
            r8 = this;
            if (r9 == 0) goto L_0x000b
            io.flutter.plugin.editing.ListenableEditingState r9 = r8.mEditable
            java.lang.String r9 = r9.toString()
            r8.notifyValueChanged(r9)
        L_0x000b:
            io.flutter.plugin.editing.ListenableEditingState r9 = r8.mEditable
            int r9 = r9.getSelectionStart()
            io.flutter.plugin.editing.ListenableEditingState r10 = r8.mEditable
            int r10 = r10.getSelectionEnd()
            io.flutter.plugin.editing.ListenableEditingState r11 = r8.mEditable
            int r11 = r11.getComposingStart()
            io.flutter.plugin.editing.ListenableEditingState r0 = r8.mEditable
            int r7 = r0.getComposingEnd()
            io.flutter.plugin.editing.ListenableEditingState r0 = r8.mEditable
            java.util.ArrayList r0 = r0.extractBatchTextEditingDeltas()
            io.flutter.embedding.engine.systemchannels.TextInputChannel$TextEditState r1 = r8.mLastKnownFrameworkTextEditingState
            if (r1 == 0) goto L_0x0052
            io.flutter.plugin.editing.ListenableEditingState r1 = r8.mEditable
            java.lang.String r1 = r1.toString()
            io.flutter.embedding.engine.systemchannels.TextInputChannel$TextEditState r2 = r8.mLastKnownFrameworkTextEditingState
            java.lang.String r2 = r2.text
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x0050
            io.flutter.embedding.engine.systemchannels.TextInputChannel$TextEditState r1 = r8.mLastKnownFrameworkTextEditingState
            int r2 = r1.selectionStart
            if (r9 != r2) goto L_0x0050
            int r2 = r1.selectionEnd
            if (r10 != r2) goto L_0x0050
            int r2 = r1.composingStart
            if (r11 != r2) goto L_0x0050
            int r1 = r1.composingEnd
            if (r7 != r1) goto L_0x0050
            goto L_0x0052
        L_0x0050:
            r1 = 0
            goto L_0x0053
        L_0x0052:
            r1 = 1
        L_0x0053:
            if (r1 != 0) goto L_0x00ac
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "send EditingState to flutter: "
            r1.append(r2)
            io.flutter.plugin.editing.ListenableEditingState r2 = r8.mEditable
            java.lang.String r2 = r2.toString()
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            java.lang.String r2 = "TextInputPlugin"
            io.flutter.Log.v(r2, r1)
            io.flutter.embedding.engine.systemchannels.TextInputChannel$Configuration r1 = r8.configuration
            boolean r1 = r1.enableDeltaModel
            if (r1 == 0) goto L_0x0086
            io.flutter.embedding.engine.systemchannels.TextInputChannel r1 = r8.textInputChannel
            io.flutter.plugin.editing.TextInputPlugin$InputTarget r2 = r8.inputTarget
            int r2 = r2.f55158id
            r1.updateEditingStateWithDeltas(r2, r0)
            io.flutter.plugin.editing.ListenableEditingState r0 = r8.mEditable
            r0.clearBatchDeltas()
            goto L_0x0099
        L_0x0086:
            io.flutter.embedding.engine.systemchannels.TextInputChannel r0 = r8.textInputChannel
            io.flutter.plugin.editing.TextInputPlugin$InputTarget r1 = r8.inputTarget
            int r1 = r1.f55158id
            io.flutter.plugin.editing.ListenableEditingState r2 = r8.mEditable
            java.lang.String r2 = r2.toString()
            r3 = r9
            r4 = r10
            r5 = r11
            r6 = r7
            r0.updateEditingState(r1, r2, r3, r4, r5, r6)
        L_0x0099:
            io.flutter.embedding.engine.systemchannels.TextInputChannel$TextEditState r6 = new io.flutter.embedding.engine.systemchannels.TextInputChannel$TextEditState
            io.flutter.plugin.editing.ListenableEditingState r0 = r8.mEditable
            java.lang.String r1 = r0.toString()
            r0 = r6
            r2 = r9
            r3 = r10
            r4 = r11
            r5 = r7
            r0.<init>(r1, r2, r3, r4, r5)
            r8.mLastKnownFrameworkTextEditingState = r6
            goto L_0x00b1
        L_0x00ac:
            io.flutter.plugin.editing.ListenableEditingState r9 = r8.mEditable
            r9.clearBatchDeltas()
        L_0x00b1:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: io.flutter.plugin.editing.TextInputPlugin.didChangeEditingState(boolean, boolean, boolean):void");
    }

    public Editable getEditable() {
        return this.mEditable;
    }

    public ImeSyncDeferringInsetsCallback getImeSyncCallback() {
        return this.imeSyncCallback;
    }

    public InputMethodManager getInputMethodManager() {
        return this.mImm;
    }

    public InputConnection getLastInputConnection() {
        return this.lastInputConnection;
    }

    public boolean handleKeyEvent(KeyEvent keyEvent) {
        InputConnection inputConnection;
        if (!getInputMethodManager().isAcceptingText() || (inputConnection = this.lastInputConnection) == null) {
            return false;
        }
        if (inputConnection instanceof InputConnectionAdaptor) {
            return ((InputConnectionAdaptor) inputConnection).handleKeyEvent(keyEvent);
        }
        return inputConnection.sendKeyEvent(keyEvent);
    }

    public void lockPlatformViewInputConnection() {
        if (this.inputTarget.type == InputTarget.Type.VIRTUAL_DISPLAY_PLATFORM_VIEW) {
            this.isInputConnectionLocked = true;
        }
    }

    public void onProvideAutofillVirtualStructure(ViewStructure viewStructure, int i11) {
        Rect rect;
        ViewStructure viewStructure2 = viewStructure;
        if (Build.VERSION.SDK_INT >= 26 && needsAutofill()) {
            String str = this.configuration.autofill.uniqueIdentifier;
            AutofillId autofillId = viewStructure.getAutofillId();
            for (int i12 = 0; i12 < this.autofillConfiguration.size(); i12++) {
                int keyAt = this.autofillConfiguration.keyAt(i12);
                TextInputChannel.Configuration.Autofill autofill = this.autofillConfiguration.valueAt(i12).autofill;
                if (autofill != null) {
                    viewStructure2.addChildCount(1);
                    ViewStructure newChild = viewStructure2.newChild(i12);
                    newChild.setAutofillId(autofillId, keyAt);
                    String[] strArr = autofill.hints;
                    if (strArr.length > 0) {
                        newChild.setAutofillHints(strArr);
                    }
                    newChild.setAutofillType(1);
                    newChild.setVisibility(0);
                    String str2 = autofill.hintText;
                    if (str2 != null) {
                        newChild.setHint(str2);
                    }
                    if (str.hashCode() != keyAt || (rect = this.lastClientRect) == null) {
                        ViewStructure viewStructure3 = newChild;
                        viewStructure3.setDimens(0, 0, 0, 0, 1, 1);
                        viewStructure3.setAutofillValue(AutofillValue.forText(autofill.editState.text));
                    } else {
                        newChild.setDimens(rect.left, rect.top, 0, 0, rect.width(), this.lastClientRect.height());
                        newChild.setAutofillValue(AutofillValue.forText(this.mEditable));
                    }
                }
            }
        }
    }

    public void sendTextInputAppPrivateCommand(String str, Bundle bundle) {
        this.mImm.sendAppPrivateCommand(this.mView, str, bundle);
    }

    public void setTextInputClient(int i11, TextInputChannel.Configuration configuration2) {
        notifyViewExited();
        this.configuration = configuration2;
        if (canShowTextInput()) {
            this.inputTarget = new InputTarget(InputTarget.Type.FRAMEWORK_CLIENT, i11);
        } else {
            this.inputTarget = new InputTarget(InputTarget.Type.NO_TARGET, i11);
        }
        this.mEditable.removeEditingStateListener(this);
        TextInputChannel.Configuration.Autofill autofill = configuration2.autofill;
        this.mEditable = new ListenableEditingState(autofill != null ? autofill.editState : null, this.mView);
        updateAutofillConfigurationIfNeeded(configuration2);
        this.mRestartInputPending = true;
        unlockPlatformViewInputConnection();
        this.lastClientRect = null;
        this.mEditable.addEditingStateListener(this);
    }

    public void setTextInputEditingState(View view, TextInputChannel.TextEditState textEditState) {
        TextInputChannel.TextEditState textEditState2;
        if (!this.mRestartInputPending && (textEditState2 = this.mLastKnownFrameworkTextEditingState) != null && textEditState2.hasComposing()) {
            boolean composingChanged = composingChanged(this.mLastKnownFrameworkTextEditingState, textEditState);
            this.mRestartInputPending = composingChanged;
            if (composingChanged) {
                Log.i(TAG, "Composing region changed by the framework. Restarting the input method.");
            }
        }
        this.mLastKnownFrameworkTextEditingState = textEditState;
        this.mEditable.setEditingState(textEditState);
        if (this.mRestartInputPending) {
            this.mImm.restartInput(view);
            this.mRestartInputPending = false;
        }
    }

    public void showTextInput(View view) {
        if (canShowTextInput()) {
            view.requestFocus();
            this.mImm.showSoftInput(view, 0);
            return;
        }
        hideTextInput(view);
    }

    public void unlockPlatformViewInputConnection() {
        if (this.inputTarget.type == InputTarget.Type.VIRTUAL_DISPLAY_PLATFORM_VIEW) {
            this.isInputConnectionLocked = false;
        }
    }
}
