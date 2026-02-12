package java04;

import java.io.BufferedReader;
import java.io.InputStreamReader;

// 간단한 계산기
// 숫자 두 개와 연산자를 입력받아서 연산 결과를 출력

// ex) 
// 정수 : 2
// 정수 : 5
// 연산자 ( + - * / % ) : +
// 출력 : 2 + 5 = 7

// 나눗셈은 소수점이 출력되도록
// + - * / % 연산자가 아닌 경우에는 "잘못입력" 출력

public class SwitchStudy {
    public static void main(String[] args) throws Exception {
        BufferedReader br 
            = new BufferedReader( new InputStreamReader( System.in ) );
        System.out.print( "정수 : " );
        int a = Integer.parseInt( br.readLine() );
        
        System.out.print( "정수 : " );
        int b = Integer.parseInt( br.readLine() );
        
        System.out.print( "연산자( + - * / % ) : " );
        switch( br.readLine() ) {
        case "+" : System.out.println( a + " + " + b + " = " + ( a + b ) ); break;
        case "-" : System.out.println( a + " - " + b + " = " + ( a - b ) ); break;
        case "*" : System.out.println( a + " * " + b + " = " + ( a * b ) ); break;
        case "/" : System.out.println( a + " / " + b + " = " + ( (double) a / b ) ); break;
        case "%" : System.out.println( a + " % " + b + " = " + ( a % b ) ); break;
        default : System.out.println( "잘못입력" );
        }
    }
}
