package fu.client;

import com.google.gwt.user.client.rpc.AsyncCallback;

public interface DeleteBoatServiceAsync {

	void deleteBoat(String key, AsyncCallback<String> callback);

}
