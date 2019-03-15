package com.sam.webtasks.basictools;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.TextArea;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.sam.webtasks.client.SessionInfo;

public class Finish {
	public static void Run() {
		final HTML goodbyeText = new HTML("You have now completed the experiment. Thank you for taking part");
		RootPanel.get().add(goodbyeText);
	}
}
