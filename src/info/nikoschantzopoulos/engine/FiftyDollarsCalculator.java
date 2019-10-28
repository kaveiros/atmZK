package info.nikoschantzopoulos.engine;


/**
 * This class calculates the amount 
 * of fifty euro bills that will be withdrawn from the ATM.
 * If needed it passes the remaining amount to the next chain 
 * which is the twentyDollarsCalculator.
 * @author Nikos Chantzopoulos
 * @version 1.0
 * @since 07-10-2016
 *
 */
public class FiftyDollarsCalculator implements Chain {

	private Chain nextInChain;
	
	/*
	 * Defines the next Object to receive the data if this Object can't process it
	 */
	@Override
	public void setNextChain(Chain nextChain) {
		this.nextInChain = nextChain;

	}

	/*
	 * Either solves the problem or passes the data to the next Object in the chain
	 */
	@Override
	public void calculate(long amount) throws SimulatorException {
		
		InitialData initialData = InitialData.getInstance();
		if (amount > initialData.getTotal())
			throw new SimulatorException("There in not enough cash to withdraw");
		
		long numberOfbills = amount/50;
		if(initialData.getNumberOfFifty() > 0 && initialData.getNumberOfFifty() > numberOfbills) {
			long remain = amount%50;
			
			if (remain%20 != 0)
				throw new SimulatorException("The requested amount is not available for the current combination of notes");
			
			try {
					initialData.removeBillsOfFifty(numberOfbills);
			} catch (SimulatorException e) {
					throw new SimulatorException("The number of bills to withdraw exceeds the available bills on the ATM");
			}
			
			if (remain >= 0) {
				nextInChain.calculate(remain);
			}
		}
		else if(initialData.getNumberOfFifty() > 0 && initialData.getNumberOfFifty() < numberOfbills) {
			long amountRem = amount - initialData.getNumberOfFifty()*50;
			
			if (amountRem%20 !=0)
				throw new SimulatorException("The requested amount is not available for the current combination of notes");
			
			try {
				initialData.removeBillsOfFifty(initialData.getNumberOfFifty());
			} catch (SimulatorException e) {
				throw new SimulatorException("The number of bills to withdraw exceeds the available bills on the ATM");
			}
			
			if (amountRem >= 0) {
				nextInChain.calculate(amountRem);
			}
		}
		else {
			nextInChain.calculate(amount);
		}
		
		
		
	}

}
