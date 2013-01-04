package fu.client;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.KeyCodes;
import com.google.gwt.event.dom.client.KeyUpEvent;
import com.google.gwt.event.dom.client.KeyUpHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;

public class MyHandler implements KeyUpHandler,ClickHandler {
	private final BoatServiceAsync sendBoatService = (BoatServiceAsync) GWT
			.create(BoatService.class);
	private final DeleteBoatServiceAsync deleteBoatService = (DeleteBoatServiceAsync) GWT
			.create(DeleteBoatService.class);
	String key;
	
	public MyHandler(){
		
	}
	public MyHandler(String key){
		this.key=key;
	}

	public void onKeyUp(KeyUpEvent event) {
		if (event.getNativeKeyCode() == KeyCodes.KEY_ENTER) {
			BoatDTO boat = new BoatDTO();
			boat.setValues(Fu.form);
			AsyncCallback<String> callback = new AsyncCallback<String>() {
				public void onFailure(Throwable caught) {
					caught.printStackTrace();
				}

				public void onSuccess(String result) {
					if (result.equals(null)) {
						Window.alert("Eintragung fehlgeschlagen!");
					} else {
						Window.alert("Eingetragen!");
						Tableload.load_Table();
						Fu.form.reset_form();
					}
				}
			};
			sendBoatService.send(boat, callback);
		}
	}
	public void onClick(ClickEvent event) {
		AsyncCallback<String> callback = new AsyncCallback<String>() {
			public void onFailure(Throwable caught) {
				caught.printStackTrace();				
			}
			public void onSuccess(String result) {
				if (result.equals(null)) {
					Window.alert("Eintrag NICHT geloescht!");
				}else {
					Window.alert("Eintrag geloescht!");
					Tableload.load_Table();
					Fu.form.reset_form();
				}
				
			}
		};
		deleteBoatService.deleteBoat(this.key, callback);

	}
}
