package Service.user;

public class Student extends User {

    private String Student_Building_ID;//寝室楼号
    private String Student_DormitoryID;//寝室号
    private String Student_Name;
    private String Student_Sex;
    private String Student_Class;
    private String Student_State;
    private String Student_Tel;


    public String getStudent_Building_ID() {
        return Student_Building_ID;
    }

    public void setStudent_Building_ID(String student_building_id) {
        Student_Building_ID = student_building_id;
    }


    public String getStudent_DormitoryID() {
        return Student_DormitoryID;
    }

    public void setStudent_DormitoryID(String studentDormitoryID) {
        Student_DormitoryID = studentDormitoryID;
    }


    public String getStudent_Name() {
        return Student_Name;
    }

    public void setStudent_Name(String studentName) {
        Student_Name = studentName;
    }

    public String getStudent_Sex() {
        return Student_Sex;
    }

    public void setStudent_Sex(String studentSex) {
        Student_Sex = studentSex;
    }

    public String getStudent_Class() {
        return Student_Class;
    }

    public void setStudent_Class(String studentClass) {
        Student_Class = studentClass;
    }

    public String getStudent_State() {
        return Student_State;
    }

    public void setStudent_State(String studentState) {
        Student_State = studentState;
    }

    public String getStudent_Tel() {
        return Student_Tel;
    }

    public void setStudent_Tel(String studentTel) {
        Student_Tel = studentTel;
    }


/*
    //下面这些用不到可以注释掉
    private String Dormitory_Name;
    private String Building_Name;

    public String getDormitory_Name() {
        return Dormitory_Name;
    }

    public void setDormitory_Name(String dormitoryName) {
        Dormitory_Name = dormitoryName;
    }

    public String getBuilding_Name() {
        return Building_Name;
    }

    public void setBuilding_Name(String buildingName) {
        Building_Name = buildingName;
    }

    private String Dormitory_Type;
    private String Dormitory_Number;
    private String Dormitory_Tel;

    public String getDormitory_Type() {
        return Dormitory_Type;
    }

    public void setDormitory_Type(String dormitoryType) {
        Dormitory_Type = dormitoryType;
    }

    public String getDormitory_Number() {
        return Dormitory_Number;
    }

    public void setDormitory_Number(String dormitoryNumber) {
        Dormitory_Number = dormitoryNumber;
    }

    public String getDormitory_Tel() {
        return Dormitory_Tel;
    }

    public void setDormitory_Tel(String dormitoryTel) {
        Dormitory_Tel = dormitoryTel;
    }

}  */

}