package az.grp.model.web.neuron;

import java.util.List;

/**
 * Created by Seymur on 1/24/2016.
 */
public class DailyWo {

    private int id;
    private String d;
    private List<StudentNeWo> s;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getD() {
        return d;
    }

    public void setD(String d) {
        this.d = d;
    }

    public List<StudentNeWo> getS() {
        return s;
    }

    public void setS(List<StudentNeWo> s) {
        this.s = s;
    }

    @Override
    public String toString() {
        return "DailyWo{" +
                "id=" + id +
                ", d=" + d +
                ", s=" + s +
                '}';
    }
}
