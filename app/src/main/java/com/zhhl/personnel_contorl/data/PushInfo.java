package com.zhhl.personnel_contorl.data;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.List;

public class PushInfo {
    /**
     * code : 1
     * data : [{"id":"f56bb0c525444c8585ffa1829c0f492f","isNewRecord":false,"ztidcard":"220221198311048619","ztname":"王岩","zttime":"在逃855天","trackdiscription":"在逃人：王岩于20181227从吉林到龙嘉","tracktype":"0"},{"id":"1cc74ac5af0547acaec8da51791b15bd","isNewRecord":false,"ztidcard":"220211198703314514","ztname":"卢烨","zttime":"在逃560天","trackdiscription":"在逃人：卢烨于2019-1-4 2:36:00在途城市酒店入住","tracktype":"0"},{"id":"56ce7b56287a4d70be503fb5b5eff5c7","isNewRecord":false,"ztidcard":"220283198705120627","ztname":"吕瑶","zttime":"在逃909天","trackdiscription":"在逃人：吕瑶于20180625从吉林到龙嘉","tracktype":"0"},{"id":"840ab3ecdafb4827a1420922e0a14940","isNewRecord":false,"ztidcard":"220283198306010746","ztname":"葛丹丹","zttime":"在逃781天","trackdiscription":"在逃人：葛丹丹于2018-9-26 0:00:00从TAO到TAO","tracktype":"0"},{"id":"c787e9caf5914435b4ad74216f95ef1e","isNewRecord":false,"ztidcard":"220211198703314514","ztname":"卢烨","zttime":"在逃545天","trackdiscription":"在逃人：卢烨于2018-12-25 21:06:00在吉林市恒阳经贸有限责任公司伦威克酒店入住","tracktype":"0"},{"id":"1c227e99f2544a2f9cd289b962c7b117","isNewRecord":false,"ztidcard":"220204198206271214","ztname":"熊子豪","zttime":"在逃546天","trackdiscription":"在逃人：熊子豪于2018-08-13从吉林市客运换乘中心到集安","tracktype":"0"},{"id":"dcb89b0a9aff460bb90449d898100eb7","isNewRecord":false,"ztidcard":"220202199610127232","ztname":"李宝龙","zttime":"在逃1161天","trackdiscription":"在逃人：李宝龙于2018-11-18 20:14:44在天缘网吧上网","tracktype":"0"},{"id":"604c3b82001f45f290c896cd810a46ed","isNewRecord":false,"ztidcard":"220281196502020042","ztname":"吴艳平","zttime":"2019-02-20","trackdiscription":"信访人：吴艳平于20190104乘坐火车从蛟河西到长春","tracktype":"1"},{"id":"1b97b7e9d8d6464b99612722baa3db83","isNewRecord":false,"ztidcard":"220211197404280321","ztname":"王丽","zttime":"在逃636天","trackdiscription":"在逃人：王丽于2019-1-29 22:07:00在格莱美宾馆入住","tracktype":"0"}]
     */

    private String code;
    private List<DataBean> data;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean implements Parcelable {
        /**
         * id : f56bb0c525444c8585ffa1829c0f492f
         * isNewRecord : false
         * ztidcard : 220221198311048619
         * ztname : 王岩
         * zttime : 在逃855天
         * trackdiscription : 在逃人：王岩于20181227从吉林到龙嘉
         * tracktype : 0
         */

        private String id;
        private boolean isNewRecord;
        private String ztidcard;
        private String ztname;
        private String zttime;
        private String trackdiscription="";
        private String tracktype;
        private String createtime="";
        private boolean isOpen;

        public boolean isOpen() {
            return isOpen;
        }

        public void setOpen(boolean open) {
            isOpen = open;
        }

        public String getCreatetime() {
            return createtime;
        }

        public void setCreatetime(String createtime) {
            this.createtime = createtime;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public boolean isIsNewRecord() {
            return isNewRecord;
        }

        public void setIsNewRecord(boolean isNewRecord) {
            this.isNewRecord = isNewRecord;
        }

        public String getZtidcard() {
            return ztidcard;
        }

        public void setZtidcard(String ztidcard) {
            this.ztidcard = ztidcard;
        }

        public String getZtname() {
            return ztname;
        }

        public void setZtname(String ztname) {
            this.ztname = ztname;
        }

        public String getZttime() {
            return zttime;
        }

        public void setZttime(String zttime) {
            this.zttime = zttime;
        }

        public String getTrackdiscription() {
            return trackdiscription;
        }

        public void setTrackdiscription(String trackdiscription) {
            this.trackdiscription = trackdiscription;
        }

        public String getTracktype() {
            return tracktype;
        }

        public void setTracktype(String tracktype) {
            this.tracktype = tracktype;
        }

        @Override
        public int describeContents() {
            return 0;
        }

        @Override
        public void writeToParcel(Parcel dest, int flags) {
            dest.writeString(this.id);
            dest.writeByte(this.isNewRecord ? (byte) 1 : (byte) 0);
            dest.writeString(this.ztidcard);
            dest.writeString(this.ztname);
            dest.writeString(this.zttime);
            dest.writeString(this.trackdiscription);
            dest.writeString(this.tracktype);
            dest.writeString(this.createtime);
            dest.writeByte(this.isOpen ? (byte) 1 : (byte) 0);
        }

        public DataBean() {
        }

        protected DataBean(Parcel in) {
            this.id = in.readString();
            this.isNewRecord = in.readByte() != 0;
            this.ztidcard = in.readString();
            this.ztname = in.readString();
            this.zttime = in.readString();
            this.trackdiscription = in.readString();
            this.tracktype = in.readString();
            this.createtime = in.readString();
            this.isOpen = in.readByte() != 0;
        }

        public static final Creator<DataBean> CREATOR = new Creator<DataBean>() {
            @Override
            public DataBean createFromParcel(Parcel source) {
                return new DataBean(source);
            }

            @Override
            public DataBean[] newArray(int size) {
                return new DataBean[size];
            }
        };
    }
}
