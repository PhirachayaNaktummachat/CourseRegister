package th.ac.tu.cs.services.model;


import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

    public class Request {
        private long id;

        private String topic;
        private Date date;
        private String title;
        private String studentFirstName;
        private String studentLastName;
        private String studentId;
        private int studentYear;
        private String studyField;
        private String advisor;
        private String addressNumber;
        private String moo;
        private String tumbol;
        private String amphur;
        private String province;
        private String postalCode;
        private String mobilePhone;
        private String phone;
        private String cause;

        private List<Subject> addSubjectList;
        private List<Subject> dropSubjectList;

        public Request() {
            addSubjectList = new ArrayList<>();
            dropSubjectList= new ArrayList<>();
        }

        public Request(long id, String topic, Date date, String title, String studentFirstName, String studentLastName, String studentId, int studentYear, String studyField, String advisor, String addressNumber, String moo, String tumbol, String amphur, String province, String postalCode, String mobilePhone, String phone, String cause, List<Subject> addSubjectList, List<Subject> dropSubjectList) {
            this.id = id;
            this.topic = topic;
            this.date = date;
            this.title = title;
            this.studentFirstName = studentFirstName;
            this.studentLastName = studentLastName;
            this.studentId = studentId;
            this.studentYear = studentYear;
            this.studyField = studyField;
            this.advisor = advisor;
            this.addressNumber = addressNumber;
            this.moo = moo;
            this.tumbol = tumbol;
            this.amphur = amphur;
            this.province = province;
            this.postalCode = postalCode;
            this.mobilePhone = mobilePhone;
            this.phone = phone;
            this.cause = cause;
            this.addSubjectList = addSubjectList;
            this.dropSubjectList = dropSubjectList;
        }

        public long getId() {
            return id;
        }

        public void setId(long id) {
            this.id = id;
        }

        public String getTopic() {
            return topic;
        }

        public void setTopic(String topic) {
            this.topic = topic;
        }

        public Date getDate() {
            return date;
        }

        public void setDate(Date date) {
            this.date = date;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getStudentFirstName() {
            return studentFirstName;
        }

        public void setStudentFirstName(String studentFirstName) {
            this.studentFirstName = studentFirstName;
        }

        public String getStudentLastName() {
            return studentLastName;
        }

        public void setStudentLastName(String studentLastName) {
            this.studentLastName = studentLastName;
        }

        public String getStudentId() {
            return studentId;
        }

        public void setStudentId(String studentId) {
            this.studentId = studentId;
        }

        public int getStudentYear() {
            return studentYear;
        }

        public void setStudentYear(int studentYear) {
            this.studentYear = studentYear;
        }

        public String getStudyField() {
            return studyField;
        }

        public void setStudyField(String studyField) {
            this.studyField = studyField;
        }

        public String getAdvisor() {
            return advisor;
        }

        public void setAdvisor(String advisor) {
            this.advisor = advisor;
        }

        public String getAddressNumber() {
            return addressNumber;
        }

        public void setAddressNumber(String addressNumber) {
            this.addressNumber = addressNumber;
        }

        public String getMoo() {
            return moo;
        }

        public void setMoo(String moo) {
            this.moo = moo;
        }

        public String getTumbol() {
            return tumbol;
        }

        public void setTumbol(String tumbol) {
            this.tumbol = tumbol;
        }

        public String getAmphur() {
            return amphur;
        }

        public void setAmphur(String amphur) {
            this.amphur = amphur;
        }

        public String getProvince() {
            return province;
        }

        public void setProvince(String province) {
            this.province = province;
        }

        public String getPostalCode() {
            return postalCode;
        }

        public void setPostalCode(String postalCode) {
            this.postalCode = postalCode;
        }

        public String getMobilePhone() {
            return mobilePhone;
        }

        public void setMobilePhone(String mobilePhone) {
            this.mobilePhone = mobilePhone;
        }

        public String getPhone() {
            return phone;
        }

        public void setPhone(String phone) {
            this.phone = phone;
        }

        public String getCause() {
            return cause;
        }

        public void setCause(String cause) {
            this.cause = cause;
        }

        public List<Subject> getAddSubjectList() {
            return addSubjectList;
        }

        public void setAddSubjectList(List<Subject> addSubjectList) {
            this.addSubjectList = addSubjectList;
        }

        public List<Subject> getDropSubjectList() {
            return dropSubjectList;
        }

        public void setDropSubjectList(List<Subject> dropSubjectList) {
            this.dropSubjectList = dropSubjectList;
        }
    }
