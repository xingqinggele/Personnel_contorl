package com.zhhl.personnel_contorl.data;

import java.util.List;

public class HunyinGuiji {

    /**
     * hunyin : {"peiou":"鍛ㄨ壋闇�","hunyintiaoshu":1,"peioucode":"220521198612210022"}
     * Message : 鎴愬姛
     * tielugoupiao : []
     * keche : []
     * State : 1
     * minhang : []
     */

    private List<HunyinBean> hunyin;
    private String Message;
    private String State;
    private List<Trajectory.TielugoupiaoBean> tielugoupiao;
    private List<Trajectory.KecheBean> keche;
    private List<Trajectory.MinhangBean> minhang;


    public List<HunyinBean> getHunyin() {
        return hunyin;
    }

    public void setHunyin(List<HunyinBean> hunyin) {
        this.hunyin = hunyin;
    }

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

    public List<Trajectory.TielugoupiaoBean> getTielugoupiao() {
        return tielugoupiao;
    }

    public void setTielugoupiao(List<Trajectory.TielugoupiaoBean> tielugoupiao) {
        this.tielugoupiao = tielugoupiao;
    }

    public List<Trajectory.KecheBean> getKeche() {
        return keche;
    }

    public void setKeche(List<Trajectory.KecheBean> keche) {
        this.keche = keche;
    }

    public List<Trajectory.MinhangBean> getMinhang() {
        return minhang;
    }

    public void setMinhang(List<Trajectory.MinhangBean> minhang) {
        this.minhang = minhang;
    }

    static class HunyinBean {
        /**
         * peiou : 鍛ㄨ壋闇�
         * hunyintiaoshu : 1
         * peioucode : 220521198612210022
         */

        private String peiou;
        private int hunyintiaoshu;
        private String peioucode;

        public String getPeiou() {
            return peiou;
        }

        public void setPeiou(String peiou) {
            this.peiou = peiou;
        }

        public int getHunyintiaoshu() {
            return hunyintiaoshu;
        }

        public void setHunyintiaoshu(int hunyintiaoshu) {
            this.hunyintiaoshu = hunyintiaoshu;
        }

        public String getPeioucode() {
            return peioucode;
        }

        public void setPeioucode(String peioucode) {
            this.peioucode = peioucode;
        }
    }
}
