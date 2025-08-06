package com.zopim.android.sdk.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.annotation.TargetApi;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Binder;
import android.os.Build;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.SystemClock;
import android.provider.Settings;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.view.h0;
import com.google.android.exoplayer2.C;
import com.sensorsdata.analytics.android.sdk.aop.push.PushAutoTrackHelper;
import com.zendesk.logger.Logger;
import com.zopim.android.sdk.R;
import com.zopim.android.sdk.anim.AnimatorPack;
import com.zopim.android.sdk.api.ServiceUtils;
import com.zopim.android.sdk.api.ZopimChatApi;
import com.zopim.android.sdk.chatlog.view.TypingIndicatorView;
import com.zopim.android.sdk.data.LivechatChatLogPath;
import com.zopim.android.sdk.data.observers.AgentsObserver;
import com.zopim.android.sdk.data.observers.ChatLogObserver;
import com.zopim.android.sdk.embeddable.ChatActions;
import com.zopim.android.sdk.model.Agent;
import com.zopim.android.sdk.model.ChatLog;
import com.zopim.android.sdk.util.Dimensions;
import com.zopim.android.sdk.widget.view.WidgetView;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;

public class ChatWidgetService extends Service {
    private static final int ANIMATION_FRAME_RATE = 30;
    private static final int DEFAULT_WIDGET_HEIGHT_DP = 50;
    private static final int DEFAULT_WIDGET_WIDTH_DP = 50;
    private static final String LOG_TAG = "ChatWidgetService";
    private static final int WIDGET_INIT_DELAY = 300;
    private static boolean disabled = false;
    /* access modifiers changed from: private */
    public Handler animationHandler = new Handler(Looper.getMainLooper());
    private final IBinder binder = new LocalBinder();
    /* access modifiers changed from: private */
    public AnimatorSet crossfadeAnimator;
    /* access modifiers changed from: private */
    public int horizontalMargin;
    /* access modifiers changed from: private */
    public int initialAgentMessageCount;
    public AgentsObserver mAgentsObserver = new AgentsObserver() {
        public void update(final Map<String, Agent> map) {
            ChatWidgetService.this.animationHandler.post(new Runnable() {
                @TargetApi(11)
                public void run() {
                    boolean z11;
                    Iterator it2 = map.values().iterator();
                    loop0:
                    while (true) {
                        z11 = false;
                        while (true) {
                            if (!it2.hasNext()) {
                                break loop0;
                            }
                            Agent agent = (Agent) it2.next();
                            if (agent.isTyping() != null) {
                                if (z11 || agent.isTyping().booleanValue()) {
                                    z11 = true;
                                }
                            }
                        }
                    }
                    if (z11) {
                        ChatWidgetService.this.typingIndicatorView.start();
                        ChatWidgetService.this.unreadNotificationView.setVisibility(4);
                        ChatWidgetService.this.typingIndicatorView.setVisibility(0);
                        return;
                    }
                    long j11 = 0;
                    if (Build.VERSION.SDK_INT >= 11) {
                        j11 = ChatWidgetService.this.crossfadeAnimator.getDuration();
                    }
                    ChatWidgetService.this.animationHandler.postDelayed(new Runnable() {
                        public void run() {
                            ChatWidgetService.this.typingIndicatorView.stop();
                            if (ChatWidgetService.this.unreadCount > 0) {
                                ChatWidgetService.this.unreadNotificationView.setVisibility(0);
                                ChatWidgetService.this.typingIndicatorView.setVisibility(4);
                            }
                        }
                    }, j11 * 2);
                }
            });
        }
    };
    public ChatLogObserver mChannelLogObserver = new ChatLogObserver() {
        public void update(LinkedHashMap<String, ChatLog> linkedHashMap) {
            final int countMessages = LivechatChatLogPath.getInstance().countMessages(ChatLog.Type.CHAT_MSG_AGENT) - ChatWidgetService.this.initialAgentMessageCount;
            if (countMessages > ChatWidgetService.this.unreadCount) {
                int unused = ChatWidgetService.this.unreadCount = countMessages;
                ChatWidgetService.this.animationHandler.post(new Runnable() {
                    public void run() {
                        ChatWidgetService.this.unreadNotificationView.setText(String.valueOf(countMessages));
                        ChatWidgetService.this.showUnreadNotification();
                    }
                });
            }
        }
    };
    /* access modifiers changed from: private */
    public double offsetX;
    /* access modifiers changed from: private */
    public double offsetY;
    /* access modifiers changed from: private */
    public WindowManager.LayoutParams rootLayoutParams;
    /* access modifiers changed from: private */
    public Timer timer;
    /* access modifiers changed from: private */
    public TypingIndicatorView typingIndicatorView;
    /* access modifiers changed from: private */
    public int unreadCount;
    /* access modifiers changed from: private */
    public TextView unreadNotificationView;
    /* access modifiers changed from: private */
    public int verticalMargin;
    /* access modifiers changed from: private */
    public WidgetAnimatorTask widgetAnimatorTask;
    private ImageView widgetBackground;
    /* access modifiers changed from: private */
    public WidgetView widgetView;
    /* access modifiers changed from: private */
    public WindowManager windowManager;

