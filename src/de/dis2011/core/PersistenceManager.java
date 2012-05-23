package de.dis2011.core;

public interface PersistenceManager {
	
	/**
	 * Get instance of the persistence manager
	 * 
	 * @return The manager
	 */
	public PersistenceManager getInstance();
	
	/**
	 * Begin a new transaction
	 * 
	 * @return Transaction id
	 */
	public Integer beginTransaction();
	
	/**
	 * Write new usage data
	 * 
	 * @param transactionId The transaction id
	 * @param data Data to write
	 */
	public void write(Integer transactionId, String data);
	
	/**
	 * Write usage data to existing page
	 * 
	 * @param transactionId The transaction id
	 * @param pageNumber The page number
	 * @param data Data to write
	 */
	public void write(Integer transactionId, Integer pageNumber, String data);
	
	/**
	 * Commit a transaction
	 * 
	 * @param id Transaction id
	 */
	public void commit(Integer tid);
	
	
}
