import java.util.Vector;
import java.util.Enumeration;

public class Course {
    private String title;
    private Vector<CourseRecord> courseRecords;

    Course() {
        courseRecords = new Vector<CourseRecord>();
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String t) {
        title = t;
    }

    public void addCourseRecord(CourseRecord cr) {
        courseRecords.addElement(cr);
    }

    public Enumeration<CourseRecord> getCourseRecords() {
        return courseRecords.elements();
    }
    public int getStudentsCount(){
        int count=0;
        Enumeration<CourseRecord> records= getCourseRecords();
        while (records.hasMoreElements()){
            records.nextElement();
            count++;
        }
        return count;
    }

    // Excercise Solution below.
    public void printCourseStudents(){
        int Counter=0;
        Enumeration<CourseRecord> records= getCourseRecords();
        while (records.hasMoreElements()){
            System.out.println(++Counter +". "+ records.nextElement().getStudent().getName());
        }
    }

    public void printBestStudent(){
        Student bestStd=new Student("NO STUDENTS YET"); //Default output value.
        Double bestAvg=-1.0; // bonus step for better output.
        CourseRecord tempRec;
        Enumeration<CourseRecord> records= getCourseRecords();
        while (records.hasMoreElements()){
            tempRec=records.nextElement();
            try {
                if(tempRec.average()>bestAvg){
                    bestStd=tempRec.getStudent();
                    bestAvg=tempRec.average();
                }
            } catch (NotYetSetException e) {
                // Student with no grade
                // Simple igone him :)
            }
        }
        System.out.println("Best Student: "+ bestStd.getName()+", Avg: "+bestAvg);
    }

    public void printFinalExamStudents(){
        int Counter=0;
        CourseRecord currentRec;
        Enumeration<CourseRecord> records= getCourseRecords();
        while (records.hasMoreElements()){
            currentRec= records.nextElement();
            if(currentRec.canTakeFinalExam())
                System.out.println(++Counter +". "+currentRec.getStudent().getName());
        }
    }

}