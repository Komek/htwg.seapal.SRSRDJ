function CheckPattern_Text(inputField,helpId){
			return CheckPattern(/[A-Za-z'\-\s]{2,30}/,inputField.value,helpId,"Erlaubte Zeichen:A-Z,a-z,',-,Leerzeichen");
		}
		// function CheckPattern_Decimal(inputField,helpId){
			// return CheckPattern(,inputField.value,helpId,"Max. 4 Vorkommastellen und 2 Nachkommastellen");
		// }
		// function CheckPattern_Integer(inputField,helpId){
			// return CheckPattern(,inputField.value,helpId,"Erlaubte Zeichen:Ganze Zahlen");
		// }
		// function CheckPattern_Rufzeichen(inputField,helpId){
			// return CheckPattern(,inputField.value,helpId,"");
		// }
		// function CheckPattern_Typ(inputField,helpId){
			// return CheckPattern(,inputField.value,helpId,"");
		// }
		// function CheckPattern_Motor(inputField,helpId){
			// return CheckPattern(,inputField.value,helpId,"");
		// }
		// function CheckPattern_Registernr(inputField,helpId){
			// return CheckPattern(,inputField.value,helpId,"");
		// }
		// function CheckPattern_Segelzeichen(inputField,helpId){
			// return CheckPattern(,inputField.value,helpId,"");
		// }

		function CheckPattern(regex, input, helpId, helpMessage){
			if (!regex.test(input)){
				if (helpId != null){
					while (helpId.firstChild){
						helpId.removeChild(helpId.firstChild);
					}
				}
					helpId.appendChild(document.createTextNode(helpMessage)); 
					return false;
				}else {        
					if (helpId != null){
						while (helpId.firstChild){
							helpId.removeChild(helpId.firstChild);
						}
					}
				return true;
			}      
		}
		