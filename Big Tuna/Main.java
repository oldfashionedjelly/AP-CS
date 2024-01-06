import java.util.Random;

class Main {
  public static void main(String[] args) {
    Fish[] fishArray = generateFish();

    changeFish(fishArray);

    for (Fish fish : fishArray) {
      System.out.println("Type: " + fish.getType() + ", Length: " + fish.getLength());
    }
  }

  public static Fish[] generateFish() {
    Random random = new Random();
    int size = random.nextInt(10) + 5; 
    Fish[] fishArray = new Fish[size];

    for (int i = 0; i < size; i++) {
      String[] fishTypes = {"Swordfish", "Carp", "Trout", "Tuna", "Salmon", "Snapper"};
      String type = fishTypes[random.nextInt(fishTypes.length)];
      double length = random.nextDouble() * 15.0 + 5; 
      fishArray[i] = new Fish(type, length);
    }

    return fishArray;
  }

  public static void changeFish(Fish[] fishArray) {
    for (Fish fish : fishArray) {
      if (fish.getLength() > 10) {
        fish.setType("Tuna");
      }
    }
  }
}