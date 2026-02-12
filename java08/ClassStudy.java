package java08;
public class ClassStudy {
    private int kor;
    private int eng;
    private int mat;
    public ClassStudy( int kor, int eng, int mat ) {
        this.kor = kor;
        this.eng = eng;
        this.mat = mat;
    }
    public int total() {
        return kor + eng + mat;
    }
    public double average() {
        return total() / 3.0;
    }
    public String pass() {
        return average() >= 70 ? "합격" : "불합격";
    }
    public static void main(String[] args) {
        ClassStudy cs = new ClassStudy( 75, 88, 90 );
        System.out.println( "총점 : " + cs.total() );                
        System.out.println( "평균 : " + cs.average() );
        System.out.println( "당락 : " + cs.pass() );        
        // 평균이 70점이상 "합격" 아니면 "불합격" 출력
    }
}
