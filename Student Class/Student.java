public class Student {
    String name;
    double[] grades;
  
    public Student(String name, double[] grades) {
      this.name = name;
      this.grades = grades;
    }
  
    public String getName() {
      return name;
    }
  
    public double[] getGrades() {
      return grades;
    }
  
    public double calculateAverageGrade() {
        double sum = 0;
        for (double grade : grades) {
          sum += grade;
        }
        return sum / grades.length;
    }
  }