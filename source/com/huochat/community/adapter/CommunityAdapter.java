package com.huochat.community.adapter;

import android.app.Activity;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.huochat.community.CommunityManager;
import com.huochat.community.CommunityThemeColor;
import com.huochat.community.CommunityThemeHelper;
import com.huochat.community.R;
import com.huochat.community.enums.CommunityMenuItems;
import com.huochat.community.enums.SortBtnVisible;
import com.huochat.community.enums.SymbolParamType;
import com.huochat.community.enums.TopDataType;
import com.huochat.community.listener.OnCommentClickListener;
import com.huochat.community.listener.OnCommunityOperationClickListener;
import com.huochat.community.listener.OnCommunitySortClickListener;
import com.huochat.community.model.CommunityItemBean;
import com.huochat.community.model.CommunityResultBean;
import com.huochat.community.model.CommunityTopBean;
import com.huochat.community.model.MomentType;
import com.huochat.community.model.TopicBean;
import com.huochat.community.viewholder.CommunityEmptyHolder;
import com.huochat.community.viewholder.CommunityHolder;
import com.huochat.community.viewholder.CommunityTopHolder;
import com.huochat.community.widget.HotTopicTagFlowView;
import i6.i;
import java.util.LinkedList;
import java.util.List;
import qv.a;

