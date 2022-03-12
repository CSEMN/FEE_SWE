import java.util.Vector;
import java.util.Enumeration;

public class CourseRecord {
    private Student student;
    private Vector<Assignment> assignments;

    CourseRecord() {
        assignments = new Vector<Assignment>();
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student s) {
        student = s;
    }

    public void addAssignment(Assignment a) {
        assignments.addElement(a);
    }

    public Enumeration<Assignment> getAssignments() {
        return assignments.elements();
    }

    // Excercise Solution below.
    public double average() throws NotYetSetException {
        double sum = 0.0;
        int count = 0;
        Enumeration<Assignment> stdAssignments = getAssignments();
        while (stdAssignments.hasMoreElements()) {
            try {
                sum += stdAssignments.nextElement().getMark();
                count++;
            } catch (NotYetSetException e) {
                // DO NOTHING :)
            }
        }
        return sum / count;
    }

    public boolean canTakeFinalExam() {
        int count = 0;
        Enumeration<Assignment> stdAssignments = getAssignments();
        while (stdAssignments.hasMoreElements()) {
            if (stdAssignments.nextElement().hasMark())
                count++;
        }
        if (count >= 3)
            return true;
        else
            return false;
    }

}