package info.nikoschantzopoulos.VM;


import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.Init;
import org.zkoss.bind.annotation.NotifyChange;
import org.zkoss.zk.ui.util.Clients;

import info.nikoschantzopoulos.components.Amount;
import info.nikoschantzopoulos.engine.InitialData;
import info.nikoschantzopoulos.engine.SimulatorException;
import info.nikoschantzopoulos.engine.Chain;
import info.nikoschantzopoulos.engine.FiftyDollarsCalculator;
import info.nikoschantzopoulos.engine.TwentyDollarsCalculator;



/**
 * This is a View Model Class
 * ZK Binder binds it to the
 * get-money.zul page
 * during initialization.
 * @author Nikos Chantzopoulos
 * @version 1.0
 * @since 07-10-2016
 *
 */
public class GetMoneyVM {
	
	/*
	 *  The initial money on the ATM
	 */
	private InitialData initialData;
	
	/*
	 * The amount to withdraw.
	 */
	private Amount amount;
	
	
	/*
	 *  Marker annotation to identify a initial method.
	 *  Binder calls the method with this annotation when initializing a ViewModel.
	 */
	@Init
	public void init() {
		initialize();
	}
	
	
	public void initialize() {
		initialData = InitialData.getInstance();
		amount = new Amount();
	}

	/*
	 *  The ViewModel is an abstraction of the View. 
	 *  The View is responsible for displaying information and interacting with users.
	 *  The information corresponds to ViewModel's property and interaction corresponds to ViewModel's Command.
	 *  The Command is an action to manipulate ViewModel's property. 
	 *  Each command provides an action that the View can perform on ViewModel.
	
	 */
	@Command("get-money")
	@NotifyChange({"response","initialData"})
	public void onGetMoney() {
		
		Chain c1 = new FiftyDollarsCalculator();
		Chain c2 = new TwentyDollarsCalculator();
		c1.setNextChain(c2);
		
		try {
			c1.calculate(amount.getValue());
		} catch (SimulatorException e) {
			
			Clients.showNotification(e.getMessage());
		}
		
	}
	
	
	
	/*
	 *  Getters and Setters
	 *  A View Model class is actualy a POJO
	 *  communicating with the zul 
	 *  through the binder.
	 */
	
	public InitialData getInitialData() {
		return initialData;
	}


	public Amount getAmount() {
		return amount;
	}

	public void setAmount(Amount amount) {
		this.amount = amount;
	}
	
	
	
	
	

}
