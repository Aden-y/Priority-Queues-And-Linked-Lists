
public class LongHeal extends BattleEvent{
        public LongHeal(Actor target, Actor owner){
        super(target,owner);
        this.damage=70;
        this.priority=1;
        
    }
        public void doEvent() {
        //System.out.println("["+this.target.getName()+"] Is healing with ["+this.damage+"]");
        this.target.takeDamage(this.damage);
        if(target.getHealth()==0){
            System.out.println(this.target.getName()+" Was Killed");
            BattleEngine.remove(this.target);
        }
    }

    @Override
    public String toString() {
         return "";
    }
}
