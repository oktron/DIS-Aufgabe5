package de.dis2011.persistence;

import java.util.concurrent.atomic.AtomicInteger;

public class PersistencyManager {
	private PersistencyManager _instance = null;
	
	private AtomicInteger _lsn;
	
	private PersistencyManager()
	{
		_lsn = new AtomicInteger(0);
	}
	
	/**
	 * Get instance of the PersistenzManager
	 * 
	 * @return
	 */
	public PersistencyManager getInstance()
	{
		if (_instance == null) {
			return new PersistencyManager();
		}
		
		return _instance;
	}
	
}
