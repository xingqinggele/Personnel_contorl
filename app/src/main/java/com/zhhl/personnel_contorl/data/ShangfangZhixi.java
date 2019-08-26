package com.zhhl.personnel_contorl.data;

import java.util.List;

/**
 * Created by miao on 2018/11/25.
 */
public class ShangfangZhixi {
    /**
     * hunyin : []
     * Message : 失败
     * State : 1
     * renkou : [{"isNewRecord":true,"xlh":32158645,"ryzt":0,"sssxq":"220300","slsj":"20120301104013","ywFl":"010152","ryId":"229001193504024831000032158645","gmsfhm":"229001193504024831","xm":"秦显章","xbdm":"1","mzdm":"01","csrq":"19350402","csdGjhdqdm":"156","csdssxdm":"220381","jgGjhdqdm":"156","jgXzqhdm":"220381","dzbm":"2203818300000000009907","hjdzXzqhdm":"220381","dzmc":"桑树台镇永清村四组","rhyzbs":"1","xldm":"70","hyzkdm":"20","zjxydm":"00","byzkdm":"0","xxdm":"0","rkxxjbdm":"15","xpid":51316086,"hh":"011011777","hlxdm":"12","yhzgxdm":"02","sspcsjgdm":"220381216","jmsfzXlh":27285475,"jmsfzjqfjgDwmc":"公主岭市公安局","jmydsfzQfrq":"20120301","yxqqsrq":"20120301","yxqjzrq":"长期","jmsfzslyydm":"21","xzjddm":"220381102","sqjcwhdm":"220381102006","sqjcwhmc":"220300004","xmhypy":"qinxianzhang","bz":"216000066","syrkXlh":30994993,"wbHh":"216000066","bdSj":"20120301104013","hh8":"216003513","xlh8":1126253,"sfzjx":"0","xxrksj":"20140925102740","djsj":"20140925102740","rgxksj":"2018-03-07 17:36:19"}]
     */

    private String Message;
    private String State;
    private List<?> hunyin;
    private List<RenkouBean> renkou;

    public String getMessage() {
        return Message;
    }

    public void setMessage(String Message) {
        this.Message = Message;
    }

    public String getState() {
        return State;
    }

    public void setState(String State) {
        this.State = State;
    }

    public List<?> getHunyin() {
        return hunyin;
    }

    public void setHunyin(List<?> hunyin) {
        this.hunyin = hunyin;
    }

    public List<RenkouBean> getRenkou() {
        return renkou;
    }

    public void setRenkou(List<RenkouBean> renkou) {
        this.renkou = renkou;
    }

    public static class RenkouBean {
        /**
         * isNewRecord : true
         * xlh : 32158645
         * ryzt : 0
         * sssxq : 220300
         * slsj : 20120301104013
         * ywFl : 010152
         * ryId : 229001193504024831000032158645
         * gmsfhm : 229001193504024831
         * xm : 秦显章
         * xbdm : 1
         * mzdm : 01
         * csrq : 19350402
         * csdGjhdqdm : 156
         * csdssxdm : 220381
         * jgGjhdqdm : 156
         * jgXzqhdm : 220381
         * dzbm : 2203818300000000009907
         * hjdzXzqhdm : 220381
         * dzmc : 桑树台镇永清村四组
         * rhyzbs : 1
         * xldm : 70
         * hyzkdm : 20
         * zjxydm : 00
         * byzkdm : 0
         * xxdm : 0
         * rkxxjbdm : 15
         * xpid : 51316086
         * hh : 011011777
         * hlxdm : 12
         * yhzgxdm : 02
         * sspcsjgdm : 220381216
         * jmsfzXlh : 27285475
         * jmsfzjqfjgDwmc : 公主岭市公安局
         * jmydsfzQfrq : 20120301
         * yxqqsrq : 20120301
         * yxqjzrq : 长期
         * jmsfzslyydm : 21
         * xzjddm : 220381102
         * sqjcwhdm : 220381102006
         * sqjcwhmc : 220300004
         * xmhypy : qinxianzhang
         * bz : 216000066
         * syrkXlh : 30994993
         * wbHh : 216000066
         * bdSj : 20120301104013
         * hh8 : 216003513
         * xlh8 : 1126253
         * sfzjx : 0
         * xxrksj : 20140925102740
         * djsj : 20140925102740
         * rgxksj : 2018-03-07 17:36:19
         */