public final class CommunityAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private final int LIST_ITEM_TYPE_DETAIL_VIEW;
    private final int LIST_ITEM_TYPE_NONE_DYNAMIC;
    private final int LIST_ITEM_TYPE_NO_MORE_DATA;
    private final int LIST_ITEM_TYPE_TOP_VIEW;
    private Activity activity;
    private String communityId;
    private List<CommunityItemBean> communityItemBeans;
    private String communityName;
    private String communityParamSymbol;
    private CommunityResultBean communityResultBean;
    private String communitySymbol;
    private CommunityThemeColor communityThemeColor;
    private List<TopicBean> hotTopicList;
    private boolean isShowTopViewItem;
    private CommunityTopBean mCommunityTopBean;
    private int mDefItemViewWidth;
    private boolean mHasDataAnyMore;
    /* access modifiers changed from: private */
    public CommunityHolder mHodler;
    private HotTopicTagFlowView.OnItemClickListener mHotTopicItemClickListener;
    private boolean mIsShowCommunityFromPanel;
    private String mLastBrowerCircleId;
    private LayoutInflater mLayoutInflater;
    private OnCommunitySortClickListener mSortClickListener;
    private String mSymbolId;
    private OnCommentClickListener onCommentClickListenr;
    private OnCommunityOperationClickListener operationClickListener;
    private SymbolParamType symbolParamType;

    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;

        /* JADX WARNING: Can't wrap try/catch for region: R(51:0|(2:1|2)|3|(2:5|6)|7|9|10|11|12|13|14|15|16|17|18|19|20|21|22|23|24|25|26|27|28|29|30|31|32|33|34|35|36|37|38|39|40|41|42|43|44|45|46|47|49|50|51|52|(2:53|54)|55|57) */
        /* JADX WARNING: Can't wrap try/catch for region: R(52:0|(2:1|2)|3|5|6|7|9|10|11|12|13|14|15|16|17|18|19|20|21|22|23|24|25|26|27|28|29|30|31|32|33|34|35|36|37|38|39|40|41|42|43|44|45|46|47|49|50|51|52|(2:53|54)|55|57) */
        /* JADX WARNING: Can't wrap try/catch for region: R(53:0|(2:1|2)|3|5|6|7|9|10|11|12|13|14|15|16|17|18|19|20|21|22|23|24|25|26|27|28|29|30|31|32|33|34|35|36|37|38|39|40|41|42|43|44|45|46|47|49|50|51|52|53|54|55|57) */
        /* JADX WARNING: Can't wrap try/catch for region: R(54:0|1|2|3|5|6|7|9|10|11|12|13|14|15|16|17|18|19|20|21|22|23|24|25|26|27|28|29|30|31|32|33|34|35|36|37|38|39|40|41|42|43|44|45|46|47|49|50|51|52|53|54|55|57) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x0022 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x002b */
        /* JADX WARNING: Missing exception handler attribute for start block: B:15:0x0034 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:17:0x003d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:19:0x0046 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:21:0x0050 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:23:0x005a */
        /* JADX WARNING: Missing exception handler attribute for start block: B:25:0x0064 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:27:0x006e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:29:0x0078 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:31:0x0082 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:33:0x008c */
        /* JADX WARNING: Missing exception handler attribute for start block: B:35:0x0096 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:37:0x00a0 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:39:0x00aa */
        /* JADX WARNING: Missing exception handler attribute for start block: B:41:0x00b4 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:43:0x00be */
        /* JADX WARNING: Missing exception handler attribute for start block: B:45:0x00c8 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:51:0x00e3 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:53:0x00eb */
        static {
            /*
                com.huochat.community.model.MomentType[] r0 = com.huochat.community.model.MomentType.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                r1 = 1
                com.huochat.community.model.MomentType r2 = com.huochat.community.model.MomentType.MOMENT_NONE     // Catch:{ NoSuchFieldError -> 0x0010 }
                int r2 = r2.ordinal()     // Catch:{ NoSuchFieldError -> 0x0010 }
                r0[r2] = r1     // Catch:{ NoSuchFieldError -> 0x0010 }
            L_0x0010:
                r2 = 2
                com.huochat.community.model.MomentType r3 = com.huochat.community.model.MomentType.MOMENT_IMAGE_0     // Catch:{ NoSuchFieldError -> 0x0019 }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x0019 }
                r0[r3] = r2     // Catch:{ NoSuchFieldError -> 0x0019 }
            L_0x0019:
                r3 = 3
                com.huochat.community.model.MomentType r4 = com.huochat.community.model.MomentType.MOMENT_TEXT     // Catch:{ NoSuchFieldError -> 0x0022 }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x0022 }
                r0[r4] = r3     // Catch:{ NoSuchFieldError -> 0x0022 }
            L_0x0022:
                com.huochat.community.model.MomentType r4 = com.huochat.community.model.MomentType.MOMENT_FLASH     // Catch:{ NoSuchFieldError -> 0x002b }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x002b }
                r5 = 4
                r0[r4] = r5     // Catch:{ NoSuchFieldError -> 0x002b }
            L_0x002b:
                com.huochat.community.model.MomentType r4 = com.huochat.community.model.MomentType.MOMENT_IMAGE_1     // Catch:{ NoSuchFieldError -> 0x0034 }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x0034 }
                r5 = 5
                r0[r4] = r5     // Catch:{ NoSuchFieldError -> 0x0034 }
            L_0x0034:
                com.huochat.community.model.MomentType r4 = com.huochat.community.model.MomentType.MOMENT_IMAGE_2     // Catch:{ NoSuchFieldError -> 0x003d }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x003d }
                r5 = 6
                r0[r4] = r5     // Catch:{ NoSuchFieldError -> 0x003d }
            L_0x003d:
                com.huochat.community.model.MomentType r4 = com.huochat.community.model.MomentType.MOMENT_IMAGE_3     // Catch:{ NoSuchFieldError -> 0x0046 }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x0046 }
                r5 = 7
                r0[r4] = r5     // Catch:{ NoSuchFieldError -> 0x0046 }
            L_0x0046:
                com.huochat.community.model.MomentType r4 = com.huochat.community.model.MomentType.MOMENT_IMAGE_4     // Catch:{ NoSuchFieldError -> 0x0050 }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x0050 }
                r5 = 8
                r0[r4] = r5     // Catch:{ NoSuchFieldError -> 0x0050 }
            L_0x0050:
                com.huochat.community.model.MomentType r4 = com.huochat.community.model.MomentType.MOMENT_IMAGE_5     // Catch:{ NoSuchFieldError -> 0x005a }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x005a }
                r5 = 9
                r0[r4] = r5     // Catch:{ NoSuchFieldError -> 0x005a }
            L_0x005a:
                com.huochat.community.model.MomentType r4 = com.huochat.community.model.MomentType.MOMENT_IMAGE_6     // Catch:{ NoSuchFieldError -> 0x0064 }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x0064 }
                r5 = 10
                r0[r4] = r5     // Catch:{ NoSuchFieldError -> 0x0064 }
            L_0x0064:
                com.huochat.community.model.MomentType r4 = com.huochat.community.model.MomentType.MOMENT_IMAGE_7     // Catch:{ NoSuchFieldError -> 0x006e }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x006e }
                r5 = 11
                r0[r4] = r5     // Catch:{ NoSuchFieldError -> 0x006e }
            L_0x006e:
                com.huochat.community.model.MomentType r4 = com.huochat.community.model.MomentType.MOMENT_IMAGE_8     // Catch:{ NoSuchFieldError -> 0x0078 }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x0078 }
                r5 = 12
                r0[r4] = r5     // Catch:{ NoSuchFieldError -> 0x0078 }
            L_0x0078:
                com.huochat.community.model.MomentType r4 = com.huochat.community.model.MomentType.MOMENT_IMAGE_9     // Catch:{ NoSuchFieldError -> 0x0082 }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x0082 }
                r5 = 13
                r0[r4] = r5     // Catch:{ NoSuchFieldError -> 0x0082 }
            L_0x0082:
                com.huochat.community.model.MomentType r4 = com.huochat.community.model.MomentType.MOMENT_NEWS     // Catch:{ NoSuchFieldError -> 0x008c }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x008c }
                r5 = 14
                r0[r4] = r5     // Catch:{ NoSuchFieldError -> 0x008c }
            L_0x008c:
                com.huochat.community.model.MomentType r4 = com.huochat.community.model.MomentType.MOMENT_SCHOOL     // Catch:{ NoSuchFieldError -> 0x0096 }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x0096 }
                r5 = 15
                r0[r4] = r5     // Catch:{ NoSuchFieldError -> 0x0096 }
            L_0x0096:
                com.huochat.community.model.MomentType r4 = com.huochat.community.model.MomentType.MOMENT_CLUB     // Catch:{ NoSuchFieldError -> 0x00a0 }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x00a0 }
                r5 = 16
                r0[r4] = r5     // Catch:{ NoSuchFieldError -> 0x00a0 }
            L_0x00a0:
                com.huochat.community.model.MomentType r4 = com.huochat.community.model.MomentType.MOMENT_EXCHANGE     // Catch:{ NoSuchFieldError -> 0x00aa }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x00aa }
                r5 = 17
                r0[r4] = r5     // Catch:{ NoSuchFieldError -> 0x00aa }
            L_0x00aa:
                com.huochat.community.model.MomentType r4 = com.huochat.community.model.MomentType.MOMENT_PROJECT     // Catch:{ NoSuchFieldError -> 0x00b4 }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x00b4 }
                r5 = 18
                r0[r4] = r5     // Catch:{ NoSuchFieldError -> 0x00b4 }
            L_0x00b4:
                com.huochat.community.model.MomentType r4 = com.huochat.community.model.MomentType.MOMENT_OUT_SHARE_IMAGE     // Catch:{ NoSuchFieldError -> 0x00be }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x00be }
                r5 = 19
                r0[r4] = r5     // Catch:{ NoSuchFieldError -> 0x00be }
            L_0x00be:
                com.huochat.community.model.MomentType r4 = com.huochat.community.model.MomentType.MOMENT_OUT_SHARE_LINK     // Catch:{ NoSuchFieldError -> 0x00c8 }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x00c8 }
                r5 = 20
                r0[r4] = r5     // Catch:{ NoSuchFieldError -> 0x00c8 }
            L_0x00c8:
                com.huochat.community.model.MomentType r4 = com.huochat.community.model.MomentType.MOMENT_CONTENT_LINK     // Catch:{ NoSuchFieldError -> 0x00d2 }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x00d2 }
                r5 = 21
                r0[r4] = r5     // Catch:{ NoSuchFieldError -> 0x00d2 }
            L_0x00d2:
                $EnumSwitchMapping$0 = r0
                com.huochat.community.enums.TopDataType[] r0 = com.huochat.community.enums.TopDataType.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                com.huochat.community.enums.TopDataType r4 = com.huochat.community.enums.TopDataType.TOPIC     // Catch:{ NoSuchFieldError -> 0x00e3 }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x00e3 }
                r0[r4] = r1     // Catch:{ NoSuchFieldError -> 0x00e3 }
            L_0x00e3:
                com.huochat.community.enums.TopDataType r1 = com.huochat.community.enums.TopDataType.NORMAL     // Catch:{ NoSuchFieldError -> 0x00eb }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00eb }
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00eb }
            L_0x00eb:
                com.huochat.community.enums.TopDataType r1 = com.huochat.community.enums.TopDataType.SORT_MENU     // Catch:{ NoSuchFieldError -> 0x00f3 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00f3 }
                r0[r1] = r3     // Catch:{ NoSuchFieldError -> 0x00f3 }
            L_0x00f3:
                $EnumSwitchMapping$1 = r0
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.huochat.community.adapter.CommunityAdapter.WhenMappings.<clinit>():void");
        }
    }

    public CommunityAdapter(Activity activity2, boolean z11) {
        this.mIsShowCommunityFromPanel = true;
        this.communityId = "";
        this.communityName = "";
        this.communitySymbol = "";
        this.mLastBrowerCircleId = "-1";
        this.mHasDataAnyMore = true;
        this.symbolParamType = SymbolParamType.SYMBOL;
        this.LIST_ITEM_TYPE_TOP_VIEW = 4097;
        this.LIST_ITEM_TYPE_DETAIL_VIEW = 4099;
        this.LIST_ITEM_TYPE_NO_MORE_DATA = 4100;
        this.LIST_ITEM_TYPE_NONE_DYNAMIC = 4101;
        this.communityThemeColor = CommunityManager.Companion.getInstance().getCommunityThemeColor();
        this.activity = activity2;
        this.isShowTopViewItem = z11;
        this.communityItemBeans = new LinkedList();
        this.mCommunityTopBean = new CommunityTopBean();
        initInflater();
    }

    private final int getListSize() {
        List<CommunityItemBean> list = this.communityItemBeans;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    private final void initInflater() {
        this.mLayoutInflater = LayoutInflater.from(this.activity).cloneInContext(CommunityThemeHelper.Companion.getThemeContext(this.activity));
    }

    /* access modifiers changed from: private */
    public static final void refreshTopHotTopicList$lambda$7$lambda$6(CommunityAdapter communityAdapter, CommunityTopBean communityTopBean) {
        communityAdapter.notifyItemChanged(0, communityTopBean);
    }

    public final void addDatas(List<CommunityItemBean> list, boolean z11) {
        addDatas(list, z11, true);
    }

    public final void addDatasFirst(List<CommunityItemBean> list) {
        if (list == null || list.isEmpty()) {
            notifyDataSetChanged();
            return;
        }
        this.communityItemBeans.addAll(0, list);
        notifyDataSetChanged();
    }

    public final CommunityItemBean getCommunityBean(int i11) {
        List<CommunityItemBean> list;
        if (i11 >= this.communityItemBeans.size() || (list = this.communityItemBeans) == null) {
            return null;
        }
        return list.get(i11);
    }

    public final CommunityResultBean getCommunityResultBean() {
        return this.communityResultBean;
    }

    public int getItemCount() {
        int listSize = getListSize();
        List<CommunityItemBean> list = this.communityItemBeans;
        boolean z11 = list == null || list.isEmpty();
        boolean z12 = this.isShowTopViewItem;
        if (z12 && z11) {
            listSize++;
        }
        if (!this.mHasDataAnyMore && !z11) {
            listSize++;
        }
        return z12 ? listSize + 1 : listSize;
    }

    public int getItemViewType(int i11) {
        List<CommunityItemBean> list = this.communityItemBeans;
        int i12 = 0;
        boolean z11 = list == null || list.isEmpty();
        boolean z12 = this.isShowTopViewItem;
        if (z12 && i11 == 0) {
            return this.LIST_ITEM_TYPE_TOP_VIEW;
        }
        if (z12 && z11) {
            return this.LIST_ITEM_TYPE_NONE_DYNAMIC;
        }
        if (!this.mHasDataAnyMore && !z11 && i11 == getItemCount() - 1) {
            return this.LIST_ITEM_TYPE_NO_MORE_DATA;
        }
        if (this.isShowTopViewItem) {
            i11--;
        }
        CommunityItemBean communityItemBean = this.communityItemBeans.get(i11);
        List<String> images = communityItemBean != null ? communityItemBean.getImages() : null;
        int type = communityItemBean.getType() * 10;
        if (images != null) {
            i12 = images.size();
        }
        return type + i12;
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:0x0013 A[Catch:{ Exception -> 0x002d }] */
    /* JADX WARNING: Removed duplicated region for block: B:11:0x0014 A[Catch:{ Exception -> 0x002d }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.String getLastMid() {
        /*
            r4 = this;
            java.lang.String r0 = "-1"
            java.util.List<com.huochat.community.model.CommunityItemBean> r1 = r4.communityItemBeans     // Catch:{ Exception -> 0x002d }
            r2 = 1
            if (r1 == 0) goto L_0x0010
            boolean r1 = r1.isEmpty()     // Catch:{ Exception -> 0x002d }
            if (r1 == 0) goto L_0x000e
            goto L_0x0010
        L_0x000e:
            r1 = 0
            goto L_0x0011
        L_0x0010:
            r1 = r2
        L_0x0011:
            if (r1 == 0) goto L_0x0014
            goto L_0x002d
        L_0x0014:
            java.util.List<com.huochat.community.model.CommunityItemBean> r1 = r4.communityItemBeans     // Catch:{ Exception -> 0x002d }
            java.util.List<com.huochat.community.model.CommunityItemBean> r3 = r4.communityItemBeans     // Catch:{ Exception -> 0x002d }
            int r3 = r3.size()     // Catch:{ Exception -> 0x002d }
            int r3 = r3 - r2
            java.lang.Object r1 = r1.get(r3)     // Catch:{ Exception -> 0x002d }
            com.huochat.community.model.CommunityItemBean r1 = (com.huochat.community.model.CommunityItemBean) r1     // Catch:{ Exception -> 0x002d }
            if (r1 == 0) goto L_0x002d
            java.lang.String r1 = r1.getMid()     // Catch:{ Exception -> 0x002d }
            if (r1 != 0) goto L_0x002c
            goto L_0x002d
        L_0x002c:
            r0 = r1
        L_0x002d:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huochat.community.adapter.CommunityAdapter.getLastMid():java.lang.String");
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:0x0013 A[Catch:{ Exception -> 0x002f }] */
    /* JADX WARNING: Removed duplicated region for block: B:13:0x0026 A[Catch:{ Exception -> 0x002f }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Long getLastPostTime() {
        /*
            r5 = this;
            r0 = -1
            java.util.List<com.huochat.community.model.CommunityItemBean> r2 = r5.communityItemBeans     // Catch:{ Exception -> 0x002f }
            r3 = 1
            if (r2 == 0) goto L_0x0010
            boolean r2 = r2.isEmpty()     // Catch:{ Exception -> 0x002f }
            if (r2 == 0) goto L_0x000e
            goto L_0x0010
        L_0x000e:
            r2 = 0
            goto L_0x0011
        L_0x0010:
            r2 = r3
        L_0x0011:
            if (r2 == 0) goto L_0x0015
        L_0x0013:
            r2 = r0
            goto L_0x002a
        L_0x0015:
            java.util.List<com.huochat.community.model.CommunityItemBean> r2 = r5.communityItemBeans     // Catch:{ Exception -> 0x002f }
            java.util.List<com.huochat.community.model.CommunityItemBean> r4 = r5.communityItemBeans     // Catch:{ Exception -> 0x002f }
            int r4 = r4.size()     // Catch:{ Exception -> 0x002f }
            int r4 = r4 - r3
            java.lang.Object r2 = r2.get(r4)     // Catch:{ Exception -> 0x002f }
            com.huochat.community.model.CommunityItemBean r2 = (com.huochat.community.model.CommunityItemBean) r2     // Catch:{ Exception -> 0x002f }
            if (r2 == 0) goto L_0x0013
            long r2 = r2.getPostTime()     // Catch:{ Exception -> 0x002f }
        L_0x002a:
            java.lang.Long r0 = java.lang.Long.valueOf(r2)     // Catch:{ Exception -> 0x002f }
            goto L_0x0033
        L_0x002f:
            java.lang.Long r0 = java.lang.Long.valueOf(r0)
        L_0x0033:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huochat.community.adapter.CommunityAdapter.getLastPostTime():java.lang.Long");
    }

    public final boolean hasListData() {
        List<CommunityItemBean> list = this.communityItemBeans;
        return !(list == null || list.isEmpty());
    }

    public final boolean hasTopicListData() {
        if (this.isShowTopViewItem) {
            List<TopicBean> list = this.hotTopicList;
            if (!(list == null || list.isEmpty())) {
                return true;
            }
        }
        return false;
    }

    public final void insertData(CommunityItemBean communityItemBean) {
        this.communityItemBeans.add(0, communityItemBean);
        notifyItemInserted(this.isShowTopViewItem ? 1 : 0);
    }

    public final void notifyComunityBaseInfo(CommunityResultBean communityResultBean2) {
        this.communityResultBean = communityResultBean2;
        String str = null;
        this.communityId = communityResultBean2 != null ? communityResultBean2.getCommunityId() : null;
        this.communityName = communityResultBean2 != null ? communityResultBean2.getCommunityName() : null;
        StringBuilder sb2 = new StringBuilder();
        sb2.append(communityResultBean2 != null ? communityResultBean2.getBaseCurrency() : null);
        if (communityResultBean2 != null) {
            str = communityResultBean2.getPriceCurrency();
        }
        sb2.append(str);
        this.communitySymbol = sb2.toString();
    }

    public final void notifyNoMoreDataChanged() {
        this.mHasDataAnyMore = false;
        notifyDataSetChanged();
    }

    public final void notifyThemeChanged() {
        initInflater();
        this.communityThemeColor = CommunityManager.Companion.getInstance().getCommunityThemeColor();
        notifyDataSetChanged();
    }

    /* JADX WARNING: type inference failed for: r6v5, types: [android.view.View] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onBindViewHolder(androidx.recyclerview.widget.RecyclerView.ViewHolder r6, int r7) {
        /*
            r5 = this;
            r0 = 0
            r1 = 1
            if (r7 != 0) goto L_0x002d
            boolean r2 = r6 instanceof com.huochat.community.viewholder.CommunityTopHolder
            if (r2 == 0) goto L_0x002d
            com.huochat.community.model.CommunityResultBean r7 = r5.communityResultBean
            if (r7 == 0) goto L_0x0025
            com.huochat.community.enums.SortBtnVisible$Companion r2 = com.huochat.community.enums.SortBtnVisible.Companion
            int r3 = r7.getButtonFlag()
            com.huochat.community.enums.SortBtnVisible r2 = r2.getVisible(r3)
            com.huochat.community.enums.SortBtnVisible r3 = com.huochat.community.enums.SortBtnVisible.VISIBLE
            if (r2 != r3) goto L_0x001b
            r0 = r1
        L_0x001b:
            r1 = r6
            com.huochat.community.viewholder.CommunityTopHolder r1 = (com.huochat.community.viewholder.CommunityTopHolder) r1
            java.lang.String r7 = r7.getTotalMsg()
            r1.bindData(r7, r0)
        L_0x0025:
            com.huochat.community.viewholder.CommunityTopHolder r6 = (com.huochat.community.viewholder.CommunityTopHolder) r6
            com.huochat.community.listener.OnCommunitySortClickListener r7 = r5.mSortClickListener
            r6.setOnSortClickListener(r7)
            return
        L_0x002d:
            if (r7 != r1) goto L_0x0039
            boolean r2 = r6 instanceof com.huochat.community.viewholder.CommunityEmptyHolder
            if (r2 == 0) goto L_0x0039
            com.huochat.community.viewholder.CommunityEmptyHolder r6 = (com.huochat.community.viewholder.CommunityEmptyHolder) r6
            r6.bindData()
            return
        L_0x0039:
            boolean r2 = r6 instanceof com.huochat.community.viewholder.CommunityHolder
            if (r2 != 0) goto L_0x003e
            return
        L_0x003e:
            com.huochat.community.viewholder.CommunityHolder r6 = (com.huochat.community.viewholder.CommunityHolder) r6
            int r2 = r5.mDefItemViewWidth
            if (r2 <= 0) goto L_0x0052
            r2 = 1097859072(0x41700000, float:15.0)
            int r2 = com.huochat.community.util.DisplayTool.dp2px(r2)
            int r2 = r2 * 2
            int r3 = r5.mDefItemViewWidth
            int r3 = r3 - r2
            r6.setDefExpandableTextWidth(r3)
        L_0x0052:
            int r2 = r5.getItemViewType(r7)
            int r3 = r5.LIST_ITEM_TYPE_NO_MORE_DATA
            if (r2 != r3) goto L_0x009a
            android.view.View r7 = r6.getItemCommunityListDetailView()
            r1 = 0
            if (r7 != 0) goto L_0x007f
            android.view.View r7 = r6.itemView
            r7.setVisibility(r0)
            android.view.LayoutInflater r7 = r5.mLayoutInflater
            if (r7 != 0) goto L_0x006b
            r7 = r1
        L_0x006b:
            int r2 = com.huochat.community.R.layout.community_item_list_no_more_data
            android.view.View r7 = r7.inflate(r2, r1, r0)
            r6.setItemCommunityListDetailView(r7)
            android.widget.LinearLayout r7 = r6.getLinearLayoutItemRoot()
            android.view.View r0 = r6.getItemCommunityListDetailView()
            r7.addView(r0)
        L_0x007f:
            android.view.View r6 = r6.getItemCommunityListDetailView()
            if (r6 == 0) goto L_0x008e
            int r7 = com.huochat.community.R.id.tv_no_more_data_tips
            android.view.View r6 = r6.findViewById(r7)
            r1 = r6
            android.widget.TextView r1 = (android.widget.TextView) r1
        L_0x008e:
            if (r1 == 0) goto L_0x00e3
            com.huochat.community.CommunityThemeColor r6 = r5.communityThemeColor
            int r6 = r6.getCommunityMomentListNoMoreDataTipsTextColor()
            r1.setTextColor(r6)
            goto L_0x00e3
        L_0x009a:
            boolean r2 = r5.isShowTopViewItem
            if (r2 == 0) goto L_0x00a0
            int r7 = r7 + -1
        L_0x00a0:
            java.util.List<com.huochat.community.model.CommunityItemBean> r2 = r5.communityItemBeans
            java.lang.Object r7 = r2.get(r7)
            com.huochat.community.model.CommunityItemBean r7 = (com.huochat.community.model.CommunityItemBean) r7
            java.lang.String r2 = r5.getLastMid()
            java.lang.String r3 = r7.getMid()
            boolean r2 = kotlin.jvm.internal.x.b(r2, r3)
            android.app.Activity r3 = r5.activity
            java.lang.String r4 = r5.mSymbolId
            r6.bindData(r7, r3, r4)
            r2 = r2 ^ r1
            r6.setBottomLineVisibility(r2)
            com.huochat.community.listener.OnCommunityOperationClickListener r2 = r5.operationClickListener
            r6.setOperationClick(r2)
            com.huochat.community.listener.OnCommentClickListener r2 = r5.onCommentClickListenr
            r6.setOnCommentClick(r2)
            java.lang.String r2 = r5.mLastBrowerCircleId
            java.lang.String r3 = "-1"
            boolean r2 = kotlin.jvm.internal.x.b(r3, r2)
            if (r2 == 0) goto L_0x00e0
            java.lang.String r2 = r5.mLastBrowerCircleId
            java.lang.String r7 = r7.getMid()
            boolean r7 = kotlin.jvm.internal.x.b(r2, r7)
            if (r7 == 0) goto L_0x00e0
            r0 = r1
        L_0x00e0:
            r6.setShowBrowerLocationView(r0)
        L_0x00e3:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huochat.community.adapter.CommunityAdapter.onBindViewHolder(androidx.recyclerview.widget.RecyclerView$ViewHolder, int):void");
    }

    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i11) {
        View view;
        CommunityHolder communityHolder = null;
        if (i11 == this.LIST_ITEM_TYPE_TOP_VIEW) {
            LayoutInflater layoutInflater = this.mLayoutInflater;
            if (layoutInflater == null) {
                layoutInflater = null;
            }
            return new CommunityTopHolder(this.activity, layoutInflater.inflate(R.layout.item_community_list_top_view, (ViewGroup) null, false));
        } else if (i11 == this.LIST_ITEM_TYPE_NONE_DYNAMIC) {
            LayoutInflater layoutInflater2 = this.mLayoutInflater;
            if (layoutInflater2 == null) {
                layoutInflater2 = null;
            }
            return new CommunityEmptyHolder(layoutInflater2.inflate(R.layout.item_community_list_empty_view, (ViewGroup) null, false));
        } else {
            MomentType type = MomentType.getType(i11);
            switch (type == null ? -1 : WhenMappings.$EnumSwitchMapping$0[type.ordinal()]) {
                case 1:
                    LinearLayout linearLayout = new LinearLayout(viewGroup.getContext());
                    linearLayout.setOrientation(1);
                    linearLayout.setId(R.id.linear_layout_item_root);
                    view = linearLayout;
                    break;
                case 2:
                case 3:
                    LayoutInflater layoutInflater3 = this.mLayoutInflater;
                    if (layoutInflater3 == null) {
                        layoutInflater3 = null;
                    }
                    view = layoutInflater3.inflate(R.layout.item_community_text, viewGroup, false);
                    break;
                case 4:
                case 5:
                    LayoutInflater layoutInflater4 = this.mLayoutInflater;
                    if (layoutInflater4 == null) {
                        layoutInflater4 = null;
                    }
                    view = layoutInflater4.inflate(R.layout.item_community_image_1, viewGroup, false);
                    break;
                case 6:
                    LayoutInflater layoutInflater5 = this.mLayoutInflater;
                    if (layoutInflater5 == null) {
                        layoutInflater5 = null;
                    }
                    view = layoutInflater5.inflate(R.layout.item_community_image_2, viewGroup, false);
                    break;
                case 7:
                    LayoutInflater layoutInflater6 = this.mLayoutInflater;
                    if (layoutInflater6 == null) {
                        layoutInflater6 = null;
                    }
                    view = layoutInflater6.inflate(R.layout.item_community_image_3, viewGroup, false);
                    break;
                case 8:
                    LayoutInflater layoutInflater7 = this.mLayoutInflater;
                    if (layoutInflater7 == null) {
                        layoutInflater7 = null;
                    }
                    view = layoutInflater7.inflate(R.layout.item_community_image_4, viewGroup, false);
                    break;
                case 9:
                    LayoutInflater layoutInflater8 = this.mLayoutInflater;
                    if (layoutInflater8 == null) {
                        layoutInflater8 = null;
                    }
                    view = layoutInflater8.inflate(R.layout.item_community_image_5, viewGroup, false);
                    break;
                case 10:
                    LayoutInflater layoutInflater9 = this.mLayoutInflater;
                    if (layoutInflater9 == null) {
                        layoutInflater9 = null;
                    }
                    view = layoutInflater9.inflate(R.layout.item_community_image_6, viewGroup, false);
                    break;
                case 11:
                    LayoutInflater layoutInflater10 = this.mLayoutInflater;
                    if (layoutInflater10 == null) {
                        layoutInflater10 = null;
                    }
                    view = layoutInflater10.inflate(R.layout.item_community_image_7, viewGroup, false);
                    break;
                case 12:
                    LayoutInflater layoutInflater11 = this.mLayoutInflater;
                    if (layoutInflater11 == null) {
                        layoutInflater11 = null;
                    }
                    view = layoutInflater11.inflate(R.layout.item_community_image_8, viewGroup, false);
                    break;
                case 13:
                    LayoutInflater layoutInflater12 = this.mLayoutInflater;
                    if (layoutInflater12 == null) {
                        layoutInflater12 = null;
                    }
                    view = layoutInflater12.inflate(R.layout.item_community_image_9, viewGroup, false);
                    break;
                case 14:
                case 15:
                case 16:
                case 17:
                case 18:
                    LayoutInflater layoutInflater13 = this.mLayoutInflater;
                    if (layoutInflater13 == null) {
                        layoutInflater13 = null;
                    }
                    view = layoutInflater13.inflate(R.layout.item_community_share_url, viewGroup, false);
                    break;
                case 19:
                    LayoutInflater layoutInflater14 = this.mLayoutInflater;
                    if (layoutInflater14 == null) {
                        layoutInflater14 = null;
                    }
                    view = layoutInflater14.inflate(R.layout.item_community_image_1, viewGroup, false);
                    break;
                case 20:
                    LayoutInflater layoutInflater15 = this.mLayoutInflater;
                    if (layoutInflater15 == null) {
                        layoutInflater15 = null;
                    }
                    view = layoutInflater15.inflate(R.layout.item_community_out_share_url, viewGroup, false);
                    break;
                case 21:
                    LayoutInflater layoutInflater16 = this.mLayoutInflater;
                    if (layoutInflater16 == null) {
                        layoutInflater16 = null;
                    }
                    view = layoutInflater16.inflate(R.layout.item_community_content_identify_link, viewGroup, false);
                    break;
                default:
                    LayoutInflater layoutInflater17 = this.mLayoutInflater;
                    if (layoutInflater17 == null) {
                        layoutInflater17 = null;
                    }
                    view = layoutInflater17.inflate(R.layout.item_community_text, viewGroup, false);
                    break;
            }
            Activity activity2 = this.activity;
            if (!(activity2 == null || view == null)) {
                communityHolder = new CommunityHolder(activity2, view, true, this.mIsShowCommunityFromPanel);
            }
            communityHolder.setSymbolParams(this.communityParamSymbol, this.symbolParamType);
            communityHolder.setOnHolderTouchListener(new CommunityAdapter$onCreateViewHolder$1(this));
            View viewBottomLine = communityHolder.getViewBottomLine();
            if (viewBottomLine != null) {
                viewBottomLine.getLayoutParams().height = viewBottomLine.getResources().getDimensionPixelOffset(R.dimen.dimen_0_6);
                viewBottomLine.setBackgroundColor(this.communityThemeColor.getListDividingLineColor());
                ((LinearLayout.LayoutParams) viewBottomLine.getLayoutParams()).topMargin = viewBottomLine.getResources().getDimensionPixelOffset(R.dimen.dimen_20);
                Resources resources = viewBottomLine.getResources();
                int i12 = R.dimen.dimen_15;
                ((LinearLayout.LayoutParams) viewBottomLine.getLayoutParams()).leftMargin = resources.getDimensionPixelOffset(i12);
                ((LinearLayout.LayoutParams) viewBottomLine.getLayoutParams()).rightMargin = viewBottomLine.getResources().getDimensionPixelOffset(i12);
                viewBottomLine.setVisibility(0);
            }
            communityHolder.setShowBottomOpratePanel(false);
            return communityHolder;
        }
    }

    public final void refreshTopCommunityMsgInfo(String str, int i11, CommunityMenuItems communityMenuItems) {
        CommunityTopBean communityTopBean = this.mCommunityTopBean;
        if (communityTopBean != null) {
            communityTopBean.setDataType(TopDataType.NORMAL.getType());
            communityTopBean.setTotalMsg(str);
            communityTopBean.setButtonFlag(i11);
            communityTopBean.setCommunityListSort(communityMenuItems);
            notifyItemChanged(0, this.mCommunityTopBean);
        }
    }

    public final void refreshTopHotTopicList(List<TopicBean> list) {
        CommunityTopBean communityTopBean = this.mCommunityTopBean;
        if (communityTopBean != null) {
            this.hotTopicList = list;
            communityTopBean.setDataType(TopDataType.TOPIC.getType());
            communityTopBean.setHotTopicList(list);
            i.b().g(new a(this, communityTopBean), 100);
        }
    }

    public final void refreshTopListSortStatus(CommunityMenuItems communityMenuItems) {
        CommunityTopBean communityTopBean = this.mCommunityTopBean;
        if (communityTopBean != null) {
            communityTopBean.setDataType(TopDataType.SORT_MENU.getType());
            communityTopBean.setCommunityListSort(communityMenuItems);
            notifyItemChanged(0, this.mCommunityTopBean);
        }
    }

    public final void remove(CommunityItemBean communityItemBean) {
        int indexOf;
        List<CommunityItemBean> list = this.communityItemBeans;
        if (!(list == null || list.isEmpty()) && (indexOf = this.communityItemBeans.indexOf(communityItemBean)) != -1) {
            this.communityItemBeans.remove(indexOf);
            notifyDataSetChanged();
        }
    }

    public final void removeFullExpandableTextViewLongClickEvent() {
        CommunityHolder communityHolder = this.mHodler;
        if (communityHolder != null) {
            communityHolder.removeFullExpandableTextViewLongClickEvent();
        }
    }

    public final void resetAll() {
        this.isShowTopViewItem = false;
        this.mIsShowCommunityFromPanel = true;
        this.communityId = "";
        this.communityName = "";
        this.communitySymbol = "";
        this.mLastBrowerCircleId = "";
        this.communityResultBean = null;
        this.mCommunityTopBean = null;
        this.mHasDataAnyMore = true;
        this.communityItemBeans = null;
        this.communityParamSymbol = "";
        this.symbolParamType = SymbolParamType.SYMBOL;
        notifyDataSetChanged();
    }

    public final void setCommunityResultBean(CommunityResultBean communityResultBean2) {
        this.communityResultBean = communityResultBean2;
    }

    public final void setDatas(List<CommunityItemBean> list) {
        this.communityItemBeans.clear();
        this.communityItemBeans.addAll(list);
        this.mHasDataAnyMore = true;
        notifyDataSetChanged();
    }

    public final void setDefItemWidth(int i11) {
        this.mDefItemViewWidth = i11;
    }

    public final void setLastBrowerCircleLocation(String str) {
        this.mLastBrowerCircleId = str;
    }

    public final void setOnCommentClick(OnCommentClickListener onCommentClickListener) {
        this.onCommentClickListenr = onCommentClickListener;
    }

    public final void setOnCommunitySortClickListener(OnCommunitySortClickListener onCommunitySortClickListener) {
        this.mSortClickListener = onCommunitySortClickListener;
    }

    public final void setOnHotTopicItemClickListener(HotTopicTagFlowView.OnItemClickListener onItemClickListener) {
        this.mHotTopicItemClickListener = onItemClickListener;
    }

    public final void setOperationClick(OnCommunityOperationClickListener onCommunityOperationClickListener) {
        this.operationClickListener = onCommunityOperationClickListener;
    }

    public final void setSymbolId(String str) {
        this.mSymbolId = str;
    }

    public final void setSymbolParams(String str, SymbolParamType symbolParamType2) {
        this.communityParamSymbol = str;
        this.symbolParamType = symbolParamType2;
    }

    public final void update(CommunityItemBean communityItemBean) {
        update(communityItemBean, true);
    }

    public final void addDatas(List<CommunityItemBean> list, boolean z11, boolean z12) {
        this.mHasDataAnyMore = z12;
        if (z11) {
            this.communityItemBeans.clear();
            this.communityItemBeans.addAll(list);
            notifyDataSetChanged();
        } else if (!list.isEmpty()) {
            this.communityItemBeans.addAll(list);
            notifyItemRangeChanged(this.communityItemBeans.size() - 1, this.communityItemBeans.size() - 1);
        }
    }

    public final void update(CommunityItemBean communityItemBean, boolean z11) {
        int indexOf = this.communityItemBeans.indexOf(communityItemBean);
        if (indexOf != -1) {
            this.communityItemBeans.set(indexOf, communityItemBean);
            if (z11) {
                if (this.isShowTopViewItem) {
                    indexOf++;
                }
                notifyItemChanged(indexOf, 1);
            }
        }
    }

    public CommunityAdapter(Activity activity2, boolean z11, boolean z12) {
        this(activity2, z11);
        this.mIsShowCommunityFromPanel = z12;
    }

    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i11, List<Object> list) {
        super.onBindViewHolder(viewHolder, i11, list);
        if (this.isShowTopViewItem && i11 == 0 && (viewHolder instanceof CommunityTopHolder)) {
            boolean z11 = true;
            if ((!list.isEmpty()) && (list.get(0) instanceof CommunityTopBean)) {
                CommunityTopBean communityTopBean = (CommunityTopBean) list.get(0);
                int i12 = WhenMappings.$EnumSwitchMapping$1[TopDataType.Companion.getType(communityTopBean.getDataType()).ordinal()];
                if (i12 == 1) {
                    ((CommunityTopHolder) viewHolder).bindHotTopicData(communityTopBean.getHotTopicList(), this.mHotTopicItemClickListener);
                } else if (i12 == 2) {
                    if (SortBtnVisible.Companion.getVisible(communityTopBean.getButtonFlag()) != SortBtnVisible.VISIBLE) {
                        z11 = false;
                    }
                    ((CommunityTopHolder) viewHolder).bindData(communityTopBean.getTotalMsg(), z11);
                } else if (i12 == 3) {
                    ((CommunityTopHolder) viewHolder).resetSortBtnStatus(communityTopBean.getCommunityListSort());
                }
            }
        }
    }
}
