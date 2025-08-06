package com.tencent.qcloud.tuikit.tuichat.component.popmenu;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.TextView;
import androidx.core.content.res.ResourcesCompat;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import com.tencent.qcloud.tuicore.util.ScreenUtil;
import com.tencent.qcloud.tuikit.tuichat.R;
import com.tencent.qcloud.tuikit.tuichat.classicui.interfaces.ChatPopMenuAction;
import com.tencent.qcloud.tuikit.tuichat.classicui.widget.message.MessageRecyclerView;
import java.util.ArrayList;
import java.util.List;

public class ChatPopMenu {
    private static final int Y_OFFSET = 10;
    private final MenuAdapter adapter;
    public int backGroundColor;
    public int bgRadius = 0;
    /* access modifiers changed from: private */
    public ChatPopMenu chatPopMenu;
    /* access modifiers changed from: private */
    public final List<ChatPopMenuAction> chatPopMenuActionList = new ArrayList();
    private int columnNum;
    /* access modifiers changed from: private */
    public final Context context;
    /* access modifiers changed from: private */
    public MessageRecyclerView.OnEmptySpaceClickListener mEmptySpaceClickListener;
    private View popupView;
    private final PopupWindow popupWindow;
    private RecyclerView recyclerView;
    public int shadowColor;
    private int shadowWidth = 10;

    public static class GridDecoration extends RecyclerView.ItemDecoration {
        private final int columnNum;
        private final Drawable divider;
        private final int leftRightSpace;
        private final int topBottomSpace;

        public GridDecoration(Drawable drawable, int i11, int i12, int i13) {
            this.divider = drawable;
            this.columnNum = i11;
            this.leftRightSpace = i12;
            this.topBottomSpace = i13;
        }

        public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.State state) {
            int childAdapterPosition = recyclerView.getChildAdapterPosition(view);
            int i11 = this.columnNum;
            int i12 = childAdapterPosition % i11;
            int i13 = this.leftRightSpace;
            rect.left = (i12 * i13) / i11;
            rect.right = i13 - (((i12 + 1) * i13) / i11);
            if (childAdapterPosition >= i11) {
                rect.top = this.topBottomSpace;
            }
        }

