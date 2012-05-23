package de.dis2011.core;

import java.io.FileWriter;
import java.util.concurrent.atomic.AtomicInteger;

public class PersistenceManagerFilesystem implements PersistenceManager {

	private PersistenceManager _instance = null;
	
	private AtomicInteger _pageNumber;
	private AtomicInteger _currentTransactionId;
	private AtomicInteger _lsn;
	
	private PersistenceManagerFilesystem() 
	{
		_pageNumber = new AtomicInteger();
		_currentTransactionId = new AtomicInteger();
		_lsn = new AtomicInteger();
	}
	
	@Override
	public PersistenceManager getInstance() 
	{
		if (_instance == null) {
			return new PersistenceManagerFilesystem();
		}
		
		return _instance;
	}

	@Override
	public Integer beginTransaction() 
	{
		Integer transactionId = _currentTransactionId.getAndIncrement();
		
		
		log(transactionId,0,"bot");
		
		return transactionId;
	}

	@Override
	public void write(Integer transactionId, String data) 
	{
		Integer pageNumber = _pageNumber.getAndIncrement();
		
		// TODO Auto-generated method stub
		log(transactionId, pageNumber, data);
	}
	
	@Override
	public void write(Integer transactionId, Integer pageNumber, String data)
	{
		// TODO Auto-generated method stub
		log(transactionId, pageNumber, data);
	}

	@Override
	public void commit(Integer transactionId) 
	{
		// TODO Auto-generated method stub
		log(transactionId,0,"commit");
	}
	
	/**
	 * Log to file
	 * 
	 * @param transactionId The transaction id
	 * @param pageNumber The page number
	 * @param data The data
	 */
	private void log(Integer transactionId, Integer pageNumber, String data)
	{
		Integer lsn = _lsn.getAndIncrement();
		String logEntry = lsn + "," + transactionId + "," + pageNumber + "," + data;
		
		try {
			FileWriter writer = new FileWriter(lsn+"");
			
			writer.write(logEntry);
			writer.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
