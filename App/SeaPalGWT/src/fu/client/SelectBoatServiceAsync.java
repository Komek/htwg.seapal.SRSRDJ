package fu.client;

import java.util.Collection;
import com.google.gwt.user.client.rpc.AsyncCallback;

public interface SelectBoatServiceAsync {
	void selectBoat(AsyncCallback<Collection<BoatDTO>> callback);
}
