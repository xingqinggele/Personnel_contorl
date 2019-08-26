package com.zhhl.personnel_contorl.data;

import java.util.List;

/**
 * Created by miao on 2018/11/27.
 */
public class Cunguanzhixi {

    /**
     * hunyin : [{"id":"10003177769","isNewRecord":false,"deptName":"绿园区民政局婚姻登记处","opDate":"2016-12-21 00:00:00","certNo":"BJ220106-2016-001806","nameMan":"计洪伟","nameWoman":"宋微","certNumMan":"230826198005280037","certNumWoman":"220106198411171623","nationMan":"156","nationWoman":"156","opType":"补办结婚","gxsj":"2018-10-18 10:26:06"}]
     * Message : 成功
     * State : 0
     * renkou : [{"isNewRecord":true,"xlh":37160667,"ryzt":0,"sssxq":"220100","slsj":"20180502112635","ywFl":"010152","ryId":"230826198005280037000036093300","gmsfhm":"230826198005280037","xm":"计洪伟","xbdm":"1","mzdm":"01","csrq":"19800528","csdGjhdqdm":"156","csdssxdm":"230826","csdDzmc":"悦来镇冷云村","jgGjhdqdm":"156","jgXzqhdm":"230826","dzbm":"1FBF98EE-668C-0662-E053-0A6A1C9FBD80","hjdzXzqhdm":"220106","dzmc":"正阳街道西安大路委80组","rhyzbs":"1","xldm":"30","hyzkdm":"20","lxdh":"18844169788","byzkdm":"1","sg":"173","xxdm":"1","lbssj":"20161221","lbsyyJyqk":"171","lzdGjhdqdm":"156","lzdXzqhdm":"210381","rkxxjbdm":"15","xpid":63057439,"hh":"012694308","hlxdm":"10","yhzgxdm":"11","sspcsjgdm":"220106665","sjgsdwmc":"长春市正阳街派出所","jmsfzXlh":42270537,"jmsfzjqfjgDwmc":"长春市公安局绿园分局","jmydsfzQfrq":"20180502","yxqqsrq":"20180426","yxqjzrq":"20380426","jmsfzslyydm":"41","xzjddm":"220106002","sqjcwhdm":"220106002031","sqjcwhmc":"220106002031076","xmhypy":"jihongwei","syrkXlh":36093300,"qyGjhdqdm":"156","qydXzqhdm":"210381","bdSj":"20180502112635","qyldyydm":"171","qlcrq":"20161221","sfzjx":"0","fxjZzjgdm":"220106","xxrksj":"20161222023035","djsj":"20161222023035","rgxksj":"2018-05-06 06:01:52"}]
     */

    private String Message;
    private String State;
    private List<HunyinBean> hunyin;
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

    public List<HunyinBean> getHunyin() {
        return hunyin;
    }

    public void setHunyin(List<HunyinBean> hunyin) {
        this.hunyin = hunyin;
    }

    public List<RenkouBean> getRenkou() {
        return renkou;
    }

    public void setRenkou(List<RenkouBean> renkou) {
        this.renkou = renkou;
    }

    public static class HunyinBean {
        /**
         * id : 10003177769
         * isNewRecord : false
         * deptName : 绿园区民政局婚姻登记处
         * opDate : 2016-12-21 00:00:00
         * certNo : BJ220106-2016-001806
         * nameMan : 计洪伟
         * nameWoman : 宋微
         * certNumMan : 230826198005280037
         * certNumWoman : 220106198411171623
         * nationMan : 156
         * nationWoman : 156
         * opType : 补办结婚
         * gxsj : 2018-10-18 10:26:06
         */

        private String id;
        private boolean isNewRecord;
        private String deptName;
        private String opDate;
        private String certNo;
        private String nameMan;
        private String nameWoman;
        private String certNumMan;
        private String certNumWoman;
        private String nationMan;
        private String nationWoman;
        private String opType;
        private String gxsj;

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

