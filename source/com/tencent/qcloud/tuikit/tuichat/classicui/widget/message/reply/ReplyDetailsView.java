package com.tencent.qcloud.tuikit.tuichat.classicui.widget.message.reply;

import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.qcloud.tuicore.TUIConstants;
import com.tencent.qcloud.tuicore.TUICore;
import com.tencent.qcloud.tuikit.timcommon.bean.MessageRepliesBean;
import com.tencent.qcloud.tuikit.timcommon.bean.TUIMessageBean;
import com.tencent.qcloud.tuikit.timcommon.component.face.FaceManager;
import com.tencent.qcloud.tuikit.timcommon.component.gatherimage.UserIconView;
import com.tencent.qcloud.tuikit.timcommon.util.DateTimeUtil;
import com.tencent.qcloud.tuikit.tuichat.R;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class ReplyDetailsView extends RecyclerView {
    private Activity activity;
    private ReplyDetailsAdapter adapter;
    private LinearLayoutManager layoutManager;
    /* access modifiers changed from: private */
    public FrameLayout translationContentFrameLayout;

    public class ReplyDetailsAdapter extends RecyclerView.Adapter<ReplyDetailsViewHolder> {
        public Map<MessageRepliesBean.ReplyBean, TUIMessageBean> data;

        public ReplyDetailsAdapter() {
        }

        public int getItemCount() {
            Map<MessageRepliesBean.ReplyBean, TUIMessageBean> map = this.data;
            if (map == null) {
                return 0;
            }
            return map.size();
        }

        public void setData(Map<MessageRepliesBean.ReplyBean, TUIMessageBean> map) {
            this.data = map;
        }

        public void onBindViewHolder(ReplyDetailsViewHolder replyDetailsViewHolder, int i11) {
            String str;
            String str2;
            MessageRepliesBean.ReplyBean replyBean = (MessageRepliesBean.ReplyBean) new ArrayList(this.data.keySet()).get(i11);
            TUIMessageBean tUIMessageBean = this.data.get(replyBean);
            ArrayList arrayList = new ArrayList();
            if (tUIMessageBean == null) {
                str2 = replyBean.getSenderShowName();
                str = replyBean.getMessageAbstract();
                arrayList.add(replyBean.getSenderFaceUrl());
            } else {
                str = tUIMessageBean.getExtra();
                str2 = tUIMessageBean.getUserDisplayName();
                arrayList.add(tUIMessageBean.getFaceUrl());
                replyDetailsViewHolder.timeText.setText(DateTimeUtil.getTimeFormatText(new Date(tUIMessageBean.getMessageTime() * 1000)));
            }
            replyDetailsViewHolder.userFaceView.setIconUrls(arrayList);
            replyDetailsViewHolder.userNameTv.setText(str2);
            FaceManager.handlerEmojiText(replyDetailsViewHolder.messageText, str, false);
            ReplyDetailsView.this.setTranslationContent(tUIMessageBean);
        }

        public ReplyDetailsViewHolder onCreateViewHolder(ViewGroup viewGroup, int i11) {
            View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.chat_reply_details_item_layout, viewGroup, false);
            FrameLayout unused = ReplyDetailsView.this.translationContentFrameLayout = (FrameLayout) inflate.findViewById(R.id.translate_content_fl);
            return new ReplyDetailsViewHolder(inflate);
        }
    }

    public static class ReplyDetailsViewHolder extends RecyclerView.ViewHolder {
        public TextView messageText;
        public TextView timeText;
        public UserIconView userFaceView;
        public TextView userNameTv;

        public ReplyDetailsViewHolder(View view) {
            super(view);
            this.userFaceView = (UserIconView) view.findViewById(R.id.user_icon);
            this.userNameTv = (TextView) view.findViewById(R.id.user_name_tv);
            this.messageText = (TextView) view.findViewById(R.id.msg_abstract);
            this.timeText = (TextView) view.findViewById(R.id.msg_time);
        }
    }

    public ReplyDetailsView(Context context) {
        super(context);
        initView();
    }

    private void initView() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        this.layoutManager = linearLayoutManager;
        setLayoutManager(linearLayoutManager);
        ReplyDetailsAdapter replyDetailsAdapter = new ReplyDetailsAdapter();
        this.adapter = replyDetailsAdapter;
        setAdapter(replyDetailsAdapter);
    }

    /* access modifiers changed from: private */
    public void setTranslationContent(TUIMessageBean tUIMessageBean) {
        HashMap hashMap = new HashMap();
        hashMap.put("messageBean", tUIMessageBean);
        hashMap.put(TUIConstants.TUIChat.CHAT_RECYCLER_VIEW, this);
        TUICore.raiseExtension(TUIConstants.TUITranslation.Extension.TranslationView.CLASSIC_EXTENSION_ID, this.translationContentFrameLayout, hashMap);
    }

    public void setActivity(Activity activity2) {
        this.activity = activity2;
    }

    public void setData(Map<MessageRepliesBean.ReplyBean, TUIMessageBean> map) {
        this.adapter.setData(map);
        this.adapter.notifyDataSetChanged();
    }

    public ReplyDetailsView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        initView();
    }

    public ReplyDetailsView(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        initView();
    }
}
