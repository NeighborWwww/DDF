#include <IRremote.h>
#include <stdio.h>
#include <LiquidCrystal.h>
volatile int RECV_PIN = 10;
volatile int iptBuff = 0;
volatile int mode = 0;
volatile int minite = 0;
volatile int sec = 0;
volatile int hr = 0;
volatile int d = 1;
volatile int m = 1;
volatile int y = 0;
volatile int REGH = 0;
volatile int REGL = 0;
volatile int set_buff1 = 0;
volatile int set_buff2 = 0;
volatile int set_buff3 = 0;
volatile int counterFlg = 0;
volatile int buff[6] = {0,0,0,0,0,0};
volatile boolean startFlg = false;
volatile int sec_s = 0;
volatile int minite_s = 0;
volatile int hr_s = 0;
volatile int sec_sl = 0;
volatile int minite_sl = 0;
volatile int hr_sl = 0;
volatile int sec_c = 0;
volatile int minite_c = 0;
volatile int hr_c = 0;
volatile int pmode = 0;
volatile int s_Buff = 0;
LiquidCrystal lcd(12, 11, 5, 4, 3, 2);
IRrecv irrecv(RECV_PIN);

decode_results results;

void setup()
{
  Serial.begin(9600);
  // In case the interrupt driver crashes on setup, give a clue
  // to the user what's going on.
  Serial.println("Enabling IRin");
  irrecv.enableIRIn(); // Start the receiver
  Serial.println("Enabled IRin");
  cli(); // disable global interrupts before configuring interrupt
  TCCR1A = 0; // set TCCR1A register to 00000000
  TCCR1B = 0; // set TCCR1B register to 00000000
  OCR1A = 15999; // set compare match register
 /* Notice that (15624+1)*1/16000000*1024 ~ 1 second */
  TCCR1B |= (1 << WGM12); // Set WGM12 bit to 1, turns on CTC mode:
  TCCR1B |= (1 << CS12)|(1 << CS10); // Set CS10 and CS12 bits to 1
 /* Notice that When CS12=1, CS11=0 and CS12=1, pre-scaler is 1024 */
  TIMSK1 |= (1 << OCIE1A); // enable timer compare interrupt:
  sei(); // enable global interrupts after configured interrupt

}
void disp_d(int n1,int n2, int n3){
   Serial.print(n1);
   Serial.print(".");
   Serial.print(n2);
   Serial.print(".");
   Serial.print(n3);
   Serial.println("");
}
void disp(int n1,int n2,int n3){

  Serial.print(n1);
  Serial.print(":");
  Serial.print(n2);
  Serial.print(":");
  Serial.print(n3);
  Serial.println("");
  Serial.print("Mode is ");
  Serial.println(mode);
}


void resetBuff(){
  mode = 0;
  pmode = 0;
  set_buff1 = 0;
  set_buff2 = 0;
  set_buff3 = 0;
  for (int i = 0; i<6;i++){
    buff[i] = 0;
  }
  Serial.println("Buffer reset!");
}
void stopWatchReset(){
  sec_s = 0;
  minite_s = 0;
  hr_s = 0;
}
ISR(TIMER1_COMPA_vect){ // This function runs once every time timer compare
  
  if (counterFlg ==1 && mode == 4){
    sec_c--;
    if(sec_c == -1){
      sec_c = 59;
      minite_c--;
      if(minite_c == -1){
        minite_c = 59;
        hr--;
      }
    }
    if (sec_c == 0 && minite_c == 0 && hr_c == 0){
      Serial.println("wake up!!!");
      delay(2000);
      counterFlg = 0;
      resetBuff();
    }
  }
  if (mode == 3 && startFlg){
    sec_s++;
    if(sec_s == 60){
      sec_s = 0;
      minite_s++;
      if(minite_s==60){
        minite_s = 0;
        hr_s++;
        if(hr_s == 24){
          Serial.println("Are you kidding me? TOO MUCH!");
        }
      }
    }
  }
  else if(mode == 3 && !startFlg){
    stopWatchReset();
  }
  sec++;
  if (sec >= 60){
    sec = 0;
    minite ++;
    if (minite>=60){
      minite = 0;
      hr++;
      if(hr >= 24){
        hr = 0;
        d++;
        if(d>=31){
          d=1;
          m++;
          if(m>=13){
            m=1;
            y++;
          }
        }
      }
    }
  }
  if (mode == 1 || mode ==2 || ((mode == 4)&&(counterFlg==0))){
    disp(set_buff1,set_buff2,set_buff3);
  }
  else if(mode == 3 && startFlg){
    disp(hr_s,minite_s,sec_s);
  }
  else if(mode == 3 && !startFlg){
    disp(hr_sl,minite_sl,sec_sl);
  }
  else if((mode == 4)&&(counterFlg == 1)){
    disp(hr_c,minite_c,sec_c);
  }
  else{
      disp_d(y,m,d);
      disp(hr,minite,sec);
  }
}


