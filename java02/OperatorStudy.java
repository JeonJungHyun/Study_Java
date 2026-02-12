package java02;
public class OperatorStudy {
    public static void main(String[] args) {
        // 데이터 저장 - 메모리 할당 - 변수 선언
        int kor = 92;
        int eng = 90;
        int mat = 81;

        // 데이터 처리 
        int tot = kor + eng + mat;
        double avg = tot / 3.0;

        // 처리 결과 확인 
        System.out.println( "국어 : " + kor + "점" );
        System.out.println( "영어 : " + eng + "점" );
        System.out.println( "수학 : " + mat + "점" );
       
        System.out.println( "총점 : " + tot + "점" );
        System.out.println( "평균 : " + avg + "점" );

        // 국어 : 92점
        // 영어 : 90점
        // 수학 : 81점
        // 총점 : 263점
        // 평균 : 87.66666667점

    }
}
