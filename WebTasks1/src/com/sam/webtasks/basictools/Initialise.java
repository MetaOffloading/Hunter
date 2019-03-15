package com.sam.webtasks.basictools;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.TextBox;
import com.sam.webtasks.client.SequenceHandler;
import com.sam.webtasks.client.SessionInfo;

public class Initialise {
	public static void Run() {
		if (SessionInfo.localTesting) {
			Window.alert("Set to local testing mode. Data will not be stored on server.");
		}
	
		//set timestamp for the beginning of the experiment
		TimeStamp.Start();
		
		//generate a random session key so that we have an identifier for this session
	    SessionInfo.sessionKey=SessionKey.Get();

		//generate a reward code, which can be used to claim payment at end
		RewardCode.Generate();

		//set up counterbalancing
		for (int i = 0; i < SessionInfo.counterbalanceFactors.length; i++) {
			if (SessionInfo.specifiedLevels[i]==-1) {
				Counterbalance.addFactor(SessionInfo.counterbalanceFactors[i], SessionInfo.counterbalanceLevels[i]);
			} else {
				Counterbalance.addFactor(SessionInfo.counterbalanceFactors[i], SessionInfo.counterbalanceLevels[i], SessionInfo.specifiedLevels[i]);
			}
		}
		
		HTML participantHTML = new HTML("Please enter your participant code:");
		final TextBox textBox = new TextBox();
		Button continueButton = new Button("Continue");
		
		RootPanel.get().add(participantHTML);
		RootPanel.get().add(textBox);
		RootPanel.get().add(continueButton);
		
		continueButton.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				if (textBox.getText().length() > 0) {
					SessionInfo.participantID = textBox.getText();
					RootPanel.get().clear();
					SequenceHandler.Next();
				}
				
			}
		});
	}
}
