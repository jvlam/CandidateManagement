package candidatemanagementv2;

import com.flow.CandidateBox;
import com.flow.Menu;
import com.tools.Tools;
import com.candidate.Candidate;
public class CandidateManageMentV2 {

    public static void main(String[] args) {

        Menu menu = new Menu();
        menu.addItem("1. Add candidate");
        menu.addItem("2. Delete candidate");
        menu.addItem("3. Update candiate");
        menu.addItem("4. Search candidate");
        menu.addItem("5. Show all candidate");
        menu.addItem("6. Sort candidate");
        menu.addItem("7. Quit");
        CandidateBox box = new CandidateBox();
        int choice;
        do {
            menu.showMenu();
            choice = Tools.getInt("Select your choice: ", 1, menu.size());
            switch (choice) {
                case 1:
                    if (box.addCandidate()) {
                        System.out.println("Successful!");
                    } else {
                        System.out.println("Unsuceessful!");
                    }
                    break;
                case 2:
                    if (box.deleteCandidate()) {
                        System.out.println("Successful!");
                    } else {
                        System.out.println("Unsuceessful!");
                    }
                    break;
                case 3:
                    if (box.updateCandidate()) {
                        System.out.println("Successful!");
                    } else {
                        System.out.println("Unsuceessful!");
                    }
                    break;

                case 4:
                    String id = Tools.getString("Enter id to search", false);
                    Candidate temp = box.searchCandidate(id);
                    if(temp != null)
                        temp.showProfile();
                    else
                        System.out.println("Not found!");
                    break;
                case 5:
                    box.showCandidate();
                    break;
                case 6:
                    box.sortCandidate();
                    break;

            }

        } while (choice != 7);
    }

}