    /* renamed from: com.zopim.android.sdk.widget.ChatWidgetService$5  reason: invalid class name */
    public static /* synthetic */ class AnonymousClass5 {
        public static final /* synthetic */ int[] $SwitchMap$com$zopim$android$sdk$widget$view$WidgetView$Anchor;

        /* JADX WARNING: Can't wrap try/catch for region: R(8:0|1|2|3|4|5|6|(3:7|8|10)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        static {
            /*
                com.zopim.android.sdk.widget.view.WidgetView$Anchor[] r0 = com.zopim.android.sdk.widget.view.WidgetView.Anchor.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$com$zopim$android$sdk$widget$view$WidgetView$Anchor = r0
                com.zopim.android.sdk.widget.view.WidgetView$Anchor r1 = com.zopim.android.sdk.widget.view.WidgetView.Anchor.TOP_LEFT     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = $SwitchMap$com$zopim$android$sdk$widget$view$WidgetView$Anchor     // Catch:{ NoSuchFieldError -> 0x001d }
                com.zopim.android.sdk.widget.view.WidgetView$Anchor r1 = com.zopim.android.sdk.widget.view.WidgetView.Anchor.TOP_RIGHT     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = $SwitchMap$com$zopim$android$sdk$widget$view$WidgetView$Anchor     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.zopim.android.sdk.widget.view.WidgetView$Anchor r1 = com.zopim.android.sdk.widget.view.WidgetView.Anchor.BOTTOM_LEFT     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = $SwitchMap$com$zopim$android$sdk$widget$view$WidgetView$Anchor     // Catch:{ NoSuchFieldError -> 0x0033 }
                com.zopim.android.sdk.widget.view.WidgetView$Anchor r1 = com.zopim.android.sdk.widget.view.WidgetView.Anchor.BOTTOM_RIGHT     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.zopim.android.sdk.widget.ChatWidgetService.AnonymousClass5.<clinit>():void");
        }
    }

    public class LocalBinder extends Binder {
        public LocalBinder() {
        }

        public ChatWidgetService getService() {
            return ChatWidgetService.this;
        }
    }

    public class WidgetAnimatorTask extends TimerTask {
        public int destX;
        public int destY;
        public int horizontalMargin;
        public int verticalMargin;

        public WidgetAnimatorTask(ChatWidgetService chatWidgetService) {
            this(0, 0);
        }

        /* access modifiers changed from: private */
        public void updateWidget() {
            WindowManager.LayoutParams access$300 = ChatWidgetService.this.rootLayoutParams;
            int i11 = ChatWidgetService.this.rootLayoutParams.x;
            int i12 = this.destX;
            access$300.x = (((i11 - i12) * 2) / 3) + i12;
            WindowManager.LayoutParams access$3002 = ChatWidgetService.this.rootLayoutParams;
            int i13 = ChatWidgetService.this.rootLayoutParams.y;
            int i14 = this.destY;
            access$3002.y = (((i13 - i14) * 2) / 3) + i14;
            if (h0.Z(ChatWidgetService.this.widgetView)) {
                try {
                    ChatWidgetService.this.windowManager.updateViewLayout(ChatWidgetService.this.widgetView, ChatWidgetService.this.rootLayoutParams);
                } catch (IllegalArgumentException e11) {
                    Logger.l(ChatWidgetService.LOG_TAG, "Error updating the WidgetView, maybe not attached to the window manager, error: %s", e11.getMessage());
                }
            }
            if (Math.abs(ChatWidgetService.this.rootLayoutParams.x - this.destX) < 2 && Math.abs(ChatWidgetService.this.rootLayoutParams.y - this.destY) < 2) {
                cancel();
                ChatWidgetService.this.timer.cancel();
            }
        }

        public int getNavBar() {
            Resources resources = ChatWidgetService.this.getBaseContext().getResources();
            int identifier = resources.getIdentifier(ChatWidgetService.this.getResources().getConfiguration().orientation == 1 ? "navigation_bar_height" : "navigation_bar_height_landscape", "dimen", "android");
            if (identifier > 0) {
                return resources.getDimensionPixelSize(identifier);
            }
            return 0;
        }

        public int getStatusBar() {
            int identifier = ChatWidgetService.this.getResources().getIdentifier("status_bar_height", "dimen", "android");
            if (identifier > 0) {
                return ChatWidgetService.this.getResources().getDimensionPixelSize(identifier);
            }
            return 0;
        }

        public void run() {
            ChatWidgetService.this.animationHandler.post(new Runnable() {
                public void run() {
                    WidgetAnimatorTask.this.updateWidget();
                }
            });
        }

        public WidgetAnimatorTask(int i11, int i12) {
            int i13 = 0;
            this.horizontalMargin = i11 < 0 ? 0 : i11;
            this.verticalMargin = i12 >= 0 ? i12 : i13;
            int i14 = ChatWidgetService.this.getApplicationContext().getResources().getDisplayMetrics().heightPixels;
            int i15 = ChatWidgetService.this.getApplicationContext().getResources().getDisplayMetrics().widthPixels;
            int width = (i15 - ChatWidgetService.this.widgetView.getWidth()) - i11;
            int statusBar = (((getStatusBar() + i14) - getNavBar()) - ChatWidgetService.this.widgetView.getHeight()) - i12;
            int abs = Math.abs(ChatWidgetService.this.rootLayoutParams.x - i11);
            int abs2 = Math.abs(ChatWidgetService.this.rootLayoutParams.x - width);
            int abs3 = Math.abs(ChatWidgetService.this.rootLayoutParams.y - i12);
            int abs4 = Math.abs(ChatWidgetService.this.rootLayoutParams.y - statusBar);
            if (Math.min(abs3, abs4) < Math.min(abs, abs2)) {
                if (abs3 < abs4) {
                    this.destY = i12;
                } else {
                    this.destY = statusBar;
                }
                if (ChatWidgetService.this.rootLayoutParams.x < i11) {
                    this.destX = i11;
                } else if (ChatWidgetService.this.rootLayoutParams.x > width) {
                    this.destX = width;
                } else {
                    this.destX = ChatWidgetService.this.rootLayoutParams.x;
                }
            } else {
                if (abs < abs2) {
                    this.destX = i11;
                } else {
                    this.destX = width;
                }
                if (ChatWidgetService.this.rootLayoutParams.y < i12) {
                    this.destY = i12;
                } else if (ChatWidgetService.this.rootLayoutParams.y > statusBar) {
                    this.destY = statusBar;
                } else {
                    this.destY = ChatWidgetService.this.rootLayoutParams.y;
                }
            }
            double unused = ChatWidgetService.this.offsetX = (double) ((this.destX * 100) / i15);
            double unused2 = ChatWidgetService.this.offsetY = (double) ((this.destY * 100) / i14);
        }
    }

