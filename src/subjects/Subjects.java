package subjects;

import questions.Questions;

/**
 * 
 * @author Taiwo / Fabulous Fellini
 *
 */
public class Subjects {
	
	public static final int SUBJECT_BUS                                  = 0;
	public static final int SUBJECT_SHOES                                = 1;
	public static final int SUBJECT_BRUSHING_TEETH                       = 2;
	public static final int SUBJECT_LAUNDRY                              = 3;
	public static final int SUBJECT_CROSSING_THE_STREET_AT_STOP_SIGN     = 4; 
	public static final int SUBJECT_CROSSING_THE_STREET_AT_STOPLIGHT     = 5;
	public static final int SUBJECT_WASHING_HANDS_AT_HOME                = 6;
	public static final int SUBJECT_WASHING_HAIR                         = 7;
	public static final int SUBJECT_ORDER_FOOD_FROM_SIT_DOWN_RESTAURANT  = 8;
	public static final int SUBJECT_ORDER_FOOD_FROM_FAST_FOOD_RESTAURANT = 9;
	public static final int SUBJECT_PAY_BILL_AT_SIT_DOWN_RESTAURANT      = 10;
	
	private int currentSubject;
	
	private Questions question = new Questions();
	
	/**
	 * Constructor.  Set subject to first subject.
	 */
	public Subjects() {
		currentSubject = SUBJECT_BUS;
	}

	public int getCurrentSubject() {
		return currentSubject;
	}

	public void setCurrentSubject(int currentSubject) {
		this.currentSubject = currentSubject;
	}

	public Questions getQuestion() {
		return question;
	}
}
