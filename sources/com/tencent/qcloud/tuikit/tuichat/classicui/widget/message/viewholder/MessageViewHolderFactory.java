package com.tencent.qcloud.tuikit.tuichat.classicui.widget.message.viewholder;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.qcloud.tuikit.timcommon.classicui.widget.message.MessageBaseHolder;
import com.tencent.qcloud.tuikit.timcommon.interfaces.ICommonMessageAdapter;
import com.tencent.qcloud.tuikit.tuichat.R;
import com.tencent.qcloud.tuikit.tuichat.TUIChatService;
import com.tencent.qcloud.tuikit.tuichat.bean.message.TipsMessageBean;
import java.lang.reflect.InvocationTargetException;

public class MessageViewHolderFactory {
    public static RecyclerView.ViewHolder getInstance(ViewGroup viewGroup, ICommonMessageAdapter iCommonMessageAdapter, int i11) {
        RecyclerView.ViewHolder viewHolder;
        LayoutInflater from = LayoutInflater.from(viewGroup.getContext());
        if (i11 == -99) {
            return new MessageHeaderHolder(from.inflate(R.layout.loading_progress_bar, viewGroup, false));
        }
        View inflate = from.inflate(R.layout.message_adapter_item_content, viewGroup, false);
        if (i11 == TUIChatService.getInstance().getViewType(TipsMessageBean.class)) {
            inflate = from.inflate(R.layout.message_adapter_item_empty, viewGroup, false);
            viewHolder = new TipsMessageHolder(inflate);
        } else {
            viewHolder = getViewHolder(inflate, i11);
        }
        if (viewHolder == null) {
            viewHolder = new TextMessageHolder(inflate);
        }
        ((MessageBaseHolder) viewHolder).setAdapter(iCommonMessageAdapter);
        return viewHolder;
    }

    private static RecyclerView.ViewHolder getViewHolder(View view, int i11) {
        Class<? extends MessageBaseHolder> messageViewHolderClass = TUIChatService.getInstance().getMessageViewHolderClass(i11);
        if (messageViewHolderClass == null) {
            return null;
        }
        try {
            return (RecyclerView.ViewHolder) messageViewHolderClass.getConstructor(new Class[]{View.class}).newInstance(new Object[]{view});
        } catch (NoSuchMethodException e11) {
            e11.printStackTrace();
            return null;
        } catch (IllegalAccessException e12) {
            e12.printStackTrace();
            return null;
        } catch (InstantiationException e13) {
            e13.printStackTrace();
            return null;
        } catch (InvocationTargetException e14) {
            e14.printStackTrace();
            return null;
        }
    }
}
