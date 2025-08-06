package com.hbg.lib.network.contract.core.bean;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.List;

public class ContractTagInfo implements Serializable {
    @SerializedName("tagsGroup")
    private List<TagsGroupInfo> tagsGroup;

    public static class TagsGroupInfo {
        @SerializedName("tag_group_id")

        /* renamed from: a  reason: collision with root package name */
        public Integer f69213a;
        @SerializedName("front_tag_group_id")

        /* renamed from: b  reason: collision with root package name */
        public String f69214b;
        @SerializedName("tag_group_name")

        /* renamed from: c  reason: collision with root package name */
        public String f69215c;
        @SerializedName("tags")

        /* renamed from: d  reason: collision with root package name */
        public List<TagInfo> f69216d;

        public static class TagInfo {
            @SerializedName("tag_id")

            /* renamed from: a  reason: collision with root package name */
            public Integer f69217a;
            @SerializedName("front_tag_id")

            /* renamed from: b  reason: collision with root package name */
            public String f69218b;
            @SerializedName("tag_name")

            /* renamed from: c  reason: collision with root package name */
            public String f69219c;
            @SerializedName("tag_name_en")

            /* renamed from: d  reason: collision with root package name */
            public String f69220d;
            @SerializedName("tag_name_sc")

            /* renamed from: e  reason: collision with root package name */
            public String f69221e;
            @SerializedName("tag_link")

            /* renamed from: f  reason: collision with root package name */
            public String f69222f;
            @SerializedName("productIds")

            /* renamed from: g  reason: collision with root package name */
            public List<String> f69223g;
            @SerializedName("front_tag_url")

            /* renamed from: h  reason: collision with root package name */
            public String f69224h;
            @SerializedName("is_market_show")

            /* renamed from: i  reason: collision with root package name */
            public String f69225i;

            public boolean a(Object obj) {
                return obj instanceof TagInfo;
            }

            public String b() {
                return this.f69218b;
            }

            public String c() {
                return this.f69224h;
            }

            public String d() {
                return this.f69225i;
            }

            public List<String> e() {
                return this.f69223g;
            }

            public boolean equals(Object obj) {
                if (obj == this) {
                    return true;
                }
                if (!(obj instanceof TagInfo)) {
                    return false;
                }
                TagInfo tagInfo = (TagInfo) obj;
                if (!tagInfo.a(this)) {
                    return false;
                }
                Integer f11 = f();
                Integer f12 = tagInfo.f();
                if (f11 != null ? !f11.equals(f12) : f12 != null) {
                    return false;
                }
                String b11 = b();
                String b12 = tagInfo.b();
                if (b11 != null ? !b11.equals(b12) : b12 != null) {
                    return false;
                }
                String h11 = h();
                String h12 = tagInfo.h();
                if (h11 != null ? !h11.equals(h12) : h12 != null) {
                    return false;
                }
                String i11 = i();
                String i12 = tagInfo.i();
                if (i11 != null ? !i11.equals(i12) : i12 != null) {
                    return false;
                }
                String j11 = j();
                String j12 = tagInfo.j();
                if (j11 != null ? !j11.equals(j12) : j12 != null) {
                    return false;
                }
                String g11 = g();
                String g12 = tagInfo.g();
                if (g11 != null ? !g11.equals(g12) : g12 != null) {
                    return false;
                }
                List<String> e11 = e();
                List<String> e12 = tagInfo.e();
                if (e11 != null ? !e11.equals(e12) : e12 != null) {
                    return false;
                }
                String c11 = c();
                String c12 = tagInfo.c();
                if (c11 != null ? !c11.equals(c12) : c12 != null) {
                    return false;
                }
                String d11 = d();
                String d12 = tagInfo.d();
                return d11 != null ? d11.equals(d12) : d12 == null;
            }

            public Integer f() {
                return this.f69217a;
            }

            public String g() {
                return this.f69222f;
            }

            public String h() {
                return this.f69219c;
            }

