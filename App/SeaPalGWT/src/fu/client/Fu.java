package fu.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.VerticalPanel;

public class Fu implements EntryPoint {
	
	private static final String SERVER_ERROR = "An error occurred while "
			+ "attempting to contact the server. Please check your network "
			+ "connection and try again.";
	private VerticalPanel formPanel = new VerticalPanel();
	public static Form form = new Form();
	private Button deleteButton = new Button();
	
	public void onModuleLoad() {
		deleteButton.setText("Loeschen");
		formPanel.add(form.initForm());
		RootPanel.get("form").add(formPanel);
		Tableload.load_Table();
	}
}
