package de.dis2011.persistence;

public class PersistenzManager {
	private PersistenzManager _instance = null;
	
	private PersistenzManager()
	{
		
	}
	
	public PersistenzManager getInstance()
	{
		if (_instance == null) {
			return new PersistenzManager();
		}
		
		return _instance;
	}
}
