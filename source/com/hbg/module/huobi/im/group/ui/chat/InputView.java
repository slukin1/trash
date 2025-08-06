package com.hbg.module.huobi.im.group.ui.chat;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.media.MediaMetadataRetriever;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.MediaStore;
import android.text.Editable;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.webkit.MimeTypeMap;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentManager;
import com.google.gson.Gson;
import com.hbg.lib.core.BaseModuleConfig;
import com.hbg.module.huobi.im.R$color;
import com.hbg.module.huobi.im.R$dimen;
import com.hbg.module.huobi.im.R$drawable;
import com.hbg.module.huobi.im.R$id;
import com.hbg.module.huobi.im.R$layout;
import com.hbg.module.huobi.im.R$string;
import com.hbg.module.huobi.im.utils.ClickableForegroundColorSpan;
import com.luck.picture.lib.config.SelectMimeType;
import com.luck.picture.lib.permissions.PermissionConfig;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import com.tencent.qcloud.tuicore.ServiceInitializer;
import com.tencent.qcloud.tuicore.TUIConstants;
import com.tencent.qcloud.tuicore.TUICore;
import com.tencent.qcloud.tuicore.util.BackgroundTasks;
import com.tencent.qcloud.tuicore.util.ToastUtil;
import com.tencent.qcloud.tuikit.timcommon.bean.TUIMessageBean;
import com.tencent.qcloud.tuikit.timcommon.component.face.CustomFace;
import com.tencent.qcloud.tuikit.timcommon.component.face.Emoji;
import com.tencent.qcloud.tuikit.timcommon.component.face.FaceManager;
import com.tencent.qcloud.tuikit.timcommon.component.interfaces.IUIKitCallback;
import com.tencent.qcloud.tuikit.timcommon.util.FileUtil;
import com.tencent.qcloud.tuikit.tuichat.TUIChatConstants;
import com.tencent.qcloud.tuikit.tuichat.bean.ChatInfo;
import com.tencent.qcloud.tuikit.tuichat.bean.InputMoreActionUnit;
import com.tencent.qcloud.tuikit.tuichat.bean.ReplyPreviewBean;
import com.tencent.qcloud.tuikit.tuichat.bean.message.FileMessageBean;
import com.tencent.qcloud.tuikit.tuichat.classicui.component.camera.CameraActivity;
import com.tencent.qcloud.tuikit.tuichat.classicui.widget.input.BaseInputFragment;
import com.tencent.qcloud.tuikit.tuichat.classicui.widget.input.TIMMentionEditText;
import com.tencent.qcloud.tuikit.tuichat.classicui.widget.input.face.FaceFragment;
import com.tencent.qcloud.tuikit.tuichat.classicui.widget.input.inputmore.InputMoreFragment;
import com.tencent.qcloud.tuikit.tuichat.component.AudioPlayer;
import com.tencent.qcloud.tuikit.tuichat.presenter.ChatPresenter;
import com.tencent.qcloud.tuikit.tuichat.ui.interfaces.IInputLayout;
import com.tencent.qcloud.tuikit.tuichat.util.ChatMessageParser;
import com.tencent.qcloud.tuikit.tuichat.util.PermissionUtils;
import com.tencent.qcloud.tuikit.tuichat.util.TUIChatLog;
import com.tencent.qcloud.tuikit.tuichat.util.TUIChatUtils;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import rd.q;

