package com.zhhl.personnel_contorl.data;


import androidx.annotation.NonNull;


import com.zhhl.personnel_contorl.utils.DateUtil;

import java.util.ArrayList;


/**
 * Created by miao on 2018/10/10.
 */
public class PersonTrajectory implements Comparable<PersonTrajectory> {
    private int type = 0;
    private long time;
    private String name;

    public PersonTrajectory() {
    }

    private Trajectory.KecheBean kecheBean;//12
    private Trajectory.MinhangBean minhangBean;//13
    private Trajectory.ShangwangBean shangwangBean;//14
    private Trajectory.TielugoupiaoBean tielugoupiaoBean;//15
    private Trajectory.ZhudianBean zhudianBean;//16
    private Trajectory.KakouBean kakouBean;//17


    private GuijiCQDWrapper wrapper;//21

    private GxrData2.HunyinBean hunyin2;//33
    private GxrData2.QinshuBean qinshu2;//34


    private ArrayList<GxrData2.HbtxBean> hbtx2;//46
    private ArrayList<GxrData2.HctxBean> hctx2;//47
    private ArrayList<GxrData2.KctxBean> kctx2;//48
    private ArrayList<GxrData2.ZstxBean> zstx2;//49
    private ArrayList<GxrData2.HclzBean> hclz2;//50

    private SimpleCarInfo carInfo;//51

    private GxclData.QsclBean gxcl;//61

    public ArrayList<GxrData2.HbtxBean> getHbtx2() {
        return hbtx2;
    }

    public ArrayList<GxrData2.HctxBean> getHctx2() {
        return hctx2;
    }

    public ArrayList<GxrData2.KctxBean> getKctx2() {
        return kctx2;
    }

    public ArrayList<GxrData2.HclzBean> getHclz2() {
        return hclz2;
    }

    public ArrayList<GxrData2.ZstxBean> getZstx2() {
        return zstx2;
    }

    public GxrData2.QinshuBean getQinshu2() {
        return qinshu2;
    }

    public GxrData2.HunyinBean getHunyin2() {
        return hunyin2;
    }


    private void setHunyin2(GxrData2.HunyinBean hunyin2) {
        this.hunyin2 = hunyin2;
        type = 33;
        time = System.currentTimeMillis()+20;
    }

    private void setQinshu2(GxrData2.QinshuBean qinshu2) {
        this.qinshu2 = qinshu2;
        type = 34;
        time = System.currentTimeMillis()+10;
    }


    private void setGxcl(GxclData.QsclBean gxcl) {
        this.gxcl = gxcl;
        type = 61;
        time = System.currentTimeMillis();
    }

    public GxclData.QsclBean getGxcl() {
        return gxcl;
    }

    public PersonTrajectory(GxclData.QsclBean o) {
        setGxcl(o);
    }

    public PersonTrajectory(GxrData2.HunyinBean o) {
        setHunyin2(o);
    }

    public PersonTrajectory(GxrData2.QinshuBean o) {
        setQinshu2(o);
    }

    public PersonTrajectory(GuijiCQDWrapper wrapper) {
        setData(wrapper);
    }

    public GuijiCQDWrapper getWrapper() {
        return wrapper;
    }

