import java.util.Objects;
import java.time.LocalDate;

public class Person {

    /*
    String ID = "";
    String firstName = "";
    String lastName = "";
    String title = "";
    int YOB = 0;
     */

    LocalDate currentDate = LocalDate.now();

    private String ID = "";
    private String firstName = "";
    private String lastName = "";
    private String title = "";
    private int YOB = 0;

    public Person(String ID, String firstName, String lastName, String title, int YOB) {
        this.ID = ID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.title = title;
        this.YOB = YOB;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getYOB() {
        return YOB;
    }

    public void setYOB(int YOB) {
        this.YOB = YOB;
    }

    public String getFullName() {
        return this.getFirstName() + " " + this.getLastName();
        //^ This one works but it's a little extra for no reason

        //This works and is the most concise
        //return firstName + " " + lastName;
    }

    public String getFormalName() {

        return title + " " + getFullName();

    }

    public int getAge() {
        return currentDate.getYear() - YOB;
    }

    public int getAge(int year) {
        return year - YOB;
    }

    public String toCSV() {

        return ID + ", " + firstName + ", " + lastName + ", " + title + ", " + YOB;

    }

    public String toJSON() {

        return "{\"people\":[" + "{ \"ID\":\"" + ID + "\", \"firstName\":\"" + firstName + "\", \"lastName\":\"" +
                lastName + "\", \"title\":\"" + title + "\", \"YOB\":" + YOB + " } ]}";

    }

    public String toXML() {

        /*
        <employees>
  <employee>
    <firstName>John</firstName> <lastName>Doe</lastName>
  </employee>
  <employee>
    <firstName>Anna</firstName> <lastName>Smith</lastName>
  </employee>
  <employee>
    <firstName>Peter</firstName> <lastName>Jones</lastName>
  </employee>
</employees>
         */

        return "<people> <person> <ID>" + ID + "</ID> <firstName>" + firstName + "</firstName> <lastName>" +
                lastName + "</lastName> <title>" + title + "</title> <YOB>" + YOB + "</YOB> </person> </people>";

    }

    @Override
    public String toString() {
        return "Person{" +
                "ID='" + ID + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", title='" + title + '\'' +
                ", YOB=" + YOB +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return YOB == person.YOB && Objects.equals(ID, person.ID) && Objects.equals(firstName, person.firstName) && Objects.equals(lastName, person.lastName) && Objects.equals(title, person.title);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ID, firstName, lastName, title, YOB);
    }
}
