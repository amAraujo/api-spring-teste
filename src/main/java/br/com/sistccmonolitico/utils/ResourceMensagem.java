package br.com.sistccmonolitico.utils;

import java.text.MessageFormat;
import java.util.ResourceBundle;

import br.com.sistccmonolitico.enuns.MensagemEnum;

public class ResourceMensagem {
	
	private static final String BUNDLE_NAME = "mensagem";

	public static String getMessage(MensagemEnum messageEnum, Object... args) {
		String message = ResourceBundle.getBundle(BUNDLE_NAME).getString(messageEnum.getMensagem());
		if (message != null && args.length > 0) {
			message = MessageFormat.format(message, args);
		}
		return message;

	}
}
