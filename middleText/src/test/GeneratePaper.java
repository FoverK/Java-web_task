package test;


public class GeneratePaper {
		private char[] oper = {'+','-','*','/'};
		private int[] quesNum  = {5,10,20,};
		private String[] question ;
		private int[] answer;
		
		public void setQuestion(String[] q) {
				this.question = q;
		}
		public void setAnswer(int[] a) {
			this.answer = a;
	}
		public String[] getQuestion() {
			return question;
		}
		public int[] getAnswer() {
			return answer;
		}
		public  void gQuestion() {
				
				
				int r2 = (int) (Math.random()*3);
				String[]q = new String[quesNum[r2]];
				int[] a = new int[quesNum[r2]];
				for(int i = 0 ; i< quesNum[r2];i++) {
					int r1 = (int) (Math.random()*4);
					int correct = 0;
					int num1 =  (int) (Math.random()*101);
					int num2 =  (int) (Math.random()*101);
					switch(oper[r1]) {
						case '+':
							correct = num1 + num2;
							break;
						case '-':
							correct = num1 - num2;
							break;
						case '*':
							correct = num1 * num2;
							break;
						case '/':
							while(num2 == 0) {
								num2 =  (int) (Math.random()*101);
							}
							correct = num1 / num2;
							break;
					}
					q[i] = String.valueOf(num1) + "   "+ oper[r1] + "   "+ String.valueOf(num2) + "   "+ "=";
					a[i] = correct;
				}
				setQuestion(q);
				setAnswer(a);
		}
}
