package az.grp.model.web.neuron;

/**
 * Created by Seymur on 1/24/2016.
 */
public class LessonNeWo {

    private int lId;
    private String p;

    public int getlId() {
        return lId;
    }

    public void setlId(int lId) {
        this.lId = lId;
    }

    public String getP() {
        return p;
    }

    public void setP(String p) {
        this.p = p;
    }

    @Override
    public String toString() {
        return "LessonNeWo{" +
                "lId=" + lId +
                ", p='" + p + '\'' +
                '}';
    }
}
