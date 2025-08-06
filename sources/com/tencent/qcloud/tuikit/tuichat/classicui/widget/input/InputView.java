package com.tencent.qcloud.tuikit.tuichat.classicui.widget.input;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.media.MediaMetadataRetriever;
import android.net.Uri;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.webkit.MimeTypeMap;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.luck.picture.lib.config.SelectMimeType;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import com.tencent.imsdk.v2.V2TIMManager;
import com.tencent.qcloud.tuicore.ServiceInitializer;
import com.tencent.qcloud.tuicore.TUIConstants;
import com.tencent.qcloud.tuicore.TUICore;
import com.tencent.qcloud.tuicore.interfaces.TUIExtensionEventListener;
import com.tencent.qcloud.tuicore.interfaces.TUIExtensionInfo;
import com.tencent.qcloud.tuicore.util.ToastUtil;
import com.tencent.qcloud.tuikit.timcommon.bean.TUIMessageBean;
import com.tencent.qcloud.tuikit.timcommon.component.face.CustomFace;
import com.tencent.qcloud.tuikit.timcommon.component.face.Emoji;
import com.tencent.qcloud.tuikit.timcommon.component.face.FaceManager;
import com.tencent.qcloud.tuikit.timcommon.component.interfaces.IUIKitCallback;
import com.tencent.qcloud.tuikit.timcommon.util.FileUtil;
import com.tencent.qcloud.tuikit.timcommon.util.ThreadUtils;
import com.tencent.qcloud.tuikit.tuichat.R;
import com.tencent.qcloud.tuikit.tuichat.TUIChatConstants;
import com.tencent.qcloud.tuikit.tuichat.bean.ChatInfo;
import com.tencent.qcloud.tuikit.tuichat.bean.DraftInfo;
import com.tencent.qcloud.tuikit.tuichat.bean.InputMoreActionUnit;
import com.tencent.qcloud.tuikit.tuichat.bean.ReplyPreviewBean;
import com.tencent.qcloud.tuikit.tuichat.bean.message.FileMessageBean;
import com.tencent.qcloud.tuikit.tuichat.classicui.component.camera.CameraActivity;
import com.tencent.qcloud.tuikit.tuichat.classicui.interfaces.IChatLayout;
import com.tencent.qcloud.tuikit.tuichat.classicui.widget.input.TIMMentionEditText;
import com.tencent.qcloud.tuikit.tuichat.classicui.widget.input.face.FaceFragment;
import com.tencent.qcloud.tuikit.tuichat.classicui.widget.input.inputmore.InputMoreFragment;
import com.tencent.qcloud.tuikit.tuichat.component.AudioRecorder;
import com.tencent.qcloud.tuikit.tuichat.config.TUIChatConfigs;
import com.tencent.qcloud.tuikit.tuichat.presenter.ChatPresenter;
import com.tencent.qcloud.tuikit.tuichat.util.ChatMessageBuilder;
import com.tencent.qcloud.tuikit.tuichat.util.ChatMessageParser;
import com.tencent.qcloud.tuikit.tuichat.util.PermissionHelper;
import com.tencent.qcloud.tuikit.tuichat.util.TUIChatLog;
import com.tencent.qcloud.tuikit.tuichat.util.TUIChatUtils;
import com.tencent.rtmp.TXLivePushConfig;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class InputView extends LinearLayout implements View.OnClickListener, TextWatcher {
    public static final int CALL_MEMBER_LIMIT = 8;
    private static final int STATE_ACTION_INPUT = 3;
    private static final int STATE_FACE_INPUT = 2;
    private static final int STATE_NONE_INPUT = -1;
    private static final int STATE_SOFT_INPUT = 0;
    private static final int STATE_VOICE_INPUT = 1;
    /* access modifiers changed from: private */
    public static final String TAG = InputView.class.getSimpleName();
    private Map<String, String> atUserInfoMap = new HashMap();
    private String displayInputString;
    /* access modifiers changed from: private */
    public boolean isQuoteModel = false;
    /* access modifiers changed from: private */
    public boolean isReplyModel = false;
    private boolean isShowCustomFace = true;
    public AppCompatActivity mActivity;
    /* access modifiers changed from: private */
    public boolean mAudioCancel;
    public boolean mAudioInputDisable;
    public ImageView mAudioInputSwitchButton;
    private boolean mCaptureDisable;
    public ChatInfo mChatInfo;
    /* access modifiers changed from: private */
    public ChatInputHandler mChatInputHandler;
    /* access modifiers changed from: private */
    public IChatLayout mChatLayout;
    private int mCurrentState;
    public ImageView mEmojiInputButton;
    public boolean mEmojiInputDisable;
    private FaceFragment mFaceFragment;
    private FragmentManager mFragmentManager;
    private String mInputContent;
    public List<InputMoreActionUnit> mInputMoreActionList = new ArrayList();
    public List<InputMoreActionUnit> mInputMoreCustomActionList = new ArrayList();
    /* access modifiers changed from: private */
    public InputMoreFragment mInputMoreFragment;
    public View mInputMoreLayout;
    public View mInputMoreView;
    private boolean mIsSending = false;
    private int mLastMsgLineCount;
    /* access modifiers changed from: private */
    public MessageHandler mMessageHandler;
    public ImageView mMoreInputButton;
    public boolean mMoreInputDisable;
    public Object mMoreInputEvent;
    /* access modifiers changed from: private */
    public OnInputViewListener mOnInputViewListener;
    public Button mSendAudioButton;
    private boolean mSendEnable;
    private boolean mSendFileDisable;
    private boolean mSendPhotoDisable;
    public TextView mSendTextButton;
    /* access modifiers changed from: private */
    public float mStartRecordY;
    public TIMMentionEditText mTextInput;
    private boolean mVideoRecordDisable;
    /* access modifiers changed from: private */
    public ChatPresenter presenter;
    private ImageView quoteCloseBtn;
    private View quotePreviewBar;
    private TextView quoteTv;
    private ImageView replyCloseBtn;
    private View replyPreviewBar;
    private ReplyPreviewBean replyPreviewBean;
    private TextView replyTv;

    public interface ChatInputHandler {
        public static final int RECORD_CANCEL = 3;
        public static final int RECORD_FAILED = 5;
        public static final int RECORD_START = 1;
        public static final int RECORD_STOP = 2;
        public static final int RECORD_TOO_SHORT = 4;

        void onInputAreaClick();

        void onRecordStatusChanged(int i11);

        void onUserTyping(boolean z11, long j11);
    }

    public interface MessageHandler {
        void scrollToEnd();

        void sendMessage(TUIMessageBean tUIMessageBean);
    }

    public interface OnInputViewListener {
        void onStartGroupMemberSelectActivity();

        void onUpdateChatBackground();
    }

    public InputView(Context context) {
        super(context);
        initViews();
    }

    /* access modifiers changed from: private */
    public TUIMessageBean buildVideoMessage(String str) {
        MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
        try {
            mediaMetadataRetriever.setDataSource(str);
            String extractMetadata = mediaMetadataRetriever.extractMetadata(9);
            Bitmap frameAtTime = mediaMetadataRetriever.getFrameAtTime(0, 1);
            if (frameAtTime == null) {
                TUIChatLog.e(TAG, "buildVideoMessage() bitmap is null");
                try {
                    mediaMetadataRetriever.release();
                } catch (Exception e11) {
                    e11.printStackTrace();
                }
                return null;
            }
            TUIMessageBean buildVideoMessage = ChatMessageBuilder.buildVideoMessage(FileUtil.saveBitmap("JCamera", frameAtTime), str, frameAtTime.getWidth(), frameAtTime.getHeight(), Long.valueOf(extractMetadata).longValue());
            try {
                mediaMetadataRetriever.release();
            } catch (Exception e12) {
                e12.printStackTrace();
            }
            return buildVideoMessage;
        } catch (Exception e13) {
            String str2 = TAG;
            TUIChatLog.e(str2, "MediaMetadataRetriever exception " + e13);
            try {
                mediaMetadataRetriever.release();
            } catch (Exception e14) {
                e14.printStackTrace();
            }
            return null;
        } catch (Throwable th2) {
            try {
                mediaMetadataRetriever.release();
            } catch (Exception e15) {
                e15.printStackTrace();
            }
            throw th2;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0033  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private java.util.Map<java.lang.String, java.lang.String> getDisplayAtNameMap(java.util.List<java.lang.String> r9, java.util.List<java.lang.String> r10) {
        /*
            r8 = this;
            java.util.HashMap r0 = new java.util.HashMap
            r0.<init>()
            com.tencent.qcloud.tuikit.tuichat.classicui.widget.input.TIMMentionEditText r1 = r8.mTextInput
            java.lang.String r2 = "@"
            if (r1 == 0) goto L_0x002a
            android.text.Editable r1 = r1.getText()
            com.tencent.qcloud.tuikit.tuichat.classicui.widget.input.TIMMentionEditText r3 = r8.mTextInput
            int r3 = r3.getSelectionEnd()
            if (r1 == 0) goto L_0x002a
            if (r3 <= 0) goto L_0x002a
            java.lang.String r1 = r1.toString()
            boolean r4 = android.text.TextUtils.isEmpty(r1)
            if (r4 != 0) goto L_0x002a
            int r4 = r3 + -1
            java.lang.String r1 = r1.substring(r4, r3)
            goto L_0x002b
        L_0x002a:
            r1 = r2
        L_0x002b:
            r3 = 0
            r4 = r3
        L_0x002d:
            int r5 = r10.size()
            if (r4 >= r5) goto L_0x00da
            java.lang.String r5 = " "
            if (r4 != 0) goto L_0x0087
            java.lang.Object r6 = r9.get(r3)
            java.lang.CharSequence r6 = (java.lang.CharSequence) r6
            boolean r6 = android.text.TextUtils.isEmpty(r6)
            if (r6 == 0) goto L_0x0065
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            r6.append(r1)
            java.lang.Object r7 = r10.get(r3)
            java.lang.String r7 = (java.lang.String) r7
            r6.append(r7)
            r6.append(r5)
            java.lang.String r5 = r6.toString()
            java.lang.Object r6 = r10.get(r3)
            java.lang.String r6 = (java.lang.String) r6
            r0.put(r5, r6)
            goto L_0x00d6
        L_0x0065:
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            r6.append(r1)
            java.lang.Object r7 = r9.get(r3)
            java.lang.String r7 = (java.lang.String) r7
            r6.append(r7)
            r6.append(r5)
            java.lang.String r5 = r6.toString()
            java.lang.Object r6 = r10.get(r3)
            java.lang.String r6 = (java.lang.String) r6
            r0.put(r5, r6)
            goto L_0x00d6
        L_0x0087:
            java.lang.Object r6 = r9.get(r4)
            java.lang.CharSequence r6 = (java.lang.CharSequence) r6
            boolean r6 = android.text.TextUtils.isEmpty(r6)
            if (r6 == 0) goto L_0x00a9
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            r6.append(r2)
            java.lang.Object r7 = r10.get(r4)
            java.lang.String r7 = (java.lang.String) r7
            r6.append(r7)
            java.lang.String r6 = r6.toString()
            goto L_0x00be
        L_0x00a9:
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            r6.append(r2)
            java.lang.Object r7 = r9.get(r4)
            java.lang.String r7 = (java.lang.String) r7
            r6.append(r7)
            java.lang.String r6 = r6.toString()
        L_0x00be:
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>()
            r7.append(r6)
            r7.append(r5)
            java.lang.String r5 = r7.toString()
            java.lang.Object r6 = r10.get(r4)
            java.lang.String r6 = (java.lang.String) r6
            r0.put(r5, r6)
        L_0x00d6:
            int r4 = r4 + 1
            goto L_0x002d
        L_0x00da:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.qcloud.tuikit.tuichat.classicui.widget.input.InputView.getDisplayAtNameMap(java.util.List, java.util.List):java.util.Map");
    }

    private List<InputMoreActionUnit> getExtensionInputMoreList() {
        ArrayList arrayList = new ArrayList();
        HashMap hashMap = new HashMap();
        hashMap.put("ChatContext", getContext());
        if (1 == this.mChatInfo.getType()) {
            hashMap.put(TUIConstants.TUIChat.Extension.InputMore.USER_ID, this.mChatInfo.getId());
        } else {
            hashMap.put(TUIConstants.TUIChat.Extension.InputMore.GROUP_ID, this.mChatInfo.getId());
        }
        hashMap.put(TUIConstants.TUIChat.Extension.InputMore.FILTER_VIDEO_CALL, Boolean.valueOf(!TUIChatConfigs.getConfigs().getGeneralConfig().isEnableVideoCall()));
        hashMap.put(TUIConstants.TUIChat.Extension.InputMore.FILTER_VOICE_CALL, Boolean.valueOf(!TUIChatConfigs.getConfigs().getGeneralConfig().isEnableVoiceCall()));
        for (final TUIExtensionInfo next : TUICore.getExtensionList(TUIConstants.TUIChat.Extension.InputMore.CLASSIC_EXTENSION_ID, hashMap)) {
            if (next != null) {
                String text = next.getText();
                int intValue = ((Integer) next.getIcon()).intValue();
                int weight = next.getWeight();
                AnonymousClass27 r62 = new InputMoreActionUnit() {
                    public void onAction(String str, int i11) {
                        TUIExtensionEventListener extensionListener = next.getExtensionListener();
                        if (extensionListener != null) {
                            extensionListener.onClicked((Map<String, Object>) null);
                        }
                    }
                };
                r62.setName(text);
                r62.setIconResId(intValue);
                r62.setPriority(weight);
                arrayList.add(r62);
            }
        }
        return arrayList;
    }

    private int getNavigateBarHeight() {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        WindowManager windowManager = (WindowManager) getContext().getSystemService("window");
        windowManager.getDefaultDisplay().getMetrics(displayMetrics);
        int i11 = displayMetrics.heightPixels;
        windowManager.getDefaultDisplay().getRealMetrics(displayMetrics);
        int i12 = displayMetrics.heightPixels;
        if (i12 > i11) {
            return i12 - i11;
        }
        return 0;
    }

    private String getString(int i11) {
        return getResources().getString(i11);
    }

    /* access modifiers changed from: private */
    public void hideInputMoreLayout() {
        this.mInputMoreView.setVisibility(8);
    }

    private void initViews() {
        AppCompatActivity appCompatActivity = (AppCompatActivity) getContext();
        this.mActivity = appCompatActivity;
        LinearLayout.inflate(appCompatActivity, R.layout.chat_input_layout, this);
        this.mInputMoreView = findViewById(R.id.more_groups);
        this.mSendAudioButton = (Button) findViewById(R.id.chat_voice_input);
        this.mAudioInputSwitchButton = (ImageView) findViewById(R.id.voice_input_switch);
        this.mEmojiInputButton = (ImageView) findViewById(R.id.face_btn);
        this.mMoreInputButton = (ImageView) findViewById(R.id.more_btn);
        this.mSendTextButton = (TextView) findViewById(R.id.send_btn);
        this.mTextInput = (TIMMentionEditText) findViewById(R.id.chat_message_input);
        View findViewById = findViewById(R.id.reply_preview_bar);
        this.replyPreviewBar = findViewById;
        int i11 = R.id.reply_text;
        this.replyTv = (TextView) findViewById.findViewById(i11);
        View view = this.replyPreviewBar;
        int i12 = R.id.reply_close_btn;
        this.replyCloseBtn = (ImageView) view.findViewById(i12);
        View findViewById2 = findViewById(R.id.quote_preview_bar);
        this.quotePreviewBar = findViewById2;
        this.quoteTv = (TextView) findViewById2.findViewById(i11);
        this.quoteCloseBtn = (ImageView) this.quotePreviewBar.findViewById(i12);
        int dimensionPixelSize = getResources().getDimensionPixelSize(R.dimen.chat_input_icon_size);
        ViewGroup.LayoutParams layoutParams = this.mEmojiInputButton.getLayoutParams();
        layoutParams.width = dimensionPixelSize;
        layoutParams.height = dimensionPixelSize;
        this.mEmojiInputButton.setLayoutParams(layoutParams);
        ViewGroup.LayoutParams layoutParams2 = this.mAudioInputSwitchButton.getLayoutParams();
        layoutParams2.width = dimensionPixelSize;
        layoutParams2.height = dimensionPixelSize;
        this.mAudioInputSwitchButton.setLayoutParams(layoutParams2);
        ViewGroup.LayoutParams layoutParams3 = this.mMoreInputButton.getLayoutParams();
        layoutParams3.width = dimensionPixelSize;
        layoutParams3.height = dimensionPixelSize;
        this.mMoreInputButton.setLayoutParams(layoutParams3);
        this.mIsSending = false;
        init();
    }

    private boolean isSoftInputShown() {
        View decorView = ((Activity) getContext()).getWindow().getDecorView();
        int height = decorView.getHeight();
        Rect rect = new Rect();
        decorView.getWindowVisibleDisplayFrame(rect);
        return (height - rect.bottom) - getNavigateBarHeight() >= 0;
    }

    /* access modifiers changed from: private */
    public void recordComplete(boolean z11) {
        int duration = AudioRecorder.getInstance().getDuration();
        String str = TAG;
        TUIChatLog.i(str, "recordComplete duration:" + duration);
        ChatInputHandler chatInputHandler = this.mChatInputHandler;
        if (chatInputHandler != null) {
            if (!z11 || duration == 0) {
                chatInputHandler.onRecordStatusChanged(5);
                return;
            } else if (this.mAudioCancel) {
                chatInputHandler.onRecordStatusChanged(3);
                return;
            } else if (duration < 1000) {
                chatInputHandler.onRecordStatusChanged(4);
                return;
            } else {
                chatInputHandler.onRecordStatusChanged(2);
            }
        }
        MessageHandler messageHandler = this.mMessageHandler;
        if (messageHandler != null && z11) {
            messageHandler.sendMessage(ChatMessageBuilder.buildAudioMessage(AudioRecorder.getInstance().getPath(), duration));
        }
    }

    /* access modifiers changed from: private */
    public void setOpenPhotoCallback() {
        this.mInputMoreFragment.setCallback(new IUIKitCallback() {
            public void onError(String str, int i11, String str2) {
                String access$700 = InputView.TAG;
                TUIChatLog.i(access$700, "errCode: " + i11);
                ToastUtil.toastLongMessage(str2);
            }

            public void onSuccess(Object obj) {
                String access$700 = InputView.TAG;
                TUIChatLog.i(access$700, "onSuccess: " + obj);
                if (obj == null) {
                    TUIChatLog.e(InputView.TAG, "data is null");
                } else if (TextUtils.isEmpty(obj.toString())) {
                    TUIChatLog.e(InputView.TAG, "uri is empty");
                } else {
                    Uri uri = (Uri) obj;
                    String mimeTypeFromExtension = MimeTypeMap.getSingleton().getMimeTypeFromExtension(FileUtil.getFileExtensionFromUrl(FileUtil.getFileName(ServiceInitializer.getAppContext(), uri)));
                    if (TextUtils.isEmpty(mimeTypeFromExtension)) {
                        TUIChatLog.e(InputView.TAG, "mimeType is empty.");
                    } else if (mimeTypeFromExtension.contains("video")) {
                        TUIMessageBean access$1000 = InputView.this.buildVideoMessage(FileUtil.getPathFromUri(uri));
                        if (access$1000 == null) {
                            ToastUtil.toastShortMessage(InputView.this.getResources().getString(R.string.send_failed_file_not_exists));
                            String access$7002 = InputView.TAG;
                            TUIChatLog.e(access$7002, "start send video error data: " + obj);
                        } else if (InputView.this.mMessageHandler != null) {
                            InputView.this.mMessageHandler.sendMessage(access$1000);
                            InputView.this.hideSoftInput();
                        }
                    } else if (mimeTypeFromExtension.contains("image")) {
                        TUIMessageBean buildImageMessage = ChatMessageBuilder.buildImageMessage(uri);
                        if (buildImageMessage == null) {
                            String access$7003 = InputView.TAG;
                            TUIChatLog.e(access$7003, "start send image error data: " + obj);
                            ToastUtil.toastShortMessage(InputView.this.getResources().getString(R.string.send_failed_file_not_exists));
                        } else if (InputView.this.mMessageHandler != null) {
                            InputView.this.mMessageHandler.sendMessage(buildImageMessage);
                            InputView.this.hideSoftInput();
                        }
                    } else {
                        String access$7004 = InputView.TAG;
                        TUIChatLog.e(access$7004, "Send photo or video failed , invalid mimeType : " + mimeTypeFromExtension);
                    }
                }
            }
        });
    }

    private void showCustomInputMoreFragment() {
        TUIChatLog.i(TAG, "showCustomInputMoreFragment");
        if (this.mFragmentManager == null) {
            this.mFragmentManager = this.mActivity.getSupportFragmentManager();
        }
        hideSoftInput();
        this.mInputMoreView.setVisibility(0);
        this.mFragmentManager.q().t(R.id.more_groups, (BaseInputFragment) this.mMoreInputEvent).k();
        if (this.mChatInputHandler != null) {
            postDelayed(new Runnable() {
                public void run() {
                    InputView.this.mChatInputHandler.onInputAreaClick();
                }
            }, 100);
        }
    }

    private void showFaceViewGroup() {
        TUIChatLog.i(TAG, "showFaceViewGroup");
        if (this.mFragmentManager == null) {
            this.mFragmentManager = this.mActivity.getSupportFragmentManager();
        }
        if (this.mFaceFragment == null) {
            this.mFaceFragment = new FaceFragment();
        }
        hideSoftInput();
        this.mInputMoreView.setVisibility(0);
        this.mTextInput.requestFocus();
        this.mFaceFragment.setShowCustomFace(this.isShowCustomFace);
        this.mFaceFragment.setListener(new FaceFragment.OnEmojiClickListener() {
            public void onCustomFaceClick(int i11, CustomFace customFace) {
                InputView.this.mMessageHandler.sendMessage(ChatMessageBuilder.buildFaceMessage(i11, customFace.getFaceKey()));
            }

            public void onEmojiClick(Emoji emoji) {
                int selectionStart = InputView.this.mTextInput.getSelectionStart();
                Editable text = InputView.this.mTextInput.getText();
                text.insert(selectionStart, emoji.getFaceKey());
                FaceManager.handlerEmojiText(InputView.this.mTextInput, text, true);
            }

            public void onEmojiDelete() {
                boolean z11;
                int selectionStart = InputView.this.mTextInput.getSelectionStart();
                Editable text = InputView.this.mTextInput.getText();
                if (selectionStart > 0) {
                    int i11 = selectionStart - 1;
                    if (text.charAt(i11) == ']') {
                        int i12 = selectionStart - 2;
                        while (true) {
                            if (i12 < 0) {
                                break;
                            } else if (text.charAt(i12) != '[') {
                                i12--;
                            } else if (FaceManager.isFaceChar(text.subSequence(i12, selectionStart).toString())) {
                                text.delete(i12, selectionStart);
                                z11 = true;
                            }
                        }
                    }
                    z11 = false;
                    if (!z11) {
                        text.delete(i11, selectionStart);
                    }
                }
            }
        });
        this.mFragmentManager.q().t(R.id.more_groups, this.mFaceFragment).k();
        if (this.mChatInputHandler != null) {
            postDelayed(new Runnable() {
                public void run() {
                    InputView.this.mChatInputHandler.onInputAreaClick();
                }
            }, 100);
        }
    }

    private void showInputMoreLayout() {
        TUIChatLog.i(TAG, "showInputMoreLayout");
        if (this.mFragmentManager == null) {
            this.mFragmentManager = this.mActivity.getSupportFragmentManager();
        }
        if (this.mInputMoreFragment == null) {
            this.mInputMoreFragment = new InputMoreFragment();
        }
        assembleActions();
        this.mInputMoreFragment.setActions(this.mInputMoreActionList);
        hideSoftInput();
        this.mInputMoreView.setVisibility(0);
        this.mFragmentManager.q().t(R.id.more_groups, this.mInputMoreFragment).k();
        if (this.mChatInputHandler != null) {
            postDelayed(new Runnable() {
                public void run() {
                    InputView.this.mChatInputHandler.onInputAreaClick();
                }
            }, 100);
        }
    }

    private void updateAtUserInfoMap(ArrayList<String> arrayList, ArrayList<String> arrayList2) {
        this.displayInputString = "";
        for (int i11 = 0; i11 < arrayList2.size(); i11++) {
            this.atUserInfoMap.put(arrayList2.get(i11), arrayList.get(i11));
            if (TextUtils.isEmpty(arrayList.get(i11))) {
                this.displayInputString += arrayList2.get(i11);
                this.displayInputString += " ";
                this.displayInputString += TIMMentionEditText.TIM_MENTION_TAG;
            } else {
                this.displayInputString += arrayList.get(i11);
                this.displayInputString += " ";
                this.displayInputString += TIMMentionEditText.TIM_MENTION_TAG;
            }
        }
        if (!this.displayInputString.isEmpty()) {
            String str = this.displayInputString;
            this.displayInputString = str.substring(0, str.length() - 1);
        }
    }

    private void updateChatBackground() {
        OnInputViewListener onInputViewListener = this.mOnInputViewListener;
        if (onInputViewListener != null) {
            onInputViewListener.onUpdateChatBackground();
        }
    }

    public void addAction(InputMoreActionUnit inputMoreActionUnit) {
        this.mInputMoreCustomActionList.add(inputMoreActionUnit);
    }

    public void addInputText(String str, String str2) {
        if (str2 != null && !str2.isEmpty()) {
            updateAtUserInfoMap(new ArrayList<String>(str) {
                public final /* synthetic */ String val$name;

                {
                    this.val$name = r2;
                    add(r2);
                }
            }, new ArrayList<String>(str2) {
                public final /* synthetic */ String val$id;

                {
                    this.val$id = r2;
                    add(r2);
                }
            });
            if (this.mTextInput != null) {
                HashMap hashMap = new HashMap();
                hashMap.put(TIMMentionEditText.TIM_MENTION_TAG + this.displayInputString, str2);
                this.mTextInput.setMentionMap(hashMap);
                int selectionEnd = this.mTextInput.getSelectionEnd();
                if (selectionEnd != -1) {
                    String str3 = TIMMentionEditText.TIM_MENTION_TAG + this.displayInputString;
                    FaceManager.handlerEmojiText(this.mTextInput, this.mTextInput.getText().insert(selectionEnd, str3).toString(), true);
                    this.mTextInput.setSelection(selectionEnd + str3.length());
                }
                showSoftInput();
            }
        }
    }

    public void afterTextChanged(Editable editable) {
        if (TextUtils.isEmpty(editable.toString().trim())) {
            this.mSendEnable = false;
            showSendTextButton(8);
            showMoreInputButton(0);
            ChatInputHandler chatInputHandler = this.mChatInputHandler;
            if (chatInputHandler != null) {
                chatInputHandler.onUserTyping(false, V2TIMManager.getInstance().getServerTime());
            }
        } else {
            this.mSendEnable = true;
            showSendTextButton(0);
            showMoreInputButton(8);
            if (this.mTextInput.getLineCount() != this.mLastMsgLineCount) {
                this.mLastMsgLineCount = this.mTextInput.getLineCount();
                ChatInputHandler chatInputHandler2 = this.mChatInputHandler;
                if (chatInputHandler2 != null) {
                    chatInputHandler2.onInputAreaClick();
                }
            }
            if (!TextUtils.equals(this.mInputContent, this.mTextInput.getText().toString())) {
                TIMMentionEditText tIMMentionEditText = this.mTextInput;
                FaceManager.handlerEmojiText(tIMMentionEditText, tIMMentionEditText.getText(), true);
            }
        }
        ChatInputHandler chatInputHandler3 = this.mChatInputHandler;
        if (chatInputHandler3 != null && !this.mIsSending) {
            chatInputHandler3.onUserTyping(true, V2TIMManager.getInstance().getServerTime());
        }
        if (this.mIsSending) {
            this.mIsSending = false;
        }
    }

    public void appendText(String str) {
        if (this.mChatInfo == null) {
            TUIChatLog.e(TAG, "appendText error :  chatInfo is null");
            return;
        }
        TIMMentionEditText tIMMentionEditText = this.mTextInput;
        if (tIMMentionEditText == null) {
            TUIChatLog.e(TAG, "appendText error :  textInput is null");
            return;
        }
        String obj = tIMMentionEditText.getText().toString();
        this.mTextInput.setText(obj + str);
        TIMMentionEditText tIMMentionEditText2 = this.mTextInput;
        tIMMentionEditText2.setSelection(tIMMentionEditText2.getText().length());
    }

    public void assembleActions() {
        this.mInputMoreActionList.clear();
        if (!this.mSendPhotoDisable) {
            AnonymousClass22 r02 = new InputMoreActionUnit() {
                public void onAction(String str, int i11) {
                    InputView.this.startSendPhoto();
                }
            };
            r02.setIconResId(R.drawable.ic_more_picture);
            r02.setName(getString(R.string.pic));
            r02.setPriority(1000);
            this.mInputMoreActionList.add(r02);
        }
        if (!this.mCaptureDisable) {
            AnonymousClass23 r03 = new InputMoreActionUnit() {
                public void onAction(String str, int i11) {
                    InputView.this.startCapture();
                }
            };
            r03.setIconResId(R.drawable.ic_more_camera);
            r03.setName(getString(R.string.photo));
            r03.setPriority(900);
            this.mInputMoreActionList.add(r03);
        }
        if (!this.mVideoRecordDisable) {
            AnonymousClass24 r04 = new InputMoreActionUnit() {
                public void onAction(String str, int i11) {
                    InputView.this.startVideoRecord();
                }
            };
            r04.setIconResId(R.drawable.ic_more_video);
            r04.setPriority(TXLivePushConfig.DEFAULT_MIN_VIDEO_BITRATE);
            r04.setName(getString(R.string.video));
            this.mInputMoreActionList.add(r04);
        }
        if (!this.mSendFileDisable) {
            AnonymousClass25 r05 = new InputMoreActionUnit() {
                public void onAction(String str, int i11) {
                    InputView.this.startSendFile();
                }
            };
            r05.setIconResId(R.drawable.ic_more_file);
            r05.setName(getString(R.string.file));
            r05.setPriority(700);
            this.mInputMoreActionList.add(r05);
        }
        this.mInputMoreActionList.addAll(this.mInputMoreCustomActionList);
        this.mInputMoreActionList.addAll(getExtensionInputMoreList());
        Collections.sort(this.mInputMoreActionList, new Comparator<InputMoreActionUnit>() {
            public int compare(InputMoreActionUnit inputMoreActionUnit, InputMoreActionUnit inputMoreActionUnit2) {
                return inputMoreActionUnit2.getPriority() - inputMoreActionUnit.getPriority();
            }
        });
    }

    public void beforeTextChanged(CharSequence charSequence, int i11, int i12, int i13) {
        this.mInputContent = charSequence.toString();
    }

    public void clearCustomActionList() {
        this.mInputMoreCustomActionList.clear();
    }

    public void disableAudioInput(boolean z11) {
        this.mAudioInputDisable = z11;
        if (z11) {
            this.mAudioInputSwitchButton.setVisibility(8);
        } else {
            this.mAudioInputSwitchButton.setVisibility(0);
        }
    }

    public void disableCaptureAction(boolean z11) {
        this.mCaptureDisable = z11;
    }

    public void disableEmojiInput(boolean z11) {
        this.mEmojiInputDisable = z11;
        if (z11) {
            this.mEmojiInputButton.setVisibility(8);
        } else {
            this.mEmojiInputButton.setVisibility(0);
        }
    }

    public void disableMoreInput(boolean z11) {
        this.mMoreInputDisable = z11;
        if (z11) {
            this.mMoreInputButton.setVisibility(8);
            this.mSendTextButton.setVisibility(0);
            return;
        }
        this.mMoreInputButton.setVisibility(0);
        this.mSendTextButton.setVisibility(8);
    }

    public void disableSendFileAction(boolean z11) {
        this.mSendFileDisable = z11;
    }

    public void disableSendPhotoAction(boolean z11) {
        this.mSendPhotoDisable = z11;
    }

    public void disableShowCustomFace(boolean z11) {
        this.isShowCustomFace = !z11;
    }

    public void disableVideoRecordAction(boolean z11) {
        this.mVideoRecordDisable = z11;
    }

    public void exitReply() {
        this.isReplyModel = false;
        this.replyPreviewBean = null;
        this.replyPreviewBar.setVisibility(8);
        this.isQuoteModel = false;
        this.quotePreviewBar.setVisibility(8);
        updateChatBackground();
    }

    public ChatInfo getChatInfo() {
        return this.mChatInfo;
    }

    public EditText getInputText() {
        return this.mTextInput;
    }

    public void hideSoftInput() {
        Window window;
        TUIChatLog.i(TAG, "hideSoftInput");
        ((InputMethodManager) getContext().getSystemService("input_method")).hideSoftInputFromWindow(this.mTextInput.getWindowToken(), 0);
        this.mTextInput.clearFocus();
        Context context = getContext();
        if ((context instanceof Activity) && (window = ((Activity) context).getWindow()) != null) {
            window.setSoftInputMode(48);
        }
    }

    @SuppressLint({"ClickableViewAccessibility"})
    public void init() {
        this.mAudioInputSwitchButton.setOnClickListener(this);
        this.mEmojiInputButton.setOnClickListener(this);
        this.mMoreInputButton.setOnClickListener(this);
        this.mSendTextButton.setOnClickListener(this);
        this.mTextInput.addTextChangedListener(this);
        this.mTextInput.setOnTouchListener(new View.OnTouchListener() {
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() != 0) {
                    return false;
                }
                if (InputView.this.presenter != null) {
                    InputView.this.presenter.scrollToNewestMessage();
                }
                InputView.this.showSoftInput();
                return false;
            }
        });
        this.mTextInput.setOnKeyListener(new View.OnKeyListener() {
            public boolean onKey(View view, int i11, KeyEvent keyEvent) {
                if (i11 != 67 || keyEvent.getAction() != 0) {
                    return false;
                }
                if ((!InputView.this.isQuoteModel && !InputView.this.isReplyModel) || !TextUtils.isEmpty(InputView.this.mTextInput.getText().toString())) {
                    return false;
                }
                InputView.this.exitReply();
                return false;
            }
        });
        this.mTextInput.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            public boolean onEditorAction(TextView textView, int i11, KeyEvent keyEvent) {
                return false;
            }
        });
        this.mTextInput.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            public void onFocusChange(View view, boolean z11) {
                if (!z11 && InputView.this.mChatInputHandler != null) {
                    InputView.this.mChatInputHandler.onUserTyping(false, V2TIMManager.getInstance().getServerTime());
                }
            }
        });
        this.mSendAudioButton.setOnTouchListener(new View.OnTouchListener() {
            public boolean onTouch(View view, final MotionEvent motionEvent) {
                PermissionHelper.requestPermission(1, new PermissionHelper.PermissionCallback() {
                    public void onDenied() {
                        TUIChatLog.i(InputView.TAG, "audio record checkPermission failed");
                    }

                    public void onGranted() {
                        int action = motionEvent.getAction();
                        boolean z11 = true;
                        if (action != 0) {
                            if (action != 1) {
                                if (action == 2) {
                                    if (motionEvent.getY() - InputView.this.mStartRecordY < -100.0f) {
                                        boolean unused = InputView.this.mAudioCancel = true;
                                        if (InputView.this.mChatInputHandler != null) {
                                            InputView.this.mChatInputHandler.onRecordStatusChanged(3);
                                        }
                                    } else {
                                        if (InputView.this.mAudioCancel && InputView.this.mChatInputHandler != null) {
                                            InputView.this.mChatInputHandler.onRecordStatusChanged(1);
                                        }
                                        boolean unused2 = InputView.this.mAudioCancel = false;
                                    }
                                    InputView.this.mSendAudioButton.setText(ServiceInitializer.getAppContext().getString(R.string.release_end));
                                    return;
                                } else if (action != 3) {
                                    return;
                                }
                            }
                            InputView inputView = InputView.this;
                            if (motionEvent.getY() - InputView.this.mStartRecordY >= -100.0f) {
                                z11 = false;
                            }
                            boolean unused3 = inputView.mAudioCancel = z11;
                            if (InputView.this.mChatInputHandler != null) {
                                InputView.this.mChatInputHandler.onRecordStatusChanged(2);
                            }
                            AudioRecorder.getInstance().stopRecord();
                            InputView.this.mSendAudioButton.setText(ServiceInitializer.getAppContext().getString(R.string.hold_say));
                            return;
                        }
                        boolean unused4 = InputView.this.mAudioCancel = true;
                        float unused5 = InputView.this.mStartRecordY = motionEvent.getY();
                        if (InputView.this.mChatInputHandler != null) {
                            InputView.this.mChatInputHandler.onRecordStatusChanged(1);
                        }
                        InputView.this.mSendAudioButton.setText(ServiceInitializer.getAppContext().getString(R.string.release_end));
                        AudioRecorder.getInstance().startRecord(new AudioRecorder.Callback() {
                            public void onCompletion(Boolean bool) {
                                InputView.this.recordComplete(bool.booleanValue());
                            }

                            public void onVoiceDb(double d11) {
                            }
                        });
                    }
                });
                return false;
            }
        });
        this.mTextInput.setOnMentionInputListener(new TIMMentionEditText.OnMentionInputListener() {
            public void onMentionCharacterInput(String str) {
                if ((str.equals(TIMMentionEditText.TIM_MENTION_TAG) || str.equals(TIMMentionEditText.TIM_MENTION_TAG_FULL)) && TUIChatUtils.isGroupChat(InputView.this.mChatLayout.getChatInfo().getType()) && InputView.this.mOnInputViewListener != null) {
                    InputView.this.mOnInputViewListener.onStartGroupMemberSelectActivity();
                }
            }
        });
        this.replyCloseBtn.setOnClickListener(new View.OnClickListener() {
            @SensorsDataInstrumented
            public void onClick(View view) {
                InputView.this.exitReply();
                SensorsDataAutoTrackHelper.trackViewOnClick(view);
            }
        });
        this.quoteCloseBtn.setOnClickListener(new View.OnClickListener() {
            @SensorsDataInstrumented
            public void onClick(View view) {
                InputView.this.exitReply();
                SensorsDataAutoTrackHelper.trackViewOnClick(view);
            }
        });
    }

    @SensorsDataInstrumented
    public void onClick(View view) {
        String str = TAG;
        StringBuilder sb2 = new StringBuilder();
        sb2.append("onClick id:");
        sb2.append(view.getId());
        sb2.append("|voice_input_switch:");
        int i11 = R.id.voice_input_switch;
        sb2.append(i11);
        sb2.append("|face_btn:");
        int i12 = R.id.face_btn;
        sb2.append(i12);
        sb2.append("|more_btn:");
        int i13 = R.id.more_btn;
        sb2.append(i13);
        sb2.append("|send_btn:");
        int i14 = R.id.send_btn;
        sb2.append(i14);
        sb2.append("|mCurrentState:");
        sb2.append(this.mCurrentState);
        sb2.append("|mSendEnable:");
        sb2.append(this.mSendEnable);
        sb2.append("|mMoreInputEvent:");
        sb2.append(this.mMoreInputEvent);
        TUIChatLog.i(str, sb2.toString());
        if (view.getId() == i11) {
            int i15 = this.mCurrentState;
            if (i15 == 2 || i15 == 3) {
                this.mCurrentState = 1;
                this.mInputMoreView.setVisibility(8);
                this.mEmojiInputButton.setImageResource(R.drawable.action_face_selector);
            } else if (i15 == 0) {
                this.mCurrentState = 1;
            } else {
                this.mCurrentState = 0;
            }
            if (this.mCurrentState == 1) {
                this.mSendAudioButton.setVisibility(0);
                this.mTextInput.setVisibility(8);
                this.mAudioInputSwitchButton.setImageResource(R.drawable.chat_input_keyboard);
                hideInputMoreLayout();
                hideSoftInput();
            } else {
                this.mAudioInputSwitchButton.setImageResource(R.drawable.action_audio_selector);
                this.mSendAudioButton.setVisibility(8);
                this.mTextInput.setVisibility(0);
                showSoftInput();
            }
        } else if (view.getId() == i12) {
            this.mAudioInputSwitchButton.setImageResource(R.drawable.action_audio_selector);
            if (this.mCurrentState == 1) {
                this.mCurrentState = -1;
                this.mSendAudioButton.setVisibility(8);
                this.mTextInput.setVisibility(0);
            }
            if (this.mCurrentState == 2) {
                this.mCurrentState = 0;
                this.mEmojiInputButton.setImageResource(R.drawable.action_face_selector);
                this.mTextInput.setVisibility(0);
                showSoftInput();
            } else {
                this.mCurrentState = 2;
                this.mEmojiInputButton.setImageResource(R.drawable.chat_input_keyboard);
                showFaceViewGroup();
            }
        } else if (view.getId() == i13) {
            hideSoftInput();
            Object obj = this.mMoreInputEvent;
            if (obj instanceof View.OnClickListener) {
                ((View.OnClickListener) obj).onClick(view);
            } else if (obj instanceof BaseInputFragment) {
                showCustomInputMoreFragment();
            } else if (this.mCurrentState == 3) {
                this.mCurrentState = -1;
                this.mInputMoreView.setVisibility(0);
            } else {
                showInputMoreLayout();
                this.mCurrentState = 3;
                this.mAudioInputSwitchButton.setImageResource(R.drawable.action_audio_selector);
                this.mEmojiInputButton.setImageResource(R.drawable.action_face_selector);
                this.mSendAudioButton.setVisibility(8);
                this.mTextInput.setVisibility(0);
            }
        } else if (view.getId() == i14 && this.mSendEnable) {
            MessageHandler messageHandler = this.mMessageHandler;
            if (messageHandler != null) {
                IChatLayout iChatLayout = this.mChatLayout;
                if (iChatLayout == null) {
                    messageHandler.sendMessage(ChatMessageBuilder.buildTextMessage(this.mTextInput.getText().toString()));
                } else if ((this.isQuoteModel || this.isReplyModel) && this.replyPreviewBean != null) {
                    if (!TUIChatUtils.isGroupChat(iChatLayout.getChatInfo().getType()) || this.mTextInput.getMentionIdList().isEmpty()) {
                        this.mMessageHandler.sendMessage(ChatMessageBuilder.buildReplyMessage(this.mTextInput.getText().toString(), this.replyPreviewBean));
                    } else {
                        this.mMessageHandler.sendMessage(ChatMessageBuilder.buildAtReplyMessage(this.mTextInput.getText().toString(), new ArrayList(this.mTextInput.getMentionIdList()), this.replyPreviewBean));
                    }
                    exitReply();
                } else if (!TUIChatUtils.isGroupChat(iChatLayout.getChatInfo().getType()) || this.mTextInput.getMentionIdList().isEmpty()) {
                    this.mMessageHandler.sendMessage(ChatMessageBuilder.buildTextMessage(this.mTextInput.getText().toString()));
                } else {
                    ArrayList arrayList = new ArrayList(this.mTextInput.getMentionIdList());
                    if (arrayList.isEmpty()) {
                        this.mMessageHandler.sendMessage(ChatMessageBuilder.buildTextMessage(this.mTextInput.getText().toString()));
                    } else {
                        this.mMessageHandler.sendMessage(ChatMessageBuilder.buildTextAtMessage(arrayList, this.mTextInput.getText().toString()));
                    }
                }
            }
            this.mIsSending = true;
            this.mTextInput.setText("");
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.mTextInput.removeTextChangedListener(this);
        this.atUserInfoMap.clear();
        ChatInputHandler chatInputHandler = this.mChatInputHandler;
        if (chatInputHandler != null) {
            chatInputHandler.onUserTyping(false, V2TIMManager.getInstance().getServerTime());
        }
    }

    public void onEmptyClick() {
        hideSoftInput();
        this.mCurrentState = 0;
        hideInputMoreLayout();
        this.mEmojiInputButton.setImageResource(R.drawable.action_face_selector);
        this.mAudioInputSwitchButton.setImageResource(R.drawable.action_audio_selector);
        this.mSendAudioButton.setVisibility(8);
        this.mTextInput.setVisibility(0);
    }

    public void onTextChanged(CharSequence charSequence, int i11, int i12, int i13) {
    }

    public void replaceMoreInput(BaseInputFragment baseInputFragment) {
        this.mMoreInputEvent = baseInputFragment;
    }

    public void setChatInfo(ChatInfo chatInfo) {
        DraftInfo draft;
        this.mChatInfo = chatInfo;
        if (chatInfo != null && (draft = chatInfo.getDraft()) != null && !TextUtils.isEmpty(draft.getDraftText()) && this.mTextInput != null) {
            Gson gson = new Gson();
            String draftText = draft.getDraftText();
            try {
                HashMap hashMap = (HashMap) gson.fromJson(draft.getDraftText(), HashMap.class);
                if (hashMap != null) {
                    String str = (String) hashMap.get("content");
                    try {
                        ReplyPreviewBean replyPreviewBean2 = (ReplyPreviewBean) gson.fromJson((String) hashMap.get("reply"), ReplyPreviewBean.class);
                        if (replyPreviewBean2 != null) {
                            showReplyPreview(replyPreviewBean2);
                        }
                        draftText = str;
                    } catch (JsonSyntaxException unused) {
                        draftText = str;
                        TUIChatLog.e(TAG, " getCustomJsonMap error ");
                        this.mTextInput.setText(draftText);
                        TIMMentionEditText tIMMentionEditText = this.mTextInput;
                        tIMMentionEditText.setSelection(tIMMentionEditText.getText().length());
                    }
                }
            } catch (JsonSyntaxException unused2) {
                TUIChatLog.e(TAG, " getCustomJsonMap error ");
                this.mTextInput.setText(draftText);
                TIMMentionEditText tIMMentionEditText2 = this.mTextInput;
                tIMMentionEditText2.setSelection(tIMMentionEditText2.getText().length());
            }
            this.mTextInput.setText(draftText);
            TIMMentionEditText tIMMentionEditText22 = this.mTextInput;
            tIMMentionEditText22.setSelection(tIMMentionEditText22.getText().length());
        }
    }

    public void setChatInputHandler(ChatInputHandler chatInputHandler) {
        this.mChatInputHandler = chatInputHandler;
    }

    public void setChatLayout(IChatLayout iChatLayout) {
        this.mChatLayout = iChatLayout;
    }

    public void setDraft() {
        if (this.mChatInfo == null) {
            TUIChatLog.e(TAG, "set drafts error :  chatInfo is null");
            return;
        }
        TIMMentionEditText tIMMentionEditText = this.mTextInput;
        if (tIMMentionEditText == null) {
            TUIChatLog.e(TAG, "set drafts error :  textInput is null");
            return;
        }
        String obj = tIMMentionEditText.getText().toString();
        if ((this.isQuoteModel || this.isReplyModel) && this.replyPreviewBean != null) {
            Gson gson = new Gson();
            HashMap hashMap = new HashMap();
            hashMap.put("content", obj);
            hashMap.put("reply", gson.toJson((Object) this.replyPreviewBean));
            obj = gson.toJson((Object) hashMap);
        }
        ChatPresenter chatPresenter = this.presenter;
        if (chatPresenter != null) {
            chatPresenter.setDraft(obj);
        }
    }

    public void setMessageHandler(MessageHandler messageHandler) {
        this.mMessageHandler = messageHandler;
    }

    public void setOnInputViewListener(OnInputViewListener onInputViewListener) {
        this.mOnInputViewListener = onInputViewListener;
    }

    public void setPresenter(ChatPresenter chatPresenter) {
        this.presenter = chatPresenter;
    }

    public void showEmojiInputButton(int i11) {
        if (!this.mEmojiInputDisable) {
            this.mEmojiInputButton.setVisibility(i11);
        }
    }

    public void showMoreInputButton(int i11) {
        if (!this.mMoreInputDisable) {
            this.mMoreInputButton.setVisibility(i11);
        }
    }

    public void showReplyPreview(ReplyPreviewBean replyPreviewBean2) {
        exitReply();
        this.replyPreviewBean = replyPreviewBean2;
        String messageAbstract = replyPreviewBean2.getMessageAbstract();
        String msgTypeStr = ChatMessageParser.getMsgTypeStr(replyPreviewBean2.getMessageType());
        String emojiJudge = FaceManager.emojiJudge(replyPreviewBean2.getMessageSender() + " : " + msgTypeStr + " " + messageAbstract);
        if (replyPreviewBean2.isReplyMessage()) {
            this.isReplyModel = true;
            this.replyTv.setText(emojiJudge);
            this.replyPreviewBar.setVisibility(0);
        } else {
            this.isQuoteModel = true;
            this.quoteTv.setText(emojiJudge);
            this.quotePreviewBar.setVisibility(0);
        }
        if (replyPreviewBean2.getOriginalMessageBean() instanceof FileMessageBean) {
            this.replyTv.setEllipsize(TextUtils.TruncateAt.MIDDLE);
            this.quoteTv.setEllipsize(TextUtils.TruncateAt.MIDDLE);
        } else {
            this.replyTv.setEllipsize(TextUtils.TruncateAt.END);
            this.quoteTv.setEllipsize(TextUtils.TruncateAt.END);
        }
        MessageHandler messageHandler = this.mMessageHandler;
        if (messageHandler != null) {
            messageHandler.scrollToEnd();
        }
        showSoftInput();
    }

    public void showSendTextButton(int i11) {
        if (this.mMoreInputDisable) {
            this.mSendTextButton.setVisibility(0);
        } else {
            this.mSendTextButton.setVisibility(i11);
        }
    }

    public void showSoftInput() {
        TUIChatLog.i(TAG, "showSoftInput");
        this.mCurrentState = 0;
        InputMethodManager inputMethodManager = (InputMethodManager) getContext().getSystemService("input_method");
        if (!isSoftInputShown()) {
            inputMethodManager.toggleSoftInput(0, 0);
        }
        ThreadUtils.postOnUiThreadDelayed(new Runnable() {
            public void run() {
                Window window;
                InputView.this.hideInputMoreLayout();
                InputView.this.mAudioInputSwitchButton.setImageResource(R.drawable.action_audio_selector);
                InputView.this.mEmojiInputButton.setImageResource(R.drawable.chat_input_face);
                InputView.this.mSendAudioButton.setVisibility(8);
                InputView.this.mTextInput.setVisibility(0);
                InputView.this.mTextInput.requestFocus();
                Context context = InputView.this.getContext();
                if ((context instanceof Activity) && (window = ((Activity) context).getWindow()) != null) {
                    window.setSoftInputMode(16);
                }
            }
        }, 200);
        if (this.mChatInputHandler != null) {
            postDelayed(new Runnable() {
                public void run() {
                    InputView.this.mChatInputHandler.onInputAreaClick();
                }
            }, 200);
        }
    }

    public void startCapture() {
        TUIChatLog.i(TAG, "startCapture");
        PermissionHelper.requestPermission(2, new PermissionHelper.PermissionCallback() {
            public void onDenied() {
                TUIChatLog.i(InputView.TAG, "startCapture checkPermission failed");
            }

            public void onGranted() {
                Intent intent = new Intent(InputView.this.getContext(), CameraActivity.class);
                intent.putExtra(TUIChatConstants.CAMERA_TYPE, 257);
                CameraActivity.mCallBack = new IUIKitCallback() {
                    public void onError(String str, int i11, String str2) {
                    }

                    public void onSuccess(Object obj) {
                        TUIMessageBean buildImageMessage = ChatMessageBuilder.buildImageMessage(Uri.fromFile(new File(obj.toString())));
                        if (InputView.this.mMessageHandler != null) {
                            InputView.this.mMessageHandler.sendMessage(buildImageMessage);
                            InputView.this.hideSoftInput();
                        }
                    }
                };
                InputView.this.setOpenPhotoCallback();
                InputView.this.mInputMoreFragment.startActivityForResult(intent, 1012);
            }
        });
    }

    public void startSendFile() {
        TUIChatLog.i(TAG, "startSendFile");
        Intent intent = new Intent("android.intent.action.GET_CONTENT");
        intent.setType("*/*");
        intent.addCategory("android.intent.category.OPENABLE");
        this.mInputMoreFragment.setCallback(new IUIKitCallback() {
            public void onError(String str, int i11, String str2) {
                ToastUtil.toastLongMessage(str2);
            }

            public void onSuccess(Object obj) {
                TUIMessageBean buildFileMessage = ChatMessageBuilder.buildFileMessage((Uri) obj);
                if (buildFileMessage == null) {
                    ToastUtil.toastShortMessage(InputView.this.getResources().getString(R.string.send_failed_file_not_exists));
                } else if (InputView.this.mMessageHandler != null) {
                    InputView.this.mMessageHandler.sendMessage(buildFileMessage);
                    InputView.this.hideSoftInput();
                }
            }
        });
        this.mInputMoreFragment.startActivityForResult(intent, 1011);
    }

    public void startSendPhoto() {
        TUIChatLog.i(TAG, "startSendPhoto");
        Intent intent = new Intent("android.intent.action.GET_CONTENT");
        intent.addCategory("android.intent.category.OPENABLE");
        intent.setType("*/*");
        intent.putExtra("android.intent.extra.MIME_TYPES", new String[]{SelectMimeType.SYSTEM_IMAGE, SelectMimeType.SYSTEM_VIDEO});
        setOpenPhotoCallback();
        this.mInputMoreFragment.startActivityForResult(intent, 1012);
    }

    public void startVideoRecord() {
        TUIChatLog.i(TAG, "startVideoRecord");
        PermissionHelper.requestPermission(2, new PermissionHelper.PermissionCallback() {
            public void onDenied() {
                TUIChatLog.i(InputView.TAG, "startVideoRecord checkPermission failed");
            }

            public void onGranted() {
                PermissionHelper.requestPermission(1, new PermissionHelper.PermissionCallback() {
                    public void onDenied() {
                        TUIChatLog.i(InputView.TAG, "startVideoRecord checkPermission failed");
                    }

                    public void onGranted() {
                        Intent intent = new Intent(InputView.this.getContext(), CameraActivity.class);
                        intent.putExtra(TUIChatConstants.CAMERA_TYPE, 258);
                        CameraActivity.mCallBack = new IUIKitCallback() {
                            public void onError(String str, int i11, String str2) {
                            }

                            public void onSuccess(Object obj) {
                                Intent intent = (Intent) obj;
                                TUIMessageBean buildVideoMessage = ChatMessageBuilder.buildVideoMessage(intent.getStringExtra(TUIChatConstants.CAMERA_IMAGE_PATH), intent.getStringExtra(TUIChatConstants.CAMERA_VIDEO_PATH), intent.getIntExtra(TUIChatConstants.IMAGE_WIDTH, 0), intent.getIntExtra(TUIChatConstants.IMAGE_HEIGHT, 0), intent.getLongExtra(TUIChatConstants.VIDEO_TIME, 0));
                                if (InputView.this.mMessageHandler != null) {
                                    InputView.this.mMessageHandler.sendMessage(buildVideoMessage);
                                    InputView.this.hideSoftInput();
                                }
                            }
                        };
                        InputView.this.setOpenPhotoCallback();
                        InputView.this.mInputMoreFragment.startActivityForResult(intent, 1012);
                    }
                });
            }
        });
    }

    public void updateInputText(ArrayList<String> arrayList, ArrayList<String> arrayList2) {
        if (arrayList2 != null && !arrayList2.isEmpty()) {
            updateAtUserInfoMap(arrayList, arrayList2);
            if (this.mTextInput != null) {
                this.mTextInput.setMentionMap(getDisplayAtNameMap(arrayList, arrayList2));
                int selectionEnd = this.mTextInput.getSelectionEnd();
                if (selectionEnd != -1) {
                    FaceManager.handlerEmojiText(this.mTextInput, this.mTextInput.getText().insert(selectionEnd, this.displayInputString).toString(), true);
                    this.mTextInput.setSelection(selectionEnd + this.displayInputString.length());
                }
                ThreadUtils.postOnUiThreadDelayed(new Runnable() {
                    public void run() {
                        InputView.this.showSoftInput();
                    }
                }, 200);
            }
        }
    }

    public void replaceMoreInput(View.OnClickListener onClickListener) {
        this.mMoreInputEvent = onClickListener;
    }

    public InputView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        initViews();
    }

    public InputView(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        initViews();
    }
}
