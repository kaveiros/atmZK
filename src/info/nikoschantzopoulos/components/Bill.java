package info.nikoschantzopoulos.components;

import info.nikoschantzopoulos.engine.SimulatorException;

/**
 * This POJO repsesents a Bill
 * @author Nikos Chantzopoulos
 * @version 1.0
 * @since 07-10-2016
 *
 */
public class Bill {

	private Note type;
	
	private long numberOfBills;
	
	public Bill(Note type, long numberOfBills) {
		setType(type);
		setNumberOfBills(numberOfBills);
	}

	public Note getType() {
		return type;
	}

	public void setType(Note type) {
		this.type = type;
	}

	public long getNumberOfBills() {
		return numberOfBills;
	}

	public void setNumberOfBills(long numberOfBills) {
		this.numberOfBills = numberOfBills;
	}
	
	/*
	 * Special setter to remove initial 
	 * number of bills
	 */
	public void removeNumberOfBills(long numberOfBillsRemoved) throws SimulatorException {
		if (numberOfBills >= numberOfBillsRemoved)
			numberOfBills = numberOfBills - numberOfBillsRemoved;
		else
			throw new SimulatorException("The number of bills to remove exceeds the available bills on the ATM");
			
	}
	
}
