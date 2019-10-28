package info.nikoschantzopoulos.components;


/**
 * This class is responsible for 
 * withdrawing the ammount from 
 * the ATM. It is a simple POJO.
 * @author Nikos Chantzopoulos
 * @version 1.0
 * @since 07-10-2016
 *
 */
public class Amount {
	
	private long value;
	
	public Amount() {
		
	}

	public long getValue() {
		return value;
	}

	public void setValue(long value) {
		this.value = value;
	}
	
	

}
