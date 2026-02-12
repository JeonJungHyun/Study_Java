package java14;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.Random;
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
    public void setNum( int num ) {
        this.num = num;
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
        winning = new Vector<Rank>( 40 );   // 족보
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
        // 구사는 8땡 이하를 무효화 한다
        winning.add(new Rank(21, "구사", deck.get(16), deck.get(6)));               
        // 멍텅구리 구사는 땡을 제외한 족보 이하만 무효화 한다
        winning.add(new Rank(22, "멍텅구리", deck.get(16), deck.get(7)));
        winning.add(new Rank(22, "멍텅구리", deck.get(17), deck.get(6)));
        winning.add(new Rank(22, "멍텅구리", deck.get(17), deck.get(7)));

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
    private Rank com = null;
    private Rank user = null;
    public int decideWinner() {
        int win = 0;
        // -1           컴퓨터 승
        // 0            비긴 경우
        // 1            사용자 승
        // 2            구사로 비긴 경우
        com = checkCard( comCard );
        user = checkCard( userCard );

        System.out.println( "컴퓨터 패 : " + com.getName() );
        System.out.println( "사용자 패 : " + user.getName() );

        if( com.getName().equals( "땡잡이" ) ) {
            if( user.getName().contains( "땡") && ! user.getName().contains( "광땡") ) {
                System.out.println( "컴퓨터가 땡잡이로 이겼습니다" );
                return -1;
            } else {
                com.setNum( 100 - 1 );                
            }
        }
        if( user.getName().equals( "땡잡이" ) ) {
            if( com.getName().contains( "땡") && ! com.getName().contains( "광땡") ) {
                System.out.println( "사용자가 땡잡이로 이겼습니다" );
                return 1;
            } else {
                user.setNum( 100 - 1);
            }
        }
        if( user.getName().equals( "구사") ) {
            if( ! com.getName().contains( "광땡" ) 
                && ! com.getName().contains( "장땡" ) ) {
                System.out.println( "사용자의 카드가 구사로 비겼습니다" );
                return 2;
            }
        }
        if( com.getName().equals( "구사") ) {
            if( ! user.getName().contains( "광땡" ) 
                && ! user.getName().contains( "장땡" ) ) {
                System.out.println( "컴퓨터의 카드가 구사로 비겼습니다" );
                return 2;
            }
        }
        if( user.getName().contains( "멍텅구리" ) ) {
            if( com.getNum() >= 14 ) {
                System.out.println( "사용자가 멍텅구리 카드로 비겼습니다" );
                return 2;
            }
        }
        if( com.getName().contains( "멍텅구리" ) ) {
            if( user.getNum() >= 14 ) {
                System.out.println( "컴퓨터가 멍텅구리 카드로 비겼습니다" );
                return 2;
            }
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
    public static void main(String[] args) throws Exception {
        CollectionStudy cs = new CollectionStudy();
        // cs.dispDeck();
        // cs.dispWinning();

        // 컴퓨터와 1:1 게임
        // 카드를 섞어서 각각 2장을 갖는다. 
        // 족보인 경우는 족보 등수 대로 승패
        // 족보가 아닌 경우 두 카드 숫자를 더해서 끗이 높은 쪽이 승
        // 각각의 카드를 출력하고 승패 출력
        
        // 진 사람에게 패를 먼저 받도록 한다. 
        // 게임 시작 시 1000원 판 돈을 내고 시작한다. 

        // 구사 족보를 추가한다. 
        // 9 짜리 카드와 4 짜리 카드 조합 4가지 경우를 구사라고 하며 
        // 9 짜리 카드 중(10점)짜리와 4 짜리 카드 중(10점)짜리일 경우만 8땡 이하를 무효화 하고
        // 다른 구사(멍텅구리 구사)인 경우는 땡을 제외한 족보 이하만 무효화 한다. 
        // 구사로 무효화 된 판은 기존 판돈을 그대로 유지한 채 새 게임을 진행한다. 

        // 각각 초기 판돈을 가지고 시작하며 
        // 컴퓨터가 판돈을 모두 소진하면 다시 판돈만큼 채우고
        // 사용자가 판돈을 소진하면 추가로 더할거냐? 묻고 판돈을 다시 채워준다. 
        // 사용자가 그만하겠다고 하는 경우 종료된다. 
        // 종료하면 사용자와 컴퓨터의 누적 금액을 출력한다. 

        // 판돈은 배팅할 수 있으면 콜, 레이스, 다이, 올인을 선택할 수 있다.
        // 콜인 경우 컴퓨터가 더 한 금액만큼만 추가로 더 내게 된다.
        // 레이스일 경우 금액을 입력받는다. 가진 금액보다 더 입력할 수 없다.
        // 다이를 선택할 경우 컴퓨터가 이기게 된다.
        // 올인인 경우 남은 판돈을 모두 건다. 

        // 컴퓨터도 땡이하의 족보인 경우에는 랜덤 금액의 1배를 더 걸고
        // 땡일 경우는 2배를 광땡일 때는 3배를 건다. (추후 AI로 대체)
        // 단 가진 돈 내에서

        int userMoney = 1000000;        // 사용자 소지금
        int comMoney = 1000000;         // 컴퓨터 소지금
        int pot = 0;
        int round = 0;
        boolean gusa = true;
        while( true ) {            
            round ++;
            System.out.println();
            System.out.println( "[[ " + round + "판 째 경기입니다 ]]" );            

            if( gusa ) {
                pot = 10000 * 2;
                userMoney -= 10000;
                comMoney -= 10000;
            } 
            
            // 카드를 섞어서 나눈다.
            cs.dealCard();
            Rank userRank = cs.checkCard( cs.userCard );
            Rank comRank = cs.checkCard( cs.comCard );
            System.out.println( "사용자 패 : " +  userRank.getName() );
            
            // AI로 대체
            Random r = new Random();
            int betSeed = r.nextInt( 5 ) + 1;
            int comBet = 0;
            if( comRank.getNum() <= 3 ) {           // 광땡
                comBet = betSeed * ( pot / 2 ) * 3;
            } else if( comRank.getNum() <= 19 ) {   // 땡 족보
                comBet = betSeed * ( pot / 2 ) * 2;
            } else {                                // 끗
                comBet = betSeed * ( pot / 2 );
            }
            if( comBet > comMoney ) comBet = comMoney;
            System.out.println();
            System.out.println( "컴퓨터 배팅금액 : " + comBet );
            pot += comBet;
            comMoney -= comBet;

            // do ~ while
            System.out.println();
            System.out.println( "\t 1 : 콜" );
            System.out.println( "\t 2 : 레이스" );
            System.out.println( "\t 3 : 올인" );
            System.out.println( "\t 4 : 다이" );
            System.out.print( "선택 : " );            
            BufferedReader br = new BufferedReader( new InputStreamReader( System.in ) );
            int userBet = 0;
            switch( Integer.parseInt( br.readLine() ) ) {
            case 1 : pot += comBet; userMoney -= comBet; 
                     break;
            case 2 : System.out.print( "레이스 금액 : " );
                     // 사용자 베팅
                     userBet = Integer.parseInt( br.readLine() );
                     if( userBet > userMoney ) userBet = userMoney;                     
                     pot += userBet; userMoney -= userBet;              // 사용자 베팅
                     // 레이스에 대한 컴퓨터 배팅
                     if( userBet > comMoney ) userBet = comMoney;       // 컴퓨터 올인
                     pot += userBet; comMoney -= userBet;
                     break;
            case 3 : pot += userMoney; 
                     userBet = userMoney;                               // 사용자 올인
                     if( userBet > comMoney ) {
                        userBet -= comMoney;      // 컴퓨터 올인
                        pot += userBet;
                        comMoney = 0;
                     } else {
                        pot += userBet;
                        comMoney -= userBet;
                     }
                     userMoney = 0;
                     break;
            case 4 : comMoney += pot;
                     System.out.println( "사용자가 쫄렸습니다" );
                     System.out.println();
                     System.out.println( "사용자 소지금 : " + userMoney );
                     System.out.println( "컴퓨터 소지금 : " + comMoney );
                     continue;
            default : pot += comBet; userMoney -= comBet; 
                      System.out.println( "사용자가 콜했습니다" );   
            }

            System.out.println( pot );
            int result = cs.decideWinner();
            if( result == -1 ) {
                comMoney += pot;                
                gusa = true;
            } else if( result == 1 ) {
                userMoney += pot;
                gusa = true;
            } else if( result == 0 ) {
                comMoney += pot / 2;
                userMoney += pot / 2;
                gusa = true;
            } else if( result == 2 ) {
                gusa = false;
            }

            System.out.println();
            System.out.println( "사용자 소지금 : " + userMoney );
            System.out.println( "컴퓨터 소지금 : " + comMoney );

            if( userMoney == 0 ) {
                System.out.print( "더 할거냐? : " );
                String yn = br.readLine();
                if( yn.equals( "Y" ) || yn.equals( "y" ) ) {
                    userMoney = 1000000;
                    System.out.println( "니 손가락하나 내꺼" );
                } else {
                    System.out.println( "사용자가 게임을 포기했습니다" );
                    break;
                }
            }
            if( comMoney == 0 ) {
                comMoney = 1000000;
            }
           
        } 
    }
}
