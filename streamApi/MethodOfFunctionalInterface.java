package streamApi;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


class Course{
    private String name;
    private String category;
    private int reviewSource;
    private int noOfStudent;

    public Course(String name, String category, int reviewSource, int noOfStudent) {
        this.name = name;
        this.category = category;
        this.reviewSource = reviewSource;
        this.noOfStudent = noOfStudent;
    }

    @Override
    public String toString() {
        return name + " : "+noOfStudent+" : "+reviewSource+" : "+category;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getReviewSource() {
        return reviewSource;
    }

    public void setReviewSource(int reviewSource) {
        this.reviewSource = reviewSource;
    }

    public int getNoOfStudent() {
        return noOfStudent;
    }

    public void setNoOfStudent(int noOfStudent) {
        this.noOfStudent = noOfStudent;
    }



}
public class MethodOfFunctionalInterface {
    public static void main(String[] args) {
         List<Course>courseList = Arrays.asList(
                new Course("Spring","Framework",98,20000),
                 new Course("Spring Boot","Framework",90,40000),
                new Course("API","Microservices",95,30000),
                new Course("Microservices","Microservices",92,25000),
                new Course("FullStack","FullStack",96,23000),
                new Course("AWS","Framework",80,20600),
                new Course("Azure","Cloud",70,20009),
                new Course("Docker","Cloud",75,60000),
                new Course("Kubernetes","Cloud",68,80000));

         //check all the cources greater than 50
         //allMatch
         System.out.println(courseList.stream().allMatch(course -> course.getReviewSource()>50));
         // noneMatch
         System.out.println(courseList.stream().noneMatch(course -> course.getReviewSource()>50));
         //anyMatch
         System.out.println(courseList.stream().anyMatch(course -> course.getReviewSource()>50));

         sortCourcesBasedOnStudentNumber(courseList);
         sortCourcesBasedOnStudentNumberDecreasingOrder(courseList);
         sortBasedOnNumberOfStudentThenReview(courseList);
         FindTipFiveAfterSort(courseList);
         SkipTopFive(courseList);
         SkipTopTwoAndAfterFetchTopFive(courseList);
         FindMaxAfterComparing(courseList);
         FindFirstWhoseReviewGreaterThan90(courseList);
         mappingExample(courseList);
         groupingBasedOnCategory(courseList);
         groupingExample(courseList);
         groupingAndMappingExample(courseList);
    }

    private static void groupingAndMappingExample(List<Course> courseList) {
        System.out.println("Grouping and Mapping Example");
//        Map<String,List<String >>listMap=courseList.stream().collect(Collectors.groupingBy(Course::getCategory,Collectors.mapping(Course::getName,Collectors.toList())));

        System.out.println(courseList.stream().collect(Collectors.groupingBy(Course::getCategory,Collectors.mapping(Course::getName,Collectors.toList()))));
    }

    private static void groupingExample(List<Course> courseList) {
        System.out.println("GroupByCouting");
        System.out.println(courseList.stream().collect(Collectors.groupingBy(Course::getCategory,Collectors.counting())));
    }

    private static void groupingBasedOnCategory(List<Course> courseList) {
        System.out.println("group based on category");
        System.out.println(courseList.stream().collect(Collectors.groupingBy(Course::getCategory)));
    }

    private static void mappingExample(List<Course> courseList) {
        System.out.println("Mapping Example");
        System.out.println(courseList.stream().filter(x->x.getReviewSource()>90).mapToInt(Course::getNoOfStudent).sum());
    }

    private static void FindFirstWhoseReviewGreaterThan90(List<Course> courseList) {
        System.out.println("Find First");
        System.out.println(courseList.stream().filter(x->x.getReviewSource()>90).findFirst());
    }

    private static void FindMaxAfterComparing(List<Course> courseList) {
        System.out.println("Find Max");
        System.out.println(courseList.stream().max(Comparator.comparing(Course::getNoOfStudent)));
    }


    private static void SkipTopTwoAndAfterFetchTopFive(List<Course> courseList) {
        System.out.println("Skip and limit");
        List<Course>list = courseList.stream().sorted(Comparator.comparingInt(Course::getNoOfStudent)).skip(2).limit(5).collect(Collectors.toList());
        System.out.println(list);
    }

    private static void SkipTopFive(List<Course> courseList) {
        System.out.println("Skip Top five");
        List<Course>list = courseList.stream().sorted(Comparator.comparing(Course::getNoOfStudent)).skip(2).collect(Collectors.toList());
        System.out.println(list);
    }

    private static void FindTipFiveAfterSort(List<Course> courseList) {
        System.out.println("Top Five after sorting");
        List<Course>list = courseList.stream().sorted(Comparator.comparing(Course::getNoOfStudent).thenComparingInt(Course::getReviewSource)).limit(5).collect(Collectors.toList());
        System.out.println(list);
    }

    private static void sortBasedOnNumberOfStudentThenReview(List<Course> courseList) {
        System.out.println("Cmparing based on student and then review");
        List<Course>list = courseList.stream().sorted(Comparator.comparing(Course::getNoOfStudent).thenComparing(Course::getReviewSource)).collect(Collectors.toList());
        System.out.println(list);
    }

    private static void sortCourcesBasedOnStudentNumberDecreasingOrder(List<Course> courseList) {
        System.out.println("Sort cource based on noOfStudent in decreasing order");
        List<Course>list = courseList.stream().sorted(Comparator.comparing(Course::getNoOfStudent).reversed()).collect(Collectors.toList());

    }

    private static void sortCourcesBasedOnStudentNumber(List<Course> courseList) {
        System.out.println("Sort cource based on noOfStudent in Increasing order");
        List<Course>list = courseList.stream().sorted(Comparator.comparing(Course::getNoOfStudent)).collect(Collectors.toList());
        //List<Course> list = courseList.stream().sorted((x,y)->x.getNoOfStudent()-y.getNoOfStudent()).collect(Collectors.toList());
        System.out.println(list);
    }




}
