package java13;
import java.util.Collections;
import java.util.Vector;
class Card {
    private int num;
    private boolean isGwang;
    private String name;
    public Card( int num, boolean isGwang, String name ) {
        this.num = num;
        this.isGwang = isGwang;
        this.name = name;
    }  
    public int getNum() {
        return num;
    }  
    public String getName() {
        return name;
    }
    public boolean getIsGwang() {
        return isGwang;
    }
    public String toString() {
        return "숫자 : " + num + ", 광 : " + isGwang + ", 카드 : " + name;
    }
}
class Rank {
    private int num;
    private String name;
    private Card one;
    private Card two;
    public Rank( int num, String name, Card one, Card two ) {
        this.num = num;
        this.name = name;
        this.one = one;
        this.two = two;
    }
    public int getNum() {
        return num;
    }
    public String getName() {
        return name;
    }
    public Card getOne() {
        return one;
    }
    public Card getTwo() {
        return two;
    }
    public String toString() {
        return "등수: " + num + ", 족보: " + name + ", 패: [" + one + ", " + two + "]";
    }
}
public class CollectionStudy {
    private Vector<Card> deck;
    private Vector<Rank> winning;
    private Vector<Card> comCard;
    private Vector<Card> userCard;
    public CollectionStudy() {
        deck = new Vector<Card>( 20 );      // 카드 덱
        winning = new Vector<Rank>( 37 );   // 족보
        comCard = new Vector<Card>( 2 );    // 컴퓨터 패
        userCard = new Vector<Card>( 2 );   // 사용자 패
        // 카드를 나열한다.
        for (int i = 1; i <= 10; i++) {
            if (i == 1 || i == 3 || i == 8) {
                deck.add(new Card(i, true, i + "월 광"));
                deck.add(new Card(i, false, i + "월"));
            } else {
                deck.add(new Card(i, false, i + "월"));
                deck.add(new Card(i, false, i + "월"));
            }
        } 
        // 족보를 나열한다. 
        winning.add(new Rank(1, "38광땡", deck.get(4), deck.get(14)));
        winning.add(new Rank(2, "18광땡", deck.get(0), deck.get(14)));
        winning.add(new Rank(3, "13광땡", deck.get(0), deck.get(4)));

        winning.add(new Rank(4, "장땡", deck.get(18), deck.get(19)));
        winning.add(new Rank(5, "9땡", deck.get(16), deck.get(17)));
        winning.add(new Rank(6, "8땡", deck.get(15), deck.get(14)));
        winning.add(new Rank(7, "7땡", deck.get(12), deck.get(13)));
        winning.add(new Rank(8, "6땡", deck.get(10), deck.get(11)));
        winning.add(new Rank(9, "5땡", deck.get(8), deck.get(9)));
        winning.add(new Rank(10, "4땡", deck.get(6), deck.get(7)));
        winning.add(new Rank(11, "3땡", deck.get(4), deck.get(5)));
        winning.add(new Rank(12, "2땡", deck.get(2), deck.get(3)));
        winning.add(new Rank(13, "1땡", deck.get(0), deck.get(1)));

        winning.add(new Rank(14, "알리", deck.get(0), deck.get(2)));
        winning.add(new Rank(14, "알리", deck.get(0), deck.get(3)));
        winning.add(new Rank(14, "알리", deck.get(1), deck.get(2)));
        winning.add(new Rank(14, "알리", deck.get(1), deck.get(3)));
        
        winning.add(new Rank(15, "독사", deck.get(0), deck.get(6)));
        winning.add(new Rank(15, "독사", deck.get(0), deck.get(7)));
        winning.add(new Rank(15, "독사", deck.get(1), deck.get(6)));
        winning.add(new Rank(15, "독사", deck.get(1), deck.get(7)));
        
        winning.add(new Rank(16, "구삥", deck.get(16), deck.get(0)));
        winning.add(new Rank(16, "구삥", deck.get(16), deck.get(1)));
        winning.add(new Rank(16, "구삥", deck.get(17), deck.get(0)));
        winning.add(new Rank(16, "구삥", deck.get(17), deck.get(1)));
        
        winning.add(new Rank(17, "장삥", deck.get(18), deck.get(0)));
        winning.add(new Rank(17, "장삥", deck.get(18), deck.get(1)));
        winning.add(new Rank(17, "장삥", deck.get(19), deck.get(0)));
        winning.add(new Rank(17, "장삥", deck.get(19), deck.get(1)));
        
        winning.add(new Rank(18, "장사", deck.get(18), deck.get(6)));
        winning.add(new Rank(18, "장사", deck.get(18), deck.get(7)));
        winning.add(new Rank(18, "장사", deck.get(19), deck.get(6)));
        winning.add(new Rank(18, "장사", deck.get(19), deck.get(7)));
        
        winning.add(new Rank(19, "세륙", deck.get(10), deck.get(6)));
        winning.add(new Rank(19, "세륙", deck.get(10), deck.get(7)));
        winning.add(new Rank(19, "세륙", deck.get(11), deck.get(6)));
        winning.add(new Rank(19, "세륙", deck.get(11), deck.get(7)));
        
        // 광땡이하 땡보다 높다
        winning.add(new Rank(20, "땡잡이", deck.get(6), deck.get(12)));
        // 어떤 패보다 우선으로 판을 재시작한다. 
        winning.add(new Rank(21, "구사", deck.get(16), deck.get(6)));               
    } // 생성자 

