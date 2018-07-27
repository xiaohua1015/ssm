package cn.isdev.ssm.bean;

/**
 * Created by Administrator on 2018/7/28.
 */
public class Teacher {
    private int id;
    private String name;
    private String address;
    private int genger;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getGenger() {
        return genger;
    }

    public void setGenger(int genger) {
        this.genger = genger;
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", genger=" + genger +
                '}';
    }
}
