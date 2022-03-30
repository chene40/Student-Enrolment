import java.util.ArrayList;

public class Student {
    
    private String studentName;
    ArrayList<Course> desiredCourses;

    public Student(String studentName){
        this.studentName = studentName;
        desiredCourses = new ArrayList<>();
    }

    public String getName(){
        return this.studentName;
    }

    public void addDesiredCourse(Course courseToAdd){
        for (Course course : desiredCourses){
            if (course.getCode().equals(courseToAdd.getCode())) return;
        }
        desiredCourses.add(courseToAdd);
    }

    public ArrayList<Course> getBestSchedule(){
        ArrayList<Course> bestSchedule = new ArrayList<>();
        ArrayList<ArrayList<Course>> possibleSchedules = powerSet(desiredCourses);
        int counter = 5;        // to keep track of number of days on campus

        for (ArrayList<Course> schedule : possibleSchedules){

            // only checks for schedules of size 5 (i.e. 5 course schedules)
            if (validSize(schedule)){       

                /*  isValidSchedule checks that:
                    1) there are no conflicts among courses
                    2) the size of the schedule is 5 (i.e. 5 courses)
                    3) all courses in schedule are in student's desired courses 

                    numDaysOnCampus ensures that the new schedule minimizes the number of days required to be on campus
                */

                if (isValidSchedule(schedule) && numDaysOnCampus(schedule) <= counter){
                    bestSchedule = schedule;
                    counter = numDaysOnCampus(bestSchedule);
                }
            }
        }
        return bestSchedule;        
    }

    // returns the power set of size 2^n given a set of n elements
    private ArrayList<ArrayList<Course>> powerSet(ArrayList<Course> set){
        ArrayList<ArrayList<Course>> pSet = new ArrayList<>();

        int num = power(2, set.size());                         // size of power set = 2^n

        for (int i = 0; i < num; i++){                          // 2^n elements in our power set
            ArrayList<Course> element = new ArrayList<>(); 

            for (int j = 0; j < set.size(); j++){               
                if ((i & (1 << j)) != 0){                       // checks if any of our bits is 1
                    element.add(set.get(j));                    // if bit is 1, add that Course to our set
                }
            }
            pSet.add(element);                                  // add the set to our power set and continue to next iteration
        }
        return pSet;
    }

    // since we can't import or use Math.pow(x,y).........
    private int power(int base, int exponent){
        int result = base;
        for (int i = 1; i < exponent; i++) result *= base;
        return result;
    }

    // details listed above
    private boolean isValidSchedule(ArrayList<Course> schedule){
        return (inDesiredCourses(schedule) && validSize(schedule) && noConflicts(schedule));
    }

    // checks if all courses in schedule are in student's desired courses 
    private boolean inDesiredCourses(ArrayList<Course> schedule){
        for (Course course : schedule){
            if (!desiredCourses.contains(course)) return false;
        }
        return true;
    }

    // checks if the size of the schedule is 5 (i.e. 5 courses)
    private boolean validSize(ArrayList<Course> schedule){
        return schedule.size() == 5;
    }

    // checks for conflicts among courses in schedule
    public boolean noConflicts(ArrayList<Course> schedule){
        for (int i = 0; i < schedule.size(); i++){
            Course course1 = schedule.get(i);
            for (int j = i+1; j < schedule.size(); j++){
                Course course2 = schedule.get(j);
                if (course1.conflictsWith(course2)) return false;
            }
        }
        return true;
    }

    // checks the number of days required to be on campus
    private int numDaysOnCampus(ArrayList<Course> schedule){
        ArrayList<Integer> daysOnCampus = new ArrayList<>();

        for (Course course : schedule){
            for (int[] lectureTime : course.lectures){
                if (!daysOnCampus.contains(lectureTime[0])){
                    daysOnCampus.add(lectureTime[0]);
                }
            }
        }
        return daysOnCampus.size();
    }

    public static void main(String[] args) {

        Course se2aa4 = new Course("se2aa4");
        Course se2fa3 = new Course("se2fa3");
        Course se2ga3 = new Course("se2ga3");
        Course se2cx3 = new Course("se2cx3");
        Course se2da4 = new Course("se2da4");
        Course se2c03 = new Course("se2c03");
        Course eng2px3 = new Course("eng2px3");
        Course eng1p13 = new Course("eng1p13");
        Course math2z03 = new Course("math2z03");
        Course math2zz3 = new Course("math2zz3");
        Course freeCourse = new Course("freeCourse");

        se2cx3.addLecture(1, 17);
        se2cx3.addLecture(3, 17);
        se2cx3.addLecture(4, 17);

        se2da4.addLecture(1, 16);
        se2da4.addLecture(2, 16);
        se2da4.addLecture(3, 16);

        se2aa4.addLecture(1, 13);
        se2aa4.addLecture(3, 13);
        se2aa4.addLecture(4, 13);

        se2fa3.addLecture(2, 12);
        se2fa3.addLecture(3, 12);
        se2fa3.addLecture(5, 12);

        se2c03.addLecture(1, 11);
        se2c03.addLecture(3, 11);
        se2c03.addLecture(5, 13);

        se2ga3.addLecture(2, 15);
        se2ga3.addLecture(3, 15);
        se2ga3.addLecture(5, 15);

        eng2px3.addLecture(1, 13);
        eng1p13.addLecture(1, 14);
        math2z03.addLecture(1, 15);
        math2zz3.addLecture(1, 16);
        math2zz3.addLecture(1, 16);
        freeCourse.addLecture(1, 12);

        Student Eric = new Student("Eric");

        // addDesiredCourse() method
        Eric.addDesiredCourse(se2aa4);
        Eric.addDesiredCourse(se2c03);
        Eric.addDesiredCourse(se2ga3);
        Eric.addDesiredCourse(se2cx3);
        Eric.addDesiredCourse(se2fa3);
        Eric.addDesiredCourse(se2da4);
        Eric.addDesiredCourse(eng2px3);
        Eric.addDesiredCourse(eng1p13);
        Eric.addDesiredCourse(eng1p13);
        Eric.addDesiredCourse(se2aa4);
        Eric.addDesiredCourse(math2z03);
        Eric.addDesiredCourse(math2zz3);
        Eric.addDesiredCourse(freeCourse);

        System.out.println();

        // getName() method
        System.out.println("Student Name is: " + Eric.getName());

        // checking for duplicates
        // expect 8 since eng1p13, se2aa4 should not be duplicated
        System.out.println("There are " + Eric.desiredCourses.size() + " courses in Eric's desired courses");
        System.out.print("These courses are: ");
        for (Course course : Eric.desiredCourses){
            System.out.print(course.getCode() + " ");
        }

        System.out.println("\n");
    
        System.out.print("The best schedule for " + Eric.getName() + " is: ");
        ArrayList<Course> bestS = Eric.getBestSchedule();
        for (Course course : bestS)
            System.out.print(course.getCode() + " ");

        System.out.println();
        System.out.println(Eric.getName() + " has to be on campus for " + Eric.numDaysOnCampus(bestS) + " days");
        System.out.println("size of power set is " + Eric.powerSet(Eric.desiredCourses).size());        // 2^11 = 2048
        System.out.println(Eric.power(2,5));        // 2^5 = 32
    }   
}
