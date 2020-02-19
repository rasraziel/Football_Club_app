public class MemberPlayer {
    private String firstName, lastName, team;
    private int age;

    public MemberPlayer(){}

    public MemberPlayer(String firstName, String lastName, int age, String team){
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.team = team;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getTeam() {
        return team;
    }

    public int getAge() {
        return age;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setTeam(String team) {
        this.team = team;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String toString(){
        return this.firstName +" "+ this.lastName +" "+ this.age +" "+ this.team;
    }
}
