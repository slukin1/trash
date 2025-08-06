package com.huobi.view.keyboard;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.app.Activity;
import android.content.Context;
import android.inputmethodservice.Keyboard;
import android.inputmethodservice.KeyboardView;
import android.os.Handler;
import android.text.Editable;
import android.text.Selection;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import android.widget.EditText;
import android.widget.LinearLayout;
import androidx.core.content.ContextCompat;
import com.hbg.lib.common.utils.SoftInputUtils;
import com.hbg.lib.widgets.R$color;
import com.hbg.lib.widgets.R$id;
import com.hbg.lib.widgets.R$layout;
import com.hbg.lib.widgets.R$xml;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import i6.i;
import java.util.List;
import java.util.Locale;

public class CustomBoardView extends LinearLayout {
    public static final int KEYBOARD_HIDE = 2;
    public static final int KEYBOARD_SHOW = 1;
    private AnimatorSet hideAnimatorSet;
    /* access modifiers changed from: private */
    public boolean isUpper = false;
    private KeyboardView.OnKeyboardActionListener keyboardActionListener = new KeyboardView.OnKeyboardActionListener() {
        public void onKey(int i11, int[] iArr) {
            if (CustomBoardView.this.mEditText != null) {
                Editable text = CustomBoardView.this.mEditText.getText();
                int selectionStart = CustomBoardView.this.mEditText.getSelectionStart();
                if (i11 == -3) {
                    CustomBoardView.this.hideKeyboardLayout();
                    if (CustomBoardView.this.mInputOver != null) {
                        CustomBoardView.this.mInputOver.inputHasOver(i11, CustomBoardView.this.mEditText);
                    }
                } else if (i11 == -5) {
                    if (text != null && text.length() > 0 && selectionStart > 0) {
                        text.delete(selectionStart - 1, selectionStart);
                    }
                } else if (i11 == -1) {
                    CustomBoardView.this.changeCharUpperAndLower();
                    CustomBoardView.this.mKeyboardView.setKeyboard(CustomBoardView.this.mKeyboard);
                } else if (i11 == -4) {
                    if (CustomBoardView.this.mKeyboardView.getRightType() == 4) {
                        CustomBoardView.this.hideKeyboardLayout();
                        if (CustomBoardView.this.mInputOver != null) {
                            CustomBoardView.this.mInputOver.inputHasOver(CustomBoardView.this.mKeyboardView.getRightType(), CustomBoardView.this.mEditText);
                        }
                    } else if (CustomBoardView.this.mKeyboardView.getRightType() == 5 && CustomBoardView.this.mInputOver != null) {
                        CustomBoardView.this.mInputOver.inputHasOver(CustomBoardView.this.mKeyboardView.getRightType(), CustomBoardView.this.mEditText);
                    }
                } else if (i11 != 0) {
                    if (i11 == 123123) {
                        boolean unused = CustomBoardView.this.isUpper = false;
                        CustomBoardView customBoardView = CustomBoardView.this;
                        customBoardView.showKeyBoardLayout(customBoardView.mEditText, 8);
                    } else if (i11 == 456456) {
                        boolean unused2 = CustomBoardView.this.isUpper = false;
                        CustomBoardView customBoardView2 = CustomBoardView.this;
                        customBoardView2.showKeyBoardLayout(customBoardView2.mEditText, 6);
                    } else if (i11 == 789789) {
                        boolean unused3 = CustomBoardView.this.isUpper = false;
                        CustomBoardView customBoardView3 = CustomBoardView.this;
                        customBoardView3.showKeyBoardLayout(customBoardView3.mEditText, 7);
                    } else if (i11 == 741741) {
                        CustomBoardView customBoardView4 = CustomBoardView.this;
                        customBoardView4.showKeyBoardLayout(customBoardView4.mEditText, 6);
                    } else {
                        text.insert(selectionStart, Character.toString((char) i11));
                    }
                }
            }
        }

        public void onPress(int i11) {
            if (CustomBoardView.this.mInputType == 8 || CustomBoardView.this.mInputType == 1 || CustomBoardView.this.mInputType == 3 || CustomBoardView.this.mInputType == 2 || CustomBoardView.this.mInputType == 5 || CustomBoardView.this.mInputType == 4) {
                CustomBoardView.this.mKeyboardView.setPreviewEnabled(false);
            } else if (i11 == -1 || i11 == -5 || i11 == 123123 || i11 == 456456 || i11 == 789789 || i11 == 32) {
                CustomBoardView.this.mKeyboardView.setPreviewEnabled(false);
            } else {
                CustomBoardView.this.mKeyboardView.setPreviewEnabled(true);
            }
        }

        public void onRelease(int i11) {
            if (CustomBoardView.this.mInputType != 8 && i11 == -1) {
                CustomBoardView.this.mKeyboardView.setPreviewEnabled(true);
            }
        }

        public void onText(CharSequence charSequence) {
            if (CustomBoardView.this.mEditText != null) {
                Editable text = CustomBoardView.this.mEditText.getText();
                int selectionStart = CustomBoardView.this.mEditText.getSelectionStart();
                CustomBoardView.this.mEditText.setText(text.subSequence(0, selectionStart) + charSequence.toString() + text.subSequence(selectionStart, text.length()));
                Selection.setSelection(CustomBoardView.this.mEditText.getText(), selectionStart + 1);
            }
        }

        public void swipeDown() {
        }

        public void swipeLeft() {
        }

        public void swipeRight() {
        }

        public void swipeUp() {
        }
    };
    private KeyboardAnimProxy keyboardAnimProxy;
    private Activity mActivity;
    private Context mContext;
    /* access modifiers changed from: private */
    public EditText mEditText;
    /* access modifiers changed from: private */
    public InputFinishListener mInputOver;
    /* access modifiers changed from: private */
    public int mInputType = 3;
    private KeyBoardStateChangeListener mKeyBoardStateChangeListener;
    /* access modifiers changed from: private */
    public Keyboard mKeyboard;
    /* access modifiers changed from: private */
    public HuobiKeyBoardView mKeyboardView;
    /* access modifiers changed from: private */
    public View.OnTouchListener mOnTouchListener;

