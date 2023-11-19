    //
    // Source code recreated from a .class file by IntelliJ IDEA
    // (powered by FernFlower decompiler)
    //

    package rpg;

    public class BattleHandler {
        private Destructible enemy;
        private Player player;

        public BattleHandler(Destructible enemy) {
            this.player = GameLogic.player;
            this.enemy = enemy;
        }

        public void start() {
            while(this.player.hp > 0 && this.enemy.getLife() > 0) {
                int whoIndex = (int)(Math.random() * 2.0);
                if (whoIndex == 0) {
                    this.player.attack(this.enemy);
                } else if (whoIndex == 1) {
                    this.enemy.attackPlayer();
                }
            }

        }

        public void checkResult() {
            if (this.player.isDead()) {
                System.out.println("You are dead.. GAME OVER");
                System.exit(0);
            } else if (this.enemy.isDead()) {
                Map.enemies.remove(this.enemy);
                GameLogic.printHeading("You are the winner! You have  " + this.player.hp + "/" + this.player.maxHp + " HP");
                Player var10000 = GameLogic.player;
                var10000.honor += 100;
                GameLogic.printHeading("Your earn 100 honor!");
            }

        }
    }
