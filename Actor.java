public class Actor {
    private String name;
    private int health;
    final int STARTINGHEALTH=100;
    public Actor(String nm){
        this.name=nm;
        this.health=STARTINGHEALTH;
    }
    public String getName(){
        return this.name;
    }
    public int getHealth(){
        return this.health;
    }
    public void takeDamage(int adjust){
        if(adjust+this.health>STARTINGHEALTH){
            this.health=STARTINGHEALTH;
            
        }else if(this.health+adjust<=0){
            this.health=0;
        }else{
            this.health+=adjust;
        }
        
    }
    public boolean isDead(){
        if(this.health==0){
            return true;
        }else{
            return false;
        }
    }
}
