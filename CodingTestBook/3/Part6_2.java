
/*
 * 8/19 정렬 문제 - p180
 * N명의 학생정보가 있고 각 학생은 이름과 성적으로 구분한다.
 * 성적이 낮은 순서대로 학생의 이름을 출력하라
 */

import java.util.*;

class Student{
    String name;
    int score;

    public Student(String name, int score){
        this.name = name;
        this.score = score;
    }
    
    public String getName(){
        return name;
    }

    public int getScore(){
        return score;
    }
   
}

public class Part6_2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        Student[] student_array = new Student[N];

        for(int i=0; i<N; i++){
            String name = sc.next();
            int score = sc.nextInt();
            student_array[i] = new Student(name,score);
        }

        Arrays.sort(student_array, new Comparator<Student>() {
            @Override
            public int compare(Student s1, Student s2) {
                return Integer.compare(s1.getScore(),s2.getScore());
            }
        });
        
        for(int i=0; i<N; i++){
            System.out.print(student_array[i].getName());
            if(i != N-1)  System.out.print(" ");
        }
 }
}

/*
 * Array.sort를 사용할 때 임의의 클래스를 사용한다면 Overried를 통해 어떤 값으로 정렬할 지 정의할 것
 */