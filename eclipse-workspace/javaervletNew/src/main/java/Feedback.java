public class Feedback {

    private String name;
    private String email;
    private String feedback;

    //Constructor..
    public Feedback(String name, String email, String feedback) {
        this.name = name;
        this.email = email;
        this.feedback = feedback;
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