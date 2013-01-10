var map;
var position;
var tout;

//var Temp Marker
var markerTmp;
var markersTmp = [];

//var Marker
var markerNr = 0;
var markerActive;

//var Route
var pathsRoute = [];
var markersRoute = [];
var polylineRoute = [];
var polyline;

//var Distancetool
var pathDis = [];
var polylineTmp;
var polylinesTmp = [];
var markerDis;
var dTout;
var infowindowDistance;
var polylinesMarkerTmp = [];

function MVCArrayBinder(mvcArray){
    this.array_ = mvcArray;
}

MVCArrayBinder.prototype = new google.maps.MVCObject();
MVCArrayBinder.prototype.get = function(key) {
    if (!isNaN(parseInt(key))){
    	return this.array_.getAt(parseInt(key));
    } else {
    	this.array_.get(key);
    }
};

MVCArrayBinder.prototype.set = function(key, val) {
    if (!isNaN(parseInt(key))){
      this.array_.setAt(parseInt(key), val);
    } else {
      this.array_.set(key, val);
    }
};

function initialize() {
	var mapTypeIds = [ "roadmap", "satellite", "OSM" ];
	
	//StandardMap
	var mapOptions = {
		center : new google.maps.LatLng(47.66, 9.19),
		zoom : 14,
		draggableCursor: 'crosshair',
		mapTypeId : google.maps.MapTypeId.ROADMAP,
		mapTypeControlOptions : {
	            mapTypeIds : mapTypeIds,
	            style : google.maps.MapTypeControlStyle.DROPDOWN_MENU
	    }
	};
	map = new google.maps.Map(document.getElementById("map_canvas"),
			mapOptions);
	
	//OpenStreetMap
	map.mapTypes.set("OSM", new google.maps.ImageMapType({
		getTileUrl : function(coord, zoom) {
			return "http://tile.openstreetmap.org/" + zoom + "/" + coord.x
					+ "/" + coord.y + ".png";
		},
		tileSize : new google.maps.Size(256, 256),
		name : "OpenStreetMap",
		maxZoom : 18
	}));
	
	//Overlay OpenSeaMap
	map.overlayMapTypes.push(new google.maps.ImageMapType({
		getTileUrl : function(coord, zoom) {
			return "http://tiles.openseamap.org/seamark/" + zoom + "/"
					+ coord.x + "/" + coord.y + ".png";
		},
		tileSize : new google.maps.Size(256, 256),
		name : "OpenSeaMap",
		maxZoom : 18
	}));

	//LatLng center
	google.maps.event.addListener(map, 'center_changed', function() {
		var lat = map.getCenter().lat();
		var lng = map.getCenter().lng();

		$("#lat").html(getFormatLat(lat));
		$("#long").html(getFormatLng(lng));
	});
	
	$("#setMarker").click(function(){
		setMarker(position);
	});

	$("#setRoute").click(function(){
		setRoute(position);
	});
	$("#getDistance").click(function(){
		getDistance(position);
        window.clearTimeout(dTout);
		dTout = window.setTimeout(function() {
			deleteDistance();
        }, 4000);
	});
	$("#loeschen").click(function(){
		deleteMarker(markerActive);
	});
	
	$("#loeschenRoute").click(function(){
		deleteRoute(markerActive);
	});
	//Polyline Route
	var polylineOptions = {
			strokeColor: "#CC0000",
			strokeOpacity: 1.0,
			strokeWeight: 2,
			map: map
			};
		
	polyline = new google.maps.Polyline(polylineOptions);
	polyline.binder = new MVCArrayBinder(polyline.getPath());
	
	//Polyline Entfernung
	var polylineOptionsTmp = {
			strokeColor: "#CC0000",
			strokeOpacity: 1.0,
			strokeWeight: 3,
			map:map
			};
		
	polylineTmp = new google.maps.Polyline(polylineOptionsTmp);
	
	//click-Listener
	google.maps.event.addListener(map, 'click', setMarkerTmp);

}
//Format Lat
function getFormatLat(lat){
	var positionLat = lat.toString();
	var vzLat = 1;
	if(positionLat < 0){
		vzLat = -1;
	}
	var latArr = positionLat.split(".");
	var lat1 = latArr[0];
	var lat2 = (Math.round(((positionLat - lat1)*60 * 100 )) / 100 ) * vzLat;
	return "Lat "+lat1+"&deg;"+lat2+"'N ";
	
}
//Format Lng 
function getFormatLng(lng){
	var positionLng = lng.toString();
	var vzLng = 1;
	if(positionLng < 0){
		vzLng = -1;
	}
	var lngArr = positionLng.split(".");
	var lng1 = lngArr[0];
	var lng2 = (Math.round(((positionLng - lng1)*60 * 100 )) / 100 ) * vzLng;
	
	if(lng1.length == 1 && lng1>0){
		return "Lng 00"+lng1+"&deg;"+lng2+"'E ";
	}else if(lng1.length == 2 && lng1>0 ){
		return "Lng 0"+lng1+"&deg;"+lng2+"'E ";
	}else if(lng1.length == 3 && lng1>0){
		return "Lng "+lng1+"&deg;"+lng2+"'E ";
	}else if(lng1.length == 2 && lng1<0){
		return "Lng -00"+(lng1*(-1))+"&deg;"+lng2+"'E ";
	}else if(lng1.length == 3 && lng1<0 ){
		return "Lng -0"+(lng1*(-1))+"&deg;"+lng2+"'E ";
	}else if(lng1.length == 4 && lng1<0){
		return "Lng "+lng1+"&deg;"+lng2+"'E ";
	}
}
//Listener create a TMP Marker
function setMarkerTmp(event){
	$("#menueMarker").hide(300);
	$("#menueRoute").hide(300);
	position = event;
	for (var i = 0; i < markersTmp.length; i++ ) {
		markersTmp[i].setMap(null);
	}
    var markerTmpIcon = new google.maps.MarkerImage('././images_map/fadenkreuz.png',new google.maps.Size(30, 30), null, new google.maps.Point(15,15));
	var markerOptions = {
		position : event.latLng,
		map : map,
		draggable : true,
		icon: markerTmpIcon
	};
	markerTmp = new google.maps.Marker(markerOptions);
    markersTmp.push(markerTmp);

	var infowindow = new google.maps.InfoWindow();
	infowindow.setContent("Position: <br>"+getFormatLat(event.latLng.lat())+getFormatLat(event.latLng.lng()));
    infowindow.open(map, markerTmp);
	google.maps.event.addListener(markerTmp, 'click', function(event) {
		infowindow.setContent("Position: <br>"+getFormatLat(event.latLng.lat())+getFormatLat(event.latLng.lng()));
        infowindow.open(map, markerTmp);
	});	
	google.maps.event.addListener(markerTmp, 'dragend', function(event){
		infowindow.close();
		infowindow.setContent("Position: <br>"+getFormatLat(event.latLng.lat())+getFormatLat(event.latLng.lng()));
	 });
	
	showMenue();
}

