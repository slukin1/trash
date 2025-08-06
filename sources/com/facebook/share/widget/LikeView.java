package com.facebook.share.widget;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import com.engagelab.privates.common.BuildConfig;
import com.facebook.FacebookException;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.facebook.common.R;
import com.facebook.internal.AnalyticsEvents;
import com.facebook.internal.FragmentWrapper;
import com.facebook.internal.NativeProtocol;
import com.facebook.internal.Utility;
import com.facebook.places.model.PlaceFields;
import com.facebook.share.internal.LikeActionController;
import com.facebook.share.internal.LikeBoxCountView;
import com.facebook.share.internal.LikeButton;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import com.sensorsdata.analytics.android.sdk.aop.push.PushAutoTrackHelper;
import s1.a;

@Deprecated
public class LikeView extends FrameLayout {
    private static final int NO_FOREGROUND_COLOR = -1;
    private AuxiliaryViewPosition auxiliaryViewPosition = AuxiliaryViewPosition.DEFAULT;
    private BroadcastReceiver broadcastReceiver;
    private LinearLayout containerView;
    /* access modifiers changed from: private */
    public LikeActionControllerCreationCallback creationCallback;
    private int edgePadding;
    private boolean explicitlyDisabled = true;
    private int foregroundColor = -1;
    private HorizontalAlignment horizontalAlignment = HorizontalAlignment.DEFAULT;
    private int internalPadding;
    private LikeActionController likeActionController;
    private LikeBoxCountView likeBoxCountView;
    private LikeButton likeButton;
    private Style likeViewStyle = Style.DEFAULT;
    /* access modifiers changed from: private */
    public String objectId;
    /* access modifiers changed from: private */
    public ObjectType objectType;
    /* access modifiers changed from: private */
    public OnErrorListener onErrorListener;
    private FragmentWrapper parentFragment;
    private TextView socialSentenceView;

