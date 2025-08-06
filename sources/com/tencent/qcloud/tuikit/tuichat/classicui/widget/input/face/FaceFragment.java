package com.tencent.qcloud.tuikit.tuichat.classicui.widget.input.face;

import android.app.Activity;
import android.content.Context;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.FrameLayout;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import com.tencent.qcloud.tuikit.timcommon.component.face.ChatFace;
import com.tencent.qcloud.tuikit.timcommon.component.face.CustomFace;
import com.tencent.qcloud.tuikit.timcommon.component.face.Emoji;
import com.tencent.qcloud.tuikit.timcommon.component.face.FaceGroup;
import com.tencent.qcloud.tuikit.timcommon.component.face.FaceManager;
import com.tencent.qcloud.tuikit.timcommon.component.face.RecentEmojiManager;
import com.tencent.qcloud.tuikit.tuichat.R;
import com.tencent.qcloud.tuikit.tuichat.classicui.component.EmojiIndicatorView;
import com.tencent.qcloud.tuikit.tuichat.classicui.widget.input.BaseInputFragment;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FaceFragment extends BaseInputFragment {
    public ArrayList<View> ViewPagerItems = new ArrayList<>();
    public LinearLayout faceGroup;
    public List<FaceGroup> faceGroups;
    public EmojiIndicatorView faceIndicator;
    public ViewPager faceViewPager;
    /* access modifiers changed from: private */
    public OnEmojiClickListener listener;
    /* access modifiers changed from: private */
    public int mCurrentGroupIndex = 0;
    public FaceGroupIcon mCurrentSelected;
    private RecentEmojiManager recentManager;
    public ArrayList<Emoji> recentlyEmojiList;
    private boolean showCustomFace = true;

    public static class FaceGVAdapter extends BaseAdapter {
        private final List<ChatFace> list;
        private final Context mContext;

        public class ViewHolder {

            /* renamed from: iv  reason: collision with root package name */
            public ImageView f48590iv;

            public ViewHolder() {
            }
        }

        public FaceGVAdapter(List<ChatFace> list2, Context context) {
            this.list = list2;
            this.mContext = context;
        }

        public int getCount() {
            return this.list.size();
        }

        public Object getItem(int i11) {
            return this.list.get(i11);
        }

        public long getItemId(int i11) {
            return (long) i11;
        }

        public View getView(int i11, View view, ViewGroup viewGroup) {
            View view2;
            ViewHolder viewHolder;
            ChatFace chatFace = this.list.get(i11);
            if (view == null) {
                viewHolder = new ViewHolder();
                view2 = LayoutInflater.from(this.mContext).inflate(R.layout.item_face, (ViewGroup) null);
                ImageView imageView = (ImageView) view2.findViewById(R.id.face_image);
                viewHolder.f48590iv = imageView;
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) imageView.getLayoutParams();
                if (!(chatFace == null || chatFace.getHeight() == 0 || chatFace.getWidth() == 0)) {
                    layoutParams.width = chatFace.getWidth();
                    layoutParams.height = chatFace.getHeight();
                }
                viewHolder.f48590iv.setLayoutParams(layoutParams);
                view2.setTag(viewHolder);
            } else {
                view2 = view;
                viewHolder = (ViewHolder) view.getTag();
            }
            if (chatFace != null) {
                FaceManager.loadFace(chatFace, viewHolder.f48590iv);
            }
            return view2;
        }
    }

    public class FaceVPAdapter extends PagerAdapter {
        private List<View> views;

        public FaceVPAdapter(List<View> list) {
            this.views = list;
        }

        public void destroyItem(View view, int i11, Object obj) {
            ((ViewPager) view).removeView((View) obj);
        }

        public int getCount() {
            return this.views.size();
        }

        public Object instantiateItem(View view, int i11) {
            ((ViewPager) view).addView(this.views.get(i11));
            return this.views.get(i11);
        }

        public boolean isViewFromObject(View view, Object obj) {
            return view == obj;
        }
    }

    public interface OnEmojiClickListener {
        void onCustomFaceClick(int i11, CustomFace customFace);

        void onEmojiClick(Emoji emoji);

        void onEmojiDelete();
    }

    private int getPagerCount(ArrayList<? extends ChatFace> arrayList, int i11, int i12) {
        int size = arrayList.size();
        int i13 = (i11 * i12) - (this.mCurrentGroupIndex > 0 ? 0 : 1);
        if (size % i13 == 0) {
            return size / i13;
        }
        return (size / i13) + 1;
    }

    private View getViewPagerItem(int i11, ArrayList<? extends ChatFace> arrayList, final int i12, final int i13) {
        GridView gridView = (GridView) ((LayoutInflater) getActivity().getSystemService("layout_inflater")).inflate(R.layout.layout_face_grid, (ViewGroup) null).findViewById(R.id.chart_face_gv);
        gridView.setNumColumns(i12);
        final ArrayList arrayList2 = new ArrayList();
        int i14 = (i12 * i13) - (this.mCurrentGroupIndex > 0 ? 0 : 1);
        int i15 = i11 * i14;
        int i16 = (i11 + 1) * i14;
        if (i16 > arrayList.size()) {
            i16 = arrayList.size();
        }
        arrayList2.addAll(arrayList.subList(i15, i16));
        if (this.mCurrentGroupIndex == 0 && arrayList2.size() < i14) {
            for (int size = arrayList2.size(); size < i14; size++) {
                arrayList2.add((Object) null);
            }
        }
        if (this.mCurrentGroupIndex == 0) {
            Emoji emoji = new Emoji();
            emoji.setIcon(BitmapFactory.decodeResource(getResources(), R.drawable.face_delete));
            arrayList2.add(emoji);
        }
        gridView.setAdapter(new FaceGVAdapter(arrayList2, getActivity()));
        gridView.setNumColumns(i12);
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @SensorsDataInstrumented
            public void onItemClick(AdapterView<?> adapterView, View view, int i11, long j11) {
                if (FaceFragment.this.mCurrentGroupIndex > 0) {
                    FaceFragment.this.listener.onCustomFaceClick(FaceFragment.this.mCurrentGroupIndex, (CustomFace) arrayList2.get(i11));
                } else if (i11 == (i12 * i13) - 1) {
                    if (FaceFragment.this.listener != null) {
                        FaceFragment.this.listener.onEmojiDelete();
                    }
                    SensorsDataAutoTrackHelper.trackListView(adapterView, view, i11);
                    return;
                } else if (FaceFragment.this.listener != null) {
                    FaceFragment.this.listener.onEmojiClick((Emoji) arrayList2.get(i11));
                }
                SensorsDataAutoTrackHelper.trackListView(adapterView, view, i11);
            }
        });
        return gridView;
    }

    /* access modifiers changed from: private */
    public void initViewPager(ArrayList<? extends ChatFace> arrayList, int i11, int i12) {
        intiIndicator(arrayList, i11, i12);
        this.ViewPagerItems.clear();
        int pagerCount = getPagerCount(arrayList, i11, i12);
        for (int i13 = 0; i13 < pagerCount; i13++) {
            this.ViewPagerItems.add(getViewPagerItem(i13, arrayList, i11, i12));
        }
        this.faceViewPager.setAdapter(new FaceVPAdapter(this.ViewPagerItems));
        this.faceViewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            public int oldPosition = 0;

            public void onPageScrollStateChanged(int i11) {
            }

            public void onPageScrolled(int i11, float f11, int i12) {
            }

            public void onPageSelected(int i11) {
                FaceFragment.this.faceIndicator.playBy(this.oldPosition, i11);
                this.oldPosition = i11;
            }
        });
    }

    private void initViews() {
        this.faceGroups = FaceManager.getFaceGroupList();
        for (int i11 = 0; i11 < this.faceGroups.size(); i11++) {
            final FaceGroup faceGroup2 = this.faceGroups.get(i11);
            if (faceGroup2.getGroupID() == 0 || this.showCustomFace) {
                FaceGroupIcon faceGroupIcon = new FaceGroupIcon(getActivity());
                faceGroupIcon.setFaceTabIcon(faceGroup2.getFaceGroupIconUrl());
                if (i11 == 0) {
                    this.mCurrentSelected = faceGroupIcon;
                    this.mCurrentGroupIndex = faceGroup2.getGroupID();
                    initViewPager(faceGroup2.getFaces(), faceGroup2.getPageColumnCount(), faceGroup2.getPageRowCount());
                    this.mCurrentSelected.setSelected(true);
                }
                faceGroupIcon.setOnClickListener(new View.OnClickListener() {
                    @SensorsDataInstrumented
                    public void onClick(View view) {
                        FaceFragment faceFragment = FaceFragment.this;
                        if (faceFragment.mCurrentSelected != view) {
                            int unused = faceFragment.mCurrentGroupIndex = faceGroup2.getGroupID();
                            ArrayList<ChatFace> faces = faceGroup2.getFaces();
                            FaceFragment.this.mCurrentSelected.setSelected(false);
                            FaceFragment.this.initViewPager(faces, faceGroup2.getPageColumnCount(), faceGroup2.getPageRowCount());
                            FaceGroupIcon faceGroupIcon = (FaceGroupIcon) view;
                            FaceFragment.this.mCurrentSelected = faceGroupIcon;
                            faceGroupIcon.setSelected(true);
                        }
                        SensorsDataAutoTrackHelper.trackViewOnClick(view);
                    }
                });
                this.faceGroup.addView(faceGroupIcon);
            }
        }
    }

    private void intiIndicator(ArrayList<? extends ChatFace> arrayList, int i11, int i12) {
        this.faceIndicator.init(getPagerCount(arrayList, i11, i12));
    }

    public void onAttach(Activity activity) {
        if (activity instanceof OnEmojiClickListener) {
            this.listener = (OnEmojiClickListener) activity;
        }
        this.recentManager = RecentEmojiManager.getInstance();
        super.onAttach(activity);
    }

    public void onCreate(Bundle bundle) {
        try {
            if (this.recentManager.getCollection(RecentEmojiManager.PREFERENCE_NAME) != null) {
                this.recentlyEmojiList = (ArrayList) this.recentManager.getCollection(RecentEmojiManager.PREFERENCE_NAME);
            } else {
                this.recentlyEmojiList = new ArrayList<>();
            }
        } catch (IOException e11) {
            e11.printStackTrace();
        } catch (ClassNotFoundException e12) {
            e12.printStackTrace();
        }
        super.onCreate(bundle);
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.fragment_face, viewGroup, false);
        this.faceViewPager = (ViewPager) inflate.findViewById(R.id.face_viewPager);
        this.faceIndicator = (EmojiIndicatorView) inflate.findViewById(R.id.face_indicator);
        this.faceGroup = (LinearLayout) inflate.findViewById(R.id.face_view_group);
        initViews();
        return inflate;
    }

    public void onDestroyView() {
        super.onDestroyView();
        try {
            this.recentManager.putCollection(RecentEmojiManager.PREFERENCE_NAME, this.recentlyEmojiList);
        } catch (IOException e11) {
            e11.printStackTrace();
        }
    }

    public void setListener(OnEmojiClickListener onEmojiClickListener) {
        this.listener = onEmojiClickListener;
    }

    public void setShowCustomFace(boolean z11) {
        this.showCustomFace = z11;
    }
}
