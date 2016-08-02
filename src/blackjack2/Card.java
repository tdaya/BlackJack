/*
an implementation of card type 
need suit, number, a way to construct a new instance of card class
need method to return a number of the card
need a toString method to return the name of the card 
 */

package blackjack2;


public class Card {              //a card is defined by a suit and a number
                                //private so that user cannot change/set the number 
    private Suit mySuit;       //one of the four suits
    private int myNumber;     //Ace has a value of 1, Jack - King has values 11-13

//constructor, the method called to create an instance (object) of the class card
public Card (Suit aSuit, int aNumber){   //require user to give it a suit and number

    this.mySuit = aSuit;                //initializing suit and number of the card
    
    //checking to see if user puts in a valid value/number
    if (aNumber >= 1 && aNumber <= 13) {
    this.myNumber = aNumber;              //using this to access the private data mySuit an myNumber
    }
    else{
        System.out.println("Not Valid");
        System.exit(1);         //this exits the program, tells program there was an error
    }
}

public int getNumber (){   //this method returns the number of the card
    return myNumber;       //this method is necessary b/c myNumber is private
}

/*this method prints out what is on the card by overriding the toString method
all classes in java inherit the object class and every object class has a toString method*/
public String toString(){
    
    String numStr = "Error";
    //take myNumber and hold it in numStr using a switch statement 
    
    switch(this.myNumber){
    
        case 2:              //when myNumber is 2, say numstr = 2
            numStr = "Two";
            break;
        case 3: 
            numStr = "Three";
            break; 
        case 4: 
            numStr = "Four";
            break;
        case 5: 
            numStr = "Five";
            break;
        case 6: 
            numStr = "Six";
            break;
        case 7: 
            numStr = "Seven";
            break;
        case 8: 
            numStr = "Eight";
            break;
        case 9: 
            numStr = "Nine";
            break;
        case 10: 
            numStr = "Ten";
            break;
        case 11: 
            numStr = "Jack";
            break;
        case 12: 
            numStr = "Queen";
            break;
        case 13: 
            numStr = "King";
            break;
        case 1: 
            numStr = "Ace";
            break;
    }
    return numStr + " of " + mySuit.toString();   //using toString method that is inherited from the suit  
}
}