public class InputView extends LinearLayout implements IInputLayout, View.OnClickListener, TextWatcher {
    public static final int AUDIO_RECORD = 2;
    public static final int CALL_MEMBER_LIMIT = 8;
    public static final int CAPTURE = 1;
    public static final int SEND_FILE = 5;
    public static final int SEND_PHOTO = 4;
    private static final int STATE_ACTION_INPUT = 3;
    private static final int STATE_FACE_INPUT = 2;
    private static final int STATE_NONE_INPUT = -1;
    private static final int STATE_SOFT_INPUT = 0;
    private static final int STATE_VOICE_INPUT = 1;
    /* access modifiers changed from: private */
    public static final String TAG = InputView.class.getSimpleName();
    public static final int VIDEO_RECORD = 3;
    private Map<String, String> atUserInfoMap = new HashMap();
    /* access modifiers changed from: private */
    public ChatPresenter chatManager;
    private String displayInputString = "";
    /* access modifiers changed from: private */
    public boolean isReplyModel = false;
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
    private InputMoreFragment mInputMoreFragment;
    public View mInputMoreLayout;
    public View mInputMoreView;
    private int mLastMsgLineCount;
    /* access modifiers changed from: private */
    public MessageHandler mMessageHandler;
    public ImageView mMoreInputButton;
    public boolean mMoreInputDisable;
    public Object mMoreInputEvent;
    private AlertDialog mPermissionDialog;
    private boolean mPrimeSendAble;
    public Button mSendAudioButton;
    private boolean mSendEnable;
    private boolean mSendFileDisable;
    private boolean mSendPhotoDisable;
    public Button mSendTextButton;
    /* access modifiers changed from: private */
    public OnStartActivityListener mStartActivityListener;
    /* access modifiers changed from: private */
    public float mStartRecordY;
    public TIMMentionEditText mTextInput;
    private boolean mVideoRecordDisable;
    private OnPlusClickListener plusClickListener;
    private HashMap<String, Object> pointMap = new HashMap<>();
    private String primePath;
    private ImageView replyCloseBtn;
    private View replyLayout;
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
    }

    public interface MessageHandler {
        void scrollToEnd();

        void sendMessage(TUIMessageBean tUIMessageBean);
    }

    public interface OnPlusClickListener {
        void onPlusClick();
    }

    public interface OnStartActivityListener {
        void onStartGroupMemberSelectActivity();
    }

    public InputView(Context context) {
        super(context);
        initViews();
    }

    private void addActionsFromListeners() {
        if (this.mChatInfo != null) {
            HashMap hashMap = new HashMap();
            hashMap.put("chatId", this.mChatInfo.getId());
            hashMap.put(TUIConstants.TUIChat.CHAT_NAME, this.mChatInfo.getChatName());
            hashMap.put(TUIConstants.TUIChat.CHAT_TYPE, Integer.valueOf(this.mChatInfo.getType()));
            hashMap.put("context", getContext());
            Map<String, Object> extensionInfo = TUICore.getExtensionInfo(TUIConstants.TUIChat.EXTENSION_INPUT_MORE_AUDIO_CALL, hashMap);
            if (extensionInfo != null && extensionInfo.size() > 0) {
                int intValue = ((Integer) extensionInfo.get(TUIConstants.TUIChat.INPUT_MORE_ACTION_ID)).intValue();
                InputMoreActionUnit inputMoreActionUnit = new InputMoreActionUnit();
                inputMoreActionUnit.setActionId(intValue);
                inputMoreActionUnit.setUnitView((View) extensionInfo.get(TUIConstants.TUIChat.INPUT_MORE_VIEW));
                inputMoreActionUnit.setPriority(2);
                inputMoreActionUnit.setOnClickListener(new InputMoreActionUnit.OnActionClickListener(inputMoreActionUnit, inputMoreActionUnit) {
                    public final /* synthetic */ InputMoreActionUnit val$audioUnit;

                    {
                        this.val$audioUnit = r3;
                        Objects.requireNonNull(r2);
                    }

                    public void onClick() {
                        InputView.this.onCustomActionClick(this.val$audioUnit.getActionId());
                    }
                });
                this.mInputMoreActionList.add(inputMoreActionUnit);
            }
            Map<String, Object> extensionInfo2 = TUICore.getExtensionInfo(TUIConstants.TUIChat.EXTENSION_INPUT_MORE_VIDEO_CALL, hashMap);
            if (extensionInfo2 != null && extensionInfo.size() > 0) {
                int intValue2 = ((Integer) extensionInfo2.get(TUIConstants.TUIChat.INPUT_MORE_ACTION_ID)).intValue();
                InputMoreActionUnit inputMoreActionUnit2 = new InputMoreActionUnit();
                inputMoreActionUnit2.setActionId(intValue2);
                inputMoreActionUnit2.setUnitView((View) extensionInfo2.get(TUIConstants.TUIChat.INPUT_MORE_VIEW));
                inputMoreActionUnit2.setPriority(1);
                inputMoreActionUnit2.setOnClickListener(new InputMoreActionUnit.OnActionClickListener(inputMoreActionUnit2, inputMoreActionUnit2) {
                    public final /* synthetic */ InputMoreActionUnit val$videoUnit;

                    {
                        this.val$videoUnit = r3;
                        Objects.requireNonNull(r2);
                    }

                    public void onClick() {
                        InputView.this.onCustomActionClick(this.val$videoUnit.getActionId());
                    }
                });
                this.mInputMoreActionList.add(inputMoreActionUnit2);
            }
            Map<String, Object> extensionInfo3 = TUICore.getExtensionInfo(TUIConstants.TUIChat.EXTENSION_INPUT_MORE_CUSTOM_MESSAGE, hashMap);
            if (extensionInfo3 != null && extensionInfo.size() > 0) {
                InputMoreActionUnit inputMoreActionUnit3 = new InputMoreActionUnit();
                inputMoreActionUnit3.setActionId(((Integer) extensionInfo3.get(TUIConstants.TUIChat.INPUT_MORE_ACTION_ID)).intValue());
                inputMoreActionUnit3.setIconResId(((Integer) extensionInfo3.get("icon")).intValue());
                inputMoreActionUnit3.setTitleId(((Integer) extensionInfo3.get("title")).intValue());
                inputMoreActionUnit3.setPriority(10);
                inputMoreActionUnit3.setOnClickListener(new InputMoreActionUnit.OnActionClickListener(inputMoreActionUnit3, inputMoreActionUnit3) {
                    public final /* synthetic */ InputMoreActionUnit val$unit;

                    {
                        this.val$unit = r3;
                        Objects.requireNonNull(r2);
                    }

                    public void onClick() {
                        InputView.this.onCustomActionClick(this.val$unit.getActionId());
                    }
                });
                this.mInputMoreActionList.add(inputMoreActionUnit3);
            }
        }
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
                } catch (IOException unused) {
                }
                return null;
            }
            TUIMessageBean buildVideoMessage = ChatMessageBuilder.buildVideoMessage(FileUtil.saveBitmap("JCamera", frameAtTime), str, frameAtTime.getWidth(), frameAtTime.getHeight(), Long.valueOf(extractMetadata).longValue());
            try {
                mediaMetadataRetriever.release();
            } catch (IOException unused2) {
            }
            return buildVideoMessage;
        } catch (Exception e11) {
            String str2 = TAG;
            TUIChatLog.e(str2, "MediaMetadataRetriever exception " + e11);
            try {
                mediaMetadataRetriever.release();
            } catch (IOException unused3) {
            }
            return null;
        } catch (Throwable th2) {
            try {
                mediaMetadataRetriever.release();
            } catch (IOException unused4) {
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
        throw new UnsupportedOperationException("Method not decompiled: com.hbg.module.huobi.im.group.ui.chat.InputView.getDisplayAtNameMap(java.util.List, java.util.List):java.util.Map");
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

    private void hideInputMoreLayout() {
        this.mInputMoreView.setVisibility(8);
    }

    private void initViews() {
        AppCompatActivity appCompatActivity = (AppCompatActivity) getContext();
        this.mActivity = appCompatActivity;
        LinearLayout.inflate(appCompatActivity, R$layout.chat_input_layout, this);
        this.mInputMoreView = findViewById(R$id.more_groups);
        this.mSendAudioButton = (Button) findViewById(R$id.chat_voice_input);
        this.mAudioInputSwitchButton = (ImageView) findViewById(R$id.voice_input_switch);
        this.mEmojiInputButton = (ImageView) findViewById(R$id.face_btn);
        this.mMoreInputButton = (ImageView) findViewById(R$id.more_btn);
        this.mSendTextButton = (Button) findViewById(R$id.send_btn);
        this.mTextInput = (TIMMentionEditText) findViewById(R$id.chat_message_input);
        this.replyLayout = findViewById(R$id.reply_preview_bar);
        this.replyTv = (TextView) findViewById(R$id.reply_text);
        this.replyCloseBtn = (ImageView) findViewById(R$id.reply_close_btn);
        int dimensionPixelSize = getResources().getDimensionPixelSize(R$dimen.chat_input_icon_size);
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
    public void onCustomActionClick(int i11) {
        if (i11 == 1 || i11 == 2) {
            String str = i11 == 1 ? "audio" : "video";
            if (TUIChatUtils.isGroupChat(getChatInfo().getType())) {
                Bundle bundle = new Bundle();
                bundle.putString("groupId", getChatInfo().getId());
                bundle.putString("type", str);
                bundle.putString("group_id", getChatInfo().getId());
                bundle.putBoolean("isSelectForCall", true);
                bundle.putInt("limit", 8);
                TUICore.startActivity(getContext(), TUIConstants.TUIContact.StartActivity.GroupMemberSelect.CLASSIC_ACTIVITY_NAME, bundle, 11);
                return;
            }
            return;
        }
        HashMap hashMap = new HashMap();
        hashMap.put(TUIConstants.TUIChat.INPUT_MORE_ACTION_ID, Integer.valueOf(i11));
        hashMap.put("chatId", this.mChatInfo.getId());
        hashMap.put(TUIConstants.TUIChat.CHAT_NAME, this.mChatInfo.getChatName());
        hashMap.put(TUIConstants.TUIChat.CHAT_TYPE, Integer.valueOf(this.mChatInfo.getType()));
        TUICore.notifyEvent(TUIConstants.TUIChat.EVENT_KEY_INPUT_MORE, TUIConstants.TUIChat.EVENT_SUB_KEY_ON_CLICK, hashMap);
    }

    /* access modifiers changed from: private */
    public void recordComplete(boolean z11) {
        int duration = AudioPlayer.getInstance().getDuration();
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
            messageHandler.sendMessage(ChatMessageBuilder.buildAudioMessage(AudioPlayer.getInstance().getPath(), duration));
        }
    }

    private void setOpenPhotoCallback() {
        this.mInputMoreFragment.setCallback(new IUIKitCallback() {
            public void onError(String str, int i11, String str2) {
                String access$200 = InputView.TAG;
                TUIChatLog.i(access$200, "errCode: " + i11);
                ToastUtil.toastLongMessage(str2);
            }

            public void onSuccess(Object obj) {
                String access$200 = InputView.TAG;
                TUIChatLog.i(access$200, "onSuccess: " + obj);
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
                        TUIMessageBean access$900 = InputView.this.buildVideoMessage(FileUtil.getPathFromUri(uri));
                        if (access$900 == null) {
                            String access$2002 = InputView.TAG;
                            TUIChatLog.e(access$2002, "start send video error data: " + obj);
                        } else if (InputView.this.mMessageHandler != null) {
                            InputView.this.mMessageHandler.sendMessage(access$900);
                            InputView.this.hideSoftInput();
                        }
                    } else if (mimeTypeFromExtension.contains("image")) {
                        TUIMessageBean buildImageMessage = ChatMessageBuilder.buildImageMessage(uri);
                        if (InputView.this.mMessageHandler != null) {
                            InputView.this.mMessageHandler.sendMessage(buildImageMessage);
                            InputView.this.hideSoftInput();
                        }
                    } else {
                        String access$2003 = InputView.TAG;
                        TUIChatLog.e(access$2003, "Send photo or video failed , invalid mimeType : " + mimeTypeFromExtension);
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
        this.mFragmentManager.q().t(R$id.more_groups, (BaseInputFragment) this.mMoreInputEvent).k();
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
        this.mFaceFragment.setListener(new FaceFragment.OnEmojiClickListener() {
            public void onCustomFaceClick(int i11, CustomFace customFace) {
                InputView.this.mMessageHandler.sendMessage(ChatMessageBuilder.buildFaceMessage(i11, customFace.getFaceUrl()));
            }

            public void onEmojiClick(Emoji emoji) {
                int selectionStart = InputView.this.mTextInput.getSelectionStart();
                Editable text = InputView.this.mTextInput.getText();
                text.insert(selectionStart, emoji.getFaceKey());
                FaceManager.handlerEmojiText(InputView.this.mTextInput, text.toString(), true);
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
        this.mFragmentManager.q().t(R$id.more_groups, this.mFaceFragment).k();
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
        this.mFragmentManager.q().t(R$id.more_groups, this.mInputMoreFragment).k();
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

    public void ableSendPrimeAction(boolean z11, String str) {
        this.mPrimeSendAble = z11;
        this.primePath = str;
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
            TIMMentionEditText tIMMentionEditText = this.mTextInput;
            if (tIMMentionEditText != null) {
                tIMMentionEditText.setText("");
                HashMap hashMap = new HashMap();
                hashMap.put(TIMMentionEditText.TIM_MENTION_TAG + this.displayInputString, str2);
                this.mTextInput.setMentionMap(hashMap);
                int selectionEnd = this.mTextInput.getSelectionEnd();
                if (selectionEnd != -1) {
                    String str3 = TIMMentionEditText.TIM_MENTION_TAG + this.displayInputString;
                    ClickableForegroundColorSpan clickableForegroundColorSpan = new ClickableForegroundColorSpan(ContextCompat.getColor(this.mTextInput.getContext(), R$color.color_12B298));
                    SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(str3);
                    spannableStringBuilder.setSpan(clickableForegroundColorSpan, 0, str3.length() - 1, 33);
                    FaceManager.handlerEmojiText(this.mTextInput, this.mTextInput.getText().insert(selectionEnd, spannableStringBuilder).toString(), true);
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
            return;
        }
        this.mSendEnable = true;
        showSendTextButton(0);
        showMoreInputButton(8);
        if (this.mTextInput.getLineCount() != this.mLastMsgLineCount) {
            this.mLastMsgLineCount = this.mTextInput.getLineCount();
            ChatInputHandler chatInputHandler = this.mChatInputHandler;
            if (chatInputHandler != null) {
                chatInputHandler.onInputAreaClick();
            }
        }
        if (!TextUtils.equals(this.mInputContent, this.mTextInput.getText().toString())) {
            TIMMentionEditText tIMMentionEditText = this.mTextInput;
            FaceManager.handlerEmojiText(tIMMentionEditText, tIMMentionEditText.getText().toString(), true);
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
        if (this.mPrimeSendAble) {
            AnonymousClass19 r02 = new InputMoreActionUnit() {
                public void onAction(String str, int i11) {
                    InputView.this.jump2PrimePage();
                }
            };
            r02.setIconResId(R$drawable.icon_prime_card);
            r02.setTitleId(R$string.n_im_primebox_exchange);
            this.mInputMoreActionList.add(r02);
        }
        if (!this.mSendPhotoDisable) {
            AnonymousClass20 r03 = new InputMoreActionUnit() {
                public void onAction(String str, int i11) {
                    InputView.this.startSendPhoto();
                }
            };
            r03.setIconResId(R$drawable.ic_more_picture);
            r03.setTitleId(R$string.n_otc_chat_phtograph);
            this.mInputMoreActionList.add(r03);
        }
        addActionsFromListeners();
        this.mInputMoreActionList.addAll(this.mInputMoreCustomActionList);
        Collections.sort(this.mInputMoreActionList, new Comparator<InputMoreActionUnit>() {
            public int compare(InputMoreActionUnit inputMoreActionUnit, InputMoreActionUnit inputMoreActionUnit2) {
                return inputMoreActionUnit.getPriority() - inputMoreActionUnit2.getPriority();
            }
        });
    }

    public void beforeTextChanged(CharSequence charSequence, int i11, int i12, int i13) {
        this.mInputContent = charSequence.toString();
    }

    public boolean checkPermission(int i11) {
        if (Build.VERSION.SDK_INT >= 33) {
            if (i11 == 1) {
                if (!PermissionUtils.checkPermission(this.mActivity, PermissionConfig.READ_MEDIA_IMAGES)) {
                    return false;
                }
            } else if (i11 == 2) {
                if (!PermissionUtils.checkPermission(this.mActivity, PermissionConfig.READ_MEDIA_AUDIO)) {
                    return false;
                }
            } else if (i11 == 3 && !PermissionUtils.checkPermission(this.mActivity, PermissionConfig.READ_MEDIA_VIDEO)) {
                return false;
            }
        } else if (!PermissionUtils.checkPermission(this.mActivity, PermissionConfig.WRITE_EXTERNAL_STORAGE) || !PermissionUtils.checkPermission(this.mActivity, PermissionConfig.READ_EXTERNAL_STORAGE)) {
            return false;
        }
        if (i11 == 5 || i11 == 4) {
            return true;
        }
        if (i11 == 1) {
            return PermissionUtils.checkPermission(this.mActivity, "android.permission.CAMERA");
        }
        if (i11 == 2) {
            return PermissionUtils.checkPermission(this.mActivity, "android.permission.RECORD_AUDIO");
        }
        if (i11 != 3) {
            return true;
        }
        if (!PermissionUtils.checkPermission(this.mActivity, "android.permission.CAMERA") || !PermissionUtils.checkPermission(this.mActivity, "android.permission.RECORD_AUDIO")) {
            return false;
        }
        return true;
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

    public void disableVideoRecordAction(boolean z11) {
        this.mVideoRecordDisable = z11;
    }

    public void exitReply() {
        this.isReplyModel = false;
        this.replyPreviewBean = null;
        this.replyLayout.setVisibility(8);
    }

    public ChatInfo getChatInfo() {
        return this.mChatInfo;
    }

    public EditText getInputText() {
        return this.mTextInput;
    }

    public void hideSoftInput() {
        TUIChatLog.i(TAG, "hideSoftInput");
        ((InputMethodManager) getContext().getSystemService("input_method")).hideSoftInputFromWindow(this.mTextInput.getWindowToken(), 0);
        this.mTextInput.clearFocus();
        this.mInputMoreView.setVisibility(8);
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
                InputView.this.chatManager.clearMessageAndReLoad();
                InputView.this.showSoftInput();
                return false;
            }
        });
        this.mTextInput.setOnKeyListener(new View.OnKeyListener() {
            public boolean onKey(View view, int i11, KeyEvent keyEvent) {
                if (i11 != 67 || keyEvent.getAction() != 0 || !InputView.this.isReplyModel || !TextUtils.isEmpty(InputView.this.mTextInput.getText().toString())) {
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
        this.mSendAudioButton.setOnTouchListener(new View.OnTouchListener() {
            /* JADX WARNING: Code restructure failed: missing block: B:11:0x0042, code lost:
                if (r5 != 3) goto L_0x011d;
             */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public boolean onTouch(android.view.View r5, android.view.MotionEvent r6) {
                /*
                    r4 = this;
                    java.lang.String r5 = com.hbg.module.huobi.im.group.ui.chat.InputView.TAG
                    java.lang.StringBuilder r0 = new java.lang.StringBuilder
                    r0.<init>()
                    java.lang.String r1 = "mSendAudioButton onTouch action:"
                    r0.append(r1)
                    int r1 = r6.getAction()
                    r0.append(r1)
                    java.lang.String r0 = r0.toString()
                    com.tencent.qcloud.tuikit.tuichat.util.TUIChatLog.i(r5, r0)
                    int r5 = r6.getAction()
                    r0 = 2
                    r1 = 0
                    if (r5 != 0) goto L_0x0036
                    com.hbg.module.huobi.im.group.ui.chat.InputView r5 = com.hbg.module.huobi.im.group.ui.chat.InputView.this
                    boolean r5 = r5.checkPermission(r0)
                    if (r5 != 0) goto L_0x0036
                    java.lang.String r5 = com.hbg.module.huobi.im.group.ui.chat.InputView.TAG
                    java.lang.String r6 = "audio record checkPermission failed"
                    com.tencent.qcloud.tuikit.tuichat.util.TUIChatLog.i(r5, r6)
                    return r1
                L_0x0036:
                    int r5 = r6.getAction()
                    r2 = 1
                    if (r5 == 0) goto L_0x00e1
                    if (r5 == r2) goto L_0x009f
                    r3 = 3
                    if (r5 == r0) goto L_0x0046
                    if (r5 == r3) goto L_0x009f
                    goto L_0x011d
                L_0x0046:
                    float r5 = r6.getY()
                    com.hbg.module.huobi.im.group.ui.chat.InputView r6 = com.hbg.module.huobi.im.group.ui.chat.InputView.this
                    float r6 = r6.mStartRecordY
                    float r5 = r5 - r6
                    r6 = -1018691584(0xffffffffc3480000, float:-200.0)
                    int r5 = (r5 > r6 ? 1 : (r5 == r6 ? 0 : -1))
                    if (r5 >= 0) goto L_0x006e
                    com.hbg.module.huobi.im.group.ui.chat.InputView r5 = com.hbg.module.huobi.im.group.ui.chat.InputView.this
                    boolean unused = r5.mAudioCancel = r2
                    com.hbg.module.huobi.im.group.ui.chat.InputView r5 = com.hbg.module.huobi.im.group.ui.chat.InputView.this
                    com.hbg.module.huobi.im.group.ui.chat.InputView$ChatInputHandler r5 = r5.mChatInputHandler
                    if (r5 == 0) goto L_0x008c
                    com.hbg.module.huobi.im.group.ui.chat.InputView r5 = com.hbg.module.huobi.im.group.ui.chat.InputView.this
                    com.hbg.module.huobi.im.group.ui.chat.InputView$ChatInputHandler r5 = r5.mChatInputHandler
                    r5.onRecordStatusChanged(r3)
                    goto L_0x008c
                L_0x006e:
                    com.hbg.module.huobi.im.group.ui.chat.InputView r5 = com.hbg.module.huobi.im.group.ui.chat.InputView.this
                    boolean r5 = r5.mAudioCancel
                    if (r5 == 0) goto L_0x0087
                    com.hbg.module.huobi.im.group.ui.chat.InputView r5 = com.hbg.module.huobi.im.group.ui.chat.InputView.this
                    com.hbg.module.huobi.im.group.ui.chat.InputView$ChatInputHandler r5 = r5.mChatInputHandler
                    if (r5 == 0) goto L_0x0087
                    com.hbg.module.huobi.im.group.ui.chat.InputView r5 = com.hbg.module.huobi.im.group.ui.chat.InputView.this
                    com.hbg.module.huobi.im.group.ui.chat.InputView$ChatInputHandler r5 = r5.mChatInputHandler
                    r5.onRecordStatusChanged(r2)
                L_0x0087:
                    com.hbg.module.huobi.im.group.ui.chat.InputView r5 = com.hbg.module.huobi.im.group.ui.chat.InputView.this
                    boolean unused = r5.mAudioCancel = r1
                L_0x008c:
                    com.hbg.module.huobi.im.group.ui.chat.InputView r5 = com.hbg.module.huobi.im.group.ui.chat.InputView.this
                    android.widget.Button r5 = r5.mSendAudioButton
                    android.content.Context r6 = com.tencent.qcloud.tuicore.ServiceInitializer.getAppContext()
                    int r0 = com.hbg.module.huobi.im.R$string.release_end
                    java.lang.String r6 = r6.getString(r0)
                    r5.setText(r6)
                    goto L_0x011d
                L_0x009f:
                    com.hbg.module.huobi.im.group.ui.chat.InputView r5 = com.hbg.module.huobi.im.group.ui.chat.InputView.this
                    float r6 = r6.getY()
                    com.hbg.module.huobi.im.group.ui.chat.InputView r3 = com.hbg.module.huobi.im.group.ui.chat.InputView.this
                    float r3 = r3.mStartRecordY
                    float r6 = r6 - r3
                    r3 = -1027080192(0xffffffffc2c80000, float:-100.0)
                    int r6 = (r6 > r3 ? 1 : (r6 == r3 ? 0 : -1))
                    if (r6 >= 0) goto L_0x00b3
                    goto L_0x00b4
                L_0x00b3:
                    r2 = r1
                L_0x00b4:
                    boolean unused = r5.mAudioCancel = r2
                    com.hbg.module.huobi.im.group.ui.chat.InputView r5 = com.hbg.module.huobi.im.group.ui.chat.InputView.this
                    com.hbg.module.huobi.im.group.ui.chat.InputView$ChatInputHandler r5 = r5.mChatInputHandler
                    if (r5 == 0) goto L_0x00c8
                    com.hbg.module.huobi.im.group.ui.chat.InputView r5 = com.hbg.module.huobi.im.group.ui.chat.InputView.this
                    com.hbg.module.huobi.im.group.ui.chat.InputView$ChatInputHandler r5 = r5.mChatInputHandler
                    r5.onRecordStatusChanged(r0)
                L_0x00c8:
                    com.tencent.qcloud.tuikit.tuichat.component.AudioPlayer r5 = com.tencent.qcloud.tuikit.tuichat.component.AudioPlayer.getInstance()
                    r5.stopRecord()
                    com.hbg.module.huobi.im.group.ui.chat.InputView r5 = com.hbg.module.huobi.im.group.ui.chat.InputView.this
                    android.widget.Button r5 = r5.mSendAudioButton
                    android.content.Context r6 = com.tencent.qcloud.tuicore.ServiceInitializer.getAppContext()
                    int r0 = com.hbg.module.huobi.im.R$string.n_group_im_press_talk
                    java.lang.String r6 = r6.getString(r0)
                    r5.setText(r6)
                    goto L_0x011d
                L_0x00e1:
                    com.hbg.module.huobi.im.group.ui.chat.InputView r5 = com.hbg.module.huobi.im.group.ui.chat.InputView.this
                    boolean unused = r5.mAudioCancel = r2
                    com.hbg.module.huobi.im.group.ui.chat.InputView r5 = com.hbg.module.huobi.im.group.ui.chat.InputView.this
                    float r6 = r6.getY()
                    float unused = r5.mStartRecordY = r6
                    com.hbg.module.huobi.im.group.ui.chat.InputView r5 = com.hbg.module.huobi.im.group.ui.chat.InputView.this
                    com.hbg.module.huobi.im.group.ui.chat.InputView$ChatInputHandler r5 = r5.mChatInputHandler
                    if (r5 == 0) goto L_0x0100
                    com.hbg.module.huobi.im.group.ui.chat.InputView r5 = com.hbg.module.huobi.im.group.ui.chat.InputView.this
                    com.hbg.module.huobi.im.group.ui.chat.InputView$ChatInputHandler r5 = r5.mChatInputHandler
                    r5.onRecordStatusChanged(r2)
                L_0x0100:
                    com.hbg.module.huobi.im.group.ui.chat.InputView r5 = com.hbg.module.huobi.im.group.ui.chat.InputView.this
                    android.widget.Button r5 = r5.mSendAudioButton
                    android.content.Context r6 = com.tencent.qcloud.tuicore.ServiceInitializer.getAppContext()
                    int r0 = com.hbg.module.huobi.im.R$string.release_end
                    java.lang.String r6 = r6.getString(r0)
                    r5.setText(r6)
                    com.tencent.qcloud.tuikit.tuichat.component.AudioPlayer r5 = com.tencent.qcloud.tuikit.tuichat.component.AudioPlayer.getInstance()
                    com.hbg.module.huobi.im.group.ui.chat.InputView$4$1 r6 = new com.hbg.module.huobi.im.group.ui.chat.InputView$4$1
                    r6.<init>()
                    r5.startRecord(r6)
                L_0x011d:
                    return r1
                */
                throw new UnsupportedOperationException("Method not decompiled: com.hbg.module.huobi.im.group.ui.chat.InputView.AnonymousClass4.onTouch(android.view.View, android.view.MotionEvent):boolean");
            }
        });
        this.mTextInput.setOnMentionInputListener(new TIMMentionEditText.OnMentionInputListener() {
            public void onMentionCharacterInput(String str) {
                if ((str.equals(TIMMentionEditText.TIM_MENTION_TAG) || str.equals(TIMMentionEditText.TIM_MENTION_TAG_FULL)) && TUIChatUtils.isGroupChat(InputView.this.mChatLayout.getChatInfo().getType()) && InputView.this.mStartActivityListener != null) {
                    InputView.this.mStartActivityListener.onStartGroupMemberSelectActivity();
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
    }

    public void jump2PrimePage() {
        q.a("APP_LIVE_group_moreprimebox", this.pointMap);
        if (!TextUtils.isEmpty(this.primePath)) {
            BaseModuleConfig.a a11 = BaseModuleConfig.a();
            a11.k0(BaseModuleConfig.a().j() + "/" + this.primePath);
        }
    }

    @SensorsDataInstrumented
    public void onClick(View view) {
        String str = TAG;
        StringBuilder sb2 = new StringBuilder();
        sb2.append("onClick id:");
        sb2.append(view.getId());
        sb2.append("|voice_input_switch:");
        int i11 = R$id.voice_input_switch;
        sb2.append(i11);
        sb2.append("|face_btn:");
        int i12 = R$id.face_btn;
        sb2.append(i12);
        sb2.append("|more_btn:");
        int i13 = R$id.more_btn;
        sb2.append(i13);
        sb2.append("|send_btn:");
        int i14 = R$id.send_btn;
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
                this.mEmojiInputButton.setImageResource(R$drawable.action_face_selector);
            } else if (i15 == 0) {
                this.mCurrentState = 1;
            } else {
                this.mCurrentState = 0;
            }
            if (this.mCurrentState == 1) {
                this.mAudioInputSwitchButton.setImageResource(R$drawable.ic_keyboard);
                this.mSendAudioButton.setVisibility(0);
                this.mTextInput.setVisibility(8);
                hideSoftInput();
            } else {
                this.mAudioInputSwitchButton.setImageResource(R$drawable.ic_voice);
                this.mSendAudioButton.setVisibility(8);
                this.mTextInput.setVisibility(0);
                showSoftInput();
            }
        } else if (view.getId() == i12) {
            if (this.mCurrentState == 1) {
                this.mCurrentState = -1;
                this.mAudioInputSwitchButton.setImageResource(R$drawable.ic_voice);
                this.mSendAudioButton.setVisibility(8);
                this.mTextInput.setVisibility(0);
            }
            if (this.mCurrentState == 2) {
                this.mCurrentState = -1;
                this.mInputMoreView.setVisibility(8);
                this.mEmojiInputButton.setImageResource(R$drawable.action_face_selector);
                this.mTextInput.setVisibility(0);
            } else {
                this.mCurrentState = 2;
                showFaceViewGroup();
            }
        } else if (view.getId() == i13) {
            hideSoftInput();
            OnPlusClickListener onPlusClickListener = this.plusClickListener;
            if (onPlusClickListener != null) {
                onPlusClickListener.onPlusClick();
            }
            Object obj = this.mMoreInputEvent;
            if (obj instanceof View.OnClickListener) {
                ((View.OnClickListener) obj).onClick(view);
            } else if (obj instanceof BaseInputFragment) {
                showCustomInputMoreFragment();
            } else if (this.mCurrentState == 3) {
                this.mCurrentState = -1;
                if (this.mInputMoreView.getVisibility() == 0) {
                    this.mInputMoreView.setVisibility(8);
                } else {
                    this.mInputMoreView.setVisibility(0);
                }
            } else {
                showInputMoreLayout();
                this.mCurrentState = 3;
                this.mAudioInputSwitchButton.setImageResource(R$drawable.ic_voice);
                this.mEmojiInputButton.setImageResource(R$drawable.action_face_selector);
                this.mSendAudioButton.setVisibility(8);
                this.mTextInput.setVisibility(0);
            }
        } else if (view.getId() == i14 && this.mSendEnable) {
            if (this.mMessageHandler != null) {
                if (this.isReplyModel && this.replyPreviewBean != null) {
                    if (!TUIChatUtils.isGroupChat(this.mChatLayout.getChatInfo().getType()) || this.mTextInput.getMentionIdList().isEmpty()) {
                        this.mMessageHandler.sendMessage(ChatMessageBuilder.buildReplyMessage(this.mTextInput.getText().toString().trim(), this.replyPreviewBean));
                    } else {
                        this.mMessageHandler.sendMessage(ChatMessageBuilder.buildAtReplyMessage(this.mTextInput.getText().toString().trim(), new ArrayList(this.mTextInput.getMentionIdList()), this.replyPreviewBean));
                    }
                    exitReply();
                } else if (!TUIChatUtils.isGroupChat(this.mChatLayout.getChatInfo().getType()) || this.mTextInput.getMentionIdList().isEmpty()) {
                    this.mMessageHandler.sendMessage(ChatMessageBuilder.buildTextMessage(this.mTextInput.getText().toString().trim()));
                } else {
                    ArrayList arrayList = new ArrayList(this.mTextInput.getMentionIdList());
                    if (arrayList.isEmpty()) {
                        this.mMessageHandler.sendMessage(ChatMessageBuilder.buildTextMessage(this.mTextInput.getText().toString().trim()));
                    } else {
                        String obj2 = this.mTextInput.getText().toString();
                        if (TextUtils.equals(obj2, TIMMentionEditText.TIM_MENTION_TAG + this.displayInputString)) {
                            this.mMessageHandler.sendMessage(ChatMessageBuilder.buildTextAtMessage(arrayList, this.mTextInput.getText().toString()));
                        } else {
                            this.mMessageHandler.sendMessage(ChatMessageBuilder.buildTextAtMessage(arrayList, this.mTextInput.getText().toString().trim()));
                        }
                    }
                }
            }
            this.mTextInput.setText("");
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.mTextInput.removeTextChangedListener(this);
        this.atUserInfoMap.clear();
    }

    public void onTextChanged(CharSequence charSequence, int i11, int i12, int i13) {
    }

    public void replaceMoreInput(BaseInputFragment baseInputFragment) {
        this.mMoreInputEvent = baseInputFragment;
    }

    /* JADX WARNING: Removed duplicated region for block: B:26:0x0072  */
    /* JADX WARNING: Removed duplicated region for block: B:29:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void setChatInfo(com.tencent.qcloud.tuikit.tuichat.bean.ChatInfo r5) {
        /*
            r4 = this;
            r4.mChatInfo = r5
            if (r5 == 0) goto L_0x008c
            com.tencent.qcloud.tuikit.tuichat.bean.DraftInfo r0 = r5.getDraft()
            if (r0 == 0) goto L_0x0068
            java.lang.String r1 = r0.getDraftText()
            boolean r1 = android.text.TextUtils.isEmpty(r1)
            if (r1 != 0) goto L_0x0068
            com.tencent.qcloud.tuikit.tuichat.classicui.widget.input.TIMMentionEditText r1 = r4.mTextInput
            if (r1 == 0) goto L_0x0068
            com.google.gson.Gson r1 = new com.google.gson.Gson
            r1.<init>()
            java.lang.String r2 = r0.getDraftText()
            java.lang.String r0 = r0.getDraftText()     // Catch:{ JsonSyntaxException -> 0x004f }
            java.lang.Class<java.util.HashMap> r3 = java.util.HashMap.class
            java.lang.Object r0 = r1.fromJson((java.lang.String) r0, r3)     // Catch:{ JsonSyntaxException -> 0x004f }
            java.util.HashMap r0 = (java.util.HashMap) r0     // Catch:{ JsonSyntaxException -> 0x004f }
            if (r0 == 0) goto L_0x0056
            java.lang.String r3 = "content"
            java.lang.Object r3 = r0.get(r3)     // Catch:{ JsonSyntaxException -> 0x004f }
            java.lang.String r3 = (java.lang.String) r3     // Catch:{ JsonSyntaxException -> 0x004f }
            java.lang.String r2 = "reply"
            java.lang.Object r0 = r0.get(r2)     // Catch:{ JsonSyntaxException -> 0x004e }
            java.lang.String r0 = (java.lang.String) r0     // Catch:{ JsonSyntaxException -> 0x004e }
            java.lang.Class<com.tencent.qcloud.tuikit.tuichat.bean.ReplyPreviewBean> r2 = com.tencent.qcloud.tuikit.tuichat.bean.ReplyPreviewBean.class
            java.lang.Object r0 = r1.fromJson((java.lang.String) r0, r2)     // Catch:{ JsonSyntaxException -> 0x004e }
            com.tencent.qcloud.tuikit.tuichat.bean.ReplyPreviewBean r0 = (com.tencent.qcloud.tuikit.tuichat.bean.ReplyPreviewBean) r0     // Catch:{ JsonSyntaxException -> 0x004e }
            if (r0 == 0) goto L_0x004c
            r4.showReplyPreview(r0)     // Catch:{ JsonSyntaxException -> 0x004e }
        L_0x004c:
            r2 = r3
            goto L_0x0056
        L_0x004e:
            r2 = r3
        L_0x004f:
            java.lang.String r0 = TAG
            java.lang.String r1 = " getCustomJsonMap error "
            com.tencent.qcloud.tuikit.tuichat.util.TUIChatLog.e(r0, r1)
        L_0x0056:
            com.tencent.qcloud.tuikit.tuichat.classicui.widget.input.TIMMentionEditText r0 = r4.mTextInput
            r0.setText(r2)
            com.tencent.qcloud.tuikit.tuichat.classicui.widget.input.TIMMentionEditText r0 = r4.mTextInput
            android.text.Editable r1 = r0.getText()
            int r1 = r1.length()
            r0.setSelection(r1)
        L_0x0068:
            int r5 = r5.getType()
            boolean r5 = com.tencent.qcloud.tuikit.tuichat.util.TUIChatUtils.isGroupChat(r5)
            if (r5 == 0) goto L_0x008c
            java.util.HashMap<java.lang.String, java.lang.Object> r5 = r4.pointMap
            com.tencent.qcloud.tuikit.tuichat.bean.ChatInfo r0 = r4.mChatInfo
            java.lang.String r0 = r0.getId()
            java.lang.String r1 = "groupid"
            r5.put(r1, r0)
            java.util.HashMap<java.lang.String, java.lang.Object> r5 = r4.pointMap
            com.tencent.qcloud.tuikit.tuichat.bean.ChatInfo r0 = r4.mChatInfo
            java.lang.String r0 = r0.getChatName()
            java.lang.String r1 = "state"
            r5.put(r1, r0)
        L_0x008c:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.hbg.module.huobi.im.group.ui.chat.InputView.setChatInfo(com.tencent.qcloud.tuikit.tuichat.bean.ChatInfo):void");
    }

    public void setChatInputHandler(ChatInputHandler chatInputHandler) {
        this.mChatInputHandler = chatInputHandler;
    }

    public void setChatLayout(IChatLayout iChatLayout) {
        this.mChatLayout = iChatLayout;
    }

    public void setChatManager(ChatPresenter chatPresenter) {
        this.chatManager = chatPresenter;
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
        if (this.isReplyModel && this.replyPreviewBean != null) {
            Gson gson = new Gson();
            HashMap hashMap = new HashMap();
            hashMap.put("content", obj);
            hashMap.put("reply", gson.toJson((Object) this.replyPreviewBean));
            obj = gson.toJson((Object) hashMap);
        }
        ChatPresenter chatPresenter = this.chatManager;
        if (chatPresenter != null) {
            chatPresenter.setDraft(obj);
        }
    }

    public void setMessageHandler(MessageHandler messageHandler) {
        this.mMessageHandler = messageHandler;
    }

    public void setOnPlusClickListener(OnPlusClickListener onPlusClickListener) {
        this.plusClickListener = onPlusClickListener;
    }

    public void setStartActivityListener(OnStartActivityListener onStartActivityListener) {
        this.mStartActivityListener = onStartActivityListener;
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
        this.isReplyModel = true;
        this.replyPreviewBean = replyPreviewBean2;
        String messageAbstract = replyPreviewBean2.getMessageAbstract();
        String msgTypeStr = ChatMessageParser.getMsgTypeStr(replyPreviewBean2.getMessageType());
        if (replyPreviewBean2.getOriginalMessageBean() instanceof FileMessageBean) {
            this.replyTv.setEllipsize(TextUtils.TruncateAt.MIDDLE);
        } else {
            this.replyTv.setEllipsize(TextUtils.TruncateAt.END);
        }
        this.replyTv.setText(FaceManager.emojiJudge(replyPreviewBean2.getMessageSender() + " : " + msgTypeStr + " " + messageAbstract));
        this.replyLayout.setVisibility(0);
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
        hideInputMoreLayout();
        this.mAudioInputSwitchButton.setImageResource(R$drawable.ic_voice);
        this.mEmojiInputButton.setImageResource(R$drawable.chat_input_face);
        this.mCurrentState = 0;
        this.mSendAudioButton.setVisibility(8);
        this.mTextInput.setVisibility(0);
        this.mTextInput.requestFocus();
        InputMethodManager inputMethodManager = (InputMethodManager) getContext().getSystemService("input_method");
        if (!isSoftInputShown()) {
            inputMethodManager.toggleSoftInput(0, 0);
        }
        if (this.mChatInputHandler != null) {
            postDelayed(new Runnable() {
                public void run() {
                    InputView.this.mChatInputHandler.onInputAreaClick();
                }
            }, 200);
        }
    }

    public void startCapture() {
        String str = TAG;
        TUIChatLog.i(str, "startCapture");
        if (!checkPermission(1)) {
            TUIChatLog.i(str, "startCapture checkPermission failed");
            return;
        }
        Intent intent = new Intent(getContext(), CameraActivity.class);
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
        setOpenPhotoCallback();
        this.mInputMoreFragment.startActivityForResult(intent, 1012);
    }

    public void startSendFile() {
        String str = TAG;
        TUIChatLog.i(str, "startSendFile");
        if (!checkPermission(5)) {
            TUIChatLog.i(str, "startSendFile checkPermission failed");
            return;
        }
        Intent intent = new Intent("android.intent.action.GET_CONTENT");
        intent.setType("*/*");
        intent.addCategory("android.intent.category.OPENABLE");
        this.mInputMoreFragment.setCallback(new IUIKitCallback() {
            public void onError(String str, int i11, String str2) {
                ToastUtil.toastLongMessage(str2);
            }

            public void onSuccess(Object obj) {
                TUIMessageBean buildFileMessage = ChatMessageBuilder.buildFileMessage((Uri) obj);
                if (InputView.this.mMessageHandler != null) {
                    InputView.this.mMessageHandler.sendMessage(buildFileMessage);
                    InputView.this.hideSoftInput();
                }
            }
        });
        this.mInputMoreFragment.startActivityForResult(intent, 1011);
    }

    public void startSendPhoto() {
        Intent intent;
        String str = TAG;
        TUIChatLog.i(str, "startSendPhoto");
        if (!checkPermission(4)) {
            TUIChatLog.i(str, "startSendPhoto checkPermission failed");
            return;
        }
        if (Build.VERSION.SDK_INT < 19) {
            intent = new Intent("android.intent.action.GET_CONTENT");
            intent.addCategory("android.intent.category.OPENABLE");
            intent.setType("*/*");
            intent.putExtra("android.intent.extra.MIME_TYPES", new String[]{SelectMimeType.SYSTEM_IMAGE});
        } else {
            intent = new Intent("android.intent.action.PICK", MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        }
        setOpenPhotoCallback();
        this.mInputMoreFragment.startActivityForResult(intent, 1012);
    }

    public void startVideoRecord() {
        String str = TAG;
        TUIChatLog.i(str, "startVideoRecord");
        if (!checkPermission(3)) {
            TUIChatLog.i(str, "startVideoRecord checkPermission failed");
            return;
        }
        Intent intent = new Intent(getContext(), CameraActivity.class);
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
        setOpenPhotoCallback();
        this.mInputMoreFragment.startActivityForResult(intent, 1012);
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
                BackgroundTasks.getInstance().postDelayed(new Runnable() {
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
