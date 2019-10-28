package info.nikoschantzopoulos.engine;

/**
 * This class calculates the amount 
 * of twenty euro bills that will be withdrawn from the ATM.
 * @author Nikos Chantzopoulos
 * @version 1.0
 * @since 07-10-2016
 *
 */
public class TwentyDollarsCalculator implements Chain {


	/*
	 * Defines the next Object to receive the data if this Object can't process it
	 */
	@Override
	public void setNextChain(Chain nextChain) {

	}

	/*
	 * Either solves the problem or passes the data to the next Object in the chain
	 */
	@Override
	public void calculate(long amount) throws SimulatorException {
		
		long numberOfbills = amount/20;
		long remain = amount%20;
		if (remain > 0)
				throw new SimulatorException("The requested amount is not available for the current combination of notes");
		
		InitialData initialData = InitialData.getInstance();
		try {
			initialData.removeBillsOfTwenty(numberOfbills);
		} catch (SimulatorException e) {
			throw new SimulatorException("The number of bills to withdraw exceeds the available bills on the ATM");
			
		}
		
		
		
	}

}
