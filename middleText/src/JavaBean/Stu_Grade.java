package JavaBean;

public class Stu_Grade {
		private String name;
		private int grade;
		public void setName(String name) {
			this.name = name;
		}
		public void setGrade(int grade) {
			this.grade = grade;
		}
		public String getName() {
			return name;
		}
		public int getGrade() {
			return grade;
		}
		public Stu_Grade() {
			
		}
		public Stu_Grade(String name,int garde) {
			this.grade = garde;
			this.name = name;
		}
		
}
