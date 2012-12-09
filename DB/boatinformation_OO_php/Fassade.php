<?php
include("Backend/Boat.php");
	class Fassade{
		
		
		public $boats = Array();
		
		
		public static function addBoat($param){
			
			//$boat = new Boat($param);
			
			for ($i = 0; $i < count($param); $i++) {
	   			echo "Wert " .$i." : ".$param[i];
			}
			
		}
		
		public static function deleteBoat($key){
			
		}
		
		public static function getBoat($key){
			
		}
		
	}   
?>