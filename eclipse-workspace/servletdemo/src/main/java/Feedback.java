public class Feedback {

    private String name;
    private String email;
    private String feedback;

    public Feedback(java.lang.String email, java.lang.String feedback, java.lang.String name) {
        this.email = email;
        this.feedback = feedback;
        this.name = name;
    }

    //Getter method.... for get value and return value..
    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getFeedback() {
        return feedback;
    }
}
