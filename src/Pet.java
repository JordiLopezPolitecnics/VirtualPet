public class Pet {
    // Pet's stats
    String name;
    String enemyName;
    String type;
    int energy;
    int hygiene;
    int weight;
    int mood;

    // Variables that make the loop work
    int action;
    char repeatAttack;
    boolean alive = true;
    boolean keepLoop = true;

    // Empty constructor for the user's pet
    public Pet() {
    }

    // Constructor for the enemy
    public Pet(int energy, int hygiene, int weight, int mood) {
        this.energy = energy;
        this.hygiene = hygiene;
        this.weight = weight;
        this.mood = mood;
    }

    // Asking the pet's type and name at the beginning of the game before the loop starts
    public void askData() {
        System.out.println("Will your pet be a dog or a cat?");
        type = Teclat.llegirString();
        System.out.println("What's the name of your pet?");
        name = Teclat.llegirString();
        System.out.println("And what's the name of your nemesis?");
        enemyName = Teclat.llegirString();
        System.out.println("Congratulations, you just adopted a new " + this.type + " called " + this.name + "!");
        System.out.println();
        energy = (int)(Math.random()*21)+40;
        hygiene = (int)(Math.random()*21)+40;
        weight = (int)(Math.random()*21)+40;
        mood = (int)(Math.random()*21)+40;
        System.out.println(this.name + " starts with these stats:");
        System.out.println("\uD83D\uDD0B Energy -> " + this.energy);
        System.out.println("\uD83E\uDDF9 Hygiene -> " + this.hygiene);
        System.out.println("⚖\uFE0F Weight -> " + this.weight);
        System.out.println("\uD83D\uDCAD Mood -> " + this.mood);
        System.out.println();
        System.out.println("Take care of " + this.name + "!");
    }

    // Sleep action
    public void sleep(){
        System.out.println(this.name + " lays down and takes a big nap...");
        if (type == "dog"){
            this.energy = this.energy+25;
        }
        else {
            this.energy = this.energy+20;
        }
        this.mood = this.mood+10;
        System.out.println();
        System.out.println("... ... ...");
        System.out.println("zzz zzz zzz...");
        System.out.println("... ... ...");
        System.out.println();
        System.out.println(this.name + " has slept for a few hours!");
    }
    // Play action
    public void play(){
        System.out.println("You pick up " + this.name + "'s favorite toy and play with it!");
        this.energy = this.energy-20;
        this.mood = this.mood+20;
        if (type == "dog") {
            System.out.println();
            System.out.println("... ... ...");
            System.out.println("woof woof!");
            System.out.println("... ... ...");
            System.out.println();
        }
        else {
            System.out.println();
            System.out.println("... ... ...");
            System.out.println("meow meow!");
            System.out.println("... ... ...");
            System.out.println();
        }
        System.out.println(this.name + " had such a good time with you!");
    }
    // Eat action
    public void eat(){
        System.out.println("You prepare " + this.name + "'s meal as it rubs against you in excitement...");
        this.energy = this.energy+10;
        this.hygiene = this.hygiene-15;
        this.weight = this.weight+10;
        System.out.println();
        System.out.println("... ... ...");
        System.out.println();
        System.out.println(this.name + "'s belly is full and sated!");
    }
    // Shower action
    public void shower(){
        System.out.println("You put " + this.name + " into the shower as it looks at you suspiciously...");
        if (type == "dog"){
            this.energy = this.energy-10;
            this.mood = this.mood-15;
        }
        else{
            this.energy = this.energy-5;
            this.mood = this.mood+5;
        }
        this.hygiene = this.hygiene+25;
        System.out.println();
        System.out.println("... ... ...");
        System.out.println();
        System.out.println(this.name + " looks clean and smells amazing!");
    }
    // Attack action
    public void attack(Pet opponent) {
        do{
            System.out.println("How many times do you want " + this.name + " to attack " + enemyName + "?");
            int attackTimes;
            int counter;
            attackTimes = Teclat.llegirInt();
            System.out.println("You command " + this.name + " to attack " + enemyName + " " + attackTimes + " times!");
            for (counter = 0; counter < attackTimes && this.alive && opponent.alive; counter++) {
                this.energy = this.energy-3;
                this.hygiene = this.hygiene-3;
                this.mood = this.mood-3;
                opponent.energy = opponent.energy-5;
                System.out.println();
                System.out.println("... !!! ... !!! ...");
                System.out.println();
                System.out.println(this.name + " feels worse after attacking...");
                this.checkCriticalStats();
                System.out.println();
                System.out.println("But " + enemyName + "'s energy is now at (" + opponent.energy + ")");
                System.out.println();
                this.checkDeath();
                opponent.checkDeath();
                if (!opponent.alive) {
                    System.out.println();
                    System.out.println("Hey, you killed " + enemyName + " !");
                    System.out.println("A new " + enemyName + " will be generated via careful and extremely advanced biogenetics science and techniques!");
                }
            }
            if (this.alive && opponent.alive) {
                System.out.println("Attack " + enemyName + " again?");
                System.out.println("(Y) or (N)");
                repeatAttack = Teclat.llegirChar();
            }
        } while ((repeatAttack == 'y' || repeatAttack == 'Y') && (this.alive) && opponent.alive);
    }
    // Check if any of the stats are dangerously low and telling the player
    public void checkCriticalStats(){
        if (this.energy < 15){
            System.out.println();
            System.out.println("--- " + this.name + " is almost out of energy... ---");
        }
        else if (this.energy < 35){
            System.out.println();
            System.out.println("--- " + this.name + " feels tired... ---");
        }
        if (this.hygiene < 15){
            System.out.println();
            System.out.println("--- " + this.name + " looks and smells horrible... ---");
        }
        else if (this.hygiene < 35){
            System.out.println();
            System.out.println("--- " + this.name + " is kinda dirty... ---");
        }
        if (this.weight < 15){
            System.out.println();
            System.out.println("--- " + this.name + " looks obese and can barely walk... ---");
        }
        else if (this.weight < 35){
            System.out.println();
            System.out.println("--- " + this.name + " has gained some weight... ---");
        }
        if (this.mood < 15){
            System.out.println();
            System.out.println("--- " + this.name + " is depressed and needs help... ---");
        }
        else if (this.mood < 35){
            System.out.println();
            System.out.println("--- " + this.name + " looks sad... ---");
        }
    }
    // Check if any of the stats are too low or too high for the pet to stay alive
    public void checkDeath(){
        if (energy <= 0 || energy >100){
            alive = false;
            if ( energy <= 0) {
                System.out.println();
                System.out.println("Oh, no! " + this.name + " died because it lost all energy!");
            }
            else {
                System.out.println();
                System.out.println("Oh, no! " + this.name + " died because it has en excess of energy!");
            }
        }
        else if (hygiene <= 0 || hygiene >100){
            alive = false;
            if ( hygiene <= 0) {
                System.out.println();
                System.out.println("Oh, no! " + this.name + " died because it was absurdly dirty and choked on filth!");
            }
            else {
                System.out.println();
                System.out.println("Oh, no! " + this.name + " died because it was extremely clean!");
            }
        }
        else if (weight <= 0 || weight >100){
            alive = false;
            if ( weight <= 0) {
                System.out.println();
                System.out.println("Oh, no! " + this.name + " died because it lost too much weight!");
            }
            else {
                System.out.println();
                System.out.println("Oh, no! " + this.name + " died because it was too fat and couldn't breathe!");
            }
        }
        else if (mood <= 0 || mood >100){
            alive = false;
            if ( mood <= 0) {
                System.out.println();
                System.out.println("Oh, no! " + this.name + " died because it was too depressed and decided to stop living!");
            }
            else {
                System.out.println();
                System.out.println("Oh, no! " + this.name + " died because it was too excited and had a heart attack!");
            }
        }
    }
    // Display the stats after they change
    public void displayUpdatedStats(){
        System.out.println();
        System.out.println(this.name + "'s stats are now these:");
        System.out.println("\uD83D\uDD0B " + this.energy + " | \uD83E\uDDF9 " + this.hygiene + " | ⚖\uFE0F " + this.weight + " | \uD83D\uDCAD " + this.mood);
    }
}