package net.schoener.peter.gwtjobapplication.client;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.RadioButton;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.Widget;

public class JobApplication extends Composite
{
	private static JobApplicationUiBinder uiBinder = GWT.create(JobApplicationUiBinder.class);

	interface JobApplicationUiBinder extends UiBinder<Widget, JobApplication>
	{
	}

	@UiField TextBox nameBox;

	@UiField RadioButton maleButton;
	@UiField RadioButton femaleButton;

	public JobApplication()
	{
		initWidget(uiBinder.createAndBindUi(this));
	}
}
