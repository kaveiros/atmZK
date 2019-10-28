package info.nikoschantzopoulos.engine;

import info.nikoschantzopoulos.components.Bill;
import info.nikoschantzopoulos.components.Note;

/**
 * This class provides the intial ammount of
 * Bills in the ATM. Of course in a real 
 * world application the ammount of money will
 * be provided from a database and not from a
 * singleton.
 * @author Nikos Chantzopoulos
 * @version 1.0
 * @since 07-10-2016
 *
 */
public class InitialData {
	
	private static InitialData instance = new InitialData();
	private Bill billsOfTwenty;
	private Bill billsOfFifty ;
	
	private InitialData() {
		billsOfTwenty = new Bill(Note.TWENTY, 15);
		billsOfFifty = new Bill(Note.FIFTY, 10);
	}
	
	public static InitialData getInstance() {
		return instance;
	}
	
	public long getTotal() {
		return billsOfFifty.getNumberOfBills()*50 + billsOfTwenty.getNumberOfBills()*20;
	}
	
	public long getNumberOfTweenty() {
		return billsOfTwenty.getNumberOfBills();
	}
	
	public long getNumberOfFifty() {
		return billsOfFifty.getNumberOfBills();
	}
	
	public void removeBillsOfTwenty(long billsToRemove) throws SimulatorException{
		billsOfTwenty.removeNumberOfBills(billsToRemove);
	}
	
	public void removeBillsOfFifty(long billsToRemove) throws SimulatorException{
		billsOfFifty.removeNumberOfBills(billsToRemove);
	}

}
