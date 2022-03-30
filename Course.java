import java.util.ArrayList;

public class Course{

    ArrayList<int[]> lectures;      // int[day, hour]
    private final String courseCode;

    public Course(String courseCode){
        this.courseCode = courseCode;
        lectures = new ArrayList<>();
    }

    public String getCode(){
        return this.courseCode;
    }

    public boolean hasLectureOn(int day){
        for (int[] lecture : lectures){
            if (lecture[0] == day) return true;     // lecture[0] = day of lecture
        }
        return false;
    }

    public void addLecture(int day, int hour){
        for (int[] lecture : lectures){
            if (lecture[0] == day && lecture[1] == hour) return;    // already has lecture
        }
        
        int[] newLecture = {day, hour};
        lectures.add(newLecture);
    }

    public boolean hasLectureAt(int day, int hour){
        for (int[] lecture : lectures){
            if (lecture[0] == day && lecture[1] == hour) return true;    // has lecture
        }
        return false;
    }

    public boolean conflictsWith(Course other){

        // if there is a course in lecture{} that have the same lecture day & time as other, return true

        for (int[] lecture : lectures){
            if (other.hasLectureAt(lecture[0], lecture[1])) return true;
        }
        return false;
    }

    public static void main(String[] args) {
        Course se2aa4 = new Course("se2aa4");
        System.out.println(se2aa4.courseCode);
        System.out.println(se2aa4.getCode());

        System.out.println(se2aa4.hasLectureAt(1, 13));     // false
        System.out.println(se2aa4.hasLectureOn(1));         // false

        se2aa4.addLecture(1, 13);
        System.out.println(se2aa4.hasLectureAt(1, 13));     // true
        System.out.println(se2aa4.hasLectureOn(1));         // true

        se2aa4.addLecture(1, 13);
        for (int[] lec : se2aa4.lectures){
            System.out.println(lec[0] + " " + lec[1]);
        }

        Course se2c03 = new Course("se2c03");
        System.out.println(se2c03.courseCode);
        System.out.println(se2c03.getCode());

        se2c03.addLecture(1, 13);

        System.out.println(se2c03.hasLectureAt(1, 13));     // true
        System.out.println(se2c03.hasLectureOn(1));         // true

        System.out.println(se2c03.conflictsWith(se2aa4));   // true
        System.out.println(se2aa4.conflictsWith(se2c03));   // true

        Course eng2px3 = new Course("eng2px3");

        eng2px3.addLecture(2, 13);

        System.out.println(eng2px3.hasLectureAt(1, 13));    // false
        System.out.println(eng2px3.hasLectureOn(1));        // false
        System.out.println(eng2px3.hasLectureOn(2));        // true

        System.out.println(se2c03.conflictsWith(eng2px3));  // false
        System.out.println(se2aa4.conflictsWith(eng2px3));  // false

    } 
}