        public String getDeptName() {
            return deptName;
        }

        public void setDeptName(String deptName) {
            this.deptName = deptName;
        }

        public String getOpDate() {
            return opDate;
        }

        public void setOpDate(String opDate) {
            this.opDate = opDate;
        }

        public String getCertNo() {
            return certNo;
        }

        public void setCertNo(String certNo) {
            this.certNo = certNo;
        }

        public String getNameMan() {
            return nameMan;
        }

        public void setNameMan(String nameMan) {
            this.nameMan = nameMan;
        }

        public String getNameWoman() {
            return nameWoman;
        }

        public void setNameWoman(String nameWoman) {
            this.nameWoman = nameWoman;
        }

        public String getCertNumMan() {
            return certNumMan;
        }

        public void setCertNumMan(String certNumMan) {
            this.certNumMan = certNumMan;
        }

        public String getCertNumWoman() {
            return certNumWoman;
        }

        public void setCertNumWoman(String certNumWoman) {
            this.certNumWoman = certNumWoman;
        }

        public String getNationMan() {
            return nationMan;
        }

        public void setNationMan(String nationMan) {
            this.nationMan = nationMan;
        }

        public String getNationWoman() {
            return nationWoman;
        }

        public void setNationWoman(String nationWoman) {
            this.nationWoman = nationWoman;
        }

        public String getOpType() {
            return opType;
        }

        public void setOpType(String opType) {
            this.opType = opType;
        }

        public String getGxsj() {
            return gxsj;
        }

        public void setGxsj(String gxsj) {
            this.gxsj = gxsj;
        }
    }

