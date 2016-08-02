/*

 */
package blackjack2;

import java.util.Scanner;

public class BlackJack2 {

    public static void main(String[] args) {
        
        //initialize scanner and deck
        Scanner sc = new Scanner(System.in);
        Deck theDeck = new Deck (1, true);
        
        //initialize the player object
        Player me = new Player("Player");
        Player dealer = new Player ("Dealer");
        
        me.addCard(theDeck.dealNextCard());        //add card to my hand from the deck
        dealer.addCard(theDeck.dealNextCard());    //deal a card to the dealer
        me.addCard(theDeck.dealNextCard());       //twice to deal 2 cards to me and 2 cards to dealer
        dealer.addCard(theDeck.dealNextCard());
   
    //print initial hands
        System.out.println("Cards are dealt\n");
        me.printHand(true);    //show first card of my hand
        System.out.println("\n");
        dealer.printHand(false); //does not show dealer's card
        System.out.println("\n");
        
    //create variables that describe when me player and dealer are finished hitting
    boolean meDone = false;
    boolean dealerDone = false; 
    String ans;
    
    //prompt the user or dealer if they want to hit 
    while (!meDone || !dealerDone){    //while meDone is false or dealer is not done 
       
        //player's turn
        if(!meDone){         //if meDone is not true 
            System.out.println("Hit or Stay? (Enter H or S):");
            ans = sc.next();
            System.out.println();
            
        //if the player hits, use string.compareto 
        if(ans.compareToIgnoreCase("H")==0){
            
            //if the player asks to hit, add the next card in the deck and store if player busts or not
            meDone = !me.addCard(theDeck.dealNextCard());   //this addCard method returns a boolean value of true when total of hand is less than or equal to 21
            //done if the player is busted
            me.printHand(true);  //print hand of player
            
        } else {        //if player wants to stay, also done
            meDone = true;
        }
        } 
        //dealer's turn 
        if (!dealerDone){
            if(dealer.getHandSum() < 17){       //if dealer's value is less than 17, hit
                System.out.println("\nThe dealer hits\n");
                dealerDone = !dealer.addCard(theDeck.dealNextCard());
                dealer.printHand(false);  //print hand of dealer
            }else{
                System.out.println("\nThe dealer stays \n");
                dealerDone = true;
            }
      }
            System.out.println("");
     /* up to this point the loop keeps prompting the player and dealer untill the conditions 
     in the while meDone and dealerDone are true, so that the expressions become false and the 
     oop exits*/
    }
            
   //when the loop exits, close scanner
   sc.close();
   
   //print final hands
   me.printHand(true);
        System.out.println("\n");
   dealer.printHand(true);
   
   //get the sum of both of the hands 
   int mySum = me.getHandSum();
   int dealerSum = dealer.getHandSum();
   
   //win the game if my sm if greater than the dealer sun and less than or equal to 21 or dealer busted
   if (mySum > dealerSum && mySum <= 21 || dealerSum > 21){
       System.out.println("\nYou win!");
   }else{
       System.out.println("\nDealer wins!");
   }
  }  
}


/* Deck myDeck = new Deck (1, true );        //1 represent the number of decks, boolean true is shuffled, false is not shuffled
myDeck.printDeck(2);*/