        private boolean isNewRecord;
        private int xlh;
        private int ryzt;
        private String sssxq;
        private String slsj;
        private String ywFl;
        private String ryId;
        private String gmsfhm;
        private String xm;
        private String xbdm;
        private String mzdm;
        private String csrq;
        private String csdGjhdqdm;
        private String csdssxdm;
        private String jgGjhdqdm;
        private String jgXzqhdm;
        private String dzbm;
        private String hjdzXzqhdm;
        private String dzmc;
        private String rhyzbs;
        private String xldm;
        private String hyzkdm;
        private String zjxydm;
        private String byzkdm;
        private String xxdm;
        private String rkxxjbdm;
        private int xpid;
        private String hh;
        private String hlxdm;
        private String yhzgxdm;
        private String sspcsjgdm;
        private int jmsfzXlh;
        private String jmsfzjqfjgDwmc;
        private String jmydsfzQfrq;
        private String yxqqsrq;
        private String yxqjzrq;
        private String jmsfzslyydm;
        private String xzjddm;
        private String sqjcwhdm;
        private String sqjcwhmc;
        private String xmhypy;
        private String bz;
        private int syrkXlh;
        private String wbHh;
        private String bdSj;
        private String hh8;
        private int xlh8;
        private String sfzjx;
        private String xxrksj;
        private String djsj;
        private String rgxksj;

        public boolean isIsNewRecord() {
            return isNewRecord;
        }

        public void setIsNewRecord(boolean isNewRecord) {
            this.isNewRecord = isNewRecord;
        }

        public int getXlh() {
            return xlh;
        }

        public void setXlh(int xlh) {
            this.xlh = xlh;
        }

        public int getRyzt() {
            return ryzt;
        }

        public void setRyzt(int ryzt) {
            this.ryzt = ryzt;
        }

        public String getSssxq() {
            return sssxq;
        }

        public void setSssxq(String sssxq) {
            this.sssxq = sssxq;
        }

        public String getSlsj() {
            return slsj;
        }

        public void setSlsj(String slsj) {
            this.slsj = slsj;
        }

        public String getYwFl() {
            return ywFl;
        }

        public void setYwFl(String ywFl) {
            this.ywFl = ywFl;
        }

        public String getRyId() {
            return ryId;
        }

        public void setRyId(String ryId) {
            this.ryId = ryId;
        }

        public String getGmsfhm() {
            return gmsfhm;
        }

        public void setGmsfhm(String gmsfhm) {
            this.gmsfhm = gmsfhm;
        }

        public String getXm() {
            return xm;
        }

        public void setXm(String xm) {
            this.xm = xm;
        }

        public String getXbdm() {
            return xbdm;
        }

        public void setXbdm(String xbdm) {
            this.xbdm = xbdm;
        }

        public String getMzdm() {
            return mzdm;
        }

        public void setMzdm(String mzdm) {
            this.mzdm = mzdm;
        }

        public String getCsrq() {
            return csrq;
        }

        public void setCsrq(String csrq) {
            this.csrq = csrq;
        }

        public String getCsdGjhdqdm() {
            return csdGjhdqdm;
        }

        public void setCsdGjhdqdm(String csdGjhdqdm) {
            this.csdGjhdqdm = csdGjhdqdm;
        }

        public String getCsdssxdm() {
            return csdssxdm;
        }

        public void setCsdssxdm(String csdssxdm) {
            this.csdssxdm = csdssxdm;
        }

        public String getJgGjhdqdm() {
            return jgGjhdqdm;
        }

        public void setJgGjhdqdm(String jgGjhdqdm) {
            this.jgGjhdqdm = jgGjhdqdm;
        }

        public String getJgXzqhdm() {
            return jgXzqhdm;
        }

        public void setJgXzqhdm(String jgXzqhdm) {
            this.jgXzqhdm = jgXzqhdm;
        }

        public String getDzbm() {
            return dzbm;
        }

        public void setDzbm(String dzbm) {
            this.dzbm = dzbm;
        }

        public String getHjdzXzqhdm() {
            return hjdzXzqhdm;
        }

        public void setHjdzXzqhdm(String hjdzXzqhdm) {
            this.hjdzXzqhdm = hjdzXzqhdm;
        }

        public String getDzmc() {
            return dzmc;
        }

        public void setDzmc(String dzmc) {
            this.dzmc = dzmc;
        }

        public String getRhyzbs() {
            return rhyzbs;
        }

        public void setRhyzbs(String rhyzbs) {
            this.rhyzbs = rhyzbs;
        }

        public String getXldm() {
            return xldm;
        }

        public void setXldm(String xldm) {
            this.xldm = xldm;
        }

        public String getHyzkdm() {
            return hyzkdm;
        }

        public void setHyzkdm(String hyzkdm) {
            this.hyzkdm = hyzkdm;
        }

        public String getZjxydm() {
            return zjxydm;
        }

        public void setZjxydm(String zjxydm) {
            this.zjxydm = zjxydm;
        }

        public String getByzkdm() {
            return byzkdm;
        }

