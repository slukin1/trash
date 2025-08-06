package tk;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.List;
import pro.huobi.R;

public class a extends BaseExpandableListAdapter {

    /* renamed from: a  reason: collision with root package name */
    public Context f47904a;

    /* renamed from: b  reason: collision with root package name */
    public List<vk.a> f47905b;

    /* renamed from: c  reason: collision with root package name */
    public List<List<vk.a>> f47906c;

    /* renamed from: tk.a$a  reason: collision with other inner class name */
    public class C0584a {

        /* renamed from: a  reason: collision with root package name */
        public TextView f47907a;

        /* renamed from: b  reason: collision with root package name */
        public ImageView f47908b;

        public C0584a() {
        }
    }

    public a(Context context, List<vk.a> list, List<List<vk.a>> list2) {
        this.f47904a = context;
        this.f47905b = list;
        this.f47906c = list2;
    }

    public Object getChild(int i11, int i12) {
        return this.f47906c.get(i11).get(i12);
    }

    public long getChildId(int i11, int i12) {
        return (long) i12;
    }

    public View getChildView(int i11, int i12, boolean z11, View view, ViewGroup viewGroup) {
        C0584a aVar;
        if (view == null) {
            view = LayoutInflater.from(this.f47904a).inflate(R.layout.item_account_choose_child, (ViewGroup) null);
            aVar = new C0584a();
            aVar.f47907a = (TextView) view.findViewById(R.id.tv_title);
            view.setTag(aVar);
        } else {
            aVar = (C0584a) view.getTag();
        }
        aVar.f47907a.setText(((vk.a) this.f47906c.get(i11).get(i12)).d());
        aVar.f47907a.setOnClickListener(((vk.a) this.f47906c.get(i11).get(i12)).c());
        return view;
    }

    public int getChildrenCount(int i11) {
        if (this.f47906c.size() > i11) {
            return this.f47906c.get(i11).size();
        }
        return 0;
    }

    public Object getGroup(int i11) {
        return this.f47905b.get(i11);
    }

    public int getGroupCount() {
        return this.f47905b.size();
    }

    public long getGroupId(int i11) {
        return (long) i11;
    }

    public View getGroupView(int i11, boolean z11, View view, ViewGroup viewGroup) {
        C0584a aVar;
        View view2;
        vk.a aVar2 = this.f47905b.get(i11);
        if (view == null) {
            aVar = new C0584a();
            if (aVar2.e() == 1) {
                view2 = LayoutInflater.from(this.f47904a).inflate(R.layout.item_account_choose_segment, (ViewGroup) null);
                aVar.f47907a = (TextView) view2.findViewById(R.id.tv_title);
            } else {
                view2 = LayoutInflater.from(this.f47904a).inflate(R.layout.item_account_choose_new, (ViewGroup) null);
                aVar.f47907a = (TextView) view2.findViewById(R.id.tv_title);
                aVar.f47908b = (ImageView) view2.findViewById(R.id.iv_select);
            }
            view2.setTag(aVar);
        } else {
            view2 = view;
            aVar = (C0584a) view.getTag();
        }
        if (aVar2.e() == 1) {
            aVar.f47907a.setText(aVar2.d());
        } else {
            aVar.f47907a.setText(aVar2.d());
            aVar.f47908b.setVisibility(aVar2.g() ? 0 : 8);
            if (aVar2.f()) {
                aVar.f47907a.setTextColor(view2.getContext().getResources().getColor(R.color.baseColorThreeLevelText));
            } else {
                aVar.f47907a.setTextColor(view2.getContext().getResources().getColor(R.color.global_main_text_color));
            }
            if (this.f47905b.get(i11).c() != null) {
                aVar.f47907a.setOnClickListener(this.f47905b.get(i11).c());
            }
        }
        return view2;
    }

    public boolean hasStableIds() {
        return true;
    }

    public boolean isChildSelectable(int i11, int i12) {
        return true;
    }
}