    public interface InputFinishListener {
        void inputHasOver(int i11, EditText editText);
    }

    public interface KeyBoardStateChangeListener {
        void KeyBoardStateChange(int i11, EditText editText);
    }

    public interface KeyboardAnimProxy {
        void hideKeyboardAnim();

        void showKeyboardAnim();
    }

    public CustomBoardView(Activity activity) {
        super(activity);
        init(activity);
    }

    /* access modifiers changed from: private */
    public void changeCharUpperAndLower() {
        List<Keyboard.Key> keys = this.mKeyboard.getKeys();
        if (this.isUpper) {
            this.isUpper = false;
            for (Keyboard.Key next : keys) {
                CharSequence charSequence = next.label;
                if (charSequence != null && isWord(charSequence.toString())) {
                    next.label = next.label.toString().toLowerCase(Locale.US);
                    int[] iArr = next.codes;
                    iArr[0] = iArr[0] + 32;
                }
            }
            return;
        }
        this.isUpper = true;
        for (Keyboard.Key next2 : keys) {
            CharSequence charSequence2 = next2.label;
            if (charSequence2 != null && isWord(charSequence2.toString())) {
                next2.label = next2.label.toString().toUpperCase(Locale.US);
                int[] iArr2 = next2.codes;
                iArr2[0] = iArr2[0] - 32;
            }
        }
    }