    public class WidgetTouchListener implements View.OnTouchListener {
        private static final long CLICK_THRESHOLD_MS = 200;
        private final int clickThresholdPx;
        public long downEvent;
        private float downX;
        private float downY;
        private float prevX;
        private float prevY;

        private WidgetTouchListener() {
            this.clickThresholdPx = ViewConfiguration.get(ChatWidgetService.this.getApplicationContext()).getScaledTouchSlop();
        }

        public void onClick() {
            Logger.j(ChatWidgetService.LOG_TAG, "onClick() chat widget", new Object[0]);
            Logger.g(ChatWidgetService.LOG_TAG, "Broadcasting intent action zopim.action.RESUME_CHAT to resume a chat activity", new Object[0]);
            Intent intent = new Intent();
            intent.setAction(ChatActions.ACTION_RESUME_CHAT);
            intent.addCategory("android.intent.category.DEFAULT");
            intent.addFlags(C.ENCODING_PCM_32BIT);
            intent.setPackage(ChatWidgetService.this.getApplicationContext().getPackageName());
            ChatWidgetService.this.startActivity(intent);
            ChatWidgetService.this.stopSelf();
        }

        public boolean onTouch(View view, MotionEvent motionEvent) {
            int actionMasked = motionEvent.getActionMasked();
            float rawX = motionEvent.getRawX();
            float rawY = motionEvent.getRawY();
            if (actionMasked != 0) {
                if (actionMasked != 1) {
                    if (actionMasked == 2) {
                        WindowManager.LayoutParams access$300 = ChatWidgetService.this.rootLayoutParams;
                        access$300.x = (int) (((float) access$300.x) + (rawX - this.prevX));
                        WindowManager.LayoutParams access$3002 = ChatWidgetService.this.rootLayoutParams;
                        access$3002.y = (int) (((float) access$3002.y) + (rawY - this.prevY));
                        this.prevX = rawX;
                        this.prevY = rawY;
                        ChatWidgetService.this.windowManager.updateViewLayout(ChatWidgetService.this.widgetView, ChatWidgetService.this.rootLayoutParams);
                        return true;
                    } else if (actionMasked != 3) {
                        return false;
                    }
                }
                if (SystemClock.elapsedRealtime() - this.downEvent < 200) {
                    float abs = Math.abs(rawX - this.downX);
                    float abs2 = Math.abs(rawY - this.downY);
                    if (((int) Math.sqrt((double) ((abs * abs) + (abs2 * abs2)))) < this.clickThresholdPx) {
                        onClick();
                        return false;
                    }
                }
                ChatWidgetService chatWidgetService = ChatWidgetService.this;
                ChatWidgetService chatWidgetService2 = ChatWidgetService.this;
                WidgetAnimatorTask unused = chatWidgetService.widgetAnimatorTask = new WidgetAnimatorTask(chatWidgetService2.horizontalMargin, ChatWidgetService.this.verticalMargin);
                Timer unused2 = ChatWidgetService.this.timer = new Timer();
                ChatWidgetService.this.timer.schedule(ChatWidgetService.this.widgetAnimatorTask, 0, 30);
                return true;
            }
            this.downEvent = SystemClock.elapsedRealtime();
            if (ChatWidgetService.this.widgetAnimatorTask != null) {
                ChatWidgetService.this.widgetAnimatorTask.cancel();
                ChatWidgetService.this.timer.cancel();
            }
            this.downX = rawX;
            this.downY = rawY;
            this.prevX = rawX;
            this.prevY = rawY;
            return true;
        }
    }

