package com.tencent.qcloud.tuikit.tuibarrage.view.adapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.text.style.ImageSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.imsdk.common.IMLog;
import com.tencent.qcloud.tuicore.util.ScreenUtil;
import com.tencent.qcloud.tuikit.tuibarrage.R;
import com.xiaomi.mipush.sdk.Constants;
import java.util.HashMap;
import java.util.List;

public class TUIBarrageMsgListAdapter extends RecyclerView.Adapter<ViewHolder> {
    private static final String TAG = "TUIBarrageMsgListAdapter";
    /* access modifiers changed from: private */
    public int[] avatarDrawables = {R.drawable.group0, R.drawable.group1, R.drawable.group2, R.drawable.group3, R.drawable.group4, R.drawable.group5, R.drawable.group6, R.drawable.group7, R.drawable.group8, R.drawable.group9, R.drawable.group10, R.drawable.group11};
    /* access modifiers changed from: private */
    public HashMap<Integer, Bitmap> bitmaps = new HashMap<>();
    /* access modifiers changed from: private */
    public Context mContext;
    private List<TUIBarrageMsgEntity> mMsgEntityList;
    private OnItemClickListener mOnItemClickListener;

    public interface OnItemClickListener {
        void onAgreeClick(int i11);
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView mBtnMsgAgree;
        private TextView mTvMsgContent;

        public class CenterImageSpan extends ImageSpan {
            public CenterImageSpan(Context context, Bitmap bitmap) {
                super(context, bitmap);
            }

            public void draw(Canvas canvas, CharSequence charSequence, int i11, int i12, float f11, int i13, int i14, int i15, Paint paint) {
                Drawable drawable = getDrawable();
                Paint.FontMetricsInt fontMetricsInt = paint.getFontMetricsInt();
                canvas.save();
                canvas.translate(f11, (float) (((((fontMetricsInt.descent + i14) + i14) + fontMetricsInt.ascent) / 2) - (drawable.getBounds().bottom / 2)));
                drawable.draw(canvas);
                canvas.restore();
            }
        }

        public ViewHolder(View view) {
            super(view);
            initView(view);
        }

        private void initView(View view) {
            this.mTvMsgContent = (TextView) view.findViewById(R.id.tv_msg_content);
            this.mBtnMsgAgree = (TextView) view.findViewById(R.id.btn_msg_agree);
        }

        public void bind(TUIBarrageMsgEntity tUIBarrageMsgEntity, OnItemClickListener onItemClickListener, int i11) {
            String str;
            String str2 = TextUtils.isEmpty(tUIBarrageMsgEntity.userName) ? tUIBarrageMsgEntity.userId : tUIBarrageMsgEntity.userName;
            if (i11 == 0) {
                str = str2;
            } else {
                str = "avatar" + " " + str2 + "：" + tUIBarrageMsgEntity.content;
            }
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(str);
            ForegroundColorSpan foregroundColorSpan = new ForegroundColorSpan(this.mTvMsgContent.getContext().getResources().getColor(R.color.tuibarrage_color_blue));
            if (TextUtils.isEmpty(str2)) {
                str2 = "";
            }
            int i12 = i11 == 0 ? 0 : 6;
            int length = str2.length();
            if (i11 != 0) {
                length = length + 1 + 6 + 1;
            }
            spannableStringBuilder.setSpan(foregroundColorSpan, i12, length, 33);
            if (i11 != 0) {
                String str3 = tUIBarrageMsgEntity.userId;
                int abs = !TextUtils.isEmpty(str3) ? Math.abs(str3.hashCode()) : 0;
                int i13 = abs % 12;
                IMLog.d(TUIBarrageMsgListAdapter.TAG, abs + Constants.ACCEPT_TIME_SEPARATOR_SP + i13);
                if (TUIBarrageMsgListAdapter.this.bitmaps.get(Integer.valueOf(i13)) == null) {
                    TUIBarrageMsgListAdapter.this.bitmaps.put(Integer.valueOf(i13), Bitmap.createScaledBitmap(BitmapFactory.decodeResource(TUIBarrageMsgListAdapter.this.mContext.getResources(), TUIBarrageMsgListAdapter.this.avatarDrawables[i13]), ScreenUtil.dip2px(18.0f), ScreenUtil.dip2px(18.0f), false));
                }
                spannableStringBuilder.setSpan(new CenterImageSpan(TUIBarrageMsgListAdapter.this.mContext, (Bitmap) TUIBarrageMsgListAdapter.this.bitmaps.get(Integer.valueOf(i13))), 0, 6, 33);
            }
            this.mTvMsgContent.setText(spannableStringBuilder);
            this.mTvMsgContent.setBackgroundResource(R.drawable.tuibarrage_bg_msg_item);
        }
    }

    public TUIBarrageMsgListAdapter(Context context, List<TUIBarrageMsgEntity> list, OnItemClickListener onItemClickListener) {
        this.mContext = context;
        this.mMsgEntityList = list;
        this.mOnItemClickListener = onItemClickListener;
    }

    public int getItemCount() {
        return this.mMsgEntityList.size();
    }

    public void onBindViewHolder(ViewHolder viewHolder, int i11) {
        viewHolder.bind(this.mMsgEntityList.get(i11), this.mOnItemClickListener, i11);
    }

    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i11) {
        return new ViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.tuibarrage_item_msg, viewGroup, false));
    }
}
