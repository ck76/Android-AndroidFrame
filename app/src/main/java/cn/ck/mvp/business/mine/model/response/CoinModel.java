package cn.ck.mvp.business.mine.model.response;

/**
 * Created by ck on 2018/9/26.
 */
public class CoinModel {
    /**
     * coin : 210
     */
    public CoinModel(String courseName,int percent, int refund, int bonus) {
        this.courseName=courseName;
        this.percent = percent;
        this.refund = refund;
        this.bonus = bonus;
    }

    private int percent;
    private String courseName;

    public int getPercent() {

        return percent;
    }

    public void setPercent(int percent) {
        this.percent = percent;
    }

    public int getRefund() {

        return refund;
    }

    public void setRefund(int refund) {
        this.refund = refund;
    }

    public int getBonus() {
        return bonus;
    }

    public void setBonus(int bonus) {
        this.bonus = bonus;
    }

    private int refund;

    private int bonus;

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }
}
