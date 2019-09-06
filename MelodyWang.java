import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
* @author Melody Wang
* @version 09/03/19
*/
public class MelodyWang extends Student implements SpecialInterestOrHobby, NumberOfSiblings
{

/**
 * Constructor for the MelodyWang class.
 * Constructors are special methods with the same exact name as the class name.  
 * Constructors to not have return types.
 * Constructors can be overloaded. This means we can call a constructor with different sets of parameter
 *  lists to initalize for different conditions (depending on what constructors have been written.
 * @param String f (firstname)
 * @param String l (lastname)
 * @param int r (row of seating arrangement)
 * @param int s (seat number within row seating arrangement)
 * 
 */
private String bandFile; // special image for bandClass
public MelodyWang(String f, String l, int r, int s) {
    firstName=f;
    lastName=l;
    myRow=r;
    mySeat=s;
    portraitFile=f.toLowerCase()+l.toLowerCase()+".JPG";    // Make sure to name your image files firstlast.jpg, all lowercase!!!
    standingFile=f.toLowerCase()+ l.toLowerCase()+"-standing.JPG";
    bandFile=f.toLowerCase()+l.toLowerCase()+"-band.JPG";
    soundFile=f.toLowerCase()+l.toLowerCase()+".wav";  // Make sure to name your sound files firstlast.wav, all lowercase!!!
    setImage(portraitFile);
    sitting=true;
}
/**
 * Default constructor, if you don't pass in a name and seating location
 * Pay attention to how the row and seat variables set the location of the image.  1,1 is the first cell in the upper left
 * of the classroom.
 */
public MelodyWang() {
    firstName="Melody";
    lastName="Wang";
    myRow=4;
    mySeat=4;
   // imgFile=firstName.toLowerCase()+ lastName.toLowerCase()+".jpg";
   portraitFile=firstName.toLowerCase()+ lastName.toLowerCase()+".JPG";
   standingFile=firstName.toLowerCase()+ lastName.toLowerCase()+"-standing.JPG";
   bandFile=firstName.toLowerCase()+ lastName.toLowerCase()+"-band.JPG";
   soundFile=firstName.toLowerCase()+ lastName.toLowerCase()+".wav";
   setImage(portraitFile);
   sitting=true;
}

