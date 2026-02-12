package java03;

import java.io.BufferedReader;
import java.io.InputStreamReader;

// 삼항 연산
// 국어 영어 수학 점수를 입력받는다
// 평균 70점이상 이면 "합격" 출력
// 70점미만 이면 "불합격" 출력
// 점수가 국영수 하나라도 0~100 사이가 아니면 "잘못입력" 출력
// 삼항연산자를 두 개 겹쳐서 사용해야 한다.

public class OperatorStudy {
    public static void main(String[] args) throws Exception {
        BufferedReader br 
            = new BufferedReader( new InputStreamReader( System.in ) );
        System.out.print( "국어 : " );     
        int kor = Integer.parseInt( br.readLine() );
        System.out.print( "영어 : " );     
        int eng = Integer.parseInt( br.readLine() );
        System.out.print( "수학 : " );     
        int mat = Integer.parseInt( br.readLine() );

        double avg = ( kor + eng + mat ) / 3.0;

        System.out.println(
            kor >= 0 && kor <= 100 && eng >= 0 && eng <= 100 && mat >= 0 && mat <= 100
            ? ( avg >= 70 ? "합격" : "불합격" )         // 값이 범위 내 일때만
            : "잘못입력"
        );
        System.out.println(
            kor < 0 || kor > 100 || eng < 0 || eng > 100 || mat < 0 || mat > 100
            ? "잘못입력"
            : ( avg >= 70 ? "합격" : "불합격" )
        );
    }
}
