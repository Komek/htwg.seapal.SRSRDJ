package fu.client;

import com.google.gwt.user.client.rpc.AsyncCallback;

public interface BoatServiceAsync {
	void send(BoatDTO boat, AsyncCallback<String> callback)
			throws IllegalArgumentException;
}
