package answers;

/**
 * 
 * @author Taiwo / Fabulous Fellini
 *
 */
public class Answers {

	private final String[] busAnswers = {
			"Leave your house",
			"Walk to the bus stop",
			"Wait for the bus",
			"Get on the bus",
			"Take out money or bus card",
			"Pay bus fair",
			"Find a seat on the bus",
			"Sit down on seat",
			"Pay attention to your location so you do not miss your destination",
			"When you're almost to your destination, pull the string or push the "
					+ "button to alert the bus driver you want to get off the bus",
			"Get off the bus",
			"Walk to your final destination"
	}; 

	private final String[] shoeAnswers = {
			"Choose desired socks",
			"Put on socks",
			"Choose desired shoes",
			"If shoes are tied, untie them",
			"Put right shoe on right foot",
			"Put left shoe on left foot",
			"If shoes have laces, tie them.  If shoes have velcro, strap them"
	};
	
	private final String[] brushingTeethAnswers = {
			"Get toothbrush and toothpaste",
			"Apply toothpaste to toothbrush",
			"Brush teeth well",
			"Spit out toothpaste",
			"Rinse off toothbrush",
			"Put toothbrush and toothpaste away"
	};
	
	private final String[] laundryAnswers = {
			"Place dirty laundry in a basket or a bag",
			"Ask guardian which settings to use for washing machine, and apply those settings",
			"Bring dirty laundry to washing machine",
			"Place laundry soap in washing machine",
			"Place dirty laundry into washing machine",
			"Turn on washing machine",
			"Wait for laundry timer to end",
			"Remove laundry from washing machine"
	};
	
	private final String[] dryerAnswers = {
			"Place wet laundry in dryer",
			"Close dryer door",
			"Ask guardian which settings to use for dryer, and apply those settings",
			"Turn on dryer",
			"Wait for dryer timer to end",
			"If laundry is still wet, add additional time",
			"When laundry is dry, remove laudry from dryer",
			"Fold"
	};
	
	private final String[] crossingStreetAtStopSignAnswers = {
			"Walk towards destination, towards the closes stop sign",
			"Stop at the stop sign",
			"Look both ways, and make sure no cars are coming in either direction",
			"Walk across the street",
			"Repeat steps until you arrive at your destination"
	};
	
	private final String[] crossingStreetAtStopLightAnswers = {
			"Walk towards destination, towards the closes stop light",
			"Stop at the stop light",
			"Wait for the walk signal",
			"Look both ways, and make sure no cars are coming in either direction",
			"Walk across the street",
			"Repeat steps until you arrive at your destination"
	};

	private final String[] washingHandsAtHomeAnswers = {
			"Turn on water faucet",
			"Wet hands",
			"Apply hand soap",
			"Rub hands together for 15 seconds",
			"Rinse hands",
			"Dry hands"
	};
	
	private final String[] washingHairAnswers = {
			"Get in shower",
			"Turn on shower",
			"Wet your hair",
			"Grab desired shampoo",
			"Follow directions on shampoo bottle to wash your hair",
			"Make sure to keep your eyes closed while shampooing hair",
			"Rinse your hair"
	};
	
	private final String[] orderFoodFromSitDownRestarantAnswers = {
			"Go to desired restaurant",
			"Wait for host or hostess to seat you",
			"Review the menu",
			"Decide what you would like to order",
			"Wait for the waiter or waitress to visit your table",
			"Place your order with the waiter or waitress",
			"Wait for food to arrive",
			"Consume food"
	};
	
	private final String[] payBillFromSitDownRestarantAnswers = {
			"Finish eating",
			"Wait for waiter or waitress to visit your table",
			"Ask for check",
			"Wait for waiter or waitress to arrive with check",
			"Choose desired form of payment",
			"Place desired form of payment with check",
			"Wait for waiter or waitress to pick up check from your table",
			"Wait for waiter or waitress to return with check",
			"Leave tip (15% - 20%)",
			"If payment is with credit or debit card, sign check" 
	};
	
	private final String[] orderFoodFromFastFoodRestarantAnswers = {
			"Go to desired restaurant",
			"Wait for cashier to welcome you",
			"Review the menu",
			"Decide what you would like to order",
			"Tell cashier what you would like to order",
			"Let cashier tell you the total",
			"Give cashier form of payment",
			"Check change is correct",
			"Wait for food to arrive",
			"Consume food" 
	};
	
	public String[][] answers = {
			busAnswers,
			shoeAnswers,
			brushingTeethAnswers,
			laundryAnswers,
			dryerAnswers,
			crossingStreetAtStopSignAnswers,
			crossingStreetAtStopLightAnswers,
			washingHandsAtHomeAnswers,
			washingHairAnswers,
			orderFoodFromSitDownRestarantAnswers,
			payBillFromSitDownRestarantAnswers,
			orderFoodFromFastFoodRestarantAnswers
	};

	/**
	 * 
	 * @return String[][]
	 */
	public String[][] getAnswers() {
		return answers;
	}
}
