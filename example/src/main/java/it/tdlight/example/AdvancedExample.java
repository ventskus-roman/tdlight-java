package it.tdlight.example;

import it.tdlight.common.Init;
import it.tdlight.common.TelegramClient;
import it.tdlight.common.utils.CantLoadLibrary;
import it.tdlight.jni.TdApi;
import it.tdlight.tdlight.ClientManager;

/**
 * This is an advanced example that uses directly the native client without using the SimpleClient implementation
 */
public class AdvancedExample {

	public static void main(String[] args) throws CantLoadLibrary {
		// Initialize TDLight native libraries
		Init.start();

		// Create a client
		TelegramClient client = ClientManager.create();

		// Initialize the client
		client.initialize(AdvancedExample::onUpdate, AdvancedExample::onUpdateError, AdvancedExample::onError);

		// Here you can use the client.

		// An example on how to use TDLight java can be found here:
		// https://github.com/tdlight-team/tdlight-java/blob/master/example/src/main/java/it.tdlight.example/Example.java

		// The documentation of the TDLight methods can be found here:
		// https://tdlight-team.github.io/tdlight-docs
	}

	private static void onUpdate(TdApi.Object object) {
		TdApi.Update update = (TdApi.Update) object;
		System.out.println("Received update: " + update);
	}

	private static void onUpdateError(Throwable exception) {
		System.out.println("Received an error from updates:");
		exception.printStackTrace();
	}

	private static void onError(Throwable exception) {
		System.out.println("Received an error:");
		exception.printStackTrace();
	}
}