package fu.client;

import java.util.Collection;
import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

@RemoteServiceRelativePath("selectBoat")
public interface SelectBoatService extends RemoteService{
	Collection<BoatDTO> selectBoat() throws IllegalArgumentException;
}
