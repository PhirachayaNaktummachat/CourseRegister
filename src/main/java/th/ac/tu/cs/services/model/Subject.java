package th.ac.tu.cs.services.model;

public class Subject {
    private String addordrop;
    private String studentId;
    private String subjectCode;
    private String subjectName;
    private String subjectSection;
    private String subjectDate;
    private String subjectCredit;
    private String subjectTeacher;
    private boolean subjectTeacherCheck;

    public Subject() {
    }

    public Subject(String addordrop, String studentId, String subjectCode, String subjectName, String subjectSection, String subjectDate, String subjectCredit, String subjectTeacher, boolean subjectTeacherCheck) {
        this.addordrop = addordrop;
        this.studentId = studentId;
        this.subjectCode = subjectCode;
        this.subjectName = subjectName;
        this.subjectSection = subjectSection;
        this.subjectDate = subjectDate;
        this.subjectCredit = subjectCredit;
        this.subjectTeacher = subjectTeacher;
        this.subjectTeacherCheck = subjectTeacherCheck;
    }

    public String getAddordrop() {
        return addordrop;
    }

    public void setAddordrop(String addordrop) {
        this.addordrop = addordrop;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getSubjectCode() {
        return subjectCode;
    }

    public void setSubjectCode(String subjectCode) {
        this.subjectCode = subjectCode;
    }

    public String getSubjectName() {
        return subjectName;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }

    public String getSubjectSection() {
        return subjectSection;
    }

    public void setSubjectSection(String subjectSection) {
        this.subjectSection = subjectSection;
    }

    public String getSubjectDate() {
        return subjectDate;
    }

    public void setSubjectDate(String subjectDate) {
        this.subjectDate = subjectDate;
    }

    public String getSubjectCredit() {
        return subjectCredit;
    }

    public void setSubjectCredit(String subjectCredit) {
        this.subjectCredit = subjectCredit;
    }

    public String getSubjectTeacher() {
        return subjectTeacher;
    }

    public void setSubjectTeacher(String subjectTeacher) {
        this.subjectTeacher = subjectTeacher;
    }

    public boolean isSubjectTeacherCheck() {
        return subjectTeacherCheck;
    }

    public void setSubjectTeacherCheck(boolean subjectTeacherCheck) {
        this.subjectTeacherCheck = subjectTeacherCheck;
    }
}