    @TargetApi(23)
    private boolean canDrawOverlays(Context context) {
        if (Build.VERSION.SDK_INT >= 23) {
            return Settings.canDrawOverlays(context);
        }
        return hasSystemAlertWindowPermission(context);
    }

    public static void disable() {
        disabled = true;
    }

    private int getWindowType() {
        return Build.VERSION.SDK_INT >= 26 ? 2038 : 2002;
    }

    @TargetApi(19)
    private boolean hasSystemAlertWindowPermission(Context context) {
        if (Build.VERSION.SDK_INT >= 19) {
            if (context.checkCallingOrSelfPermission("android.permission.SYSTEM_ALERT_WINDOW") == 0) {
                return true;
            }
            return false;
        } else if (context.checkCallingOrSelfPermission("android.permission.SYSTEM_ALERT_WINDOW") == 0) {
            return true;
        } else {
            return false;
        }
    }

    private boolean shouldStopService() {
        if (disabled) {
            Logger.j(LOG_TAG, "Not presenting chat widget. Disabled.", new Object[0]);
        }
        if (!canDrawOverlays(this)) {
            Logger.g(LOG_TAG, "Not presenting chat widget. Can not draw overlays or missing permission SYSTEM_ALERT_WINDOW", new Object[0]);
        }
        if (disabled || !canDrawOverlays(getApplicationContext())) {
            return true;
        }
        return false;
    }

    /* access modifiers changed from: private */
    @TargetApi(11)
    public void showUnreadNotification() {
        if (Build.VERSION.SDK_INT >= 11) {
            this.crossfadeAnimator.start();
            return;
        }
        this.typingIndicatorView.setVisibility(4);
        this.unreadNotificationView.setVisibility(0);
    }