    public void dispDeck() {                // 카드 덱 출력
        for ( Card card : deck ) {
            System.out.println( card );
        }
    }
    public void dispWinning() {             // 족보 출력
        for ( Rank rank : winning ) {
            System.out.println( rank );
        }
    }
    public void dealCard() {
        Collections.shuffle( deck );
        userCard.clear();
        comCard.clear();
        userCard.add( deck.get( 0 ) );
        userCard.add( deck.get( 2) );
        comCard.add( deck.get( 1 ) );
        comCard.add( deck.get(3 ) ); 
    }

    public Rank checkCard( Vector <Card> cards ) {
        for( int i=0; i<winning.size(); i++ ) {
            Rank r = winning.get( i );
            if( ( r.getOne().equals( cards.get(0 ) ) 
                && r.getTwo().equals( cards.get(1) ) ) ||
                ( r.getOne().equals( cards.get(1) ) 
                && r.getTwo().equals( cards.get(0) ) )
                ) {
                return r;
            }
        }
        int num = ( cards.get(0).getNum() + cards.get(1).getNum() ) % 10;
        String name = num == 0 ? "망통" : num + "끗";        
        return new Rank( 100-num, name, cards.get(0), cards.get(1) );
    }  

    public int decideWinner() {
        int win = 0;
        // -1           컴퓨터 승
        // 0            비김
        // 1            사용자 승
        Rank com = checkCard( comCard );
        Rank user = checkCard( userCard );

        System.out.println( "컴퓨터 패 : " + com.getName() );
        System.out.println( "사용자 패 : " + user.getName() );

        if( com.getName().equals( "땡잡이" ) ) {
            if( user.getName().contains( "땡") && ! user.getName().contains( "광땡") ) {
                System.out.println( "컴퓨터가 땡잡이로 이겼습니다" );
                return -1;
            }
        }
        if( user.getName().equals( "땡잡이" ) ) {
            if( com.getName().contains( "땡") && ! com.getName().contains( "광땡") ) {
                System.out.println( "사용자가 땡잡이로 이겼습니다" );
                return 1;
            }
        }
        if( user.getName().equals( "구사") || com.getName().equals( "구사" ) ) {
            System.out.println( "구사로 비겼습니다" );
            return 0;
        }
        if( com.getNum() < user.getNum() ) {
            win = -1;
            System.out.println( "컴퓨터가 이겼습니다" );
        } else if( com.getNum() > user.getNum() ) {
            win = 1;
            System.out.println( "사용자가 이겼습니다" );
        } else {
            win = 0;
            System.out.println( "비겼습니다" );
        }
        return win;
    }

    public static void main(String[] args) {
        CollectionStudy cs = new CollectionStudy();
        // cs.dispDeck();
        // cs.dispWinning();

        // 컴퓨터와 1:1 게임
        // 카드를 섞어서 각각 2장을 갖는다. 
        // 족보인 경우는 족보 등수 대로 승패
        // 족보가 아닌 경우 두 카드 숫자를 더해서 끗이 높은 쪽이 승
        // 각각의 카드를 출력하고 승패 출력
        // 최종적으로 먼저 10회 승리하는 쪽이 최종승리
        
        int comCnt = 0;
        int userCnt = 0;        
        int round = 0;
        int winNum = 10;
        while( true ) {
            round ++;
            System.out.println();
            System.out.println( round + "판 째 경기입니다" );            

            // 카드를 섞어서 나눈다.
            cs.dealCard();
            
            // 승패를 결정한다. 
            int win = cs.decideWinner();
            if( win == 1 ) {
                userCnt ++;
            } else if( win == -1 ) {
                comCnt ++;
            }
            
            System.out.println( "사용자 : " + userCnt + "승" + "\t" 
                + "컴퓨터 : " + comCnt + "승" );

            System.out.println();    
            if( comCnt >= winNum ) {
                System.out.println( "컴퓨터가 최종 승리했습니다" );
                break;
            } else if( userCnt >= winNum ) {
                System.out.println( "사용자가 최종 승리했습니다" );
                break;
            }
        } 
    }
}
