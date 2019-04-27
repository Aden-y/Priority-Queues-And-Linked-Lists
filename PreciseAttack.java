
public class PreciseAttack extends BattleEvent{
    public PreciseAttack(Actor target, Actor owner){
        super(target,owner);
        this.damage=-70;
        this.priority=1;
        
    }
    @Override
        public void doEvent() {
        System.out.println(this.owner.getName()+"Attacks "+this.target.getName()+" for damage of "+this.damage+"!");
        this.target.takeDamage(this.damage);
        if(target.isDead()){
            System.out.println(this.target.getName()+" is Defeated");
            BattleEngine.remove(this.target);
        }
    }


    
}
