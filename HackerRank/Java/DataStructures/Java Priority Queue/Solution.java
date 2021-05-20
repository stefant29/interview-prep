// https://www.hackerrank.com/challenges/java-priority-queue

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.PriorityQueue;
import java.util.Arrays;

class Student implements Comparable<Student> {
    public int id;
    public String name;
    public double cgpa;
    
    public Student(int id, String name, double cgpa) {
        this.id = id;
        this.name = name;
        this.cgpa = cgpa;
    }
    
    public int getId() {
        return this.id;
    }
    
    public String getName() {
        return this.name;
    }
    
    public double getCGPA() {
        return this.cgpa;
    }
    
    public int compareTo(Student s) {
        if (this.cgpa > s.cgpa) {
            return -1;
        } else if (this.cgpa < s.cgpa) {
            return 1;
        } else if (!this.name.equals(s.name)) {
            return this.name.compareTo(s.name);
        } else {
            return this.id - s.id;
        }
    }
}

class Priorities {
    public List<Student> getStudents(List<String> events) {
        PriorityQueue<Student> pq = new PriorityQueue<Student>();
        for (String event : events) {
            String[] commands = event.split(" ");
            if (commands[0].equals("ENTER")) {
                pq.add(new Student(Integer.parseInt(commands[3]), commands[1], Double.parseDouble(commands[2])));
            } else if (commands[0].equals("SERVED")) {
                pq.poll();
            }
        }
        
        ArrayList<Student> ret = new ArrayList();
        while (pq.size() != 0) {
            ret.add(pq.poll());
        }
        return ret;
    }
}

