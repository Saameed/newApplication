package az.grp.model.web;

/**
 * Created by Hp on 1/5/2016.
 */
public class StatisticFinalGroup {

    private String groupName;
    private int finalPointPercent;
    private int studentCount;

    public int getStudentCount() {
        return studentCount;
    }

    public void setStudentCount(int studentCount) {
        this.studentCount = studentCount;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public int getFinalPointPercent() {
        return finalPointPercent;
    }

    public void setFinalPointPercent(int finalPointPercent) {
        this.finalPointPercent = finalPointPercent;
    }

    @Override
    public String toString() {
        return "StatisticFinalGroup{" +
                "groupName='" + groupName + '\'' +
                ", finalPointPercent=" + finalPointPercent +
                '}';
    }
}
