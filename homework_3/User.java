public class User {

    private String surName; //1
    private String firstName; //2
    private String fatherName; //3
    private String birthDate; //4
    private Long phoneNumber; //5
    private char gender; //6

    public User(
            String argsurName,
            String argFirstName,
            String argFatherName,
            String argBirthDate,
            Long argPhoneNumber,
            char argGender
    ) {
        this.surName = argsurName;
        this.firstName = argFirstName;
        this.fatherName = argFatherName;
        this.birthDate = argBirthDate;
        this.phoneNumber = argPhoneNumber;
        this.gender = argGender;
    }

    public String getSurName() {
        return this.surName;
    }
    public String getFirstName() {
        return this.firstName;
    }
    public String getFatherName() {
        return this.fatherName;
    }

    public String getBirthDate() {
        return this.birthDate;
    }

    public Long getPhoneNumber() {
        return this.phoneNumber;
    }

    public char getGender() {
        return this.gender;
    }
}