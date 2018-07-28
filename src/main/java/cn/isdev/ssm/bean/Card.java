package cn.isdev.ssm.bean;

/**
 * Created by Administrator on 2018/7/28.
 */
public class Card {
    private int id;
    private String num;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num;
    }

    @Override
    public String toString() {
        return "Card{" +
                "id=" + id +
                ", num='" + num + '\'' +
                '}';
    }
}
