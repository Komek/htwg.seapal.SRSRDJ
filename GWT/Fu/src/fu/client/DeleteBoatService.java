package fu.client;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

@RemoteServiceRelativePath("deleteBoat")
public interface DeleteBoatService extends RemoteService{
	String deleteBoat(String key);
}
