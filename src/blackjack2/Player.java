/*
the player class represents the user and the dealer 
the player has a hand of cards and the number of cards in their hand 
 */
package blackjack2;


public class Player {
    
    private final String name;    //the players name
    
    private final Card [] hand = new Card[10];   //the player's hand is an array, they can have up to 10 cards
    
    private int numCards;           //the number of cards in the players current hand
    
    //constructor
    public Player (String aName){   //aName the name of the player 
        this.name = aName;
        
        //initialize an empty hand for the player 
        this.emptyHand();   //set a players hand to empty 
    }
    
    //this method is to reset the player's hand to empty for every new game 
    private void emptyHand(){
        for (int c = 0; c < 10; c++){
            this.hand[c] = null;    //setting elements in the hand to null
        }
        this.numCards = 0;      //setting the number of cards to 0, default value is also 0
    }
 
    /*this method is to add a card/ deal to the player's hand 
    the return value is going to be a boolean describing whether the sum of the new hand 
    is below or equal to 21 if boolean returns false then player has busted*/
    public boolean addCard(Card aCard){    //aCard is the card to add
        
    //print error if there is the max cards in the hand - 10 
       if (this.numCards == 10){
        System.err.printf("%s cannot add card \n" , this.name);    //print error %s = string
        System.exit(1);         //program will exit
    }
      
    //add a new card in next slot and increment number of cards counter
        this.hand[this.numCards] = aCard;   //this.hand = new card
        this.numCards++;            //increment numCard
      
        return (this.getHandSum() <= 21); //return getHandSum, check to see if it is less than or equal to 21
    }
    
    //this method is to get the sum of the cards in the player's hand and retun the sum
    public int getHandSum (){
        //recall facecards take the value 10 and Ace takes the value 1 or 11
        
        int handSum = 0;
        int cardNum;
        int numAces = 0;
        
        //calculate each card's contribution to the hand sum
        for (int c = 0; c < this.numCards; c++){
            
            //get the number for the current card, using getNumber method from card class
            cardNum = this.hand[c].getNumber();
            
            if (cardNum == 1){   //if card number is 1, Ace
                numAces++;       //increment number of Aces
                handSum += 11;   //add 11
         } else if (cardNum > 10){     //this means there is a face card
                 handSum += 10;
         } else {                   //if the card is 2-9
             handSum += cardNum;
         }
      }
        /*make a loop that says while we have we have Aces and handSum is above 21, then subract 10 
        converts 11 into 1 for each ace as necessary */
        
        while (handSum > 21 && numAces > 0) { //while handSum is greater than 21, and the number of Aces is greater than 0
            handSum -=10;                     //subtract 10 from handSum
            numAces--;                      //decrement numAces, loop exits when there are no more aces 
        }
        return handSum;
    }
    
    //this method is to print out the cards in the player's hand 
    public void printHand(boolean showFirstCard){        //showFirstCard is to determine whether the first card is hidden or not 
        System.out.printf("%s's cards:\n" , this.name);  
        for (int c = 0; c < this.numCards; c++){
            if (c==0 && !showFirstCard){              //if we're on the first card c==0 and we dont want to show the first card
                System.out.println("[hidden]");      //print hidden
            } else {                                //else print the card
                System.out.printf("%s\n" , this.hand[c].toString());         
            }
        }
    }
}