        public void setByzkdm(String byzkdm) {
            this.byzkdm = byzkdm;
        }

        public String getXxdm() {
            return xxdm;
        }

        public void setXxdm(String xxdm) {
            this.xxdm = xxdm;
        }

        public String getRkxxjbdm() {
            return rkxxjbdm;
        }

        public void setRkxxjbdm(String rkxxjbdm) {
            this.rkxxjbdm = rkxxjbdm;
        }

        public int getXpid() {
            return xpid;
        }

        public void setXpid(int xpid) {
            this.xpid = xpid;
        }

        public String getHh() {
            return hh;
        }

        public void setHh(String hh) {
            this.hh = hh;
        }

        public String getHlxdm() {
            return hlxdm;
        }

        public void setHlxdm(String hlxdm) {
            this.hlxdm = hlxdm;
        }

        public String getYhzgxdm() {
            return yhzgxdm;
        }

        public void setYhzgxdm(String yhzgxdm) {
            this.yhzgxdm = yhzgxdm;
        }

        public String getSspcsjgdm() {
            return sspcsjgdm;
        }

        public void setSspcsjgdm(String sspcsjgdm) {
            this.sspcsjgdm = sspcsjgdm;
        }

        public int getJmsfzXlh() {
            return jmsfzXlh;
        }

        public void setJmsfzXlh(int jmsfzXlh) {
            this.jmsfzXlh = jmsfzXlh;
        }

        public String getJmsfzjqfjgDwmc() {
            return jmsfzjqfjgDwmc;
        }

        public void setJmsfzjqfjgDwmc(String jmsfzjqfjgDwmc) {
            this.jmsfzjqfjgDwmc = jmsfzjqfjgDwmc;
        }

        public String getJmydsfzQfrq() {
            return jmydsfzQfrq;
        }

        public void setJmydsfzQfrq(String jmydsfzQfrq) {
            this.jmydsfzQfrq = jmydsfzQfrq;
        }

        public String getYxqqsrq() {
            return yxqqsrq;
        }

        public void setYxqqsrq(String yxqqsrq) {
            this.yxqqsrq = yxqqsrq;
        }

        public String getYxqjzrq() {
            return yxqjzrq;
        }

        public void setYxqjzrq(String yxqjzrq) {
            this.yxqjzrq = yxqjzrq;
        }

        public String getJmsfzslyydm() {
            return jmsfzslyydm;
        }

        public void setJmsfzslyydm(String jmsfzslyydm) {
            this.jmsfzslyydm = jmsfzslyydm;
        }

        public String getXzjddm() {
            return xzjddm;
        }

        public void setXzjddm(String xzjddm) {
            this.xzjddm = xzjddm;
        }

        public String getSqjcwhdm() {
            return sqjcwhdm;
        }

        public void setSqjcwhdm(String sqjcwhdm) {
            this.sqjcwhdm = sqjcwhdm;
        }

        public String getSqjcwhmc() {
            return sqjcwhmc;
        }

        public void setSqjcwhmc(String sqjcwhmc) {
            this.sqjcwhmc = sqjcwhmc;
        }

        public String getXmhypy() {
            return xmhypy;
        }

        public void setXmhypy(String xmhypy) {
            this.xmhypy = xmhypy;
        }

        public String getBz() {
            return bz;
        }

        public void setBz(String bz) {
            this.bz = bz;
        }

        public int getSyrkXlh() {
            return syrkXlh;
        }

        public void setSyrkXlh(int syrkXlh) {
            this.syrkXlh = syrkXlh;
        }

        public String getWbHh() {
            return wbHh;
        }

        public void setWbHh(String wbHh) {
            this.wbHh = wbHh;
        }

        public String getBdSj() {
            return bdSj;
        }

        public void setBdSj(String bdSj) {
            this.bdSj = bdSj;
        }

        public String getHh8() {
            return hh8;
        }

        public void setHh8(String hh8) {
            this.hh8 = hh8;
        }

        public int getXlh8() {
            return xlh8;
        }

        public void setXlh8(int xlh8) {
            this.xlh8 = xlh8;
        }

        public String getSfzjx() {
            return sfzjx;
        }

        public void setSfzjx(String sfzjx) {
            this.sfzjx = sfzjx;
        }

        public String getXxrksj() {
            return xxrksj;
        }

        public void setXxrksj(String xxrksj) {
            this.xxrksj = xxrksj;
        }

        public String getDjsj() {
            return djsj;
        }

        public void setDjsj(String djsj) {
            this.djsj = djsj;
        }

        public String getRgxksj() {
            return rgxksj;
        }

        public void setRgxksj(String rgxksj) {
            this.rgxksj = rgxksj;
        }
    }
}
