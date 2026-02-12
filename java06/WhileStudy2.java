package java06;

import java.io.BufferedReader;
import java.io.InputStreamReader;

// 덧셈 맞추기 게임 / 구구단 게임
// 컴퓨터가 사용자에게 랜덤으로 덧셈 문제를 10문제 출제

// 1번 문제] 45 + 23 :
// 답 입력 :            정답        정답입니다 출력 / 맞은 개수 증가 / 점수 + 10점
//                     오답        오답입니다 출력 / 정답은 68입니다 출력
// 2번 문제] 68 + 35 :
// 답 입력 :            정답        정답입니다 출력 / 맞은 개수 증가 / 점수 + 10점
//                     오답        오답입니다 출력 / 정답은 103입니다 출력

// ... 10문제 출력
// 맞은개수 : 5개
// 점수 : 50점

// 더 할거냐? (Y/y)     Y/y 입력            새로 10문제 출제
//                     Y/y 이외 입력        프로그램 종료

public class WhileStudy2 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader( new InputStreamReader( System.in ) );        
        
        while( true ) {
            int cnt = 0;
            int score = 0;
            String yn = null;
            for( int i=0; i<10; i++ ) {
                int a = (int) ( Math.random() * 100 ) + 1;
                int b = (int) ( Math.random() * 100 ) + 1;
                System.out.print( (i+1) + "]번 문제 " + a + " + " + b + " : " );
                int answer = Integer.parseInt( br.readLine() );
                if( answer == a+b ) {
                    System.out.println( "정답입니다" );
                    cnt ++;
                    score += 10;
                } else {
                    System.out.println( "오답입니다" );
                    System.out.println( "정답은 " + (a+b) + "입니다" );                
                }
            }
            System.out.println( "맞은 개수 : " + cnt + "개" );
            System.out.println( "점수 : " + score + "점" );
            
            System.out.print( "더할거냐 (Y/y) : " );
            yn = br.readLine();
            if( ! yn.equals( "Y" ) && ! yn.equals( "y" ) )
                break;
        }
    }
}
