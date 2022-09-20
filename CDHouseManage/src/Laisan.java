
import java.util.Scanner;

public class Laisan {

    public static void main(String[] args) {
        Scanner scc = new Scanner(System.in);
        String watchTower , suboss , caesar ;
        Fanssion fans = new Fanssion();

        do {
            System.out.println("1 .add CD to catalog\n"
                              +"2 .search CD by title\n"
                              +"3 .display catalog\n"
                              +"4 .update CD by ID\n"
                              +"5 .save to file\n"
                              +"6 .print list CD from file");
            watchTower = scc.nextLine();
            switch (watchTower) {
                case "1":
                    fans.addCD();
                    System.out.println("put y to do again, other to return menu.");
                    suboss = scc.nextLine();
                    if (suboss.matches("y")) {
                        fans.addCD();
                    }
                    break;
                case "2":
                    fans.searchByTitle();
                    System.out.println("put y to do again, other to return menu.");
                    suboss = scc.nextLine();
                    if (suboss.matches("y")) {
                        fans.searchByTitle();
                    }
                    break;
                case "3":
                    fans.printCatalog();
                    break;
                case "4":
                    System.out.println("1 .to update CD by ID\n" + "2 .to delete CD by ID");
                    suboss = scc.nextLine();
                    switch (suboss) {
                        case "1":
                            fans.updateCD();
                            System.out.println("put y to do again, other to return menu.");
                            caesar = scc.nextLine();
                            if (caesar.matches("y")) {
                                fans.updateCD();
                            }
                            break;
                        case "2":
                            fans.deleteCD();
                            System.out.println("put y to do again, other to return menu.");
                            caesar = scc.nextLine();
                            if (caesar.matches("y")) fans.deleteCD();
                            break;
                        default: break;
                    }
                    break;
                case "5":
                    fans.saveFile();
                    break;
                case "6":
                    fans.listReadFile();
                    break;
                default:
                    break;
            }
        } while (watchTower.matches("[1-6]"));
    }
}
