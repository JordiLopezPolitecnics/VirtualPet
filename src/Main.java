public class Main {
    static void main(String[] args) {
        Pet pet = new Pet();
        Pet enemy = new Pet(100, 100, 100, 100);
        // Game Starts and asks the pet's name and type, then assigns random stats between 40 and 60
        pet.askData();
        // Main menu
        do {
            System.out.println();
            System.out.println("Choose your action!");
            System.out.println("(1) -> Sleep");
            System.out.println("(2) -> Play");
            System.out.println("(3) -> Eat");
            System.out.println("(4) -> Shower");
            System.out.println("(5) -> Attack");
            System.out.println("(6) -> Exit Application");
            int action = Teclat.llegirInt();
            switch (action) {
                case 1: {
                    pet.sleep();
                }
                break;
                case 2: {
                    pet.play();
                }
                break;
                case 3: {
                    pet.eat();
                }
                break;
                case 4: {
                    pet.shower();
                }
                break;
                case 5: {
                    pet.attack(enemy);
                }
                break;
                case 6: {
                    pet.keepLoop = false;
                }
                break;
            }
            // If action 6 is not selected, game checks the pet's stats
            if (pet.keepLoop) {
                pet.checkCriticalStats();
                pet.checkDeath();
                // Then, if the pet is not dead, game asks what to do next
                if (pet.alive){
                    pet.displayUpdatedStats();
                    System.out.println();
                    System.out.println("What will you do next?");
                }
            }
        // As long as pet is alive and Action 6 is not selected, loop will repeat
        } while (pet.alive && pet.keepLoop);
        // End of game messages
        if (!pet.keepLoop) {
            System.out.println();
            System.out.println("The application has been closed.");
            System.out.println("Goodbye!" + pet.name + " will miss you :(");
        }
        else {
            System.out.println();
            System.out.println("\uD83D\uDEAB END OF THE GAME \uD83D\uDEAB");
        }
    }
}