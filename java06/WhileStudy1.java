package java06;

import java.io.BufferedReader;
import java.io.InputStreamReader;


// 숫자 맞추기 게임
// 컴퓨터가 임의의 수(난수) 1 ~ 10까지 발생             7
// 사용자에 1 ~ 10까지 입력                         

// 3 을 입력    틀린 경우   입력한 값이 작습니다 출력
// 8 을 입력    틀린 경우   입력한 값이 큽니다 출력 
// 7 을 입력    맞는 경우   3번 만에 맞췄는지를 출력

// 더 할거냐? (Y/y) :        Y/y가 입력된 경우         다시 난수 발생
//                          Y/y가 아닌 경우          프로그램 종료      

// 배팅을 한다    사용자가 3번안에 맞추면 배팅금액 * 2 / 컴퓨터의 합계가 차감
//              사용자가 3번안에 못 맞추면 배팅금액이 컴퓨터 금액으로 증가

// 사용자나 컴퓨터나 금액이 모두 차감되면 금액을 충전한다. 

public class WhileStudy1 {
    public static void main(String[] args) throws Exception {
        // int com = (int) ( Math.random() * 100 );       // 0.0 <= 난수 < 1.0    0~99
        // int com = (int) ( Math.random() * 100 ) + 1;   // 1 ~ 100
        BufferedReader br = new BufferedReader( new InputStreamReader( System.in ) );
        String yn = null;
        do {
            int com = (int) ( Math.random() * 10 ) + 1; 
            int cnt = 0;    
            while( true ) {
                cnt ++;
                System.out.print( "맞춰봐 ( 1~10 ) : " );
                int user = Integer.parseInt( br.readLine() );
                if( com == user ) {
                    System.out.println( cnt + "번 만에 정답입니다" );
                    break;
                } else if( com > user ) {
                    System.out.println( "입력한 값이 작습니다" );
                } else {
                    System.out.println( "입력한 값이 큽니다" );
                }
            }
            System.out.print( "더할거냐 (Y/y) : " );
            yn = br.readLine();
        } while( yn.equals( "Y" ) || yn.equals( "y" ) );
    }
}
