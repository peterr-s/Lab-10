package net.schoener.peter.gwtjobapplication.client;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.CheckBox;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.DialogBox;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.RadioButton;
import com.google.gwt.user.client.ui.TextArea;
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
	@UiField TextBox emailBox;
	@UiField TextBox phoneBox;
	@UiField CheckBox devBox;
	@UiField CheckBox uiBox;
	@UiField CheckBox mktBox;
	@UiField CheckBox busBox;
	@UiField ListBox degreeBox;
	@UiField TextArea resumeBox;
	@UiField Button submitButton;

	public JobApplication()
	{
		initWidget(uiBinder.createAndBindUi(this));
		
		DialogBox notification = new DialogBox();
		notification.setText("Job_Application_Form class invoked");
	}
	
	@UiHandler("submitButton")
	void onSubmitBtnClick(ClickEvent e)
	{
		boolean allOK;
		
		// validate name
		String name = nameBox.getValue().trim();
		allOK = !(name == null || name.equals(""));
		
		// validate gender
		boolean isMale = maleButton.getValue();
		if(!(isMale || femaleButton.getValue()))
			allOK = false;
		
		// validate email
		String email = emailBox.getValue().trim().toLowerCase();
		if(!email.matches("[a-z0-9]+@+[a-z0-9](\\.[a-z0-9])*.[a-z]{2,3}"))
			allOK = false;
		
		// validate phone number
		String phone = phoneBox.getValue().trim().replaceAll("[- \\(\\)]", "");
		//if(!phone.matches("(\\([0-9]{3}\\) ?)|([0-9]{3}(-| )?)[0-9]{3}(-| )?[0-9]{4}"))
		if(!phone.matches("[0-9]{6,}"))
			allOK = false;
		
		// validate jobs
		boolean[] wantJob = {
			devBox.getValue(),
			uiBox.getValue(),
			mktBox.getValue(),
			busBox.getValue()
		};
		if(!(wantJob[0] || wantJob[1] || wantJob[2] || wantJob[3]))
			allOK = false;
		
		// validate résumé
		String resume = resumeBox.getValue().trim();
		/*if(resume == null || resume.equals(""))
			allOK = false;*/ // not a req'd field
		
		// make popup
		Window.alert(allOK ? ("your data has been submitted:\n\t" + name + "\n\tGender: " + (isMale ? "" : "fe") + "male\n\tEmail: " + email + "\n\tPhone: " + phone + "\n\tApplying as:" + (wantJob[0] ? " developer" : "") + (wantJob[1] ? " designer" : "") + (wantJob[2] ? " marketer" : "") + (wantJob[3] ? " analyst" : "") + "\n\tDegree: " + degreeBox.getSelectedItemText() + ((resume == null || resume.equals("")) ? "" : ("\n\tRésumé: " + resume.substring(0, 20) + "..."))) : "You didn't fill the form out correctly.");
	}
}
