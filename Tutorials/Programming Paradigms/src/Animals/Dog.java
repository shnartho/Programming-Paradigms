package Animals;

// Identity - 'Unique' name identifier for an object
public class Dog {

    // State - represents the dog's hunger state
    private boolean isHungry;

    // Behavior - an object method, can also interact with other objects
    public void bark() {
        System.out.println("Bark!");
    }

    public void bark(Dog otherDog) {
        System.out.println("Barked at " + otherDog);
    }

}
