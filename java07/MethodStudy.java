package java07;

// 오버로드
public class MethodStudy {
    public void disp( int a, char b ) {
        System.out.print( a + "\t" );
        for( int i=0; i<a; i++ ) {
            System.out.print( b );
        }
        System.out.println();
    }
    public void disp( char a, int b ) {
        System.out.print( b + "\t" );
        for( int i=0; i<b; i++ ) {
            System.out.print( a );
        }
        System.out.println();
    }
    public void disp( int a, char b, char c ) {
        System.out.print( a + "\t" );
        for( int i=0; i<a; i++ ) {
            if( i % 2 == 0 ) System.out.print( b );
            else System.out.print( c );
        }
        System.out.println();
    }
    public void disp( char a, int b, int c ) {
        int cnt = 0;
        if( b > c ) cnt = b - c;
        else cnt = c - b;
        System.out.print( cnt + "\t" );
        for( int i=0; i<cnt; i++ ) {
            System.out.print( a );
        }
        System.out.println();
    }
    public void disp( String a, int b ) {
        System.out.print( b + "\t" );
        for( int i=0; i<b; i++ ) {
            System.out.print( a );
        }
        System.out.println();
    }
    public static void main(String[] args) {
        MethodStudy ms = new MethodStudy();
        ms.disp( 5, '@' );              // 5       @@@@@
        ms.disp( 3, '#' );              // 3       ###
        ms.disp( '$', 7 );              // 7       $$$$$$$
        ms.disp( 7, '%', '#' );       // 7       %#%#%#%
        ms.disp( '&', 9, 4 );         // 5       &&&&&
        ms.disp( '*', 4, 10 );        // 6       ******
        ms.disp( "!", 10 );             // 10      !!!!!!!!!!
    }
}




