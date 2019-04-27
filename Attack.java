
public class Attack extends BattleEvent {

    
    
    public Attack(Actor target, Actor owner){
        super(target,owner);
        this.priority=0;
        this.damage=-30;
    }
           public void doEvent() {
       System.out.println(this.owner.getName()+"Attacks "+this.target.getName()+" for damage of "+this.damage+"!");
        this.target.takeDamage(this.damage);
        if(target.getHealth()==0){
            System.out.println(this.target.getName()+" Was Killed");
            BattleEngine.remove(this.target);
        }
    }



    
}
