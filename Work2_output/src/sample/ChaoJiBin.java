package sample;

public class ChaoJiBin extends XiaoBin{

    int rate = 50;//拥有百分之50的暴击几率
    public boolean situation;

    public ChaoJiBin(String name ,int health, int damage, int defence) {
        super(name ,health, damage*2, defence); //超级兵拥有更高的伤害
        situation = true;
    }

    public int getRate(){return  this.rate;}
}
