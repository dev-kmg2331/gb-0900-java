package interfaceTask;

public abstract class FormAdapter implements Form{
	@Override
	public String[] getMenu() {
		return null;
	}
	
	@Override
	public abstract void sell(String menu);
}
