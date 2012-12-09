<?php
	class Boat {
		
		private $parameter = Array();
		
				
		public function __construct($params){
			for ($i = 0; $i < count($params); $i++) {
				echo $params[$i]."wert<br>";
	   			//$parameter[$i] = $params[$i];
			}
		}
		
		public function __destruct(){
			
		}
		
		public function setBoat(){
			for ($i = 0; $i < count($params); $i++) {
	   			$parameter[$i] = $params[$i];
			}
		}
		
		public function getBoat(){
			return $parameter;
		}	
	
	}
?>