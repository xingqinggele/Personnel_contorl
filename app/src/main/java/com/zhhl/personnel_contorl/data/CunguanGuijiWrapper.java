package com.zhhl.personnel_contorl.data;

import androidx.annotation.NonNull;

import com.zhhl.personnel_contorl.utils.DateUtil;


/**
 * Created by miao on 2018/11/25.
 */
public class CunguanGuijiWrapper implements Comparable<CunguanGuijiWrapper> {

    private int type;
    private long time;
    private String name;

    private Cunguanguiji.CheliangBean cheliangBean;
    private Cunguanguiji.BudongchanBean budongchanBean;
    private Cunguanguiji.GetixinxiBean getixinxiBean;
    private Cunguanguiji.QiyexinxiBean qiyexinxiBean;
    private Cunguanguiji.ShengneifangchanBean shengneifangchanBean;
    private Cunguanguiji.WeifafanzuiBean weifafanzuiBean;

    public long getTime() {
        return time;
    }

    public CunguanGuijiWrapper() {

    }

    public String getName() {
        return name;
    }

    public CunguanGuijiWrapper(Cunguanguiji.CheliangBean cheliangBean) {
        setData(cheliangBean);
    }

    public CunguanGuijiWrapper(Cunguanguiji.BudongchanBean budongchanBean) {
        setData(budongchanBean);
    }

    public CunguanGuijiWrapper(Cunguanguiji.GetixinxiBean getixinxiBean) {
        setData(getixinxiBean);
    }

    public CunguanGuijiWrapper(Cunguanguiji.QiyexinxiBean qiyexinxiBean) {
        setData(qiyexinxiBean);
    }

    public CunguanGuijiWrapper(Cunguanguiji.ShengneifangchanBean shengneifangchanBean) {
        setData(shengneifangchanBean);
    }

    public CunguanGuijiWrapper(Cunguanguiji.WeifafanzuiBean weifafanzuiBean) {
        setData(weifafanzuiBean);
    }

    private void setData(Cunguanguiji.CheliangBean cheliangBean) {
        type = 1;
        this.cheliangBean = cheliangBean;
        time = DateUtil.parseDate("yyyy-MM-dd HH:mm:ss", cheliangBean.getHckRksj());
        name = cheliangBean.getJbrXm();
    }

    private void setData(Cunguanguiji.BudongchanBean budongchanBean) {
        this.budongchanBean = budongchanBean;
        type = 2;
        time = DateUtil.parseDate("yyyy-MM-dd HH:mm:ss", budongchanBean.getRgxksj());
        name = budongchanBean.getQlrmc();
    }

    private void setData(Cunguanguiji.GetixinxiBean ge) {
        this.type = 3;
        this.getixinxiBean = ge;
        time = DateUtil.parseDate("yyyy-MM-dd HH:mm:ss", ge.getRgxksj());
        name = ge.getFddbrxm();
    }

    private void setData(Cunguanguiji.QiyexinxiBean qiyexinxiBean) {
        this.type = 4;
        this.qiyexinxiBean = qiyexinxiBean;
        time = DateUtil.parseDate("yyyy-MM-dd HH:mm:ss", qiyexinxiBean.getRgxksj());
        name = qiyexinxiBean.getFddbrXm();
    }

    private void setData(Cunguanguiji.ShengneifangchanBean shengneifangchanBean) {
        this.type = 5;
        this.shengneifangchanBean = shengneifangchanBean;
        time = DateUtil.parseDate("yyyy-MM-dd HH:mm:ss", shengneifangchanBean.getRgxksj());
        name = shengneifangchanBean.getXm();
    }

    private void setData(Cunguanguiji.WeifafanzuiBean weifafanzuiBean) {
        this.type = 6;
        this.weifafanzuiBean = weifafanzuiBean;
        this.time = DateUtil.parseDate("yyyy-MM-dd HH:mm:ss", weifafanzuiBean.getRgxksj());
        name = weifafanzuiBean.getXm();
    }

    public Cunguanguiji.CheliangBean getCheliangBean() {
        return cheliangBean;
    }

    public Cunguanguiji.BudongchanBean getBudongchanBean() {
        return budongchanBean;
    }

    public Cunguanguiji.GetixinxiBean getGetixinxiBean() {
        return getixinxiBean;
    }

    public Cunguanguiji.QiyexinxiBean getQiyexinxiBean() {
        return qiyexinxiBean;
    }

    public Cunguanguiji.ShengneifangchanBean getShengneifangchanBean() {
        return shengneifangchanBean;
    }

    public Cunguanguiji.WeifafanzuiBean getWeifafanzuiBean() {
        return weifafanzuiBean;
    }

    public int getType() {
        return type;
    }

    @Override
    public int compareTo(@NonNull CunguanGuijiWrapper o) {
        if (this.time - o.time < 0) return 1;
        else if (this.time - o.time > 0) return -1;
        else return 0;
    }
}
