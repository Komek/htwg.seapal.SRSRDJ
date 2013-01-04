package fu.client;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

@RemoteServiceRelativePath("greet")
public interface BoatService extends RemoteService {
	String send(BoatDTO boat) throws IllegalArgumentException;
}
