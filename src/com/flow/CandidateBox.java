package com.flow;

import java.util.HashMap;
import com.candidate.Candidate;
import com.candidate.Experience;
import com.candidate.Fresher;
import com.candidate.Intern;
import com.tools.Tools;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
//key    value

public class CandidateBox extends HashMap<String, Candidate> implements I_CandidateBox {

    @Override
    public boolean addCandidate() {
        Candidate tempCand = null;
        int type = candidateType();
        String id = Tools.getString("Enter candidate id: ", false);
        if (searchCandidate(id) != null) {
            System.out.println("ID has exist!");
            return false;
        }
        switch (type) {
            case 0:
                tempCand = new Experience(type, id);
                break;
            case 1:
                tempCand = new Fresher(type, id);
                break;
            case 2:
                tempCand = new Intern(type, id);
                break;
        }
        if (tempCand.setInformation()) {
            put(id, tempCand);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean deleteCandidate() {
        String id = Tools.getString("Enter candidate id: ", false);
        Candidate tempCand = searchCandidate(id);
        if (tempCand == null) {
            System.out.println("Not found!");
            return false;
        }

        String choice = Tools.getString("Are you sure?(Y/N)", false);
        if (choice.equalsIgnoreCase("n")) {
            System.out.println("Continue!");
        } else {
            remove(id);
        }
        return true;
    }

    @Override
    public boolean updateCandidate() {
        String id = Tools.getString("Enter candidate id: ", false);
        Candidate tempCand = searchCandidate(id);
        if (tempCand == null) {
            System.out.println("Not found!");
            return false;
        }
        tempCand.updateInformation();
        return true;

    }

    @Override
    public Candidate searchCandidate(String id) {
        Candidate tempCan = null;

        if (this.containsKey(id)) {
            tempCan = get(id);
        } 
        return tempCan;
    }

    public int candidateType() {
        int choice;
        System.out.println("Enter candidate type: ");
        System.out.println("0. Experience");
        System.out.println("1. Fresher");
        System.out.println("2. Intern");
        choice = Tools.getInt("Select your choice: ", 0, 2);
        return choice;

    }

    @Override
    public void showCandidate() {
        for (String element : this.keySet()) {
            get(element).showProfile();
        }
    }

    @Override
    public boolean sortCandidate() {
        List<Candidate> list = new ArrayList<>(this.values());
        Collections.sort(list);
        for (Candidate candidate : list) {
            candidate.showProfile();
        }
        return true;
    }
}
