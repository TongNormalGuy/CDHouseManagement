
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Fanssion { 

    private String nameCD;
    private String typeCD;
    private String titleCD;
    private float priceCD;
    private String idCD;
    private int publicYear;

    ArrayList<CD> listCD = new ArrayList<>(700); // i don exactly remember how to limit the number of arrays

    Scanner sc = new Scanner(System.in);
    boolean flak = true; // flag
    int numOfCD; // number of CD, but you may see i use .size() to get the number of CD
    int checkCDT; // CD type
    int checkFileAdd; // counting when an object is added to the list

    public void addCD() {
        if (listCD.size() > 700) {
            System.out.println("full storage.");
        } else {
            do { // CD name here 
                //check empty, blank
                System.out.println("please put CD name: ");
                nameCD = sc.nextLine();
                if (nameCD.isEmpty()) {
                    System.out.println("please do not let it empty.");
                }
                // check duplicate
                for (int i = 0; i < listCD.size(); i++) {
                    if (listCD.get(i).getNameCD().matches(nameCD)) {
                        System.out.println("the CD name has exited.");
                        nameCD = "";
                    }
                }
            } while (nameCD.isEmpty());

            do { // CD type here
                checkCDT = 0;
                System.out.println("please put CD type(game, movie, music): ");
                typeCD = sc.nextLine();
                switch (typeCD) {
                    case "game":
                        checkCDT++;
                        break;
                    case "movie":
                        checkCDT++;
                        break;
                    case "music":
                        checkCDT++;
                        break;
                    default:
                        System.out.println("please put in right format.");
                        break;
                }
            } while (checkCDT == 0);

            do { // CD price here
                try {
                    System.out.println("please put CD price here: ");
                    priceCD = Float.parseFloat(sc.nextLine()); // check is number
                    flak = false;
                    //check the price input is follow 0 to 10.000 and it is real number 
                    if (priceCD < 0) {
                        System.out.println("please put REAL NUMBER greater 0.");
                        flak = true;
                    }
                } catch (Exception e) {
                    System.out.println("please put number.");
                    flak = true;
                }
            } while (flak == true);

            do { // CD ID here
                System.out.println("(format Pxxxx when x is digit and do not let it empty)\n"
                        + "please put CD ID :"
                );
                idCD = sc.nextLine();
                //product ID format
                if (idCD.isEmpty()) {
                    System.out.println("please do not let it empty.");
                } else if (!idCD.matches("P\\d{4}")) {
                    System.out.println("Wrong format");
                    idCD = "";
                }
                //check space in string ID
                for (int i = 0; i < idCD.length(); i++) {
                    if (idCD.charAt(i) == ' ') {
                        idCD = "";
                    }
                }
                // check duplicate
                for (int i = 0; i < listCD.size(); i++) {
                    if (listCD.get(i).getIdCD().matches(idCD)) {
                        System.out.println("the CD ID has exited.");
                        idCD = "";
                    }
                }
            } while (idCD.isEmpty());

            do { // publishing year here
                try {
                    System.out.println("(please put the year greater 1980)"
                            + "\nplease put publishing year here: ");
                    publicYear = Integer.parseInt(sc.nextLine());
                    flak = false;
                    //check publishing year, why 1980? check when CD were published
                    if (publicYear < 1980) flak = true;
                } catch (Exception e) {
                    System.out.println("please put number.");
                    flak = true;
                }
            } while (flak);

            do { // CD title here
                //check empty, blank
                System.out.println("please put CD title: ");
                titleCD = sc.nextLine();
                if (titleCD.isEmpty()) {
                    System.out.println("please do not let it empty.");
                    titleCD = "";
                }
                // check duplicate
                for (int i = 0; i < listCD.size(); i++) {
                    if (listCD.get(i).getTitleCD().matches(titleCD)) {
                        System.out.println("the CD title has exited.");
                        titleCD = "";
                    }
                }
            } while (titleCD.isEmpty());

            /// add product to product list
            CD obj = new CD(nameCD, typeCD, titleCD, priceCD, idCD, publicYear);
            listCD.add(obj);
            numOfCD++;
            System.out.println("add done." + "\n--------------------");
        }
    }

    public void searchByTitle() {
        if (listCD.isEmpty()) {
            System.out.println("mistake occur.");
        } else {
            System.out.println("search CD title: ");
            titleCD = sc.nextLine();
            flak = true;
            for (int i = 0; i < listCD.size(); i++) {
                //if user enter a part of name 
                if (listCD.get(i).getTitleCD().contains(titleCD)) {
                    System.out.println("CD title = " + titleCD
                            + " - CD result is shown as: "
                            + listCD.get(i)
                            + "\n--------------------");
                    flak = false;
                }
            }
        }
        if (flak) {
            System.out.println("not found or nothing.");
        }
    }

    public void printCatalog() {
        readFile();
        if (listCD.isEmpty()) {
            System.out.println("number of CD here: " + listCD.size());
        } else {
            System.out.println("number of CD here: " + listCD.size());
            System.out.println("(name, type, title, price, ID, publishing year)");
            for (int i = 0; i < listCD.size(); i++) {
                System.out.println(listCD.get(i));
            }
        }
    }

    public void updateCD() { // in update method, user put blank will not change value
        if (listCD.isEmpty()) {
            System.out.println("mistake occur.");
        } else {
            System.out.println("put CD ID to update: ");
            idCD = sc.nextLine();
            for (int i = 0; i < listCD.size(); i++) {
                if (!idCD.matches(listCD.get(i).getIdCD())) {
                    System.out.println("not found");
                } else {
                    do { // CD name here 
                        //check empty, blank
                        System.out.println("please put CD name: ");
                        nameCD = sc.nextLine();
                        if (nameCD.isEmpty()) {
                            System.out.println("name not change.");
                            this.nameCD = listCD.get(i).getNameCD();
                            flak = false;
                        }
                        // check duplicate
                        for (int j = 0; j < listCD.size(); j++) {
                            if (listCD.get(j).getNameCD().matches(nameCD)) {
                                System.out.println("the CD name has exited.");
                                flak = true;
                            }
                        }
                    } while (flak == true);

                    do { // CD type here
                        checkCDT = 0;
                        System.out.println("please put CD type(game, movie, music): ");
                        typeCD = sc.nextLine();
                        switch (typeCD) {
                            case "game":
                                checkCDT++;
                                break;
                            case "movie":
                                checkCDT++;
                                break;
                            case "music":
                                checkCDT++;
                                break;
                            case "":
                                System.out.println("name not change");
                                this.typeCD = listCD.get(i).getTypeCD();
                                checkCDT++;
                                break;
                            default:
                                System.out.println("please put in right format.");
                                break;
                        }
                    } while (checkCDT == 0);

                    do { // CD price here
                        try {
                            System.out.println("please put CD price here: ");
                            String tmpp = null;
                            tmpp = sc.nextLine(); //check tmpp is number or blank
                            if (tmpp.isEmpty()) { // if tmp is blank, price value not change
                                System.out.println("CD price not change.");
                                break;
                            } else {
                                priceCD = Float.parseFloat(tmpp); // check is number
                                flak = false;
                                //check the price input is greater 0
                                if (priceCD < 0) {
                                    System.out.println("please put REAL NUMBER greater 0.");
                                    flak = true;
                                }
                            }
                        } catch (Exception e) {
                            System.out.println("please put number.");
                            flak = true;
                        }
                    } while (flak == true);

                    do { // publishing year here
                        try {
                            System.out.println("(please put the year greater 1980)"
                                    + "\nplease put publishing year here: ");
                            String tmp = null;
                            tmp = sc.nextLine();
                            if (tmp.isEmpty()) {
                                System.out.println("publishing year not change.");
                                break;
                            } else {
                                publicYear = Integer.parseInt(tmp);
                                flak = false;
                                //check publishing year
                                if (publicYear < 1980) flak = true;
                            }
                        } catch (Exception e) {
                            System.out.println("please put number.");
                            flak = true;
                        }
                    } while (flak);

                    do { // CD title here
                        //check empty, blank
                        System.out.println("please put CD title: ");
                        titleCD = sc.nextLine();
                        if (titleCD.isEmpty()) {
                            System.out.println("title not change.");
                            this.titleCD = listCD.get(i).getTitleCD();
                        }
                        // check duplicate
                        for (int j = 0; j < listCD.size(); j++) {
                            if (listCD.get(j).getTitleCD().matches(titleCD)) {
                                System.out.println("the CD title has exited.");
                                titleCD = "";
                            }
                        }
                    } while (titleCD.isEmpty());

                    // update cd info
                    CD obj = new CD(nameCD, typeCD, titleCD, priceCD, idCD, publicYear);
                    listCD.set(i, obj);
                    System.out.println("done.\n--------------------");
                }
            }
        }
    }

    public void deleteCD() {
        if (listCD.isEmpty()) {
            System.out.println("mistake occur.");
        } else {
            System.out.println("put CD ID to remove: ");
            idCD = sc.nextLine();
            for (int i = 0; i < listCD.size(); i++) {
                if (!listCD.get(i).getIdCD().matches(idCD)) {
                    listCD.remove(i);
                    System.out.println("remove done.");
                    numOfCD--;
                    flak = false;
                }
            }
            if (flak) {
                System.out.println("not found or mistake.");
            }
        }
    }

    public void saveFile() {
        if (checkFileAdd == 0 || numOfCD == 0) {
            readFile();
        }
        try {
            if (listCD.isEmpty()) {
                System.out.println("nothing to save.");
                throw new IOException();
            }
            FileWriter fw = new FileWriter("CDStorage.dat");
            PrintWriter pw = new PrintWriter(fw); // cach khac
            for (int i = 0; i < listCD.size(); i++) {
                pw.println(listCD.get(i).toString());
            }
            pw.close();
            System.out.println("save success.");
        } catch (IOException ex) {
            System.out.println("save fail.");
            System.out.println("\n--------------------");
        }
    }

    public void readFile() {
        if (listCD.size() > 700) {
            System.out.println("full list to read more.");
        } else {
            try {
                File file = new File("CDStorage.dat");
                Scanner scn = new Scanner(file);
//                FileReader fr = new FileReader("CDStorage.txt"); //buffered reader , other way to read file
//                BufferedReader br = new BufferedReader(fr);
                String line = null;
                while (scn.hasNextLine()) {
                    line = scn.nextLine();
//                    line = br.readLine(); //buffered reader
                    if (line == null) {
                        break;
                    }
                    String[] text = line.split(",");
                    if (text.length != 6) {
                        throw new IOException();
                    } else {
                        nameCD = text[0];
                        typeCD = text[1];
                        titleCD = text[2];
                        priceCD = Float.parseFloat(text[3]);
                        idCD = text[4];
                        publicYear = Integer.parseInt(text[5]);
                        flak = true;
                    }
                    for (int i = 0; i < listCD.size(); i++) {
                        if (text[4].equals(listCD.get(i).getIdCD())) {
                            flak = false;
                        }
                    }
                    if (flak) {
//                    CD obj = new CD(nameCD, typeCD, titleCD, priceCD, idCD, publicYear)); // other way to add object
//                    listCD.add(obj);
                        listCD.add(new CD(nameCD, typeCD, titleCD, priceCD, idCD, publicYear));
                        numOfCD++;
                        checkFileAdd++;
                        System.out.println("read success");
                    }
                }
            } catch (FileNotFoundException e) {
                if (numOfCD == 0) System.out.println("mistake occur, file not exist.");
            } catch (IOException e) {
                System.out.println("mistake occur.");
            }
        }
    }

    public void listReadFile() {
        readFile();
        if (checkFileAdd == 0 && numOfCD == 0) {
            System.out.println("erro");
        } else {
            Collections.sort(listCD, (CD s1, CD s2) -> (s2.getNameCD().charAt(1) - s1.getNameCD().charAt(1)) * -1);
            System.out.println("put CD type to list(game, movie, music): ");
            typeCD = sc.nextLine();
            do {
                switch (typeCD) {
                    case "game":
                        System.out.println("(name, type, title, price, ID, publishing year)");
                        for (int i = 0; i < listCD.size(); i++) {
                            if (listCD.get(i).getTypeCD().matches(typeCD)) {
                                System.out.println(listCD.get(i));
                            }
                        }
                        checkCDT++;
                        break;
                    case "movie":
                        System.out.println("(name, type, title, price, ID, publishing year)");
                        for (int i = 0; i < listCD.size(); i++) {
                            if (listCD.get(i).getTypeCD().matches(typeCD)) {
                                System.out.println(listCD.get(i));
                            }
                        }
                        checkCDT++;
                        break;
                    case "music":
                        System.out.println("(name, type, title, price, ID, publishing year)");
                        for (int i = 0; i < listCD.size(); i++) {
                            if (listCD.get(i).getTypeCD().matches(typeCD)) {
                                System.out.println(listCD.get(i));
                            }
                        }
                        checkCDT++;
                        break;
                    default:
                        break;
                }
            } while (checkCDT == 0);
        }
    }
}
