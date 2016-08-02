/*
implementation of deck
the data in the class is the deck having an array of cards - 52 array slots
data: how many cards are in the deck
representing cards in the deck as an array of cards, could also use ArrayList<Card> myCards;

 */
package blackjack2;

import java.util.Random;        //for shuffling the deck

public class Deck {
 
  private Card[] myCards;   //deck has array of cards, the top card is the first index
                            //this is the number of array slots, it will not change
  private int numCards;     //the number of cards currently in the deck 
                            // as we deal cards the number in the deck is going to decrease, numCards tells us how many cards are left in the deck

/*this is a no arguements constructor, it defines the default behaviour if nothing is passed
 construtor with default one deck and no shuffling
  overloaded Deck method */
public Deck(){
      //call the other constructor defining one deck without shuffling
      this(1, false);
  }
  
//constructor defines number of decks and if it is shuffled
public Deck (int numDecks, boolean shuffle ){        //casinos have more than one deck when playing, numDeck is the numebr of individual decks 
                                                      //boolean shuffle is the arguement added for shuffling the deck after its been created 
    this.numCards = numDecks * 52;                  //the number of cards in my playing deck is multiplied by 52                                                  
    this.myCards = new Card[this.numCards];         //making an array called myCards, initialize it 
                                                    //creating a new array where each slot is an object type of card and there are numCards total slots 
    //initializing card index for adding a card 
    int c = 0; 
    
    //going to create the deck using nested loops
    //for each deck
    for (int d = 0; d < numDecks; d++){         //numDecks is number of decks I want to use
        
        //for each suit
        for (int s = 0; s < 4; s++){            //4 suits 
            
            //for each number 
            for (int n = 1; n <= 13; n++){      //13 possible number values
        
            //add a new card to the deck - need a card index for this 
            this.myCards[c] = new Card (Suit.values()[s], n);   //pssing the card a suit and number - n in (),using suit.value to pass the enum values and not int and index into it using [s]
            c++;                                 //adding a card to the index
      }
    }
  }                                                 

//adding shuffle 
if (shuffle){      //shuffle is a boolean
    this.shuffle();
}
}

//shuffle method to shuffle deck by randomly swapping pairs of cards
public void shuffle(){
    //initialize random numnber generator
    Random rng = new Random();
    
    //temporary card to hold swap position
    Card temp;
    
    //temporary index j
    int j;
    for (int i = 0; i < this.numCards; i++){  //while i is less than this.numCards
        
        //get a random card j to swap with i 
        j = rng.nextInt(this.numCards);   //this generates values between 0 and numCards
        
        //do the swap for every card
        temp = this.myCards[i];             //store card value of i in the temp
        this.myCards[i]= this.myCards[j];  //storing j value in i
        this.myCards[j] = temp;           //value of i updated with value of j
    }

}

//method to deal the next card from the top of the deck
//going to return the card on the top of the deck
public Card dealNextCard(){
    
//get top card 
    Card top = this.myCards[0];     //get card at position 0 and return it
    
   //need to shift the cards left by one index on the array 
    for (int c = 1; c < this.numCards; c++){
        this.myCards[c-1] = this.myCards[c];
    }
    //empty out card in the last slot
    this.myCards[this.numCards-1] = null;
    
    //decrement the number of cards in the deck 
    this.numCards--;
    return top;                     //the dealt card is returned
}
//print out the top cards of the deck
public void printDeck(int numToPrint){  //numToPrint is the number of cards from the top of the deck to print
    
    for (int c = 0; c < numToPrint; c++){ //loop through first numToPrint cards
        System.out.printf("%3d/%d %s\n", c+1, this.numCards, this.myCards[c].toString());  //printf allows me to give it a string
                                        //%3d means print an integer that has a width of 3 and add space to the left
                                        //%d means print an integer
                                        //%s means print a string
                                        //need to give args 3 values, 2 integers and a string 
                                        //c+1 is giving it card 1, card 2 etc
                                        //this.numCards is number of cards
                                        //use toString
    }
    System.out.printf("\t\t[%d other\n", this.numCards-numToPrint); //\t add tabs adnd say this is how many other cards we have
}

}
