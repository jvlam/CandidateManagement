package com.flow;

import com.candidate.Candidate;

public interface I_CandidateBox {

    public boolean addCandidate();

    public boolean deleteCandidate();

    public boolean updateCandidate();

    public Candidate searchCandidate(String id);

    public void showCandidate();

    public boolean sortCandidate();

}
