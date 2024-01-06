import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

class Main {
  public static void main(String[] args) {
    Student[] students = readStudentsFromFile("grades.txt");

    double[] averageGrades = new double[students.length];
    for (int i = 0; i < students.length; i++) {
      averageGrades[i] = students[i].calculateAverageGrade();
    }

    bubbleSort(averageGrades, students);
    System.out.println("Sorted by average grades (Bubble Sort):");
    for (Student student : students) {
      System.out.println(student.getName() + ": " + student.calculateAverageGrade());
    }

    Arrays.sort(averageGrades);
    System.out.println("\nSorted by average grades (Arrays.sort):");
    for (double grade : averageGrades) {
      for (Student student : students) {
        if (student.calculateAverageGrade() == grade) {
          System.out.println(student.getName() + ": " + grade);
        }
      }
    }
  }
  
  public static Student[] readStudentsFromFile(String filename) {
      Student[] students = new Student[25];
      int studentCount = 0;

      try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
        String line;
        while ((line = br.readLine()) != null) {
          String[] parts = line.split(" ");
          String name = parts[0];
          double[] grades = new double[5];

          for (int i = 1; i <= 5; i++) {
            grades[i - 1] = Double.parseDouble(parts[i]);
          }

          students[studentCount] = new Student(name, grades);
          studentCount++;
        }
      } catch (IOException e) {
        e.printStackTrace();
      }
        return Arrays.copyOf(students, studentCount);
  }

    public static void bubbleSort(double[] arr, Student[] students) {
      int n = arr.length;
      boolean swapped;

      do {
        swapped = false;
        for (int i = 1; i < n; i++) {
          if (arr[i - 1] > arr[i]) {
            double tempGrade = arr[i - 1];
            arr[i - 1] = arr[i];
            arr[i] = tempGrade;

            Student tempStudent = students[i - 1];
            students[i - 1] = students[i];
            students[i] = tempStudent;

            swapped = true;
          }
        }
      } while (swapped);
    }
}