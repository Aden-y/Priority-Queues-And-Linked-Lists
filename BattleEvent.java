
public abstract class BattleEvent {
    protected Actor owner,target;
    protected int damage, priority;
    public BattleEvent(Actor target, Actor owner){
        this.target=target;
        this.owner=owner;
    }
    
   
    public Actor getTarget(){
        return this.target;
    }
    public Actor getOwner(){
        return this.owner;
    }
    public int getPriority(){
        return this.priority;
    }
        public void doEvent() {
        System.out.println(this.owner+"Attacks "+this.target+" for damage of "+this.damage+"!");
        this.target.takeDamage(this.damage);
        if(target.getHealth()==0){
            System.out.println(this.target.getName()+" is Defeated!");
            BattleEngine.remove(this.target);
        }
    }
        public String toString(){
            return "Target "+this.target.getName()+" Damage: "+this.damage+" Priority: "+this.priority;
            
        }
    
}