 /**
 * When MelodyWang actor is clicked, if sitting (default setting), sets image to stand, calls myHobby() and bandClass(). Else (if not sitting), calls 
 * answerQuestion() and sitDown().
 */   
public void act() 
{
    if(Greenfoot.mouseClicked(this)){
        if (sitting){
            sitting=false;
            setImage(standingFile);
            System.out.println(""); // Print a blank line to create space between any student output.
            getName();
            sayName(soundFile);
            myHobby("I'm a part of the marching band.");
            System.out.println("I have " + numberOfSiblings() + " siblings, " + numberOfBrothers() + " brothers and " + numberOfSisters() + " sisters.");
        // Create a "special method for your class and put the call here.  You can twirl your image, resize it, move it around, change transparancy, or a 
        // combination of all of those types of actions, or more. Make sure to save the original image if you manipulate it, so that you can put it back.
        // Call the sitDown() method to move back  to your seat
        
             bandClass();  // My special method
        }
        else {
            answerQuestion();
            sitDown();
        }
                
    }
} 

/**
 * Prints the first and last name to the console
 */
public void getName(){
    System.out.println("My name is " + firstName + " " + lastName);
}
/**
 * Allows the user to interact with the student by asking questions. A second level of questioning regarding what was hard from summer homework is supported.
 */
public void answerQuestion(){
    String q=Greenfoot.ask("What would you like to know?");
    if (q.contains("hard")){
        q=Greenfoot.ask
        ("Sorts, searches, tracing iterations of loops, syntax for declaring variables (arrays, 2D arrays, lists, etc.), and deciding scope for methods. " +
        "May I sit down?");
        if (q.contains("sorts")) {
            q=Greenfoot.ask("I was confused about the differences between merge, selection, and insertion sort, and how to implement each of them. " +
            "May I sit down?");
        }
        if (q.contains("searches")) {
            q=Greenfoot.ask("I had trouble remembering the different kinds of searches and how they are used. May I sit down?");
        }
        if (q.contains("iterations") || q.contains("loops")) {
            q=Greenfoot.ask("Counting iterations and tracing what would be printed or stored in a variable was difficult. " +
            "May I sit down?");
        }
        if (q.contains("syntax")) {
            q=Greenfoot.ask("Remembering the exact syntax to declare different variables was hard. May I sit down?");
        }
        if (q.contains("scope")) {
            q=Greenfoot.ask("I was unsure about when to use private or public methods. May I sit down?");
        }
    }
    else {
      q=Greenfoot.ask("I don't understand the question... May I sit down?"); 
    }
    if (q.equals("yes")){
        Greenfoot.delay(10);
        sitDown();
    }
    else if (q.equals("no")) {
        answerQuestion();
    }
    
}
/**
 * This is a local method specific to the MelodyWang class used to animate the character once the image is clicked on.
<<<<<<< HEAD
 * 
=======
<<<<<<< Updated upstream
 * You can write your own methods to perform your own animation for your character/avatar.
=======
 * When the student is clicked, the user will be prompted to enter a number from 1-4 to determine what movement will be shown. If a number outside of this range is entered, there will 
 * be random movement instead.
>>>>>>> Stashed changes
>>>>>>> 8bfc4223f3baa383eab6a6e139b7a5c4b5f7d62a
 */
public void bandClass(){
    String [][] formation = new String [2][2];
    formation[0][0] = "Box";
    formation[0][1] = "Lines";
    formation[1][0] = "Diagonals";
    formation[1][1] = "Plus";
    int [][] randomMovement = new int [5][5];
    for (int a=0; a<5; a++) {
        for (int b=0; b<5; b++) {
            randomMovement[a][b] = (int)(Math.random()*10);
        }
    }
    setImage(bandFile);
    String q=Greenfoot.ask("What formation would you like to see? (Enter a number between 1-4)");
    //Box formation
    if (q.equals("1")) {
        setLocation(0, 0);
        System.out.println("Now showing: " + formation[0][0] + " formation");
        //move right
        for (int i=1; i<=9; i++) {
            setLocation(i, 0);
            Greenfoot.delay(10);
        }
        //move down
        for (int i=1; i<=5; i++) {
            setLocation(9, i);
            Greenfoot.delay(10);
        }
        //move left
        for (int i=9; i>=0; i--) {
            setLocation(i, 5);
            Greenfoot.delay(10);
        }
        //move up
        for (int i=5; i>=0; i--) {
            setLocation(0, i);
            Greenfoot.delay(10);
        }
    }
    //Lines formation
    else if (q.equals("2")) {
        setLocation(0, 0);
        System.out.println("Now showing: " + formation[0][1] + " formation");
        //move right
        for (int i=1;i<=9;i++){
            setLocation(i,0);
            Greenfoot.delay(10);
        }    
        //move left
        for (int i=9;i>=0;i--){
            setLocation(i,0);
            Greenfoot.delay(10);
        }
        //move down
        for (int i=1;i<=5;i++){
            setLocation(0,i);
            Greenfoot.delay(10);
        } 
        //move up
        for (int i=5;i>=0;i--){
            setLocation(0,i);
            Greenfoot.delay(10);
        }
    }
    //Diagonals formation
    else if (q.equals("3")) {
        setLocation(0, 0);
        System.out.println("Now showing: " + formation[1][0] + " formation");
        //move diagonal (right and down)
        for (int i=1; i<=5; i++) {
            setLocation(i, i);
            Greenfoot.delay(10);
        }
        //move back to (0,0)
        for (int i=5; i>=0; i--) {
            setLocation(i, i);
            Greenfoot.delay(10);
        }
        //move to the right
        for (int i=1; i<=9; i++) {
            setLocation(i, 0);
            Greenfoot.delay(10);
        }
        //move down
        for (int i=1; i<=5; i++) {
            setLocation(9, i);
            Greenfoot.delay(10);
        }
        //move diagonal (up and left)
        for (int i=9; i>=5; i--) {
            setLocation(i, i-4);
            Greenfoot.delay(10);
        }
        //move back to the corner
        for (int i=5; i<=9; i++) {
            setLocation(i, i-4);
            Greenfoot.delay(10);
        }
    }
    //Plus formation
    else if (q.equals("4")) {
        System.out.println("Now showing: " + formation[1][1] + " formation");
        setLocation(4, 3);
        //move up, then back down
        for (int i=3; i>=0; i--) {
            setLocation(4, i);
            Greenfoot.delay(10);
        }
        for (int i=0; i<=3; i++) {
            setLocation(4, i);
            Greenfoot.delay(10);
        }
        //move left, then back right
        for (int i=4; i>=0; i--) {
            setLocation(i, 3);
            Greenfoot.delay(10);
        }
        for (int i=0; i<=4; i++) {
            setLocation(i, 3);
            Greenfoot.delay(10);
        }
        //move down, then back up
        for (int i=3; i<=5; i++) {
            setLocation(4, i);
            Greenfoot.delay(10);
        }
        for (int i=5; i>=3; i--) {
            setLocation(4, i);
            Greenfoot.delay(10);
        }
        //move right, then back left
        for (int i=4; i<=9; i++) {
            setLocation(i, 3);
            Greenfoot.delay(10);
        }
        for (int i=9; i>=4; i--) {
            setLocation(i, 3);
            Greenfoot.delay(10);
        }
    }
    //Random movement (if an invalid number is entered when asking for formation number)
    else {
        System.out.println("That's not a valid formation! I don't know where I'm going.");
        for (int i=1; i<=10; i++) {
            setLocation(randomMovement[(int)(Math.random()*4)][(int)(Math.random()*4)], randomMovement[(int)(Math.random()*4)][(int)(Math.random()*4)]);
            Greenfoot.delay(10);
        }
    }
    Greenfoot.delay(10);
    setImage(standingFile);
    returnToSeat();
    }
public void myHobby(String s) {
    /**
 * Used to print a hobby to the console
 * @param String s (description of a hobby)
 */
     System.out.println(s);
}
public int numberOfSiblings() {
    return 2;
}
public int numberOfBrothers() {
    return 0;
}
public int numberOfSisters() {
    return 2;
}
}
