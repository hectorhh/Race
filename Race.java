/* Name: Hector Herrera
 * Pennkey: Hectorh
 * Recitation: 216
 * 
 * Execution: Java Race
 * 
 * Penn and Princeton will race
 * 
 */
public class Race {    
    public static void main(String[] args) {
        boolean pennWins = false;       // has Penn won the race?
        boolean princetonWins = false;  // has Princeton won the race?

        // the width of 1 pixel in window coordinates,
        // assuming you do NOT call PennDraw.setXscale()
        double ONE_PIXEL = 1.0 / 512;   

        //Penn's starting position
        double x1 = .3;
        double y1 = .9;
        
        //Princeton's starting position
        double x2 = .7;
        double y2 = .9;

        PennDraw.enableAnimation(40);

        while (!pennWins && !princetonWins) {
            PennDraw.clear();
            PennDraw.line(0, .8, 1, .8); //start line
            PennDraw.line(0, .2, 1, .2); //finish line
            
            //Penn's pennant movement
            PennDraw.picture(x1, y1, "penn.png");
            if (Math.random() <= .51) { 
                y1 = y1 - ONE_PIXEL;
            }
            
            //Princeton's pennant movement
            PennDraw.picture(x2, y2, "princeton.png");
            if (Math.random() <= .49) {
                y2 = y2 - ONE_PIXEL;
            }
            
            //Ends the pennant race
            if (y1 <= .2 || y2 <= .2) {
                pennWins = true;
                princetonWins = true;
            }

            PennDraw.advance(); // show this frame and go on to the next one
        }

        PennDraw.disableAnimation(); // the race is over so turn off animation
        

        //The text will display who has won the race
        if (y1 <= .2) {
            PennDraw.text(.5, .5, "PENN WINS!");
        } else if (y2 <= .2) {
            PennDraw.text(.5, .5, "PRINCETON WINS!");
        }
    }
}