    private void hideAnimatorKeyboard() {
        if (getVisibility() == 0) {
            if (this.hideAnimatorSet == null) {
                ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this, View.ALPHA, new float[]{1.0f, 0.5f});
                ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this, View.TRANSLATION_Y, new float[]{0.0f, (float) getHeight()});
                AnimatorSet animatorSet = new AnimatorSet();
                this.hideAnimatorSet = animatorSet;
                animatorSet.setInterpolator(new DecelerateInterpolator());
                this.hideAnimatorSet.setDuration(220).playTogether(new Animator[]{ofFloat, ofFloat2});
                this.hideAnimatorSet.addListener(new AnimatorListenerAdapter() {
                    public void onAnimationEnd(Animator animator) {
                        super.onAnimationEnd(animator);
                        CustomBoardView.this.setVisibility(8);
                        CustomBoardView.this.clearAnimation();
                    }
                });
            }
            if (!this.hideAnimatorSet.isRunning()) {
                this.hideAnimatorSet.start();
            }
        }
    }

    private void init(Context context) {
        this.mContext = context;
        LayoutInflater.from(context).inflate(R$layout.custom_keyboard, this, true);
        setOrientation(1);
        setBackgroundColor(ContextCompat.getColor(getContext(), R$color.custom_keyboard_bg_color));
        findViewById(R$id.keyboard_finish_tv).setOnClickListener(new a(this));
        findViewById(R$id.keyboard_top_rl).setOnClickListener(b.f19062b);
        initInputType();
    }

    private void initInputType() {
        initKeyBoard();
        int i11 = this.mInputType;
        if (i11 == 1) {
            this.mKeyboardView.setPreviewEnabled(false);
            this.mKeyboard = new Keyboard(this.mContext, R$xml.symbols);
        } else if (i11 == 2) {
            this.mKeyboardView.setPreviewEnabled(false);
            this.mKeyboard = new Keyboard(this.mContext, R$xml.symbols_finish);
        } else if (i11 == 3) {
            this.mKeyboardView.setPreviewEnabled(false);
            this.mKeyboard = new Keyboard(this.mContext, R$xml.symbols_point);
        } else if (i11 == 4) {
            this.mKeyboardView.setPreviewEnabled(false);
            this.mKeyboard = new Keyboard(this.mContext, R$xml.symbols_x);
        } else if (i11 == 5) {
            this.mKeyboardView.setPreviewEnabled(false);
            this.mKeyboard = new Keyboard(this.mContext, R$xml.symbols_next);
        } else if (i11 == 6) {
            this.mKeyboardView.setPreviewEnabled(true);
            this.mKeyboard = new Keyboard(this.mContext, R$xml.symbols_abc);
        } else if (i11 == 7) {
            this.mKeyboardView.setPreviewEnabled(true);
            this.mKeyboard = new Keyboard(this.mContext, R$xml.symbols_symbol);
        } else if (i11 == 8) {
            this.mKeyboardView.setPreviewEnabled(false);
            this.mKeyboard = new Keyboard(this.mContext, R$xml.symbols_num_abc);
        }
        this.mKeyboardView.setKeyboard(this.mKeyboard);
        this.mKeyboardView.setInputType(this.mInputType);
    }

    private void initKeyBoard() {
        HuobiKeyBoardView huobiKeyBoardView = (HuobiKeyBoardView) findViewById(R$id.keyboard_view_abc_sym);
        this.mKeyboardView = huobiKeyBoardView;
        huobiKeyBoardView.setEnabled(true);
        this.mKeyboardView.setOnKeyboardActionListener(this.keyboardActionListener);
        this.mKeyboardView.setOnTouchListener(new View.OnTouchListener() {
            public boolean onTouch(View view, MotionEvent motionEvent) {
                return motionEvent.getAction() == 2;
            }
        });
        this.mKeyboardView.setVisibility(0);
    }

    private boolean isWord(String str) {
        return "abcdefghijklmnopqrstuvwxyz".indexOf(str.toLowerCase(Locale.US)) > -1;
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void lambda$init$0(View view) {
        hideKeyboardLayout();
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    public void show(EditText editText) {
        initInputType();
        KeyboardAnimProxy keyboardAnimProxy2 = this.keyboardAnimProxy;
        if (keyboardAnimProxy2 != null) {
            keyboardAnimProxy2.showKeyboardAnim();
        } else {
            showAnimatorKeyboard();
        }
        KeyBoardStateChangeListener keyBoardStateChangeListener = this.mKeyBoardStateChangeListener;
        if (keyBoardStateChangeListener != null) {
            keyBoardStateChangeListener.KeyBoardStateChange(1, editText);
        }
    }

    private void showAnimatorKeyboard() {
        if (getVisibility() != 0) {
            setVisibility(4);
            post(new Runnable() {
                public void run() {
                    CustomBoardView.this.setVisibility(0);
                    ObjectAnimator ofFloat = ObjectAnimator.ofFloat(CustomBoardView.this, View.ALPHA, new float[]{0.5f, 1.0f});
                    CustomBoardView customBoardView = CustomBoardView.this;
                    ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(customBoardView, View.TRANSLATION_Y, new float[]{(float) customBoardView.getHeight(), 0.0f});
                    AnimatorSet animatorSet = new AnimatorSet();
                    animatorSet.setInterpolator(new DecelerateInterpolator());
                    animatorSet.setDuration(220).playTogether(new Animator[]{ofFloat, ofFloat2});
                    animatorSet.addListener(new AnimatorListenerAdapter() {
                        public void onAnimationEnd(Animator animator) {
                            super.onAnimationEnd(animator);
                            CustomBoardView.this.setVisibility(0);
                            CustomBoardView.this.clearAnimation();
                        }
                    });
                    animatorSet.start();
                }
            });
        }
    }

    public EditText getEditText() {
        return this.mEditText;
    }

    public void hideKeyboardLayout() {
        if (getVisibility() == 0) {
            KeyboardAnimProxy keyboardAnimProxy2 = this.keyboardAnimProxy;
            if (keyboardAnimProxy2 != null) {
                keyboardAnimProxy2.hideKeyboardAnim();
            } else {
                hideAnimatorKeyboard();
            }
            KeyBoardStateChangeListener keyBoardStateChangeListener = this.mKeyBoardStateChangeListener;
            if (keyBoardStateChangeListener != null) {
                keyBoardStateChangeListener.KeyBoardStateChange(2, this.mEditText);
            }
            EditText editText = this.mEditText;
            if (editText != null) {
                editText.clearFocus();
                this.mEditText = null;
            }
        }
    }

    public boolean keyboardVisible() {
        return getVisibility() == 0;
    }

    public void setInputOverListener(InputFinishListener inputFinishListener) {
        this.mInputOver = inputFinishListener;
    }

    public void setKeyBoardStateChangeListener(KeyBoardStateChangeListener keyBoardStateChangeListener) {
        this.mKeyBoardStateChangeListener = keyBoardStateChangeListener;
    }

    public void setKeyboardAnimProxy(KeyboardAnimProxy keyboardAnimProxy2) {
        this.keyboardAnimProxy = keyboardAnimProxy2;
    }

    public void setOnTouchListener(View.OnTouchListener onTouchListener) {
        this.mOnTouchListener = onTouchListener;
    }

    public void setOtherEdittext(EditText... editTextArr) {
        for (EditText onTouchListener : editTextArr) {
            onTouchListener.setOnTouchListener(new View.OnTouchListener() {
                public boolean onTouch(View view, MotionEvent motionEvent) {
                    if (motionEvent.getAction() == 1) {
                        new Handler().postDelayed(new Runnable() {
                            public void run() {
                                CustomBoardView.this.hideKeyboardLayout();
                            }
                        }, 100);
                        if (view instanceof EditText) {
                            EditText unused = CustomBoardView.this.mEditText = (EditText) view;
                        }
                        CustomBoardView.this.hideKeyboardLayout();
                    }
                    if (CustomBoardView.this.mOnTouchListener == null) {
                        return false;
                    }
                    CustomBoardView.this.mOnTouchListener.onTouch(view, motionEvent);
                    return false;
                }
            });
        }
    }

    public void showKeyBoardLayout(final EditText editText, int i11) {
        if (!editText.equals(this.mEditText) || getVisibility() != 0 || this.mInputType != i11) {
            this.mInputType = i11;
            this.mEditText = editText;
            if (SoftInputUtils.l(editText, this.mContext)) {
                i.b().g(new Runnable() {
                    public void run() {
                        CustomBoardView.this.show(editText);
                    }
                }, 100);
            } else {
                show(editText);
            }
        }
    }

    public CustomBoardView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init(context);
    }

    public CustomBoardView(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        init(context);
    }
}
