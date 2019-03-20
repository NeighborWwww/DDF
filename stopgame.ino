#include <LiquidCrystal.h>
  LiquidCrystal lcd(12, 11, 5, 4, 3, 2);
  int AnalogIn_0 = A0;
  int buttom_pin  =  13;
  int led = 7;
  long system_clock = 0;
  long acc=0;
  long react_Time = 0;
  int timeoutflg = 0;
  long timewait = 0;
void setup() {
  // put your setup code here, to run once:
  pinMode(buttom_pin,INPUT_PULLUP);
  pinMode(led,OUTPUT);    
   /* Configure interrupt on Timer1 */
  cli(); // disable global interrupts before configuring interrupt
  TCCR1A = 0; // set TCCR1A register to 00000000
  TCCR1B = 0; // set TCCR1B register to 00000000
  OCR1A = 15999; // set compare match register
 /* Notice that (15624+1)*1/16000000*1024 ~ 1 second */
  TCCR1B |= (1 << WGM12); // Set WGM12 bit to 1, turns on CTC mode:
  TCCR1B |= (0 << CS12)|(1 << CS10); // Set CS10 and CS12 bits to 1
 /* Notice that When CS12=1, CS11=0 and CS12=1, pre-scaler is 1024 */
  TIMSK1 |= (1 << OCIE1A); // enable timer compare interrupt:
  sei(); // enable global interrupts after configured interrupt

}
void loop() {
  // put your main code here, to run repeatedly:
  digitalWrite(led,LOW);
  timewait = 0;
  acc = 0;
  react_Time = 0;
  timeoutflg = 0;
  system_clock = 0;
  timewait = system_clock+random(3000,10000);
  while (timewait<system_clock){
  }
  digitalWrite(led,HIGH);
  acc = system_clock;
  while(digitalRead(buttom_pin) != 1){
    if (system_clock>acc+50000){
      timeoutflg = 1;
    }
  }
  react_Time = system_clock - acc;
  if (timeoutflg == 1){
   lcd.clear(); // start with a blank screen (refresh)
   lcd.setCursor(0, 0); // set the cursor to column 0, line 0
   lcd.print(" TIME OUT ");
   delay(10000);
  }
  else{
   lcd.clear(); // start with a blank screen (refresh)
   lcd.setCursor(0, 0); // set the cursor to column 0, line 0
   lcd.print("Reaction Time =  ");
   lcd.setCursor(0,1);
   lcd.print(react_Time);
   delay(10000);
  }

}
ISR(TIMER1_COMPA_vect){ // This function runs once every time timer compare
  system_clock++;
}
