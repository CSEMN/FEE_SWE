import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Random;

public class Main {
    public static void main(String[] args) throws Exception {
        ArrayList<Student> students = new ArrayList<Student>();
        ArrayList<Assignment> assignments = new ArrayList<Assignment>();
        ArrayList<CourseRecord> courseRecords = new ArrayList<CourseRecord>();
        ArrayList<Course> courses = new ArrayList<Course>();

        Random rand = new Random();
        Student tempStd;
        boolean alreadyRegestered;
        // generate random Students
        for (int i = 0; i < rand.nextInt(45) + 5; i++) { // 5 to 50 students
            tempStd = new Student(randomString(rand.nextInt(5) + 5));
            // make sure no replicant names;
            alreadyRegestered = false;
            for (Student std : students) {
                if (std.getName().compareTo(tempStd.getName()) == 0) {
                    alreadyRegestered = true;
                    break;
                }
            }
            if (alreadyRegestered)
                continue;
            else
                students.add(tempStd);
        }
        // generate random Assignments
        for (int i = 0; i < rand.nextInt(80) + 10; i++) { // 10 to 50 assignments
            assignments.add(new Assignment(rand.nextInt(100) - 1)); // mark between -1 to 100
        }
        // generate random CourseRecords
        CourseRecord tempCR;

        for (int i = 0; i < rand.nextInt(40) + 10; i++) { // 10 to 30 CourseRecords
            tempCR = new CourseRecord();
            // make sure no dulicate students in same record.
            alreadyRegestered = false;
            tempStd = students.get(rand.nextInt(students.size())); // pick one of the students.
            for (CourseRecord cr : courseRecords) {
                if (cr.getStudent().getName().compareTo(tempStd.getName()) == 0) {
                    alreadyRegestered = true;
                    break;
                }
            }
            if (alreadyRegestered)
                continue;
            else
                tempCR.setStudent(tempStd);

            for (int j = 0; j < rand.nextInt(5) + 1; j++) {// add some assignmnets
                tempCR.addAssignment(assignments.get(rand.nextInt(assignments.size())));
            }
            courseRecords.add(tempCR);
        }
        // generate random Courses
        Course tempC;
        for (int i = 0; i < rand.nextInt(7) + 3; i++) { // 3 to 10 Courses
            tempC = new Course();
            tempC.setTitle(randomString(3));

            // add some Course Records with no replications.
            for (int j = 0; j < rand.nextInt(10) + 4; j++) {
                tempCR = courseRecords.get(rand.nextInt(courseRecords.size()));
                alreadyRegestered = false;
                Enumeration<CourseRecord> cr = tempC.getCourseRecords();
                while(cr.hasMoreElements()){
                    if (cr.nextElement().getStudent().getName().compareTo(tempCR.getStudent().getName())==0){
                        alreadyRegestered=true;
                        break;
                    }
                }
                if (alreadyRegestered)
                    continue;
                else
                    tempC.addCourseRecord(tempCR);
            }
            courses.add(tempC);
        }

        // === OUPUT HERE ===
        for (int i = 0; i < courses.size(); i++) {
            Course c = courses.get(i);
            System.out.println((i + 1) + ". Course Title: " + c.getTitle());
            System.out.println("Regesterd: " + c.getStudentsCount() + " Students");
            // Uncomment the line below to show all students enrolled.
            // c.printCourseStudents();
            c.printBestStudent();
            System.out.println("Students who Can take final exam: ");
            c.printFinalExamStudents();
            System.out.println();
        }

        System.out.println("End of APP");
    }

    // Creates random String
    private static String randomString(int lenght) {
        int leftLimit = 65; // letter 'A'
        int rightLimit = 90; // letter 'Z'
        Random random = new Random();

        String generatedString = random.ints(leftLimit, rightLimit + 1)
                .limit(lenght)
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();
        return generatedString;
    }
}
