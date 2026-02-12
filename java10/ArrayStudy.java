package java10;

//      0   1   2   3
// 0    1   2   3   0
// 1    4   5   6   0
// 2    7   8   9   0
// 3    0   0   0   0

//      0   1   2   3
// 0    1   2   3   6
// 1    4   5   6   15
// 2    7   8   9   24
// 3    12  15  18  45
public class ArrayStudy {
    public static void main(String[] args) {
        int m[][] = new int[][] 
                        { {1, 2, 3, 0}, {4, 5, 6, 0}, {7, 8, 9, 0}, {0, 0, 0, 0} };        
        for( int i=0; i<m.length -1; i++ ) {               // 계산     0 1 2 
            for( int j=0; j<m[i].length -1; j++ ) {        //          0 1 2 
                m[i][3] += m[i][j];
                m[3][j] += m[i][j];
                m[3][3] += m[i][j];
            }
            System.out.println();
        }
        for( int i=0; i<m.length; i++ ) {               // 출력
            for( int j=0; j<m[i].length; j++ ) {
                System.out.print( m[i][j] + "\t" );
            }
            System.out.println();
        }
    }   
}
