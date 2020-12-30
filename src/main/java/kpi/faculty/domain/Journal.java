package kpi.faculty.domain;

public class Journal {
    private int studentId;
    private int courseId;
    private int grade;

    private String name;
    private String course;

    private boolean ongoing;
    private boolean notStarted;

    public boolean isOngoing() {
        return ongoing;
    }

    public void setOngoing(boolean ongoing) {
        this.ongoing = ongoing;
    }

    public boolean isNotStarted() {
        return notStarted;
    }

    public void setNotStarted(boolean notStarted) {
        this.notStarted = notStarted;
    }

    public String getName() {
        return name;
    }

    public String getCourse() {
        return course;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    @Override
    public String toString() {
        return "Journal{" +
                "studentId=" + studentId +
                ", courseId=" + courseId +
                ", grade=" + grade +
                ", name='" + name + '\'' +
                ", course='" + course + '\'' +
                '}';
    }
}
