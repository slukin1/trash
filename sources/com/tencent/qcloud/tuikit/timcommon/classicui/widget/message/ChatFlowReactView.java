package com.tencent.qcloud.tuikit.timcommon.classicui.widget.message;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import com.tencent.qcloud.tuicore.TUIThemeManager;
import com.tencent.qcloud.tuikit.timcommon.R;
import com.tencent.qcloud.tuikit.timcommon.bean.MessageReactBean;
import com.tencent.qcloud.tuikit.timcommon.bean.ReactUserBean;
import com.tencent.qcloud.tuikit.timcommon.component.face.FaceManager;
import java.util.ArrayList;
import java.util.Map;
import java.util.Set;

public class ChatFlowReactView extends RecyclerView {
    private ChatFlowReactAdapter adapter;
    private ChatFlowReactLayoutManager layoutManager;
    private int themeColorId;

    public static class ChatFlowReactAdapter extends RecyclerView.Adapter<ChatFlowReactViewHolder> {
        private MessageReactBean data;
        /* access modifiers changed from: private */
        public ReactOnClickListener reactOnClickListener;
        private int themeColorId;

        private String formatDisplayUserName(Set<String> set) {
            StringBuilder sb2 = new StringBuilder();
            int i11 = 0;
            for (String userDisplayName : set) {
                sb2.append(getUserDisplayName(userDisplayName));
                i11++;
                if (i11 != set.size()) {
                    sb2.append("、");
                }
            }
            return sb2.toString();
        }

        private String getUserDisplayName(String str) {
            ReactUserBean reactUserBean;
            if (this.data.getReactUserBeanMap() == null || (reactUserBean = this.data.getReactUserBeanMap().get(str)) == null) {
                return str;
            }
            return reactUserBean.getDisplayString();
        }

        public int getItemCount() {
            MessageReactBean messageReactBean = this.data;
            if (messageReactBean != null) {
                return messageReactBean.getReactSize();
            }
            return 0;
        }

        public void setData(MessageReactBean messageReactBean) {
            this.data = messageReactBean;
        }

        public void setReactOnClickListener(ReactOnClickListener reactOnClickListener2) {
            this.reactOnClickListener = reactOnClickListener2;
        }

        public void setThemeColorId(int i11) {
            this.themeColorId = i11;
        }

        public void onBindViewHolder(ChatFlowReactViewHolder chatFlowReactViewHolder, int i11) {
            Map.Entry entry = (Map.Entry) new ArrayList(this.data.getReacts().entrySet()).get(i11);
            final String str = (String) entry.getKey();
            Set set = (Set) entry.getValue();
            chatFlowReactViewHolder.faceImageView.setImageBitmap(FaceManager.getEmoji(str));
            chatFlowReactViewHolder.faceImageView.setOnClickListener(new View.OnClickListener() {
                @SensorsDataInstrumented
                public void onClick(View view) {
                    if (ChatFlowReactAdapter.this.reactOnClickListener != null) {
                        ChatFlowReactAdapter.this.reactOnClickListener.onClick(str);
                    }
                    SensorsDataAutoTrackHelper.trackViewOnClick(view);
                }
            });
            if (this.themeColorId != 0) {
                TextView textView = chatFlowReactViewHolder.userTextView;
                textView.setTextColor(textView.getResources().getColor(this.themeColorId));
                TextView textView2 = chatFlowReactViewHolder.userTextView;
                textView2.setTextColor(textView2.getResources().getColor(this.themeColorId));
            } else {
                TextView textView3 = chatFlowReactViewHolder.userTextView;
                Resources resources = textView3.getResources();
                Context context = chatFlowReactViewHolder.userTextView.getContext();
                int i12 = R.attr.chat_react_text_color;
                textView3.setTextColor(resources.getColor(TUIThemeManager.getAttrResId(context, i12)));
                TextView textView4 = chatFlowReactViewHolder.userTextView;
                textView4.setTextColor(textView4.getResources().getColor(TUIThemeManager.getAttrResId(chatFlowReactViewHolder.userTextView.getContext(), i12)));
            }
            chatFlowReactViewHolder.userTextView.setText(formatDisplayUserName(set));
        }

