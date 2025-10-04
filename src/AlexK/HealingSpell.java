package AlexK;



/**
 * Healing spells increase the targets health or mana
 */
public class HealingSpell extends Spell {
	/**
	 * Defines, if HP or MP is affected
	 * <p>
	 * type == true: affects HP
	 * <p>
	 * type == false: affects MP
	 */
	private final boolean type;
	/**
	 * Defines, if amount is interpreted as an absolute value or as a percentage.
	 * <p>
	 * percentage == true: deduct value to subtract as 'amount' percentage of basic value
	 * <p>
	 * percentage == false: subtract amount directly 
	 */
	private final boolean percentage;
	/**
	 * Has to be non-negative; if percentage==true, amount must be in the interval [0,100]
	 */
	private final int amount;

	/**
	 * @param name name
	 * @param manaCost manaCost
	 * @param levelNeeded levelNeeded
	 * @param type defines if health or mana is affected
	 * @param percentage defines if amount is an absolute or a percentage value
	 * @param amount amount
	 */
	public HealingSpell(String name, int manaCost, MagicLevel levelNeeded, boolean type, boolean percentage, int amount) {
		super(name, manaCost, levelNeeded);
		if (amount < 0) throw new IllegalArgumentException("Amount must be non-negative");
		if (percentage &&  amount > 100) throw new IllegalArgumentException("Percentage must be between 0 and 100");
		this.type = type;
		this.percentage = percentage;
		this.amount = amount;
	}
	
	/**
	 * Use one of the functions heal, healPercent, enforceMagic or enforceMagicPercent according
	 * to the flags type and percentage
	 * @param target target that receives healing
	 */
	@Override	
	public void doEffect(MagicEffectRealization target) {
		if (target == null) {
            throw new IllegalArgumentException("Null target was provided");
        }
        if (type && percentage) {
            target.healPercent(amount);
        }else if (type && !percentage) {
            target.heal(amount);
        }else if (!type && percentage) {
            target.enforceMagicPercent(amount);
        }else {
            target.enforceMagic(amount);
        }
		
	}

	/**
	 * Returns "; +'amount' 'percentage' 'HPorMP'", where 'percentage' is a '%'-sign if percentage
	 * is true, empty otherwise and HPorMP is HP if type is true, MP otherwise
	 * e.g. "; +10 HP" or "; +50 % MP"
	 * @return "; +'amount' 'percentage' 'HPorMP'"
	 */
	@Override
	public String additionalOutputString() {
		return "; +" + amount + (percentage ? " % ": " ") + (type ? "HP": "MP");
	}
}