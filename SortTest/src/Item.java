import java.util.ArrayList;

public class Item {
	
	private String projectKey;
	private String moduleName;
	
	public Item(String projectKey, String moduleName)
	{
		this.projectKey=projectKey;
		this.moduleName=moduleName;
	}
	public String getProjectKey() {
		return projectKey;
	}
	public void setProjectKey(String projectKey) {
		this.projectKey = projectKey;
	}
	public String getModuleName() {
		return moduleName;
	}
	public void setModuleName(String moduleName) {
		this.moduleName = moduleName;
	}
	
}
