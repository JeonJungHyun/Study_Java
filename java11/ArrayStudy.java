package java11;

public class ArrayStudy {
    public static void main(String[] args) {
        int SIZE = 5;
        int m[][] = new int[SIZE][SIZE];
        int cnt = 0;
        int a = SIZE/2, b = SIZE/2;        
        for( int i=0; i<m.length; i++ ) {   
            for( int j=a; j<=b; j++ ) {
                m[i][j] = ++cnt;
            }
            if( i<SIZE/2 ) {
                a --; b ++;
            } else {
                a ++; b --;
            }
        }
        for( int i=0; i<m.length; i++ ) {           // 출력
            for( int j=0; j<m[i].length; j++ ) {
                System.out.print( m[i][j] + "\t" );
            }
            System.out.println();
        }
    }
}