//set Marker
function setMarker(event){
	deleteMarker(markerTmp);
	markerNr++;
	var markerOptions = {
			position : event.latLng,
			map : map,
		    animation: google.maps.Animation.DROP,
			title: "MarkerNr :"+markerNr,
			draggable : true
		};
	
	var marker = new google.maps.Marker(markerOptions);
	
	var infowindow = new google.maps.InfoWindow();
	google.maps.event.addListener(marker, 'click', function(event) {
		$("#menueTmp").hide(300);
		$("#menueRoute").hide(300);
		infowindow.setContent(marker.title+" | Position: <br>"+getFormatLat(event.latLng.lat())+getFormatLat(event.latLng.lng()));
        infowindow.open(map, marker);
        markerActive = marker;
        showMenueMarker();
        setTimeout(function(){infowindow.close();}, '2500');
	});	
	google.maps.event.addListener(marker, 'dragend', function(event){
		infowindow.close();
		infowindow.setContent(marker.title+" | Position: <br>"+getFormatLat(event.latLng.lat())+getFormatLat(event.latLng.lng()));
		infowindow.open(map, marker);
		setTimeout(function(){infowindow.close();}, '1500');
	 });
	$("#menueTmp").hide(300);
	
}
//set Route 
function setRoute(event){
	deleteMarker(markerTmp);
	pathRoute = polyline.getPath();
	pathRoute.push(event.latLng);
	var len = pathRoute.getLength();
	var markerOptionsPolyline = {
			position : event.latLng,
			map : map,
		    animation: google.maps.Animation.DROP,
			icon: '././images_map/route.png',
			title: "Routenpunkt: "+pathRoute.getLength(),
			draggable : true
		};
	
	var markerRoute = new google.maps.Marker(markerOptionsPolyline);
	markersRoute.push(markerRoute);
	polylineRoute.push(polyline);
	markerRoute.bindTo('position', polyline.binder, (len-1).toString());
	
	var infowindow = new google.maps.InfoWindow();
	google.maps.event.addListener(markerRoute, 'click', function(event) {
		markerActive = markerRoute;
		$("#menueRoute").hide(300);
		infowindow.setContent(markerRoute.title+" | Position: <br>"+getFormatLat(event.latLng.lat())+getFormatLat(event.latLng.lng())+"<br> Distanz der ges. Route: "+calculateDistance(pathRoute)+"km");
        infowindow.open(map, markerRoute);
        showMenueRoute();
        setTimeout(function(){infowindow.close();}, '3500');
	});
	
	google.maps.event.addListener(markerRoute, 'dragend', function(event) {
		markerActive = markerRoute;
		$("#menueRoute").hide(300);
		infowindow.setContent(markerRoute.title+" | Position: <br>"+getFormatLat(event.latLng.lat())+getFormatLat(event.latLng.lng())+"<br> Distanz der ges. Route: "+calculateDistance(pathRoute)+"km");
        infowindow.open(map, markerRoute);
        showMenueRoute();
        setTimeout(function(){infowindow.close();}, '2500');
	});	
	
	$("#menueTmp").hide(300);
}
//set Polylines, Markers (Distance Tools)
function getDistance(event){
	deleteMarker(markerTmp);
	pathDis = polylineTmp.getPath();
	pathDis.push(event.latLng);
	var markerOptionsDistance = {
			position : event.latLng,
			map : map,
			title: 'Nr.:'+pathDis.getLength(),
			icon: '././images_map/entfernung.png'
		};
	markerDis = new google.maps.Marker(markerOptionsDistance);
	polylinesTmp.push(polylineTmp);
	polylinesMarkerTmp.push(markerDis);
	var infowindow = new google.maps.InfoWindow();
	if(polylinesMarkerTmp.length > 1){
		infowindow.setContent("ges. Distanz: "+calculateDistance(pathDis)+"km");
		infowindow.open(map, markerDis);
		setTimeout(function(){infowindow.close();}, '2500');
	}
	$("#menueTmp").hide(300);

}

