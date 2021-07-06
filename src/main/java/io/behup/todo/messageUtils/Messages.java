package io.behup.todo.messageUtils;

import javax.faces.application.FacesMessage;
import javax.faces.application.FacesMessage.Severity;
import javax.faces.context.FacesContext;

public class Messages {

	public static void generateMessageInfo(Severity severity, String summary, String detail) {
		FacesMessage msg = new FacesMessage(severity, summary, detail);
		FacesContext.getCurrentInstance().addMessage(null, msg);
	}

}
