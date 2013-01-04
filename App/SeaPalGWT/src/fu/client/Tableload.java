package fu.client;

import java.util.Collection;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.RootPanel;

public class Tableload {
	private static HorizontalPanel tablePanel = new HorizontalPanel();

	public static void load_Table() {
		final SelectBoatServiceAsync selectBoatservice = (SelectBoatServiceAsync) GWT
				.create(SelectBoatService.class);

		AsyncCallback<Collection<BoatDTO>> callback = new AsyncCallback<Collection<BoatDTO>>() {
			public void onFailure(Throwable caught) {
				caught.printStackTrace();
			}

			public void onSuccess(Collection<BoatDTO> result) {
				build_table(result);
			}
		};
		selectBoatservice.selectBoat(callback);
	}

	public static void build_table(Collection<BoatDTO> result) {
		tablePanel.clear();
		FlexTable boatTable = new FlexTable();
		int row = 1;
		Button trips, show, delete;
		
		boatTable.setText(0, 0, "Loeschen");
		boatTable.setText(0, 1, "Bootsname");
		boatTable.setText(0, 2, "Registernr");
		boatTable.setText(0, 3, "Typ");
		boatTable.setText(0, 4, "Eigentuemer");
		boatTable.setText(0, 5, "Trips");
		boatTable.setText(0, 6, "Werte");

		for (final BoatDTO boat : result) {
			trips = new Button("Trips");
			show = new Button("Anzeigen");
			delete = new Button("X");
			delete.addClickHandler(new MyHandler((String)boat.registernr));			
			show.addClickHandler(new ClickHandler() {
				public void onClick(ClickEvent event) {
					Fu.form.set_form(boat);
				}
			});
			trips.addClickHandler(new ClickHandler() {
				public void onClick(ClickEvent event) {
					Label lb = new Label();
					lb.setText("Forwarding to: " + boat.registernr);
					RootPanel.get("forward").clear();
					RootPanel.get("forward").add(lb);
				}
			});
			boatTable.setWidget(row, 0, delete);
			boatTable.setText(row, 1, boat.bootsname);
			boatTable.setText(row, 2, boat.registernr);
			boatTable.setText(row, 3, boat.typ);
			boatTable.setText(row, 4, boat.eigner);
			boatTable.setWidget(row, 5, trips);
			boatTable.setWidget(row, 6, show);
			boatTable.getRowFormatter().addStyleName(row, "tbtd");
			row++;
		}
		boatTable.getColumnFormatter().addStyleName(0, "bt");
		boatTable.getColumnFormatter().addStyleName(1, "tc");
		boatTable.getColumnFormatter().addStyleName(2, "tc");
		boatTable.getColumnFormatter().addStyleName(3, "tc");
		boatTable.getColumnFormatter().addStyleName(4, "tc");
		boatTable.getColumnFormatter().addStyleName(5, "bt");
		boatTable.getColumnFormatter().addStyleName(6, "bt");
		boatTable.getRowFormatter().addStyleName(0, "th");
		tablePanel.add(boatTable);
		RootPanel.get("table").add(tablePanel);
	}
}