//calculate Distance between start and end markers
function calculateDistance(event) {
    var distance = google.maps.geometry.spherical.computeLength(event);
    return (Math.round(distance / 1000 * 100) / 100);

}
//delete marker
function deleteMarker(event){
	event.setMap(null);
	$("#menueMarker").hide(300);
}

//show Menue Temp Marker
function showMenue(){
	$("#menueTmp").show(300);
	window.clearTimeout(tout);
	tout = window.setTimeout(function(){
		markerTmp.setMap(null);
		$("#menueTmp").hide(300);
	}, 4000);
}

//show Menue Marker
function showMenueMarker(){
	$("#menueMarker").show(300);
	window.clearTimeout(tout);
	tout = window.setTimeout(function(){
		$("#menueMarker").hide(300);
	}, 3500);
}
//show Menue route
function showMenueRoute(){
	$("#menueRoute").show(300);
	window.clearTimeout(tout);
	tout = window.setTimeout(function(){
		$("#menueRoute").hide(300);
	}, 3500);
}
//delete Route
function deleteRoute(event){
	event.unbindAll();
	for (var i = 0; i < markersRoute.length; i++ ) {
		markersRoute[i].setMap(null);
	}
    pathsRoute = [];
     
    for (var i = 0; i < polylineRoute.length; i++ ) {
    	polylineRoute[i].setMap(null);
	}
    polylineRoute = [];
    var polylineOptions = {
 			strokeColor: "CC0000",
 			strokeOpacity: 1.0,
 			strokeWeight: 2,
 			map:map
 			};
     polyline = new google.maps.Polyline(polylineOptions);
     polyline.binder = new MVCArrayBinder(polyline.getPath());

	$("#menueRoute").hide(300);
}


function deleteDistance(){
	for (var i = 0; i < polylinesMarkerTmp.length; i++ ) {
		polylinesMarkerTmp[i].setMap(null);
	}
	polylinesMarkerTmp.length = 0;
	pathDis = [];
	
	for (var i = 0; i < polylinesTmp.length; i++ ) {
		polylinesTmp[i].setMap(null);
	}
	var polylineOptionsTmp = {
			strokeColor: "#CC0000",
			strokeOpacity: 1.0,
			strokeWeight: 3,
			map:map
			};
	
    polylineTmp = new google.maps.Polyline(polylineOptionsTmp);
}