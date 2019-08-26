package com.zhhl.personnel_contorl.data;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by miao on 2018/11/14.
 */
public class ItemBean implements Parcelable {

    private String icon;
    private String name;
    private String message;
    private String id;
    private long time;

    public long getTime() {
        return time;
    }

    public void setTime(long time) {
        this.time = time;
    }

    public int getScope() {
        return scope;
    }

    public void setScope(int scope) {
        this.scope = scope;
    }

    private int scope;

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public ItemBean() {
    }

    public ItemBean(String name, String message, String id) {

        this.name = name;
        this.message = message;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMessage(int pos,String title ) {
        return pos==0?"通过人员关系及轨迹分析等数据,分析得出<font color=red>" +title+"</font>"+ name + "疑似出现在XX位置......":"通过人员关系及轨迹分析等数据,分析得出" + name + "疑似出现在XX位置......";
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.name);
        dest.writeString(this.message);
        dest.writeString(this.id);
        dest.writeLong(this.time);
        dest.writeInt(this.scope);
        dest.writeString(this.icon);
    }

    private ItemBean(Parcel in) {
        this.name = in.readString();
        this.message = in.readString();
        this.id = in.readString();
        this.time = in.readLong();
        this.scope = in.readInt();
        this.icon = in.readString();
    }

    public static final Creator<ItemBean> CREATOR = new Creator<ItemBean>() {
        @Override
        public ItemBean createFromParcel(Parcel source) {
            return new ItemBean(source);
        }

        @Override
        public ItemBean[] newArray(int size) {
            return new ItemBean[size];
        }
    };
}
