package net.schoener.peter.gwtjobapplication.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.ui.DialogBox;
import com.google.gwt.user.client.ui.RootPanel;

public class Job_Application_Form implements EntryPoint
{

	@Override
	public void onModuleLoad()
	{
		RootPanel.get().add(new JobApplication());

		DialogBox notification = new DialogBox();
		notification.setText("Job_Application_Form class invoked");
	}

}
