package info.nikoschantzopoulos.engine;

/**
 * This interface defines the methods for 
 * the chain of responsibility pattern.
 * The chain of responsibility pattern has a 
 * group of objects that are expected between
 * them be able to solve a problem. 
 * If the first Object can't solve it, it passes
 * the data to the next Object in the chain
 * @author Nikos Chantzopoulos
 * @version 1.0
 * @since 07-10-2016
 */
public interface Chain {

	/*
	 * Defines the next Object to receive the data if this Object can't process it
	 */
	public void setNextChain(Chain nextChain);
	
	/*
	 * Either solves the problem or passes the data to the next Object in the chain
	 */
	public void calculate(long ammount) throws SimulatorException;
}
