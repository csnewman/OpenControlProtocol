/*
 * ComputerClient.ino
 * Author: Chandler
 */ 


int dataPin = 2;
int latchPin = 4;
int clockPin = 7;
int clearPin = 8;
int powerStatusPin = 12;



void setup(){
	pinMode(dataPin, OUTPUT);
	pinMode(latchPin, OUTPUT);
	pinMode(clockPin, OUTPUT);
	pinMode(clearPin, OUTPUT);
	
	pinMode(powerStatusPin, INPUT);
	
	delay(1000);
	
	digitalWrite(clearPin, HIGH);
	
	Serial.begin(9600); 
	//test(10, HIGH);
}

void test(int timing, int state){
	delay(timing);
	
	for(int i = 0; i < 8; i++){
		digitalWrite(dataPin, state);
		
		delay(timing);
		
		digitalWrite(clockPin, HIGH);
		delay(timing);
		digitalWrite(clockPin, LOW);
	}
	
	digitalWrite(latchPin, HIGH);
	delay(timing);
	digitalWrite(latchPin, LOW);
}

void power(int time){
	test(0, HIGH);
	delay(time);
	test(0, LOW);
}

String serialBuffer = "";

void handleSerial(){
	int len = Serial.available();
	for (int i = 0; i < len; i ++) {
		serialBuffer += (char)Serial.read();
	}
	
	if(serialBuffer.length() > 0){
		int start = serialBuffer.indexOf('<');
		int end = serialBuffer.indexOf('>');
		
		//Clean up the string to remove extra data
		if(start > 0){
			serialBuffer = serialBuffer.substring(start);
			
			start = serialBuffer.indexOf('<');
			end = serialBuffer.indexOf('>');
		}
		
		//Wait until we have all the needed data
		if(end == -1){
			return;
		}
		
		String command = serialBuffer.substring(start, end+1);
		serialBuffer = serialBuffer.substring(end+1);
		
		int split = command.indexOf(':');
		String id = command.substring(1, split);
		String data = command.substring(split+1, command.length()-1);
		
		Serial.println("command: "+command+" (id="+id+", data="+data+")");
		
		writeCommand("response:ok");
	}
}

void writeCommand(String text){
	Serial.print("<");
	Serial.print(text);
	Serial.println(">");
}

void loop(){
	handleSerial();
	
	//	if (Serial.available() > 0) {
	//		switch (Serial.read())
	//		{
	//		case '2':
	//			power(200);
	//			break;
	//		case 'S':
	//			int s = digitalRead(powerStatusPin);
	//			String stat = "OFF";
	//			if(s == 1){
	//				stat = "ON";
	//			}
	//			Serial.println("Status: "+stat);
	//			break;
	//
	//		}
	//	}
}

