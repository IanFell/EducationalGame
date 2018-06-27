package questions;

import answers.Answers;

/**
 * 
 * @author Taiwo / Fabulous Fellini
 *
 */
public class Questions {
	
	public static final String QUESTION_BUS                                 = "What are the steps for taking the bus?";
	public static final String QUESTION_SHOES                               = "What are the steps to put on your shoes?";
	public static final String QUESTION_BRUSHING_TEETH                      = "What are the steps to brush your teeth?";
	public static final String QUESTION_LAUNDRY                             = "What are the steps to do laundry?";
	public static final String SUBJECT_CROSSING_THE_STREET_AT_STOP_SIGN     = "What are the steps to cross the street at a stop sign?";
	public static final String SUBJECT_CROSSING_THE_STREET_AT_STOP_LIGHT    = "What are the steps to cross the street at a stop light?";
	public static final String SUBJECT_WASHING_HANDS_AT_HOME                = "What are the steps to wash your hands at home?";
	public static final String SUBJECT_WASHING_HAIR                         = "What are the steps to wash your hair?";
	public static final String SUBJECT_ORDER_FOOD_FROM_SIT_DOWN_RESTAURANT  = "What are the steps to order food from a sit down restaruant?";
	public static final String SUBJECT_PAY_BILL_AT_SIT_DOWN_RESTAURANT      = "What are the steps to pay the bill at a fast food restaruant?";
	public static final String SUBJECT_ORDER_FOOD_FROM_FAST_FOOD_RESTAURANT = "What are the steps to order food from a fast food restaruant?";
	
	private String[] questions = {
			QUESTION_BUS,
			QUESTION_SHOES,
			QUESTION_BRUSHING_TEETH,
			QUESTION_LAUNDRY,
			SUBJECT_CROSSING_THE_STREET_AT_STOP_SIGN,
			SUBJECT_CROSSING_THE_STREET_AT_STOP_LIGHT,
			SUBJECT_WASHING_HANDS_AT_HOME,
			SUBJECT_WASHING_HAIR,
			SUBJECT_ORDER_FOOD_FROM_SIT_DOWN_RESTAURANT,
			SUBJECT_PAY_BILL_AT_SIT_DOWN_RESTAURANT,
			SUBJECT_ORDER_FOOD_FROM_FAST_FOOD_RESTAURANT,
	};  
	
	private Answers answer = new Answers();
	
	public Answers getAnswer() {
		return answer;
	}

	public String getCurrentQuestionBasedOnCurrentSubject(int currentSubject) {
		return questions[currentSubject];
	}
}