    public static void startService(Context context) {
        ServiceUtils.startAsForegroundServiceIfNeeded(context, new Intent(context, ChatWidgetService.class));
    }

    public static boolean stopService(Context context) {
        return context.stopService(new Intent(context, ChatWidgetService.class));
    }

    public IBinder onBind(Intent intent) {
        return this.binder;
    }

    public void onConfigurationChanged(Configuration configuration) {
        if (!disabled && canDrawOverlays(this)) {
            super.onConfigurationChanged(configuration);
            int i11 = getApplicationContext().getResources().getDisplayMetrics().widthPixels;
            int i12 = getApplicationContext().getResources().getDisplayMetrics().heightPixels;
            WindowManager.LayoutParams layoutParams = this.rootLayoutParams;
            layoutParams.x = (int) ((this.offsetX / 100.0d) * ((double) i11));
            layoutParams.y = (int) ((this.offsetY / 100.0d) * ((double) i12));
            this.widgetAnimatorTask = new WidgetAnimatorTask(this.horizontalMargin, this.verticalMargin);
            Timer timer2 = new Timer();
            this.timer = timer2;
            timer2.schedule(this.widgetAnimatorTask, 0, 30);
        }
    }

    @TargetApi(11)
    public void onCreate() {
        ServiceUtils.startForegroundIfNeeded(this, ZopimChatApi.getServiceNotificationServiceIntent());
        if (shouldStopService()) {
            Logger.g(LOG_TAG, "Not presenting chat widget. Can not draw overlays or missing permission SYSTEM_ALERT_WINDOW", new Object[0]);
            stopSelf();
            return;
        }
        final int i11 = getApplicationContext().getResources().getDisplayMetrics().heightPixels;
        final int i12 = getApplicationContext().getResources().getDisplayMetrics().widthPixels;
        try {
            this.horizontalMargin = getResources().getDimensionPixelSize(R.dimen.widget_horizontal_margin);
            this.verticalMargin = getResources().getDimensionPixelSize(R.dimen.widget_vertical_margin);
        } catch (Resources.NotFoundException e11) {
            Logger.k(LOG_TAG, "Could not find margin resources. Will use zero margin", e11, new Object[0]);
            this.horizontalMargin = 0;
            this.verticalMargin = 0;
        }
        this.windowManager = (WindowManager) getSystemService("window");
        WidgetView widgetView2 = (WidgetView) LayoutInflater.from(this).inflate(R.layout.chat_widget, (ViewGroup) null);
        this.widgetView = widgetView2;
        this.typingIndicatorView = (TypingIndicatorView) widgetView2.findViewById(R.id.typing_indicator);
        this.unreadNotificationView = (TextView) this.widgetView.findViewById(R.id.unread_notification);
        ImageView imageView = (ImageView) this.widgetView.findViewById(R.id.background);
        this.widgetBackground = imageView;
        if (Build.VERSION.SDK_INT >= 11) {
            AnimatorSet crossfade = AnimatorPack.crossfade(imageView, imageView);
            AnimatorSet crossfade2 = AnimatorPack.crossfade(this.typingIndicatorView, this.unreadNotificationView);
            AnimatorSet animatorSet = new AnimatorSet();
            this.crossfadeAnimator = animatorSet;
            animatorSet.play(crossfade).with(crossfade2);
            this.crossfadeAnimator.addListener(new AnimatorListenerAdapter() {
                public void onAnimationEnd(Animator animator) {
                    super.onAnimationEnd(animator);
                    ChatWidgetService.this.typingIndicatorView.setScaleX(1.0f);
                    ChatWidgetService.this.typingIndicatorView.setScaleY(1.0f);
                }
            });
            long integer = (long) getResources().getInteger(R.integer.crossfade_duration);
            if (integer > 0) {
                this.crossfadeAnimator.setDuration(integer);
            }
        }
        this.widgetView.setOnTouchListener(new WidgetTouchListener());
        int convertDpToPixel = Dimensions.convertDpToPixel(this, 50.0f);
        int convertDpToPixel2 = Dimensions.convertDpToPixel(this, 50.0f);
        try {
            convertDpToPixel = getResources().getDimensionPixelSize(R.dimen.widget_width);
            convertDpToPixel2 = getResources().getDimensionPixelSize(R.dimen.widget_height);
        } catch (Resources.NotFoundException e12) {
            Logger.k(LOG_TAG, "Could not find widget size resources. Will use default size.", e12, new Object[0]);
        }
        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams(convertDpToPixel, convertDpToPixel2, getWindowType(), 520, -3);
        this.rootLayoutParams = layoutParams;
        layoutParams.gravity = 51;
        this.windowManager.addView(this.widgetView, layoutParams);
        this.widgetView.postDelayed(new Runnable() {
            public void run() {
                if (!h0.Z(ChatWidgetService.this.widgetView)) {
                    Logger.j(ChatWidgetService.LOG_TAG, "Not attached to window. Skip loading widget", new Object[0]);
                    return;
                }
                int i11 = AnonymousClass5.$SwitchMap$com$zopim$android$sdk$widget$view$WidgetView$Anchor[ChatWidgetService.this.widgetView.getAnchor().ordinal()];
                if (i11 == 1) {
                    ChatWidgetService.this.rootLayoutParams.x = -ChatWidgetService.this.rootLayoutParams.width;
                    ChatWidgetService.this.rootLayoutParams.y = -ChatWidgetService.this.rootLayoutParams.height;
                } else if (i11 == 2) {
                    ChatWidgetService.this.rootLayoutParams.x = i12 + ChatWidgetService.this.rootLayoutParams.width;
                    ChatWidgetService.this.rootLayoutParams.y = -ChatWidgetService.this.rootLayoutParams.height;
                } else if (i11 == 3) {
                    ChatWidgetService.this.rootLayoutParams.x = -ChatWidgetService.this.rootLayoutParams.width;
                    ChatWidgetService.this.rootLayoutParams.y = i11 + ChatWidgetService.this.rootLayoutParams.height;
                } else if (i11 != 4) {
                    ChatWidgetService.this.rootLayoutParams.x = -ChatWidgetService.this.rootLayoutParams.width;
                    ChatWidgetService.this.rootLayoutParams.y = (i11 - ChatWidgetService.this.widgetView.getHeight()) / 2;
                } else {
                    ChatWidgetService.this.rootLayoutParams.x = i12 + ChatWidgetService.this.rootLayoutParams.width;
                    ChatWidgetService.this.rootLayoutParams.y = i11 + ChatWidgetService.this.rootLayoutParams.height;
                }
                ChatWidgetService.this.windowManager.updateViewLayout(ChatWidgetService.this.widgetView, ChatWidgetService.this.rootLayoutParams);
                ChatWidgetService.this.widgetView.setVisibility(0);
                ChatWidgetService chatWidgetService = ChatWidgetService.this;
                ChatWidgetService chatWidgetService2 = ChatWidgetService.this;
                WidgetAnimatorTask unused = chatWidgetService.widgetAnimatorTask = new WidgetAnimatorTask(chatWidgetService2.horizontalMargin, ChatWidgetService.this.verticalMargin);
                Timer unused2 = ChatWidgetService.this.timer = new Timer();
                ChatWidgetService.this.timer.schedule(ChatWidgetService.this.widgetAnimatorTask, 0, 30);
            }
        }, 300);
    }

