public class Student {
    private String id;
    private String name;
    private String field;
    private String semester;
    private String email;
    private String phoneNumber;

    public Student(String id, String name, String field, String semester, String email, String phoneNumber) {
        this.id = id;
        this.name = name;
        this.field = field;
        this.semester = semester;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }

    // Getters and setters

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getField() {
        return field;
    }

    public void setField(String field) {
        this.field = field;
    }

    public String getSemester() {
        return semester;
    }

    public void setSemester(String semester) {
        this.semester = semester;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