    public static class RenkouBean {
        /**
         * isNewRecord : true
         * xlh : 37160667
         * ryzt : 0
         * sssxq : 220100
         * slsj : 20180502112635
         * ywFl : 010152
         * ryId : 230826198005280037000036093300
         * gmsfhm : 230826198005280037
         * xm : 计洪伟
         * xbdm : 1
         * mzdm : 01
         * csrq : 19800528
         * csdGjhdqdm : 156
         * csdssxdm : 230826
         * csdDzmc : 悦来镇冷云村
         * jgGjhdqdm : 156
         * jgXzqhdm : 230826
         * dzbm : 1FBF98EE-668C-0662-E053-0A6A1C9FBD80
         * hjdzXzqhdm : 220106
         * dzmc : 正阳街道西安大路委80组
         * rhyzbs : 1
         * xldm : 30
         * hyzkdm : 20
         * lxdh : 18844169788
         * byzkdm : 1
         * sg : 173
         * xxdm : 1
         * lbssj : 20161221
         * lbsyyJyqk : 171
         * lzdGjhdqdm : 156
         * lzdXzqhdm : 210381
         * rkxxjbdm : 15
         * xpid : 63057439
         * hh : 012694308
         * hlxdm : 10
         * yhzgxdm : 11
         * sspcsjgdm : 220106665
         * sjgsdwmc : 长春市正阳街派出所
         * jmsfzXlh : 42270537
         * jmsfzjqfjgDwmc : 长春市公安局绿园分局
         * jmydsfzQfrq : 20180502
         * yxqqsrq : 20180426
         * yxqjzrq : 20380426
         * jmsfzslyydm : 41
         * xzjddm : 220106002
         * sqjcwhdm : 220106002031
         * sqjcwhmc : 220106002031076
         * xmhypy : jihongwei
         * syrkXlh : 36093300
         * qyGjhdqdm : 156
         * qydXzqhdm : 210381
         * bdSj : 20180502112635
         * qyldyydm : 171
         * qlcrq : 20161221
         * sfzjx : 0
         * fxjZzjgdm : 220106
         * xxrksj : 20161222023035
         * djsj : 20161222023035
         * rgxksj : 2018-05-06 06:01:52
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
        private String csdDzmc;
        private String jgGjhdqdm;
        private String jgXzqhdm;
        private String dzbm;
        private String hjdzXzqhdm;
        private String dzmc;
        private String rhyzbs;
        private String xldm;
        private String hyzkdm;
        private String lxdh;
        private String byzkdm;
        private String sg;
        private String xxdm;
        private String lbssj;
        private String lbsyyJyqk;
        private String lzdGjhdqdm;
        private String lzdXzqhdm;
        private String rkxxjbdm;
        private int xpid;
        private String hh;
        private String hlxdm;
        private String yhzgxdm;
        private String sspcsjgdm;
        private String sjgsdwmc;
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
        private int syrkXlh;
        private String qyGjhdqdm;
        private String qydXzqhdm;
        private String bdSj;
        private String qyldyydm;
        private String qlcrq;
        private String sfzjx;
        private String fxjZzjgdm;
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

        public String getCsdDzmc() {
            return csdDzmc;
        }

        public void setCsdDzmc(String csdDzmc) {
            this.csdDzmc = csdDzmc;
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

        public String getLxdh() {
            return lxdh;
        }

        public void setLxdh(String lxdh) {
            this.lxdh = lxdh;
        }

        public String getByzkdm() {
            return byzkdm;
        }

        public void setByzkdm(String byzkdm) {
            this.byzkdm = byzkdm;
        }

        public String getSg() {
            return sg;
        }

        public void setSg(String sg) {
            this.sg = sg;
        }

        public String getXxdm() {
            return xxdm;
        }

        public void setXxdm(String xxdm) {
            this.xxdm = xxdm;
        }

        public String getLbssj() {
            return lbssj;
        }

        public void setLbssj(String lbssj) {
            this.lbssj = lbssj;
        }

        public String getLbsyyJyqk() {
            return lbsyyJyqk;
        }

        public void setLbsyyJyqk(String lbsyyJyqk) {
            this.lbsyyJyqk = lbsyyJyqk;
        }

        public String getLzdGjhdqdm() {
            return lzdGjhdqdm;
        }

        public void setLzdGjhdqdm(String lzdGjhdqdm) {
            this.lzdGjhdqdm = lzdGjhdqdm;
        }

        public String getLzdXzqhdm() {
            return lzdXzqhdm;
        }

        public void setLzdXzqhdm(String lzdXzqhdm) {
            this.lzdXzqhdm = lzdXzqhdm;
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

        public String getSjgsdwmc() {
            return sjgsdwmc;
        }

        public void setSjgsdwmc(String sjgsdwmc) {
            this.sjgsdwmc = sjgsdwmc;
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

        public int getSyrkXlh() {
            return syrkXlh;
        }

        public void setSyrkXlh(int syrkXlh) {
            this.syrkXlh = syrkXlh;
        }

        public String getQyGjhdqdm() {
            return qyGjhdqdm;
        }

        public void setQyGjhdqdm(String qyGjhdqdm) {
            this.qyGjhdqdm = qyGjhdqdm;
        }

        public String getQydXzqhdm() {
            return qydXzqhdm;
        }

        public void setQydXzqhdm(String qydXzqhdm) {
            this.qydXzqhdm = qydXzqhdm;
        }

        public String getBdSj() {
            return bdSj;
        }

        public void setBdSj(String bdSj) {
            this.bdSj = bdSj;
        }

        public String getQyldyydm() {
            return qyldyydm;
        }

        public void setQyldyydm(String qyldyydm) {
            this.qyldyydm = qyldyydm;
        }

        public String getQlcrq() {
            return qlcrq;
        }

        public void setQlcrq(String qlcrq) {
            this.qlcrq = qlcrq;
        }

        public String getSfzjx() {
            return sfzjx;
        }

        public void setSfzjx(String sfzjx) {
            this.sfzjx = sfzjx;
        }

        public String getFxjZzjgdm() {
            return fxjZzjgdm;
        }

        public void setFxjZzjgdm(String fxjZzjgdm) {
            this.fxjZzjgdm = fxjZzjgdm;
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