    public void onDestroy() {
        Logger.j(LOG_TAG, "Destroying Widget UI", new Object[0]);
        WidgetView widgetView2 = this.widgetView;
        if (widgetView2 != null) {
            this.windowManager.removeView(widgetView2);
        }
        ZopimChatApi.getDataSource().deleteAgentsObserver(this.mAgentsObserver);
        ZopimChatApi.getDataSource().deleteChatLogObserver(this.mChannelLogObserver);
    }

    public int onStartCommand(Intent intent, int i11, int i12) {
        PushAutoTrackHelper.onServiceStartCommand(this, intent, i11, i12);
        Logger.j(LOG_TAG, "Starting Widget UI", new Object[0]);
        if (shouldStopService()) {
            stopSelf();
            return 2;
        } else if (intent == null || !ChatActions.ACTION_STOP_WIDGET_SERVICE.equals(intent.getAction())) {
            this.unreadCount = 0;
            this.initialAgentMessageCount = LivechatChatLogPath.getInstance().countMessages(ChatLog.Type.CHAT_MSG_AGENT);
            ZopimChatApi.getDataSource().addAgentsObserver(this.mAgentsObserver);
            ZopimChatApi.getDataSource().addChatLogObserver(this.mChannelLogObserver);
            return 2;
        } else {
            stopSelf();
            return 2;
        }
    }
}
