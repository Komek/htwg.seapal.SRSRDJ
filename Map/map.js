var map;
var mapOptions;
var marker;
var markNr = 0;
var alleMarken = [];
var tempMarken = [];
var infowindow;
var poly;
var path;
var timeout;
var pos;
var activeMarker;

function initialize() {
    //"Menu" buttons:
    $('#bMarkeSetzen').click(function() {
        setMarker(pos);
    });
    $('#bPolylines').click(function() {
        addLatLng(pos);
    });
    $('#bEntfernung').click(function() {
        //implementieren
        alert("$ entfernung");
    });
    $('#bLoeschen').click(function() {
        deleteMarker(activeMarker);
    });
    $('#bStart').click(function(){
       //implementieren 
       alert("$ start");
    });
    $('#bEnde').click(function(){
        //implementieren
        alert("$ ende");
    })

    mapTypeIds = ["roadmap", "satellite", "OSM"];

    var crosshairShape = {
        coords : [64, 64, 64, 64],
        type : 'rect'
    };

    var latlng = new google.maps.LatLng(47.665, 9.185);

    var myOptions = {
        zoom : 14,
        center : latlng,
        mapTypeId : google.maps.MapTypeId.ROADMAP,
        draggableCursor : 'crosshair',
        mapTypeControlOptions : {
            mapTypeIds : mapTypeIds,
            style : google.maps.MapTypeControlStyle.DROPDOWN_MENU
        }
    };
    map = new google.maps.Map(document.getElementById("map_canvas"), myOptions);

    //<!--OpenStreetMap-->
    map.mapTypes.set("OSM", new google.maps.ImageMapType({
        getTileUrl : function(coord, zoom) {
            return "http://tile.openstreetmap.org/" + zoom + "/" + coord.x + "/" + coord.y + ".png";
        },
        tileSize : new google.maps.Size(256, 256),
        maxZoom : 18,
        name : "OpenStreetMap"
    }));
    //<!--OpenSeaMap-->
    map.overlayMapTypes.push(new google.maps.ImageMapType({
        getTileUrl : function(coord, zoom) {
            return "http://tiles.openseamap.org/seamark/" + zoom + "/" + coord.x + "/" + coord.y + ".png";
        },
        tileSize : new google.maps.Size(256, 256),
        name : "OpenSeaMap",
        maxZoom : 18
    }));

    //<!--LatLong - Center Listener-->
    google.maps.event.addListener(map, 'center_changed', function() {
        document.getElementById("lat").firstChild.nodeValue = map.getCenter().lat();
        document.getElementById("long").firstChild.nodeValue = map.getCenter().lng();
    });

    var polyOptions = {
        strokeColor : '#FF0000',
        strokeOpacity : 1.0,
        strokeWeight : 3
    };
    poly = new google.maps.Polyline(polyOptions);
    poly.setMap(map);

    //<!--set Marker Listener-->
    google.maps.event.addListener(map, 'click', setTempMarker);

}

function addLatLng(event) {
    deleteMarker(tempMarker);
    $("button").hide(200);

    path = poly.getPath();

    // Because path is an MVCArray, we can simply append a new coordinate
    // and it will automatically appear
    path.push(event.latLng);

    // Add a new marker at the new plotted point on the polyline.
    marker = new google.maps.Marker({
        position : event.latLng,
        title : '#' + path.getLength(),
        draggable : true,
        map : map
    });

    $('#entfernung').append(getEntfernung(marker) + '<br>');
}

function setMarker(event) {

    deleteMarker(tempMarker);
    $("button").hide(200);
    //Marker
    markNr++;

    //Marker Icon
    var marker_icon = new google.maps.MarkerImage("./map.php-Dateien/images/flag.gif", new google.maps.Size(128, 128), //originalgröße
    new google.maps.Point(0, 0), //origin
    new google.maps.Point(10, 38), //anchor
    new google.maps.Size(40, 40) //scaled Size
    );

    marker = new google.maps.Marker({
        position : event.latLng,
        title : markNr.toString(),
        draggable : true,
        icon : marker_icon
    });
    marker.setMap(map);
    alleMarken.push(marker);

    google.maps.event.addListener(marker, 'click', function() {
        showMarkerMenu();
        activeMarker = marker;
    });

    $('#ausgabe').append('Marker ' + markNr + ', LatLng: ' + event.latLng + '<br>');
}

function setTempMarker(event) {

    pos = event;
    // alte tempMarken löschen
    if (tempMarken) {
        for (i in tempMarken) {
            tempMarken[i].setMap(null);
        }
        tempMarken.length = 0;
    }

    var tempMarkInfo = new google.maps.InfoWindow({
        content : "Position: " + event.latLng
    });
    // neuen setzen
    tempMarker = new google.maps.Marker({
        position : event.latLng,
        icon : './map.php-Dateien/images/pfeil_nach_unten.jpg',
        title : "temp"
    });
    tempMarker.setMap(map);
    tempMarken.push(tempMarker);
    //Menu zeigen
    showMenu();
    //Listener
    google.maps.event.addListener(tempMarker, 'click', function() {
        tempMarkInfo.open(map, tempMarker);
    });

}

function deleteMarker(event) {
    event.setMap(null);
}

function showMenu() {
    //KontextMenu anzeigen
    $("button").hide(200);
    $(".allgMenu").show(200);

    //TimeOut
    window.clearTimeout(timeout);
    timeout = window.setTimeout(function() {
        tempMarker.setMap(null);
        $("button").hide(200);
    }, 5000);
}

function showMarkerMenu() {
    $("button").hide(200);
    $(".markerOptions").show(200);
    
    //TimeOut
    window.clearTimeout(timeout);
    timeout = window.setTimeout(function() {
        tempMarker.setMap(null);
        $("button").hide(200);
    }, 5000);
}

function getEntfernung(anfang, ende) {

    if (ende === anfang) {
        return 0;
    }

    var entfernung = 0;
    //korrigieren
    for ( i = 1; i < path.length; i++) {
        entfernung = entfernung + google.maps.geometry.spherical.computeDistanceBetween(path[i - 1], path[i]);
    }
    $('#ausgabe').append(entfernung + "<br>");

    return entfernung;
}

