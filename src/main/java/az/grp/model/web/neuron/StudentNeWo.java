package az.grp.model.web.neuron;

import java.util.List;

/**
 * Created by Seymur on 1/24/2016.
 */
public class StudentNeWo {

    private int sId;
    private List<LessonNeWo> l;

    public int getsId() {
        return sId;
    }

    public void setsId(int sId) {
        this.sId = sId;
    }

    public List<LessonNeWo> getL() {
        return l;
    }

    public void setL(List<LessonNeWo> l) {
        this.l = l;
    }

    @Override
    public String toString() {
        return "StudentNeWo{" +
                "sId=" + sId +
                ", l=" + l +
                '}';
    }
}