    private void setData(GuijiCQDWrapper wrapper) {
        type = 21;
        time = System.currentTimeMillis();
        this.wrapper = wrapper;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public long getTime() {
        return time;
    }

    public void setTime(long time) {
        this.time = time;
    }

    public PersonTrajectory(Trajectory.KecheBean kecheBean) {
        setData(kecheBean);
    }

    public PersonTrajectory(Trajectory.MinhangBean minhangBean) {
        setData(minhangBean);
    }

    public PersonTrajectory(Trajectory.ShangwangBean shangwangBean) {
        setData(shangwangBean);
    }

    public PersonTrajectory(Trajectory.TielugoupiaoBean tielugoupiaoBean) {
        setData(tielugoupiaoBean);
    }

    public PersonTrajectory(Trajectory.ZhudianBean zhudianBean) {
        setData(zhudianBean);
    }

    public PersonTrajectory(Trajectory.KakouBean kakouBean) {
        setData(kakouBean);
    }

    private void setData(Trajectory.KakouBean kakouBean) {
        this.type = 17;
        this.kakouBean = kakouBean;
        this.time = DateUtil.parseDate("yyyy-MM-dd HH:mm:ss", kakouBean.getTgsj());
        name = kakouBean.getHphm();
    }

    private void setData(Trajectory.KecheBean kecheBean) {
        this.kecheBean = kecheBean;
        type = 12;
        time = DateUtil.parseDate("yyyy-MM-ddHH:mm", kecheBean.getFcrq() + kecheBean.getFcsj());
        name = kecheBean.getCkXm();
    }

    private void setData(Trajectory.MinhangBean minhangBean) {
        this.type = 13;
        this.minhangBean = minhangBean;
        time = DateUtil.parseDate("yyyy-MM-ddHH:mm:ss", minhangBean.getDdcfRq().split(" ")[0] + minhangBean.getDdcfSj());
        name = minhangBean.getXm();
    }

    private void setData(Trajectory.ShangwangBean shangwangBean) {
        this.type = 14;
        this.shangwangBean = shangwangBean;
        time = DateUtil.parseDate("yyyy-MM-dd HH:mm:ss", shangwangBean.getSwKssj());
        name = shangwangBean.getXm();
    }

    private void setData(Trajectory.TielugoupiaoBean tielugoupiaoBean) {
        this.type = 15;
        this.tielugoupiaoBean = tielugoupiaoBean;
        time = DateUtil.parseDate("yyyyMMdd", tielugoupiaoBean.getCcrq());
        name = tielugoupiaoBean.getXm();
    }

    private void setData(Trajectory.ZhudianBean zhudianBean) {
        this.type = 16;
        this.zhudianBean = zhudianBean;
        this.time = DateUtil.parseDate("yyyyMMddHHmm", zhudianBean.getRzsj());
        name = zhudianBean.getXm();
    }

    public Trajectory.KecheBean getKecheBean() {
        return kecheBean;
    }

    public Trajectory.MinhangBean getMinhangBean() {
        return minhangBean;
    }

    public Trajectory.ShangwangBean getShangwangBean() {
        return shangwangBean;
    }

    public Trajectory.TielugoupiaoBean getTielugoupiaoBean() {
        return tielugoupiaoBean;
    }

    public Trajectory.ZhudianBean getZhudianBean() {
        return zhudianBean;
    }

    public Trajectory.KakouBean getKakouBean() {
        return kakouBean;
    }

    @Override
    public int compareTo(@NonNull PersonTrajectory o) {
        if (this.time - o.time < 0) return 1;
        else if (this.time - o.time > 0) return -1;
        else return 0;
    }

    public SimpleCarInfo getCarInfo() {
        return carInfo;
    }

    public PersonTrajectory(SimpleCarInfo carInfo) {
        setCarInfo(carInfo);
    }

    private void setCarInfo(SimpleCarInfo carInfo) {
        this.carInfo = carInfo;
        type = 51;
        time = System.currentTimeMillis();
    }


    public PersonTrajectory setHbtx(ArrayList<GxrData2.HbtxBean> hbtxBeans) {
        this.hbtx2 = hbtxBeans;
        type = 46;
        time = System.currentTimeMillis();
        return this;
    }

    public PersonTrajectory setHctx(ArrayList<GxrData2.HctxBean> hctx2) {
        this.hctx2 = hctx2;
        type = 47;
        time = System.currentTimeMillis();
        return this;
    }

    public PersonTrajectory setHclz(ArrayList<GxrData2.HclzBean> hclz2) {
        this.hclz2 = hclz2;
        type = 50;
        time = System.currentTimeMillis();
        return this;
    }

    public PersonTrajectory setKctx(ArrayList<GxrData2.KctxBean> kctx2) {
        this.kctx2 = kctx2;
        type = 48;
        time = System.currentTimeMillis();
        return this;
    }

    public PersonTrajectory setZstx(ArrayList<GxrData2.ZstxBean> zstx2) {
        this.zstx2 = zstx2;
        type = 49;
        time = System.currentTimeMillis();
        return this;
    }

}
