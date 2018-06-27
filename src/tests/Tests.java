package tests;

import subjects.Subjects;

public class Tests {
	
	public static void outputSubjectQuestionAndAnswers(Subjects subject, int currentSubject)
	{
		currentSubject = subject.getCurrentSubject();
		System.out.println("Current subject: " + currentSubject);
		System.out.println("Current question: " + subject.getQuestion().getCurrentQuestionBasedOnCurrentSubject(currentSubject));
		for (int i = 0; i < subject.getQuestion().getAnswer().answers[0].length; i++) {
			System.out.println("Current answers: " + subject.getQuestion().getAnswer().answers[0][i]);
		}
	}

}