        public void onDraw(Canvas canvas, RecyclerView recyclerView, RecyclerView.State state) {
            canvas.save();
            int ceil = ((int) Math.ceil((double) ((((float) recyclerView.getChildCount()) * 1.0f) / ((float) this.columnNum)))) - 1;
            for (int i11 = 0; i11 < ceil; i11++) {
                View childAt = recyclerView.getChildAt(this.columnNum * i11);
                int i12 = this.columnNum;
                View childAt2 = recyclerView.getChildAt((i11 * i12) + (i12 - 1));
                int bottom = childAt.getBottom();
                this.divider.setBounds(childAt.getLeft(), (bottom - this.divider.getIntrinsicHeight()) + (this.topBottomSpace / 2), childAt2.getRight(), bottom + (this.topBottomSpace / 2));
                this.divider.draw(canvas);
            }
            canvas.restore();
        }
    }

    public class MenuAdapter extends RecyclerView.Adapter<MenuItemViewHolder> {

        public class MenuItemViewHolder extends RecyclerView.ViewHolder {
            public ImageView icon;
            public TextView title;

            public MenuItemViewHolder(View view) {
                super(view);
                this.title = (TextView) view.findViewById(R.id.menu_title);
                this.icon = (ImageView) view.findViewById(R.id.menu_icon);
            }
        }

        public MenuAdapter() {
        }

        public int getItemCount() {
            return ChatPopMenu.this.chatPopMenuActionList.size();
        }

        public void onBindViewHolder(MenuItemViewHolder menuItemViewHolder, int i11) {
            final ChatPopMenuAction access$100 = ChatPopMenu.this.getChatPopMenuAction(i11);
            menuItemViewHolder.title.setText(access$100.actionName);
            menuItemViewHolder.icon.setImageDrawable(ResourcesCompat.f(ChatPopMenu.this.context.getResources(), access$100.actionIcon, (Resources.Theme) null));
            int i12 = access$100.backGroundColor;
            if (i12 != 0) {
                menuItemViewHolder.itemView.setBackgroundColor(i12);
            }
            if (access$100.textColor != Integer.MAX_VALUE) {
                TextView textView = menuItemViewHolder.title;
                textView.setTextColor(textView.getContext().getResources().getColor(access$100.textColor));
            }
            menuItemViewHolder.itemView.setOnClickListener(new View.OnClickListener() {
                @SensorsDataInstrumented
                public void onClick(View view) {
                    access$100.actionClickListener.onClick();
                    ChatPopMenu.this.chatPopMenu.hide();
                    if (ChatPopMenu.this.mEmptySpaceClickListener != null) {
                        ChatPopMenu.this.mEmptySpaceClickListener.onClick();
                    }
                    SensorsDataAutoTrackHelper.trackViewOnClick(view);
                }
            });
        }

        public MenuItemViewHolder onCreateViewHolder(ViewGroup viewGroup, int i11) {
            return new MenuItemViewHolder(LayoutInflater.from(ChatPopMenu.this.context).inflate(R.layout.chat_pop_menu_item_layout, (ViewGroup) null));
        }
    }

    public ChatPopMenu(Context context2, List<ChatPopMenuAction> list) {
        int size = list.size();
        this.columnNum = size;
        if (size < 1) {
            this.columnNum = 1;
        }
        this.chatPopMenu = this;
        this.context = context2;
        View inflate = LayoutInflater.from(context2).inflate(R.layout.chat_pop_menu_layout, (ViewGroup) null);
        this.popupView = inflate;
        this.recyclerView = (RecyclerView) inflate.findViewById(R.id.chat_pop_menu_content_view);
        this.recyclerView.setLayoutManager(new GridLayoutManager(context2, this.columnNum));
        MenuAdapter menuAdapter = new MenuAdapter();
        this.adapter = menuAdapter;
        this.recyclerView.setAdapter(menuAdapter);
        int dimensionPixelSize = context2.getResources().getDimensionPixelSize(R.dimen.chat_pop_menu_item_space_width);
        int dimensionPixelSize2 = context2.getResources().getDimensionPixelSize(R.dimen.chat_pop_menu_item_space_height);
        this.recyclerView.addItemDecoration(new GridDecoration(context2.getResources().getDrawable(R.drawable.chat_pop_menu_divider), this.columnNum, dimensionPixelSize, dimensionPixelSize2));
        PopupWindow popupWindow2 = new PopupWindow(this.popupView, -2, -2, false);
        this.popupWindow = popupWindow2;
        popupWindow2.setBackgroundDrawable(new ColorDrawable());
        popupWindow2.setTouchable(true);
        popupWindow2.setOutsideTouchable(true);
    }

    /* access modifiers changed from: private */
    public ChatPopMenuAction getChatPopMenuAction(int i11) {
        return this.chatPopMenuActionList.get(i11);
    }

    public Drawable getBackgroundDrawable(float f11, float f12, float f13, float f14, boolean z11, float f15) {
        final int i11 = this.shadowWidth;
        final Path path = new Path();
        final boolean z12 = z11;
        final float f16 = f14;
        final float f17 = f11;
        final float f18 = f12;
        final float f19 = f15;
        final float f21 = f13;
        return new Drawable() {
            public void draw(Canvas canvas) {
                Paint paint = new Paint();
                ChatPopMenu chatPopMenu = ChatPopMenu.this;
                if (chatPopMenu.backGroundColor != 0) {
                    paint.setColor(chatPopMenu.context.getResources().getColor(ChatPopMenu.this.backGroundColor));
                } else {
                    paint.setColor(chatPopMenu.context.getResources().getColor(R.color.black_tips_backgound_color));
                }
                paint.setStyle(Paint.Style.FILL);
                ChatPopMenu chatPopMenu2 = ChatPopMenu.this;
                if (chatPopMenu2.shadowColor != 0) {
                    paint.setShadowLayer((float) i11, 0.0f, 0.0f, chatPopMenu2.context.getResources().getColor(ChatPopMenu.this.shadowColor));
                } else {
                    paint.setShadowLayer((float) i11, 0.0f, 0.0f, -5592406);
                }
                if (z12) {
                    Path path = path;
                    int i11 = i11;
                    float f11 = f16;
                    RectF rectF = new RectF((float) i11, ((float) i11) + f11, f17 - ((float) i11), (f18 + f11) - ((float) i11));
                    float f12 = f19;
                    path.addRoundRect(rectF, f12, f12, Path.Direction.CW);
                    Path path2 = path;
                    float f13 = f21;
                    float f14 = f16;
                    path2.moveTo(f13 - f14, f14 + ((float) i11));
                    path.lineTo(f21, (float) i11);
                    Path path3 = path;
                    float f15 = f21;
                    float f16 = f16;
                    path3.lineTo(f15 + f16, f16 + ((float) i11));
                } else {
                    Path path4 = path;
                    int i12 = i11;
                    RectF rectF2 = new RectF((float) i12, (float) i12, f17 - ((float) i12), f18 - ((float) i12));
                    float f17 = f19;
                    path4.addRoundRect(rectF2, f17, f17, Path.Direction.CW);
                    path.moveTo(f21 - f16, f18 - ((float) i11));
                    path.lineTo(f21, (f18 + f16) - ((float) i11));
                    path.lineTo(f21 + f16, f18 - ((float) i11));
                }
                path.close();
                canvas.drawPath(path, paint);
            }

            public int getOpacity() {
                return -3;
            }

            public void setAlpha(int i11) {
            }

            public void setColorFilter(ColorFilter colorFilter) {
            }
        };
    }

    public void hide() {
        PopupWindow popupWindow2 = this.popupWindow;
        if (popupWindow2 != null && popupWindow2.isShowing()) {
            this.popupWindow.dismiss();
        }
    }

    public void setChatPopMenuActionList(List<ChatPopMenuAction> list) {
        this.chatPopMenuActionList.clear();
        this.chatPopMenuActionList.addAll(list);
        this.adapter.notifyDataSetChanged();
    }

    public void setEmptySpaceClickListener(MessageRecyclerView.OnEmptySpaceClickListener onEmptySpaceClickListener) {
        this.mEmptySpaceClickListener = onEmptySpaceClickListener;
    }

    public void setShadowWidth(int i11) {
        this.shadowWidth = i11;
    }

    public void show(View view, int i11) {
        float f11;
        View view2 = view;
        if (this.chatPopMenuActionList.size() != 0) {
            float width = (float) view.getWidth();
            float height = (float) view.getHeight();
            int[] iArr = new int[2];
            view2.getLocationOnScreen(iArr);
            int dimensionPixelOffset = this.context.getResources().getDimensionPixelOffset(R.dimen.chat_pop_menu_indicator_height);
            int ceil = (int) Math.ceil((double) ((((float) this.chatPopMenuActionList.size()) * 1.0f) / ((float) this.columnNum)));
            if (this.popupWindow != null) {
                int dimensionPixelSize = this.context.getResources().getDimensionPixelSize(R.dimen.chat_pop_menu_item_space_width);
                int dimensionPixelSize2 = this.context.getResources().getDimensionPixelSize(R.dimen.chat_pop_menu_item_space_height);
                int dip2px = ScreenUtil.dip2px(36.72f);
                int dip2px2 = ScreenUtil.dip2px(36.72f);
                int dip2px3 = ScreenUtil.dip2px(18.0f);
                int dip2px4 = ScreenUtil.dip2px(18.0f);
                int min = Math.min(this.chatPopMenuActionList.size(), this.columnNum);
                int i12 = (dip2px * min) + (dip2px3 * 2) + ((min - 1) * dimensionPixelSize);
                int i13 = this.shadowWidth;
                int i14 = i12 - i13;
                int i15 = (((dip2px2 * ceil) + (dip2px4 * 2)) + ((ceil - 1) * dimensionPixelSize2)) - i13;
                float f12 = width / 2.0f;
                int screenWidth = ScreenUtil.getScreenWidth(this.context);
                int i16 = iArr[0];
                int i17 = ((iArr[1] - i15) - dimensionPixelOffset) - 10;
                if (((float) (iArr[0] * 2)) + width > ((float) screenWidth)) {
                    float f13 = (float) i14;
                    f12 = f13 - f12;
                    i16 = (int) ((((float) iArr[0]) + width) - f13);
                }
                boolean z11 = i17 <= i11;
                if (z11) {
                    i17 = ((int) (((float) iArr[1]) + height)) + 10;
                    i15 -= dimensionPixelOffset;
                }
                if (f12 > 0.0f) {
                    float f14 = (float) i14;
                    if (f12 <= f14 && f14 >= width) {
                        f11 = f12;
                        this.popupView.setBackground(getBackgroundDrawable((float) i14, (float) i15, f11, (float) dimensionPixelOffset, z11, (float) this.bgRadius));
                        this.popupWindow.showAtLocation(view2, 0, i16, i17);
                    }
                }
                f11 = (((float) i14) * 1.0f) / 2.0f;
                this.popupView.setBackground(getBackgroundDrawable((float) i14, (float) i15, f11, (float) dimensionPixelOffset, z11, (float) this.bgRadius));
                this.popupWindow.showAtLocation(view2, 0, i16, i17);
            }
        }
    }
}
