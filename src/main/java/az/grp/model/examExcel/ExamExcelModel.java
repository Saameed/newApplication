package az.grp.model.examExcel;

/**
 * Created by Seymur on 10.06.2016.
 */
public class ExamExcelModel {

    private String fullName;
    private String studentNo;
    private String beforePoint;
    private String afterPoint;
    private String fullPoint;
    private String point;
    private String mark;
    private String majorNo;
    private String lessonName;
    private String groupName;


    public String getMajorNo() {
        return majorNo;
    }

    public void setMajorNo(String majorNo) {
        this.majorNo = majorNo;
    }

    public String getLessonName() {
        return lessonName;
    }

    public void setLessonName(String lessonName) {
        this.lessonName = lessonName;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getStudentNo() {
        return studentNo;
    }

    public void setStudentNo(String studentNo) {
        this.studentNo = studentNo;
    }

    public String getBeforePoint() {
        return beforePoint;
    }

    public void setBeforePoint(String beforePoint) {
        this.beforePoint = beforePoint;
    }

    public String getAfterPoint() {
        return afterPoint;
    }

    public void setAfterPoint(String afterPoint) {
        this.afterPoint = afterPoint;
    }

    public String getFullPoint() {
        return fullPoint;
    }

    public void setFullPoint(String fullPoint) {
        this.fullPoint = fullPoint;
    }

    public String getPoint() {
        return point;
    }

    public void setPoint(String point) {
        this.point = point;
    }

    public String getMark() {
        return mark;
    }

    public void setMark(String mark) {
        this.mark = mark;
    }

    @Override
    public String toString() {
        return "ExamExcelModel{" +
                "fullName='" + fullName + '\'' +
                ", studentNo='" + studentNo + '\'' +
                ", beforePoint='" + beforePoint + '\'' +
                ", afterPoint='" + afterPoint + '\'' +
                ", fullPoint='" + fullPoint + '\'' +
                ", point='" + point + '\'' +
                ", mark='" + mark + '\'' +
                ", majorNo='" + majorNo + '\'' +
                ", lessonName='" + lessonName + '\'' +
                ", groupName='" + groupName + '\'' +
                '}';
    }
}
