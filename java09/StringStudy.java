package java09;

import java.util.Calendar;
import java.util.StringTokenizer;

public class StringStudy {
    public static void main(String[] args) {
        // String StringBuffer StringTokenizer Wrapper Array
        // 주민등록번호 입력        990820-1******   
        
        // 당신은 1999년 8월 20일생 남자이고 26세입니다. 출력       2025-1999
        // 1이나 2면 1900년대생 3이나 4면 2000년대생
        StringBuffer sb = new StringBuffer();
        StringTokenizer st = new StringTokenizer( "990820-1111111", "-" );
        while( st.hasMoreTokens() ) {
            sb.append( st.nextToken() );
        }
        
        // sb
        //   0   1   2   3   4   5   6
        // | 9 | 9 | 0 | 8 | 2 | 0 | 1 | ...        char []
        int year = ( sb.charAt(0 ) - 48 ) * 10 + sb.charAt( 1 ) - 48;
        //               '9' 57                    '9' 57
        int month = ( sb.charAt(2 ) - 48 ) * 10 + sb.charAt( 3 ) - 48;
        // int day = ( sb.charAt(4 ) - 48 ) * 10 + sb.charAt( 5 ) - 48;
        // int day = Integer.parseInt( sb.substring( 4, 6 ) );
        char[] str = sb.toString().toCharArray();
        int day = ( str[4] - 48 ) * 10 + str[5] - 48;

        int gender = sb.charAt( 6 ) - 48;       // 1 2 3 4
        year += ( gender == 1 || gender == 2 ) ? 1900 : 2000; 
        String fm = ( gender == 1 || gender == 3 ) ? "남자" : "여자";
        int age = Calendar.getInstance().get( Calendar.YEAR ) - year;
        //          Calendar 객체.메서드

        System.out.println( "당신은 " + year + "년 " + month + "월 " + day + "일생 " 
            + fm + "이고 " + age + "살 입니다" );



    }
}
