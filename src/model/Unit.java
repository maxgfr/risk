package model;

import java.util.Random;

public class Unit{
	
	private TypeUnit type;
	private int Strength;
	private int priorityAttack;
	private int priorityDefence;
	private int movementPerTour;
	private int cost;
	
	public Unit(){}
	
	public Unit(TypeUnit unitType){
		if (unitType == TypeUnit.SOLDIER){
			this.type = TypeUnit.SOLDIER;
			this.Strength = giveRandomNumber(1,6);
			this.cost = 1;
			this.priorityAttack = 2;
			this.priorityDefence = 1;
			this.movementPerTour = 2;
		}
		else if (unitType == TypeUnit.HORSE_RIDER){
			this.type = TypeUnit.HORSE_RIDER;
			this.Strength = giveRandomNumber(2,7);
			this.cost = 3;
			this.priorityAttack = 1;
			this.priorityDefence = 3;
			this.movementPerTour = 3;
			
		}
		else if (unitType == TypeUnit.CANNON){
			this.type = TypeUnit.CANNON;
			this.Strength = giveRandomNumber(4,9);
			this.cost = 7;
			this.priorityAttack = 3;
			this.priorityDefence = 2;
			this.movementPerTour = 1;
		}
	}

	public Unit(TypeUnit unitType, int Strength, int cost, int priorityAttack, int priorityDefence, int movementpertour){
		this.type = unitType;
		this.Strength = Strength;
		this.cost = cost;
		this.priorityAttack = priorityAttack;
		this.priorityDefence = priorityDefence;
		this.movementPerTour = movementpertour;
	}
        
    public int giveRandomNumber(int leftLimit, int rightLimit ) {
        Random rdm = new Random();
        return rdm.nextInt((rightLimit - leftLimit) + 1) + leftLimit;
    }
    
    @Override
    public boolean equals(Object obj) {
      if (this == obj)
        return true;
      if (obj == null)
        return false;
      if (!(obj instanceof Unit))
        return false;
      Unit other = (Unit) obj;
      if (type == null) {
        if (other.type != null)
          return false;
      } else if (!type.equals(other.type))
        return false;
      return true;
    }

	/**
	 * @return the type
	 */
	public TypeUnit getType() {
		return type;
	}

	/**
	 * @param type the type to set
	 */
	public void setType(TypeUnit type) {
		this.type = type;
	}

	/**
	 * @return the strength
	 */
	public int getStrength() {
            return Strength;
	}
        
    public int getStrengthType(TypeUnit unitType) {
        if (unitType == TypeUnit.SOLDIER){
	return giveRandomNumber(1,6);
        }
        if (unitType == TypeUnit.HORSE_RIDER){
	return giveRandomNumber(2,7);
        }
        if (unitType == TypeUnit.CANNON){
	return giveRandomNumber(4,9);
        }
        return 0;
	}

	/**
	 * @param strength the strength to set
	 */
	public void setStrength(int strength) {
		Strength = strength;
	}

	/**
	 * @return the priorityAttack
	 */
	public int getPriorityAttack() {
		return priorityAttack;
	}

	/**
	 * @param priorityAttack the priorityAttack to set
	 */
	public void setPriorityAttack(int priorityAttack) {
		this.priorityAttack = priorityAttack;
	}

	/**
	 * @return the priorityDefence
	 */
	public int getPriorityDefence() {
		return priorityDefence;
	}

	/**
	 * @param priorityDefence the priorityDefence to set
	 */
	public void setPriorityDefence(int priorityDefence) {
		this.priorityDefence = priorityDefence;
	}

	/**
	 * @return the movementPerTour
	 */
	public int getMovementPerTour() {
		return movementPerTour;
	}

	/**
	 * @param movementPerTour the movementPerTour to set
	 */
	public void setMovementPerTour(int movementPerTour) {
		this.movementPerTour = movementPerTour;
	}

	/**
	 * @return the cost
	 */
	public int getCost() {
		return cost;
	}

	/**
	 * @param cost the cost to set
	 */
	public void setCost(int cost) {
		this.cost = cost;
	}
	
        @Override
        public String toString() { 
            String toDisplay = "Type :" + this.getType().toString() + "\n";
            toDisplay += "Strength :" + this.getStrength() + "\n";
            toDisplay += "Priority Attack :" + this.getPriorityAttack() + "\n";
            toDisplay += "Priority Defence :" + this.getPriorityDefence() + "\n";
            toDisplay += "Movement Per Tour :" + this.getMovementPerTour() + "\n";
            return toDisplay;
        } 
}
