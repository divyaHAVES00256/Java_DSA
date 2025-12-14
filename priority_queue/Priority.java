// import java.util.Comparator;
import java.util.PriorityQueue;

public class Priority {
    static class Student implements Comparable<Student>{ //Interface methods are implicitly public abstract
        int rank;
        String name;

        //student 
        Student(int rank, String name){
            this.rank = rank;
            this.name = name;
        }

        // @Override
        public int compareTo(Student s2){ //overriding comparetor is public as interface is public 
            return this.rank - s2.rank;
        }
    }
    public static void main(String[] args) {
        PriorityQueue<Student> pq = new PriorityQueue<>();
        pq.add(new Student(3, "Alice"));
        pq.add(new Student(11, "Bob"));
        pq.add(new Student(5, "Charlie"));
        pq.add(new Student(11, "David"));
        pq.add(new Student(4, "Eve"));
        while (!pq.isEmpty()) {
            Student s = pq.remove(); // removes smallest rank first
            System.out.println(s.rank + " - " + s.name);
        }

        System.out.println("gchgchb ");

        // PriorityQueue<Integer> pq1 = new PriorityQueue<>(Comparator.reverseOrder());
        PriorityQueue<Integer> pq1 = new PriorityQueue<>();

        pq1.add(23);
        pq1.add(3);
        pq1.add(2);
        pq1.add(31);
        while(!pq1.isEmpty()){
            System.out.println(pq1.remove());
            
        }
    }
}