        public ChatFlowReactViewHolder onCreateViewHolder(ViewGroup viewGroup, int i11) {
            return new ChatFlowReactViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.chat_flow_react_item_layout, viewGroup, false));
        }
    }

    public static class ChatFlowReactViewHolder extends RecyclerView.ViewHolder {
        public ImageView faceImageView;
        public TextView userTextView;

        public ChatFlowReactViewHolder(View view) {
            super(view);
            this.userTextView = (TextView) view.findViewById(R.id.users_tv);
            this.faceImageView = (ImageView) view.findViewById(R.id.face_iv);
        }
    }

    public interface ReactOnClickListener {
        void onClick(String str);
    }

    public ChatFlowReactView(Context context) {
        super(context);
        initView();
    }

    private void initView() {
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        ChatFlowReactLayoutManager chatFlowReactLayoutManager = new ChatFlowReactLayoutManager(TypedValue.applyDimension(1, 5.76f, displayMetrics), TypedValue.applyDimension(1, 7.68f, displayMetrics));
        this.layoutManager = chatFlowReactLayoutManager;
        setLayoutManager(chatFlowReactLayoutManager);
        ChatFlowReactAdapter chatFlowReactAdapter = new ChatFlowReactAdapter();
        this.adapter = chatFlowReactAdapter;
        setAdapter(chatFlowReactAdapter);
    }

    public void setData(MessageReactBean messageReactBean) {
        ChatFlowReactAdapter chatFlowReactAdapter = this.adapter;
        if (chatFlowReactAdapter != null) {
            chatFlowReactAdapter.setData(messageReactBean);
            this.adapter.notifyDataSetChanged();
        }
    }

    public void setReactOnClickListener(ReactOnClickListener reactOnClickListener) {
        ChatFlowReactAdapter chatFlowReactAdapter = this.adapter;
        if (chatFlowReactAdapter != null) {
            chatFlowReactAdapter.setReactOnClickListener(reactOnClickListener);
        }
    }

    public void setThemeColorId(int i11) {
        this.themeColorId = i11;
        this.adapter.setThemeColorId(i11);
    }

    public static class ChatFlowReactLayoutManager extends RecyclerView.LayoutManager {
        private int horizontalSpacing = 0;
        private int verticalSpacing = 0;

        public ChatFlowReactLayoutManager() {
        }

        public RecyclerView.LayoutParams generateDefaultLayoutParams() {
            return new RecyclerView.LayoutParams(-2, -2);
        }

        public boolean isAutoMeasureEnabled() {
            return true;
        }

        public void onLayoutChildren(RecyclerView.Recycler recycler, RecyclerView.State state) {
            int i11;
            boolean z11;
            int i12;
            int i13;
            detachAndScrapAttachedViews(recycler);
            int itemCount = getItemCount();
            if (itemCount != 0) {
                int paddingStart = getPaddingStart();
                boolean z12 = true;
                boolean z13 = true;
                int i14 = 0;
                int i15 = 0;
                int i16 = 0;
                while (i16 < itemCount) {
                    View o11 = recycler.o(i16);
                    addView(o11);
                    measureChildWithMargins(o11, 0, 0);
                    int decoratedMeasuredWidth = getDecoratedMeasuredWidth(o11);
                    int decoratedMeasuredHeight = getDecoratedMeasuredHeight(o11);
                    if (i16 == 0 || this.horizontalSpacing + paddingStart + decoratedMeasuredWidth <= (getWidth() - getPaddingStart()) - getPaddingEnd()) {
                        z11 = z13;
                        i11 = i15;
                    } else {
                        i11 = i14;
                        z12 = true;
                        z11 = false;
                    }
                    if (z12) {
                        i12 = getPaddingStart();
                    } else {
                        i12 = paddingStart + this.horizontalSpacing;
                    }
                    int i17 = i12;
                    if (z11) {
                        i13 = getPaddingTop();
                    } else {
                        i13 = this.verticalSpacing + i11;
                    }
                    int i18 = i13;
                    int i19 = decoratedMeasuredWidth + i17;
                    int i21 = decoratedMeasuredHeight + i18;
                    int max = Math.max(i14, i21);
                    layoutDecoratedWithMargins(o11, i17, i18, i19, i21);
                    i16++;
                    z12 = false;
                    paddingStart = i19;
                    z13 = z11;
                    i15 = i11;
                    i14 = max;
                }
            }
        }

        public ChatFlowReactLayoutManager(float f11, float f12) {
            this.verticalSpacing = Math.round(f12);
            this.horizontalSpacing = Math.round(f11);
        }
    }

    public ChatFlowReactView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        initView();
    }

    public ChatFlowReactView(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        initView();
    }
}
