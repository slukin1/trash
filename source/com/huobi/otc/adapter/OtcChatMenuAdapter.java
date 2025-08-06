package com.huobi.otc.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.hbg.module.otc.R$drawable;
import com.hbg.module.otc.R$id;
import com.hbg.module.otc.R$layout;
import com.hbg.module.otc.R$string;
import java.util.ArrayList;
import java.util.Iterator;

public class OtcChatMenuAdapter extends BaseAdapter {

    /* renamed from: b  reason: collision with root package name */
    public ArrayList<a> f78256b;

    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public int f78257a;

        /* renamed from: b  reason: collision with root package name */
        public int f78258b;

        /* renamed from: c  reason: collision with root package name */
        public int f78259c;

        public a(int i11, int i12, int i13) {
            this.f78257a = i11;
            this.f78258b = i12;
            this.f78259c = i13;
        }

        public static a a(int i11) {
            if (i11 == OtcChatMenuItemType.camera.value) {
                return new a(i11, R$string.n_otc_chat_takehoto, R$drawable.otc_chating_takephotos);
            }
            if (i11 == OtcChatMenuItemType.photo.value) {
                return new a(i11, R$string.n_otc_chat_phtograph, R$drawable.otc_chating_photogragh);
            }
            if (i11 == OtcChatMenuItemType.voiceCall.value) {
                return new a(i11, R$string.n_otc_chat_voice_call, R$drawable.otc_chating_call);
            }
            if (i11 == OtcChatMenuItemType.pdf.value) {
                return new a(i11, R$string.n_otc_chat_pdf_title, R$drawable.otc_chating_pdf);
            }
            if (i11 == OtcChatMenuItemType.transConfirm.value) {
                return new a(i11, R$string.n_otc_chat_menu_item_mk, R$drawable.otc_chating_transconfirm);
            }
            return null;
        }
    }

    public OtcChatMenuAdapter() {
        ArrayList<a> arrayList = new ArrayList<>();
        this.f78256b = arrayList;
        arrayList.add(a.a(OtcChatMenuItemType.camera.value));
        this.f78256b.add(a.a(OtcChatMenuItemType.photo.value));
        this.f78256b.add(a.a(OtcChatMenuItemType.pdf.value));
    }

    public boolean a(int i11) {
        Iterator<a> it2 = this.f78256b.iterator();
        while (it2.hasNext()) {
            if (it2.next().f78257a == i11) {
                return true;
            }
        }
        return false;
    }

    public void b(int i11, boolean z11) {
        a aVar;
        Iterator<a> it2 = this.f78256b.iterator();
        int i12 = 0;
        while (true) {
            if (it2.hasNext()) {
                aVar = it2.next();
                int i13 = aVar.f78257a;
                if (i13 == i11) {
                    break;
                } else if (i13 > i11) {
                    break;
                } else {
                    i12++;
                }
            } else {
                break;
            }
        }
        aVar = null;
        if (z11 && aVar == null) {
            this.f78256b.add(i12, a.a(i11));
            notifyDataSetChanged();
        } else if (!z11 && aVar != null) {
            this.f78256b.remove(aVar);
            notifyDataSetChanged();
        }
    }

    public int getCount() {
        return this.f78256b.size();
    }

    public Object getItem(int i11) {
        return this.f78256b.get(i11);
    }

    public long getItemId(int i11) {
        return (long) this.f78256b.get(i11).f78257a;
    }

    public View getView(int i11, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = LayoutInflater.from(viewGroup.getContext()).inflate(R$layout.item_otc_chat_menu_layout, viewGroup, false);
        }
        a aVar = this.f78256b.get(i11);
        ((ImageView) view.findViewById(R$id.menu_item_icon)).setImageResource(aVar.f78259c);
        ((TextView) view.findViewById(R$id.menu_item_title)).setText(aVar.f78258b);
        view.setTag(aVar);
        return view;
    }
}
