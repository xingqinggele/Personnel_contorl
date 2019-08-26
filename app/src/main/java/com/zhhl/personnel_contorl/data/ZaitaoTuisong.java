package com.zhhl.personnel_contorl.data;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.List;

/**
 * Created by miao on 2018/12/28.
 */
public class ZaitaoTuisong {
    /**
     * date : [{"id":"56ce7b56287a4d70be503fb5b5eff5c7","isNewRecord":false,"ztidcard":"220283198705120627","ztname":"吕瑶","zttime":"在逃909天","trackdiscription":"在逃人：吕瑶于20180625从吉林到龙嘉","createtime":"2018-12-26 09:33:16","abnormacause":"异常","status":"0","outlawrelation":"本人","abnormaltime":"20180625","relationidcard":"220283198705120627"},{"id":"840ab3ecdafb4827a1420922e0a14940","isNewRecord":false,"ztidcard":"220283198306010746","ztname":"葛丹丹","zttime":"在逃781天","trackdiscription":"在逃人：葛丹丹于2018-9-26 0:00:00从TAO到TAO","createtime":"2018-12-26 09:33:46","abnormacause":"异常","status":"1","outlawrelation":"本人","abnormaltime":"2018-9-26 0:00:00","relationidcard":"220283198306010746"},{"id":"c787e9caf5914435b4ad74216f95ef1e","isNewRecord":false,"ztidcard":"220211198703314514","ztname":"卢烨","zttime":"在逃545天","trackdiscription":"在逃人：卢烨于2018-12-25 21:06:00在吉林市恒阳经贸有限责任公司伦威克酒店入住","createtime":"2018-12-26 09:36:31","abnormacause":"异常","status":"0","outlawrelation":"本人","abnormaltime":"2018-12-25 21:06:00","relationidcard":"220211198703314514"},{"id":"1c227e99f2544a2f9cd289b962c7b117","isNewRecord":false,"ztidcard":"220204198206271214","ztname":"熊子豪","zttime":"在逃546天","trackdiscription":"在逃人：熊子豪于2018-08-13从吉林市客运换乘中心到集安","createtime":"2018-12-26 09:37:01","abnormacause":"异常","status":"0","outlawrelation":"本人","abnormaltime":"2018-08-13","relationidcard":"220204198206271214"},{"id":"dcb89b0a9aff460bb90449d898100eb7","isNewRecord":false,"ztidcard":"220202199610127232","ztname":"李宝龙","zttime":"在逃1161天","trackdiscription":"在逃人：李宝龙于2018-11-18 20:14:44在天缘网吧上网","createtime":"2018-12-26 09:37:03","abnormacause":"异常","status":"0","outlawrelation":"本人","abnormaltime":"2018-11-18 20:14:44","relationidcard":"220202199610127232"}]
     * code : 1
     */

    private String code;
    private List<DateBean> date;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public List<DateBean> getDate() {
        return date;
    }

    public void setDate(List<DateBean> date) {
        this.date = date;
    }

    public static class DateBean implements Parcelable {
        /**
         * id : 56ce7b56287a4d70be503fb5b5eff5c7
         * isNewRecord : false
         * ztidcard : 220283198705120627
         * ztname : 吕瑶
         * zttime : 在逃909天
         * trackdiscription : 在逃人：吕瑶于20180625从吉林到龙嘉
         * createtime : 2018-12-26 09:33:16
         * abnormacause : 异常
         * status : 0
         * outlawrelation : 本人
         * abnormaltime : 20180625
         * relationidcard : 220283198705120627
         */

        private String id;
        private boolean isNewRecord;
        private String ztidcard;
        private String ztname;
        private String zttime;
        private String trackdiscription;
        private String createtime;
        private String abnormacause;
        private String status;
        private String outlawrelation;
        private String abnormaltime;
        private String relationidcard;

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

        public String getCreatetime() {
            return createtime;
        }

        public void setCreatetime(String createtime) {
            this.createtime = createtime;
        }

        public String getAbnormacause() {
            return abnormacause;
        }

        public void setAbnormacause(String abnormacause) {
            this.abnormacause = abnormacause;
        }

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }

        public String getOutlawrelation() {
            return outlawrelation;
        }

        public void setOutlawrelation(String outlawrelation) {
            this.outlawrelation = outlawrelation;
        }

        public String getAbnormaltime() {
            return abnormaltime;
        }

        public void setAbnormaltime(String abnormaltime) {
            this.abnormaltime = abnormaltime;
        }

        public String getRelationidcard() {
            return relationidcard;
        }

        public void setRelationidcard(String relationidcard) {
            this.relationidcard = relationidcard;
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
            dest.writeString(this.createtime);
            dest.writeString(this.abnormacause);
            dest.writeString(this.status);
            dest.writeString(this.outlawrelation);
            dest.writeString(this.abnormaltime);
            dest.writeString(this.relationidcard);
        }

        public DateBean() {
        }

        DateBean(Parcel in) {
            this.id = in.readString();
            this.isNewRecord = in.readByte() != 0;
            this.ztidcard = in.readString();
            this.ztname = in.readString();
            this.zttime = in.readString();
            this.trackdiscription = in.readString();
            this.createtime = in.readString();
            this.abnormacause = in.readString();
            this.status = in.readString();
            this.outlawrelation = in.readString();
            this.abnormaltime = in.readString();
            this.relationidcard = in.readString();
        }

        public static final Creator<DateBean> CREATOR = new Creator<DateBean>() {
            @Override
            public DateBean createFromParcel(Parcel source) {
                return new DateBean(source);
            }

            @Override
            public DateBean[] newArray(int size) {
                return new DateBean[size];
            }
        };
    }
}