    /* renamed from: com.facebook.share.widget.LikeView$2  reason: invalid class name */
    public static /* synthetic */ class AnonymousClass2 {
        public static final /* synthetic */ int[] $SwitchMap$com$facebook$share$widget$LikeView$AuxiliaryViewPosition;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|(3:5|6|8)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        static {
            /*
                com.facebook.share.widget.LikeView$AuxiliaryViewPosition[] r0 = com.facebook.share.widget.LikeView.AuxiliaryViewPosition.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$com$facebook$share$widget$LikeView$AuxiliaryViewPosition = r0
                com.facebook.share.widget.LikeView$AuxiliaryViewPosition r1 = com.facebook.share.widget.LikeView.AuxiliaryViewPosition.TOP     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = $SwitchMap$com$facebook$share$widget$LikeView$AuxiliaryViewPosition     // Catch:{ NoSuchFieldError -> 0x001d }
                com.facebook.share.widget.LikeView$AuxiliaryViewPosition r1 = com.facebook.share.widget.LikeView.AuxiliaryViewPosition.BOTTOM     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = $SwitchMap$com$facebook$share$widget$LikeView$AuxiliaryViewPosition     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.facebook.share.widget.LikeView$AuxiliaryViewPosition r1 = com.facebook.share.widget.LikeView.AuxiliaryViewPosition.INLINE     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.facebook.share.widget.LikeView.AnonymousClass2.<clinit>():void");
        }
    }

    @Deprecated
    public enum AuxiliaryViewPosition {
        BOTTOM("bottom", 0),
        INLINE("inline", 1),
        TOP(ViewHierarchyConstants.DIMENSION_TOP_KEY, 2);
        
        public static AuxiliaryViewPosition DEFAULT;
        private int intValue;
        private String stringValue;

        /* access modifiers changed from: public */
        static {
            AuxiliaryViewPosition auxiliaryViewPosition;
            DEFAULT = auxiliaryViewPosition;
        }

        private AuxiliaryViewPosition(String str, int i11) {
            this.stringValue = str;
            this.intValue = i11;
        }

        public static AuxiliaryViewPosition fromInt(int i11) {
            for (AuxiliaryViewPosition auxiliaryViewPosition : values()) {
                if (auxiliaryViewPosition.getValue() == i11) {
                    return auxiliaryViewPosition;
                }
            }
            return null;
        }

        /* access modifiers changed from: private */
        public int getValue() {
            return this.intValue;
        }

        public String toString() {
            return this.stringValue;
        }
    }

    @Deprecated
    public enum HorizontalAlignment {
        CENTER(TtmlNode.CENTER, 0),
        LEFT("left", 1),
        RIGHT(TtmlNode.RIGHT, 2);
        
        public static HorizontalAlignment DEFAULT;
        private int intValue;
        private String stringValue;

        /* access modifiers changed from: public */
        static {
            HorizontalAlignment horizontalAlignment;
            DEFAULT = horizontalAlignment;
        }

        private HorizontalAlignment(String str, int i11) {
            this.stringValue = str;
            this.intValue = i11;
        }

        public static HorizontalAlignment fromInt(int i11) {
            for (HorizontalAlignment horizontalAlignment : values()) {
                if (horizontalAlignment.getValue() == i11) {
                    return horizontalAlignment;
                }
            }
            return null;
        }

        /* access modifiers changed from: private */
        public int getValue() {
            return this.intValue;
        }

        public String toString() {
            return this.stringValue;
        }
    }

    public class LikeActionControllerCreationCallback implements LikeActionController.CreationCallback {
        private boolean isCancelled;

        private LikeActionControllerCreationCallback() {
        }

        public void cancel() {
            this.isCancelled = true;
        }

        public void onComplete(LikeActionController likeActionController, FacebookException facebookException) {
            if (!this.isCancelled) {
                if (likeActionController != null) {
                    if (!likeActionController.shouldEnableView()) {
                        facebookException = new FacebookException("Cannot use LikeView. The device may not be supported.");
                    }
                    LikeView.this.associateWithLikeActionController(likeActionController);
                    LikeView.this.updateLikeStateAndLayout();
                }
                if (!(facebookException == null || LikeView.this.onErrorListener == null)) {
                    LikeView.this.onErrorListener.onError(facebookException);
                }
                LikeActionControllerCreationCallback unused = LikeView.this.creationCallback = null;
            }
        }
    }

    public class LikeControllerBroadcastReceiver extends BroadcastReceiver {
        private LikeControllerBroadcastReceiver() {
        }

        public void onReceive(Context context, Intent intent) {
            PushAutoTrackHelper.onBroadcastReceiver(this, context, intent);
            String action = intent.getAction();
            Bundle extras = intent.getExtras();
            boolean z11 = true;
            if (extras != null) {
                String string = extras.getString(LikeActionController.ACTION_OBJECT_ID_KEY);
                if (!Utility.isNullOrEmpty(string) && !Utility.areObjectsEqual(LikeView.this.objectId, string)) {
                    z11 = false;
                }
            }
            if (z11) {
                if (LikeActionController.ACTION_LIKE_ACTION_CONTROLLER_UPDATED.equals(action)) {
                    LikeView.this.updateLikeStateAndLayout();
                } else if (LikeActionController.ACTION_LIKE_ACTION_CONTROLLER_DID_ERROR.equals(action)) {
                    if (LikeView.this.onErrorListener != null) {
                        LikeView.this.onErrorListener.onError(NativeProtocol.getExceptionFromErrorData(extras));
                    }
                } else if (LikeActionController.ACTION_LIKE_ACTION_CONTROLLER_DID_RESET.equals(action)) {
                    LikeView likeView = LikeView.this;
                    likeView.setObjectIdAndTypeForced(likeView.objectId, LikeView.this.objectType);
                    LikeView.this.updateLikeStateAndLayout();
                }
            }
        }
    }

    @Deprecated
    public enum ObjectType {
        UNKNOWN("unknown", 0),
        OPEN_GRAPH("open_graph", 1),
        PAGE(PlaceFields.PAGE, 2);
        
        public static ObjectType DEFAULT;
        private int intValue;
        private String stringValue;

        /* access modifiers changed from: public */
        static {
            ObjectType objectType;
            DEFAULT = objectType;
        }

        private ObjectType(String str, int i11) {
            this.stringValue = str;
            this.intValue = i11;
        }

        public static ObjectType fromInt(int i11) {
            for (ObjectType objectType : values()) {
                if (objectType.getValue() == i11) {
                    return objectType;
                }
            }
            return null;
        }

        public int getValue() {
            return this.intValue;
        }

        public String toString() {
            return this.stringValue;
        }
    }

    public interface OnErrorListener {
        void onError(FacebookException facebookException);
    }

    @Deprecated
    public enum Style {
        STANDARD(BuildConfig.BUILD_TYPE, 0),
        BUTTON("button", 1),
        BOX_COUNT("box_count", 2);
        
        public static Style DEFAULT;
        private int intValue;
        private String stringValue;

        /* access modifiers changed from: public */
        static {
            Style style;
            DEFAULT = style;
        }

        private Style(String str, int i11) {
            this.stringValue = str;
            this.intValue = i11;
        }

        public static Style fromInt(int i11) {
            for (Style style : values()) {
                if (style.getValue() == i11) {
                    return style;
                }
            }
            return null;
        }

        /* access modifiers changed from: private */
        public int getValue() {
            return this.intValue;
        }

        public String toString() {
            return this.stringValue;
        }
    }

    @Deprecated
    public LikeView(Context context) {
        super(context);
        initialize(context);
    }

    /* access modifiers changed from: private */
    public void associateWithLikeActionController(LikeActionController likeActionController2) {
        this.likeActionController = likeActionController2;
        this.broadcastReceiver = new LikeControllerBroadcastReceiver();
        a b11 = a.b(getContext());
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(LikeActionController.ACTION_LIKE_ACTION_CONTROLLER_UPDATED);
        intentFilter.addAction(LikeActionController.ACTION_LIKE_ACTION_CONTROLLER_DID_ERROR);
        intentFilter.addAction(LikeActionController.ACTION_LIKE_ACTION_CONTROLLER_DID_RESET);
        b11.c(this.broadcastReceiver, intentFilter);
    }

    /* JADX WARNING: Removed duplicated region for block: B:7:0x0015  */
    /* JADX WARNING: Removed duplicated region for block: B:9:0x0018  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private android.app.Activity getActivity() {
        /*
            r3 = this;
            android.content.Context r0 = r3.getContext()
        L_0x0004:
            boolean r1 = r0 instanceof android.app.Activity
            if (r1 != 0) goto L_0x0013
            boolean r2 = r0 instanceof android.content.ContextWrapper
            if (r2 == 0) goto L_0x0013
            android.content.ContextWrapper r0 = (android.content.ContextWrapper) r0
            android.content.Context r0 = r0.getBaseContext()
            goto L_0x0004
        L_0x0013:
            if (r1 == 0) goto L_0x0018
            android.app.Activity r0 = (android.app.Activity) r0
            return r0
        L_0x0018:
            com.facebook.FacebookException r0 = new com.facebook.FacebookException
            java.lang.String r1 = "Unable to get Activity."
            r0.<init>((java.lang.String) r1)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.share.widget.LikeView.getActivity():android.app.Activity");
    }

    private Bundle getAnalyticsParameters() {
        Bundle bundle = new Bundle();
        bundle.putString("style", this.likeViewStyle.toString());
        bundle.putString(AnalyticsEvents.PARAMETER_LIKE_VIEW_AUXILIARY_POSITION, this.auxiliaryViewPosition.toString());
        bundle.putString(AnalyticsEvents.PARAMETER_LIKE_VIEW_HORIZONTAL_ALIGNMENT, this.horizontalAlignment.toString());
        bundle.putString("object_id", Utility.coerceValueIfNullOrEmpty(this.objectId, ""));
        bundle.putString("object_type", this.objectType.toString());
        return bundle;
    }

    private void initialize(Context context) {
        this.edgePadding = getResources().getDimensionPixelSize(R.dimen.com_facebook_likeview_edge_padding);
        this.internalPadding = getResources().getDimensionPixelSize(R.dimen.com_facebook_likeview_internal_padding);
        if (this.foregroundColor == -1) {
            this.foregroundColor = getResources().getColor(R.color.com_facebook_likeview_text_color);
        }
        setBackgroundColor(0);
        this.containerView = new LinearLayout(context);
        this.containerView.setLayoutParams(new FrameLayout.LayoutParams(-2, -2));
        initializeLikeButton(context);
        initializeSocialSentenceView(context);
        initializeLikeCountView(context);
        this.containerView.addView(this.likeButton);
        this.containerView.addView(this.socialSentenceView);
        this.containerView.addView(this.likeBoxCountView);
        addView(this.containerView);
        setObjectIdAndTypeForced(this.objectId, this.objectType);
        updateLikeStateAndLayout();
    }

    private void initializeLikeButton(Context context) {
        LikeActionController likeActionController2 = this.likeActionController;
        LikeButton likeButton2 = new LikeButton(context, likeActionController2 != null && likeActionController2.isObjectLiked());
        this.likeButton = likeButton2;
        likeButton2.setOnClickListener(new View.OnClickListener() {
            @SensorsDataInstrumented
            public void onClick(View view) {
                LikeView.this.toggleLike();
                SensorsDataAutoTrackHelper.trackViewOnClick(view);
            }
        });
        this.likeButton.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
    }

    private void initializeLikeCountView(Context context) {
        this.likeBoxCountView = new LikeBoxCountView(context);
        this.likeBoxCountView.setLayoutParams(new LinearLayout.LayoutParams(-1, -1));
    }

    private void initializeSocialSentenceView(Context context) {
        TextView textView = new TextView(context);
        this.socialSentenceView = textView;
        textView.setTextSize(0, getResources().getDimension(R.dimen.com_facebook_likeview_text_size));
        this.socialSentenceView.setMaxLines(2);
        this.socialSentenceView.setTextColor(this.foregroundColor);
        this.socialSentenceView.setGravity(17);
        this.socialSentenceView.setLayoutParams(new LinearLayout.LayoutParams(-2, -1));
    }

    private void parseAttributes(AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes;
        if (attributeSet != null && getContext() != null && (obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R.styleable.com_facebook_like_view)) != null) {
            this.objectId = Utility.coerceValueIfNullOrEmpty(obtainStyledAttributes.getString(R.styleable.com_facebook_like_view_com_facebook_object_id), (String) null);
            this.objectType = ObjectType.fromInt(obtainStyledAttributes.getInt(R.styleable.com_facebook_like_view_com_facebook_object_type, ObjectType.DEFAULT.getValue()));
            Style fromInt = Style.fromInt(obtainStyledAttributes.getInt(R.styleable.com_facebook_like_view_com_facebook_style, Style.DEFAULT.getValue()));
            this.likeViewStyle = fromInt;
            if (fromInt != null) {
                AuxiliaryViewPosition fromInt2 = AuxiliaryViewPosition.fromInt(obtainStyledAttributes.getInt(R.styleable.com_facebook_like_view_com_facebook_auxiliary_view_position, AuxiliaryViewPosition.DEFAULT.getValue()));
                this.auxiliaryViewPosition = fromInt2;
                if (fromInt2 != null) {
                    HorizontalAlignment fromInt3 = HorizontalAlignment.fromInt(obtainStyledAttributes.getInt(R.styleable.com_facebook_like_view_com_facebook_horizontal_alignment, HorizontalAlignment.DEFAULT.getValue()));
                    this.horizontalAlignment = fromInt3;
                    if (fromInt3 != null) {
                        this.foregroundColor = obtainStyledAttributes.getColor(R.styleable.com_facebook_like_view_com_facebook_foreground_color, -1);
                        obtainStyledAttributes.recycle();
                        return;
                    }
                    throw new IllegalArgumentException("Unsupported value for LikeView 'horizontal_alignment'");
                }
                throw new IllegalArgumentException("Unsupported value for LikeView 'auxiliary_view_position'");
            }
            throw new IllegalArgumentException("Unsupported value for LikeView 'style'");
        }
    }

    /* access modifiers changed from: private */
    public void setObjectIdAndTypeForced(String str, ObjectType objectType2) {
        tearDownObjectAssociations();
        this.objectId = str;
        this.objectType = objectType2;
        if (!Utility.isNullOrEmpty(str)) {
            this.creationCallback = new LikeActionControllerCreationCallback();
            if (!isInEditMode()) {
                LikeActionController.getControllerForObjectId(str, objectType2, this.creationCallback);
            }
        }
    }

    private void tearDownObjectAssociations() {
        if (this.broadcastReceiver != null) {
            a.b(getContext()).e(this.broadcastReceiver);
            this.broadcastReceiver = null;
        }
        LikeActionControllerCreationCallback likeActionControllerCreationCallback = this.creationCallback;
        if (likeActionControllerCreationCallback != null) {
            likeActionControllerCreationCallback.cancel();
            this.creationCallback = null;
        }
        this.likeActionController = null;
    }

    /* access modifiers changed from: private */
    public void toggleLike() {
        if (this.likeActionController != null) {
            Activity activity = null;
            if (this.parentFragment == null) {
                activity = getActivity();
            }
            this.likeActionController.toggleLike(activity, this.parentFragment, getAnalyticsParameters());
        }
    }

    private void updateBoxCountCaretPosition() {
        int i11 = AnonymousClass2.$SwitchMap$com$facebook$share$widget$LikeView$AuxiliaryViewPosition[this.auxiliaryViewPosition.ordinal()];
        if (i11 == 1) {
            this.likeBoxCountView.setCaretPosition(LikeBoxCountView.LikeBoxCountViewCaretPosition.BOTTOM);
        } else if (i11 == 2) {
            this.likeBoxCountView.setCaretPosition(LikeBoxCountView.LikeBoxCountViewCaretPosition.TOP);
        } else if (i11 == 3) {
            this.likeBoxCountView.setCaretPosition(this.horizontalAlignment == HorizontalAlignment.RIGHT ? LikeBoxCountView.LikeBoxCountViewCaretPosition.RIGHT : LikeBoxCountView.LikeBoxCountViewCaretPosition.LEFT);
        }
    }

    private void updateLayout() {
        View view;
        LikeActionController likeActionController2;
        LikeActionController likeActionController3;
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.containerView.getLayoutParams();
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.likeButton.getLayoutParams();
        HorizontalAlignment horizontalAlignment2 = this.horizontalAlignment;
        int i11 = horizontalAlignment2 == HorizontalAlignment.LEFT ? 3 : horizontalAlignment2 == HorizontalAlignment.CENTER ? 1 : 5;
        layoutParams.gravity = i11 | 48;
        layoutParams2.gravity = i11;
        this.socialSentenceView.setVisibility(8);
        this.likeBoxCountView.setVisibility(8);
        if (this.likeViewStyle == Style.STANDARD && (likeActionController3 = this.likeActionController) != null && !Utility.isNullOrEmpty(likeActionController3.getSocialSentence())) {
            view = this.socialSentenceView;
        } else if (this.likeViewStyle == Style.BOX_COUNT && (likeActionController2 = this.likeActionController) != null && !Utility.isNullOrEmpty(likeActionController2.getLikeCountString())) {
            updateBoxCountCaretPosition();
            view = this.likeBoxCountView;
        } else {
            return;
        }
        int i12 = 0;
        view.setVisibility(0);
        ((LinearLayout.LayoutParams) view.getLayoutParams()).gravity = i11;
        LinearLayout linearLayout = this.containerView;
        AuxiliaryViewPosition auxiliaryViewPosition2 = this.auxiliaryViewPosition;
        AuxiliaryViewPosition auxiliaryViewPosition3 = AuxiliaryViewPosition.INLINE;
        if (auxiliaryViewPosition2 != auxiliaryViewPosition3) {
            i12 = 1;
        }
        linearLayout.setOrientation(i12);
        AuxiliaryViewPosition auxiliaryViewPosition4 = this.auxiliaryViewPosition;
        if (auxiliaryViewPosition4 == AuxiliaryViewPosition.TOP || (auxiliaryViewPosition4 == auxiliaryViewPosition3 && this.horizontalAlignment == HorizontalAlignment.RIGHT)) {
            this.containerView.removeView(this.likeButton);
            this.containerView.addView(this.likeButton);
        } else {
            this.containerView.removeView(view);
            this.containerView.addView(view);
        }
        int i13 = AnonymousClass2.$SwitchMap$com$facebook$share$widget$LikeView$AuxiliaryViewPosition[this.auxiliaryViewPosition.ordinal()];
        if (i13 == 1) {
            int i14 = this.edgePadding;
            view.setPadding(i14, i14, i14, this.internalPadding);
        } else if (i13 == 2) {
            int i15 = this.edgePadding;
            view.setPadding(i15, this.internalPadding, i15, i15);
        } else if (i13 == 3) {
            if (this.horizontalAlignment == HorizontalAlignment.RIGHT) {
                int i16 = this.edgePadding;
                view.setPadding(i16, i16, this.internalPadding, i16);
                return;
            }
            int i17 = this.internalPadding;
            int i18 = this.edgePadding;
            view.setPadding(i17, i18, i18, i18);
        }
    }

    /* access modifiers changed from: private */
    public void updateLikeStateAndLayout() {
        boolean z11 = !this.explicitlyDisabled;
        LikeActionController likeActionController2 = this.likeActionController;
        if (likeActionController2 == null) {
            this.likeButton.setSelected(false);
            this.socialSentenceView.setText((CharSequence) null);
            this.likeBoxCountView.setText((String) null);
        } else {
            this.likeButton.setSelected(likeActionController2.isObjectLiked());
            this.socialSentenceView.setText(this.likeActionController.getSocialSentence());
            this.likeBoxCountView.setText(this.likeActionController.getLikeCountString());
            z11 &= this.likeActionController.shouldEnableView();
        }
        super.setEnabled(z11);
        this.likeButton.setEnabled(z11);
        updateLayout();
    }

    @Deprecated
    public OnErrorListener getOnErrorListener() {
        return this.onErrorListener;
    }

    public void onDetachedFromWindow() {
        setObjectIdAndType((String) null, ObjectType.UNKNOWN);
        super.onDetachedFromWindow();
    }

    @Deprecated
    public void setAuxiliaryViewPosition(AuxiliaryViewPosition auxiliaryViewPosition2) {
        if (auxiliaryViewPosition2 == null) {
            auxiliaryViewPosition2 = AuxiliaryViewPosition.DEFAULT;
        }
        if (this.auxiliaryViewPosition != auxiliaryViewPosition2) {
            this.auxiliaryViewPosition = auxiliaryViewPosition2;
            updateLayout();
        }
    }

    @Deprecated
    public void setEnabled(boolean z11) {
        this.explicitlyDisabled = true;
        updateLikeStateAndLayout();
    }

    @Deprecated
    public void setForegroundColor(int i11) {
        if (this.foregroundColor != i11) {
            this.socialSentenceView.setTextColor(i11);
        }
    }

    @Deprecated
    public void setFragment(Fragment fragment) {
        this.parentFragment = new FragmentWrapper(fragment);
    }

    @Deprecated
    public void setHorizontalAlignment(HorizontalAlignment horizontalAlignment2) {
        if (horizontalAlignment2 == null) {
            horizontalAlignment2 = HorizontalAlignment.DEFAULT;
        }
        if (this.horizontalAlignment != horizontalAlignment2) {
            this.horizontalAlignment = horizontalAlignment2;
            updateLayout();
        }
    }

    @Deprecated
    public void setLikeViewStyle(Style style) {
        if (style == null) {
            style = Style.DEFAULT;
        }
        if (this.likeViewStyle != style) {
            this.likeViewStyle = style;
            updateLayout();
        }
    }

    @Deprecated
    public void setObjectIdAndType(String str, ObjectType objectType2) {
        String coerceValueIfNullOrEmpty = Utility.coerceValueIfNullOrEmpty(str, (String) null);
        if (objectType2 == null) {
            objectType2 = ObjectType.DEFAULT;
        }
        if (!Utility.areObjectsEqual(coerceValueIfNullOrEmpty, this.objectId) || objectType2 != this.objectType) {
            setObjectIdAndTypeForced(coerceValueIfNullOrEmpty, objectType2);
            updateLikeStateAndLayout();
        }
    }

    @Deprecated
    public void setOnErrorListener(OnErrorListener onErrorListener2) {
        this.onErrorListener = onErrorListener2;
    }

    @Deprecated
    public void setFragment(android.app.Fragment fragment) {
        this.parentFragment = new FragmentWrapper(fragment);
    }

    @Deprecated
    public LikeView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        parseAttributes(attributeSet);
        initialize(context);
    }
}