            public int hashCode() {
                Integer f11 = f();
                int i11 = 43;
                int hashCode = f11 == null ? 43 : f11.hashCode();
                String b11 = b();
                int hashCode2 = ((hashCode + 59) * 59) + (b11 == null ? 43 : b11.hashCode());
                String h11 = h();
                int hashCode3 = (hashCode2 * 59) + (h11 == null ? 43 : h11.hashCode());
                String i12 = i();
                int hashCode4 = (hashCode3 * 59) + (i12 == null ? 43 : i12.hashCode());
                String j11 = j();
                int hashCode5 = (hashCode4 * 59) + (j11 == null ? 43 : j11.hashCode());
                String g11 = g();
                int hashCode6 = (hashCode5 * 59) + (g11 == null ? 43 : g11.hashCode());
                List<String> e11 = e();
                int hashCode7 = (hashCode6 * 59) + (e11 == null ? 43 : e11.hashCode());
                String c11 = c();
                int hashCode8 = (hashCode7 * 59) + (c11 == null ? 43 : c11.hashCode());
                String d11 = d();
                int i13 = hashCode8 * 59;
                if (d11 != null) {
                    i11 = d11.hashCode();
                }
                return i13 + i11;
            }

            public String i() {
                return this.f69220d;
            }

            public String j() {
                return this.f69221e;
            }

            public String toString() {
                return "ContractTagInfo.TagsGroupInfo.TagInfo(tagId=" + f() + ", frontTagId=" + b() + ", tagName=" + h() + ", tagNameEn=" + i() + ", tagNameSc=" + j() + ", tagLink=" + g() + ", productIds=" + e() + ", frontTagUrl=" + c() + ", isMarketShow=" + d() + ")";
            }
        }

        public boolean a(Object obj) {
            return obj instanceof TagsGroupInfo;
        }

        public String b() {
            return this.f69214b;
        }

        public Integer c() {
            return this.f69213a;
        }

        public String d() {
            return this.f69215c;
        }

        public List<TagInfo> e() {
            return this.f69216d;
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof TagsGroupInfo)) {
                return false;
            }
            TagsGroupInfo tagsGroupInfo = (TagsGroupInfo) obj;
            if (!tagsGroupInfo.a(this)) {
                return false;
            }
            Integer c11 = c();
            Integer c12 = tagsGroupInfo.c();
            if (c11 != null ? !c11.equals(c12) : c12 != null) {
                return false;
            }
            String b11 = b();
            String b12 = tagsGroupInfo.b();
            if (b11 != null ? !b11.equals(b12) : b12 != null) {
                return false;
            }
            String d11 = d();
            String d12 = tagsGroupInfo.d();
            if (d11 != null ? !d11.equals(d12) : d12 != null) {
                return false;
            }
            List<TagInfo> e11 = e();
            List<TagInfo> e12 = tagsGroupInfo.e();
            return e11 != null ? e11.equals(e12) : e12 == null;
        }

        public int hashCode() {
            Integer c11 = c();
            int i11 = 43;
            int hashCode = c11 == null ? 43 : c11.hashCode();
            String b11 = b();
            int hashCode2 = ((hashCode + 59) * 59) + (b11 == null ? 43 : b11.hashCode());
            String d11 = d();
            int hashCode3 = (hashCode2 * 59) + (d11 == null ? 43 : d11.hashCode());
            List<TagInfo> e11 = e();
            int i12 = hashCode3 * 59;
            if (e11 != null) {
                i11 = e11.hashCode();
            }
            return i12 + i11;
        }

        public String toString() {
            return "ContractTagInfo.TagsGroupInfo(tagGroupId=" + c() + ", frontTagGroupId=" + b() + ", tagGroupName=" + d() + ", tags=" + e() + ")";
        }
    }

    public boolean canEqual(Object obj) {
        return obj instanceof ContractTagInfo;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ContractTagInfo)) {
            return false;
        }
        ContractTagInfo contractTagInfo = (ContractTagInfo) obj;
        if (!contractTagInfo.canEqual(this)) {
            return false;
        }
        List<TagsGroupInfo> tagsGroup2 = getTagsGroup();
        List<TagsGroupInfo> tagsGroup3 = contractTagInfo.getTagsGroup();
        return tagsGroup2 != null ? tagsGroup2.equals(tagsGroup3) : tagsGroup3 == null;
    }

    public List<TagsGroupInfo> getTagsGroup() {
        return this.tagsGroup;
    }

    public int hashCode() {
        List<TagsGroupInfo> tagsGroup2 = getTagsGroup();
        return 59 + (tagsGroup2 == null ? 43 : tagsGroup2.hashCode());
    }

    public void setTagsGroup(List<TagsGroupInfo> list) {
        this.tagsGroup = list;
    }

    public String toString() {
        return "ContractTagInfo(tagsGroup=" + getTagsGroup() + ")";
    }
}
