class Main {
  public static void main(String[] args) {
    String input = "the quick brown fox jumped over the lazy dog or over Veer";
    int[] letterCount = new int[26]; 

    for (char ch : input.toLowerCase().toCharArray()) {
        if (ch >= 'a' && ch <= 'z') {
            int index = ch - 'a';
            letterCount[index]++;
        }
    }

    for (char ch = 'a'; ch <= 'z'; ch++) {
        int index = ch - 'a';
        System.out.println(ch + ": " + letterCount[index]);
    }

  }
}