void translate(){
  switch(results.value)
  {
    case 0xFFA25D: iptBuff = 11; Serial.print(iptBuff); Serial.println("  SET"); break;
    case 0xFFE21D: iptBuff = 12; Serial.print(iptBuff);Serial.println("  RESET"); break;
    case 0xFF6897: iptBuff = 0; Serial.print(iptBuff);Serial.println("  0"); break;
    case 0xFF30CF: iptBuff = 1; Serial.print(iptBuff);Serial.println("  1"); break;
    case 0xFF18E7: iptBuff = 2; Serial.print(iptBuff);Serial.println("  2"); break;
    case 0xFF7A85: iptBuff = 3; Serial.print(iptBuff);Serial.println("  3"); break;
    case 0xFF10EF: iptBuff = 4; Serial.print(iptBuff);Serial.println("  4"); break;
    case 0xFF38C7: iptBuff = 5; Serial.print(iptBuff);Serial.println("  5"); break;
    case 0xFF5AA5: iptBuff = 6; Serial.print(iptBuff);Serial.println("  6"); break;
    case 0xFF42BD: iptBuff = 7; Serial.print(iptBuff);Serial.println("  7"); break;
    case 0xFF4AB5: iptBuff = 8; Serial.print(iptBuff);Serial.println("  8"); break;
    case 0xFF52AD: iptBuff = 9; Serial.print(iptBuff);Serial.println("  9"); break;
    default:
    Serial.println("Dont care");   
  }
  delay(500);
  
}
void loadBuff(){
        for (int i=0; i<6; i++){
          Serial.println("for loop enter");
          while(!(irrecv.decode(&results)));
          delay(500);
//          Serial.println("recieved");
          translate();
          if(iptBuff == 12){
            resetBuff();
            break;
          }
          if(iptBuff == 11){
            break;
          }
          buff[i] = iptBuff;
          irrecv.resume();
//          Serial.print("buff");
//          Serial.print(i);
//          Serial.print(" = ");
//          Serial.println(buff[i]);
          set_buff3 = buff[0]*10+buff[1];
          set_buff2 = buff[2]*10+buff[3];
          set_buff1 = buff[4]*10+buff[5];
          }
}

void loop() {
//  Serial.print("loop mode is ");
//  Serial.println(mode);
while(!(irrecv.decode(&results)));
//  if (!(irrecv.decode(&results))) {
    translate();
    mode = iptBuff;
    irrecv.resume(); // Receive the next value
    if(mode == 0|| mode ==1||mode == 2|| mode == 3|| mode == 4){
      pmode = mode;
    }
    else{
      mode = pmode;
    }
    if(mode == 1){
      Serial.println("Mode Settime Enter");
      loadBuff();
          if (set_buff3 > 59){
            set_buff3 = 59;
          }
          if (set_buff2 > 59){
            set_buff2 = 59;
          }
          if (set_buff1 > 23){
            set_buff1 = 23;
          }
        
        if(iptBuff !=12){
          while(!(irrecv.decode(&results)));
          delay(500);
          irrecv.resume();
          translate();
          if(iptBuff == 11){
            sec = set_buff3;
            minite = set_buff2;
            hr = set_buff1;
            resetBuff();
           }
        }
        else{
          resetBuff();
        }
    }
    else if(mode == 2){
        Serial.println("Mode Setdate Enter");
        loadBuff();
        if (set_buff3 > 30){
            set_buff3 = 30;
        }
        if (set_buff2 > 12){
            set_buff2 = 12;
        }
        if(iptBuff !=12){
          while(!(irrecv.decode(&results)));
          delay(500);
          translate();
          irrecv.resume();
          if(iptBuff == 11){
            d = set_buff3;
            m = set_buff2;
            y = set_buff1;
            resetBuff();
           }
        }
        else{
          resetBuff();
        }
    }  
    
    else if(mode == 3){
      Serial.println("Mode Stopwatch Enter");
        while(!(irrecv.decode(&results)));
        translate();
        irrecv.resume();
        while(iptBuff == 11){
          if(iptBuff == 11){
            startFlg = !startFlg;
            if(!startFlg){
               sec_sl = sec_s;
               minite_sl = minite_s;
               hr_sl = hr_s;
            }

          }
          else if(iptBuff == 12){
           resetBuff();
            break;
          }
        while(!(irrecv.decode(&results)));
        translate();
        irrecv.resume();
        }
        resetBuff();

    }
    else if(mode == 4){
      Serial.println("Mode Countdown Enter");
      loadBuff();
          if (set_buff3 > 59){
            set_buff3 = 59;
          }
          if (set_buff2 > 59){
            set_buff2 = 59;
          }
          if (set_buff1 > 23){
            set_buff1 = 23;
          }
        
        if(iptBuff !=12){
        while(!(irrecv.decode(&results)));
          delay(500);
          translate();
          irrecv.resume();
          if(iptBuff == 11){
            sec_c = set_buff3;
            minite_c = set_buff2;
            hr_c = set_buff1;
            counterFlg = 1;
          }
        }
    }
//}
}


//FFA25D SET
//FFE21D RESET
//FF6897 0
//FF30CF 1
//FF18E7 2 
//FF7A85 3 
//FF10EF 4
//FF38C7 5 
//FF5AA5 6
//FF42BD 7
//FF4AB5 8
//FF52AD 9
