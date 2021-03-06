package dungeon;
import java.util.Scanner;

public class TyLenol extends Hero
{
	private final int MIN_ADD = 25;
	private final int MAX_ADD = 50;

    public TyLenol()
	{
		super("Ty Lenol", 90, 4, .7, 20, 45, .3);
    }//end constructor


    public void battleChoices(DungeonCharacter opponent)
	{
    	Scanner sc = new Scanner(System.in);
		super.battleChoices(opponent);
		int choice;

		do
		{
		    System.out.println("1. Attack Opponent"
		    		+ "\n2. Snort Tylenol");
		    System.out.print("Choose an option: ");
		    
		    try
		    {
		    	choice = sc.nextInt();
		    }
		    catch(Exception e)
		    {
		    	choice = 1;
		    	System.out.println("Invalid choice; performing regular attack!");
		    }

		    switch (choice)
		    {
			    case 1: setAttack(new HeroAttack(opponent, this));
			    		getAttack().useAttack();
			        break;
			    case 2:
			    	setAttack(new IncreaseHP(MAX_ADD, MIN_ADD, this));
			    	getAttack().useAttack();
			        break;
			    default:
			        System.out.println("invalid choice!");
		    }//end switch

		    setNumTurns(getNumTurns()-1);
			if (getNumTurns() > 0)
			    System.out.println("Number of turns remaining is: " + getNumTurns());

		} while(getNumTurns() > 0 && getHitPoints() > 0 && opponent.getHitPoints() > 0);

    }//end overridden method

}//end class