package com.zhhl.personnel_contorl.data;

import androidx.annotation.NonNull;

import com.zhhl.personnel_contorl.utils.DateUtil;


/**
 * Created by miao on 2018/11/25.
 */
public class ShangfangguijiWrapper implements Comparable<ShangfangguijiWrapper> {

    private Shangfangguiji.CheliangBean cheliangBean;
    private Shangfangguiji.KecheBean kecheBean;
    private Shangfangguiji.MinhangBean minhangBean;
    private Shangfangguiji.ShangwangBean shangwangBean;
    private Shangfangguiji.TielugoupiaoBean tielugoupiaoBean;
    private Shangfangguiji.ZhudianBean zhudianBean;
    private Shangfangguiji.KakouBean kakouBean;
    private int type;
    private long time;
    private String name;

    public long getTime() {
        return time;
    }

    public ShangfangguijiWrapper() {

    }

    public String getName() {
        return name;
    }

    public ShangfangguijiWrapper(Shangfangguiji.CheliangBean cheliangBean) {
        setData(cheliangBean);
    }

    public ShangfangguijiWrapper(Shangfangguiji.KecheBean kecheBean) {
        setData(kecheBean);
    }

    public ShangfangguijiWrapper(Shangfangguiji.MinhangBean minhangBean) {
        setData(minhangBean);
    }

    public ShangfangguijiWrapper(Shangfangguiji.ShangwangBean shangwangBean) {
        setData(shangwangBean);
    }

    public ShangfangguijiWrapper(Shangfangguiji.TielugoupiaoBean tielugoupiaoBean) {
        setData(tielugoupiaoBean);
    }

    public ShangfangguijiWrapper(Shangfangguiji.ZhudianBean zhudianBean) {
        setData(zhudianBean);
    }

    public ShangfangguijiWrapper(Shangfangguiji.KakouBean kakouBean) {
        setData(kakouBean);
    }

    private void setData(Shangfangguiji.KakouBean kakouBean) {
        this.type = 7;
        this.kakouBean = kakouBean;
        this.time = DateUtil.parseDate("yyyy-MM-dd HH:mm:ss", kakouBean.getTgsj());
        name = kakouBean.getHphm();
    }

    private void setData(Shangfangguiji.CheliangBean cheliangBean) {
        type = 1;
        this.cheliangBean = cheliangBean;
        time = DateUtil.parseDate("yyyy-MM-dd HH:mm:ss", cheliangBean.getHckRksj());
        name = cheliangBean.getJbrXm();
    }

    private void setData(Shangfangguiji.KecheBean kecheBean) {
        this.kecheBean = kecheBean;
        type = 2;
        time = DateUtil.parseDate("yyyy-MM-ddHH:mm", kecheBean.getFcrq() + kecheBean.getFcsj());
        name = kecheBean.getCkXm();
    }

    private void setData(Shangfangguiji.MinhangBean minhangBean) {
        this.type = 3;
        this.minhangBean = minhangBean;
        time = DateUtil.parseDate("yyyy-MM-ddHH:mm:ss", minhangBean.getDdcfRq().split(" ")[0] + minhangBean.getDdcfSj());
        name = minhangBean.getXm();
    }

    private void setData(Shangfangguiji.ShangwangBean shangwangBean) {
        this.type = 4;
        this.shangwangBean = shangwangBean;
        time = DateUtil.parseDate("yyyy-MM-dd HH:mm:ss", shangwangBean.getSwKssj());
        name = shangwangBean.getXm();
    }

    private void setData(Shangfangguiji.TielugoupiaoBean tielugoupiaoBean) {
        this.type = 5;
        this.tielugoupiaoBean = tielugoupiaoBean;
        time = DateUtil.parseDate("yyyyMMdd", tielugoupiaoBean.getCcrq());
        name = tielugoupiaoBean.getXm();
    }

    private void setData(Shangfangguiji.ZhudianBean zhudianBean) {
        this.type = 6;
        this.zhudianBean = zhudianBean;
        this.time = DateUtil.parseDate("yyyyMMddHHmm", zhudianBean.getRzsj());
        name = zhudianBean.getXm();
    }

    public Shangfangguiji.CheliangBean getCheliangBean() {
        return cheliangBean;
    }

    public Shangfangguiji.KecheBean getKecheBean() {
        return kecheBean;
    }

    public Shangfangguiji.MinhangBean getMinhangBean() {
        return minhangBean;
    }

    public Shangfangguiji.ShangwangBean getShangwangBean() {
        return shangwangBean;
    }

    public Shangfangguiji.TielugoupiaoBean getTielugoupiaoBean() {
        return tielugoupiaoBean;
    }

    public Shangfangguiji.ZhudianBean getZhudianBean() {
        return zhudianBean;
    }

    public Shangfangguiji.KakouBean getKakouBean() {
        return kakouBean;
    }

    public int getType() {
        return type;
    }

    @Override
    public int compareTo(@NonNull ShangfangguijiWrapper o) {
        if (this.time - o.time < 0) return 1;
        else if (this.time - o.time > 0) return -1;
        else return 0;
    }
}


